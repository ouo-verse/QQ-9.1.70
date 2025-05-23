package com.tencent.tfd.sdk.wxa;

import android.content.Context;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.qzone.proxy.personalitycomponent.adapter.PersonalityConfig;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.msf.core.c0.g;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.tfd.sdk.wxa.Cantaloupe;
import com.tencent.tfd.sdk.wxa.Cpackage;
import com.tencent.tfd.sdk.wxa.Draco;
import com.tencent.tfd.sdk.wxa.Solar;
import cooperation.qzone.util.WnsError;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class Cherry {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    public static final Cherry f375527h;

    /* renamed from: i, reason: collision with root package name */
    public static long f375528i;

    /* renamed from: j, reason: collision with root package name */
    public static int[] f375529j;

    /* renamed from: a, reason: collision with root package name */
    public Bryony f375530a;

    /* renamed from: b, reason: collision with root package name */
    public Cdo f375531b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f375532c;

    /* renamed from: d, reason: collision with root package name */
    public Chestnut f375533d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f375534e;

    /* renamed from: f, reason: collision with root package name */
    public final AtomicReference<Cantaloupe> f375535f;

    /* renamed from: g, reason: collision with root package name */
    public final AtomicReference<Boolean> f375536g;

    /* compiled from: P */
    /* renamed from: com.tencent.tfd.sdk.wxa.Cherry$do, reason: invalid class name */
    /* loaded from: classes26.dex */
    public class Cdo extends Handler {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public Context f375537a;

        public Cdo(Looper looper, Context context) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Cherry.this, looper, context);
            } else {
                this.f375537a = context;
            }
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            System.currentTimeMillis();
            int i3 = message.what;
            if (i3 != 1) {
                if (i3 == 2) {
                    Cherry.this.a(Cherry.this.a(this.f375537a, true, false, ((Integer) message.obj).intValue()), false);
                    synchronized (Cherry.this.f375536g) {
                        Cherry.this.f375536g.set(Boolean.FALSE);
                        Cherry.this.f375536g.notifyAll();
                    }
                    return;
                }
                return;
            }
            Cherry.this.a(this.f375537a, true, 3);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62486);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f375527h = new Cherry();
        f375528i = TimeUnit.MINUTES.toMillis(30L);
        f375529j = new int[]{0, 15, 30, 90, 240, 360, 600, 1200, WnsError.WNS_CODE_DIS_STAT_BEGIN, g.T0, 4800, 7200};
    }

    public Cherry() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f375532c = false;
        this.f375534e = new Object();
        this.f375535f = new AtomicReference<>(null);
        this.f375536g = new AtomicReference<>(Boolean.FALSE);
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [java.util.Map<java.lang.String, com.tencent.tfd.sdk.wxa.Draco$do>, java.util.concurrent.ConcurrentHashMap] */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.util.Map<java.lang.String, com.tencent.tfd.sdk.wxa.Draco$do>, java.util.concurrent.ConcurrentHashMap] */
    public static void a(Cherry cherry) {
        Context context;
        Context context2;
        long j3;
        String str;
        File file;
        cherry.getClass();
        synchronized (Cgoto.class) {
            context = Cgoto.f375756a;
        }
        Flat.c(context, cherry.f375533d);
        try {
            LockMethodProxy.sleep(cherry.f375530a.A);
        } catch (InterruptedException unused) {
        }
        Codlin codlin = Codlin.f375548h;
        synchronized (codlin) {
            try {
                System.currentTimeMillis();
                codlin.c(context);
                System.currentTimeMillis();
                codlin.b(context);
            } catch (Throwable unused2) {
            }
        }
        if (codlin.a(39)) {
            cherry.f375533d.getClass();
            if (TextUtils.isEmpty(Chestnut.b(context, "405"))) {
                StringBuilder sb5 = new StringBuilder();
                try {
                    String[] split = new String(Cextends.a("/proc/self/maps")).split("\n");
                    HashSet hashSet = new HashSet();
                    for (String str2 : split) {
                        String[] split2 = str2.split(" +");
                        if (split2.length >= 2) {
                            String trim = split2[split2.length - 1].trim();
                            try {
                                file = new File(trim);
                            } catch (Throwable unused3) {
                                str = null;
                            }
                            if (file.exists()) {
                                str = file.getName();
                                if (str != null && str.contains("res") && str.endsWith(".apk") && !str.contains("mediatek") && !TextUtils.equals("/system/framework/framework-res.apk", trim) && !hashSet.contains(trim)) {
                                    hashSet.add(trim);
                                    String a16 = Cfinally.a(context, trim);
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
                } catch (Throwable unused4) {
                }
                sb5.append(",");
                String name = Resources.getSystem().getClass().getName();
                if (!TextUtils.equals("android.content.res.Resources", name)) {
                    sb5.append(name);
                }
                cherry.f375533d.a(context, "405", sb5.toString().replace("(\\|)|\\s*|\t|\r|\n", ""), true);
            }
        }
        if (cherry.f375530a.f375479v && codlin.a(45)) {
            Chestnut chestnut = cherry.f375533d;
            int i3 = Avocado.f375410b;
            chestnut.getClass();
            try {
                j3 = Long.valueOf(Chestnut.b(context, "902")).longValue();
            } catch (Throwable unused5) {
                j3 = 0;
            }
            if (Math.abs(j3 - System.currentTimeMillis()) >= Avocado.f375409a) {
                if (TextUtils.isEmpty(Chestnut.b(context, "901")) || Math.abs(j3 - System.currentTimeMillis()) >= Coconut.f375544e.a(context, "sid_refresh_period", Coconut.f375543d, 3600000L)) {
                    Apricot b16 = Banana.b(context);
                    if (b16.f375396a != 0) {
                        b16 = Banana.a(context);
                    }
                    if (b16.f375396a == 0) {
                        String str3 = b16.f375399d;
                        HashMap hashMap = new HashMap();
                        hashMap.put("901", str3);
                        Chestnut.a(context, hashMap);
                        String apricot = b16.toString();
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("904", apricot);
                        Chestnut.a(context, hashMap2);
                    }
                }
                chestnut.b(context, System.currentTimeMillis());
            }
        }
        Bryony bryony = cherry.f375530a;
        if (bryony.f375475r) {
            Csynchronized csynchronized = bryony.f375459b;
            if (csynchronized == null) {
                csynchronized = Bryony.D;
            }
            if (csynchronized.userAgreement()) {
                if (codlin.a(41) && Draco.f375595a.containsKey(Draco.f375597c)) {
                    new Dorado((Draco.Cdo) Draco.f375595a.get(Draco.f375597c), context).start();
                }
                cherry.a(cherry.f375530a.f375463f, false, 0);
                Bryony bryony2 = Solar.f375694a;
                synchronized (Cgoto.class) {
                    context2 = Cgoto.f375756a;
                }
                if (Solar.a(context2) != null) {
                    return;
                }
                new Solar.Cdo(true).a();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:320:0x08b4, code lost:
    
        if ((r0 != null && r0.contains("ACCESS_NETWORK_STATE")) != false) goto L303;
     */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0919  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0923  */
    /* JADX WARN: Type inference failed for: r13v6, types: [java.util.HashMap, java.util.Map<java.lang.Integer, java.lang.Long>] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.HashMap, java.util.Map<java.lang.Integer, java.lang.Long>] */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.util.Map<java.lang.String, com.tencent.tfd.sdk.wxa.Draco$do>, java.util.concurrent.ConcurrentHashMap] */
    /* JADX WARN: Type inference failed for: r6v39, types: [java.util.HashMap, java.util.Map<java.lang.Integer, java.lang.Long>] */
    /* JADX WARN: Type inference failed for: r6v8, types: [java.util.Map<java.lang.String, com.tencent.tfd.sdk.wxa.Draco$do>, java.util.concurrent.ConcurrentHashMap] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Cantaloupe b(Context context, boolean z16, int i3) {
        int i16;
        HashSet hashSet;
        String str;
        Dew a16;
        int i17;
        int i18;
        NetworkInfo activeNetworkInfo;
        Map<Integer, String> features;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Cantaloupe) iPatchRedirector.redirect((short) 8, this, context, Boolean.valueOf(z16), Integer.valueOf(i3));
        }
        Codlin codlin = Codlin.f375548h;
        long a17 = codlin.a(context);
        long currentTimeMillis = System.currentTimeMillis();
        int i19 = Bullace.f375489f;
        long currentTimeMillis2 = System.currentTimeMillis();
        Cdefault.f375755a.clear();
        HashMap hashMap = new HashMap();
        StringBuilder a18 = Pyxis.a("");
        a18.append(UrsaMinor.f375742a);
        hashMap.put("1", a18.toString());
        Bryony bryony = this.f375530a;
        if (bryony != null && bryony.f375480w) {
            hashMap.put("2", "1");
        }
        Bryony bryony2 = this.f375530a;
        hashMap.put("101", TextUtils.isEmpty(bryony2.f375474q) ? "" : bryony2.f375474q);
        hashMap.put(ThemeReporter.FROM_SERVER_SET_THEME, this.f375533d.a(context).f375495a);
        Bryony bryony3 = this.f375530a;
        hashMap.put(ThemeReporter.FROM_PUSH, TextUtils.isEmpty(bryony3.f375465h) ? "" : bryony3.f375465h);
        hashMap.put(ThemeReporter.FROM_CLEANER, Cnative.a(context, z16, i19, this.f375530a.f375477t, i3, this.f375533d));
        hashMap.put("2001", codlin.a());
        Coconut coconut = Coconut.f375544e;
        int i26 = UrsaMinor.f375742a;
        if (i26 == 105668 || i26 == 105928) {
            if (!codlin.a(17) && !codlin.a(18)) {
                hashMap.put("1001", "2");
            }
        } else if (!z16) {
            hashMap.put("1001", "1");
        }
        StringBuilder a19 = Pyxis.a("");
        a19.append((int) coconut.a(context, "m_p_s", 300L, 1L));
        hashMap.put("2012", a19.toString());
        if (codlin.a(136) && Leo.a(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0) {
            hashMap.put("501", "1");
        }
        if (codlin.a(139)) {
            Cpackage.Cdo a26 = Cpackage.a(context);
            if (a26 != null) {
                if (a26.f375763b && !coconut.a(context, "ig_g_l", false)) {
                    hashMap.put("2020", "1");
                } else {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(a26.f375763b ? "1" : "0");
                    sb5.append(",");
                    sb5.append(a26.f375762a);
                    hashMap.put("2020", sb5.toString());
                }
            } else {
                hashMap.put("2020", "-1");
            }
        }
        if (!codlin.a(41)) {
            hashMap.put("2003", "0");
        } else {
            long currentTimeMillis3 = System.currentTimeMillis();
            Eridanus eridanus = Draco.f375596b;
            if (eridanus == null || eridanus.f375606b == 0) {
                if (!Draco.f375595a.containsKey(Draco.f375597c)) {
                    eridanus = Eridanus.a(-10);
                } else if ("main".equals(Thread.currentThread().getName())) {
                    eridanus = Eridanus.a(-11);
                } else {
                    Draco.Cdo cdo = (Draco.Cdo) Draco.f375595a.get(Draco.f375597c);
                    if (cdo != null && (i16 = cdo.f375599b) <= 3) {
                        cdo.f375599b = i16 + 1;
                        Draco.f375596b = cdo.f375598a.b(context);
                    }
                    eridanus = Draco.f375596b;
                }
            }
            hashMap.put("100", eridanus.f375605a);
            Cdefault.a(20, System.currentTimeMillis() - currentTimeMillis3);
            if (!codlin.a(10001)) {
                hashMap.put("2004", "0");
            }
        }
        ITuringDeviceInfoProvider iTuringDeviceInfoProvider = this.f375530a.f375460c;
        if (iTuringDeviceInfoProvider != null) {
            Object obj = new Object();
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            long currentTimeMillis4 = System.currentTimeMillis();
            new Cascara(atomicBoolean, hashMap, iTuringDeviceInfoProvider, obj).start();
            synchronized (obj) {
                try {
                    obj.wait(1000L);
                } catch (InterruptedException unused) {
                }
            }
            if (System.currentTimeMillis() - currentTimeMillis4 > 1000) {
                Log.w("Turing", "invoke info impl timeout");
            }
            atomicBoolean.set(true);
        }
        hashMap.put("264", Creturn.a());
        if (codlin.a(22)) {
            hashMap.put(ThemeReporter.FROM_ENGINE, Cstatic.a(context));
            Cdefault.a(8, Long.valueOf("" + Cstatic.f375777f).longValue());
        }
        if (!codlin.a(10002)) {
            hashMap.put("2005", "0");
        }
        if (!codlin.a(10003)) {
            hashMap.put("2006", "0");
        }
        hashMap.put("266", Chestnut.b(context, "901"));
        if (codlin.a(115)) {
            String b16 = Chamaeleon.b();
            if (b16 == null) {
                b16 = "";
            }
            hashMap.put(IFeatureRuntimeService.MODULE_ID, b16);
        }
        if (codlin.a(116)) {
            String a27 = Andromeda.a();
            if (a27 == null) {
                a27 = "";
            }
            hashMap.put("269", a27);
        }
        if (codlin.a(117)) {
            StringBuilder a28 = Pyxis.a("");
            a28.append(Chamaeleon.a(context));
            hashMap.put("270", a28.toString());
        }
        if (codlin.a(46)) {
            StringBuilder a29 = Pyxis.a("");
            Set<String> set = Cprivate.f375766a;
            if (set.isEmpty()) {
                set.add(Cswitch.a(Cswitch.T0));
                set.add(Cswitch.a(Cswitch.U0));
                set.add(Cswitch.a(Cswitch.V0));
                set.add(Cswitch.a(Cswitch.W0));
                set.add(Cswitch.a(Cswitch.X0));
                set.add(Cswitch.a(Cswitch.Y0));
            }
            Iterator<String> it = set.iterator();
            int i27 = 0;
            int i28 = 0;
            while (it.hasNext()) {
                try {
                    Class.forName(it.next());
                    i27 |= 1 << i28;
                } catch (Throwable unused2) {
                }
                i28++;
            }
            a29.append(i27);
            hashMap.put("271", a29.toString());
        }
        if (codlin.a(118)) {
            StringBuilder a36 = Pyxis.a("");
            a36.append(Ara.b());
            hashMap.put("272", a36.toString());
        }
        if (codlin.a(17) || codlin.a(40)) {
            List<String> a37 = Lynx.a(this.f375530a.f375461d);
            HashSet hashSet2 = new HashSet();
            if (!(a37 == null || ((ArrayList) a37).isEmpty())) {
                hashSet2.addAll(a37);
            }
            String a38 = coconut.a(context, "p_l_h_l");
            if (TextUtils.isEmpty(a38)) {
                hashSet = null;
            } else {
                hashSet = new HashSet();
                Collections.addAll(hashSet, a38.split(","));
            }
            if (hashSet != null) {
                hashSet2.addAll(hashSet);
            }
            if (hashSet2.size() > 0) {
                hashMap.put("277", Lynx.a(hashSet2));
            }
        }
        if (codlin.a(122)) {
            try {
                str = Cfinal.a(context);
            } catch (Throwable unused3) {
                str = "exception";
            }
            hashMap.put("280", str);
        }
        if (codlin.a(126)) {
            hashMap.put("281", String.valueOf(System.currentTimeMillis() - SystemClock.elapsedRealtime()));
        }
        String a39 = coconut.a(context, "x_l2_p_i");
        if (a39 != null) {
            hashMap.put("2014", a39);
        }
        String a46 = coconut.a(context, "x_u_p_i");
        if (a46 != null) {
            hashMap.put("2015", a46);
        }
        String a47 = coconut.a(context);
        if (a47 != null) {
            hashMap.put("2013", a47);
        }
        Codlin codlin2 = Codlin.f375548h;
        if (codlin2.a(39)) {
            this.f375533d.getClass();
            hashMap.put("239", Chestnut.b(context, "405"));
        }
        if (codlin2.a(100)) {
            long currentTimeMillis5 = System.currentTimeMillis();
            String a48 = Andromeda.a(context);
            if (a48 == null) {
                a48 = "";
            }
            hashMap.put("250", a48);
            Cdefault.a(30, System.currentTimeMillis() - currentTimeMillis5);
        }
        if (codlin2.a(101)) {
            long currentTimeMillis6 = System.currentTimeMillis();
            hashMap.put("251", Herbaceous.a(context) > 0 ? "1" : "0");
            Cdefault.a(31, System.currentTimeMillis() - currentTimeMillis6);
        }
        if (codlin2.a(102)) {
            hashMap.put("252", Bergamot.a(context) ? "1" : "0");
        }
        if (codlin2.a(103)) {
            StringBuilder a49 = Pyxis.a("");
            a49.append(Chamaeleon.d(context));
            hashMap.put("253", a49.toString());
        }
        if (codlin2.a(104)) {
            StringBuilder a56 = Pyxis.a("");
            a56.append(Chamaeleon.b(context));
            hashMap.put("254", a56.toString());
        }
        if (codlin2.a(105)) {
            StringBuilder a57 = Pyxis.a("");
            a57.append(Cbreak.a(context));
            hashMap.put("255", a57.toString());
        }
        if (codlin2.a(106)) {
            long currentTimeMillis7 = System.currentTimeMillis();
            String a58 = Chamaeleon.a();
            if (a58 == null) {
                a58 = "";
            }
            hashMap.put("256", a58);
            Cdefault.a(32, System.currentTimeMillis() - currentTimeMillis7);
        }
        if (codlin2.a(107)) {
            String f16 = Chamaeleon.f(context);
            if (f16 == null) {
                f16 = "";
            }
            hashMap.put("257", f16);
        }
        if (codlin2.a(113)) {
            long currentTimeMillis8 = System.currentTimeMillis();
            hashMap.put("258", Octans.a() ? "1" : "0");
            Cdefault.a(40, System.currentTimeMillis() - currentTimeMillis8);
        }
        if (codlin2.a(114)) {
            long currentTimeMillis9 = System.currentTimeMillis();
            hashMap.put("259", Octans.a(context) ? "1" : "0");
            Cdefault.a(41, System.currentTimeMillis() - currentTimeMillis9);
        }
        if (codlin2.a(44)) {
            long currentTimeMillis10 = System.currentTimeMillis();
            hashMap.put("240", Blueberry.a());
            Cdefault.a(42, System.currentTimeMillis() - currentTimeMillis10);
        }
        if (codlin2.a(138)) {
            hashMap.put("282", Chamaeleon.c(context));
        }
        StringBuilder a59 = Pyxis.a("");
        a59.append(this.f375530a.f375471n);
        hashMap.put("403", a59.toString());
        hashMap.put("402", this.f375530a.f375469l);
        hashMap.put("404", this.f375530a.f375470m);
        hashMap.put("401", this.f375530a.f375472o);
        this.f375530a.getClass();
        hashMap.put("405", null);
        Map<Integer, String> map = this.f375530a.f375473p;
        StringBuilder sb6 = new StringBuilder();
        Iterator<Integer> it5 = map.keySet().iterator();
        while (it5.hasNext()) {
            int intValue = it5.next().intValue();
            sb6.append(intValue);
            sb6.append("_");
            sb6.append(Bennet.a(",", "%54", Bennet.a("_", "%5F", map.get(Integer.valueOf(intValue)))));
            if (it5.hasNext()) {
                sb6.append(",");
            }
        }
        hashMap.put(PersonalityConfig.RESERVES_COVER_CLICK_WIDGET_VISITOR_WITH_NANE_PLATGE, sb6.toString());
        this.f375533d.getClass();
        hashMap.put("302", Chestnut.b(context, ThemeReporter.FROM_DIY));
        this.f375533d.getClass();
        hashMap.put("303", Chestnut.b(context, ThemeReporter.FROM_NIGHT));
        this.f375533d.getClass();
        hashMap.put("305", Chestnut.b(context, ThemeReporter.FROM_WEEKLOOP));
        hashMap.put("308", "" + GalacticCore.a(context));
        this.f375533d.getClass();
        hashMap.put("309", Chestnut.b(context, "404"));
        this.f375533d.getClass();
        hashMap.put("310", Chestnut.b(context, ThemeReporter.FROM_ENGINE));
        ITuringIoTFeatureMap iTuringIoTFeatureMap = this.f375530a.f375462e;
        try {
            SparseArray<Object> a77 = TNative$aa.a77(new SparseArray(), context, hashMap, (iTuringIoTFeatureMap == null || (features = iTuringIoTFeatureMap.getFeatures(context)) == null || features.isEmpty()) ? null : features, i19);
            this.f375533d.a(context, ThemeReporter.FROM_DIY, (System.currentTimeMillis() - currentTimeMillis2) + "_" + (z16 ? 1 : 0));
            int b17 = Equuleus.b(a77);
            byte[] a65 = Equuleus.a(a77);
            StringBuilder sb7 = new StringBuilder();
            String str2 = (String) Equuleus.a(a77, 2, String.class);
            if (str2 == null) {
                str2 = "";
            }
            sb7.append(str2);
            StringBuilder sb8 = new StringBuilder();
            Iterator it6 = Cdefault.f375755a.keySet().iterator();
            while (it6.hasNext()) {
                int intValue2 = ((Integer) it6.next()).intValue();
                sb8.append(",");
                sb8.append(intValue2);
                sb8.append("_");
                sb8.append(Cdefault.f375755a.get(Integer.valueOf(intValue2)));
            }
            sb7.append(sb8.toString());
            this.f375533d.a(context, ThemeReporter.FROM_ENGINE, sb7.toString());
            Chestnut chestnut = this.f375533d;
            long length = a65.length;
            chestnut.getClass();
            chestnut.a(context, ThemeReporter.FROM_WEEKLOOP, "" + length + "_" + (z16 ? 1 : 0));
            try {
                this.f375530a.getClass();
            } catch (Throwable unused4) {
            }
            if (b17 != 0) {
                a16 = Dew.a(b17);
            } else if (a65.length == 0) {
                a16 = Dew.a(-10003);
            } else {
                a16 = new Dew(0, a65);
            }
        } catch (Throwable unused5) {
            a16 = Dew.a(-10006);
        }
        Dew dew = a16;
        long currentTimeMillis11 = System.currentTimeMillis() - currentTimeMillis;
        int i29 = dew.f375591a;
        if (i29 != 0) {
            return Cantaloupe.a(i29);
        }
        long currentTimeMillis12 = System.currentTimeMillis();
        Durian a66 = Cumquat.f375573b.a(dew.f375592b);
        try {
            activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Throwable th5) {
            String message = th5.getMessage();
        }
        if (activeNetworkInfo != null && (activeNetworkInfo.getState() == NetworkInfo.State.CONNECTING || activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED)) {
            if (NetworkMonitor.getType(activeNetworkInfo) != 1) {
                if (NetworkMonitor.getType(activeNetworkInfo) == 0) {
                    if (Proxy.getDefaultHost() == null) {
                        if (Proxy.getHost(context) == null) {
                            i17 = 1;
                            this.f375533d.a(context, ThemeReporter.FROM_NIGHT, i17 + "_" + (System.currentTimeMillis() - currentTimeMillis12) + "_" + a17 + "_" + (z16 ? 1 : 0) + "_" + dew.f375592b.length + "_" + currentTimeMillis11 + "_" + (System.currentTimeMillis() - currentTimeMillis));
                            i18 = a66.f375601a;
                            if (i18 == 0) {
                            }
                        }
                    }
                    i17 = 2;
                    this.f375533d.a(context, ThemeReporter.FROM_NIGHT, i17 + "_" + (System.currentTimeMillis() - currentTimeMillis12) + "_" + a17 + "_" + (z16 ? 1 : 0) + "_" + dew.f375592b.length + "_" + currentTimeMillis11 + "_" + (System.currentTimeMillis() - currentTimeMillis));
                    i18 = a66.f375601a;
                    if (i18 == 0) {
                    }
                }
            } else {
                i17 = 0;
                this.f375533d.a(context, ThemeReporter.FROM_NIGHT, i17 + "_" + (System.currentTimeMillis() - currentTimeMillis12) + "_" + a17 + "_" + (z16 ? 1 : 0) + "_" + dew.f375592b.length + "_" + currentTimeMillis11 + "_" + (System.currentTimeMillis() - currentTimeMillis));
                i18 = a66.f375601a;
                if (i18 == 0) {
                    return new Cantaloupe(i18, a66.f375602b, a66.f375603c);
                }
                byte[] bArr = a66.f375604d;
                int i36 = Bullace.f375489f;
                try {
                    HashMap hashMap2 = new HashMap();
                    if (Coconut.f375544e.a(context, "e_w_t", false)) {
                        hashMap2.put("2007", "1");
                    }
                    SparseArray<Object> b77 = TNative$aa.b77(new SparseArray(), bArr, hashMap2, i36);
                    int b18 = Equuleus.b(b77);
                    if (b18 != 0) {
                        return Cantaloupe.a(b18);
                    }
                    Integer num = (Integer) Equuleus.a(b77, 102, Integer.class);
                    if (num == null) {
                        return Cantaloupe.a(AppConstants.RichMediaErrorCode.ERROR_LOCAL_OUT_MEM);
                    }
                    if (num.intValue() < 0) {
                        return Cantaloupe.a(num.intValue() + AppConstants.RichMediaErrorCode.ERROR_LOCAL_OUT_MEM);
                    }
                    String str3 = (String) Equuleus.a(b77, 101, String.class);
                    if (str3 == null) {
                        str3 = "";
                    }
                    if (TextUtils.isEmpty(str3)) {
                        return Cantaloupe.a(num.intValue() - 10010);
                    }
                    String str4 = (String) Equuleus.a(b77, 104, String.class);
                    if (str4 == null) {
                        str4 = "";
                    }
                    String str5 = (String) Equuleus.a(b77, 105, String.class);
                    if (str5 == null) {
                        str5 = "";
                    }
                    String str6 = (String) Equuleus.a(b77, 106, String.class);
                    if (str6 == null) {
                        str6 = "";
                    }
                    Integer num2 = (Integer) Equuleus.a(b77, 107, Integer.class);
                    String str7 = (String) Equuleus.a(b77, 108, String.class);
                    if (str7 == null) {
                        str7 = "";
                    }
                    if (num2 == null || num2.intValue() < 3600) {
                        num2 = 3600;
                    }
                    long currentTimeMillis13 = (System.currentTimeMillis() / 1000) + num2.intValue();
                    Cantaloupe.Cdo cdo2 = new Cantaloupe.Cdo();
                    cdo2.f375505b = currentTimeMillis13;
                    cdo2.f375504a = str3;
                    cdo2.f375507d = str4;
                    cdo2.f375508e = str5;
                    cdo2.f375509f = str6;
                    cdo2.f375510g = str7;
                    Cantaloupe cantaloupe = new Cantaloupe(cdo2);
                    Chestnut chestnut2 = this.f375533d;
                    chestnut2.getClass();
                    HashMap hashMap3 = new HashMap();
                    hashMap3.put("101", cantaloupe.f375495a);
                    hashMap3.put("102", "" + cantaloupe.f375496b);
                    if (!TextUtils.isEmpty(cantaloupe.f375498d)) {
                        hashMap3.put("104", cantaloupe.f375498d);
                    }
                    if (!TextUtils.isEmpty(cantaloupe.f375499e)) {
                        hashMap3.put("105", cantaloupe.f375499e);
                    }
                    if (!TextUtils.isEmpty(cantaloupe.f375500f)) {
                        hashMap3.put("106", cantaloupe.f375500f);
                    }
                    if (!TextUtils.isEmpty(cantaloupe.f375501g)) {
                        hashMap3.put("110", cantaloupe.f375501g);
                    }
                    chestnut2.a(context, (Map<String, String>) hashMap3, true);
                    Chestnut chestnut3 = this.f375533d;
                    long intValue3 = num2.intValue();
                    chestnut3.getClass();
                    chestnut3.a(context, "107", "" + intValue3, true);
                    chestnut3.a(context, "108", "" + (System.currentTimeMillis() / 1000), true);
                    return cantaloupe;
                } catch (Throwable unused6) {
                    return Cantaloupe.a(-10007);
                }
            }
        }
        i17 = -1;
        this.f375533d.a(context, ThemeReporter.FROM_NIGHT, i17 + "_" + (System.currentTimeMillis() - currentTimeMillis12) + "_" + a17 + "_" + (z16 ? 1 : 0) + "_" + dew.f375592b.length + "_" + currentTimeMillis11 + "_" + (System.currentTimeMillis() - currentTimeMillis));
        i18 = a66.f375601a;
        if (i18 == 0) {
        }
    }

    public final Cantaloupe a(Context context) {
        Cantaloupe cantaloupe;
        Cantaloupe a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Cantaloupe) iPatchRedirector.redirect((short) 9, (Object) this, (Object) context);
        }
        synchronized (this.f375535f) {
            cantaloupe = this.f375535f.get();
            if (cantaloupe == null) {
                Chestnut chestnut = this.f375533d;
                if (chestnut != null) {
                    a16 = chestnut.a(context);
                } else {
                    a16 = Cantaloupe.a(1);
                }
                cantaloupe = a16;
                this.f375535f.set(cantaloupe);
            }
        }
        return cantaloupe;
    }

    public final void a(Cantaloupe cantaloupe, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, cantaloupe, Boolean.valueOf(z16));
            return;
        }
        synchronized (this.f375535f) {
            if (!z16) {
                if (cantaloupe.f375497c != 0) {
                    return;
                }
            }
            this.f375535f.set(cantaloupe);
        }
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        synchronized (this.f375536g) {
            if (this.f375536g.get().booleanValue()) {
                return;
            }
            this.f375536g.set(Boolean.TRUE);
            this.f375531b.sendMessageDelayed(Message.obtain(this.f375531b, 2, 3), 0L);
        }
    }

    public final Cantaloupe a(Context context, boolean z16, int i3) {
        Cantaloupe a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Cantaloupe) iPatchRedirector.redirect((short) 5, this, context, Boolean.valueOf(z16), Integer.valueOf(i3));
        }
        Cantaloupe a17 = a(context);
        if (this.f375530a == null) {
            return Cantaloupe.a(-10002);
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
            return Cantaloupe.a(-10008);
        }
        synchronized (this.f375534e) {
            a16 = a(context);
            if (a16 == a17 || a(a16) != 1) {
                synchronized (this.f375536g) {
                    if (!this.f375536g.get().booleanValue()) {
                        this.f375536g.set(Boolean.TRUE);
                        this.f375531b.post(new Casaba(this, context, i3));
                    }
                    try {
                        this.f375536g.wait(z16 ? this.f375530a.f375481x : 10000L);
                    } catch (InterruptedException unused) {
                    }
                }
                a16 = a(context);
                if (a16 == a17) {
                    a16 = Cantaloupe.a(-10004);
                }
            }
        }
        return a16;
    }

    public final int a(Cantaloupe cantaloupe) {
        Context context;
        long j3;
        Context context2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, (Object) cantaloupe)).intValue();
        }
        if (this.f375530a.f375476s || cantaloupe.f375497c != 0 || TextUtils.isEmpty(cantaloupe.f375495a)) {
            return 2;
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (currentTimeMillis >= cantaloupe.f375496b) {
            this.f375530a.getClass();
            return 3;
        }
        Chestnut chestnut = this.f375533d;
        synchronized (Cgoto.class) {
            context = Cgoto.f375756a;
        }
        chestnut.getClass();
        try {
            j3 = Long.valueOf(Chestnut.b(context, "107")).longValue();
        } catch (Throwable unused) {
            j3 = 0;
        }
        Chestnut chestnut2 = this.f375533d;
        synchronized (Cgoto.class) {
            context2 = Cgoto.f375756a;
        }
        if (Math.abs(currentTimeMillis - chestnut2.a(context2, "108")) < j3) {
            return 1;
        }
        this.f375530a.getClass();
        return 3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x00f9, code lost:
    
        if (r21 != false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0124, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0120, code lost:
    
        if (java.lang.Math.abs(java.lang.System.currentTimeMillis() - r3.longValue()) >= com.tencent.tfd.sdk.wxa.Cherry.f375528i) goto L63;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00fc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Cantaloupe a(Context context, boolean z16, boolean z17, int i3) {
        Context context2;
        Context context3;
        String a16;
        Cantaloupe a17;
        long j3;
        Context context4;
        Context context5;
        byte b16;
        Context context6;
        long j16;
        byte b17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Cantaloupe) iPatchRedirector.redirect((short) 7, this, context, Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i3));
        }
        if (!GalacticCore.b(context)) {
            return Cantaloupe.a(-10012);
        }
        if (!this.f375530a.f375476s) {
            synchronized (Cgoto.class) {
                context4 = Cgoto.f375756a;
            }
            if ((Math.abs((System.currentTimeMillis() / 1000) - (this.f375533d.a(context4, QAdVrReportParams.ClickAdActionTypeValue.ACTION_TYPE_NO_JUMP) / 1000)) > 3600) == false) {
                return Cantaloupe.a(-30015);
            }
            Chestnut chestnut = this.f375533d;
            synchronized (Cgoto.class) {
                context5 = Cgoto.f375756a;
            }
            Centaurus b18 = chestnut.b(context5);
            if (b18.f375526b.size() != 0) {
                Chestnut chestnut2 = this.f375533d;
                synchronized (Cgoto.class) {
                    context6 = Cgoto.f375756a;
                }
                chestnut2.getClass();
                try {
                    j16 = Long.valueOf(Chestnut.b(context6, "401")).longValue();
                } catch (Throwable unused) {
                    j16 = 0;
                }
                if (j16 > 0) {
                    long abs = Math.abs(System.currentTimeMillis() - ((Long) b18.f375526b.getLast()).longValue());
                    int[] iArr = f375529j;
                    int length = j16 < ((long) iArr.length) ? (int) j16 : iArr.length - 1;
                    if (length >= 1) {
                        if (iArr[length - 1] >= iArr[length]) {
                            throw new IllegalArgumentException("");
                        }
                        if (abs <= TimeUnit.SECONDS.toMillis(new Random().nextInt((r3 - r5) + 1) + r5)) {
                            b17 = false;
                            if (b17 == false) {
                                Long l3 = (Long) b18.f375526b.getFirst();
                                if (b18.f375526b.size() >= b18.f375525a) {
                                }
                            }
                            if (b16 == false) {
                                return Cantaloupe.a(-10011);
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
        Chestnut chestnut3 = this.f375533d;
        synchronized (Cgoto.class) {
            context2 = Cgoto.f375756a;
        }
        Centaurus b19 = chestnut3.b(context2);
        b19.a(Long.valueOf(System.currentTimeMillis()));
        Chestnut chestnut4 = this.f375533d;
        synchronized (Cgoto.class) {
            context3 = Cgoto.f375756a;
        }
        chestnut4.getClass();
        StringBuilder sb5 = new StringBuilder();
        for (int i16 = 0; i16 < b19.f375526b.size(); i16++) {
            sb5.append(b19.f375526b.get(i16));
            if (i16 != b19.f375526b.size() - 1) {
                sb5.append("_");
            }
        }
        chestnut4.a(context3, "402", sb5.toString(), true);
        synchronized (LeoMinor.class) {
            a16 = LeoMinor.a(context, LeoMinor.f375652a);
        }
        if (!TextUtils.isEmpty(a16)) {
            this.f375533d.a(context, "404", a16, true);
        }
        Flat.c(context, this.f375533d);
        Flat.b(context, this.f375533d);
        if (Coconut.f375544e.a(context, "e_b_d", false)) {
            SparseArray sparseArray = new SparseArray();
            TNative$aa.c77(sparseArray, context);
            Equuleus.b(sparseArray);
        }
        try {
            a17 = b(context, z16, i3);
        } catch (Throwable th5) {
            Log.w("TuringFdJava", th5);
            a17 = Cantaloupe.a(-10015);
        }
        if (a17.f375497c == -30015) {
            Chestnut chestnut5 = this.f375533d;
            long currentTimeMillis = System.currentTimeMillis();
            chestnut5.getClass();
            chestnut5.a(context, QAdVrReportParams.ClickAdActionTypeValue.ACTION_TYPE_NO_JUMP, "" + currentTimeMillis, true);
        } else if (this.f375533d.a(context, QAdVrReportParams.ClickAdActionTypeValue.ACTION_TYPE_NO_JUMP) != 0) {
            Chestnut chestnut6 = this.f375533d;
            chestnut6.getClass();
            chestnut6.a(context, QAdVrReportParams.ClickAdActionTypeValue.ACTION_TYPE_NO_JUMP, "0", true);
        }
        this.f375533d.getClass();
        try {
            j3 = Long.valueOf(Chestnut.b(context, "401")).longValue();
        } catch (Throwable unused2) {
            j3 = 0;
        }
        if (a17.f375497c < 0) {
            this.f375533d.a(context, j3 + 1);
        } else if (j3 != 0) {
            this.f375533d.a(context, 0L);
        }
        this.f375533d.getClass();
        if (!TextUtils.isEmpty(Chestnut.b(context, "404"))) {
            this.f375533d.a(context, "404", "", true);
        }
        if (a17.f375497c == 0) {
            Flat.a(context, this.f375533d);
            Date date = Date.f375589a;
            Chestnut chestnut7 = this.f375533d;
            if (date.a(context, chestnut7)) {
                chestnut7.a(context, "112", "" + System.currentTimeMillis(), false);
            }
        }
        this.f375533d.a(context, ThemeReporter.FROM_AUTH, String.format("%d_%d_%d_%d_%d_%d", Integer.valueOf(a17.f375497c), Integer.valueOf(z16 ? 1 : 0), Integer.valueOf(i3), 0, Integer.valueOf(a17.f375502h), Integer.valueOf(a17.f375503i)));
        return a17;
    }
}
