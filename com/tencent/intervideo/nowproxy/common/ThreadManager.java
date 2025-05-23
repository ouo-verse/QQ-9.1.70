package com.tencent.intervideo.nowproxy.common;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ThreadManager {
    static IPatchRedirector $redirector_;
    public static volatile HandlerThread FILE_HANDLER_THREAD;
    public static volatile Handler FILE_THREAD_HANDLER;
    public static volatile Handler UI_THREAD_HANDLER;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10740);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        FILE_THREAD_HANDLER = null;
        FILE_HANDLER_THREAD = null;
        UI_THREAD_HANDLER = null;
    }

    public ThreadManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static Handler getFileThreadHandler() {
        if (FILE_HANDLER_THREAD == null) {
            synchronized (ThreadManager.class) {
                FILE_HANDLER_THREAD = new BaseHandlerThread("nowlive_install", 0);
                FILE_HANDLER_THREAD.start();
                FILE_THREAD_HANDLER = new Handler(FILE_HANDLER_THREAD.getLooper());
            }
        }
        return FILE_THREAD_HANDLER;
    }

    public static Handler getUIThreadHandler() {
        if (FILE_HANDLER_THREAD == null) {
            synchronized (ThreadManager.class) {
                FILE_THREAD_HANDLER = new Handler(Looper.getMainLooper());
            }
        }
        return FILE_THREAD_HANDLER;
    }

    public static synchronized void unInit() {
        synchronized (ThreadManager.class) {
            if (FILE_HANDLER_THREAD != null) {
                FILE_HANDLER_THREAD.quit();
                FILE_HANDLER_THREAD = null;
            }
        }
    }
}
