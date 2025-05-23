package com.tencent.qimei.f;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qimei.f.a;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c implements com.tencent.qimei.a.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public Context f343266a;

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.qimei.a.a f343267b;

    /* renamed from: c, reason: collision with root package name */
    public String f343268c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f343269d;

    /* renamed from: e, reason: collision with root package name */
    public final Runnable f343270e;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements Runnable {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
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
                a.C9318a a16 = com.tencent.qimei.f.a.a(c.this.f343266a);
                if (a16 == null) {
                    com.tencent.qimei.a.a aVar = c.this.f343267b;
                    if (aVar != null) {
                        aVar.callbackOaid(false, "", "", false);
                        return;
                    }
                    return;
                }
                c cVar = c.this;
                String str = a16.f343260a;
                cVar.f343268c = str;
                if (!TextUtils.isEmpty(str)) {
                    c.this.f343269d = true;
                }
                c cVar2 = c.this;
                com.tencent.qimei.a.a aVar2 = cVar2.f343267b;
                if (aVar2 != null) {
                    aVar2.callbackOaid(cVar2.f343269d, "", cVar2.f343268c, false);
                }
            } catch (Throwable th5) {
                th5.printStackTrace();
                if (TextUtils.isEmpty(c.this.f343268c)) {
                    c.this.f343269d = false;
                }
                c cVar3 = c.this;
                com.tencent.qimei.a.a aVar3 = cVar3.f343267b;
                if (aVar3 != null) {
                    aVar3.callbackOaid(cVar3.f343269d, "", cVar3.f343268c, false);
                }
            }
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f343268c = null;
        this.f343269d = false;
        this.f343270e = new a();
    }

    @Override // com.tencent.qimei.a.b
    public void a(Context context, com.tencent.qimei.a.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) aVar);
        } else {
            this.f343266a = context;
            this.f343267b = aVar;
        }
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
            com.tencent.qimei.b.d.f343207e.a(this.f343270e);
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
