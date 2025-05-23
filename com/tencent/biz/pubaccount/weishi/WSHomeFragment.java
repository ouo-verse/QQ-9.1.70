package com.tencent.biz.pubaccount.weishi;

import UserGrowth.stGetTabsRsp;
import UserGrowth.stNewsRedDot;
import UserGrowth.stPublisherRsp;
import UserGrowth.stTabInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.pubaccount.accountdetail.api.IMsgListPluginApi;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDataCardApi;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailActivity;
import com.tencent.biz.pubaccount.weishi.event.WSCommentShowEvent;
import com.tencent.biz.pubaccount.weishi.event.WSHomeBackBtnClickEvent;
import com.tencent.biz.pubaccount.weishi.event.WSHomePagerChangeEvent;
import com.tencent.biz.pubaccount.weishi.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi.event.WSSpeedPlayEvent;
import com.tencent.biz.pubaccount.weishi.event.WSUserAuthEvent;
import com.tencent.biz.pubaccount.weishi.home.avatarzone.WSRedDotEvent;
import com.tencent.biz.pubaccount.weishi.home.d;
import com.tencent.biz.pubaccount.weishi.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi.main.WSVideoPageChangeObserver;
import com.tencent.biz.pubaccount.weishi.main.a;
import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi.report.WSReportDc00898;
import com.tencent.biz.pubaccount.weishi.teenmode.WSTeenModePart;
import com.tencent.biz.pubaccount.weishi.util.ah;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.view.WSViewPager;
import com.tencent.biz.pubaccount.weishi.view.nav.WSNavigationBar;
import com.tencent.gdtad.util.GdtManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.applets.PublicAccountEventReport;
import com.tencent.mobileqq.cardcontainer.api.IChatListTestAndVibrateApi;
import com.tencent.mobileqq.kandian.base.image.api.IImageManager;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.kandian.biz.common.api.IWeiShiReportUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import vy.WSNavigationBarInfo;

/* compiled from: P */
/* loaded from: classes32.dex */
public class WSHomeFragment extends WSBaseFragment<com.tencent.biz.pubaccount.weishi.home.b, com.tencent.biz.pubaccount.weishi.home.a> implements View.OnClickListener, com.tencent.biz.pubaccount.weishi.home.b, wz.c {
    private View M;
    private WSViewPager N;
    private ImageView P;
    private ImageView Q;
    private KandianUrlImageView R;
    private SystemBarCompact S;
    private View T;
    private TextView U;
    private View V;
    private WSNavigationBar W;
    private com.tencent.biz.pubaccount.weishi.home.d X;
    private boolean Y;
    private boolean Z;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f80385a0;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f80386b0;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f80387c0;

    /* renamed from: f0, reason: collision with root package name */
    private Context f80390f0;

    /* renamed from: g0, reason: collision with root package name */
    private List<QBaseFragment> f80391g0;

    /* renamed from: h0, reason: collision with root package name */
    private h f80392h0;

    /* renamed from: i0, reason: collision with root package name */
    private ViewPager.OnPageChangeListener f80393i0;

    /* renamed from: j0, reason: collision with root package name */
    private WSVideoPageChangeObserver f80394j0;

    /* renamed from: d0, reason: collision with root package name */
    private long f80388d0 = 0;

    /* renamed from: e0, reason: collision with root package name */
    private final g00.c f80389e0 = new g00.c();

    /* renamed from: k0, reason: collision with root package name */
    private p10.e f80395k0 = new p10.e();

