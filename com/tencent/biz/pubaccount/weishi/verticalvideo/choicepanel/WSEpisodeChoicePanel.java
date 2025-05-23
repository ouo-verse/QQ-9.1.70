package com.tencent.biz.pubaccount.weishi.verticalvideo.choicepanel;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi.util.ba;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.util.r;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi.verticalvideo.data.g;
import com.tencent.biz.pubaccount.weishi.verticalvideo.data.j;
import com.tencent.biz.pubaccount.weishi.verticalvideo.holder.au;
import com.tencent.biz.pubaccount.weishi.view.WSDragLayout;
import com.tencent.biz.pubaccount.weishi.view.WSXRecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.immersive.SystemBarTintManager;
import com.tencent.widget.pull2refresh.LoadingMoreHelper;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import com.tencent.widget.pull2refresh.XRecyclerView;
import java.util.List;
import java.util.Map;
import kz.k;

/* loaded from: classes32.dex */
public class WSEpisodeChoicePanel extends PopupWindow implements com.tencent.biz.pubaccount.weishi.verticalvideo.choicepanel.a, View.OnKeyListener, WSDragLayout.c {
    private static final float K = r.H(10.0f);
    private static final int L = r.H(88.0f);
    private View C;
    private TextView D;
    private TextView E;
    private com.tencent.biz.pubaccount.weishi.verticalvideo.choicepanel.b F;
    private com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.a G;
    private j H;
    private boolean I;
    private final RecyclerView.OnScrollListener J;

    /* renamed from: d, reason: collision with root package name */
    private final WSVerticalPageFragment f81917d;

    /* renamed from: e, reason: collision with root package name */
    private WSDragLayout f81918e;

    /* renamed from: f, reason: collision with root package name */
    private WSXRecyclerView f81919f;

    /* renamed from: h, reason: collision with root package name */
    private RelativeLayout f81920h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f81921i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f81922m;

