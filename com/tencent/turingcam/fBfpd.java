package com.tencent.turingcam;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.turingface.sdk.mfa.d;
import com.tencent.turingface.sdk.mfa.h;
import com.tencent.turingface.sdk.mfa.l;
import com.tencent.turingface.sdk.mfa.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes27.dex */
public class fBfpd {
    static IPatchRedirector $redirector_;
    public static fBfpd B;
    public static final V3a8U C;
    public boolean A;

    /* renamed from: a, reason: collision with root package name */
    public m f382214a;

    /* renamed from: b, reason: collision with root package name */
    public V3a8U f382215b;

    /* renamed from: c, reason: collision with root package name */
    public d f382216c;

    /* renamed from: d, reason: collision with root package name */
    public int f382217d;

    /* renamed from: e, reason: collision with root package name */
    public String f382218e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f382219f;

    /* renamed from: g, reason: collision with root package name */
    public String[] f382220g;

    /* renamed from: h, reason: collision with root package name */
    public int f382221h;

    /* renamed from: i, reason: collision with root package name */
    public String f382222i;

    /* renamed from: j, reason: collision with root package name */
    public String f382223j;

    /* renamed from: k, reason: collision with root package name */
    public String f382224k;

    /* renamed from: l, reason: collision with root package name */
    public String f382225l;

    /* renamed from: m, reason: collision with root package name */
    public Map<Integer, String> f382226m;

    /* renamed from: n, reason: collision with root package name */
    public String f382227n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f382228o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f382229p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f382230q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f382231r;

    /* renamed from: s, reason: collision with root package name */
    public long f382232s;

    /* renamed from: t, reason: collision with root package name */
    public long f382233t;

    /* renamed from: u, reason: collision with root package name */
    public int f382234u;

    /* renamed from: v, reason: collision with root package name */
    public long f382235v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f382236w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f382237x;

    /* renamed from: y, reason: collision with root package name */
    public Set<Integer> f382238y;

    /* renamed from: z, reason: collision with root package name */
    public String f382239z;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class spXPg implements V3a8U {
        static IPatchRedirector $redirector_;

        public spXPg() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.turingcam.V3a8U
        public boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return false;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16754);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            C = new spXPg();
        }
    }

    public fBfpd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f382217d = 0;
        this.f382218e = "";
        this.f382219f = true;
        this.f382220g = null;
        this.f382221h = 10000;
        this.f382222i = "";
        this.f382223j = "";
        this.f382224k = "";
        this.f382225l = "";
        this.f382226m = new HashMap();
        this.f382227n = "";
        this.f382228o = true;
        this.f382229p = false;
        this.f382230q = true;
        this.f382231r = true;
        this.f382232s = 5000L;
        this.f382233t = 60000L;
        this.f382234u = 3;
        this.f382235v = 0L;
        this.f382236w = false;
        this.f382237x = false;
        this.A = false;
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        String[] strArr = this.f382220g;
        if (strArr != null) {
            if (strArr.length == 0) {
                this.f382220g = null;
            } else {
                ArrayList arrayList = new ArrayList();
                for (String str : this.f382220g) {
                    if (str != null && !str.isEmpty()) {
                        arrayList.add(str);
                    }
                }
                this.f382220g = arrayList.isEmpty() ? null : (String[]) arrayList.toArray(new String[0]);
            }
        }
        if (this.f382220g == null) {
            this.f382220g = new String[]{"https://tdid.m.qq.com/tmf"};
        }
        if (this.f382214a == null) {
            if (this.f382221h < 1000) {
                this.f382221h = 10000;
            }
            String[] strArr2 = this.f382220g;
            int i3 = this.f382221h;
            h hVar = new h(strArr2);
            if (strArr2.length > 1) {
                zVR7H.f382476a.submit(new l(hVar, i3));
            }
            this.f382214a = hVar;
            return;
        }
        this.f382236w = true;
    }

    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (TextUtils.isEmpty(this.f382227n)) {
            return "";
        }
        return this.f382227n;
    }

    public final Context c() {
        Context context;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Context) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        synchronized (eh5ma.class) {
            context = eh5ma.f382207a;
        }
        return context;
    }

    public V3a8U d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (V3a8U) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        V3a8U v3a8U = this.f382215b;
        if (v3a8U == null) {
            return C;
        }
        return v3a8U;
    }

    public final void a(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            eh5ma.a(context);
        } else {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) context);
        }
    }
}
