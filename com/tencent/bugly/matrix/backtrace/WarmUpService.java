package com.tencent.bugly.matrix.backtrace;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import com.tencent.bugly.matrix.backtrace.WarmUpUtility;
import com.tencent.bugly.matrix.util.MatrixLog;
import com.tencent.bugly.matrix.xlog.XLogNative;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes5.dex */
public class WarmUpService extends Service {
    static final String ARGS_WARM_UP_ELF_START_OFFSET = "elf-start-offset";
    static final String ARGS_WARM_UP_PATH_OF_ELF = "path-of-elf";
    static final String ARGS_WARM_UP_SAVING_PATH = "saving-path";
    static final String BIND_ARGS_ENABLE_LOGGER = "enable-logger";
    static final String BIND_ARGS_PATH_OF_XLOG_SO = "path-of-xlog-so";
    static final int CMD_WARM_UP_SINGLE_ELF_FILE = 100;
    private static final long INTERVAL_OF_CHECK = 60000;
    public static final int INVALID_ARGUMENT = -1;
    private static final String INVOKE_ARGS = "invoke-args";
    private static final String INVOKE_RESP = "invoke-resp";
    private static final int MSG_SUICIDE = 1;
    static final int OK = 0;
    static final String RESULT_OF_WARM_UP = "warm-up-result";
    private static final String TAG = "Matrix.WarmUpService";
    public static final int WARM_UP_FAILED = -2;
    public static final int WARM_UP_FAILED_TOO_MANY_TIMES = -3;
    private static volatile boolean sHasInitiated = false;
    private static volatile boolean sHasLoaded = false;
    private static HandlerThread sRecycler;
    private static Handler sRecyclerHandler;
    private final Messenger mMessenger = new Messenger(new Handler() { // from class: com.tencent.bugly.matrix.backtrace.WarmUpService.1
        @Override // android.os.Handler
        @SuppressLint({"HandlerLeak"})
        public void handleMessage(Message message) {
            super.handleMessage(message);
            Object obj = message.obj;
            if (obj instanceof Bundle) {
                Bundle bundle = (Bundle) obj;
                Bundle bundle2 = bundle.getBundle(WarmUpService.INVOKE_ARGS);
                IBinder binder = bundle.getBinder(WarmUpService.INVOKE_RESP);
                Bundle call = WarmUpService.this.call(message.what, bundle2);
                try {
                    new Messenger(binder).send(Message.obtain(null, message.what, call));
                } catch (RemoteException e16) {
                    MatrixLog.printErrStackTrace(WarmUpService.TAG, e16, "", new Object[0]);
                }
            }
        }
    });
    private final WarmUpDelegate mWarmUpDelegate = new WarmUpDelegate();
    private static final AtomicInteger sWorkingCall = new AtomicInteger(0);
    private static final byte[] sRecyclerLock = new byte[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class RecyclerCallback implements Handler.Callback {
        RecyclerCallback() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                MatrixLog.i(WarmUpService.TAG, "Suicide.", new Object[0]);
                SystemMethodProxy.killProcess(Process.myPid());
                System.exit(0);
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    interface RemoteConnection {
        boolean connect(Context context, Bundle bundle);

        void disconnect(Context context);

        boolean isConnected();
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    interface RemoteInvoker {
        Bundle call(int i3, Bundle bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class RemoteInvokerImpl implements RemoteInvoker, RemoteConnection {
        private static final String TAG = "Matrix.WarmUpInvoker";
        volatile Messenger mReq;
        volatile Messenger mResp;
        final Bundle[] mResult = {null};
        final HandlerThread[] mHandlerThread = {null};
        ServiceConnection mConnection = new ServiceConnection() { // from class: com.tencent.bugly.matrix.backtrace.WarmUpService.RemoteInvokerImpl.1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                RemoteInvokerImpl.this.mReq = new Messenger(iBinder);
                synchronized (RemoteInvokerImpl.this.mBound) {
                    RemoteInvokerImpl.this.mBound[0] = true;
                    RemoteInvokerImpl.this.mBound.notifyAll();
                }
                MatrixLog.i(RemoteInvokerImpl.TAG, "This remote invoker(%s) connected.", this);
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                RemoteInvokerImpl.this.mReq = null;
                synchronized (RemoteInvokerImpl.this.mBound) {
                    RemoteInvokerImpl.this.mBound[0] = false;
                    RemoteInvokerImpl.this.mBound.notifyAll();
                }
                MatrixLog.i(RemoteInvokerImpl.TAG, "This remote invoker(%s) disconnected.", this);
                synchronized (RemoteInvokerImpl.this.mResult) {
                    Bundle[] bundleArr = RemoteInvokerImpl.this.mResult;
                    bundleArr[0] = null;
                    bundleArr.notifyAll();
                }
            }
        };
        private final boolean[] mBound = {false};

        private void checkThread() {
            if (Looper.getMainLooper() != Looper.myLooper()) {
            } else {
                throw new RuntimeException("Should not call this from main thread!");
            }
        }

        @Override // com.tencent.bugly.matrix.backtrace.WarmUpService.RemoteInvoker
        public Bundle call(int i3, Bundle bundle) {
            Bundle bundle2;
            try {
                Messenger messenger = this.mReq;
                if (messenger != null) {
                    Bundle bundle3 = new Bundle();
                    bundle3.putBundle(WarmUpService.INVOKE_ARGS, bundle);
                    bundle3.putBinder(WarmUpService.INVOKE_RESP, this.mResp.getBinder());
                    messenger.send(Message.obtain(null, i3, bundle3));
                    synchronized (this.mResult) {
                        Bundle[] bundleArr = this.mResult;
                        bundleArr[0] = null;
                        bundleArr.wait(MiniBoxNoticeInfo.MIN_5);
                        bundle2 = this.mResult[0];
                    }
                    return bundle2;
                }
            } catch (RemoteException | InterruptedException e16) {
                MatrixLog.printErrStackTrace(TAG, e16, "", new Object[0]);
            }
            return null;
        }

        @Override // com.tencent.bugly.matrix.backtrace.WarmUpService.RemoteConnection
        public boolean connect(Context context, Bundle bundle) {
            checkThread();
            if (this.mBound[0]) {
                return true;
            }
            MatrixLog.i(TAG, "Start connecting to remote. (%s)", Integer.valueOf(hashCode()));
            synchronized (this.mHandlerThread) {
                HandlerThread handlerThread = this.mHandlerThread[0];
                if (handlerThread != null) {
                    handlerThread.quitSafely();
                    this.mHandlerThread[0] = null;
                }
                this.mHandlerThread[0] = new BaseHandlerThread("warm-up-remote-invoker-" + hashCode());
                this.mHandlerThread[0].start();
                this.mResp = new Messenger(new Handler(this.mHandlerThread[0].getLooper()) { // from class: com.tencent.bugly.matrix.backtrace.WarmUpService.RemoteInvokerImpl.2
                    @Override // android.os.Handler
                    public void handleMessage(Message message) {
                        Object obj = message.obj;
                        if (obj instanceof Bundle) {
                            Bundle bundle2 = (Bundle) obj;
                            synchronized (RemoteInvokerImpl.this.mResult) {
                                Bundle[] bundleArr = RemoteInvokerImpl.this.mResult;
                                bundleArr[0] = bundle2;
                                bundleArr.notifyAll();
                            }
                        }
                    }
                });
            }
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(context, (Class<?>) WarmUpService.class));
            intent.putExtra(WarmUpService.BIND_ARGS_ENABLE_LOGGER, bundle.getBoolean(WarmUpService.BIND_ARGS_ENABLE_LOGGER, false));
            intent.putExtra(WarmUpService.BIND_ARGS_PATH_OF_XLOG_SO, bundle.getString(WarmUpService.BIND_ARGS_PATH_OF_XLOG_SO, null));
            context.bindService(intent, this.mConnection, 1);
            try {
                synchronized (this.mBound) {
                    boolean[] zArr = this.mBound;
                    if (!zArr[0]) {
                        zArr.wait(60000L);
                    }
                }
            } catch (InterruptedException e16) {
                MatrixLog.printErrStackTrace(TAG, e16, "", new Object[0]);
            }
            if (!this.mBound[0]) {
                disconnect(context);
            }
            return this.mBound[0];
        }

        @Override // com.tencent.bugly.matrix.backtrace.WarmUpService.RemoteConnection
        public void disconnect(Context context) {
            try {
                context.unbindService(this.mConnection);
            } catch (Throwable th5) {
                MatrixLog.printErrStackTrace(TAG, th5, "", new Object[0]);
            }
            MatrixLog.i(TAG, "Start disconnecting to remote. (%s)", Integer.valueOf(hashCode()));
            synchronized (this.mHandlerThread) {
                HandlerThread handlerThread = this.mHandlerThread[0];
                if (handlerThread != null) {
                    handlerThread.quitSafely();
                    this.mHandlerThread[0] = null;
                }
            }
            synchronized (this.mResult) {
                Bundle[] bundleArr = this.mResult;
                bundleArr[0] = null;
                bundleArr.notifyAll();
            }
        }

        @Override // com.tencent.bugly.matrix.backtrace.WarmUpService.RemoteConnection
        public boolean isConnected() {
            return this.mBound[0];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized Bundle call(int i3, Bundle bundle) {
        int i16;
        removeScheduledSuicide();
        try {
            Bundle bundle2 = new Bundle();
            bundle2.putInt(RESULT_OF_WARM_UP, -1);
            if (bundle == null) {
                MatrixLog.i(TAG, "Args is null.", new Object[0]);
                return bundle2;
            }
            String string = bundle.getString(ARGS_WARM_UP_SAVING_PATH, null);
            MatrixLog.i(TAG, "Invoke from client with savingPath: %s.", string);
            if (isNullOrNil(string)) {
                MatrixLog.i(TAG, "Saving path is empty.", new Object[0]);
                return bundle2;
            }
            this.mWarmUpDelegate.setSavingPath(string);
            if (i3 == 100) {
                String string2 = bundle.getString(ARGS_WARM_UP_PATH_OF_ELF, null);
                if (isNullOrNil(string2)) {
                    MatrixLog.i(TAG, "Warm-up so path is empty.", new Object[0]);
                    return bundle2;
                }
                int i17 = bundle.getInt(ARGS_WARM_UP_ELF_START_OFFSET, 0);
                MatrixLog.i(TAG, "Warm up so path %s offset %s.", string2, Integer.valueOf(i17));
                if (!WarmUpUtility.UnfinishedManagement.checkAndMark(this, string2, i17)) {
                    i16 = -3;
                } else {
                    boolean internalWarmUpSoPath = WarmUpDelegate.internalWarmUpSoPath(string2, i17, true);
                    if (!WeChatBacktraceNative.testLoadQut(string2, i17)) {
                        MatrixLog.w(TAG, "Warm up elf %s:%s success, but test load qut failed!", string2, Integer.valueOf(i17));
                        internalWarmUpSoPath = false;
                    }
                    WarmUpUtility.UnfinishedManagement.result(this, string2, i17, internalWarmUpSoPath);
                    if (internalWarmUpSoPath) {
                        i16 = 0;
                    } else {
                        i16 = -2;
                    }
                }
                bundle2.putInt(RESULT_OF_WARM_UP, i16);
            } else {
                MatrixLog.w(TAG, "Unknown cmd: %s", Integer.valueOf(i3));
            }
            return bundle2;
        } finally {
            scheduleSuicide(false);
        }
    }

    private static synchronized void init() {
        synchronized (WarmUpService.class) {
            if (sHasInitiated) {
                return;
            }
            synchronized (sRecyclerLock) {
                if (sRecycler == null) {
                    BaseHandlerThread baseHandlerThread = new BaseHandlerThread("backtrace-recycler");
                    sRecycler = baseHandlerThread;
                    baseHandlerThread.start();
                    sRecyclerHandler = new Handler(sRecycler.getLooper(), new RecyclerCallback());
                }
            }
            scheduleSuicide(true);
            sHasInitiated = true;
        }
    }

    private boolean isNullOrNil(String str) {
        if (str != null && !str.isEmpty()) {
            return false;
        }
        return true;
    }

    private static synchronized void loadLibrary(Intent intent) {
        synchronized (WarmUpService.class) {
            if (sHasLoaded) {
                return;
            }
            MatrixLog.i(TAG, "Init called.", new Object[0]);
            WeChatBacktrace.loadLibrary();
            boolean booleanExtra = intent.getBooleanExtra(BIND_ARGS_ENABLE_LOGGER, false);
            String stringExtra = intent.getStringExtra(BIND_ARGS_PATH_OF_XLOG_SO);
            MatrixLog.i(TAG, "Enable logger: %s", Boolean.valueOf(booleanExtra));
            MatrixLog.i(TAG, "Path of XLog: %s", stringExtra);
            XLogNative.setXLogger(stringExtra);
            WeChatBacktrace.enableLogger(booleanExtra);
            sHasLoaded = true;
        }
    }

    private void removeScheduledSuicide() {
        MatrixLog.i(TAG, "Remove scheduled suicide", new Object[0]);
        synchronized (sRecyclerLock) {
            sRecyclerHandler.removeMessages(1);
            sWorkingCall.getAndIncrement();
        }
    }

    private static void scheduleSuicide(boolean z16) {
        MatrixLog.i(TAG, "Schedule suicide", new Object[0]);
        synchronized (sRecyclerLock) {
            if (z16) {
                sRecyclerHandler.sendEmptyMessageDelayed(1, 60000L);
            } else if (sWorkingCall.decrementAndGet() == 0) {
                sRecyclerHandler.sendEmptyMessageDelayed(1, 60000L);
            }
        }
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        if (!sHasLoaded) {
            loadLibrary(intent);
        }
        return this.mMessenger.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (!sHasInitiated) {
            init();
        }
    }
}
