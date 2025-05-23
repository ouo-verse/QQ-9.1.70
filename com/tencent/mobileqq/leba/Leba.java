package com.tencent.mobileqq.leba;

import android.content.res.Configuration;
import android.os.SystemClock;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.Page;
import com.tencent.cache.api.PageHierarchy;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QIphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.leba.Leba;
import com.tencent.mobileqq.leba.business.ILebaRichApi;
import com.tencent.mobileqq.leba.core.LebaHelper;
import com.tencent.mobileqq.leba.list.LebaPluginListView;
import com.tencent.mobileqq.leba.logic.LebaPluginLogic;
import com.tencent.mobileqq.leba.view.LebaDrawablePreloadHelper;
import com.tencent.mobileqq.leba.view.LebaListItemPreLoader;
import com.tencent.mobileqq.leba.zplan.widget.PullToZoomHeaderFrameLayout;
import com.tencent.mobileqq.leba.zplan.widget.ZplanFrameLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mobileqq.resconfig.MainResourceConfig;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.StudyModeChangeListener;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.tianshu.api.IRedPointReportManager;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.api.IRedTouchServer;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.TianshuRedTouch;
import com.tencent.mobileqq.util.af;
import com.tencent.mobileqq.utils.QQSettingMeABTestHelper;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.CommonLoadingView;
import com.tencent.mobileqq.widget.RoundRelativeLayout;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.utils.api.IZPlanAccessibleHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.shadow.dynamic.host.Constant;
import com.tencent.theme.TextHook;
import com.tencent.util.AbiUtil;
import com.tencent.util.QUITokenResCompat;
import com.tencent.util.QUITokenResUtil;
import cooperation.qzone.QZoneHelper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.app.api.ProcessConstant;

