package com.tencent.mobileqq.activity.qcircle;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.events.QFSRebuildInSplitViewModeEvent;
import com.tencent.biz.qqcircle.events.QFSThemeChangeEvent;
import com.tencent.biz.qqcircle.helpers.y;
import com.tencent.biz.qqcircle.immersive.events.QFSExitFoldCacheSaveEvent;
import com.tencent.biz.qqcircle.immersive.feed.ad.preload.QFSAdFeedSourcePreloadManager;
import com.tencent.biz.qqcircle.immersive.manager.QFSTopViewManager;
import com.tencent.biz.qqcircle.immersive.part.QFSMainMultiTabFragmentPart;
import com.tencent.biz.qqcircle.immersive.utils.bk;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.manager.QCircleFolderTabInfoManager;
import com.tencent.biz.qqcircle.utils.QCircleDeviceUsageUtils;
import com.tencent.biz.qqcircle.utils.QCircleNetWorkTestHelper;
import com.tencent.biz.qqcircle.utils.bp;
import com.tencent.biz.qqcircle.utils.bx;
import com.tencent.biz.qqcircle.utils.bz;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.video.event.RFWScrollerReNotifyResumeEvent;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.Page;
import com.tencent.cache.api.PageHierarchy;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.cache.api.util.Priority;
import com.tencent.image.ApngImage;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.framebusiness.QCircleInjectImpl;
import com.tencent.mobileqq.activity.framebusiness.controllerinject.TabDataHelper;
import com.tencent.mobileqq.activity.framebusiness.controllerinject.o;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.activity.qcircle.bubble.QCircleRedPointBubbleReportInfo;
import com.tencent.mobileqq.activity.qcircle.bubble.QCircleTabRedPointBubbleShowController;
import com.tencent.mobileqq.activity.qcircle.bubble.QCircleTianShuBubbleReporter;
import com.tencent.mobileqq.activity.qcircle.pad.QCircleFunctionFragment;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.auto.engine.lib.ASEngineConstants;
import com.tencent.mobileqq.auto.engine.lib.ASEnterBean;
import com.tencent.mobileqq.auto.engine.loader.ASDynamicEngine;
import com.tencent.mobileqq.auto.engine.main.IASFragment;
import com.tencent.mobileqq.pad.LaunchMode;
import com.tencent.mobileqq.pad.SplitViewState;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCircleLpReportDc05504DataBuilder;
import com.tencent.mobileqq.qcircle.api.constant.QCirclePeriodCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcircle.api.data.QCircleRedInfoBean;
import com.tencent.mobileqq.qcircle.api.event.QCircleFrameEvent;
import com.tencent.mobileqq.qcircle.api.event.QCircleRedInfoEvent;
import com.tencent.mobileqq.qcircle.api.event.QCircleTriggerBottomRefreshEvent;
import com.tencent.mobileqq.qcircle.api.event.QFSFrameTabBarVisibleEvent;
import com.tencent.mobileqq.qcircle.api.event.QFSRefreshTabEvent;
import com.tencent.mobileqq.qcircle.api.event.QFSSmallWindowScreenStateEvent;
import com.tencent.mobileqq.qcircle.api.event.QFSStudyModeChangeEvent;
import com.tencent.mobileqq.qcircle.api.event.QFSTopViewRedEvent;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;
import com.tencent.mobileqq.qcircle.api.helper.QCircleObserver;
import com.tencent.mobileqq.qcircle.api.helper.QCircleRedDotDataHelper;
import com.tencent.mobileqq.qcircle.api.helper.QCircleSeekAreaFrameLayout;
import com.tencent.mobileqq.qcircle.api.helper.QCircleVideoSeekHelper;
import com.tencent.mobileqq.qcircle.api.requests.QCircleRedPointEvent;
import com.tencent.mobileqq.qcircle.api.utils.EeveeRedpointUtil;
import com.tencent.mobileqq.qcircle.api.utils.QCircleHostUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.redtouch.RedTouchTab;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.widget.TabViewMap;
import com.tencent.mobileqq.winkpublish.common.UploadConstants;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.common.event.RFRestartAppEvent;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qqcircle.report.datong.QCircleDTLoginReporter;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StGPSV2;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import l40.i;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import org.json.JSONException;
import org.json.JSONObject;
import p40.l;
import p40.n;
import qqcircle.QQCircleCounter$RedPointInfo;
import uq3.p;

/* compiled from: P */
@Page(business = Business.QCircle, type = PageHierarchy.MainPage)
/* loaded from: classes10.dex */
public class QCircleFrame extends Frame implements SimpleEventReceiver, QzoneConfig.QzoneConfigChangeListener, com.tencent.biz.qqcircle.helpers.a {
    private static final long MILLIS_TO_SECOND = 1000;
    private static final String RECOVER_FRAME_EVENT = "RECOVER_FRAME_EVENT";
    private static final String RECOVER_RECODE = "ret_code";
    private static final String RECOVER_TIME_COST = "time_cost";
    public static final String TAG = "QCircleFrame";
    private static final int UI_STATE_OTHERS = 7;
    private static final int UI_STATE_QCIRCLE = 6;
    private static boolean mTopViewRedFlag;
    private com.tencent.mobileqq.auto.engine.main.b mAsBaseFrame;
    private boolean mForceRefreshAllTab;
    private IASFragment mFragment;
    private MainFragment mMainFragment;
    private Handler mMainHandler;
    private View mNavContentView;
    private Drawable mOriginBg;
    private ViewStub mPadNavContentStub;
    private FrameLayout mRootView;
    private int mTabHeight;
    private ASDynamicEngine.b mThirdTabImp;
    private static final QCircleRedInfoBean sRedInfoBean = new QCircleRedInfoBean(1);
    private static long CACHE_VALID_DURATION_TIME = 600000;
    private static final boolean OPEN_RECOVER_FRAME = uq3.c.a7();
    private static boolean mNeedRefreshTab = false;
    private static long mRedPointReceiveTime = 0;
    private static long mRedPointDisplayTime = 0;
    private static long mRedPointClickTime = 0;
    private static int mRedPointUIState = 0;
    private static boolean inBubbleDisplayableSceneWhenRev = true;
    private boolean mIsOnTabSelected = false;
    private long mIdleQCircleTime = Long.MAX_VALUE;
    private long mLeaveQCircleTime = Long.MAX_VALUE;
    private SplitViewState mLastSplitViewState = SplitViewState.UNKNOWN;
    private boolean mReLogin = false;
    private final l40.i mFastVideoPlayWrapper = new l40.i();
    private boolean mIsFirstEnterMainPage = true;
    private QCircleObserver mQCircleRedDotObserver = new c();

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements i.e {
        a() {
        }

        @Override // l40.i.e
        public FeedCloudMeta$StFeed a() {
            return k30.h.f().h(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b extends l.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f184494a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QCircleSeekAreaFrameLayout.a f184495b;

        b(View view, QCircleSeekAreaFrameLayout.a aVar) {
            this.f184494a = view;
            this.f184495b = aVar;
        }

        @Override // p40.l.d
        public void a() {
            if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_dispatch_clicl_by_view", true)) {
                this.f184494a.callOnClick();
                QLog.d(QCircleFrame.TAG, 1, "PreClickListener call by view");
            } else {
                this.f184495b.a();
                QLog.d(QCircleFrame.TAG, 1, "PreClickListener: end by callback");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class c extends QCircleObserver {
        c() {
        }

        @Override // com.tencent.mobileqq.qcircle.api.helper.QCircleObserver
        protected void onUpdateRedPoint(int i3) {
            if (QLog.isColorLevel()) {
                QLog.e(QCircleFrame.TAG, 2, "QCircleObserver onUpdateRedPoint " + i3);
            }
            if (QCircleFrame.this.mMainFragment != null) {
                QCircleInjectImpl.Q0(QCircleFrame.this.mMainFragment, "mQCircleRedDotObserver");
            }
        }
    }

    private static boolean canShowNumRed(boolean z16) {
        QCircleRedInfoBean qCircleRedInfoBean = sRedInfoBean;
        if (!QCircleInjectImpl.V(qCircleRedInfoBean) && (!z16 || !EeveeRedpointUtil.enableNumRedClear(qCircleRedInfoBean.getRedPointInfo()))) {
            return true;
        }
        return false;
    }

    private void cancelFastPlayIfNeed() {
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_destroy_fast_play_when_re_select", true) || this.mFastVideoPlayWrapper.V()) {
            return;
        }
        QLog.d("QCircleFastVideoPlayWrapper_QCircleFrame", 1, "[cancelFastPlayIfNeed] real do");
        this.mFastVideoPlayWrapper.w();
    }

    private void changeBgInFlatState() {
        MainFragment mainFragment;
        View findViewById;
        if (!com.tencent.mobileqq.activity.qcircle.utils.c.j() || (mainFragment = this.mMainFragment) == null || mainFragment.getBaseActivity() == null || (findViewById = this.mMainFragment.getBaseActivity().findViewById(R.id.ve9)) == null) {
            return;
        }
        if (this.mOriginBg == null) {
            this.mOriginBg = findViewById.getBackground();
        }
        QLog.d(TAG, 1, "[changeBgInFlatState] isSelectTab: " + this.mIsOnTabSelected);
        if (this.mIsOnTabSelected && com.tencent.mobileqq.activity.qcircle.utils.c.j()) {
            findViewById.setBackground(new ColorDrawable(Color.parseColor("#0d0d0d")));
        } else {
            findViewById.setBackground(this.mOriginBg);
        }
    }

    private void checkIdleCacheTime() {
        this.mLeaveQCircleTime = System.currentTimeMillis();
        if (!uq3.c.N6() && System.currentTimeMillis() - this.mIdleQCircleTime > CACHE_VALID_DURATION_TIME) {
            mNeedRefreshTab = true;
            this.mForceRefreshAllTab = true;
        }
    }

    private void checkLeaveCacheTime() {
        this.mIdleQCircleTime = System.currentTimeMillis();
        if (!uq3.c.N6() && System.currentTimeMillis() - this.mLeaveQCircleTime > CACHE_VALID_DURATION_TIME) {
            mNeedRefreshTab = true;
            this.mForceRefreshAllTab = true;
        }
    }

    private boolean checkLockScreen(String str) {
        if (!uq3.c.F5()) {
            return false;
        }
        boolean z16 = !Foreground.isCurrentProcessForeground();
        QLog.d(TAG, 1, "[checkLockScreen] isLockScreen: " + z16 + " | tag: " + str);
        updateSmallWindowLockScreen(z16);
        return z16;
    }

    private void checkNeedRefreshTab() {
        if (mTopViewRedFlag) {
            QLog.d(TAG, 1, "checkNeedRefreshTab with topview redFlag");
            mTopViewRedFlag = false;
            mNeedRefreshTab = false;
        } else if (mNeedRefreshTab) {
            SimpleEventBus.getInstance().dispatchEvent(new QCircleFrameEvent(getActivity().hashCode(), getRefreshTabIndex()));
            this.mForceRefreshAllTab = false;
            mNeedRefreshTab = false;
        }
    }

    private void closeDrawerAndDisableIfNeed() {
        FrameHelperActivity.gj(true, TAG);
        if (FrameHelperActivity.Gi()) {
            FrameHelperActivity.Zh();
        }
        FrameHelperActivity.gj(false, TAG);
    }

    private void createASFrame() {
        if (this.mAsBaseFrame == null) {
            this.mAsBaseFrame = com.tencent.mobileqq.auto.engine.main.a.a(ASEngineConstants.BusinessKey.BUSINESS_QCIRCLE);
        }
    }

    private void createNewASFragment(boolean z16) {
        Bundle bundle = new Bundle();
        ASEnterBean initBean = getInitBean();
        initBean.getAttrs().put("IS_PRELOAD", z16 + "");
        bundle.putSerializable(ASEngineConstants.ShadowEngineKey.KEY_AS_ENTER_BEAN, initBean);
        this.mFragment = this.mAsBaseFrame.a(this.mRootView, initBean);
        this.mAsBaseFrame.j(getActivity());
        IASFragment iASFragment = this.mFragment;
        if (iASFragment == null) {
            QLog.d(TAG, 1, "[createNewASFragment] fragment is empty");
            return;
        }
        if (!iASFragment.isAdded()) {
            this.mLastSplitViewState = com.tencent.mobileqq.activity.qcircle.utils.c.a();
            QCircleHostGlobalInfo.setIsNowFlatState(com.tencent.mobileqq.activity.qcircle.utils.c.i());
            QLog.d(TAG, 1, "[createNewASFragment] setArguments. ");
            this.mFragment.setArguments(bundle);
        }
        tryInitFastPlayVideoView(this.mMainFragment);
    }

    private void createQCircleView(boolean z16) {
        createASFrame();
        setRootViewBackgroundByConfig();
        setRootViewBackground();
        createNewASFragment(z16);
        VideoReport.addToDetectionWhitelist(getActivity());
    }

    private void daTongLoginReport() {
        if (l40.i.E()) {
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.activity.qcircle.h
                @Override // java.lang.Runnable
                public final void run() {
                    QCircleFrame.this.realDoLoginReport();
                }
            });
        } else {
            realDoLoginReport();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: doTabWidgetAnim, reason: merged with bridge method [inline-methods] */
    public void lambda$doTabWidgetAnim$5(final boolean z16, final long j3) {
        if (o.e().g()) {
            RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.qcircle.a
                @Override // java.lang.Runnable
                public final void run() {
                    QCircleFrame.this.lambda$doTabWidgetAnim$5(z16, j3);
                }
            }, 50L);
        } else {
            o.e().j(getActivity(), z16, j3);
        }
    }

    private boolean enableFixFastClickInPad() {
        if (this.mFragment != null && com.tencent.mobileqq.activity.qcircle.utils.c.i() && uq3.c.c0()) {
            return true;
        }
        return false;
    }

    private void enterMemoryOptimize() {
        if (!q50.b.e().h()) {
            return;
        }
        ImageCacheHelper.f98636a.d(Priority.Low);
    }

    private void enterQCircleFragment(boolean z16) {
        boolean z17;
        QLog.d(TAG, 1, "[enterQCircleFragment] fromTabSelect\uff1a" + z16);
        com.tencent.mobileqq.qcircle.api.global.a.c();
        QCircleFolderFunnelCollect.record(QCircleFolderFunnelCollect.PERIOD_ENTER_CIRCLE);
        MainFragment mainFragment = this.mMainFragment;
        if (mainFragment != null) {
            z17 = mainFragment.isHidden();
        } else {
            z17 = false;
        }
        QCircleFolderFunnelCollect.setEnterMainFragmentHidden(z17);
        QCircleFolderFunnelCollect.setRedInfo(sRedInfoBean.isShowRedDot());
        QCircleTianShuBubbleReporter.j(false);
        com.tencent.mobileqq.auto.engine.loader.a.e(ASEngineConstants.BusinessKey.BUSINESS_QCIRCLE).A(true);
        QCircleHostGlobalInfo.setCurrentTabActive(!com.tencent.mobileqq.activity.qcircle.utils.c.i());
        checkLeaveCacheTime();
        closeDrawerAndDisableIfNeed();
        int j3 = y.j();
        QLog.d("QCircleFastVideoPlayWrapper_QCircleFrame", 1, "[enterQCircleFragment] tabType:" + j3);
        saveQQTabRedPointInfo();
        boolean b16 = bp.b();
        boolean E = l.t().E();
        if (!b16 && this.mIsFirstEnterMainPage && z16 && ((j3 == 6 || j3 == 0) && l40.i.I() && !E)) {
            enterQCircleFragmentByFastPlay();
        } else {
            cancelFastPlayIfNeed();
            handleQCircleTabActive(true);
            com.tencent.mobileqq.auto.engine.main.b bVar = this.mAsBaseFrame;
            if (bVar != null) {
                bVar.g();
            }
            checkNeedRefreshTab();
            daTongLoginReport();
            QCircleReportHelper.getInstance().setQCircleIsActivate(true);
            QCircleNativeSessionManager.g().enterQCircle();
            handleSeekAreaStatus(!com.tencent.mobileqq.activity.qcircle.utils.c.i());
        }
        this.mIsFirstEnterMainPage = false;
        QCircleInjectImpl.Q0(this.mMainFragment, "QCircleFrame onTabSelected");
        enterMemoryOptimize();
        com.tencent.mobileqq.activity.qcircle.utils.c.d().onSend(5, null, null);
        QCircleDeviceUsageUtils.e().i();
        QFSAdFeedSourcePreloadManager.k().j();
        com.tencent.biz.qqcircle.immersive.manager.h.i().h();
    }

    private void enterQCircleFragmentByFastPlay() {
        Context context;
        QLog.d("QCircleFastVideoPlayWrapper_QCircleFrame", 1, "[enterQCircleFragmentByFastPlay]");
        handleQCircleTabActive(true);
        daTongLoginReport();
        QCircleReportHelper.getInstance().setQCircleIsActivate(true);
        QCircleNativeSessionManager.g().enterQCircle();
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.activity.qcircle.f
            @Override // java.lang.Runnable
            public final void run() {
                QCircleFrame.this.lambda$enterQCircleFragmentByFastPlay$3();
            }
        };
        MainFragment mainFragment = this.mMainFragment;
        if (mainFragment != null) {
            context = mainFragment.getContext();
        } else {
            context = null;
        }
        this.mFastVideoPlayWrapper.A(context, runnable);
    }

