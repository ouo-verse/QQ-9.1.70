package com.tencent.turingcam;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.TelephonyManager;
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
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.turingcam.AExmx;
import com.tencent.turingcam.HnGHR;
import com.tencent.turingface.sdk.mfa.TNative$aa;
import com.tencent.turingface.sdk.mfa.b;
import com.tencent.turingface.sdk.mfa.d;
import com.tencent.turingface.sdk.mfa.f;
import com.tencent.turingface.sdk.mfa.j;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.WeakHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes27.dex */
public class cPR64 {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final String f382171a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f382172b;

    /* renamed from: c, reason: collision with root package name */
    public static final AtomicReference<bUA8L> f382173c;

    /* loaded from: classes27.dex */
    public static class spXPg implements Callable<bUA8L> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        public static final HashMap<String, FutureTask<bUA8L>> f382174d;

        /* renamed from: a, reason: collision with root package name */
        public final String f382175a;

        /* renamed from: b, reason: collision with root package name */
        public final Map<Integer, String> f382176b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f382177c;

        /* renamed from: com.tencent.turingcam.cPR64$spXPg$spXPg, reason: collision with other inner class name */
        /* loaded from: classes27.dex */
        public class C10026spXPg implements Comparator<Integer> {
            static IPatchRedirector $redirector_;