/* compiled from: P */
@Page(business = Business.Leba, type = PageHierarchy.MainPage)
/* loaded from: classes15.dex */
public class Leba extends Frame implements ViewStub.OnInflateListener, CommonLoadingView.a {
    static IPatchRedirector $redirector_ = null;
    public static final int LEBA_ZPLAN_TOP_CORNER_DP = 20;
    public static final String TAG = "LebaFrame";
    private long createTime;
    public ImageView lebaBgImageView;
    private PullToZoomHeaderFrameLayout lebaContainer;
    private RoundRelativeLayout lebaLayout;
    private LebaPluginListView lebaPluginListView;
    private boolean mHasInited;
    private ZplanFrameLayout mHeaderContainerView;
    private boolean mIsZplanSwitchOn;
    private z62.b mLebaZplanControlManager;
    private boolean mNowThemeIsAnimate;
    public ILebaRichApi mRichApi;
    private ImageView mRightLebaSetting;
    private ImageView mRightManageIcon;
    private View mRootView;
    public StudyModeChangeListener mStudyModeChangeListener;
    public IStudyModeManager mStudyModeManager;
    private TextView mTitle;
    private RelativeLayout mTitleArea;
    private ji3.k mZPlanSwitchChangeListener;
    private z62.f mZplanHeaderLayout;
    private final com.tencent.mobileqq.leba.view.f preInflateHelper;
    private final MainResourceConfig resConfig;
    private RelativeLayout statustitle;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a implements ViewTreeObserver.OnDrawListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private boolean f240088d;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) Leba.this);
            } else {
                this.f240088d = true;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(ViewTreeObserver viewTreeObserver) {
            try {
                viewTreeObserver.removeOnDrawListener(this);
            } catch (Exception e16) {
                QLog.e(Leba.TAG, 1, "onDrawListener removeOnDrawListener error ", e16);
            }
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public void onDraw() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (this.f240088d) {
                ((CommonLoadingView) Leba.this.findViewById(R.id.b5t)).setVisibility(8);
                QLog.i(Leba.TAG, 4, "timeTrace loading invisible");
                final ViewTreeObserver viewTreeObserver = Leba.this.lebaContainer.getViewTreeObserver();
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.leba.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        Leba.a.this.b(viewTreeObserver);
                    }
                });
            }
            this.f240088d = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b extends RecyclerView.OnScrollListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) Leba.this);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) recyclerView, i3);
                return;
            }
            if (Leba.this.mNowThemeIsAnimate) {
                if (i3 != 0) {
                    ApngImage.pauseByTag(4);
                    if (QLog.isColorLevel()) {
                        QLog.e(Leba.TAG, 2, "onScrollStateChanged not SCROLL_STATE_IDLE");
                        return;
                    }
                    return;
                }
                ApngImage.playByTag(4);
                if (QLog.isColorLevel()) {
                    QLog.e(Leba.TAG, 2, "onScrollStateChanged SCROLL_STATE_IDLE");
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, recyclerView, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                super.onScrolled(recyclerView, i3, i16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class c implements StudyModeChangeListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<Leba> f240091d;

        c(Leba leba) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) leba);
            } else {
                this.f240091d = new WeakReference<>(leba);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void b(Leba leba) {
            leba.refreshZplanCover();
            leba.onPostThemeChanged();
        }

        @Override // com.tencent.mobileqq.studymode.StudyModeChangeListener
        public void onChange(boolean z16) {
            final Leba leba;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
                return;
            }
            WeakReference<Leba> weakReference = this.f240091d;
            if (weakReference == null || (leba = weakReference.get()) == null) {
                return;
            }
            QLog.i(Leba.TAG, 1, "StudyModeChange onChange " + z16);
            com.tencent.mobileqq.leba.util.a.b(new Runnable() { // from class: com.tencent.mobileqq.leba.k
                @Override // java.lang.Runnable
                public final void run() {
                    Leba.c.b(Leba.this);
                }
            });
        }
    }

    public Leba() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mIsZplanSwitchOn = false;
        this.mHasInited = false;
        this.createTime = 0L;
        this.mNowThemeIsAnimate = false;
        this.resConfig = MainResourceConfig.i();
        this.preInflateHelper = new com.tencent.mobileqq.leba.view.f();
        this.mZPlanSwitchChangeListener = new ji3.k() { // from class: com.tencent.mobileqq.leba.a
            @Override // ji3.k
            public final void onChange(boolean z16) {
                Leba.this.lambda$new$0(z16);
            }
        };
    }

    private void adjustTitleBar(boolean z16) {
        if (z16) {
            updateRightManageIcon();
            this.mTitle.setVisibility(0);
            updateTitleBar(this.mTitleArea, this.resConfig);
        } else {
            this.mTitleArea.setBackgroundColor(0);
            this.mTitle.setVisibility(8);
        }
        refreshHead(z16);
        refreshLebaLayout(z16);
    }

    private static View.OnTouchListener buildTitleAreaOnTouchListener(final WeakReference<Leba> weakReference) {
        return new View.OnTouchListener() { // from class: com.tencent.mobileqq.leba.e
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean lambda$buildTitleAreaOnTouchListener$7;
                lambda$buildTitleAreaOnTouchListener$7 = Leba.lambda$buildTitleAreaOnTouchListener$7(weakReference, view, motionEvent);
                return lambda$buildTitleAreaOnTouchListener$7;
            }
        };
    }

    private boolean checkZplanSettingFunctionEnable() {
        int e16 = LebaPluginLogic.e();
        if (e16 != 0 && e16 != 2) {
            return false;
        }
        return true;
    }

    private boolean disableLebaSetting() {
        if (((ILebaHelperService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(ILebaHelperService.class, "")).isFeedGoOffline()) {
            return true;
        }
        if (!AppSetting.t(getActivity())) {
            return false;
        }
        if (!((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).isZplanAccessibleWithoutSetting(Constant.FROM_ID_UNINSTALL_PLUGIN, this.app.getLongAccountUin()) || QQSettingMeABTestHelper.e().f() || !((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).enableZPlanNativeAppFilament(0)) {
            return true;
        }
        return false;
    }

    private void gotoListMgrActivity(boolean z16) {
        QLog.i(TAG, 1, "gotoListMgrActivity: " + z16);
        ReportController.o(this.app, "CliOper", "", "", "trends_tab", "click_tt_right", 0, 0, "", "", "", "");
        ((IRedTouchManager) this.app.getRuntimeService(IRedTouchManager.class, "")).onRedTouchItemClick("150000");
        com.tencent.mobileqq.leba.core.e.a().f240377c = true;
        com.tencent.mobileqq.leba.core.f.q(getActivity(), this.app, z16, 1);
    }

    private void initLebaView() {
        View findViewById;
        if (this.lebaContainer == null) {
            this.lebaBgImageView = (ImageView) findViewById(R.id.e6u);
            z62.b bVar = new z62.b(this, this.mZplanHeaderLayout);
            this.mLebaZplanControlManager = bVar;
            ZplanFrameLayout zplanFrameLayout = this.mHeaderContainerView;
            if (zplanFrameLayout != null) {
                zplanFrameLayout.setZPlanHandleEventListener(bVar);
            }
            PullToZoomHeaderFrameLayout pullToZoomHeaderFrameLayout = (PullToZoomHeaderFrameLayout) findViewById(R.id.yge);
            this.lebaContainer = pullToZoomHeaderFrameLayout;
            pullToZoomHeaderFrameLayout.setHandleEvent(this.mLebaZplanControlManager);
            if (getActivity() == null) {
                findViewById = null;
            } else {
                findViewById = getActivity().findViewById(af.f());
            }
            if (findViewById != null) {
                this.lebaContainer.setPadding(0, 0, 0, findViewById.getHeight());
            }
            this.mLebaZplanControlManager.f452046h = this.lebaContainer;
            this.lebaPluginListView = (LebaPluginListView) findViewById(R.id.f25990cb);
            this.lebaContainer.getViewTreeObserver().addOnDrawListener(new a());
            this.lebaPluginListView.l(new b());
        }
        if (this.lebaLayout == null) {
            RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) findViewById(R.id.j8y);
            this.lebaLayout = roundRelativeLayout;
            roundRelativeLayout.f316195e = ViewUtils.dpToPx(20.0f);
        }
        updateContentBg();
    }

    private void initTitleBar() {
        this.statustitle = (RelativeLayout) this.mRootView.findViewById(R.id.jo9);
        QIphoneTitleBarActivity.setLayerType((ViewGroup) findViewById(R.id.rlCommenTitle));
        this.mTitleArea = (RelativeLayout) findViewById(R.id.f166034e70);
        TextView textView = (TextView) findViewById(R.id.ivTitleName);
        this.mTitle = textView;
        textView.setText(R.string.hvs);
        MainResourceConfig.s(this.mTitle);
        ImageView imageView = (ImageView) findViewById(R.id.ivTitleBtnRightImage);
        this.mRightManageIcon = imageView;
        imageView.setOnClickListener(com.tencent.mobileqq.leba.view.d.a(new View.OnClickListener() { // from class: com.tencent.mobileqq.leba.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Leba.this.lambda$initTitleBar$5(view);
            }
        }));
        ImageView imageView2 = (ImageView) findViewById(R.id.xzc);
        this.mRightLebaSetting = imageView2;
        imageView2.setOnClickListener(com.tencent.mobileqq.leba.view.d.a(new View.OnClickListener() { // from class: com.tencent.mobileqq.leba.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Leba.this.lambda$initTitleBar$6(view);
            }
        }));
        com.tencent.mobileqq.leba.report.d.m(this.mRightManageIcon);
        this.mTitleArea.setOnTouchListener(buildTitleAreaOnTouchListener(new WeakReference(this)));
        refreshTitleBar();
        refreshTitleRightBtnRes();
    }

    private void initZplanCover() {
        if (this.mHeaderContainerView == null || this.mZplanHeaderLayout == null) {
            ZplanFrameLayout zplanFrameLayout = (ZplanFrameLayout) findViewById(R.id.x8_);
            this.mHeaderContainerView = zplanFrameLayout;
            z62.f fVar = new z62.f((ViewGroup) this.mRootView, zplanFrameLayout, getActivity());
            this.mZplanHeaderLayout = fVar;
            fVar.m();
        }
        Integer e16 = ni3.a.f420201a.e();
        if ((e16 != null && this.mHeaderContainerView != null && this.mLebaZplanControlManager == null) || this.mLebaZplanControlManager.f452045g == 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mHeaderContainerView.getLayoutParams();
            layoutParams.height = e16.intValue();
            this.mHeaderContainerView.setLayoutParams(layoutParams);
        }
        refreshZplanCover();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$buildTitleAreaOnTouchListener$7(WeakReference weakReference, View view, MotionEvent motionEvent) {
        z62.b bVar;
        Leba leba = (Leba) weakReference.get();
        if (leba == null || !leba.mIsZplanSwitchOn || (bVar = leba.mLebaZplanControlManager) == null || bVar.f452045g != -1) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initTitleBar$5(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        gotoListMgrActivity(false);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initTitleBar$6(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        ((ILebaUIStyleSettingApi) QRoute.api(ILebaUIStyleSettingApi.class)).openStyleSetting(getActivity());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(boolean z16) {
        QLog.i(TAG, 1, "zplanSettingChange: " + this.mIsZplanSwitchOn + "->" + z16);
        if (this.mIsZplanSwitchOn == z16) {
            return;
        }
        this.mIsZplanSwitchOn = z16;
        onZplanSwitchChange();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyResume$1() {
        com.tencent.mobileqq.leba.utils.a.c(this.mRightManageIcon, HardCodeUtil.qqStr(R.string.f162061ze), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onAccountChanged$4() {
        refreshZplanCover();
        updateUserZPlanInfo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onZplanSwitchChange$2() {
        z62.b bVar;
        refreshZplanCover();
        if (checkZplanEnable() && (bVar = this.mLebaZplanControlManager) != null && bVar.f452045g == -1) {
            bVar.u();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$updateUserZPlanInfo$8() {
        z62.f fVar = this.mZplanHeaderLayout;
        if (fVar != null) {
            fVar.M();
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onSwitchToLebaDelay, reason: merged with bridge method [inline-methods] */
    public void lambda$onSwitchToLeba$3(boolean z16, BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo) {
        if (this.app == null) {
            return;
        }
        ReportController.o(this.app, "CliOper", "", "", "trends_tab", "click_trends_tab", 0, 0, "", "", String.valueOf(com.tencent.mobileqq.leba.report.f.b(z16, redTypeInfo)), "");
        onLebaTabChange();
        if (z16) {
            IRedTouchManager iRedTouchManager = (IRedTouchManager) this.app.getRuntimeService(IRedTouchManager.class, "");
            if (TianshuRedTouch.INSTANCE.j()) {
                ((IRedPointReportManager) QRoute.api(IRedPointReportManager.class)).reportLevelZeroClick(0);
            } else {
                iRedTouchManager.reportLevelZeroRedInfo(0, 31);
            }
        }
    }

    private void onZplanSwitchChange() {
        com.tencent.mobileqq.leba.report.d.r(getActivity(), this.mRootView, "pg_discover_list_primary_page", checkZplanEnable());
        getActivity().runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.leba.c
            @Override // java.lang.Runnable
            public final void run() {
                Leba.this.lambda$onZplanSwitchChange$2();
            }
        });
    }

    private void refreshHead(boolean z16) {
        View view;
        boolean z17;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "refreshHead:" + z16);
        }
        try {
            view = getActivity().findViewById(R.id.e3u);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "refreshHead exception ", e16);
            view = null;
        }
        FrameFragment a16 = com.tencent.mobileqq.leba.controller.a.f240329a.a();
        if (view != null) {
            if (view.getVisibility() == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (a16 != null) {
                if (a16.getCurrentFrame() == this) {
                    if (z16) {
                        a16.setQQHeadVisibility(0, "leba_refresh_head");
                    } else {
                        a16.setQQHeadVisibility(8, "leba_refresh_head");
                    }
                } else {
                    QLog.i(TAG, 1, "refreshHead fm current frame not leba");
                }
            } else {
                QLog.i(TAG, 1, "FrameFragment is null, show:" + z16);
            }
            MainResourceConfig.s(this.mTitle);
            if (z17 != z16) {
                refreshTitleRightBtnRes();
            }
        }
    }

    private void refreshTitleRightBtnRes() {
        boolean z16;
        View findViewById;
        if (checkZplanEnable() && (findViewById = getActivity().findViewById(R.id.e3u)) != null && findViewById.getVisibility() != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        int[][] iArr = {new int[]{android.R.attr.state_pressed}, new int[0]};
        if (z16) {
            ImageView imageView = this.mRightManageIcon;
            imageView.setImageDrawable(QUITokenResCompat.getStateListDrawable(imageView.getContext(), iArr, new int[]{R.drawable.f160900jv0, R.drawable.juz}));
            this.mRightManageIcon.setBackgroundResource(R.drawable.krr);
            ImageView imageView2 = this.mRightLebaSetting;
            imageView2.setImageDrawable(QUITokenResCompat.getStateListDrawable(imageView2.getContext(), iArr, new int[]{R.drawable.qui_setting_vas_icon_white_press, R.drawable.qui_setting_vas_icon_white}));
            this.mRightLebaSetting.setBackgroundResource(R.drawable.krr);
            return;
        }
        ImageView imageView3 = this.mRightManageIcon;
        imageView3.setImageDrawable(QUITokenResCompat.getStateListDrawable(imageView3.getContext(), iArr, new int[]{R.drawable.juy, R.drawable.jux}));
        this.mRightManageIcon.setBackground(null);
        ImageView imageView4 = this.mRightLebaSetting;
        imageView4.setImageDrawable(QUITokenResCompat.getStateListDrawable(imageView4.getContext(), iArr, new int[]{R.drawable.qui_setting_vas_icon_navigation_01_press, R.drawable.qui_setting_vas_icon_navigation_01}));
        this.mRightLebaSetting.setBackground(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshZplanCover() {
        z62.b bVar;
        QLog.d(TAG, 1, "refreshZplanCover ");
        refreshTitleBar();
        refreshTitleRightBtnRes();
        if (checkZplanEnable()) {
            if (this.mHeaderContainerView != null) {
                Integer e16 = ni3.a.f420201a.e();
                if (e16 != null && (bVar = this.mLebaZplanControlManager) != null && bVar.f452045g == 0) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mHeaderContainerView.getLayoutParams();
                    layoutParams.height = e16.intValue();
                    this.mHeaderContainerView.setLayoutParams(layoutParams);
                }
                this.mHeaderContainerView.setVisibility(0);
            }
            View findViewById = findViewById(R.id.j8y);
            if (findViewById != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams2.addRule(3, R.id.x8_);
                findViewById.setLayoutParams(layoutParams2);
            }
            z62.f fVar = this.mZplanHeaderLayout;
            if (fVar != null) {
                fVar.N();
            }
            z62.b bVar2 = this.mLebaZplanControlManager;
            if (bVar2 != null) {
                bVar2.p();
            }
            if (this.lebaBgImageView != null && ThemeUtil.useNativeThemeVideoPlayer()) {
                this.lebaBgImageView.setImageResource(R.drawable.qui_common_bg_bottom_standard_bg);
                return;
            }
            return;
        }
        View findViewById2 = findViewById(R.id.j8y);
        if (findViewById2 != null) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) findViewById2.getLayoutParams();
            layoutParams3.addRule(3, R.id.jo9);
            findViewById2.setLayoutParams(layoutParams3);
        }
        ZplanFrameLayout zplanFrameLayout = this.mHeaderContainerView;
        if (zplanFrameLayout != null) {
            zplanFrameLayout.setVisibility(8);
        }
        z62.f fVar2 = this.mZplanHeaderLayout;
        if (fVar2 != null) {
            fVar2.K();
        }
        if (this.lebaBgImageView != null && ThemeUtil.useNativeThemeVideoPlayer()) {
            this.lebaBgImageView.setImageDrawable(null);
            this.lebaBgImageView.setBackgroundColor(0);
        }
    }

    private void removeObservers() {
        StudyModeChangeListener studyModeChangeListener;
        if (this.app != null) {
            IStudyModeManager iStudyModeManager = this.mStudyModeManager;
            if (iStudyModeManager != null && (studyModeChangeListener = this.mStudyModeChangeListener) != null) {
                iStudyModeManager.unregisterStudyModeChangeListener(studyModeChangeListener);
            } else {
                com.tencent.mobileqq.leba.core.f.w(TAG, "removeObservers", "StudyModeManager");
            }
        }
        LebaPluginListView lebaPluginListView = this.lebaPluginListView;
        if (lebaPluginListView != null) {
            lebaPluginListView.t();
        } else {
            com.tencent.mobileqq.leba.core.f.w(TAG, "removeObservers", "ThirdParts");
        }
    }

    private void updateRightManageIcon() {
        int e16 = LebaPluginLogic.e();
        ImageView imageView = this.mRightManageIcon;
        int i3 = 0;
        if (imageView != null) {
            if (e16 == 1) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
            }
        }
        if (this.mRightLebaSetting != null) {
            if (disableLebaSetting()) {
                this.mRightLebaSetting.setVisibility(8);
                return;
            }
            boolean checkZplanSettingFunctionEnable = checkZplanSettingFunctionEnable();
            ImageView imageView2 = this.mRightLebaSetting;
            if (!checkZplanSettingFunctionEnable) {
                i3 = 8;
            }
            imageView2.setVisibility(i3);
            if (checkZplanSettingFunctionEnable) {
                com.tencent.mobileqq.leba.report.d.v(getActivity(), this.mRightLebaSetting, "em_setting_button");
            }
        }
    }

    private void updateTitleBar(RelativeLayout relativeLayout, MainResourceConfig mainResourceConfig) {
        relativeLayout.setBackground(mainResourceConfig.p(getActivity(), relativeLayout.getBackground()));
        int q16 = mainResourceConfig.q(getActivity());
        if (relativeLayout.getLayoutParams() == null) {
            relativeLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, q16));
        } else {
            relativeLayout.getLayoutParams().height = q16;
        }
    }

    private void updateUserZPlanInfo() {
        QLog.i(TAG, 1, "updateUserZPlanInfo onAccountChanged");
        String currentUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin();
        ArrayList arrayList = new ArrayList();
        arrayList.add(currentUin);
        ((IZPlanApi) QRoute.api(IZPlanApi.class)).requireUserZPlanInfo(arrayList, new Function0() { // from class: com.tencent.mobileqq.leba.g
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit lambda$updateUserZPlanInfo$8;
                lambda$updateUserZPlanInfo$8 = Leba.this.lambda$updateUserZPlanInfo$8();
                return lambda$updateUserZPlanInfo$8;
            }
        });
    }

    public boolean checkZplanEnable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        if (!this.mIsZplanSwitchOn) {
            QLog.d(TAG, 2, "checkZplanEnable mIsZplanSwitchOn false");
            return false;
        }
        if (!checkZplanSettingFunctionEnable()) {
            QLog.d(TAG, 2, "checkZplanEnable checkZplanSettingFunctionEnable false ");
            return false;
        }
        return !QQSettingMeABTestHelper.e().f();
    }

    public void dismissUserGuide() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
        } else {
            this.mZplanHeaderLayout.y();
        }
    }

    @Override // com.tencent.mobileqq.app.Frame
    public void fillData(boolean z16) {
        LebaPluginListView lebaPluginListView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, z16);
            return;
        }
        initZplanCover();
        try {
            initLebaView();
        } catch (Exception e16) {
            QLog.e(TAG, 1, "leba fillData->initLebaView exception:" + e16, e16);
        }
        ((ILebaHelperService) this.app.getRuntimeService(ILebaHelperService.class, ProcessConstant.MULTI)).initLebaHelper();
        LebaPluginListView lebaPluginListView2 = this.lebaPluginListView;
        if (lebaPluginListView2 != null) {
            lebaPluginListView2.k();
        } else {
            com.tencent.mobileqq.leba.core.f.w(TAG, "fillData", "ThirdParts");
        }
        if (this.mStudyModeManager != null) {
            if (this.mStudyModeChangeListener == null) {
                this.mStudyModeChangeListener = new c(this);
            }
            this.mStudyModeManager.registerStudyModeChangeListener(this.mStudyModeChangeListener);
        } else {
            com.tencent.mobileqq.leba.core.f.w(TAG, "fillData", "StudyModeManager");
        }
        if (z16 && (lebaPluginListView = this.lebaPluginListView) != null) {
            lebaPluginListView.m();
        }
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.be
    public String getLastActivityName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return HardCodeUtil.qqStr(R.string.hvs);
    }

    public int getStatusTitleBottom() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Integer) iPatchRedirector.redirect((short) 27, (Object) this)).intValue();
        }
        RelativeLayout relativeLayout = this.statustitle;
        if (relativeLayout == null) {
            return 0;
        }
        return relativeLayout.getBottom();
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.be
    public boolean hasInited() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.mHasInited;
    }

    public void initAPI() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (this.mRichApi == null) {
            this.mRichApi = (ILebaRichApi) QRoute.api(ILebaRichApi.class);
        }
        if (this.mStudyModeManager == null) {
            this.mStudyModeManager = (IStudyModeManager) QRoute.api(IStudyModeManager.class);
        }
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.ba
    public void notifyConfigurationChanged(Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) configuration);
            return;
        }
        super.notifyConfigurationChanged(configuration);
        QLog.d(TAG, 2, "onConfigurationChanged, newConfig : " + configuration);
        z62.b bVar = this.mLebaZplanControlManager;
        if (bVar != null) {
            bVar.k(configuration);
        }
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.ba
    public void notifyCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.notifyCreate();
        LebaDrawablePreloadHelper.e();
        initAPI();
        this.mIsZplanSwitchOn = ((IZPlanApi) QRoute.api(IZPlanApi.class)).isQzoneEntranceEnabled(this.app.getLongAccountUin());
        LebaPluginListView lebaPluginListView = this.lebaPluginListView;
        if (lebaPluginListView != null) {
            lebaPluginListView.n();
        } else {
            com.tencent.mobileqq.leba.core.f.w(TAG, "onCreate", "lebaPluginListView");
        }
        initTitleBar();
        ViewStub viewStub = (ViewStub) findViewById(R.id.j5j);
        if (viewStub != null) {
            viewStub.setOnInflateListener(this);
        }
        ((CommonLoadingView) findViewById(R.id.b5t)).setOnFirstDrawListener(this);
        LebaListItemPreLoader.d(this.preInflateHelper);
        View view = this.mRootView;
        if (view instanceof ViewGroup) {
            LebaListItemPreLoader.e((ViewGroup) view);
        }
        this.createTime = SystemClock.uptimeMillis();
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.ba
    public View notifyCreateView(LayoutInflater layoutInflater) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (View) iPatchRedirector.redirect((short) 21, (Object) this, (Object) layoutInflater);
        }
        View inflate = layoutInflater.inflate(R.layout.f168251q7, (ViewGroup) null);
        this.mRootView = inflate;
        return inflate;
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.ba
    public void notifyDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        removeObservers();
        LebaPluginListView lebaPluginListView = this.lebaPluginListView;
        if (lebaPluginListView != null) {
            lebaPluginListView.o();
        } else {
            com.tencent.mobileqq.leba.core.f.w(TAG, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "ThirdParts");
        }
        z62.b bVar = this.mLebaZplanControlManager;
        if (bVar != null) {
            bVar.l();
            this.mLebaZplanControlManager = null;
        }
        z62.f fVar = this.mZplanHeaderLayout;
        if (fVar != null) {
            fVar.Q();
            this.mZplanHeaderLayout.K();
        }
        ((IZPlanApi) QRoute.api(IZPlanApi.class)).setOnSettingChangeListener((AppInterface) this.app, Constant.FROM_ID_UNINSTALL_PLUGIN, null);
        ZplanFrameLayout zplanFrameLayout = this.mHeaderContainerView;
        if (zplanFrameLayout != null) {
            zplanFrameLayout.a();
            this.mHeaderContainerView = null;
        }
        CommonLoadingView commonLoadingView = (CommonLoadingView) findViewById(R.id.b5t);
        if (commonLoadingView != null) {
            commonLoadingView.setOnFirstDrawListener(null);
        }
        LebaDrawablePreloadHelper.b();
        LebaListItemPreLoader.f(this.preInflateHelper);
        com.tencent.mobileqq.leba.utils.f.a(getActivity());
        super.notifyDestroy();
        this.mZPlanSwitchChangeListener = null;
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.ba
    public void notifyPause(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
            return;
        }
        ApngImage.pauseByTag(4);
        super.notifyPause(z16);
        com.tencent.mobileqq.leba.core.g.c(false);
        new com.tencent.mobileqq.leba.entity.e();
        z62.f fVar = this.mZplanHeaderLayout;
        if (fVar != null) {
            fVar.L(z16);
        }
        z62.b bVar = this.mLebaZplanControlManager;
        if (bVar != null) {
            bVar.n();
        }
        LebaPluginListView lebaPluginListView = this.lebaPluginListView;
        if (lebaPluginListView != null) {
            lebaPluginListView.q();
        } else {
            com.tencent.mobileqq.leba.core.f.w(TAG, MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "ThirdParts");
        }
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.leba.Leba.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) Leba.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    ((IRedTouchServer) Leba.this.app.getRuntimeService(IRedTouchServer.class, "")).sendRedpointReq(false, false, 5);
                }
            }
        }, 500L);
        QLog.i(TAG, 2, "leba.java onPause");
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.ba
    public void notifyResume(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
            return;
        }
        super.notifyResume(z16);
        com.tencent.mobileqq.leba.feed.d.d(false);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "leba.java onResume. refreshFlag: " + com.tencent.mobileqq.leba.core.e.f240372e);
        }
        com.tencent.mobileqq.leba.core.g.c(true);
        AbstractGifImage.resumeAll();
        LebaPluginListView lebaPluginListView = this.lebaPluginListView;
        if (lebaPluginListView != null) {
            lebaPluginListView.s(z16);
        } else {
            com.tencent.mobileqq.leba.core.f.w(TAG, "onResume", "ThirdParts");
        }
        updateRightManageIcon();
        ((IRedTouchManager) this.app.getRuntimeService(IRedTouchManager.class, "")).residenceReport(System.currentTimeMillis());
        if ((com.tencent.mobileqq.leba.core.e.f240372e & 4) != 0 || (com.tencent.mobileqq.leba.core.e.f240372e & 8) != 0) {
            com.tencent.mobileqq.leba.core.b.c(3, "refresh_flag:" + com.tencent.mobileqq.leba.core.e.f240372e);
        }
        if (AppSetting.f99565y) {
            this.mTitle.setFocusable(true);
            this.mTitle.setContentDescription(getString(R.string.c77));
            getActivity().setTitle(getString(R.string.c77));
        }
        ((IVasService) MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IVasService.class, "")).getTianshuWebManager().setTraceInfoOfLastClick("{}");
        ApngImage.playByTag(4);
        ((ILebaHelperService) this.app.getRuntimeService(ILebaHelperService.class, ProcessConstant.MULTI)).checkModleAndRefesh();
        refreshZplanCover();
        refreshTitleBar();
        if (AbiUtil.isArm64Runtime(this.app.getApp())) {
            ((IZPlanApi) QRoute.api(IZPlanApi.class)).setOnSettingChangeListener((AppInterface) this.app, Constant.FROM_ID_UNINSTALL_PLUGIN, this.mZPlanSwitchChangeListener);
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.leba.b
            @Override // java.lang.Runnable
            public final void run() {
                Leba.this.lambda$notifyResume$1();
            }
        });
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.ba
    public void notifyStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        super.notifyStop();
        QLog.i(TAG, 2, DKHippyEvent.EVENT_STOP);
        z62.f fVar = this.mZplanHeaderLayout;
        if (fVar != null) {
            fVar.O();
        }
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.be
    public void onAccountChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        super.onAccountChanged();
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "onAccountChanged");
        }
        Iterator<AtomicBoolean> it = LebaPluginLogic.f240659b.values().iterator();
        while (it.hasNext()) {
            it.next().set(true);
        }
        LebaPluginListView lebaPluginListView = this.lebaPluginListView;
        if (lebaPluginListView != null) {
            lebaPluginListView.m();
        } else {
            com.tencent.mobileqq.leba.core.f.w(TAG, "onAccountChanged", "ThirdParts");
        }
        com.tencent.mobileqq.leba.core.e.a().j();
        z62.f fVar = this.mZplanHeaderLayout;
        if (fVar != null) {
            fVar.K();
            this.mZplanHeaderLayout.m();
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.leba.d
            @Override // java.lang.Runnable
            public final void run() {
                Leba.this.lambda$onAccountChanged$4();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.Frame
    public void onBeforeAccountChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
        } else {
            super.onBeforeAccountChanged();
            removeObservers();
        }
    }

    @Override // com.tencent.mobileqq.widget.CommonLoadingView.a
    public void onFirstDraw() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        QLog.d(TAG, 2, "onFirstDraw mainLooper");
        ViewStub viewStub = (ViewStub) findViewById(R.id.j5j);
        if (viewStub != null) {
            viewStub.setVisibility(0);
        }
    }

    @Override // android.view.ViewStub.OnInflateListener
    public void onInflate(ViewStub viewStub, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) viewStub, (Object) view);
            return;
        }
        fillData(false);
        if (!this.mHasInited) {
            notifyResume(true);
        }
        this.mHasInited = true;
    }

    protected void onLebaGameCenterMsgReceive(boolean z16, boolean z17, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i3));
            return;
        }
        if (this.isResume) {
            com.tencent.mobileqq.leba.core.b.c(3, null);
        } else {
            com.tencent.mobileqq.leba.core.e.f240372e |= 2;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "onGameCenterMsgReceive, " + this.isResume);
        }
    }

    public void onLebaTabChange() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
            return;
        }
        QLog.d(QZoneHelper.QZONE_PRELOAD_FROM_LEBA_CLICK, 1, "onLebaTabChange");
        com.tencent.mobileqq.leba.core.g.c(true);
        AppRuntime appRuntime = this.app;
        if (appRuntime != null) {
            LebaHelper lebaHelper = (LebaHelper) ((ILebaHelperService) appRuntime.getRuntimeService(ILebaHelperService.class, ProcessConstant.MULTI)).getLebaHelper();
            if (lebaHelper != null) {
                lebaHelper.f();
            } else {
                QLog.i(TAG, 1, "onLebaTabChange lebaHelper == null");
            }
        }
        LebaPluginListView lebaPluginListView = this.lebaPluginListView;
        if (lebaPluginListView != null) {
            lebaPluginListView.p();
        } else {
            com.tencent.mobileqq.leba.core.f.w(TAG, "onLebaTabChange", "ThirdParts");
        }
        com.tencent.mobileqq.leba.report.d.r(getActivity(), this.mRootView, "pg_discover_list_primary_page", checkZplanEnable());
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.be
    public void onLogout(Constants.LogoutReason logoutReason) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) logoutReason);
            return;
        }
        super.onLogout(logoutReason);
        QLog.i(TAG, 2, "onLogout reason:" + logoutReason);
    }

    public void onPostThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        QLog.i(TAG, 1, "onPostThemeChanged");
        ImageView imageView = this.lebaBgImageView;
        if (imageView != null) {
            imageView.setTag(null);
        }
        updateContentBg();
        MainResourceConfig.s(this.mTitle);
        updateRightManageIcon();
        refreshTitleBar();
        LebaPluginListView lebaPluginListView = this.lebaPluginListView;
        if (lebaPluginListView != null) {
            lebaPluginListView.r();
        } else {
            com.tencent.mobileqq.leba.core.f.w(TAG, "onPostThemeChanged", "ThirdParts");
        }
        if (getContentView() != null) {
            TextHook.updateFont(getContentView());
        }
        ((ILebaHelperService) this.app.getRuntimeService(ILebaHelperService.class, ProcessConstant.MULTI)).checkModleAndRefesh();
        if (checkZplanEnable()) {
            z62.f fVar = this.mZplanHeaderLayout;
            if (fVar != null) {
                fVar.N();
                this.mZplanHeaderLayout.P();
            }
            z62.b bVar = this.mLebaZplanControlManager;
            if (bVar != null) {
                bVar.p();
            }
        }
    }

    public void onSwitchToLeba(final boolean z16, final BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Boolean.valueOf(z16), redTypeInfo);
        } else {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.leba.f
                @Override // java.lang.Runnable
                public final void run() {
                    Leba.this.lambda$onSwitchToLeba$3(z16, redTypeInfo);
                }
            }, 150L);
        }
    }

    public void refreshLebaLayout(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, z16);
            return;
        }
        RoundRelativeLayout roundRelativeLayout = this.lebaLayout;
        if (roundRelativeLayout == null) {
            return;
        }
        int i3 = roundRelativeLayout.f316197h;
        if (!z16 && !QQTheme.isVasTheme()) {
            this.lebaLayout.f316197h = 3;
        } else {
            this.lebaLayout.f316197h = 0;
        }
        RoundRelativeLayout roundRelativeLayout2 = this.lebaLayout;
        if (i3 != roundRelativeLayout2.f316197h) {
            roundRelativeLayout2.invalidate();
        }
    }

    public void refreshTitleBar() {
        z62.b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        boolean z16 = true;
        if (checkZplanEnable() && (bVar = this.mLebaZplanControlManager) != null) {
            int i3 = bVar.f452045g;
            if (i3 != 10 && i3 != 11) {
                if (i3 != -1) {
                    z16 = false;
                }
                adjustTitleBar(z16);
            }
        } else {
            adjustTitleBar(true);
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.leba.Leba.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) Leba.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    QUIImmersiveHelper.s(Leba.this.getActivity(), true, false);
                }
            }
        });
    }

    void setThemeDiyBgLeba() {
        if (this.mRichApi != null && QQTheme.isVasTheme()) {
            this.mRichApi.applyThemeBg(this.app, this.lebaBgImageView, QUITokenResUtil.getResId(R.drawable.bg_texture_theme_version2, R.drawable.qui_common_bg_leba_bg), "-leba-");
            if (ThemeUtil.isNowThemeIsAnimate()) {
                this.mNowThemeIsAnimate = true;
                return;
            } else {
                this.mNowThemeIsAnimate = false;
                return;
            }
        }
        com.tencent.mobileqq.leba.core.f.w(TAG, "setThemeDiyBgLeba", "RichApi");
    }

    protected void updateContentBg() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        if (this.lebaBgImageView == null) {
            return;
        }
        if (QQTheme.isNowSimpleUI()) {
            if (QUITokenResUtil.useQUIToken() && getResources() != null) {
                i3 = getResources().getColor(R.color.qui_common_bg_bottom_standard);
            } else if (QQTheme.isNowThemeIsNight()) {
                i3 = -16777216;
            } else {
                i3 = -1;
            }
            this.lebaBgImageView.setBackgroundColor(i3);
            this.lebaBgImageView.setImageDrawable(null);
            return;
        }
        this.lebaBgImageView.setBackgroundColor(0);
        if (ThemeUtil.useNativeThemeVideoPlayer() && !checkZplanEnable()) {
            this.lebaBgImageView.setImageDrawable(null);
        } else {
            this.lebaBgImageView.setImageDrawable(null);
            int resId = QUITokenResUtil.getResId(R.drawable.bg_texture_theme_version2, R.drawable.qui_common_bg_primary_bg);
            ImageView imageView = this.lebaBgImageView;
            imageView.setBackground(imageView.getResources().getDrawable(resId));
        }
        setThemeDiyBgLeba();
    }
}
