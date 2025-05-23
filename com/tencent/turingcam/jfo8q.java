package com.tencent.turingcam;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class jfo8q {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final String f382267a;

    /* renamed from: b, reason: collision with root package name */
    public final long f382268b;

    /* renamed from: c, reason: collision with root package name */
    public final int f382269c;

    /* renamed from: d, reason: collision with root package name */
    public final String f382270d;

    /* renamed from: e, reason: collision with root package name */
    public final String f382271e;

    /* renamed from: f, reason: collision with root package name */
    public final String f382272f;

    /* renamed from: g, reason: collision with root package name */
    public final String f382273g;

    /* renamed from: h, reason: collision with root package name */
    public int f382274h;

    /* renamed from: i, reason: collision with root package name */
    public int f382275i;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class spXPg {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f382276a;

        /* renamed from: b, reason: collision with root package name */
        public long f382277b;

        /* renamed from: c, reason: collision with root package name */
        public String f382278c;

        /* renamed from: d, reason: collision with root package name */
        public String f382279d;

        /* renamed from: e, reason: collision with root package name */
        public String f382280e;

        /* renamed from: f, reason: collision with root package name */
        public String f382281f;

        public spXPg(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3);
            }
        }
    }

    public jfo8q(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        this.f382267a = "";
        this.f382268b = 0L;
        this.f382269c = i3;
        this.f382270d = "";
        this.f382271e = "";
        this.f382272f = "";
        this.f382273g = "";
        this.f382274h = i16;
        this.f382275i = i17;
    }

    public static jfo8q a(int i3) {
        return new jfo8q(i3, 0, 0);
    }

    public jfo8q(spXPg spxpg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) spxpg);
            return;
        }
        this.f382274h = 0;
        this.f382275i = 0;
        this.f382267a = spxpg.f382276a;
        this.f382268b = spxpg.f382277b;
        this.f382269c = 0;
        this.f382270d = spxpg.f382278c;
        this.f382271e = spxpg.f382279d;
        this.f382272f = spxpg.f382280e;
        this.f382273g = spxpg.f382281f;
    }
}
