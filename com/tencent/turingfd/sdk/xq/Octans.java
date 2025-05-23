package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Octans implements Cygnus {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f382947a;

    /* renamed from: b, reason: collision with root package name */
    public final long f382948b;

    /* renamed from: c, reason: collision with root package name */
    public final String f382949c;

    /* renamed from: d, reason: collision with root package name */
    public final int f382950d;

    /* renamed from: e, reason: collision with root package name */
    public final int f382951e;

    /* renamed from: f, reason: collision with root package name */
    public final String f382952f;

    /* renamed from: g, reason: collision with root package name */
    public final String f382953g;

    /* renamed from: h, reason: collision with root package name */
    public final String f382954h;

    /* renamed from: i, reason: collision with root package name */
    public final String f382955i;

    /* renamed from: j, reason: collision with root package name */
    public final String f382956j;

    /* compiled from: P */
    /* renamed from: com.tencent.turingfd.sdk.xq.Octans$do, reason: invalid class name */
    /* loaded from: classes27.dex */
    public static final class Cdo {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public boolean f382957a;

        /* renamed from: b, reason: collision with root package name */
        public long f382958b;

        /* renamed from: c, reason: collision with root package name */
        public String f382959c;

        /* renamed from: d, reason: collision with root package name */
        public int f382960d;

        /* renamed from: e, reason: collision with root package name */
        public int f382961e;

        /* renamed from: f, reason: collision with root package name */
        public String f382962f;

        /* renamed from: g, reason: collision with root package name */
        public String f382963g;

        /* renamed from: h, reason: collision with root package name */
        public String f382964h;

        /* renamed from: i, reason: collision with root package name */
        public String f382965i;

        /* renamed from: j, reason: collision with root package name */
        public String f382966j;

        public Cdo(boolean z16, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), Long.valueOf(j3));
            } else {
                this.f382957a = z16;
                this.f382958b = j3;
            }
        }
    }

    public Octans(Cdo cdo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) cdo);
            return;
        }
        this.f382947a = cdo.f382957a;
        this.f382948b = cdo.f382958b;
        this.f382949c = cdo.f382959c;
        this.f382950d = cdo.f382960d;
        this.f382951e = cdo.f382961e;
        this.f382952f = cdo.f382962f;
        this.f382953g = cdo.f382963g;
        this.f382954h = cdo.f382964h;
        this.f382955i = cdo.f382965i;
        this.f382956j = cdo.f382966j;
    }

    @Override // com.tencent.turingfd.sdk.xq.Cygnus
    public long getErrorCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return this.f382948b;
    }

    @Override // com.tencent.turingfd.sdk.xq.Cygnus
    public String getFileMd5() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.f382954h;
    }

    @Override // com.tencent.turingfd.sdk.xq.Cygnus
    public String getFileName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.f382955i;
    }

    @Override // com.tencent.turingfd.sdk.xq.Cygnus
    public String getFileSha1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.f382953g;
    }

    @Override // com.tencent.turingfd.sdk.xq.Cygnus
    public String getHandleUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.f382952f;
    }

    @Override // com.tencent.turingfd.sdk.xq.Cygnus
    public String getPkgName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f382949c;
    }

    @Override // com.tencent.turingfd.sdk.xq.Cygnus
    public int getRiskCategory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.f382951e;
    }

    @Override // com.tencent.turingfd.sdk.xq.Cygnus
    public String getRiskTips() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.f382956j;
    }

    @Override // com.tencent.turingfd.sdk.xq.Cygnus
    public int getSafeLevel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.f382950d;
    }

    @Override // com.tencent.turingfd.sdk.xq.Cygnus
    public boolean isSucceed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.f382947a;
    }
}
