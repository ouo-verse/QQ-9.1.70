package com.tencent.pts.core;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.pts.utils.PTSLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* loaded from: classes22.dex */
public class PTSThreadUtil {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "PTSThreadUtil";
    private static volatile Handler sMainThreadHandler;
    private static volatile Handler sSubThreadHandler;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37211);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            sMainThreadHandler = new Handler(Looper.getMainLooper());
        }
    }

    PTSThreadUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void registerSubHandlerThread(HandlerThread handlerThread) {
        if (handlerThread != null && sSubThreadHandler == null) {
            synchronized (PTSThreadUtil.class) {
                if (sSubThreadHandler == null) {
                    sSubThreadHandler = new Handler(handlerThread.getLooper());
                    PTSLog.i(TAG, "[registerSubHandlerThread], thread name = " + handlerThread.getName());
                }
            }
        }
    }

    public static void runOnSubThread(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (sSubThreadHandler == null) {
            synchronized (PTSThreadUtil.class) {
                if (sSubThreadHandler == null) {
                    BaseHandlerThread baseHandlerThread = new BaseHandlerThread("readinjoy-common-pts-sub");
                    baseHandlerThread.start();
                    sSubThreadHandler = new Handler(baseHandlerThread.getLooper());
                }
            }
        }
        sSubThreadHandler.post(runnable);
        if (PTSLog.isDebug() || PTSLog.isColorLevel()) {
            PTSLog.i(TAG, "[runOnSubThread], callStack = " + Log.getStackTraceString(new Throwable()));
        }
    }

    public static void runOnUIThread(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            sMainThreadHandler.post(runnable);
        }
    }
}