            public C10026spXPg() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
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
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16023);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f382174d = new HashMap<>();
            }
        }

        public spXPg(Map<Integer, String> map, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, map, Boolean.valueOf(z16));
                return;
            }
            this.f382176b = map;
            this.f382177c = z16;
            if (map != null && !map.isEmpty()) {
                TreeMap treeMap = new TreeMap(new C10026spXPg());
                treeMap.putAll(map);
                Iterator it = treeMap.keySet().iterator();
                StringBuilder sb5 = new StringBuilder();
                while (it.hasNext()) {
                    sb5.append((String) treeMap.get((Integer) it.next()));
                }
                this.f382175a = sb5.toString();
                return;
            }
            this.f382175a = "";
        }

        public FutureTask<bUA8L> a() {
            FutureTask<bUA8L> futureTask;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (FutureTask) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            HashMap<String, FutureTask<bUA8L>> hashMap = f382174d;
            synchronized (hashMap) {
                Iterator<Map.Entry<String, FutureTask<bUA8L>>> it = hashMap.entrySet().iterator();
                while (it.hasNext()) {
                    if (it.next().getValue().isDone()) {
                        it.remove();
                    }
                }
                HashMap<String, FutureTask<bUA8L>> hashMap2 = f382174d;
                futureTask = hashMap2.get(this.f382175a);
                if (futureTask == null || futureTask.isDone()) {
                    futureTask = new FutureTask<>(this);
                    zVR7H.f382476a.submit(futureTask);
                    hashMap2.put(this.f382175a, futureTask);
                }
            }
            return futureTask;
        }

        /* JADX WARN: Type inference failed for: r0v4, types: [com.tencent.turingcam.bUA8L, java.lang.Object] */
        @Override // java.util.concurrent.Callable
        public bUA8L call() {
            Context context;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return iPatchRedirector.redirect((short) 4, (Object) this);
            }
            synchronized (eh5ma.class) {
                context = eh5ma.f382207a;
            }
            MtmV0 mtmV0 = new MtmV0();
            try {
                b.f382488g.a(context);
                mtmV0.f381952b = 0;
                mtmV0.f381955e = System.currentTimeMillis();
                byte[] a16 = cPR64.a(context, this.f382176b, mtmV0, this.f382177c);
                mtmV0.f381956f = System.currentTimeMillis();
                mtmV0.f381953c = a16.length;
                bUA8L a17 = cPR64.a(context, a16, mtmV0);
                cPR64.a(context, a17);
                cPR64.a(context, mtmV0);
                return a17;
            } catch (Throwable unused) {
                return new bUA8L(-10015);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19589);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        f382171a = LwgsO.a(LwgsO.f381883a1);
        f382172b = LwgsO.a(LwgsO.f381895e1);
        f382173c = new AtomicReference<>(null);
    }

    public static void a() {
        Context context;
        Method method;
        VV8k1<wUeOG> vV8k1 = n6fHX.f382314a;
        if (ZY08E.f382121f.a("enable_risk_click", WT9z5.f382089b)) {
            if (Build.VERSION.SDK_INT >= 28) {
                Object obj = lpjAh.f382307a;
                String[] strArr = {"L"};
                boolean z16 = false;
                if (obj != null && (method = lpjAh.f382308b) != null) {
                    try {
                        method.invoke(obj, strArr);
                        z16 = true;
                    } catch (Throwable unused) {
                    }
                }
                if (!z16) {
                    qK8iQ.a();
                }
            }
            Log.i("TRCDM", "erc");
            FE6di fE6di = n6fHX.f382318e;
            synchronized (AExmx.class) {
                WeakHashMap<Activity, Object> weakHashMap = AExmx.f381719a;
                if (fE6di != null) {
                    synchronized (eh5ma.class) {
                        context = eh5ma.f382207a;
                    }
                    if (context instanceof Application) {
                        Application application = (Application) context;
                        AtomicReference<AExmx.spXPg> atomicReference = AExmx.f381720b;
                        synchronized (atomicReference) {
                            if (atomicReference.get() == null) {
                                BaseHandlerThread baseHandlerThread = new BaseHandlerThread("TuringDispatch");
                                baseHandlerThread.start();
                                AExmx.spXPg spxpg = new AExmx.spXPg(new RCWe2(baseHandlerThread.getLooper(), fE6di));
                                atomicReference.set(spxpg);
                                application.registerActivityLifecycleCallbacks(spxpg);
                            }
                        }
                    }
                }
            }
        }
    }

    public static bUA8L a(Context context, byte[] bArr, MtmV0 mtmV0) {
        Iioec iioec;
        if (bArr.length == 0) {
            return new bUA8L(-1000);
        }
        j a16 = com.tencent.turingface.sdk.mfa.a.a().a(8123, 18123, 5, bArr, 200000L, null);
        int i3 = a16.f382527a;
        if (i3 != 0) {
            iioec = new Iioec(i3 - 40000, Iioec.f381858e, a16.f382528b, a16.f382529c);
        } else {
            iioec = new Iioec(0, a16.f382530d, 0, 0);
        }
        int i16 = iioec.f381859a;
        if (i16 != 0) {
            return new bUA8L(i16);
        }
        byte[] bArr2 = iioec.f381862d;
        try {
            flIYu fliyu = new flIYu();
            fliyu.f382248a = -999;
            if (mtmV0.f381952b == 1) {
                fliyu = (flIYu) qtIFA.a(fliyu, bArr2);
            } else {
                YunKQ yunKQ = new YunKQ(bArr2);
                yunKQ.f382114b = "UTF-8";
                fliyu.a(yunKQ);
            }
            if (fliyu == null) {
                return new bUA8L(-1002);
            }
            int i17 = fliyu.f382248a;
            if (i17 == 0) {
                if (TextUtils.isEmpty(fliyu.f382249b)) {
                    return new bUA8L(-1001);
                }
                tLlmS.a(fliyu.f382253f, fliyu.f382252e);
                int seconds = (int) TimeUnit.MINUTES.toSeconds(10L);
                if (fliyu.f382250c < 0) {
                    fliyu.f382250c = seconds;
                }
                return new bUA8L(0, fliyu.f382249b, System.currentTimeMillis(), fliyu.f382250c * 1000, fliyu.f382251d, fliyu.f382252e);
            }
            return new bUA8L((-2000) - i17);
        } catch (Throwable unused) {
            return new bUA8L(-999);
        }
    }

    public static bUA8L a(Context context, Map<Integer, String> map, int i3, long j3) {
        fBfpd fbfpd;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return new bUA8L(-10008);
        }
        bUA8L a16 = a(context);
        if (a16 != null && (a16.f382162e & 1) != 0) {
            i3 |= 1;
        }
        if (map != null && !map.isEmpty()) {
            i3 = (i3 & (-2)) | 2;
        }
        boolean z16 = (i3 & 1) != 0;
        boolean z17 = (i3 & 2) == 0;
        if (z16 && a16 != null) {
            if (kWj12.c(context) && Math.abs(System.currentTimeMillis() - a16.f382160c) >= a16.f382161d) {
                new spXPg(null, true).a();
            }
            return a16;
        }
        if (!kWj12.c(context)) {
            return (!z17 || a16 == null) ? new bUA8L(-10012) : a16;
        }
        FutureTask<bUA8L> a17 = new spXPg(map, false).a();
        if (j3 <= 0) {
            try {
                synchronized (fBfpd.class) {
                    fbfpd = fBfpd.B;
                }
                j3 = fbfpd.f382233t;
            } catch (TimeoutException unused) {
                return (!z17 || a16 == null) ? new bUA8L(-10004) : a16;
            } catch (Exception unused2) {
                return (!z17 || a16 == null) ? new bUA8L(-10015) : a16;
            }
        }
        return a17.get(j3, TimeUnit.MILLISECONDS);
    }

    public static void a(Context context, MtmV0 mtmV0) {
        long j3;
        StringBuilder a16 = tmnyR.a("5_");
        a16.append(mtmV0.f381952b);
        a16.append("_");
        a16.append(mtmV0.f381954d);
        a16.append("_");
        a16.append(System.currentTimeMillis() - mtmV0.f381951a);
        a16.append("_");
        a16.append(mtmV0.f381953c);
        a16.append("_");
        long j16 = mtmV0.f381955e;
        if (j16 >= 0) {
            long j17 = mtmV0.f381956f;
            if (j17 >= j16) {
                j3 = j17 - j16;
                a16.append(j3);
                String sb5 = a16.toString();
                String str = XStYH.f382092b;
                HashMap hashMap = new HashMap();
                hashMap.put("703", sb5);
                XStYH.a(context, hashMap);
            }
        }
        j3 = -1;
        a16.append(j3);
        String sb52 = a16.toString();
        String str2 = XStYH.f382092b;
        HashMap hashMap2 = new HashMap();
        hashMap2.put("703", sb52);
        XStYH.a(context, hashMap2);
    }

    public static String a(Context context, int i3, kwCJn kwcjn, boolean z16, boolean z17) {
        fBfpd fbfpd;
        HashMap hashMap = new HashMap();
        hashMap.put("3", "" + i3);
        hashMap.put("3005", z16 ? "1" : "0");
        hashMap.put("3006", z17 ? "1" : "0");
        if (i3 == 17 || i3 == 40) {
            long currentTimeMillis = System.currentTimeMillis();
            synchronized (fBfpd.class) {
                fbfpd = fBfpd.B;
            }
            fbfpd.getClass();
            List<String> a16 = OCkqn.a((f) null);
            kwcjn.a(-i3, System.currentTimeMillis() - currentTimeMillis);
            HashSet hashSet = new HashSet();
            if (!v0KaV.a(a16)) {
                hashSet.addAll(a16);
            }
            if (z16) {
                Set<String> c16 = ZY08E.f382121f.c();
                if (c16 != null) {
                    hashSet.addAll(c16);
                }
                hashSet.add(context.getPackageName());
            }
            if (!hashSet.isEmpty()) {
                hashMap.put("277", OCkqn.a(hashSet));
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        try {
            SparseArray<Object> h91_FC6D5B0A7013DB60 = TNative$aa.h91_FC6D5B0A7013DB60(new SparseArray(), context, hashMap, 0);
            if (SWw7W.b(h91_FC6D5B0A7013DB60) != 0) {
                return "";
            }
            String str = (String) SWw7W.a(h91_FC6D5B0A7013DB60, 205, String.class);
            Random random = Ckq8l.f381753a;
            if (str == null) {
                str = "";
            }
            kwcjn.f382302a.put(Integer.valueOf(i3), Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
            return str;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static byte[] a(Context context, Map<Integer, String> map, MtmV0 mtmV0, boolean z16) {
        long currentTimeMillis = System.currentTimeMillis();
        kwCJn kwcjn = new kwCJn();
        HashMap<String, String> a16 = a(context, map, mtmV0, z16, kwcjn, false);
        a16.put("4", kwcjn.a());
        try {
            SparseArray<Object> g91_FC6D5B0A7013DB60 = TNative$aa.g91_FC6D5B0A7013DB60(new SparseArray(), context, a16, mtmV0.f381952b);
            int b16 = SWw7W.b(g91_FC6D5B0A7013DB60);
            if (b16 != 0) {
                Log.i("TuringDebug", "g : " + b16);
                return new byte[0];
            }
            byte[] a17 = SWw7W.a(g91_FC6D5B0A7013DB60);
            StringBuilder a18 = tmnyR.a("5_");
            a18.append(System.currentTimeMillis() - currentTimeMillis);
            String sb5 = a18.toString();
            HashMap hashMap = new HashMap();
            hashMap.put("702", sb5);
            XStYH.a(context, hashMap);
            return a17;
        } catch (Throwable th5) {
            Log.w("TuringDebug", th5);
            return new byte[0];
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:123:0x0399, code lost:
    
        if (android.text.TextUtils.isEmpty(r0) != false) goto L151;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x033c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:162:0x049f  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x04c9  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x04e1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0527  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0535  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x05d6  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x05f0  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0600  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x060c  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x061c  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x062b  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0653 A[Catch: all -> 0x06a4, TryCatch #2 {all -> 0x06a4, blocks: (B:218:0x0647, B:220:0x0653, B:224:0x0673, B:225:0x067a, B:227:0x0686, B:229:0x068e, B:230:0x069f), top: B:217:0x0647 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x06b5  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x06c3  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x084f  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x086f  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0899  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x08bb  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x08fa  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x08fe  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x090c  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x092c  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x0954  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x0983  */
    /* JADX WARN: Removed duplicated region for block: B:354:0x07d4  */
    /* JADX WARN: Removed duplicated region for block: B:357:0x07d6 A[Catch: all -> 0x0831, TryCatch #12 {all -> 0x0831, blocks: (B:349:0x07a1, B:351:0x07b0, B:355:0x07dc, B:357:0x07d6, B:370:0x07e0, B:371:0x07f5, B:373:0x07fb, B:376:0x080b, B:381:0x081c, B:384:0x0816, B:390:0x0823), top: B:348:0x07a1 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:394:0x0842  */
    /* JADX WARN: Removed duplicated region for block: B:398:0x0613  */
    /* JADX WARN: Removed duplicated region for block: B:399:0x05f7  */
    /* JADX WARN: Removed duplicated region for block: B:400:0x05da  */
    /* JADX WARN: Removed duplicated region for block: B:401:0x054c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:436:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x031f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static HashMap<String, String> a(Context context, Map<Integer, String> map, MtmV0 mtmV0, boolean z16, kwCJn kwcjn, boolean z17) {
        fBfpd fbfpd;
        boolean z18;
        b bVar;
        String str;
        ZY08E zy08e;
        String a16;
        String a17;
        d dVar;
        String a18;
        String a19;
        String a26;
        String str2;
        boolean z19;
        boolean z26;
        boolean z27;
        String str3;
        String str4;
        String a27;
        boolean z28;
        String str5;
        TextUtils.SimpleStringSplitter simpleStringSplitter;
        Object a28;
        String str6;
        HashSet hashSet;
        BufferedReader bufferedReader;
        String str7;
        VV8k1<wUeOG> vV8k1;
        wUeOG[] wueogArr;
        wUeOG[] wueogArr2;
        boolean z29;
        int i3;
        boolean z36;
        HashMap<String, String> hashMap = new HashMap<>();
        StringBuilder a29 = tmnyR.a("");
        a29.append(WT9z5.f382088a);
        hashMap.put("1", a29.toString());
        synchronized (fBfpd.class) {
            fbfpd = fBfpd.B;
        }
        fbfpd.getClass();
        b bVar2 = b.f382488g;
        boolean z37 = false;
        try {
            if (bVar2.a(28)) {
                mtmV0.getClass();
                if (z17) {
                    jfo8q a36 = T0QUa.f382050l.a(context);
                    if (a36.f382269c == 0) {
                        hashMap.put(ThemeReporter.FROM_SERVER_SET_THEME, a36.f382267a);
                        z36 = false;
                    } else {
                        z36 = true;
                    }
                    hashMap.put("3005", z36 ? "1" : "0");
                    z18 = z36;
                    if (bVar2.a(22)) {
                        long currentTimeMillis = System.currentTimeMillis();
                        hashMap.put(ThemeReporter.FROM_ENGINE, Stvdh.a(context));
                        kwcjn.a(22, System.currentTimeMillis() - currentTimeMillis);
                    }
                    if (bVar2.a(100)) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        String a37 = V124r.a(context);
                        if (a37 == null) {
                            a37 = "";
                        }
                        hashMap.put("250", a37);
                        kwcjn.a(100, System.currentTimeMillis() - currentTimeMillis2);
                    }
                    if (bVar2.a(101)) {
                        long currentTimeMillis3 = System.currentTimeMillis();
                        int a38 = KwqWR.a(context);
                        hashMap.put("251", a38 > 0 ? "1" : "0");
                        hashMap.put("288", String.valueOf(a38));
                        kwcjn.a(101, System.currentTimeMillis() - currentTimeMillis3);
                    }
                    if (bVar2.a(102)) {
                        long currentTimeMillis4 = System.currentTimeMillis();
                        hashMap.put("252", Settings.Secure.getInt(context.getContentResolver(), "mock_location", 0) != 0 ? "1" : "0");
                        kwcjn.a(102, System.currentTimeMillis() - currentTimeMillis4);
                    }
                    if (bVar2.a(103)) {
                        long currentTimeMillis5 = System.currentTimeMillis();
                        StringBuilder a39 = tmnyR.a("");
                        a39.append(EjxAs.d(context));
                        hashMap.put("253", a39.toString());
                        kwcjn.a(103, System.currentTimeMillis() - currentTimeMillis5);
                    }
                    if (bVar2.a(104)) {
                        long currentTimeMillis6 = System.currentTimeMillis();
                        StringBuilder a46 = tmnyR.a("");
                        a46.append(EjxAs.b(context));
                        hashMap.put("254", a46.toString());
                        kwcjn.a(104, System.currentTimeMillis() - currentTimeMillis6);
                    }
                    if (bVar2.a(105)) {
                        long currentTimeMillis7 = System.currentTimeMillis();
                        StringBuilder a47 = tmnyR.a("");
                        a47.append(Amfcp.a(context));
                        hashMap.put("255", a47.toString());
                        kwcjn.a(105, System.currentTimeMillis() - currentTimeMillis7);
                    }
                    if (bVar2.a(106)) {
                        long currentTimeMillis8 = System.currentTimeMillis();
                        String a48 = EjxAs.a();
                        if (a48 == null) {
                            a48 = "";
                        }
                        hashMap.put("256", a48);
                        kwcjn.a(106, System.currentTimeMillis() - currentTimeMillis8);
                    }
                    if (bVar2.a(115)) {
                        long currentTimeMillis9 = System.currentTimeMillis();
                        String b16 = EjxAs.b();
                        if (b16 == null) {
                            b16 = "";
                        }
                        hashMap.put(IFeatureRuntimeService.MODULE_ID, b16);
                        kwcjn.a(115, System.currentTimeMillis() - currentTimeMillis9);
                    }
                    if (bVar2.a(116)) {
                        long currentTimeMillis10 = System.currentTimeMillis();
                        String a49 = V124r.a();
                        if (a49 == null) {
                            a49 = "";
                        }
                        hashMap.put("269", a49);
                        kwcjn.a(116, System.currentTimeMillis() - currentTimeMillis10);
                    }
                    if (bVar2.a(107)) {
                        long currentTimeMillis11 = System.currentTimeMillis();
                        String e16 = EjxAs.e(context);
                        if (e16 == null) {
                            e16 = "";
                        }
                        hashMap.put("257", e16);
                        kwcjn.a(107, System.currentTimeMillis() - currentTimeMillis11);
                    }
                    if (bVar2.a(114)) {
                        long currentTimeMillis12 = System.currentTimeMillis();
                        try {
                            z29 = yMdp8.a(context);
                        } catch (Throwable unused) {
                            z29 = false;
                        }
                        hashMap.put("259", z29 ? "1" : "0");
                        kwcjn.a(114, System.currentTimeMillis() - currentTimeMillis12);
                    }
                    long currentTimeMillis13 = System.currentTimeMillis();
                    StringBuilder a56 = tmnyR.a("");
                    a56.append(EjxAs.a(context));
                    hashMap.put("270", a56.toString());
                    kwcjn.a(117, System.currentTimeMillis() - currentTimeMillis13);
                    if (bVar2.a(44)) {
                        long currentTimeMillis14 = System.currentTimeMillis();
                        hashMap.put("240", YmjBd.a());
                        kwcjn.a(44, System.currentTimeMillis() - currentTimeMillis14);
                    }
                    if (!bVar2.a(17)) {
                        hashMap.put("267", a(context, 17, kwcjn, z18, z17));
                    } else if (bVar2.a(40)) {
                        hashMap.put("267", a(context, 40, kwcjn, z18, z17));
                    } else if (bVar2.a(43)) {
                        hashMap.put("267", a(context, 43, kwcjn, z18, z17));
                    }
                    StringBuilder a57 = tmnyR.a("");
                    a57.append((int) kWj12.b(context));
                    hashMap.put("308", a57.toString());
                    hashMap.put("303", XStYH.b(context, "703"));
                    bVar = b.f382488g;
                    if (!bVar.a(10002)) {
                        hashMap.put("2005", "0");
                    }
                    hashMap.put("2001", bVar.a());
                    VV8k1<wUeOG> vV8k12 = n6fHX.f382314a;
                    StringBuilder sb5 = new StringBuilder();
                    vV8k1 = n6fHX.f382315b;
                    synchronized (vV8k1) {
                        wueogArr = (wUeOG[]) vV8k1.f382070b.toArray(n6fHX.f382316c);
                        vV8k1.f382070b.clear();
                    }
                    for (wUeOG wueog : wueogArr) {
                        if (wueog == null) {
                            break;
                        }
                        sb5.append(wueog.a());
                        sb5.append(ContainerUtils.FIELD_DELIMITER);
                    }
                    VV8k1<wUeOG> vV8k13 = n6fHX.f382314a;
                    synchronized (vV8k13) {
                        wueogArr2 = (wUeOG[]) vV8k13.f382070b.toArray(n6fHX.f382316c);
                        vV8k13.f382070b.clear();
                    }
                    for (wUeOG wueog2 : wueogArr2) {
                        if (wueog2 == null) {
                            break;
                        }
                        sb5.append(wueog2.a());
                        sb5.append(ContainerUtils.FIELD_DELIMITER);
                    }
                    str = sb5.toString();
                } else {
                    boolean z38 = fbfpd.f382229p;
                    int i16 = 0;
                    while (true) {
                        if (i16 >= 3) {
                            break;
                        }
                        jfo8q a58 = T0QUa.f382050l.a(context, true, 1);
                        int i17 = a58.f382269c;
                        if (i17 != 0) {
                            fbfpd.f382229p = true;
                            if (i17 != 0 && ((i3 = mtmV0.f381954d) == 0 || (i3 == -10011 && i17 != -10011))) {
                                mtmV0.f381954d = i17;
                            }
                            i16++;
                        } else {
                            hashMap.put(ThemeReporter.FROM_SERVER_SET_THEME, a58.f382267a);
                            mtmV0.f381954d = 0;
                            break;
                        }
                    }
                    fbfpd.f382229p = z38;
                }
            }
            StringBuilder sb52 = new StringBuilder();
            vV8k1 = n6fHX.f382315b;
            synchronized (vV8k1) {
            }
        } catch (Throwable unused2) {
        }
        z18 = false;
        if (bVar2.a(22)) {
        }
        if (bVar2.a(100)) {
        }
        if (bVar2.a(101)) {
        }
        if (bVar2.a(102)) {
        }
        if (bVar2.a(103)) {
        }
        if (bVar2.a(104)) {
        }
        if (bVar2.a(105)) {
        }
        if (bVar2.a(106)) {
        }
        if (bVar2.a(115)) {
        }
        if (bVar2.a(116)) {
        }
        if (bVar2.a(107)) {
        }
        if (bVar2.a(114)) {
        }
        long currentTimeMillis132 = System.currentTimeMillis();
        StringBuilder a562 = tmnyR.a("");
        a562.append(EjxAs.a(context));
        hashMap.put("270", a562.toString());
        kwcjn.a(117, System.currentTimeMillis() - currentTimeMillis132);
        if (bVar2.a(44)) {
        }
        if (!bVar2.a(17)) {
        }
        StringBuilder a572 = tmnyR.a("");
        a572.append((int) kWj12.b(context));
        hashMap.put("308", a572.toString());
        hashMap.put("303", XStYH.b(context, "703"));
        bVar = b.f382488g;
        if (!bVar.a(10002)) {
        }
        hashMap.put("2001", bVar.a());
        VV8k1<wUeOG> vV8k122 = n6fHX.f382314a;
        str = "unknown";
        hashMap.put("273", str);
        HashMap hashMap2 = new HashMap(fbfpd.f382226m);
        if (map != null && !map.isEmpty()) {
            hashMap2.putAll(map);
        }
        StringBuilder sb6 = new StringBuilder();
        Iterator it = hashMap2.keySet().iterator();
        while (it.hasNext()) {
            int intValue = ((Integer) it.next()).intValue();
            sb6.append(intValue);
            sb6.append("_");
            sb6.append(Ckq8l.a(",", "%54", Ckq8l.a("_", "%5F", (String) hashMap2.get(Integer.valueOf(intValue)))));
            if (it.hasNext()) {
                sb6.append(",");
            }
        }
        hashMap.put(PersonalityConfig.RESERVES_COVER_CLICK_WIDGET_VISITOR_WITH_NANE_PLATGE, sb6.toString());
        hashMap.put("402", fbfpd.f382223j);
        zy08e = ZY08E.f382121f;
        if (zy08e.a("e_r_t", false)) {
            hashMap.put("278", "1");
        }
        hashMap.put("266", XStYH.b(context, "901"));
        long currentTimeMillis15 = System.currentTimeMillis();
        hashMap.put("272", pZZwF.b());
        kwcjn.a(118, System.currentTimeMillis() - currentTimeMillis15);
        if (b.f382488g.a(120)) {
            long currentTimeMillis16 = System.currentTimeMillis();
            System.currentTimeMillis();
            hashSet = new HashSet();
            try {
                bufferedReader = new BufferedReader(new FileReader(LwgsO.a(LwgsO.f381920n)));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        String a59 = YaDRx.a(readLine);
                        if (a59 != null) {
                            hashSet.add(a59);
                        }
                    } catch (Throwable unused3) {
                    }
                }
            } catch (Throwable unused4) {
                bufferedReader = null;
            }
            HDnuc.a(bufferedReader);
            if (hashSet.size() <= 0) {
                StringBuilder sb7 = new StringBuilder();
                Iterator it5 = hashSet.iterator();
                while (it5.hasNext()) {
                    sb7.append((String) it5.next());
                    if (it5.hasNext()) {
                        sb7.append(",");
                    }
                }
                str7 = sb7.toString();
            } else {
                str7 = "";
            }
            hashMap.put("279", str7);
            kwcjn.a(120, System.currentTimeMillis() - currentTimeMillis16);
        }
        long currentTimeMillis17 = System.currentTimeMillis();
        synchronized (ucT3w.class) {
            a16 = ucT3w.a(context, ucT3w.f382402b);
        }
        hashMap.put("309", a16);
        kwcjn.f382303b.put(9, Long.valueOf(System.currentTimeMillis() - currentTimeMillis17));
        if (bVar2.a(122)) {
            long currentTimeMillis18 = System.currentTimeMillis();
            try {
                str6 = ukkac.a();
            } catch (Throwable unused5) {
                str6 = "exception";
            }
            hashMap.put("280", str6);
            kwcjn.a(122, System.currentTimeMillis() - currentTimeMillis18);
        }
        a17 = zy08e.a();
        if (a17 != null) {
            hashMap.put("2013", a17);
        }
        if (bVar2.a(126)) {
            hashMap.put("281", String.valueOf(System.currentTimeMillis() - SystemClock.elapsedRealtime()));
        }
        dVar = fbfpd.f382216c;
        if (dVar != null) {
            try {
                long currentTimeMillis19 = System.currentTimeMillis();
                String imei = dVar.getImei();
                if (imei == null) {
                    imei = "";
                }
                hashMap.put("274", imei);
                kwcjn.a(47, System.currentTimeMillis() - currentTimeMillis19);
                long currentTimeMillis20 = System.currentTimeMillis();
                String imsi = dVar.getImsi();
                if (imsi == null) {
                    imsi = "";
                }
                hashMap.put("276", imsi);
                kwcjn.a(49, System.currentTimeMillis() - currentTimeMillis20);
                long currentTimeMillis21 = System.currentTimeMillis();
                String androidId = dVar.getAndroidId();
                if (androidId == null) {
                    androidId = "";
                }
                hashMap.put("275", androidId);
                kwcjn.a(48, System.currentTimeMillis() - currentTimeMillis21);
            } catch (Throwable th5) {
                Log.w("Turing", "invoke info impl exception", th5);
            }
        }
        long currentTimeMillis22 = System.currentTimeMillis();
        hashMap.put("264", sh4jo.a());
        kwcjn.a(24, System.currentTimeMillis() - currentTimeMillis22);
        StringBuilder sb8 = new StringBuilder();
        sb8.append("C:");
        sb8.append(z16 ? "1" : "0");
        GOzix.a(sb8);
        hashMap.put(ThemeReporter.FROM_CLEANER, sb8.toString());
        if (!zy08e.d()) {
            a18 = LwgsO.a(LwgsO.f381910j1);
        } else {
            a18 = zy08e.a("c_s_l");
        }
        if (a18 != null) {
            hashMap.put(AppSetting.SUPVERSION, a18);
        }
        if (!zy08e.d()) {
            a19 = LwgsO.a(LwgsO.f381913k1);
        } else {
            a19 = zy08e.a("p_s_l");
        }
        if (a19 != null) {
            hashMap.put("2017", a19);
        }
        a26 = zy08e.a("p_d_l");
        if (a26 != null) {
            hashMap.put("2022", a26);
        }
        hashMap.put("2018", String.valueOf(Process.myUid()));
        long currentTimeMillis23 = System.currentTimeMillis();
        PackageManager packageManager = context.getPackageManager();
        try {
            a28 = rBDKv.a(packageManager.getClass(), f382171a, packageManager);
        } catch (Throwable unused6) {
        }
        if (a28 != null) {
            StringBuilder sb9 = new StringBuilder();
            Class<?> cls = a28.getClass();
            sb9.append(cls.getName());
            sb9.append(",");
            Class<? super Object> superclass = cls.getSuperclass();
            if (superclass != null && superclass != Object.class) {
                sb9.append(superclass.getName());
            }
            sb9.append(",");
            ClassLoader classLoader = cls.getClassLoader();
            if (classLoader != null && classLoader != Application.class.getClassLoader()) {
                sb9.append(classLoader.toString().replace(",", ""));
            }
            str2 = sb9.toString();
            kwcjn.a(133, System.currentTimeMillis() - currentTimeMillis23);
            if (!TextUtils.isEmpty(str2)) {
                hashMap.put("2019", str2);
            }
            if (bVar2.a(140)) {
                long currentTimeMillis24 = System.currentTimeMillis();
                StringBuilder sb10 = new StringBuilder();
                try {
                    HashSet hashSet2 = new HashSet();
                    AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
                    sb10.append(accessibilityManager.isEnabled() ? 1 : 0);
                    sb10.append(",");
                    sb10.append(accessibilityManager.isTouchExplorationEnabled() ? 1 : 0);
                    sb10.append(",");
                    boolean z39 = true;
                    for (AccessibilityServiceInfo accessibilityServiceInfo : accessibilityManager.getEnabledAccessibilityServiceList(-1)) {
                        if (z39) {
                            z39 = z37;
                        } else {
                            try {
                                sb10.append(";");
                            } catch (Throwable unused7) {
                                z19 = z18;
                                z26 = false;
                                z27 = true;
                                str5 = "exp";
                                hashMap.put("2021", str5);
                                kwcjn.a(140, System.currentTimeMillis() - currentTimeMillis24);
                                if (bVar2.a(138)) {
                                }
                                if (bVar2.a(145)) {
                                }
                                if (bVar2.a(146)) {
                                }
                                if (bVar2.a(147)) {
                                }
                                if (bVar2.a(149)) {
                                }
                                if (bVar2.a(150)) {
                                }
                                if (bVar2.a(151)) {
                                }
                                if (z19) {
                                }
                                return hashMap;
                            }
                        }
                        jnpyH.a(sb10, accessibilityServiceInfo);
                        hashSet2.add(accessibilityServiceInfo.getId());
                        z37 = false;
                    }
                    sb10.append(",");
                    sb10.append(Settings.Secure.getInt(context.getContentResolver(), "accessibility_enabled", -1));
                    sb10.append(",");
                    String string = DeviceInfoMonitor.getString(context.getContentResolver(), "enabled_accessibility_services");
                    if (!TextUtils.isEmpty(string)) {
                        TextUtils.SimpleStringSplitter simpleStringSplitter2 = new TextUtils.SimpleStringSplitter(':');
                        simpleStringSplitter2.setString(string);
                        boolean z46 = true;
                        while (simpleStringSplitter2.hasNext()) {
                            String next = simpleStringSplitter2.next();
                            if (!TextUtils.isEmpty(next) && !hashSet2.contains(next)) {
                                String[] split = next.split("/");
                                simpleStringSplitter = simpleStringSplitter2;
                                if (split.length == 2) {
                                    try {
                                        if (!TextUtils.isEmpty(split[0])) {
                                            try {
                                                if (!TextUtils.isEmpty(split[1])) {
                                                    z19 = z18;
                                                    z26 = false;
                                                    try {
                                                        z27 = true;
                                                        try {
                                                            ComponentName componentName = new ComponentName(split[0], split[1]);
                                                            if (!hashSet2.contains(componentName.flattenToShortString())) {
                                                                if (hashSet2.contains(componentName.flattenToString())) {
                                                                }
                                                                if (z46) {
                                                                    sb10.append(";");
                                                                } else {
                                                                    z46 = z26;
                                                                }
                                                                sb10.append(next);
                                                            }
                                                            simpleStringSplitter2 = simpleStringSplitter;
                                                            z18 = z19;
                                                        } catch (Throwable unused8) {
                                                            str5 = "exp";
                                                            hashMap.put("2021", str5);
                                                            kwcjn.a(140, System.currentTimeMillis() - currentTimeMillis24);
                                                            if (bVar2.a(138)) {
                                                            }
                                                            if (bVar2.a(145)) {
                                                            }
                                                            if (bVar2.a(146)) {
                                                            }
                                                            if (bVar2.a(147)) {
                                                            }
                                                            if (bVar2.a(149)) {
                                                            }
                                                            if (bVar2.a(150)) {
                                                            }
                                                            if (bVar2.a(151)) {
                                                            }
                                                            if (z19) {
                                                            }
                                                            return hashMap;
                                                        }
                                                    } catch (Throwable unused9) {
                                                        z27 = true;
                                                        str5 = "exp";
                                                        hashMap.put("2021", str5);
                                                        kwcjn.a(140, System.currentTimeMillis() - currentTimeMillis24);
                                                        if (bVar2.a(138)) {
                                                        }
                                                        if (bVar2.a(145)) {
                                                        }
                                                        if (bVar2.a(146)) {
                                                        }
                                                        if (bVar2.a(147)) {
                                                        }
                                                        if (bVar2.a(149)) {
                                                        }
                                                        if (bVar2.a(150)) {
                                                        }
                                                        if (bVar2.a(151)) {
                                                        }
                                                        if (z19) {
                                                        }
                                                        return hashMap;
                                                    }
                                                }
                                            } catch (Throwable unused10) {
                                                z27 = true;
                                                z19 = z18;
                                                z26 = false;
                                                str5 = "exp";
                                                hashMap.put("2021", str5);
                                                kwcjn.a(140, System.currentTimeMillis() - currentTimeMillis24);
                                                if (bVar2.a(138)) {
                                                    long currentTimeMillis25 = System.currentTimeMillis();
                                                    hashMap.put("282", EjxAs.c(context));
                                                    kwcjn.a(138, System.currentTimeMillis() - currentTimeMillis25);
                                                }
                                                if (bVar2.a(145)) {
                                                    long currentTimeMillis26 = System.currentTimeMillis();
                                                    String a65 = o4LU5.f382325c.b().a();
                                                    if (a65 != null) {
                                                        hashMap.put("283", a65);
                                                    }
                                                    kwcjn.a(145, System.currentTimeMillis() - currentTimeMillis26);
                                                }
                                                if (bVar2.a(146)) {
                                                    long currentTimeMillis27 = System.currentTimeMillis();
                                                    String a66 = kWj12.a();
                                                    if (a66 != null) {
                                                        hashMap.put("284", a66);
                                                    }
                                                    kwcjn.a(146, System.currentTimeMillis() - currentTimeMillis27);
                                                }
                                                if (bVar2.a(147)) {
                                                    if (!zy08e.d()) {
                                                        a27 = LwgsO.a(LwgsO.f381916l1);
                                                    } else {
                                                        a27 = zy08e.a("m_c_l_2");
                                                    }
                                                    if (!TextUtils.isEmpty(a27)) {
                                                        hashMap.put("2024", a27);
                                                    }
                                                    String a67 = zy08e.a("nbe_a_t");
                                                    if (!TextUtils.isEmpty(a67)) {
                                                        if (Build.VERSION.SDK_INT <= Integer.parseInt(a67)) {
                                                            z28 = z27;
                                                            hashMap.put("2029", !z28 ? "1" : "0");
                                                        }
                                                    }
                                                    z28 = z26;
                                                    hashMap.put("2029", !z28 ? "1" : "0");
                                                }
                                                if (bVar2.a(149)) {
                                                    long currentTimeMillis28 = System.currentTimeMillis();
                                                    hashMap.put("285", EjxAs.c());
                                                    kwcjn.a(149, System.currentTimeMillis() - currentTimeMillis28);
                                                }
                                                if (bVar2.a(150)) {
                                                    long currentTimeMillis29 = System.currentTimeMillis();
                                                    try {
                                                        str4 = TimeZone.getDefault().getID();
                                                    } catch (Throwable unused11) {
                                                        str4 = "";
                                                    }
                                                    hashMap.put("286", str4);
                                                    kwcjn.a(150, System.currentTimeMillis() - currentTimeMillis29);
                                                }
                                                if (bVar2.a(151)) {
                                                    long currentTimeMillis30 = System.currentTimeMillis();
                                                    try {
                                                        str3 = DeviceInfoMonitor.getSimOperator((TelephonyManager) eh5ma.a().getSystemService("phone"));
                                                    } catch (Throwable unused12) {
                                                        str3 = null;
                                                    }
                                                    if (!TextUtils.isEmpty(str3)) {
                                                        hashMap.put("287", str3);
                                                    }
                                                    kwcjn.a(151, System.currentTimeMillis() - currentTimeMillis30);
                                                }
                                                if (z19) {
                                                    hashMap.putAll(a(context, bVar2, zy08e));
                                                }
                                                return hashMap;
                                            }
                                        }
                                    } catch (Throwable unused13) {
                                        z26 = false;
                                        z19 = z18;
                                    }
                                }
                                z19 = z18;
                                z26 = false;
                                if (z46) {
                                }
                                sb10.append(next);
                                simpleStringSplitter2 = simpleStringSplitter;
                                z18 = z19;
                            }
                            z19 = z18;
                            simpleStringSplitter = simpleStringSplitter2;
                            simpleStringSplitter2 = simpleStringSplitter;
                            z18 = z19;
                        }
                    }
                    z19 = z18;
                    z26 = false;
                    z27 = true;
                    sb10.append(",");
                    boolean z47 = true;
                    for (AccessibilityServiceInfo accessibilityServiceInfo2 : accessibilityManager.getInstalledAccessibilityServiceList()) {
                        if (!hashSet2.contains(accessibilityServiceInfo2.getId()) && !jnpyH.a(accessibilityServiceInfo2)) {
                            if (z47) {
                                z47 = false;
                            } else {
                                sb10.append(";");
                                z47 = z47;
                            }
                            jnpyH.a(sb10, accessibilityServiceInfo2);
                            accessibilityServiceInfo2.getId();
                        }
                    }
                    str5 = sb10.toString();
                } catch (Throwable unused14) {
                    z19 = z18;
                    z26 = z37;
                }
                hashMap.put("2021", str5);
                kwcjn.a(140, System.currentTimeMillis() - currentTimeMillis24);
            } else {
                z19 = z18;
                z26 = false;
                z27 = true;
            }
            if (bVar2.a(138)) {
            }
            if (bVar2.a(145)) {
            }
            if (bVar2.a(146)) {
            }
            if (bVar2.a(147)) {
            }
            if (bVar2.a(149)) {
            }
            if (bVar2.a(150)) {
            }
            if (bVar2.a(151)) {
            }
            if (z19) {
            }
            return hashMap;
        }
        str2 = null;
        kwcjn.a(133, System.currentTimeMillis() - currentTimeMillis23);
        if (!TextUtils.isEmpty(str2)) {
        }
        if (bVar2.a(140)) {
        }
        if (bVar2.a(138)) {
        }
        if (bVar2.a(145)) {
        }
        if (bVar2.a(146)) {
        }
        if (bVar2.a(147)) {
        }
        if (bVar2.a(149)) {
        }
        if (bVar2.a(150)) {
        }
        if (bVar2.a(151)) {
        }
        if (z19) {
        }
        return hashMap;
        hashMap.put("280", str6);
        kwcjn.a(122, System.currentTimeMillis() - currentTimeMillis18);
        a17 = zy08e.a();
        if (a17 != null) {
        }
        if (bVar2.a(126)) {
        }
        dVar = fbfpd.f382216c;
        if (dVar != null) {
        }
        long currentTimeMillis222 = System.currentTimeMillis();
        hashMap.put("264", sh4jo.a());
        kwcjn.a(24, System.currentTimeMillis() - currentTimeMillis222);
        StringBuilder sb82 = new StringBuilder();
        sb82.append("C:");
        sb82.append(z16 ? "1" : "0");
        GOzix.a(sb82);
        hashMap.put(ThemeReporter.FROM_CLEANER, sb82.toString());
        if (!zy08e.d()) {
        }
        if (a18 != null) {
        }
        if (!zy08e.d()) {
        }
        if (a19 != null) {
        }
        a26 = zy08e.a("p_d_l");
        if (a26 != null) {
        }
        hashMap.put("2018", String.valueOf(Process.myUid()));
        long currentTimeMillis232 = System.currentTimeMillis();
        PackageManager packageManager2 = context.getPackageManager();
        a28 = rBDKv.a(packageManager2.getClass(), f382171a, packageManager2);
        if (a28 != null) {
        }
        str2 = null;
        kwcjn.a(133, System.currentTimeMillis() - currentTimeMillis232);
        if (!TextUtils.isEmpty(str2)) {
        }
        if (bVar2.a(140)) {
        }
        if (bVar2.a(138)) {
        }
        if (bVar2.a(145)) {
        }
        if (bVar2.a(146)) {
        }
        if (bVar2.a(147)) {
        }
        if (bVar2.a(149)) {
        }
        if (bVar2.a(150)) {
        }
        if (bVar2.a(151)) {
        }
        if (z19) {
        }
        return hashMap;
        str2 = null;
        kwcjn.a(133, System.currentTimeMillis() - currentTimeMillis232);
        if (!TextUtils.isEmpty(str2)) {
        }
        if (bVar2.a(140)) {
        }
        if (bVar2.a(138)) {
        }
        if (bVar2.a(145)) {
        }
        if (bVar2.a(146)) {
        }
        if (bVar2.a(147)) {
        }
        if (bVar2.a(149)) {
        }
        if (bVar2.a(150)) {
        }
        if (bVar2.a(151)) {
        }
        if (z19) {
        }
        return hashMap;
        HDnuc.a(bufferedReader);
        if (hashSet.size() <= 0) {
        }
        hashMap.put("279", str7);
        kwcjn.a(120, System.currentTimeMillis() - currentTimeMillis16);
        long currentTimeMillis172 = System.currentTimeMillis();
        synchronized (ucT3w.class) {
        }
        long currentTimeMillis2222 = System.currentTimeMillis();
        hashMap.put("264", sh4jo.a());
        kwcjn.a(24, System.currentTimeMillis() - currentTimeMillis2222);
        StringBuilder sb822 = new StringBuilder();
        sb822.append("C:");
        sb822.append(z16 ? "1" : "0");
        GOzix.a(sb822);
        hashMap.put(ThemeReporter.FROM_CLEANER, sb822.toString());
        if (!zy08e.d()) {
        }
        if (a18 != null) {
        }
        if (!zy08e.d()) {
        }
        if (a19 != null) {
        }
        a26 = zy08e.a("p_d_l");
        if (a26 != null) {
        }
        hashMap.put("2018", String.valueOf(Process.myUid()));
        long currentTimeMillis2322 = System.currentTimeMillis();
        PackageManager packageManager22 = context.getPackageManager();
        a28 = rBDKv.a(packageManager22.getClass(), f382171a, packageManager22);
        if (a28 != null) {
        }
        str2 = null;
        kwcjn.a(133, System.currentTimeMillis() - currentTimeMillis2322);
        if (!TextUtils.isEmpty(str2)) {
        }
        if (bVar2.a(140)) {
        }
        if (bVar2.a(138)) {
        }
        if (bVar2.a(145)) {
        }
        if (bVar2.a(146)) {
        }
        if (bVar2.a(147)) {
        }
        if (bVar2.a(149)) {
        }
        if (bVar2.a(150)) {
        }
        if (bVar2.a(151)) {
        }
        if (z19) {
        }
        return hashMap;
    }

    public static bUA8L a(Context context) {
        long j3;
        int i3;
        Context context2;
        AtomicReference<bUA8L> atomicReference = f382173c;
        synchronized (atomicReference) {
            bUA8L bua8l = atomicReference.get();
            if (bua8l == null) {
                String b16 = XStYH.b(context, "1001");
                if (TextUtils.isEmpty(b16)) {
                    return null;
                }
                long j16 = 0;
                try {
                    j3 = Long.parseLong(XStYH.b(context, "1002"));
                } catch (Throwable unused) {
                    j3 = 0;
                }
                try {
                    j16 = Long.parseLong(XStYH.b(context, "1003"));
                } catch (Throwable unused2) {
                }
                long j17 = j16;
                try {
                    i3 = Integer.parseInt(XStYH.b(context, QzoneVideoBeaconReport.RESULTCODE_VIDEO_TRIIMRECORD_AVCAMERAUSED));
                } catch (Throwable unused3) {
                    i3 = 0;
                }
                int i16 = i3;
                synchronized (eh5ma.class) {
                    context2 = eh5ma.f382207a;
                }
                bua8l = new bUA8L(0, b16, j3, j17, i16, XStYH.b(context2, QzoneVideoBeaconReport.RESULTCODE_VIDEO_TRIIMRECORD_DOWNLOADERROR));
                f382173c.set(bua8l);
            }
            return bua8l;
        }
    }

    public static void a(Context context, bUA8L bua8l) {
        AtomicReference<bUA8L> atomicReference = f382173c;
        synchronized (atomicReference) {
            if (bua8l.f382158a != 0) {
                return;
            }
            atomicReference.set(bua8l);
            String str = XStYH.f382092b;
            if (TextUtils.isEmpty(bua8l.f382159b)) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("1001", bua8l.f382159b);
            hashMap.put("1002", String.valueOf(bua8l.f382160c));
            hashMap.put("1003", String.valueOf(bua8l.f382161d));
            hashMap.put(QzoneVideoBeaconReport.RESULTCODE_VIDEO_TRIIMRECORD_AVCAMERAUSED, String.valueOf(bua8l.f382162e));
            String str2 = bua8l.f382163f;
            Random random = Ckq8l.f381753a;
            if (str2 == null) {
                str2 = "";
            }
            hashMap.put(QzoneVideoBeaconReport.RESULTCODE_VIDEO_TRIIMRECORD_DOWNLOADERROR, str2);
            XStYH.a(context, hashMap);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0065, code lost:
    
        if (r9.getPackageManager().getApplicationInfo(r9.getPackageName(), 128).metaData.containsKey(com.tencent.turingcam.EgBof.f381795b) != false) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00d8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Map<String, String> a(Context context, b bVar, ZY08E zy08e) {
        fBfpd fbfpd;
        String sb5;
        boolean z16;
        FutureTask<HnGHR.spXPg> futureTask;
        String str;
        HashMap hashMap = new HashMap();
        if (bVar.a(46)) {
            StringBuilder a16 = tmnyR.a("");
            a16.append(eCoqw.a());
            hashMap.put("271", a16.toString());
        }
        String str2 = f382172b;
        if (d5HOq.a(context, str2) == 0) {
            hashMap.put(str2, "1");
        }
        if (bVar.a(143)) {
            boolean a17 = zy08e.a("ig_g_a_l", false);
            if (d5HOq.a(context, EgBof.f381794a) != 0) {
            }
            z16 = true;
            if (z16) {
                str = "-2";
            } else {
                AtomicReference<FutureTask<HnGHR.spXPg>> atomicReference = EgBof.f381796c;
                synchronized (atomicReference) {
                    futureTask = atomicReference.get();
                    if (futureTask == null) {
                        futureTask = new FutureTask<>(new wheT7());
                        zVR7H.f382477b.submit(futureTask);
                        atomicReference.set(futureTask);
                    }
                }
                try {
                    HnGHR.spXPg spxpg = futureTask.get(1L, TimeUnit.SECONDS);
                    if (spxpg == null) {
                        str = "-1";
                    } else if (!spxpg.f381836b || a17) {
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append(spxpg.f381836b ? "1" : "0");
                        sb6.append(",");
                        sb6.append(spxpg.f381835a);
                        str = sb6.toString();
                    } else {
                        str = "1";
                    }
                } catch (Throwable unused) {
                    str = "-3";
                }
            }
            hashMap.put("2020", str);
        }
        synchronized (fBfpd.class) {
            fbfpd = fBfpd.B;
        }
        fbfpd.getClass();
        if (bVar.a(144)) {
            String a18 = ZY08E.f382121f.a("d_i_l");
            if (a18 == null) {
                a18 = ZY08E.f382119d;
            }
            if (TextUtils.isEmpty(a18)) {
                sb5 = null;
            } else {
                StringBuilder sb7 = new StringBuilder();
                for (String str3 : a18.split(",")) {
                    String[] split = str3.split(":");
                    if (split.length == 2) {
                        try {
                            String a19 = wBKEO.a(Long.parseLong(split[0], 16), Long.parseLong(split[1], 16));
                            if (!TextUtils.isEmpty(a19)) {
                                if (sb7.length() > 0) {
                                    sb7.append(",");
                                }
                                sb7.append(a19);
                            }
                        } catch (Throwable unused2) {
                        }
                    }
                }
                sb5 = sb7.toString();
            }
            if (!TextUtils.isEmpty(sb5)) {
                hashMap.put("2023", sb5);
            } else {
                hashMap.put("2023", "");
            }
        }
        return hashMap;
        z16 = false;
        if (z16) {
        }
        hashMap.put("2020", str);
        synchronized (fBfpd.class) {
        }
    }
}