    private ViewGroup findContainerView(@NonNull ViewGroup viewGroup) {
        if (viewGroup == viewGroup.getRootView()) {
            return null;
        }
        ViewParent parent = viewGroup.getParent();
        if (!(parent instanceof ViewGroup)) {
            return null;
        }
        if (viewGroup instanceof FragmentContainerView) {
            return findContainerView((ViewGroup) parent);
        }
        if (!(viewGroup instanceof FrameLayout)) {
            return findContainerView((ViewGroup) parent);
        }
        return viewGroup;
    }

    private boolean fixConfigChangeInBack() {
        if (hasOpenPicSelectPage()) {
            return false;
        }
        boolean isCurrentProcessForeground = Foreground.isCurrentProcessForeground();
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102007", true);
        boolean contains = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qcircle_config_change_check_foreground_model", "PAL-AL00").contains(DeviceInfoMonitor.getModel());
        if (!isSwitchOn || isCurrentProcessForeground || !contains) {
            return false;
        }
        return true;
    }

    private void forceHideQQHead() {
        MainFragment mainFragment = this.mMainFragment;
        if (mainFragment != null) {
            mainFragment.setQQHeadVisibility(8, "qcircle");
        }
    }

    private static int getBubbleInterceptState() {
        if (!inBubbleDisplayableSceneWhenRev) {
            return 2;
        }
        return 1;
    }

    private View getClickView(TabViewMap tabViewMap, int i3, int i16) {
        if (tabViewMap != null) {
            try {
                if (tabViewMap.size() != 0) {
                    View view = tabViewMap.get(TabDataHelper.TAB_NEW_WORLD);
                    for (Map.Entry<String, View> entry : tabViewMap.entrySet()) {
                        Rect rect = new Rect();
                        String key = entry.getKey();
                        View value = entry.getValue();
                        value.getGlobalVisibleRect(rect);
                        if (rect.contains(i3, i16)) {
                            if (value == view) {
                                QLog.d(TAG, 1, "find target view,but is qcircleTabView");
                                return null;
                            }
                            QLog.d(TAG, 1, "find target view" + key);
                            if (value instanceof RedTouchTab) {
                                return ((RedTouchTab) value).getTarget();
                            }
                            return value;
                        }
                    }
                    return null;
                }
            } catch (Exception e16) {
                QLog.d(TAG, 1, "isClickOtherTab error:", e16);
            }
        }
        return null;
    }

    public static String getDtRedDotType(QCircleRedInfoBean qCircleRedInfoBean) {
        if (qCircleRedInfoBean.getAllRedNum() > 0) {
            return "number";
        }
        if (qCircleRedInfoBean.isShowRecommendRedDot()) {
            return QCircleDaTongConstant.ElementParamValue.RECOM;
        }
        return "none";
    }

    private QCircleFunctionFragment getFunctionFragment() {
        if (getActivity() != null) {
            for (Fragment fragment : getActivity().getSupportFragmentManager().getFragments()) {
                if ((fragment instanceof QCircleFunctionFragment) && !fragment.isHidden()) {
                    return (QCircleFunctionFragment) fragment;
                }
            }
            return null;
        }
        return null;
    }

    private ASEnterBean getInitBean() {
        String str;
        String str2;
        HashMap<String, String> hashMap = new HashMap<>();
        HashMap<String, byte[]> hashMap2 = new HashMap<>();
        hashMap.put("key_jump_from", String.valueOf(getSourceType()));
        hashMap.put(UploadConstants.KEY_ENABLE_SPLASH, "1");
        QCircleRedInfoBean qCircleRedInfoBean = sRedInfoBean;
        if (qCircleRedInfoBean.isShowRedDot()) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("key_show_active_red_dot", str);
        hashMap.put("key_unread_red_num", String.valueOf(qCircleRedInfoBean.getAllRedNum()));
        hashMap.put("xsj_main_entrance", QCircleDaTongConstant.ElementParamValue.QQ_MAIN_TAB);
        hashMap.put("childmode", "1");
        QCirclePluginUtil.setIsTabModeJudgeByQCircleFrame(isFromTab());
        QCirclePluginUtil.setsIsTabModeForPad(true);
        if (qCircleRedInfoBean.getRedDotTransInfo() != null) {
            hashMap2.put("key_red_dot_trans_info", qCircleRedInfoBean.getRedDotTransInfo());
        }
        if (qCircleRedInfoBean.getEntranceTabType() > 0) {
            hashMap.put(QCircleSchemeAttr.Polymerize.TAB_TYPE, String.valueOf(qCircleRedInfoBean.getEntranceTabType()));
        }
        if ((this.app instanceof QQAppInterface) && getActivity() != null && !TextUtils.isEmpty(qCircleRedInfoBean.getRedDotJumpUrl())) {
            ax c16 = bi.c((QQAppInterface) this.app, getActivity(), qCircleRedInfoBean.getRedDotJumpUrl());
            if (c16 != null && !TextUtils.isEmpty(c16.f307440e)) {
                hashMap.putAll(c16.f307441f);
                str2 = c16.f307440e;
                hashMap.putAll(parseSchemeAttr());
                QLog.d(TAG, 1, "[enterBean] jump_from: " + getSourceType() + ", isFromTab: " + isFromTab());
                return new ASEnterBean(ASEngineConstants.BusinessKey.BUSINESS_QCIRCLE).setByteAttrs(hashMap2).setSchemeAction(str2).setAttrs(hashMap);
            }
            QLog.e(TAG, 2, "has JumpUrl:" + qCircleRedInfoBean.getRedDotJumpUrl() + ", but parse jump action failed");
        }
        str2 = QCircleScheme.Q_CIRCLE_ACTION_OPEN_FOLDER_PAGE;
        hashMap.putAll(parseSchemeAttr());
        QLog.d(TAG, 1, "[enterBean] jump_from: " + getSourceType() + ", isFromTab: " + isFromTab());
        return new ASEnterBean(ASEngineConstants.BusinessKey.BUSINESS_QCIRCLE).setByteAttrs(hashMap2).setSchemeAction(str2).setAttrs(hashMap);
    }

