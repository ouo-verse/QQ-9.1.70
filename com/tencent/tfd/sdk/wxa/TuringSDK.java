package com.tencent.tfd.sdk.wxa;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class TuringSDK extends Bryony {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static final class Builder {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public Context f375712a;

        /* renamed from: b, reason: collision with root package name */
        public String f375713b;

        /* renamed from: c, reason: collision with root package name */
        public int f375714c;

        /* renamed from: d, reason: collision with root package name */
        public long f375715d;

        /* renamed from: e, reason: collision with root package name */
        public int f375716e;

        /* renamed from: f, reason: collision with root package name */
        public String f375717f;

        /* renamed from: g, reason: collision with root package name */
        public String f375718g;

        /* renamed from: h, reason: collision with root package name */
        public int f375719h;

        /* renamed from: i, reason: collision with root package name */
        public String f375720i;

        /* renamed from: j, reason: collision with root package name */
        public int f375721j;

        /* renamed from: k, reason: collision with root package name */
        public boolean f375722k;

        /* renamed from: l, reason: collision with root package name */
        public Map<Integer, String> f375723l;

        /* renamed from: m, reason: collision with root package name */
        public boolean f375724m;

        /* renamed from: n, reason: collision with root package name */
        public String f375725n;

        /* renamed from: o, reason: collision with root package name */
        public String f375726o;

        /* renamed from: p, reason: collision with root package name */
        public boolean f375727p;

        /* renamed from: q, reason: collision with root package name */
        public String f375728q;

        /* renamed from: r, reason: collision with root package name */
        public boolean f375729r;

        /* renamed from: s, reason: collision with root package name */
        public boolean f375730s;

        /* renamed from: t, reason: collision with root package name */
        public boolean f375731t;

        /* renamed from: u, reason: collision with root package name */
        public ITuringPrivacyPolicy f375732u;

        /* renamed from: v, reason: collision with root package name */
        public ITuringDeviceInfoProvider f375733v;

        /* renamed from: w, reason: collision with root package name */
        public ITuringPkgProvider f375734w;

        /* renamed from: x, reason: collision with root package name */
        public ITuringIoTFeatureMap f375735x;

        /* renamed from: y, reason: collision with root package name */
        public boolean f375736y;

        /* renamed from: z, reason: collision with root package name */
        public boolean f375737z;

        public Builder(Context context, ITuringPrivacyPolicy iTuringPrivacyPolicy) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) iTuringPrivacyPolicy);
                return;
            }
            this.f375713b = "";
            this.f375714c = 5000;
            this.f375715d = 60000L;
            this.f375716e = 3;
            this.f375717f = "";
            this.f375718g = "";
            this.f375719h = 0;
            this.f375720i = "";
            this.f375721j = 0;
            this.f375722k = true;
            this.f375723l = new HashMap();
            this.f375724m = true;
            this.f375725n = "";
            this.f375726o = "";
            this.f375727p = true;
            this.f375728q = "turingfd.cert";
            this.f375729r = true;
            this.f375730s = false;
            this.f375731t = true;
            this.f375736y = false;
            this.f375737z = false;
            this.f375712a = context.getApplicationContext();
            this.f375732u = iTuringPrivacyPolicy;
        }

        public final Builder appid(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (Builder) iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
            }
            this.f375725n = str;
            return this;
        }

        public final Builder autoRequestBg(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                return (Builder) iPatchRedirector.redirect((short) 17, (Object) this, z16);
            }
            this.f375729r = z16;
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
            this.f375728q = str;
            return this;
        }

        public final Builder channel(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (Builder) iPatchRedirector.redirect((short) 11, (Object) this, i3);
            }
            this.f375721j = i3;
            return this;
        }

        public final Builder clientBuildNo(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Builder) iPatchRedirector.redirect((short) 5, (Object) this, i3);
            }
            this.f375719h = i3;
            return this;
        }

        public final Builder clientChannel(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Builder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            }
            this.f375717f = str;
            return this;
        }

        public final Builder clientLc(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Builder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            }
            this.f375720i = str;
            return this;
        }

        public final Builder clientMetaDataMap(Map<Integer, String> map) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (Builder) iPatchRedirector.redirect((short) 7, (Object) this, (Object) map);
            }
            this.f375723l = map;
            return this;
        }

        public final Builder clientVersion(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Builder) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            }
            this.f375718g = str;
            return this;
        }

        public final Builder enableClickRisk() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
                return (Builder) iPatchRedirector.redirect((short) 25, (Object) this);
            }
            this.f375737z = true;
            return this;
        }

        public final Builder forceReqServiceEveryTime(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                return (Builder) iPatchRedirector.redirect((short) 18, (Object) this, z16);
            }
            this.f375730s = z16;
            return this;
        }

        public final Builder initNetwork(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                return (Builder) iPatchRedirector.redirect((short) 19, (Object) this, z16);
            }
            this.f375731t = z16;
            return this;
        }

        public final Builder loadLibrary(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (Builder) iPatchRedirector.redirect((short) 12, (Object) this, z16);
            }
            this.f375724m = z16;
            return this;
        }

        public final Builder phyFeature(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return (Builder) iPatchRedirector.redirect((short) 15, (Object) this, z16);
            }
            this.f375727p = z16;
            return this;
        }

        public final Builder pkgInfo(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
                return (Builder) iPatchRedirector.redirect((short) 20, (Object) this, z16);
            }
            this.f375722k = z16;
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
            this.f375716e = i16;
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
            this.f375715d = i3;
            return this;
        }

        public final Builder soFilePath(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (Builder) iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
            }
            this.f375726o = str;
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
            this.f375714c = i3;
            return this;
        }

        public final Builder turingDeviceInfoProvider(ITuringDeviceInfoProvider iTuringDeviceInfoProvider) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
                return (Builder) iPatchRedirector.redirect((short) 21, (Object) this, (Object) iTuringDeviceInfoProvider);
            }
            this.f375733v = iTuringDeviceInfoProvider;
            return this;
        }

        public final Builder turingIoTFeatureMap(ITuringIoTFeatureMap iTuringIoTFeatureMap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
                return (Builder) iPatchRedirector.redirect((short) 23, (Object) this, (Object) iTuringIoTFeatureMap);
            }
            this.f375735x = iTuringIoTFeatureMap;
            return this;
        }

        public final Builder turingPkgProvider(ITuringPkgProvider iTuringPkgProvider) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
                return (Builder) iPatchRedirector.redirect((short) 22, (Object) this, (Object) iTuringPkgProvider);
            }
            this.f375734w = iTuringPkgProvider;
            return this;
        }

        public final Builder tvOS(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
                return (Builder) iPatchRedirector.redirect((short) 24, (Object) this, z16);
            }
            this.f375736y = z16;
            return this;
        }

        public final Builder uniqueId(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Builder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
            this.f375713b = str;
            return this;
        }
    }

    public TuringSDK(Builder builder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) builder);
            return;
        }
        this.f375463f = builder.f375712a;
        this.f375465h = builder.f375713b;
        this.f375481x = builder.f375714c;
        this.f375482y = builder.f375715d;
        this.f375483z = builder.f375716e;
        this.f375470m = builder.f375718g;
        this.f375469l = builder.f375717f;
        this.f375471n = builder.f375719h;
        this.f375472o = builder.f375720i;
        this.f375473p = builder.f375723l;
        this.f375464g = builder.f375721j;
        this.f375466i = builder.f375724m;
        this.f375474q = builder.f375725n;
        this.f375468k = builder.f375726o;
        this.f375477t = builder.f375727p;
        String unused = builder.f375728q;
        this.f375475r = builder.f375729r;
        this.f375476s = builder.f375730s;
        this.f375479v = builder.f375731t;
        this.f375459b = builder.f375732u;
        this.f375478u = builder.f375722k;
        this.f375460c = builder.f375733v;
        this.f375461d = builder.f375734w;
        this.f375462e = builder.f375735x;
        this.f375480w = builder.f375736y;
        this.C = builder.f375737z;
        a();
    }

    public static Builder createConf(Context context, ITuringPrivacyPolicy iTuringPrivacyPolicy) {
        return new Builder(context, iTuringPrivacyPolicy);
    }

    public static String getVersionInfo() {
        return Filbert.b();
    }

    public int init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        Filbert.f375613e = this;
        Cgoto.a(this.f375463f);
        AtomicBoolean atomicBoolean = Filbert.f375612d;
        if (atomicBoolean.get()) {
            return 0;
        }
        Log.i("TuringFdJava", Filbert.b());
        synchronized (Filbert.f375611c) {
            int i3 = this.f375464g;
            if (i3 > 0) {
                UrsaMinor.f375742a = i3;
            }
            UrsaMinor.f375743b = this.C;
            AtomicReference<String> atomicReference = Creturn.f375771a;
            if (!TextUtils.isEmpty(null)) {
                AtomicReference<String> atomicReference2 = Creturn.f375771a;
                synchronized (atomicReference2) {
                    atomicReference2.set(null);
                }
            }
            AtomicBoolean atomicBoolean2 = Filbert.f375610b;
            if (atomicBoolean2.get()) {
                Filbert.a(this);
                return 0;
            }
            if (atomicBoolean.get()) {
                return 0;
            }
            atomicBoolean.set(true);
            System.currentTimeMillis();
            int b16 = Filbert.b(this);
            if (b16 != 0) {
                atomicBoolean2.set(false);
            } else {
                b16 = Filbert.c(this);
                if (b16 != 0) {
                    atomicBoolean2.set(false);
                } else {
                    if (UrsaMinor.f375742a == 0) {
                        Log.e("TuringFdJava", "pleace input valid channel !");
                        atomicBoolean2.set(false);
                        return -10018;
                    }
                    Cumquat.f375573b.f375574a = this;
                    Filbert.a(this);
                    atomicBoolean2.set(true);
                    atomicBoolean.set(false);
                    return 0;
                }
            }
            return b16;
        }
    }
}
