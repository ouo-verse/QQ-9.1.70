package com.tencent.tfd.sdk.wxa;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
public class Bryony {
    static IPatchRedirector $redirector_;
    public static final Cdo D;
    public long A;
    public boolean B;
    public boolean C;

    /* renamed from: a, reason: collision with root package name */
    public Cabstract f375458a;

    /* renamed from: b, reason: collision with root package name */
    public ITuringPrivacyPolicy f375459b;

    /* renamed from: c, reason: collision with root package name */
    public ITuringDeviceInfoProvider f375460c;

    /* renamed from: d, reason: collision with root package name */
    public ITuringPkgProvider f375461d;

    /* renamed from: e, reason: collision with root package name */
    public ITuringIoTFeatureMap f375462e;

    /* renamed from: f, reason: collision with root package name */
    public Context f375463f;

    /* renamed from: g, reason: collision with root package name */
    public int f375464g;

    /* renamed from: h, reason: collision with root package name */
    public String f375465h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f375466i;

    /* renamed from: j, reason: collision with root package name */
    public String f375467j;

    /* renamed from: k, reason: collision with root package name */
    public String f375468k;

    /* renamed from: l, reason: collision with root package name */
    public String f375469l;

    /* renamed from: m, reason: collision with root package name */
    public String f375470m;

    /* renamed from: n, reason: collision with root package name */
    public int f375471n;

    /* renamed from: o, reason: collision with root package name */
    public String f375472o;

    /* renamed from: p, reason: collision with root package name */
    public Map<Integer, String> f375473p;

    /* renamed from: q, reason: collision with root package name */
    public String f375474q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f375475r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f375476s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f375477t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f375478u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f375479v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f375480w;

    /* renamed from: x, reason: collision with root package name */
    public long f375481x;

    /* renamed from: y, reason: collision with root package name */
    public long f375482y;

    /* renamed from: z, reason: collision with root package name */
    public int f375483z;

    /* compiled from: P */
    /* renamed from: com.tencent.tfd.sdk.wxa.Bryony$do, reason: invalid class name */
    /* loaded from: classes26.dex */
    public class Cdo implements Csynchronized {
        static IPatchRedirector $redirector_;

        public Cdo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.tfd.sdk.wxa.Csynchronized
        public final boolean userAgreement() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return false;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62445);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            D = new Cdo();
        }
    }

    public Bryony() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f375464g = 0;
        this.f375465h = "";
        this.f375466i = true;
        this.f375467j = "";
        this.f375468k = "";
        this.f375469l = "";
        this.f375470m = "";
        this.f375471n = 0;
        this.f375472o = "";
        this.f375473p = new HashMap();
        this.f375474q = "";
        this.f375475r = true;
        this.f375476s = false;
        this.f375477t = true;
        this.f375478u = true;
        this.f375479v = true;
        this.f375480w = false;
        this.f375481x = 5000L;
        this.f375482y = 60000L;
        this.f375483z = 3;
        this.A = 5000L;
        this.B = false;
        this.C = false;
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (TextUtils.isEmpty(this.f375467j)) {
            this.f375467j = "https://tdid.m.qq.com?mc=2";
        }
        if (this.f375458a == null) {
            this.f375458a = new Cabstract(this.f375467j);
        } else {
            this.B = true;
        }
    }
}
