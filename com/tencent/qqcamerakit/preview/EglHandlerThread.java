package com.tencent.qqcamerakit.preview;

import android.opengl.EGLContext;
import android.os.Handler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* compiled from: P */
/* loaded from: classes22.dex */
public class EglHandlerThread extends BaseHandlerThread {
    static IPatchRedirector $redirector_;
    private EGLContext C;
    private b D;
    private Handler E;
    private boolean F;

    /* renamed from: m, reason: collision with root package name */
    private a f344936m;

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

    /* JADX INFO: Access modifiers changed from: private */
    public void release() {
        if (getLooper().getThread() != Thread.currentThread()) {
            com.tencent.qqcamerakit.common.e.d("EglHandlerThread", 1, "release should be called in origin thread " + getThreadId());
            return;
        }
        if (!this.F) {
            return;
        }
        b bVar = this.D;
        if (bVar != null) {
            bVar.c();
            this.D = null;
        }
        a aVar = this.f344936m;
        if (aVar != null) {
            aVar.f();
            this.f344936m = null;
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

    @Override // android.os.HandlerThread
    protected void onLooperPrepared() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        try {
            super.onLooperPrepared();
            this.E = new Handler(getLooper());
            a aVar = new a(this.C, 1);
            this.f344936m = aVar;
            b bVar = new b(aVar);
            this.D = bVar;
            bVar.a(64, 64);
            this.D.b();
            this.F = true;
        } catch (Exception e16) {
            this.F = false;
            com.tencent.qqcamerakit.common.e.c("EglHandlerThread", 1, e16, new Object[0]);
        }
    }

    @Override // android.os.HandlerThread
    public boolean quit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (getLooper().getThread() != Thread.currentThread()) {
            com.tencent.qqcamerakit.common.e.d("EglHandlerThread", 1, "quit should be called in origin thread " + getThreadId());
            this.E.post(new Runnable() { // from class: com.tencent.qqcamerakit.preview.EglHandlerThread.1
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
        this.E.post(new Runnable() { // from class: com.tencent.qqcamerakit.preview.EglHandlerThread.2
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
