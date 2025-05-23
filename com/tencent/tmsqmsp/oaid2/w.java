package com.tencent.tmsqmsp.oaid2;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tmsqmsp.oaid2.x;

/* compiled from: P */
/* loaded from: classes26.dex */
public class w implements b, x.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private x f380893a;

    /* renamed from: b, reason: collision with root package name */
    private IVendorCallback f380894b;

    public w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.tmsqmsp.oaid2.b
    public void a(Context context, IVendorCallback iVendorCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) iVendorCallback);
        } else {
            this.f380894b = iVendorCallback;
            this.f380893a = new x(context, this);
        }
    }

    @Override // com.tencent.tmsqmsp.oaid2.b
    public String d() {
        String c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        if (!e() || (c16 = this.f380893a.c()) == null) {
            return "";
        }
        return c16;
    }

    @Override // com.tencent.tmsqmsp.oaid2.b
    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        x xVar = this.f380893a;
        if (xVar != null) {
            return xVar.b();
        }
        return false;
    }

    @Override // com.tencent.tmsqmsp.oaid2.b
    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        }
    }

    @Override // com.tencent.tmsqmsp.oaid2.b
    public boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.tmsqmsp.oaid2.b
    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        x xVar = this.f380893a;
        if (xVar != null) {
            xVar.d();
        }
    }

    @Override // com.tencent.tmsqmsp.oaid2.b
    public String a() {
        String a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? (e() && (a16 = this.f380893a.a()) != null) ? a16 : "" : (String) iPatchRedirector.redirect((short) 5, (Object) this);
    }

    @Override // com.tencent.tmsqmsp.oaid2.x.b
    public void a(x xVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) xVar);
            return;
        }
        try {
            IVendorCallback iVendorCallback = this.f380894b;
            if (iVendorCallback != null) {
                iVendorCallback.onResult(e(), d(), a());
            }
        } catch (Throwable unused) {
            IVendorCallback iVendorCallback2 = this.f380894b;
            if (iVendorCallback2 != null) {
                iVendorCallback2.onResult(false, "", "");
            }
        }
    }
}
