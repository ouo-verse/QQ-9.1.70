package com.tencent.tfd.sdk.wxa;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qzone.proxy.personalitycomponent.adapter.PersonalityConfig;
import com.tencent.mobileqq.mini.config.AppSetting;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class Solar {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static Bryony f375694a;

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicReference<Taurus> f375695b;

    /* compiled from: P */
    /* renamed from: com.tencent.tfd.sdk.wxa.Solar$do, reason: invalid class name */
    /* loaded from: classes26.dex */
    public static class Cdo implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: c, reason: collision with root package name */
        public static final Handler f375696c;

        /* renamed from: d, reason: collision with root package name */
        public static final AtomicReference<AtomicReference<Taurus>> f375697d;

        /* renamed from: a, reason: collision with root package name */
        public final boolean f375698a;

        /* renamed from: b, reason: collision with root package name */
        public AtomicReference<Taurus> f375699b;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62728);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            f375697d = new AtomicReference<>(null);
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("TuringRiskThread", 0);
            baseHandlerThread.start();
            f375696c = new Handler(baseHandlerThread.getLooper());
        }

        public Cdo(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, z16);
            } else {
                this.f375698a = z16;
            }
        }

        public final void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            AtomicReference<AtomicReference<Taurus>> atomicReference = f375697d;
            synchronized (atomicReference) {
                AtomicReference<Taurus> atomicReference2 = atomicReference.get();
                this.f375699b = atomicReference2;
                if (atomicReference2 != null) {
                    return;
                }
                AtomicReference<Taurus> atomicReference3 = new AtomicReference<>(null);
                this.f375699b = atomicReference3;
                atomicReference.set(atomicReference3);
                f375696c.post(this);
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            Context context;
            Taurus taurus;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            synchronized (Cgoto.class) {
                context = Cgoto.f375756a;
            }
            Serpens serpens = new Serpens();
            try {
                Codlin.f375548h.a(context);
                serpens.f375689b = 1;
                serpens.f375692e = System.currentTimeMillis();
                byte[] a16 = Solar.a(context, serpens, this.f375698a);
                serpens.f375693f = System.currentTimeMillis();
                serpens.f375690c = a16.length;
                taurus = Solar.a(context, a16, serpens);
                try {
                    Solar.a(context, taurus);
                    Solar.a(context, serpens);
                    AtomicReference<AtomicReference<Taurus>> atomicReference = f375697d;
                    synchronized (atomicReference) {
                        AtomicReference<Taurus> andSet = atomicReference.getAndSet(null);
                        if (andSet != null) {
                            andSet.set(taurus);
                        }
                        atomicReference.notifyAll();
                    }
                } catch (Throwable unused) {
                    AtomicReference<AtomicReference<Taurus>> atomicReference2 = f375697d;
                    synchronized (atomicReference2) {
                        AtomicReference<Taurus> andSet2 = atomicReference2.getAndSet(null);
                        if (andSet2 != null) {
                            if (taurus == null) {
                                taurus = new Taurus(-10015);
                            }
                            andSet2.set(taurus);
                        }
                        atomicReference2.notifyAll();
                    }
                }
            } catch (Throwable unused2) {
                taurus = null;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62729);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f375695b = new AtomicReference<>(null);
        }
    }

    public static void a(Context context, Serpens serpens) {
        long j3;
        StringBuilder a16 = Pyxis.a("5_");
        a16.append(serpens.f375689b);
        a16.append("_");
        a16.append(serpens.f375691d);
        a16.append("_");
        a16.append(System.currentTimeMillis() - serpens.f375688a);
        a16.append("_");
        a16.append(serpens.f375690c);
        a16.append("_");
        long j16 = serpens.f375692e;
        if (j16 >= 0) {
            long j17 = serpens.f375693f;
            if (j17 >= j16) {
                j3 = j17 - j16;
                a16.append(j3);
                String sb5 = a16.toString();
                String str = Chestnut.f375539b;
                HashMap hashMap = new HashMap();
                hashMap.put("703", sb5);
                Chestnut.a(context, hashMap);
            }
        }
        j3 = -1;
        a16.append(j3);
        String sb52 = a16.toString();
        String str2 = Chestnut.f375539b;
        HashMap hashMap2 = new HashMap();
        hashMap2.put("703", sb52);
        Chestnut.a(context, hashMap2);
    }

    public static Taurus a(Context context, byte[] bArr, Serpens serpens) {
        if (bArr.length == 0) {
            return new Taurus(-1000);
        }
        Durian a16 = Cumquat.f375573b.a(bArr);
        int i3 = a16.f375601a;
        if (i3 != 0) {
            return new Taurus(i3);
        }
        byte[] bArr2 = a16.f375604d;
        try {
            UrsaMajor ursaMajor = new UrsaMajor();
            ursaMajor.f375738a = -999;
            if (serpens.f375689b == 1) {
                ursaMajor = (UrsaMajor) Guava.a(ursaMajor, bArr2);
            } else {
                ursaMajor.a(new Caelum(bArr2));
            }
            if (ursaMajor == null) {
                return new Taurus(-1002);
            }
            int i16 = ursaMajor.f375738a;
            if (i16 == 0) {
                if (TextUtils.isEmpty(ursaMajor.f375739b)) {
                    return new Taurus(-1001);
                }
                int seconds = (int) TimeUnit.MINUTES.toSeconds(10L);
                if (ursaMajor.f375740c < seconds) {
                    ursaMajor.f375740c = seconds;
                }
                return new Taurus(0, ursaMajor.f375739b, System.currentTimeMillis(), ursaMajor.f375740c * 1000, ursaMajor.f375741d);
            }
            return new Taurus((-2000) - i16);
        } catch (Throwable unused) {
            return new Taurus(-999);
        }
    }

    public static String a(Context context, int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put("3", "" + i3);
        if (i3 == 17 || i3 == 40) {
            List<String> a16 = Lynx.a(f375694a.f375461d);
            HashSet hashSet = new HashSet();
            if (!(a16 == null || a16.isEmpty())) {
                hashSet.addAll(a16);
            }
            if (hashSet.size() > 0) {
                hashMap.put("277", Lynx.a(hashSet));
            }
        }
        try {
            SparseArray<Object> h77 = TNative$aa.h77(new SparseArray(), context, hashMap, 0);
            if (Equuleus.b(h77) != 0) {
                return "";
            }
            String str = (String) Equuleus.a(h77, 205, String.class);
            String str2 = str != null ? str : "";
            StringBuilder sb5 = new StringBuilder();
            String[] split = str2.split(",");
            for (String str3 : split) {
                if (!str3.split(":")[0].equals("0")) {
                    sb5.append(str3);
                    sb5.append(":");
                    sb5.append(",");
                }
            }
            return sb5.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static byte[] a(Context context, Serpens serpens, boolean z16) {
        String str;
        String a16;
        String str2;
        BufferedReader bufferedReader;
        String str3;
        Sculptor poll;
        Sculptor poll2;
        int i3;
        long currentTimeMillis = System.currentTimeMillis();
        HashMap hashMap = new HashMap();
        StringBuilder a17 = Pyxis.a("");
        a17.append(UrsaMinor.f375742a);
        hashMap.put("1", a17.toString());
        Bryony bryony = f375694a;
        if (bryony != null && bryony.f375480w) {
            hashMap.put("2", "1");
        }
        Codlin codlin = Codlin.f375548h;
        if (codlin.a(28)) {
            boolean z17 = f375694a.f375476s;
            int i16 = 0;
            while (true) {
                if (i16 >= 3) {
                    break;
                }
                Cantaloupe a18 = Cherry.f375527h.a(context, true, 1);
                int i17 = a18.f375497c;
                if (i17 != 0) {
                    f375694a.f375476s = true;
                    if (i17 != 0 && ((i3 = serpens.f375691d) == 0 || (i3 == -10011 && i17 != -10011))) {
                        serpens.f375691d = i17;
                    }
                    i16++;
                } else {
                    hashMap.put(ThemeReporter.FROM_SERVER_SET_THEME, a18.f375495a);
                    serpens.f375691d = 0;
                    break;
                }
            }
            f375694a.f375476s = z17;
        }
        if (codlin.a(22)) {
            hashMap.put(ThemeReporter.FROM_ENGINE, Cstatic.a(context));
        }
        if (codlin.a(100)) {
            String a19 = Andromeda.a(context);
            if (a19 == null) {
                a19 = "";
            }
            hashMap.put("250", a19);
        }
        if (codlin.a(101)) {
            hashMap.put("251", Herbaceous.a(context) > 0 ? "1" : "0");
        }
        if (codlin.a(102)) {
            hashMap.put("252", Bergamot.a(context) ? "1" : "0");
        }
        if (codlin.a(103)) {
            StringBuilder a26 = Pyxis.a("");
            a26.append(Chamaeleon.d(context));
            hashMap.put("253", a26.toString());
        }
        if (codlin.a(104)) {
            StringBuilder a27 = Pyxis.a("");
            a27.append(Chamaeleon.b(context));
            hashMap.put("254", a27.toString());
        }
        if (codlin.a(105)) {
            StringBuilder a28 = Pyxis.a("");
            a28.append(Cbreak.a(context));
            hashMap.put("255", a28.toString());
        }
        if (codlin.a(106)) {
            String a29 = Chamaeleon.a();
            if (a29 == null) {
                a29 = "";
            }
            hashMap.put("256", a29);
        }
        if (codlin.a(115)) {
            String b16 = Chamaeleon.b();
            if (b16 == null) {
                b16 = "";
            }
            hashMap.put(IFeatureRuntimeService.MODULE_ID, b16);
        }
        if (codlin.a(116)) {
            String a36 = Andromeda.a();
            if (a36 == null) {
                a36 = "";
            }
            hashMap.put("269", a36);
        }
        if (codlin.a(107)) {
            String f16 = Chamaeleon.f(context);
            if (f16 == null) {
                f16 = "";
            }
            hashMap.put("257", f16);
        }
        if (codlin.a(113)) {
            hashMap.put("258", Octans.a() ? "1" : "0");
        }
        if (codlin.a(114)) {
            hashMap.put("259", Octans.a(context) ? "1" : "0");
        }
        StringBuilder a37 = Pyxis.a("");
        a37.append(Chamaeleon.a(context));
        hashMap.put("270", a37.toString());
        if (codlin.a(44)) {
            hashMap.put("240", Blueberry.a());
        }
        if (codlin.a(17)) {
            hashMap.put("267", a(context, 17));
        } else if (codlin.a(40)) {
            hashMap.put("267", a(context, 40));
        } else if (codlin.a(43)) {
            hashMap.put("267", a(context, 43));
        }
        StringBuilder a38 = Pyxis.a("");
        a38.append(GalacticCore.a(context));
        hashMap.put("308", a38.toString());
        hashMap.put("303", Chestnut.b(context, "703"));
        Codlin codlin2 = Codlin.f375548h;
        if (!codlin2.a(10002)) {
            hashMap.put("2005", "0");
        }
        hashMap.put("2001", codlin2.a());
        Centaurus<Sculptor> centaurus = Scorpius.f375679a;
        try {
            StringBuilder sb5 = new StringBuilder();
            for (int i18 = 0; i18 < 3; i18++) {
                Centaurus<Sculptor> centaurus2 = Scorpius.f375680b;
                synchronized (centaurus2) {
                    poll2 = centaurus2.f375526b.poll();
                }
                if (poll2 == null) {
                    break;
                }
                sb5.append(poll2.a());
                sb5.append(ContainerUtils.FIELD_DELIMITER);
            }
            for (int i19 = 0; i19 < 3; i19++) {
                Centaurus<Sculptor> centaurus3 = Scorpius.f375679a;
                synchronized (centaurus3) {
                    poll = centaurus3.f375526b.poll();
                }
                if (poll == null) {
                    break;
                }
                sb5.append(poll.a());
                sb5.append(ContainerUtils.FIELD_DELIMITER);
            }
            str = sb5.toString();
            if (TextUtils.isEmpty(str)) {
                str = "unknown";
            }
        } catch (Throwable unused) {
            str = "unknown";
        }
        hashMap.put("273", str);
        Map<Integer, String> map = f375694a.f375473p;
        StringBuilder sb6 = new StringBuilder();
        Iterator<Integer> it = map.keySet().iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            sb6.append(intValue);
            sb6.append("_");
            sb6.append(Bennet.a(",", "%54", Bennet.a("_", "%5F", map.get(Integer.valueOf(intValue)))));
            if (it.hasNext()) {
                sb6.append(",");
            }
        }
        hashMap.put(PersonalityConfig.RESERVES_COVER_CLICK_WIDGET_VISITOR_WITH_NANE_PLATGE, sb6.toString());
        Coconut coconut = Coconut.f375544e;
        if (coconut.a(context, "e_r_t", false)) {
            hashMap.put("278", "1");
        }
        hashMap.put("266", Chestnut.b(context, "901"));
        hashMap.put("272", "" + Ara.b());
        String str4 = null;
        if (Codlin.f375548h.a(120)) {
            StringBuilder sb7 = new StringBuilder();
            sb7.append("");
            System.currentTimeMillis();
            HashSet hashSet = new HashSet();
            try {
                bufferedReader = new BufferedReader(new FileReader(Cswitch.a(Cswitch.f375809n)));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        String a39 = Aquila.a(readLine);
                        if (a39 != null) {
                            hashSet.add(a39);
                        }
                    } catch (Throwable unused2) {
                    }
                }
            } catch (Throwable unused3) {
                bufferedReader = null;
            }
            Cvolatile.a(bufferedReader);
            if (hashSet.size() > 0) {
                StringBuilder sb8 = new StringBuilder();
                Iterator it5 = hashSet.iterator();
                while (it5.hasNext()) {
                    sb8.append((String) it5.next());
                    if (it5.hasNext()) {
                        sb8.append(",");
                    }
                }
                str3 = sb8.toString();
            } else {
                str3 = "";
            }
            sb7.append(str3);
            hashMap.put("279", sb7.toString());
        }
        synchronized (LeoMinor.class) {
            a16 = LeoMinor.a(context, LeoMinor.f375653b);
        }
        hashMap.put("309", a16);
        if (codlin.a(122)) {
            try {
                str2 = Cfinal.a(context);
            } catch (Throwable unused4) {
                str2 = "exception";
            }
            hashMap.put("280", str2);
        }
        String a46 = coconut.a(context);
        if (a46 != null) {
            hashMap.put("2013", a46);
        }
        if (codlin.a(126)) {
            hashMap.put("281", String.valueOf(System.currentTimeMillis() - SystemClock.elapsedRealtime()));
        }
        ITuringDeviceInfoProvider iTuringDeviceInfoProvider = f375694a.f375460c;
        if (iTuringDeviceInfoProvider != null) {
            try {
                String imei = iTuringDeviceInfoProvider.getImei();
                if (imei == null) {
                    imei = "";
                }
                hashMap.put("274", imei);
                String imsi = iTuringDeviceInfoProvider.getImsi();
                if (imsi == null) {
                    imsi = "";
                }
                hashMap.put("276", imsi);
                String androidId = iTuringDeviceInfoProvider.getAndroidId();
                if (androidId == null) {
                    androidId = "";
                }
                hashMap.put("275", androidId);
            } catch (Throwable th5) {
                Log.w("Turing", "invoke info impl exception", th5);
            }
        }
        hashMap.put("264", Creturn.a());
        StringBuilder sb9 = new StringBuilder();
        sb9.append("C:");
        sb9.append(z16 ? "1" : "0");
        hashMap.put(ThemeReporter.FROM_CLEANER, sb9.toString());
        String a47 = coconut.a(context, "c_s_l");
        if (a47 != null) {
            hashMap.put(AppSetting.SUPVERSION, a47);
        }
        String a48 = coconut.a(context, "p_s_l");
        if (a48 != null) {
            hashMap.put("2017", a48);
        }
        String a49 = coconut.a(context, "p_d_l");
        if (a49 != null) {
            hashMap.put("2022", a49);
        }
        hashMap.put("2018", String.valueOf(Process.myUid()));
        PackageManager packageManager = context.getPackageManager();
        try {
            Object a56 = Orion.a(packageManager.getClass(), Cswitch.a(Cswitch.Z0), packageManager);
            if (a56 != null) {
                StringBuilder sb10 = new StringBuilder();
                Class<?> cls = a56.getClass();
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
                str4 = sb10.toString();
            }
        } catch (Throwable unused5) {
        }
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("2019", str4);
        }
        if (codlin.a(140)) {
            hashMap.put("2021", Ccase.a(context));
        }
        if (codlin.a(138)) {
            hashMap.put("282", Chamaeleon.c(context));
        }
        try {
            SparseArray<Object> g77 = TNative$aa.g77(new SparseArray(), context, hashMap, serpens.f375689b);
            int b17 = Equuleus.b(g77);
            if (b17 != 0) {
                Log.i("TuringDebug", "g : " + b17);
                return new byte[0];
            }
            byte[] a57 = Equuleus.a(g77);
            StringBuilder a58 = Pyxis.a("5_");
            a58.append(System.currentTimeMillis() - currentTimeMillis);
            String sb11 = a58.toString();
            HashMap hashMap2 = new HashMap();
            hashMap2.put("702", sb11);
            Chestnut.a(context, hashMap2);
            try {
                f375694a.getClass();
            } catch (Throwable unused6) {
            }
            return a57;
        } catch (Throwable th6) {
            Log.w("TuringDebug", th6);
            return new byte[0];
        }
    }

    public static Taurus a(Context context) {
        long j3;
        int i3;
        AtomicReference<Taurus> atomicReference = f375695b;
        synchronized (atomicReference) {
            Taurus taurus = atomicReference.get();
            if (taurus == null) {
                String b16 = Chestnut.b(context, "1001");
                if (TextUtils.isEmpty(b16)) {
                    return null;
                }
                long j16 = 0;
                try {
                    j3 = Long.parseLong(Chestnut.b(context, "1002"));
                } catch (Throwable unused) {
                    j3 = 0;
                }
                try {
                    j16 = Long.parseLong(Chestnut.b(context, "1003"));
                } catch (Throwable unused2) {
                }
                long j17 = j16;
                try {
                    i3 = Integer.parseInt(Chestnut.b(context, QzoneVideoBeaconReport.RESULTCODE_VIDEO_TRIIMRECORD_AVCAMERAUSED));
                } catch (Throwable unused3) {
                    i3 = 0;
                }
                taurus = new Taurus(0, b16, j3, j17, i3);
                f375695b.set(taurus);
            }
            return taurus;
        }
    }

    public static void a(Context context, Taurus taurus) {
        AtomicReference<Taurus> atomicReference = f375695b;
        synchronized (atomicReference) {
            if (taurus.f375700a != 0) {
                return;
            }
            atomicReference.set(taurus);
            String str = Chestnut.f375539b;
            if (TextUtils.isEmpty(taurus.f375701b)) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("1001", taurus.f375701b);
            hashMap.put("1002", String.valueOf(taurus.f375702c));
            hashMap.put("1003", String.valueOf(taurus.f375703d));
            hashMap.put(QzoneVideoBeaconReport.RESULTCODE_VIDEO_TRIIMRECORD_AVCAMERAUSED, String.valueOf(taurus.f375704e));
            Chestnut.a(context, hashMap);
        }
    }
}
