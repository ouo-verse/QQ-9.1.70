package com.tencent.biz.pubaccount.weishi;

import UserGrowth.stFeed;
import UserGrowth.stFollowFeedsRsp;
import UserGrowth.stSimpleMetaFeed;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.qq.taf.jce.JceStruct;
import com.tencent.biz.pubaccount.weishi.cache.WeiShiCacheManager;
import com.tencent.biz.pubaccount.weishi.comment.WsCommentPresenter;
import com.tencent.biz.pubaccount.weishi.event.FollowEvent;
import com.tencent.biz.pubaccount.weishi.event.LikeRspEvent;
import com.tencent.biz.pubaccount.weishi.event.WSActivityResultEvent;
import com.tencent.biz.pubaccount.weishi.event.WSAddCommentEvent;
import com.tencent.biz.pubaccount.weishi.event.WSBottomBarRefreshEvent;
import com.tencent.biz.pubaccount.weishi.event.WSFriendFeedExposureEvent;
import com.tencent.biz.pubaccount.weishi.event.WSItemExposeEvent;
import com.tencent.biz.pubaccount.weishi.event.WSPlayerMuteEvent;
import com.tencent.biz.pubaccount.weishi.event.WSRefreshEvent;
import com.tencent.biz.pubaccount.weishi.event.WSRequestRefreshEvent;
import com.tencent.biz.pubaccount.weishi.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi.event.WSVideoPlayEvent;
import com.tencent.biz.pubaccount.weishi.holder.WSFollowFeedHolder;
import com.tencent.biz.pubaccount.weishi.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi.player.WSPlayerWrapper;
import com.tencent.biz.pubaccount.weishi.report.WSFollowBeaconReport;
import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi.report.WSReportDc00898;
import com.tencent.biz.pubaccount.weishi.util.ba;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.view.RecyclerViewHelper;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.pull2refresh.BaseAdapter;
import com.tencent.widget.pull2refresh.XRecyclerView;
import java.util.ArrayList;
import java.util.List;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes32.dex */
public class WSFollowFragment extends WSBaseHomeFragment<v00.a, com.tencent.biz.pubaccount.weishi.presenter.c, List<stFeed>> implements v00.a, wz.c, com.tencent.biz.pubaccount.weishi.ui.a {

    /* renamed from: k0, reason: collision with root package name */
    public static boolean f80369k0;
    public WsCommentPresenter S;
    private f T;
    private LinearLayoutManager U;
    private WSPlayerManager V;
    private com.tencent.biz.pubaccount.weishi.holder.f W;
    private LinearLayout X;
    private FrameLayout Y;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f80370a0;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f80371b0;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f80372c0;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f80373d0;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f80374e0;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f80375f0;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f80376g0;

    /* renamed from: h0, reason: collision with root package name */
    private boolean f80377h0;

    /* renamed from: i0, reason: collision with root package name */
    private boolean f80378i0;
    private boolean Z = true;

    /* renamed from: j0, reason: collision with root package name */
    private long f80379j0 = 0;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    private class ActivityResultRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<WSFollowFragment> f80380d;

        /* renamed from: e, reason: collision with root package name */
        private final Intent f80381e;

        ActivityResultRunnable(WSFollowFragment wSFollowFragment, Intent intent) {
            this.f80380d = new WeakReference<>(wSFollowFragment);
            this.f80381e = intent;
        }

