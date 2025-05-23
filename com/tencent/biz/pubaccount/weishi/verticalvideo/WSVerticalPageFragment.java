package com.tencent.biz.pubaccount.weishi.verticalvideo;

import UserGrowth.stGlobalConfig;
import UserGrowth.stSimpleMetaFeed;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi.WSAutoShowCommentParams;
import com.tencent.biz.pubaccount.weishi.WSBaseFragment;
import com.tencent.biz.pubaccount.weishi.WSFollowFragment;
import com.tencent.biz.pubaccount.weishi.comment.WsCommentPresenter;
import com.tencent.biz.pubaccount.weishi.event.FollowEvent;
import com.tencent.biz.pubaccount.weishi.event.LikeRspEvent;
import com.tencent.biz.pubaccount.weishi.event.WSActivityResultEvent;
import com.tencent.biz.pubaccount.weishi.event.WSAddCommentEvent;
import com.tencent.biz.pubaccount.weishi.event.WSBottomBarRefreshEvent;
import com.tencent.biz.pubaccount.weishi.event.WSClearModeEvent;
import com.tencent.biz.pubaccount.weishi.event.WSDramaFollowEvent;
import com.tencent.biz.pubaccount.weishi.event.WSHomeBackBtnClickEvent;
import com.tencent.biz.pubaccount.weishi.event.WSRefreshEvent;
import com.tencent.biz.pubaccount.weishi.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi.event.WSSpeedChangeEvent;
import com.tencent.biz.pubaccount.weishi.event.WSSpeedPlayEvent;
import com.tencent.biz.pubaccount.weishi.event.WSUserAuthEvent;
import com.tencent.biz.pubaccount.weishi.event.WSVerticalPageChangeEvent;
import com.tencent.biz.pubaccount.weishi.main.WSVideoPageChangeDefaultObserver;
import com.tencent.biz.pubaccount.weishi.main.WSVideoPageChangeObserver;
import com.tencent.biz.pubaccount.weishi.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi.util.aj;
import com.tencent.biz.pubaccount.weishi.util.az;
import com.tencent.biz.pubaccount.weishi.util.ba;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.util.p;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.pubaccount.weishi.util.z;
import com.tencent.biz.pubaccount.weishi.verticalvideo.choicepanel.WSEpisodeChoicePanel;
import com.tencent.biz.pubaccount.weishi.verticalvideo.holder.au;
import com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter;
import com.tencent.biz.pubaccount.weishi.verticalvideo.view.WSSwipeRefreshLayout;
import com.tencent.biz.pubaccount.weishi.view.RecyclerViewHelper;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.view.VideoFeedsRecyclerView;
import com.tencent.widget.immersive.SystemBarCompact;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes32.dex */
public class WSVerticalPageFragment extends WSBaseFragment<h, g> implements h, com.tencent.mobileqq.kandian.base.view.widget.a, wz.c, d, SwipeRefreshLayout.OnRefreshListener, com.tencent.biz.pubaccount.weishi.ui.a {
    private static final WSVideoPageChangeObserver B0 = new WSVideoPageChangeDefaultObserver();
    private SystemBarCompact N;
    private WSSwipeRefreshLayout P;
    private VideoFeedsRecyclerView Q;
    private TextView R;
    private ProgressBar S;
    private com.tencent.biz.pubaccount.weishi.e T;
    private com.tencent.biz.pubaccount.weishi.util.k U;
    private ViewStub V;
    private m10.b X;
    private f Y;
    private List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> Z;

    /* renamed from: a0, reason: collision with root package name */
    private WSPlayerManager f81810a0;

    /* renamed from: b0, reason: collision with root package name */
    private m00.a f81811b0;

    /* renamed from: c0, reason: collision with root package name */
    public WsCommentPresenter f81812c0;

    /* renamed from: d0, reason: collision with root package name */
    private com.tencent.biz.pubaccount.weishi.baseui.b<Object> f81813d0;

    /* renamed from: e0, reason: collision with root package name */
    private com.tencent.biz.pubaccount.weishi.baseui.b f81814e0;

    /* renamed from: f0, reason: collision with root package name */
    private com.tencent.biz.pubaccount.weishi.verticalvideo.holder.e f81815f0;

    /* renamed from: g0, reason: collision with root package name */
    private WSEpisodeChoicePanel f81816g0;

    /* renamed from: h0, reason: collision with root package name */
    private com.tencent.biz.pubaccount.weishi.verticalvideo.advcard.f f81817h0;

    /* renamed from: i0, reason: collision with root package name */
    private int f81818i0;

    /* renamed from: j0, reason: collision with root package name */
    private int f81819j0;

    /* renamed from: k0, reason: collision with root package name */
    private String f81820k0;

    /* renamed from: l0, reason: collision with root package name */
    private String f81821l0;

    /* renamed from: m0, reason: collision with root package name */
    private String f81822m0;

    /* renamed from: n0, reason: collision with root package name */
    private String f81823n0;

    /* renamed from: o0, reason: collision with root package name */
    private String f81824o0;

    /* renamed from: p0, reason: collision with root package name */
    private String f81825p0;

    /* renamed from: q0, reason: collision with root package name */
    private boolean f81826q0;

