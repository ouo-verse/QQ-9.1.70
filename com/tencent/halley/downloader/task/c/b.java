package com.tencent.halley.downloader.task.c;

import com.tencent.halley.common.utils.j;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public boolean f113856a;

    /* renamed from: b, reason: collision with root package name */
    public long f113857b;

    /* renamed from: c, reason: collision with root package name */
    public long f113858c;

    /* renamed from: d, reason: collision with root package name */
    public int f113859d;

    /* renamed from: e, reason: collision with root package name */
    public long f113860e;

    /* renamed from: f, reason: collision with root package name */
    public List<a> f113861f;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f113862a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f113863b;

        /* renamed from: c, reason: collision with root package name */
        public String f113864c;

        /* renamed from: d, reason: collision with root package name */
        public long f113865d;

        /* renamed from: e, reason: collision with root package name */
        public long f113866e;

        /* renamed from: f, reason: collision with root package name */
        public int f113867f;

        /* renamed from: g, reason: collision with root package name */
        public String f113868g;

        /* renamed from: h, reason: collision with root package name */
        public String f113869h;

        /* renamed from: i, reason: collision with root package name */
        public long f113870i;

        /* renamed from: j, reason: collision with root package name */
        public String f113871j;

        /* renamed from: k, reason: collision with root package name */
        public String f113872k;

        /* renamed from: l, reason: collision with root package name */
        public String f113873l;

        /* renamed from: m, reason: collision with root package name */
        public String f113874m;

        /* renamed from: n, reason: collision with root package name */
        public String f113875n;

        /* renamed from: o, reason: collision with root package name */
        public int f113876o;

        /* renamed from: p, reason: collision with root package name */
        public int f113877p;

        /* renamed from: q, reason: collision with root package name */
        public String f113878q;

        /* renamed from: r, reason: collision with root package name */
        public long f113879r;

        /* renamed from: s, reason: collision with root package name */
        public String f113880s;

        /* renamed from: t, reason: collision with root package name */
        public String f113881t;

        /* renamed from: u, reason: collision with root package name */
        public long f113882u;

        /* renamed from: v, reason: collision with root package name */
        public String f113883v;

        /* renamed from: w, reason: collision with root package name */
        public long f113884w;

        /* renamed from: x, reason: collision with root package name */
        public String f113885x;

        /* renamed from: y, reason: collision with root package name */
        private int f113886y;

        /* renamed from: z, reason: collision with root package name */
        private int f113887z;

        public a(int i3, com.tencent.halley.downloader.task.d.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) aVar);
                return;
            }
            this.f113864c = "";
            this.f113868g = "";
            this.f113869h = "";
            this.f113870i = -1L;
            this.f113871j = "";
            this.f113872k = "";
            this.f113873l = "";
            this.f113874m = "";
            this.f113875n = "";
            this.f113876o = -1;
            this.f113877p = -1;
            this.f113878q = "";
            this.f113880s = "";
            this.f113881t = "";
            this.f113882u = -1L;
            this.f113883v = "";
            this.f113885x = "";
            this.f113862a = i3;
            this.f113886y = aVar.f113892e;
            this.f113887z = aVar.f113891d.ordinal();
        }

        public final String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.f113862a + "," + this.f113886y + "," + this.f113887z + "," + (this.f113863b ? 1 : 0) + "," + j.b(this.f113864c) + "," + this.f113865d + "," + this.f113866e + "," + this.f113867f + "," + j.b(this.f113868g) + "," + this.f113869h + "," + this.f113870i + "," + j.b(this.f113871j) + "," + this.f113872k + "," + j.b("[" + this.f113873l + "]") + "," + j.b(this.f113874m) + "," + j.b("[" + this.f113875n + "]") + "," + this.f113876o + "," + this.f113877p + "," + j.b(this.f113878q) + "," + this.f113879r + "," + this.f113880s + "," + this.f113881t + "," + this.f113882u + "," + this.f113883v + "," + this.f113884w;
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f113859d = 0;
        this.f113860e = 0L;
        this.f113861f = new ArrayList();
    }

    public final void a(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        } else if (this.f113861f.size() < 20) {
            this.f113861f.add(aVar);
        }
    }

    public final String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        StringBuilder sb6 = new StringBuilder();
        sb6.append(!this.f113856a ? 1 : 0);
        sb5.append(sb6.toString());
        sb5.append(",");
        sb5.append(this.f113857b);
        sb5.append(",");
        sb5.append(this.f113858c);
        sb5.append(",");
        sb5.append(this.f113860e);
        sb5.append(",");
        sb5.append(this.f113859d);
        sb5.append(";");
        return sb5.toString();
    }
}