        @Override // java.lang.Runnable
        public void run() {
            int intExtra = this.f80381e.getIntExtra("key_feed_position", 0);
            String stringExtra = this.f80381e.getStringExtra("key_from");
            String stringExtra2 = this.f80381e.getStringExtra("key_play_scene");
            RecyclerView.ViewHolder findViewHolderForLayoutPosition = WSFollowFragment.this.P.getRecyclerView().findViewHolderForLayoutPosition(((com.tencent.biz.pubaccount.weishi.presenter.c) WSFollowFragment.this.E).D0());
            com.tencent.biz.pubaccount.weishi.util.x.j("WSFollowContinuePlayLog", "[WSFollowFragment.java][onActivityResult] from vertical getLastPosition:" + ((com.tencent.biz.pubaccount.weishi.presenter.c) WSFollowFragment.this.E).D0() + ", holder:" + findViewHolderForLayoutPosition);
            if (findViewHolderForLayoutPosition instanceof com.tencent.biz.pubaccount.weishi.holder.f) {
                WSFollowFragment.this.Zh((com.tencent.biz.pubaccount.weishi.holder.f) findViewHolderForLayoutPosition, stringExtra, stringExtra2, intExtra);
            }
            WSFollowFragment.this.f80372c0 = false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements com.tencent.biz.pubaccount.weishi.cache.a {
        a() {
        }

        @Override // com.tencent.biz.pubaccount.weishi.cache.a
        public void a(JceStruct jceStruct) {
            if (jceStruct instanceof stFollowFeedsRsp) {
                stFollowFeedsRsp stfollowfeedsrsp = (stFollowFeedsRsp) jceStruct;
                if (com.tencent.biz.pubaccount.weishi.util.r.q(stfollowfeedsrsp.feeds)) {
                    return;
                }
                com.tencent.biz.pubaccount.weishi.util.x.b("WSFollowFragmentLog", "load cache data for follow page, size: " + stfollowfeedsrsp.feeds.size());
                WSFollowFragment.this.hi(stfollowfeedsrsp.feeds);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
            super.onScrollStateChanged(recyclerView, i3);
            if (i3 == 1) {
                WSFollowFragment.this.f80376g0 = true;
            }
            if (i3 == 0) {
                com.tencent.biz.pubaccount.weishi.util.z.c("weishi_follow_list");
            } else {
                com.tencent.biz.pubaccount.weishi.util.z.b(WSFollowFragment.this.getActivity(), "weishi_follow_list");
            }
            if (RecyclerViewHelper.b(recyclerView)) {
                ((com.tencent.biz.pubaccount.weishi.presenter.c) WSFollowFragment.this.E).j();
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i3, int i16) {
            com.tencent.biz.pubaccount.weishi.holder.f Xh;
            super.onScrolled(recyclerView, i3, i16);
            if (WSFollowFragment.this.T.f80706e == null) {
                int findFirstVisibleItemPosition = WSFollowFragment.this.U.findFirstVisibleItemPosition();
                Xh = WSFollowFragment.this.Wh(findFirstVisibleItemPosition, false);
                com.tencent.biz.pubaccount.weishi.util.x.f("WSFollowContinuePlayLog", "mAdapter.mPlayingHolder is null. startPosition:" + findFirstVisibleItemPosition + ", lastOrNextVideoHolder:" + Xh);
            } else {
                WSFollowFragment wSFollowFragment = WSFollowFragment.this;
                Xh = wSFollowFragment.Xh(wSFollowFragment.T.f80706e, i16 > 0, false);
            }
            if (WSFollowFragment.this.fi(Xh)) {
                if (WSFollowFragment.this.f80372c0) {
                    com.tencent.biz.pubaccount.weishi.util.x.f("WSFollowContinuePlayLog", "[WSFollowFragment.java][onScrolled] mIsHandlingBackFromVertical true.");
                    return;
                }
                com.tencent.biz.pubaccount.weishi.util.x.m("WSFollowContinuePlayLog", "[WSFollowFragment.java][onScrolled] playVideo title:" + Xh.f80801d.f81175j + ", mPlayingHolder:" + Xh);
                WSFollowFragment.this.ji(Xh);
                com.tencent.biz.pubaccount.weishi.holder.f Xh2 = WSFollowFragment.this.Xh(Xh, i16 > 0, true);
                com.tencent.biz.pubaccount.weishi.util.x.i("WS_VIDEO_PRE_PLAY", "[WSFollowFragment.java][onScrolled] setPrePlayingHolder prePlayHolder:" + Xh2);
                WSFollowFragment.this.T.C(Xh2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (WSFollowFragment.this.T != null) {
                WSFollowFragment.this.T.clearList();
            }
            ((com.tencent.biz.pubaccount.weishi.presenter.c) WSFollowFragment.this.getPresenter()).B0(true, true);
            WSFollowFragment.this.X.setVisibility(8);
            WSFollowFragment.this.showLoading();
            WSReportDc00898.m(true);
        }
    }

    private void Th() {
        if (this.S == null) {
            this.S = new WsCommentPresenter(this, 0);
            View viewStub = new ViewStub(getBaseActivity());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 80;
            viewStub.setLayoutParams(layoutParams);
            this.Y.addView(viewStub);
        }
    }

    private void Uh(int i3) {
        String str;
        if ("monofeed_tab".equals(uy.b.f440579a.a())) {
            str = WSRequestRefreshEvent.PAGE_WONDER_FOLLOW;
        } else {
            str = WSRequestRefreshEvent.PAGE_DISCOVER_FOLLOW;
        }
        WSRequestRefreshEvent wSRequestRefreshEvent = new WSRequestRefreshEvent(str);
        wSRequestRefreshEvent.setRefreshState(i3);
        wz.b.b().a(wSRequestRefreshEvent);
    }

    private com.tencent.biz.pubaccount.weishi.holder.f Vh(int i3, boolean z16) {
        stFeed stfeed = this.T.getDataList().get(i3);
        if (stfeed.feed_type != 2 || stfeed.feed == null) {
            return null;
        }
        RecyclerView.ViewHolder findViewHolderForLayoutPosition = this.P.getRecyclerView().findViewHolderForLayoutPosition(i3);
        if (!(findViewHolderForLayoutPosition instanceof com.tencent.biz.pubaccount.weishi.holder.f)) {
            return null;
        }
        com.tencent.biz.pubaccount.weishi.holder.f fVar = (com.tencent.biz.pubaccount.weishi.holder.f) findViewHolderForLayoutPosition;
        if (fi(fVar) || z16) {
            return fVar;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.tencent.biz.pubaccount.weishi.holder.f Wh(int i3, boolean z16) {
        if (this.T != null && i3 >= 0) {
            while (i3 < this.T.getDataList().size()) {
                com.tencent.biz.pubaccount.weishi.holder.f Vh = Vh(i3, z16);
                if (Vh != null) {
                    return Vh;
                }
                i3++;
            }
        }
        return null;
    }

    private void ai() {
        wz.b.b().d(this);
    }

    private void bi() {
        WSPlayerManager wSPlayerManager = new WSPlayerManager(bb.t());
        this.V = wSPlayerManager;
        wSPlayerManager.Q0(true);
        this.T.B(this.V);
    }

    private void gi(int i3) {
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = this.P.getRecyclerView().findViewHolderForAdapterPosition(i3);
        if (findViewHolderForAdapterPosition instanceof WSFollowFeedHolder) {
            ((WSFollowFeedHolder) findViewHolderForAdapterPosition).r0();
            return;
        }
        if (findViewHolderForAdapterPosition instanceof com.tencent.biz.pubaccount.weishi.holder.c) {
            ((com.tencent.biz.pubaccount.weishi.holder.c) findViewHolderForAdapterPosition).f();
        } else if (findViewHolderForAdapterPosition instanceof com.tencent.biz.pubaccount.weishi.holder.d) {
            ((com.tencent.biz.pubaccount.weishi.holder.d) findViewHolderForAdapterPosition).e();
        } else if (findViewHolderForAdapterPosition instanceof com.tencent.biz.pubaccount.weishi.holder.a) {
            ((com.tencent.biz.pubaccount.weishi.holder.a) findViewHolderForAdapterPosition).i();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ji(com.tencent.biz.pubaccount.weishi.holder.f fVar) {
        this.W = fVar;
        this.T.A(fVar);
        this.f80371b0 = false;
    }

    private void ki() {
        int childCount = this.P.getRecyclerView().getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            gi(i3);
        }
    }

    private void li() {
        int findFirstVisibleItemPosition = this.U.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = this.U.findLastVisibleItemPosition();
        if (findFirstVisibleItemPosition < 0 || findLastVisibleItemPosition >= this.T.getDataList().size()) {
            return;
        }
        while (findFirstVisibleItemPosition <= findLastVisibleItemPosition) {
            gi(findFirstVisibleItemPosition);
            findFirstVisibleItemPosition++;
        }
    }

    private void mi(boolean z16) {
        f fVar;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[WSFollowFragment.java][reportVideoPlay] tabSelectedIndex:");
        com.tencent.biz.pubaccount.weishi.home.e eVar = com.tencent.biz.pubaccount.weishi.home.e.f80814a;
        sb5.append(eVar.e());
        sb5.append(", isPlay:");
        sb5.append(z16);
        com.tencent.biz.pubaccount.weishi.util.x.j("WS_VIDEO_PLAY_TIME", sb5.toString());
        if (eVar.e() != 0 || (fVar = this.T) == null) {
            return;
        }
        if (z16) {
            ni(fVar.t());
        } else {
            oi(fVar.t());
        }
    }

    private void oi(WSPlayerManager wSPlayerManager) {
        if (this.Z && wSPlayerManager != null && (wSPlayerManager.E0() || wSPlayerManager.D0())) {
            WSFollowBeaconReport.D(wSPlayerManager.n0(), false);
            wSPlayerManager.N0();
        }
        this.Z = false;
    }

    private void showErrorView() {
        com.tencent.biz.pubaccount.weishi.util.x.b("WSFollowFragmentLog", "showErrorView");
        this.X.setVisibility(0);
        WSReportDc00898.m(false);
        this.X.setOnClickListener(new c());
    }

    private void wi() {
        if (!this.f80374e0) {
            com.tencent.biz.pubaccount.weishi.report.e.f81530e = 2;
        } else if (!this.f80375f0 && !this.f80376g0) {
            com.tencent.biz.pubaccount.weishi.report.e.f81530e = 3;
        } else {
            com.tencent.biz.pubaccount.weishi.report.e.f81530e = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.weishi.WSBaseFragment
    public void Ah() {
        super.Ah();
        if (this.K) {
            bb.W(WSPublicAccReport.SOP_NAME_FOCUS);
        }
    }

    @Override // v00.a
    public void C() {
        XRecyclerView xRecyclerView = this.P;
        if (xRecyclerView != null) {
            xRecyclerView.backToTopAtOnce();
        }
    }

    @Override // v00.a
    public void Ca(boolean z16) {
        this.P.pullRefreshCompleted(z16);
        Uh(2);
    }

    @Override // com.tencent.biz.pubaccount.weishi.ui.a
    public void Cb() {
        com.tencent.biz.pubaccount.weishi.util.x.b("WSFollowFragmentLog", "onTabSelected");
        if (this.V == null) {
            return;
        }
        this.f80371b0 = true;
        int findFirstVisibleItemPosition = this.U.findFirstVisibleItemPosition();
        com.tencent.biz.pubaccount.weishi.holder.f fVar = this.W;
        if (fVar == null) {
            fVar = Wh(findFirstVisibleItemPosition, true);
        }
        ii(fVar);
        com.tencent.biz.pubaccount.weishi.player.b.d().f(!r0.C0());
        if (!this.f80377h0) {
            ki();
            this.f80377h0 = true;
        } else {
            li();
        }
    }

    @Override // v00.a
    public boolean D() {
        return this.K;
    }

    @Override // com.tencent.biz.pubaccount.weishi.WSBaseHomeFragment
    protected BaseAdapter Eh() {
        f fVar = new f(this);
        this.T = fVar;
        return fVar;
    }

    @Override // com.tencent.biz.pubaccount.weishi.WSBaseHomeFragment
    protected RecyclerView.LayoutManager Fh() {
        g gVar = new g(this.M, 1, false);
        this.U = gVar;
        return gVar;
    }

    @Override // com.tencent.biz.pubaccount.weishi.WSBaseHomeFragment
    protected void Gh(View view) {
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            view.setPadding(0, ImmersiveUtils.getStatusBarHeight(getBaseActivity()), 0, 0);
        }
        WeiShiCacheManager.O().z(new a());
        bi();
        ai();
        this.Y = (FrameLayout) this.N.findViewById(R.id.xua);
        this.X = (LinearLayout) this.N.findViewById(R.id.eep);
        Th();
        this.P.getRecyclerView().addOnScrollListener(new b());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.pubaccount.weishi.WSBaseHomeFragment
    protected void Hh(XRecyclerView xRecyclerView, int i3) {
        ((com.tencent.biz.pubaccount.weishi.presenter.c) getPresenter()).B0(false, false);
        ((com.tencent.biz.pubaccount.weishi.presenter.c) getPresenter()).s();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.pubaccount.weishi.WSBaseHomeFragment
    protected void Ih(XRecyclerView xRecyclerView, boolean z16) {
        if (!this.f80375f0) {
            this.f80375f0 = true;
        }
        if (!z16) {
            u.d(WSPublicAccReport.SOP_NAME_FOCUS, "0", false);
        }
        ((com.tencent.biz.pubaccount.weishi.presenter.c) getPresenter()).B0(false, true);
    }

    @Override // com.tencent.biz.pubaccount.weishi.b
    /* renamed from: Sh, reason: merged with bridge method [inline-methods] */
    public com.tencent.biz.pubaccount.weishi.presenter.c V() {
        return new com.tencent.biz.pubaccount.weishi.presenter.c();
    }

    @Override // com.tencent.biz.pubaccount.weishi.ui.a
    public void Y0() {
        com.tencent.biz.pubaccount.weishi.util.x.b("WSFollowFragmentLog", "onTabUnSelected");
        WSPlayerManager wSPlayerManager = this.V;
        if (wSPlayerManager == null) {
            return;
        }
        if (wSPlayerManager.E0()) {
            wSPlayerManager.Y0();
        }
        com.tencent.biz.pubaccount.weishi.player.b.d().f(false);
        ((com.tencent.biz.pubaccount.weishi.presenter.c) this.E).Z();
    }

    @Override // v00.a
    public void Z8() {
        XRecyclerView xRecyclerView = this.P;
        if (xRecyclerView != null) {
            xRecyclerView.startMachineRefresh();
        }
    }

    public void Zh(com.tencent.biz.pubaccount.weishi.holder.f fVar, String str, String str2, int i3) {
        WSPlayerWrapper wSPlayerWrapper;
        com.tencent.biz.pubaccount.weishi.player.wrapper.h hVar;
        com.tencent.biz.pubaccount.weishi.player.e eVar;
        com.tencent.biz.pubaccount.weishi.player.e f16 = jz.f.d().f();
        if (f16 == null || fVar == null || (wSPlayerWrapper = f16.f81129e) == null || (hVar = f16.f81126b) == null || (eVar = fVar.f80802e) == null || this.V == null) {
            return;
        }
        eVar.f81129e = wSPlayerWrapper;
        eVar.f81126b = hVar;
        eVar.f81137m = f16.f81137m;
        wSPlayerWrapper.u0(true);
        this.T.f80706e = fVar;
        com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.j0(str, str2, fVar.f80802e, false, i3, null);
        if (!this.f80370a0) {
            WSFollowBeaconReport.C(fVar.f80802e);
        }
        this.T.C(Xh(fVar, true, true));
        this.V.a1(fVar.f80802e, true);
        this.V.T0(1.0f);
        this.V.S0(this.T.E());
        this.Z = true;
        this.f80370a0 = false;
        com.tencent.biz.pubaccount.weishi.util.x.i("WSFollowContinuePlayLog", "WSFollowFragment handleOnActivityResultFromVertical()2, title: " + fVar.f80802e.f81127c.f81175j + ", playingHolder: " + fVar);
    }

    @Override // wz.c
    public void b(WSSimpleBaseEvent wSSimpleBaseEvent) {
        ((com.tencent.biz.pubaccount.weishi.presenter.c) this.E).b(wSSimpleBaseEvent);
    }

    public boolean ci() {
        return this.Z;
    }

    public boolean di() {
        return com.tencent.biz.pubaccount.weishi.config.experiment.b.h().I();
    }

    public boolean ei() {
        return this.f80373d0;
    }

    @Override // v00.a
    public f getAdapter() {
        return this.T;
    }

    @Override // wz.c
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(LikeRspEvent.class);
        arrayList.add(WSVideoPlayEvent.class);
        arrayList.add(WSItemExposeEvent.class);
        arrayList.add(FollowEvent.class);
        arrayList.add(WSAddCommentEvent.class);
        arrayList.add(WSFriendFeedExposureEvent.class);
        arrayList.add(WSPlayerMuteEvent.class);
        arrayList.add(WSBottomBarRefreshEvent.class);
        arrayList.add(WSRefreshEvent.class);
        return arrayList;
    }

    public void hi(List<stFeed> list) {
        hideLoading();
        if (this.X.isShown()) {
            this.X.setVisibility(8);
        }
        f fVar = this.T;
        if (fVar != null) {
            fVar.fillList(list);
        }
        jz.f.d().i(list);
        XRecyclerView xRecyclerView = this.P;
        if (xRecyclerView != null) {
            xRecyclerView.loadMoreComplete(true, true);
        }
    }

    public void ii(com.tencent.biz.pubaccount.weishi.holder.f fVar) {
        if (!this.f80371b0 || fVar == null) {
            return;
        }
        com.tencent.biz.pubaccount.weishi.util.x.l("WSFollowContinuePlayLog", "[WSFollowFragment.java][onPlayFirstVideo] playVideo title:" + fVar.f80801d.f81175j + ", mPlayingHolder:" + fVar);
        ji(fVar);
        com.tencent.biz.pubaccount.weishi.holder.f Xh = Xh(fVar, true, true);
        com.tencent.biz.pubaccount.weishi.util.x.i("WS_VIDEO_PRE_PLAY", "[WSFollowFragment.java][onPlayFirstVideo] setPrePlayingHolder prePlayHolder:" + Xh);
        this.T.C(Xh);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.pubaccount.weishi.WSBaseHomeFragment
    public void loadData() {
        ((com.tencent.biz.pubaccount.weishi.presenter.c) getPresenter()).B0(true, false);
    }

    @Override // v00.a
    public void nd(List<stFeed> list, boolean z16) {
        if (this.X.isShown()) {
            this.X.setVisibility(8);
        }
        this.T.appendList(list);
        cf(true, !z16);
    }

    @Override // com.tencent.biz.pubaccount.weishi.WSBaseFragment, com.tencent.biz.pubaccount.weishi.j.b
    public void o0(boolean z16, boolean z17) {
        super.o0(z16, z17);
        if (z17) {
            return;
        }
        if (z16) {
            Cb();
            WSPublicAccReport.getInstance().reportPageVisitEnter(WSPublicAccReport.SOP_NAME_FOCUS);
        } else {
            Y0();
            WSPublicAccReport.getInstance().reportPageVisitExit(WSPublicAccReport.SOP_NAME_FOCUS);
        }
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        wz.b.b().a(new WSActivityResultEvent(i3, i16, intent));
        if (i3 == 4097 && i16 == 8193) {
            this.f80372c0 = true;
            com.tencent.biz.pubaccount.weishi.util.x.j("WSFollowContinuePlayLog", "[WSFollowFragment.java][onActivityResult] from vertical position:" + intent.getIntExtra("key_feed_position", 0));
            ThreadManager.getUIHandler().postDelayed(new ActivityResultRunnable(this, intent), 100L);
        }
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        WsCommentPresenter wsCommentPresenter = this.S;
        if (wsCommentPresenter != null) {
            return wsCommentPresenter.d0();
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ba.B(configuration, "WSFollowFragment");
        f fVar = this.T;
        if (fVar != null) {
            fVar.notifyDataSetChanged();
        }
        WsCommentPresenter wsCommentPresenter = this.S;
        if (wsCommentPresenter != null) {
            if (wsCommentPresenter.isShowing()) {
                this.S.V();
                this.S.U();
            }
            this.S = null;
            this.Y.removeAllViews();
            Th();
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.WSBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f80379j0 = System.currentTimeMillis();
        this.f80378i0 = com.tencent.biz.pubaccount.weishi.util.r.t();
        com.tencent.biz.pubaccount.weishi.util.x.i("weishi-beacon", "\u8fdb\u5165\u7011\u5e03\u6d41\u7684\u65f6\u95f4\uff1a" + this.f80379j0);
    }

    @Override // com.tencent.biz.pubaccount.weishi.WSBaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        wi();
        WeiShiCacheManager.O().r(this.T.getDataList());
        wz.b.b().f(this);
        k00.e.e().j();
        WSPlayerManager wSPlayerManager = this.V;
        if (wSPlayerManager != null) {
            wSPlayerManager.e0(true);
            this.V = null;
        }
        this.P.getRecyclerView().clearOnScrollListeners();
        com.tencent.biz.pubaccount.weishi.util.z.a(getActivity());
    }

    @Override // com.tencent.biz.pubaccount.weishi.WSBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.K) {
            com.tencent.biz.pubaccount.weishi.player.b.d().f(false);
        }
        WSPlayerManager wSPlayerManager = this.V;
        if (wSPlayerManager != null && !f80369k0) {
            wSPlayerManager.f0();
        }
        mi(false);
        ((com.tencent.biz.pubaccount.weishi.presenter.c) this.E).Z();
    }

    @Override // com.tencent.biz.pubaccount.weishi.WSBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.V != null) {
            if (this.K) {
                com.tencent.biz.pubaccount.weishi.player.b.d().f(!this.V.C0());
            }
            this.V.g0();
            mi(true);
        }
        if (this.f80379j0 > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.f80379j0;
            this.f80379j0 = 0L;
            com.tencent.biz.pubaccount.weishi.util.x.i("weishi-beacon", "\u5173\u6ce8\u9875\u521d\u59cb\u5316\u8017\u65f6\uff1a" + currentTimeMillis);
            com.tencent.biz.pubaccount.weishi.report.g.d().l(true, currentTimeMillis, WSPublicAccReport.SOP_NAME_FOCUS, WSPublicAccReport.SOP_NAME_FOCUS);
        }
    }

    public void ri(boolean z16) {
        this.Z = z16;
    }

    public void si(boolean z16) {
        if (this.K) {
            this.f80371b0 = z16;
        }
    }

    public void ti(boolean z16) {
        this.f80373d0 = z16;
    }

    public boolean ui() {
        return !this.f80378i0 && di();
    }

    public void vi(int i3, stSimpleMetaFeed stsimplemetafeed) {
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = this.P.getRecyclerView().findViewHolderForAdapterPosition(i3);
        if (findViewHolderForAdapterPosition instanceof WSFollowFeedHolder) {
            ((WSFollowFeedHolder) findViewHolderForAdapterPosition).L0(stsimplemetafeed);
        }
    }

    @Override // v00.a
    public XRecyclerView x() {
        return this.P;
    }

    @Override // com.tencent.biz.pubaccount.weishi.WSBaseHomeFragment
    protected void endOfRefresh() {
        this.f80371b0 = true;
    }

    @Override // v00.b
    /* renamed from: pi, reason: merged with bridge method [inline-methods] */
    public void setData(List<stFeed> list) {
        this.f80374e0 = true;
        if (this.X.isShown()) {
            this.X.setVisibility(8);
        }
        this.T.fillList(list);
        cf(true, true);
    }

    public void qi() {
        this.f80378i0 = true;
        com.tencent.biz.pubaccount.weishi.util.r.D();
    }

    private void ni(WSPlayerManager wSPlayerManager) {
        if (wSPlayerManager == null || !wSPlayerManager.E0()) {
            return;
        }
        WSFollowBeaconReport.C(wSPlayerManager.n0());
        this.Z = true;
        this.f80370a0 = true;
    }

    @Override // v00.a
    public void L9(boolean z16, boolean z17, List<stFeed> list, boolean z18) {
        if (!z16 || this.K) {
            return;
        }
        this.f80373d0 = true;
    }

    @Override // v00.a
    public void Xd(boolean z16, boolean z17) {
        f fVar;
        if (z16 && (fVar = this.T) != null && fVar.getDataList().size() == 0) {
            showErrorView();
        }
        if (z17) {
            Uh(-2);
        }
    }

    public com.tencent.biz.pubaccount.weishi.holder.f Xh(com.tencent.biz.pubaccount.weishi.holder.f fVar, boolean z16, boolean z17) {
        if (fVar == null) {
            return null;
        }
        int layoutPosition = fVar.getLayoutPosition();
        if (z16) {
            return Wh(layoutPosition + 1, z17);
        }
        return Yh(layoutPosition - 1, z17);
    }

    @Override // v00.a
    public void cf(boolean z16, boolean z17) {
        if (!z17) {
            this.T.addFooterView(View.inflate(getBaseActivity(), R.layout.fx5, null));
        }
        this.P.loadMoreComplete(z16, z17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean fi(com.tencent.biz.pubaccount.weishi.holder.f fVar) {
        return fVar != null && com.tencent.biz.pubaccount.weishi.util.r.o(fVar.b()) >= 50;
    }

    private com.tencent.biz.pubaccount.weishi.holder.f Yh(int i3, boolean z16) {
        if (i3 < 0) {
            return null;
        }
        while (i3 >= 0) {
            com.tencent.biz.pubaccount.weishi.holder.f Vh = Vh(i3, z16);
            if (Vh != null) {
                return Vh;
            }
            i3--;
        }
        return null;
    }

    @Override // com.tencent.biz.pubaccount.weishi.WSBaseHomeFragment
    protected void Dh(Bundle bundle) {
    }
}
