package com.tencent.ams.fusion.service.event.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b implements com.tencent.ams.fusion.service.event.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public boolean f70285a;

    /* renamed from: b, reason: collision with root package name */
    public int f70286b;

    /* renamed from: c, reason: collision with root package name */
    public long f70287c;

    /* renamed from: d, reason: collision with root package name */
    public a f70288d;

    /* renamed from: e, reason: collision with root package name */
    public c f70289e;

    /* renamed from: f, reason: collision with root package name */
    public C0676b f70290f;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f70291a;

        /* renamed from: b, reason: collision with root package name */
        public String f70292b;

        /* renamed from: c, reason: collision with root package name */
        public String f70293c;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "AdInfo{mCl='" + this.f70291a + "', mTraceId='" + this.f70292b + "', displayCode=" + this.f70293c + "'}";
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.ams.fusion.service.event.impl.b$b, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0676b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public long f70294a;

        /* renamed from: b, reason: collision with root package name */
        public int f70295b;

        /* renamed from: c, reason: collision with root package name */
        public String f70296c;

        /* renamed from: d, reason: collision with root package name */
        public int f70297d;

        /* renamed from: e, reason: collision with root package name */
        public Map f70298e;

        public C0676b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "CustomizedInfo{mCostTime=" + this.f70294a + ", mSubCode=" + this.f70295b + ", resUrl=" + this.f70296c + ", resType=" + this.f70297d + ", mReportMap=" + this.f70298e + '}';
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f70299a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f70300b;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "SdkInfo{mPlacementId='" + this.f70299a + "', mIsHotLaunch=" + this.f70300b + '}';
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f70285a = true;
        this.f70288d = new a();
        this.f70289e = new c();
        this.f70290f = new C0676b();
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "ReportEvent{mEventId=" + this.f70286b + ", mErrorCode=" + this.f70287c + ", mCustomizedInfo=" + this.f70290f.toString() + ", mAdInfo=" + this.f70288d.toString() + ", mSdkInfo=" + this.f70289e.toString() + '}';
    }
}
