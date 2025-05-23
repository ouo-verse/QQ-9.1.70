package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Rambutan {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public long f383044a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f383045b;

    /* renamed from: c, reason: collision with root package name */
    public int f383046c;

    /* renamed from: d, reason: collision with root package name */
    public long f383047d;

    /* renamed from: e, reason: collision with root package name */
    public long f383048e;

    /* renamed from: f, reason: collision with root package name */
    public int f383049f;

    /* renamed from: g, reason: collision with root package name */
    public int f383050g;

    /* compiled from: P */
    /* renamed from: com.tencent.turingfd.sdk.xq.Rambutan$do, reason: invalid class name */
    /* loaded from: classes27.dex */
    public static final class Cdo {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public boolean f383051a;

        /* renamed from: b, reason: collision with root package name */
        public int f383052b;

        /* renamed from: c, reason: collision with root package name */
        public long f383053c;

        /* renamed from: d, reason: collision with root package name */
        public long f383054d;

        /* renamed from: e, reason: collision with root package name */
        public int f383055e;

        /* renamed from: f, reason: collision with root package name */
        public int f383056f;

        public Cdo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f383051a = true;
            this.f383052b = -1;
            this.f383053c = -1L;
            this.f383054d = -1L;
            this.f383055e = 0;
            this.f383056f = 0;
        }

        public static /* synthetic */ long a(Cdo cdo) {
            cdo.getClass();
            return -1L;
        }
    }

    public Rambutan(Cdo cdo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) cdo);
            return;
        }
        Cdo.a(cdo);
        this.f383044a = -1L;
        this.f383045b = cdo.f383051a;
        this.f383046c = cdo.f383052b;
        this.f383047d = cdo.f383053c;
        this.f383048e = cdo.f383054d;
        this.f383050g = cdo.f383056f;
        this.f383049f = cdo.f383055e;
    }
}
