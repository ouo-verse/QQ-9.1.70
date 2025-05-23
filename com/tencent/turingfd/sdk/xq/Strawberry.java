package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.turingfd.sdk.xq.ComaBerenices;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Strawberry {
    static IPatchRedirector $redirector_;
    public static Strawberry C;
    public static final LeoMinor D;
    public boolean A;
    public boolean B;

    /* renamed from: a, reason: collision with root package name */
    public Hydra f383079a;

    /* renamed from: b, reason: collision with root package name */
    public LeoMinor f383080b;

    /* renamed from: c, reason: collision with root package name */
    public ITuringDeviceInfoProvider f383081c;

    /* renamed from: d, reason: collision with root package name */
    public ITuringPkgProvider f383082d;

    /* renamed from: e, reason: collision with root package name */
    public ITuringIoTFeatureMap f383083e;

    /* renamed from: f, reason: collision with root package name */
    public int f383084f;

    /* renamed from: g, reason: collision with root package name */
    public String f383085g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f383086h;

    /* renamed from: i, reason: collision with root package name */
    public String[] f383087i;

    /* renamed from: j, reason: collision with root package name */
    public int f383088j;

    /* renamed from: k, reason: collision with root package name */
    public String f383089k;

    /* renamed from: l, reason: collision with root package name */
    public String f383090l;

    /* renamed from: m, reason: collision with root package name */
    public String f383091m;

    /* renamed from: n, reason: collision with root package name */
    public int f383092n;

    /* renamed from: o, reason: collision with root package name */
    public String f383093o;

    /* renamed from: p, reason: collision with root package name */
    public Map<Integer, String> f383094p;

    /* renamed from: q, reason: collision with root package name */
    public String f383095q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f383096r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f383097s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f383098t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f383099u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f383100v;

    /* renamed from: w, reason: collision with root package name */
    public long f383101w;

    /* renamed from: x, reason: collision with root package name */
    public long f383102x;

    /* renamed from: y, reason: collision with root package name */
    public int f383103y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f383104z;

    /* compiled from: P */
    /* renamed from: com.tencent.turingfd.sdk.xq.Strawberry$do, reason: invalid class name */
    /* loaded from: classes27.dex */
    public class Cdo implements LeoMinor {
        static IPatchRedirector $redirector_;

        public Cdo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.turingfd.sdk.xq.LeoMinor
        public boolean userAgreement() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return false;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12746);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            D = new Cdo();
        }
    }

    public Strawberry() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f383084f = 0;
        this.f383085g = "";
        this.f383086h = true;
        this.f383087i = null;
        this.f383088j = 10000;
        this.f383089k = "";
        this.f383090l = "";
        this.f383091m = "";
        this.f383092n = 0;
        this.f383093o = "";
        this.f383094p = new HashMap();
        this.f383095q = "";
        this.f383096r = true;
        this.f383097s = false;
        this.f383098t = true;
        this.f383099u = true;
        this.f383100v = false;
        this.f383101w = 5000L;
        this.f383102x = 60000L;
        this.f383103y = 3;
        this.f383104z = false;
        this.A = false;
        this.B = false;
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        String[] strArr = this.f383087i;
        if (strArr != null) {
            if (strArr.length == 0) {
                this.f383087i = null;
            } else {
                ArrayList arrayList = new ArrayList();
                for (String str : this.f383087i) {
                    if (str != null && !str.isEmpty()) {
                        arrayList.add(str);
                    }
                }
                this.f383087i = arrayList.isEmpty() ? null : (String[]) arrayList.toArray(new String[0]);
            }
        }
        if (this.f383087i == null) {
            this.f383087i = new String[]{"https://tdid.m.qq.com?mc=2"};
        }
        if (this.f383079a == null) {
            if (this.f383088j < 1000) {
                this.f383088j = 10000;
            }
            String[] strArr2 = this.f383087i;
            int i3 = this.f383088j;
            ComaBerenices.Cdo cdo = new ComaBerenices.Cdo(strArr2);
            if (strArr2.length > 1) {
                Cstrictfp.f383431a.submit(new Chamaeleon(cdo, i3));
            }
            this.f383079a = cdo;
            return;
        }
        this.f383104z = true;
    }

    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (TextUtils.isEmpty(this.f383095q)) {
            return "";
        }
        return this.f383095q;
    }

    public final Context c() {
        Context context;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Context) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        synchronized (Celse.class) {
            context = Celse.f383328a;
        }
        return context;
    }

    public LeoMinor d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (LeoMinor) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        LeoMinor leoMinor = this.f383080b;
        if (leoMinor == null) {
            return D;
        }
        return leoMinor;
    }

    public final void a(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            Celse.a(context);
        } else {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) context);
        }
    }
}
