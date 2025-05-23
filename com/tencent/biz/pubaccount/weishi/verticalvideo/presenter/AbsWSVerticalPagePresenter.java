package com.tencent.biz.pubaccount.weishi.verticalvideo.presenter;

import UserGrowth.stSimpleMetaFeed;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi.WSAutoShowCommentParams;
import com.tencent.biz.pubaccount.weishi.event.FollowEvent;
import com.tencent.biz.pubaccount.weishi.event.LikeRspEvent;
import com.tencent.biz.pubaccount.weishi.event.WSAddCommentEvent;
import com.tencent.biz.pubaccount.weishi.event.WSClearModeEvent;
import com.tencent.biz.pubaccount.weishi.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi.event.WSSpeedChangeEvent;
import com.tencent.biz.pubaccount.weishi.event.WSSpeedPlayEvent;
import com.tencent.biz.pubaccount.weishi.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi.util.ah;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.util.w;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi.verticalvideo.holder.au;
import com.tencent.biz.pubaccount.weishi.verticalvideo.onemore.WSOneMoreFeedHelper;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import ez.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import mqq.util.WeakReference;

/* loaded from: classes32.dex */
public abstract class AbsWSVerticalPagePresenter implements com.tencent.biz.pubaccount.weishi.verticalvideo.g, jz.c<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j>, jz.d<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> {
    private static final int M = ah.b(40.0f);
    private static final int N = ah.b(46.0f);
    private final r10.e C;
    private hz.a D;
    protected boolean E;
    protected boolean F;
    public boolean G;
    public boolean H;
    public int I;
    protected boolean J;
    private boolean K;
    private boolean L;

    /* renamed from: d, reason: collision with root package name */
    private final WeakReference<com.tencent.biz.pubaccount.weishi.verticalvideo.h> f82225d;

    /* renamed from: e, reason: collision with root package name */
    private final w f82226e;

    /* renamed from: f, reason: collision with root package name */
    protected final com.tencent.biz.pubaccount.weishi.verticalvideo.j f82227f;

    /* renamed from: h, reason: collision with root package name */
    private WSAutoShowCommentParams f82228h;

    /* renamed from: i, reason: collision with root package name */
    private final WSOneMoreFeedHelper f82229i;

    /* renamed from: m, reason: collision with root package name */
    private final com.tencent.biz.pubaccount.weishi.verticalvideo.utils.c f82230m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class a implements e.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaseViewHolder f82239a;

        a(BaseViewHolder baseViewHolder) {
            this.f82239a = baseViewHolder;
        }