    /* renamed from: r0, reason: collision with root package name */
    private boolean f81827r0;

    /* renamed from: s0, reason: collision with root package name */
    private boolean f81828s0;

    /* renamed from: t0, reason: collision with root package name */
    private boolean f81829t0;

    /* renamed from: u0, reason: collision with root package name */
    private long f81830u0;

    /* renamed from: v0, reason: collision with root package name */
    private long f81831v0;

    /* renamed from: x0, reason: collision with root package name */
    private boolean f81833x0;

    /* renamed from: y0, reason: collision with root package name */
    private boolean f81834y0;

    /* renamed from: z0, reason: collision with root package name */
    private boolean f81835z0;
    private WSVideoPageChangeObserver M = B0;
    private final g00.c W = new g00.c();

    /* renamed from: w0, reason: collision with root package name */
    private long f81832w0 = 0;
    private RecyclerView.OnScrollListener A0 = new b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class a implements WSSwipeRefreshLayout.a {
        a() {
        }

        @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.view.WSSwipeRefreshLayout.a
        public boolean a() {
            return WSVerticalPageFragment.this.getAdapter().I();
        }

        @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.view.WSSwipeRefreshLayout.a
        public boolean b() {
            return WSVerticalPageFragment.this.getAdapter().J();
        }
    }

