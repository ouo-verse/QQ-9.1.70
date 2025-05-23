package com.tencent.biz.pubaccount.weishi.verticalvideo.presenter;

import UserGrowth.stGlobalConfig;
import UserGrowth.stSimpleMetaFeed;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi.event.WSBottomBarRefreshEvent;
import com.tencent.biz.pubaccount.weishi.event.WSHomeBackBtnClickEvent;
import com.tencent.biz.pubaccount.weishi.event.WSRefreshEvent;
import com.tencent.biz.pubaccount.weishi.event.WSRequestRefreshEvent;
import com.tencent.biz.pubaccount.weishi.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi.event.WSVerticalForHomePageSelectedEvent;
import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi.report.WSReportDc00898;
import com.tencent.biz.pubaccount.weishi.util.ao;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.pubaccount.weishi.verticalvideo.data.WSVerticalDataManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes32.dex */
public class WSVerticalForHomePresenter extends WSVerticalForRecommendPresenter {
    private static final int Z = ScreenUtil.dip2px(48.0f);
    private boolean S;
    private boolean T;
    protected long U;
    private long V;
    private long W;
    private String X;
    c00.a Y;

    public WSVerticalForHomePresenter(com.tencent.biz.pubaccount.weishi.verticalvideo.h hVar) {
        super(hVar);
        this.S = true;
        this.T = false;
        this.Y = new c00.a();
    }

