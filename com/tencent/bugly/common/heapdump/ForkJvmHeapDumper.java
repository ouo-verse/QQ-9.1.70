package com.tencent.bugly.common.heapdump;

import android.util.Log;
import com.tencent.bugly.common.privacy.PrivacyInformation;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.rmonitor.base.thread.suspend.a;
import com.tencent.rmonitor.common.logger.Logger;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ForkJvmHeapDumper extends StripHeapDumper {
    private static final long HEAP_DUMP_MAX_WAIT_TIME = 60000;
    public static final String TAG = "RMonitor_ForkDumper";
    private static boolean isSymbolResolved = false;
    private static ArrayList<IForkJvmDumperListener> forkJvmDumperListeners = new ArrayList<>();
    private static final Object forkJvmDumperListenerLock = new Object();

    public ForkJvmHeapDumper() {
        if (DumpEnableChecker.isForkDumpVersionPermitted() && StripHeapDumper.isSoLoaded && !isSymbolResolved) {
            isSymbolResolved = nInitForkDump(PrivacyInformation.getInstance().getAndroidFrameworkVersion());
        }
    }

    private int doForkDump(String str, @NotNull HeapDumpConfig heapDumpConfig) {
        int i3;
        notifyForkJvmDumperListener(true);
        final int nSuspendVM = nSuspendVM(a.a(Thread.currentThread()), str, heapDumpConfig.getStripConfig());
        if (nSuspendVM != 0) {
            notifyForkJvmDumperListener(false);
            nResumeVM(a.a(Thread.currentThread()));
            Log.i(TAG, "main process waiting dump result.");
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            Runnable runnable = new Runnable() { // from class: com.tencent.bugly.common.heapdump.ForkJvmHeapDumper.1
                @Override // java.lang.Runnable
                public void run() {
                    Log.i(ForkJvmHeapDumper.TAG, "wait sub process dump timeout.");
                    atomicBoolean.set(true);
                    SystemMethodProxy.killProcess(nSuspendVM);
                }
            };
            getMonitorHandler().postDelayed(runnable, 60000L);
            int nWaitProcessExit = nWaitProcessExit(nSuspendVM);
            getMonitorHandler().removeCallbacks(runnable);
            Log.i(TAG, "main process wait result: " + nWaitProcessExit);
            if (nWaitProcessExit != 0) {
                if (atomicBoolean.get()) {
                    i3 = 106;
                } else {
                    i3 = 105;
                }
                notifyDumpException(heapDumpConfig, new RuntimeException());
                return i3;
            }
        }
        File file = new File(str);
        if (file.exists() && file.length() > 1048576) {
            return 0;
        }
        return 108;
    }

    private static native boolean nInitForkDump(int i3);

    private static native void nResumeVM(long j3);

    private static native int nSuspendVM(long j3, String str, int i3);

    private static native int nWaitProcessExit(int i3);

    public static void notifyForkJvmDumperListener(boolean z16) {
        synchronized (forkJvmDumperListenerLock) {
            Iterator<IForkJvmDumperListener> it = forkJvmDumperListeners.iterator();
            while (it.hasNext()) {
                IForkJvmDumperListener next = it.next();
                if (z16) {
                    next.onSuspend();
                } else {
                    next.onResume();
                }
            }
        }
    }

    public static void registerForkJvmDumperListener(IForkJvmDumperListener iForkJvmDumperListener) {
        synchronized (forkJvmDumperListenerLock) {
            if (!forkJvmDumperListeners.contains(iForkJvmDumperListener)) {
                forkJvmDumperListeners.add(iForkJvmDumperListener);
            }
        }
    }

    public static void unRegisterForkJvmDumperListener(IForkJvmDumperListener iForkJvmDumperListener) {
        synchronized (forkJvmDumperListenerLock) {
            forkJvmDumperListeners.remove(iForkJvmDumperListener);
        }
    }

    @Override // com.tencent.bugly.common.heapdump.IHeapDumper
    public int dump(String str, @NotNull HeapDumpConfig heapDumpConfig) {
        Logger logger = Logger.f365497g;
        logger.i(TAG, "dump ", str);
        if (!StripHeapDumper.isSoLoaded) {
            logger.e(TAG, "dump failed caused by so not loaded!");
            return 101;
        }
        if (!isSymbolResolved) {
            logger.e(TAG, "dump failed caused by Symbol is not resolved!");
            return 102;
        }
        if (!DumpEnableChecker.isDiskSpaceEnough()) {
            logger.e(TAG, "dump failed caused by disk space not enough!");
            return 103;
        }
        if (!DumpEnableChecker.isForkDumpVersionPermitted()) {
            logger.e(TAG, "dump failed caused by version net permitted!");
            return 104;
        }
        return doForkDump(str, heapDumpConfig);
    }

    @Override // com.tencent.bugly.common.heapdump.IHeapDumper
    public boolean isValid() {
        return isSymbolResolved;
    }
}
