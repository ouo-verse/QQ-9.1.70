package e10;

import UserGrowth.stGetFollowedDramasRsp;
import UserGrowth.stGlobalConfig;
import UserGrowth.stJumpInfo;
import UserGrowth.stNotificationRsp;
import UserGrowth.stSimpleMetaFeed;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tencent.biz.pubaccount.weishi.WeishiConstants;
import com.tencent.biz.pubaccount.weishi.cache.WeiShiCacheManager;
import com.tencent.biz.pubaccount.weishi.event.WSUserAuthEvent;
import com.tencent.biz.pubaccount.weishi.recommend.data.f;
import com.tencent.biz.pubaccount.weishi.report.WSReportDc00898;
import com.tencent.biz.pubaccount.weishi.util.WeishiLinkUtil;
import com.tencent.biz.pubaccount.weishi.util.ao;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.qqstory.utils.l;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;
import kz.m;
import mz.g;

/* compiled from: P */
/* loaded from: classes38.dex */
public class c extends e10.a implements com.tencent.biz.pubaccount.weishi.recommend.data.b {
    private final f I;
    private final m J;
    private final kz.a<g> K;
    private fz.a L;
    private long M;
    private long N;
    private long P;
    private long Q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class a implements com.tencent.biz.pubaccount.weishi.cache.a {
        a() {
        }

        @Override // com.tencent.biz.pubaccount.weishi.cache.a
        public void a(JceStruct jceStruct) {
            if (jceStruct instanceof stGetFollowedDramasRsp) {
                x.i("WSGridForHotPresenterLog", "fetchFollowDramaHeaderDataFromCache() onReadCacheCompleted");
                c.this.y1(vz.a.a((stGetFollowedDramasRsp) jceStruct), true);
            }
        }
    }

    public c(String str) {
        super(str);
        this.J = new m();
        this.K = v1();
        this.M = 0L;
        this.N = 0L;
        this.P = 0L;
        this.Q = -1L;
        this.I = new f();
    }

    private void B1() {
        if (!WeishiConstants.f80408a) {
            this.M = System.currentTimeMillis() - this.N;
            x.j("WSGridForHotPresenterLog", "[WSGridForHotPresenter.java][reportBeaconAnd898Exit] exitPublicAccount mStayTime:" + this.M);
            this.N = 0L;
        }
        com.tencent.biz.pubaccount.weishi.recommend.e x06 = x0();
        if (x06 == null) {
            return;
        }
        int e56 = x06.e5();
        WSReportDc00898.o(117, new Object[]{Long.valueOf(this.M), Integer.valueOf(e56)});
        com.tencent.biz.pubaccount.weishi.report.g.d().e(this.M, this.Q, e56, bb.f81753a, ao.f81709b, 1);
    }

    private void C1() {
        if (this.P > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.P;
            this.P = 0L;
            x.j("WSGridForHotPresenterLog", "[WSGridForHotPresenter.java][reportPageInitConst] initTime\uff1a" + currentTimeMillis);
            com.tencent.biz.pubaccount.weishi.report.g.d().f(true, currentTimeMillis);
            com.tencent.biz.pubaccount.weishi.report.g.d().l(true, currentTimeMillis, "feeds", "feeds");
        }
    }

    private void D1(int i3) {
        WeishiLinkUtil.q();
        WeishiLinkUtil.n(i3);
    }

    private void u1() {
        WeiShiCacheManager.O().A(new a());
    }

    private kz.a<g> v1() {
        return new b();
    }

    private void w1(stGlobalConfig stglobalconfig, com.tencent.biz.pubaccount.weishi.recommend.e eVar) {
        if (l.c(BaseApplication.getContext())) {
            eVar.b1(stglobalconfig);
        }
    }

