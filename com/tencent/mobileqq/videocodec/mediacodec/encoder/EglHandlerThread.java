package com.tencent.mobileqq.videocodec.mediacodec.encoder;

import android.annotation.TargetApi;
import android.opengl.EGLContext;
import android.os.Handler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* compiled from: P */
@TargetApi(18)
/* loaded from: classes20.dex */
public class EglHandlerThread extends BaseHandlerThread {
    static IPatchRedirector $redirector_;
    private EGLContext C;
    private b D;
    private Handler E;
    private boolean F;

    /* renamed from: m, reason: collision with root package name */
    private a f312550m;

    public EglHandlerThread(String str, EGLContext eGLContext) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) eGLContext);
        } else {
            this.F = false;
            this.C = eGLContext;
        }
    }

    private boolean e() {
        if (getLooper() != null && getLooper().getThread() == Thread.currentThread()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void release() {
        if (!e()) {
            QLog.e("EglHandlerThread", 2, "release should be called in origin thread " + getThreadId());
            return;
        }
        if (!this.F) {
            return;
        }
        b bVar = this.D;
        if (bVar != null) {
            bVar.d();
            this.D = null;
        }
        a aVar = this.f312550m;
        if (aVar != null) {
            aVar.g();
            this.f312550m = null;
        }
    }

    public Handler getHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Handler) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.E;
    }

    public boolean isInitSuccess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.F;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.HandlerThread
    public void onLooperPrepared() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        try {
            super.onLooperPrepared();
            this.E = new Handler(getLooper());
            a aVar = new a(this.C, 1);
            this.f312550m = aVar;
            b bVar = new b(aVar);
            this.D = bVar;
            bVar.a(64, 64);
            this.D.c();
            this.F = true;
        } catch (Exception e16) {
            this.F = false;
            QLog.e("EglHandlerThread", 2, e16, new Object[0]);
        }
    }

    @Override // android.os.HandlerThread
    public boolean quit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (!e()) {
            QLog.e("EglHandlerThread", 2, "quit should be called in origin thread " + getThreadId());
            this.E.post(new Runnable() { // from class: com.tencent.mobileqq.videocodec.mediacodec.encoder.EglHandlerThread.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EglHandlerThread.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        EglHandlerThread.this.quit();
                    }
                }
            });
            return false;
        }
        boolean quit = super.quit();
        release();
        return quit;
    }

    @Override // android.os.HandlerThread
    public boolean quitSafely() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        this.E.post(new Runnable() { // from class: com.tencent.mobileqq.videocodec.mediacodec.encoder.EglHandlerThread.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EglHandlerThread.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    EglHandlerThread.this.release();
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        });
        return super.quitSafely();
    }
}
