package com.tencent.mobileqq.qqvideoplatform.imp;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.videoplatform.api.IThreadMgr;
import com.tencent.richframework.thread.RFWThreadManager;

/* compiled from: P */
/* loaded from: classes17.dex */
public class f implements IThreadMgr {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static Handler f276412a;

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static Handler a() {
        Handler handler = f276412a;
        if (handler == null) {
            synchronized (ThreadManagerV2.class) {
                if (f276412a == null) {
                    f276412a = RFWThreadManager.createNewThreadHandler("QQVideoThreadMgrImp", 0);
                }
            }
            return f276412a;
        }
        return handler;
    }

    @Override // com.tencent.mobileqq.videoplatform.api.IThreadMgr
    public void postOnSubThread(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) runnable);
        } else {
            a().post(runnable);
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.IThreadMgr
    public void postOnSubThreadDelayed(Runnable runnable, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, runnable, Long.valueOf(j3));
        } else {
            a().postDelayed(runnable, j3);
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.IThreadMgr
    public void postOnUIThread(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) runnable);
        } else {
            RFWThreadManager.getUIHandler().post(runnable);
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.IThreadMgr
    public void postOnUIThreadDelayed(Runnable runnable, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, runnable, Long.valueOf(j3));
        } else {
            RFWThreadManager.getUIHandler().postDelayed(runnable, j3);
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.IThreadMgr
    public void quitSubThread() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.IThreadMgr
    public void removeCallbackOnSubHandler(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) runnable);
        } else {
            a().removeCallbacks(runnable);
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.IThreadMgr
    public void removeCallbackOnUIHandler(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) runnable);
        } else {
            RFWThreadManager.getUIHandler().removeCallbacks(runnable);
        }
    }
}
