package com.tencent.qmsp.oaid2;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmsp.oaid2.f;

/* compiled from: P */
/* loaded from: classes22.dex */
public class h implements b, f.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private IVendorCallback f344223a;

    /* renamed from: b, reason: collision with root package name */
    private f f344224b;

    public h() {
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
        this.f344223a = iVendorCallback;
        f fVar = new f(context, this);
        this.f344224b = fVar;
        fVar.c();
    }

    @Override // com.tencent.qmsp.oaid2.f.b
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        IVendorCallback iVendorCallback = this.f344223a;
        if (iVendorCallback != null) {
            iVendorCallback.onResult(e(), d(), a());
        }
    }

    @Override // com.tencent.qmsp.oaid2.b
    public String d() {
        String a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        if (!e() || (a16 = this.f344224b.a()) == null) {
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
        f fVar = this.f344224b;
        if (fVar != null) {
            return fVar.d();
        }
        return false;
    }

    @Override // com.tencent.qmsp.oaid2.b
    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
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
        f fVar = this.f344224b;
        if (fVar != null) {
            fVar.e();
        }
    }

    @Override // com.tencent.qmsp.oaid2.b
    public String a() {
        String b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? (e() && (b16 = this.f344224b.b()) != null) ? b16 : "" : (String) iPatchRedirector.redirect((short) 5, (Object) this);
    }
}
