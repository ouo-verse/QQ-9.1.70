package com.tencent.hlyyb.downloader.e.d;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public boolean f114500a;

    /* renamed from: b, reason: collision with root package name */
    public long f114501b;

    /* renamed from: c, reason: collision with root package name */
    public long f114502c;

    /* renamed from: d, reason: collision with root package name */
    public int f114503d;

    /* renamed from: e, reason: collision with root package name */
    public List<a> f114504e;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f114505a;

        /* renamed from: b, reason: collision with root package name */
        public int f114506b;

        /* renamed from: c, reason: collision with root package name */
        public int f114507c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f114508d;

        /* renamed from: e, reason: collision with root package name */
        public String f114509e;

        /* renamed from: f, reason: collision with root package name */
        public long f114510f;

        /* renamed from: g, reason: collision with root package name */
        public long f114511g;

        /* renamed from: h, reason: collision with root package name */
        public int f114512h;

        /* renamed from: i, reason: collision with root package name */
        public String f114513i;

        /* renamed from: j, reason: collision with root package name */
        public String f114514j;

        /* renamed from: k, reason: collision with root package name */
        public long f114515k;

        /* renamed from: l, reason: collision with root package name */
        public String f114516l;

        /* renamed from: m, reason: collision with root package name */
        public String f114517m;

        /* renamed from: n, reason: collision with root package name */
        public String f114518n;

        /* renamed from: o, reason: collision with root package name */
        public String f114519o;

        /* renamed from: p, reason: collision with root package name */
        public String f114520p;

        /* renamed from: q, reason: collision with root package name */
        public int f114521q;

        /* renamed from: r, reason: collision with root package name */
        public int f114522r;

        /* renamed from: s, reason: collision with root package name */
        public String f114523s;

        /* renamed from: t, reason: collision with root package name */
        public long f114524t;

        /* renamed from: u, reason: collision with root package name */
        public String f114525u;

        /* renamed from: v, reason: collision with root package name */
        public String f114526v;

        public a(int i3, com.tencent.hlyyb.downloader.e.f.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) aVar);
                return;
            }
            this.f114509e = "";
            this.f114513i = "";
            this.f114514j = "";
            this.f114515k = -1L;
            this.f114516l = "";
            this.f114517m = "";
            this.f114518n = "";
            this.f114519o = "";
            this.f114520p = "";
            this.f114521q = -1;
            this.f114522r = -1;
            this.f114523s = "";
            this.f114525u = "";
            this.f114526v = "";
            this.f114505a = i3;
            this.f114506b = aVar.f114533c;
            this.f114507c = aVar.f114532b - 1;
        }

        public final String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.f114505a + "," + this.f114506b + "," + this.f114507c + "," + (this.f114508d ? 1 : 0) + "," + com.tencent.hlyyb.common.b.b.b(this.f114509e) + "," + this.f114510f + "," + this.f114511g + "," + this.f114512h + "," + com.tencent.hlyyb.common.b.b.b(this.f114513i) + "," + this.f114514j + "," + this.f114515k + "," + com.tencent.hlyyb.common.b.b.b(this.f114516l) + "," + this.f114517m + "," + com.tencent.hlyyb.common.b.b.b("[" + this.f114518n + "]") + "," + com.tencent.hlyyb.common.b.b.b(this.f114519o) + "," + com.tencent.hlyyb.common.b.b.b("[" + this.f114520p + "]") + "," + this.f114521q + "," + this.f114522r + "," + com.tencent.hlyyb.common.b.b.b(this.f114523s) + "," + this.f114524t + "," + this.f114525u + "," + this.f114526v;
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f114503d = 0;
            this.f114504e = new ArrayList();
        }
    }

    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        Iterator<a> it = this.f114504e.iterator();
        while (it.hasNext()) {
            sb5.append(it.next());
            sb5.append(";");
        }
        return sb5.toString();
    }

    public final String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        StringBuilder sb6 = new StringBuilder();
        sb6.append(!this.f114500a ? 1 : 0);
        sb5.append(sb6.toString());
        sb5.append(",");
        sb5.append(this.f114501b);
        sb5.append(",");
        sb5.append(this.f114502c);
        sb5.append(",");
        sb5.append(this.f114503d);
        sb5.append(";");
        return sb5.toString();
    }

    public final void a(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        } else if (this.f114504e.size() < 20) {
            this.f114504e.add(aVar);
        }
    }
}
