package com.tencent.turingcam;

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
import com.tencent.mobileqq.msf.core.c0.g;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.turingcam.HnGHR;
import com.tencent.turingcam.ShGzN;
import com.tencent.turingcam.cPR64;
import com.tencent.turingcam.jfo8q;
import com.tencent.turingface.sdk.mfa.TNative$aa;
import com.tencent.turingface.sdk.mfa.b;
import com.tencent.turingface.sdk.mfa.d;
import com.tencent.turingface.sdk.mfa.f;
import com.tencent.turingface.sdk.mfa.j;
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
public class T0QUa {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name */
    public static final String f382047i;

    /* renamed from: j, reason: collision with root package name */
    public static final String f382048j;

    /* renamed from: k, reason: collision with root package name */
    public static final String f382049k;

    /* renamed from: l, reason: collision with root package name */
    public static final T0QUa f382050l;

    /* renamed from: m, reason: collision with root package name */
    public static final long f382051m;

    /* renamed from: n, reason: collision with root package name */
    public static final int[] f382052n;

    /* renamed from: a, reason: collision with root package name */
    public fBfpd f382053a;

    /* renamed from: b, reason: collision with root package name */
    public Handler f382054b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f382055c;

    /* renamed from: d, reason: collision with root package name */
    public XStYH f382056d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f382057e;

    /* renamed from: f, reason: collision with root package name */
    public final AtomicReference<jfo8q> f382058f;

    /* renamed from: g, reason: collision with root package name */
    public final AtomicReference<Boolean> f382059g;

