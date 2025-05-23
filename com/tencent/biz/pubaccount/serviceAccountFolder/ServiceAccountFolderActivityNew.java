package com.tencent.biz.pubaccount.serviceAccountFolder;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StUser;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead$StGetMainPageRsp;
import NS_COMM.COMM;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderBaseTabFragment;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderFollowTabFragment;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendQCircleTabFragment;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.network.request.SubscribePersonalDetailRequest;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.event.UserStateUpdateEvent;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.app.utils.PermissionUtils;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ca;
import com.tencent.mobileqq.vas.config.business.qvip.QVipServiceAccountFolderProcessor;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.request.GetAdInfoRequest;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.mobilereport.MobileReportManager;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ServiceAccountFolderActivityNew extends BaseActivity implements SimpleEventReceiver {

    /* renamed from: y0, reason: collision with root package name */
    public static boolean f79922y0;

    /* renamed from: a0, reason: collision with root package name */
    private View f79923a0;

    /* renamed from: b0, reason: collision with root package name */
    private View f79924b0;

    /* renamed from: c0, reason: collision with root package name */
    private ImageView f79925c0;

    /* renamed from: d0, reason: collision with root package name */
    private ImageView f79926d0;

    /* renamed from: e0, reason: collision with root package name */
    private ImageView f79927e0;

    /* renamed from: f0, reason: collision with root package name */
    private SquareImageView f79928f0;

    /* renamed from: g0, reason: collision with root package name */
    private RadioGroup f79929g0;

    /* renamed from: h0, reason: collision with root package name */
    private RadioButton f79930h0;

    /* renamed from: i0, reason: collision with root package name */
    private RadioButton f79931i0;

    /* renamed from: j0, reason: collision with root package name */
    private QQViewPager f79932j0;

    /* renamed from: k0, reason: collision with root package name */
    private e f79933k0;

    /* renamed from: m0, reason: collision with root package name */
    private String f79935m0;

    /* renamed from: n0, reason: collision with root package name */
    private String f79936n0;

    /* renamed from: o0, reason: collision with root package name */
    private ImageView f79937o0;

    /* renamed from: p0, reason: collision with root package name */
    private TopGestureLayout f79938p0;

    /* renamed from: q0, reason: collision with root package name */
    private boolean f79939q0;

    /* renamed from: r0, reason: collision with root package name */
    private long f79940r0;

    /* renamed from: s0, reason: collision with root package name */
    private int f79941s0;

    /* renamed from: t0, reason: collision with root package name */
    private boolean f79942t0;

    /* renamed from: u0, reason: collision with root package name */
    private ExtraTypeInfo f79943u0;

    /* renamed from: v0, reason: collision with root package name */
    private CertifiedAccountRead$StGetMainPageRsp f79944v0;

    /* renamed from: l0, reason: collision with root package name */
    private ArrayList<FolderBaseTabFragment> f79934l0 = new ArrayList<>();

    /* renamed from: w0, reason: collision with root package name */
    private boolean f79945w0 = true;

    /* renamed from: x0, reason: collision with root package name */
    View.OnClickListener f79946x0 = new a();

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!hf0.a.b("service_account_folder_publish_feed_button", 2000L)) {
                if (!PermissionUtils.isStorePermissionEnable(ServiceAccountFolderActivityNew.this)) {
                    DialogUtil.showPermissionDialogForStorage(ServiceAccountFolderActivityNew.this);
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("postUin", ServiceAccountFolderActivityNew.this.f79936n0);
                    intent.putExtra(GetAdInfoRequest.SOURCE_FROM, 2);
                    if (ServiceAccountFolderActivityNew.this.f79944v0 != null && ServiceAccountFolderActivityNew.this.f79944v0.user.youZhan.size() > 0) {
                        boolean z16 = true;
                        if (ServiceAccountFolderActivityNew.this.f79944v0.user.youZhan.get(0).type.get() <= 1) {
                            z16 = false;
                        }
                        intent.putExtra("has_shop", z16);
                    }
                    QZoneHelper.forwardToQQPublicAccountPublishPage(ServiceAccountFolderActivityNew.this.getActivity(), intent, 0);
                    if (ServiceAccountFolderActivityNew.this.f79944v0 != null) {
                        String str2 = ServiceAccountFolderActivityNew.this.f79944v0.user.get().f24929id.get();
                        if (ServiceAccountFolderActivityNew.this.f79941s0 == 0) {
                            str = "auth_follow";
                        } else {
                            str = "auth_discover";
                        }
                        VSReporter.n(str2, str, "post_clk", 0, 0, "", "");
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ServiceAccountFolderActivityNew.this.doOnBackPressed();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c implements RadioGroup.OnCheckedChangeListener {
        c() {
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup radioGroup, int i3) {
            EventCollector.getInstance().onRadioGroupCheckedBefore(radioGroup, i3);
            ServiceAccountFolderActivityNew.this.f79942t0 = true;
            if (ServiceAccountFolderActivityNew.this.f79930h0.getId() == i3) {
                ServiceAccountFolderActivityNew.this.f79932j0.setCurrentItem(0);
            } else if (ServiceAccountFolderActivityNew.this.f79931i0.getId() == i3) {
                ServiceAccountFolderActivityNew.this.f79932j0.setCurrentItem(1);
            }
            EventCollector.getInstance().onRadioGroupChecked(radioGroup, i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class e extends FragmentPagerAdapter {
        public e(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public BaseFragment getItem(int i3) {
            if (ServiceAccountFolderActivityNew.this.f79934l0.size() > i3) {
                return (BaseFragment) ServiceAccountFolderActivityNew.this.f79934l0.get(i3);
            }
            return null;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        /* renamed from: getCount */
        public int getF373114d() {
            return ServiceAccountFolderActivityNew.this.f79934l0.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class f implements VSDispatchObserver.OnVSRspCallBack<CertifiedAccountRead$StGetMainPageRsp> {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<ServiceAccountFolderActivityNew> f79952a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ ServiceAccountFolderActivityNew f79953d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ CertifiedAccountRead$StGetMainPageRsp f79954e;

            a(ServiceAccountFolderActivityNew serviceAccountFolderActivityNew, CertifiedAccountRead$StGetMainPageRsp certifiedAccountRead$StGetMainPageRsp) {
                this.f79953d = serviceAccountFolderActivityNew;
                this.f79954e = certifiedAccountRead$StGetMainPageRsp;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                this.f79953d.d3(this.f79954e);
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        public f(ServiceAccountFolderActivityNew serviceAccountFolderActivityNew) {
            this.f79952a = new WeakReference<>(serviceAccountFolderActivityNew);
        }

        private void b(CertifiedAccountRead$StGetMainPageRsp certifiedAccountRead$StGetMainPageRsp) {
            ServiceAccountFolderActivityNew serviceAccountFolderActivityNew = this.f79952a.get();
            if (serviceAccountFolderActivityNew == null) {
                hd0.c.k("ServiceAccountFolderActivityNew", "responseUpdateTitleUI activity is released!");
                return;
            }
            CertifiedAccountMeta$StUser certifiedAccountMeta$StUser = certifiedAccountRead$StGetMainPageRsp.user.get();
            serviceAccountFolderActivityNew.f79936n0 = certifiedAccountMeta$StUser.f24929id.get();
            String str = certifiedAccountMeta$StUser.icon.get();
            if (!TextUtils.isEmpty(certifiedAccountRead$StGetMainPageRsp.user.icon.get()) && URLUtil.isNetworkUrl(str)) {
                serviceAccountFolderActivityNew.f79928f0.setContentDescription(serviceAccountFolderActivityNew.getResources().getString(R.string.vsc));
                serviceAccountFolderActivityNew.f79928f0.setImageResource(R.drawable.mzu);
                serviceAccountFolderActivityNew.f79928f0.setOnClickListener(new a(serviceAccountFolderActivityNew, certifiedAccountRead$StGetMainPageRsp));
            }
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, CertifiedAccountRead$StGetMainPageRsp certifiedAccountRead$StGetMainPageRsp) {
            if (z16) {
                ServiceAccountFolderActivityNew serviceAccountFolderActivityNew = this.f79952a.get();
                if (serviceAccountFolderActivityNew == null) {
                    hd0.c.k("ServiceAccountFolderActivityNew", "sendRequest GetMainPage is success but activity is released!");
                    return;
                }
                if (certifiedAccountRead$StGetMainPageRsp != null) {
                    serviceAccountFolderActivityNew.f79944v0 = certifiedAccountRead$StGetMainPageRsp;
                    hd0.c.k("ServiceAccountFolderActivityNew", "sendRequest GetMainPage success");
                    b(certifiedAccountRead$StGetMainPageRsp);
                    serviceAccountFolderActivityNew.i3();
                    serviceAccountFolderActivityNew.j3(certifiedAccountRead$StGetMainPageRsp);
                    return;
                }
                return;
            }
            hd0.c.k("ServiceAccountFolderActivityNew", "sendRequest GetMainPage error retCode:" + j3 + ",errMsg:" + str);
        }
    }

    static {
        boolean z16 = false;
        if (QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_QQ_SUBSCRIBE_SETTING, QzoneConfig.SECONDARY_JUMP_TO_RECOMMEND_TAB, 0) > 0) {
            z16 = true;
        }
        f79922y0 = z16;
    }

    private COMM.StCommonExt c3() {
        COMM.StCommonExt stCommonExt = new COMM.StCommonExt();
        COMM.Entry entry = new COMM.Entry();
        entry.key.set("user_info");
        entry.value.set("1");
        stCommonExt.mapInfo.get().add(entry);
        return stCommonExt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d3(CertifiedAccountRead$StGetMainPageRsp certifiedAccountRead$StGetMainPageRsp) {
        CertifiedAccountMeta$StUser certifiedAccountMeta$StUser = certifiedAccountRead$StGetMainPageRsp.user;
        if (certifiedAccountMeta$StUser != null && certifiedAccountMeta$StUser.certifiedType.get() == 1) {
            String g36 = g3(g3(QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_SUBPERSONAL_HOMEPAGE_URL, QzoneConfig.DEFAULT_SUBPERSONAL_HOMEPAGE_URL), "{puin}", certifiedAccountRead$StGetMainPageRsp.user.f24929id.get()), "{openid}", "");
            try {
                Intent intent = new Intent();
                intent.putExtra("url", g36);
                intent.setClass(BaseApplication.getContext(), QQBrowserActivity.class);
                startActivity(intent);
                return;
            } catch (Exception e16) {
                QLog.e("ServiceAccountFolderActivityNew", 1, "start Intent error " + e16);
                return;
            }
        }
        CertifiedAccountMeta$StUser certifiedAccountMeta$StUser2 = certifiedAccountRead$StGetMainPageRsp.user;
        if (certifiedAccountMeta$StUser2 != null && certifiedAccountMeta$StUser2.type.get() == 1) {
            com.tencent.biz.subscribe.d.t(this, certifiedAccountRead$StGetMainPageRsp.user);
            VSReporter.o("auth_follow", "clk_head", 0, 0, new String[0]);
        } else {
            com.tencent.biz.subscribe.d.l("https://h5.qzone.qq.com/subscription/followlist?_proxy=1_wv=3");
        }
    }

    private void e3() {
        this.f79929g0.setOnCheckedChangeListener(new c());
        this.f79932j0.setOnPageChangeListener(new d());
        if (isStudyMode() || !this.f79945w0) {
            this.f79931i0.setVisibility(8);
        }
        ExtraTypeInfo extraTypeInfo = this.f79943u0;
        if (extraTypeInfo != null && extraTypeInfo.pageType == 7004 && !isStudyMode() && this.f79945w0) {
            this.f79932j0.setCurrentItem(0);
            MobileReportManager.getInstance().reportActionLive("", "", "qq_live", "find_page", "", 100, 1, System.currentTimeMillis(), "");
        } else {
            this.f79932j0.setCurrentItem(0);
            MobileReportManager.getInstance().reportActionLive("", "", "qq_live", "tab_page", "", 100, 1, System.currentTimeMillis(), "");
        }
        this.f79941s0 = this.f79932j0.getCurrentItem();
        this.f79940r0 = System.currentTimeMillis();
    }

    private static String g3(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (str.contains(str2)) {
            return str.replace(str2, str3);
        }
        return str.replace(str2.toUpperCase(), str3);
    }

    private void h3() {
        SubscribePersonalDetailRequest subscribePersonalDetailRequest = new SubscribePersonalDetailRequest(this.f79935m0, c3());
        subscribePersonalDetailRequest.setEnableCache(true);
        VSNetworkHelper.getInstance().sendRequest(subscribePersonalDetailRequest, new f(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i3() {
        CertifiedAccountMeta$StUser certifiedAccountMeta$StUser;
        CertifiedAccountRead$StGetMainPageRsp certifiedAccountRead$StGetMainPageRsp = this.f79944v0;
        if (certifiedAccountRead$StGetMainPageRsp != null && (certifiedAccountMeta$StUser = certifiedAccountRead$StGetMainPageRsp.user) != null && SubscribeUtils.p(certifiedAccountMeta$StUser.attr.get()) && !isStudyMode()) {
            this.f79927e0.setVisibility(8);
            VSReporter.n(this.f79944v0.user.get().f24929id.get(), "auth_person", "post_exp", 0, 0, "", "");
            this.f79927e0.setOnClickListener(this.f79946x0);
            return;
        }
        this.f79927e0.setVisibility(8);
    }

    private void initData() {
        this.f79943u0 = (ExtraTypeInfo) getIntent().getSerializableExtra(ExtraTypeInfo.KEY_SUBSCRIBE_INTENT_EXTRA_TYPE_INFO);
        this.f79934l0.add(new FolderFollowTabFragment());
        this.f79945w0 = QVipServiceAccountFolderProcessor.getConfig().showRecommendPage;
        if (!isStudyMode() && this.f79945w0) {
            if (py.a.a()) {
                this.f79934l0.add(new FolderRecommendQCircleTabFragment());
            } else {
                this.f79934l0.add(new FolderRecommendTabFragment());
            }
        }
        this.f79935m0 = this.app.getAccount();
    }

    private void initTitleBar() {
        this.f79937o0 = (ImageView) findViewById(R.id.mb5);
        ImageView imageView = (ImageView) findViewById(R.id.f165943lo1);
        this.f79925c0 = imageView;
        imageView.setOnClickListener(new b());
        this.f79926d0 = (ImageView) findViewById(R.id.lrn);
        this.f79928f0 = (SquareImageView) findViewById(R.id.lro);
        if (this.f79939q0) {
            this.f79925c0.setImageDrawable(getResources().getDrawable(R.drawable.d6g));
            this.f79926d0.setImageDrawable(getResources().getDrawable(R.drawable.hlm));
            this.f79928f0.setFilterColor(1711276032);
        }
        this.f79926d0.setVisibility(8);
        this.f79928f0.setVisibility(8);
        h3();
    }

    private void initView() {
        this.f79923a0 = findViewById(R.id.iop);
        this.f79924b0 = findViewById(R.id.m6n);
        this.f79929g0 = (RadioGroup) findViewById(R.id.f166790m62);
        this.f79930h0 = (RadioButton) findViewById(R.id.m4w);
        this.f79931i0 = (RadioButton) findViewById(R.id.m4x);
        this.f79932j0 = (QQViewPager) findViewById(R.id.mft);
        Iterator<FolderBaseTabFragment> it = this.f79934l0.iterator();
        while (it.hasNext()) {
            FolderBaseTabFragment next = it.next();
            if (next instanceof FolderFollowTabFragment) {
                ((FolderFollowTabFragment) next).Rh(this.f79932j0);
            }
        }
        e eVar = new e(getSupportFragmentManager());
        this.f79933k0 = eVar;
        this.f79932j0.setAdapter(eVar);
        this.f79932j0.setOffscreenPageLimit(1);
        this.f79927e0 = (ImageView) findViewById(R.id.bb_);
        if (this.f79939q0) {
            this.f79924b0.setBackgroundColor(-16777216);
            this.f79930h0.setTextColor(getResources().getColor(R.color.f156856a0));
            this.f79930h0.setBackgroundDrawable(getResources().getDrawable(R.drawable.hbd));
            this.f79931i0.setTextColor(getResources().getColor(R.color.f156856a0));
            this.f79931i0.setBackgroundDrawable(getResources().getDrawable(R.drawable.hbd));
            this.f79927e0.setImageDrawable(getResources().getDrawable(R.drawable.f160419hm4));
            this.f79927e0.setColorFilter(1308622848);
        }
        initTitleBar();
        e3();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j3(CertifiedAccountRead$StGetMainPageRsp certifiedAccountRead$StGetMainPageRsp) {
        e eVar;
        if (certifiedAccountRead$StGetMainPageRsp.messStatus.get() != null && (eVar = this.f79933k0) != null && eVar.getItem(0) != null && (this.f79933k0.getItem(0) instanceof FolderFollowTabFragment)) {
            ((FolderFollowTabFragment) this.f79933k0.getItem(0)).Uh(certifiedAccountRead$StGetMainPageRsp.messStatus.noticeCount.get());
        }
    }

    public void b3(boolean z16) {
        TopGestureLayout topGestureLayout = getTopGestureLayout();
        if (topGestureLayout != null) {
            topGestureLayout.setInterceptTouchFlag(z16);
        }
        if (QLog.isColorLevel()) {
            QLog.d("ServiceAccountFolderActivityNew", 2, "enableFlingRight->enable:" + z16);
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        super.doOnCreate(bundle);
        setContentView(R.layout.c9t);
        ca.a(this);
        this.f79939q0 = SubscribeUtils.m();
        initData();
        initView();
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            this.f79923a0.setFitsSystemWindows(true);
            this.f79923a0.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
        }
        SimpleEventBus.getInstance().registerReceiver(this);
        VideoReport.addToDetectionWhitelist(this);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        String str;
        super.doOnDestroy();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        try {
            com.tencent.biz.subscribe.a.a();
        } catch (Exception e16) {
            QLog.e("ServiceAccountFolderActivityNew", 1, e16, new Object[0]);
        }
        if (this.f79940r0 > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.f79940r0;
            if (this.f79941s0 == FolderBaseTabFragment.G) {
                str = "auth_follow";
            } else {
                str = "auth_discover";
            }
            VSReporter.m(str, "exp", 0, 0, String.valueOf(currentTimeMillis));
            this.f79940r0 = 0L;
        }
        this.f79934l0.clear();
        VSNetworkHelper.getInstance().cancelRequest(BaseApplication.getContext());
        ServiceAccountFolderNTManager serviceAccountFolderNTManager = ServiceAccountFolderNTManager.f79965a;
        serviceAccountFolderNTManager.t();
        serviceAccountFolderNTManager.s();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        super.doOnResume();
    }

    public boolean f3() {
        if (this.f79937o0.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(UserStateUpdateEvent.class);
        return arrayList;
    }

    protected TopGestureLayout getTopGestureLayout() {
        if (this.f79938p0 == null) {
            ViewGroup viewGroup = (ViewGroup) getWindow().getDecorView();
            View childAt = viewGroup.getChildAt(0);
            if (childAt != null && (childAt instanceof DragFrameLayout)) {
                viewGroup = (ViewGroup) childAt;
            }
            View childAt2 = viewGroup.getChildAt(0);
            if (childAt2 instanceof TopGestureLayout) {
                this.f79938p0 = (TopGestureLayout) childAt2;
            }
        }
        return this.f79938p0;
    }

    public boolean isStudyMode() {
        return StudyModeManager.t();
    }

    public void l3(int i3) {
        if ((i3 == 0 && this.f79932j0.getCurrentItem() != 0) || i3 == 8) {
            this.f79937o0.setVisibility(i3);
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof UserStateUpdateEvent) {
            h3();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class d implements ViewPager.OnPageChangeListener {
        d() {
        }

        private void a(int i3) {
            String str = "1";
            if (i3 == FolderBaseTabFragment.G) {
                String[] strArr = new String[1];
                if (!ServiceAccountFolderActivityNew.this.f79942t0) {
                    str = "2";
                }
                strArr[0] = str;
                VSReporter.o("auth_discover", "tofollow", 0, 0, strArr);
                MobileReportManager.getInstance().reportActionLive("", "", "qq_live", "tab_page", "", 100, 1, System.currentTimeMillis(), "");
                return;
            }
            String[] strArr2 = new String[1];
            if (!ServiceAccountFolderActivityNew.this.f79942t0) {
                str = "2";
            }
            strArr2[0] = str;
            VSReporter.o("auth_follow", "todiscover", 0, 0, strArr2);
            MobileReportManager.getInstance().reportActionLive("", "", "qq_live", "find_page", "", 100, 1, System.currentTimeMillis(), "");
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i3) {
            String str;
            a(i3);
            if (ServiceAccountFolderActivityNew.this.f79929g0 != null && ServiceAccountFolderActivityNew.this.f79929g0.getChildCount() > i3) {
                ServiceAccountFolderActivityNew.this.f79929g0.getChildAt(i3).performClick();
                ServiceAccountFolderActivityNew.this.f79942t0 = false;
            }
            if (ServiceAccountFolderActivityNew.this.f79934l0.size() > i3) {
                ((FolderBaseTabFragment) ServiceAccountFolderActivityNew.this.f79934l0.get(i3)).qh(ServiceAccountFolderActivityNew.this, i3);
            }
            if (ServiceAccountFolderActivityNew.this.f79940r0 > 0) {
                long currentTimeMillis = System.currentTimeMillis() - ServiceAccountFolderActivityNew.this.f79940r0;
                if (ServiceAccountFolderActivityNew.this.f79941s0 == FolderBaseTabFragment.G) {
                    str = "auth_follow";
                } else {
                    str = "auth_discover";
                }
                VSReporter.m(str, "exp", 0, 0, String.valueOf(currentTimeMillis));
                ServiceAccountFolderActivityNew.this.f79940r0 = 0L;
            }
            ServiceAccountFolderActivityNew.this.f79940r0 = System.currentTimeMillis();
            ServiceAccountFolderActivityNew.this.f79941s0 = i3;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i3) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i3, float f16, int i16) {
        }
    }
}
