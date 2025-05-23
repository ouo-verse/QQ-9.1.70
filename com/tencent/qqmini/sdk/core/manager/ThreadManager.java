package com.tencent.qqmini.sdk.core.manager;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.thread.ThreadPools;
import com.tencent.qqmini.sdk.launcher.core.proxy.ThreadProxy;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* compiled from: P */
@MiniKeep
/* loaded from: classes23.dex */
public class ThreadManager {
    private static volatile Handler SUB_HANDLER;
    private static volatile Handler UI_HANDLER;
    private static volatile HandlerThread sSubThread;
    private static volatile ThreadProxy sThreadProxy;

    @Deprecated
    public static void executeOnComputationThreadPool(Runnable runnable) {
        ThreadPools.getComputationThreadPool().execute(runnable);
    }

    @Deprecated
    public static void executeOnDiskIOThreadPool(Runnable runnable) {
        getSubThreadHandler().post(runnable);
    }

    @Deprecated
    public static void executeOnNetworkIOThreadPool(Runnable runnable) {
        ThreadPools.getNetworkIOThreadPool().execute(runnable);
    }

    public static HandlerThread getSubThread() {
        if (sSubThread == null) {
            synchronized (ThreadManager.class) {
                BaseHandlerThread baseHandlerThread = new BaseHandlerThread("MINIAPP_SUB", 10);
                baseHandlerThread.start();
                sSubThread = baseHandlerThread;
            }
        }
        return sSubThread;
    }

    public static Handler getSubThreadHandler() {
        if (SUB_HANDLER == null) {
            synchronized (ThreadManager.class) {
                if (SUB_HANDLER == null) {
                    SUB_HANDLER = new Handler(getSubThread().getLooper());
                }
            }
        }
        return SUB_HANDLER;
    }

    private static ThreadProxy getThreadProxy() {
        if (sThreadProxy == null) {
            synchronized (ThreadManager.class) {
                if (sThreadProxy == null) {
                    sThreadProxy = (ThreadProxy) ProxyManager.get(ThreadProxy.class);
                }
            }
        }
        return sThreadProxy;
    }

    public static Handler getUIHandler() {
        if (UI_HANDLER == null) {
            synchronized (ThreadManager.class) {
                if (UI_HANDLER == null) {
                    UI_HANDLER = new Handler(Looper.getMainLooper());
                }
            }
        }
        return UI_HANDLER;
    }

    public static void runComputationTask(Runnable runnable) {
        getThreadProxy().runComputationTask(runnable);
    }

    public static void runIOTask(Runnable runnable) {
        getThreadProxy().runIOTask(runnable);
    }

    public static void runNetTask(Runnable runnable) {
        getThreadProxy().runNetTask(runnable);
    }
}
