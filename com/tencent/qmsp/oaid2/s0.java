package com.tencent.qmsp.oaid2;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmsp.oaid2.r0;

/* compiled from: P */
/* loaded from: classes22.dex */
public class s0 implements b, r0.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public IVendorCallback f344288a;

    /* renamed from: b, reason: collision with root package name */
    private r0 f344289b;

    public s0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qmsp.oaid2.r0.b
    public void a(r0 r0Var) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) r0Var);
            return;
        }
        IVendorCallback iVendorCallback = this.f344288a;
        if (iVendorCallback != null) {
            iVendorCallback.onResult(e(), d(), a());
        }
    }

    @Override // com.tencent.qmsp.oaid2.b
    public String d() {
        String a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (!e() || (a16 = this.f344289b.a()) == null) {
            return "";
        }
        return a16;
    }

    @Override // com.tencent.qmsp.oaid2.b
    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        r0 r0Var = this.f344289b;
        if (r0Var != null) {
            return r0Var.d();
        }
        return false;
    }

    @Override // com.tencent.qmsp.oaid2.b
    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    @Override // com.tencent.qmsp.oaid2.b
    public boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.qmsp.oaid2.b
    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        r0 r0Var = this.f344289b;
        if (r0Var != null) {
            r0Var.e();
        }
    }

    @Override // com.tencent.qmsp.oaid2.b
    public void a(Context context, IVendorCallback iVendorCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) context, (Object) iVendorCallback);
            return;
        }
        this.f344288a = iVendorCallback;
        r0 r0Var = new r0(context, this);
        this.f344289b = r0Var;
        r0Var.c();
    }

    @Override // com.tencent.qmsp.oaid2.b
    public String a() {
        String b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) ? (e() && (b16 = this.f344289b.b()) != null) ? b16 : "" : (String) iPatchRedirector.redirect((short) 8, (Object) this);
    }
}
