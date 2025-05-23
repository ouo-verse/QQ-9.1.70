package com.tencent.mobileqq.activity.leba;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResultCaller;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.Page;
import com.tencent.cache.api.PageHierarchy;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.activity.main.LebaTabRedTouch;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.leba.feed.ILebaPluginFeedApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.servlet.QZoneNotifyServlet;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.studymode.StudyModeChangeListener;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.utils.abtest.QCommonOnlineExpProviderImpl;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qzonehub.api.IQZoneApiProxy;
import com.tencent.qzonehub.api.IQZoneEnvApi;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.shadow.dynamic.host.Constant;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QZoneConfigHelper;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.api.QZoneApiProxy;
import cooperation.qzone.api.QzoneFragmentImpl;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.QZoneLoginReportHelper;
import cooperation.qzone.util.QZLog;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import ji3.k;
import mqq.app.AppRuntime;

/* compiled from: P */
@Page(business = Business.QZone, type = PageHierarchy.MainPage)
/* loaded from: classes10.dex */
public class QzoneFrame extends Frame {
    static IPatchRedirector $redirector_ = null;
    private static final long CHANGE_THEME_INTERVAL = 1000;
    public static int FRIENDFEED = 0;
    private static final String QZONE_FRAME_TAG = "QzoneFrameFragment";
    public static String QZONE_PUBLISH_QUEUE_NOTIFY = null;
    public static String QZONE_PUBLISH_QUEUE_NOTIFY_FROM_QUERY = null;
    private static final String TAG = "QzoneFrame";
    private static boolean mIsNewConciseQzoneFrame;
    private static boolean mIsShowOldQZoneFrame;
    private static boolean mQZoneFrameViewEnable;
    BroadcastReceiver broadcastReceiver;
    private boolean isStop;
    private long mCurrentChangeThemeTime;
    private boolean mEnableNewResume;
    private Fragment mFragment;
    private FragmentManager mFragmentManager;
    private Set<com.tencent.mobileqq.activity.leba.presenter.a> mFramePresenterSet;
    private com.tencent.mobileqq.leba.feed.c mNavigatorController;
    private ViewGroup mQZoneTitleView;
    private FragmentContainerView mQzoneContainer;
    private ViewGroup mQzoneTitleContainer;
    private View mRootView;
    private StudyModeChangeListener mStudyModeChangeListener;
    private boolean mZPlanQZoneSwitchState;
    private k mZPlanSwitchChangeListener;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QzoneFrame.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
            } else if (QzoneFrame.this.mFragment != null) {
                ((QzoneFragmentImpl) QzoneFrame.this.mFragment).updatePublishBox(intent);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(68503);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 23)) {
            redirector.redirect((short) 23);
            return;
        }
        FRIENDFEED = 1;
        QZONE_PUBLISH_QUEUE_NOTIFY = "qzone_publish_queue_notify";
        QZONE_PUBLISH_QUEUE_NOTIFY_FROM_QUERY = "qzone_publish_queue_notify_from_query";
    }

    public QzoneFrame() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.isStop = true;
        this.mCurrentChangeThemeTime = 0L;
        this.mZPlanQZoneSwitchState = false;
        this.mZPlanSwitchChangeListener = null;
        this.broadcastReceiver = new a();
    }

    private void destroyQzoneFragment() {
        if (isFragmentAdded()) {
            ActivityResultCaller activityResultCaller = this.mFragment;
            if (activityResultCaller instanceof QzoneFragmentImpl) {
                ((QzoneFragmentImpl) activityResultCaller).clearMemoryCache();
            }
            ensureFragmentRemoved();
            this.mFragment = null;
        }
    }

    private void dispatchInitAction(QBaseActivity qBaseActivity, Fragment fragment, View view) {
        Set<com.tencent.mobileqq.activity.leba.presenter.a> set = this.mFramePresenterSet;
        if (set != null && !set.isEmpty()) {
            for (com.tencent.mobileqq.activity.leba.presenter.a aVar : this.mFramePresenterSet) {
                if (aVar != null) {
                    aVar.b(qBaseActivity, fragment, view);
                }
            }
        }
    }

    private void dispatchSwitchState(boolean z16) {
        Set<com.tencent.mobileqq.activity.leba.presenter.a> set = this.mFramePresenterSet;
        if (set != null && !set.isEmpty()) {
            for (com.tencent.mobileqq.activity.leba.presenter.a aVar : this.mFramePresenterSet) {
                if (aVar != null) {
                    if (z16) {
                        aVar.a();
                    } else {
                        aVar.c();
                    }
                }
            }
        }
    }

    private void ensureFragmentRemoved() {
        FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager != null && fragmentManager.getFragments().size() > 0) {
            for (Fragment fragment : this.mFragmentManager.getFragments()) {
                if (fragment instanceof QzoneFragmentImpl) {
                    try {
                        this.mFragmentManager.beginTransaction().remove(fragment).commitNowAllowingStateLoss();
                        FragmentContainerView fragmentContainerView = this.mQzoneContainer;
                        if (fragmentContainerView != null) {
                            fragmentContainerView.removeAllViews();
                        }
                    } catch (Exception e16) {
                        QLog.e(TAG, 1, e16, new Object[0]);
                    }
                }
            }
        }
    }

    private String getFrameFragmentClass(boolean z16) {
        if (z16) {
            return QZoneApiProxy.FEEDX_FRAME_ZPALN_FRAGMENT_CLASS_NAME;
        }
        return QZoneApiProxy.FEEDX_FRAME_FRAGMENT_CLASS_NAME;
    }

    private Fragment getMainFragment(QBaseActivity qBaseActivity) {
        if (qBaseActivity != null) {
            return qBaseActivity.getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
        }
        return null;
    }

    private void initListeners() {
        try {
            getActivity().registerReceiver(this.broadcastReceiver, new IntentFilter(new IntentFilter(QZONE_PUBLISH_QUEUE_NOTIFY)));
            QLog.d(TAG, 1, "[registerReceiver] this: ", toString());
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "registerReceiver" + th5);
        }
        dispatchInitAction(getActivity(), this.mFragment, this.mRootView);
        try {
            registerZplanSwitchListener();
            registerStudyModeListener();
        } catch (Throwable th6) {
            QLog.e(TAG, 1, "[onCreate] register zplan switch, error:", th6);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initQzoneFrameFragment() {
        boolean isNewQConciseFragment = isNewQConciseFragment();
        Fragment createLebaFragment = QZoneApiProxy.createLebaFragment(getActivity(), (QQAppInterface) this.app, getFrameFragmentClass(isNewQConciseFragment));
        this.mFragment = createLebaFragment;
        mIsShowOldQZoneFrame = !isNewQConciseFragment;
        if (createLebaFragment instanceof QzoneFragmentImpl) {
            ((QzoneFragmentImpl) createLebaFragment).setTitleView(this.mQZoneTitleView);
            if (this.mFragmentManager != null) {
                ensureFragmentRemoved();
                this.mFragmentManager.beginTransaction().add(this.mFragment, QZONE_FRAME_TAG).commitNowAllowingStateLoss();
                this.mQzoneContainer.addView(this.mFragment.getView());
            }
        }
    }

    private boolean isFragmentAdded() {
        Fragment fragment = this.mFragment;
        if (fragment != null && fragment.isAdded()) {
            return true;
        }
        return false;
    }

    public static boolean isNewConciseFragment() {
        QLog.d(TAG, 1, "isNewConciseFragment: ", Boolean.valueOf(mIsNewConciseQzoneFrame));
        return mIsNewConciseQzoneFrame;
    }

    private boolean isNewQConciseFragment() {
        boolean equals = QCommonOnlineExpProviderImpl.EXP_QQ_LEBA_CONCISE_THEME_CONTENT_B.equals(((IQZoneApiProxy) QRoute.api(IQZoneApiProxy.class)).getExpContentInSimpleUI(this.app));
        if (QCommonOnlineExpProviderImpl.EXP_QQ_LEBA_POST_BTN_MODE_B.equals(((IQZoneApiProxy) QRoute.api(IQZoneApiProxy.class)).getExpPostBtnMode(this.app)) || QCommonOnlineExpProviderImpl.EXP_QQ_LEBA_POST_BTN_MODE_C.equals(((IQZoneApiProxy) QRoute.api(IQZoneApiProxy.class)).getExpPostBtnMode(this.app))) {
            equals = true;
        }
        if (SimpleUIUtil.isNowElderMode()) {
            equals = false;
        }
        mIsNewConciseQzoneFrame = equals;
        return equals;
    }

    public static boolean isNewQZoneFrame(AppRuntime appRuntime) {
        boolean z16 = true;
        if (appRuntime == null) {
            QLog.e(TAG, 1, "app is null");
            return false;
        }
        boolean equals = QCommonOnlineExpProviderImpl.EXP_QQ_LEBA_CONCISE_THEME_CONTENT_B.equals(((IQZoneApiProxy) QRoute.api(IQZoneApiProxy.class)).getExpContentInSimpleUI(appRuntime));
        if (!QCommonOnlineExpProviderImpl.EXP_QQ_LEBA_POST_BTN_MODE_B.equals(((IQZoneApiProxy) QRoute.api(IQZoneApiProxy.class)).getExpPostBtnMode(appRuntime)) && !QCommonOnlineExpProviderImpl.EXP_QQ_LEBA_POST_BTN_MODE_C.equals(((IQZoneApiProxy) QRoute.api(IQZoneApiProxy.class)).getExpPostBtnMode(appRuntime))) {
            z16 = equals;
        }
        if (SimpleUIUtil.isNowElderMode()) {
            return false;
        }
        return z16;
    }

    public static boolean isQZoneFrameViewEnable() {
        return mQZoneFrameViewEnable;
    }

    public static boolean isShowOldQZoneFrame() {
        return mIsShowOldQZoneFrame;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$registerStudyModeListener$0(boolean z16) {
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.activity.leba.b
            @Override // java.lang.Runnable
            public final void run() {
                QzoneFrame.this.recreateFragment();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$registerZplanSwitchListener$1(boolean z16) {
        QZLog.i("QZoneConciseZPlan QzoneFrame", 1, "[Exit Setting ZPlan Switch] lastSwitchState = " + this.mZPlanQZoneSwitchState + ", curSwitchState = " + z16);
        if (this.mZPlanQZoneSwitchState == z16) {
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.leba.QzoneFrame.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QzoneFrame.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    QzoneFrame.this.onZPlanQZoneSwitchChanged();
                }
            }
        });
        this.mZPlanQZoneSwitchState = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recreateFragment() {
        try {
            QLog.d(TAG, 1, "[recreateFragment] this: ", toString());
            notifyDestroy();
            notifyCreate();
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
    }

    private void registerPresenterSet() {
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        this.mFramePresenterSet = copyOnWriteArraySet;
        copyOnWriteArraySet.add(new com.tencent.mobileqq.activity.leba.presenter.b());
    }

    private void registerStudyModeListener() {
        if (this.mStudyModeChangeListener == null) {
            this.mStudyModeChangeListener = new StudyModeChangeListener() { // from class: com.tencent.mobileqq.activity.leba.a
                @Override // com.tencent.mobileqq.studymode.StudyModeChangeListener
                public final void onChange(boolean z16) {
                    QzoneFrame.this.lambda$registerStudyModeListener$0(z16);
                }
            };
        }
        ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).registerStudyModeChangeListener(this.mStudyModeChangeListener);
    }

    private void registerZplanSwitchListener() {
        this.mZPlanQZoneSwitchState = ((IZPlanApi) QRoute.api(IZPlanApi.class)).isQzoneEntranceEnabled(this.app.getLongAccountUin());
        QZLog.i("QZoneConciseZPlan QzoneFrame", 1, "ZPlan Switch init State=" + this.mZPlanQZoneSwitchState);
        if (this.mZPlanSwitchChangeListener == null) {
            this.mZPlanSwitchChangeListener = new k() { // from class: com.tencent.mobileqq.activity.leba.c
                @Override // ji3.k
                public final void onChange(boolean z16) {
                    QzoneFrame.this.lambda$registerZplanSwitchListener$1(z16);
                }
            };
        }
        ((IZPlanApi) QRoute.api(IZPlanApi.class)).setOnSettingChangeListener((QQAppInterface) this.app, Constant.FROM_ID_UNINSTALL_PLUGIN, this.mZPlanSwitchChangeListener);
    }

    private void tryOnPause() {
        FragmentManager fragmentManager;
        if (this.mEnableNewResume && (fragmentManager = this.mFragmentManager) != null) {
            fragmentManager.beginTransaction().setMaxLifecycle(this.mFragment, Lifecycle.State.STARTED).commitNowAllowingStateLoss();
        } else {
            this.mFragment.onPause();
        }
    }

    private void tryResume() {
        FragmentManager fragmentManager;
        if (this.mEnableNewResume && (fragmentManager = this.mFragmentManager) != null) {
            fragmentManager.beginTransaction().setMaxLifecycle(this.mFragment, Lifecycle.State.RESUMED).commitNowAllowingStateLoss();
        } else {
            this.mFragment.onResume();
        }
    }

    @Override // com.tencent.mobileqq.app.Frame
    public void fillData(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, z16);
        }
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.be
    public boolean hasInited() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        return isFragmentAdded();
    }

    public boolean isStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        return this.isStop;
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.ba
    public void notifyActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.notifyActivityResult(i3, i16, intent);
        if (isFragmentAdded()) {
            this.mFragment.onActivityResult(i3, i16, intent);
        }
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.ba
    public boolean notifyBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        ActivityResultCaller activityResultCaller = this.mFragment;
        if ((activityResultCaller instanceof com.tencent.mobileqq.zootopia.api.b) && ((com.tencent.mobileqq.zootopia.api.b) activityResultCaller).onBackPressedEvent()) {
            return true;
        }
        return super.notifyBackPressed();
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.ba
    public void notifyConfigurationChanged(Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) configuration);
            return;
        }
        super.notifyConfigurationChanged(configuration);
        if (isFragmentAdded()) {
            this.mFragment.onConfigurationChanged(configuration);
        }
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.ba
    public void notifyCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        boolean z16 = false;
        QLog.d(TAG, 1, "[onCreate] create this: ", toString());
        super.notifyCreate();
        registerPresenterSet();
        this.mNavigatorController = ((ILebaPluginFeedApi) QRoute.api(ILebaPluginFeedApi.class)).getLebaPluginFeedController(getActivity(), this.app, getActivity());
        QZoneApiProxy.initEnv(getActivity(), (QQAppInterface) this.app);
        QZoneApiProxy.initServlet(getActivity(), (QQAppInterface) this.app);
        ViewGroup viewGroup = (ViewGroup) this.mRootView.findViewById(R.id.dhn);
        this.mQzoneTitleContainer = viewGroup;
        this.mQZoneTitleView = (ViewGroup) viewGroup.findViewById(R.id.f166674ha2);
        this.mQzoneContainer = (FragmentContainerView) this.mRootView.findViewById(R.id.dgz);
        initQzoneFrameFragment();
        initListeners();
        if (QzoneConfig.getInstance().getConfig("QZoneSetting", "SECONDARY_QZONE_FRAME_RESUME_NEW", 1) == 1) {
            z16 = true;
        }
        this.mEnableNewResume = z16;
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.ba
    public View notifyCreateView(LayoutInflater layoutInflater) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this, (Object) layoutInflater);
        }
        this.mRootView = layoutInflater.inflate(R.layout.aky, (ViewGroup) null);
        if (isNewQConciseFragment() && (view = this.mRootView) != null) {
            view.findViewById(R.id.jq6).setVisibility(0);
        }
        mQZoneFrameViewEnable = true;
        return this.mRootView;
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.ba
    public void notifyDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        QLog.d(TAG, 1, "[onDestroy] destroy this: ", toString());
        super.notifyDestroy();
        try {
            getActivity().unregisterReceiver(this.broadcastReceiver);
            QLog.d(TAG, 1, "[unregisterReceiver] this: ", toString());
        } catch (Exception e16) {
            QLog.e(TAG, 1, "registerReceiver" + e16);
        }
        ViewGroup viewGroup = this.mQZoneTitleView;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        destroyQzoneFragment();
        mQZoneFrameViewEnable = false;
        mIsShowOldQZoneFrame = false;
        ((IZPlanApi) QRoute.api(IZPlanApi.class)).setOnSettingChangeListener((QQAppInterface) this.app, Constant.FROM_ID_UNINSTALL_PLUGIN, null);
        this.mZPlanSwitchChangeListener = null;
        if (this.mStudyModeChangeListener != null) {
            ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).unregisterStudyModeChangeListener(this.mStudyModeChangeListener);
            this.mStudyModeChangeListener = null;
        }
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.ba
    public void notifyPause(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
            return;
        }
        QLog.d(TAG, 1, "onPause: ");
        super.notifyPause(z16);
        if (!isFragmentAdded()) {
            return;
        }
        tryOnPause();
        ApngImage.pauseByTag(4);
        FrameHelperActivity.gj(true, TAG);
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.ba
    public void notifyResume(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
            return;
        }
        QLog.d(TAG, 1, "onResume: ");
        super.notifyResume(z16);
        if (!isFragmentAdded()) {
            return;
        }
        FragmentContainerView fragmentContainerView = this.mQzoneContainer;
        if (fragmentContainerView != null) {
            fragmentContainerView.setBackground(null);
        }
        ViewGroup viewGroup = this.mQzoneTitleContainer;
        if (viewGroup != null && viewGroup.findViewById(R.id.ivTitleBtnLeft) != null) {
            this.mQzoneTitleContainer.findViewById(R.id.ivTitleBtnLeft).setVisibility(8);
        }
        tryResume();
        ApngImage.playByTag(4);
        FrameHelperActivity.gj(true, TAG);
        if (FrameHelperActivity.Gi()) {
            FrameHelperActivity.Zh();
            FrameHelperActivity.gj(false, TAG);
        }
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.ba
    public void notifyStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        QLog.d(TAG, 1, "onStart: ");
        super.notifyStart();
        if (!isFragmentAdded()) {
            return;
        }
        this.isStop = false;
        this.mFragment.onStart();
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.ba
    public void notifyStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        QLog.d(TAG, 1, "onStop: ");
        super.notifyStop();
        if (!isFragmentAdded()) {
            return;
        }
        this.isStop = true;
        try {
            this.mFragment.onStop();
        } catch (Exception e16) {
            QLog.e(TAG, 1, "onStop: " + e16);
        }
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.be
    public void onAccountChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        QLog.d(TAG, 2, "onAccountChanged");
        super.onAccountChanged();
        com.tencent.mobileqq.leba.feed.c cVar = this.mNavigatorController;
        if (cVar != null) {
            cVar.onAccountChanged();
        }
        recreateFragment();
    }

    @Override // com.tencent.mobileqq.app.Frame
    public void onBeforeAccountChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        super.onBeforeAccountChanged();
        com.tencent.mobileqq.leba.feed.c cVar = this.mNavigatorController;
        if (cVar != null) {
            cVar.onBeforeAccountChanged();
        }
        QLog.d(TAG, 1, "[onBeforeAccountChanged] this: ", toString());
        notifyDestroy();
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.be
    public void onFrameTabClick() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        super.onFrameTabClick();
        ActivityResultCaller activityResultCaller = this.mFragment;
        if (activityResultCaller instanceof QzoneFragmentImpl) {
            ((QzoneFragmentImpl) activityResultCaller).forceRefresh();
        }
    }

    public void onPostThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        QZLog.i("QZoneConciseZPlan QzoneFrame", 1, "[onPostThemeChanged]");
        if (System.currentTimeMillis() - this.mCurrentChangeThemeTime < 1000) {
            return;
        }
        this.mCurrentChangeThemeTime = System.currentTimeMillis();
        com.tencent.mobileqq.leba.feed.c cVar = this.mNavigatorController;
        if (cVar != null) {
            cVar.onPostThemeChanged();
        }
        SimpleUIUtil.bgColor = 0;
        SimpleUIUtil.textColor = 0;
        QZoneNotifyServlet.l();
        recreateFragment();
    }

    public void onSwitchOutofQzone() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        try {
            QLog.d(TAG, 1, "onSwitchOutofQzone");
            ((IQZoneEnvApi) QRoute.api(IQZoneEnvApi.class)).onLeaveQZoneEnv(false, true);
            if (!QZoneConfigHelper.f()) {
                ImmersiveUtils.setStatusTextColor(SimpleUIUtil.useDarkResource(), getActivity().getWindow());
            }
            ActivityResultCaller activityResultCaller = this.mFragment;
            if (activityResultCaller != null) {
                ((QzoneFragmentImpl) activityResultCaller).onSwitchOutofQzone();
            }
            dispatchSwitchState(false);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "onSwitchOutofQzone" + th5);
        }
    }

    public void onSwitchToQzone(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, z16);
            return;
        }
        QLog.i(TAG, 1, "onSwitchToQzone:" + z16);
        QZoneLoginReportHelper.reportLoginFromSimpleMode();
        ((IQZoneEnvApi) QRoute.api(IQZoneEnvApi.class)).onEnterQZoneEnv(false, true);
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.activity.leba.QzoneFrame.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QzoneFrame.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    QZoneHelper.preloadQzone((QQAppInterface) QzoneFrame.this.app, QZoneHelper.QZONE_PRELOAD_FROM_LEBA_CLICK);
                }
            }
        });
        LpReportInfo_pf00064.allReport(637, 30, 1);
        LpReportInfo_pf00064.allReport(637, 31, 1);
        if (z16) {
            LebaTabRedTouch.d();
        } else {
            LpReportInfo_pf00064.allReport(637, 23, 2);
        }
        VideoReport.addToDetectionWhitelist(getActivity());
        com.tencent.mobileqq.service.report.b.d(getActivity(), false);
        com.tencent.mobileqq.leba.feed.c cVar = this.mNavigatorController;
        if (cVar != null) {
            cVar.d();
        }
        dispatchSwitchState(true);
        ActivityResultCaller activityResultCaller = this.mFragment;
        if (activityResultCaller instanceof QzoneFragmentImpl) {
            ((QzoneFragmentImpl) activityResultCaller).onSwitchToQzone();
        }
    }

    public void onZPlanQZoneSwitchChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        } else {
            QZLog.i("QZoneConciseZPlan QzoneFrame", 1, "[onZPlanQZoneSwitchChanged]");
            recreateFragment();
        }
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.be
    public void setActivity(QBaseActivity qBaseActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qBaseActivity);
            return;
        }
        super.setActivity((BaseActivity) qBaseActivity);
        if (getMainFragment(qBaseActivity) != null) {
            this.mFragmentManager = getMainFragment(qBaseActivity).getChildFragmentManager();
        }
    }
}