    /* renamed from: h, reason: collision with root package name */
    public final AtomicReference<FutureTask<HnGHR.spXPg>> f382060h;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class spXPg extends Handler {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public Context f382061a;

        public spXPg(Looper looper, Context context) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, T0QUa.this, looper, context);
            } else {
                this.f382061a = context;
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
                    T0QUa.this.a(T0QUa.this.a(this.f382061a, true, false, ((Integer) message.obj).intValue()), false);
                    synchronized (T0QUa.this.f382059g) {
                        T0QUa.this.f382059g.set(Boolean.FALSE);
                        T0QUa.this.f382059g.notifyAll();
                    }
                    return;
                }
                return;
            }
            T0QUa.this.a(this.f382061a, true, 3);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17016);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f382047i = LwgsO.a(LwgsO.f381889c1);
        f382048j = LwgsO.a(LwgsO.f381892d1);
        f382049k = LwgsO.a(LwgsO.f381895e1);
        f382050l = new T0QUa();
        f382051m = TimeUnit.MINUTES.toMillis(30L);
        f382052n = new int[]{0, 15, 30, 90, 240, 360, 600, 1200, WnsError.WNS_CODE_DIS_STAT_BEGIN, g.T0, 4800, 7200};
    }

    public T0QUa() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f382055c = false;
        this.f382057e = new Object();
        this.f382058f = new AtomicReference<>(null);
        this.f382059g = new AtomicReference<>(Boolean.FALSE);
        this.f382060h = new AtomicReference<>(null);
    }

    /* JADX WARN: Removed duplicated region for block: B:99:0x019a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(T0QUa t0QUa) {
        Context context;
        Context context2;
        boolean z16;
        String str;
        File file;
        t0QUa.getClass();
        synchronized (eh5ma.class) {
            context = eh5ma.f382207a;
        }
        YVsFX.a(context, t0QUa.f382056d);
        long j3 = t0QUa.f382053a.f382235v;
        long j16 = 0;
        if (j3 > 0) {
            try {
                LockMethodProxy.sleep(j3);
            } catch (InterruptedException unused) {
            }
        }
        b bVar = b.f382488g;
        bVar.getClass();
        try {
            System.currentTimeMillis();
            bVar.b(context);
            System.currentTimeMillis();
            bVar.b();
        } catch (Throwable unused2) {
        }
        if (bVar.a(39)) {
            t0QUa.f382056d.getClass();
            if (TextUtils.isEmpty(XStYH.b(context, "405"))) {
                StringBuilder sb5 = new StringBuilder();
                try {
                    String[] split = new String(F2BEC.a("/proc/self/maps")).split("\n");
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
                                    String a16 = fi6GY.a(context, trim);
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
                t0QUa.f382056d.a(context, "405", sb5.toString().replace("(\\|)|\\s*|\t|\r|\n", ""), true);
            }
        }
        if (t0QUa.f382053a.f382231r && bVar.a(45)) {
            XStYH xStYH = t0QUa.f382056d;
            int i3 = Nb4Ck.f381958b;
            xStYH.getClass();
            try {
                j16 = Long.valueOf(XStYH.b(context, "902")).longValue();
            } catch (Throwable unused5) {
            }
            if (Math.abs(j16 - System.currentTimeMillis()) >= Nb4Ck.f381957a) {
                if (!TextUtils.isEmpty(XStYH.b(context, "901"))) {
                    long abs = Math.abs(j16 - System.currentTimeMillis());
                    ZY08E zy08e = ZY08E.f382121f;
                    long j17 = ZY08E.f382120e;
                    String a17 = zy08e.a("sid_refresh_period");
                    if (a17 != null) {
                        try {
                            j17 = Long.parseLong(a17) * 3600000;
                        } catch (NumberFormatException unused6) {
                        }
                    }
                    if (abs < j17) {
                        z16 = false;
                        if (z16) {
                            e7l68 a18 = k7FCJ.a(context);
                            if (a18.f382200a != 0) {
                                a18 = k7FCJ.a();
                            }
                            if (a18.f382200a == 0) {
                                String str3 = a18.f382203d;
                                HashMap hashMap = new HashMap();
                                hashMap.put("901", str3);
                                XStYH.a(context, hashMap);
                                String e7l68Var = a18.toString();
                                HashMap hashMap2 = new HashMap();
                                hashMap2.put("904", e7l68Var);
                                XStYH.a(context, hashMap2);
                            }
                        }
                        xStYH.b(context, System.currentTimeMillis());
                    }
                }
                z16 = true;
                if (z16) {
                }
                xStYH.b(context, System.currentTimeMillis());
            }
        }
        fBfpd fbfpd = t0QUa.f382053a;
        if (fbfpd.f382228o && fbfpd.d().a()) {
            if (bVar.a(41)) {
                if (((ConcurrentHashMap) ShGzN.f382022a).containsKey(ShGzN.f382024c)) {
                    new i0xzF((ShGzN.spXPg) ((ConcurrentHashMap) ShGzN.f382022a).get(ShGzN.f382024c), context).start();
                }
            }
            t0QUa.a(t0QUa.f382053a.c(), false, 0);
            String str4 = cPR64.f382171a;
            synchronized (eh5ma.class) {
                context2 = eh5ma.f382207a;
            }
            if (cPR64.a(context2) == null && kWj12.c(context)) {
                new cPR64.spXPg(null, true).a();
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(101:8|(1:10)(1:406)|11|(1:13)(1:405)|14|(1:16)(1:404)|17|(1:19)|20|(3:22|(1:24)(1:26)|25)|27|(1:29)|30|(2:31|32)|33|(2:397|(1:401))(1:(1:38))|39|(80:41|42|43|44|(1:48)|49|(4:51|(2:86|87)|53|(1:55)(6:56|2ab|63|64|(6:66|(1:71)|74|75|(1:77)(1:79)|78)(1:80)|72))|92|(6:94|(1:96)|97|(1:99)(4:104|(5:106|(11:111|112|113|114|115|116|117|(5:121|(1:123)(1:126)|124|125|110)|119|120|110)|108|109|110)|131|132)|100|(1:102)(1:103))|133|(1:135)(3:378|(2:383|(1:385)(2:386|(1:388)(3:389|(1:393)|394)))|382)|136|(5:138|45f|143|(1:145)|146)|153|(1:155)|156|(1:158)|159|(1:161)|162|(3:164|(1:166)|167)|168|(3:170|(1:172)|173)|174|(1:176)|177|(1:179)|180|(1:182)|183|(5:371|(1:373)|374|(1:376)|377)|187|(3:366|367|368)|189|(1:191)|192|(1:194)|195|(1:197)|198|(1:200)|201|(1:203)|204|(3:206|(1:208)|209)|210|(3:212|(1:214)(1:216)|215)|217|(4:219|(1:221)(1:226)|(1:223)(1:225)|224)|227|(1:229)|230|(1:232)|233|(1:235)|236|(3:238|(1:240)|241)|242|(3:244|(1:246)|247)|248|(5:250|251|252|(1:254)(1:256)|255)|259|(1:261)|262|(1:264)|265|(4:268|(2:270|271)(1:273)|272|266)|274|275|276|277|278|(1:280)|281|(2:284|282)|285|286|(1:288)(2:360|(1:362)(1:363))|289|(2:291|292)(4:293|(1:295)(1:359)|296|(2:298|299)(7:300|301|302|(1:304)|305|306|(2:308|309)(2:310|(2:312|313)(2:314|(2:316|317)(4:318|(1:320)|321|(2:323|324)(20:325|(1:327)|328|(1:330)|331|(1:333)|334|(1:336)|337|(1:355)|341|(1:343)|344|(1:346)|347|(1:349)|350|(1:352)|353|354)))))))|396|44|(2:46|48)|49|(0)|92|(0)|133|(0)(0)|136|(0)|153|(0)|156|(0)|159|(0)|162|(0)|168|(0)|174|(0)|177|(0)|180|(0)|183|(1:185)|371|(0)|374|(0)|377|187|(0)|189|(0)|192|(0)|195|(0)|198|(0)|201|(0)|204|(0)|210|(0)|217|(0)|227|(0)|230|(0)|233|(0)|236|(0)|242|(0)|248|(0)|259|(0)|262|(0)|265|(1:266)|274|275|276|277|278|(0)|281|(1:282)|285|286|(0)(0)|289|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:365:0x09bd, code lost:
    
        r3 = com.tencent.turingcam.hajYm.a(-10006);
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0297, code lost:
    
        if (r34.getPackageManager().getApplicationInfo(r34.getPackageName(), 128).metaData.containsKey(com.tencent.turingcam.T0QUa.f382048j) != false) goto L69;
     */
    /* JADX WARN: Removed duplicated region for block: B:135:0x03cb  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0448  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0493  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x04c6  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x04d7  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x04f5  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x050c  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0523  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0543  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0563  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0583  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x05db  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x05f7  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0606  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0612  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0622  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x063c  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0661  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0696  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x06be  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x06de  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x06fe  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x071e  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0745  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x075c  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x078a  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x07ab  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x0813  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x0921  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x093e A[LOOP:2: B:282:0x0938->B:284:0x093e, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:288:0x09a4  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x09cc  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x09d1  */
    /* JADX WARN: Removed duplicated region for block: B:360:0x09aa  */
    /* JADX WARN: Removed duplicated region for block: B:366:0x05c5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:373:0x05a0  */
    /* JADX WARN: Removed duplicated region for block: B:376:0x05a9  */
    /* JADX WARN: Removed duplicated region for block: B:378:0x03d5  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0339  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final jfo8q b(Context context, boolean z16, int i3) {
        long j3;
        b bVar;
        long j16;
        b bVar2;
        int i16;
        d dVar;
        List<String> a16;
        Set<String> c16;
        String str;
        String a17;
        String a18;
        String a19;
        b bVar3;
        Iterator<Integer> it;
        hajYm a26;
        int i17;
        Iioec iioec;
        int b16;
        String str2;
        Iterator it5;
        boolean z17;
        String sb5;
        StringBuilder sb6;
        StringBuilder sb7;
        String a27;
        boolean z18;
        FutureTask<HnGHR.spXPg> futureTask;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (jfo8q) iPatchRedirector.redirect((short) 8, this, context, Boolean.valueOf(z16), Integer.valueOf(i3));
        }
        long a28 = b.f382488g.a(context);
        long currentTimeMillis = System.currentTimeMillis();
        String str3 = CRchv.f381744a;
        long currentTimeMillis2 = System.currentTimeMillis();
        ((HashMap) Bi3eT.f381729a).clear();
        HashMap hashMap = new HashMap();
        StringBuilder a29 = tmnyR.a("");
        a29.append(WT9z5.f382088a);
        hashMap.put("1", a29.toString());
        hashMap.put("101", this.f382053a.b());
        hashMap.put(ThemeReporter.FROM_SERVER_SET_THEME, this.f382056d.a(context).f382267a);
        fBfpd fbfpd = this.f382053a;
        hashMap.put(ThemeReporter.FROM_PUSH, TextUtils.isEmpty(fbfpd.f382218e) ? "" : fbfpd.f382218e);
        boolean z19 = this.f382053a.f382230q;
        XStYH xStYH = this.f382056d;
        StringBuilder sb8 = new StringBuilder();
        GOzix.a(sb8);
        sb8.append(",");
        sb8.append("F:");
        sb8.append(z16 ? "1" : "0");
        sb8.append(",");
        sb8.append("PT:");
        sb8.append(0);
        sb8.append(",");
        sb8.append("PKG:");
        sb8.append("1");
        sb8.append(",");
        sb8.append("SC:");
        sb8.append(z19 ? "1" : "0");
        if (WT9z5.f382088a == 105748) {
            sb8.append(",");
            sb8.append("SOTR:");
            sb8.append(k7FCJ.a().toString() + ";" + k7FCJ.a(context).toString());
        }
        sb8.append(",");
        sb8.append("SRT:");
        sb8.append(i3);
        String b17 = XStYH.b(context, ThemeReporter.FROM_AUTH);
        if (TextUtils.isEmpty(b17)) {
            StringBuilder a36 = tmnyR.a("0_");
            a36.append(z16 ? "1" : "0");
            b17 = a36.toString();
        }
        if (!TextUtils.isEmpty(b17)) {
            sb8.append(",");
            sb8.append("R:");
            sb8.append(b17);
        }
        sb8.append(",");
        sb8.append("US:");
        try {
            j3 = Long.valueOf(XStYH.b(context, "503")).longValue();
        } catch (Throwable unused) {
            j3 = 0;
        }
        sb8.append(j3);
        sb8.append("_");
        sb8.append(xStYH.a(context, "502"));
        sb8.append("_");
        sb8.append(Process.myUid());
        sb8.append(",");
        sb8.append("STIF:");
        sb8.append(XStYH.b(context, "904"));
        sb8.append(",");
        sb8.append("GCI:");
        sb8.append("44f1e07");
        hashMap.put(ThemeReporter.FROM_CLEANER, sb8.toString());
        bVar = b.f382488g;
        hashMap.put("2001", bVar.a());
        ZY08E zy08e = ZY08E.f382121f;
        int i18 = WT9z5.f382088a;
        if (i18 == 105668 || i18 == 105928) {
            if (!bVar.a(17) && !bVar.a(18)) {
                hashMap.put("1001", "2");
            }
        } else if (!z16) {
            hashMap.put("1001", "1");
        }
        StringBuilder a37 = tmnyR.a("");
        String a38 = zy08e.a("m_p_s");
        if (a38 != null) {
            try {
                j16 = Long.parseLong(a38) * 1;
            } catch (NumberFormatException unused2) {
                j16 = 300;
            }
            a37.append((int) j16);
            hashMap.put("2012", a37.toString());
            if (bVar.a(136) && d5HOq.a(context, f382049k) == 0) {
                hashMap.put("501", "1");
            }
            if (bVar.a(143)) {
                if (d5HOq.a(context, f382047i) != 0) {
                }
                z18 = true;
                if (z18) {
                    hashMap.put("2020", "-2");
                } else {
                    synchronized (this.f382060h) {
                        futureTask = this.f382060h.get();
                        if (futureTask == null) {
                            futureTask = new FutureTask<>(new rGcZC());
                            zVR7H.f382477b.submit(futureTask);
                            this.f382060h.set(futureTask);
                        }
                    }
                    try {
                        HnGHR.spXPg spxpg = futureTask.get(1L, TimeUnit.SECONDS);
                        if (spxpg != null) {
                            if (spxpg.f381836b && !zy08e.a("ig_g_a_l", false)) {
                                hashMap.put("2020", "1");
                            }
                            StringBuilder sb9 = new StringBuilder();
                            sb9.append(spxpg.f381836b ? "1" : "0");
                            sb9.append(",");
                            sb9.append(spxpg.f381835a);
                            hashMap.put("2020", sb9.toString());
                        } else {
                            hashMap.put("2020", "-1");
                        }
                    } catch (Throwable unused3) {
                        hashMap.put("2020", "-3");
                    }
                }
            }
            this.f382053a.getClass();
            if (bVar.a(144)) {
                String a39 = ZY08E.f382121f.a("d_i_l");
                if (a39 == null) {
                    a39 = ZY08E.f382119d;
                }
                if (TextUtils.isEmpty(a39)) {
                    sb5 = null;
                } else {
                    StringBuilder sb10 = new StringBuilder();
                    String[] split = a39.split(",");
                    int length = split.length;
                    int i19 = 0;
                    while (i19 < length) {
                        String[] split2 = split[i19].split(":");
                        if (split2.length == 2) {
                            try {
                                sb6 = sb10;
                                try {
                                    a27 = a(Long.parseLong(split2[0], 16), Long.parseLong(split2[1], 16));
                                } catch (Throwable unused4) {
                                }
                            } catch (Throwable unused5) {
                            }
                            if (!TextUtils.isEmpty(a27)) {
                                if (sb6.length() > 0) {
                                    sb7 = sb6;
                                    sb7.append(",");
                                } else {
                                    sb7 = sb6;
                                }
                                sb7.append(a27);
                                i19++;
                                sb10 = sb7;
                            }
                            sb7 = sb6;
                            i19++;
                            sb10 = sb7;
                        }
                        sb7 = sb10;
                        i19++;
                        sb10 = sb7;
                    }
                    sb5 = sb10.toString();
                }
                if (!TextUtils.isEmpty(sb5)) {
                    hashMap.put("2023", sb5);
                } else {
                    hashMap.put("2023", "");
                }
            }
            bVar2 = b.f382488g;
            ZY08E zy08e2 = ZY08E.f382121f;
            if (!bVar2.a(41)) {
                hashMap.put("2003", "0");
            } else {
                long currentTimeMillis3 = System.currentTimeMillis();
                wmqhz wmqhzVar = ShGzN.f382023b;
                if (wmqhzVar == null || wmqhzVar.f382424b == 0) {
                    if (!((ConcurrentHashMap) ShGzN.f382022a).containsKey(ShGzN.f382024c)) {
                        wmqhzVar = wmqhz.a(-10);
                    } else if ("main".equals(Thread.currentThread().getName())) {
                        wmqhzVar = wmqhz.a(-11);
                    } else {
                        ShGzN.spXPg spxpg2 = (ShGzN.spXPg) ((ConcurrentHashMap) ShGzN.f382022a).get(ShGzN.f382024c);
                        if (spxpg2 != null && (i16 = spxpg2.f382026b) <= 3) {
                            spxpg2.f382026b = i16 + 1;
                            ShGzN.f382023b = spxpg2.f382025a.a(context);
                        }
                        wmqhzVar = ShGzN.f382023b;
                    }
                }
                hashMap.put("100", wmqhzVar.f382423a);
                Bi3eT.a(20, System.currentTimeMillis() - currentTimeMillis3);
            }
            dVar = this.f382053a.f382216c;
            if (dVar != null) {
                Object obj = new Object();
                AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                long currentTimeMillis4 = System.currentTimeMillis();
                new M7T4N(atomicBoolean, hashMap, dVar, obj).start();
                synchronized (obj) {
                    try {
                        obj.wait(1000L);
                    } catch (InterruptedException unused6) {
                    }
                }
                if (System.currentTimeMillis() - currentTimeMillis4 > 1000) {
                    Log.w("Turing", "invoke info impl timeout");
                }
                atomicBoolean.set(true);
            }
            hashMap.put("264", sh4jo.a());
            if (bVar2.a(22)) {
                hashMap.put(ThemeReporter.FROM_ENGINE, Stvdh.a(context));
                Bi3eT.a(8, Long.valueOf("" + Stvdh.f382043f).longValue());
            }
            if (!bVar2.a(10002)) {
                hashMap.put("2005", "0");
            }
            if (!bVar2.a(10003)) {
                hashMap.put("2006", "0");
            }
            hashMap.put("266", XStYH.b(context, "901"));
            if (bVar2.a(115)) {
                String b18 = EjxAs.b();
                if (b18 == null) {
                    b18 = "";
                }
                hashMap.put(IFeatureRuntimeService.MODULE_ID, b18);
            }
            if (bVar2.a(116)) {
                String a46 = V124r.a();
                if (a46 == null) {
                    a46 = "";
                }
                hashMap.put("269", a46);
            }
            if (bVar2.a(117)) {
                StringBuilder a47 = tmnyR.a("");
                a47.append(EjxAs.a(context));
                hashMap.put("270", a47.toString());
            }
            if (bVar2.a(46)) {
                StringBuilder a48 = tmnyR.a("");
                a48.append(eCoqw.a());
                hashMap.put("271", a48.toString());
            }
            if (bVar2.a(118)) {
                StringBuilder a49 = tmnyR.a("");
                a49.append(pZZwF.b());
                hashMap.put("272", a49.toString());
            }
            if (!bVar2.a(17) || bVar2.a(40)) {
                this.f382053a.getClass();
                a16 = OCkqn.a((f) null);
                HashSet hashSet = new HashSet();
                if (!v0KaV.a(a16)) {
                    hashSet.addAll(a16);
                }
                c16 = zy08e2.c();
                if (c16 != null) {
                    hashSet.addAll(c16);
                }
                hashSet.add(context.getPackageName());
                hashMap.put("277", OCkqn.a(hashSet));
            }
            if (bVar2.a(122)) {
                try {
                    str = ukkac.a();
                } catch (Throwable unused7) {
                    str = "exception";
                }
                hashMap.put("280", str);
            }
            if (bVar2.a(126)) {
                hashMap.put("281", String.valueOf(System.currentTimeMillis() - SystemClock.elapsedRealtime()));
            }
            a17 = zy08e2.a("x_l2_p_i");
            if (a17 != null) {
                hashMap.put("2014", a17);
            }
            a18 = zy08e2.a("x_u_p_i");
            if (a18 != null) {
                hashMap.put("2015", a18);
            }
            a19 = zy08e2.a();
            if (a19 != null) {
                hashMap.put("2013", a19);
            }
            bVar3 = b.f382488g;
            if (bVar3.a(39)) {
                this.f382056d.getClass();
                hashMap.put("239", XStYH.b(context, "405"));
            }
            if (bVar3.a(100)) {
                long currentTimeMillis5 = System.currentTimeMillis();
                String a56 = V124r.a(context);
                if (a56 == null) {
                    a56 = "";
                }
                hashMap.put("250", a56);
                Bi3eT.a(30, System.currentTimeMillis() - currentTimeMillis5);
            }
            if (bVar3.a(101)) {
                long currentTimeMillis6 = System.currentTimeMillis();
                int a57 = KwqWR.a(context);
                hashMap.put("251", a57 > 0 ? "1" : "0");
                hashMap.put("288", String.valueOf(a57));
                Bi3eT.a(31, System.currentTimeMillis() - currentTimeMillis6);
            }
            if (bVar3.a(102)) {
                hashMap.put("252", Settings.Secure.getInt(context.getContentResolver(), "mock_location", 0) != 0 ? "1" : "0");
            }
            if (bVar3.a(103)) {
                StringBuilder a58 = tmnyR.a("");
                a58.append(EjxAs.d(context));
                hashMap.put("253", a58.toString());
            }
            if (bVar3.a(104)) {
                StringBuilder a59 = tmnyR.a("");
                a59.append(EjxAs.b(context));
                hashMap.put("254", a59.toString());
            }
            if (bVar3.a(105)) {
                StringBuilder a65 = tmnyR.a("");
                a65.append(Amfcp.a(context));
                hashMap.put("255", a65.toString());
            }
            if (bVar3.a(106)) {
                long currentTimeMillis7 = System.currentTimeMillis();
                String a66 = EjxAs.a();
                if (a66 == null) {
                    a66 = "";
                }
                hashMap.put("256", a66);
                Bi3eT.a(32, System.currentTimeMillis() - currentTimeMillis7);
            }
            if (bVar3.a(107)) {
                String e16 = EjxAs.e(context);
                if (e16 == null) {
                    e16 = "";
                }
                hashMap.put("257", e16);
            }
            if (bVar3.a(114)) {
                long currentTimeMillis8 = System.currentTimeMillis();
                try {
                    z17 = yMdp8.a(context);
                } catch (Throwable unused8) {
                    z17 = false;
                }
                hashMap.put("259", z17 ? "1" : "0");
                Bi3eT.a(41, System.currentTimeMillis() - currentTimeMillis8);
            }
            if (bVar3.a(44)) {
                long currentTimeMillis9 = System.currentTimeMillis();
                hashMap.put("240", YmjBd.a());
                Bi3eT.a(42, System.currentTimeMillis() - currentTimeMillis9);
            }
            if (bVar3.a(138)) {
                hashMap.put("282", EjxAs.c(context));
            }
            StringBuilder a67 = tmnyR.a("");
            this.f382053a.getClass();
            a67.append(0);
            hashMap.put("403", a67.toString());
            hashMap.put("402", this.f382053a.f382223j);
            hashMap.put("404", this.f382053a.f382224k);
            hashMap.put("401", this.f382053a.f382225l);
            this.f382053a.getClass();
            hashMap.put("405", null);
            Map<Integer, String> map = this.f382053a.f382226m;
            StringBuilder sb11 = new StringBuilder();
            it = map.keySet().iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                sb11.append(intValue);
                sb11.append("_");
                sb11.append(Ckq8l.a(",", "%54", Ckq8l.a("_", "%5F", map.get(Integer.valueOf(intValue)))));
                if (it.hasNext()) {
                    sb11.append(",");
                }
            }
            hashMap.put(PersonalityConfig.RESERVES_COVER_CLICK_WIDGET_VISITOR_WITH_NANE_PLATGE, sb11.toString());
            this.f382056d.getClass();
            hashMap.put("302", XStYH.b(context, ThemeReporter.FROM_DIY));
            this.f382056d.getClass();
            hashMap.put("303", XStYH.b(context, ThemeReporter.FROM_NIGHT));
            this.f382056d.getClass();
            hashMap.put("305", XStYH.b(context, ThemeReporter.FROM_WEEKLOOP));
            hashMap.put("308", "" + ((int) kWj12.b(context)));
            this.f382056d.getClass();
            hashMap.put("309", XStYH.b(context, "404"));
            this.f382056d.getClass();
            hashMap.put("310", XStYH.b(context, ThemeReporter.FROM_ENGINE));
            this.f382053a.getClass();
            SparseArray<Object> a91_FC6D5B0A7013DB60 = TNative$aa.a91_FC6D5B0A7013DB60(new SparseArray(), context, hashMap, null, 0);
            this.f382056d.a(context, ThemeReporter.FROM_DIY, (System.currentTimeMillis() - currentTimeMillis2) + "_" + (z16 ? 1 : 0));
            b16 = SWw7W.b(a91_FC6D5B0A7013DB60);
            byte[] a68 = SWw7W.a(a91_FC6D5B0A7013DB60);
            StringBuilder sb12 = new StringBuilder();
            str2 = (String) SWw7W.a(a91_FC6D5B0A7013DB60, 2, String.class);
            Random random = Ckq8l.f381753a;
            if (str2 == null) {
                str2 = "";
            }
            sb12.append(str2);
            StringBuilder sb13 = new StringBuilder();
            it5 = ((HashMap) Bi3eT.f381729a).keySet().iterator();
            while (it5.hasNext()) {
                int intValue2 = ((Integer) it5.next()).intValue();
                sb13.append(",");
                sb13.append(intValue2);
                sb13.append("_");
                sb13.append(((HashMap) Bi3eT.f381729a).get(Integer.valueOf(intValue2)));
            }
            sb12.append(sb13.toString());
            this.f382056d.a(context, ThemeReporter.FROM_ENGINE, sb12.toString());
            XStYH xStYH2 = this.f382056d;
            long length2 = a68.length;
            xStYH2.getClass();
            xStYH2.a(context, ThemeReporter.FROM_WEEKLOOP, "" + length2 + "_" + (z16 ? 1 : 0));
            if (b16 != 0) {
                a26 = hajYm.a(b16);
            } else if (a68.length == 0) {
                a26 = hajYm.a(-10003);
            } else {
                a26 = new hajYm(0, a68);
            }
            long currentTimeMillis10 = System.currentTimeMillis() - currentTimeMillis;
            i17 = a26.f382255a;
            if (i17 != 0) {
                return jfo8q.a(i17);
            }
            long currentTimeMillis11 = System.currentTimeMillis();
            j a69 = com.tencent.turingface.sdk.mfa.a.a().a(8117, 18117, 1, a26.f382256b, 200000L, null);
            int i26 = a69.f382527a;
            if (i26 != 0) {
                iioec = new Iioec(i26 - 40000, Iioec.f381858e, a69.f382528b, a69.f382529c);
            } else {
                iioec = new Iioec(0, a69.f382530d, 0, 0);
            }
            this.f382056d.a(context, ThemeReporter.FROM_NIGHT, ((int) kWj12.a(context)) + "_" + (System.currentTimeMillis() - currentTimeMillis11) + "_" + a28 + "_" + (z16 ? 1 : 0) + "_" + a26.f382256b.length + "_" + currentTimeMillis10 + "_" + (System.currentTimeMillis() - currentTimeMillis));
            int i27 = iioec.f381859a;
            if (i27 != 0) {
                return new jfo8q(i27, iioec.f381860b, iioec.f381861c);
            }
            byte[] bArr = iioec.f381862d;
            String str4 = CRchv.f381744a;
            try {
                HashMap hashMap2 = new HashMap();
                if (ZY08E.f382121f.a("e_w_t", false)) {
                    hashMap2.put("2007", "1");
                }
                SparseArray<Object> b91_FC6D5B0A7013DB60 = TNative$aa.b91_FC6D5B0A7013DB60(new SparseArray(), bArr, hashMap2, 0);
                int b19 = SWw7W.b(b91_FC6D5B0A7013DB60);
                if (b19 != 0) {
                    return jfo8q.a(b19);
                }
                Integer num = (Integer) SWw7W.a(b91_FC6D5B0A7013DB60, 102, Integer.class);
                if (num == null) {
                    return jfo8q.a(AppConstants.RichMediaErrorCode.ERROR_LOCAL_OUT_MEM);
                }
                if (num.intValue() < 0) {
                    return jfo8q.a(num.intValue() + AppConstants.RichMediaErrorCode.ERROR_LOCAL_OUT_MEM);
                }
                String str5 = (String) SWw7W.a(b91_FC6D5B0A7013DB60, 101, String.class);
                Random random2 = Ckq8l.f381753a;
                if (str5 == null) {
                    str5 = "";
                }
                if (TextUtils.isEmpty(str5)) {
                    return jfo8q.a(num.intValue() - 10010);
                }
                String str6 = (String) SWw7W.a(b91_FC6D5B0A7013DB60, 104, String.class);
                if (str6 == null) {
                    str6 = "";
                }
                String str7 = (String) SWw7W.a(b91_FC6D5B0A7013DB60, 105, String.class);
                if (str7 == null) {
                    str7 = "";
                }
                String str8 = (String) SWw7W.a(b91_FC6D5B0A7013DB60, 106, String.class);
                if (str8 == null) {
                    str8 = "";
                }
                Integer num2 = (Integer) SWw7W.a(b91_FC6D5B0A7013DB60, 107, Integer.class);
                String str9 = (String) SWw7W.a(b91_FC6D5B0A7013DB60, 108, String.class);
                if (str9 == null) {
                    str9 = "";
                }
                if (num2 == null || num2.intValue() < 3600) {
                    num2 = 3600;
                }
                long currentTimeMillis12 = (System.currentTimeMillis() / 1000) + num2.intValue();
                jfo8q.spXPg spxpg3 = new jfo8q.spXPg(0);
                spxpg3.f382277b = currentTimeMillis12;
                spxpg3.f382276a = str5;
                spxpg3.f382278c = str6;
                spxpg3.f382279d = str7;
                spxpg3.f382280e = str8;
                spxpg3.f382281f = str9;
                jfo8q jfo8qVar = new jfo8q(spxpg3);
                XStYH xStYH3 = this.f382056d;
                xStYH3.getClass();
                HashMap hashMap3 = new HashMap();
                hashMap3.put("101", jfo8qVar.f382267a);
                hashMap3.put("102", "" + jfo8qVar.f382268b);
                if (!TextUtils.isEmpty(jfo8qVar.f382270d)) {
                    hashMap3.put("104", jfo8qVar.f382270d);
                }
                if (!TextUtils.isEmpty(jfo8qVar.f382271e)) {
                    hashMap3.put("105", jfo8qVar.f382271e);
                }
                if (!TextUtils.isEmpty(jfo8qVar.f382272f)) {
                    hashMap3.put("106", jfo8qVar.f382272f);
                }
                if (!TextUtils.isEmpty(jfo8qVar.f382273g)) {
                    hashMap3.put("110", jfo8qVar.f382273g);
                }
                xStYH3.a(context, (Map<String, String>) hashMap3, true);
                XStYH xStYH4 = this.f382056d;
                long intValue3 = num2.intValue();
                xStYH4.getClass();
                xStYH4.a(context, "107", "" + intValue3, true);
                xStYH4.a(context, "108", "" + (System.currentTimeMillis() / 1000), true);
                return jfo8qVar;
            } catch (Throwable unused9) {
                return jfo8q.a(-10007);
            }
        }
        j16 = 300;
        a37.append((int) j16);
        hashMap.put("2012", a37.toString());
        if (bVar.a(136)) {
            hashMap.put("501", "1");
        }
        if (bVar.a(143)) {
        }
        this.f382053a.getClass();
        if (bVar.a(144)) {
        }
        bVar2 = b.f382488g;
        ZY08E zy08e22 = ZY08E.f382121f;
        if (!bVar2.a(41)) {
        }
        dVar = this.f382053a.f382216c;
        if (dVar != null) {
        }
        hashMap.put("264", sh4jo.a());
        if (bVar2.a(22)) {
        }
        if (!bVar2.a(10002)) {
        }
        if (!bVar2.a(10003)) {
        }
        hashMap.put("266", XStYH.b(context, "901"));
        if (bVar2.a(115)) {
        }
        if (bVar2.a(116)) {
        }
        if (bVar2.a(117)) {
        }
        if (bVar2.a(46)) {
        }
        if (bVar2.a(118)) {
        }
        if (!bVar2.a(17)) {
        }
        this.f382053a.getClass();
        a16 = OCkqn.a((f) null);
        HashSet hashSet2 = new HashSet();
        if (!v0KaV.a(a16)) {
        }
        c16 = zy08e22.c();
        if (c16 != null) {
        }
        hashSet2.add(context.getPackageName());
        hashMap.put("277", OCkqn.a(hashSet2));
        if (bVar2.a(122)) {
        }
        if (bVar2.a(126)) {
        }
        a17 = zy08e22.a("x_l2_p_i");
        if (a17 != null) {
        }
        a18 = zy08e22.a("x_u_p_i");
        if (a18 != null) {
        }
        a19 = zy08e22.a();
        if (a19 != null) {
        }
        bVar3 = b.f382488g;
        if (bVar3.a(39)) {
        }
        if (bVar3.a(100)) {
        }
        if (bVar3.a(101)) {
        }
        if (bVar3.a(102)) {
        }
        if (bVar3.a(103)) {
        }
        if (bVar3.a(104)) {
        }
        if (bVar3.a(105)) {
        }
        if (bVar3.a(106)) {
        }
        if (bVar3.a(107)) {
        }
        if (bVar3.a(114)) {
        }
        if (bVar3.a(44)) {
        }
        if (bVar3.a(138)) {
        }
        StringBuilder a672 = tmnyR.a("");
        this.f382053a.getClass();
        a672.append(0);
        hashMap.put("403", a672.toString());
        hashMap.put("402", this.f382053a.f382223j);
        hashMap.put("404", this.f382053a.f382224k);
        hashMap.put("401", this.f382053a.f382225l);
        this.f382053a.getClass();
        hashMap.put("405", null);
        Map<Integer, String> map2 = this.f382053a.f382226m;
        StringBuilder sb112 = new StringBuilder();
        it = map2.keySet().iterator();
        while (it.hasNext()) {
        }
        hashMap.put(PersonalityConfig.RESERVES_COVER_CLICK_WIDGET_VISITOR_WITH_NANE_PLATGE, sb112.toString());
        this.f382056d.getClass();
        hashMap.put("302", XStYH.b(context, ThemeReporter.FROM_DIY));
        this.f382056d.getClass();
        hashMap.put("303", XStYH.b(context, ThemeReporter.FROM_NIGHT));
        this.f382056d.getClass();
        hashMap.put("305", XStYH.b(context, ThemeReporter.FROM_WEEKLOOP));
        hashMap.put("308", "" + ((int) kWj12.b(context)));
        this.f382056d.getClass();
        hashMap.put("309", XStYH.b(context, "404"));
        this.f382056d.getClass();
        hashMap.put("310", XStYH.b(context, ThemeReporter.FROM_ENGINE));
        this.f382053a.getClass();
        SparseArray<Object> a91_FC6D5B0A7013DB602 = TNative$aa.a91_FC6D5B0A7013DB60(new SparseArray(), context, hashMap, null, 0);
        this.f382056d.a(context, ThemeReporter.FROM_DIY, (System.currentTimeMillis() - currentTimeMillis2) + "_" + (z16 ? 1 : 0));
        b16 = SWw7W.b(a91_FC6D5B0A7013DB602);
        byte[] a682 = SWw7W.a(a91_FC6D5B0A7013DB602);
        StringBuilder sb122 = new StringBuilder();
        str2 = (String) SWw7W.a(a91_FC6D5B0A7013DB602, 2, String.class);
        Random random3 = Ckq8l.f381753a;
        if (str2 == null) {
        }
        sb122.append(str2);
        StringBuilder sb132 = new StringBuilder();
        it5 = ((HashMap) Bi3eT.f381729a).keySet().iterator();
        while (it5.hasNext()) {
        }
        sb122.append(sb132.toString());
        this.f382056d.a(context, ThemeReporter.FROM_ENGINE, sb122.toString());
        XStYH xStYH22 = this.f382056d;
        long length22 = a682.length;
        xStYH22.getClass();
        xStYH22.a(context, ThemeReporter.FROM_WEEKLOOP, "" + length22 + "_" + (z16 ? 1 : 0));
        if (b16 != 0) {
        }
        long currentTimeMillis102 = System.currentTimeMillis() - currentTimeMillis;
        i17 = a26.f382255a;
        if (i17 != 0) {
        }
        z18 = false;
        if (z18) {
        }
        this.f382053a.getClass();
        if (bVar.a(144)) {
        }
        bVar2 = b.f382488g;
        ZY08E zy08e222 = ZY08E.f382121f;
        if (!bVar2.a(41)) {
        }
        dVar = this.f382053a.f382216c;
        if (dVar != null) {
        }
        hashMap.put("264", sh4jo.a());
        if (bVar2.a(22)) {
        }
        if (!bVar2.a(10002)) {
        }
        if (!bVar2.a(10003)) {
        }
        hashMap.put("266", XStYH.b(context, "901"));
        if (bVar2.a(115)) {
        }
        if (bVar2.a(116)) {
        }
        if (bVar2.a(117)) {
        }
        if (bVar2.a(46)) {
        }
        if (bVar2.a(118)) {
        }
        if (!bVar2.a(17)) {
        }
        this.f382053a.getClass();
        a16 = OCkqn.a((f) null);
        HashSet hashSet22 = new HashSet();
        if (!v0KaV.a(a16)) {
        }
        c16 = zy08e222.c();
        if (c16 != null) {
        }
        hashSet22.add(context.getPackageName());
        hashMap.put("277", OCkqn.a(hashSet22));
        if (bVar2.a(122)) {
        }
        if (bVar2.a(126)) {
        }
        a17 = zy08e222.a("x_l2_p_i");
        if (a17 != null) {
        }
        a18 = zy08e222.a("x_u_p_i");
        if (a18 != null) {
        }
        a19 = zy08e222.a();
        if (a19 != null) {
        }
        bVar3 = b.f382488g;
        if (bVar3.a(39)) {
        }
        if (bVar3.a(100)) {
        }
        if (bVar3.a(101)) {
        }
        if (bVar3.a(102)) {
        }
        if (bVar3.a(103)) {
        }
        if (bVar3.a(104)) {
        }
        if (bVar3.a(105)) {
        }
        if (bVar3.a(106)) {
        }
        if (bVar3.a(107)) {
        }
        if (bVar3.a(114)) {
        }
        if (bVar3.a(44)) {
        }
        if (bVar3.a(138)) {
        }
        StringBuilder a6722 = tmnyR.a("");
        this.f382053a.getClass();
        a6722.append(0);
        hashMap.put("403", a6722.toString());
        hashMap.put("402", this.f382053a.f382223j);
        hashMap.put("404", this.f382053a.f382224k);
        hashMap.put("401", this.f382053a.f382225l);
        this.f382053a.getClass();
        hashMap.put("405", null);
        Map<Integer, String> map22 = this.f382053a.f382226m;
        StringBuilder sb1122 = new StringBuilder();
        it = map22.keySet().iterator();
        while (it.hasNext()) {
        }
        hashMap.put(PersonalityConfig.RESERVES_COVER_CLICK_WIDGET_VISITOR_WITH_NANE_PLATGE, sb1122.toString());
        this.f382056d.getClass();
        hashMap.put("302", XStYH.b(context, ThemeReporter.FROM_DIY));
        this.f382056d.getClass();
        hashMap.put("303", XStYH.b(context, ThemeReporter.FROM_NIGHT));
        this.f382056d.getClass();
        hashMap.put("305", XStYH.b(context, ThemeReporter.FROM_WEEKLOOP));
        hashMap.put("308", "" + ((int) kWj12.b(context)));
        this.f382056d.getClass();
        hashMap.put("309", XStYH.b(context, "404"));
        this.f382056d.getClass();
        hashMap.put("310", XStYH.b(context, ThemeReporter.FROM_ENGINE));
        this.f382053a.getClass();
        SparseArray<Object> a91_FC6D5B0A7013DB6022 = TNative$aa.a91_FC6D5B0A7013DB60(new SparseArray(), context, hashMap, null, 0);
        this.f382056d.a(context, ThemeReporter.FROM_DIY, (System.currentTimeMillis() - currentTimeMillis2) + "_" + (z16 ? 1 : 0));
        b16 = SWw7W.b(a91_FC6D5B0A7013DB6022);
        byte[] a6822 = SWw7W.a(a91_FC6D5B0A7013DB6022);
        StringBuilder sb1222 = new StringBuilder();
        str2 = (String) SWw7W.a(a91_FC6D5B0A7013DB6022, 2, String.class);
        Random random32 = Ckq8l.f381753a;
        if (str2 == null) {
        }
        sb1222.append(str2);
        StringBuilder sb1322 = new StringBuilder();
        it5 = ((HashMap) Bi3eT.f381729a).keySet().iterator();
        while (it5.hasNext()) {
        }
        sb1222.append(sb1322.toString());
        this.f382056d.a(context, ThemeReporter.FROM_ENGINE, sb1222.toString());
        XStYH xStYH222 = this.f382056d;
        long length222 = a6822.length;
        xStYH222.getClass();
        xStYH222.a(context, ThemeReporter.FROM_WEEKLOOP, "" + length222 + "_" + (z16 ? 1 : 0));
        if (b16 != 0) {
        }
        long currentTimeMillis1022 = System.currentTimeMillis() - currentTimeMillis;
        i17 = a26.f382255a;
        if (i17 != 0) {
        }
    }

    public jfo8q a(Context context) {
        jfo8q jfo8qVar;
        jfo8q a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (jfo8q) iPatchRedirector.redirect((short) 9, (Object) this, (Object) context);
        }
        synchronized (this.f382058f) {
            jfo8qVar = this.f382058f.get();
            if (jfo8qVar == null) {
                XStYH xStYH = this.f382056d;
                if (xStYH != null) {
                    a16 = xStYH.a(context);
                } else {
                    a16 = jfo8q.a(1);
                }
                jfo8qVar = a16;
                this.f382058f.set(jfo8qVar);
            }
        }
        return jfo8qVar;
    }

    public final void a(jfo8q jfo8qVar, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, jfo8qVar, Boolean.valueOf(z16));
            return;
        }
        synchronized (this.f382058f) {
            if (!z16) {
                if (jfo8qVar.f382269c != 0) {
                    return;
                }
            }
            this.f382058f.set(jfo8qVar);
        }
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        synchronized (this.f382059g) {
            if (this.f382059g.get().booleanValue()) {
                return;
            }
            this.f382059g.set(Boolean.TRUE);
            this.f382054b.sendMessageDelayed(Message.obtain(this.f382054b, 2, 3), 0L);
        }
    }

    public final jfo8q a(Context context, boolean z16, int i3) {
        jfo8q a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (jfo8q) iPatchRedirector.redirect((short) 5, this, context, Boolean.valueOf(z16), Integer.valueOf(i3));
        }
        jfo8q a17 = a(context);
        if (this.f382053a == null) {
            return jfo8q.a(-10002);
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
            return jfo8q.a(-10008);
        }
        synchronized (this.f382057e) {
            a16 = a(context);
            if (a16 == a17 || a(a16) != 1) {
                synchronized (this.f382059g) {
                    if (!this.f382059g.get().booleanValue()) {
                        this.f382059g.set(Boolean.TRUE);
                        this.f382054b.post(new io3JD(this, context, true, i3));
                    }
                    try {
                        this.f382059g.wait(z16 ? this.f382053a.f382232s : 10000L);
                    } catch (InterruptedException unused) {
                    }
                }
                a16 = a(context);
                if (a16 == a17) {
                    a16 = jfo8q.a(-10004);
                }
            }
        }
        return a16;
    }

    public final int a(jfo8q jfo8qVar) {
        Context context;
        long j3;
        Context context2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, (Object) jfo8qVar)).intValue();
        }
        if (this.f382053a.f382229p || jfo8qVar.f382269c != 0 || TextUtils.isEmpty(jfo8qVar.f382267a)) {
            return 2;
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (currentTimeMillis >= jfo8qVar.f382268b) {
            this.f382053a.getClass();
            return 3;
        }
        XStYH xStYH = this.f382056d;
        synchronized (eh5ma.class) {
            context = eh5ma.f382207a;
        }
        xStYH.getClass();
        try {
            j3 = Long.valueOf(XStYH.b(context, "107")).longValue();
        } catch (Throwable unused) {
            j3 = 0;
        }
        XStYH xStYH2 = this.f382056d;
        synchronized (eh5ma.class) {
            context2 = eh5ma.f382207a;
        }
        if (Math.abs(currentTimeMillis - xStYH2.a(context2, "108")) < j3) {
            return 1;
        }
        this.f382053a.getClass();
        return 3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x00fb, code lost:
    
        if (r22 != false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0126, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0122, code lost:
    
        if (java.lang.Math.abs(java.lang.System.currentTimeMillis() - r3.longValue()) >= com.tencent.turingcam.T0QUa.f382051m) goto L63;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00fe  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final jfo8q a(Context context, boolean z16, boolean z17, int i3) {
        Context context2;
        Context context3;
        String a16;
        jfo8q a17;
        long j3;
        Context context4;
        Context context5;
        byte b16;
        Context context6;
        long j16;
        byte b17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (jfo8q) iPatchRedirector.redirect((short) 7, this, context, Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i3));
        }
        if (!kWj12.c(context)) {
            return jfo8q.a(-10012);
        }
        if (!this.f382053a.f382229p) {
            synchronized (eh5ma.class) {
                context4 = eh5ma.f382207a;
            }
            if ((Math.abs((System.currentTimeMillis() / 1000) - (this.f382056d.a(context4, QAdVrReportParams.ClickAdActionTypeValue.ACTION_TYPE_NO_JUMP) / 1000)) > 3600) == false) {
                return jfo8q.a(-30015);
            }
            XStYH xStYH = this.f382056d;
            synchronized (eh5ma.class) {
                context5 = eh5ma.f382207a;
            }
            VV8k1<Long> a18 = xStYH.a(context5, 30);
            if (a18.f382070b.size() != 0) {
                XStYH xStYH2 = this.f382056d;
                synchronized (eh5ma.class) {
                    context6 = eh5ma.f382207a;
                }
                xStYH2.getClass();
                try {
                    j16 = Long.valueOf(XStYH.b(context6, "401")).longValue();
                } catch (Throwable unused) {
                    j16 = 0;
                }
                if (j16 > 0) {
                    long abs = Math.abs(System.currentTimeMillis() - a18.f382070b.getLast().longValue());
                    int[] iArr = f382052n;
                    int length = j16 < ((long) iArr.length) ? (int) j16 : iArr.length - 1;
                    if (length >= 1) {
                        if (iArr[length - 1] >= iArr[length]) {
                            throw new IllegalArgumentException("");
                        }
                        if (abs <= TimeUnit.SECONDS.toMillis(new Random().nextInt((r3 - r5) + 1) + r5)) {
                            b17 = false;
                            if (b17 == false) {
                                Long first = a18.f382070b.getFirst();
                                if (a18.f382070b.size() >= a18.f382069a) {
                                }
                            }
                            if (b16 == false) {
                                return jfo8q.a(-10011);
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
        XStYH xStYH3 = this.f382056d;
        synchronized (eh5ma.class) {
            context2 = eh5ma.f382207a;
        }
        VV8k1<Long> a19 = xStYH3.a(context2, 30);
        a19.a(Long.valueOf(System.currentTimeMillis()));
        XStYH xStYH4 = this.f382056d;
        synchronized (eh5ma.class) {
            context3 = eh5ma.f382207a;
        }
        xStYH4.getClass();
        StringBuilder sb5 = new StringBuilder();
        for (int i16 = 0; i16 < a19.f382070b.size(); i16++) {
            sb5.append(a19.f382070b.get(i16));
            if (i16 != a19.f382070b.size() - 1) {
                sb5.append("_");
            }
        }
        xStYH4.a(context3, "402", sb5.toString(), true);
        synchronized (ucT3w.class) {
            a16 = ucT3w.a(context, ucT3w.f382401a);
        }
        if (!TextUtils.isEmpty(a16)) {
            this.f382056d.a(context, "404", a16, true);
        }
        YVsFX.a(context, this.f382056d);
        XStYH xStYH5 = this.f382056d;
        long a26 = xStYH5.a(context, "502");
        int myUid = Process.myUid();
        if (a26 == 0) {
            xStYH5.c(context, 0L);
        } else if (a26 != 0 && myUid != a26) {
            xStYH5.c(context, -1L);
        } else {
            xStYH5.c(context, 1L);
        }
        if (ZY08E.f382121f.a("e_b_d", false)) {
            SparseArray sparseArray = new SparseArray();
            TNative$aa.c91_FC6D5B0A7013DB60(sparseArray, context);
            SWw7W.b(sparseArray);
        }
        try {
            a17 = b(context, z16, i3);
        } catch (Throwable th5) {
            Log.w("TuringFdJava", th5);
            a17 = jfo8q.a(-10015);
        }
        if (a17.f382269c == -30015) {
            XStYH xStYH6 = this.f382056d;
            long currentTimeMillis = System.currentTimeMillis();
            xStYH6.getClass();
            xStYH6.a(context, QAdVrReportParams.ClickAdActionTypeValue.ACTION_TYPE_NO_JUMP, "" + currentTimeMillis, true);
        } else if (this.f382056d.a(context, QAdVrReportParams.ClickAdActionTypeValue.ACTION_TYPE_NO_JUMP) != 0) {
            XStYH xStYH7 = this.f382056d;
            xStYH7.getClass();
            xStYH7.a(context, QAdVrReportParams.ClickAdActionTypeValue.ACTION_TYPE_NO_JUMP, "0", true);
        }
        this.f382056d.getClass();
        try {
            j3 = Long.valueOf(XStYH.b(context, "401")).longValue();
        } catch (Throwable unused2) {
            j3 = 0;
        }
        if (a17.f382269c < 0) {
            this.f382056d.a(context, j3 + 1);
        } else if (j3 != 0) {
            this.f382056d.a(context, 0L);
        }
        this.f382056d.getClass();
        if (!TextUtils.isEmpty(XStYH.b(context, "404"))) {
            this.f382056d.a(context, "404", "", true);
        }
        if (a17.f382269c == 0) {
            XStYH xStYH8 = this.f382056d;
            String str = YVsFX.f382107a;
            long a27 = xStYH8.a(context, "502");
            long myUid2 = Process.myUid();
            if (a27 != myUid2) {
                xStYH8.a(context, "502", "" + myUid2, false);
            }
        }
        this.f382056d.a(context, ThemeReporter.FROM_AUTH, String.format("%d_%d_%d_%d_%d_%d", Integer.valueOf(a17.f382269c), Integer.valueOf(z16 ? 1 : 0), Integer.valueOf(i3), 0, Integer.valueOf(a17.f382274h), Integer.valueOf(a17.f382275i)));
        return a17;
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
                String str = uuid + ":" + Ckq8l.a(propertyByteArray);
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
