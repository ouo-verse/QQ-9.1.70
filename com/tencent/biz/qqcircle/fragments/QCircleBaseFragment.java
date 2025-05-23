package com.tencent.biz.qqcircle.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.biz.qcircleshadow.lib.variation.HostAppSettingUtil;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.events.QFSLifecycleCollectionEvent;
import com.tencent.biz.qqcircle.immersive.floatingwindow.model.QFSSmallWindowGlobalCollect;
import com.tencent.biz.qqcircle.immersive.utils.at;
import com.tencent.biz.qqcircle.j;
import com.tencent.biz.qqcircle.widgets.QCircleInteractiveLayout;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoaderFactory;
import com.tencent.biz.richframework.part.ImmersivePartFragment;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.biz.richframework.part.TagData;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildAVChannelApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleAlphaUserReportDataBuilder;
import com.tencent.mobileqq.qcircle.api.event.HostActivityResultEvent;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.superplayer.api.ISPBandwidthPredictor;
import com.tencent.superplayer.api.SuperPlayerFactory;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import cooperation.qqcircle.report.QCircleQualityReporter;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class QCircleBaseFragment extends ImmersivePartFragment implements com.tencent.biz.qqcircle.richframework.part.a<QCircleReportBean>, SimpleEventReceiver {
    public static final ISPBandwidthPredictor BAND_WIDTH_PREDICTOR = SuperPlayerFactory.createBandwidthPredictor(HostUIHelper.getInstance().getHostApplicationContext());
    protected static final String TAG = "QCircleBaseFragment";
    protected View mContentView;
    private QCircleInteractiveLayout mInteractiveLayout;
    private Runnable mLaunchStatistics = new Runnable() { // from class: com.tencent.biz.qqcircle.fragments.QCircleBaseFragment.1
        @Override // java.lang.Runnable
        public void run() {
            QCircleBaseFragment.this.getMainHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.fragments.QCircleBaseFragment.1.1
                @Override // java.lang.Runnable
                public void run() {
                    if (QCircleBaseFragment.this.getActivity() == null) {
                        return;
                    }
                    long currentTimeMillis = System.currentTimeMillis() - QCircleBaseFragment.this.getActivity().getIntent().getLongExtra("key_bundle_open_page_time", -1L);
                    QLog.i("KEY_BUNDLE_OPEN_PAGE_TIME", 1, String.format("FragmentName:%s,pageId:%d, firstRender cost:%d", QCircleBaseFragment.this.getClass().getSimpleName(), Integer.valueOf(QCircleBaseFragment.this.getPageId()), Long.valueOf(currentTimeMillis)));
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(QCircleReportHelper.newEntry("refer", String.valueOf(QCircleBaseFragment.this.getPageId())));
                    arrayList.add(QCircleReportHelper.newEntry("attach_info", String.valueOf(currentTimeMillis)));
                    QCircleQualityReporter.reportQualityEvent("key_page_first_render_time_event", arrayList);
                }
            });
        }
    };
    protected QCircleReportBean mReportBean;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class EnterPandoraEventSceneReportRunnable implements Runnable {
        EnterPandoraEventSceneReportRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (QCirclePluginUtil.isInQCircleNew()) {
                QCircleCommonUtil.initPermissionManagementReport();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends PartManager {
        a(IPartHost iPartHost, View view) {
            super(iPartHost, view);
        }

        @Override // com.tencent.biz.richframework.part.PartManager
        public void onPartCreate(@NonNull Activity activity, Bundle bundle) {
            try {
                super.onPartCreate(activity, bundle);
            } catch (NullPointerException e16) {
                QCircleAlphaUserReporter.reportLog(QCircleAlphaUserReporter.KEY_PART_INIT_VIEW_NP_EXCEPTION_EVENT, new QCircleAlphaUserReportDataBuilder().setAttachInfo(Log.getStackTraceString(e16).substring(0, 1024)));
                if (QCircleApplication.isRDMVersion() || HostAppSettingUtil.isGrayVersion()) {
                    QLog.e(QCircleBaseFragment.this.getLogTag(), 1, "all children views:", at.d(QCircleBaseFragment.this.mContentView));
                }
                QLog.e(QCircleBaseFragment.this.getLogTag(), 1, "onActivityCreated error:", Log.getStackTraceString(e16));
                throw e16;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    private static class b extends ViewModelProvider.NewInstanceFactory {

        /* renamed from: c, reason: collision with root package name */
        private static volatile b f84436c;

        b() {
        }

        @NonNull
        public static b a() {
            if (f84436c == null) {
                synchronized (b.class) {
                    if (f84436c == null) {
                        f84436c = new b();
                    }
                }
            }
            return f84436c;
        }
    }

    private View addInteractiveView() {
        if (this.mInteractiveLayout == null) {
            this.mInteractiveLayout = new QCircleInteractiveLayout(getContext());
        }
        this.mInteractiveLayout.addView(this.mContentView);
        return this.mInteractiveLayout;
    }

    private void enterPandoraEventSceneReport() {
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_resume_report_pandora_scene_sub_thread", true)) {
            RFWThreadManager.getInstance().execOnSubThread(new EnterPandoraEventSceneReportRunnable());
        } else if (QCirclePluginUtil.isInQCircleNew()) {
            QCircleCommonUtil.initPermissionManagementReport();
        }
    }

    private void popPageScene() {
        if (getPageId() <= 0) {
            QLog.d(getLogTag(), 1, getLogTag() + "popPageScene with invalid pageId");
            return;
        }
        QCircleReportHelper.getInstance().popPageScene(getPageId());
    }

    private void quitGuildFloatWindow() {
        boolean M6 = uq3.c.M6();
        boolean g16 = kc0.a.g();
        QLog.d(getLogTag(), 1, getLogTag() + "->quitGuildFloatWindow isBottomTabMode = " + M6 + ", isSelected QCircle tab = " + g16);
        if (M6 && !g16) {
            QLog.d(getLogTag(), 2, getLogTag() + "->quitGuildFloatWindow -> is not select qcircle in tab mode");
            return;
        }
        try {
            ((IGuildAVChannelApi) QRoute.api(IGuildAVChannelApi.class)).quitAVFloatWindowWithExitRoom();
        } catch (Exception e16) {
            QLog.e(getLogTag(), 1, getLogTag() + "->quitGuildFloatWindow Exception:" + e16);
        }
    }

    private void setDtCustomPageId(Map<String, Object> map, Object obj) {
        if (map != null && (obj instanceof QCircleReportBean)) {
            Object obj2 = map.get("xsj_custom_pgid");
            if (!(obj2 instanceof String)) {
                return;
            }
            ((QCircleReportBean) obj).setDtCustomPageId((String) obj2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void assembleFromReportData() {
        Intent intent;
        QCircleInitBean qCircleInitBean;
        QCircleReportBean qCircleReportBean;
        if (getActivity() != null && (intent = getActivity().getIntent()) != null && intent.hasExtra("key_bundle_common_init_bean") && (qCircleInitBean = (QCircleInitBean) intent.getSerializableExtra("key_bundle_common_init_bean")) != null && qCircleInitBean.getFromReportBean() != null && (qCircleReportBean = this.mReportBean) != null) {
            qCircleReportBean.assembleFromReportData(qCircleInitBean.getFromReportBean());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public Object createViewTagData() {
        QCircleInitBean qCircleInitBean;
        QCircleReportBean qCircleReportBean = new QCircleReportBean(getPageId());
        qCircleReportBean.setDtPageId(getDaTongPageId());
        if (getActivity() != null && getActivity().getIntent() != null && getActivity().getIntent().hasExtra("key_bundle_common_init_bean") && (qCircleInitBean = (QCircleInitBean) getActivity().getIntent().getSerializableExtra("key_bundle_common_init_bean")) != null && qCircleInitBean.getFromReportBean() != null) {
            qCircleReportBean.setFromPageId(qCircleInitBean.getFromReportBean().getPageId());
            qCircleReportBean.setDtFromPageId(qCircleInitBean.getFromReportBean().getDtPageId());
        }
        return qCircleReportBean;
    }

    public void dtPageLogicDestroy() {
        View view = this.mContentView;
        if (view == null) {
            QLog.i(TAG, 1, "dtPageLogicDestroy  mContentView == null , subPage: " + getLogTag());
            return;
        }
        VideoReport.pageLogicDestroy(view);
    }

    public boolean enableAudioFocus() {
        return true;
    }

    public boolean enableReleaseAudioFocus() {
        QCircleInitBean qCircleInitBean = getQCircleInitBean();
        if (enableAudioFocus() && (qCircleInitBean == null || qCircleInitBean.enableReleaseAudioFocus())) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Map<String, Object> getChildDaTongPageParams() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getDaTongPageId() {
        return "";
    }

    @Override // androidx.fragment.app.Fragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    @NonNull
    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        if (useDefaultViewModelProviderFactory()) {
            return super.getDefaultViewModelProviderFactory();
        }
        return b.a();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @CallSuper
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(HostActivityResultEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public abstract String getLogTag();

    public abstract int getPageId();

    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public PartManager getPartManager() {
        if (this.mPartManager == null) {
            this.mPartManager = new a(this, getView());
        }
        return this.mPartManager;
    }

    @Nullable
    public QCircleInitBean getQCircleInitBean() {
        Intent intent;
        FragmentActivity activity = getActivity();
        if (activity == null) {
            intent = null;
        } else {
            intent = activity.getIntent();
        }
        if (intent == null || !intent.hasExtra("key_bundle_common_init_bean")) {
            return null;
        }
        Serializable serializableExtra = intent.getSerializableExtra("key_bundle_common_init_bean");
        if (!(serializableExtra instanceof QCircleInitBean)) {
            return null;
        }
        return (QCircleInitBean) serializableExtra;
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    protected int getStatusBarColor() {
        return QCircleSkinHelper.getInstance().getColor(R.color.qvideo_skin_color_bg_default);
    }

    public boolean isHaveInteractive() {
        QCircleInteractiveLayout qCircleInteractiveLayout = this.mInteractiveLayout;
        if (qCircleInteractiveLayout != null) {
            return qCircleInteractiveLayout.b();
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    protected boolean isUseDarkTextStatusBar() {
        return !QCircleCommonUtil.isInNightMode();
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    protected boolean needAdjustImmersive() {
        if (getActivity() == null || getParentFragmentManager() != getActivity().getSupportFragmentManager()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (getActivity() != null && getActivity().getIntent() != null && getActivity().getIntent().getLongExtra("key_bundle_open_page_time", -1L) != -1 && getActivity().getWindow() != null && getActivity().getWindow().getDecorView() != null) {
            getActivity().getWindow().getDecorView().post(this.mLaunchStatistics);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        QLog.d(getLogTag(), 1, getLogTag() + "->onAttach");
        pushPageScene();
        super.onAttach(activity);
    }

    public void onBackPressed() {
        QLog.d(getLogTag(), 1, getLogTag() + "->onBackPressed");
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        SimpleEventBus.getInstance().registerReceiver(this);
        com.tencent.biz.qqcircle.immersive.manager.c.d().c(hashCode(), getDaTongPageId(), getPageId(), QFSLifecycleCollectionEvent.QFSPageLifecycleEnum.ON_CREATE);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view;
        View preloadView = RFWLayoutPreLoaderFactory.getLayoutLoader(l30.a.a().c()).getPreloadView(getContext(), getContentLayoutId(), false);
        this.mContentView = preloadView;
        if (preloadView == null) {
            this.mContentView = layoutInflater.inflate(getContentLayoutId(), viewGroup, false);
        } else {
            QLog.d(getLogTag(), 1, "[onCreateView] get preInflate view success, hashCode:" + hashCode());
        }
        if (uq3.c.u6() && this.mContentView != null) {
            view = addInteractiveView();
        } else {
            view = this.mContentView;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Window window;
        QLog.d(getLogTag(), 1, getLogTag() + "->onDestroy");
        super.onDestroy();
        FragmentActivity activity = getActivity();
        if (activity == null) {
            window = null;
        } else {
            window = activity.getWindow();
        }
        if (window != null && getActivity().getWindow().getDecorView() != null) {
            getActivity().getWindow().getDecorView().removeCallbacks(this.mLaunchStatistics);
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        j.f().h();
        com.tencent.biz.qqcircle.immersive.manager.c.d().c(hashCode(), getDaTongPageId(), getPageId(), QFSLifecycleCollectionEvent.QFSPageLifecycleEnum.ON_DESTROY);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        QLog.d(getLogTag(), 1, getLogTag() + "->onDestroyView");
        super.onDestroyView();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        QLog.d(getLogTag(), 1, getLogTag() + "->onDetach");
        popPageScene();
        super.onDetach();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        QLog.d(getLogTag(), 1, getLogTag() + "->onPause");
        QCircleCommonUtil.cancelPermissionManagementReport();
        super.onPause();
        if (getActivity() != null) {
            BAND_WIDTH_PREDICTOR.stop(getActivity());
        }
        com.tencent.biz.qqcircle.immersive.manager.c.d().c(hashCode(), getDaTongPageId(), getPageId(), QFSLifecycleCollectionEvent.QFSPageLifecycleEnum.ON_PAUSE);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @CallSuper
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof HostActivityResultEvent) {
            HostActivityResultEvent hostActivityResultEvent = (HostActivityResultEvent) simpleBaseEvent;
            QLog.i(TAG, 1, hashCode() + ": onActivityResult receive event, currentHashCode:" + hashCode() + ",hostHashCode:" + getActivity().getBaseContext().hashCode() + ", shadowHashCode:" + hostActivityResultEvent.getShadowTopContextHashCode());
            onActivityResult(hostActivityResultEvent.getRequestCode(), hostActivityResultEvent.getResultCode(), hostActivityResultEvent.getIntent());
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        QLog.d(getLogTag(), 1, getLogTag() + "->onResume");
        enterPandoraEventSceneReport();
        super.onResume();
        if (getActivity() != null) {
            QCirclePluginGlobalInfo.d0(Integer.valueOf(getActivity().hashCode()));
            BAND_WIDTH_PREDICTOR.start(getActivity());
        }
        QFSSmallWindowGlobalCollect.k().p(this, getDaTongPageId());
        com.tencent.biz.qqcircle.immersive.manager.c.d().c(hashCode(), getDaTongPageId(), getPageId(), QFSLifecycleCollectionEvent.QFSPageLifecycleEnum.ON_RESUME);
        registerDaTongReportPageId();
        quitGuildFloatWindow();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        QLog.d(getLogTag(), 1, getLogTag() + "->onSaveInstanceState");
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        QLog.d(getLogTag(), 1, getLogTag() + "->onStart");
        super.onStart();
        com.tencent.biz.qqcircle.immersive.manager.c.d().c(hashCode(), getDaTongPageId(), getPageId(), QFSLifecycleCollectionEvent.QFSPageLifecycleEnum.ON_START);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        QLog.d(getLogTag(), 1, getLogTag() + "->onStop");
        super.onStop();
        com.tencent.biz.qqcircle.immersive.manager.c.d().c(hashCode(), getDaTongPageId(), getPageId(), QFSLifecycleCollectionEvent.QFSPageLifecycleEnum.ON_STOP);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(View view, Bundle bundle) {
        QLog.d(getLogTag(), 1, getLogTag() + "->doOnCreateView");
        super.onViewCreatedBeforePartInit(view, bundle);
    }

    protected void pushPageScene() {
        Intent intent;
        Serializable serializableExtra;
        if (getPageId() <= 0) {
            QLog.d(getLogTag(), 1, getLogTag() + "pushPageScene with invalid pageId");
            return;
        }
        if (QCircleReportHelper.getInstance().isPageStackEmpty()) {
            FragmentActivity activity = getActivity();
            QCircleInitBean qCircleInitBean = null;
            if (activity == null) {
                intent = null;
            } else {
                intent = activity.getIntent();
            }
            if (intent == null) {
                serializableExtra = null;
            } else {
                serializableExtra = intent.getSerializableExtra("key_bundle_common_init_bean");
            }
            if (serializableExtra instanceof QCircleInitBean) {
                qCircleInitBean = (QCircleInitBean) serializableExtra;
            }
            if (qCircleInitBean != null) {
                QCircleReportHelper.getInstance().setLaunchParms(QCircleReportHelper.LaunchParam.wrap(qCircleInitBean.getLaunchFrom(), qCircleInitBean.getLaunchId(), qCircleInitBean.getUin(), getPageId(), qCircleInitBean.getSchemeAttrs()));
            }
        }
        QCircleReportHelper.getInstance().pushPageScene(getPageId());
    }

    public void registerDaTongReportPageId() {
        String str;
        if (this.mContentView == null) {
            QLog.i(TAG, 1, "reportDaTongRegister  mContentView == null , subPage: " + getLogTag());
            return;
        }
        VideoReport.addToDetectionWhitelist(getActivity());
        if (!TextUtils.isEmpty(getDaTongPageId())) {
            str = getDaTongPageId();
        } else {
            str = QCircleDaTongConstant.PageId.BASE;
        }
        VideoReport.setPageId(this.mContentView, str);
        Map<String, Object> childDaTongPageParams = getChildDaTongPageParams();
        VideoReport.setPageParams(this.mContentView, new QCircleDTParamBuilder().buildPageParams(getLogTag(), childDaTongPageParams));
        VideoReport.setElementDynamicParams(this.mContentView, new QCircleDTParamBuilder().buildElementDynamicParams());
        VideoReport.setEventDynamicParams(this.mContentView, new QCircleDTParamBuilder().buildDynamicParams());
        WinkDatongCurrentParams.params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_CLCK_REF_PGID, str);
        Object createViewTagData = createViewTagData();
        setDtCustomPageId(childDaTongPageParams, createViewTagData);
        this.mContentView.setTag(TagData.TAG_DATA_ID, createViewTagData);
        QLog.i(TAG, 1, "00000QG6YX3X0LZH reportDaTongRegister  subPage: " + getLogTag() + ", pageId: " + str);
    }

    public void setExcludeInteractiveView(View view) {
        QCircleInteractiveLayout qCircleInteractiveLayout = this.mInteractiveLayout;
        if (qCircleInteractiveLayout != null) {
            qCircleInteractiveLayout.setExcludeInteractiveView(view);
        } else {
            QLog.e(TAG, 1, "setExcludeInteractiveView  mInteractiveLayout == null");
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z16) {
        QLog.d(getLogTag(), 1, getLogTag() + "->setUserVisibleHint:" + z16);
        super.setUserVisibleHint(z16);
    }

    protected boolean useDefaultViewModelProviderFactory() {
        return true;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.biz.qqcircle.richframework.part.a
    public QCircleReportBean getReportBean() {
        if (this.mReportBean == null) {
            this.mReportBean = new QCircleReportBean();
        }
        assembleFromReportData();
        this.mReportBean.setDtPageId(getDaTongPageId());
        return this.mReportBean.setPageId(getPageId());
    }

    public void setReportBean(QCircleReportBean qCircleReportBean) {
        this.mReportBean = QCircleReportBean.setReportBean(getLogTag(), qCircleReportBean);
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    protected void setStatusBarTextColor() {
    }
}
