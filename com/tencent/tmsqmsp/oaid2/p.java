package com.tencent.tmsqmsp.oaid2;

import android.content.Context;
import android.os.IBinder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes26.dex */
public class p implements b, o {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private IVendorCallback f380846a;

    /* renamed from: b, reason: collision with root package name */
    private String f380847b;

    /* renamed from: c, reason: collision with root package name */
    private String f380848c;

    /* renamed from: d, reason: collision with root package name */
    private q f380849d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f380850e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f380851f;

    public p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f380847b = "";
        this.f380848c = "";
        this.f380850e = false;
        this.f380851f = false;
    }

    @Override // com.tencent.tmsqmsp.oaid2.b
    public void a(Context context, IVendorCallback iVendorCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) iVendorCallback);
            return;
        }
        this.f380846a = iVendorCallback;
        q qVar = new q(context);
        this.f380849d = qVar;
        qVar.a(this);
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (IBinder) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.tmsqmsp.oaid2.o
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        IVendorCallback iVendorCallback = this.f380846a;
        if (iVendorCallback != null) {
            iVendorCallback.onResult(false, null, null);
        }
    }

    @Override // com.tencent.tmsqmsp.oaid2.b
    public String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f380848c;
    }

    @Override // com.tencent.tmsqmsp.oaid2.b
    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.f380851f;
    }

    @Override // com.tencent.tmsqmsp.oaid2.b
    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            this.f380849d.a(this);
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
        q qVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else if (this.f380850e && (qVar = this.f380849d) != null) {
            qVar.a();
        }
    }

    @Override // com.tencent.tmsqmsp.oaid2.b
    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? this.f380847b : (String) iPatchRedirector.redirect((short) 5, (Object) this);
    }

    @Override // com.tencent.tmsqmsp.oaid2.o
    public void a(n nVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) nVar);
            return;
        }
        try {
            String c16 = nVar.c();
            this.f380847b = c16;
            if (c16 == null) {
                this.f380847b = "";
            }
        } catch (Exception unused) {
        }
        try {
            String i3 = nVar.i();
            this.f380848c = i3;
            if (i3 == null) {
                this.f380848c = "";
            }
        } catch (Exception unused2) {
        }
        try {
            this.f380851f = nVar.b();
        } catch (Exception unused3) {
        }
        this.f380850e = true;
        IVendorCallback iVendorCallback = this.f380846a;
        if (iVendorCallback != null) {
            iVendorCallback.onResult(this.f380851f, this.f380848c, this.f380847b);
        }
    }
}
