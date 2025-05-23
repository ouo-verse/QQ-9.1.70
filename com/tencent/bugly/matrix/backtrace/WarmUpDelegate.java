package com.tencent.bugly.matrix.backtrace;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.OperationCanceledException;
import android.os.Process;
import android.system.ErrnoException;
import android.system.Os;
import android.system.StructStat;
import android.util.Pair;
import com.tencent.bugly.common.utils.AndroidVersion;
import com.tencent.bugly.matrix.backtrace.WarmUpReporter;
import com.tencent.bugly.matrix.backtrace.WarmUpScheduler;
import com.tencent.bugly.matrix.backtrace.WarmUpService;
import com.tencent.bugly.matrix.backtrace.WarmUpUtility;
import com.tencent.bugly.matrix.backtrace.WeChatBacktrace;
import com.tencent.bugly.matrix.util.MatrixLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import cooperation.qzone.patch.QZonePatchService;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.CancellationException;

/* compiled from: P */
/* loaded from: classes5.dex */
class WarmUpDelegate {
    private static final String ACTION_WARMED_UP = "action.backtrace.warmed-up";
    private static final String PERMISSION_WARMED_UP = ".backtrace.warmed_up";
    private static final String TAG = "Matrix.WarmUpDelegate";
    private static final String TASK_TAG_CLEAN_UP = "clean-up";
    private static final String TASK_TAG_COMPUTE_DISK_USAGE = "compute-disk-usage";
    private static final String TASK_TAG_CONSUMING_UP = "consuming-up";
    private static final String TASK_TAG_WARM_UP = "warm-up";
    static volatile WarmUpReporter sReporter;
    private WeChatBacktrace.Configuration mConfiguration;
    private boolean mIsolateRemote = false;
    private final boolean[] mPrepared = {false};
    String mSavingPath;
    private ThreadTaskExecutor mThreadTaskExecutor;
    private WarmUpScheduler mWarmUpScheduler;
    private WarmedUpReceiver mWarmedUpReceiver;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class LocalWarmUpInvoker implements WarmUpInvoker {
        LocalWarmUpInvoker() {
        }

        @Override // com.tencent.bugly.matrix.backtrace.WarmUpInvoker
        public boolean warmUp(String str, int i3) {
            return WarmUpDelegate.internalWarmUpSoPath(str, i3, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class RemoteWarmUpInvoker implements WarmUpInvoker, WarmUpService.RemoteConnection {
        private Bundle mArgs;
        private Context mContext;
        WarmUpService.RemoteInvokerImpl mImpl = new WarmUpService.RemoteInvokerImpl();
        private final String mSavingPath;

        RemoteWarmUpInvoker(String str) {
            this.mSavingPath = str;
        }

        @Override // com.tencent.bugly.matrix.backtrace.WarmUpService.RemoteConnection
        public boolean connect(Context context, Bundle bundle) {
            this.mContext = context;
            this.mArgs = bundle;
            return this.mImpl.connect(context, bundle);
        }

        @Override // com.tencent.bugly.matrix.backtrace.WarmUpService.RemoteConnection
        public void disconnect(Context context) {
            this.mImpl.disconnect(context);
        }

        @Override // com.tencent.bugly.matrix.backtrace.WarmUpService.RemoteConnection
        public boolean isConnected() {
            return this.mImpl.isConnected();
        }

        @Override // com.tencent.bugly.matrix.backtrace.WarmUpInvoker
        public boolean warmUp(String str, int i3) {
            int i16;
            boolean z16;
            if (!isConnected() && !connect(this.mContext, this.mArgs)) {
                return false;
            }
            Bundle bundle = new Bundle();
            bundle.putString("saving-path", this.mSavingPath);
            bundle.putString("path-of-elf", str);
            bundle.putInt("elf-start-offset", i3);
            Bundle call = this.mImpl.call(100, bundle);
            if (call != null) {
                i16 = call.getInt("warm-up-result");
            } else {
                i16 = -100;
            }
            if (i16 == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                WeChatBacktraceNative.notifyWarmedUp(str, i3);
            }
            MatrixLog.i(WarmUpDelegate.TAG, "Warm-up %s:%s - retCode %s", str, Integer.valueOf(i3), Integer.valueOf(i16));
            return z16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    static final class ThreadTaskExecutor implements Runnable, Handler.Callback {
        private static final long BLOCKED_CHECK_INTERVAL = 300000;
        private static final int MSG_BLOCKED_CHECK = 1;
        private Thread mThreadExecutor;
        private String mThreadName;
        private HashMap<String, Runnable> mRunnableTasks = new HashMap<>();
        private Queue<String> mTaskQueue = new LinkedList();
        private Handler mBlockedChecker = new Handler(Looper.getMainLooper(), this);
        private boolean mThreadBlocked = false;
        long[] mTaskStartTS = {0};

        ThreadTaskExecutor(String str) {
            this.mThreadName = str;
        }

        void arrangeTask(Runnable runnable, String str) {
            synchronized (this.mTaskQueue) {
                if (this.mTaskQueue.contains(str)) {
                    return;
                }
                this.mTaskQueue.add(str);
                this.mRunnableTasks.put(str, runnable);
                synchronized (this) {
                    Thread thread = this.mThreadExecutor;
                    if (thread == null || !thread.isAlive()) {
                        BaseThread baseThread = new BaseThread(this, this.mThreadName);
                        this.mThreadExecutor = baseThread;
                        baseThread.start();
                        this.mBlockedChecker.removeMessages(1);
                        this.mBlockedChecker.sendEmptyMessageDelayed(1, 300000L);
                    }
                }
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                synchronized (this.mTaskStartTS) {
                    if (this.mTaskStartTS[0] == 0) {
                        return false;
                    }
                    this.mThreadBlocked = true;
                    WarmUpReporter warmUpReporter = WarmUpDelegate.sReporter;
                    if (warmUpReporter != null) {
                        warmUpReporter.onReport(WarmUpReporter.ReportEvent.WarmUpThreadBlocked, new Object[0]);
                    }
                }
            }
            return false;
        }

        boolean isThreadBlocked() {
            return this.mThreadBlocked;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.mThreadBlocked = false;
            synchronized (this.mTaskStartTS) {
                this.mTaskStartTS[0] = System.currentTimeMillis();
            }
            Runnable runnable = null;
            String str = null;
            while (true) {
                if (runnable != null) {
                    try {
                        long currentTimeMillis = System.currentTimeMillis();
                        MatrixLog.i(WarmUpDelegate.TAG, "Before '%s' task execution..", str);
                        runnable.run();
                        MatrixLog.i(WarmUpDelegate.TAG, "After '%s' task execution..", str);
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        WarmUpReporter warmUpReporter = WarmUpDelegate.sReporter;
                        if (warmUpReporter != null) {
                            if (WarmUpDelegate.TASK_TAG_WARM_UP.equalsIgnoreCase(str)) {
                                warmUpReporter.onReport(WarmUpReporter.ReportEvent.WarmUpDuration, Long.valueOf(currentTimeMillis2));
                            } else if (WarmUpDelegate.TASK_TAG_CONSUMING_UP.equalsIgnoreCase(str)) {
                                warmUpReporter.onReport(WarmUpReporter.ReportEvent.ConsumeRequestDuration, Long.valueOf(currentTimeMillis2));
                            }
                        }
                    } catch (Throwable th5) {
                        synchronized (this.mTaskStartTS) {
                            this.mTaskStartTS[0] = 0;
                            this.mBlockedChecker.removeMessages(1);
                            throw th5;
                        }
                    }
                }
                synchronized (this.mTaskQueue) {
                    str = this.mTaskQueue.poll();
                    if (str == null) {
                        synchronized (this.mTaskStartTS) {
                            this.mTaskStartTS[0] = 0;
                        }
                        this.mBlockedChecker.removeMessages(1);
                        return;
                    }
                    Runnable remove = this.mRunnableTasks.remove(str);
                    if (remove == null) {
                        synchronized (this.mTaskStartTS) {
                            this.mTaskStartTS[0] = 0;
                        }
                        this.mBlockedChecker.removeMessages(1);
                        return;
                    }
                    runnable = remove;
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    private static final class WarmedUpReceiver extends BroadcastReceiver {
        private WeChatBacktrace.Mode mCurrentBacktraceMode;

        WarmedUpReceiver(WeChatBacktrace.Mode mode) {
            this.mCurrentBacktraceMode = mode;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            MatrixLog.i(WarmUpDelegate.TAG, "Warm-up received.", new Object[0]);
            String action = intent.getAction();
            if (action != null && action.equals(WarmUpDelegate.ACTION_WARMED_UP)) {
                WeChatBacktraceNative.setWarmedUp(true);
                WarmUpDelegate.updateBacktraceMode(this.mCurrentBacktraceMode);
                try {
                    context.unregisterReceiver(this);
                } catch (Throwable th5) {
                    MatrixLog.printErrStackTrace(WarmUpDelegate.TAG, th5, "Unregister receiver twice.", new Object[0]);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WarmUpInvoker acquireWarmUpInvoker() {
        if (this.mIsolateRemote) {
            RemoteWarmUpInvoker remoteWarmUpInvoker = new RemoteWarmUpInvoker(this.mSavingPath);
            Bundle bundle = new Bundle();
            bundle.putBoolean("enable-logger", this.mConfiguration.mEnableIsolateProcessLog);
            bundle.putString("path-of-xlog-so", this.mConfiguration.mPathOfXLogSo);
            if (!remoteWarmUpInvoker.connect(this.mConfiguration.mContext, bundle)) {
                return null;
            }
            return remoteWarmUpInvoker;
        }
        return new LocalWarmUpInvoker();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void broadcastWarmedUp(Context context) {
        try {
            File warmUpMarkedFile = WarmUpUtility.warmUpMarkedFile(context);
            warmUpMarkedFile.createNewFile();
            WarmUpUtility.writeContentToFile(warmUpMarkedFile, context.getApplicationInfo().nativeLibraryDir);
        } catch (IOException e16) {
            MatrixLog.printErrStackTrace(TAG, e16, "", new Object[0]);
        }
        WeChatBacktraceNative.setWarmedUp(true);
        updateBacktraceMode(this.mConfiguration.mBacktraceMode);
        MatrixLog.i(TAG, "Broadcast warmed up message to other processes.", new Object[0]);
        Intent intent = new Intent(ACTION_WARMED_UP);
        intent.putExtra("pid", Process.myPid());
        context.sendBroadcast(intent, context.getPackageName() + PERMISSION_WARMED_UP);
        WarmUpReporter warmUpReporter = sReporter;
        if (warmUpReporter != null) {
            warmUpReporter.onReport(WarmUpReporter.ReportEvent.WarmedUp, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean internalWarmUpSoPath(String str, int i3, boolean z16) {
        return WeChatBacktraceNative.warmUp(str, i3, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseWarmUpInvoker(WarmUpInvoker warmUpInvoker) {
        if (this.mIsolateRemote) {
            ((RemoteWarmUpInvoker) warmUpInvoker).disconnect(this.mConfiguration.mContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void updateBacktraceMode(WeChatBacktrace.Mode mode) {
        if (mode == WeChatBacktrace.Mode.FpUntilQuickenWarmedUp || mode == WeChatBacktrace.Mode.DwarfUntilQuickenWarmedUp) {
            WeChatBacktraceNative.setBacktraceMode(WeChatBacktrace.Mode.Quicken.value);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean warmUpBlocked(String str, int i3) {
        boolean z16 = !WarmUpUtility.UnfinishedManagement.check(this.mConfiguration.mContext, str, i3);
        if (z16) {
            MatrixLog.w(TAG, "Elf file %s:%s has blocked and will not do warm-up.", str, Integer.valueOf(i3));
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void warmUpFailed(String str, int i3) {
        WarmUpReporter warmUpReporter = sReporter;
        if (warmUpReporter != null) {
            warmUpReporter.onReport(WarmUpReporter.ReportEvent.WarmUpFailed, str, Integer.valueOf(i3));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cleaningUp(final CancellationSignal cancellationSignal) {
        this.mThreadTaskExecutor.arrangeTask(new Runnable() { // from class: com.tencent.bugly.matrix.backtrace.WarmUpDelegate.2
            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                File file = new File(WarmUpUtility.validateSavingPath(WarmUpDelegate.this.mConfiguration));
                MatrixLog.i(WarmUpDelegate.TAG, "Going to clean up saving path(%s)..", file.getAbsoluteFile());
                if (!file.isDirectory()) {
                    WarmUpDelegate.this.mWarmUpScheduler.taskFinished(WarmUpScheduler.TaskType.CleanUp);
                    return;
                }
                final HashMap hashMap = new HashMap();
                try {
                    WarmUpUtility.iterateTargetDirectory(file, cancellationSignal, new FileFilter() { // from class: com.tencent.bugly.matrix.backtrace.WarmUpDelegate.2.1
                        @Override // java.io.FileFilter
                        public boolean accept(File file2) {
                            String name;
                            String absolutePath;
                            try {
                                name = file2.getName();
                                absolutePath = file2.getAbsolutePath();
                            } catch (Throwable th5) {
                                MatrixLog.printErrStackTrace(WarmUpDelegate.TAG, th5, "", new Object[0]);
                            }
                            if (!name.contains("_malformed_") && !name.contains("_temp_")) {
                                StructStat lstat = Os.lstat(absolutePath);
                                long max = Math.max(lstat.st_atime, lstat.st_mtime) * 1000;
                                MatrixLog.i(WarmUpDelegate.TAG, "File(%s) last access time %s", absolutePath, Long.valueOf(max));
                                if (System.currentTimeMillis() - max > 259200000) {
                                    file2.delete();
                                    MatrixLog.i(WarmUpDelegate.TAG, "Delete long time no access file(%s)", absolutePath);
                                } else if (max >= System.currentTimeMillis()) {
                                    if (max - System.currentTimeMillis() >= 604800000) {
                                        file2.delete();
                                        MatrixLog.i(WarmUpDelegate.TAG, "Delete future file(%s)", absolutePath);
                                    }
                                } else {
                                    int lastIndexOf = name.lastIndexOf(46);
                                    if (lastIndexOf == -1) {
                                        return false;
                                    }
                                    String substring = name.substring(0, lastIndexOf);
                                    if (name.endsWith(".hash")) {
                                        return false;
                                    }
                                    Pair pair = (Pair) hashMap.get(substring);
                                    if (pair != null) {
                                        if (max > ((Long) pair.second).longValue()) {
                                            if (System.currentTimeMillis() - ((Long) pair.second).longValue() >= 172800000) {
                                                ((File) pair.first).delete();
                                                MatrixLog.i(WarmUpDelegate.TAG, "Delete file(%s) cause %s is newer(%s vs %s).", ((File) pair.first).getName(), name, pair.second, Long.valueOf(max));
                                            }
                                            hashMap.put(substring, new Pair(file2, Long.valueOf(max)));
                                        } else if (System.currentTimeMillis() - max >= 172800000) {
                                            file2.delete();
                                            MatrixLog.i(WarmUpDelegate.TAG, "Delete file(%s) cause %s is newer(%s vs %s).", name, ((File) pair.first).getName(), Long.valueOf(max), pair.second);
                                        }
                                    } else {
                                        hashMap.put(substring, new Pair(file2, Long.valueOf(max)));
                                    }
                                }
                                return false;
                            }
                            if (System.currentTimeMillis() - file2.lastModified() >= 172800000) {
                                MatrixLog.i(WarmUpDelegate.TAG, "Delete malformed and temp file %s", absolutePath);
                                file2.delete();
                            }
                            return false;
                        }
                    });
                } catch (OperationCanceledException unused) {
                    z16 = true;
                } catch (Throwable th5) {
                    MatrixLog.printErrStackTrace(WarmUpDelegate.TAG, th5, "", new Object[0]);
                }
                z16 = false;
                if (!z16) {
                    WarmUpUtility.markCleanUpTimestamp(WarmUpDelegate.this.mConfiguration.mContext);
                    WarmUpDelegate.this.mWarmUpScheduler.taskFinished(WarmUpScheduler.TaskType.CleanUp);
                    MatrixLog.i(WarmUpDelegate.TAG, "Clean up saving path(%s) done.", file.getAbsoluteFile());
                    WarmUpReporter warmUpReporter = WarmUpDelegate.sReporter;
                    if (warmUpReporter != null) {
                        warmUpReporter.onReport(WarmUpReporter.ReportEvent.CleanedUp, new Object[0]);
                        return;
                    }
                    return;
                }
                MatrixLog.i(WarmUpDelegate.TAG, "Clean up saving path(%s) cancelled.", file.getAbsoluteFile());
            }
        }, TASK_TAG_CLEAN_UP);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void computeDiskUsage(final CancellationSignal cancellationSignal) {
        this.mThreadTaskExecutor.arrangeTask(new Runnable() { // from class: com.tencent.bugly.matrix.backtrace.WarmUpDelegate.4
            @Override // java.lang.Runnable
            public void run() {
                File file = new File(WarmUpDelegate.this.mSavingPath);
                if (!file.isDirectory()) {
                    WarmUpDelegate.this.mWarmUpScheduler.taskFinished(WarmUpScheduler.TaskType.DiskUsage);
                    return;
                }
                final long[] jArr = new long[2];
                try {
                    WarmUpUtility.iterateTargetDirectory(file, cancellationSignal, new FileFilter() { // from class: com.tencent.bugly.matrix.backtrace.WarmUpDelegate.4.1
                        @Override // java.io.FileFilter
                        public boolean accept(File file2) {
                            try {
                                StructStat lstat = Os.lstat(file2.getAbsolutePath());
                                long[] jArr2 = jArr;
                                jArr2[0] = jArr2[0] + 1;
                                long j3 = jArr2[1];
                                long j16 = lstat.st_blocks;
                                long j17 = lstat.st_blksize;
                                Long.signum(j16);
                                jArr2[1] = j3 + (j16 * j17);
                            } catch (ErrnoException e16) {
                                MatrixLog.printErrStackTrace(WarmUpDelegate.TAG, e16, "", new Object[0]);
                            }
                            return false;
                        }
                    });
                    WarmUpDelegate.this.mWarmUpScheduler.taskFinished(WarmUpScheduler.TaskType.DiskUsage);
                    WarmUpUtility.markComputeDiskUsageTimestamp(WarmUpDelegate.this.mConfiguration.mContext);
                    MatrixLog.i(WarmUpDelegate.TAG, "Compute disk usage, file count(%s), disk usage(%s)", Long.valueOf(jArr[0]), Long.valueOf(jArr[1]));
                    WarmUpReporter warmUpReporter = WarmUpDelegate.sReporter;
                    if (warmUpReporter != null) {
                        warmUpReporter.onReport(WarmUpReporter.ReportEvent.DiskUsage, Long.valueOf(jArr[0]), Long.valueOf(jArr[1]));
                    }
                } catch (OperationCanceledException | CancellationException unused) {
                    WarmUpDelegate.this.mWarmUpScheduler.taskFinished(WarmUpScheduler.TaskType.DiskUsage);
                    WarmUpUtility.markComputeDiskUsageTimestamp(WarmUpDelegate.this.mConfiguration.mContext);
                    MatrixLog.i(WarmUpDelegate.TAG, "Compute disk usage, file count(%s), disk usage(%s)", Long.valueOf(jArr[0]), Long.valueOf(jArr[1]));
                } catch (Throwable th5) {
                    WarmUpDelegate.this.mWarmUpScheduler.taskFinished(WarmUpScheduler.TaskType.DiskUsage);
                    WarmUpUtility.markComputeDiskUsageTimestamp(WarmUpDelegate.this.mConfiguration.mContext);
                    MatrixLog.i(WarmUpDelegate.TAG, "Compute disk usage, file count(%s), disk usage(%s)", Long.valueOf(jArr[0]), Long.valueOf(jArr[1]));
                    throw th5;
                }
            }
        }, TASK_TAG_COMPUTE_DISK_USAGE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void consumingRequestedQut(final CancellationSignal cancellationSignal) {
        this.mThreadTaskExecutor.arrangeTask(new Runnable() { // from class: com.tencent.bugly.matrix.backtrace.WarmUpDelegate.3
            /* JADX WARN: Removed duplicated region for block: B:15:0x005b A[Catch: all -> 0x00a9, TryCatch #0 {all -> 0x00a9, blocks: (B:7:0x002c, B:9:0x0030, B:13:0x0053, B:15:0x005b, B:17:0x0061, B:18:0x0068, B:20:0x007e, B:23:0x0084, B:29:0x008d, B:24:0x0090), top: B:6:0x002c }] */
            /* JADX WARN: Removed duplicated region for block: B:31:0x0067  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                String str;
                int i3;
                boolean z16;
                CancellationSignal cancellationSignal2;
                MatrixLog.i(WarmUpDelegate.TAG, "Going to consume requested QUT.", new Object[0]);
                String[] consumeRequestedQut = WeChatBacktraceNative.consumeRequestedQut();
                WarmUpInvoker acquireWarmUpInvoker = WarmUpDelegate.this.acquireWarmUpInvoker();
                if (acquireWarmUpInvoker == null) {
                    WarmUpDelegate.this.mWarmUpScheduler.taskFinished(WarmUpScheduler.TaskType.RequestConsuming);
                    MatrixLog.w(WarmUpDelegate.TAG, "Failed to acquire warm-up invoker.", new Object[0]);
                    return;
                }
                try {
                    int length = consumeRequestedQut.length;
                    int i16 = 0;
                    while (true) {
                        if (i16 >= length) {
                            break;
                        }
                        String str2 = consumeRequestedQut[i16];
                        int lastIndexOf = str2.lastIndexOf(58);
                        if (lastIndexOf != -1) {
                            try {
                                str = str2.substring(0, lastIndexOf);
                                try {
                                    i3 = Integer.valueOf(str2.substring(lastIndexOf + 1)).intValue();
                                } catch (Throwable unused) {
                                    i3 = 0;
                                    if (WarmUpDelegate.this.warmUpBlocked(str, i3)) {
                                    }
                                    MatrixLog.i(WarmUpDelegate.TAG, "Consumed requested QUT -> %s, ret = %s.", str2, Boolean.valueOf(z16));
                                    cancellationSignal2 = cancellationSignal;
                                    if (cancellationSignal2 == null) {
                                    }
                                    i16++;
                                }
                            } catch (Throwable unused2) {
                                str = str2;
                            }
                        } else {
                            i3 = 0;
                            str = str2;
                        }
                        if (WarmUpDelegate.this.warmUpBlocked(str, i3)) {
                            z16 = acquireWarmUpInvoker.warmUp(str, i3);
                            if (!z16) {
                                WarmUpDelegate.this.warmUpFailed(str, i3);
                            }
                        } else {
                            z16 = false;
                        }
                        MatrixLog.i(WarmUpDelegate.TAG, "Consumed requested QUT -> %s, ret = %s.", str2, Boolean.valueOf(z16));
                        cancellationSignal2 = cancellationSignal;
                        if (cancellationSignal2 == null && cancellationSignal2.isCanceled()) {
                            MatrixLog.i(WarmUpDelegate.TAG, "Consume requested QUT canceled.", new Object[0]);
                            break;
                        }
                        i16++;
                    }
                    MatrixLog.i(WarmUpDelegate.TAG, "Consume requested QUT done.", new Object[0]);
                } finally {
                    WarmUpDelegate.this.releaseWarmUpInvoker(acquireWarmUpInvoker);
                    WarmUpDelegate.this.mWarmUpScheduler.taskFinished(WarmUpScheduler.TaskType.RequestConsuming);
                }
            }
        }, TASK_TAG_CONSUMING_UP);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isBacktraceThreadBlocked() {
        ThreadTaskExecutor threadTaskExecutor = this.mThreadTaskExecutor;
        if (threadTaskExecutor != null) {
            return threadTaskExecutor.isThreadBlocked();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void prepare(WeChatBacktrace.Configuration configuration) {
        synchronized (this.mPrepared) {
            boolean[] zArr = this.mPrepared;
            if (zArr[0]) {
                return;
            }
            zArr[0] = true;
            this.mConfiguration = configuration;
            this.mIsolateRemote = configuration.mWarmUpInIsolateProcess;
            this.mThreadTaskExecutor = new ThreadTaskExecutor("WeChatBacktraceTask");
            this.mWarmUpScheduler = new WarmUpScheduler(this, configuration.mContext, configuration.mWarmUpTiming, configuration.mWarmUpDelay);
            if (configuration.mIsWarmUpProcess) {
                Context context = configuration.mContext;
                if (!WarmUpUtility.hasWarmedUp(context)) {
                    MatrixLog.i(TAG, "Has not been warmed up", new Object[0]);
                    this.mWarmUpScheduler.scheduleTask(WarmUpScheduler.TaskType.WarmUp);
                }
                if (WarmUpUtility.needCleanUp(context)) {
                    MatrixLog.i(TAG, "Need clean up", new Object[0]);
                    this.mWarmUpScheduler.scheduleTask(WarmUpScheduler.TaskType.CleanUp);
                }
                if (WarmUpUtility.shouldComputeDiskUsage(context)) {
                    MatrixLog.i(TAG, "Should schedule disk usage task.", new Object[0]);
                    this.mWarmUpScheduler.scheduleTask(WarmUpScheduler.TaskType.DiskUsage);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void registerWarmedUpReceiver(WeChatBacktrace.Configuration configuration, WeChatBacktrace.Mode mode) {
        if (WarmUpUtility.hasWarmedUp(configuration.mContext)) {
            return;
        }
        if (this.mWarmedUpReceiver == null) {
            this.mWarmedUpReceiver = new WarmedUpReceiver(mode);
            MatrixLog.i(TAG, "Register warm-up receiver.", new Object[0]);
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(ACTION_WARMED_UP);
                if (AndroidVersion.isOver34()) {
                    int i3 = Context.class.getDeclaredField("RECEIVER_NOT_EXPORTED").getInt(null);
                    configuration.mContext.registerReceiver(this.mWarmedUpReceiver, intentFilter, configuration.mContext.getPackageName() + PERMISSION_WARMED_UP, null, i3);
                } else {
                    configuration.mContext.registerReceiver(this.mWarmedUpReceiver, intentFilter, configuration.mContext.getPackageName() + PERMISSION_WARMED_UP, null);
                }
            } catch (Throwable th5) {
                MatrixLog.i(TAG, "failed to register warmed up receiver." + th5.toString(), new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void requestConsuming() {
        if (!WarmUpUtility.hasWarmedUp(this.mConfiguration.mContext)) {
            return;
        }
        this.mWarmUpScheduler.scheduleTask(WarmUpScheduler.TaskType.RequestConsuming);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSavingPath(String str) {
        this.mSavingPath = str;
        WeChatBacktraceNative.setSavingPath(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void warmingUp(final CancellationSignal cancellationSignal) {
        this.mThreadTaskExecutor.arrangeTask(new Runnable() { // from class: com.tencent.bugly.matrix.backtrace.WarmUpDelegate.1
            /* JADX WARN: Code restructure failed: missing block: B:33:0x007f, code lost:
            
                if (0 == 0) goto L22;
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                boolean z16;
                MatrixLog.i(WarmUpDelegate.TAG, "Going to warm up.", new Object[0]);
                final WarmUpInvoker warmUpInvoker = null;
                try {
                } catch (OperationCanceledException unused) {
                    if (0 != 0) {
                        WarmUpDelegate.this.releaseWarmUpInvoker(null);
                    }
                    z16 = true;
                } catch (Throwable th5) {
                    try {
                        MatrixLog.printErrStackTrace(WarmUpDelegate.TAG, th5, "", new Object[0]);
                    } finally {
                        if (0 != 0) {
                            WarmUpDelegate.this.releaseWarmUpInvoker(null);
                        }
                    }
                }
                if (new File(WarmUpUtility.validateSavingPath(WarmUpDelegate.this.mConfiguration)).isDirectory()) {
                    warmUpInvoker = WarmUpDelegate.this.acquireWarmUpInvoker();
                    if (warmUpInvoker == null) {
                        MatrixLog.w(WarmUpDelegate.TAG, "Failed to acquire warm-up invoker", new Object[0]);
                        if (warmUpInvoker != null) {
                            return;
                        } else {
                            return;
                        }
                    }
                    Iterator<String> it = WarmUpDelegate.this.mConfiguration.mWarmUpDirectoriesList.iterator();
                    while (it.hasNext()) {
                        WarmUpUtility.iterateTargetDirectory(new File(it.next()), cancellationSignal, new FileFilter() { // from class: com.tencent.bugly.matrix.backtrace.WarmUpDelegate.1.1
                            @Override // java.io.FileFilter
                            public boolean accept(File file) {
                                String absolutePath = file.getAbsolutePath();
                                if (file.exists() && !WarmUpDelegate.this.warmUpBlocked(absolutePath, 0) && (absolutePath.endsWith(".so") || absolutePath.endsWith(".odex") || absolutePath.endsWith(".oat") || absolutePath.endsWith(QZonePatchService.PATCH_SUFFIX_DEX))) {
                                    MatrixLog.i(WarmUpDelegate.TAG, "Warming up so %s", absolutePath);
                                    if (!warmUpInvoker.warmUp(absolutePath, 0)) {
                                        WarmUpDelegate.this.warmUpFailed(absolutePath, 0);
                                    }
                                }
                                return false;
                            }
                        });
                    }
                    WarmUpDelegate.this.releaseWarmUpInvoker(warmUpInvoker);
                    z16 = false;
                    if (!z16) {
                        WarmUpDelegate.this.mWarmUpScheduler.taskFinished(WarmUpScheduler.TaskType.WarmUp);
                        WarmUpDelegate warmUpDelegate = WarmUpDelegate.this;
                        warmUpDelegate.broadcastWarmedUp(warmUpDelegate.mConfiguration.mContext);
                        MatrixLog.i(WarmUpDelegate.TAG, "Warm-up done.", new Object[0]);
                        return;
                    }
                    MatrixLog.i(WarmUpDelegate.TAG, "Warm-up cancelled.", new Object[0]);
                    return;
                }
                MatrixLog.w(WarmUpDelegate.TAG, "Saving path is not a directory.", new Object[0]);
                WarmUpDelegate.this.mWarmUpScheduler.taskFinished(WarmUpScheduler.TaskType.WarmUp);
            }
        }, TASK_TAG_WARM_UP);
    }
}