    private Handler getMainHandler() {
        if (this.mMainHandler == null) {
            this.mMainHandler = new Handler(Looper.getMainLooper());
        }
        return this.mMainHandler;
    }

    public static String getOutLayerRedType(QCircleRedInfoBean qCircleRedInfoBean) {
        if (qCircleRedInfoBean == null) {
            return "";
        }
        if (qCircleRedInfoBean.isShowActiveRedDot()) {
            return String.valueOf(1);
        }
        if (!qCircleRedInfoBean.isShowRecommendRedDot()) {
            return "";
        }
        return String.valueOf(2);
    }

    public static synchronized BusinessInfoCheckUpdate.RedTypeInfo getQQRedTypeInfo(boolean z16) {
        BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo;
        synchronized (QCircleFrame.class) {
            refreshRedInfoBean(QCircleRedDotDataHelper.getQQMainTabRedPointInfo(), z16, false);
            redTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
            int i3 = -1;
            redTypeInfo.red_type.set(-1);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cn", "#FF0000");
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
            redTypeInfo.red_desc.set(jSONObject.toString());
            QCircleRedInfoBean qCircleRedInfoBean = sRedInfoBean;
            if (qCircleRedInfoBean.getAllRedNum() > 0) {
                PBUInt32Field pBUInt32Field = redTypeInfo.red_type;
                if (canShowNumRed(z16)) {
                    i3 = 5;
                }
                pBUInt32Field.set(i3);
                redTypeInfo.red_content.set(String.valueOf(qCircleRedInfoBean.getAllRedNum()));
                QLog.d("QFSRedDot", 2, "report red dot show,type:", 5);
            } else {
                if (qCircleRedInfoBean.isShowRedDot() && !z16) {
                    if (qCircleRedInfoBean.hasAvatarCornerRedPoint()) {
                        redTypeInfo.red_type.set(-1);
                    } else {
                        redTypeInfo.red_type.set(0);
                    }
                    mNeedRefreshTab = true;
                    QLog.d("QFSRedDot", 2, "report red dot show,type:", 0);
                }
                if (!qCircleRedInfoBean.isShowRedDot()) {
                    mTopViewRedFlag = false;
                }
            }
        }
        return redTypeInfo;
    }

    public static QCircleRedInfoBean getRedInfoBean() {
        return sRedInfoBean;
    }

    private int getRefreshTabIndex() {
        if (this.mForceRefreshAllTab) {
            return 4;
        }
        QCircleRedInfoBean qCircleRedInfoBean = sRedInfoBean;
        if (qCircleRedInfoBean.isShowRecommendRedDot()) {
            return 1;
        }
        if (qCircleRedInfoBean.isShowActiveRedDot()) {
            return 2;
        }
        return -1;
    }

    private int getReportDwopVia() {
        int i3;
        if (getRedInfoBean().getAllRedNum() > 0) {
            i3 = 1;
        } else if (getRedInfoBean().isShowRedDot()) {
            i3 = 2;
        } else {
            i3 = 3;
        }
        QLog.d(TAG, 2, "RedDotDowpVia:" + i3);
        return i3;
    }

    private int getSourceType() {
        if (com.tencent.mobileqq.activity.qcircle.utils.c.i()) {
            return 1004;
        }
        return 11;
    }

    private static int getThrActionType(QCircleRedInfoBean qCircleRedInfoBean) {
        if (qCircleRedInfoBean == null) {
            return 3;
        }
        if (qCircleRedInfoBean.getAllRedNum() > 0) {
            return 2;
        }
        if (!qCircleRedInfoBean.isShowRedDot()) {
            return 3;
        }
        return 1;
    }

    private void handleCheckRefresh(SimpleBaseEvent simpleBaseEvent) {
        if (!(simpleBaseEvent instanceof QCircleTriggerBottomRefreshEvent) || System.currentTimeMillis() - this.mIdleQCircleTime <= CACHE_VALID_DURATION_TIME || getActivity() == null || !((QCircleTriggerBottomRefreshEvent) simpleBaseEvent).needCheckRefresh()) {
            return;
        }
        SimpleEventBus.getInstance().dispatchEvent(new QCircleFrameEvent(getActivity().hashCode(), 0));
        this.mIdleQCircleTime = System.currentTimeMillis();
        QLog.d(TAG, 1, "refresh by QCircleTriggerBottomRefreshEvent");
    }

    private void handleConfigChangeInFlatState(Configuration configuration) {
        QLog.d(TAG, 1, "[handleConfigChangeInFlatState] mIsOnTabSelected: " + this.mIsOnTabSelected + ", isSplitViewMode: " + com.tencent.mobileqq.activity.qcircle.utils.c.j() + ", mLastSplitViewState: " + this.mLastSplitViewState + ", currentSplitViewState: " + com.tencent.mobileqq.activity.qcircle.utils.c.a());
        if (com.tencent.mobileqq.activity.qcircle.utils.c.j() && this.mLastSplitViewState != com.tencent.mobileqq.activity.qcircle.utils.c.a()) {
            if (fixConfigChangeInBack()) {
                QLog.e(TAG, 1, "[handleConfigChangeInFlatState] is not foreground. ");
                return;
            }
            SimpleEventBus.getInstance().dispatchEvent(new QFSRebuildInSplitViewModeEvent(com.tencent.mobileqq.activity.qcircle.utils.c.a()));
            QCircleHostGlobalInfo.setNeedRestoreFolderUi(true);
            if (this.mIsOnTabSelected) {
                handleSeekAreaStatus(!com.tencent.mobileqq.activity.qcircle.utils.c.i());
                lambda$doTabWidgetAnim$5(true, 0L);
            }
            if (showInNavFragment()) {
                releaseFunctionFragment();
            }
            this.mReLogin = false;
            initNavContentInFlatState();
            setNavContentVisible(com.tencent.mobileqq.activity.qcircle.utils.c.i());
            rebuildQCircle();
            if (showInNavFragment() && this.mIsOnTabSelected) {
                QLog.d(TAG, 1, "[handleConfigChangeInFlatState] rebuild in navFragment");
                notifyResume(true);
                onTabSelected(false, false);
            } else if (!showInNavFragment() && this.mIsOnTabSelected) {
                QLog.d(TAG, 1, "[handleConfigChangeInFlatState] rebuild in functionFragment");
                startFunctionFragment(getActivity(), false);
            }
        }
    }

    private void handleFoldExitCacheSaveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (!(simpleBaseEvent instanceof QFSExitFoldCacheSaveEvent)) {
            return;
        }
        if (!bz.f()) {
            QLog.d(TAG, 1, "handleFoldExitCacheSaveEvent disable");
        } else {
            if (isSameContext(((QFSExitFoldCacheSaveEvent) simpleBaseEvent).getContextHashCode())) {
                QLog.d(TAG, 1, "handleFoldExitCacheSaveEvent isSameContext");
                return;
            }
            QLog.d(TAG, 1, "handleFoldExitCacheSaveEvent real rebuild");
            QCircleHostGlobalInfo.setNeedRestoreFolderUi(true);
            rebuildOnFlatState(null);
        }
    }

    private void handleQCircleFrameEvent(SimpleBaseEvent simpleBaseEvent) {
        if ((simpleBaseEvent instanceof QCircleFrameEvent) && getActivity() != null && simpleBaseEvent.mHashCode != getActivity().hashCode() && ((QCircleFrameEvent) simpleBaseEvent).mIsNeedExposeTab) {
            reportQCircleFrameExpose();
        }
    }

    private void handleRedInfoEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QCircleRedInfoEvent) {
            QCircleRedInfoEvent qCircleRedInfoEvent = (QCircleRedInfoEvent) simpleBaseEvent;
            QCircleInjectImpl.R0(this.mMainFragment, qCircleRedInfoEvent.mInvokeMethodName, qCircleRedInfoEvent.mIsClearRedPoint);
        }
    }

    private void handleRedPointReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if ((simpleBaseEvent instanceof QCircleRedPointEvent) && ((QCircleRedPointEvent) simpleBaseEvent).mRedPointMainMsgType == 106) {
            inBubbleDisplayableSceneWhenRev = QCircleInjectImpl.i0(this.mIsOnTabSelected);
            QLog.i(TAG, 1, "handleRedPointReceiveEvent, inBubbleDisplayableSceneWhenRev=" + inBubbleDisplayableSceneWhenRev);
        }
    }

    private void handleRestartAppEvent(SimpleBaseEvent simpleBaseEvent) {
        if (!(simpleBaseEvent instanceof RFRestartAppEvent)) {
            return;
        }
        mNeedRefreshTab = true;
    }

    private void handleSeekAreaStatus(boolean z16) {
        View view;
        MainFragment mainFragment = this.mMainFragment;
        if (mainFragment == null) {
            view = null;
        } else {
            view = mainFragment.getView();
        }
        if (view == null) {
            QLog.e(TAG, 1, "[handleSeekAreaStatus] fragment view should not be null.");
            return;
        }
        ViewParent parent = view.getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ViewGroup findContainerView = findContainerView((ViewGroup) parent);
            if (z16) {
                QCircleSeekAreaFrameLayout addSeekView = QCircleVideoSeekHelper.addSeekView(findContainerView, this.mTabHeight);
                if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_hook_bottom_click_for_float", true)) {
                    return;
                }
                setPerClickListener(addSeekView);
                return;
            }
            QCircleVideoSeekHelper.removeSeekArea(findContainerView);
            return;
        }
        QLog.d(TAG, 1, "[handleSeekAreaStatus] fragment parent should not be null.");
    }

    private void handleStudyModeChangeEvent(SimpleBaseEvent simpleBaseEvent) {
        if ((simpleBaseEvent instanceof QFSStudyModeChangeEvent) && ((QFSStudyModeChangeEvent) simpleBaseEvent).isStudyMode()) {
            handleQCircleTabActive(false);
        }
    }

    private void handleTabBarVisibleEvent(SimpleBaseEvent simpleBaseEvent) {
        boolean z16;
        if (!(simpleBaseEvent instanceof QFSFrameTabBarVisibleEvent) || !this.mIsOnTabSelected) {
            return;
        }
        QFSFrameTabBarVisibleEvent qFSFrameTabBarVisibleEvent = (QFSFrameTabBarVisibleEvent) simpleBaseEvent;
        lambda$doTabWidgetAnim$5(qFSFrameTabBarVisibleEvent.needShowTab(), qFSFrameTabBarVisibleEvent.getAnimDuration());
        if (!qFSFrameTabBarVisibleEvent.isShowSeekTouchArea()) {
            if (qFSFrameTabBarVisibleEvent.needShowTab() && !com.tencent.mobileqq.activity.qcircle.utils.c.i()) {
                z16 = true;
            } else {
                z16 = false;
            }
            handleSeekAreaStatus(z16);
        }
    }

    private void handleTopViewRedEvent(SimpleBaseEvent simpleBaseEvent) {
        if ((simpleBaseEvent instanceof QFSTopViewRedEvent) && !this.mIsOnTabSelected && this.mLeaveQCircleTime != Long.MAX_VALUE) {
            mTopViewRedFlag = true;
            QLog.d(TAG, 1, "handleTopViewRedEvent");
            SimpleEventBus.getInstance().dispatchEvent(new QFSRefreshTabEvent(6, true));
        }
    }

    private boolean hasOpenPicSelectPage() {
        return uq3.k.a().c("sp_key_qcircle_open_pic_select_page", false);
    }

    private void inflateRootView(LayoutInflater layoutInflater) {
        if (this.mRootView == null) {
            this.mRootView = (FrameLayout) layoutInflater.inflate(R.layout.g3p, (ViewGroup) null);
        }
        if (com.tencent.mobileqq.activity.qcircle.utils.c.j()) {
            this.mRootView.setBackgroundColor(-16777216);
        }
    }

    private boolean isFromTab() {
        return !com.tencent.mobileqq.activity.qcircle.utils.c.i();
    }

    public static boolean isQCircleFrameInTabMiddle(MainFragment mainFragment) {
        ArrayList<FrameFragment.e> arrayList;
        if (mainFragment == null) {
            arrayList = null;
        } else {
            arrayList = mainFragment.mTabHostTabListWithOrder;
        }
        if (arrayList != null && arrayList.size() % 2 != 0 && arrayList.get(arrayList.size() / 2) != null) {
            return QCircleFrame.class.getName().equals(arrayList.get(arrayList.size() / 2).getTag());
        }
        return false;
    }

    private boolean isSameContext(int i3) {
        IASFragment iASFragment = this.mFragment;
        if (iASFragment != null && iASFragment.getTargetDecorView() != null) {
            ViewGroup viewGroup = (ViewGroup) this.mFragment.getTargetDecorView();
            if (viewGroup.getChildCount() <= 0) {
                QLog.d(TAG, 1, "[isSameContext] targetDecorView childViewCount is 0");
                return false;
            }
            Activity b16 = bk.b(viewGroup.getChildAt(0));
            if (b16 != null && b16.hashCode() == i3) {
                return true;
            }
            return false;
        }
        QLog.d(TAG, 1, "[isSameContext] mFragment is null");
        return false;
    }

    private boolean isShowQTab() {
        ViewGroup viewGroup;
        MainFragment mainFragment = this.mMainFragment;
        if (mainFragment == null || (viewGroup = mainFragment.mTabWidget) == null || viewGroup.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    private boolean isShowingFunctionFragment() {
        if (getFunctionFragment() != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$enterQCircleFragmentByFastPlay$2() {
        com.tencent.mobileqq.auto.engine.main.b bVar = this.mAsBaseFrame;
        if (bVar != null) {
            bVar.g();
        }
        checkNeedRefreshTab();
        handleSeekAreaStatus(!com.tencent.mobileqq.activity.qcircle.utils.c.i());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$enterQCircleFragmentByFastPlay$3() {
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.activity.qcircle.d
            @Override // java.lang.Runnable
            public final void run() {
                QCircleFrame.this.lambda$enterQCircleFragmentByFastPlay$2();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initNavContentInFlatState$1(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        startFunctionFragment(this.mRootView.getContext(), false);
        QLog.d(TAG, 4, "goHomeButton is clicked");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$onThirdTabInject$0() {
        MainFragment mainFragment = this.mMainFragment;
        if (mainFragment == null) {
            QLog.d(TAG, 1, "onThirdTabInject mMainFragment is np");
            return this.mIsOnTabSelected;
        }
        return TextUtils.equals(mainFragment.getCurrentTabName(), com.tencent.mobileqq.activity.home.impl.b.F);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setPerClickListener$4(float f16, float f17, QCircleSeekAreaFrameLayout.a aVar) {
        TabViewMap tabViewMap;
        QLog.d(TAG, 1, "PreClickListener: begin");
        MainFragment mainFragment = this.mMainFragment;
        if (mainFragment != null && (tabViewMap = mainFragment.mTabViewMap) != null) {
            View clickView = getClickView(tabViewMap, (int) f16, (int) f17);
            if (clickView == null) {
                aVar.a();
                return;
            } else {
                QLog.d(TAG, 1, "PreClickListener:click otherTab");
                l.t().l(getActivity(), new b(clickView, aVar));
                return;
            }
        }
        aVar.a();
        QLog.d(TAG, 1, "PreClickListener: end by NP view");
    }

    private void loadPadNavContentPic() {
        ImageView imageView;
        String str;
        View view = this.mNavContentView;
        if (view == null || (imageView = (ImageView) view.findViewById(R.id.uuh)) == null) {
            return;
        }
        if (com.dataline.util.j.b()) {
            str = "https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/changename/qcircle_pad_navigation_emptystate_v2.png";
        } else {
            str = "https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/changename/qcircle_pad_navigation_emptystate.png";
        }
        QCircleFeedPicLoader.g().loadImage(Option.obtain().setRequestHeight(imageView.getLayoutParams().height).setRequestWidth(imageView.getLayoutParams().width).setLoadingDrawable(new ColorDrawable(Color.parseColor("#00000000"))).setUrl(str).setTargetView(imageView));
    }

    private boolean needReBuildDecorView() {
        IASFragment iASFragment;
        try {
            iASFragment = this.mFragment;
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "check isDestroyDecorView error:" + th5.getMessage(), th5);
        }
        if (iASFragment instanceof com.tencent.mobileqq.auto.engine.main.fragment.d) {
            if (iASFragment.getTargetDecorView() != null) {
                return false;
            }
            return true;
        }
        if (iASFragment == null) {
            return true;
        }
        if (iASFragment.getTargetDecorView() instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) this.mFragment.getTargetDecorView();
            if (viewGroup.getChildCount() == 1) {
                boolean isDestroyed = ((Activity) viewGroup.getChildAt(0).getContext()).isDestroyed();
                QLog.e(TAG, 1, "check isDestroyDecorView :" + isDestroyed);
                return isDestroyed;
            }
            if (viewGroup.getChildCount() == 0) {
                QLog.e(TAG, 1, "check isDestroyDecorView decorView has no any childView, need rebuild");
                return true;
            }
        }
        return false;
    }

    private boolean needRecoverEmptyFrame() {
        IASFragment iASFragment = this.mFragment;
        if (iASFragment == null) {
            QLog.d(TAG, 1, "needRecoverEmptyFrame return true, mFragment is empty");
            return true;
        }
        if (iASFragment instanceof com.tencent.mobileqq.auto.engine.main.fragment.d) {
            QLog.d(TAG, 1, "not need recover , mFragment is native");
            return false;
        }
        if (iASFragment.getTargetDecorView() != null) {
            return false;
        }
        QLog.d(TAG, 1, "needRecoverEmptyFrame return true, targetDecorView is empty");
        return true;
    }

    private static boolean needReportRedPointExpose() {
        QCircleRedInfoBean qCircleRedInfoBean = sRedInfoBean;
        if (qCircleRedInfoBean.isNeedReportRedDot() && qCircleRedInfoBean.isShowRedDot() && QCircleInjectImpl.E) {
            return true;
        }
        return false;
    }

    private void onOldFragmentDestroy() {
        if (!l40.i.I()) {
            return;
        }
        this.mFastVideoPlayWrapper.j0();
        this.mFastVideoPlayWrapper.s0();
    }

    private void onResumeInFlatState() {
        IASFragment iASFragment = this.mFragment;
        if (iASFragment != null && iASFragment.isAdded() && com.tencent.mobileqq.activity.qcircle.utils.c.i()) {
            this.mFragment.setIsSelected(true);
        }
    }

    private void onThirdTabInject() {
        if (!p.a("qcircle_enable_use_native_fragment_v3")) {
            com.tencent.mobileqq.auto.engine.loader.a.e(ASEngineConstants.BusinessKey.BUSINESS_QCIRCLE).z(null);
            return;
        }
        QLog.d(TAG, 1, "onThirdTabInject");
        this.mThirdTabImp = new ASDynamicEngine.b() { // from class: com.tencent.mobileqq.activity.qcircle.g
            @Override // com.tencent.mobileqq.auto.engine.loader.ASDynamicEngine.b
            public final boolean a() {
                boolean lambda$onThirdTabInject$0;
                lambda$onThirdTabInject$0 = QCircleFrame.this.lambda$onThirdTabInject$0();
                return lambda$onThirdTabInject$0;
            }
        };
        com.tencent.mobileqq.auto.engine.loader.a.e(ASEngineConstants.BusinessKey.BUSINESS_QCIRCLE).z(this.mThirdTabImp);
    }

    private HashMap<String, String> parseSchemeAttr() {
        Intent intent;
        HashMap<String, String> hashMap = new HashMap<>();
        MainFragment mainFragment = this.mMainFragment;
        if (mainFragment != null && (mainFragment.getContext() instanceof Activity)) {
            intent = ((Activity) mainFragment.getContext()).getIntent();
        } else {
            intent = null;
        }
        if (intent == null) {
            QLog.d(TAG, 1, "parseSchemeAttr get from activity");
            intent = getJumpIntentFromActivity();
        }
        if (intent == null) {
            QLog.d(TAG, 1, "parseSchemeAttr jumpIntent is null");
            return hashMap;
        }
        Serializable serializableExtra = intent.getSerializableExtra(QCircleSchemeAttr.Polymerize.TAB_TYPE);
        if (serializableExtra instanceof HashMap) {
            hashMap.putAll((HashMap) serializableExtra);
        }
        return hashMap;
    }

    private void preloadFolderTab() {
        FeedCloudMeta$StGPSV2 feedCloudMeta$StGPSV2;
        if (!uq3.c.U5()) {
            return;
        }
        QLog.d(TAG, 1, "preloadFolderTab: ");
        QCircleFolderTabInfoManager m3 = QCircleFolderTabInfoManager.m();
        if (uq3.o.i()) {
            feedCloudMeta$StGPSV2 = com.tencent.biz.qqcircle.c.e().d();
        } else {
            feedCloudMeta$StGPSV2 = new FeedCloudMeta$StGPSV2();
        }
        m3.f(feedCloudMeta$StGPSV2, new QCircleFolderBean(new QCircleReportBean()));
    }

    private void reDispatchSelectOnResume() {
        if (!l40.i.G()) {
            return;
        }
        com.tencent.mobileqq.auto.engine.main.b bVar = this.mAsBaseFrame;
        if (bVar != null && !bVar.b()) {
            if (!this.mFastVideoPlayWrapper.K()) {
                QLog.d(TAG, 1, "[reDispatchSelectOnResume] fastPlay not finish");
                return;
            }
            IASFragment iASFragment = this.mFragment;
            if (iASFragment != null && iASFragment.isAdded()) {
                QLog.d(TAG, 1, "reDispatchSelectOnResume");
                this.mAsBaseFrame.g();
                return;
            } else {
                QLog.d(TAG, 1, "[reDispatchSelectOnResume] isAdd: false");
                return;
            }
        }
        QLog.d(TAG, 1, "[reDispatchSelectOnResume] isPagSelected: true");
    }

    private void reNotifyResumeByEvent() {
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_re_notify_resume", true)) {
            if ((n.e().k() || (this.mFragment instanceof com.tencent.mobileqq.auto.engine.main.fragment.d)) && !com.tencent.mobileqq.activity.qcircle.utils.c.i()) {
                QLog.d(TAG, 2, "re dispatch onResume");
                SimpleEventBus.getInstance().dispatchEvent(new RFWScrollerReNotifyResumeEvent());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void realDoLoginReport() {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PAGE_STACK_NUM, QCircleReportHelper.getQQCirclePageStackNum() + "");
        buildElementParams.put("xsj_main_entrance", QCircleDaTongConstant.ElementParamValue.QQ_MAIN_TAB);
        buildElementParams.put("xsj_sub_entrance", "default");
        String tabModeSchema = QCircleHostGlobalInfo.getTabModeSchema();
        if (!TextUtils.isEmpty(tabModeSchema)) {
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_SCHEMA, tabModeSchema);
        }
        QCircleHostGlobalInfo.setTabModeSchema("");
        QCircleDTLoginReporter.executeDaTongLoginReport(buildElementParams);
        bx.e();
    }

    private void rebuildOnFlatState(com.tencent.mobileqq.activity.qcircle.utils.b bVar) {
        rebuildQCircle();
        if (bVar != null) {
            bVar.v(isQCircleTabSelected(), true);
        }
        QCircleFunctionFragment functionFragment = getFunctionFragment();
        if (this.mIsOnTabSelected && functionFragment != null) {
            functionFragment.ph();
            onTabSelected(false, false);
        }
    }

    private void rebuildQCircle() {
        if (this.mRootView == null) {
            return;
        }
        releaseFolderFragment();
        createASFrame();
        createNewASFragment(false);
    }

    private void recoverEmptyFrame() {
        try {
            if (!uq3.c.b0()) {
                QLog.d(TAG, 1, "recoverEmptyFrame return wns close");
                return;
            }
            if (!needRecoverEmptyFrame()) {
                QLog.d(TAG, 1, "recoverEmptyFrame return has view");
                return;
            }
            this.mAsBaseFrame.i();
            onOldFragmentDestroy();
            QLog.d(TAG, 1, "recoverEmptyFrame release older");
            this.mFragment = null;
            wrapFolderFragmentIfNeed();
        } catch (Exception e16) {
            QLog.d(TAG, 1, "recoverEmptyFrame exception:", e16);
        }
    }

    private void recoverViewInFunctionFragment(@NonNull FrameLayout frameLayout) {
        if (this.mFragment == null) {
            createNewASFragment(false);
        }
        IASFragment iASFragment = this.mFragment;
        if (iASFragment != null && !iASFragment.isAdded()) {
            QLog.d(TAG, 1, "[wrapFolderFragmentIfNeed] add decorView success. ");
            frameLayout.addView(this.mFragment.getTargetDecorView(), -1, -1);
        } else {
            QLog.d(TAG, 1, "[wrapFolderFragmentIfNeed] fragment is already added. ");
        }
    }

    public static synchronized void refreshRedInfoBean(QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo, boolean z16, boolean z17) {
        int i3;
        synchronized (QCircleFrame.class) {
            sRedInfoBean.refreshRedDotInfo(qQCircleCounter$RedPointInfo);
            mRedPointReceiveTime = EeveeRedpointUtil.getReceiveRedPointTimeStamp() / 1000;
            if (z16) {
                i3 = 6;
            } else {
                i3 = 7;
            }
            mRedPointUIState = i3;
            if (needReportRedPointExpose()) {
                EeveeRedpointUtil.setLastExposeRedPointInfo(qQCircleCounter$RedPointInfo);
                if (!z17) {
                    reportDcQQCircleRedDotReceive();
                }
                reportQCircleRedDotExpose();
                QLog.i(TAG, 1, "getQQRedTypeInfo, report red dot expose");
            }
        }
    }

    private void releaseFolderFragment() {
        com.tencent.mobileqq.auto.engine.main.b bVar;
        try {
            if (this.mFragment != null && (bVar = this.mAsBaseFrame) != null) {
                bVar.i();
                if (this.mFragment.isRealFragment()) {
                    getActivity().getSupportFragmentManager().beginTransaction().remove((Fragment) this.mFragment).commitAllowingStateLoss();
                } else {
                    this.mFragment.onStop();
                    removeQCircleDecorView();
                    this.mFragment.onDestroy();
                    QLog.d(TAG, 1, "release native view");
                }
                onOldFragmentDestroy();
                this.mFragment = null;
                QCirclePluginUtil.setIsTabModeJudgeByQCircleFrame(false);
                QLog.d(TAG, 1, "releaseFolderFragment");
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "onAccountChanged exception:" + e16);
        }
    }

    private void releaseFunctionFragment() {
        QLog.d(TAG, 1, "[releaseFunctionFragment]");
        QCircleFunctionFragment functionFragment = getFunctionFragment();
        if (functionFragment != null) {
            functionFragment.sh();
            functionFragment.rh();
        }
        removeFunctionFragment();
    }

    private void removeFunctionFragment() {
        if (!com.tencent.mobileqq.activity.qcircle.utils.c.j()) {
            QLog.d(TAG, 1, "[removeFunctionFragment] isSplitViewMode: " + com.tencent.mobileqq.activity.qcircle.utils.c.j());
            return;
        }
        if (this.mReLogin) {
            QLog.d(TAG, 1, "[removeFunctionFragment] is reLogin. ");
            this.mReLogin = false;
        } else {
            if (!isShowingFunctionFragment()) {
                QLog.d(TAG, 1, "[removeFunctionFragment] isShowingFunctionFragment: false");
                return;
            }
            if (getActivity() != null && getActivity().getSupportFragmentManager().isStateSaved()) {
                QLog.e(TAG, 1, "[removeFunctionFragment] FragmentManager state has already saved after onSaveInstanceState");
            } else if (getActivity() != null) {
                getActivity().doOnBackPressed();
            }
        }
    }

    private void removeQCircleDecorView() {
        if (this.mRootView != null && this.mFragment != null) {
            if (com.tencent.mobileqq.activity.qcircle.utils.c.j()) {
                for (int i3 = 0; i3 < this.mRootView.getChildCount(); i3++) {
                    View childAt = this.mRootView.getChildAt(i3);
                    QLog.d(TAG, 1, "[removeQCircleDecorView] childView: " + childAt.getClass().getName());
                    if ((childAt.getTag() instanceof String) && TextUtils.equals((String) childAt.getTag(), TAG)) {
                        this.mRootView.removeView(childAt);
                        return;
                    }
                }
                return;
            }
            this.mRootView.removeView(this.mFragment.getTargetDecorView());
        }
    }

    public static void reportDTQCircleBubbleInterceptByTianShu(@NonNull QCircleRedPointBubbleReportInfo qCircleRedPointBubbleReportInfo) {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
        buildElementParams.put("xsj_action_type", "clck");
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_EXTERNAL_ENTRANCE, QCircleDaTongConstant.ElementParamValue.QQ_MAIN_TAB);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_REDDOT_TYPE, qCircleRedPointBubbleReportInfo.getDtRedPointType());
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_REDDOT_RECOM_TYPE, qCircleRedPointBubbleReportInfo.getRedDotReportExt());
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_REDDOT_RECOM_TEXT, qCircleRedPointBubbleReportInfo.getTabTipWording());
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_REDDOT_INTERCEPT_REASON, Integer.valueOf(getBubbleInterceptState()));
        VideoReport.reportEvent(QCircleDaTongConstant.EventId.EV_XSJ_BUBBLE_INTERCEPT, null, buildElementParams);
    }

    public static void reportDcQCircleBubbleInterceptByTianShu(@NonNull QCircleRedPointBubbleReportInfo qCircleRedPointBubbleReportInfo) {
        ((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setActionType(111).setSubActionType(5).setThrActionType(1).setExt1(qCircleRedPointBubbleReportInfo.getDcRedPointType()).setExt5(qCircleRedPointBubbleReportInfo.getRedDotReportExt()).setExt7(QCircleNativeSessionManager.g().getSession()).setExt8(qCircleRedPointBubbleReportInfo.getTabTipWording()).setExt12(String.valueOf(mRedPointReceiveTime)).setExt13(String.valueOf(mRedPointDisplayTime)).setExt15(String.valueOf(mRedPointUIState)).setExt16(qCircleRedPointBubbleReportInfo.getContent()).setExt17(String.valueOf(getBubbleInterceptState())));
    }

    public static void reportDcQQCircleBubbleShow(@NonNull QCircleRedPointBubbleReportInfo qCircleRedPointBubbleReportInfo) {
        ((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setActionType(111).setSubActionType(6).setThrActionType(1).setExt1(qCircleRedPointBubbleReportInfo.getDcRedPointType()).setExt5(qCircleRedPointBubbleReportInfo.getRedDotReportExt()).setExt7(QCircleNativeSessionManager.g().getSession()).setExt8(qCircleRedPointBubbleReportInfo.getTabTipWording()).setExt11(qCircleRedPointBubbleReportInfo.getLastRedDotReportExt()).setExt12(String.valueOf(mRedPointReceiveTime)).setExt13(String.valueOf(mRedPointDisplayTime)).setExt15(String.valueOf(mRedPointUIState)).setExt16(qCircleRedPointBubbleReportInfo.getContent()).setExt17(String.valueOf(mRedPointDisplayTime)).setExt18(String.valueOf(System.currentTimeMillis())));
    }

    public static void reportDcQQCircleRedDotClear(@NonNull QCircleRedPointBubbleReportInfo qCircleRedPointBubbleReportInfo) {
        ((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setActionType(111).setSubActionType(4).setThrActionType(1).setExt1(qCircleRedPointBubbleReportInfo.getDcRedPointType()).setExt5(qCircleRedPointBubbleReportInfo.getRedDotReportExt()).setExt7(QCircleNativeSessionManager.g().getSession()).setExt8(qCircleRedPointBubbleReportInfo.getTabTipWording()).setExt11(qCircleRedPointBubbleReportInfo.getLastRedDotReportExt()).setExt12(String.valueOf(mRedPointReceiveTime)).setExt13(String.valueOf(mRedPointDisplayTime)).setExt15(String.valueOf(mRedPointUIState)).setExt16(qCircleRedPointBubbleReportInfo.getContent()).setExt17(String.valueOf(mRedPointDisplayTime)).setExt18(String.valueOf(System.currentTimeMillis() / 1000)));
    }

    private static void reportDcQQCircleRedDotClick(boolean z16) {
        int thrActionType;
        String redDotReportExt;
        QCircleRedInfoBean redInfoBean = getRedInfoBean();
        if (z16) {
            thrActionType = 4;
        } else {
            thrActionType = getThrActionType(redInfoBean);
        }
        IQCircleReportApi iQCircleReportApi = (IQCircleReportApi) QRoute.api(IQCircleReportApi.class);
        QCircleLpReportDc05504DataBuilder ext1 = new QCircleLpReportDc05504DataBuilder().setActionType(111).setSubActionType(2).setThrActionType(thrActionType).setExt1(getOutLayerRedType(redInfoBean));
        String str = "";
        if (redInfoBean.getRedDotReportExt() == null) {
            redDotReportExt = "";
        } else {
            redDotReportExt = redInfoBean.getRedDotReportExt();
        }
        QCircleLpReportDc05504DataBuilder ext7 = ext1.setExt5(redDotReportExt).setExt7(QCircleNativeSessionManager.g().getSession());
        if (redInfoBean.getTabTipWording() != null) {
            str = redInfoBean.getTabTipWording();
        }
        iQCircleReportApi.report5504(ext7.setExt8(str).setExt11(redInfoBean.getLastExposedRedPointInfo().extend.get()).setExt12(String.valueOf(mRedPointReceiveTime)).setExt13(String.valueOf(mRedPointDisplayTime)).setExt14(String.valueOf(mRedPointClickTime)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void reportDcQQCircleRedDotExpose() {
        String redDotReportExt;
        QCircleRedInfoBean redInfoBean = getRedInfoBean();
        if (QCircleHostUtil.isRedDotSame(redInfoBean.getRedPointInfo(), redInfoBean.getLastExposedRedPointInfo())) {
            return;
        }
        IQCircleReportApi iQCircleReportApi = (IQCircleReportApi) QRoute.api(IQCircleReportApi.class);
        QCircleLpReportDc05504DataBuilder ext1 = new QCircleLpReportDc05504DataBuilder().setActionType(111).setSubActionType(1).setThrActionType(getThrActionType(redInfoBean)).setExt1(getOutLayerRedType(redInfoBean));
        String str = "";
        if (redInfoBean.getRedDotReportExt() == null) {
            redDotReportExt = "";
        } else {
            redDotReportExt = redInfoBean.getRedDotReportExt();
        }
        QCircleLpReportDc05504DataBuilder ext7 = ext1.setExt5(redDotReportExt).setExt7(QCircleNativeSessionManager.g().getSession());
        if (redInfoBean.getTabTipWording() != null) {
            str = redInfoBean.getTabTipWording();
        }
        iQCircleReportApi.report5504(ext7.setExt8(str).setExt11(redInfoBean.getLastExposedRedPointInfo().extend.get()).setExt12(String.valueOf(mRedPointReceiveTime)).setExt13(String.valueOf(mRedPointDisplayTime)).setExt15(String.valueOf(mRedPointUIState)));
    }

    private static void reportDcQQCircleRedDotReceive() {
        String redDotReportExt;
        QCircleRedInfoBean redInfoBean = getRedInfoBean();
        if (QCircleHostUtil.isRedDotSame(redInfoBean.getRedPointInfo(), redInfoBean.getLastExposedRedPointInfo())) {
            return;
        }
        IQCircleReportApi iQCircleReportApi = (IQCircleReportApi) QRoute.api(IQCircleReportApi.class);
        QCircleLpReportDc05504DataBuilder ext1 = new QCircleLpReportDc05504DataBuilder().setActionType(111).setSubActionType(3).setThrActionType(getThrActionType(redInfoBean)).setExt1(getOutLayerRedType(redInfoBean));
        String str = "";
        if (redInfoBean.getRedDotReportExt() == null) {
            redDotReportExt = "";
        } else {
            redDotReportExt = redInfoBean.getRedDotReportExt();
        }
        QCircleLpReportDc05504DataBuilder ext7 = ext1.setExt5(redDotReportExt).setExt7(QCircleNativeSessionManager.g().getSession());
        if (redInfoBean.getTabTipWording() != null) {
            str = redInfoBean.getTabTipWording();
        }
        iQCircleReportApi.report5504(ext7.setExt8(str).setExt11(redInfoBean.getLastExposedRedPointInfo().extend.get()).setExt12(String.valueOf(mRedPointReceiveTime)).setExt15(String.valueOf(mRedPointUIState)));
    }

    private static void reportDtQQCircleRedDotClick(boolean z16) {
        String redDotReportExt;
        QCircleRedInfoBean redInfoBean = getRedInfoBean();
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
        buildElementParams.put("xsj_action_type", "clck");
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_EXTERNAL_ENTRANCE, QCircleDaTongConstant.ElementParamValue.QQ_MAIN_TAB);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_REDDOT_TYPE, getDtRedDotType(redInfoBean));
        String str = "";
        if (redInfoBean.getRedDotReportExt() == null) {
            redDotReportExt = "";
        } else {
            redDotReportExt = redInfoBean.getRedDotReportExt();
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_REDDOT_RECOM_TYPE, redDotReportExt);
        if (redInfoBean.getTabTipWording() != null) {
            str = redInfoBean.getTabTipWording();
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_REDDOT_RECOM_TEXT, str);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_REDDOT_IS_BUBBLE_CLICK, Integer.valueOf(z16 ? 1 : 0));
        VideoReport.reportEvent(QCircleDaTongConstant.EventId.EV_XSJ_EXTERNAL_ENTRANCE_ACTION, null, buildElementParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void reportDtQQCircleRedDotExpose() {
        String redDotReportExt;
        QCircleRedInfoBean redInfoBean = getRedInfoBean();
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
        buildElementParams.put("xsj_action_type", "imp");
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_EXTERNAL_ENTRANCE, QCircleDaTongConstant.ElementParamValue.QQ_MAIN_TAB);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_REDDOT_TYPE, getDtRedDotType(redInfoBean));
        String str = "";
        if (redInfoBean.getRedDotReportExt() == null) {
            redDotReportExt = "";
        } else {
            redDotReportExt = redInfoBean.getRedDotReportExt();
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_REDDOT_RECOM_TYPE, redDotReportExt);
        if (redInfoBean.getTabTipWording() != null) {
            str = redInfoBean.getTabTipWording();
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_REDDOT_RECOM_TEXT, str);
        VideoReport.reportEvent(QCircleDaTongConstant.EventId.EV_XSJ_EXTERNAL_ENTRANCE_ACTION, null, buildElementParams);
    }

    public static void reportQCircleRedDotExpose() {
        mRedPointDisplayTime = System.currentTimeMillis() / 1000;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.qcircle.QCircleFrame.4
            @Override // java.lang.Runnable
            public void run() {
                QCircleFrame.reportDcQQCircleRedDotExpose();
                QCircleFrame.reportDtQQCircleRedDotExpose();
            }
        }, 16, null, true);
    }

    private void reportQCircleTabClick() {
        ReportController.o(this.app, "CliOper", "", "", WinkDaTongReportConstant.ElementParamValue.LITTLE_WORLD, "bottom_tab_clk", getReportDwopVia(), 1, "", "", "", "");
    }

    private void reportRecoverEvent(long j3, boolean z16) {
        String str;
        IQCircleReportApi iQCircleReportApi = (IQCircleReportApi) QRoute.api(IQCircleReportApi.class);
        FeedCloudCommon$Entry[] feedCloudCommon$EntryArr = new FeedCloudCommon$Entry[2];
        feedCloudCommon$EntryArr[0] = QCircleReportHelper.newEntry("time_cost", String.valueOf(j3));
        if (z16) {
            str = "0";
        } else {
            str = "-1";
        }
        feedCloudCommon$EntryArr[1] = QCircleReportHelper.newEntry("ret_code", str);
        iQCircleReportApi.reportQualityEvent(RECOVER_FRAME_EVENT, Arrays.asList(feedCloudCommon$EntryArr), true);
    }

    private void saveQQTabRedPointInfo() {
        if (QFSMainMultiTabFragmentPart.Ka()) {
            QLog.d(TAG, 1, "[saveQQTabRedPointInfo]");
            y.g().w(y.i());
        }
    }

    private void setPerClickListener(QCircleSeekAreaFrameLayout qCircleSeekAreaFrameLayout) {
        if (qCircleSeekAreaFrameLayout == null) {
            return;
        }
        qCircleSeekAreaFrameLayout.setPreClickListener(new QCircleSeekAreaFrameLayout.b() { // from class: com.tencent.mobileqq.activity.qcircle.c
            @Override // com.tencent.mobileqq.qcircle.api.helper.QCircleSeekAreaFrameLayout.b
            public final void a(float f16, float f17, QCircleSeekAreaFrameLayout.a aVar) {
                QCircleFrame.this.lambda$setPerClickListener$4(f16, f17, aVar);
            }
        });
    }

    private void setRootViewBackground() {
        int i3;
        if (this.mRootView == null || uq3.c.g6()) {
            return;
        }
        FrameLayout frameLayout = this.mRootView;
        Resources resources = getResources();
        if (QQTheme.isNowThemeIsNight()) {
            i3 = R.color.can;
        } else {
            i3 = R.color.cam;
        }
        frameLayout.setBackgroundColor(resources.getColor(i3));
    }

    private void setRootViewBackgroundByConfig() {
        if (this.mRootView == null) {
            QLog.e(TAG, 1, "[setRootViewBackgroundByConfig] mRootView is null");
            return;
        }
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_host_frame_layout_background", false);
        QLog.d(TAG, 1, "[setRootViewBackgroundByConfig] configEnable:" + isSwitchOn);
        if (!isSwitchOn) {
            return;
        }
        this.mRootView.setBackgroundColor(getResources().getColor(R.color.can));
    }

    private boolean showInNavFragment() {
        if (com.tencent.mobileqq.activity.qcircle.utils.c.a() == SplitViewState.STATE_OVERLAP) {
            return true;
        }
        return false;
    }

    private void showTabWidgetIfNeed() {
        ViewGroup viewGroup;
        MainFragment mainFragment = this.mMainFragment;
        if (mainFragment != null && mainFragment.getTabHost() != null && (viewGroup = this.mMainFragment.mTabWidget) != null) {
            if (viewGroup.getVisibility() == 0) {
                QLog.d(TAG, 1, "[showTabWidgetIfNeed] is visible do nothing. ");
                return;
            } else {
                lambda$doTabWidgetAnim$5(true, 0L);
                return;
            }
        }
        QLog.d(TAG, 1, "[showTabWidgetIfNeed] tabWidget is null");
    }

    private void startFunctionFragment(Context context, boolean z16) {
        if (com.tencent.mobileqq.activity.qcircle.utils.c.j() && this.mIsOnTabSelected) {
            if (isShowingFunctionFragment()) {
                QLog.d(TAG, 1, "[startFunctionFragment] isShowingFunctionFragment: true");
                return;
            }
            QLog.d(TAG, 1, "[startFunctionFragment] isFromTabSelect: " + z16);
            com.tencent.mobileqq.pad.i.e(context, new Bundle(), QCircleFunctionFragment.class, new com.tencent.mobileqq.pad.b().e(false).g(true).h(LaunchMode.standard).a());
            if (!z16) {
                enterQCircleFragment(z16);
                return;
            }
            return;
        }
        QLog.e(TAG, 1, "[startFunctionFragment] not support start in function area");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void triggerRebuildFolderFragment() {
        if (!com.tencent.mobileqq.activity.qcircle.utils.c.i()) {
            releaseFolderFragment();
            createASFrame();
            if (this.mIsOnTabSelected) {
                QLog.i(TAG, 1, "recover after onPostThemeChanged");
                wrapFolderFragmentIfNeed();
                onTabSelected(false, false);
                return;
            }
            return;
        }
        rebuildOnFlatState(null);
    }

    private void tryInitFastPlayIoc(IASFragment iASFragment) {
        if (iASFragment == null) {
            QLog.d("QCircleFastVideoPlayWrapper_QCircleFrame", 1, "[tryInitFastPlayIoc] fragment is null");
            return;
        }
        if (iASFragment.getTargetDecorView() instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) iASFragment.getTargetDecorView();
            if (viewGroup.getChildCount() <= 0) {
                QLog.d("QCircleFastVideoPlayWrapper_QCircleFrame", 1, "[tryInitFastPlayIoc] targetDecorView childViewCount is 0");
                return;
            }
            View childAt = viewGroup.getChildAt(0);
            QLog.d("QCircleFastVideoPlayWrapper_QCircleFrame", 1, "[tryInitFastPlayIoc] iocRegisterContainer:" + childAt);
            this.mFastVideoPlayWrapper.h0(childAt);
        }
    }

    private void updateQCircleInnerState() {
        QLog.d(TAG, 1, "updateQCircleInnerState: ");
        QCircleHostGlobalInfo.setIsSplitViewMode(com.tencent.mobileqq.activity.qcircle.utils.c.j());
    }

    private void updateSmallWindowLockScreen(boolean z16) {
        SimpleEventBus.getInstance().dispatchEvent(new QFSSmallWindowScreenStateEvent(z16));
    }

    private void wrapFolderFragmentIfNeed() {
        wrapFolderFragmentIfNeed(false);
    }

    public void exitQCircleFragment() {
        com.tencent.mobileqq.auto.engine.main.b bVar;
        QLog.d(TAG, 1, "[exitQCircleFragment] ");
        checkIdleCacheTime();
        QCircleInjectImpl.Q0(this.mMainFragment, "QCircleFrame onTabUnSelected");
        q50.b.e().d();
        QCircleReportHelper.getInstance().setQCircleIsActivate(false);
        if (l40.i.I()) {
            boolean K = this.mFastVideoPlayWrapper.K();
            QLog.d("QCircleFastVideoPlayWrapper_QCircleFrame", 1, "[exitQCircleFragment] fastPlayHaveFinish\uff1a" + K);
            if (K && (bVar = this.mAsBaseFrame) != null) {
                bVar.h();
            }
            this.mFastVideoPlayWrapper.w();
        } else {
            com.tencent.mobileqq.auto.engine.main.b bVar2 = this.mAsBaseFrame;
            if (bVar2 != null) {
                bVar2.h();
            }
        }
        QCircleTianShuBubbleReporter.k();
        QCircleNativeSessionManager.g().exitQCircle();
        Map<String, String> f16 = QCircleNetWorkTestHelper.f();
        QCircleNetWorkTestHelper.d(f16);
        QCircleFolderFunnelCollect.recordNetWorkSpeedInfo(f16);
        QCircleFolderFunnelCollect.record(QCircleFolderFunnelCollect.PERIOD_EXIT_CIRCLE);
        handleSeekAreaStatus(false);
        handleQCircleTabActive(false);
        QCirclePanelStateEvent.resetPanelState();
        QCircleDeviceUsageUtils.e().g();
        QFSAdFeedSourcePreloadManager.k().p();
    }

    @Override // com.tencent.mobileqq.app.Frame
    public void fillData(boolean z16) {
        AppRuntime appRuntime = this.app;
        if (appRuntime != null) {
            ((QQAppInterface) appRuntime).addObserver(this.mQCircleRedDotObserver);
        }
        QCircleRedInfoBean qCircleRedInfoBean = sRedInfoBean;
        if (qCircleRedInfoBean != null) {
            qCircleRedInfoBean.reset();
        }
        if (z16) {
            releaseFolderFragment();
            this.mIsFirstEnterMainPage = true;
            handleQCircleTabAccountChanged();
            this.mFastVideoPlayWrapper.k0();
        } else {
            this.mReLogin = true;
        }
        MainFragment mainFragment = this.mMainFragment;
        if (mainFragment != null) {
            QCircleInjectImpl.Q0(mainFragment, "onAccountChanged");
        }
        com.tencent.mobileqq.auto.engine.main.b bVar = this.mAsBaseFrame;
        if (bVar != null) {
            bVar.c(z16);
        }
    }

    public FrameLayout getActivityRootContainer() {
        MainFragment mainFragment = this.mMainFragment;
        if (mainFragment != null && mainFragment.getView() != null) {
            ViewParent parent = this.mMainFragment.getView().getParent();
            if (!(parent instanceof ViewGroup)) {
                return null;
            }
            ViewGroup findContainerView = findContainerView((ViewGroup) parent);
            if (findContainerView instanceof FrameLayout) {
                return (FrameLayout) findContainerView;
            }
        }
        return null;
    }

    public com.tencent.mobileqq.auto.engine.main.b getAsBaseFrame() {
        return this.mAsBaseFrame;
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.be
    public View getContentView() {
        View contentView = super.getContentView();
        if (contentView != null) {
            onThirdTabInject();
        }
        return contentView;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QCircleFrameEvent.class);
        arrayList.add(QCircleRedInfoEvent.class);
        arrayList.add(QCircleTriggerBottomRefreshEvent.class);
        arrayList.add(QFSFrameTabBarVisibleEvent.class);
        arrayList.add(RFRestartAppEvent.class);
        arrayList.add(QFSTopViewRedEvent.class);
        arrayList.add(QFSStudyModeChangeEvent.class);
        arrayList.add(QCircleRedPointEvent.class);
        arrayList.add(QFSExitFoldCacheSaveEvent.class);
        return arrayList;
    }

    public Intent getJumpIntentFromActivity() {
        QBaseActivity activity;
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_qcircle_frame_get_intent_from_activity", true) || (activity = getActivity()) == null) {
            return null;
        }
        return activity.getIntent();
    }

    public View getQCircleDecorView() {
        IASFragment iASFragment = this.mFragment;
        if (iASFragment == null) {
            return null;
        }
        return iASFragment.getTargetDecorView();
    }

    public FrameLayout getQCircleTabContainer() {
        TabViewMap tabViewMap;
        MainFragment mainFragment = this.mMainFragment;
        if (mainFragment != null && (tabViewMap = mainFragment.mTabViewMap) != null) {
            View view = tabViewMap.get(TabDataHelper.TAB_NEW_WORLD);
            if (!(view instanceof FrameLayout)) {
                QLog.d(TAG, 1, "getQCircleTabContainer, mTabs[8] is not FrameLayout ");
                return null;
            }
            return (FrameLayout) view;
        }
        QLog.d(TAG, 1, "getQCircleTabContainer, mMainFragment or mTabs is null ");
        return null;
    }

    public int getTabHeight() {
        return this.mTabHeight;
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.be
    public boolean hasInited() {
        return true;
    }

    public void initNavContentInFlatState() {
        FrameLayout frameLayout = this.mRootView;
        if (frameLayout != null && this.mPadNavContentStub == null) {
            ViewStub viewStub = (ViewStub) frameLayout.findViewById(R.id.f219202b);
            this.mPadNavContentStub = viewStub;
            if (viewStub == null) {
                QLog.d(TAG, 1, "don't find pad navigation content");
                return;
            }
            View inflate = viewStub.inflate();
            this.mNavContentView = inflate;
            TextView textView = (TextView) inflate.findViewById(R.id.f45141r3);
            loadPadNavContentPic();
            if (textView == null) {
                return;
            }
            textView.setText(com.dataline.util.j.d(com.tencent.biz.qqcircle.utils.h.a(R.string.f19081434)));
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.qcircle.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QCircleFrame.this.lambda$initNavContentInFlatState$1(view);
                }
            });
            return;
        }
        loadPadNavContentPic();
    }

    public boolean isQCircleTabSelected() {
        return this.mIsOnTabSelected;
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.ba
    public void notifyActivityResult(int i3, int i16, Intent intent) {
        super.notifyActivityResult(i3, i16, intent);
        IASFragment iASFragment = this.mFragment;
        if (iASFragment != null) {
            iASFragment.onActivityResult(i3, i16, intent);
        }
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.ba
    public boolean notifyBackPressed() {
        if (com.tencent.mobileqq.activity.qcircle.utils.c.i() && isShowQTab() && !isShowingFunctionFragment()) {
            getActivity().moveTaskToBack(true);
            return true;
        }
        com.tencent.mobileqq.auto.engine.main.b bVar = this.mAsBaseFrame;
        if (bVar != null) {
            boolean d16 = bVar.d();
            QLog.d("ASDynamicEngine_back", 1, "onBackPressed qcircleFrame:" + d16);
            return d16;
        }
        return super.notifyBackPressed();
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.ba
    public void notifyConfigurationChanged(Configuration configuration) {
        DisplayUtil.init(getActivity(), configuration);
        super.notifyConfigurationChanged(configuration);
        handleConfigChangeInFlatState(configuration);
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.ba
    public void notifyCreate() {
        QLog.d(TAG, 1, "onCreate: ");
        super.notifyCreate();
        SimpleEventBus.getInstance().registerReceiver(this);
        QCircleTabRedPointBubbleShowController.z(getActivity());
        com.tencent.biz.qqcircle.helpers.b.a().b(this);
        this.mFastVideoPlayWrapper.l0(new a());
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.ba
    public View notifyCreateView(LayoutInflater layoutInflater) {
        QLog.d(TAG, 1, "onCreateView: ");
        onThirdTabInject();
        updateQCircleInnerState();
        inflateRootView(layoutInflater);
        if (this.mFragment == null) {
            createQCircleView(false);
        } else {
            QLog.d(TAG, 1, "onCreateView from preload success");
        }
        if (com.tencent.mobileqq.activity.qcircle.utils.c.i()) {
            initNavContentInFlatState();
            setNavContentVisible(false);
        } else {
            wrapFolderFragmentIfNeed();
            QLog.d(TAG, 1, "onCreateView new fragment");
        }
        return this.mRootView;
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.ba
    public void notifyDestroy() {
        QCircleObserver qCircleObserver;
        QLog.d(TAG, 1, "onDestroy: ");
        super.notifyDestroy();
        notifyContentView(null);
        this.mRootView = null;
        QCircleHostGlobalInfo.setCurrentTabActive(false);
        l.t().K(null);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        AppRuntime appRuntime = this.app;
        if (appRuntime != null && (qCircleObserver = this.mQCircleRedDotObserver) != null) {
            ((QQAppInterface) appRuntime).removeObserver(qCircleObserver);
        }
        getMainHandler().removeCallbacksAndMessages(null);
        com.tencent.mobileqq.auto.engine.main.b bVar = this.mAsBaseFrame;
        if (bVar != null) {
            bVar.f();
        }
        handleQCircleTabDestroy();
        this.mMainFragment = null;
        com.tencent.mobileqq.auto.engine.loader.a.e(ASEngineConstants.BusinessKey.BUSINESS_QCIRCLE).A(false);
        QCirclePluginUtil.setIsTabModeJudgeByQCircleFrame(false);
        QCircleHostGlobalInfo.setIsSplitViewMode(false);
        QCircleHostGlobalInfo.setIsNowFlatState(false);
        QCirclePluginUtil.setsIsTabModeForPad(false);
        this.mFastVideoPlayWrapper.j0();
        this.mFastVideoPlayWrapper.d0();
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.ba
    public void notifyNewIntent(Intent intent) {
        super.notifyNewIntent(intent);
        if (this.mFragment == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable(ASEngineConstants.ShadowEngineKey.KEY_AS_ENTER_BEAN, getInitBean());
        this.mFragment.onNewIntent(bundle);
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.ba
    public void notifyPause(boolean z16) {
        QLog.d(TAG, 1, "onPause: ");
        super.notifyPause(z16);
        ApngImage.pauseByTag(8);
        FrameHelperActivity.gj(true, TAG);
        IASFragment iASFragment = this.mFragment;
        if (iASFragment != null && !iASFragment.isRealFragment()) {
            this.mFragment.onPause();
        }
        com.tencent.mobileqq.qcircle.api.global.a.b();
        this.mFastVideoPlayWrapper.e0();
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.ba
    public void notifyResume(boolean z16) {
        MainFragment mainFragment;
        if (checkLockScreen("onResume")) {
            QLog.w(TAG, 1, "[onResume] current is lock screen state, not call onResume.");
            return;
        }
        uq3.k.a().j("sp_key_qcircle_open_pic_select_page", false);
        QLog.d(TAG, 1, "onResume: ");
        super.notifyResume(z16);
        recoverFrame(this.mRootView, true);
        recoverEmptyFrame();
        ApngImage.playByTag(8);
        MainFragment mainFragment2 = this.mMainFragment;
        if (mainFragment2 != null) {
            QCircleInjectImpl.Q0(mainFragment2, "QCircleFrame onResume");
        }
        if (this.mIsOnTabSelected) {
            FrameHelperActivity.gj(false, TAG);
            if (QLog.isColorLevel() && (mainFragment = this.mMainFragment) != null && mainFragment.Ki()) {
                QLog.d(TAG, 2, "in circle but head is visible");
            }
            reDispatchSelectOnResume();
            forceHideQQHead();
        }
        if (z16) {
            QCircleHostGlobalInfo.setCurrentTabActive(!com.tencent.mobileqq.activity.qcircle.utils.c.i());
        }
        IASFragment iASFragment = this.mFragment;
        if (iASFragment != null && !iASFragment.isRealFragment()) {
            onResumeInFlatState();
            this.mFragment.onResume();
        }
        this.mFastVideoPlayWrapper.f0();
        reNotifyResumeByEvent();
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.ba
    public void notifyStart() {
        if (checkLockScreen("onStart")) {
            QLog.w(TAG, 1, "[onStart] current is lock screen state, not call onStart.");
        } else {
            QLog.d(TAG, 1, "onStart: ");
            super.notifyStart();
        }
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.ba
    public void notifyStop() {
        QLog.d(TAG, 1, "onStop: ");
        super.notifyStop();
        IASFragment iASFragment = this.mFragment;
        if (iASFragment != null && !iASFragment.isRealFragment()) {
            this.mFragment.onStop();
        }
    }

    @Override // com.tencent.mobileqq.app.Frame
    public void onBeforeAccountChanged() {
        AppRuntime appRuntime = this.app;
        if (appRuntime != null) {
            ((QQAppInterface) appRuntime).removeObserver(this.mQCircleRedDotObserver);
        }
    }

    @Override // common.config.service.QzoneConfig.QzoneConfigChangeListener
    public void onConfigChange() {
        MainFragment mainFragment = this.mMainFragment;
        if (mainFragment != null) {
            QCircleInjectImpl.Q0(mainFragment, "Wns onConfigChange");
        }
    }

    public void onPostThemeChanged(FrameFragment frameFragment, com.tencent.mobileqq.activity.qcircle.utils.b bVar) {
        if (!bVar.r()) {
            QLog.i(TAG, 1, "[onPostThemeChanged] theme not change");
            bVar.v(isQCircleTabSelected(), false);
            return;
        }
        SimpleEventBus.getInstance().dispatchEvent(new QFSThemeChangeEvent());
        QLog.i(TAG, 1, "[onPostThemeChanged]");
        bVar.y(bVar.i());
        MainFragment mainFragment = this.mMainFragment;
        if (mainFragment != null) {
            QCircleInjectImpl.Q0(mainFragment, "onPostThemeChanged");
        }
        setRootViewBackground();
        if (!com.tencent.mobileqq.activity.qcircle.utils.c.i()) {
            releaseFolderFragment();
            createASFrame();
            bVar.v(isQCircleTabSelected(), true);
            if (this.mIsOnTabSelected) {
                QLog.i(TAG, 1, "recover after onPostThemeChanged");
                wrapFolderFragmentIfNeed();
                onTabSelected(false, false);
                return;
            }
            return;
        }
        rebuildOnFlatState(bVar);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        handleQCircleFrameEvent(simpleBaseEvent);
        handleRedInfoEvent(simpleBaseEvent);
        handleCheckRefresh(simpleBaseEvent);
        handleTabBarVisibleEvent(simpleBaseEvent);
        handleRestartAppEvent(simpleBaseEvent);
        handleTopViewRedEvent(simpleBaseEvent);
        handleStudyModeChangeEvent(simpleBaseEvent);
        handleRedPointReceiveEvent(simpleBaseEvent);
        handleFoldExitCacheSaveEvent(simpleBaseEvent);
    }

    public void onStudyModeChange(FrameFragment frameFragment) {
        if (!p.a("qcircle_enable_use_native_fragment_v3")) {
            return;
        }
        RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.qcircle.b
            @Override // java.lang.Runnable
            public final void run() {
                QCircleFrame.this.triggerRebuildFolderFragment();
            }
        }, 1000L);
    }

    public void onTabClickSelf() {
        QLog.d(TAG, 1, "onTabClickSelf");
        reportQCircleTabClick();
        if (getActivity() != null) {
            SimpleEventBus.getInstance().dispatchEvent(new QCircleFrameEvent(getActivity().hashCode(), 0));
        }
        com.tencent.mobileqq.auto.engine.main.b bVar = this.mAsBaseFrame;
        if (bVar != null) {
            bVar.e();
        }
    }

    public void onTabDataChange() {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "onTabDataChange");
        }
    }

    public void onTabSelected(boolean z16, boolean z17) {
        QLog.i(TAG, 1, "[onTabSelected], changedByTipClick = " + z16 + ", isTipsShowing = " + z17 + ", isLandscape = " + com.tencent.mobileqq.activity.qcircle.utils.c.h() + ", isSplitViewMode = " + com.tencent.mobileqq.activity.qcircle.utils.c.j());
        if (bz.r() && fb0.a.b(TAG, 500L) && this.mIsOnTabSelected) {
            QLog.d(TAG, 1, "[onTabSelected] fast click");
            return;
        }
        CACHE_VALID_DURATION_TIME = uq3.c.t3() * 1000;
        this.mIsOnTabSelected = true;
        changeBgInFlatState();
        forceHideQQHead();
        setNavContentVisible(com.tencent.mobileqq.activity.qcircle.utils.c.i());
        if (com.tencent.mobileqq.activity.qcircle.utils.c.i()) {
            initNavContentInFlatState();
            startFunctionFragment(getActivity(), true);
        }
        reportQCircleTabClick();
        reportQQCircleRedDotClick(z16);
        QLog.d(TAG, 1, "[onTabSelected] tabHeight: " + getTabHeight());
        wrapFolderFragmentIfNeed();
        com.tencent.biz.qqcircle.utils.l.j();
        enterQCircleFragment(true);
        if (uq3.o.A()) {
            QLog.d(TAG, 1, "[onTabSelected] release other player");
            SuperPlayerSDKMgr.releaseOtherScened(String.valueOf(126));
        }
    }

    public void onTabUnSelected(int i3) {
        QLog.d(TAG, 1, "onTabUnSelected");
        com.tencent.mobileqq.auto.engine.loader.a.e(ASEngineConstants.BusinessKey.BUSINESS_QCIRCLE).A(false);
        this.mIsOnTabSelected = false;
        changeBgInFlatState();
        setNavContentVisible(false);
        removeFunctionFragment();
        QCircleHostGlobalInfo.setCurrentTabActive(false);
        exitQCircleFragment();
        com.tencent.mobileqq.qcircle.api.global.a.b();
        showTabWidgetIfNeed();
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.be
    public View preLoadView(LayoutInflater layoutInflater) {
        if (enableFixFastClickInPad()) {
            return this.mRootView;
        }
        updateQCircleInnerState();
        if (com.tencent.mobileqq.activity.qcircle.utils.c.i()) {
            initNavContentInFlatState();
            setNavContentVisible(false);
        }
        inflateRootView(layoutInflater);
        createQCircleView(true);
        preloadFolderTab();
        QLog.d(TAG, 1, "preLoadView view success");
        return this.mRootView;
    }

    public void recoverFrame(FrameLayout frameLayout, boolean z16) {
        if (OPEN_RECOVER_FRAME && needReBuildDecorView()) {
            QLog.i(TAG, 1, "need recoverFrame");
            if (frameLayout != null && this.mAsBaseFrame != null) {
                try {
                    long nanoTime = System.nanoTime();
                    IASFragment iASFragment = this.mFragment;
                    if (iASFragment != null && iASFragment.getTargetDecorView() != null) {
                        frameLayout.removeView(this.mFragment.getTargetDecorView());
                    }
                    this.mAsBaseFrame.i();
                    onOldFragmentDestroy();
                    this.mFragment = null;
                    if (z16) {
                        wrapFolderFragmentIfNeed();
                        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_reselected_when_re_build_frame", true)) {
                            onTabSelected(false, false);
                        }
                    } else {
                        recoverViewInFunctionFragment(frameLayout);
                    }
                    QLog.i(TAG, 1, "recoverFrame success");
                    reportRecoverEvent(System.nanoTime() - nanoTime, true);
                } catch (Throwable th5) {
                    reportRecoverEvent(0L, false);
                    QLog.e(TAG, 1, "recoverDecorView error:" + th5.getMessage(), th5);
                }
            }
        }
    }

    public void reportQCircleFrameExpose() {
        ReportController.o(this.app, "CliOper", "", "", WinkDaTongReportConstant.ElementParamValue.LITTLE_WORLD, "bottom_tab_exp", getReportDwopVia(), 1, "", "", "", "");
    }

    public void reportQQCircleRedDotClick(boolean z16) {
        if (!TextUtils.isEmpty(QCircleHostGlobalInfo.getTabModeSchema()) && ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_intercept_schema_tab_click_report", true)) {
            return;
        }
        mRedPointClickTime = System.currentTimeMillis() / 1000;
        reportDcQQCircleRedDotClick(z16);
        reportDtQQCircleRedDotClick(z16);
        if (sRedInfoBean.isShowRedDot()) {
            QFSTopViewManager.e().m();
        }
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.be
    public void setActivity(QBaseActivity qBaseActivity) {
        super.setActivity(qBaseActivity);
    }

    public void setIntent(Intent intent) {
        if (intent == null) {
            return;
        }
        IASFragment iASFragment = this.mFragment;
        if (iASFragment instanceof com.tencent.mobileqq.auto.engine.main.fragment.d) {
            ((com.tencent.mobileqq.auto.engine.main.fragment.d) iASFragment).g(intent);
        }
    }

    public void setMainFragment(MainFragment mainFragment) {
        this.mMainFragment = mainFragment;
        tryInitFastPlayVideoView(mainFragment);
    }

    public void setNavContentVisible(boolean z16) {
        int i3;
        if (this.mNavContentView != null) {
            QLog.d(TAG, 1, "setNavContentVisible: " + z16);
            View view = this.mNavContentView;
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view.setVisibility(i3);
        }
    }

    public void setTabHeight(int i3) {
        if (i3 == this.mTabHeight) {
            return;
        }
        this.mTabHeight = i3;
        FrameLayout frameLayout = this.mRootView;
        if (frameLayout != null) {
            frameLayout.setPadding(0, 0, 0, 0);
        }
        HostUIHelper.getInstance().setHostTABHeight(this.mTabHeight);
    }

    public void tryInitFastPlayVideoView(FrameFragment frameFragment) {
        IASFragment iASFragment;
        if (!l40.i.I()) {
            return;
        }
        tryInitFastPlayIoc(this.mFragment);
        if (!this.mFastVideoPlayWrapper.U() && (iASFragment = this.mFragment) != null && (iASFragment.getTargetDecorView() instanceof ViewGroup) && frameFragment != null) {
            if (frameFragment.getTabHost() != null || frameFragment.getTabHost().a() != null) {
                int height = frameFragment.mTabWidget.getHeight();
                ViewGroup viewGroup = (ViewGroup) getActivity().getWindow().getDecorView();
                ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(android.R.id.content);
                if (viewGroup2 != null) {
                    viewGroup = viewGroup2;
                }
                QLog.d("QCircleFastVideoPlayWrapper_QCircleFrame", 1, "[tryInitFastPlay] fastPlayRootView\uff1a" + viewGroup + ",contentView:" + viewGroup2);
                this.mFastVideoPlayWrapper.o0(viewGroup, r.K(viewGroup.getContext()) - ImmersiveUtils.dpToPx(1.0f), height, false);
            }
        }
    }

    private void wrapFolderFragmentIfNeed(boolean z16) {
        QLog.d(TAG, 1, "wrapFolderFragmentIfNeed");
        if (com.tencent.mobileqq.activity.qcircle.utils.c.i() || this.mRootView == null) {
            return;
        }
        if (this.mFragment == null) {
            QLog.d(TAG, 1, "[wrapFolderFragmentIfNeed] fragment is null. ");
            createNewASFragment(z16);
        }
        if (this.mFragment.isAdded()) {
            QLog.d(TAG, 1, "[wrapFolderFragmentIfNeed] fragment is already added. ");
            return;
        }
        if (this.mFragment.isRealFragment()) {
            QLog.d(TAG, 1, "[wrapFolderFragmentIfNeed] fragment is real fragment. ");
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.f31230qh, (Fragment) this.mFragment).commitAllowingStateLoss();
        } else {
            View targetDecorView = this.mFragment.getTargetDecorView();
            QLog.d(TAG, 1, "[wrapFolderFragmentIfNeed] add decorView success;targetDecorView:" + targetDecorView);
            if (targetDecorView != null) {
                targetDecorView.setTag(TAG);
                this.mRootView.addView(targetDecorView, -1, -1);
            }
        }
        QCirclePeriodCollect.record(QCirclePeriodCollect.PERIOD_ENTER_CLICK);
    }

    private void handleQCircleTabAccountChanged() {
    }

    private void handleQCircleTabDestroy() {
    }

    private void handleQCircleTabActive(boolean z16) {
    }
}
