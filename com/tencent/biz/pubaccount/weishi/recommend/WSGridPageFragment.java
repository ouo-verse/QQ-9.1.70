package com.tencent.biz.pubaccount.weishi.recommend;

import UserGrowth.stGlobalConfig;
import UserGrowth.stNotificationRsp;
import UserGrowth.stPopWindowsConfig;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import b10.a;
import com.tencent.biz.pubaccount.weishi.WSBaseFragment;
import com.tencent.biz.pubaccount.weishi.drama.WSDramaPageFragment;
import com.tencent.biz.pubaccount.weishi.event.FollowEvent;
import com.tencent.biz.pubaccount.weishi.event.LikeRspEvent;
import com.tencent.biz.pubaccount.weishi.event.WSAddCommentEvent;
import com.tencent.biz.pubaccount.weishi.event.WSBottomBarRefreshEvent;
import com.tencent.biz.pubaccount.weishi.event.WSChangeItemViewVisibilityEvent;
import com.tencent.biz.pubaccount.weishi.event.WSDramaFollowEvent;
import com.tencent.biz.pubaccount.weishi.event.WSDramaWatchRecordEvent;
import com.tencent.biz.pubaccount.weishi.event.WSGridAdCardExposeEvent;
import com.tencent.biz.pubaccount.weishi.event.WSRefreshEvent;
import com.tencent.biz.pubaccount.weishi.event.WSSaveFirstItemLocationCoverEvent;
import com.tencent.biz.pubaccount.weishi.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi.k;
import com.tencent.biz.pubaccount.weishi.n;
import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi.report.WSReportDc00898;
import com.tencent.biz.pubaccount.weishi.t;
import com.tencent.biz.pubaccount.weishi.util.ac;
import com.tencent.biz.pubaccount.weishi.util.ba;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.pubaccount.weishi.util.z;
import com.tencent.biz.pubaccount.weishi.v;
import com.tencent.biz.pubaccount.weishi.view.RecyclerViewHelper;
import com.tencent.biz.pubaccount.weishi.view.WSXRecyclerView;
import com.tencent.biz.pubaccount.weishi.view.WeiShiNoticeView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.widget.pull2refresh.BaseAdapter;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import com.tencent.widget.pull2refresh.LoadingMoreHelper;
import com.tencent.widget.pull2refresh.RecyclerViewHeaderViewAdapter;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import com.tencent.widget.pull2refresh.XRecyclerView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes32.dex */
public class WSGridPageFragment extends WSBaseFragment<com.tencent.biz.pubaccount.weishi.recommend.e, com.tencent.biz.pubaccount.weishi.recommend.d> implements com.tencent.biz.pubaccount.weishi.recommend.e, wz.c, com.tencent.biz.pubaccount.weishi.ui.a {
    private ViewGroup M;
    private WSXRecyclerView N;
    private LinearLayout P;
    private WeiShiNoticeView Q;
    private View R;
    private WSGridItemExpose S;
    private stNotificationRsp T;
    private com.tencent.biz.pubaccount.weishi.e U;
    private t V;
    private Context W;
    private View X;
    private b10.a Y;
    private RecyclerView Z;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f81365a0;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f81369e0;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f81370f0;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f81371g0;

    /* renamed from: i0, reason: collision with root package name */
    private boolean f81373i0;

    /* renamed from: j0, reason: collision with root package name */
    private String f81374j0;

    /* renamed from: k0, reason: collision with root package name */
    private String f81375k0;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f81366b0 = false;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f81367c0 = false;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f81368d0 = false;

    /* renamed from: h0, reason: collision with root package name */
    private boolean f81372h0 = false;

    /* renamed from: l0, reason: collision with root package name */
    private final XRecyclerView.RefreshCallback f81376l0 = new b();

    /* renamed from: m0, reason: collision with root package name */
    private final RecyclerView.OnScrollListener f81377m0 = new c();

    /* renamed from: n0, reason: collision with root package name */
    private final t.a f81378n0 = new d();

