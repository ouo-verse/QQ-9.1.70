package com.tencent.mobileqq.msf.core.x;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes15.dex */
public class r {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    private static final String f250423a = "WeakNetworkConfig";

    /* renamed from: b, reason: collision with root package name */
    static final /* synthetic */ boolean f250424b;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f250425a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f250426b;

        /* renamed from: c, reason: collision with root package name */
        public int f250427c;

        /* renamed from: d, reason: collision with root package name */
        public int f250428d;

        /* renamed from: e, reason: collision with root package name */
        public int f250429e;

        /* renamed from: f, reason: collision with root package name */
        public int f250430f;

        /* renamed from: g, reason: collision with root package name */
        public int f250431g;

        /* renamed from: h, reason: collision with root package name */
        public int f250432h;

        /* renamed from: i, reason: collision with root package name */
        public int f250433i;

        /* renamed from: j, reason: collision with root package name */
        public int f250434j;

        /* renamed from: k, reason: collision with root package name */
        public int f250435k;

        public a(int i3, boolean z16, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29, int i36) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Boolean.valueOf(z16), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i27), Integer.valueOf(i28), Integer.valueOf(i29), Integer.valueOf(i36));
                return;
            }
            this.f250425a = i3;
            this.f250426b = z16;
            this.f250427c = i16;
            this.f250428d = i17;
            this.f250429e = i18;
            this.f250430f = i19;
            this.f250431g = i26;
            this.f250432h = i27;
            this.f250433i = i28;
            this.f250434j = i29;
            this.f250435k = i36;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            StringBuilder sb5 = new StringBuilder(64);
            sb5.append("WeaknetNew ConfigParam: [");
            sb5.append(this.f250425a);
            sb5.append(",");
            sb5.append(this.f250426b);
            sb5.append(",");
            sb5.append(this.f250427c);
            sb5.append(",");
            sb5.append(this.f250428d);
            sb5.append(",");
            sb5.append(this.f250429e);
            sb5.append(",");
            sb5.append(this.f250430f);
            sb5.append(",");
            sb5.append(this.f250432h);
            sb5.append(",");
            sb5.append(this.f250433i);
            sb5.append(",");
            sb5.append(this.f250435k);
            sb5.append(",");
            sb5.append(this.f250434j);
            sb5.append("]");
            return sb5.toString();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23654);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f250424b = true;
        }
    }

    public r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static a a() {
        return new a(1, true, 3000, 3000, 2, 2, 2000, 20, 2000, 3000, 500);
    }

    public static a b() {
        a a16;
        if (!BaseApplication.getContext().getMSFInterfaceAdapter().isReleaseVersion()) {
            a16 = a();
        } else {
            int V0 = b.V0();
            if (V0 != 1) {
                if (V0 != 2) {
                    a16 = a();
                } else {
                    a16 = new a(2, false, 2000, 2000, 2, 1, 2000, 20, 1000, 2000, 1000);
                }
            } else {
                a16 = a();
            }
        }
        if (!f250424b && a16 == null) {
            throw new AssertionError();
        }
        return a16;
    }
}
