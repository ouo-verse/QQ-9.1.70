package com.tencent.biz.pubaccount.weishi.main;

import UserGrowth.stSimpleMetaFeed;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.RectF;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.activity.result.ActivityResultCaller;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.pubaccount.weishi.WSBaseFragment;
import com.tencent.biz.pubaccount.weishi.event.WSChangeItemViewVisibilityEvent;
import com.tencent.biz.pubaccount.weishi.event.WSSaveFirstItemLocationCoverEvent;
import com.tencent.biz.pubaccount.weishi.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi.event.WSSpeedPlayEvent;
import com.tencent.biz.pubaccount.weishi.h;
import com.tencent.biz.pubaccount.weishi.ui.videotransition.WSDragFrameLayout;
import com.tencent.biz.pubaccount.weishi.ui.videotransition.WSVideoTransitionManager;
import com.tencent.biz.pubaccount.weishi.util.ba;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.pubaccount.weishi.view.WSViewPager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseFragment;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class WSMainContainerFragment extends WSBaseFragment<com.tencent.biz.pubaccount.weishi.main.c, com.tencent.biz.pubaccount.weishi.main.b> implements com.tencent.biz.pubaccount.weishi.main.c, wz.c {
    private WSDragFrameLayout Q;
    private WSViewPager R;
    private h S;
    private List<QBaseFragment> T;
    private int U;
    private String V;
    private boolean W;
    private final WSVideoTransitionManager M = new WSVideoTransitionManager();
    private final RectF N = new RectF();
    private final RectF P = new RectF();
    private boolean X = true;
    private boolean Y = false;
    private boolean Z = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ WSDragFrameLayout f80915d;

        a(WSDragFrameLayout wSDragFrameLayout) {
            this.f80915d = wSDragFrameLayout;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.f80915d.getViewTreeObserver().removeOnPreDrawListener(this);
            WSMainContainerFragment wSMainContainerFragment = WSMainContainerFragment.this;
            wSMainContainerFragment.Wh(this.f80915d, ((com.tencent.biz.pubaccount.weishi.main.b) ((WSBaseFragment) wSMainContainerFragment).E).getIntentFeed());
            WSMainContainerFragment.this.M.h(this.f80915d, WSMainContainerFragment.this.N, WSMainContainerFragment.this.P);
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class c implements WSVideoTransitionManager.b {
        c() {
        }

        @Override // com.tencent.biz.pubaccount.weishi.ui.videotransition.WSVideoTransitionManager.b
        public void a() {
            WSMainContainerFragment wSMainContainerFragment = WSMainContainerFragment.this;
            wSMainContainerFragment.ei(((com.tencent.biz.pubaccount.weishi.main.b) ((WSBaseFragment) wSMainContainerFragment).E).getIntentFeedId(), WSMainContainerFragment.this.V, true);
            FragmentActivity activity = WSMainContainerFragment.this.getActivity();
            if (activity != null) {
                activity.finish();
                activity.overridePendingTransition(0, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class d implements WSDragFrameLayout.b {
        d() {
        }

        @Override // com.tencent.biz.pubaccount.weishi.ui.videotransition.WSDragFrameLayout.b
        public void onEndDrag(boolean z16) {
            FragmentActivity activity;
            ((com.tencent.biz.pubaccount.weishi.verticalvideo.h) WSMainContainerFragment.this.S.getItem(0)).Ld();
            if (!z16 || (activity = WSMainContainerFragment.this.getActivity()) == null) {
                return;
            }
            activity.onBackPressed();
        }

        @Override // com.tencent.biz.pubaccount.weishi.ui.videotransition.WSDragFrameLayout.b
        public void onStartDrag() {
            ((com.tencent.biz.pubaccount.weishi.verticalvideo.h) WSMainContainerFragment.this.S.getItem(0)).od();
            WSMainContainerFragment wSMainContainerFragment = WSMainContainerFragment.this;
            wSMainContainerFragment.ei(((com.tencent.biz.pubaccount.weishi.main.b) ((WSBaseFragment) wSMainContainerFragment).E).getIntentFeedId(), WSMainContainerFragment.this.V, false);
        }
    }

    private WSDragFrameLayout.b Sh() {
        return new d();
    }

    private stSimpleMetaFeed Th() {
        ActivityResultCaller activityResultCaller = (QBaseFragment) this.T.get(0);
        if (activityResultCaller instanceof com.tencent.biz.pubaccount.weishi.verticalvideo.h) {
            return ((com.tencent.biz.pubaccount.weishi.verticalvideo.h) activityResultCaller).Tc();
        }
        return null;
    }

    private void Uh() {
        this.T = getPresenter().getFragments(getArguments());
        h hVar = new h(getChildFragmentManager(), this.T);
        this.S = hVar;
        this.R.setAdapter(hVar);
        this.R.addOnPageChangeListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wh(WSDragFrameLayout wSDragFrameLayout, stSimpleMetaFeed stsimplemetafeed) {
        this.P.set(com.tencent.biz.pubaccount.weishi.ui.videotransition.c.c(wSDragFrameLayout.getMeasuredWidth(), wSDragFrameLayout.getMeasuredHeight(), stsimplemetafeed));
    }

    private void Xh(WSDragFrameLayout wSDragFrameLayout) {
        ci(wSDragFrameLayout);
        Wh(wSDragFrameLayout, ((com.tencent.biz.pubaccount.weishi.main.b) this.E).getIntentFeed());
        wSDragFrameLayout.getViewTreeObserver().addOnPreDrawListener(new a(wSDragFrameLayout));
        this.M.f(wSDragFrameLayout, com.tencent.biz.pubaccount.weishi.ui.videotransition.c.a(), this.N, this.P);
    }

    private boolean Yh() {
        if (this.U != 0) {
            gi();
            return true;
        }
        h hVar = this.S;
        if (hVar == null) {
            return false;
        }
        boolean z16 = false;
        for (int i3 = 0; i3 < hVar.getF373114d(); i3++) {
            QBaseFragment item = hVar.getItem(i3);
            if (item instanceof WSBaseFragment) {
                z16 = z16 || ((WSBaseFragment) item).onBackEvent();
            }
        }
        return z16;
    }

    private boolean Zh() {
        return this.Y || this.Z;
    }

    private boolean ai() {
        return com.tencent.biz.pubaccount.weishi.ui.videotransition.c.j(Ra());
    }

    private void ci(WSDragFrameLayout wSDragFrameLayout) {
        wSDragFrameLayout.measure(View.MeasureSpec.makeMeasureSpec(ba.o(), 1073741824), View.MeasureSpec.makeMeasureSpec(ba.n(), 1073741824));
    }

    private void di() {
        wz.b.b().d(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ei(String str, String str2, boolean z16) {
        x.j("WSVerticalMainFragment", "sendChangeItemViewVisibilityEvent() fallFeedId = " + str + ", from = " + str2 + ", isShow = " + z16);
        if (TextUtils.isEmpty(str)) {
            if (this.Z) {
                wz.b.b().a(new WSChangeItemViewVisibilityEvent(true, z16));
                return;
            }
            return;
        }
        wz.b.b().a(new WSChangeItemViewVisibilityEvent(str, z16));
    }

    private void fi(int i3) {
        this.R.setCurrentItem(i3, true);
    }

    private void hi() {
        wz.b.b().f(this);
    }

    private void initData() {
        getPresenter().handleIntent(getArguments());
    }

    @Override // com.tencent.biz.pubaccount.weishi.main.c
    public void G9(boolean z16) {
        this.W = z16;
    }

    @Override // com.tencent.biz.pubaccount.weishi.b
    /* renamed from: Qh, reason: merged with bridge method [inline-methods] */
    public com.tencent.biz.pubaccount.weishi.main.b V() {
        String from = getFrom();
        x.f("WSVerticalMainFragment", "[WSMainContainerFragment.java][createPresenter] from:" + from);
        return com.tencent.biz.pubaccount.weishi.main.d.f(from, this);
    }

    @Override // com.tencent.biz.pubaccount.weishi.main.c
    public Bundle Ra() {
        return getArguments();
    }

    public int Rh() {
        return this.U;
    }

    @Override // com.tencent.biz.pubaccount.weishi.main.c
    public void Tb(boolean z16) {
        WSDragFrameLayout wSDragFrameLayout = this.Q;
        if (wSDragFrameLayout != null && wSDragFrameLayout.getIsFeatureEnable()) {
            z16 = false;
        }
        Bh(z16);
    }

    @Override // wz.c
    public void b(WSSimpleBaseEvent wSSimpleBaseEvent) {
        if (wSSimpleBaseEvent instanceof WSSpeedPlayEvent) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("WSSpeedPlayEvent.isActive:");
            WSSpeedPlayEvent wSSpeedPlayEvent = (WSSpeedPlayEvent) wSSimpleBaseEvent;
            sb5.append(wSSpeedPlayEvent.isActive());
            x.i("WSVerticalMainFragment", sb5.toString());
            boolean z16 = !wSSpeedPlayEvent.isActive();
            if (Zh()) {
                this.Q.setFeatureEnable(z16);
            }
            this.R.setScrollable(z16);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.main.c
    public h getAdapter() {
        return this.S;
    }

    @Override // wz.c
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(WSSpeedPlayEvent.class);
        return arrayList;
    }

    public String getFrom() {
        if (!TextUtils.isEmpty(this.V)) {
            return this.V;
        }
        if (getArguments() != null) {
            this.V = getArguments().getString("key_from");
        }
        return this.V;
    }

    @Override // com.tencent.biz.pubaccount.weishi.main.c
    public void h9(boolean z16) {
        this.R.setCanScrollHorizontally(z16);
        this.R.setScrollable(z16);
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        super.initWindowStyleAndAnimation(activity);
        Ch(activity);
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        h hVar = this.S;
        if (hVar == null || hVar.getItem(Rh()) == null) {
            return;
        }
        this.S.getItem(Rh()).onActivityResult(i3, i16, intent);
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        WSDragFrameLayout wSDragFrameLayout;
        boolean z16 = Yh() || super.onBackEvent();
        if (z16 || (wSDragFrameLayout = this.Q) == null || !wSDragFrameLayout.getIsFeatureEnable()) {
            return z16;
        }
        RectF rectF = this.N;
        if (this.Z) {
            wz.b.b().a(new WSSaveFirstItemLocationCoverEvent());
            Wh(this.Q, Th());
            rectF = com.tencent.biz.pubaccount.weishi.ui.videotransition.c.d();
            this.M.f(this.Q, com.tencent.biz.pubaccount.weishi.ui.videotransition.c.a(), this.P, rectF);
        }
        this.M.i(this.Q, this.P, rectF, new c());
        return true;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ba.B(configuration, "WSMainContainerFragment");
        WSDragFrameLayout wSDragFrameLayout = this.Q;
        if (wSDragFrameLayout != null) {
            wSDragFrameLayout.setClipVertical(0, ba.n());
            this.Q.invalidate();
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.WSBaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        hi();
    }

    @Override // com.tencent.biz.pubaccount.weishi.main.c
    public boolean v6() {
        return this.W;
    }

    @Override // com.tencent.biz.pubaccount.weishi.WSBaseFragment
    protected List<QBaseFragment> vh() {
        return this.T;
    }

    @Override // com.tencent.biz.pubaccount.weishi.main.c
    public void y3(boolean z16) {
        this.X = z16;
        this.Q.setEnableDragVertical(z16);
    }

    private void Vh(WSDragFrameLayout wSDragFrameLayout) {
        Tb(false);
        wSDragFrameLayout.setFeatureEnable(true);
        wSDragFrameLayout.setOnDragListener(Sh());
    }

    public void gi() {
        fi(0);
    }

    @Override // com.tencent.biz.pubaccount.weishi.main.c
    public void yc() {
        G9(true);
        fi(1);
    }

    private void bi(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        this.Y = com.tencent.biz.pubaccount.weishi.ui.videotransition.c.j(bundle);
        this.Z = com.tencent.biz.pubaccount.weishi.ui.videotransition.c.i(bundle);
        this.N.set(com.tencent.biz.pubaccount.weishi.ui.videotransition.c.g(bundle));
    }

    private void initView(View view) {
        WSViewPager wSViewPager = (WSViewPager) view.findViewById(R.id.p8w);
        this.R = wSViewPager;
        wSViewPager.setOffscreenPageLimit(1);
        this.R.setCurrentItem(0);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.d0z, viewGroup, false);
        initData();
        di();
        initView(inflate);
        Uh();
        bi(Ra());
        this.Q = (WSDragFrameLayout) inflate;
        if (Zh()) {
            Vh(this.Q);
        }
        if (ai()) {
            Xh(this.Q);
        }
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b implements ViewPager.OnPageChangeListener {
        b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i3) {
            x.f("WSVerticalMainFragment", "[WSMainContainerFragment.java][initAdapter] onPageSelected position:" + i3);
            WSMainContainerFragment.this.U = i3;
            WSMainContainerFragment.this.getPresenter().onRightLeftPageSelected(i3);
            WSMainContainerFragment.this.Q.setEnableDragHorizontal(i3 == 0);
            WSMainContainerFragment.this.Q.setEnableDragVertical(i3 == 0 && WSMainContainerFragment.this.X);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i3) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i3, float f16, int i16) {
        }
    }
}
