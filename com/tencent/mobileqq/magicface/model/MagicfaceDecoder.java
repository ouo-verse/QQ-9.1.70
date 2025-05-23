package com.tencent.mobileqq.magicface.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;

/* compiled from: P */
/* loaded from: classes15.dex */
public abstract class MagicfaceDecoder {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    c f243390a;

    /* renamed from: b, reason: collision with root package name */
    a f243391b;

    /* renamed from: c, reason: collision with root package name */
    b f243392c;

    /* renamed from: d, reason: collision with root package name */
    public int f243393d;

    /* renamed from: e, reason: collision with root package name */
    public int f243394e;

    /* renamed from: f, reason: collision with root package name */
    volatile boolean f243395f;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface a {
        void a();

        void b();
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface b {
        void b(byte[] bArr, byte[] bArr2, int i3, int i16, float f16);

        void c(int[] iArr, int i3, int i16);
    }

    public MagicfaceDecoder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        this.f243393d = 8;
        this.f243394e = 1000 / 8;
        a();
    }

    protected abstract void a();

    public abstract void b();

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        }
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        }
    }

    public void e(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.f243393d = i3;
            this.f243394e = 1000 / i3;
        }
    }

    public void f(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        } else {
            this.f243391b = aVar;
        }
    }

    public void g(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) cVar);
        } else {
            this.f243390a = cVar;
        }
    }

    public void h(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar);
        } else {
            this.f243392c = bVar;
        }
    }

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        c();
        if (!this.f243395f) {
            try {
                new BaseThread(new Runnable() { // from class: com.tencent.mobileqq.magicface.model.MagicfaceDecoder.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MagicfaceDecoder.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        int priority = Thread.currentThread().getPriority();
                        Thread.currentThread().setPriority(10);
                        MagicfaceDecoder.this.f243395f = true;
                        a aVar = MagicfaceDecoder.this.f243391b;
                        if (aVar != null) {
                            aVar.a();
                        }
                        MagicfaceDecoder.this.b();
                        MagicfaceDecoder.this.f243395f = false;
                        a aVar2 = MagicfaceDecoder.this.f243391b;
                        if (aVar2 != null) {
                            aVar2.b();
                        }
                        Thread.currentThread().setPriority(priority);
                    }
                }).start();
            } catch (OutOfMemoryError e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("MagicfaceDecoder", 2, "startDecoder err:" + e16.getMessage());
                }
            }
        }
    }

    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.f243395f = false;
        }
    }
}
