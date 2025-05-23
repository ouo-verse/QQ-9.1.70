package e10;

import UserGrowth.stExposureFeedInfo;
import UserGrowth.stGlobalConfig;
import UserGrowth.stSimpleGetFeedListRsp;
import UserGrowth.stSimpleMetaFeed;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tencent.biz.pubaccount.weishi.cache.WeiShiCacheManager;
import com.tencent.biz.pubaccount.weishi.event.WSBottomBarRefreshEvent;
import com.tencent.biz.pubaccount.weishi.event.WSPreloadTabEvent;
import com.tencent.biz.pubaccount.weishi.event.WSRefreshEvent;
import com.tencent.biz.pubaccount.weishi.event.WSRequestRefreshEvent;
import com.tencent.biz.pubaccount.weishi.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi.push.WSRedDotPushMsg;
import com.tencent.biz.pubaccount.weishi.recommend.WSGridPageFragment;
import com.tencent.biz.pubaccount.weishi.recommend.data.WSGridDataManager;
import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi.report.WSReportDc00898;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.util.r;
import com.tencent.biz.pubaccount.weishi.util.w;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.pubaccount.weishi.verticalvideo.data.i;
import com.tencent.mobileqq.app.dv;
import com.tencent.widget.pull2refresh.XRecyclerView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes38.dex */
public abstract class a extends com.tencent.biz.pubaccount.weishi.presenter.a<com.tencent.biz.pubaccount.weishi.recommend.e> implements com.tencent.biz.pubaccount.weishi.recommend.d, com.tencent.biz.pubaccount.weishi.recommend.data.a {
    protected String E;
    protected WSRedDotPushMsg G;
    private w H;

    /* renamed from: m, reason: collision with root package name */
    private int f395338m;

    /* renamed from: f, reason: collision with root package name */
    private boolean f395335f = false;

    /* renamed from: h, reason: collision with root package name */
    private boolean f395336h = false;

    /* renamed from: i, reason: collision with root package name */
    private boolean f395337i = false;
    protected String C = "";
    protected String D = "";
    protected final WSGridDataManager F = new WSGridDataManager();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: e10.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public class C10210a implements com.tencent.biz.pubaccount.weishi.cache.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f395339a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f395340b;

        C10210a(boolean z16, boolean z17) {
            this.f395339a = z16;
            this.f395340b = z17;
        }

