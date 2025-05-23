package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import android.content.res.Resources;
import android.media.MediaDrm;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.qzone.proxy.personalitycomponent.adapter.PersonalityConfig;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.turingfd.sdk.xq.Arbutus;
import com.tencent.turingfd.sdk.xq.Cassiopeia;
import com.tencent.turingfd.sdk.xq.Guava;
import com.tencent.turingfd.sdk.xq.Sultana;
import cooperation.qzone.util.WnsError;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Vermillion {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name */
    public static final String f383177i;

    /* renamed from: j, reason: collision with root package name */
    public static final String f383178j;

    /* renamed from: k, reason: collision with root package name */
    public static final String f383179k;

    /* renamed from: l, reason: collision with root package name */
    public static final Vermillion f383180l;

    /* renamed from: m, reason: collision with root package name */
    public static final long f383181m;

    /* renamed from: n, reason: collision with root package name */
    public static final int[] f383182n;

    /* renamed from: a, reason: collision with root package name */
    public Strawberry f383183a;

    /* renamed from: b, reason: collision with root package name */
    public Handler f383184b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f383185c;

    /* renamed from: d, reason: collision with root package name */
    public Walnut f383186d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f383187e;

    /* renamed from: f, reason: collision with root package name */
    public final AtomicReference<Sultana> f383188f;

    /* renamed from: g, reason: collision with root package name */
    public final AtomicReference<Boolean> f383189g;

    /* renamed from: h, reason: collision with root package name */
    public final AtomicReference<FutureTask<Cassiopeia.Cdo>> f383190h;

    /* compiled from: P */
    /* renamed from: com.tencent.turingfd.sdk.xq.Vermillion$do, reason: invalid class name */
    /* loaded from: classes27.dex */
    public class Cdo extends Handler {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public Context f383191a;

        public Cdo(Looper looper, Context context) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Vermillion.this, looper, context);
            } else {
                this.f383191a = context;
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            System.currentTimeMillis();
            int i3 = message.what;
            if (i3 != 1) {
                if (i3 == 2) {
                    Vermillion.this.a(Vermillion.this.a(this.f383191a, true, false, ((Integer) message.obj).intValue()), false);
                    synchronized (Vermillion.this.f383189g) {
                        Vermillion.this.f383189g.set(Boolean.FALSE);
                        Vermillion.this.f383189g.notifyAll();
                    }
                    return;
                }
                return;
            }
            Vermillion.this.a(this.f383191a, true, 3);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13298);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f383177i = Ccontinue.a(Ccontinue.f383257c1);
        f383178j = Ccontinue.a(Ccontinue.f383260d1);
        f383179k = Ccontinue.a(Ccontinue.f383263e1);
        f383180l = new Vermillion();
        f383181m = TimeUnit.MINUTES.toMillis(30L);
        f383182n = new int[]{0, 15, 30, 90, 240, 360, 600, 1200, WnsError.WNS_CODE_DIS_STAT_BEGIN, com.tencent.mobileqq.msf.core.c0.g.T0, 4800, 7200};
    }

    public Vermillion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f383185c = false;
        this.f383187e = new Object();
        this.f383188f = new AtomicReference<>(null);
        this.f383189g = new AtomicReference<>(Boolean.FALSE);
        this.f383190h = new AtomicReference<>(null);
    }

    /* JADX WARN: Removed duplicated region for block: B:97:0x0195  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(Vermillion vermillion) {
        Context context;
        Context context2;
        long j3;
        boolean z16;
        String str;
        File file;
        vermillion.getClass();
        synchronized (Celse.class) {
            context = Celse.f383328a;
        }
        j.a(context, vermillion.f383186d);
        vermillion.f383183a.getClass();
        Watermelon watermelon = Watermelon.f383208g;
        watermelon.getClass();
        try {
            System.currentTimeMillis();
            watermelon.b(context);
            System.currentTimeMillis();
            watermelon.b();
        } catch (Throwable unused) {
        }
        if (watermelon.a(39)) {
            vermillion.f383186d.getClass();
            if (TextUtils.isEmpty(Walnut.b(context, "405"))) {
                StringBuilder sb5 = new StringBuilder();
                try {
                    String[] split = new String(Csynchronized.a("/proc/self/maps")).split("\n");
                    HashSet hashSet = new HashSet();
                    for (String str2 : split) {
                        String[] split2 = str2.split(" +");
                        if (split2.length >= 2) {
                            String trim = split2[split2.length - 1].trim();
                            try {
                                file = new File(trim);
                            } catch (Throwable unused2) {
                                str = null;
                            }
                            if (file.exists()) {
                                str = file.getName();
                                if (str != null && str.contains("res") && str.endsWith(".apk") && !str.contains("mediatek") && !TextUtils.equals("/system/framework/framework-res.apk", trim) && !hashSet.contains(trim)) {
                                    hashSet.add(trim);
                                    String a16 = Andromeda.a(context, trim);
                                    if (a16 != null && !TextUtils.equals(a16, "android.auto_generated_rro__") && !TextUtils.equals(a16, "android.overlay")) {
                                        if (sb5.length() > 0) {
                                            sb5.append(":");
                                        }
                                        sb5.append(a16);
                                    }
                                }
                            }
                        }
                    }
                } catch (Throwable unused3) {
                }
                sb5.append(",");
                String name = Resources.getSystem().getClass().getName();
                if (!TextUtils.equals("android.content.res.Resources", name)) {
                    sb5.append(name);
                }
                vermillion.f383186d.a(context, "405", sb5.toString().replace("(\\|)|\\s*|\t|\r|\n", ""), true);
            }
        }
        if (vermillion.f383183a.f383099u && watermelon.a(45)) {
            Walnut walnut = vermillion.f383186d;
            int i3 = Persimmon.f382998b;
            walnut.getClass();
            try {
                j3 = Long.valueOf(Walnut.b(context, "902")).longValue();
            } catch (Throwable unused4) {
                j3 = 0;
            }
            if (Math.abs(j3 - System.currentTimeMillis()) >= Persimmon.f382997a) {
                if (!TextUtils.isEmpty(Walnut.b(context, "901"))) {
                    long abs = Math.abs(j3 - System.currentTimeMillis());
                    Warden warden = Warden.f383204f;
                    long j16 = Warden.f383203e;
                    String a17 = warden.a("sid_refresh_period");
                    if (a17 != null) {
                        try {
                            j16 = Long.parseLong(a17) * 3600000;
                        } catch (NumberFormatException unused5) {
                        }
                    }
                    if (abs < j16) {
                        z16 = false;
                        if (z16) {
                            Peanut a18 = Pistachio.a(context);
                            if (a18.f382984a != 0) {
                                a18 = Pistachio.a();
                            }
                            if (a18.f382984a == 0) {
                                String str3 = a18.f382987d;
                                HashMap hashMap = new HashMap();
                                hashMap.put("901", str3);
                                Walnut.a(context, hashMap);
                                String peanut = a18.toString();
                                HashMap hashMap2 = new HashMap();
                                hashMap2.put("904", peanut);
                                Walnut.a(context, hashMap2);
                            }
                        }
                        walnut.b(context, System.currentTimeMillis());
                    }
                }
                z16 = true;
                if (z16) {
                }
                walnut.b(context, System.currentTimeMillis());
            }
        }
        Strawberry strawberry = vermillion.f383183a;
        if (strawberry.f383096r && strawberry.d().userAgreement()) {
            if (watermelon.a(41)) {
                if (((ConcurrentHashMap) Arbutus.f382574a).containsKey(Arbutus.f382576c)) {
                    new Apricot((Arbutus.Cdo) ((ConcurrentHashMap) Arbutus.f382574a).get(Arbutus.f382576c), context).start();
                }
            }
            vermillion.a(vermillion.f383183a.c(), false, 0);
            String str4 = Guava.f382799a;
            synchronized (Celse.class) {
                context2 = Celse.f383328a;
            }
            if (Guava.a(context2) == null && Bennet.c(context)) {
                new Guava.Cdo(null, true).b();
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(118:8|(1:12)|13|(1:15)(1:368)|16|(1:18)(1:367)|19|(1:21)(1:366)|22|(1:24)|25|(1:27)|28|(1:30)|31|(3:33|(1:35)(1:37)|36)|38|(1:40)|41|42|43|44|(2:359|(1:363))(1:(1:49))|50|(83:52|53|54|55|(1:59)|60|(4:62|(2:96|97)|64|(1:66)(6:67|311|75|76|(5:78|(1:83)|86|(1:88)(1:90)|89)(1:91)|84))|102|(6:326|(1:328)|329|(1:331)(4:336|(3:338|(1:354)(5:340|341|342|343|(4:345|(1:347)|348|349)(1:351))|350)|355|356)|332|(1:334)(1:335))|106|(1:108)(4:307|(2:314|(1:316)(2:317|(1:319)(3:320|(1:324)|325)))|311|(1:313))|109|(5:111|4d8|117|(1:119)|120)(1:306)|121|(1:123)|124|(1:126)|127|(1:129)|130|(3:132|(1:134)|135)|136|(3:138|(1:140)|141)|142|(1:144)|145|(1:147)|148|(1:150)|151|(5:293|(1:295)|296|(1:298)|299)|155|(3:288|289|290)|157|(1:159)|160|(1:162)|163|(1:165)|166|(1:168)|169|(1:171)|172|(3:174|(1:176)|177)|178|(3:180|(1:182)(1:184)|183)|185|(4:187|(1:189)(1:194)|(1:191)(1:193)|192)|195|(1:197)|198|(1:200)|201|(1:203)|204|(3:206|(1:208)|209)|210|(3:212|(1:214)|215)|216|(3:218|(1:220)(1:222)|221)|223|(5:225|226|227|(1:229)(1:231)|230)|234|(1:236)|237|(1:239)|240|(4:243|(3:245|246|247)(1:249)|248|241)|250|251|(1:257)(1:287)|258|259|260|(1:262)|263|(2:266|264)|267|268|(1:270)(2:281|(1:283)(1:284))|271|(2:273|274)(2:275|(2:277|278)(2:279|280)))|358|55|(2:57|59)|60|(0)|102|(1:104)|326|(0)|329|(0)(0)|332|(0)(0)|106|(0)(0)|109|(0)(0)|121|(0)|124|(0)|127|(0)|130|(0)|136|(0)|142|(0)|145|(0)|148|(0)|151|(1:153)|293|(0)|296|(0)|299|155|(0)|157|(0)|160|(0)|163|(0)|166|(0)|169|(0)|172|(0)|178|(0)|185|(0)|195|(0)|198|(0)|201|(0)|204|(0)|210|(0)|216|(0)|223|(0)|234|(0)|237|(0)|240|(1:241)|250|251|(14:253|255|257|258|259|260|(0)|263|(1:264)|267|268|(0)(0)|271|(0)(0))|287|258|259|260|(0)|263|(1:264)|267|268|(0)(0)|271|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:286:0x0a51, code lost:
    
        r4 = r31;
        r1 = com.tencent.turingfd.sdk.xq.b.a(-10006);
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x02fd, code lost:
    
        if (r30.getPackageManager().getApplicationInfo(r30.getPackageName(), 128).metaData.containsKey(com.tencent.turingfd.sdk.xq.Vermillion.f383178j) != false) goto L80;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0396  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0425  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x04b2  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0513  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0546  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0557  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0575  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x058c  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x05a3  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x05c3  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x05e3  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0603  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0659  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0675  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0684  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0690  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x06a0  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x06ba  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x06db  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0700  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0728  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0748  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0768  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0788  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x07a9  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x07c0  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x07e6  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x080f  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x082f  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0895  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x095b  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x09b5  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x09d2 A[LOOP:1: B:264:0x09cc->B:266:0x09d2, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:270:0x0a38  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x0a63  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x0a68  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x0a3e  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x0643 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:295:0x061e  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x0627  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x04fc  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x0430  */
    /* JADX WARN: Removed duplicated region for block: B:328:0x03a9  */
    /* JADX WARN: Removed duplicated region for block: B:331:0x03b1  */
    /* JADX WARN: Removed duplicated region for block: B:334:0x0409  */
    /* JADX WARN: Removed duplicated region for block: B:335:0x0410  */
    /* JADX WARN: Removed duplicated region for block: B:336:0x03b3  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x030f  */
    /* JADX WARN: Type inference failed for: r10v4, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r4v33 */
    /* JADX WARN: Type inference failed for: r4v34, types: [int] */
    /* JADX WARN: Type inference failed for: r4v60 */
    /* JADX WARN: Type inference failed for: r4v61 */
    /* JADX WARN: Type inference failed for: r4v62 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Sultana b(Context context, boolean z16, int i3) {
        long j3;
        long j16;
        String a16;
        String sb5;
        Watermelon watermelon;
        int i16;
        ITuringDeviceInfoProvider iTuringDeviceInfoProvider;
        HashMap hashMap;
        long j17;
        int i17;
        boolean z17;
        List<String> a17;
        Set<String> d16;
        String str;
        String a18;
        String a19;
        String a26;
        Watermelon watermelon2;
        Iterator<Integer> it;
        ?? r46;
        b a27;
        int i18;
        int b16;
        String str2;
        Iterator it5;
        Map<Integer, String> features;
        boolean z18;
        boolean z19;
        FutureTask<Cassiopeia.Cdo> futureTask;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Sultana) iPatchRedirector.redirect((short) 8, this, context, Boolean.valueOf(z16), Integer.valueOf(i3));
        }
        long a28 = Watermelon.f383208g.a(context);
        long currentTimeMillis = System.currentTimeMillis();
        int i19 = Sugarcane.f383111g;
        long currentTimeMillis2 = System.currentTimeMillis();
        ((HashMap) Cimplements.f383368a).clear();
        HashMap hashMap2 = new HashMap();
        StringBuilder a29 = Flat.a("");
        a29.append(Nectarine.f382928a);
        hashMap2.put("1", a29.toString());
        Strawberry strawberry = this.f383183a;
        if (strawberry != null && strawberry.f383100v) {
            hashMap2.put("2", "1");
        }
        hashMap2.put("101", this.f383183a.b());
        hashMap2.put(ThemeReporter.FROM_SERVER_SET_THEME, this.f383186d.b(context).f383113a);
        Strawberry strawberry2 = this.f383183a;
        hashMap2.put(ThemeReporter.FROM_PUSH, TextUtils.isEmpty(strawberry2.f383085g) ? "" : strawberry2.f383085g);
        boolean z26 = this.f383183a.f383098t;
        Walnut walnut = this.f383186d;
        int i26 = Cextends.f383330b;
        StringBuilder sb6 = new StringBuilder();
        sb6.append("T:");
        long j18 = Cextends.f383329a;
        sb6.append(j18);
        sb6.append(",");
        sb6.append("LT:");
        sb6.append(System.currentTimeMillis() - j18);
        sb6.append(",");
        sb6.append("F:");
        sb6.append(z16 ? "1" : "0");
        sb6.append(",");
        sb6.append("PT:");
        sb6.append(i19);
        sb6.append(",");
        sb6.append("PKG:");
        sb6.append("1");
        sb6.append(",");
        sb6.append("SC:");
        sb6.append(z26 ? "1" : "0");
        if (Nectarine.f382928a == 105748) {
            sb6.append(",");
            sb6.append("SOTR:");
            sb6.append(Pistachio.a().toString() + ";" + Pistachio.a(context).toString());
        }
        sb6.append(",");
        sb6.append("SRT:");
        sb6.append(i3);
        Warden warden = Warden.f383204f;
        StringBuilder sb7 = new StringBuilder();
        Cprotected b17 = warden.b();
        if (b17 != null) {
            sb7.append(b17.f383420a);
            sb7.append("_");
            sb7.append(b17.f383422c);
        }
        String sb8 = sb7.toString();
        if (!TextUtils.isEmpty(sb8)) {
            sb6.append(",");
            sb6.append("CL:");
            sb6.append(sb8);
        }
        String b18 = Walnut.b(context, ThemeReporter.FROM_AUTH);
        if (TextUtils.isEmpty(b18)) {
            StringBuilder a36 = Flat.a("0_");
            a36.append(z16 ? "1" : "0");
            b18 = a36.toString();
        }
        if (!TextUtils.isEmpty(b18)) {
            sb6.append(",");
            sb6.append("R:");
            sb6.append(b18);
        }
        sb6.append(",");
        sb6.append("US:");
        try {
            j3 = Long.valueOf(Walnut.b(context, "503")).longValue();
        } catch (Throwable unused) {
            j3 = 0;
        }
        sb6.append(j3);
        sb6.append("_");
        sb6.append(walnut.a(context, "502"));
        sb6.append("_");
        sb6.append(Process.myUid());
        sb6.append(",");
        sb6.append("STIF:");
        sb6.append(Walnut.b(context, "904"));
        sb6.append(",");
        sb6.append("GCI:");
        sb6.append("7c2183b");
        hashMap2.put(ThemeReporter.FROM_CLEANER, sb6.toString());
        Watermelon watermelon3 = Watermelon.f383208g;
        hashMap2.put("2001", watermelon3.a());
        Warden warden2 = Warden.f383204f;
        int i27 = Nectarine.f382928a;
        if (i27 == 105668 || i27 == 105928) {
            if (!watermelon3.a(17) && !watermelon3.a(18)) {
                hashMap2.put("1001", "2");
            }
        } else if (!z16) {
            hashMap2.put("1001", "1");
        }
        StringBuilder a37 = Flat.a("");
        String a38 = warden2.a("m_p_s");
        if (a38 != null) {
            try {
                j16 = Long.parseLong(a38) * 1;
            } catch (NumberFormatException unused2) {
                j16 = 300;
            }
            a37.append((int) j16);
            hashMap2.put("2012", a37.toString());
            if (watermelon3.a(136) && Bryony.a(context, f383179k) == 0) {
                hashMap2.put("501", "1");
            }
            if (watermelon3.a(143)) {
                if (Bryony.a(context, f383177i) != 0) {
                }
                z19 = true;
                if (z19) {
                    hashMap2.put("2020", "-2");
                } else {
                    synchronized (this.f383190h) {
                        futureTask = this.f383190h.get();
                        if (futureTask == null) {
                            futureTask = new FutureTask<>(new Teazle(this));
                            Cstrictfp.f383431a.submit(futureTask);
                            this.f383190h.set(futureTask);
                        }
                    }
                    try {
                        Cassiopeia.Cdo cdo = futureTask.get(1L, TimeUnit.SECONDS);
                        if (cdo != null) {
                            if (cdo.f382645b && !warden2.a("ig_g_a_l", false)) {
                                hashMap2.put("2020", "1");
                            }
                            StringBuilder sb9 = new StringBuilder();
                            sb9.append(cdo.f382645b ? "1" : "0");
                            sb9.append(",");
                            sb9.append(cdo.f382644a);
                            hashMap2.put("2020", sb9.toString());
                        } else {
                            hashMap2.put("2020", "-1");
                        }
                    } catch (Throwable unused3) {
                        hashMap2.put("2020", "-3");
                    }
                }
            }
            if (!this.f383183a.B || watermelon3.a(144)) {
                a16 = Warden.f383204f.a("d_i_l");
                if (a16 == null) {
                    a16 = Warden.f383202d;
                }
                if (TextUtils.isEmpty(a16)) {
                    sb5 = null;
                } else {
                    StringBuilder sb10 = new StringBuilder();
                    for (String str3 : a16.split(",")) {
                        String[] split = str3.split(":");
                        if (split.length == 2) {
                            try {
                                String a39 = a(Long.parseLong(split[0], 16), Long.parseLong(split[1], 16));
                                if (!TextUtils.isEmpty(a39)) {
                                    if (sb10.length() > 0) {
                                        sb10.append(",");
                                    }
                                    sb10.append(a39);
                                }
                            } catch (Throwable unused4) {
                            }
                        }
                    }
                    sb5 = sb10.toString();
                }
                if (!TextUtils.isEmpty(sb5)) {
                    hashMap2.put("2023", sb5);
                } else {
                    hashMap2.put("2023", "");
                }
            }
            watermelon = Watermelon.f383208g;
            Warden warden3 = Warden.f383204f;
            if (!watermelon.a(41)) {
                hashMap2.put("2003", "0");
            } else {
                long currentTimeMillis3 = System.currentTimeMillis();
                Avocado avocado = Arbutus.f382575b;
                if (avocado == null || avocado.f382585b == 0) {
                    if (!((ConcurrentHashMap) Arbutus.f382574a).containsKey(Arbutus.f382576c)) {
                        avocado = Avocado.a(-10);
                    } else if ("main".equals(Thread.currentThread().getName())) {
                        avocado = Avocado.a(-11);
                    } else {
                        Arbutus.Cdo cdo2 = (Arbutus.Cdo) ((ConcurrentHashMap) Arbutus.f382574a).get(Arbutus.f382576c);
                        if (cdo2 != null && (i16 = cdo2.f382578b) <= 3) {
                            cdo2.f382578b = i16 + 1;
                            Arbutus.f382575b = cdo2.f382577a.a(context);
                        }
                        avocado = Arbutus.f382575b;
                    }
                }
                hashMap2.put("100", avocado.f382584a);
                Cimplements.a(20, System.currentTimeMillis() - currentTimeMillis3);
                if (!watermelon.a(10001)) {
                    hashMap2.put("2004", "0");
                }
            }
            iTuringDeviceInfoProvider = this.f383183a.f383081c;
            if (iTuringDeviceInfoProvider != null) {
                Object obj = new Object();
                AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                long currentTimeMillis4 = System.currentTimeMillis();
                hashMap = hashMap2;
                j17 = a28;
                i17 = i19;
                new Tough(this, atomicBoolean, hashMap2, iTuringDeviceInfoProvider, currentTimeMillis4, obj).start();
                synchronized (obj) {
                    try {
                        obj.wait(1000L);
                    } catch (InterruptedException unused5) {
                    }
                }
                if (System.currentTimeMillis() - currentTimeMillis4 > 1000) {
                    Log.w("Turing", "invoke info impl timeout");
                }
                z17 = true;
                atomicBoolean.set(true);
            } else {
                hashMap = hashMap2;
                j17 = a28;
                i17 = i19;
                z17 = true;
            }
            hashMap.put("264", Cprivate.a());
            if (watermelon.a(22)) {
                hashMap.put(ThemeReporter.FROM_ENGINE, Cabstract.a(context));
                Cimplements.a(8, Long.valueOf("" + Cabstract.f383225f).longValue());
            }
            if (!watermelon.a(10002)) {
                hashMap.put("2005", "0");
            }
            if (!watermelon.a(10003)) {
                hashMap.put("2006", "0");
            }
            hashMap.put("266", Walnut.b(context, "901"));
            if (watermelon.a(115)) {
                String b19 = Almond.b();
                if (b19 == null) {
                    b19 = "";
                }
                hashMap.put(IFeatureRuntimeService.MODULE_ID, b19);
            }
            if (watermelon.a(116)) {
                String a46 = Leo.a();
                if (a46 == null) {
                    a46 = "";
                }
                hashMap.put("269", a46);
            }
            if (watermelon.a(117)) {
                StringBuilder a47 = Flat.a("");
                a47.append(Almond.a(context));
                hashMap.put("270", a47.toString());
            }
            if (watermelon.a(46)) {
                StringBuilder a48 = Flat.a("");
                a48.append(Centaurus.a());
                hashMap.put("271", a48.toString());
            }
            if (watermelon.a(118)) {
                StringBuilder a49 = Flat.a("");
                a49.append(Lyra.b());
                hashMap.put("272", a49.toString());
            }
            if (!watermelon.a(17) || watermelon.a(40)) {
                a17 = Cantaloupe.a(this.f383183a.f383082d);
                HashSet hashSet = new HashSet();
                if (!Creturn.a(a17)) {
                    hashSet.addAll(a17);
                }
                d16 = warden3.d();
                if (d16 != null) {
                    hashSet.addAll(d16);
                }
                hashSet.add(context.getPackageName());
                hashMap.put("277", Cantaloupe.a(hashSet));
            }
            if (watermelon.a(122)) {
                try {
                    str = Cpublic.a();
                } catch (Throwable unused6) {
                    str = "exception";
                }
                hashMap.put("280", str);
            }
            if (watermelon.a(126)) {
                hashMap.put("281", String.valueOf(System.currentTimeMillis() - SystemClock.elapsedRealtime()));
            }
            a18 = warden3.a("x_l2_p_i");
            if (a18 != null) {
                hashMap.put("2014", a18);
            }
            a19 = warden3.a("x_u_p_i");
            if (a19 != null) {
                hashMap.put("2015", a19);
            }
            a26 = warden3.a();
            if (a26 != null) {
                hashMap.put("2013", a26);
            }
            watermelon2 = Watermelon.f383208g;
            if (watermelon2.a(39)) {
                this.f383186d.getClass();
                hashMap.put("239", Walnut.b(context, "405"));
            }
            if (watermelon2.a(100)) {
                long currentTimeMillis5 = System.currentTimeMillis();
                String a56 = Leo.a(context);
                if (a56 == null) {
                    a56 = "";
                }
                Syrup.a(hashMap, "250", a56, currentTimeMillis5, 30);
            }
            if (watermelon2.a(101)) {
                Syrup.a(hashMap, "251", s.b(context) > 0 ? "1" : "0", System.currentTimeMillis(), 31);
            }
            if (watermelon2.a(102)) {
                hashMap.put("252", Settings.Secure.getInt(context.getContentResolver(), "mock_location", 0) != 0 ? z17 : false ? "1" : "0");
            }
            if (watermelon2.a(103)) {
                StringBuilder a57 = Flat.a("");
                a57.append(Almond.d(context));
                hashMap.put("253", a57.toString());
            }
            if (watermelon2.a(104)) {
                StringBuilder a58 = Flat.a("");
                a58.append(Almond.b(context));
                hashMap.put("254", a58.toString());
            }
            if (watermelon2.a(105)) {
                StringBuilder a59 = Flat.a("");
                a59.append(Cthis.a(context));
                hashMap.put("255", a59.toString());
            }
            if (watermelon2.a(106)) {
                long currentTimeMillis6 = System.currentTimeMillis();
                String a65 = Almond.a();
                if (a65 == null) {
                    a65 = "";
                }
                Syrup.a(hashMap, "256", a65, currentTimeMillis6, 32);
            }
            if (watermelon2.a(107)) {
                String f16 = Almond.f(context);
                if (f16 == null) {
                    f16 = "";
                }
                hashMap.put("257", f16);
            }
            if (watermelon2.a(113)) {
                Syrup.a(hashMap, "258", Cherry.a() ? "1" : "0", System.currentTimeMillis(), 40);
            }
            if (watermelon2.a(114)) {
                long currentTimeMillis7 = System.currentTimeMillis();
                try {
                    z18 = Cherry.a(context);
                } catch (Throwable unused7) {
                    z18 = false;
                }
                Syrup.a(hashMap, "259", z18 ? "1" : "0", currentTimeMillis7, 41);
            }
            if (watermelon2.a(44)) {
                long currentTimeMillis8 = System.currentTimeMillis();
                hashMap.put("240", Sorgo.a());
                Cimplements.a(42, System.currentTimeMillis() - currentTimeMillis8);
            }
            if (watermelon2.a(138)) {
                hashMap.put("282", Almond.c(context));
            }
            StringBuilder a66 = Flat.a("");
            a66.append(this.f383183a.f383092n);
            hashMap.put("403", a66.toString());
            hashMap.put("402", this.f383183a.f383090l);
            hashMap.put("404", this.f383183a.f383091m);
            hashMap.put("401", this.f383183a.f383093o);
            this.f383183a.getClass();
            hashMap.put("405", null);
            Map<Integer, String> map = this.f383183a.f383094p;
            StringBuilder sb11 = new StringBuilder();
            it = map.keySet().iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                sb11.append(intValue);
                sb11.append("_");
                sb11.append(Plum.a(",", "%54", Plum.a("_", "%5F", map.get(Integer.valueOf(intValue)))));
                if (it.hasNext()) {
                    sb11.append(",");
                }
            }
            hashMap.put(PersonalityConfig.RESERVES_COVER_CLICK_WIDGET_VISITOR_WITH_NANE_PLATGE, sb11.toString());
            this.f383186d.getClass();
            hashMap.put("302", Walnut.b(context, ThemeReporter.FROM_DIY));
            this.f383186d.getClass();
            hashMap.put("303", Walnut.b(context, ThemeReporter.FROM_NIGHT));
            this.f383186d.getClass();
            hashMap.put("305", Walnut.b(context, ThemeReporter.FROM_WEEKLOOP));
            hashMap.put("308", "" + ((int) Bennet.b(context)));
            this.f383186d.getClass();
            hashMap.put("309", Walnut.b(context, "404"));
            this.f383186d.getClass();
            hashMap.put("310", Walnut.b(context, ThemeReporter.FROM_ENGINE));
            ITuringIoTFeatureMap iTuringIoTFeatureMap = this.f383183a.f383083e;
            SparseArray<Object> a89_A931D6BEC30CD812 = TNative$aa.a89_A931D6BEC30CD812(new SparseArray(), context, hashMap, (iTuringIoTFeatureMap == null || (features = iTuringIoTFeatureMap.getFeatures(context)) == null || features.isEmpty()) ? null : features, i17);
            Walnut walnut2 = this.f383186d;
            StringBuilder sb12 = new StringBuilder();
            sb12.append(System.currentTimeMillis() - currentTimeMillis2);
            sb12.append("_");
            boolean z27 = z16;
            sb12.append(z27 ? 1 : 0);
            walnut2.a(context, ThemeReporter.FROM_DIY, sb12.toString());
            b16 = Bagasse.b(a89_A931D6BEC30CD812);
            byte[] a67 = Bagasse.a(a89_A931D6BEC30CD812);
            StringBuilder sb13 = new StringBuilder();
            str2 = (String) Bagasse.a(a89_A931D6BEC30CD812, 2, String.class);
            int i28 = Plum.f383026a;
            if (str2 == null) {
                str2 = "";
            }
            sb13.append(str2);
            StringBuilder sb14 = new StringBuilder();
            it5 = ((HashMap) Cimplements.f383368a).keySet().iterator();
            while (it5.hasNext()) {
                int intValue2 = ((Integer) it5.next()).intValue();
                sb14.append(",");
                sb14.append(intValue2);
                sb14.append("_");
                sb14.append(((HashMap) Cimplements.f383368a).get(Integer.valueOf(intValue2)));
            }
            sb13.append(sb14.toString());
            this.f383186d.a(context, ThemeReporter.FROM_ENGINE, sb13.toString());
            Walnut walnut3 = this.f383186d;
            long length = a67.length;
            walnut3.getClass();
            walnut3.a(context, ThemeReporter.FROM_WEEKLOOP, "" + length + "_" + (z27 ? 1 : 0));
            if (b16 == 0) {
                a27 = b.a(b16);
                r46 = z27;
            } else if (a67.length == 0) {
                a27 = b.a(-10003);
                r46 = z27;
            } else {
                a27 = new b(0, a67);
                r46 = z27;
            }
            long currentTimeMillis9 = System.currentTimeMillis() - currentTimeMillis;
            i18 = a27.f383230a;
            if (i18 == 0) {
                return Sultana.a(i18);
            }
            long currentTimeMillis10 = System.currentTimeMillis();
            c a68 = Wild.f383217b.a(1, a27.f383231b, 8117, 18117, null);
            this.f383186d.a(context, ThemeReporter.FROM_NIGHT, Bennet.a(context) + "_" + (System.currentTimeMillis() - currentTimeMillis10) + "_" + j17 + "_" + r46 + "_" + a27.f383231b.length + "_" + currentTimeMillis9 + "_" + (System.currentTimeMillis() - currentTimeMillis));
            int i29 = a68.f383233a;
            if (i29 != 0) {
                return new Sultana(i29, Sultana.f383112j, a68.f383234b, a68.f383235c);
            }
            return a(context, a68.f383236d, Sugarcane.f383111g);
        }
        j16 = 300;
        a37.append((int) j16);
        hashMap2.put("2012", a37.toString());
        if (watermelon3.a(136)) {
            hashMap2.put("501", "1");
        }
        if (watermelon3.a(143)) {
        }
        if (!this.f383183a.B) {
        }
        a16 = Warden.f383204f.a("d_i_l");
        if (a16 == null) {
        }
        if (TextUtils.isEmpty(a16)) {
        }
        if (!TextUtils.isEmpty(sb5)) {
        }
        watermelon = Watermelon.f383208g;
        Warden warden32 = Warden.f383204f;
        if (!watermelon.a(41)) {
        }
        iTuringDeviceInfoProvider = this.f383183a.f383081c;
        if (iTuringDeviceInfoProvider != null) {
        }
        hashMap.put("264", Cprivate.a());
        if (watermelon.a(22)) {
        }
        if (!watermelon.a(10002)) {
        }
        if (!watermelon.a(10003)) {
        }
        hashMap.put("266", Walnut.b(context, "901"));
        if (watermelon.a(115)) {
        }
        if (watermelon.a(116)) {
        }
        if (watermelon.a(117)) {
        }
        if (watermelon.a(46)) {
        }
        if (watermelon.a(118)) {
        }
        if (!watermelon.a(17)) {
        }
        a17 = Cantaloupe.a(this.f383183a.f383082d);
        HashSet hashSet2 = new HashSet();
        if (!Creturn.a(a17)) {
        }
        d16 = warden32.d();
        if (d16 != null) {
        }
        hashSet2.add(context.getPackageName());
        hashMap.put("277", Cantaloupe.a(hashSet2));
        if (watermelon.a(122)) {
        }
        if (watermelon.a(126)) {
        }
        a18 = warden32.a("x_l2_p_i");
        if (a18 != null) {
        }
        a19 = warden32.a("x_u_p_i");
        if (a19 != null) {
        }
        a26 = warden32.a();
        if (a26 != null) {
        }
        watermelon2 = Watermelon.f383208g;
        if (watermelon2.a(39)) {
        }
        if (watermelon2.a(100)) {
        }
        if (watermelon2.a(101)) {
        }
        if (watermelon2.a(102)) {
        }
        if (watermelon2.a(103)) {
        }
        if (watermelon2.a(104)) {
        }
        if (watermelon2.a(105)) {
        }
        if (watermelon2.a(106)) {
        }
        if (watermelon2.a(107)) {
        }
        if (watermelon2.a(113)) {
        }
        if (watermelon2.a(114)) {
        }
        if (watermelon2.a(44)) {
        }
        if (watermelon2.a(138)) {
        }
        StringBuilder a662 = Flat.a("");
        a662.append(this.f383183a.f383092n);
        hashMap.put("403", a662.toString());
        hashMap.put("402", this.f383183a.f383090l);
        hashMap.put("404", this.f383183a.f383091m);
        hashMap.put("401", this.f383183a.f383093o);
        this.f383183a.getClass();
        hashMap.put("405", null);
        Map<Integer, String> map2 = this.f383183a.f383094p;
        StringBuilder sb112 = new StringBuilder();
        it = map2.keySet().iterator();
        while (it.hasNext()) {
        }
        hashMap.put(PersonalityConfig.RESERVES_COVER_CLICK_WIDGET_VISITOR_WITH_NANE_PLATGE, sb112.toString());
        this.f383186d.getClass();
        hashMap.put("302", Walnut.b(context, ThemeReporter.FROM_DIY));
        this.f383186d.getClass();
        hashMap.put("303", Walnut.b(context, ThemeReporter.FROM_NIGHT));
        this.f383186d.getClass();
        hashMap.put("305", Walnut.b(context, ThemeReporter.FROM_WEEKLOOP));
        hashMap.put("308", "" + ((int) Bennet.b(context)));
        this.f383186d.getClass();
        hashMap.put("309", Walnut.b(context, "404"));
        this.f383186d.getClass();
        hashMap.put("310", Walnut.b(context, ThemeReporter.FROM_ENGINE));
        ITuringIoTFeatureMap iTuringIoTFeatureMap2 = this.f383183a.f383083e;
        if (iTuringIoTFeatureMap2 == null) {
            SparseArray<Object> a89_A931D6BEC30CD8122 = TNative$aa.a89_A931D6BEC30CD812(new SparseArray(), context, hashMap, (iTuringIoTFeatureMap2 == null || (features = iTuringIoTFeatureMap2.getFeatures(context)) == null || features.isEmpty()) ? null : features, i17);
            Walnut walnut22 = this.f383186d;
            StringBuilder sb122 = new StringBuilder();
            sb122.append(System.currentTimeMillis() - currentTimeMillis2);
            sb122.append("_");
            boolean z272 = z16;
            sb122.append(z272 ? 1 : 0);
            walnut22.a(context, ThemeReporter.FROM_DIY, sb122.toString());
            b16 = Bagasse.b(a89_A931D6BEC30CD8122);
            byte[] a672 = Bagasse.a(a89_A931D6BEC30CD8122);
            StringBuilder sb132 = new StringBuilder();
            str2 = (String) Bagasse.a(a89_A931D6BEC30CD8122, 2, String.class);
            int i282 = Plum.f383026a;
            if (str2 == null) {
            }
            sb132.append(str2);
            StringBuilder sb142 = new StringBuilder();
            it5 = ((HashMap) Cimplements.f383368a).keySet().iterator();
            while (it5.hasNext()) {
            }
            sb132.append(sb142.toString());
            this.f383186d.a(context, ThemeReporter.FROM_ENGINE, sb132.toString());
            Walnut walnut32 = this.f383186d;
            long length2 = a672.length;
            walnut32.getClass();
            walnut32.a(context, ThemeReporter.FROM_WEEKLOOP, "" + length2 + "_" + (z272 ? 1 : 0));
            if (b16 == 0) {
            }
            long currentTimeMillis92 = System.currentTimeMillis() - currentTimeMillis;
            i18 = a27.f383230a;
            if (i18 == 0) {
            }
        }
        SparseArray<Object> a89_A931D6BEC30CD81222 = TNative$aa.a89_A931D6BEC30CD812(new SparseArray(), context, hashMap, (iTuringIoTFeatureMap2 == null || (features = iTuringIoTFeatureMap2.getFeatures(context)) == null || features.isEmpty()) ? null : features, i17);
        Walnut walnut222 = this.f383186d;
        StringBuilder sb1222 = new StringBuilder();
        sb1222.append(System.currentTimeMillis() - currentTimeMillis2);
        sb1222.append("_");
        boolean z2722 = z16;
        sb1222.append(z2722 ? 1 : 0);
        walnut222.a(context, ThemeReporter.FROM_DIY, sb1222.toString());
        b16 = Bagasse.b(a89_A931D6BEC30CD81222);
        byte[] a6722 = Bagasse.a(a89_A931D6BEC30CD81222);
        StringBuilder sb1322 = new StringBuilder();
        str2 = (String) Bagasse.a(a89_A931D6BEC30CD81222, 2, String.class);
        int i2822 = Plum.f383026a;
        if (str2 == null) {
        }
        sb1322.append(str2);
        StringBuilder sb1422 = new StringBuilder();
        it5 = ((HashMap) Cimplements.f383368a).keySet().iterator();
        while (it5.hasNext()) {
        }
        sb1322.append(sb1422.toString());
        this.f383186d.a(context, ThemeReporter.FROM_ENGINE, sb1322.toString());
        Walnut walnut322 = this.f383186d;
        long length22 = a6722.length;
        walnut322.getClass();
        walnut322.a(context, ThemeReporter.FROM_WEEKLOOP, "" + length22 + "_" + (z2722 ? 1 : 0));
        if (b16 == 0) {
        }
        long currentTimeMillis922 = System.currentTimeMillis() - currentTimeMillis;
        i18 = a27.f383230a;
        if (i18 == 0) {
        }
        z19 = false;
        if (z19) {
        }
        if (!this.f383183a.B) {
        }
        a16 = Warden.f383204f.a("d_i_l");
        if (a16 == null) {
        }
        if (TextUtils.isEmpty(a16)) {
        }
        if (!TextUtils.isEmpty(sb5)) {
        }
        watermelon = Watermelon.f383208g;
        Warden warden322 = Warden.f383204f;
        if (!watermelon.a(41)) {
        }
        iTuringDeviceInfoProvider = this.f383183a.f383081c;
        if (iTuringDeviceInfoProvider != null) {
        }
        hashMap.put("264", Cprivate.a());
        if (watermelon.a(22)) {
        }
        if (!watermelon.a(10002)) {
        }
        if (!watermelon.a(10003)) {
        }
        hashMap.put("266", Walnut.b(context, "901"));
        if (watermelon.a(115)) {
        }
        if (watermelon.a(116)) {
        }
        if (watermelon.a(117)) {
        }
        if (watermelon.a(46)) {
        }
        if (watermelon.a(118)) {
        }
        if (!watermelon.a(17)) {
        }
        a17 = Cantaloupe.a(this.f383183a.f383082d);
        HashSet hashSet22 = new HashSet();
        if (!Creturn.a(a17)) {
        }
        d16 = warden322.d();
        if (d16 != null) {
        }
        hashSet22.add(context.getPackageName());
        hashMap.put("277", Cantaloupe.a(hashSet22));
        if (watermelon.a(122)) {
        }
        if (watermelon.a(126)) {
        }
        a18 = warden322.a("x_l2_p_i");
        if (a18 != null) {
        }
        a19 = warden322.a("x_u_p_i");
        if (a19 != null) {
        }
        a26 = warden322.a();
        if (a26 != null) {
        }
        watermelon2 = Watermelon.f383208g;
        if (watermelon2.a(39)) {
        }
        if (watermelon2.a(100)) {
        }
        if (watermelon2.a(101)) {
        }
        if (watermelon2.a(102)) {
        }
        if (watermelon2.a(103)) {
        }
        if (watermelon2.a(104)) {
        }
        if (watermelon2.a(105)) {
        }
        if (watermelon2.a(106)) {
        }
        if (watermelon2.a(107)) {
        }
        if (watermelon2.a(113)) {
        }
        if (watermelon2.a(114)) {
        }
        if (watermelon2.a(44)) {
        }
        if (watermelon2.a(138)) {
        }
        StringBuilder a6622 = Flat.a("");
        a6622.append(this.f383183a.f383092n);
        hashMap.put("403", a6622.toString());
        hashMap.put("402", this.f383183a.f383090l);
        hashMap.put("404", this.f383183a.f383091m);
        hashMap.put("401", this.f383183a.f383093o);
        this.f383183a.getClass();
        hashMap.put("405", null);
        Map<Integer, String> map22 = this.f383183a.f383094p;
        StringBuilder sb1122 = new StringBuilder();
        it = map22.keySet().iterator();
        while (it.hasNext()) {
        }
        hashMap.put(PersonalityConfig.RESERVES_COVER_CLICK_WIDGET_VISITOR_WITH_NANE_PLATGE, sb1122.toString());
        this.f383186d.getClass();
        hashMap.put("302", Walnut.b(context, ThemeReporter.FROM_DIY));
        this.f383186d.getClass();
        hashMap.put("303", Walnut.b(context, ThemeReporter.FROM_NIGHT));
        this.f383186d.getClass();
        hashMap.put("305", Walnut.b(context, ThemeReporter.FROM_WEEKLOOP));
        hashMap.put("308", "" + ((int) Bennet.b(context)));
        this.f383186d.getClass();
        hashMap.put("309", Walnut.b(context, "404"));
        this.f383186d.getClass();
        hashMap.put("310", Walnut.b(context, ThemeReporter.FROM_ENGINE));
        ITuringIoTFeatureMap iTuringIoTFeatureMap22 = this.f383183a.f383083e;
        SparseArray<Object> a89_A931D6BEC30CD812222 = TNative$aa.a89_A931D6BEC30CD812(new SparseArray(), context, hashMap, (iTuringIoTFeatureMap22 == null || (features = iTuringIoTFeatureMap22.getFeatures(context)) == null || features.isEmpty()) ? null : features, i17);
        Walnut walnut2222 = this.f383186d;
        StringBuilder sb12222 = new StringBuilder();
        sb12222.append(System.currentTimeMillis() - currentTimeMillis2);
        sb12222.append("_");
        boolean z27222 = z16;
        sb12222.append(z27222 ? 1 : 0);
        walnut2222.a(context, ThemeReporter.FROM_DIY, sb12222.toString());
        b16 = Bagasse.b(a89_A931D6BEC30CD812222);
        byte[] a67222 = Bagasse.a(a89_A931D6BEC30CD812222);
        StringBuilder sb13222 = new StringBuilder();
        str2 = (String) Bagasse.a(a89_A931D6BEC30CD812222, 2, String.class);
        int i28222 = Plum.f383026a;
        if (str2 == null) {
        }
        sb13222.append(str2);
        StringBuilder sb14222 = new StringBuilder();
        it5 = ((HashMap) Cimplements.f383368a).keySet().iterator();
        while (it5.hasNext()) {
        }
        sb13222.append(sb14222.toString());
        this.f383186d.a(context, ThemeReporter.FROM_ENGINE, sb13222.toString());
        Walnut walnut3222 = this.f383186d;
        long length222 = a67222.length;
        walnut3222.getClass();
        walnut3222.a(context, ThemeReporter.FROM_WEEKLOOP, "" + length222 + "_" + (z27222 ? 1 : 0));
        if (b16 == 0) {
        }
        long currentTimeMillis9222 = System.currentTimeMillis() - currentTimeMillis;
        i18 = a27.f383230a;
        if (i18 == 0) {
        }
    }

    public Sultana a(Context context) {
        Sultana sultana;
        Sultana a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Sultana) iPatchRedirector.redirect((short) 10, (Object) this, (Object) context);
        }
        synchronized (this.f383188f) {
            sultana = this.f383188f.get();
            if (sultana == null) {
                Walnut walnut = this.f383186d;
                if (walnut != null) {
                    a16 = walnut.b(context);
                } else {
                    a16 = Sultana.a(1);
                }
                sultana = a16;
                this.f383188f.set(sultana);
            }
        }
        return sultana;
    }

    public final void a(Sultana sultana, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, sultana, Boolean.valueOf(z16));
            return;
        }
        synchronized (this.f383188f) {
            try {
                if (sultana == null) {
                    return;
                }
                if (z16 || sultana.f383115c == 0) {
                    this.f383188f.set(sultana);
                }
            } catch (Throwable th5) {
                throw th5;
            }
        }
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        synchronized (this.f383189g) {
            if (this.f383189g.get().booleanValue()) {
                return;
            }
            this.f383189g.set(Boolean.TRUE);
            this.f383184b.sendMessageDelayed(Message.obtain(this.f383184b, 2, 3), 0L);
        }
    }

    public final Sultana a(Context context, boolean z16, int i3) {
        Sultana a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Sultana) iPatchRedirector.redirect((short) 5, this, context, Boolean.valueOf(z16), Integer.valueOf(i3));
        }
        Sultana a17 = a(context);
        if (this.f383183a == null) {
            return Sultana.a(-10002);
        }
        int a18 = a(a17);
        if (a18 == 1) {
            return a17;
        }
        if (a18 != 2) {
            if (a18 == 3) {
                a();
            }
            return a17;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            a();
            return Sultana.a(-10008);
        }
        synchronized (this.f383187e) {
            a16 = a(context);
            if (a16 == a17 || a(a16) != 1) {
                synchronized (this.f383189g) {
                    if (!this.f383189g.get().booleanValue()) {
                        this.f383189g.set(Boolean.TRUE);
                        this.f383184b.post(new Tangor(this, context, true, i3));
                    }
                    try {
                        this.f383189g.wait(z16 ? this.f383183a.f383101w : 10000L);
                    } catch (InterruptedException unused) {
                    }
                }
                a16 = a(context);
                if (a16 == a17) {
                    a16 = Sultana.a(-10004);
                }
            }
        }
        return a16;
    }

    public final int a(Sultana sultana) {
        Context context;
        long j3;
        Context context2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, (Object) sultana)).intValue();
        }
        if (this.f383183a.f383097s || sultana.f383115c != 0 || TextUtils.isEmpty(sultana.f383113a)) {
            return 2;
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (currentTimeMillis >= sultana.f383114b) {
            this.f383183a.getClass();
            return 3;
        }
        Walnut walnut = this.f383186d;
        synchronized (Celse.class) {
            context = Celse.f383328a;
        }
        walnut.getClass();
        try {
            j3 = Long.valueOf(Walnut.b(context, "107")).longValue();
        } catch (Throwable unused) {
            j3 = 0;
        }
        Walnut walnut2 = this.f383186d;
        synchronized (Celse.class) {
            context2 = Celse.f383328a;
        }
        if (Math.abs(currentTimeMillis - walnut2.a(context2, "108")) < j3) {
            return 1;
        }
        this.f383183a.getClass();
        return 3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x00fb, code lost:
    
        if (r22 != false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0126, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0122, code lost:
    
        if (java.lang.Math.abs(java.lang.System.currentTimeMillis() - r3.longValue()) >= com.tencent.turingfd.sdk.xq.Vermillion.f383181m) goto L63;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00fe  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Sultana a(Context context, boolean z16, boolean z17, int i3) {
        Context context2;
        Context context3;
        String a16;
        Sultana a17;
        long j3;
        Context context4;
        Context context5;
        byte b16;
        Context context6;
        long j16;
        byte b17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Sultana) iPatchRedirector.redirect((short) 7, this, context, Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i3));
        }
        if (!Bennet.c(context)) {
            return Sultana.a(-10012);
        }
        if (!this.f383183a.f383097s) {
            synchronized (Celse.class) {
                context4 = Celse.f383328a;
            }
            if ((Math.abs((System.currentTimeMillis() / 1000) - (this.f383186d.a(context4, QAdVrReportParams.ClickAdActionTypeValue.ACTION_TYPE_NO_JUMP) / 1000)) > 3600) == false) {
                return Sultana.a(-30015);
            }
            Walnut walnut = this.f383186d;
            synchronized (Celse.class) {
                context5 = Celse.f383328a;
            }
            UrsaMinor<Long> a18 = walnut.a(context5, 30);
            if (a18.f383176b.size() != 0) {
                Walnut walnut2 = this.f383186d;
                synchronized (Celse.class) {
                    context6 = Celse.f383328a;
                }
                walnut2.getClass();
                try {
                    j16 = Long.valueOf(Walnut.b(context6, "401")).longValue();
                } catch (Throwable unused) {
                    j16 = 0;
                }
                if (j16 > 0) {
                    long abs = Math.abs(System.currentTimeMillis() - a18.f383176b.getLast().longValue());
                    int[] iArr = f383182n;
                    int length = j16 < ((long) iArr.length) ? (int) j16 : iArr.length - 1;
                    if (length >= 1) {
                        if (iArr[length - 1] >= iArr[length]) {
                            throw new IllegalArgumentException("");
                        }
                        if (abs <= TimeUnit.SECONDS.toMillis(new Random().nextInt((r3 - r5) + 1) + r5)) {
                            b17 = false;
                            if (b17 == false) {
                                Long first = a18.f383176b.getFirst();
                                if (a18.f383176b.size() >= a18.f383175a) {
                                }
                            }
                            if (b16 == false) {
                                return Sultana.a(-10011);
                            }
                        }
                    }
                }
                b17 = true;
                if (b17 == false) {
                }
                if (b16 == false) {
                }
            }
            b16 = true;
            if (b16 == false) {
            }
        }
        Walnut walnut3 = this.f383186d;
        synchronized (Celse.class) {
            context2 = Celse.f383328a;
        }
        UrsaMinor<Long> a19 = walnut3.a(context2, 30);
        a19.a(Long.valueOf(System.currentTimeMillis()));
        Walnut walnut4 = this.f383186d;
        synchronized (Celse.class) {
            context3 = Celse.f383328a;
        }
        walnut4.getClass();
        StringBuilder sb5 = new StringBuilder();
        for (int i16 = 0; i16 < a19.f383176b.size(); i16++) {
            sb5.append(a19.f383176b.get(i16));
            if (i16 != a19.f383176b.size() - 1) {
                sb5.append("_");
            }
        }
        walnut4.a(context3, "402", sb5.toString(), true);
        synchronized (Blueberry.class) {
            a16 = Blueberry.a(context, Blueberry.f382611a);
        }
        if (!TextUtils.isEmpty(a16)) {
            this.f383186d.a(context, "404", a16, true);
        }
        j.a(context, this.f383186d);
        Walnut walnut5 = this.f383186d;
        long a26 = walnut5.a(context, "502");
        int myUid = Process.myUid();
        if (a26 == 0) {
            walnut5.c(context, 0L);
        } else if (a26 != 0 && myUid != a26) {
            walnut5.c(context, -1L);
        } else {
            walnut5.c(context, 1L);
        }
        if (Warden.f383204f.a("e_b_d", false)) {
            SparseArray sparseArray = new SparseArray();
            TNative$aa.c89_A931D6BEC30CD812(sparseArray, context);
            Bagasse.b(sparseArray);
        }
        try {
            a17 = b(context, z16, i3);
        } catch (Throwable th5) {
            Log.w("TuringFdJava", th5);
            a17 = Sultana.a(-10015);
        }
        if (a17.f383115c == -30015) {
            Walnut walnut6 = this.f383186d;
            long currentTimeMillis = System.currentTimeMillis();
            walnut6.getClass();
            walnut6.a(context, QAdVrReportParams.ClickAdActionTypeValue.ACTION_TYPE_NO_JUMP, "" + currentTimeMillis, true);
        } else if (this.f383186d.a(context, QAdVrReportParams.ClickAdActionTypeValue.ACTION_TYPE_NO_JUMP) != 0) {
            Walnut walnut7 = this.f383186d;
            walnut7.getClass();
            walnut7.a(context, QAdVrReportParams.ClickAdActionTypeValue.ACTION_TYPE_NO_JUMP, "0", true);
        }
        this.f383186d.getClass();
        try {
            j3 = Long.valueOf(Walnut.b(context, "401")).longValue();
        } catch (Throwable unused2) {
            j3 = 0;
        }
        if (a17.f383115c < 0) {
            this.f383186d.a(context, j3 + 1);
        } else if (j3 != 0) {
            this.f383186d.a(context, 0L);
        }
        this.f383186d.getClass();
        if (!TextUtils.isEmpty(Walnut.b(context, "404"))) {
            this.f383186d.a(context, "404", "", true);
        }
        if (a17.f383115c == 0) {
            Walnut walnut8 = this.f383186d;
            String str = j.f383378a;
            long a27 = walnut8.a(context, "502");
            long myUid2 = Process.myUid();
            if (a27 != myUid2) {
                walnut8.a(context, "502", "" + myUid2, false);
            }
        }
        this.f383186d.a(context, ThemeReporter.FROM_AUTH, String.format("%d_%d_%d_%d_%d_%d", Integer.valueOf(a17.f383115c), Integer.valueOf(z16 ? 1 : 0), Integer.valueOf(i3), 0, Integer.valueOf(a17.f383120h), Integer.valueOf(a17.f383121i)));
        return a17;
    }

    public final Sultana a(Context context, byte[] bArr, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Sultana) iPatchRedirector.redirect((short) 9, this, context, bArr, Integer.valueOf(i3));
        }
        try {
            HashMap hashMap = new HashMap();
            if (Warden.f383204f.a("e_w_t", false)) {
                hashMap.put("2007", "1");
            }
            SparseArray<Object> b89_A931D6BEC30CD812 = TNative$aa.b89_A931D6BEC30CD812(new SparseArray(), bArr, hashMap, i3);
            int b16 = Bagasse.b(b89_A931D6BEC30CD812);
            if (b16 != 0) {
                return Sultana.a(b16);
            }
            Integer num = (Integer) Bagasse.a(b89_A931D6BEC30CD812, 102, Integer.class);
            if (num == null) {
                return Sultana.a(AppConstants.RichMediaErrorCode.ERROR_LOCAL_OUT_MEM);
            }
            if (num.intValue() < 0) {
                return Sultana.a(num.intValue() + AppConstants.RichMediaErrorCode.ERROR_LOCAL_OUT_MEM);
            }
            String str = (String) Bagasse.a(b89_A931D6BEC30CD812, 101, String.class);
            int i16 = Plum.f383026a;
            if (str == null) {
                str = "";
            }
            if (TextUtils.isEmpty(str)) {
                return Sultana.a(num.intValue() - 10010);
            }
            String str2 = (String) Bagasse.a(b89_A931D6BEC30CD812, 104, String.class);
            if (str2 == null) {
                str2 = "";
            }
            String str3 = (String) Bagasse.a(b89_A931D6BEC30CD812, 105, String.class);
            if (str3 == null) {
                str3 = "";
            }
            String str4 = (String) Bagasse.a(b89_A931D6BEC30CD812, 106, String.class);
            if (str4 == null) {
                str4 = "";
            }
            Integer num2 = (Integer) Bagasse.a(b89_A931D6BEC30CD812, 107, Integer.class);
            String str5 = (String) Bagasse.a(b89_A931D6BEC30CD812, 108, String.class);
            if (str5 == null) {
                str5 = "";
            }
            if (num2 == null || num2.intValue() < 3600) {
                num2 = 3600;
            }
            long currentTimeMillis = (System.currentTimeMillis() / 1000) + num2.intValue();
            Sultana.Cdo cdo = new Sultana.Cdo(0);
            cdo.f383123b = currentTimeMillis;
            cdo.f383122a = str;
            cdo.f383125d = str2;
            cdo.f383126e = str3;
            cdo.f383127f = str4;
            cdo.f383128g = str5;
            Sultana sultana = new Sultana(cdo);
            Walnut walnut = this.f383186d;
            walnut.getClass();
            HashMap hashMap2 = new HashMap();
            hashMap2.put("101", sultana.f383113a);
            hashMap2.put("102", "" + sultana.f383114b);
            if (!TextUtils.isEmpty(sultana.f383116d)) {
                hashMap2.put("104", sultana.f383116d);
            }
            if (!TextUtils.isEmpty(sultana.f383117e)) {
                hashMap2.put("105", sultana.f383117e);
            }
            if (!TextUtils.isEmpty(sultana.f383118f)) {
                hashMap2.put("106", sultana.f383118f);
            }
            if (!TextUtils.isEmpty(sultana.f383119g)) {
                hashMap2.put("110", sultana.f383119g);
            }
            walnut.a(context, (Map<String, String>) hashMap2, true);
            Walnut walnut2 = this.f383186d;
            long intValue = num2.intValue();
            walnut2.getClass();
            walnut2.a(context, "107", "" + intValue, true);
            walnut2.a(context, "108", "" + (System.currentTimeMillis() / 1000), true);
            return sultana;
        } catch (Throwable unused) {
            return Sultana.a(-10007);
        }
    }

    public static String a(long j3, long j16) {
        MediaDrm mediaDrm;
        try {
            UUID uuid = new UUID(j3, j16);
            mediaDrm = new MediaDrm(uuid);
            try {
                byte[] propertyByteArray = mediaDrm.getPropertyByteArray("deviceUniqueId");
                if (propertyByteArray.length == 0) {
                    try {
                        if (Build.VERSION.SDK_INT >= 28) {
                            mediaDrm.close();
                        } else {
                            mediaDrm.release();
                        }
                    } catch (Throwable unused) {
                    }
                    return null;
                }
                String str = uuid + ":" + Plum.a(propertyByteArray);
                try {
                    if (Build.VERSION.SDK_INT >= 28) {
                        mediaDrm.close();
                    } else {
                        mediaDrm.release();
                    }
                } catch (Throwable unused2) {
                }
                return str;
            } catch (Throwable unused3) {
                try {
                    if (Build.VERSION.SDK_INT >= 28) {
                        if (mediaDrm != null) {
                            mediaDrm.close();
                        }
                    } else if (mediaDrm != null) {
                        mediaDrm.release();
                    }
                } catch (Throwable unused4) {
                }
                return null;
            }
        } catch (Throwable unused5) {
            mediaDrm = null;
        }
    }
}
