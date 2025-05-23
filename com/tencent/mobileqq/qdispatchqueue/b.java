package com.tencent.mobileqq.qdispatchqueue;

import android.os.Handler;
import com.tencent.component.media.MtpConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* compiled from: P */
/* loaded from: classes16.dex */
class b implements e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final Handler f261872a;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static b f261873a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(MtpConstants.FORMAT_JP2);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f261873a = new b();
            }
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("DispatchQueueDefaultDispatcher");
        baseHandlerThread.start();
        this.f261872a = new Handler(baseHandlerThread.getLooper());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b b() {
        return a.f261873a;
    }

    @Override // com.tencent.mobileqq.qdispatchqueue.e
    public void a(Runnable runnable, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, runnable, Long.valueOf(j3));
        } else {
            this.f261872a.postDelayed(runnable, j3);
        }
    }
}
