package com.tencent.mobileqq.videoplatform.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.videoplatform.api.IThreadMgr;
import com.tencent.mobileqq.videoplatform.imp.ThreadMgrImp;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ThreadUtil {
    static IPatchRedirector $redirector_;
    private static IThreadMgr sThreadMgr;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14821);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            sThreadMgr = new ThreadMgrImp();
        }
    }

    public ThreadUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void postOnSubThread(Runnable runnable) {
        sThreadMgr.postOnSubThread(runnable);
    }

    public static void postOnSubThreadDelayed(Runnable runnable, long j3) {
        sThreadMgr.postOnSubThreadDelayed(runnable, j3);
    }

    public static void postOnUIThread(Runnable runnable) {
        sThreadMgr.postOnUIThread(runnable);
    }

    public static void postOnUIThreadDelayed(Runnable runnable, long j3) {
        sThreadMgr.postOnUIThreadDelayed(runnable, j3);
    }

    public static void quitThread() {
        sThreadMgr.quitSubThread();
    }

    public static void removeCallbacksInSubHandler(Runnable runnable) {
        sThreadMgr.removeCallbackOnSubHandler(runnable);
    }

    public static void removeCallbacksOnUIHandler(Runnable runnable) {
        sThreadMgr.removeCallbackOnUIHandler(runnable);
    }

    public static void setThreadImp(IThreadMgr iThreadMgr) {
        sThreadMgr = iThreadMgr;
    }
}
