package com.tencent.turingcam;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import com.tencent.turingcam.F26wG;
import com.tencent.turingcam.t0bih;
import com.tencent.turingface.sdk.mfa.d;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: P */
/* loaded from: classes27.dex */
public class JD1Ej {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static final ExecutorService f381864b;

    /* renamed from: c, reason: collision with root package name */
    private static final JD1Ej f381865c;

    /* renamed from: d, reason: collision with root package name */
    public static final String f381866d;

    /* renamed from: a, reason: collision with root package name */
    private Context f381867a;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class ShGzN implements QafBz {
        static IPatchRedirector $redirector_;

        public ShGzN(JD1Ej jD1Ej) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) jD1Ej);
            }
        }

        @Override // com.tencent.turingcam.V3a8U
        public boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class SkEpO {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f381868a;

        /* renamed from: b, reason: collision with root package name */
        public String f381869b;

        public SkEpO() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f381868a = 0;
                this.f381869b = "";
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class spXPg implements d {
        static IPatchRedirector $redirector_;

        public spXPg(JD1Ej jD1Ej) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) jD1Ej);
            }
        }

        @Override // com.tencent.turingface.sdk.mfa.d
        public String getAndroidId() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return null;
        }

        @Override // com.tencent.turingface.sdk.mfa.d
        public String getImei() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return null;
        }

        @Override // com.tencent.turingface.sdk.mfa.d
        public String getImsi() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return null;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16792);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f381864b = ProxyExecutors.newSingleThreadExecutor();
        f381865c = new JD1Ej();
        f381866d = DeviceInfoMonitor.getModel();
    }

    JD1Ej() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public SkEpO b() {
        jfo8q a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (SkEpO) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        Context context = this.f381867a;
        int a17 = arWPM.a();
        if (a17 != 0) {
            a16 = jfo8q.a(a17);
        } else {
            a16 = T0QUa.f382050l.a(context, true, 1);
        }
        SkEpO skEpO = new SkEpO();
        skEpO.f381869b = a16.f382267a;
        skEpO.f381868a = a16.f382269c;
        return skEpO;
    }

    public static JD1Ej a() {
        return f381865c;
    }

    public int a(TuringFaceBuilder turingFaceBuilder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) turingFaceBuilder)).intValue();
        }
        this.f381867a = turingFaceBuilder.getContext().getApplicationContext();
        HashSet hashSet = new HashSet();
        hashSet.add(17);
        hashSet.add(43);
        hashSet.add(40);
        hashSet.add(102);
        hashSet.add(15);
        hashSet.add(114);
        hashSet.add(5);
        hashSet.add(4);
        hashSet.add(151);
        F26wG.spXPg spxpg = new F26wG.spXPg(this.f381867a, new ShGzN(this));
        String[] strArr = new String[1];
        strArr[0] = !TextUtils.isEmpty(turingFaceBuilder.getHostUrl()) ? turingFaceBuilder.getHostUrl() : "";
        spxpg.f381810m = strArr;
        spxpg.f381799b = 108098;
        spxpg.f381805h = true;
        spxpg.f381806i = true;
        spxpg.f381808k = new spXPg(this);
        spxpg.f381812o = 0L;
        spxpg.f381811n = turingFaceBuilder.getTuringNetwork();
        spxpg.f381813p = hashSet;
        spxpg.f381814q = f381866d;
        spxpg.f381809l = true;
        if (turingFaceBuilder.isDisableGetProp()) {
            spxpg.f381815r = true;
        }
        F26wG f26wG = new F26wG(spxpg);
        AtomicBoolean atomicBoolean = arWPM.f382135c;
        synchronized (atomicBoolean) {
            if (atomicBoolean.get()) {
                return 0;
            }
            if (Build.VERSION.SDK_INT == 23) {
                String a16 = Ckq8l.a("M String fixed1".getBytes(), "UTF-8");
                if (a16 == null) {
                    a16 = "M String fixed1 failed";
                }
                Log.i("TuringFdJava", a16);
                String a17 = Ckq8l.a("M String fixed2".getBytes(), null);
                if (a17 == null) {
                    a17 = "M String fixed2 failed";
                }
                Log.i("TuringFdJava", a17);
            }
            int i3 = f26wG.f382217d;
            if (i3 > 0) {
                WT9z5.f382088a = i3;
            }
            if (WT9z5.f382088a == 0) {
                Log.e("TuringFdJava", "please input valid channel!");
                return -10018;
            }
            WT9z5.f382089b = f26wG.f382237x;
            synchronized (fBfpd.class) {
                fBfpd.B = f26wG;
            }
            Log.i("TuringFdJava", arWPM.b());
            String str = f26wG.f382239z;
            AtomicReference<String> atomicReference = sh4jo.f382370a;
            if (!TextUtils.isEmpty(str)) {
                synchronized (atomicReference) {
                    atomicReference.set(str);
                }
            }
            System.currentTimeMillis();
            int b16 = arWPM.b(f26wG);
            if (b16 == 0) {
                b16 = arWPM.c(f26wG);
                if (b16 == 0) {
                    arWPM.d(f26wG);
                    arWPM.a(f26wG);
                    atomicBoolean.set(true);
                    return 0;
                }
            }
            return b16;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x013a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] a(String str) {
        boolean z16;
        long j3;
        Context context;
        bUA8L a16;
        bUA8L bua8l;
        bUA8L bua8l2;
        long currentTimeMillis;
        bUA8L bua8l3;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (byte[]) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        final HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put(100, str);
        }
        t0bih.spXPg spxpg = new t0bih.spXPg();
        spxpg.f382375b = false;
        spxpg.f382376c = true;
        spxpg.f382374a = hashMap;
        t0bih t0bihVar = new t0bih(spxpg);
        int a17 = arWPM.a();
        bUA8L bua8l4 = null;
        if (a17 != 0) {
            Log.i("TuringDebug", "init error : " + a17);
            bua8l3 = new bUA8L(a17);
        } else {
            long currentTimeMillis2 = System.currentTimeMillis();
            try {
                if (t0bihVar.f382132c) {
                    a16 = new bUA8L(-10024);
                } else {
                    synchronized (eh5ma.class) {
                        context = eh5ma.f382207a;
                    }
                    a16 = cPR64.a(context, t0bihVar.f382130a, t0bihVar.f382131b ? 1 : 2, 0);
                }
                bUA8L bua8l5 = a16;
                try {
                    j3 = System.currentTimeMillis() - currentTimeMillis2;
                } catch (Throwable th5) {
                    th = th5;
                    j3 = 0;
                }
                try {
                    long currentTimeMillis3 = System.currentTimeMillis();
                    int i3 = bua8l5.f382158a;
                    if (i3 == 0 || i3 == -10004 || i3 == -10012 || i3 == -10011 || i3 == -22056 || i3 == -42056 || i3 == -10015 || i3 == -10024) {
                        z16 = i3 != 0;
                        try {
                            FutureTask futureTask = new FutureTask(new ORjG3(t0bihVar, bua8l5, z16));
                            zVR7H.f382477b.submit(futureTask);
                            try {
                                try {
                                    bua8l = (bUA8L) futureTask.get(10000L, TimeUnit.MILLISECONDS);
                                } catch (Throwable unused) {
                                    bua8l = new bUA8L(-10015);
                                }
                            } catch (TimeoutException unused2) {
                                bua8l = new bUA8L(-10023);
                            }
                            bua8l2 = bua8l;
                        } catch (Throwable th6) {
                            th = th6;
                            bua8l4 = bua8l5;
                        }
                        try {
                            currentTimeMillis = System.currentTimeMillis() - currentTimeMillis3;
                            if (bua8l2 != null) {
                                z17 = z16;
                                bua8l3 = bua8l2;
                            } else {
                                bua8l3 = bua8l2;
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            bua8l4 = bua8l2;
                            if (bua8l4 != null) {
                                bua8l4.f382164g = j3;
                                bua8l4.f382165h = 0L;
                                bua8l4.f382166i = z16;
                            }
                            throw th;
                        }
                    } else {
                        bua8l3 = bua8l5;
                        z17 = false;
                        currentTimeMillis = 0;
                    }
                    bua8l3.f382164g = j3;
                    bua8l3.f382165h = currentTimeMillis;
                    bua8l3.f382166i = z17;
                } catch (Throwable th8) {
                    th = th8;
                    bua8l4 = bua8l5;
                    z16 = false;
                    if (bua8l4 != null) {
                    }
                    throw th;
                }
            } catch (Throwable th9) {
                th = th9;
                z16 = false;
                j3 = 0;
                if (bua8l4 != null) {
                }
                throw th;
            }
        }
        if (bua8l3.f382158a != 0) {
            return null;
        }
        f381864b.submit(new Runnable() { // from class: com.tencent.turingcam.a
            @Override // java.lang.Runnable
            public final void run() {
                JD1Ej.this.a(hashMap);
            }
        });
        String[] split = bua8l3.f382159b.split(":");
        if (split.length <= 1) {
            return null;
        }
        return FLlEM.a(split[1]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Map map) {
        bUA8L a16;
        Context context = this.f381867a;
        int a17 = arWPM.a();
        if (a17 != 0) {
            Log.i("TuringDebug", "init error : " + a17);
            a16 = new bUA8L(a17);
        } else {
            a16 = cPR64.a(context, (Map<Integer, String>) map, 0, 0L);
        }
        int i3 = a16.f382158a;
    }
}