    private void x1(stGlobalConfig stglobalconfig, String str, com.tencent.biz.pubaccount.weishi.recommend.e eVar) {
        int i3;
        stJumpInfo stjumpinfo = stglobalconfig.jumpinfo;
        if (stjumpinfo == null || TextUtils.isEmpty(stjumpinfo.h5url)) {
            i3 = 2;
        } else {
            eVar.We(stglobalconfig.jumpinfo.h5url);
            i3 = 1;
        }
        WSReportDc00898.k(i3, 2, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y1(g gVar, boolean z16) {
        if (x0() == null) {
            return;
        }
        if (gVar != null && gVar.a() != null && gVar.a().size() != 0) {
            x0().ub(gVar, z16);
        } else {
            x0().h7();
        }
    }

    private void z1(List<stSimpleMetaFeed> list, stGlobalConfig stglobalconfig, String str, boolean z16) {
        com.tencent.biz.pubaccount.weishi.recommend.e x06 = x0();
        if (stglobalconfig != null && x06 != null) {
            int i3 = stglobalconfig.link_strategy_type;
            if (i3 == 1 || i3 == 2) {
                x06.b1(stglobalconfig);
                return;
            } else if (i3 == 4) {
                w1(stglobalconfig, x06);
                return;
            } else {
                if (i3 != 7) {
                    return;
                }
                x1(stglobalconfig, str, x06);
                return;
            }
        }
        x.f("WSGridForHotPresenterLog", "[WSGridForHotPresenter.java][performLinkStrategy] globalConfig is null!");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e10.a
    public void I0(List<stSimpleMetaFeed> list, boolean z16, stGlobalConfig stglobalconfig, int i3, long j3) {
        super.I0(list, z16, stglobalconfig, i3, j3);
        f10.b.f397582a.l();
        this.Q = System.currentTimeMillis() - j3;
        String f16 = g10.b.f(false, i3, list.get(0), this.G, this.E);
        if (com.tencent.biz.pubaccount.weishi.x.e()) {
            wz.b.b().a(new WSUserAuthEvent());
        }
        z1(list, stglobalconfig, f16, z16);
        D1(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e10.a
    public void L0(JceStruct jceStruct, boolean z16, boolean z17) {
        super.L0(jceStruct, z16, z17);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e10.a
    public boolean O0() {
        return false;
    }

    @Override // e10.a
    protected boolean W0() {
        return true;
    }

    @Override // e10.a, com.tencent.biz.pubaccount.weishi.recommend.d
    public void a1() {
        super.a1();
        d1().m();
    }

    @Override // e10.a, com.tencent.biz.pubaccount.weishi.recommend.d
    public void b1(String str) {
        this.I.b(str, this);
    }

    @Override // e10.a, com.tencent.biz.pubaccount.weishi.recommend.d
    public void c() {
        super.c();
        this.P = System.currentTimeMillis();
        b1(this.C);
        if (h1()) {
            u1();
        }
    }

    @Override // e10.a, com.tencent.biz.pubaccount.weishi.recommend.d
    public fz.a d1() {
        if (this.L == null) {
            this.L = new fz.a();
        }
        return this.L;
    }

    @Override // e10.a, com.tencent.biz.pubaccount.weishi.recommend.d
    public void doOnDestroy() {
        super.doOnDestroy();
        B1();
    }

    @Override // e10.a, com.tencent.biz.pubaccount.weishi.recommend.d
    public void doOnResume() {
        super.doOnResume();
        if (!WeishiConstants.f80408a) {
            this.N = System.currentTimeMillis();
        } else {
            WeishiConstants.f80408a = false;
        }
        C1();
        A1();
    }

    @Override // e10.a, com.tencent.biz.pubaccount.weishi.recommend.d
    public boolean f1() {
        return true;
    }

    @Override // e10.a, com.tencent.biz.pubaccount.weishi.recommend.d
    public boolean h1() {
        return com.tencent.biz.pubaccount.weishi.config.experiment.b.h().K();
    }

    @Override // com.tencent.biz.pubaccount.weishi.recommend.data.b
    public void i0(stNotificationRsp stnotificationrsp, com.tencent.biz.pubaccount.weishi.net.d dVar) {
        com.tencent.biz.pubaccount.weishi.recommend.e x06 = x0();
        if (x06 != null) {
            x06.N6();
            x06.Ic(stnotificationrsp, dVar);
        }
    }

    @Override // e10.a, com.tencent.biz.pubaccount.weishi.recommend.d
    public boolean k1() {
        return true;
    }

    @Override // e10.a, com.tencent.biz.pubaccount.weishi.recommend.d
    public void q1() {
        this.J.d(this.K);
    }

    private void A1() {
        WSReportDc00898.o(6, this.G);
    }

    @Override // e10.a
    protected boolean V0() {
        boolean L = bb.L(8);
        int V = WeiShiCacheManager.O().V();
        x.j("WSGridForHotPresenterLog", "[WSGridForHotPresenter.java][isPreloadCacheValid] mSubTab:" + this.E + ", preloadCacheValid:" + L + ", redCacheCount:" + V);
        return L && V >= 8;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e10.a
    public void X0(List<stSimpleMetaFeed> list, boolean z16, boolean z17) {
        if (z17) {
            f10.b.f397582a.g();
        }
        super.X0(list, z16, z17);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class b implements kz.a<g> {
        b() {
        }

        @Override // kz.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(g gVar) {
            c.this.y1(gVar, false);
        }

        @Override // kz.a
        public void onFailure(int i3, String str) {
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.recommend.data.b
    public void x(int i3, String str) {
    }
}
