package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class TuringSDK extends Strawberry {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class Builder {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public Context f383143a;

        /* renamed from: b, reason: collision with root package name */
        public String f383144b;

        /* renamed from: c, reason: collision with root package name */
        public int f383145c;

        /* renamed from: d, reason: collision with root package name */
        public long f383146d;

        /* renamed from: e, reason: collision with root package name */
        public int f383147e;

        /* renamed from: f, reason: collision with root package name */
        public String f383148f;

        /* renamed from: g, reason: collision with root package name */
        public String f383149g;

        /* renamed from: h, reason: collision with root package name */
        public int f383150h;

        /* renamed from: i, reason: collision with root package name */
        public String f383151i;

        /* renamed from: j, reason: collision with root package name */
        public int f383152j;

        /* renamed from: k, reason: collision with root package name */
        public Map<Integer, String> f383153k;

        /* renamed from: l, reason: collision with root package name */
        public boolean f383154l;

        /* renamed from: m, reason: collision with root package name */
        public String f383155m;

        /* renamed from: n, reason: collision with root package name */
        public String f383156n;

        /* renamed from: o, reason: collision with root package name */
        public boolean f383157o;

        /* renamed from: p, reason: collision with root package name */
        public String f383158p;

        /* renamed from: q, reason: collision with root package name */
        public boolean f383159q;

        /* renamed from: r, reason: collision with root package name */
        public boolean f383160r;

        /* renamed from: s, reason: collision with root package name */
        public boolean f383161s;

        /* renamed from: t, reason: collision with root package name */
        public ITuringPrivacyPolicy f383162t;

        /* renamed from: u, reason: collision with root package name */
        public ITuringDeviceInfoProvider f383163u;

        /* renamed from: v, reason: collision with root package name */
        public ITuringPkgProvider f383164v;

        /* renamed from: w, reason: collision with root package name */
        public ITuringIoTFeatureMap f383165w;

        /* renamed from: x, reason: collision with root package name */
        public boolean f383166x;

        /* renamed from: y, reason: collision with root package name */
        public boolean f383167y;

        /* renamed from: z, reason: collision with root package name */
        public boolean f383168z;

        public Builder(Context context, ITuringPrivacyPolicy iTuringPrivacyPolicy) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) iTuringPrivacyPolicy);
                return;
            }
            this.f383144b = "";
            this.f383145c = 5000;
            this.f383146d = 60000L;
            this.f383147e = 3;
            this.f383148f = "";
            this.f383149g = "";
            this.f383150h = 0;
            this.f383151i = "";
            this.f383152j = 0;
            this.f383153k = new HashMap();
            this.f383154l = true;
            this.f383155m = "";
            this.f383156n = "";
            this.f383157o = true;
            this.f383158p = "turingfd.cert";
            this.f383159q = true;
            this.f383160r = false;
            this.f383161s = true;
            this.f383166x = false;
            this.f383167y = false;
            this.f383168z = false;
            this.f383143a = context.getApplicationContext();
            this.f383162t = iTuringPrivacyPolicy;
        }

        public final Builder appid(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (Builder) iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
            }
            this.f383155m = str;
            return this;
        }

        public final Builder autoRequestBg(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                return (Builder) iPatchRedirector.redirect((short) 17, (Object) this, z16);
            }
            this.f383159q = z16;
            return this;
        }

        public final TuringSDK build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
                return (TuringSDK) iPatchRedirector.redirect((short) 26, (Object) this);
            }
            return new TuringSDK(this);
        }

        public final Builder certFileName(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return (Builder) iPatchRedirector.redirect((short) 16, (Object) this, (Object) str);
            }
            this.f383158p = str;
            return this;
        }

        public final Builder channel(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (Builder) iPatchRedirector.redirect((short) 11, (Object) this, i3);
            }
            this.f383152j = i3;
            return this;
        }

        public final Builder clientBuildNo(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Builder) iPatchRedirector.redirect((short) 5, (Object) this, i3);
            }
            this.f383150h = i3;
            return this;
        }

        public final Builder clientChannel(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Builder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            }
            this.f383148f = str;
            return this;
        }

        public final Builder clientLc(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Builder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            }
            this.f383151i = str;
            return this;
        }

        public final Builder clientMetaDataMap(Map<Integer, String> map) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (Builder) iPatchRedirector.redirect((short) 7, (Object) this, (Object) map);
            }
            this.f383153k = map;
            return this;
        }

        public final Builder clientVersion(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Builder) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            }
            this.f383149g = str;
            return this;
        }

        public final Builder enableClickRisk() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
                return (Builder) iPatchRedirector.redirect((short) 24, (Object) this);
            }
            this.f383167y = true;
            return this;
        }

        public final Builder enableDRM() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
                return (Builder) iPatchRedirector.redirect((short) 25, (Object) this);
            }
            this.f383168z = true;
            return this;
        }

        public final Builder forceReqServiceEveryTime(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                return (Builder) iPatchRedirector.redirect((short) 18, (Object) this, z16);
            }
            this.f383160r = z16;
            return this;
        }

        public final Builder initNetwork(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                return (Builder) iPatchRedirector.redirect((short) 19, (Object) this, z16);
            }
            this.f383161s = z16;
            return this;
        }

        public final Builder loadLibrary(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (Builder) iPatchRedirector.redirect((short) 12, (Object) this, z16);
            }
            this.f383154l = z16;
            return this;
        }

        public final Builder phyFeature(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return (Builder) iPatchRedirector.redirect((short) 15, (Object) this, z16);
            }
            this.f383157o = z16;
            return this;
        }

        public final Builder retryTime(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            int i16 = 10;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (Builder) iPatchRedirector.redirect((short) 10, (Object) this, i3);
            }
            if (i3 < 1) {
                i3 = 1;
            }
            if (i3 <= 10) {
                i16 = i3;
            }
            this.f383147e = i16;
            return this;
        }

        public final Builder riskDetectTimeout(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (Builder) iPatchRedirector.redirect((short) 9, (Object) this, i3);
            }
            if (i3 < 100) {
                i3 = 100;
            }
            if (i3 > 60000) {
                i3 = 60000;
            }
            this.f383146d = i3;
            return this;
        }

        public final Builder soFilePath(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (Builder) iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
            }
            this.f383156n = str;
            return this;
        }

        public final Builder timeout(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (Builder) iPatchRedirector.redirect((short) 8, (Object) this, i3);
            }
            if (i3 < 100) {
                i3 = 100;
            }
            if (i3 > 60000) {
                i3 = 60000;
            }
            this.f383145c = i3;
            return this;
        }

        public final Builder turingDeviceInfoProvider(ITuringDeviceInfoProvider iTuringDeviceInfoProvider) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
                return (Builder) iPatchRedirector.redirect((short) 20, (Object) this, (Object) iTuringDeviceInfoProvider);
            }
            this.f383163u = iTuringDeviceInfoProvider;
            return this;
        }

        public final Builder turingIoTFeatureMap(ITuringIoTFeatureMap iTuringIoTFeatureMap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
                return (Builder) iPatchRedirector.redirect((short) 22, (Object) this, (Object) iTuringIoTFeatureMap);
            }
            this.f383165w = iTuringIoTFeatureMap;
            return this;
        }

        public final Builder turingPkgProvider(ITuringPkgProvider iTuringPkgProvider) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
                return (Builder) iPatchRedirector.redirect((short) 21, (Object) this, (Object) iTuringPkgProvider);
            }
            this.f383164v = iTuringPkgProvider;
            return this;
        }

        public final Builder tvOS(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
                return (Builder) iPatchRedirector.redirect((short) 23, (Object) this, z16);
            }
            this.f383166x = z16;
            return this;
        }

        public final Builder uniqueId(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Builder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
            this.f383144b = str;
            return this;
        }
    }

    public TuringSDK(Builder builder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) builder);
            return;
        }
        a(builder.f383143a);
        this.f383085g = builder.f383144b;
        this.f383101w = builder.f383145c;
        this.f383102x = builder.f383146d;
        this.f383103y = builder.f383147e;
        this.f383091m = builder.f383149g;
        this.f383090l = builder.f383148f;
        this.f383092n = builder.f383150h;
        this.f383093o = builder.f383151i;
        this.f383094p = builder.f383153k;
        this.f383084f = builder.f383152j;
        this.f383086h = builder.f383154l;
        this.f383095q = builder.f383155m;
        this.f383089k = builder.f383156n;
        this.f383098t = builder.f383157o;
        String unused = builder.f383158p;
        this.f383096r = builder.f383159q;
        this.f383097s = builder.f383160r;
        this.f383099u = builder.f383161s;
        this.f383080b = builder.f383162t;
        this.f383081c = builder.f383163u;
        this.f383082d = builder.f383164v;
        this.f383083e = builder.f383165w;
        this.f383100v = builder.f383166x;
        this.A = builder.f383167y;
        this.B = builder.f383168z;
        a();
    }

    public static Builder createConf(Context context, ITuringPrivacyPolicy iTuringPrivacyPolicy) {
        return new Builder(context, iTuringPrivacyPolicy);
    }

    public static String getVersionInfo() {
        return i.b();
    }

    public int init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        AtomicBoolean atomicBoolean = i.f383365b;
        synchronized (atomicBoolean) {
            if (atomicBoolean.get()) {
                return 0;
            }
            if (Build.VERSION.SDK_INT == 23) {
                String a16 = Plum.a("M String fixed1".getBytes(), "UTF-8");
                if (a16 == null) {
                    a16 = "M String fixed1 failed";
                }
                Log.i("TuringFdJava", a16);
                String a17 = Plum.a("M String fixed2".getBytes(), null);
                if (a17 == null) {
                    a17 = "M String fixed2 failed";
                }
                Log.i("TuringFdJava", a17);
            }
            int i3 = this.f383084f;
            if (i3 > 0) {
                Nectarine.f382928a = i3;
            }
            if (Nectarine.f382928a == 0) {
                Log.e("TuringFdJava", "please input valid channel!");
                return -10018;
            }
            Nectarine.f382929b = this.A;
            synchronized (Strawberry.class) {
                Strawberry.C = this;
            }
            Log.i("TuringFdJava", i.b());
            AtomicReference<String> atomicReference = Cprivate.f383415a;
            if (!TextUtils.isEmpty(null)) {
                AtomicReference<String> atomicReference2 = Cprivate.f383415a;
                synchronized (atomicReference2) {
                    atomicReference2.set(null);
                }
            }
            System.currentTimeMillis();
            int b16 = i.b(this);
            if (b16 == 0) {
                b16 = i.c(this);
                if (b16 == 0) {
                    Wild.f383217b.f383218a = this;
                    i.a(this);
                    atomicBoolean.set(true);
                    return 0;
                }
            }
            return b16;
        }
    }
}
