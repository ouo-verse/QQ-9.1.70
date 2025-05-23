package com.tencent.tfd.sdk.wxa;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class Cantaloupe implements Cimplements {
    static IPatchRedirector $redirector_;

    /* renamed from: j, reason: collision with root package name */
    public static final byte[] f375494j;

    /* renamed from: a, reason: collision with root package name */
    public final String f375495a;

    /* renamed from: b, reason: collision with root package name */
    public final long f375496b;

    /* renamed from: c, reason: collision with root package name */
    public final int f375497c;

    /* renamed from: d, reason: collision with root package name */
    public final String f375498d;

    /* renamed from: e, reason: collision with root package name */
    public final String f375499e;

    /* renamed from: f, reason: collision with root package name */
    public final String f375500f;

    /* renamed from: g, reason: collision with root package name */
    public final String f375501g;

    /* renamed from: h, reason: collision with root package name */
    public int f375502h;

    /* renamed from: i, reason: collision with root package name */
    public int f375503i;

    /* compiled from: P */
    /* renamed from: com.tencent.tfd.sdk.wxa.Cantaloupe$do, reason: invalid class name */
    /* loaded from: classes26.dex */
    public static final class Cdo {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f375504a;

        /* renamed from: b, reason: collision with root package name */
        public long f375505b;

        /* renamed from: c, reason: collision with root package name */
        public int f375506c;

        /* renamed from: d, reason: collision with root package name */
        public String f375507d;

        /* renamed from: e, reason: collision with root package name */
        public String f375508e;

        /* renamed from: f, reason: collision with root package name */
        public String f375509f;

        /* renamed from: g, reason: collision with root package name */
        public String f375510g;

        public Cdo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f375506c = 0;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62467);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f375494j = new byte[0];
        }
    }

    public Cantaloupe(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        this.f375495a = "";
        this.f375496b = 0L;
        this.f375497c = i3;
        this.f375498d = "";
        this.f375499e = "";
        this.f375500f = "";
        this.f375501g = "";
        this.f375502h = i16;
        this.f375503i = i17;
    }

    public static Cantaloupe a(int i3) {
        return new Cantaloupe(i3, 0, 0);
    }

    public Cantaloupe(Cdo cdo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) cdo);
            return;
        }
        this.f375502h = 0;
        this.f375503i = 0;
        this.f375495a = cdo.f375504a;
        this.f375496b = cdo.f375505b;
        this.f375497c = cdo.f375506c;
        this.f375498d = cdo.f375507d;
        this.f375499e = cdo.f375508e;
        this.f375500f = cdo.f375509f;
        this.f375501g = cdo.f375510g;
    }
}