        @Override // ez.e.b
        public void a(com.tencent.biz.pubaccount.weishi.verticalvideo.data.j jVar) {
            Object obj = ((au) this.f82239a).f82127d;
            if (obj instanceof com.tencent.biz.pubaccount.weishi.verticalvideo.holder.b) {
                ((com.tencent.biz.pubaccount.weishi.verticalvideo.holder.b) obj).o(jVar);
            }
            if (jVar.f() != null) {
                AbsWSVerticalPagePresenter.this.C.d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class b implements com.tencent.biz.pubaccount.weishi.verticalvideo.onemore.a {
        b() {
        }

        @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.onemore.a
        public void a(stSimpleMetaFeed stsimplemetafeed) {
            com.tencent.biz.pubaccount.weishi.verticalvideo.h O0 = AbsWSVerticalPagePresenter.this.O0();
            if (O0 == null) {
                return;
            }
            if (AbsWSVerticalPagePresenter.this.w1(stsimplemetafeed)) {
                x.j("AbsWSVerticalPagePresenter", "feed has been in vertical list, update failed.");
                return;
            }
            com.tencent.biz.pubaccount.weishi.verticalvideo.data.j jVar = new com.tencent.biz.pubaccount.weishi.verticalvideo.data.j();
            jVar.p(stsimplemetafeed);
            O0.pa(jVar);
        }
    }

    public AbsWSVerticalPagePresenter(com.tencent.biz.pubaccount.weishi.verticalvideo.h hVar) {
        WSOneMoreFeedHelper wSOneMoreFeedHelper = new WSOneMoreFeedHelper(new com.tencent.biz.pubaccount.weishi.verticalvideo.onemore.d());
        this.f82229i = wSOneMoreFeedHelper;
        this.G = true;
        this.K = true;
        this.L = true;
        this.f82225d = new WeakReference<>(hVar);
        this.f82226e = new w(com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.l(hVar.getFrom()));
        this.f82227f = new com.tencent.biz.pubaccount.weishi.verticalvideo.j();
        wSOneMoreFeedHelper.m(I0());
        this.f82230m = new com.tencent.biz.pubaccount.weishi.verticalvideo.utils.c(hVar);
        this.C = new r10.e(hVar);
    }

    private List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> E0() {
        ArrayList arrayList = new ArrayList();
        com.tencent.biz.pubaccount.weishi.verticalvideo.f B0 = B0();
        if (B0 != null && B0.getDataList() != null) {
            arrayList.addAll(B0.getDataList());
        }
        return arrayList;
    }

    private void F1(List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> list) {
        ArrayList arrayList = new ArrayList();
        for (com.tencent.biz.pubaccount.weishi.verticalvideo.data.j jVar : list) {
            if (jVar != null && jVar.e() != null) {
                arrayList.add(jVar.e());
            }
        }
        WSPicLoader.g().u(arrayList, false, WSPublicAccReport.SOP_NAME_VIDEO_PLAY);
    }

    private int H0(boolean z16, boolean z17, List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> list, Object obj) {
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        return O1(z16, z17, list, obj) ? 0 : 3;
    }

    private com.tencent.biz.pubaccount.weishi.verticalvideo.onemore.a I0() {
        return new b();
    }

    private void J1(String str, String str2, WSPlayerManager wSPlayerManager) {
        if (!this.G || wSPlayerManager == null) {
            return;
        }
        if (wSPlayerManager.E0() || wSPlayerManager.D0()) {
            com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.j0(str, str2, wSPlayerManager.n0(), false, this.I, com.tencent.biz.pubaccount.weishi.verticalvideo.utils.e.k(h0(), L0()));
            wSPlayerManager.N0();
            this.G = false;
        }
    }

    private void L1(boolean z16, boolean z17) {
        com.tencent.biz.pubaccount.weishi.verticalvideo.h O0 = O0();
        if (O0 == null || O0.getAdapter() == null) {
            return;
        }
        if (z16 || z17) {
            O0.getAdapter().T(1);
        }
    }

    private void W0(BaseViewHolder<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> baseViewHolder, int i3) {
        com.tencent.biz.pubaccount.weishi.verticalvideo.h O0;
        com.tencent.biz.pubaccount.weishi.verticalvideo.f adapter;
        if (N1() && (O0 = O0()) != null && (adapter = O0.getAdapter()) != null && (baseViewHolder instanceof au)) {
            ez.e.c().e(i3, adapter.getDataList(), new a(baseViewHolder));
        }
    }

    private void i0() {
        if (v1()) {
            WSPublicAccReport.getInstance().closePublicAccReport(C0());
            xz.b.f449122a.e(false);
        }
    }

    private void t1(List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> list, com.tencent.biz.pubaccount.weishi.verticalvideo.h hVar, int i3) {
        int N0 = N0(list, com.tencent.biz.pubaccount.weishi.verticalvideo.data.i.o(B0().getItem(i3)));
        if (N0 == -1) {
            A0(list, hVar);
            return;
        }
        List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> a06 = bb.a0(list, 0, N0);
        List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> a07 = bb.a0(list, N0 + 1, list.size());
        X0(a06, hVar);
        K1(a07, hVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean w1(stSimpleMetaFeed stsimplemetafeed) {
        List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> E0 = E0();
        for (int i3 = 0; i3 < E0.size(); i3++) {
            com.tencent.biz.pubaccount.weishi.verticalvideo.data.j jVar = E0.get(i3);
            if (jVar != null && jVar.e() != null && TextUtils.equals(jVar.e().f25129id, stsimplemetafeed.f25129id)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void A0(List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> list, com.tencent.biz.pubaccount.weishi.verticalvideo.h hVar) {
        hVar.c(list);
    }

    public boolean A1() {
        return this.K;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.tencent.biz.pubaccount.weishi.verticalvideo.f B0() {
        com.tencent.biz.pubaccount.weishi.verticalvideo.h O0 = O0();
        if (O0 != null) {
            return O0.getAdapter();
        }
        return null;
    }

    public boolean B1() {
        com.tencent.biz.pubaccount.weishi.verticalvideo.h O0 = O0();
        return O0 != null && O0.D();
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public HashSet<rz.a> C(QBaseActivity qBaseActivity) {
        return null;
    }

    public int C0() {
        return (com.tencent.biz.pubaccount.weishi.report.e.f81528c || this.F) ? 1 : 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void C1(List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> list, boolean z16, boolean z17, Object obj) {
        com.tencent.biz.pubaccount.weishi.verticalvideo.h O0 = O0();
        if (O0 == null) {
            return;
        }
        int H0 = H0(z16, z17, list, obj);
        if (H0 == 0) {
            A0(list, O0);
        } else if (H0 == 1) {
            t1(list, O0, this.I);
        } else if (H0 == 2) {
            X0(list, O0);
        } else if (H0 == 3) {
            K1(list, O0);
        }
        R1(O0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public com.tencent.biz.pubaccount.weishi.verticalvideo.data.j D0() {
        au L0 = L0();
        if (L0 == null) {
            return null;
        }
        return (com.tencent.biz.pubaccount.weishi.verticalvideo.data.j) L0.f82129f;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public Map<String, String> E() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void E1(RecyclerView.ViewHolder viewHolder, int i3) {
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.j jVar;
        com.tencent.biz.pubaccount.weishi.verticalvideo.h O0 = O0();
        if (O0 == null || !(viewHolder instanceof au) || (jVar = (com.tencent.biz.pubaccount.weishi.verticalvideo.data.j) ((au) viewHolder).f82129f) == null || jVar.e().video_type == 2) {
            return;
        }
        com.tencent.biz.qqstory.base.c.a().dispatch(new wz.a(4, Integer.valueOf(i3), jVar, Integer.valueOf(O0.Ue().hashCode())));
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void F(boolean z16) {
        this.C.c(z16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public stSimpleMetaFeed G0(int i3) {
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.j J0 = J0(i3);
        if (J0 != null) {
            return J0.e();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void G1(String str, WSVerticalPageFragment wSVerticalPageFragment, stSimpleMetaFeed stsimplemetafeed, int i3) {
        Map<String, String> h06 = wSVerticalPageFragment.getPresenter().h0();
        h06.put("click_status", String.valueOf(i3));
        com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.p(wSVerticalPageFragment.getFrom(), wSVerticalPageFragment.getPlayScene(), str, 1000001, stsimplemetafeed, h06);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void H(boolean z16, boolean z17, String str) {
        x.j("WSEpisodeChoicePanel", "onLoadData mIsGettingDataList:" + this.E);
        if (this.E) {
            return;
        }
        boolean y06 = y0(z16, z17, str);
        this.E = y06;
        if (z16 || !y06) {
            return;
        }
        this.f82226e.a();
    }

    public void H1(boolean z16) {
        com.tencent.biz.pubaccount.weishi.verticalvideo.f adapter;
        x.j("WS_VIDEO_PLAY_TIME", "[AbsWSVerticalPagePresenter.java][reportVideoPlay] isPlay:" + z16);
        com.tencent.biz.pubaccount.weishi.verticalvideo.h O0 = O0();
        if (O0 == null || (adapter = O0.getAdapter()) == null) {
            return;
        }
        WSPlayerManager y16 = adapter.y();
        if (z16) {
            I1(O0.getFrom(), O0.getPlayScene(), y16);
        } else {
            J1(O0.getFrom(), O0.getPlayScene(), y16);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public boolean J() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.tencent.biz.pubaccount.weishi.verticalvideo.data.j J0(int i3) {
        com.tencent.biz.pubaccount.weishi.verticalvideo.f B0 = B0();
        if (B0 == null || i3 < 0) {
            return null;
        }
        return B0.getItem(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void K1(List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> list, com.tencent.biz.pubaccount.weishi.verticalvideo.h hVar) {
        hVar.setData(list);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public boolean L() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public au L0() {
        com.tencent.biz.pubaccount.weishi.verticalvideo.f B0 = B0();
        if (B0 != null) {
            return B0.z();
        }
        return null;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void M(boolean z16) {
        this.L = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public stSimpleMetaFeed M0() {
        return com.tencent.biz.pubaccount.weishi.verticalvideo.data.i.s(O0());
    }

    protected void M1() {
        com.tencent.biz.pubaccount.weishi.verticalvideo.h hVar = this.f82225d.get();
        if (hVar == null || !x1()) {
            return;
        }
        hVar.ra(-16777216);
    }

    protected boolean N1() {
        return false;
    }

    public com.tencent.biz.pubaccount.weishi.verticalvideo.h O0() {
        WeakReference<com.tencent.biz.pubaccount.weishi.verticalvideo.h> weakReference = this.f82225d;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public boolean O1(boolean z16, boolean z17, List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> list, Object obj) {
        return false;
    }

    public void P0(int i3, String str, boolean z16, boolean z17) {
        com.tencent.biz.pubaccount.weishi.verticalvideo.h O0 = O0();
        if (O0 == null) {
            return;
        }
        this.E = false;
        this.f82226e.b();
        O0.hideLoading();
        O0.A0();
        Q1(i3, str);
        com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.D(null, z16, false, i3, O0.getFrom(), O0.getPlayScene());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void P1(int i3, int i16) {
        com.tencent.biz.pubaccount.weishi.verticalvideo.h O0 = O0();
        if (O0 == null || i3 <= 0) {
            return;
        }
        if (iz.a.g().x(i3, i16)) {
            O0.Yb(i3, i16);
        } else if (iz.a.g().l(i16) == i3) {
            O0.b1(iz.a.g().m(i16));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Q1(int i3, String str) {
        com.tencent.biz.pubaccount.weishi.verticalvideo.h O0 = O0();
        if (O0 == null || O0.getAdapter() == null || !O0.getAdapter().isEmpty()) {
            return;
        }
        O0.O0(i3, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void R0(List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> list) {
        com.tencent.biz.pubaccount.weishi.verticalvideo.h O0 = O0();
        if (O0 == null) {
            return;
        }
        O0.hideLoading();
        O0.A0();
        if (list.size() > 0) {
            F1(list);
            L1(false, true);
            A0(list, O0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void S1(com.tencent.biz.pubaccount.weishi.verticalvideo.data.j jVar, stSimpleMetaFeed stsimplemetafeed) {
        this.f82230m.h(jVar, stsimplemetafeed);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void T0(RecyclerView.ViewHolder viewHolder, int i3) {
        this.I = i3;
        if (i3 > 0) {
            this.F = true;
        }
        com.tencent.biz.pubaccount.weishi.verticalvideo.h O0 = O0();
        if (O0 != null && (viewHolder instanceof au)) {
            au auVar = (au) viewHolder;
            O0.Zf().onVideoSelected((com.tencent.biz.pubaccount.weishi.verticalvideo.data.j) auVar.f82129f, viewHolder.getAdapterPosition());
            com.tencent.biz.pubaccount.weishi.verticalvideo.l lVar = (com.tencent.biz.pubaccount.weishi.verticalvideo.l) auVar.f82115i;
            lVar.y(this.C);
            this.C.a(auVar);
            lVar.x(this.f82229i);
            this.f82229i.l(F0(auVar), i3);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public boolean U() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void V0(List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> list, boolean z16, boolean z17, Object obj) {
        com.tencent.biz.pubaccount.weishi.verticalvideo.h O0 = O0();
        if (O0 == null) {
            return;
        }
        this.E = false;
        this.f82226e.b();
        O0.hideLoading();
        O0.A0();
        if (list.size() > 0) {
            F1(list);
            L1(z16, z17);
            C1(list, z16, z17, obj);
        } else {
            Q1(-1, "");
        }
        com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.D(list, z17, true, -1, O0.getFrom(), O0.getPlayScene());
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void X(String str, WSVerticalPageFragment wSVerticalPageFragment, com.tencent.biz.pubaccount.weishi.verticalvideo.data.j jVar) {
        if (com.tencent.biz.pubaccount.weishi.util.r.v(jVar.e())) {
            com.tencent.biz.pubaccount.weishi.verticalvideo.utils.d.d(str, wSVerticalPageFragment, jVar);
        } else if (com.tencent.biz.pubaccount.weishi.util.r.u(jVar.e().poster)) {
            com.tencent.biz.pubaccount.weishi.verticalvideo.utils.d.e(str, wSVerticalPageFragment, jVar.e());
        } else {
            x0(str, wSVerticalPageFragment, jVar.e());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void X0(List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> list, com.tencent.biz.pubaccount.weishi.verticalvideo.h hVar) {
        hVar.T(list);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public WSAutoShowCommentParams Y() {
        return this.f82228h;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void Z() {
        this.f82226e.d();
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void a0() {
        M1();
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void b(WSSimpleBaseEvent wSSimpleBaseEvent) {
        if (wSSimpleBaseEvent instanceof LikeRspEvent) {
            this.f82227f.g(wSSimpleBaseEvent, O0());
            return;
        }
        if (wSSimpleBaseEvent instanceof FollowEvent) {
            this.f82227f.f(wSSimpleBaseEvent, O0());
            return;
        }
        if (wSSimpleBaseEvent instanceof WSAddCommentEvent) {
            this.f82227f.e(wSSimpleBaseEvent, O0());
            return;
        }
        if (wSSimpleBaseEvent instanceof WSClearModeEvent) {
            Q0(wSSimpleBaseEvent);
        } else if (wSSimpleBaseEvent instanceof WSSpeedPlayEvent) {
            this.f82227f.i((WSSpeedPlayEvent) wSSimpleBaseEvent, O0(), this);
        } else if (wSSimpleBaseEvent instanceof WSSpeedChangeEvent) {
            this.f82227f.h((WSSpeedChangeEvent) wSSimpleBaseEvent, O0(), this);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void c() {
        this.f82226e.e(O0().getPlayScene());
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public int c0() {
        return M;
    }

    @Override // jz.c
    public void d0(final List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> list, final boolean z16, final boolean z17, final Object obj) {
        Runnable runnable = new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter.2
            @Override // java.lang.Runnable
            public void run() {
                AbsWSVerticalPagePresenter.this.V0(list, z16, z17, obj);
            }
        };
        if (Looper.myLooper() != Looper.getMainLooper()) {
            ThreadManager.getUIHandler().post(runnable);
        } else {
            runnable.run();
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.d
    public void destroy() {
        com.tencent.biz.pubaccount.weishi.verticalvideo.h O0 = O0();
        if (O0 != null && O0.U0() != null) {
            O0.U0().e0(A1());
        }
        if (v1()) {
            xz.j.i(true);
        }
        if (!yz.i.f451583a.j()) {
            e0();
        }
        com.tencent.biz.pubaccount.weishi.verticalvideo.onemore.b.a(E0());
        this.C.h();
        if (w0() != null) {
            w0().e();
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void doOnPause() {
        com.tencent.biz.pubaccount.weishi.verticalvideo.h O0 = O0();
        if (y1() && O0 != null && O0.U0() != null) {
            O0.U0().f0();
            H1(false);
        }
        com.tencent.biz.pubaccount.weishi.player.b.d().f(false);
        Z();
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void doOnResume() {
        com.tencent.biz.pubaccount.weishi.verticalvideo.h O0 = O0();
        if (O0 != null && O0.U0() != null && B1()) {
            O0.U0().g0();
            H1(true);
        }
        if (B1()) {
            com.tencent.biz.pubaccount.weishi.player.b.d().f(true);
            g0();
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void g() {
        if (u1()) {
            xz.j.i(yz.i.f451583a.j());
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void g0() {
        if (yz.i.f451583a.j()) {
            xz.j.h();
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public Map<String, String> h0() {
        return new HashMap();
    }

    @Override // jz.c
    public void i(final int i3, final String str, final boolean z16, final boolean z17) {
        Runnable runnable = new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter.3
            @Override // java.lang.Runnable
            public void run() {
                AbsWSVerticalPagePresenter.this.P0(i3, str, z16, z17);
            }
        };
        if (Looper.myLooper() != Looper.getMainLooper()) {
            ThreadManager.getUIHandler().post(runnable);
        } else {
            runnable.run();
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void j() {
        this.f82226e.c(this.I);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public int k0() {
        return N;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public boolean m() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void n(RecyclerView.ViewHolder viewHolder) {
        com.tencent.biz.pubaccount.weishi.verticalvideo.h O0 = O0();
        if (O0 != null && (viewHolder instanceof au)) {
            O0.Zf().onVideoSelectedIdle((com.tencent.biz.pubaccount.weishi.verticalvideo.data.j) ((au) viewHolder).f82129f, viewHolder.getAdapterPosition());
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void p0(String str) {
        x.j("WSEpisodeChoicePanel", "onLoadDataUp mIsGettingDataList:" + this.E);
        if (this.E) {
            return;
        }
        this.E = z0(str);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public int t() {
        return com.tencent.biz.pubaccount.weishi.config.experiment.b.h().l();
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public boolean t0() {
        return true;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void u0(boolean z16) {
        this.K = z16;
    }

    protected boolean u1() {
        return false;
    }

    protected boolean v1() {
        return false;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public com.tencent.biz.pubaccount.weishi.player.e w() {
        return null;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public hz.a w0() {
        if (this.D == null) {
            this.D = new hz.a();
        }
        return this.D;
    }

    @Override // jz.d
    public void x(List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> list) {
        R0(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void x0(String str, WSVerticalPageFragment wSVerticalPageFragment, stSimpleMetaFeed stsimplemetafeed) {
        com.tencent.biz.pubaccount.weishi.verticalvideo.h O0 = O0();
        if (O0 == null) {
            return;
        }
        O0.Zf().onVideoPageHeaderClick(stsimplemetafeed.poster_id);
        G1(str, wSVerticalPageFragment, stsimplemetafeed, 1);
    }

    protected boolean x1() {
        return true;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void y(BaseViewHolder<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> baseViewHolder, int i3) {
        x.i("AbsWSVerticalPagePresenter", "onHandleBindCustomViewHolder");
        W0(baseViewHolder, i3);
    }

    public abstract boolean y0(boolean z16, boolean z17, String str);

    public boolean y1() {
        return this.L;
    }

    protected boolean z0(String str) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean z1() {
        WSPlayerManager U0;
        com.tencent.biz.pubaccount.weishi.verticalvideo.h O0 = O0();
        if (O0 == null || (U0 = O0.U0()) == null) {
            return false;
        }
        if (!U0.z0() && (U0.E0() || U0.D0())) {
            return false;
        }
        x.f("AbsWSVerticalPagePresenter", "[isFirstVideoPlayInvalid] state:" + U0.k0());
        return true;
    }

    private void Q0(WSSimpleBaseEvent wSSimpleBaseEvent) {
        this.J = ((WSClearModeEvent) wSSimpleBaseEvent).isClearMode();
        this.f82227f.d(wSSimpleBaseEvent, O0());
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public boolean V() {
        this.H = true;
        com.tencent.biz.pubaccount.weishi.report.dc898.d.l();
        i0();
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private String F0(au auVar) {
        T t16;
        if (auVar != null && (t16 = auVar.f82129f) != 0 && ((com.tencent.biz.pubaccount.weishi.verticalvideo.data.j) t16).e() != null && ((com.tencent.biz.pubaccount.weishi.verticalvideo.data.j) auVar.f82129f).e().f25129id != null) {
            return ((com.tencent.biz.pubaccount.weishi.verticalvideo.data.j) auVar.f82129f).e().f25129id;
        }
        return "";
    }

    private void I1(String str, String str2, WSPlayerManager wSPlayerManager) {
        if (wSPlayerManager == null || !wSPlayerManager.E0()) {
            return;
        }
        com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.i0(str, str2, wSPlayerManager.n0(), this.I, com.tencent.biz.pubaccount.weishi.verticalvideo.utils.e.k(h0(), L0()));
        this.G = true;
    }

    private void R1(com.tencent.biz.pubaccount.weishi.verticalvideo.h hVar) {
        au z16;
        if (hVar == null || hVar.getAdapter() == null || (z16 = hVar.getAdapter().z()) == null) {
            return;
        }
        this.I = z16.getAdapterPosition();
        x.i("AbsWSVerticalPagePresenter", "updateCurrentPosition() mCurrentPosition = " + this.I);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void D1(List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> list, boolean z16, boolean z17, String str) {
        this.f82230m.e(z16 && !z1(), z17, list, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public stSimpleMetaFeed K0(com.tencent.biz.pubaccount.weishi.verticalvideo.data.j jVar) {
        stSimpleMetaFeed e16;
        if (jVar == null || (e16 = jVar.e()) == null) {
            return null;
        }
        return e16;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void r(String str) {
        H(true, false, str);
    }

    private int N0(List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> list, String str) {
        if (list != null && list.size() != 0 && !TextUtils.isEmpty(str)) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                com.tencent.biz.pubaccount.weishi.verticalvideo.data.j jVar = list.get(i3);
                if (jVar.e() != null && str.equals(jVar.e().f25129id)) {
                    return i3;
                }
            }
        }
        return -1;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void handleIntent(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        this.f82228h = (WSAutoShowCommentParams) bundle.getSerializable("auto_show_comment_params");
    }

    @Override // com.tencent.biz.pubaccount.weishi.d
    public void detachView() {
    }

    protected void e0() {
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void l() {
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void s0() {
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void I(String str) {
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void Q(RecyclerView.ViewHolder viewHolder) {
    }

    @Override // com.tencent.biz.pubaccount.weishi.d
    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public void attachView(com.tencent.biz.pubaccount.weishi.verticalvideo.h hVar) {
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void d(com.tencent.biz.pubaccount.weishi.player.e eVar) {
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void f0(RecyclerView.ViewHolder viewHolder) {
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public int p(int i3) {
        return i3;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void a(com.tencent.biz.pubaccount.weishi.player.e eVar, boolean z16) {
    }
}
