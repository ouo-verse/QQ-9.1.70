package com.tencent.qmsp.oaid2;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c0 implements b, a0 {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private z f344185a;

    /* renamed from: b, reason: collision with root package name */
    private Context f344186b;

    /* renamed from: c, reason: collision with root package name */
    private IVendorCallback f344187c;

    public c0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qmsp.oaid2.b
    public void a(Context context, IVendorCallback iVendorCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) iVendorCallback);
            return;
        }
        if (z.a(context)) {
            String a16 = e.a(context);
            if (!TextUtils.isEmpty(a16)) {
                z.a(context, a16);
            }
            this.f344185a = new z(context, this);
        }
        this.f344187c = iVendorCallback;
        this.f344186b = context;
    }

    @Override // com.tencent.qmsp.oaid2.a0
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        IVendorCallback iVendorCallback = this.f344187c;
        if (iVendorCallback != null) {
            iVendorCallback.onResult(false, "", "");
        }
    }

    @Override // com.tencent.qmsp.oaid2.b
    public String d() {
        String a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        if (!e() || (a16 = this.f344185a.a()) == null) {
            return "";
        }
        return a16;
    }

    @Override // com.tencent.qmsp.oaid2.b
    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        z zVar = this.f344185a;
        if (zVar != null) {
            return zVar.c();
        }
        return false;
    }

    @Override // com.tencent.qmsp.oaid2.b
    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        z zVar = this.f344185a;
        if (zVar != null) {
            zVar.a(e.a(this.f344186b));
        } else {
            b();
        }
    }

    @Override // com.tencent.qmsp.oaid2.b
    public boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.qmsp.oaid2.b
    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        z zVar = this.f344185a;
        if (zVar != null) {
            zVar.d();
        }
    }

    @Override // com.tencent.qmsp.oaid2.b
    public String a() {
        String b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? (!e() || (b16 = this.f344185a.b()) == null) ? "" : b16 : (String) iPatchRedirector.redirect((short) 5, (Object) this);
    }

    @Override // com.tencent.qmsp.oaid2.a0
    public void a(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
            return;
        }
        IVendorCallback iVendorCallback = this.f344187c;
        if (iVendorCallback != null) {
            iVendorCallback.onResult(e(), d(), a());
        }
    }
}