    /* renamed from: l0, reason: collision with root package name */
    private Runnable f80396l0 = new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.WSHomeFragment.1
        @Override // java.lang.Runnable
        public void run() {
            if (WSHomeFragment.this.U != null) {
                WSHomeFragment.this.U.setVisibility(8);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements d.b {
        a() {
        }

        @Override // com.tencent.biz.pubaccount.weishi.home.d.b
        public void a(WSNavigationBarInfo wSNavigationBarInfo) {
            WSHomeFragment.this.Y = false;
            WSHomeFragment.this.N.setCurrentItem(wSNavigationBarInfo.getPosition());
        }

        @Override // com.tencent.biz.pubaccount.weishi.home.d.b
        public void b(WSNavigationBarInfo wSNavigationBarInfo) {
            ((com.tencent.biz.pubaccount.weishi.home.a) WSHomeFragment.this.E).b0(wSNavigationBarInfo.getBarId());
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ stPublisherRsp f80400d;

        b(stPublisherRsp stpublisherrsp) {
            this.f80400d = stpublisherrsp;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WSHomeFragment.this.Oh(this.f80400d);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ stTabInfo f80402d;

        c(stTabInfo sttabinfo) {
            this.f80402d = sttabinfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a20.d.b(WSHomeFragment.this.f80390f0, this.f80402d, WSHomeFragment.this.Vh());
        }
    }

    private void Mh() {
        if (this.f80391g0 == null) {
            this.f80391g0 = new ArrayList();
        }
        this.f80391g0.clear();
        this.f80391g0.addAll(getPresenter().h());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nh() {
        if (com.tencent.biz.pubaccount.weishi.home.c.k()) {
            return;
        }
        if (com.tencent.biz.pubaccount.weishi.home.e.f80814a.k()) {
            fi(false);
            this.V.setVisibility(8);
            if (this.L) {
                return;
            }
            ji();
            ph(false);
            return;
        }
        fi(true);
        this.V.setVisibility(0);
        if (this.L) {
            return;
        }
        ii();
        ph(true);
    }

    public static WSHomeFragment Ph(Bundle bundle, WSVideoPageChangeObserver wSVideoPageChangeObserver) {
        WSHomeFragment wSHomeFragment = new WSHomeFragment();
        wSHomeFragment.f80394j0 = wSVideoPageChangeObserver;
        wSHomeFragment.setArguments(bundle);
        return wSHomeFragment;
    }

    private void Rh() {
        int e16 = com.tencent.biz.pubaccount.weishi.report.f.e(this.Z);
        String enterPublicAccFrom = WSPublicAccReport.getInstance().getEnterPublicAccFrom();
        if (!TextUtils.equals(enterPublicAccFrom, "from_qq_chat") && !TextUtils.equals(enterPublicAccFrom, "from_operation_h5")) {
            WSPublicAccReport.getInstance().closePublicAccReport(e16);
            f10.b.f397582a.e();
        }
        com.tencent.biz.pubaccount.weishi.report.e.f81529d = 0;
        com.tencent.biz.pubaccount.weishi.report.e.f81530e = 0;
    }

    private String Uh() {
        if (TextUtils.equals(com.tencent.biz.pubaccount.weishi.home.e.f80814a.f(), "monofeed_tab")) {
            return "monofeed";
        }
        return "feeds";
    }

    private void Wh() {
        wz.b.b().a(new WSHomeBackBtnClickEvent(true));
        getBaseActivity().doOnBackPressed();
    }

    private void Xh() {
        this.f80395k0.a(this.f80390f0, getArguments() != null ? getArguments().getBundle("key_home_bundle") : null);
    }

    private void Yh() {
        if (Boolean.valueOf(((IChatListTestAndVibrateApi) QRoute.api(IChatListTestAndVibrateApi.class)).getPublicAccountPluginSwitch()).booleanValue() && ((IMsgListPluginApi) QRoute.api(IMsgListPluginApi.class)).getEntityByUin("WSHomeFragmentLog", AppConstants.WEISHI_UIN_LONGVALUE) != null) {
            Intent intent = new Intent();
            intent.putExtra("uin", String.valueOf(AppConstants.WEISHI_UIN_LONGVALUE));
            intent.putExtra("chatPage", true);
            ((IPublicAccountDataCardApi) QRoute.api(IPublicAccountDataCardApi.class)).startPublicAccountDataCardPage(getBaseActivity(), intent);
            return;
        }
        WSPublicAccReport.getInstance().reportPublicAccDetailClick();
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(getBaseActivity(), IPublicAccountDetailActivity.ROUTE_NAME);
        activityURIRequest.extra().putString("uin", String.valueOf(AppConstants.WEISHI_UIN_LONGVALUE));
        activityURIRequest.extra().putInt("uintype", 1008);
        activityURIRequest.extra().putInt("source", 119);
        QRoute.startUri(activityURIRequest, (com.tencent.mobileqq.qroute.route.o) null);
    }

    private void Zh() {
        getPresenter().o(getArguments());
        Mh();
        h hVar = new h(getChildFragmentManager(), this.f80391g0);
        this.f80392h0 = hVar;
        this.N.setAdapter(hVar);
        this.N.setCurrentItem(Sh());
        this.N.setOffscreenPageLimit(2);
        getPresenter().onPageSelected(Sh());
        this.f80393i0 = new ViewPager.OnPageChangeListener() { // from class: com.tencent.biz.pubaccount.weishi.WSHomeFragment.3
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i3) {
                WSHomeFragment.this.getPresenter().onPageSelected(i3);
                WSHomeFragment.this.Z = true;
                WSHomeFragment.this.f80387c0 = true;
                WSHomeFragment.this.Nh();
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i3) {
                if (i3 == 1) {
                    WSHomeFragment.this.Y = true;
                } else if (i3 == 0) {
                    ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.WSHomeFragment.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            WSHomeFragment.this.pi();
                        }
                    }, 100L);
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i3, float f16, int i16) {
            }
        };
    }

    private void ai() {
        if (!com.tencent.biz.pubaccount.weishi.home.e.f80814a.k() && !this.L) {
            ii();
            this.V.setVisibility(0);
            ph(true);
        } else {
            ji();
            this.V.setVisibility(8);
            ph(false);
        }
        if (com.tencent.biz.pubaccount.weishi.config.experiment.b.h().F()) {
            this.V.setVisibility(8);
        }
    }

    private void bi() {
        this.W.setBottomBarStyle(3);
        if (com.tencent.biz.pubaccount.weishi.home.c.m()) {
            ViewGroup.LayoutParams layoutParams = this.W.getLayoutParams();
            layoutParams.width = ah.b(180.0f);
            this.W.setLayoutParams(layoutParams);
        }
        com.tencent.biz.pubaccount.weishi.home.d dVar = new com.tencent.biz.pubaccount.weishi.home.d(getPresenter());
        this.X = dVar;
        dVar.y(new a());
        this.W.setAdapter(this.X);
        com.tencent.biz.pubaccount.weishi.home.g.f80819a.a(this.N, this.X.getScrollHelper(), this.f80393i0);
    }

    private boolean ci() {
        List<QBaseFragment> list = this.f80391g0;
        if (list == null || list.size() <= 0) {
            return false;
        }
        while (true) {
            boolean z16 = false;
            for (QBaseFragment qBaseFragment : this.f80391g0) {
                if (qBaseFragment instanceof WSBaseFragment) {
                    if (z16 || ((WSBaseFragment) qBaseFragment).onBackEvent()) {
                        z16 = true;
                    }
                }
            }
            return z16;
        }
    }

    public static void di(l lVar) {
        a.C0826a.a(lVar);
    }

    private void ei() {
        if (this.L) {
            com.tencent.biz.pubaccount.weishi.util.x.i("weishi-815", "is night mode");
            ji();
            ph(false);
            return;
        }
        com.tencent.biz.pubaccount.weishi.util.x.i("weishi-815", "is day mode");
    }

    private void fi(boolean z16) {
        Animation loadAnimation;
        if (this.T == null) {
            return;
        }
        if (!this.f80385a0 && z16) {
            ki();
        }
        if (z16) {
            loadAnimation = AnimationUtils.loadAnimation(this.f80390f0, R.anim.f154476ii);
            this.T.setVisibility(0);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(this.f80390f0, R.anim.f154480ae);
            this.T.setVisibility(8);
        }
        this.T.startAnimation(loadAnimation);
    }

    private void hi(String str, String str2, int i3) {
        cz.f.f392428a.k(str, str2, i3, Vh());
    }

    private void ii() {
        this.Q.setImageResource(R.drawable.m6q);
        this.P.setImageResource(R.drawable.m6l);
    }

    private void initData() {
        this.X.w(getPresenter().q());
        wz.b.b().d(this);
        GdtManager.q().r(this.f80390f0, new GdtManager.a());
        getPresenter().g();
        ry.a.g();
    }

    private void initView() {
        this.N = (WSViewPager) this.M.findViewById(R.id.f125497m8);
        this.W = (WSNavigationBar) this.M.findViewById(R.id.f164634ta3);
        this.P = (ImageView) this.M.findViewById(R.id.f125147l_);
        this.Q = (ImageView) this.M.findViewById(R.id.f125177lc);
        this.R = (KandianUrlImageView) this.M.findViewById(R.id.f125237li);
        RelativeLayout relativeLayout = (RelativeLayout) this.M.findViewById(R.id.f125297lo);
        this.V = this.M.findViewById(R.id.f125337ls);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) relativeLayout.getLayoutParams();
        layoutParams.setMargins(0, ImmersiveUtils.getStatusBarHeight(getBaseActivity()), 0, 0);
        relativeLayout.setLayoutParams(layoutParams);
        this.P.setOnClickListener(this);
        this.Q.setOnClickListener(this);
        Zh();
        bi();
        ai();
    }

    private void ji() {
        this.Q.setImageResource(R.drawable.m6r);
        this.P.setImageResource(R.drawable.m6m);
    }

    private void li(int i3) {
        WSViewPager wSViewPager = this.N;
        if (wSViewPager != null) {
            wSViewPager.setCurrentItem(i3);
        }
    }

    private void mi(String str) {
        int p16 = this.X.p(str);
        if (p16 != -1) {
            li(p16);
        }
    }

    private void ni() {
        com.tencent.biz.pubaccount.weishi.home.e eVar = com.tencent.biz.pubaccount.weishi.home.e.f80814a;
        if (eVar.j()) {
            com.tencent.biz.pubaccount.weishi.report.f.d();
            bb.W(Vh());
            WSPublicAccReport wSPublicAccReport = WSPublicAccReport.getInstance();
            com.tencent.biz.pubaccount.weishi.home.d dVar = this.X;
            wSPublicAccReport.reportAttentionClick(dVar == null ? 0 : dVar.o(), Uh(), this.Y);
            oi(0);
            f10.b.f397582a.o();
            WSReportDc00898.q();
            return;
        }
        bb.W(Vh());
        if (eVar.k()) {
            WSPublicAccReport.getInstance().reportImmersionClick(this.Y);
            com.tencent.biz.pubaccount.weishi.report.f.l(String.valueOf(System.currentTimeMillis()));
        } else {
            WSPublicAccReport.getInstance().reportRecommendClick(this.Y);
        }
    }

    private void oi(int i3) {
        if (Sh() == 0) {
            i3 = 0;
        }
        this.X.x(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pi() {
        if (this.f80387c0) {
            ni();
        }
        this.f80387c0 = false;
    }

    private void qi() {
        jz.f.d().m();
        Rh();
        bb.f81753a = false;
        ThreadManager.getUIHandler().removeCallbacks(this.f80396l0);
        com.tencent.biz.pubaccount.weishi.net.j.Y.clear();
        com.tencent.biz.pubaccount.weishi.recommend.data.c.e().c();
        if (!TextUtils.equals(WSPublicAccReport.getInstance().getEnterPublicAccFrom(), "from_qq_chat")) {
            xz.j.i(true);
        }
        xz.b.f449122a.e(false);
    }

    @Override // com.tencent.biz.pubaccount.weishi.b
    /* renamed from: Qh, reason: merged with bridge method [inline-methods] */
    public com.tencent.biz.pubaccount.weishi.presenter.d V() {
        return new com.tencent.biz.pubaccount.weishi.presenter.d();
    }

    public int Sh() {
        return com.tencent.biz.pubaccount.weishi.home.e.f80814a.e();
    }

    public List<QBaseFragment> Th() {
        return this.f80391g0;
    }

    public String Vh() {
        return getPresenter().e();
    }

    @Override // wz.c
    public void b(WSSimpleBaseEvent wSSimpleBaseEvent) {
        if (wSSimpleBaseEvent instanceof WSUserAuthEvent) {
            x.g(getActivity(), Vh());
            return;
        }
        if (wSSimpleBaseEvent instanceof WSRedDotEvent) {
            stNewsRedDot redDot = ((WSRedDotEvent) wSSimpleBaseEvent).getRedDot();
            oi(redDot != null ? redDot.newsCount : 0);
            gi(redDot);
        } else if (wSSimpleBaseEvent instanceof WSHomePagerChangeEvent) {
            mi(((WSHomePagerChangeEvent) wSSimpleBaseEvent).getId());
        } else if (wSSimpleBaseEvent instanceof WSSpeedPlayEvent) {
            this.N.setScrollable(!((WSSpeedPlayEvent) wSSimpleBaseEvent).isActive());
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.home.b
    public void d4(stPublisherRsp stpublisherrsp) {
        if (this.T == null) {
            this.T = ((ViewStub) this.M.findViewById(R.id.f125527ma)).inflate();
        }
        View view = this.T;
        if (view != null) {
            this.U = (TextView) view.findViewById(R.id.f122197da);
            ((ImageView) this.T.findViewById(R.id.f122187d_)).setOnClickListener(new b(stpublisherrsp));
            getPresenter().v0(this.f80390f0, stpublisherrsp);
            this.f80386b0 = stpublisherrsp.newUser;
            this.U.setText(stpublisherrsp.newsUserText);
            if (com.tencent.biz.pubaccount.weishi.home.e.f80814a.k()) {
                this.T.setVisibility(8);
            } else {
                ki();
            }
        }
    }

    @Override // wz.c
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(WSCommentShowEvent.class);
        arrayList.add(WSUserAuthEvent.class);
        arrayList.add(WSRedDotEvent.class);
        arrayList.add(WSHomePagerChangeEvent.class);
        arrayList.add(WSSpeedPlayEvent.class);
        return arrayList;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    @Override // com.tencent.biz.pubaccount.weishi.home.b
    public WSVideoPageChangeObserver j2() {
        return this.f80394j0;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        h hVar = this.f80392h0;
        if (hVar == null || hVar.getItem(Sh()) == null) {
            return;
        }
        this.f80392h0.getItem(Sh()).onActivityResult(i3, i16, intent);
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        return ci() || super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id5 = view.getId();
        if (id5 == R.id.f125147l_) {
            Wh();
        } else {
            if (id5 != R.id.f125177lc) {
                return;
            }
            Yh();
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.WSBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.biz.pubaccount.weishi.util.x.b("WSHomeFragmentLog", "[WSHomeFragment.java][onCreate] this:" + this);
        com.tencent.biz.pubaccount.weishi.report.f.k("QQ_official_account");
        this.f80390f0 = getBaseActivity();
        com.tencent.biz.pubaccount.weishi.util.v.b().d();
        ((IWeiShiReportUtil) QRoute.api(IWeiShiReportUtil.class)).reportEnter();
        Xh();
    }

    @Override // com.tencent.biz.pubaccount.weishi.WSBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        getPresenter().doOnDestroy();
        com.tencent.biz.pubaccount.weishi.util.v.b().h();
        wz.b.b().f(this);
        com.tencent.biz.pubaccount.weishi.report.c.b().a();
        ((IWeiShiReportUtil) QRoute.api(IWeiShiReportUtil.class)).reportExit();
        ((IImageManager) QRoute.api(IImageManager.class)).clean();
        com.tencent.biz.pubaccount.weishi.home.g.f80819a.b(this.N);
    }

    @Override // com.tencent.biz.pubaccount.weishi.WSBaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.X.v();
        qi();
    }

    @Override // com.tencent.biz.pubaccount.weishi.WSBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        PublicAccountEventReport.p(getBaseActivity().app, "2062433139", 1, 4, System.currentTimeMillis() - this.f80388d0);
    }

    @Override // com.tencent.biz.pubaccount.weishi.WSBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.f80388d0 = System.currentTimeMillis();
        SystemBarCompact systemBarCompact = this.S;
        if (systemBarCompact != null) {
            systemBarCompact.setStatusBarVisible(2, 0);
        }
        ei();
        xz.j.i(yz.i.f451583a.j());
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f80389e0.a(bundle);
        com.tencent.biz.pubaccount.weishi.util.x.f("WSHomeFragmentLog", "[WSHomeFragment.java][onSaveInstanceState] outState:" + bundle);
    }

    @Override // com.tencent.biz.pubaccount.weishi.WSBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        initView();
        initData();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
        com.tencent.biz.pubaccount.weishi.util.x.f("WSHomeFragmentLog", "[WSHomeFragment.java][onViewStateRestored] savedInstanceState:" + bundle);
        this.f80389e0.b(bundle);
    }

    @Override // com.tencent.biz.pubaccount.weishi.WSBaseFragment
    public HashSet<rz.a> qh() {
        HashSet<rz.a> hashSet = new HashSet<>();
        hashSet.add(b00.h.B(getBaseActivity(), (ViewStub) this.M.findViewById(R.id.f125517m_), getPresenter()));
        hashSet.add(new WSTeenModePart(getQBaseActivity(), Vh()));
        return hashSet;
    }

    @Override // com.tencent.biz.pubaccount.weishi.home.b
    public void ye() {
        WSPublicAccReport.getInstance().reportTabLiveBtnExposure(Vh());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oh(stPublisherRsp stpublisherrsp) {
        this.Z = true;
        cz.f.f392428a.j(this.f80390f0, stpublisherrsp, Vh());
    }

    private void ki() {
        this.f80385a0 = true;
        if (this.f80386b0) {
            this.U.setVisibility(0);
            ThreadManager.getUIHandler().postDelayed(this.f80396l0, 3000L);
            hi("gzh_exposure", "publish_copywriting", 0);
        } else {
            this.U.setVisibility(8);
        }
        this.T.setVisibility(0);
        hi("gzh_exposure", "publish", 0);
    }

    private void gi(stNewsRedDot stnewsreddot) {
        if (stnewsreddot == null || stnewsreddot.newsCount <= 0) {
            return;
        }
        WSPublicAccReport.getInstance().reportAttentionRedDotExposure(stnewsreddot.newsCount, Vh());
    }

    @Override // com.tencent.biz.pubaccount.weishi.home.b
    public void Oa(stGetTabsRsp stgettabsrsp) {
        ArrayList<stTabInfo> arrayList;
        if (stgettabsrsp == null || (arrayList = stgettabsrsp.Tabs) == null) {
            return;
        }
        if (arrayList.size() > 0) {
            stTabInfo sttabinfo = stgettabsrsp.Tabs.get(0);
            if (TextUtils.isEmpty(sttabinfo.displayIcon)) {
                this.R.setVisibility(8);
                return;
            }
            this.R.setVisibility(0);
            WSPicLoader.g().w(this.R, sttabinfo.displayIcon, BaseApplication.getContext().getResources().getDrawable(R.color.ajr));
            this.R.setOnClickListener(new c(sttabinfo));
            return;
        }
        this.R.setVisibility(8);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.M = (ViewGroup) layoutInflater.inflate(R.layout.fw_, viewGroup, false);
        SystemBarCompact systemBarComp = SystemBarActivityModule.getSystemBarComp(getBaseActivity());
        this.S = systemBarComp;
        if (systemBarComp != null) {
            systemBarComp.setStatusBarVisible(2, 0);
        }
        return this.M;
    }
}