        @Override // com.tencent.biz.pubaccount.weishi.cache.a
        public void a(JceStruct jceStruct) {
            x.f("AbsWSGridPagePresenterLog", "[AbsWSGridPagePresenter.java][onReadCacheCompleted] mSubTabId:" + a.this.E);
            a.this.L0(jceStruct, this.f395339a, this.f395340b);
        }
    }

    public a(String str) {
        this.E = str;
        this.H = new w(H0(this.E));
    }

    private String E0() {
        if (!Q0()) {
            return "";
        }
        String str = bb.f81755c;
        dv C = bb.C();
        return (C == null || !TextUtils.isEmpty(str)) ? str : C.d();
    }

    private int G0() {
        List<stSimpleMetaFeed> dataList;
        if (x0() == null || (dataList = x0().getDataList()) == null) {
            return -1;
        }
        return dataList.size() - 1;
    }

    private String H0(String str) {
        if (!TextUtils.isEmpty(str)) {
            return "feeds_" + this.E;
        }
        return "feeds";
    }

    private void J0(List<stSimpleMetaFeed> list) {
        com.tencent.biz.pubaccount.weishi.recommend.e x06 = x0();
        if (x06 == null) {
            return;
        }
        x06.L8(true, s1());
        x06.setData(list);
        this.H.b();
    }

    private boolean N0() {
        com.tencent.biz.pubaccount.weishi.recommend.e x06 = x0();
        if (x06 instanceof WSGridPageFragment) {
            return x06.U9();
        }
        return true;
    }

    private void Z() {
        this.H.d();
    }

    private void y0() {
        String str;
        com.tencent.biz.pubaccount.weishi.recommend.e x06 = x0();
        if (x06 != null && !O0()) {
            x.j("AbsWSGridPagePresenterLog", "[AbsWSGridPagePresenter.java][handleCacheData] mSubTabId:" + this.E + ", saveFeed and cache!");
            List<stSimpleMetaFeed> dataList = x06.getDataList();
            if (dataList.size() <= 0) {
                x.j("AbsWSGridPagePresenterLog", "[AbsWSGridPagePresenter.java][handleCacheData] mSubTabId:" + this.E + ", data is null, no need to cache!");
                return;
            }
            List<stSimpleMetaFeed> arrayList = new ArrayList<>(dataList);
            stSimpleMetaFeed c16 = ry.a.c();
            if (c16 == null) {
                c16 = r.k(arrayList);
            }
            arrayList.remove(c16);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[AbsWSGridPagePresenter.java][handleCacheData] mSubTabId:");
            sb5.append(this.E);
            sb5.append(", feedId:");
            String str2 = "";
            if (c16 == null) {
                str = "";
            } else {
                str = c16.f25129id;
            }
            sb5.append(str);
            sb5.append(", feedTitle:");
            if (c16 != null) {
                str2 = c16.feed_desc;
            }
            sb5.append(str2);
            sb5.append(", to cache!");
            x.f("AbsWSGridPagePresenterLog", sb5.toString());
            WeiShiCacheManager.O().q(arrayList, c16, this.f395338m, H0(this.E));
            return;
        }
        x.f("AbsWSGridPagePresenterLog", "[AbsWSGridPagePresenter.java][handleCacheData] ignoreCacheData:true! mSubTabId:" + this.E);
    }

    private void z0(int i3) {
        WSRequestRefreshEvent wSRequestRefreshEvent = new WSRequestRefreshEvent(WSRequestRefreshEvent.PAGE_DISCOVER_HOT_GRID);
        wSRequestRefreshEvent.setRefreshState(i3);
        wz.b.b().a(wSRequestRefreshEvent);
    }

    public void B0(String str, String str2) {
        boolean z16 = bb.J() && W0();
        if (V0()) {
            C0(true, z16);
        } else {
            C0(false, z16);
            D0(false, true, false, str, str2);
        }
    }

    public void C0(boolean z16, boolean z17) {
        boolean P0 = P0();
        x.f("AbsWSGridPagePresenterLog", "[AbsWSGridPagePresenter.java][fetchGridDataFromCache] mSubTabId:" + this.E + ", ignoreGridCacheData:" + P0 + ", isRedDotCacheValid:" + z16 + ", isFromWeiShiPush:" + z17);
        if (P0) {
            return;
        }
        WeiShiCacheManager.O().B(false, new C10210a(z16, z17));
    }

    public void D0(boolean z16, boolean z17, boolean z18, String str, String str2) {
        com.tencent.biz.pubaccount.weishi.recommend.e x06 = x0();
        if (x06 == null) {
            return;
        }
        if (z17 && !z18) {
            x06.showLoading();
        }
        ArrayList<stExposureFeedInfo> d16 = com.tencent.biz.pubaccount.weishi.recommend.data.c.e().d();
        com.tencent.biz.pubaccount.weishi.recommend.data.e p16 = new com.tencent.biz.pubaccount.weishi.recommend.data.e(z16, z17, z18).p(this.E);
        String str3 = "";
        if (!z17) {
            str = "";
        }
        com.tencent.biz.pubaccount.weishi.recommend.data.e n3 = p16.n(str);
        if (!z17) {
            str2 = "";
        }
        com.tencent.biz.pubaccount.weishi.recommend.data.e k3 = n3.o(str2).k(d16);
        if (z17) {
            str3 = F0();
        }
        k3.l(str3);
        k3.m(z17 ? i.r() : 0);
        x.f("AbsWSGridPagePresenterLog", "[AbsWSGridPagePresenter.java][getFeedList] mSubTabId:" + this.E + ", requestParams:" + k3);
        this.F.h(k3, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String F0() {
        if (x0() != null && !TextUtils.isEmpty(x0().Id())) {
            return x0().Id();
        }
        return E0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void I0(List<stSimpleMetaFeed> list, boolean z16, stGlobalConfig stglobalconfig, int i3, long j3) {
        com.tencent.biz.pubaccount.weishi.recommend.e x06 = x0();
        if (x06 == null) {
            return;
        }
        if (z16) {
            list.remove(0);
            x06.setData(list);
            return;
        }
        x06.hideLoading();
        x06.r4();
        if (this.f395335f) {
            x06.Za(true);
        }
        x06.c(list);
        if (x06.D()) {
            x06.Jg();
            wz.b.b().a(new WSPreloadTabEvent());
        } else {
            x06.L8(true, s1());
        }
    }

    public void K0(List<stSimpleMetaFeed> list) {
        com.tencent.biz.pubaccount.weishi.recommend.e x06 = x0();
        if (x06 == null) {
            return;
        }
        x06.M6();
        x06.Za(true);
        x06.c(list);
        if (x06.D()) {
            x06.Jg();
        }
        z0(2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void L0(JceStruct jceStruct, boolean z16, boolean z17) {
        ArrayList<stSimpleMetaFeed> arrayList;
        if ((jceStruct instanceof stSimpleGetFeedListRsp) && (arrayList = ((stSimpleGetFeedListRsp) jceStruct).feeds) != null && arrayList.size() > 0) {
            this.f395335f = true;
            x.j("AbsWSGridPagePresenterLog", "[AbsWSGridPagePresenter.java][handleOnReadCacheCompleted] mHasLoadedFromService:" + this.f395336h);
            if (this.f395336h) {
                return;
            }
            this.f395337i = z16;
            if (z17) {
                g10.b.f(true, -1, null, this.G, this.E);
            }
            com.tencent.biz.pubaccount.weishi.recommend.e x06 = x0();
            if (x06 == null) {
                return;
            }
            if (z16) {
                x.j("AbsWSGridPagePresenterLog", "[AbsWSGridPagePresenter.java][handleOnReadCacheCompleted] mSubTabId:" + this.E + ", feedsSize:" + arrayList.size());
                D0(false, true, true, this.C, "");
                x06.D7(arrayList, false);
            }
            x06.hideLoading();
            x06.r4();
            x06.setData(arrayList);
            x06.L8(true, true);
            this.H.b();
            this.f395338m = arrayList.size();
            if (z16 || this.f395336h) {
                return;
            }
            x.f("AbsWSGridPagePresenterLog", "[AbsWSGridPagePresenter.java][handleOnReadCacheCompleted] mSubTabId:" + this.E + ", showTopLoading");
            x06.G7(true);
        }
    }

    protected void M0() {
        String str;
        if (W0() && Q0()) {
            WSRedDotPushMsg z16 = bb.z();
            this.G = z16;
            if (z16 == null) {
                str = "";
            } else {
                str = z16.mMsgData;
            }
            this.C = str;
            this.D = bb.v();
            bb.X();
        }
    }

    protected abstract boolean O0();

    protected abstract boolean P0();

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Q0() {
        return "from_home_page".equals(WSPublicAccReport.getInstance().getEnterPublicAccFrom());
    }

    @Override // com.tencent.biz.pubaccount.weishi.recommend.data.a
    public void R(List<stSimpleMetaFeed> list, boolean z16, boolean z17, boolean z18, long j3) {
        boolean N0 = N0();
        x.f("AbsWSGridPagePresenterLog", "[AbsWSGridPagePresenter.java][onLoadGridDataSuccess] mSubTabId:" + this.E + ", activityFinishing:" + N0 + ", feeds:" + list.size() + ", isFirstFromService:" + z16 + ", isRefresh:" + z17 + ", isRedDotCacheValid:" + z18);
        if (N0) {
            return;
        }
        this.f395336h = true;
        this.f395337i = true;
        stGlobalConfig m3 = iz.a.g().m(1);
        int i3 = m3 != null ? m3.link_strategy_type : 1;
        if (z16) {
            I0(list, z18, m3, i3, j3);
        } else if (z17) {
            K0(list);
        } else {
            J0(list);
        }
        A0(list, z16, z17, z18);
        X0(list, z18, z16);
    }

    protected abstract boolean V0();

    protected abstract boolean W0();

    /* JADX INFO: Access modifiers changed from: protected */
    public void X0(List<stSimpleMetaFeed> list, boolean z16, boolean z17) {
        if (s1() || z16) {
            WSPicLoader.g().u(list, true, H0(this.E));
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.recommend.d
    public void Y0() {
        Z();
    }

    @Override // com.tencent.biz.pubaccount.weishi.recommend.d
    public void Z0(WSRefreshEvent wSRefreshEvent) {
        com.tencent.biz.pubaccount.weishi.recommend.e x06 = x0();
        if (x06 != null && x06.D() && wSRefreshEvent.getPageType() == 2) {
            x06.C();
            x06.G7(false);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.recommend.d
    public void c1() {
        this.H.c(G0());
    }

    @Override // com.tencent.biz.pubaccount.weishi.recommend.d
    public fz.a d1() {
        return null;
    }

    @Override // com.tencent.biz.pubaccount.weishi.recommend.d
    public void doOnPause() {
        f10.b.f397582a.j();
        y0();
        Z();
    }

    @Override // com.tencent.biz.pubaccount.weishi.recommend.d
    public boolean f1() {
        return false;
    }

    @Override // com.tencent.biz.pubaccount.weishi.recommend.d
    public boolean h1() {
        return false;
    }

    @Override // com.tencent.biz.pubaccount.weishi.recommend.d
    public void i1(WSBottomBarRefreshEvent wSBottomBarRefreshEvent) {
        com.tencent.biz.pubaccount.weishi.recommend.e x06 = x0();
        if (x06 != null && x06.D() && "waterfall_tab".equals(wSBottomBarRefreshEvent.getBarId())) {
            x06.C();
            x06.G7(false);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.recommend.d
    public dz.a j1() {
        return null;
    }

    @Override // com.tencent.biz.pubaccount.weishi.recommend.d
    public boolean k1() {
        return false;
    }

    @Override // com.tencent.biz.pubaccount.weishi.recommend.d
    public boolean l1() {
        return this.f395337i;
    }

    @Override // com.tencent.biz.pubaccount.weishi.recommend.d
    public void r1(boolean z16, boolean z17) {
        if (!this.f395337i) {
            com.tencent.biz.pubaccount.weishi.report.e.f81529d = 2;
        } else if (!bb.f81753a && !z16 && !z17) {
            com.tencent.biz.pubaccount.weishi.report.e.f81529d = 3;
        } else {
            com.tencent.biz.pubaccount.weishi.report.e.f81529d = 1;
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.recommend.d
    public void s() {
        this.H.a();
    }

    @Override // com.tencent.biz.pubaccount.weishi.recommend.d
    public boolean s1() {
        return !this.F.k();
    }

    @Override // com.tencent.biz.pubaccount.weishi.recommend.d
    public void c() {
        this.f395336h = false;
        M0();
        B0(this.C, this.D);
    }

    @Override // com.tencent.biz.pubaccount.weishi.recommend.d
    public void o1(boolean z16, boolean z17) {
        D0(z16, z17, false, "", "");
    }

    private void A0(List<stSimpleMetaFeed> list, boolean z16, boolean z17, boolean z18) {
        if (z17 || z16) {
            this.f395338m = list.size();
            com.tencent.biz.pubaccount.weishi.recommend.e x06 = x0();
            if (z18 || x06 == null || !x06.D()) {
                return;
            }
            x.j("AbsWSGridPagePresenterLog", "[AbsWSGridPagePresenter.java][exposeRefreshCardFromServer] mSubTabId:" + this.E + ", feedsSize:" + list.size());
            x06.D7(list, R0(z16));
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.recommend.data.a
    public void e0(int i3, String str, boolean z16, boolean z17) {
        if (z16) {
            WSReportDc00898.o(302, new Object[]{Integer.valueOf(i3), 0L});
        }
        if (!z16 && !z17) {
            com.tencent.biz.pubaccount.weishi.recommend.a.l(i3, "", "", this.E);
        } else {
            com.tencent.biz.pubaccount.weishi.recommend.a.m(z16, z17, i3, this.E);
        }
        com.tencent.biz.pubaccount.weishi.recommend.e x06 = x0();
        if (x06 == null) {
            return;
        }
        if (z16) {
            if (this.f395335f) {
                x06.Za(false);
                return;
            } else {
                x06.O0(i3, str);
                return;
            }
        }
        if (z17) {
            x06.Za(false);
            z0(-2);
        } else {
            x06.L8(false, true);
            this.H.b();
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.recommend.d
    public void a1() {
    }

    @Override // com.tencent.biz.pubaccount.weishi.recommend.d
    public void doOnDestroy() {
    }

    @Override // com.tencent.biz.pubaccount.weishi.recommend.d
    public void doOnResume() {
    }

    @Override // com.tencent.biz.pubaccount.weishi.recommend.d
    public void g1() {
    }

    @Override // com.tencent.biz.pubaccount.weishi.recommend.d
    public void m1() {
    }

    @Override // com.tencent.biz.pubaccount.weishi.recommend.d
    public void p1() {
    }

    @Override // com.tencent.biz.pubaccount.weishi.recommend.d
    public void q1() {
    }

    protected boolean R0(boolean z16) {
        return z16;
    }

    @Override // com.tencent.biz.pubaccount.weishi.recommend.d
    public void b1(String str) {
    }

    @Override // com.tencent.biz.pubaccount.weishi.recommend.d
    public void n1(XRecyclerView xRecyclerView, boolean z16) {
    }

    @Override // com.tencent.biz.pubaccount.weishi.recommend.d
    public void e1(int i3, int i16, int i17) {
    }
}
