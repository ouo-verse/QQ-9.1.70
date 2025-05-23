package com.tencent.turingfd.sdk.xq;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.accessibility.AccessibilityManager;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qzone.proxy.personalitycomponent.adapter.PersonalityConfig;
import com.tencent.mobileqq.mini.config.AppSetting;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Guava {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final String f382799a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f382800b;

    /* renamed from: c, reason: collision with root package name */
    public static Strawberry f382801c;

    /* renamed from: d, reason: collision with root package name */
    public static final AtomicReference<Haw> f382802d;

    /* compiled from: P */
    /* renamed from: com.tencent.turingfd.sdk.xq.Guava$do, reason: invalid class name */
    /* loaded from: classes27.dex */
    public static class Cdo implements Callable<Haw> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        public static final HashMap<String, FutureTask<Haw>> f382803d;

        /* renamed from: a, reason: collision with root package name */
        public final String f382804a;

        /* renamed from: b, reason: collision with root package name */
        public final Map<Integer, String> f382805b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f382806c;

        /* compiled from: P */
        /* renamed from: com.tencent.turingfd.sdk.xq.Guava$do$do, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes27.dex */
        public class C10032do implements Comparator<Integer> {
            static IPatchRedirector $redirector_;

            public C10032do(Cdo cdo) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) cdo);
                }
            }

            @Override // java.util.Comparator
            public int compare(Integer num, Integer num2) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) num, (Object) num2)).intValue();
                }
                return num.intValue() - num2.intValue();
            }
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11788);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f382803d = new HashMap<>();
            }
        }

        public Cdo(Map<Integer, String> map, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, map, Boolean.valueOf(z16));
                return;
            }
            this.f382805b = map;
            this.f382806c = z16;
            if (map != null && !map.isEmpty()) {
                TreeMap treeMap = new TreeMap(new C10032do(this));
                treeMap.putAll(map);
                Iterator it = treeMap.keySet().iterator();
                StringBuilder sb5 = new StringBuilder();
                while (it.hasNext()) {
                    sb5.append((String) treeMap.get((Integer) it.next()));
                }
                this.f382804a = sb5.toString();
                return;
            }
            this.f382804a = "";
        }

        public synchronized void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else {
                f382803d.remove(this.f382804a);
            }
        }

        public synchronized FutureTask<Haw> b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (FutureTask) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            HashMap<String, FutureTask<Haw>> hashMap = f382803d;
            FutureTask<Haw> futureTask = hashMap.get(this.f382804a);
            if (futureTask == null || futureTask.isDone()) {
                futureTask = new FutureTask<>(this);
                Cstrictfp.f383431a.submit(futureTask);
                hashMap.put(this.f382804a, futureTask);
            }
            return futureTask;
        }

        /* JADX WARN: Type inference failed for: r0v4, types: [com.tencent.turingfd.sdk.xq.Haw, java.lang.Object] */
        @Override // java.util.concurrent.Callable
        public Haw call() throws Exception {
            Context context;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return iPatchRedirector.redirect((short) 5, (Object) this);
            }
            synchronized (Celse.class) {
                context = Celse.f383328a;
            }
            Grape grape = new Grape();
            try {
                Watermelon.f383208g.a(context);
                grape.f382794b = 1;
                grape.f382797e = System.currentTimeMillis();
                byte[] a16 = Guava.a(context, this.f382805b, grape, this.f382806c);
                grape.f382798f = System.currentTimeMillis();
                grape.f382795c = a16.length;
                Haw a17 = Guava.a(context, a16, grape);
                Guava.a(context, a17);
                Guava.a(context, grape);
                return a17;
            } catch (Throwable unused) {
                return new Haw(-10015);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11790);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        f382799a = Ccontinue.a(Ccontinue.f383251a1);
        f382800b = Ccontinue.a(Ccontinue.f383263e1);
        f382802d = new AtomicReference<>(null);
    }

    public static Haw a(Context context, byte[] bArr, Grape grape) {
        if (bArr.length == 0) {
            return new Haw(-1000);
        }
        c a16 = Wild.f383217b.a(5, bArr, 8123, 18123, null);
        int i3 = a16.f383233a;
        if (i3 != 0) {
            return new Haw(i3);
        }
        byte[] bArr2 = a16.f383236d;
        try {
            Marc marc = new Marc();
            marc.f382917a = -999;
            if (grape.f382794b == 1) {
                marc = (Marc) q.a(marc, bArr2);
            } else {
                marc.a(new Serpens(bArr2));
            }
            if (marc == null) {
                return new Haw(-1002);
            }
            int i16 = marc.f382917a;
            if (i16 == 0) {
                if (TextUtils.isEmpty(marc.f382918b)) {
                    return new Haw(-1001);
                }
                Orange.a(marc.f382922f, marc.f382921e);
                int seconds = (int) TimeUnit.MINUTES.toSeconds(10L);
                if (marc.f382919c < 0) {
                    marc.f382919c = seconds;
                }
                return new Haw(0, marc.f382918b, System.currentTimeMillis(), marc.f382919c * 1000, marc.f382920d, marc.f382921e);
            }
            return new Haw((-2000) - i16);
        } catch (Throwable unused) {
            return new Haw(-999);
        }
    }

    public static Haw a(Context context, Map<Integer, String> map, int i3, long j3) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return new Haw(-10008);
        }
        Haw a16 = a(context);
        if (a16 != null && (a16.f382811e & 1) != 0) {
            i3 |= 1;
        }
        if (map != null && !map.isEmpty()) {
            i3 = (i3 & (-2)) | 2;
        }
        boolean z16 = (i3 & 1) != 0;
        boolean z17 = (i3 & 2) == 0;
        if (z16 && a16 != null) {
            if (Bennet.c(context) && Math.abs(System.currentTimeMillis() - a16.f382809c) >= a16.f382810d) {
                new Cdo(null, true).b();
            }
            return a16;
        }
        if (!Bennet.c(context)) {
            return (!z17 || a16 == null) ? new Haw(-10012) : a16;
        }
        Cdo cdo = new Cdo(map, false);
        FutureTask<Haw> b16 = cdo.b();
        try {
            if (j3 <= 0) {
                j3 = f382801c.f383102x;
            }
            return b16.get(j3, TimeUnit.MILLISECONDS);
        } catch (TimeoutException unused) {
            return (!z17 || a16 == null) ? new Haw(-10004) : a16;
        } catch (Exception unused2) {
            return (!z17 || a16 == null) ? new Haw(-10015) : a16;
        } finally {
            cdo.a();
        }
    }

    public static void a(Context context, Grape grape) {
        long j3;
        StringBuilder a16 = Flat.a("5_");
        a16.append(grape.f382794b);
        a16.append("_");
        a16.append(grape.f382796d);
        a16.append("_");
        a16.append(System.currentTimeMillis() - grape.f382793a);
        a16.append("_");
        a16.append(grape.f382795c);
        a16.append("_");
        long j16 = grape.f382797e;
        if (j16 >= 0) {
            long j17 = grape.f382798f;
            if (j17 >= j16) {
                j3 = j17 - j16;
                a16.append(j3);
                String sb5 = a16.toString();
                String str = Walnut.f383198b;
                HashMap hashMap = new HashMap();
                hashMap.put("703", sb5);
                Walnut.a(context, hashMap);
            }
        }
        j3 = -1;
        a16.append(j3);
        String sb52 = a16.toString();
        String str2 = Walnut.f383198b;
        HashMap hashMap2 = new HashMap();
        hashMap2.put("703", sb52);
        Walnut.a(context, hashMap2);
    }

    public static String a(Context context, int i3, Ctransient ctransient, boolean z16) {
        String str;
        SparseArray<Object> h89_A931D6BEC30CD812;
        HashMap hashMap = new HashMap();
        StringBuilder sb5 = new StringBuilder();
        str = "";
        sb5.append("");
        sb5.append(i3);
        hashMap.put("3", sb5.toString());
        if (i3 == 17 || i3 == 40) {
            long currentTimeMillis = System.currentTimeMillis();
            List<String> a16 = Cantaloupe.a(f382801c.f383082d);
            ctransient.a(-i3, System.currentTimeMillis() - currentTimeMillis);
            HashSet hashSet = new HashSet();
            if (!Creturn.a(a16)) {
                hashSet.addAll(a16);
            }
            if (i3 == 17 && z16) {
                Set<String> d16 = Warden.f383204f.d();
                if (d16 != null) {
                    hashSet.addAll(d16);
                }
                hashSet.add(context.getPackageName());
            }
            hashMap.put("3005", z16 ? "1" : "0");
            if (hashSet.size() > 0) {
                hashMap.put("277", Cantaloupe.a(hashSet));
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        try {
            h89_A931D6BEC30CD812 = TNative$aa.h89_A931D6BEC30CD812(new SparseArray(), context, hashMap, 0);
        } catch (Throwable unused) {
        }
        if (Bagasse.b(h89_A931D6BEC30CD812) != 0) {
            return "";
        }
        String str2 = (String) Bagasse.a(h89_A931D6BEC30CD812, 205, String.class);
        int i16 = Plum.f383026a;
        str = str2 != null ? str2 : "";
        ctransient.f383452a.put(Integer.valueOf(i3), Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
        return str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static byte[] a(Context context, Map map, Grape grape, boolean z16) {
        long j3;
        boolean z17;
        byte b16;
        String str;
        String a16;
        String a17;
        String a18;
        Context context2;
        String str2;
        TextUtils.SimpleStringSplitter simpleStringSplitter;
        String str3;
        BufferedReader bufferedReader;
        String str4;
        Cwhile[] cwhileArr;
        Cwhile[] cwhileArr2;
        boolean z18;
        int i3;
        long currentTimeMillis = System.currentTimeMillis();
        Ctransient ctransient = new Ctransient();
        HashMap hashMap = new HashMap();
        StringBuilder a19 = Flat.a("");
        a19.append(Nectarine.f382928a);
        hashMap.put("1", a19.toString());
        Strawberry strawberry = f382801c;
        if (strawberry != null && strawberry.f383100v) {
            hashMap.put("2", "1");
        }
        Watermelon watermelon = Watermelon.f383208g;
        if (watermelon.a(28)) {
            boolean z19 = f382801c.f383097s;
            int i16 = 0;
            while (true) {
                if (i16 >= 3) {
                    break;
                }
                Sultana a26 = Vermillion.f383180l.a(context, true, 1);
                int i17 = a26.f383115c;
                if (i17 != 0) {
                    f382801c.f383097s = true;
                    if (i17 != 0 && ((i3 = grape.f382796d) == 0 || (i3 == -10011 && i17 != -10011))) {
                        grape.f382796d = i17;
                    }
                    i16++;
                } else {
                    hashMap.put(ThemeReporter.FROM_SERVER_SET_THEME, a26.f383113a);
                    grape.f382796d = 0;
                    break;
                }
            }
            f382801c.f383097s = z19;
        }
        if (watermelon.a(22)) {
            long currentTimeMillis2 = System.currentTimeMillis();
            hashMap.put(ThemeReporter.FROM_ENGINE, Cabstract.a(context));
            ctransient.a(22, System.currentTimeMillis() - currentTimeMillis2);
        }
        if (watermelon.a(100)) {
            long currentTimeMillis3 = System.currentTimeMillis();
            String a27 = Leo.a(context);
            if (a27 == null) {
                a27 = "";
            }
            j3 = currentTimeMillis;
            z17 = false;
            b16 = true;
            Grapefruit.a(hashMap, "250", a27, currentTimeMillis3, ctransient, 100);
        } else {
            j3 = currentTimeMillis;
            z17 = false;
            b16 = true;
        }
        if (watermelon.a(101)) {
            Grapefruit.a(hashMap, "251", s.b(context) > 0 ? "1" : "0", System.currentTimeMillis(), ctransient, 101);
        }
        if (watermelon.a(102)) {
            Grapefruit.a(hashMap, "252", (Settings.Secure.getInt(context.getContentResolver(), "mock_location", z17 ? 1 : 0) != 0 ? b16 : z17 ? 1 : 0) != false ? "1" : "0", System.currentTimeMillis(), ctransient, 102);
        }
        if (watermelon.a(103)) {
            long currentTimeMillis4 = System.currentTimeMillis();
            StringBuilder a28 = Flat.a("");
            a28.append(Almond.d(context));
            hashMap.put("253", a28.toString());
            ctransient.a(103, System.currentTimeMillis() - currentTimeMillis4);
        }
        if (watermelon.a(104)) {
            long currentTimeMillis5 = System.currentTimeMillis();
            StringBuilder a29 = Flat.a("");
            a29.append(Almond.b(context));
            hashMap.put("254", a29.toString());
            ctransient.a(104, System.currentTimeMillis() - currentTimeMillis5);
        }
        if (watermelon.a(105)) {
            long currentTimeMillis6 = System.currentTimeMillis();
            StringBuilder a36 = Flat.a("");
            a36.append(Cthis.a(context));
            hashMap.put("255", a36.toString());
            ctransient.a(105, System.currentTimeMillis() - currentTimeMillis6);
        }
        if (watermelon.a(106)) {
            long currentTimeMillis7 = System.currentTimeMillis();
            String a37 = Almond.a();
            if (a37 == null) {
                a37 = "";
            }
            Grapefruit.a(hashMap, "256", a37, currentTimeMillis7, ctransient, 106);
        }
        if (watermelon.a(115)) {
            long currentTimeMillis8 = System.currentTimeMillis();
            String b17 = Almond.b();
            if (b17 == null) {
                b17 = "";
            }
            Grapefruit.a(hashMap, IFeatureRuntimeService.MODULE_ID, b17, currentTimeMillis8, ctransient, 115);
        }
        if (watermelon.a(116)) {
            long currentTimeMillis9 = System.currentTimeMillis();
            String a38 = Leo.a();
            if (a38 == null) {
                a38 = "";
            }
            Grapefruit.a(hashMap, "269", a38, currentTimeMillis9, ctransient, 116);
        }
        if (watermelon.a(107)) {
            long currentTimeMillis10 = System.currentTimeMillis();
            String f16 = Almond.f(context);
            if (f16 == null) {
                f16 = "";
            }
            Grapefruit.a(hashMap, "257", f16, currentTimeMillis10, ctransient, 107);
        }
        if (watermelon.a(113)) {
            Grapefruit.a(hashMap, "258", Cherry.a() ? "1" : "0", System.currentTimeMillis(), ctransient, 113);
        }
        if (watermelon.a(114)) {
            long currentTimeMillis11 = System.currentTimeMillis();
            try {
                z18 = Cherry.a(context);
            } catch (Throwable unused) {
                z18 = z17 ? 1 : 0;
            }
            Grapefruit.a(hashMap, "259", z18 ? "1" : "0", currentTimeMillis11, ctransient, 114);
        }
        long currentTimeMillis12 = System.currentTimeMillis();
        StringBuilder a39 = Flat.a("");
        a39.append(Almond.a(context));
        hashMap.put("270", a39.toString());
        ctransient.a(117, System.currentTimeMillis() - currentTimeMillis12);
        if (watermelon.a(44)) {
            long currentTimeMillis13 = System.currentTimeMillis();
            hashMap.put("240", Sorgo.a());
            ctransient.a(44, System.currentTimeMillis() - currentTimeMillis13);
        }
        if (watermelon.a(17)) {
            hashMap.put("267", a(context, 17, ctransient, z17));
        } else if (watermelon.a(40)) {
            hashMap.put("267", a(context, 40, ctransient, z17));
        } else if (watermelon.a(43)) {
            hashMap.put("267", a(context, 43, ctransient, z17));
        }
        StringBuilder a46 = Flat.a("");
        a46.append((int) Bennet.b(context));
        hashMap.put("308", a46.toString());
        hashMap.put("303", Walnut.b(context, "703"));
        Watermelon watermelon2 = Watermelon.f383208g;
        if (!watermelon2.a(10002)) {
            hashMap.put("2005", "0");
        }
        hashMap.put("2001", watermelon2.a());
        UrsaMinor<Cwhile> ursaMinor = Gooseberry.f382788a;
        try {
            StringBuilder sb5 = new StringBuilder();
            UrsaMinor<Cwhile> ursaMinor2 = Gooseberry.f382789b;
            synchronized (ursaMinor2) {
                cwhileArr = (Cwhile[]) ursaMinor2.f383176b.toArray(Gooseberry.f382790c);
                ursaMinor2.f383176b.clear();
            }
            int length = cwhileArr.length;
            for (int i18 = z17 ? 1 : 0; i18 < length; i18++) {
                Cwhile cwhile = cwhileArr[i18];
                if (cwhile == null) {
                    break;
                }
                sb5.append(cwhile.a());
                sb5.append(ContainerUtils.FIELD_DELIMITER);
            }
            UrsaMinor<Cwhile> ursaMinor3 = Gooseberry.f382788a;
            synchronized (ursaMinor3) {
                cwhileArr2 = (Cwhile[]) ursaMinor3.f383176b.toArray(Gooseberry.f382790c);
                ursaMinor3.f383176b.clear();
            }
            int length2 = cwhileArr2.length;
            for (int i19 = z17 ? 1 : 0; i19 < length2; i19++) {
                Cwhile cwhile2 = cwhileArr2[i19];
                if (cwhile2 == null) {
                    break;
                }
                sb5.append(cwhile2.a());
                sb5.append(ContainerUtils.FIELD_DELIMITER);
            }
            str = sb5.toString();
            if (TextUtils.isEmpty(str)) {
                str = "unknown";
            }
        } catch (Throwable unused2) {
            str = "unknown";
        }
        hashMap.put("273", str);
        HashMap hashMap2 = new HashMap(f382801c.f383094p);
        if (map != null && !map.isEmpty()) {
            hashMap2.putAll(map);
        }
        StringBuilder sb6 = new StringBuilder();
        Iterator it = hashMap2.keySet().iterator();
        while (it.hasNext()) {
            int intValue = ((Integer) it.next()).intValue();
            sb6.append(intValue);
            sb6.append("_");
            sb6.append(Plum.a(",", "%54", Plum.a("_", "%5F", (String) hashMap2.get(Integer.valueOf(intValue)))));
            if (it.hasNext()) {
                sb6.append(",");
            }
        }
        hashMap.put(PersonalityConfig.RESERVES_COVER_CLICK_WIDGET_VISITOR_WITH_NANE_PLATGE, sb6.toString());
        Warden warden = Warden.f383204f;
        if (warden.a("e_r_t", z17)) {
            hashMap.put("278", "1");
        }
        hashMap.put("266", Walnut.b(context, "901"));
        long currentTimeMillis14 = System.currentTimeMillis();
        StringBuilder a47 = Flat.a("");
        a47.append(Lyra.b());
        hashMap.put("272", a47.toString());
        ctransient.a(118, System.currentTimeMillis() - currentTimeMillis14);
        String str5 = null;
        if (Watermelon.f383208g.a(120)) {
            long currentTimeMillis15 = System.currentTimeMillis();
            StringBuilder sb7 = new StringBuilder();
            sb7.append("");
            System.currentTimeMillis();
            HashSet hashSet = new HashSet();
            try {
                bufferedReader = new BufferedReader(new FileReader(Ccontinue.a(Ccontinue.f383288n)));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        String a48 = Lynx.a(readLine);
                        if (a48 != null) {
                            hashSet.add(a48);
                        }
                    } catch (Throwable unused3) {
                    }
                }
            } catch (Throwable unused4) {
                bufferedReader = null;
            }
            Eridanus.a(bufferedReader);
            if (hashSet.size() > 0) {
                StringBuilder sb8 = new StringBuilder();
                Iterator it5 = hashSet.iterator();
                while (it5.hasNext()) {
                    sb8.append((String) it5.next());
                    if (it5.hasNext()) {
                        sb8.append(",");
                    }
                }
                str4 = sb8.toString();
            } else {
                str4 = "";
            }
            sb7.append(str4);
            hashMap.put("279", sb7.toString());
            ctransient.a(120, System.currentTimeMillis() - currentTimeMillis15);
        }
        long currentTimeMillis16 = System.currentTimeMillis();
        synchronized (Blueberry.class) {
            a16 = Blueberry.a(context, Blueberry.f382612b);
        }
        hashMap.put("309", a16);
        ctransient.f383453b.put(9, Long.valueOf(System.currentTimeMillis() - currentTimeMillis16));
        if (watermelon.a(122)) {
            long currentTimeMillis17 = System.currentTimeMillis();
            try {
                str3 = Cpublic.a();
            } catch (Throwable unused5) {
                str3 = "exception";
            }
            Grapefruit.a(hashMap, "280", str3, currentTimeMillis17, ctransient, 122);
        }
        String a49 = warden.a();
        if (a49 != null) {
            hashMap.put("2013", a49);
        }
        if (watermelon.a(126)) {
            hashMap.put("281", String.valueOf(System.currentTimeMillis() - SystemClock.elapsedRealtime()));
        }
        ITuringDeviceInfoProvider iTuringDeviceInfoProvider = f382801c.f383081c;
        if (iTuringDeviceInfoProvider != null) {
            try {
                long currentTimeMillis18 = System.currentTimeMillis();
                String imei = iTuringDeviceInfoProvider.getImei();
                if (imei == null) {
                    imei = "";
                }
                hashMap.put("274", imei);
                ctransient.a(47, System.currentTimeMillis() - currentTimeMillis18);
                long currentTimeMillis19 = System.currentTimeMillis();
                String imsi = iTuringDeviceInfoProvider.getImsi();
                if (imsi == null) {
                    imsi = "";
                }
                hashMap.put("276", imsi);
                ctransient.a(49, System.currentTimeMillis() - currentTimeMillis19);
                long currentTimeMillis20 = System.currentTimeMillis();
                String androidId = iTuringDeviceInfoProvider.getAndroidId();
                if (androidId == null) {
                    androidId = "";
                }
                hashMap.put("275", androidId);
                ctransient.a(48, System.currentTimeMillis() - currentTimeMillis20);
            } catch (Throwable th5) {
                Log.w("Turing", "invoke info impl exception", th5);
            }
        }
        long currentTimeMillis21 = System.currentTimeMillis();
        hashMap.put("264", Cprivate.a());
        ctransient.a(24, System.currentTimeMillis() - currentTimeMillis21);
        StringBuilder sb9 = new StringBuilder();
        sb9.append("C:");
        sb9.append(z16 ? "1" : "0");
        hashMap.put(ThemeReporter.FROM_CLEANER, sb9.toString());
        if (!warden.e()) {
            a17 = Ccontinue.a(Ccontinue.f383278j1);
        } else {
            a17 = warden.a("c_s_l");
        }
        if (a17 != null) {
            hashMap.put(AppSetting.SUPVERSION, a17);
        }
        if (!warden.e()) {
            a18 = Ccontinue.a(Ccontinue.f383281k1);
        } else {
            a18 = warden.a("p_s_l");
        }
        if (a18 != null) {
            hashMap.put("2017", a18);
        }
        String a56 = warden.a("p_d_l");
        if (a56 != null) {
            hashMap.put("2022", a56);
        }
        hashMap.put("2018", String.valueOf(Process.myUid()));
        long currentTimeMillis22 = System.currentTimeMillis();
        PackageManager packageManager = context.getPackageManager();
        try {
            Object a57 = Coconut.a(packageManager.getClass(), f382799a, packageManager);
            if (a57 != null) {
                StringBuilder sb10 = new StringBuilder();
                Class<?> cls = a57.getClass();
                sb10.append(cls.getName());
                sb10.append(",");
                Class<? super Object> superclass = cls.getSuperclass();
                if (superclass != null && superclass != Object.class) {
                    sb10.append(superclass.getName());
                }
                sb10.append(",");
                ClassLoader classLoader = cls.getClassLoader();
                if (classLoader != null && classLoader != Application.class.getClassLoader()) {
                    sb10.append(classLoader.toString().replace(",", ""));
                }
                str5 = sb10.toString();
            }
        } catch (Throwable unused6) {
        }
        String str6 = str5;
        ctransient.a(133, System.currentTimeMillis() - currentTimeMillis22);
        if (!TextUtils.isEmpty(str6)) {
            hashMap.put("2019", str6);
        }
        if (watermelon.a(140)) {
            long currentTimeMillis23 = System.currentTimeMillis();
            StringBuilder sb11 = new StringBuilder();
            try {
                HashSet hashSet2 = new HashSet();
                AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
                sb11.append(accessibilityManager.isEnabled() ? 1 : 0);
                sb11.append(",");
                sb11.append(accessibilityManager.isTouchExplorationEnabled() ? 1 : 0);
                sb11.append(",");
                boolean z26 = true;
                for (AccessibilityServiceInfo accessibilityServiceInfo : accessibilityManager.getEnabledAccessibilityServiceList(-1)) {
                    if (z26) {
                        z26 = z17;
                    } else {
                        sb11.append(";");
                    }
                    sb11.append(Integer.toHexString(accessibilityServiceInfo.eventTypes));
                    sb11.append(":");
                    sb11.append(Integer.toHexString(accessibilityServiceInfo.feedbackType));
                    sb11.append(":");
                    sb11.append(Integer.toHexString(accessibilityServiceInfo.flags));
                    sb11.append(":");
                    sb11.append(Integer.toHexString(accessibilityServiceInfo.getCapabilities()));
                    sb11.append(":");
                    String id5 = accessibilityServiceInfo.getId();
                    sb11.append(id5);
                    hashSet2.add(id5);
                    z17 = false;
                }
                sb11.append(",");
                sb11.append(Settings.Secure.getInt(context.getContentResolver(), "accessibility_enabled", -1));
                sb11.append(",");
                TextUtils.SimpleStringSplitter simpleStringSplitter2 = new TextUtils.SimpleStringSplitter(':');
                String string = DeviceInfoMonitor.getString(context.getContentResolver(), "enabled_accessibility_services");
                if (string != null) {
                    simpleStringSplitter2.setString(string);
                    boolean z27 = true;
                    while (simpleStringSplitter2.hasNext()) {
                        String next = simpleStringSplitter2.next();
                        if (!TextUtils.isEmpty(next) && !hashSet2.contains(next)) {
                            String[] split = next.split("/");
                            simpleStringSplitter = simpleStringSplitter2;
                            if (split.length == 2 && !TextUtils.isEmpty(split[0]) && !TextUtils.isEmpty(split[1])) {
                                ComponentName componentName = new ComponentName(split[0], split[1]);
                                if (!hashSet2.contains(componentName.flattenToShortString())) {
                                    if (hashSet2.contains(componentName.flattenToString())) {
                                    }
                                }
                                simpleStringSplitter2 = simpleStringSplitter;
                            }
                            if (z27) {
                                z27 = false;
                            } else {
                                sb11.append(";");
                            }
                            sb11.append(next);
                            simpleStringSplitter2 = simpleStringSplitter;
                        }
                        simpleStringSplitter = simpleStringSplitter2;
                        simpleStringSplitter2 = simpleStringSplitter;
                    }
                }
                str2 = sb11.toString();
            } catch (Throwable unused7) {
                str2 = "exp";
            }
            Grapefruit.a(hashMap, "2021", str2, currentTimeMillis23, ctransient, 140);
        }
        if (watermelon.a(138)) {
            long currentTimeMillis24 = System.currentTimeMillis();
            hashMap.put("282", Almond.c(context));
            ctransient.a(138, System.currentTimeMillis() - currentTimeMillis24);
        }
        if (watermelon.a(145)) {
            long currentTimeMillis25 = System.currentTimeMillis();
            String a58 = Virgo.f383193c.b().a();
            if (a58 != null) {
                hashMap.put("283", a58);
            }
            ctransient.a(145, System.currentTimeMillis() - currentTimeMillis25);
        }
        if (watermelon.a(146)) {
            long currentTimeMillis26 = System.currentTimeMillis();
            synchronized (Celse.class) {
                context2 = Celse.f383328a;
            }
            String a59 = Bennet.a(((ConnectivityManager) context2.getSystemService("connectivity")).getActiveNetwork());
            if (a59 != null) {
                hashMap.put("284", a59);
            }
            ctransient.a(146, System.currentTimeMillis() - currentTimeMillis26);
        }
        if (watermelon.a(147)) {
            String a65 = warden.a("m_c_l_2");
            if (!TextUtils.isEmpty(a65)) {
                hashMap.put("2024", a65);
            }
        }
        StringBuilder sb12 = new StringBuilder();
        Iterator<Integer> it6 = ctransient.f383452a.keySet().iterator();
        while (it6.hasNext()) {
            int intValue2 = it6.next().intValue();
            if (sb12.length() > 0) {
                sb12.append(",");
            }
            sb12.append(intValue2);
            sb12.append("_");
            sb12.append(ctransient.f383452a.get(Integer.valueOf(intValue2)));
        }
        Iterator<Integer> it7 = ctransient.f383453b.keySet().iterator();
        while (it7.hasNext()) {
            int intValue3 = it7.next().intValue();
            if (sb12.length() > 0) {
                sb12.append(",");
            }
            sb12.append('s');
            sb12.append(intValue3);
            sb12.append("_");
            sb12.append(ctransient.f383453b.get(Integer.valueOf(intValue3)));
        }
        hashMap.put("4", sb12.toString());
        try {
            SparseArray<Object> g89_A931D6BEC30CD812 = TNative$aa.g89_A931D6BEC30CD812(new SparseArray(), context, hashMap, grape.f382794b);
            int b18 = Bagasse.b(g89_A931D6BEC30CD812);
            if (b18 != 0) {
                Log.i("TuringDebug", "g : " + b18);
                return new byte[0];
            }
            byte[] a66 = Bagasse.a(g89_A931D6BEC30CD812);
            StringBuilder a67 = Flat.a("5_");
            a67.append(System.currentTimeMillis() - j3);
            String sb13 = a67.toString();
            HashMap hashMap3 = new HashMap();
            hashMap3.put("702", sb13);
            Walnut.a(context, hashMap3);
            return a66;
        } catch (Throwable th6) {
            Log.w("TuringDebug", th6);
            return new byte[0];
        }
    }

    public static Haw a(Context context) {
        long j3;
        int i3;
        Context context2;
        AtomicReference<Haw> atomicReference = f382802d;
        synchronized (atomicReference) {
            Haw haw = atomicReference.get();
            if (haw == null) {
                String b16 = Walnut.b(context, "1001");
                if (TextUtils.isEmpty(b16)) {
                    return null;
                }
                long j16 = 0;
                try {
                    j3 = Long.parseLong(Walnut.b(context, "1002"));
                } catch (Throwable unused) {
                    j3 = 0;
                }
                try {
                    j16 = Long.parseLong(Walnut.b(context, "1003"));
                } catch (Throwable unused2) {
                }
                long j17 = j16;
                try {
                    i3 = Integer.parseInt(Walnut.b(context, QzoneVideoBeaconReport.RESULTCODE_VIDEO_TRIIMRECORD_AVCAMERAUSED));
                } catch (Throwable unused3) {
                    i3 = 0;
                }
                int i16 = i3;
                synchronized (Celse.class) {
                    context2 = Celse.f383328a;
                }
                haw = new Haw(0, b16, j3, j17, i16, Walnut.b(context2, QzoneVideoBeaconReport.RESULTCODE_VIDEO_TRIIMRECORD_DOWNLOADERROR));
                f382802d.set(haw);
            }
            return haw;
        }
    }

    public static void a(Context context, Haw haw) {
        AtomicReference<Haw> atomicReference = f382802d;
        synchronized (atomicReference) {
            if (haw.f382807a != 0) {
                return;
            }
            atomicReference.set(haw);
            String str = Walnut.f383198b;
            if (TextUtils.isEmpty(haw.f382808b)) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("1001", haw.f382808b);
            hashMap.put("1002", String.valueOf(haw.f382809c));
            hashMap.put("1003", String.valueOf(haw.f382810d));
            hashMap.put(QzoneVideoBeaconReport.RESULTCODE_VIDEO_TRIIMRECORD_AVCAMERAUSED, String.valueOf(haw.f382811e));
            String str2 = haw.f382812f;
            int i3 = Plum.f383026a;
            if (str2 == null) {
                str2 = "";
            }
            hashMap.put(QzoneVideoBeaconReport.RESULTCODE_VIDEO_TRIIMRECORD_DOWNLOADERROR, str2);
            Walnut.a(context, hashMap);
        }
    }
}
