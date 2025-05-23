package com.qq.e.comm.plugin.base.ad.model;

import android.graphics.Point;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.plugin.base.ad.model.ExtraCreativeElement;
import com.qq.e.comm.plugin.base.ad.model.InteractiveInfo;
import com.qq.e.comm.plugin.k.ae;
import com.qq.e.comm.plugin.k.w;
import com.qq.e.comm.plugin.k.y;
import com.qq.e.comm.plugin.router.PublicApi;
import com.qq.e.comm.plugin.router.PublicApiHelper;
import com.qq.e.comm.plugin.stat.StatTracer;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.ams.fusion.service.splash.model.SplashOrder;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class r extends f implements SplashOrder {
    private String O;
    private boolean P;
    private int Q;
    private int R;
    private int S;
    private boolean T;
    private boolean U;
    private String V;
    private int W;
    private boolean X;
    private int Y;
    private String Z;
    private String aA;
    private String[] aB;
    private boolean aC;
    private boolean aD;
    private int aE;
    private int aF;
    private int aG;
    private HashMap<Integer, v> aH;
    private boolean aI;
    private boolean aJ;
    private boolean aK;
    private boolean aL;
    private JSONObject aM;
    private j aN;
    private int aO;
    private int aP;
    private int aQ;
    private int aR;
    private int aS;
    private boolean aT;
    private boolean aU;
    private int aV;
    private int aW;
    private boolean aX;
    private k aY;
    private int aZ;

    /* renamed from: aa, reason: collision with root package name */
    private List<u> f39096aa;

    /* renamed from: ab, reason: collision with root package name */
    private Map<String, List<u>> f39097ab;

    /* renamed from: ac, reason: collision with root package name */
    private String f39098ac;

    /* renamed from: ad, reason: collision with root package name */
    private String f39099ad;

    /* renamed from: ae, reason: collision with root package name */
    private String f39100ae;

    /* renamed from: af, reason: collision with root package name */
    private String f39101af;

    /* renamed from: ag, reason: collision with root package name */
    private int f39102ag;

    /* renamed from: ah, reason: collision with root package name */
    private r f39103ah;

    /* renamed from: ai, reason: collision with root package name */
    private boolean f39104ai;

    /* renamed from: aj, reason: collision with root package name */
    private boolean f39105aj;

    /* renamed from: ak, reason: collision with root package name */
    private long f39106ak;

    /* renamed from: al, reason: collision with root package name */
    private int f39107al;

    /* renamed from: am, reason: collision with root package name */
    private int f39108am;

    /* renamed from: an, reason: collision with root package name */
    private int f39109an;

    /* renamed from: ao, reason: collision with root package name */
    private int f39110ao;

    /* renamed from: ap, reason: collision with root package name */
    private int f39111ap;

    /* renamed from: aq, reason: collision with root package name */
    private int f39112aq;

    /* renamed from: ar, reason: collision with root package name */
    private int f39113ar;

    /* renamed from: as, reason: collision with root package name */
    private int f39114as;

    /* renamed from: at, reason: collision with root package name */
    private InteractiveInfo f39115at;

    /* renamed from: au, reason: collision with root package name */
    private int f39116au;

    /* renamed from: av, reason: collision with root package name */
    private int f39117av;

    /* renamed from: aw, reason: collision with root package name */
    private String f39118aw;

    /* renamed from: ax, reason: collision with root package name */
    private int f39119ax;

    /* renamed from: ay, reason: collision with root package name */
    private int f39120ay;

    /* renamed from: az, reason: collision with root package name */
    private List<a> f39121az;

    /* renamed from: ba, reason: collision with root package name */
    private ExtraCreativeElement f39122ba;

    /* renamed from: bb, reason: collision with root package name */
    private int f39123bb;

    /* renamed from: bc, reason: collision with root package name */
    private int f39124bc;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f39125a;

        /* renamed from: b, reason: collision with root package name */
        public List<Point> f39126b;

        /* renamed from: c, reason: collision with root package name */
        public String f39127c;

        /* renamed from: d, reason: collision with root package name */
        public String f39128d;

        /* renamed from: e, reason: collision with root package name */
        public String f39129e;

        /* renamed from: f, reason: collision with root package name */
        public String f39130f;

        /* renamed from: g, reason: collision with root package name */
        public String f39131g;

        /* renamed from: h, reason: collision with root package name */
        public List<s> f39132h;

        /* renamed from: i, reason: collision with root package name */
        public List<s> f39133i;

        /* renamed from: j, reason: collision with root package name */
        public List<String> f39134j;

        /* renamed from: k, reason: collision with root package name */
        public List<String> f39135k;
    }

    public r(String str, String str2, String str3, com.qq.e.comm.plugin.base.ad.b bVar) {
        super(str, str2, str3, bVar);
        this.f39106ak = -1L;
        this.f39107al = 0;
        this.f39108am = 0;
        this.f39109an = 0;
        this.f39110ao = 0;
        this.f39111ap = 0;
        this.f39112aq = 0;
        this.f39113ar = 0;
        this.f39114as = 0;
        this.aD = false;
        this.aE = 0;
        this.aF = 0;
        this.aG = 0;
        this.aV = 1;
        this.aW = 0;
        this.aX = false;
        this.aY = null;
        this.f39123bb = 0;
        this.f39124bc = 0;
    }

    private void I(int i3) {
        this.aZ = i3;
    }

    private void b(List<com.tencent.ams.fusion.service.splash.b.a.a> list, boolean z16) {
        ExtraCreativeElement.a b16;
        String a16;
        ExtraCreativeElement bL = bL();
        if (bL == null) {
            return;
        }
        List<ExtraCreativeElement.b> b17 = bL.b();
        if (com.qq.e.comm.plugin.k.g.a(b17)) {
            for (int i3 = 0; i3 < b17.size(); i3++) {
                ExtraCreativeElement.b bVar = b17.get(i3);
                if (bVar != null && (b16 = bVar.b()) != null) {
                    if (z16) {
                        a16 = b16.b(bL.a());
                    } else {
                        a16 = b16.a(bL.a());
                    }
                    com.qq.e.comm.plugin.k.g.a(list, new com.tencent.ams.fusion.service.splash.b.a.a(a16, null, 2));
                }
            }
        }
    }

    private void c(r rVar) {
        if (rVar != null && y.a(rVar.G)) {
            ExtraCreativeElement bL = rVar.bL();
            ExtraCreativeElement bL2 = bL();
            if (bL2 != null && bL != null) {
                if (bL.c() != null && bL2.c() != null && !TextUtils.isEmpty(bL.c().b())) {
                    bL2.c().a(bL.c().b());
                }
                List<ExtraCreativeElement.b> b16 = bL.b();
                List<ExtraCreativeElement.b> b17 = bL2.b();
                if (com.qq.e.comm.plugin.k.g.a(b16) && com.qq.e.comm.plugin.k.g.a(b17)) {
                    for (int i3 = 0; i3 < b17.size(); i3++) {
                        ExtraCreativeElement.b bVar = b17.get(i3);
                        if (bVar != null) {
                            if (bVar.a() != null && i3 < b16.size() && b16.get(i3) != null && b16.get(i3).a() != null && !TextUtils.isEmpty(b16.get(i3).a().b())) {
                                bVar.a().a(b16.get(i3).a().b());
                            }
                            if (bVar.b() != null && i3 < b16.size() && b16.get(i3) != null && b16.get(i3).b() != null && !TextUtils.isEmpty(b16.get(i3).b().b())) {
                                bVar.b().a(b16.get(i3).b().b());
                            }
                        }
                    }
                }
            }
        }
    }

    private List<com.tencent.ams.fusion.service.splash.b.a.a> cj() {
        List<com.tencent.ams.fusion.service.splash.b.a.a> a16 = com.qq.e.comm.plugin.k.g.a(null, new com.tencent.ams.fusion.service.splash.b.a.a(h(), null, 1));
        com.qq.e.comm.plugin.k.g.a(a16, new com.tencent.ams.fusion.service.splash.b.a.a(ag(), null, 1));
        if (bI() != null) {
            for (a aVar : bI()) {
                if (aVar != null) {
                    com.qq.e.comm.plugin.k.g.a(a16, new com.tencent.ams.fusion.service.splash.b.a.a(aVar.f39127c, null, 1));
                }
            }
        }
        if (bJ() != null && bJ().v() != null) {
            com.qq.e.comm.plugin.k.g.a(a16, new com.tencent.ams.fusion.service.splash.b.a.a(bJ().v(), null, 1));
        }
        if (bJ() != null && bJ().f() != null) {
            com.qq.e.comm.plugin.k.g.a(a16, new com.tencent.ams.fusion.service.splash.b.a.a(bJ().f().f38888i, null, 1));
            com.qq.e.comm.plugin.k.g.a(a16, new com.tencent.ams.fusion.service.splash.b.a.a(bJ().f().f38880a, null, 1));
        }
        if (bK() != null) {
            com.qq.e.comm.plugin.k.g.a(a16, new com.tencent.ams.fusion.service.splash.b.a.a(bK().f(), null, 1));
            com.qq.e.comm.plugin.k.g.a(a16, new com.tencent.ams.fusion.service.splash.b.a.a(bK().g(), null, 1));
        }
        h(a16);
        return a16;
    }

    private List<com.tencent.ams.fusion.service.splash.b.a.a> ck() {
        List<com.tencent.ams.fusion.service.splash.b.a.a> a16 = com.qq.e.comm.plugin.k.g.a(null, new com.tencent.ams.fusion.service.splash.b.a.a(x(), bt(), 2));
        if (bI() != null) {
            for (a aVar : bI()) {
                if (aVar != null) {
                    com.qq.e.comm.plugin.k.g.a(a16, new com.tencent.ams.fusion.service.splash.b.a.a(aVar.f39128d, null, 2));
                }
            }
        }
        return a16;
    }

    private int cl() {
        int i3 = this.R;
        if (i3 > 0) {
            if (i3 != 40 || this.Q != 0) {
                return Math.max(i3 - this.Q, 0);
            }
            return Integer.MIN_VALUE;
        }
        return Integer.MIN_VALUE;
    }

    private void h(List<com.tencent.ams.fusion.service.splash.b.a.a> list) {
        if (list == null) {
            return;
        }
        InteractiveInfo interactiveInfo = this.f39115at;
        if (interactiveInfo != null && !TextUtils.isEmpty(interactiveInfo.K())) {
            com.qq.e.comm.plugin.k.g.a(list, new com.tencent.ams.fusion.service.splash.b.a.a(this.f39115at.K(), null, 3));
        }
        InteractiveInfo interactiveInfo2 = this.f39115at;
        if (interactiveInfo2 == null || TextUtils.isEmpty(interactiveInfo2.L())) {
            return;
        }
        com.qq.e.comm.plugin.k.g.a(list, new com.tencent.ams.fusion.service.splash.b.a.a(this.f39115at.L(), null, 1));
    }

    private void l(JSONObject jSONObject) {
        if (y.a(jSONObject)) {
            j jVar = new j();
            this.aN = jVar;
            jVar.a(y.e(jSONObject, "module_id"));
            this.aN.b(y.e(jSONObject, "template_id"));
        }
    }

    private void m(JSONObject jSONObject) {
        if (y.a(jSONObject)) {
            this.aO = jSONObject.optInt("title");
            this.aP = jSONObject.optInt("description");
            this.aQ = jSONObject.optInt("ad_icon");
            this.aR = jSONObject.optInt("skip_btn");
        }
    }

    public void A(int i3) {
        List<u> bs5 = bs();
        String str = null;
        if (bs5 != null && bs5.size() > 0) {
            Iterator<u> it = bs5.iterator();
            while (it.hasNext()) {
                str = it.next().a(Integer.valueOf(i3));
                if (!TextUtils.isEmpty(str)) {
                    break;
                }
            }
        }
        if (!TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(this.f39011f)) {
                this.f39011f = this.f39011f.replace("__SERVER_DATA__", str);
            }
            List<s> C = C();
            if (C != null && C.size() > 0) {
                for (s sVar : C) {
                    if (sVar != null) {
                        String a16 = sVar.a();
                        if (!TextUtils.isEmpty(a16)) {
                            sVar.a(a16.replace("__SERVER_DATA__", str));
                        }
                    }
                }
            }
            List<s> D = D();
            if (D != null && D.size() > 0) {
                for (s sVar2 : D) {
                    if (sVar2 != null) {
                        String a17 = sVar2.a();
                        if (!TextUtils.isEmpty(a17)) {
                            sVar2.a(a17.replace("__SERVER_DATA__", str));
                        }
                    }
                }
            }
            if (!TextUtils.isEmpty(this.f39015j)) {
                this.f39015j = this.f39015j.replace("__SERVER_DATA__", str);
            }
            List<String> E = E();
            if (E != null && E.size() > 0) {
                ArrayList arrayList = new ArrayList();
                Iterator<String> it5 = E.iterator();
                while (it5.hasNext()) {
                    arrayList.add(it5.next().replace("__SERVER_DATA__", str));
                }
            }
            List<String> F = F();
            if (F != null && F.size() > 0) {
                ArrayList arrayList2 = new ArrayList();
                Iterator<String> it6 = F.iterator();
                while (it6.hasNext()) {
                    arrayList2.add(it6.next().replace("__SERVER_DATA__", str));
                }
                return;
            }
            return;
        }
        com.qq.e.comm.plugin.stat.c cVar = new com.qq.e.comm.plugin.stat.c();
        cVar.a("pID", this.B);
        cVar.a("uoID", this.V);
        cVar.a("aID", this.f38980a);
        StatTracer.trackEvent(10192, 0, new com.qq.e.comm.plugin.stat.b().a(this.B).b(this.f38980a).c(this.f39021p), cVar);
    }

    public void B(int i3) {
        this.f39112aq = i3;
    }

    public void C(int i3) {
        this.f39113ar = i3;
    }

    public void D(int i3) {
        this.f39114as = i3;
    }

    public void E(String str) {
        this.O = str;
    }

    @Override // com.tencent.ams.fusion.service.splash.model.SplashOrder
    public List<Pair<Integer, Integer>> F(String str) {
        List<Point> d16;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        List<u> bs5 = bs();
        if (com.qq.e.comm.plugin.k.g.b(bs5)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (u uVar : bs5) {
            if (uVar != null && str.equals(uVar.a()) && (d16 = uVar.d()) != null && d16.size() != 0) {
                for (Point point : d16) {
                    if (point != null) {
                        arrayList.add(new Pair(Integer.valueOf(point.x), Integer.valueOf(point.y)));
                    }
                }
            }
        }
        return arrayList;
    }

    @Override // com.tencent.ams.fusion.service.splash.model.SplashOrder
    public int G(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        List<u> bs5 = bs();
        if (com.qq.e.comm.plugin.k.g.b(bs5)) {
            return 0;
        }
        for (u uVar : bs5) {
            if (uVar != null && str.equals(uVar.a())) {
                return uVar.b();
            }
        }
        return 0;
    }

    public void H(String str) {
        this.V = str;
    }

    public void J(String str) {
        this.f39098ac = str;
    }

    public void K(String str) {
        this.f39099ad = str;
    }

    public void L(String str) {
        this.f39100ae = str;
    }

    public void M(String str) {
        this.f39101af = str;
    }

    public void N(String str) {
        this.f39118aw = str;
    }

    public void O(String str) {
        this.aA = str;
    }

    @Override // com.tencent.ams.fusion.service.splash.model.SplashOrder
    public SplashOrder a(SplashOrder splashOrder) {
        return splashOrder;
    }

    @Override // com.tencent.ams.fusion.service.splash.model.SplashOrder
    public boolean aA() {
        return ((PublicApi.SplashApi) PublicApiHelper.getModuleApi(PublicApi.SplashApi.class)).checkPreloadSplashMaterial(this);
    }

    @Override // com.tencent.ams.fusion.service.splash.model.SplashOrder
    public String aB() {
        if (aH() && bL().c() != null) {
            return bL().c().b();
        }
        return h();
    }

    @Override // com.tencent.ams.fusion.service.splash.model.SplashOrder
    public String aC() {
        return x();
    }

    @Override // com.tencent.ams.fusion.service.splash.model.SplashOrder
    public List<com.tencent.ams.fusion.service.splash.b.a.a> aD() {
        List<com.tencent.ams.fusion.service.splash.b.a.a> cj5 = cj();
        a(cj5, false);
        return cj5;
    }

    @Override // com.tencent.ams.fusion.service.splash.model.SplashOrder
    public List<com.tencent.ams.fusion.service.splash.b.a.a> aE() {
        List<com.tencent.ams.fusion.service.splash.b.a.a> cj5 = cj();
        if (com.qq.e.comm.plugin.j.c.a("openOlympicSrcDownloadInRealtime", 1, 1)) {
            a(cj5, true);
        }
        return cj5;
    }

    @Override // com.tencent.ams.fusion.service.splash.model.SplashOrder
    public List<com.tencent.ams.fusion.service.splash.b.a.a> aF() {
        List<com.tencent.ams.fusion.service.splash.b.a.a> ck5 = ck();
        b(ck5, false);
        return ck5;
    }

    @Override // com.tencent.ams.fusion.service.splash.model.SplashOrder
    public List<com.tencent.ams.fusion.service.splash.b.a.a> aG() {
        List<com.tencent.ams.fusion.service.splash.b.a.a> ck5 = ck();
        if (com.qq.e.comm.plugin.j.c.a("openOlympicSrcDownloadInRealtime", 1, 1)) {
            b(ck5, true);
        }
        return ck5;
    }

    public boolean aH() {
        String bP = bP();
        if (("SlideVerticalCarouselCard".equals(bP) || "TwistVerticalCarouselCard".equals(bP)) && bL() != null) {
            return true;
        }
        return false;
    }

    public boolean aI() {
        return "AuraIconFlipInteractive".equals(bP());
    }

    public boolean aJ() {
        return "AuraIconTwistInteractive".equals(bP());
    }

    public int aK() {
        ExtraCreativeElement bL = bL();
        if (bL == null) {
            return -1;
        }
        return bL.c(s());
    }

    @Override // com.tencent.ams.fusion.service.splash.model.SplashOrder
    public List<com.tencent.ams.fusion.service.splash.b.a.a> aL() {
        com.tencent.ams.fusion.service.splash.b.a.a aVar;
        com.tencent.ams.fusion.service.splash.b.a.a aVar2;
        com.tencent.ams.fusion.service.splash.b.a.a aVar3;
        com.tencent.ams.fusion.service.splash.b.a.a aVar4;
        ArrayList arrayList = new ArrayList();
        com.tencent.ams.fusion.service.splash.b.a.a aVar5 = null;
        if (H(1) != null) {
            aVar = new com.tencent.ams.fusion.service.splash.b.a.a(H(1).b(), null, 1);
        } else {
            aVar = null;
        }
        com.qq.e.comm.plugin.k.g.a(arrayList, aVar);
        if (H(3) != null) {
            aVar2 = new com.tencent.ams.fusion.service.splash.b.a.a(H(3).b(), null, 1);
        } else {
            aVar2 = null;
        }
        com.qq.e.comm.plugin.k.g.a(arrayList, aVar2);
        if (H(2) != null) {
            aVar3 = new com.tencent.ams.fusion.service.splash.b.a.a(H(2).b(), null, 1);
        } else {
            aVar3 = null;
        }
        com.qq.e.comm.plugin.k.g.a(arrayList, aVar3);
        if (H(4) != null) {
            aVar4 = new com.tencent.ams.fusion.service.splash.b.a.a(H(4).b(), null, 1);
        } else {
            aVar4 = null;
        }
        com.qq.e.comm.plugin.k.g.a(arrayList, aVar4);
        if (H(5) != null) {
            aVar5 = new com.tencent.ams.fusion.service.splash.b.a.a(H(5).b(), null, 1);
        }
        com.qq.e.comm.plugin.k.g.a(arrayList, aVar5);
        return arrayList;
    }

    @Override // com.tencent.ams.fusion.service.splash.model.SplashOrder
    public List<com.tencent.ams.fusion.service.splash.b.a.a> aM() {
        return com.qq.e.comm.plugin.k.g.a(null, new com.tencent.ams.fusion.service.splash.b.a.a(i(), null, 1));
    }

    @Override // com.tencent.ams.fusion.service.splash.model.SplashOrder
    public List<com.tencent.ams.fusion.service.splash.b.a.a> aN() {
        com.tencent.ams.fusion.service.splash.b.a.a aVar;
        if (!by() && bx() == null && K() == 32) {
            aVar = new com.tencent.ams.fusion.service.splash.b.a.a(bE(), null, 2);
        } else {
            aVar = null;
        }
        return com.qq.e.comm.plugin.k.g.a(null, aVar);
    }

    @Override // com.tencent.ams.fusion.service.splash.model.SplashOrder
    public List<com.tencent.ams.fusion.service.splash.b.a.a> aO() {
        InteractiveInfo.a aVar;
        String str;
        if (bJ() != null) {
            aVar = bJ().f();
        } else {
            aVar = null;
        }
        if (aVar != null) {
            str = aVar.b();
        } else {
            str = null;
        }
        return com.qq.e.comm.plugin.k.g.a(null, new com.tencent.ams.fusion.service.splash.b.a.a(str, null, 2));
    }

    @Override // com.tencent.ams.fusion.service.splash.model.SplashOrder
    public List<com.tencent.ams.fusion.service.splash.b.a.a> aP() {
        InteractiveInfo.a aVar;
        String str;
        if (bJ() != null) {
            aVar = bJ().f();
        } else {
            aVar = null;
        }
        if (aVar != null) {
            str = aVar.c();
        } else {
            str = null;
        }
        return com.qq.e.comm.plugin.k.g.a(null, new com.tencent.ams.fusion.service.splash.b.a.a(str, null, 3));
    }

    @Override // com.tencent.ams.fusion.service.splash.model.SplashOrder
    public com.tencent.ams.fusion.service.splash.data.d aQ() {
        com.tencent.ams.fusion.service.splash.data.d dVar = new com.tencent.ams.fusion.service.splash.data.d();
        dVar.b(aS());
        dVar.d(aT());
        dVar.h(aU());
        dVar.j(aV());
        dVar.f(aW());
        dVar.l(aX());
        return dVar;
    }

    @Override // com.tencent.ams.fusion.service.splash.model.SplashOrder
    public com.tencent.ams.fusion.service.splash.data.c aR() {
        com.tencent.ams.fusion.service.splash.data.c cVar = new com.tencent.ams.fusion.service.splash.data.c();
        cVar.b(aY());
        return cVar;
    }

    public List<com.tencent.ams.fusion.service.splash.b.a.a> aS() {
        String str;
        if (bx() != null) {
            str = bx().h();
        } else {
            str = null;
        }
        return com.qq.e.comm.plugin.k.g.a(null, new com.tencent.ams.fusion.service.splash.b.a.a(str, null, 1));
    }

    public List<com.tencent.ams.fusion.service.splash.b.a.a> aT() {
        String str;
        String str2;
        if (bx() != null) {
            str = bx().aC();
        } else {
            str = null;
        }
        if (bx() != null) {
            str2 = bx().x();
        } else {
            str2 = null;
        }
        return com.qq.e.comm.plugin.k.g.a(null, new com.tencent.ams.fusion.service.splash.b.a.a(str, str2, 2));
    }

    public List<com.tencent.ams.fusion.service.splash.b.a.a> aU() {
        return com.qq.e.comm.plugin.k.g.a(null, new com.tencent.ams.fusion.service.splash.b.a.a(ao(), null, 1));
    }

    public List<com.tencent.ams.fusion.service.splash.b.a.a> aV() {
        return com.qq.e.comm.plugin.k.g.a(null, new com.tencent.ams.fusion.service.splash.b.a.a(i(), null, 1));
    }

    public List<com.tencent.ams.fusion.service.splash.b.a.a> aW() {
        ArrayList arrayList = new ArrayList();
        if (com.qq.e.comm.plugin.k.g.a(T())) {
            for (String str : T()) {
                if (!TextUtils.isEmpty(str)) {
                    arrayList.add(new com.tencent.ams.fusion.service.splash.b.a.a(str, null, 1));
                }
            }
        }
        return arrayList;
    }

    public List<com.tencent.ams.fusion.service.splash.b.a.a> aX() {
        String str;
        String str2;
        if (!bj()) {
            return null;
        }
        if (bx() != null) {
            str = bx().ad();
        } else {
            str = null;
        }
        if (bx() != null) {
            str2 = bx().bu();
        } else {
            str2 = null;
        }
        return com.qq.e.comm.plugin.k.g.a(null, new com.tencent.ams.fusion.service.splash.b.a.a(str, str2, 2));
    }

    public List<com.tencent.ams.fusion.service.splash.b.a.a> aY() {
        if (bJ() == null) {
            return null;
        }
        String u16 = bJ().u();
        List<String> aZ = aZ();
        ArrayList arrayList = new ArrayList();
        if (com.qq.e.comm.plugin.k.g.a(aZ)) {
            for (String str : aZ) {
                if (!TextUtils.isEmpty(str)) {
                    arrayList.add(new com.tencent.ams.fusion.service.splash.b.a.a(str, null, 1));
                }
            }
        }
        return com.qq.e.comm.plugin.k.g.a(arrayList, new com.tencent.ams.fusion.service.splash.b.a.a(u16, null, 1));
    }

    public List<String> aZ() {
        InteractiveInfo.b bVar;
        if (bJ() != null) {
            bVar = bJ().g();
        } else {
            bVar = null;
        }
        if (bVar == null) {
            return null;
        }
        return bVar.b();
    }

    public boolean ar() {
        return this.aK;
    }

    public boolean as() {
        r bx4 = bx();
        if (bx4 != null && !TextUtils.isEmpty(bv()) && !TextUtils.isEmpty(bw()) && !TextUtils.isEmpty(bx4.s()) && !TextUtils.isEmpty(bx4.bn())) {
            return bx4.f39105aj;
        }
        return false;
    }

    public String at() {
        return this.O;
    }

    @Override // com.tencent.ams.fusion.service.splash.model.SplashOrder
    public String au() {
        return this.aA;
    }

    @Override // com.tencent.ams.fusion.service.splash.model.SplashOrder
    public int av() {
        return this.aZ;
    }

    @Override // com.tencent.ams.fusion.service.splash.model.SplashOrder
    public boolean aw() {
        return false;
    }

    @Override // com.tencent.ams.fusion.service.splash.model.SplashOrder
    public boolean ax() {
        return false;
    }

    public boolean ay() {
        return this.aI;
    }

    @Override // com.tencent.ams.fusion.service.splash.model.SplashOrder
    public int az() {
        int i3 = this.S;
        if (i3 != 1 && i3 != 0) {
            if (i3 == 2) {
                return 1;
            }
            return -1;
        }
        return 0;
    }

    public int bA() {
        return this.f39108am;
    }

    public int bB() {
        return this.f39109an;
    }

    public int bC() {
        return this.f39110ao;
    }

    public int bD() {
        return this.f39111ap;
    }

    public String bE() {
        return this.f39118aw;
    }

    public int bF() {
        return this.f39119ax;
    }

    public boolean bG() {
        if (this.f39117av == 32) {
            return true;
        }
        return false;
    }

    public int bH() {
        return this.f39120ay;
    }

    public List<a> bI() {
        return this.f39121az;
    }

    public InteractiveInfo bJ() {
        return this.f39115at;
    }

    public k bK() {
        return this.aY;
    }

    public ExtraCreativeElement bL() {
        return this.f39122ba;
    }

    public int bM() {
        return this.f39112aq;
    }

    public int bN() {
        return this.f39114as;
    }

    public int bO() {
        return this.f39116au;
    }

    public String bP() {
        return this.aA;
    }

    public String[] bQ() {
        return this.aB;
    }

    public boolean bR() {
        return this.aC;
    }

    public boolean bS() {
        return this.aD;
    }

    public int bT() {
        return this.aF;
    }

    public int bU() {
        return this.aG;
    }

    public JSONObject bV() {
        return this.aM;
    }

    public int bW() {
        return this.aO;
    }

    public int bX() {
        return this.aP;
    }

    public int bY() {
        return this.aS;
    }

    public boolean bZ() {
        return this.aT;
    }

    @Override // com.tencent.ams.fusion.service.splash.model.SplashOrder
    public long ba() {
        return 0L;
    }

    public boolean bb() {
        return this.P;
    }

    public int bc() {
        return this.Q;
    }

    @Override // com.tencent.ams.fusion.service.splash.model.SplashOrder
    public int bd() {
        return cl();
    }

    public int be() {
        return this.R;
    }

    @Override // com.tencent.ams.fusion.service.splash.model.SplashOrder
    public int bf() {
        return this.S;
    }

    public String bg() {
        return y.b(v());
    }

    @Override // com.tencent.ams.fusion.service.splash.model.SplashOrder
    public int bh() {
        if (bG()) {
            return 4;
        }
        if (bi()) {
            return 1;
        }
        if (bi() && !TextUtils.isEmpty(bx().x())) {
            return 2;
        }
        return -1;
    }

    public boolean bi() {
        r bx4 = bx();
        if (bx4 != null && !TextUtils.isEmpty(bv()) && !TextUtils.isEmpty(bw()) && !TextUtils.isEmpty(bx4.s()) && !TextUtils.isEmpty(bx4.bn())) {
            return true;
        }
        return false;
    }

    public boolean bj() {
        String str;
        if (bx() != null) {
            str = bx().bP();
        } else {
            str = null;
        }
        if (bi() && ("FocusBroken".equals(str) || "FocusBrokenShake".equals(str))) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.ams.fusion.service.splash.model.SplashOrder
    public boolean bk() {
        return this.U;
    }

    @Override // com.tencent.ams.fusion.service.splash.model.SplashOrder
    public boolean bl() {
        return this.aJ;
    }

    @Override // com.tencent.ams.fusion.service.splash.model.SplashOrder
    public boolean bm() {
        return false;
    }

    @Override // com.tencent.ams.fusion.service.splash.model.SplashOrder
    public String bn() {
        return this.V;
    }

    public int bo() {
        return this.W;
    }

    @Override // com.tencent.ams.fusion.service.splash.model.SplashOrder
    public boolean bp() {
        return this.X;
    }

    public int bq() {
        return this.Y;
    }

    public String br() {
        return this.Z;
    }

    public List<u> bs() {
        return this.f39096aa;
    }

    public String bt() {
        return this.f39098ac;
    }

    public String bu() {
        return this.f39099ad;
    }

    public String bv() {
        return this.f39100ae;
    }

    public String bw() {
        return this.f39101af;
    }

    public r bx() {
        return this.f39103ah;
    }

    public boolean by() {
        return this.f39104ai;
    }

    public int bz() {
        return this.f39107al;
    }

    public boolean ca() {
        return this.aU;
    }

    public int cb() {
        return this.aV;
    }

    public boolean cc() {
        if (this.aV >= 2) {
            return true;
        }
        return false;
    }

    public int cd() {
        return this.aW;
    }

    public boolean ce() {
        return this.aX;
    }

    public int cf() {
        return this.f39123bb;
    }

    public Map<String, List<u>> cg() {
        return this.f39097ab;
    }

    public String ch() {
        InteractiveInfo interactiveInfo = this.f39115at;
        if (interactiveInfo != null) {
            return interactiveInfo.K();
        }
        return "";
    }

    public String ci() {
        InteractiveInfo interactiveInfo = this.f39115at;
        if (interactiveInfo != null) {
            return interactiveInfo.L();
        }
        return "";
    }

    public void d(JSONArray jSONArray) {
        if (y.a(jSONArray)) {
            return;
        }
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            if (y.b(jSONArray, i3) == 10) {
                this.f39105aj = true;
                return;
            }
        }
    }

    @Override // com.qq.e.comm.plugin.base.ad.model.f
    public void e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f39106ak = SystemClock.elapsedRealtime();
        super.e(jSONObject);
        E(jSONObject.optString("cid"));
        l(jSONObject.optInt("is_contract") == 1);
        o(jSONObject.optInt("pv_fcs"));
        p(jSONObject.optInt("pv_limit"));
        q(jSONObject.optInt("price_mode"));
        m(jSONObject.optInt("need_empty_report") == 1);
        n(jSONObject.optInt("is_empty") == 1);
        H(jSONObject.optString(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_UOID));
        r(jSONObject.optInt("rot_index", -1));
        p(jSONObject.optInt("offlinestop") == 1);
        s(jSONObject.optInt("timelife"));
        I(jSONObject.optString("ad_icon"));
        f(u.a(jSONObject.optJSONArray("slot")));
        J(jSONObject.optString("video_md5"));
        K(jSONObject.optString("video2_md5"));
        M(jSONObject.optString("joint_loc"));
        L(jSONObject.optString("joint_uoid"));
        t(jSONObject.optInt("oneshot_report_type"));
        u(jSONObject.optInt("text_animation_type"));
        v(jSONObject.optInt("show_button"));
        w(jSONObject.optInt("hidelogo"));
        x(jSONObject.optInt("is_extend_ad"));
        y(jSONObject.optInt("skip_delay_time"));
        g(jSONObject.optJSONArray("day_time_creatives"));
        i(jSONObject.optJSONObject("interactive"));
        g(jSONObject.optJSONObject("easter_egg"));
        j(y.g(jSONObject, "extra_card_info"));
        n(y.g(jSONObject, "safety_sensitive_creative_elements"));
        B(jSONObject.optInt("sound_on"));
        C(jSONObject.optInt("sound_rate"));
        D(jSONObject.optInt("video_timelife"));
        E(jSONObject.optInt("hide_ad_icon"));
        N(jSONObject.optString("video2"));
        z(jSONObject.optInt("icon_timelife"));
        l(jSONObject.optInt("inner_adshowtype"));
        f(jSONObject.optJSONObject("splash_switch"));
        O(jSONObject.optString("display_code"));
        f(y.f(jSONObject, "display_code_list"));
        F(jSONObject.optInt("is_alternate_ad"));
        G(jSONObject.optInt("click_mode"));
        e(jSONObject.optJSONArray("action_area_item"));
        k(jSONObject.optBoolean("is_preview"));
        o(jSONObject.optBoolean("is_global_optimal_ad"));
        k(jSONObject.optJSONObject("image_list_animation"));
        h(jSONObject.optJSONObject("image_list_animation"));
        d(jSONObject.optJSONArray("ad_extension_type"));
        l(y.g(jSONObject, "dynamic_info"));
        i(y.a(jSONObject, "is_prld_need_merge"));
        I(y.c(jSONObject, "valid_tp"));
        J(y.b(jSONObject, "component_begin_time", 0));
        K(y.b(jSONObject, "component_end_time", 0));
    }

    public void f(List<u> list) {
        this.f39096aa = list;
    }

    public void g(List<a> list) {
        this.f39121az = list;
    }

    public void i(boolean z16) {
        this.aK = z16;
    }

    public void j(boolean z16) {
        this.aL = z16;
    }

    public void k(boolean z16) {
        this.aI = z16;
    }

    public void n(boolean z16) {
        this.U = z16;
    }

    public void o(int i3) {
        this.Q = i3;
    }

    public void p(int i3) {
        this.R = i3;
    }

    public void q(int i3) {
        this.S = i3;
    }

    public void r(int i3) {
        this.W = i3;
    }

    public void s(int i3) {
        this.Y = i3;
    }

    public void t(int i3) {
        this.f39102ag = i3;
    }

    public void u(int i3) {
        this.f39107al = i3;
    }

    public void v(int i3) {
        this.f39108am = i3;
    }

    public void w(int i3) {
        this.f39109an = i3;
    }

    public void x(int i3) {
        this.f39110ao = i3;
    }

    public void y(int i3) {
        this.f39111ap = i3;
    }

    public void z(int i3) {
        this.f39119ax = i3 * 1000;
    }

    private void J(int i3) {
        this.f39123bb = i3;
    }

    private void a(List<com.tencent.ams.fusion.service.splash.b.a.a> list, boolean z16) {
        String a16;
        String a17;
        ExtraCreativeElement bL = bL();
        if (bL == null) {
            return;
        }
        try {
            ExtraCreativeElement.a c16 = bL.c();
            if (c16 != null) {
                if (z16) {
                    a17 = c16.b(bL.a());
                } else {
                    a17 = c16.a(bL.a());
                }
                com.qq.e.comm.plugin.k.g.a(list, new com.tencent.ams.fusion.service.splash.b.a.a(a17, null, 1));
            }
            List<ExtraCreativeElement.b> b16 = bL.b();
            if (com.qq.e.comm.plugin.k.g.a(b16)) {
                for (int i3 = 0; i3 < b16.size(); i3++) {
                    ExtraCreativeElement.b bVar = b16.get(i3);
                    if (bVar != null) {
                        ExtraCreativeElement.a a18 = bVar.a();
                        if (a18 != null) {
                            if (z16) {
                                a16 = a18.b(bL.a());
                            } else {
                                a16 = a18.a(bL.a());
                            }
                            com.qq.e.comm.plugin.k.g.a(list, new com.tencent.ams.fusion.service.splash.b.a.a(a16, null, 1));
                        }
                        ExtraCreativeElement.b.a[] c17 = bVar.c();
                        if (com.qq.e.comm.plugin.k.g.a(c17)) {
                            for (ExtraCreativeElement.b.a aVar : c17) {
                                if (aVar != null) {
                                    com.qq.e.comm.plugin.k.g.a(list, new com.tencent.ams.fusion.service.splash.b.a.a(aVar.a(), null, 1));
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable th5) {
            GDTLogger.e("addGalleryItemsImgs error:", th5);
        }
    }

    private void g(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        int length = jSONArray.length();
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < length; i3++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                if (y.a(jSONObject)) {
                    a aVar = new a();
                    aVar.f39125a = jSONObject.optString("cid");
                    aVar.f39131g = jSONObject.optString("apurl");
                    aVar.f39127c = jSONObject.optString("img");
                    aVar.f39128d = jSONObject.optString("video");
                    aVar.f39130f = jSONObject.optString("rl");
                    aVar.f39129e = jSONObject.optString("desc");
                    aVar.f39134j = ae.a(jSONObject.optJSONArray("click_mo_url"));
                    aVar.f39132h = s.a(jSONObject.optJSONArray("report_url"));
                    aVar.f39135k = ae.a(jSONObject.optJSONArray("click_mo_url_sdk"));
                    aVar.f39133i = s.a(jSONObject.optJSONArray("report_url_sdk"));
                    aVar.f39126b = new ArrayList();
                    JSONArray optJSONArray = jSONObject.optJSONArray("time_ranges");
                    if (!y.a(optJSONArray)) {
                        for (int i16 = 0; i16 < optJSONArray.length(); i16++) {
                            aVar.f39126b.add(new Point(optJSONArray.getJSONObject(i16).optInt("begin"), optJSONArray.getJSONObject(i16).optInt("end")));
                        }
                    }
                    arrayList.add(aVar);
                }
            } catch (JSONException e16) {
                e16.printStackTrace();
                return;
            }
        }
        g(arrayList);
    }

    private void n(JSONObject jSONObject) {
        if (y.a(jSONObject)) {
            if (com.qq.e.comm.plugin.j.c.a("openOlympicGalleryModelParse", 1, 1)) {
                GDTLogger.i("open olympic model parse");
                this.f39122ba = new ExtraCreativeElement(jSONObject, this.B, f());
            } else {
                GDTLogger.e("olympic model parse wuji close");
            }
        }
    }

    public void E(int i3) {
        this.f39116au = i3;
    }

    public v H(int i3) {
        HashMap<Integer, v> hashMap = this.aH;
        if (hashMap == null || hashMap.size() <= 0) {
            return null;
        }
        return this.aH.get(Integer.valueOf(i3));
    }

    public void I(String str) {
        this.Z = str;
    }

    @Override // com.qq.e.comm.plugin.base.ad.model.f
    public int K() {
        return this.f39117av;
    }

    public void f(JSONObject jSONObject) {
        if (y.a(jSONObject)) {
            this.f39120ay = jSONObject.optInt("disable_report_replace");
            this.aF = jSONObject.optInt("render_mode");
            this.aE = jSONObject.optInt("webview_render_wait_time");
            this.aG = jSONObject.optInt("slide_sensitiveness");
            m(jSONObject.optJSONObject("font_size"));
            this.aS = jSONObject.optInt("shake_desc_margin_bottom");
            this.aT = y.b(jSONObject, "oneshot_adapted_render", false);
            this.aU = jSONObject.optBoolean("fobid_bgsl", false);
            this.aV = y.b(jSONObject, "video_player_type", 1);
            this.aW = y.b(jSONObject, "component_switch_time", 0);
            this.aX = y.a(jSONObject, "enable_skip_to_animation");
        }
    }

    public void i(JSONObject jSONObject) {
        if (y.a(jSONObject)) {
            InteractiveInfo interactiveInfo = new InteractiveInfo();
            this.f39115at = interactiveInfo;
            interactiveInfo.a(jSONObject.optInt("begin"));
            this.f39115at.b(jSONObject.optInt("end"));
            this.f39115at.a(jSONObject.optString("track_color"));
            this.f39115at.b(jSONObject.optString("track_data"));
            this.f39115at.c(jSONObject.optString("android_track_precision"));
            this.f39115at.d(jSONObject.optString("title"));
            this.f39115at.e(jSONObject.optString("description"));
            this.f39115at.c(jSONObject.optInt("direction"));
            this.f39115at.a(jSONObject.optDouble("shake_sensitiveness"));
            this.f39115at.f(jSONObject.optString("icon_background_color"));
            this.f39115at.e(jSONObject.optInt("shake_acceleration"));
            this.f39115at.f(jSONObject.optInt("shake_times"));
            this.f39115at.g(jSONObject.optInt("long_press_time"));
            this.f39115at.h(jSONObject.optInt("press_area_factor"));
            this.f39115at.a(jSONObject.optBoolean("is_open_vibrate"));
            this.f39115at.i(jSONObject.optInt("mask_appear_type"));
            this.f39115at.j(jSONObject.optInt("type"));
            this.f39115at.b(jSONObject.optDouble("component_scale_ratio"));
            this.f39115at.g(jSONObject.optString("icon_url"));
            this.f39115at.b(jSONObject.optBoolean("is_icon_shake"));
            this.f39115at.k(jSONObject.optInt("x_axis_acceleration_rate"));
            this.f39115at.l(jSONObject.optInt("y_axis_acceleration_rate"));
            this.f39115at.m(jSONObject.optInt("z_axis_acceleration_rate"));
            this.f39115at.c(jSONObject.optBoolean("is_show_track"));
            this.f39115at.n(jSONObject.optInt("track_width"));
            this.f39115at.o(jSONObject.optInt("icon_animation_type"));
            this.f39115at.p(jSONObject.optInt("scroll_time_in_ms"));
            this.f39115at.q(jSONObject.optInt("twist_succ_angle"));
            this.f39115at.r(jSONObject.optInt("twist_rollback_succ_angle"));
            this.f39115at.s(jSONObject.optInt("twist_show_type"));
            this.f39115at.h(jSONObject.optString("highlight_color"));
            this.f39115at.t(jSONObject.optInt("distance_between_twist_and_scroll"));
            this.f39115at.j(y.e(jSONObject, "highlight_color"));
            this.f39115at.w(y.c(jSONObject, "scroll_trigger_angle"));
            this.f39115at.u(y.c(jSONObject, "flip_trigger_angle"));
            this.f39115at.v(y.c(jSONObject, "flip_trigger_back_angle"));
            this.f39115at.x(y.c(jSONObject, "scroll_direction"));
            this.f39115at.i(y.e(jSONObject, "background_color"));
            this.f39115at.c(y.g(jSONObject, "slide_angle"));
            this.f39115at.y(y.c(jSONObject, "button_guide_type"));
            this.f39115at.d(y.g(jSONObject, "microphone_data"));
            this.f39115at.a(y.f(jSONObject, "shake_supported_direct_combine"));
            this.f39115at.z(y.c(jSONObject, "shake_sample_rate"));
            this.f39115at.A(y.c(jSONObject, "shake_interval"));
            this.f39115at.b(y.f(jSONObject, "interactive_mode_list"));
            this.f39115at.B(y.c(jSONObject, "flip_direction"));
            this.f39115at.k(y.e(jSONObject, "icon_zip_url"));
            this.f39115at.l(y.e(jSONObject, "collision_animation_url"));
        }
    }

    public void j(JSONObject jSONObject) {
        this.aY = new k(jSONObject);
    }

    public void k(JSONObject jSONObject) {
        this.aM = jSONObject;
    }

    public void o(boolean z16) {
        this.aJ = z16;
    }

    public void p(boolean z16) {
        this.X = z16;
    }

    public void q(boolean z16) {
        this.f39104ai = z16;
    }

    private void K(int i3) {
        this.f39124bc = i3;
    }

    private void d(r rVar) {
        if (rVar != null && y.a(this.G)) {
            JSONObject optJSONObject = this.G.optJSONObject("ext");
            if (y.a(optJSONObject)) {
                String optString = optJSONObject.optString("sdk_data");
                if (TextUtils.isEmpty(optString)) {
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(optString);
                    if (!TextUtils.isEmpty(rVar.Q())) {
                        u(rVar.Q());
                        jSONObject.put("wechat_canvas_ext_info", rVar.Q());
                    }
                    if (!TextUtils.isEmpty(rVar.e())) {
                        b(rVar.e());
                        jSONObject.put("quick_app_link", rVar.e());
                    }
                    if (!TextUtils.isEmpty(rVar.af())) {
                        B(rVar.af());
                        jSONObject.put("web_ext_data", rVar.af());
                    }
                    optJSONObject.put("sdk_data", jSONObject.toString());
                } catch (JSONException e16) {
                    GDTLogger.d(e16.getMessage());
                }
            }
        }
    }

    public void l(boolean z16) {
        this.P = z16;
    }

    @Override // com.qq.e.comm.plugin.base.ad.model.f
    public void l(int i3) {
        this.f39117av = i3;
    }

    public void m(boolean z16) {
        this.T = z16;
    }

    public void G(int i3) {
        this.aD = i3 != 2;
    }

    public void h(JSONObject jSONObject) {
        InteractiveInfo interactiveInfo;
        if (!y.a(jSONObject) || (interactiveInfo = this.f39115at) == null) {
            return;
        }
        interactiveInfo.b(jSONObject);
    }

    public void b(r rVar) {
        if (rVar != null && y.a(rVar.G)) {
            if (rVar.bH() != 1) {
                try {
                    if (!TextUtils.isEmpty(rVar.j())) {
                        String j3 = rVar.j();
                        this.f39011f = j3;
                        this.G.put("apurl", j3);
                    }
                    if (!TextUtils.isEmpty(rVar.n())) {
                        String n3 = rVar.n();
                        this.f39015j = n3;
                        this.G.put("rl", n3);
                    }
                    if (rVar.C() != null) {
                        a(rVar.C());
                        this.G.put("report_url", rVar.G.optJSONArray("report_url"));
                    }
                    if (rVar.D() != null) {
                        b(rVar.D());
                        this.G.put("report_url_sdk", rVar.G.optJSONArray("report_url_sdk"));
                    }
                    if (rVar.E() != null) {
                        c(rVar.E());
                        this.G.put("click_mo_url", rVar.G.optJSONArray("click_mo_url"));
                    }
                    if (rVar.F() != null) {
                        d(rVar.F());
                        this.G.put("click_mo_url_sdk", rVar.G.optJSONArray("click_mo_url_sdk"));
                    }
                    if (!TextUtils.isEmpty(rVar.y())) {
                        q(rVar.y());
                        this.G.put("traceid", rVar.y());
                    }
                    if (!TextUtils.isEmpty(rVar.b())) {
                        a(rVar.b());
                        this.G.put("effect_url", rVar.b());
                    }
                    if (!TextUtils.isEmpty(rVar.r())) {
                        o(rVar.r());
                        this.G.put("landing_page_report_url", rVar.r());
                    }
                    String m3 = rVar.m();
                    if (!TextUtils.isEmpty(m3)) {
                        k(m3);
                        this.G.put("stay_report_url", m3);
                    }
                    a(rVar.v(), this.G, "mqq_landing_page");
                    if (!TextUtils.isEmpty(rVar.q())) {
                        n(rVar.q());
                        this.G.put(Constants.KEYS.AD_NEGATIVE_FEEDBACK_INFO, rVar.q());
                    }
                    a(rVar.v(), this.G, "customized_invoke_url");
                    JSONObject ac5 = rVar.ac();
                    if (y.a(ac5)) {
                        d(ac5);
                        this.G.put("pass_through_data", ac5);
                    }
                    String ae5 = rVar.ae();
                    if (!TextUtils.isEmpty(ae5)) {
                        A(ae5);
                        this.G.put("video_report_url", ae5);
                    }
                    String l3 = rVar.l();
                    if (!TextUtils.isEmpty(l3)) {
                        j(l3);
                        this.G.put("original_exposure_url", l3);
                    }
                    JSONObject optJSONObject = rVar.v().optJSONObject("wechat_ad_trace_data");
                    if (y.a(optJSONObject)) {
                        this.G.put("wechat_ad_trace_data", optJSONObject);
                    }
                    a(rVar.v(), this.G, "wechat_app_path");
                    a(rVar.v(), this.G, "wechat_app_token");
                    d(rVar);
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
            try {
                c(rVar);
                return;
            } catch (Throwable th5) {
                GDTLogger.e("merge ExtraCreativeElement failed:", th5);
                return;
            }
        }
        if (rVar != null && y.a(rVar.G)) {
            GDTLogger.d("disable report replace = " + rVar.bH());
            return;
        }
        GDTLogger.d("target is null, don not replace url");
    }

    public void F(int i3) {
        this.aC = i3 == 1;
    }

    public void f(JSONArray jSONArray) {
        this.aB = w.f(jSONArray);
    }

    public void a(r rVar) {
        this.f39103ah = rVar;
    }

    private void a(JSONObject jSONObject, JSONObject jSONObject2, String str) {
        if (y.a(jSONObject) && y.a(jSONObject2)) {
            String optString = jSONObject.optString(str);
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            try {
                jSONObject2.put(str, optString);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        h(aVar.f39131g);
        l(aVar.f39130f);
        try {
            this.G.put("apurl", this.f39011f);
            this.G.put("rl", this.f39015j);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        f(aVar.f39127c);
        p(aVar.f39128d);
        e(aVar.f39129e);
        J((String) null);
        c(aVar.f39134j);
        d(aVar.f39135k);
        a(aVar.f39132h);
        b(aVar.f39133i);
    }

    public void g(JSONObject jSONObject) {
        InteractiveInfo interactiveInfo;
        if (!y.a(jSONObject) || (interactiveInfo = this.f39115at) == null) {
            return;
        }
        interactiveInfo.a(jSONObject);
    }

    public void a(Map<String, List<u>> map) {
        this.f39097ab = map;
    }

    public void e(JSONArray jSONArray) {
        if (y.a(jSONArray)) {
            return;
        }
        this.aH = new HashMap<>();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            try {
                v vVar = new v((JSONObject) jSONArray.get(i3));
                this.aH.put(Integer.valueOf(vVar.a()), vVar);
            } catch (Throwable th5) {
                GDTLogger.e(th5.getMessage());
            }
        }
    }
}