    private boolean A2(boolean z16) {
        return this.Y.c(z16, new Function0() { // from class: com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.n
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit E2;
                E2 = WSVerticalForHomePresenter.this.E2();
                return E2;
            }
        }, new Function0() { // from class: com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.o
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit F2;
                F2 = WSVerticalForHomePresenter.this.F2();
                return F2;
            }
        }, new Function0() { // from class: com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.p
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit G2;
                G2 = WSVerticalForHomePresenter.this.G2();
                return G2;
            }
        });
    }

    private boolean C2(Object obj) {
        if (!(obj instanceof String)) {
            return true;
        }
        try {
            return new JSONObject((String) obj).optBoolean("key_should_clear_data_on_refresh", true);
        } catch (JSONException e16) {
            e16.printStackTrace();
            return true;
        }
    }

    private boolean D2(String str) {
        return !TextUtils.isEmpty(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit E2() {
        H2();
        WSPublicAccReport.getInstance().reportHomeBackTipsExposure();
        return null;
    }

    private void H2() {
        com.tencent.biz.pubaccount.weishi.verticalvideo.h O0 = O0();
        if (O0 != null) {
            O0.r0();
        }
    }

    private void I2(boolean z16, int i3, stSimpleMetaFeed stsimplemetafeed) {
        String str = "";
        if (!z16 && TextUtils.isEmpty("") && stsimplemetafeed != null) {
            str = stsimplemetafeed.f25129id;
        }
        WSReportDc00898.o(301, new Object[]{Integer.valueOf(i3), "0", str, 0, 0, Integer.valueOf(z16 ? 1 : 2), 2});
    }

    private void J2(int i3) {
        com.tencent.biz.pubaccount.weishi.verticalvideo.h O0 = O0();
        if (O0 != null) {
            com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.Q(O0.getFrom(), O0.getPlayScene(), i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object s2() {
        HashMap hashMap = new HashMap();
        hashMap.put("key_should_clear_data_on_refresh", Boolean.valueOf(this.S));
        return new JSONObject(hashMap).toString();
    }

    private void t2(int i3) {
        WSRequestRefreshEvent wSRequestRefreshEvent = new WSRequestRefreshEvent(WSRequestRefreshEvent.PAGE_WONDER_IMMERSION);
        wSRequestRefreshEvent.setRefreshState(i3);
        wz.b.b().a(wSRequestRefreshEvent);
    }

    private boolean u2() {
        List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> w3;
        com.tencent.biz.pubaccount.weishi.verticalvideo.h O0 = O0();
        if (O0 == null || O0.getAdapter() == null || (w3 = O0.getAdapter().w()) == null || w3.size() == 0) {
            return false;
        }
        O0.C();
        ArrayList arrayList = new ArrayList(w3);
        O0.c(arrayList);
        com.tencent.biz.pubaccount.weishi.verticalvideo.utils.e.q("[WSVerticalForHomePresenter.java][fillFirstDataOnRefresh]", arrayList);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<String> v2(boolean z16) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (z16) {
            String x26 = x2();
            x.j("WSVerticalForHomePresenter", "[WSVerticalForHomePresenter.java][getContextFeedIds] lastFeedId:" + x26);
            if (!TextUtils.isEmpty(x26)) {
                arrayList.add(x26);
            }
        }
        return arrayList;
    }

    private int y2() {
        stGlobalConfig m3 = iz.a.g().m(12);
        if (m3 == null) {
            return 1;
        }
        x.f("WSVerticalForHomePresenter", "RockDownloader:" + m3.download);
        return m3.link_strategy_type;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter
    public boolean B1() {
        com.tencent.biz.pubaccount.weishi.verticalvideo.h O0 = O0();
        return O0 != null && O0.D();
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void I(String str) {
        super.I(str);
        WSRequestRefreshEvent wSRequestRefreshEvent = new WSRequestRefreshEvent(WSRequestRefreshEvent.PAGE_WONDER_IMMERSION);
        wSRequestRefreshEvent.setRefreshState(1);
        wz.b.b().a(wSRequestRefreshEvent);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public boolean J() {
        return true;
    }

    protected boolean K2() {
        if (D2(this.X)) {
            return false;
        }
        return com.tencent.biz.pubaccount.weishi.home.e.l();
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.WSVerticalForRecommendPresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter
    protected boolean N1() {
        return true;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter
    public void P0(int i3, String str, boolean z16, boolean z17) {
        super.P0(i3, str, z16, z17);
        if (z17) {
            t2(-2);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.d
    /* renamed from: R */
    public void attachView(com.tencent.biz.pubaccount.weishi.verticalvideo.h hVar) {
        super.attachView(hVar);
        if (B1()) {
            com.tencent.biz.pubaccount.weishi.report.f.l(String.valueOf(System.currentTimeMillis()));
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.WSVerticalForRecommendPresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void T0(RecyclerView.ViewHolder viewHolder, int i3) {
        super.T0(viewHolder, i3);
        wz.b.b().a(new WSVerticalForHomePageSelectedEvent(i3 + 1));
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public boolean V() {
        x.i("WSVerticalForHomePresenter", "[handleOnBackEvent]");
        boolean V = super.V();
        if (!this.T && com.tencent.biz.pubaccount.weishi.home.e.f80814a.k()) {
            return A2(V);
        }
        this.T = false;
        return V;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter
    public void V0(List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> list, boolean z16, boolean z17, Object obj) {
        com.tencent.biz.pubaccount.weishi.verticalvideo.h O0 = O0();
        if (z16 && this.S && O0 != null) {
            O0.C();
            t2(2);
        }
        super.V0(list, z16, z17, obj);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void b(WSSimpleBaseEvent wSSimpleBaseEvent) {
        super.b(wSSimpleBaseEvent);
        if (wSSimpleBaseEvent instanceof WSBottomBarRefreshEvent) {
            this.f82227f.c((WSBottomBarRefreshEvent) wSSimpleBaseEvent, O0(), this);
        } else if (wSSimpleBaseEvent instanceof WSRefreshEvent) {
            this.f82227f.j((WSRefreshEvent) wSSimpleBaseEvent, O0(), this);
        } else if (wSSimpleBaseEvent instanceof WSHomeBackBtnClickEvent) {
            this.T = ((WSHomeBackBtnClickEvent) wSSimpleBaseEvent).getIsSingleClick();
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public int c0() {
        return Z;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.b, com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, jz.c
    public void d0(List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> list, boolean z16, boolean z17, Object obj) {
        D1(list, z17, z16, com.tencent.biz.pubaccount.weishi.verticalvideo.data.i.p(list));
        super.d0(list, z16, z17, obj);
        com.tencent.biz.pubaccount.weishi.verticalvideo.utils.e.q("[WSVerticalForHomePresenter.java][onSuccess] >>>>>", list);
        B2(list, z17, obj);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.WSVerticalForRecommendPresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.d
    public void destroy() {
        super.destroy();
        com.tencent.biz.pubaccount.weishi.report.g.d().e(this.V, w2(), B0() != null ? B0().t() : 0, bb.f81753a, ao.f81709b, 2);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void doOnPause() {
        super.doOnPause();
        this.V += System.currentTimeMillis() - this.W;
        i2();
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void doOnResume() {
        super.doOnResume();
        this.W = System.currentTimeMillis();
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.WSVerticalForRecommendPresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void handleIntent(Bundle bundle) {
        super.handleIntent(bundle);
        if (bundle == null) {
            return;
        }
        this.X = bundle.getString("key_home_to_context_feed_id", "");
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.WSVerticalForRecommendPresenter
    protected int k2() {
        return 12;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void r(String str) {
        com.tencent.biz.pubaccount.weishi.verticalvideo.h O0 = O0();
        if (O0 == null) {
            return;
        }
        this.S = true;
        if (u2()) {
            this.S = false;
            O0.A0();
            t2(2);
        }
        super.r(str);
    }

    public long w2() {
        return this.U;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String x2() {
        if (com.tencent.biz.pubaccount.weishi.home.e.l()) {
            if (TextUtils.isEmpty(this.X)) {
                return com.tencent.biz.pubaccount.weishi.verticalvideo.data.i.q();
            }
            return this.X;
        }
        return "";
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.WSVerticalForRecommendPresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.b, com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter
    public boolean y0(final boolean z16, final boolean z17, String str) {
        if (O0() == null) {
            return false;
        }
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.WSVerticalForHomePresenter.1
            @Override // java.lang.Runnable
            public void run() {
                WSVerticalForHomePresenter.this.U = System.currentTimeMillis();
                if (WSVerticalForHomePresenter.this.K2()) {
                    WSVerticalDataManager.j().h(z17, WSVerticalForHomePresenter.this);
                }
                WSVerticalDataManager.j().g(new com.tencent.biz.pubaccount.weishi.verticalvideo.data.k(WSVerticalForHomePresenter.this.k2(), z16, z17).m(WSVerticalForHomePresenter.this.z2()).k(WSVerticalForHomePresenter.this.v2(z17)).o(com.tencent.biz.pubaccount.weishi.verticalvideo.data.i.k(z17)).l(WSVerticalForHomePresenter.this.s2()), WSVerticalForHomePresenter.this);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String z2() {
        if (com.tencent.biz.pubaccount.weishi.home.e.l()) {
            return com.tencent.biz.pubaccount.weishi.verticalvideo.data.i.h();
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit F2() {
        J2(2);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit G2() {
        J2(1);
        return null;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter
    public boolean O1(boolean z16, boolean z17, List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> list, Object obj) {
        if (z17) {
            return z1();
        }
        return C2(obj) && z16;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.b
    protected boolean d2(boolean z16) {
        return z16 && com.tencent.biz.pubaccount.weishi.config.experiment.b.h().J() && com.tencent.biz.pubaccount.weishi.home.e.l();
    }

    private void B2(List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> list, boolean z16, Object obj) {
        stSimpleMetaFeed e16;
        if (obj == null) {
            return;
        }
        if (z16) {
            this.U = System.currentTimeMillis() - this.U;
        }
        if (list == null || list.size() <= 0 || (e16 = list.get(0).e()) == null) {
            return;
        }
        I2(false, y2(), e16);
    }
}