    /* loaded from: classes32.dex */
    class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i3, int i16) {
            x.j("WSEpisodeChoicePanel", "[WSEpisodeChoicePanel.java] onScrolled");
            super.onScrolled(recyclerView, i3, i16);
            if (((LinearLayoutManager) WSEpisodeChoicePanel.this.f81919f.getRecyclerView().getLayoutManager()).findFirstVisibleItemPosition() >= 10) {
                return;
            }
            WSEpisodeChoicePanel.this.O();
            WSEpisodeChoicePanel.this.L();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WSEpisodeChoicePanel.this.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class d implements XRecyclerView.RefreshCallback {
        d() {
        }

        @Override // com.tencent.widget.pull2refresh.XRecyclerView.RefreshCallback
        public void endOfRefresh() {
            x.j("WSEpisodeChoicePanel", "[WSEpisodeChoicePanel.java][endOfRefresh]");
        }

        @Override // com.tencent.widget.pull2refresh.XRecyclerView.RefreshCallback
        public void startLoadMore(XRecyclerView xRecyclerView, int i3) {
            x.j("WSEpisodeChoicePanel", "[WSEpisodeChoicePanel.java][startLoadMore]");
            WSEpisodeChoicePanel.this.K(false, false);
        }

        @Override // com.tencent.widget.pull2refresh.XRecyclerView.RefreshCallback
        public void startTopRefresh(XRecyclerView xRecyclerView, boolean z16) {
            x.j("WSEpisodeChoicePanel", "[WSEpisodeChoicePanel.java][startTopRefresh]");
            WSEpisodeChoicePanel.this.L();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WSEpisodeChoicePanel.this.M();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class f implements kz.a<Integer> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f81929a;

        f(boolean z16) {
            this.f81929a = z16;
        }

        @Override // kz.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Integer num) {
            WSEpisodeChoicePanel.this.V(num.intValue() == 1);
        }

        @Override // kz.a
        public void onFailure(int i3, String str) {
            if (this.f81929a) {
                return;
            }
            QQToast.makeText(WSEpisodeChoicePanel.this.y(), 1, WSEpisodeChoicePanel.this.y().getResources().getString(R.string.f169723x83), 0).show();
        }
    }

    WSEpisodeChoicePanel(WSVerticalPageFragment wSVerticalPageFragment) {
        super(LayoutInflater.from(wSVerticalPageFragment.getActivity()).inflate(R.layout.d0k, (ViewGroup) null, false), -1, -1);
        this.I = false;
        this.J = new a();
        this.f81917d = wSVerticalPageFragment;
        G();
        I();
        H();
        F();
    }

    private XRecyclerView.RefreshCallback C() {
        return new d();
    }

    private j D() {
        if (B() == null || B().O0().getAdapter().getDataList().size() == 0) {
            return null;
        }
        return B().O0().getAdapter().getDataList().get(0);
    }

    private int E() {
        this.H = D();
        if (J() && com.tencent.biz.pubaccount.weishi.config.experiment.b.h().K()) {
            this.C.setVisibility(0);
            boolean z16 = this.H.d().b().dramaInfo.isFollowed;
            int i3 = z16 ? 2 : 1;
            V(z16);
            return i3;
        }
        this.C.setVisibility(8);
        return 0;
    }

    private void F() {
        this.C = getContentView().findViewById(R.id.f163251p41);
        this.D = (TextView) getContentView().findViewById(R.id.p79);
        TextView textView = (TextView) getContentView().findViewById(R.id.p78);
        this.E = textView;
        textView.setOnClickListener(new e());
    }

    private void I() {
        View contentView = getContentView();
        contentView.setOnKeyListener(this);
        b bVar = new b();
        contentView.setOnClickListener(bVar);
        contentView.findViewById(R.id.p3i).setOnClickListener(bVar);
        RelativeLayout relativeLayout = (RelativeLayout) contentView.findViewById(R.id.p6q);
        this.f81920h = relativeLayout;
        relativeLayout.setBackgroundDrawable(ba.b(K));
        this.f81921i = (TextView) contentView.findViewById(R.id.p3p);
        this.f81922m = (TextView) contentView.findViewById(R.id.p3o);
        this.f81918e = (WSDragLayout) contentView.findViewById(R.id.p3k);
        this.f81919f = (WSXRecyclerView) contentView.findViewById(R.id.p3t);
        this.f81918e.setDisableMinScrollY(true);
        this.f81918e.setControlLitTongue(false);
        this.f81919f.setPullHeaderBgDrawable(new ColorDrawable(-16777216));
        this.f81918e.setContentView(this.f81919f.getRecyclerView());
        this.f81918e.setTouchListener(this);
        this.f81918e.setMode(1);
    }

    private boolean J() {
        j jVar = this.H;
        return (jVar == null || jVar.d() == null || this.H.d().b() == null || this.H.d().b().dramaInfo == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        int i3;
        int i16;
        if (!bb.E() && J()) {
            g d16 = this.H.d();
            boolean z16 = d16.b().dramaInfo.isFollowed;
            if (z16) {
                i3 = 2;
                i16 = 1003038;
            } else {
                i3 = 1;
                i16 = 1003030;
            }
            P(i3, i16);
            k.a(d16.a(), i3, new f(z16));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        int size = this.F.getDataList().size();
        int findLastVisibleItemPosition = ((LinearLayoutManager) this.f81919f.getRecyclerView().getLayoutManager()).findLastVisibleItemPosition();
        boolean b26 = B().b2();
        boolean a26 = B().a2();
        int p16 = this.F.p();
        x.j("WSEpisodeChoicePanel", "[WSEpisodeChoicePanel.java][preloadData] checkedPosition:" + p16 + ", loadMoreUpFinish:" + b26 + ", loadMoreDownFinish:" + a26);
        if (a26 && b26) {
            return;
        }
        if (!a26 && (b26 || p16 != 1 || size < 6)) {
            if (this.F.getDataList().size() - findLastVisibleItemPosition <= 10) {
                x.j("WSEpisodeChoicePanel", "[WSEpisodeChoicePanel.java][preloadData] loadDataDown");
                this.f81919f.getLoadMoreLayoutHelper().setLoadMore(true);
                return;
            }
            return;
        }
        x.j("WSEpisodeChoicePanel", "[WSEpisodeChoicePanel.java][preloadData] loadDataUp");
        this.f81919f.startMachineRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        x.j("WSEpisodeChoicePanel", "[WSEpisodeChoicePanel.java][removeOnScrollListener]");
        this.f81919f.getRecyclerView().removeOnScrollListener(this.J);
    }

    private void P(int i3, int i16) {
        Map<String, String> h06 = B().h0();
        h06.put("btn_status", String.valueOf(i3));
        com.tencent.biz.pubaccount.weishi.verticalvideo.report.d.e(this.f81917d.getFrom(), this.f81917d.getPlayScene(), this.f81917d.Th(), i16, h06);
    }

    private void Q() {
        Map<String, String> h06 = B().h0();
        h06.putAll(this.F.y());
        h06.put("close_type", "2");
        com.tencent.biz.pubaccount.weishi.verticalvideo.report.d.a(this.f81917d.getFrom(), this.f81917d.getPlayScene(), this.f81917d.Th(), h06);
    }

    private void R(int i3) {
        Map<String, String> h06 = B().h0();
        h06.put("btn_status", String.valueOf(i3));
        com.tencent.biz.pubaccount.weishi.verticalvideo.report.d.b(this.f81917d.getFrom(), this.f81917d.getPlayScene(), this.f81917d.Th(), h06);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(j jVar) {
        Map<String, String> h06 = B().h0();
        h06.putAll(this.F.y());
        h06.putAll(B().U1(jVar));
        h06.put("close_type", "1");
        com.tencent.biz.pubaccount.weishi.verticalvideo.report.d.c(this.f81917d.getFrom(), this.f81917d.getPlayScene(), this.f81917d.Th(), h06);
    }

    private void U() {
        au z16 = B().O0().getAdapter().z();
        x.j("WSEpisodeChoicePanel", "[WSEpisodeChoicePanel.java][scrollToPositionWhenShow] playingVideoHolder:" + z16);
        if (z16 != null) {
            int indexOf = B().O0().getAdapter().getDataList().indexOf(z16.f82129f);
            x.j("WSEpisodeChoicePanel", "[WSEpisodeChoicePanel.java][scrollToPositionWhenShow] position:" + indexOf);
            ((LinearLayoutManager) this.f81919f.getRecyclerView().getLayoutManager()).scrollToPositionWithOffset(indexOf, L);
            this.F.r(indexOf);
        }
        this.f81919f.post(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.verticalvideo.choicepanel.WSEpisodeChoicePanel.6
            @Override // java.lang.Runnable
            public void run() {
                WSEpisodeChoicePanel.this.N();
                WSEpisodeChoicePanel.this.t();
                WSEpisodeChoicePanel.this.F.D(WSEpisodeChoicePanel.this.f81919f);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(boolean z16) {
        if (!z16) {
            this.E.setBackgroundDrawable(z("#7A46FF"));
            this.E.setTextColor(-1);
            this.E.setText(y().getResources().getString(R.string.x89));
            this.D.setText(y().getResources().getString(R.string.x88));
            return;
        }
        this.E.setBackgroundDrawable(z("#FFFFFF"));
        this.E.setTextColor(Color.parseColor("#7A46FF"));
        this.E.setText(y().getResources().getString(R.string.x85));
        this.D.setText(y().getResources().getString(R.string.x87));
    }

    private void W(int i3) {
        LoadingMoreHelper loadMoreLayoutHelper = this.f81919f.getLoadMoreLayoutHelper();
        if (loadMoreLayoutHelper != null) {
            loadMoreLayoutHelper.setPreLoaderCount(i3);
        }
    }

    private void X(Window window) {
        Activity w3 = w();
        if (w3 == null) {
            return;
        }
        showAtLocation(window.getDecorView(), 80, 0, (SystemBarTintManager.hasNavBar(w3) && ScreenUtil.isNavigationBarExist(w3)) ? SystemBarTintManager.getNavigationBarHeight(w3) : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(final int i3) {
        this.f81919f.post(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.verticalvideo.choicepanel.WSEpisodeChoicePanel.7
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.biz.pubaccount.weishi.verticalvideo.choicepanel.d dVar = new com.tencent.biz.pubaccount.weishi.verticalvideo.choicepanel.d(WSEpisodeChoicePanel.this.y());
                dVar.setTargetPosition(i3);
                WSEpisodeChoicePanel.this.f81919f.getRecyclerView().getLayoutManager().startSmoothScroll(dVar);
            }
        });
    }

    private void Z() {
        U();
        this.f81921i.setText(B().W1());
        this.f81922m.setText(B().V1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        if (B().b2() || !isShowing()) {
            return;
        }
        O();
        x.j("WSEpisodeChoicePanel", "[WSEpisodeChoicePanel.java][addOnScrollListener]");
        this.f81919f.getRecyclerView().addOnScrollListener(this.J);
    }

    private void u(float f16) {
        Activity w3 = w();
        if (w3 == null) {
            return;
        }
        Window window = w3.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = f16;
        window.addFlags(2);
        window.setAttributes(attributes);
    }

    public static WSEpisodeChoicePanel v(WSVerticalPageFragment wSVerticalPageFragment) {
        return new WSEpisodeChoicePanel(wSVerticalPageFragment);
    }

    private Activity w() {
        return this.f81917d.getActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context y() {
        return this.f81917d.getContext();
    }

    private GradientDrawable z(String str) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(ba.f81738m);
        gradientDrawable.setColor(Color.parseColor(str));
        return gradientDrawable;
    }

    public String A() {
        return this.f81917d.getFrom();
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.choicepanel.a
    public void A0() {
        x.j("WSEpisodeChoicePanel", "[WSEpisodeChoicePanel.java][hideRefreshingView]");
        this.f81919f.pullRefreshCompleted(true);
        if (B().b2()) {
            this.f81919f.setRefreshEnable(false);
        }
    }

    public com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.a B() {
        return this.G;
    }

    public void K(boolean z16, boolean z17) {
        B().H(z16, z17, A());
    }

    public void L() {
        B().p0(A());
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.choicepanel.a
    public void T(List<j> list) {
        x.j("WSEpisodeChoicePanel", "[WSEpisodeChoicePanel.java][insertDataToTop]");
        x().z(list);
        t();
    }

    @Override // com.tencent.biz.pubaccount.weishi.view.WSDragLayout.c
    public void b(int i3) {
        dismiss();
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.choicepanel.a
    public void c(List<j> list) {
        x.j("WSEpisodeChoicePanel", "[WSEpisodeChoicePanel.java][fillData]");
        x().fillList(list);
        t();
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.choicepanel.a
    public void d() {
        au z16 = B().O0().getAdapter().z();
        x.j("WSEpisodeChoicePanel", "[WSEpisodeChoicePanel.java][scrollToPosition] playingVideoHolder:" + z16);
        if (z16 == null) {
            return;
        }
        int indexOf = B().O0().getAdapter().getDataList().indexOf(z16.f82129f);
        x.j("WSEpisodeChoicePanel", "[WSEpisodeChoicePanel.java][scrollToPosition] position:" + indexOf);
        Y(indexOf);
        this.F.r(indexOf);
    }

    @Override // android.widget.PopupWindow, com.tencent.biz.pubaccount.weishi.verticalvideo.choicepanel.a
    public void dismiss() {
        super.dismiss();
        this.f81917d.H0(0);
        u(1.0f);
        WSDragLayout wSDragLayout = this.f81918e;
        if (wSDragLayout != null) {
            wSDragLayout.n(0);
        }
        if (this.I) {
            return;
        }
        Q();
        this.I = false;
    }

    @Override // com.tencent.biz.pubaccount.weishi.view.WSDragLayout.c
    public void e(float f16) {
        x.i("WSEpisodeChoicePanel", "progress = " + f16);
        u((float) ((((double) f16) * 0.3d) + 0.7d));
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.choicepanel.a
    public void f(com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.a aVar) {
        this.G = aVar;
    }

    @Override // com.tencent.biz.pubaccount.weishi.view.WSDragLayout.c
    public boolean g() {
        return !B().b2();
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.choicepanel.a
    public void h(boolean z16) {
        x.j("WSEpisodeChoicePanel", "[WSEpisodeChoicePanel.java][hideLoadMoreView]");
        this.f81919f.loadMoreComplete(true, z16);
        if (B().b2()) {
            this.f81919f.setRefreshEnable(false);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.choicepanel.a
    public void onError() {
        t();
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.choicepanel.a
    public void setData(List<j> list) {
        x.j("WSEpisodeChoicePanel", "[WSEpisodeChoicePanel.java][setData]");
        x().w(list);
        t();
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.choicepanel.a
    public void show() {
        Activity w3 = w();
        if (w3 == null) {
            return;
        }
        Window window = w3.getWindow();
        if (window != null) {
            window.setDimAmount(0.5f);
            X(window);
            e(0.0f);
            Z();
            this.f81917d.K1(0);
        }
        R(E());
    }

    public com.tencent.biz.pubaccount.weishi.verticalvideo.choicepanel.b x() {
        return this.F;
    }

    private void H() {
        W(10);
        this.f81919f.setIsAutoScrolling(true);
        this.f81919f.setRefreshCallback(C());
        RecyclerViewWithHeaderFooter recyclerView = this.f81919f.getRecyclerView();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(y());
        recyclerView.setItemAnimator(null);
        recyclerView.setLayoutManager(linearLayoutManager);
        com.tencent.biz.pubaccount.weishi.verticalvideo.choicepanel.b bVar = new com.tencent.biz.pubaccount.weishi.verticalvideo.choicepanel.b(y(), recyclerView);
        this.F = bVar;
        bVar.t(new c());
        recyclerView.setAdapter(this.F);
    }

    private void G() {
        setAnimationStyle(R.style.att);
        setFocusable(true);
        setInputMethodMode(1);
        setSoftInputMode(16);
        setClippingEnabled(false);
        setOutsideTouchable(true);
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i3, KeyEvent keyEvent) {
        if (i3 != 4) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // com.tencent.biz.pubaccount.weishi.view.WSDragLayout.c
    public void scrollToTop() {
    }

    @Override // com.tencent.biz.pubaccount.weishi.view.WSDragLayout.c
    public void a(boolean z16) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class c implements lz.b<j> {
        c() {
        }

        @Override // lz.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void l(j jVar, int i3) {
            WSEpisodeChoicePanel.this.Y(i3);
            WSEpisodeChoicePanel.this.B().O0().x().scrollToPosition(i3);
            WSEpisodeChoicePanel.this.I = true;
            WSEpisodeChoicePanel.this.dismiss();
            WSEpisodeChoicePanel.this.S(jVar);
        }

        @Override // lz.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void i(j jVar, int i3) {
        }
    }
}
