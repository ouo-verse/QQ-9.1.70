package com.tencent.biz.pubaccount.weishi;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.pubaccount.weishi.event.WSPreloadTabEvent;
import com.tencent.biz.pubaccount.weishi.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi.event.WSSubTabPagerSelectedEvent;
import com.tencent.biz.pubaccount.weishi.recommend.WSGridPageFragment;
import com.tencent.biz.pubaccount.weishi.view.WSFeedsLinearLayout;
import com.tencent.biz.pubaccount.weishi.view.WSViewPager;
import com.tencent.biz.pubaccount.weishi.view.tab.WSTabLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class WSRecommendFragment extends WSBaseFragment implements com.tencent.biz.pubaccount.weishi.ui.a, wz.c {
    private static final int Z = Color.parseColor("#6933CC");
    private WSFeedsLinearLayout M;
    private WSViewPager N;
    private WSTabLayout P;
    private View Q;
    private ViewGroup R;
    private h S;
    private List<QBaseFragment> T;
    private List<a20.c> U;
    private String V;
    private boolean W;
    private int X = 0;
    private int Y = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class c implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.biz.pubaccount.weishi.recommend.data.g f80406d;

        c(com.tencent.biz.pubaccount.weishi.recommend.data.g gVar) {
            this.f80406d = gVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            WSRecommendFragment.this.M.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            com.tencent.biz.pubaccount.weishi.recommend.data.g gVar = this.f80406d;
            if (gVar == null) {
                return;
            }
            boolean z16 = false;
            if (TextUtils.equals(gVar.f81432b, "2")) {
                WSRecommendFragment.this.P.l0(false);
                WSRecommendFragment.this.Rh(false);
            } else {
                WSRecommendFragment.this.P.u0(false);
                z16 = true;
                WSRecommendFragment.this.Rh(true);
            }
            a20.b.d(z16, this.f80406d.f81431a);
        }
    }

    private List<QBaseFragment> Ih(List<a20.c> list) {
        String str;
        this.T = new ArrayList();
        if (list.size() == 0) {
            this.T.add(WSGridPageFragment.Vh("1000", true, true, this.V, this.W));
            return this.T;
        }
        int i3 = 0;
        while (i3 < list.size()) {
            a20.c cVar = list.get(i3);
            boolean z16 = i3 == 0;
            if (TextUtils.equals("1000", cVar.b())) {
                str = this.V;
            } else {
                str = "";
            }
            this.T.add(WSGridPageFragment.Vh(cVar.b(), true, z16, str, this.W));
            i3++;
        }
        return this.T;
    }

    public static BaseFragment Jh(String str, boolean z16) {
        WSRecommendFragment wSRecommendFragment = new WSRecommendFragment();
        Bundle bundle = new Bundle();
        bundle.putString("key_context_feed_id", str);
        bundle.putBoolean("key_show_context_feed_musk", z16);
        wSRecommendFragment.setArguments(bundle);
        return wSRecommendFragment;
    }

    private void Mh() {
        wz.b.b().d(this);
    }

    private void Nh(List<a20.c> list) {
        h hVar = new h(getChildFragmentManager(), Ih(list));
        this.S = hVar;
        this.N.setAdapter(hVar);
        this.N.setOffscreenPageLimit(5);
        this.N.addOnPageChangeListener(new b());
        this.Y = 0;
    }

    private void Oh() {
        if (this.L) {
            this.M.setBackgroundColor(-16777216);
        } else {
            this.M.setBackgroundColor(-1);
        }
        this.M.setOnActionListener(new p(this, this.P));
    }

    private void Ph() {
        com.tencent.biz.pubaccount.weishi.recommend.data.g c16 = a20.a.c(com.tencent.biz.pubaccount.weishi.config.experiment.b.h().t());
        List<a20.c> b16 = a20.a.b(c16);
        this.U = b16;
        Nh(b16);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Q.getLayoutParams();
        layoutParams.setMargins(0, ImmersiveUtils.getStatusBarHeight(getActivity()), 0, 0);
        this.Q.setLayoutParams(layoutParams);
        if (this.U.size() == 0) {
            this.P.setVisibility(8);
            return;
        }
        this.P.setVisibility(0);
        this.P.setupWithViewPager(this.N);
        this.P.n0(this.U, new a());
        this.P.setTabItemSelect(0, Z);
        Sh(c16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qh(int i3) {
        this.P.setTabItemSelect(i3, Z);
        List<QBaseFragment> list = this.T;
        if (list == null || i3 >= list.size()) {
            return;
        }
        int i16 = this.Y;
        this.Y = i3;
        WSGridPageFragment Kh = Kh(i16);
        if (Kh != null) {
            Kh.Y0();
        }
        WSGridPageFragment Kh2 = Kh(i3);
        if (Kh2 != null) {
            Kh2.Cb();
        }
        if (i3 != 0) {
            WSPreloadTabEvent wSPreloadTabEvent = new WSPreloadTabEvent();
            wSPreloadTabEvent.setPosition(i3);
            wz.b.b().a(wSPreloadTabEvent);
        }
        List<a20.c> list2 = this.U;
        if (list2 == null || list2.size() <= i3) {
            return;
        }
        wz.b.b().a(new WSSubTabPagerSelectedEvent(i3, this.U.get(i3)));
        a20.b.c(i3, this.U.get(i3).b());
    }

    private void Sh(com.tencent.biz.pubaccount.weishi.recommend.data.g gVar) {
        this.M.getViewTreeObserver().addOnGlobalLayoutListener(new c(gVar));
    }

    private void initView() {
        this.P = (WSTabLayout) this.M.findViewById(R.id.f125327lr);
        this.N = (WSViewPager) this.M.findViewById(R.id.f125507m9);
        this.Q = this.M.findViewById(R.id.f1188775b);
        Oh();
        Ph();
        Mh();
    }

    @Override // com.tencent.biz.pubaccount.weishi.ui.a
    public void Cb() {
        com.tencent.biz.pubaccount.weishi.util.x.b("WSRecommendFragment", "[WSRecommendFragment.java][onTabSelected]");
        WSGridPageFragment Kh = Kh(this.Y);
        if (Kh != null) {
            Kh.Cb();
        }
    }

    public int Lh() {
        return this.X;
    }

    public void Rh(boolean z16) {
        com.tencent.biz.pubaccount.weishi.util.x.f("WSRecommendFragment", "[WSRecommendFragment.java][setCurrentViewPagerCanScroll] canScroll:" + z16);
        this.N.setCanScrollHorizontally(z16);
        this.N.setScrollable(z16);
    }

    @Override // com.tencent.biz.pubaccount.weishi.b
    public d V() {
        return new com.tencent.biz.pubaccount.weishi.presenter.a();
    }

    @Override // com.tencent.biz.pubaccount.weishi.ui.a
    public void Y0() {
        com.tencent.biz.pubaccount.weishi.util.x.b("WSRecommendFragment", "[WSRecommendFragment.java][onTabUnselected]");
        WSGridPageFragment Kh = Kh(this.Y);
        if (Kh != null) {
            Kh.Y0();
        }
    }

    @Override // wz.c
    public void b(WSSimpleBaseEvent wSSimpleBaseEvent) {
        if (wSSimpleBaseEvent instanceof WSPreloadTabEvent) {
            int position = ((WSPreloadTabEvent) wSSimpleBaseEvent).getPosition();
            if (position == -1) {
                position = this.N.getCurrentItem();
            }
            int i3 = position + 1;
            if (i3 >= this.T.size()) {
                return;
            }
            ((WSGridPageFragment) this.T.get(i3)).Zh();
        }
    }

    @Override // wz.c
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(WSPreloadTabEvent.class);
        return arrayList;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        Iterator<QBaseFragment> it = this.T.iterator();
        while (it.hasNext()) {
            it.next().onActivityResult(i3, i16, intent);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.WSBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.V = getArguments().getString("key_context_feed_id");
            this.W = getArguments().getBoolean("key_show_context_feed_musk");
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.R = viewGroup;
        WSFeedsLinearLayout wSFeedsLinearLayout = (WSFeedsLinearLayout) layoutInflater.inflate(R.layout.fwb, viewGroup, false);
        this.M = wSFeedsLinearLayout;
        return wSFeedsLinearLayout;
    }

    @Override // com.tencent.biz.pubaccount.weishi.WSBaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        wz.b.b().f(this);
    }

    @Override // com.tencent.biz.pubaccount.weishi.WSBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        initView();
    }

    @Override // com.tencent.biz.pubaccount.weishi.WSBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z16) {
        super.setUserVisibleHint(z16);
        if (isResumed()) {
            if (z16) {
                Cb();
            } else {
                Y0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.weishi.WSBaseFragment
    public boolean xh() {
        if (uy.a.f440578a.f()) {
            return false;
        }
        return super.xh();
    }

    private WSGridPageFragment Kh(int i3) {
        if (i3 < 0 || i3 >= this.T.size()) {
            return null;
        }
        return (WSGridPageFragment) this.T.get(i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements WSTabLayout.e {
        a() {
        }

        @Override // com.tencent.biz.pubaccount.weishi.view.tab.WSTabLayout.e
        public void a(com.tencent.biz.pubaccount.weishi.view.tab.a aVar) {
            if (aVar.e() == null) {
                return;
            }
            WSRecommendFragment.this.N.setCurrentItem(aVar.e().d());
        }

        @Override // com.tencent.biz.pubaccount.weishi.view.tab.WSTabLayout.e
        public void b(com.tencent.biz.pubaccount.weishi.view.tab.a aVar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b implements ViewPager.OnPageChangeListener {
        b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i3) {
            WSRecommendFragment.this.X = i3;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i3) {
            WSRecommendFragment.this.Qh(i3);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i3, float f16, int i16) {
        }
    }
}
