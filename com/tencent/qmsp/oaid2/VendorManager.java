package com.tencent.qmsp.oaid2;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes22.dex */
public class VendorManager implements IVendorCallback {
    static IPatchRedirector $redirector_;
    private IVendorCallback userCallback;
    private b vendorInfo;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static /* synthetic */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f344179a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16174);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[d.c().length];
            f344179a = iArr;
            try {
                iArr[d.f344189b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f344179a[d.f344190c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f344179a[d.f344191d.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f344179a[d.f344192e.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f344179a[d.f344193f.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f344179a[d.f344194g.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f344179a[d.f344195h.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f344179a[d.f344196i.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f344179a[d.f344197j.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f344179a[d.f344198k.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f344179a[d.f344199l.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f344179a[d.f344188a.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    public VendorManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.vendorInfo = null;
            this.userCallback = null;
        }
    }

    public int getVendorInfo(Context context, IVendorCallback iVendorCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) iVendorCallback)).intValue();
        }
        this.userCallback = iVendorCallback;
        switch (a.f344179a[d.b().ordinal()]) {
            case 1:
                this.vendorInfo = new w0();
                break;
            case 2:
                this.vendorInfo = new v0();
                break;
            case 3:
                this.vendorInfo = new t();
                break;
            case 4:
                this.vendorInfo = new n0();
                break;
            case 5:
                this.vendorInfo = new w();
                break;
            case 6:
                this.vendorInfo = new p();
                break;
            case 7:
                this.vendorInfo = new s0();
                break;
            case 8:
                this.vendorInfo = new i0();
                break;
            case 9:
                this.vendorInfo = new j0();
                break;
            case 10:
                this.vendorInfo = new c0();
                break;
            case 11:
                this.vendorInfo = new m();
                break;
            case 12:
                if (d.a(context)) {
                    this.vendorInfo = new h();
                    break;
                }
                break;
        }
        if (this.vendorInfo == null && e.a()) {
            this.vendorInfo = new t();
        }
        if (this.vendorInfo == null) {
            onResult(false, "", "");
            return com.tencent.qmsp.oaid2.a.f344180a;
        }
        t0.a("init");
        try {
            this.vendorInfo.a(context, this);
            if (!this.vendorInfo.k()) {
                try {
                    this.vendorInfo.j();
                } catch (Throwable unused) {
                    onResult(false, "", "");
                    return com.tencent.qmsp.oaid2.a.f344181b;
                }
            } else {
                t0.a("sync");
                try {
                    onResult(this.vendorInfo.e(), this.vendorInfo.d(), this.vendorInfo.a());
                } catch (Throwable unused2) {
                    onResult(false, "", "");
                }
            }
            return 0;
        } catch (Throwable unused3) {
            onResult(false, "", "");
            return com.tencent.qmsp.oaid2.a.f344181b;
        }
    }

    @Override // com.tencent.qmsp.oaid2.IVendorCallback
    public void onResult(boolean z16, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str, str2);
            return;
        }
        t0.b("vm onResult " + z16);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        IVendorCallback iVendorCallback = this.userCallback;
        if (iVendorCallback != null) {
            iVendorCallback.onResult(z16, str, str2);
        }
        b bVar = this.vendorInfo;
        if (bVar != null) {
            bVar.l();
        }
    }
}
