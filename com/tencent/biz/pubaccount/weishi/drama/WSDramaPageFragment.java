package com.tencent.biz.pubaccount.weishi.drama;

import UserGrowth.stDramaFeed;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ProgressBar;
import com.tencent.biz.pubaccount.weishi.WSBaseFragment;
import com.tencent.biz.pubaccount.weishi.drama.WSDramaMiddlePart;
import com.tencent.biz.pubaccount.weishi.event.WSDramaVideoExposureEvent;
import com.tencent.biz.pubaccount.weishi.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi.player.i;
import com.tencent.biz.pubaccount.weishi.util.ao;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.view.VideoFeedsRecyclerView;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* loaded from: classes32.dex */
public class WSDramaPageFragment extends WSBaseFragment<c, b> implements c, com.tencent.mobileqq.kandian.base.view.widget.a, wz.c, WSDramaMiddlePart.d {
    private com.tencent.biz.pubaccount.weishi.baseui.b<Object> M;
    private SystemBarCompact N;
    private VideoFeedsRecyclerView P;
    private ProgressBar Q;
    private ViewStub R;
    private ViewStub S;
    private ViewStub T;
    private WSDramaMiddlePart U;
    private oz.f V;
    private String W;
    private String X;
    private String Y;
    private String Z;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f80670b0;

    /* renamed from: d0, reason: collision with root package name */
    private com.tencent.biz.pubaccount.weishi.baseui.b<Object> f80672d0;

    /* renamed from: e0, reason: collision with root package name */
    private a f80673e0;

    /* renamed from: f0, reason: collision with root package name */
    private WSPlayerManager f80674f0;

    /* renamed from: g0, reason: collision with root package name */
    private pz.a f80675g0;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f80669a0 = true;

    /* renamed from: c0, reason: collision with root package name */
    private final g00.c f80671c0 = new g00.c();

    private void Dh(String str, String str2) {
        if (!"aio_red_dot".equals(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        ao.e(getContext(), "biz_src_jc_gzh_weishi", str2);
    }

    private static Intent Eh(e eVar) {
        Bundle bundle = new Bundle();
        bundle.putString("from", eVar.g());
        bundle.putString("drama_id", eVar.c());
        bundle.putString("episode_id", eVar.f());
        bundle.putString("drama_jump_schema", eVar.d());
        bundle.putString("sub_tab_id", eVar.h());
        bundle.putInt("cur_episode_num", eVar.b());
        bundle.putInt("drama_num", eVar.e());
        Intent intent = new Intent();
        intent.putExtras(bundle);
        return intent;
    }

    private void Gh() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.W = arguments.getString("from");
            this.X = arguments.getString("drama_id");
            this.Y = arguments.getString("drama_jump_schema");
            this.Z = arguments.getString("sub_tab_id");
        }
    }

    private void Ih() {
        wz.b.b().d(this);
    }

    private void Jh() {
        WSPlayerManager wSPlayerManager = new WSPlayerManager(bb.t());
        this.f80674f0 = wSPlayerManager;
        wSPlayerManager.R0(false);
        this.f80674f0.Q0(false);
    }

    private boolean Mh(stDramaFeed stdramafeed, pz.b bVar) {
        return TextUtils.equals(stdramafeed.feed.f25129id, i.y(bVar.i()));
    }

    private boolean Nh(pz.a aVar, pz.a aVar2) {
        if ((aVar instanceof pz.b) && (aVar2 instanceof pz.b)) {
            return i.E(((pz.b) aVar).i(), ((pz.b) aVar2).i());
        }
        return false;
    }

    public static void Vh(e eVar) {
        x.f("WSDramaPageFragmentLog", "[WSDramaPageFragment.java][start] params:" + eVar);
        PublicFragmentActivity.b.a(eVar.a(), Eh(eVar), PublicFragmentActivity.class, WSDramaPageFragment.class);
    }

