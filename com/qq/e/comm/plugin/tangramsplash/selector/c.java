package com.qq.e.comm.plugin.tangramsplash.selector;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.managers.thread.GdtSDKThreadManager;
import com.qq.e.comm.pi.ICustomAdDataGenerator;
import com.qq.e.comm.plugin.base.ad.model.l;
import com.qq.e.comm.plugin.base.ad.model.r;
import com.qq.e.comm.plugin.base.ad.model.u;
import com.qq.e.comm.plugin.j.e;
import com.qq.e.comm.plugin.k.af;
import com.qq.e.comm.plugin.k.at;
import com.qq.e.comm.plugin.k.h;
import com.qq.e.comm.plugin.router.PublicApi;
import com.qq.e.comm.plugin.router.PublicApiHelper;
import com.qq.e.comm.plugin.tangramsplash.d.f;
import com.qq.e.comm.plugin.tangramsplash.d.g;
import com.qq.e.comm.plugin.tangramsplash.fusionsdkimpl.c.d;
import com.qq.e.comm.plugin.tangramsplash.report.SplashLinkReporter;
import com.qq.e.comm.plugin.tangramsplash.report.c;
import com.qq.e.comm.plugin.tangramsplash.selector.a;
import com.qq.e.comm.util.AdError;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.ams.fusion.service.splash.model.SplashOrder;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class c implements a.InterfaceC0294a {

    /* renamed from: a, reason: collision with root package name */
    public static volatile List<r> f40320a = new CopyOnWriteArrayList();

    /* renamed from: b, reason: collision with root package name */
    private volatile a f40321b;

    /* renamed from: c, reason: collision with root package name */
    private volatile int f40322c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f40323d;

    /* renamed from: f, reason: collision with root package name */
    private b f40325f;

    /* renamed from: g, reason: collision with root package name */
    private long f40326g;

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f40324e = false;

    /* renamed from: h, reason: collision with root package name */
    private final ConcurrentHashMap<String, List<pt.a>> f40327h = new ConcurrentHashMap<>();

    /* renamed from: i, reason: collision with root package name */
    private AtomicInteger f40328i = null;

    /* renamed from: j, reason: collision with root package name */
    private com.qq.e.comm.plugin.tangramsplash.selector.a f40329j = null;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface a {
        void a(Bitmap bitmap);

        void a(r rVar);

        void a(AdError adError);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f40334a;

        /* renamed from: b, reason: collision with root package name */
        public String f40335b;

        /* renamed from: c, reason: collision with root package name */
        public String f40336c;

        /* renamed from: d, reason: collision with root package name */
        public l f40337d;

        /* renamed from: e, reason: collision with root package name */
        public LoadAdParams f40338e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f40339f;

        /* renamed from: g, reason: collision with root package name */
        public int f40340g = -1;

        /* renamed from: h, reason: collision with root package name */
        public ICustomAdDataGenerator f40341h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f40342i;
    }

    public c(String str, String str2, a aVar) {
        b bVar = new b();
        this.f40325f = bVar;
        bVar.f40334a = str;
        bVar.f40335b = str2;
        bVar.f40337d = new l(str2, com.qq.e.comm.plugin.base.ad.b.SPLASH, (com.qq.e.comm.plugin.base.ad.definition.a) null);
        this.f40321b = aVar;
        this.f40325f.f40336c = com.qq.e.comm.plugin.k.a.a(str, str2, ((PublicApi.DeviceInfoApi) PublicApiHelper.getModuleApi(PublicApi.DeviceInfoApi.class)).getDeviceId());
        this.f40322c = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c(int i3) {
        if (i3 == 1) {
            return 5;
        }
        if (i3 == 2) {
            return 1;
        }
        if (i3 == 3) {
            return 3;
        }
        if (i3 == 4) {
            return 2;
        }
        if (i3 == 5) {
            return 6;
        }
        return i3;
    }

    private int e() {
        int integer = GDTADManager.getInstance().getSM().getInteger(Constants.KEYS.SPLASH_LOADTIMEOUT, 3000);
        GDTLogger.d("init global timer with fetching delay " + integer);
        long currentTimeMillis = System.currentTimeMillis();
        int i3 = integer - ((int) (currentTimeMillis - this.f40326g));
        int integer2 = GDTADManager.getInstance().getSM().getInteger("fetch_ad_after_time", 0);
        int i16 = i3 - integer2;
        GDTLogger.d("init global timer with real fetching delay:" + i16 + ":" + currentTimeMillis + ":" + this.f40326g + ":" + integer2);
        int integer3 = GDTADManager.getInstance().getSM().getInteger("splashMinFetchDelay", 100);
        int integer4 = GDTADManager.getInstance().getSM().getInteger("splashMaxFetchDelay", 5000);
        if (i16 < integer3) {
            i16 = integer3;
        } else if (i16 > integer4) {
            i16 = integer4;
        }
        com.qq.e.comm.plugin.tangramsplash.report.c.a(1310401, i16, this.f40325f);
        GDTLogger.d("init global timer with real fetching delay 2:" + i16);
        return i16;
    }

    private boolean f() {
        String str;
        boolean z16;
        b bVar = this.f40325f;
        if (bVar != null) {
            str = bVar.f40335b;
        } else {
            str = null;
        }
        boolean z17 = false;
        if (e.a().a(str, "splashSpaNeedOpt", 0) == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        GDTLogger.d("FusionAd\uff0c\u6253\u5f00\u7ade\u4ef7\u4f18\u5316 \uff1f" + z16);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("FusionAd\uff0c\u6709\u53ef\u64ad\u961f\u5217 \uff1f");
        if (f40320a != null) {
            z17 = true;
        }
        sb5.append(z17);
        GDTLogger.d(sb5.toString());
        return z16;
    }

    private void g() {
        synchronized (g.f39879a) {
            if (f40320a != null) {
                f40320a.clear();
            }
            com.qq.e.comm.plugin.tangramsplash.c.e.a().a(this.f40323d, this.f40325f.f40335b);
        }
    }

    @Override // com.qq.e.comm.plugin.tangramsplash.selector.a.InterfaceC0294a
    public void a(String str, r rVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        boolean z16;
        long currentTimeMillis = System.currentTimeMillis();
        c.a aVar = new c.a(0, 0);
        com.qq.e.comm.plugin.tangramsplash.c.e a16 = com.qq.e.comm.plugin.tangramsplash.c.e.a();
        b bVar = this.f40325f;
        List<r> b16 = a16.b(bVar.f40334a, bVar.f40335b, bVar.f40336c, com.qq.e.comm.plugin.base.ad.b.SPLASH, com.qq.e.comm.plugin.tangramsplash.d.a.a(bVar.f40338e), aVar);
        GDTLogger.d("get local preloaded data cost " + (System.currentTimeMillis() - currentTimeMillis));
        if (com.qq.e.comm.plugin.k.g.b(b16)) {
            com.qq.e.comm.plugin.tangramsplash.report.c.a(1310220, this.f40325f, (r) null, System.currentTimeMillis() - currentTimeMillis, aVar.a(), 5);
            GDTLogger.e("\u672c\u5730\u9884\u52a0\u8f7d\u5e7f\u544a\u6570\u636e\u65e0\u6548");
            return;
        }
        String b17 = com.qq.e.comm.plugin.tangramsplash.d.a.b();
        for (r rVar : b16) {
            ArrayList arrayList = new ArrayList();
            List<u> bs5 = rVar.bs();
            if (bs5 == null || bs5.size() <= 0) {
                z16 = false;
            } else {
                z16 = false;
                for (u uVar : bs5) {
                    if (b17.equals(uVar.a())) {
                        arrayList.add(uVar);
                        z16 = true;
                    }
                }
            }
            if (z16) {
                rVar.f(arrayList);
                f40320a.add(rVar);
            }
        }
        if (com.qq.e.comm.plugin.k.g.b(f40320a)) {
            com.qq.e.comm.plugin.tangramsplash.report.c.a(1310224, this.f40325f.f40335b, (r) null, this.f40323d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final int i3) {
        com.tencent.ams.fusion.service.b b16 = com.tencent.ams.fusion.service.b.b();
        ot.e o16 = b16 != null ? b16.o() : null;
        if (o16 == null) {
            a(-1107, "\u9009\u5355\u5931\u8d25\uff0c\u9009\u5355\u670d\u52a1\u4e3a\u7a7a", i3);
            GDTLogger.d("FusionAd\uff0cservice null");
            return;
        }
        com.qq.e.comm.plugin.tangramsplash.fusionsdkimpl.b.a aVar = new com.qq.e.comm.plugin.tangramsplash.fusionsdkimpl.b.a();
        boolean z16 = false;
        if (this.f40325f != null) {
            aVar.f40021j = com.qq.e.comm.plugin.tangramsplash.d.a.b();
            b bVar = this.f40325f;
            aVar.f40020i = bVar.f40334a;
            String str = bVar.f40335b;
            aVar.f40019h = str;
            int d16 = this.f40323d ? f.d(str) : f.c(str);
            aVar.f40017f = d16;
            if (f()) {
                d16 = 0;
            }
            aVar.f40018g = d16;
            HashMap hashMap = new HashMap();
            hashMap.put("splashPreloadGap", Integer.valueOf(this.f40325f.f40340g));
            hashMap.put("fetch_ad_only", Boolean.valueOf(this.f40325f.f40339f));
            aVar.f40022k = hashMap;
            LoadAdParams loadAdParams = this.f40325f.f40338e;
            if (loadAdParams != null) {
                aVar.f40013b = loadAdParams.getFilterOneShotFlag();
                aVar.f40014c = loadAdParams.isHotLaunchNotShowFirstPlayAd();
                aVar.f40027p = loadAdParams.isCanDownloadSrcInRealtimeSelect();
                aVar.f40025n = loadAdParams;
            }
            this.f40325f.f40342i = !com.qq.e.comm.plugin.tangramsplash.a.c.c();
            aVar.f40028q = f.e(this.f40325f.f40335b);
        }
        aVar.f40012a = this.f40323d;
        aVar.f40016e = e();
        aVar.f40023l = this.f40326g;
        aVar.f40024m = GDTADManager.getInstance().getSM().getInteger(Constants.KEYS.SPLASH_LOADTIMEOUT, 3000);
        b bVar2 = this.f40325f;
        if (bVar2 != null && bVar2.f40342i) {
            z16 = true;
        }
        aVar.f40015d = z16;
        aVar.f40026o = true;
        com.qq.e.comm.plugin.tangramsplash.fusionsdkimpl.c.c c16 = d.a().c();
        if (c16 != null) {
            c16.a(GlobalSetting.getiCustomAdDataGenerator());
        }
        GDTLogger.i("FusionAd\uff0cselect with request :" + aVar.toString());
        o16.c(aVar, new ot.a() { // from class: com.qq.e.comm.plugin.tangramsplash.selector.c.2
            @Override // ot.a
            public void a(pt.a aVar2) {
                if (aVar2 == null) {
                    return;
                }
                GDTLogger.d("FusionAd\uff0conSelectTaskStart :" + aVar2.d());
            }

            @Override // ot.a
            public void b(pt.a aVar2) {
                if (aVar2 == null) {
                    return;
                }
                GDTLogger.d("FusionAd\uff0conSelectTaskFinish :" + aVar2.d());
            }

            @Override // ot.a
            public void c(pt.a aVar2) {
                if (aVar2 == null) {
                    return;
                }
                GDTLogger.d("FusionAd\uff0conSelectTaskSuccess :" + aVar2.d());
            }

            @Override // ot.a
            public void d(pt.a aVar2) {
                if (aVar2 == null) {
                    return;
                }
                GDTLogger.d("FusionAd\uff0conSelectTaskFailure :" + aVar2.d() + " error :" + aVar2.e());
            }

            @Override // ot.a
            public void a(ot.d dVar) {
                if (dVar != null && dVar.d() != -1) {
                    GDTLogger.i("FusionAd\uff0conSelectFinish type :" + dVar.d() + ", cost time " + dVar.c());
                    List<SplashOrder> a16 = dVar.a();
                    if (com.qq.e.comm.plugin.k.g.b(a16)) {
                        c.this.a(-1003, "\u9009\u5355\u5b8c\u6210\uff0c\u65e0\u9009\u5355\u7ed3\u679c", i3);
                        return;
                    }
                    SplashOrder splashOrder = a16.get(0);
                    r rVar = splashOrder instanceof r ? (r) splashOrder : null;
                    if (rVar != null) {
                        com.qq.e.comm.plugin.tangramsplash.report.c.a(1310530, rVar.s(), rVar, dVar.d());
                        GDTLogger.i("FusionAd\uff0cselect succ :" + rVar.f());
                        c cVar = c.this;
                        cVar.a(cVar.c(dVar.d()), rVar, i3);
                        return;
                    }
                    if (dVar instanceof com.tencent.ams.fusion.service.splash.c.a.a.c.b.a) {
                        c.this.a(((com.tencent.ams.fusion.service.splash.c.a.a.c.b.a) dVar).l(), "\u9009\u5355\u5185\u90e8\u9519\u8bef", i3);
                        return;
                    } else {
                        c.this.a(-1105, "\u9009\u5355\u6210\u529f\uff0c\u7ed3\u679c\u7c7b\u578b\u9519\u8bef", i3);
                        return;
                    }
                }
                c.this.a(-1106, "\u9009\u5355\u6210\u529f\uff0c\u672a\u8bc6\u522b\u7684\u9009\u5355\u6765\u6e90\u7c7b\u578b", i3);
            }
        });
    }

    private boolean c(r rVar) {
        Bitmap bitmap;
        File file;
        if (rVar == null) {
            GDTLogger.e("preDecodeImgSplashBitmap fail adInfo null");
            a(new AdError(-1109, "\u89e3\u7801\u56fe\u7247\u5931\u8d25\uff0c\u5e7f\u544a\u6570\u636e\u4e3a\u7a7a"));
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (rVar.aH()) {
            bitmap = rVar.bL().d();
            if (bitmap != null) {
                file = null;
            } else {
                file = rVar.bL().a(rVar.s());
                bitmap = null;
            }
        } else {
            if (rVar.w() == 0) {
                file = at.a(1, rVar.s(), rVar.h());
            } else if (rVar.w() == 1) {
                file = at.a(1, rVar.s(), rVar.ag());
            } else {
                bitmap = null;
                file = null;
            }
            bitmap = null;
        }
        if (bitmap == null && file != null && file.exists()) {
            bitmap = h.a(file, (ImageView) null);
        }
        Bitmap bitmap2 = bitmap;
        a aVar = this.f40321b;
        if (aVar != null) {
            aVar.a(bitmap2);
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        long currentTimeMillis3 = System.currentTimeMillis() - this.f40326g;
        GDTLogger.i("preDecodeImgSplashBitmap decodeCostTime:" + currentTimeMillis2 + " allStepCostTime :" + currentTimeMillis3 + " mainBitmap :" + bitmap2);
        com.qq.e.comm.plugin.tangramsplash.report.c.a(1310520, rVar, bitmap2 != null ? 1 : 0, currentTimeMillis3, currentTimeMillis2);
        return bitmap2 != null;
    }

    public void a(boolean z16, final int i3) {
        b bVar = this.f40325f;
        this.f40324e = z16;
        bVar.f40339f = z16;
        this.f40322c = 2;
        boolean a16 = com.qq.e.comm.plugin.tangramsplash.d.a.a(this.f40325f.f40338e);
        this.f40323d = a16;
        b bVar2 = this.f40325f;
        bVar2.f40340g = (int) com.qq.e.comm.plugin.tangramsplash.d.a.a(at.b(bVar2.f40335b, a16));
        GDTLogger.d("preloadGap = " + this.f40325f.f40340g);
        this.f40326g = GDTADManager.getInstance().getSM().getLong(Constants.KEYS.FETCH_AD_START_TIME, System.currentTimeMillis());
        this.f40328i = new AtomicInteger(0);
        b bVar3 = this.f40325f;
        com.qq.e.comm.plugin.tangramsplash.report.c.a(1310201, bVar3, z16, this.f40323d, bVar3.f40340g, i3);
        GdtSDKThreadManager.getInstance().runOnThread(3, new Runnable() { // from class: com.qq.e.comm.plugin.tangramsplash.selector.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (i3 == 5) {
                    try {
                        c.this.d();
                        c.this.b(i3);
                        return;
                    } catch (Throwable th5) {
                        GDTLogger.e("set up realtime select catch error:", th5);
                        return;
                    }
                }
                List<r> b16 = com.qq.e.comm.plugin.tangramsplash.c.e.a().b(c.this.f40325f.f40334a, c.this.f40325f.f40335b, c.this.f40325f.f40336c, com.qq.e.comm.plugin.base.ad.b.SPLASH, com.qq.e.comm.plugin.tangramsplash.d.a.a(c.this.f40325f.f40338e), new c.a(0, 0));
                if (c.this.f40329j == null) {
                    c.this.f40329j = new com.qq.e.comm.plugin.tangramsplash.selector.a(c.this.f40325f, c.this.f40323d, c.this);
                }
                c.this.f40329j.a(b16, i3);
            }
        });
    }

    @Deprecated
    public com.qq.e.tg.splash.SplashOrder a(String str) {
        if (TextUtils.isEmpty(str)) {
            GDTLogger.e("FusionAd\uff0c[getResultBeforeSelectFinish] : null posId.");
            return null;
        }
        synchronized (this.f40327h) {
            if (!this.f40327h.containsKey(str)) {
                return null;
            }
            List<pt.a> list = this.f40327h.get(str);
            if (com.qq.e.comm.plugin.k.g.b(list)) {
                return null;
            }
            Object[] objArr = new Object[4];
            for (pt.a aVar : list) {
                if (aVar != null) {
                    pt.c b16 = aVar.b();
                    if (b16 != null && b16.a() != null && b16.a().a() != null) {
                        List<SplashOrder> a16 = b16.a().a();
                        int d16 = aVar.d();
                        GDTLogger.i("FusionAd\uff0c[getResultBeforeSelectFinish] SelectOrderType : " + d16 + " response :" + b16.a().a());
                        if (d16 == 1) {
                            objArr[0] = a16;
                            GDTLogger.i("FusionAd\uff0c[getResultBeforeSelectFinish] : preViewTask hit :" + objArr[0]);
                        } else if (d16 == 2) {
                            objArr[1] = a16;
                            GDTLogger.i("FusionAd\uff0c[getResultBeforeSelectFinish] : firstPlayTask hit :" + objArr[1]);
                        } else if (d16 == 3) {
                            objArr[2] = a16;
                            GDTLogger.i("FusionAd\uff0c[getResultBeforeSelectFinish] : realTimeTask hit :" + objArr[2]);
                        } else if (d16 == 4) {
                            objArr[3] = a16;
                            GDTLogger.i("FusionAd\uff0c[getResultBeforeSelectFinish] : localTask hit :" + objArr[3]);
                        }
                    }
                    GDTLogger.e("FusionAd\uff0c[getResultBeforeSelectFinish] no response : " + aVar.d());
                }
            }
            return a(objArr);
        }
    }

    public b c() {
        return this.f40325f;
    }

    private void b(int i3, String str, int i16) {
        AdError adError = new AdError(i3, str);
        GDTLogger.e(str);
        if (i16 == 5) {
            a(adError);
        }
        long currentTimeMillis = System.currentTimeMillis();
        g();
        com.qq.e.comm.plugin.tangramsplash.report.c.a(1310500, this.f40325f, (r) null, System.currentTimeMillis() - currentTimeMillis, i3, i16);
    }

    private com.qq.e.tg.splash.SplashOrder a(Object... objArr) {
        if (com.qq.e.comm.plugin.k.g.a(objArr)) {
            com.qq.e.tg.splash.SplashOrder splashOrder = new com.qq.e.tg.splash.SplashOrder(GDTADManager.getInstance().getAppContext(), GDTADManager.getInstance().getAppStatus().getAPPID());
            int length = objArr.length;
            boolean z16 = false;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                Object obj = objArr[i3];
                if (obj instanceof r) {
                    r rVar = (r) obj;
                    if (!rVar.bk()) {
                        splashOrder.cacheResult(obj);
                        com.qq.e.comm.plugin.tangramsplash.a.a().a(rVar);
                        a(7);
                        z16 = true;
                        break;
                    }
                }
                GDTLogger.i("[checkSelectResult] order null or empty");
                i3++;
            }
            if (z16) {
                return splashOrder;
            }
        }
        return null;
    }

    public void b() {
        this.f40327h.clear();
    }

    private void b(r rVar) {
        AtomicInteger atomicInteger;
        if (c(rVar)) {
            a aVar = this.f40321b;
            if (aVar == null || (atomicInteger = this.f40328i) == null || !atomicInteger.compareAndSet(0, 1)) {
                return;
            }
            aVar.a(rVar);
            return;
        }
        GDTLogger.e("splash bitmap decode fail.");
    }

    public void a(LoadAdParams loadAdParams) {
        this.f40325f.f40338e = loadAdParams;
    }

    private void a(r rVar, int i3, int i16) {
        if (com.qq.e.comm.plugin.tangramsplash.d.a.a(this.f40325f.f40338e)) {
            f.b(this.f40325f.f40335b);
            rVar.A(0);
        } else {
            f.a(this.f40325f.f40335b);
        }
        if (i3 == 4 && com.qq.e.comm.plugin.j.c.a("makeEmptyOrderCallbackFail", 0, 1)) {
            b(-1009, "\u9009\u5355\u7ed3\u679c\u662f\u4f2a\u9020\u7a7a\u5355", i16);
        }
        if (i3 != 4) {
            com.qq.e.comm.plugin.tangramsplash.report.c.a(1310498, this.f40325f, rVar, System.currentTimeMillis() - this.f40326g, i3, i16);
            b(-1004, "\u9009\u5355\u7ed3\u679c\u662f\u7a7a\u5355", i16);
            if (!f.a(GDTADManager.getInstance().getAppContext())) {
                com.qq.e.comm.plugin.tangramsplash.a.c.a(rVar, com.qq.e.comm.plugin.tangramsplash.d.a.a(this.f40325f.f40338e));
            } else {
                af.b(com.qq.e.comm.plugin.k.b.d(rVar.j()));
            }
        }
        if (i16 == 5) {
            a(true, 2);
        }
    }

    public void a(int i3, String str, int i16) {
        long currentTimeMillis = System.currentTimeMillis() - this.f40326g;
        GDTLogger.d("onSelectedFail time cost: " + currentTimeMillis);
        com.qq.e.comm.plugin.tangramsplash.report.c.a(1310497, this.f40325f, (r) null, currentTimeMillis, i3, i16);
        b(i3, str, i16);
    }

    public void a(int i3) {
        GDTLogger.d("modifyState cur state is " + this.f40322c + ";will change to " + i3);
        this.f40322c = i3;
    }

    private void a(r rVar) {
        boolean z16;
        boolean z17 = false;
        if (com.qq.e.comm.plugin.tangramsplash.b.c.g(rVar)) {
            z16 = true;
        } else {
            GDTLogger.d("checkOneshotFocusSrc fail");
            z16 = false;
        }
        if (com.qq.e.comm.plugin.tangramsplash.b.c.h(rVar)) {
            z17 = true;
        } else {
            GDTLogger.d("checkOneShotTransparentVideoSrc fail");
        }
        int i3 = (z16 && z17) ? 1 : (z16 || !z17) ? z16 ? 3 : 4 : 2;
        boolean c16 = com.qq.e.comm.plugin.j.c.c();
        boolean d16 = com.qq.e.comm.plugin.j.c.d();
        SplashLinkReporter.a(rVar, 7000033, (c16 || d16) ? (!c16 || d16) ? !c16 ? 3 : 4 : 2 : 1, i3);
    }

    public int a() {
        return this.f40322c;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i3, r rVar, int i16) {
        int i17;
        int i18;
        if (rVar == null) {
            a(-1003, "\u9009\u5355\u6210\u529f\uff0c\u672a\u77e5\u9519\u8bef", i16);
            return;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                i17 = 3;
                if (i3 == 3) {
                    i18 = 2;
                } else if (i3 != 5) {
                    if (i3 != 6) {
                        i17 = Integer.MAX_VALUE;
                    } else {
                        i18 = 4;
                    }
                }
            } else {
                i18 = 1;
            }
            if (i18 != 2) {
                af.c(this.f40325f.f40335b);
            }
            if (!rVar.bk()) {
                a(rVar, i18, i16);
                return;
            }
            com.qq.e.comm.plugin.tangramsplash.a.a().a(rVar);
            a(this.f40324e ? 4 : 5);
            if (i16 == 5) {
                rVar.j(true);
                if (!a(rVar, i16)) {
                    return;
                } else {
                    b(rVar);
                }
            }
            if (rVar.bi() || rVar.bj()) {
                a(rVar);
            }
            g();
            long currentTimeMillis = System.currentTimeMillis() - this.f40326g;
            GDTLogger.d("onSelectedSuccess time cost: " + currentTimeMillis);
            com.qq.e.comm.plugin.tangramsplash.report.c.a(1310496, this.f40325f, rVar, currentTimeMillis, i18, i16);
            return;
        }
        i17 = 0;
        i18 = i17;
        if (i18 != 2) {
        }
        if (!rVar.bk()) {
        }
    }

    @Override // com.qq.e.comm.plugin.tangramsplash.selector.a.InterfaceC0294a
    public void a(String str, int i3, int i16) {
        a(i3, "\u9884\u9009\u5355\u5931\u8d25", i16);
    }

    private boolean a(r rVar, int i3) {
        if (rVar == null || !rVar.aH()) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        int aK = rVar.aK();
        com.qq.e.comm.plugin.tangramsplash.report.c.a(1310290, rVar, aK, System.currentTimeMillis() - currentTimeMillis, System.currentTimeMillis() - this.f40326g);
        if (aK == 0) {
            return true;
        }
        b(-1108, "\u7d20\u6750\u89e3\u5bc6\u5931\u8d25\u65e0\u6cd5\u5c55\u793a", i3);
        return false;
    }

    private void a(AdError adError) {
        AtomicInteger atomicInteger;
        a aVar = this.f40321b;
        if (aVar == null || (atomicInteger = this.f40328i) == null || !atomicInteger.compareAndSet(0, 1)) {
            return;
        }
        aVar.a(adError);
    }
}
