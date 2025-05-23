package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Handler;
import android.os.SystemProperties;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.aelight.camera.download.AEResManagerConfigBean;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qqlive.tvkplayer.tools.config.TVKConfigSystem;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.turingfd.sdk.xq.Hydra;
import com.tencent.turingfd.sdk.xq.Octans;
import com.tencent.turingfd.sdk.xq.Rambutan;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Orion {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    public static Orion f382973e;

    /* renamed from: f, reason: collision with root package name */
    public static int[] f382974f;

    /* renamed from: g, reason: collision with root package name */
    public static long f382975g;

    /* renamed from: a, reason: collision with root package name */
    public Handler f382976a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f382977b;

    /* renamed from: c, reason: collision with root package name */
    public String f382978c;

    /* renamed from: d, reason: collision with root package name */
    public int f382979d;

    /* compiled from: P */
    /* renamed from: com.tencent.turingfd.sdk.xq.Orion$do, reason: invalid class name */
    /* loaded from: classes27.dex */
    public static class Cdo {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final long f382980a;

        /* renamed from: b, reason: collision with root package name */
        public final Map<Integer, Cygnus> f382981b;

        public Cdo(long j3, Map<Integer, Cygnus> map) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), map);
            } else {
                this.f382980a = j3;
                this.f382981b = map;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12254);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f382973e = new Orion();
        f382974f = new int[]{0, 5, 10, 30, 60, 120, 180, 240, 420, TbsListener.ErrorCode.STATIC_TBS_INSTALL_HAS_INSTALLED_EXCEPTION, 1080, TVKConfigSystem.REQUEST_ONLINE_CONFIG_MIN_INTERVAL_SEC};
        f382975g = TimeUnit.MINUTES.toMillis(5L);
    }

    public Orion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f382977b = new byte[0];
        StringBuilder a16 = Flat.a("IAS_89_");
        a16.append(Nectarine.f382928a);
        a16.append("_");
        a16.append("xq");
        this.f382978c = a16.toString();
        this.f382979d = 3;
    }

    public final Pyxis a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Pyxis) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (this.f382976a == null) {
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread(this.f382978c, -8);
            baseHandlerThread.start();
            this.f382976a = new Handler(baseHandlerThread.getLooper());
        }
        return new Pyxis(this.f382976a);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:15|(1:347)(16:19|13a|24|25|26|27|28|(1:30)|31|(5:33|34|35|(1:37)|38)|338|41|42|(14:45|(1:47)(7:72|(1:74)|75|(1:77)|78|(1:80)|81)|48|(1:50)|51|(1:53)|54|(1:56)|57|(1:59)|60|(2:66|67)|68|43)|82|83)|(1:85)(25:111|(8:113|36e|118|(1:120)|121|122|123|124)|131|3e9|136|(1:138)|139|(1:141)(1:332)|(1:143)|144|(1:146)|147|(1:149)|150|(2:153|151)|154|155|(7:158|159|160|162|(3:164|165|166)(1:168)|167|156)|170|171|4db|176|177|178|(19:180|181|540|187|(1:189)(5:299|300|301|302|(1:304)(2:305|(1:307)(2:308|(1:316)(2:312|(1:314)(1:315)))))|190|(1:192)(1:298)|193|(4:195|(4:198|(3:200|201|202)(1:204)|203|196)|205|206)|207|(2:209|(1:296)(5:213|214|215|(1:217)(2:219|(1:221)(2:222|(1:224)(2:225|(1:293)(7:229|(8:232|(1:234)|235|(2:237|(14:239|(1:241)|242|(1:244)|245|(1:247)|248|(1:250)|251|(7:253|(1:257)|258|(1:273)|261|(5:267|268|(1:270)|271|272)(3:263|264|265)|266)|275|261|(0)(0)|266))|276|(0)(0)|266|230)|277|278|(4:281|(3:287|288|289)(3:283|284|285)|286|279)|290|291))))|218))(1:297)|292|87|(4:89|(4:92|(2:94|95)(1:97)|96|90)|98|99)|100|101|102|(1:104)(2:106|(1:108))|105)(2:325|326))|86|87|(0)|100|101|102|(0)(0)|105) */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x08fa, code lost:
    
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:356:0x00b0, code lost:
    
        if (r37 != false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:357:0x00db, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:361:0x00d7, code lost:
    
        if (java.lang.Math.abs(java.lang.System.currentTimeMillis() - r3.longValue()) >= com.tencent.turingfd.sdk.xq.Orion.f382975g) goto L38;
     */
    /* JADX WARN: Removed duplicated region for block: B:104:0x08fe  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0909  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x07e3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:267:0x07af A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:356:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:358:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0862  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Cdo a(Map<Integer, Norma> map, Context context, boolean z16) {
        long j3;
        Integer num;
        boolean z17;
        boolean z18;
        Integer num2;
        long j16;
        long j17;
        byte[] bArr;
        Context context2;
        long j18;
        Context context3;
        byte[] bArr2;
        Quarenden a16;
        HashMap hashMap;
        long j19;
        int i3;
        long a17;
        long j26;
        Iterator<Kiwifruit> it;
        int i16;
        int i17;
        int i18;
        int i19;
        boolean z19;
        long j27;
        long j28;
        byte[] a18;
        Context context4;
        int i26;
        Context context5;
        Cumquat cumquat;
        Integer num3;
        String str;
        int i27;
        IPatchRedirector iPatchRedirector = $redirector_;
        Integer num4 = 1;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Cdo) iPatchRedirector.redirect((short) 4, this, map, context, Boolean.valueOf(z16));
        }
        UrsaMinor<Long> a19 = a().a(context);
        if (a19.f383176b.size() == 0) {
            num = 3;
        } else {
            a();
            try {
                j3 = Long.valueOf(Pyxis.a(context, ThemeReporter.FROM_DIY)).longValue();
            } catch (Throwable unused) {
                j3 = 0;
            }
            if (j3 <= 0) {
                num = 3;
            } else {
                long abs = Math.abs(System.currentTimeMillis() - a19.f383176b.getLast().longValue());
                int[] iArr = f382974f;
                num = 3;
                int length = j3 < ((long) iArr.length) ? (int) j3 : iArr.length - 1;
                if (length >= 1) {
                    if (iArr[length - 1] >= iArr[length]) {
                        throw new IllegalArgumentException("");
                    }
                    if (abs <= TimeUnit.SECONDS.toMillis(new Random().nextInt((r3 - r4) + 1) + r4)) {
                        z17 = false;
                        if (!z17) {
                            Long first = a19.f383176b.getFirst();
                            if (a19.f383176b.size() >= a19.f383175a) {
                            }
                        }
                        if (!z18) {
                            String str2 = Walnut.f383198b;
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put("602", "-5000000_0_0");
                            Walnut.a(context, hashMap2);
                            return new Cdo(-5000000L, new HashMap());
                        }
                        HashMap hashMap3 = new HashMap();
                        Pegasus pegasus = new Pegasus(map, hashMap3);
                        if (map == null || map.size() == 0) {
                            num2 = num4;
                            j16 = -1;
                            j17 = -1;
                            bArr = null;
                        } else {
                            long currentTimeMillis = System.currentTimeMillis();
                            Cconst cconst = new Cconst();
                            synchronized (Celse.class) {
                                context5 = Celse.f383328a;
                            }
                            Dew dew = new Dew();
                            Damson damson = new Damson();
                            damson.f382689a = 11;
                            damson.f382690b = 1;
                            damson.f382691c = 1;
                            damson.f382692d = 0;
                            damson.f382693e = 0;
                            damson.f382694f = null;
                            damson.f382695g = 0;
                            damson.f382700l = 1;
                            Ccase ccase = new Ccase();
                            ccase.f383237a = 1;
                            damson.f382702n = ccase;
                            dew.f382720a = damson;
                            Herbaceous herbaceous = new Herbaceous();
                            try {
                                herbaceous.f382813a = Cprivate.a(Build.FINGERPRINT);
                                herbaceous.f382814b = Cprivate.a(false);
                                herbaceous.f382815c = Cprivate.a(Build.BRAND);
                                herbaceous.f382816d = Cprivate.a();
                                herbaceous.f382817e = Build.VERSION.SDK_INT;
                                herbaceous.f382818f = Cprivate.a(Build.CPU_ABI);
                                try {
                                    Method method = SystemProperties.class.getMethod("get", String.class);
                                    method.setAccessible(true);
                                    str = (String) method.invoke(null, "ro.board.platform");
                                    if (str == null) {
                                        str = "";
                                    }
                                } catch (Throwable unused2) {
                                    str = "";
                                }
                                herbaceous.f382819g = Cprivate.a(str);
                                if (Pegasus.f382993d != -1) {
                                    new SparseArray();
                                    try {
                                        String str3 = (String) Bagasse.a(TNative$aa.d89_A931D6BEC30CD812(new SparseArray(), context5, 201), 201, String.class);
                                        int i28 = Plum.f383026a;
                                        if (str3 == null) {
                                            str3 = "";
                                        }
                                        Pegasus.f382993d = Integer.parseInt(str3);
                                    } catch (Throwable unused3) {
                                        i27 = -1;
                                    }
                                }
                                i27 = Pegasus.f382993d;
                                herbaceous.f382820h = i27;
                            } catch (Exception unused4) {
                            }
                            dew.f382721b = herbaceous;
                            dew.f382722c = 1;
                            dew.f382724e = "";
                            dew.f382723d = ((Sultana) i.a(context5)).f383113a;
                            cconst.f383245a = dew;
                            ArrayList arrayList = new ArrayList();
                            for (Integer num5 : pegasus.f382994a.keySet()) {
                                Norma norma = pegasus.f382994a.get(num5);
                                Date date = new Date();
                                int intValue = num5.intValue();
                                if (norma == null) {
                                    num3 = num4;
                                    cumquat = null;
                                } else {
                                    cumquat = new Cumquat();
                                    cumquat.f382663a = intValue;
                                    String str4 = norma.f382935f;
                                    int i29 = Plum.f383026a;
                                    if (str4 == null) {
                                        str4 = "";
                                    }
                                    cumquat.f382664b = Plum.b(str4);
                                    String str5 = norma.f382930a;
                                    if (str5 == null) {
                                        str5 = "";
                                    }
                                    cumquat.f382665c = str5;
                                    String str6 = norma.f382931b;
                                    if (str6 == null) {
                                        str6 = "";
                                    }
                                    cumquat.f382666d = Plum.b(str6);
                                    num3 = num4;
                                    cumquat.f382667e = norma.f382932c;
                                    cumquat.f382671i = 0;
                                    cumquat.f382672j = "";
                                    cumquat.f382673k = 0;
                                    cumquat.f382674l = 0;
                                    cumquat.f382675m = 0;
                                    cumquat.f382676n = null;
                                    cumquat.f382677o = 0;
                                    cumquat.f382678p = false;
                                    cumquat.f382679q = 0;
                                    cumquat.f382680r = 0;
                                }
                                date.f382708a = cumquat;
                                String str7 = norma.f382936g;
                                int i36 = Plum.f383026a;
                                if (str7 == null) {
                                    str7 = "";
                                }
                                date.f382709b = str7;
                                String str8 = norma.f382933d;
                                if (str8 == null) {
                                    str8 = "";
                                }
                                date.f382710c = str8;
                                date.f382712e = norma.f382937h;
                                String str9 = norma.f382934e;
                                if (str9 == null) {
                                    str9 = "";
                                }
                                date.f382713f = Plum.b(str9);
                                date.f382714g = norma.f382938i;
                                String str10 = norma.f382939j;
                                if (str10 == null) {
                                    str10 = "";
                                }
                                date.f382715h = str10;
                                String str11 = pegasus.f382996c;
                                if (str11 != null && str11.isEmpty() && !str10.isEmpty()) {
                                    pegasus.f382996c = str10;
                                }
                                date.f382716i = norma.f382940k;
                                date.f382717j = norma.f382941l;
                                arrayList.add(date);
                                num4 = num3;
                            }
                            num2 = num4;
                            cconst.f383246b = arrayList;
                            Solar solar = new Solar(128);
                            solar.f383075b = "UTF-8";
                            cconst.a(solar);
                            bArr = solar.a();
                            j16 = System.currentTimeMillis() - currentTimeMillis;
                            j17 = bArr.length;
                        }
                        if (bArr == null) {
                            a17 = pegasus.a(-1100000L);
                            hashMap = hashMap3;
                            j18 = j16;
                        } else {
                            f fVar = f.f383333e;
                            String str12 = pegasus.f382996c;
                            fVar.getClass();
                            Cfinal cfinal = new Cfinal();
                            cfinal.f383342a = System.currentTimeMillis();
                            HashMap hashMap4 = new HashMap();
                            hashMap4.put(num2, bArr);
                            cfinal.f383343b = hashMap4;
                            cfinal.f383344c = 0;
                            Nucleus nucleus = new Nucleus();
                            nucleus.f382942a = 89;
                            nucleus.f382943b = "89";
                            nucleus.f382944c = "A931D6BEC30CD812";
                            StringBuilder a26 = Flat.a("");
                            a26.append(Nectarine.f382928a);
                            nucleus.f382945d = a26.toString();
                            nucleus.f382946e = 2;
                            cfinal.f383345d = nucleus;
                            if (fVar.f383335b == null) {
                                fVar.f383335b = new Cascara();
                                synchronized (Celse.class) {
                                    context4 = Celse.f383328a;
                                }
                                Cascara cascara = fVar.f383335b;
                                String packageName = context4.getPackageName();
                                int i37 = Plum.f383026a;
                                if (packageName == null) {
                                    packageName = "";
                                }
                                cascara.f382643b = packageName;
                                String packageName2 = context4.getPackageName();
                                String str13 = AEResManagerConfigBean.DEFAULT_VERSION;
                                try {
                                    PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(context4.getPackageManager(), packageName2, 64);
                                    str13 = packageInfo.versionName;
                                    i26 = packageInfo.versionCode;
                                } catch (Throwable unused5) {
                                    i26 = 0;
                                }
                                fVar.f383335b.f382642a = String.format("%s,%d", str13, Integer.valueOf(i26));
                            }
                            cfinal.f383346e = fVar.f383335b;
                            Pomelo pomelo = new Pomelo();
                            pomelo.f383037h = fVar.f383334a.b();
                            fVar.f383334a.getClass();
                            pomelo.f383031b = null;
                            Strawberry strawberry = fVar.f383334a;
                            pomelo.f383032c = strawberry.f383090l;
                            pomelo.f383033d = strawberry.f383092n;
                            pomelo.f383034e = strawberry.f383091m;
                            pomelo.f383035f = strawberry.f383093o;
                            cfinal.f383347f = pomelo;
                            HashMap hashMap5 = new HashMap();
                            synchronized (Celse.class) {
                                context2 = Celse.f383328a;
                            }
                            Sultana sultana = (Sultana) i.a(context2);
                            String str14 = sultana.f383113a;
                            int i38 = Plum.f383026a;
                            if (str14 == null) {
                                str14 = "";
                            }
                            hashMap5.put(num2, str14);
                            Strawberry strawberry2 = fVar.f383334a;
                            j18 = j16;
                            String str15 = TextUtils.isEmpty(strawberry2.f383085g) ? "" : strawberry2.f383085g;
                            if (str15 == null) {
                                str15 = "";
                            }
                            hashMap5.put(6, str15);
                            if (str12 == null) {
                                str12 = "";
                            }
                            hashMap5.put(4, str12);
                            String str16 = sultana.f383118f;
                            if (str16 == null) {
                                str16 = "";
                            }
                            Integer num6 = num;
                            hashMap5.put(num6, str16);
                            cfinal.f383348g = hashMap5;
                            HashMap hashMap6 = new HashMap();
                            Context c16 = fVar.f383334a.c();
                            String str17 = Walnut.f383198b;
                            HashMap hashMap7 = new HashMap();
                            for (Iterator it5 = ((HashSet) Walnut.a(c16)).iterator(); it5.hasNext(); it5 = it5) {
                                String str18 = (String) it5.next();
                                hashMap7.put(str18, Walnut.b(c16, "TSS_" + str18));
                            }
                            for (String str19 : hashMap7.keySet()) {
                                try {
                                    int parseInt = Integer.parseInt(str19);
                                    String str20 = (String) hashMap7.get(str19);
                                    if (str20 != null) {
                                        hashMap6.put(Integer.valueOf(parseInt), str20);
                                    }
                                } catch (Throwable unused6) {
                                }
                            }
                            hashMap6.put(2, Walnut.b(fVar.f383334a.c(), "602"));
                            hashMap6.put(num6, Walnut.b(fVar.f383334a.c(), "702"));
                            hashMap6.put(4, Walnut.b(fVar.f383334a.c(), "703"));
                            cfinal.f383349h = hashMap6;
                            synchronized (Celse.class) {
                                context3 = Celse.f383328a;
                            }
                            byte a27 = Bennet.a(context3);
                            String str21 = f.f383331c;
                            try {
                                p pVar = new p();
                                Foxnut foxnut = pVar.f383410a;
                                foxnut.f382774e = str21;
                                foxnut.f382775f = str21;
                                pVar.a("req", cfinal);
                                a18 = Cstatic.a(pVar.a());
                            } catch (Exception unused7) {
                                bArr2 = null;
                            }
                            if (a18 != null) {
                                bArr2 = Cdefault.b(a18, Cdefault.a());
                                long currentTimeMillis2 = System.currentTimeMillis();
                                Object obj = new Object();
                                AtomicReference atomicReference = new AtomicReference();
                                AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                                atomicReference.set(f.f383332d);
                                new e(fVar, bArr2, atomicBoolean, atomicReference, obj).start();
                                synchronized (obj) {
                                    try {
                                        obj.wait(10000L);
                                    } catch (InterruptedException unused8) {
                                    }
                                }
                                atomicBoolean.set(true);
                                Hydra.Cdo cdo = (Hydra.Cdo) atomicReference.get();
                                Rambutan.Cdo cdo2 = new Rambutan.Cdo();
                                cdo2.f383053c = bArr2.length;
                                cdo2.f383054d = System.currentTimeMillis() - currentTimeMillis2;
                                cdo2.f383051a = true;
                                cdo2.f383052b = a27;
                                Rambutan rambutan = new Rambutan(cdo2);
                                int i39 = cdo.f382843a;
                                if (i39 != 0) {
                                    a16 = Quarenden.a(i39 - 10000, rambutan);
                                } else {
                                    try {
                                        Taurus a28 = q.a(new Melon(), cdo.f382844b);
                                        if (!(a28 instanceof Melon)) {
                                            a16 = Quarenden.a(-103L, rambutan);
                                        } else {
                                            Melon melon = (Melon) a28;
                                            int i46 = melon.f382925a;
                                            if (i46 != 0) {
                                                a16 = Quarenden.a(i46 - 30000, rambutan);
                                            } else {
                                                Map<Integer, byte[]> map2 = melon.f382926b;
                                                if (map2 != null && map2.size() != 0) {
                                                    if (!map2.containsKey(num2)) {
                                                        a16 = Quarenden.a(-302L, rambutan);
                                                    } else {
                                                        byte[] bArr3 = map2.get(num2);
                                                        rambutan.f383044a = 0L;
                                                        a16 = new Quarenden(0L, bArr3, rambutan);
                                                    }
                                                } else {
                                                    a16 = Quarenden.a(-301L, rambutan);
                                                }
                                            }
                                        }
                                    } catch (Throwable unused9) {
                                        a16 = Quarenden.a(-102L, rambutan);
                                    }
                                }
                                Context c17 = fVar.f383334a.c();
                                Rambutan rambutan2 = a16.f383043c;
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append(rambutan2.f383044a);
                                sb5.append("_");
                                sb5.append(rambutan2.f383045b ? "1" : "2");
                                sb5.append("_");
                                sb5.append(rambutan2.f383046c);
                                sb5.append("_");
                                sb5.append(rambutan2.f383047d);
                                sb5.append("_");
                                sb5.append(rambutan2.f383048e);
                                sb5.append("_");
                                sb5.append(rambutan2.f383049f);
                                sb5.append("_");
                                sb5.append(rambutan2.f383050g);
                                String sb6 = sb5.toString();
                                HashMap hashMap8 = new HashMap();
                                hashMap8.put("TSS_1", sb6);
                                HashSet hashSet = (HashSet) Walnut.a(c17);
                                if (!hashSet.contains(Sculptor.a("", 1))) {
                                    hashSet.add("1");
                                    Iterator it6 = hashSet.iterator();
                                    StringBuilder sb7 = new StringBuilder();
                                    while (it6.hasNext()) {
                                        sb7.append((String) it6.next());
                                        if (it6.hasNext()) {
                                            sb7.append("_");
                                        }
                                    }
                                    hashMap8.put("701", sb7.toString());
                                }
                                Walnut.a(c17, hashMap8);
                                long j29 = a16.f383041a;
                                if (j29 == 0) {
                                    byte[] bArr4 = a16.f383042b;
                                    if (bArr4 != null && bArr4.length != 0) {
                                        try {
                                            Mandarin mandarin = new Mandarin();
                                            Serpens serpens = new Serpens(bArr4);
                                            serpens.f383068b = "UTF-8";
                                            mandarin.a(serpens);
                                            long j36 = mandarin.f382891a;
                                            if (j36 != 0) {
                                                a17 = pegasus.a(j36 - 3200000);
                                            } else {
                                                Mangosteen mangosteen = mandarin.f382894d;
                                                if (mangosteen == null) {
                                                    a17 = pegasus.a(-4000000L);
                                                } else if (mangosteen.f382907a != 0) {
                                                    a17 = pegasus.a(j36 - 4100000);
                                                } else {
                                                    List<Kiwifruit> list = mangosteen.f382908b;
                                                    if (list != null && list.size() != 0) {
                                                        Iterator<Kiwifruit> it7 = list.iterator();
                                                        while (it7.hasNext()) {
                                                            Kiwifruit next = it7.next();
                                                            String str22 = "";
                                                            String str23 = "";
                                                            String str24 = "";
                                                            String str25 = "";
                                                            String str26 = next.f382862d;
                                                            int i47 = Plum.f383026a;
                                                            if (str26 == null) {
                                                                str26 = "";
                                                            }
                                                            Hickory hickory = next.f382859a;
                                                            if (hickory != null) {
                                                                i19 = hickory.f382824a;
                                                                if (pegasus.f382994a.containsKey(Integer.valueOf(i19))) {
                                                                    Norma norma2 = pegasus.f382994a.get(Integer.valueOf(i19));
                                                                    String str27 = norma2.f382936g;
                                                                    if (str27 == null) {
                                                                        str27 = "";
                                                                    }
                                                                    str24 = str27;
                                                                    String str28 = norma2.f382934e;
                                                                    if (str28 == null) {
                                                                        str28 = "";
                                                                    }
                                                                    str22 = str28;
                                                                    String str29 = norma2.f382930a;
                                                                    if (str29 == null) {
                                                                        str29 = "";
                                                                    }
                                                                    str25 = str29;
                                                                    String str30 = norma2.f382935f;
                                                                    if (str30 == null) {
                                                                        str30 = "";
                                                                    }
                                                                    str23 = str30;
                                                                    i17 = hickory.f382825b;
                                                                    i18 = hickory.f382827d;
                                                                    if (str26.isEmpty()) {
                                                                        if (i17 >= 1 && i17 <= 3) {
                                                                            str26 = "\u6587\u4ef6\u5b58\u5728\u98ce\u9669\uff0c\u8c28\u614e\u5b89\u88c5\uff0c\u67e5\u770b\u8be6\u60c5\u3002";
                                                                        }
                                                                        if (i17 == 0 || i17 == 4) {
                                                                            str26 = "\u6b64\u4e3a\u53ef\u6267\u884c\u6587\u4ef6\uff0c\u5b89\u88c5\u53ef\u80fd\u6709\u5b89\u5168\u98ce\u9669\uff0c\u8bf7\u8c28\u614e\u64cd\u4f5c\u3002";
                                                                        }
                                                                        it = it7;
                                                                        j28 = j17;
                                                                        i16 = -1;
                                                                        j27 = 0;
                                                                        z19 = true;
                                                                        if (i19 != i16) {
                                                                            Map<Integer, Cygnus> map3 = pegasus.f382995b;
                                                                            Integer valueOf = Integer.valueOf(i19);
                                                                            HashMap hashMap9 = hashMap3;
                                                                            Octans.Cdo cdo3 = new Octans.Cdo(z19, j27);
                                                                            cdo3.f382959c = str25;
                                                                            cdo3.f382960d = i17;
                                                                            cdo3.f382961e = i18;
                                                                            String str31 = next.f382860b;
                                                                            if (str31 == null) {
                                                                                str31 = "";
                                                                            }
                                                                            cdo3.f382962f = str31;
                                                                            cdo3.f382963g = str22;
                                                                            cdo3.f382964h = str23;
                                                                            cdo3.f382965i = str24;
                                                                            cdo3.f382966j = str26;
                                                                            map3.put(valueOf, new Octans(cdo3));
                                                                            it7 = it;
                                                                            j17 = j28;
                                                                            hashMap3 = hashMap9;
                                                                        } else {
                                                                            it7 = it;
                                                                            j17 = j28;
                                                                        }
                                                                    }
                                                                    it = it7;
                                                                    j28 = j17;
                                                                    i16 = -1;
                                                                    j27 = 0;
                                                                    z19 = true;
                                                                    if (i19 != i16) {
                                                                    }
                                                                }
                                                            }
                                                            it = it7;
                                                            i16 = -1;
                                                            i17 = -1;
                                                            i18 = -1;
                                                            i19 = -1;
                                                            z19 = false;
                                                            long j37 = j17;
                                                            j27 = -10000000;
                                                            j28 = j37;
                                                            if (i19 != i16) {
                                                            }
                                                        }
                                                        hashMap = hashMap3;
                                                        j19 = j17;
                                                        long j38 = -4200000;
                                                        for (Integer num7 : pegasus.f382994a.keySet()) {
                                                            if (pegasus.f382995b.containsKey(num7)) {
                                                                j38 = 0;
                                                            } else {
                                                                pegasus.f382995b.put(num7, new Octans(new Octans.Cdo(false, -4200000L)));
                                                            }
                                                        }
                                                        i3 = 0;
                                                        a17 = j38;
                                                    } else {
                                                        hashMap = hashMap3;
                                                        j19 = j17;
                                                        i3 = 0;
                                                        a17 = pegasus.a(-4200000L);
                                                    }
                                                }
                                            }
                                            hashMap = hashMap3;
                                        } catch (Throwable unused10) {
                                            hashMap = hashMap3;
                                            j19 = j17;
                                            i3 = 0;
                                            a17 = pegasus.a(-3100000L);
                                        }
                                    } else {
                                        hashMap = hashMap3;
                                        j19 = j17;
                                        i3 = 0;
                                        a17 = pegasus.a(-3000000L);
                                    }
                                } else {
                                    hashMap = hashMap3;
                                    j19 = j17;
                                    i3 = 0;
                                    a17 = pegasus.a(j29 - 2000000);
                                }
                                j26 = 0;
                                if (a17 != j26) {
                                    UrsaMinor<Long> a29 = a().a(context);
                                    a29.a(Long.valueOf(System.currentTimeMillis()));
                                    Pyxis a36 = a();
                                    StringBuilder sb8 = new StringBuilder();
                                    for (int i48 = i3; i48 < a29.f383176b.size(); i48++) {
                                        sb8.append(a29.f383176b.get(i48));
                                        if (i48 != a29.f383176b.size() - 1) {
                                            sb8.append("_");
                                        }
                                    }
                                    a36.a(context, "101", sb8.toString(), true);
                                }
                                Cdo cdo4 = new Cdo(a17, hashMap);
                                String str32 = Walnut.f383198b;
                                HashMap hashMap10 = new HashMap();
                                hashMap10.put("602", a17 + "_" + j19 + "_" + j18);
                                Walnut.a(context, hashMap10);
                                a();
                                long j39 = Long.valueOf(Pyxis.a(context, ThemeReporter.FROM_DIY)).longValue();
                                if (a17 >= j26) {
                                    a().a(context, j39 + 1);
                                } else if (j39 != 0) {
                                    a().a(context, 0L);
                                }
                                return cdo4;
                            }
                            throw new RuntimeException("compress data fail");
                        }
                        j19 = j17;
                        j26 = 0;
                        i3 = 0;
                        if (a17 != j26) {
                        }
                        Cdo cdo42 = new Cdo(a17, hashMap);
                        String str322 = Walnut.f383198b;
                        HashMap hashMap102 = new HashMap();
                        hashMap102.put("602", a17 + "_" + j19 + "_" + j18);
                        Walnut.a(context, hashMap102);
                        a();
                        long j392 = Long.valueOf(Pyxis.a(context, ThemeReporter.FROM_DIY)).longValue();
                        if (a17 >= j26) {
                        }
                        return cdo42;
                    }
                }
            }
            z17 = true;
            if (!z17) {
            }
            if (!z18) {
            }
        }
        z18 = true;
        if (!z18) {
        }
    }
}