    @Override // com.tencent.biz.pubaccount.weishi.WSBaseFragment
    protected void Ah() {
        super.Ah();
        if (this.K) {
            bb.W("drama_preview");
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.drama.c
    public pz.a Bd() {
        return this.f80675g0;
    }

    @Override // com.tencent.biz.pubaccount.weishi.b
    /* renamed from: Fh, reason: merged with bridge method [inline-methods] */
    public b V() {
        return new sz.c();
    }

    @Override // v00.b
    public void O0(int i3, String str) {
        x.f("WSDramaPageFragmentLog", "[WSDramaPageFragment.java][showError] code:" + i3 + ", msg:" + str);
        if (this.f80672d0 == null) {
            d dVar = new d(getActivity(), this);
            this.f80672d0 = dVar;
            dVar.r(this.R);
        }
        this.R.setVisibility(0);
    }

    public void Oh(boolean z16, boolean z17) {
        ((b) this.E).U0(z17, z16);
    }

    public void Ph(pz.a aVar) {
        tz.a.r(vz.a.f(aVar), vz.a.g(aVar), vz.a.d(aVar), vz.a.c(aVar), this.W, vz.a.i(aVar));
    }

    @Override // v00.b
    /* renamed from: Th, reason: merged with bridge method [inline-methods] */
    public void setData(List<mz.d> list) {
        this.f80673e0.p(list);
        this.U.E(list);
    }

    @Override // com.tencent.biz.pubaccount.weishi.drama.c
    public WSPlayerManager U0() {
        return this.f80674f0;
    }

    public void Uh(boolean z16) {
        this.f80669a0 = z16;
    }

    @Override // com.tencent.biz.pubaccount.weishi.drama.c
    public boolean X() {
        return this.f80670b0;
    }

    @Override // com.tencent.mobileqq.kandian.base.view.widget.a
    public void Y9(RecyclerView.ViewHolder viewHolder) {
        int layoutPosition = viewHolder.getLayoutPosition() - 1;
        x.j("WSDramaPageFragmentLognel-log", "[WSDramaPageFragment.java][onCenterViewChanged] currentPosition:" + layoutPosition + ", viewHolder:" + viewHolder);
        if (viewHolder instanceof pz.a) {
            pz.a aVar = (pz.a) viewHolder;
            if (Nh(aVar, this.f80673e0.r())) {
                x.f("WSDramaPageFragmentLog", "[WSDramaPageFragment.java][onCenterViewChanged]");
                return;
            }
            this.f80675g0 = aVar;
            this.X = aVar.f428078f.d();
            this.U.V(aVar, layoutPosition);
            this.f80673e0.s(aVar, layoutPosition);
            ((b) this.E).T0(aVar, layoutPosition);
            this.V.H(aVar, layoutPosition);
            aVar.e(layoutPosition);
            showLoading();
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.drama.c
    public void a(com.tencent.biz.pubaccount.weishi.player.e eVar, boolean z16) {
        ((b) this.E).a(eVar, z16);
    }

    @Override // wz.c
    public void b(WSSimpleBaseEvent wSSimpleBaseEvent) {
        ((b) this.E).b(wSSimpleBaseEvent);
    }

    @Override // com.tencent.biz.pubaccount.weishi.drama.c
    public void c(List<mz.d> list) {
        this.f80673e0.fillList(list);
        this.U.E(list);
    }

    @Override // com.tencent.biz.pubaccount.weishi.drama.c
    public void d(com.tencent.biz.pubaccount.weishi.player.e eVar) {
        x.i("WSDramaPageFragmentLognel-log", "[WSDramaPageFragment.java][onVideoStarted]");
        ((b) this.E).d(eVar);
        hideLoading();
        this.U.S();
    }

    @Override // com.tencent.biz.pubaccount.weishi.drama.WSDramaMiddlePart.d
    public void fd(mz.d dVar, int i3) {
        x.i("WSDramaPageFragmentLognel-log", "[WSDramaPageFragment.java][onDramaSelected] dramaId:" + dVar.d());
        this.f80670b0 = false;
        this.X = dVar.d();
        this.P.scrollToPosition(i3);
    }

    @Override // com.tencent.biz.pubaccount.weishi.drama.c
    public a getAdapter() {
        return this.f80673e0;
    }

    @Override // wz.c
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(WSDramaVideoExposureEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.pubaccount.weishi.drama.c
    public String getFrom() {
        return this.W;
    }

    @Override // v00.b
    public void hideLoading() {
        this.Q.setVisibility(8);
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        super.initWindowStyleAndAnimation(activity);
        activity.overridePendingTransition(R.anim.f154869su, R.anim.f154868st);
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    @Override // com.tencent.biz.pubaccount.weishi.drama.c
    public String k0() {
        return this.X;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        if (i3 == 4097 && i16 == 8194) {
            intent.getIntExtra("current_episode_num", 0);
            int intExtra = intent.getIntExtra("key_feed_position", 0);
            Hh(this.f80673e0.r(), intent.getStringExtra("key_from"), intent.getStringExtra("key_play_scene"), intExtra);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.WSBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Gh();
        super.onCreate(bundle);
        if (getActivity() instanceof PublicFragmentActivity) {
            this.N = SystemBarActivityModule.getSystemBarComp((PublicFragmentActivity) getActivity());
        }
        Dh(this.W, this.Y);
    }

    @Override // com.tencent.biz.pubaccount.weishi.WSBaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        ((b) this.E).destroy();
        VideoFeedsRecyclerView videoFeedsRecyclerView = this.P;
        if (videoFeedsRecyclerView != null) {
            videoFeedsRecyclerView.p();
        }
        WSPlayerManager wSPlayerManager = this.f80674f0;
        if (wSPlayerManager != null) {
            wSPlayerManager.e0(true);
            this.f80674f0 = null;
        }
        kz.c.d().h();
    }

    @Override // com.tencent.biz.pubaccount.weishi.WSBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        x.j("WSDramaPageFragmentLog", "[WSDramaPageFragment.java][onPause]");
        ((b) this.E).doOnPause();
        if (this.f80669a0) {
            this.f80674f0.f0();
            this.f80669a0 = true;
        }
        Qh(false);
        com.tencent.biz.pubaccount.weishi.player.b.d().f(false);
        tz.a.p(this.W);
    }

    @Override // com.tencent.biz.pubaccount.weishi.WSBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        x.j("WSDramaPageFragmentLog", "[WSDramaPageFragment.java][onResume]");
        SystemBarCompact systemBarCompact = this.N;
        if (systemBarCompact != null) {
            systemBarCompact.setStatusBarVisible(2, 0);
        }
        this.f80669a0 = true;
        ((b) this.E).doOnResume();
        this.f80674f0.g0();
        Qh(true);
        com.tencent.biz.pubaccount.weishi.player.b.d().f(true);
        tz.a.o(this.W);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f80671c0.a(bundle);
        x.f("WSDramaPageFragmentLog", "[WSDramaPageFragment.java][onSaveInstanceState] outState:" + bundle);
    }

    @Override // com.tencent.biz.pubaccount.weishi.WSBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ((b) this.E).c();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
        x.f("WSDramaPageFragmentLog", "[WSDramaPageFragment.java][onViewStateRestored] savedInstanceState:" + bundle);
        this.f80671c0.b(bundle);
    }

    @Override // com.tencent.biz.pubaccount.weishi.WSBaseFragment
    public HashSet<rz.a> qh() {
        HashSet<rz.a> hashSet = new HashSet<>();
        oz.f z16 = oz.f.z(this.T, this, this.W);
        this.V = z16;
        hashSet.add(z16);
        WSDramaMiddlePart B = WSDramaMiddlePart.B(this, this.S, getArguments());
        this.U = B;
        hashSet.add(B);
        this.U.e0(this);
        return hashSet;
    }

    @Override // v00.b
    public void r4() {
        this.R.setVisibility(8);
    }

    @Override // v00.b
    public void showLoading() {
        this.Q.setVisibility(0);
    }

    @Override // com.tencent.biz.pubaccount.weishi.drama.WSDramaMiddlePart.d
    public void uf(stDramaFeed stdramafeed) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[WSDramaPageFragment.java][onDramaFeedReceive] dramaFeed:");
        sb5.append(stdramafeed == null ? null : stdramafeed.toString());
        x.i("WSDramaPageFragmentLognel-log", sb5.toString());
        x.i("WSDramaPageFragmentLognel-log", "[WSDramaPageFragment.java][onDramaFeedReceive] getIntentDramaId:" + k0());
        if (stdramafeed == null || !TextUtils.equals(stdramafeed.dramaID, k0())) {
            return;
        }
        x.i("WSDramaPageFragmentLognel-log", "[WSDramaPageFragment.java][onDramaFeedReceive] feedDramaId:" + stdramafeed.dramaID + ", curDramaId:" + k0());
        pz.a aVar = this.f80675g0;
        if (aVar instanceof pz.b) {
            pz.b bVar = (pz.b) aVar;
            if (Mh(stdramafeed, bVar)) {
                x.f("WSDramaPageFragmentLog", "[WSDramaPageFragment.java][onDramaFeedReceive] sameVideo!");
                return;
            }
            this.f80673e0.x();
            mz.d dVar = bVar.f428078f;
            dVar.m(stdramafeed);
            dVar.n(stdramafeed.feed);
            bVar.g(stdramafeed.feed, bVar.getAdapterPosition(), getFrom());
            Ph(bVar);
            this.f80673e0.u(bVar);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.drama.WSDramaMiddlePart.d
    public void x3(stDramaFeed stdramafeed) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[WSDramaPageFragment.java][onDramaPreloadFeedReceive] dramaFeed:");
        sb5.append(stdramafeed == null ? null : stdramafeed.toString());
        x.i("WSDramaPageFragmentLognel-log", sb5.toString());
        if (stdramafeed == null) {
            return;
        }
        com.tencent.biz.pubaccount.weishi.cache.e.b(stdramafeed.feed);
    }

    @Override // com.tencent.biz.pubaccount.weishi.drama.c
    public void S0(com.tencent.biz.pubaccount.weishi.player.e eVar) {
        this.f80670b0 = true;
        ((b) this.E).S0(eVar);
        this.U.a0();
    }

    @Override // com.tencent.biz.pubaccount.weishi.drama.WSDramaMiddlePart.d
    public void V6(nz.f fVar, int i3) {
        this.f80670b0 = false;
        this.f80673e0.x();
    }

    private void Rh(WSPlayerManager wSPlayerManager) {
        if (wSPlayerManager == null || !wSPlayerManager.E0()) {
            return;
        }
        vz.a.l(this, wSPlayerManager.n0(), false);
    }

    private void Sh(WSPlayerManager wSPlayerManager) {
        if (wSPlayerManager != null) {
            if (wSPlayerManager.E0() || wSPlayerManager.D0()) {
                vz.a.m(this, wSPlayerManager.n0(), false);
                wSPlayerManager.N0();
            }
        }
    }

    public void Qh(boolean z16) {
        if (z16) {
            Rh(this.f80674f0);
        } else {
            Sh(this.f80674f0);
        }
    }

    private void Kh(View view) {
        this.P = (VideoFeedsRecyclerView) view.findViewById(R.id.f792549_);
        this.P.setLayoutManager(new com.tencent.biz.pubaccount.weishi.verticalvideo.e(getActivity(), this.P, 0, false));
        this.P.setEnableHeaderView(false);
        a aVar = new a(getActivity(), this);
        this.f80673e0 = aVar;
        aVar.v(this.f80674f0);
        this.P.setAdapter(this.f80673e0);
        this.P.n(this);
    }

    private void Lh(View view) {
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.f1193676n);
        com.tencent.biz.pubaccount.weishi.baseui.b<Object> a16 = uz.b.a(this, this.W);
        this.M = a16;
        if (a16 != null) {
            a16.r(viewStub);
        }
    }

    private void initView(View view) {
        this.R = (ViewStub) view.findViewById(R.id.f11914762);
        this.Q = (ProgressBar) view.findViewById(R.id.f235206n);
        this.S = (ViewStub) view.findViewById(R.id.f1181773f);
        this.T = (ViewStub) view.findViewById(R.id.f11807736);
        Lh(view);
        Jh();
        Kh(view);
        showLoading();
    }

    public void Hh(pz.b bVar, String str, String str2, int i3) {
        com.tencent.biz.pubaccount.weishi.player.e f16;
        if (bVar == null || (f16 = kz.c.d().f()) == null || f16.f81129e == null || f16.f81126b == null || bVar.i() == null || this.f80674f0 == null) {
            return;
        }
        bVar.i().f81129e = f16.f81129e;
        bVar.i().f81126b = f16.f81126b;
        bVar.i().f81137m = f16.f81137m;
        bVar.i().f81129e.u0(false);
        this.f80673e0.w(bVar);
        com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.j0(str, str2, bVar.i(), false, i3, null);
        this.f80674f0.a1(bVar.i(), true);
        x.i("WSDramaPageFragmentLog", "[WSDramaPageFragment.java][handleOnActivityResultFromVertical], title: " + bVar.i().f81127c.f81175j + ", playingHolder: " + bVar);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fw7, viewGroup, false);
        initView(inflate);
        Ih();
        return inflate;
    }

    @Override // com.tencent.mobileqq.kandian.base.view.widget.a
    public void s() {
    }

    @Override // com.tencent.mobileqq.kandian.base.view.widget.a
    public void Lg(RecyclerView.ViewHolder viewHolder) {
    }

    @Override // com.tencent.mobileqq.kandian.base.view.widget.a
    public void L2(RecyclerView.ViewHolder viewHolder, boolean z16) {
    }
}
