package com.tencent.turingcam;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.turingface.sdk.mfa.d;
import com.tencent.turingface.sdk.mfa.e;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class F26wG extends fBfpd {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class spXPg {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public Context f381798a;

        /* renamed from: b, reason: collision with root package name */
        public int f381799b;

        /* renamed from: c, reason: collision with root package name */
        public Map<Integer, String> f381800c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f381801d;

        /* renamed from: e, reason: collision with root package name */
        public String f381802e;

        /* renamed from: f, reason: collision with root package name */
        public String f381803f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f381804g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f381805h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f381806i;

        /* renamed from: j, reason: collision with root package name */
        public QafBz f381807j;

        /* renamed from: k, reason: collision with root package name */
        public d f381808k;

        /* renamed from: l, reason: collision with root package name */
        public boolean f381809l;

        /* renamed from: m, reason: collision with root package name */
        public String[] f381810m;

        /* renamed from: n, reason: collision with root package name */
        public e f381811n;

        /* renamed from: o, reason: collision with root package name */
        public long f381812o;

        /* renamed from: p, reason: collision with root package name */
        public Set<Integer> f381813p;

        /* renamed from: q, reason: collision with root package name */
        public String f381814q;

        /* renamed from: r, reason: collision with root package name */
        public boolean f381815r;

        public spXPg(Context context, QafBz qafBz) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) qafBz);
                return;
            }
            this.f381799b = 0;
            this.f381800c = new HashMap();
            this.f381801d = true;
            this.f381802e = "";
            this.f381803f = "";
            this.f381804g = true;
            this.f381805h = true;
            this.f381806i = true;
            this.f381809l = false;
            this.f381810m = null;
            this.f381811n = null;
            this.f381815r = false;
            this.f381798a = context.getApplicationContext();
            this.f381807j = qafBz;
        }
    }

    public F26wG(spXPg spxpg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) spxpg);
            return;
        }
        a(spxpg.f381798a);
        this.f382218e = "";
        this.f382232s = 5000;
        this.f382233t = 60000L;
        this.f382234u = 3;
        this.f382224k = "";
        this.f382223j = "";
        this.f382225l = "";
        this.f382226m = spxpg.f381800c;
        this.f382217d = spxpg.f381799b;
        this.f382219f = spxpg.f381801d;
        this.f382227n = spxpg.f381802e;
        this.f382222i = spxpg.f381803f;
        this.f382230q = spxpg.f381804g;
        this.f382228o = spxpg.f381805h;
        this.f382229p = false;
        this.f382231r = spxpg.f381806i;
        this.f382215b = spxpg.f381807j;
        this.f382216c = spxpg.f381808k;
        this.f382237x = spxpg.f381809l;
        this.f382220g = spxpg.f381810m;
        this.f382214a = spxpg.f381811n;
        this.f382235v = spxpg.f381812o;
        this.f382238y = spxpg.f381813p;
        this.f382239z = spxpg.f381814q;
        this.A = spxpg.f381815r;
        a();
    }
}