    /* renamed from: o0, reason: collision with root package name */
    private final k f81379o0 = new f();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WSGridPageFragment.this.ei();
        }
    }

    /* loaded from: classes32.dex */
    class b implements XRecyclerView.RefreshCallback {
        b() {
        }

        @Override // com.tencent.widget.pull2refresh.XRecyclerView.RefreshCallback
        public void endOfRefresh() {
            x.j("WSGridPageFragmentLog", "[WSGridPageFragment.java][endOfRefresh] mSubTabId:" + WSGridPageFragment.this.f81374j0);
            WSGridPageFragment.this.N.backToTopAtOnce();
            wz.b.b().a(new WSGridAdCardExposeEvent(true));
        }

        @Override // com.tencent.widget.pull2refresh.XRecyclerView.RefreshCallback
        public void startLoadMore(XRecyclerView xRecyclerView, int i3) {
            x.j("WSGridPageFragmentLog", "[WSGridPageFragment.java][startLoadMore] mSubTabId:" + WSGridPageFragment.this.f81374j0);
            WSGridPageFragment.this.getPresenter().o1(false, false);
            WSGridPageFragment.this.ti(com.tencent.biz.pubaccount.weishi.config.experiment.b.h().j());
            WSGridPageFragment.this.getPresenter().s();
        }

        @Override // com.tencent.widget.pull2refresh.XRecyclerView.RefreshCallback
        public void startTopRefresh(XRecyclerView xRecyclerView, boolean z16) {
            x.j("WSGridPageFragmentLog", "[WSGridPageFragment.java][startTopRefresh] mSubTabId:" + WSGridPageFragment.this.f81374j0 + ", isMachineRefresh:" + z16 + ", mIsFirstStartMachineRefresh:" + WSGridPageFragment.this.f81365a0);
            WSGridPageFragment.this.getPresenter().n1(xRecyclerView, z16);
            WSGridPageFragment.this.fi();
        }
    }

    /* loaded from: classes32.dex */
    class c extends RecyclerView.OnScrollListener {
        c() {
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
            super.onScrollStateChanged(recyclerView, i3);
            if (i3 == 1) {
                WSGridPageFragment.this.f81367c0 = true;
                ((com.tencent.biz.pubaccount.weishi.recommend.d) ((WSBaseFragment) WSGridPageFragment.this).E).a1();
            }
            if (i3 == 0) {
                z.c("weishi_recommend_list");
            } else {
                z.b(WSGridPageFragment.this.getActivity(), "weishi_recommend_list");
            }
            if (RecyclerViewHelper.b(recyclerView)) {
                WSGridPageFragment.this.getPresenter().c1();
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i3, int i16) {
            super.onScrolled(recyclerView, i3, i16);
            if (WSGridPageFragment.this.f81367c0) {
                WSGridPageFragment.this.getPresenter().e1(g10.b.d(WSGridPageFragment.this.N), i3, i16);
                wz.b.b().a(new WSGridAdCardExposeEvent(false));
            }
        }
    }

    /* loaded from: classes32.dex */
    class d implements t.a {
        d() {
        }

        @Override // com.tencent.biz.pubaccount.weishi.t.a
        public void a(BaseViewHolder<stSimpleMetaFeed> baseViewHolder) {
            int adapterPosition;
            stSimpleMetaFeed item;
            if (WSGridPageFragment.this.getPresenter().l1() && ((WSBaseFragment) WSGridPageFragment.this).K && (item = WSGridPageFragment.this.V.getItem((adapterPosition = baseViewHolder.getAdapterPosition()))) != null) {
                WSGridPageFragment.this.S.m(item, adapterPosition);
                com.tencent.biz.pubaccount.weishi.recommend.data.c.e().a(item);
            }
        }
    }

    /* loaded from: classes32.dex */
    class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WSGridPageFragment.this.V.clearList();
            WSGridPageFragment.this.getPresenter().o1(true, true);
            WSGridPageFragment.this.getPresenter().b1("");
            WSGridPageFragment.this.r4();
            WSGridPageFragment.this.showLoading();
            WSReportDc00898.m(true);
        }
    }

    /* loaded from: classes32.dex */
    class f extends k {
        f() {
        }

        @Override // com.tencent.biz.pubaccount.weishi.k, com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onApplicationBackground() {
            super.onApplicationBackground();
            WSGridPageFragment.this.gi();
        }
    }

    /* loaded from: classes32.dex */
    class g implements ViewTreeObserver.OnGlobalLayoutListener {
        g() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            x.j("WSGridPageFragmentLog", "[WSGridPageFragment.java][onGlobalLayout] mSubTabId:" + WSGridPageFragment.this.f81374j0);
            WSGridPageFragment.this.N.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            WSGridPageFragment wSGridPageFragment = WSGridPageFragment.this;
            wSGridPageFragment.L8(true, wSGridPageFragment.getPresenter().s1());
            WSGridPageFragment.this.ui();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class h implements BaseAdapter.OnItemClickListener {
        h() {
        }

        @Override // com.tencent.widget.pull2refresh.BaseAdapter.OnItemClickListener
        public void onItemClick(View view, int i3) {
            WSGridPageFragment wSGridPageFragment = WSGridPageFragment.this;
            wSGridPageFragment.ni(i3, wSGridPageFragment.Y.getDataList().get(i3));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class i implements a.InterfaceC0084a {
        i() {
        }

        @Override // b10.a.InterfaceC0084a
        public void a(BaseViewHolder<mz.h> baseViewHolder) {
            int adapterPosition;
            mz.h item;
            if (WSGridPageFragment.this.f81372h0 || !WSGridPageFragment.this.D() || (item = WSGridPageFragment.this.Y.getItem((adapterPosition = baseViewHolder.getAdapterPosition()))) == null) {
                return;
            }
            WSGridPageFragment.this.S.h(adapterPosition, item);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void Uh(WSChangeItemViewVisibilityEvent wSChangeItemViewVisibilityEvent) {
        WSXRecyclerView wSXRecyclerView;
        RecyclerViewWithHeaderFooter recyclerView;
        if (this.V == null || (wSXRecyclerView = this.N) == null || (recyclerView = wSXRecyclerView.getRecyclerView()) == null) {
            return;
        }
        boolean z16 = true;
        for (int i3 = 0; i3 < recyclerView.getChildCount(); i3++) {
            RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(recyclerView.getChildAt(i3));
            if (childViewHolder instanceof com.tencent.biz.pubaccount.weishi.recommend.holder.a) {
                T t16 = ((com.tencent.biz.pubaccount.weishi.recommend.holder.a) childViewHolder).f81436e;
                if (t16 instanceof stSimpleMetaFeed) {
                    stSimpleMetaFeed stsimplemetafeed = (stSimpleMetaFeed) t16;
                    if (wSChangeItemViewVisibilityEvent.getIsChangeFirstItem() && z16 && ((com.tencent.biz.pubaccount.weishi.recommend.d) this.E).f1()) {
                        si(childViewHolder, wSChangeItemViewVisibilityEvent.getIsShow());
                        return;
                    } else {
                        if (!TextUtils.isEmpty(wSChangeItemViewVisibilityEvent.getFeedId()) && wSChangeItemViewVisibilityEvent.getFeedId().equals(stsimplemetafeed.f25129id)) {
                            si(childViewHolder, wSChangeItemViewVisibilityEvent.getIsShow());
                            return;
                        }
                        z16 = false;
                    }
                } else {
                    continue;
                }
            }
        }
    }

    public static BaseFragment Vh(String str, boolean z16, boolean z17, String str2, boolean z18) {
        WSGridPageFragment wSGridPageFragment = new WSGridPageFragment();
        wSGridPageFragment.setArguments(Wh(str, z16, z17, str2, z18).getExtras());
        return wSGridPageFragment;
    }

    private static Intent Wh(String str, boolean z16, boolean z17, String str2, boolean z18) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("key_is_multi_sub_tab_page", z16);
        bundle.putBoolean("key_context_feed_show_musk", z18);
        bundle.putString("key_sub_tab_id", str);
        bundle.putBoolean("key_can_init_data", z17);
        bundle.putString("key_context_feed_id", str2);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        return intent;
    }

    private void Yh() {
        b10.a aVar = this.Y;
        if (aVar == null) {
            return;
        }
        this.S.i(aVar.getDataList());
    }

    private View ai() {
        View view = this.X;
        if (view != null) {
            return view;
        }
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.fvy, (ViewGroup) null);
        this.X = inflate;
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.f789148c);
        this.Z = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        b10.a aVar = new b10.a(getContext());
        this.Y = aVar;
        aVar.setOnItemClickListener(new h());
        this.Y.s(bi());
        this.Z.setAdapter(this.Y);
        this.Z.addItemDecoration(new n());
        return this.X;
    }

    private a.InterfaceC0084a bi() {
        return new i();
    }

    private RecyclerViewHeaderViewAdapter ci() {
        RecyclerViewHeaderViewAdapter recyclerViewHeaderViewAdapter;
        WSXRecyclerView wSXRecyclerView = this.N;
        if (wSXRecyclerView == null || wSXRecyclerView.getRecyclerView() == null || (recyclerViewHeaderViewAdapter = (RecyclerViewHeaderViewAdapter) this.N.getRecyclerView().getAdapter()) == null) {
            return null;
        }
        return recyclerViewHeaderViewAdapter;
    }

    private void di() {
        if (getArguments() != null) {
            this.f81369e0 = getArguments().getBoolean("key_is_multi_sub_tab_page");
            this.f81374j0 = getArguments().getString("key_sub_tab_id");
            this.f81371g0 = getArguments().getBoolean("key_can_init_data");
            this.f81375k0 = getArguments().getString("key_context_feed_id");
            this.f81373i0 = getArguments().getBoolean("key_context_feed_show_musk");
            x.j("WSGridPageFragmentLog", "[WSGridPageFragment.java][handleIntent] mSubTabId:" + this.f81374j0 + ", mIsMultiSubTabPage:" + this.f81369e0 + ", mCanInitData:" + this.f81371g0 + ", this:" + this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ei() {
        if (this.T == null) {
            return;
        }
        int b16 = this.Q.b();
        ac.e(this.W, this.T, this.f81374j0);
        WSReportDc00898.t(112, b16, this.T.cid);
        x.j("WSGridPageFragmentLog", "[WSGridPageFragment.java][noticeViewClick] mSubTabId:" + this.f81374j0 + ", jumpUrl" + this.T.jump_url);
        hi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fi() {
        if (this.f81365a0) {
            this.f81365a0 = false;
            return;
        }
        if (!this.f81366b0) {
            this.f81366b0 = true;
        }
        getPresenter().o1(true, false);
        if (!this.f81368d0) {
            getPresenter().b1("");
        }
        if (((com.tencent.biz.pubaccount.weishi.recommend.d) this.E).h1()) {
            ((com.tencent.biz.pubaccount.weishi.recommend.d) this.E).q1();
        }
    }

    private void ii() {
        fz.a d16 = getPresenter().d1();
        if (d16 == null) {
            return;
        }
        d16.d(requireContext(), true);
    }

    private void initData() {
        x.c("WSGridPageFragmentLog", "[WSGridPageFragment.java] initData! mSubTabId:" + this.f81374j0);
        this.f81370f0 = true;
        getPresenter().c();
        this.f81379o0.a(this.f81374j0);
        wz.b.b().d(this);
        oi();
        if (((com.tencent.biz.pubaccount.weishi.recommend.d) this.E).h1()) {
            ((com.tencent.biz.pubaccount.weishi.recommend.d) this.E).q1();
        }
    }

    private void initReport() {
        this.S = new WSGridItemExpose(this.f81374j0);
    }

    private void initViews() {
        li();
        ji();
        ki();
        this.R = this.M.findViewById(R.id.f166496fm3);
        this.P = (LinearLayout) this.M.findViewById(R.id.eep);
        mi(this.M, this.N);
    }

    private void ji() {
        WeiShiNoticeView weiShiNoticeView = (WeiShiNoticeView) LayoutInflater.from(this.W).inflate(R.layout.a4g, (ViewGroup) null);
        this.Q = weiShiNoticeView;
        weiShiNoticeView.setOnClickListener(new a());
    }

    private void ki() {
        this.N = (WSXRecyclerView) this.M.findViewById(R.id.i4l);
        ti(com.tencent.biz.pubaccount.weishi.config.experiment.b.h().k());
        this.N.setRefreshCallback(this.f81376l0);
        this.N.getRecyclerView().addOnScrollListener(this.f81377m0);
        RecyclerViewWithHeaderFooter recyclerView = this.N.getRecyclerView();
        t tVar = new t(getActivity(), recyclerView, this.f81374j0, this.f81375k0);
        this.V = tVar;
        tVar.t(this.f81373i0);
        recyclerView.setAdapter(this.V);
        this.V.u(this.f81378n0);
        v vVar = new v(2, 1);
        vVar.setGapStrategy(0);
        recyclerView.setLayoutManager(vVar);
        recyclerView.setItemAnimator(null);
        recyclerView.addItemDecoration(new n());
    }

    private void li() {
        if (this.L) {
            this.M.setBackgroundColor(this.W.getResources().getColor(R.color.black));
        }
        View findViewById = this.M.findViewById(R.id.f1188775b);
        if (this.f81369e0) {
            findViewById.setVisibility(8);
        } else {
            this.M.setPadding(0, ba.q(getActivity()), 0, 0);
            findViewById.setVisibility(0);
        }
    }

    private void mi(ViewGroup viewGroup, WSXRecyclerView wSXRecyclerView) {
        ((com.tencent.biz.pubaccount.weishi.recommend.d) this.E).j1();
    }

    private void oi() {
        GuardManager guardManager = GuardManager.sInstance;
        if (guardManager != null) {
            guardManager.registerCallBack(this.f81379o0);
        }
    }

    private void pi() {
        getPresenter().r1(this.f81366b0, this.f81367c0);
    }

    private void qi() {
        RecyclerViewWithHeaderFooter recyclerView;
        WSXRecyclerView wSXRecyclerView = this.N;
        if (wSXRecyclerView == null || (recyclerView = wSXRecyclerView.getRecyclerView()) == null) {
            return;
        }
        for (int i3 = 0; i3 < recyclerView.getChildCount(); i3++) {
            RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(recyclerView.getChildAt(i3));
            if (childViewHolder instanceof com.tencent.biz.pubaccount.weishi.recommend.holder.a) {
                com.tencent.biz.pubaccount.weishi.recommend.holder.a aVar = (com.tencent.biz.pubaccount.weishi.recommend.holder.a) childViewHolder;
                com.tencent.biz.pubaccount.weishi.ui.videotransition.c.l(aVar.itemView);
                com.tencent.biz.pubaccount.weishi.ui.videotransition.c.k(com.tencent.biz.pubaccount.weishi.ui.videotransition.c.b(aVar.itemView));
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ti(int i3) {
        LoadingMoreHelper loadMoreLayoutHelper = this.N.getLoadMoreLayoutHelper();
        if (loadMoreLayoutHelper != null) {
            loadMoreLayoutHelper.setPreLoaderCount(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ui() {
        if (this.N.h()) {
            x.i("WSGridPageFragmentLog", "[WSGridPageFragment.java][tryToLoadMoreFeeds] mSubTabId:" + this.f81374j0);
            ti(com.tencent.biz.pubaccount.weishi.config.experiment.b.h().j());
        }
    }

    private void vi() {
        GuardManager guardManager = GuardManager.sInstance;
        if (guardManager != null) {
            guardManager.unregisterCallback(this.f81379o0);
        }
    }

    private void wi(String str, int i3) {
        List<mz.h> dataList;
        mz.h a16;
        b10.a aVar = this.Y;
        if (aVar == null || (a16 = g10.b.a((dataList = aVar.getDataList()), str)) == null || a16.b() >= i3) {
            return;
        }
        a16.i(i3);
        this.Y.notifyItemChanged(dataList.indexOf(a16));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.weishi.WSBaseFragment
    public void Ah() {
        super.Ah();
        if (this.K) {
            bb.W("feeds");
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.recommend.e
    public void C() {
        WSXRecyclerView wSXRecyclerView = this.N;
        if (wSXRecyclerView != null) {
            wSXRecyclerView.backToTopAtOnce();
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.ui.a
    public void Cb() {
        x.j("WSGridPageFragmentLog", "[WSGridPageFragment.java][onTabSelected] mSubTabId:" + this.f81374j0);
        List<stSimpleMetaFeed> dataList = getDataList();
        if (this.f81370f0 && this.V.getItemCount() > 1) {
            com.tencent.biz.pubaccount.weishi.recommend.data.c.e().b(dataList.subList(0, Math.min(g10.b.c(this.N), dataList.size())));
            ui();
        } else {
            Zh();
        }
        D7(dataList, false);
        Yh();
    }

    @Override // com.tencent.biz.pubaccount.weishi.recommend.e
    public boolean D() {
        return this.K;
    }

    @Override // com.tencent.biz.pubaccount.weishi.recommend.e
    public void D7(List<stSimpleMetaFeed> list, boolean z16) {
        this.S.j(list, z16, g10.b.c(this.N));
    }

    @Override // com.tencent.biz.pubaccount.weishi.recommend.e
    public void G7(boolean z16) {
        WSXRecyclerView wSXRecyclerView = this.N;
        if (wSXRecyclerView != null) {
            this.f81365a0 = z16;
            wSXRecyclerView.startMachineRefresh();
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.recommend.e
    public void Ic(stNotificationRsp stnotificationrsp, com.tencent.biz.pubaccount.weishi.net.d dVar) {
        this.T = stnotificationrsp;
        this.Q.a(stnotificationrsp, this.f81374j0);
    }

    @Override // com.tencent.biz.pubaccount.weishi.recommend.e
    public String Id() {
        return this.f81375k0;
    }

    @Override // com.tencent.biz.pubaccount.weishi.recommend.e
    public void Jg() {
        x.j("WSGridPageFragmentLog", "[WSGridPageFragment.java][tryLoadMoreFeeds] mSubTabId:" + this.f81374j0);
        this.N.getViewTreeObserver().addOnGlobalLayoutListener(new g());
    }

    @Override // com.tencent.biz.pubaccount.weishi.recommend.e
    public void L8(boolean z16, boolean z17) {
        x.i("WSGridPageFragmentLog", "loadMoreComplete hasMore:" + z17);
        this.N.loadMoreComplete(true, z17);
    }

    @Override // com.tencent.biz.pubaccount.weishi.recommend.e
    public void M6() {
        this.S.f();
    }

    @Override // v00.b
    public void O0(int i3, String str) {
        x.f("WSGridPageFragmentLog", "[WSGridPageFragment.java][showError] mSubTabId:" + this.f81374j0 + ", code:" + i3 + ", msg:" + str);
        this.P.setVisibility(0);
        WSReportDc00898.m(false);
        this.P.setOnClickListener(new e());
    }

    @Override // com.tencent.biz.pubaccount.weishi.recommend.e
    public boolean U9() {
        FragmentActivity activity = getActivity();
        return activity != null && activity.isFinishing();
    }

    @Override // com.tencent.biz.pubaccount.weishi.recommend.e
    public void We(String str) {
        com.tencent.biz.pubaccount.weishi.z.h(this.W, str);
    }

    @Override // com.tencent.biz.pubaccount.weishi.b
    /* renamed from: Xh, reason: merged with bridge method [inline-methods] */
    public com.tencent.biz.pubaccount.weishi.recommend.d V() {
        return e10.e.b(this.f81374j0);
    }

    @Override // com.tencent.biz.pubaccount.weishi.ui.a
    public void Y0() {
        x.j("WSGridPageFragmentLog", "[WSGridPageFragment.java][onTabUnselected] mSubTabId:" + this.f81374j0);
        getPresenter().Y0();
    }

    @Override // com.tencent.biz.pubaccount.weishi.recommend.e
    public void Za(boolean z16) {
        this.N.pullRefreshCompleted(z16);
    }

    public void Zh() {
        if (this.f81370f0) {
            return;
        }
        initData();
    }

    @Override // wz.c
    public void b(WSSimpleBaseEvent wSSimpleBaseEvent) {
        List<stSimpleMetaFeed> dataList;
        t tVar = this.V;
        if (tVar == null || (dataList = tVar.getDataList()) == null) {
            return;
        }
        if (wSSimpleBaseEvent instanceof LikeRspEvent) {
            g10.a.c((LikeRspEvent) wSSimpleBaseEvent, this.V, dataList);
            return;
        }
        if (wSSimpleBaseEvent instanceof FollowEvent) {
            g10.a.b((FollowEvent) wSSimpleBaseEvent, dataList);
            return;
        }
        if (wSSimpleBaseEvent instanceof WSAddCommentEvent) {
            g10.a.a((WSAddCommentEvent) wSSimpleBaseEvent, dataList);
            return;
        }
        if (wSSimpleBaseEvent instanceof WSDramaFollowEvent) {
            ((com.tencent.biz.pubaccount.weishi.recommend.d) this.E).q1();
            return;
        }
        if (wSSimpleBaseEvent instanceof WSDramaWatchRecordEvent) {
            WSDramaWatchRecordEvent wSDramaWatchRecordEvent = (WSDramaWatchRecordEvent) wSSimpleBaseEvent;
            wi(wSDramaWatchRecordEvent.getDramaId(), wSDramaWatchRecordEvent.getEpisodeNum());
            return;
        }
        if (wSSimpleBaseEvent instanceof WSChangeItemViewVisibilityEvent) {
            Uh((WSChangeItemViewVisibilityEvent) wSSimpleBaseEvent);
            return;
        }
        if (wSSimpleBaseEvent instanceof WSSaveFirstItemLocationCoverEvent) {
            qi();
        } else if (wSSimpleBaseEvent instanceof WSBottomBarRefreshEvent) {
            ((com.tencent.biz.pubaccount.weishi.recommend.d) this.E).i1((WSBottomBarRefreshEvent) wSSimpleBaseEvent);
        } else if (wSSimpleBaseEvent instanceof WSRefreshEvent) {
            ((com.tencent.biz.pubaccount.weishi.recommend.d) this.E).Z0((WSRefreshEvent) wSSimpleBaseEvent);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.recommend.e
    public void b1(stGlobalConfig stglobalconfig) {
        ArrayList<stPopWindowsConfig> arrayList;
        if (com.tencent.biz.pubaccount.weishi.x.e() || stglobalconfig == null || (arrayList = stglobalconfig.windows_config) == null || arrayList.size() == 0) {
            return;
        }
        if (this.U == null) {
            this.U = new com.tencent.biz.pubaccount.weishi.e(getActivity(), 0, 1, "feeds");
        }
        this.U.i0(stglobalconfig);
        this.U.k0(getActivity());
    }

    @Override // com.tencent.biz.pubaccount.weishi.recommend.e
    public void c(List<stSimpleMetaFeed> list) {
        this.V.fillList(list);
    }

    @Override // com.tencent.biz.pubaccount.weishi.recommend.e
    public int e5() {
        return this.S.l();
    }

    @Override // com.tencent.biz.pubaccount.weishi.recommend.e
    public List<stSimpleMetaFeed> getDataList() {
        return this.V.getDataList();
    }

    @Override // wz.c
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(LikeRspEvent.class);
        arrayList.add(FollowEvent.class);
        arrayList.add(WSAddCommentEvent.class);
        arrayList.add(WSChangeItemViewVisibilityEvent.class);
        arrayList.add(WSBottomBarRefreshEvent.class);
        arrayList.add(WSRefreshEvent.class);
        if (((com.tencent.biz.pubaccount.weishi.recommend.d) this.E).h1()) {
            arrayList.add(WSDramaFollowEvent.class);
            arrayList.add(WSDramaWatchRecordEvent.class);
        }
        if (((com.tencent.biz.pubaccount.weishi.recommend.d) this.E).k1()) {
            arrayList.add(WSSaveFirstItemLocationCoverEvent.class);
        }
        return arrayList;
    }

    public void gi() {
        if (U9()) {
            return;
        }
        this.S.s();
    }

    @Override // com.tencent.biz.pubaccount.weishi.recommend.e
    public void h7() {
        RecyclerViewHeaderViewAdapter ci5 = ci();
        if (ci5 != null && ci5.hasHeader(this.X)) {
            ci5.removeHeader(this.X);
            ci5.notifyDataSetChanged();
        }
    }

    @Override // v00.b
    public void hideLoading() {
        this.R.setVisibility(8);
    }

    @Override // com.tencent.biz.pubaccount.weishi.WSBaseFragment, com.tencent.biz.pubaccount.weishi.j.b
    public void o0(boolean z16, boolean z17) {
        super.o0(z16, z17);
        if (z16) {
            ((com.tencent.biz.pubaccount.weishi.recommend.d) this.E).m1();
            WSPublicAccReport.getInstance().reportPageVisitEnter("feeds");
            Cb();
        } else {
            ((com.tencent.biz.pubaccount.weishi.recommend.d) this.E).p1();
            WSPublicAccReport.getInstance().reportPageVisitExit("feeds");
            Y0();
        }
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        P p16;
        super.onActivityResult(i3, i16, intent);
        if (i3 != 4098 || (p16 = this.E) == 0) {
            return;
        }
        ((com.tencent.biz.pubaccount.weishi.recommend.d) p16).g1();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ba.B(configuration, "WSGridPageFragment");
        t tVar = this.V;
        if (tVar != null) {
            tVar.notifyDataSetChanged();
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.WSBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        di();
        super.onCreate(bundle);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        this.W = getActivity();
        View inflate = layoutInflater.inflate(R.layout.a4e, viewGroup, false);
        this.M = (ViewGroup) inflate;
        f10.b.f397582a.h(System.currentTimeMillis() - currentTimeMillis);
        return inflate;
    }

    @Override // com.tencent.biz.pubaccount.weishi.WSBaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        getPresenter().doOnDestroy();
        super.onDestroyView();
        this.f81370f0 = false;
        pi();
        this.S.s();
        this.S.f();
        wz.b.b().f(this);
        vi();
        z.a(getActivity());
        this.X = null;
    }

    @Override // com.tencent.biz.pubaccount.weishi.WSBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        x.j("WSGridPageFragmentLog", "[WSGridPageFragment.java][onResume] onPause:" + this.f81374j0 + ", mIsUserVisibleHint:" + this.K);
        getPresenter().doOnPause();
    }

    @Override // com.tencent.biz.pubaccount.weishi.WSBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        x.j("WSGridPageFragmentLog", "[WSGridPageFragment.java][onResume] mSubTabId:" + this.f81374j0 + ", mIsUserVisibleHint:" + this.K);
        getPresenter().doOnResume();
    }

    @Override // com.tencent.biz.pubaccount.weishi.WSBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        long currentTimeMillis = System.currentTimeMillis();
        x.j("WSGridPageFragmentLog", "[WSGridPageFragment.java][onViewCreated] mCanInitData:" + this.f81371g0 + ", this:" + this);
        initViews();
        initReport();
        if (this.f81371g0) {
            initData();
        }
        ii();
        f10.b.f397582a.i(System.currentTimeMillis() - currentTimeMillis);
    }

    @Override // v00.b
    public void r4() {
        this.P.setVisibility(8);
    }

    @Override // v00.b
    /* renamed from: ri, reason: merged with bridge method [inline-methods] */
    public void setData(List<stSimpleMetaFeed> list) {
        this.V.p(list);
    }

    @Override // v00.b
    public void showLoading() {
        this.R.setVisibility(0);
    }

    @Override // com.tencent.biz.pubaccount.weishi.recommend.e
    public void ub(mz.g gVar, boolean z16) {
        RecyclerViewHeaderViewAdapter ci5 = ci();
        if (ci5 == null) {
            return;
        }
        View ai5 = ai();
        if (!ci5.hasHeader(ai5)) {
            ci5.addHeader(ai5);
        }
        this.Y.fillList(gVar.a());
        this.Z.scrollToPosition(0);
        this.f81372h0 = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.weishi.WSBaseFragment
    public boolean xh() {
        if (uy.a.f440578a.f()) {
            return false;
        }
        return super.xh();
    }

    @Override // com.tencent.biz.pubaccount.weishi.recommend.e
    public void N6() {
        this.f81368d0 = true;
        RecyclerViewHeaderViewAdapter recyclerViewHeaderViewAdapter = (RecyclerViewHeaderViewAdapter) this.N.getRecyclerView().getAdapter();
        Th(recyclerViewHeaderViewAdapter, this.Q, this.X);
        recyclerViewHeaderViewAdapter.notifyDataSetChanged();
    }

    public void hi() {
        this.f81368d0 = false;
        RecyclerViewHeaderViewAdapter recyclerViewHeaderViewAdapter = (RecyclerViewHeaderViewAdapter) this.N.getRecyclerView().getAdapter();
        recyclerViewHeaderViewAdapter.removeHeader(this.Q);
        recyclerViewHeaderViewAdapter.notifyDataSetChanged();
    }

    private void Th(RecyclerViewHeaderViewAdapter recyclerViewHeaderViewAdapter, View view, View view2) {
        if (view2 != null && recyclerViewHeaderViewAdapter.hasHeader(view2)) {
            recyclerViewHeaderViewAdapter.removeHeader(view2);
            recyclerViewHeaderViewAdapter.addHeader(view);
            recyclerViewHeaderViewAdapter.addHeader(view2);
            return;
        }
        recyclerViewHeaderViewAdapter.addHeader(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ni(int i3, mz.h hVar) {
        if (hVar == null) {
            x.i("WSGridPageFragmentLog", "onFollowDramaItemClick() itemData is null.");
        } else {
            com.tencent.biz.pubaccount.weishi.recommend.a.n(this.f81374j0, i3, hVar.d(), hVar.g());
            WSDramaPageFragment.Vh(new com.tencent.biz.pubaccount.weishi.drama.e("grid_drama_follow", getContext()).i(hVar.d()));
        }
    }

    private void si(RecyclerView.ViewHolder viewHolder, boolean z16) {
        View view;
        if (viewHolder == null || (view = viewHolder.itemView) == null) {
            return;
        }
        view.setVisibility(z16 ? 0 : 4);
    }
}