    /* loaded from: classes32.dex */
    class c implements DialogInterface.OnDismissListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (WSVerticalPageFragment.this.f81810a0 != null) {
                WSVerticalPageFragment.this.f81810a0.g0();
            }
        }
    }

    private void Ai() {
        if (TextUtils.equals("mini_app_personal_main", this.f81820k0)) {
            bb.W("homepage_main");
        } else if (TextUtils.equals("mini_app_personal_guest", this.f81820k0)) {
            bb.W("homepage_guest");
        }
    }

    private boolean Ci(int i3) {
        List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> dataList = this.Y.getDataList();
        x.b("WSVerticalPageFragmentLog", "onCenterViewChanged currentPosition:" + i3 + ", dataList.size:" + dataList.size());
        if (i3 == 0 || (dataList.size() - i3) - 1 >= ((g) this.E).t()) {
            return false;
        }
        x.b("WSVerticalPageFragmentLog", "onPreLoadMore");
        return true;
    }

    private boolean Oh() {
        if (zh()) {
            return false;
        }
        this.f81810a0.f0();
        return true;
    }

    private boolean Ph(boolean z16) {
        com.tencent.biz.pubaccount.weishi.baseui.b<Object> bVar = this.f81813d0;
        if (!(bVar instanceof v10.b) || z16) {
            return z16;
        }
        boolean canShowFloatWindowArea = ((v10.b) bVar).getCanShowFloatWindowArea();
        boolean z17 = false;
        if (this.f81811b0 != null && System.currentTimeMillis() - this.f81811b0.h() < 10000) {
            z17 = true;
        }
        return (canShowFloatWindowArea && z17) ? getPresenter().w0().k() : z16;
    }

    public static WSVerticalPageFragment Rh(Bundle bundle) {
        WSVerticalPageFragment wSVerticalPageFragment = new WSVerticalPageFragment();
        wSVerticalPageFragment.setArguments(bundle);
        return wSVerticalPageFragment;
    }

    private au Xh() {
        f adapter = getAdapter();
        if (adapter != null) {
            return adapter.z();
        }
        return null;
    }

    private com.tencent.biz.pubaccount.weishi.player.e Yh() {
        au Xh = Xh();
        if (Xh != null) {
            return Xh.f82114h;
        }
        return null;
    }

    private void bi() {
        if (getArguments() != null) {
            this.f81821l0 = getArguments().getString("key_play_scene");
            this.f81822m0 = getArguments().getString("key_sub_tab_id");
            this.f81823n0 = getArguments().getString("key_feed_id");
            this.f81831v0 = getArguments().getLong("key_click_open_time");
            this.f81830u0 = getArguments().getLong("key_start_time");
            this.f81828s0 = getArguments().getBoolean("key_cal_delta_time");
            this.f81824o0 = getArguments().getString("share_data_key");
            this.f81825p0 = getArguments().getString("scheme_src_type");
            this.Z = ((g) this.E).N((ArrayList) getArguments().getSerializable("key_feed_list"));
            this.f81818i0 = ((g) this.E).p(getArguments().getInt("key_feed_position"));
            ((g) this.E).handleIntent(getArguments());
        }
    }

    private void di() {
        if (this.f81812c0 == null) {
            x.i("weishi-comment", "initCommentPresenter create!!!");
            WsCommentPresenter wsCommentPresenter = new WsCommentPresenter(this, com.tencent.biz.pubaccount.weishi.verticalvideo.utils.e.h(this.f81820k0));
            this.f81812c0 = wsCommentPresenter;
            wsCommentPresenter.s0(this);
            WSAutoShowCommentParams Y = ((g) this.E).Y();
            if (Y != null) {
                this.f81812c0.p0(Y.getCommentId());
                this.f81812c0.q0(Y.getReplyId());
            }
        }
    }

    private void ei() {
        wz.b.b().d(this);
    }

    private void fi() {
        hz.a w06 = getPresenter().w0();
        if (w06 == null) {
            return;
        }
        w06.d(requireContext(), false);
        w06.o(this);
    }

    private void gi() {
        WSPlayerManager wSPlayerManager = new WSPlayerManager(bb.t());
        this.f81810a0 = wSPlayerManager;
        wSPlayerManager.R0(false);
        this.f81810a0.Q0(false);
        x.j("WSVerticalPageFragmentLog", "[WSVerticalPageFragment.java][initPlayerManager] isPlayerDoOnPause:" + Oh());
    }

    private void initData() {
        ((g) this.E).c();
        ki(false, true);
    }

    private void ni() {
        WsCommentPresenter wsCommentPresenter = this.f81812c0;
        if (wsCommentPresenter != null) {
            wsCommentPresenter.g0();
            this.f81812c0 = null;
        }
    }

    private void ti(boolean z16) {
        g presenter = getPresenter();
        if (presenter instanceof AbsWSVerticalPagePresenter) {
            ((AbsWSVerticalPagePresenter) presenter).H1(z16);
        }
    }

    private void xi() {
        if (TextUtils.equals("aio_home_page", this.f81820k0)) {
            if (this.K) {
                bb.W("feeds_fullscreen");
                return;
            }
            return;
        }
        bb.W(WSPublicAccReport.SOP_NAME_VIDEO_PLAY);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.h
    public void A0() {
        WSSwipeRefreshLayout wSSwipeRefreshLayout = this.P;
        if (wSSwipeRefreshLayout != null) {
            wSSwipeRefreshLayout.setRefreshing(false);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.WSBaseFragment
    protected void Ah() {
        super.Ah();
        xi();
    }

    public void Bi(View view) {
        m00.a aVar = this.f81811b0;
        if (aVar != null) {
            aVar.k(view);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.h
    public void C() {
        VideoFeedsRecyclerView videoFeedsRecyclerView = this.Q;
        if (videoFeedsRecyclerView != null) {
            videoFeedsRecyclerView.stopScroll();
            this.Q.scrollToPosition(0);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.ui.a
    public void Cb() {
        x.j("WSVerticalPageFragmentLog", "[WSVerticalPageFragment.java][onTabSelected]");
        this.K = true;
        WSPlayerManager wSPlayerManager = this.f81810a0;
        if (wSPlayerManager == null) {
            return;
        }
        wSPlayerManager.g0();
        ti(true);
        com.tencent.biz.pubaccount.weishi.player.b.d().f(true);
        xi();
        if (this.f81835z0) {
            return;
        }
        si(this.f81819j0, Xh(), getPresenter().h0());
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.h
    public boolean D() {
        return zh();
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.h
    public com.tencent.biz.pubaccount.weishi.verticalvideo.choicepanel.a De() {
        if (this.f81816g0 == null) {
            this.f81816g0 = WSEpisodeChoicePanel.v(this);
        }
        return this.f81816g0;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.h
    public String Ec() {
        return this.f81822m0;
    }

    public void Ei(boolean z16) {
        com.tencent.biz.pubaccount.weishi.baseui.b<Object> bVar = this.f81813d0;
        if (bVar instanceof v10.g) {
            ((v10.g) bVar).I(z16, this.f81811b0);
        }
    }

    public void Fi(boolean z16) {
        com.tencent.biz.pubaccount.weishi.baseui.b<Object> bVar = this.f81813d0;
        if (bVar instanceof v10.g) {
            ((v10.g) bVar).K(z16);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.d
    public void H0(int i3) {
        getPresenter().F(true);
        if (this.f81810a0 != null) {
            boolean z16 = !getPresenter().m() && com.tencent.biz.pubaccount.weishi.config.experiment.b.h().H();
            this.f81810a0.Q0(z16);
            if (this.f81810a0.y0()) {
                if (z16) {
                    WSPlayerManager wSPlayerManager = this.f81810a0;
                    wSPlayerManager.L0(wSPlayerManager.n0(), false);
                } else {
                    vi();
                }
            }
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.d
    public void K1(int i3) {
        getPresenter().F(false);
        WSPlayerManager wSPlayerManager = this.f81810a0;
        if (wSPlayerManager != null) {
            wSPlayerManager.Q0(true);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.h
    public boolean K3(boolean z16) {
        if (!xz.j.b(getBaseActivity())) {
            return false;
        }
        com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.F(this.f81810a0.k0(), getFrom(), getPlayScene(), Th(), ((g) this.E).h0());
        com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.j0(getFrom(), getPlayScene(), this.f81810a0.n0(), false, this.f81819j0, null);
        yz.i.f451583a.k(this.Y.getDataList(), this.f81819j0);
        ((g) this.E).u0(!z16);
        ((g) this.E).M(!z16);
        ((g) this.E).s0();
        xz.k kVar = new xz.k();
        xz.d dVar = new xz.d();
        dVar.p(getFrom());
        dVar.q(com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.n(getFrom()));
        dVar.k(this.f81810a0.E0());
        dVar.l(this.f81810a0.k0());
        dVar.o(this.f81810a0.j0());
        dVar.s(com.tencent.biz.pubaccount.weishi.verticalvideo.utils.e.n(this.Y.getDataList(), this.f81819j0));
        dVar.n(z16);
        if (z16) {
            com.tencent.biz.pubaccount.weishi.player.e n06 = this.f81810a0.n0();
            if (n06 != null) {
                n06.f81136l = null;
                n06.f81125a = null;
            }
            dVar.m(n06);
        }
        boolean k3 = kVar.k(getActivity(), dVar);
        getPresenter().w0().m(true);
        getBaseActivity().doOnBackPressed();
        return k3;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.h
    public void Ld() {
        WSPlayerManager wSPlayerManager = this.f81810a0;
        if (wSPlayerManager == null) {
            return;
        }
        wSPlayerManager.Q0(this.f81833x0);
        x.j("WSVerticalPageFragmentLog", "onEntireViewEndDrag() mIsPlayLoopBeforeDrag = " + this.f81833x0);
    }

    @Override // com.tencent.mobileqq.kandian.base.view.widget.a
    public void Lg(RecyclerView.ViewHolder viewHolder) {
        x.f("WSVerticalPageFragmentLog", "[WSVerticalPageFragment][onCenterViewIdle]");
        ((g) this.E).n(viewHolder);
    }

    @Override // v00.b
    public void O0(int i3, String str) {
        if (this.f81814e0 == null) {
            i iVar = new i(getActivity(), this);
            this.f81814e0 = iVar;
            iVar.r(this.V);
        }
        this.V.setVisibility(0);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.h
    public TextView Qc() {
        return this.R;
    }

    @Override // com.tencent.biz.pubaccount.weishi.b
    /* renamed from: Qh, reason: merged with bridge method [inline-methods] */
    public g V() {
        return m.w(this.f81820k0, this);
    }

    public void Sh(com.tencent.biz.pubaccount.weishi.verticalvideo.data.j jVar) {
        if (this.f81817h0 == null) {
            this.f81817h0 = new com.tencent.biz.pubaccount.weishi.verticalvideo.advcard.f();
        }
        this.f81817h0.f(getContext(), jVar);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.h
    public void T(List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> list) {
        this.Y.H(list);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.h
    public List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> T9() {
        return this.Z;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.h
    public stSimpleMetaFeed Tc() {
        f fVar = this.Y;
        if (fVar == null || fVar.getDataList() == null || this.Y.getDataList().size() <= 0) {
            return null;
        }
        return this.Y.getDataList().get(0).e();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public stSimpleMetaFeed Th() {
        T t16;
        au Xh = Xh();
        if (Xh == null || (t16 = Xh.f82129f) == 0) {
            return null;
        }
        return ((com.tencent.biz.pubaccount.weishi.verticalvideo.data.j) t16).e();
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.h
    public WSPlayerManager U0() {
        return this.f81810a0;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.h
    public WsCommentPresenter Ue() {
        return this.f81812c0;
    }

    public int Vh() {
        return this.f81818i0;
    }

    public com.tencent.biz.pubaccount.weishi.player.e Wh() {
        return ((g) this.E).w();
    }

    @Override // com.tencent.biz.pubaccount.weishi.ui.a
    public void Y0() {
        x.j("WSVerticalPageFragmentLog", "[WSVerticalPageFragment.java][onTabUnselected]");
        this.K = false;
        WSPlayerManager wSPlayerManager = this.f81810a0;
        if (wSPlayerManager == null) {
            return;
        }
        wSPlayerManager.f0();
        ti(false);
        this.X.f(this.f81810a0.n0());
    }

    @Override // com.tencent.mobileqq.kandian.base.view.widget.a
    public void Y9(RecyclerView.ViewHolder viewHolder) {
        x.b("WSVerticalPageFragmentLog", "onCenterViewChanged: " + viewHolder);
        if (viewHolder instanceof com.tencent.biz.pubaccount.weishi.verticalvideo.holder.e) {
            com.tencent.biz.pubaccount.weishi.verticalvideo.holder.e eVar = (com.tencent.biz.pubaccount.weishi.verticalvideo.holder.e) viewHolder;
            u10.b.b(getFrom(), getPlayScene(), Th());
            int layoutPosition = eVar.getLayoutPosition() - 1;
            this.f81819j0 = layoutPosition;
            this.Y.P(eVar, layoutPosition);
            ((g) this.E).T0(eVar, this.f81819j0);
            eVar.d(this.f81819j0);
            if (Ci(this.f81819j0)) {
                ki(false, false);
            } else if (Di(this.f81819j0)) {
                li();
            }
            if (D()) {
                si(this.f81819j0, eVar, ((g) this.E).h0());
            }
            com.tencent.biz.pubaccount.weishi.verticalvideo.holder.e eVar2 = this.f81815f0;
            if (eVar2 != null && eVar2 != viewHolder) {
                eVar2.e(this.f81819j0);
            }
            this.f81815f0 = eVar;
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.h
    public void Yb(int i3, int i16) {
        if (this.U == null) {
            this.U = new com.tencent.biz.pubaccount.weishi.util.k();
        }
        if (this.f81827r0) {
            return;
        }
        this.f81827r0 = true;
        this.U.c(this, i3, i16);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.h
    public WSVideoPageChangeObserver Zf() {
        return this.M;
    }

    public String Zh() {
        return this.f81825p0;
    }

    public void a(com.tencent.biz.pubaccount.weishi.player.e eVar, boolean z16) {
        ((g) this.E).a(eVar, z16);
    }

    public m00.a ai() {
        return this.f81811b0;
    }

    @Override // wz.c
    public void b(WSSimpleBaseEvent wSSimpleBaseEvent) {
        ((g) this.E).b(wSSimpleBaseEvent);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.h
    public void b1(stGlobalConfig stglobalconfig) {
        if (this.T == null) {
            com.tencent.biz.pubaccount.weishi.e eVar = new com.tencent.biz.pubaccount.weishi.e(getActivity(), 1, com.tencent.biz.pubaccount.weishi.verticalvideo.utils.e.l(this.f81820k0), com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.l(this.f81820k0));
            this.T = eVar;
            eVar.setOnDismissListener(new c());
        }
        if (this.f81826q0) {
            return;
        }
        this.f81826q0 = true;
        this.T.i0(stglobalconfig);
        this.T.k0(getActivity());
        WSPlayerManager wSPlayerManager = this.f81810a0;
        if (wSPlayerManager != null) {
            wSPlayerManager.f0();
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.WSBaseFragment, com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void beforeFinish() {
        super.beforeFinish();
        m10.b bVar = this.X;
        if (bVar != null) {
            bVar.e(Yh());
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.h
    public void c(List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> list) {
        this.Y.fillList(list);
    }

    public void d(com.tencent.biz.pubaccount.weishi.player.e eVar) {
        this.X.j(eVar);
        ((g) this.E).d(eVar);
        if (this.f81834y0) {
            return;
        }
        this.f81834y0 = true;
        Mh(this.f81812c0, ((g) this.E).Y());
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.h
    public f getAdapter() {
        return this.Y;
    }

    @Override // wz.c
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(LikeRspEvent.class);
        arrayList.add(FollowEvent.class);
        arrayList.add(WSUserAuthEvent.class);
        arrayList.add(WSAddCommentEvent.class);
        arrayList.add(WSClearModeEvent.class);
        arrayList.add(WSDramaFollowEvent.class);
        arrayList.add(WSBottomBarRefreshEvent.class);
        arrayList.add(WSRefreshEvent.class);
        arrayList.add(WSHomeBackBtnClickEvent.class);
        arrayList.add(WSSpeedPlayEvent.class);
        arrayList.add(WSSpeedChangeEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.h
    public String getFrom() {
        return this.f81820k0;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.h
    public String getIntentFeedId() {
        return this.f81823n0;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.h
    public String getPlayScene() {
        return this.f81821l0;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.h
    public WSSwipeRefreshLayout getRefreshLayout() {
        return this.P;
    }

    @Override // v00.b
    public void hideLoading() {
        this.S.setVisibility(8);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.h
    public boolean isFinishing() {
        return getActivity() != null && getActivity().isFinishing();
    }

    public boolean ji() {
        return ((g) this.E).L();
    }

    public void ki(boolean z16, boolean z17) {
        ((g) this.E).H(z16, z17, this.f81820k0);
    }

    public void li() {
        ((g) this.E).p0(this.f81820k0);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.h
    public String mg() {
        return this.f81824o0;
    }

    public void mi(com.tencent.biz.pubaccount.weishi.verticalvideo.data.j jVar, int i3) {
        this.X.c(jVar, i3, this.f81820k0, this.f81821l0);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.h
    public void n2(String str) {
        com.tencent.biz.pubaccount.weishi.x.g(getActivity(), str);
    }

    @Override // com.tencent.biz.pubaccount.weishi.WSBaseFragment, com.tencent.biz.pubaccount.weishi.j.b
    public void o0(boolean z16, boolean z17) {
        super.o0(z16, z17);
        if (z17) {
            return;
        }
        if (z16) {
            Cb();
            com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.O(com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.l(this.f81820k0), this.f81821l0, getPresenter().h0());
            getPresenter().g0();
        } else {
            Y0();
            com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.P(com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.l(this.f81820k0), this.f81821l0, getPresenter().h0());
        }
        getPresenter().F(z16);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.h
    public void od() {
        WSPlayerManager wSPlayerManager = this.f81810a0;
        if (wSPlayerManager == null) {
            return;
        }
        this.f81833x0 = wSPlayerManager.B0();
        this.f81810a0.Q0(true);
        x.j("WSVerticalPageFragmentLog", "onEntireViewStartDrag() mIsPlayLoopBeforeDrag = " + this.f81833x0);
    }

    public void oi() {
        com.tencent.biz.pubaccount.weishi.baseui.b<Object> bVar = this.f81813d0;
        if (bVar instanceof v10.b) {
            ((v10.b) bVar).A();
        }
        wz.b.b().a(new WSVerticalPageChangeEvent());
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        wz.b.b().a(new WSActivityResultEvent(i3, i16, intent));
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        WsCommentPresenter wsCommentPresenter = this.f81812c0;
        boolean Ph = Ph(wsCommentPresenter != null ? wsCommentPresenter.d0() : false);
        P p16 = this.E;
        if (p16 != 0 && !Ph) {
            Ph = ((g) p16).V();
        }
        return Ph || super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ba.B(configuration, "WSVerticalPageFragment");
        f fVar = this.Y;
        if (fVar != null) {
            fVar.O();
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.WSBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        x.j("WSVerticalPageFragmentLog", "[WSVerticalPageFragment.java][onCreate] savedInstanceState:" + bundle + ", getArguments():" + getArguments());
        this.f81832w0 = System.currentTimeMillis();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("\u8fdb\u5165\u64ad\u653e\u9875\u7684\u65f6\u95f4\uff1a");
        sb5.append(this.f81832w0);
        x.i("weishi-beacon", sb5.toString());
        if (getArguments() != null) {
            this.f81820k0 = getArguments().getString("key_from");
        }
        super.onCreate(bundle);
        ((g) this.E).g();
        if (getActivity() instanceof PublicFragmentActivity) {
            this.N = SystemBarActivityModule.getSystemBarComp((PublicFragmentActivity) getActivity());
        }
        bi();
        m10.b bVar = new m10.b();
        this.X = bVar;
        bVar.d(this.f81820k0, this.f81821l0, this.f81831v0, this.f81830u0, this.f81828s0);
        com.tencent.biz.pubaccount.weishi.report.dc898.d.b(getFrom(), com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.l(this.f81820k0), getPlayScene());
        Nh(getArguments(), Uh(T9()));
    }

    @Override // com.tencent.biz.pubaccount.weishi.WSBaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        x.j("WSVerticalPageFragmentLog", "[WSVerticalPageFragment.java][onDestroyView]");
        ((g) this.E).destroy();
        VideoFeedsRecyclerView videoFeedsRecyclerView = this.Q;
        if (videoFeedsRecyclerView != null) {
            videoFeedsRecyclerView.p();
            this.Q = null;
        }
        this.f81810a0 = null;
        Ai();
        wz.b.b().f(this);
        k00.e.e().j();
        ni();
        f fVar = this.Y;
        if (fVar != null && fVar.C() != null) {
            Iterator<au> it = this.Y.C().iterator();
            while (it.hasNext()) {
                au next = it.next();
                if (next != null) {
                    next.r();
                }
            }
        }
        VideoFeedsRecyclerView videoFeedsRecyclerView2 = this.Q;
        if (videoFeedsRecyclerView2 != null) {
            videoFeedsRecyclerView2.removeOnScrollListener(this.A0);
        }
        z.a(getActivity());
    }

    @Override // com.tencent.biz.pubaccount.weishi.WSBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        au z16;
        super.onPause();
        if (az.f81725a.booleanValue()) {
            x.j("WSVerticalPageFragmentLog", "[WSVerticalPageFragment.java][onPause] from show shareDialog");
            return;
        }
        x.j("WSVerticalPageFragmentLog", "[WSVerticalPageFragment.java][onPause]");
        this.X.g(Yh());
        ((g) this.E).doOnPause();
        f fVar = this.Y;
        if (fVar != null && fVar.z() != null && (z16 = this.Y.z()) != null) {
            z16.s();
        }
        ((g) this.E).Z();
    }

    @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
    public void onRefresh() {
        x.b("WSVerticalPageFragmentLog", "[WSVerticalPageFragment.java][onRefresh]");
        r0();
    }

    @Override // com.tencent.biz.pubaccount.weishi.WSBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        au z16;
        super.onResume();
        if (az.f81725a.booleanValue()) {
            x.j("WSVerticalPageFragmentLog", "[WSVerticalPageFragment.java][onResume] from show shareDialog");
            az.f81725a = Boolean.FALSE;
            return;
        }
        x.j("WSVerticalPageFragmentLog", "[WSVerticalPageFragment.java][onResume]");
        com.tencent.biz.pubaccount.weishi.report.dc898.d.c(com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.l(this.f81820k0), getPlayScene());
        ((g) this.E).doOnResume();
        f fVar = this.Y;
        if (fVar != null && fVar.z() != null && (z16 = this.Y.z()) != null) {
            z16.t();
        }
        WSFollowFragment.f80369k0 = false;
        SystemBarCompact systemBarCompact = this.N;
        if (systemBarCompact != null) {
            systemBarCompact.setStatusBarVisible(2, 0);
        }
        if (this.f81832w0 > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.f81832w0;
            this.f81832w0 = 0L;
            x.i("weishi-beacon", "\u64ad\u653e\u9875\u521d\u59cb\u5316\u8017\u65f6\uff1a" + currentTimeMillis);
            com.tencent.biz.pubaccount.weishi.report.g.d().l(true, currentTimeMillis, WSPublicAccReport.SOP_NAME_VIDEO_PLAY, this.f81821l0);
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.W.a(bundle);
        x.f("WSVerticalPageFragmentLog", "[WSVerticalPageFragment.java][onSaveInstanceState] outState:" + bundle);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.K) {
            getPresenter().F(true);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        getPresenter().F(false);
    }

    @Override // com.tencent.biz.pubaccount.weishi.WSBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        x.j("WSVerticalPageFragmentLog", "[WSVerticalPageFragment.java][onViewCreated] savedInstanceState:" + bundle);
        ((g) this.E).a0();
        m10.b bVar = this.X;
        List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> list = this.Z;
        bVar.k((list == null || list.size() <= 0) ? null : this.Z.get(0));
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
        x.f("WSVerticalPageFragmentLog", "[WSVerticalPageFragment.java][onViewStateRestored] savedInstanceState:" + bundle);
        this.W.b(bundle);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.h
    public void pa(com.tencent.biz.pubaccount.weishi.verticalvideo.data.j jVar) {
        this.Y.a0(jVar);
    }

    public void pi(int i3, com.tencent.biz.pubaccount.weishi.player.e eVar) {
        this.X.h(i3, eVar);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.h
    public void qa(com.tencent.biz.pubaccount.weishi.verticalvideo.data.j jVar) {
        au Xh = Xh();
        if (Xh == null) {
            return;
        }
        Object obj = Xh.f82127d;
        if (obj instanceof com.tencent.biz.pubaccount.weishi.verticalvideo.holder.b) {
            ((com.tencent.biz.pubaccount.weishi.verticalvideo.holder.b) obj).o(jVar);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.h
    public void qb(int i3, Intent intent) {
        getActivity().setResult(i3, intent);
    }

    @Override // com.tencent.biz.pubaccount.weishi.WSBaseFragment
    public HashSet<rz.a> qh() {
        return ((g) this.E).C(getQBaseActivity());
    }

    public void qi() {
        ((g) this.E).l();
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.h
    public void r0() {
        ((g) this.E).I(this.f81820k0);
        ((g) this.E).r(this.f81820k0);
    }

    @Override // v00.b
    public void r4() {
        this.V.setVisibility(8);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.h
    public void ra(int i3) {
        aj.a(getActivity(), i3);
    }

    public void ri(com.tencent.biz.pubaccount.weishi.player.e eVar, int i3, int i16, String str) {
        this.X.i(eVar, i3, i16, str);
    }

    @Override // com.tencent.mobileqq.kandian.base.view.widget.a
    public void s() {
        x.b("WSVerticalPageFragmentLog", "onLoadMore");
    }

    @Override // v00.b
    public void showLoading() {
        this.S.setVisibility(0);
    }

    @Override // com.tencent.biz.pubaccount.weishi.WSBaseFragment
    protected MiniMsgUserParam th() {
        m00.a aVar = new m00.a();
        this.f81811b0 = aVar;
        return aVar.g();
    }

    public void vi() {
        VideoFeedsRecyclerView x16 = x();
        if (x16 == null || x16.y()) {
            return;
        }
        ui(getFrom(), getPlayScene(), this.f81810a0);
        WSPlayerManager wSPlayerManager = this.f81810a0;
        wSPlayerManager.L0(wSPlayerManager.n0(), false);
    }

    public void wi(int i3) {
        com.tencent.biz.pubaccount.weishi.baseui.b<Object> bVar = this.f81813d0;
        if (bVar instanceof v10.f) {
            ((v10.f) bVar).F(i3);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.h
    public VideoFeedsRecyclerView x() {
        return this.Q;
    }

    @Override // com.tencent.biz.pubaccount.weishi.WSBaseFragment
    protected boolean yh() {
        return true;
    }

    @Override // v00.b
    /* renamed from: yi, reason: merged with bridge method [inline-methods] */
    public void setData(List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> list) {
        this.Y.p(list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void si(int i3, BaseViewHolder baseViewHolder, Map<String, String> map) {
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.j jVar;
        this.f81835z0 = true;
        if ((baseViewHolder instanceof au) && (jVar = (com.tencent.biz.pubaccount.weishi.verticalvideo.data.j) ((au) baseViewHolder).f82129f) != null && (jVar.e() instanceof stSimpleMetaFeed)) {
            stSimpleMetaFeed e16 = jVar.e();
            if (TextUtils.equals(com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.l(this.f81820k0), "feeds_fullscreen")) {
                com.tencent.biz.pubaccount.weishi.report.dc898.d.k();
            }
            com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.f0(this.f81820k0, this.f81821l0, i3, e16, map);
        }
    }

    /* loaded from: classes32.dex */
    class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
            super.onScrollStateChanged(recyclerView, i3);
            if (i3 == 0) {
                if (!RecyclerViewHelper.d(recyclerView)) {
                    WSVerticalPageFragment.this.f81829t0 = false;
                }
                WSVerticalPageFragment.this.getPresenter().f0(WSVerticalPageFragment.this.Q.getChildViewHolder(WSVerticalPageFragment.this.Q.q()));
                z.c("weishi_video_play_list");
            } else {
                WSVerticalPageFragment.this.getPresenter().Q(WSVerticalPageFragment.this.Q.r());
                z.b(WSVerticalPageFragment.this.getActivity(), "weishi_video_play_list");
            }
            x.j("WSVerticalPageFragmentLog", "[WSVerticalPageFragment][onScrollStateChanged] newState:" + i3);
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i3, int i16) {
            boolean z16 = false;
            int top = (recyclerView == null || recyclerView.getChildCount() == 0) ? 0 : recyclerView.getChildAt(0).getTop();
            WSSwipeRefreshLayout wSSwipeRefreshLayout = WSVerticalPageFragment.this.P;
            if (top >= 0 && ((WSBaseFragment) WSVerticalPageFragment.this).E != null && ((g) ((WSBaseFragment) WSVerticalPageFragment.this).E).J()) {
                z16 = true;
            }
            wSSwipeRefreshLayout.setEnabled(z16);
            WSVerticalPageFragment wSVerticalPageFragment = WSVerticalPageFragment.this;
            if (wSVerticalPageFragment.ci(wSVerticalPageFragment.Y) && RecyclerViewHelper.d(recyclerView) && !WSVerticalPageFragment.this.f81829t0) {
                WSVerticalPageFragment.this.f81829t0 = true;
                WSVerticalPageFragment.this.getPresenter().j();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ci(f fVar) {
        return (fVar == null || fVar.C() == null || fVar.C().size() == 0) ? false : true;
    }

    public stSimpleMetaFeed Uh(List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> list) {
        if (list == null || list.size() == 0 || list.get(0) == null) {
            return null;
        }
        return list.get(0).e();
    }

    private void hi(View view) {
        VideoFeedsRecyclerView videoFeedsRecyclerView = (VideoFeedsRecyclerView) view.findViewById(R.id.f125317lq);
        this.Q = videoFeedsRecyclerView;
        videoFeedsRecyclerView.setEnableFooterView(false);
        this.Q.setExtraFooterCount(1);
        TextView g16 = com.tencent.biz.pubaccount.weishi.verticalvideo.utils.e.g(this.Q, getContext());
        this.R = g16;
        this.Q.addFooterView(g16);
        e eVar = new e(getActivity(), this.Q, 1, false);
        this.Q.setLayoutManager(eVar);
        f fVar = new f(getActivity(), this);
        this.Y = fVar;
        fVar.V(this.f81810a0);
        this.Q.setAdapter(this.Y);
        this.Q.n(this);
        this.Q.addOnScrollListener(this.A0);
        List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> list = this.Z;
        if (list != null && list.size() > 0) {
            this.Y.fillList(this.Z);
        } else {
            showLoading();
        }
        eVar.scrollToPosition(this.f81818i0);
    }

    private void ii(View view) {
        this.P = (WSSwipeRefreshLayout) view.findViewById(R.id.f29340ld);
        this.P.setProgressViewOffset(true, 0, ba.f81746u + p.m(getActivity()));
        this.P.setOnRefreshListener(this);
        this.P.setOnInterceptTouchEventListener(new a());
    }

    private void initUI(View view) {
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.f116816zr);
        com.tencent.biz.pubaccount.weishi.baseui.b<Object> a16 = v10.j.a(this, this.f81820k0);
        this.f81813d0 = a16;
        if (a16 != null) {
            a16.r(viewStub);
        }
        this.V = (ViewStub) view.findViewById(R.id.f116676zd);
        this.S = (ProgressBar) view.findViewById(R.id.f116886zy);
        gi();
        ii(view);
        hi(view);
    }

    private void ui(String str, String str2, WSPlayerManager wSPlayerManager) {
        if (wSPlayerManager == null) {
            return;
        }
        f fVar = this.Y;
        if (fVar != null && fVar.z() != null) {
            com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.j0(str, str2, wSPlayerManager.n0(), true, this.Y.z().getAdapterPosition() - 1, com.tencent.biz.pubaccount.weishi.verticalvideo.utils.e.k(((g) this.E).h0(), Xh()));
        }
        wSPlayerManager.N0();
    }

    public void zi(WSVideoPageChangeObserver wSVideoPageChangeObserver) {
        if (wSVideoPageChangeObserver == null) {
            return;
        }
        this.M = wSVideoPageChangeObserver;
    }

    private boolean Di(int i3) {
        if (i3 == 0 || i3 + 1 >= ((g) this.E).t()) {
            return false;
        }
        x.b("WSVerticalPageFragmentLog", "onPreLoadMoreUp");
        return true;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fwc, viewGroup, false);
        x.j("WSVerticalPageFragmentLog", "[WSVerticalPageFragment.java][onCreateView] savedInstanceState:" + bundle);
        initUI(inflate);
        initData();
        di();
        ei();
        fi();
        return inflate;
    }

    private void Mh(WsCommentPresenter wsCommentPresenter, WSAutoShowCommentParams wSAutoShowCommentParams) {
        if (wsCommentPresenter == null || wSAutoShowCommentParams == null) {
            return;
        }
        if (!wSAutoShowCommentParams.getIsShowCommentPanel()) {
            x.j("WSVerticalPageFragmentLog", "no auto show comment panel.");
        } else {
            wsCommentPresenter.w0();
        }
    }

    private void Nh(Bundle bundle, stSimpleMetaFeed stsimplemetafeed) {
        if (bundle == null || stsimplemetafeed == null) {
            return;
        }
        boolean z16 = bundle.getBoolean("key_is_show_open_ws_dialog", false);
        x.j("WSVerticalPageFragmentLog", "isShowOpenWSDialog = " + z16);
        if (z16) {
            q00.b n3 = com.tencent.biz.pubaccount.weishi.config.experiment.b.h().n();
            n3.m(stsimplemetafeed.weishi_jump_url);
            p00.b.c(getContext(), n3, p00.c.b(stsimplemetafeed, com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.l(this.f81820k0), this.f81822m0, this.f81821l0));
        }
    }

    @Override // com.tencent.mobileqq.kandian.base.view.widget.a
    public void L2(RecyclerView.ViewHolder viewHolder, boolean z16) {
    }
}
