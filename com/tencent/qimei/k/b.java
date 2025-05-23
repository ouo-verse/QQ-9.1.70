package com.tencent.qimei.k;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b implements com.tencent.qimei.a.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public Context f343320a;

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.qimei.a.a f343321b;

    /* renamed from: c, reason: collision with root package name */
    public final Runnable f343322c;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements Runnable {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            try {
                if (com.tencent.qimei.f.a.f343257a) {
                    if (com.tencent.qimei.f.a.f343258b) {
                        b bVar = b.this;
                        com.tencent.qimei.a.a aVar = bVar.f343321b;
                        if (aVar != null) {
                            aVar.callbackOaid(true, "", com.tencent.qimei.k.a.a(bVar.f343320a), false);
                            return;
                        }
                        return;
                    }
                    com.tencent.qimei.a.a aVar2 = b.this.f343321b;
                    if (aVar2 != null) {
                        aVar2.callbackOaid(false, "", "", false);
                        return;
                    }
                    return;
                }
                throw new RuntimeException("SDK Need Init First!");
            } catch (Throwable th5) {
                com.tencent.qimei.a.a aVar3 = b.this.f343321b;
                if (aVar3 != null) {
                    aVar3.callbackOaid(false, "", "", false);
                }
                th5.printStackTrace();
            }
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f343320a = null;
        this.f343321b = null;
        this.f343322c = new a();
    }

    @Override // com.tencent.qimei.a.b
    public void a(Context context, com.tencent.qimei.a.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) aVar);
            return;
        }
        this.f343320a = context;
        this.f343321b = aVar;
        d dVar = d.f343326f;
        if (context != null && context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        com.tencent.qimei.f.a.f343258b = dVar.a(context);
        com.tencent.qimei.f.a.f343257a = true;
    }

    @Override // com.tencent.qimei.a.b
    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.qimei.a.b
    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    @Override // com.tencent.qimei.a.b
    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            com.tencent.qimei.b.d.f343207e.a(this.f343322c);
        }
    }

    @Override // com.tencent.qimei.a.b
    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }
}
