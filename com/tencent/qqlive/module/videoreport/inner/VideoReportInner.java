package com.tencent.qqlive.module.videoreport.inner;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qqlive.module.videoreport.Configuration;
import com.tencent.qqlive.module.videoreport.DetectionMode;
import com.tencent.qqlive.module.videoreport.IAdditionalReportListener;
import com.tencent.qqlive.module.videoreport.IEventDynamicParams;
import com.tencent.qqlive.module.videoreport.IPageParamsFormatter;
import com.tencent.qqlive.module.videoreport.IPublicParamInterface;
import com.tencent.qqlive.module.videoreport.ISessionChangeListener;
import com.tencent.qqlive.module.videoreport.IVideoReportComponent;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.SessionChangeReason;
import com.tencent.qqlive.module.videoreport.appstatus.AppStatusManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.common.EventAgingType;
import com.tencent.qqlive.module.videoreport.common.EventData;
import com.tencent.qqlive.module.videoreport.common.IReporter;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.InnerKey;
import com.tencent.qqlive.module.videoreport.constants.ModuleInitPolicy;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.qqlive.module.videoreport.constants.ParamKey;
import com.tencent.qqlive.module.videoreport.constants.ReportPolicy;
import com.tencent.qqlive.module.videoreport.data.DataBinder;
import com.tencent.qqlive.module.videoreport.data.DataEntity;
import com.tencent.qqlive.module.videoreport.data.DataRWProxy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.qqlive.module.videoreport.data.IElementDynamicParams;
import com.tencent.qqlive.module.videoreport.detection.DetectionInterceptors;
import com.tencent.qqlive.module.videoreport.detection.DetectionPolicy;
import com.tencent.qqlive.module.videoreport.dtreport.api.DTConfig;
import com.tencent.qqlive.module.videoreport.dtreport.audio.AudioEventReporter;
import com.tencent.qqlive.module.videoreport.dtreport.audio.api.IAudioTimerListener;
import com.tencent.qqlive.module.videoreport.dtreport.audio.data.AudioDataManager;
import com.tencent.qqlive.module.videoreport.dtreport.audio.data.AudioEntity;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConfigConstants;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqlive.module.videoreport.dtreport.stdevent.IEventParamsBuilder;
import com.tencent.qqlive.module.videoreport.dtreport.stdevent.StdEventCode;
import com.tencent.qqlive.module.videoreport.dtreport.stdevent.StdEventParamChecker;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoBaseEntity;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoEntity;
import com.tencent.qqlive.module.videoreport.dtreport.video.logic.VideoPageReporter;
import com.tencent.qqlive.module.videoreport.dtreport.video.logic.VideoReportManager;
import com.tencent.qqlive.module.videoreport.lazy.LazyInitObserver;
import com.tencent.qqlive.module.videoreport.page.IPageEventListener;
import com.tencent.qqlive.module.videoreport.page.IScrollReader;
import com.tencent.qqlive.module.videoreport.page.PageBodyStatistician;
import com.tencent.qqlive.module.videoreport.page.PageContext;
import com.tencent.qqlive.module.videoreport.page.PageContextManager;
import com.tencent.qqlive.module.videoreport.page.PageEventListenerMgr;
import com.tencent.qqlive.module.videoreport.page.PageFinder;
import com.tencent.qqlive.module.videoreport.page.PageInfo;
import com.tencent.qqlive.module.videoreport.page.PageInfoCacheController;
import com.tencent.qqlive.module.videoreport.page.PageManager;
import com.tencent.qqlive.module.videoreport.page.PageSwitchObserver;
import com.tencent.qqlive.module.videoreport.page.PageUtils;
import com.tencent.qqlive.module.videoreport.page.VideoReportPageInfo;
import com.tencent.qqlive.module.videoreport.page.ViewContainerBinder;
import com.tencent.qqlive.module.videoreport.remoteconfig.RemoteConfig;
import com.tencent.qqlive.module.videoreport.report.AppEventReporter;
import com.tencent.qqlive.module.videoreport.report.FinalDataTarget;
import com.tencent.qqlive.module.videoreport.report.PageReporter;
import com.tencent.qqlive.module.videoreport.report.PublicParamImpl;
import com.tencent.qqlive.module.videoreport.report.element.ElementClickReporter;
import com.tencent.qqlive.module.videoreport.report.element.ElementExposureEndReporter;
import com.tencent.qqlive.module.videoreport.report.element.ElementExposureReporter;
import com.tencent.qqlive.module.videoreport.report.element.ElementLongClickReporter;
import com.tencent.qqlive.module.videoreport.report.element.ExposureElementInfo;
import com.tencent.qqlive.module.videoreport.report.element.ExposurePolicyHelper;
import com.tencent.qqlive.module.videoreport.report.element.IExposureRecorder;
import com.tencent.qqlive.module.videoreport.report.element.ReportPolicyOperator;
import com.tencent.qqlive.module.videoreport.report.element.ReversedDataCollector;
import com.tencent.qqlive.module.videoreport.report.keyboard.KeyBoardEditorActionReporter;
import com.tencent.qqlive.module.videoreport.report.scroll.ScrollableViewManager;
import com.tencent.qqlive.module.videoreport.report.userprivacy.UserPrivacyEventReporter;
import com.tencent.qqlive.module.videoreport.reportdata.DataBuilderFactory;
import com.tencent.qqlive.module.videoreport.reportdata.FinalData;
import com.tencent.qqlive.module.videoreport.reportdata.PathData;
import com.tencent.qqlive.module.videoreport.sample.SampleInfoManager;
import com.tencent.qqlive.module.videoreport.sample.SampleMutex;
import com.tencent.qqlive.module.videoreport.sample.Sampler;
import com.tencent.qqlive.module.videoreport.sample.SamplerImpl;
import com.tencent.qqlive.module.videoreport.staging.CustomEventStagingManager;
import com.tencent.qqlive.module.videoreport.staging.EventStashManager;
import com.tencent.qqlive.module.videoreport.task.ThreadUtils;
import com.tencent.qqlive.module.videoreport.trace.SimpleTracer;
import com.tencent.qqlive.module.videoreport.traversal.ViewGroupDrawingCompat;
import com.tencent.qqlive.module.videoreport.utils.IDetectionInterceptor;
import com.tencent.qqlive.module.videoreport.utils.ListenerMgr;
import com.tencent.qqlive.module.videoreport.utils.ProcessUtils;
import com.tencent.qqlive.module.videoreport.utils.ReportUtils;
import com.tencent.qqlive.module.videoreport.utils.SPUtils;
import com.tencent.qqlive.module.videoreport.utils.UssnUtils;
import com.tencent.qqlive.module.videoreport.utils.reuse.ReusablePool;
import com.tencent.qqlive.module.videoreport.visual.debug.VisualDebugManager;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: P */
/* loaded from: classes22.dex */
public class VideoReportInner implements IVideoReport {
    private static final String TAG = "api.VideoReportInner";
    private volatile boolean isInit;
    private Configuration mConfiguration;
    private boolean mDebugMode;
    private boolean mEnableSampleTest;
    private IEventDynamicParams mEventDynamicParams;
    private PageInfoCacheController mPageInfoCacheCtrl;
    private IPageParamsFormatter mPageParamsFormatter;
    private Map<String, Object> mPublicParam;
    private Set<IReporter> mReporters;
    private boolean mTestMode;
    private Collection<IReporter> mUnmodifiableReporters;
    private RemoteConfig remoteConfig;
    private final Sampler sampler;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class InstanceHolder {
        static final VideoReportInner INSTANCE = new VideoReportInner();

        InstanceHolder() {
        }
    }

    private boolean checkTrackObjectArgument(Object obj) {
        if (!checkElementObjectArgument(obj) && !(obj instanceof Activity)) {
            return false;
        }
        return true;
    }

    private void clearElementExposureInner(View view, boolean z16) {
        if (view == null) {
            return;
        }
        IExposureRecorder.Factory.getInstance().markUnexposed(ReportUtils.calcElementUniqueId(view));
        if (z16 && (view instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                clearElementExposureInner(viewGroup.getChildAt(childCount), true);
            }
        }
    }

    private boolean elementReport(String str, View view, EventAgingType eventAgingType, Map<String, ?> map) {
        FinalData build;
        PathData collect = ReversedDataCollector.collect(view);
        if (collect == null || (build = DataBuilderFactory.obtain().build(str, collect)) == null) {
            return false;
        }
        build.setEventKey(str);
        build.setEventType(eventAgingType);
        if (map != null) {
            build.putAll(map);
        }
        if ("imp".equals(str)) {
            IExposureRecorder.Factory.getInstance().markExposed(new ExposureElementInfo(view, collect.getPage(), build, collect));
        }
        FinalDataTarget.handle(view, build);
        return true;
    }

    public static VideoReportInner getInstance() {
        return InstanceHolder.INSTANCE;
    }

    private Map<String, Object> getTotalPageParams(PageParams pageParams) {
        if (pageParams == null) {
            return null;
        }
        HashMap hashMap = new HashMap(1);
        if (pageParams.getBasicParams() != null) {
            hashMap.putAll(pageParams.getBasicParams());
        }
        if (pageParams.getRefElementParams() != null) {
            hashMap.put(ParamKey.REPORT_KEY_REF_ELMT, pageParams.getRefElementParams());
        }
        if (pageParams.getRootRefElementParams() != null) {
            hashMap.put(ParamKey.REPORT_KEY_ROOT_REF_ELMT, pageParams.getRootRefElementParams());
        }
        return hashMap;
    }

    private void initRemoteConfig(final RemoteConfig remoteConfig) {
        String sampleSceneId = getSampleSceneId();
        try {
            remoteConfig.init(sampleSceneId);
            remoteConfig.setOnConfigLoadedListener(new RemoteConfig.OnConfigLoadedListener() { // from class: com.tencent.qqlive.module.videoreport.inner.VideoReportInner.1
                @Override // com.tencent.qqlive.module.videoreport.remoteconfig.RemoteConfig.OnConfigLoadedListener
                public void onConfigLoaded() {
                    VideoReportInner.this.loadSampleConfig(remoteConfig);
                }
            });
            remoteConfig.loadByScene(sampleSceneId);
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    private void initiateAllModules() {
        ViewGroupDrawingCompat.preload();
        AppEventReporter.getInstance();
        ElementClickReporter.getInstance();
        ElementLongClickReporter.getInstance();
        ViewContainerBinder.getInstance();
        PageSwitchObserver.getInstance();
        PageManager.getInstance();
        PageReporter.getInstance();
        ElementExposureReporter.getInstance();
        ScrollableViewManager.getInstance();
        ElementExposureEndReporter.getInstance();
        AudioEventReporter.getInstance();
        VideoPageReporter.getInstance();
        KeyBoardEditorActionReporter.getInstance();
        EventStashManager.getInstance();
        AppStatusManager.getInstance();
        VisualDebugManager.getInstance();
    }

    private void initiateAudioModules() {
        AppEventReporter.getInstance();
        AudioEventReporter.getInstance();
        EventStashManager.getInstance();
        AppStatusManager.getInstance();
    }

    private void initiateModules(ModuleInitPolicy moduleInitPolicy) {
        if (moduleInitPolicy == ModuleInitPolicy.INIT_ALL) {
            initiateAllModules();
        } else if (moduleInitPolicy == ModuleInitPolicy.INIT_AUDIO) {
            initiateAudioModules();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setPageId$2(Object obj, boolean z16, String str) {
        if (checkPageObjectArgument(obj)) {
            PageReporter.getInstance().setPageBizReady(obj, z16);
            DataRWProxy.setPageId(obj, str);
            PageSwitchObserver.getInstance().onPageReport(obj);
            if (!TextUtils.isEmpty(str)) {
                this.mPageInfoCacheCtrl.appendPageStore(obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setPageParams$0(Object obj, PageParams pageParams) {
        Map<String, Object> totalPageParams;
        if (checkPageObjectArgument(obj)) {
            if (pageParams == null) {
                totalPageParams = null;
            } else {
                totalPageParams = getTotalPageParams(pageParams);
            }
            DataRWProxy.setPageParams(obj, totalPageParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setPageParams$1(Object obj, String str, Object obj2) {
        if (checkPageObjectArgument(obj)) {
            DataRWProxy.setPageParams(obj, str, obj2);
        }
    }

    private void loadRemoteConfig(Application application) {
        Configuration configuration = this.mConfiguration;
        if (configuration == null || application == null || !configuration.remoteConfigEnabled()) {
            return;
        }
        RemoteConfig remoteConfig = this.remoteConfig;
        if (remoteConfig != null) {
            initRemoteConfig(remoteConfig);
            return;
        }
        RemoteConfig remoteConfig2 = this.mConfiguration.remoteConfig();
        this.remoteConfig = remoteConfig2;
        if (remoteConfig2 == null) {
            Log.w(DTConstants.TAG.REMOTE_CONFIG, "need to bind remote config, use -> VideoReport.bindRemoteConfig()");
        } else {
            initRemoteConfig(remoteConfig2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadSampleConfig(RemoteConfig remoteConfig) {
        if (this.mConfiguration.remoteSampleEnabled()) {
            this.sampler.loadConfig(remoteConfig);
        }
    }

    private boolean reportCustomElementEvent(EventData eventData) {
        Object source = eventData.getSource();
        if (!TextUtils.isEmpty(DataRWProxy.getElementId(source))) {
            if (source instanceof Dialog) {
                Dialog dialog = (Dialog) source;
                if (dialog.getWindow() != null) {
                    return elementReport(eventData.getId(), dialog.getWindow().getDecorView(), eventData.getType(), eventData.getParams());
                }
                return false;
            }
            if (source instanceof View) {
                return elementReport(eventData.getId(), (View) source, eventData.getType(), eventData.getParams());
            }
            return false;
        }
        return false;
    }

    private boolean reportCustomPageEvent(EventData eventData) {
        Object source = eventData.getSource();
        if (PageFinder.isPage(source)) {
            FinalData createTrackData = PageUtils.createTrackData(eventData.getId(), source);
            createTrackData.setEventType(eventData.getType());
            createTrackData.putAll(eventData.getParams());
            FinalDataTarget.handle(source, createTrackData);
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    @Deprecated
    public void addReporter(com.tencent.qqlive.module.videoreport.IReporter iReporter) {
        if (iReporter != null) {
            addReporter(new OldReporterAdapter(iReporter));
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void addReporters(List<IReporter> list) {
        if (isDebugMode()) {
            Log.d(TAG, "addReporters(), reporters=" + list);
        }
        if (list != null) {
            this.mReporters.addAll(list);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void addToDetectionBlacklist(Activity activity) {
        DetectionPolicy.addBlacklist(activity);
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void addToDetectionWhitelist(Activity activity) {
        DetectionPolicy.addWhitelist(activity);
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void bindAudioPlayerInfo(Object obj, AudioEntity audioEntity) {
        AudioDataManager.getInstance().bindAudioInfo(obj, audioEntity);
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void bindRemoteConfig(RemoteConfig remoteConfig) {
        Configuration configuration = this.mConfiguration;
        if (configuration != null && configuration.remoteConfigEnabled()) {
            if (this.remoteConfig == null) {
                if (isInit()) {
                    initRemoteConfig(remoteConfig);
                    return;
                } else {
                    this.remoteConfig = remoteConfig;
                    return;
                }
            }
            Log.w(DTConstants.TAG.REMOTE_CONFIG, "you have bound remote config");
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void bindSampleConfig(String str) {
        Configuration configuration = this.mConfiguration;
        if (configuration != null && configuration.remoteSampleEnabled()) {
            this.sampler.loadConfig(str);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void bindSubmitTarget(View view, View view2) {
        if (isDebugMode()) {
            Log.d(TAG, "bindSubmitTarget(), object=" + view + ", target=" + view2);
        }
        if (checkElementObjectArgument(view) && checkElementObjectArgument(view2)) {
            DataRWProxy.putExtendParam(view, DTConstants.DTExtendMapKey.SUBMIT_TARGET, new WeakReference(view2));
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void bindVideoPlayerInfo(@NonNull Object obj, VideoEntity videoEntity) {
        VideoReportManager.getInstance().bindVideoInfo(obj, videoEntity);
    }

    public boolean checkElementObjectArgument(Object obj) {
        if (!(obj instanceof Dialog) && !(obj instanceof View)) {
            return false;
        }
        return true;
    }

    public boolean checkPageObjectArgument(Object obj) {
        if (!checkElementObjectArgument(obj) && !(obj instanceof Activity)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void clearElementExposure(View view, boolean z16) {
        if (isDebugMode()) {
            Log.d(TAG, "clearElementExposure(), view=" + view + ", clearChildren=" + z16);
        }
        clearElementExposureInner(view, z16);
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void clearPublicParams() {
        if (isDebugMode()) {
            Log.d(TAG, "clearPublicParams(), clear");
        }
        Map<String, Object> map = this.mPublicParam;
        if (map != null) {
            map.clear();
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void doAppOutReport() {
        AppEventReporter.getInstance().appOutDataSender();
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void enableAndroidXRVExposure(RecyclerView recyclerView) {
        if (isDebugMode()) {
            Log.d(TAG, "enableAndroidXRVExposure(), view=" + recyclerView);
        }
        DataRWProxy.putExtendParam(recyclerView, DTConstants.DTExtendMapKey.ENABLE_ANDROID_RV_EXPOSURE, Boolean.TRUE);
    }

    public void enableCollectAllPage(View view) {
        if (view == null) {
            Log.w(TAG, "enable all page report cannot be null");
        } else {
            DataRWProxy.setInnerParam(view, InnerKey.PAGE_COLLECT_ALL_ENABLE, Boolean.TRUE);
        }
    }

    public void enableSampleTest(boolean z16) {
        this.mEnableSampleTest = z16;
        Log.d(TAG, "enableSampleTest(" + z16 + ")...");
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void enableScrollExposureReport(Object obj, boolean z16) {
        if ((obj instanceof AbsListView) || (obj instanceof android.support.v7.widget.RecyclerView) || (obj instanceof RecyclerView)) {
            DataRWProxy.putExtendParam(obj, DTConstants.DTExtendMapKey.ELEMENT_SCROLL_EXPOSURE, Boolean.valueOf(z16));
            ScrollableViewManager.getInstance().inject((View) obj);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public PageInfo findOwnerPage(View view) {
        if (view == null) {
            return null;
        }
        return PageFinder.findOwnerPage(view);
    }

    public Configuration getConfiguration() {
        Configuration configuration = this.mConfiguration;
        if (configuration == null) {
            return Configuration.getDefault();
        }
        return configuration;
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public ClickPolicy getElementClickPolicy(Object obj) {
        return (ClickPolicy) ReportPolicyOperator.getReportPolicy(obj, InnerKey.ELEMENT_CLICK_POLICY, ClickPolicy.class);
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public EndExposurePolicy getElementEndExposePolicy(Object obj) {
        return (EndExposurePolicy) ReportPolicyOperator.getReportPolicy(obj, InnerKey.ELEMENT_END_EXPOSE_POLICY, EndExposurePolicy.class);
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public ExposurePolicy getElementExposePolicy(Object obj) {
        return (ExposurePolicy) ReportPolicyOperator.getReportPolicy(obj, InnerKey.ELEMENT_EXPOSE_POLICY, ExposurePolicy.class);
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public Map<String, ?> getElementParams(Object obj) {
        return DataRWProxy.getElementParams(obj);
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    @Deprecated
    public ReportPolicy getElementReportPolicy(Object obj) {
        if (isDebugMode()) {
            Log.d(TAG, "getElementReportPolicy(), get");
        }
        if (checkElementObjectArgument(obj)) {
            Object innerParam = DataRWProxy.getInnerParam(obj, InnerKey.ELEMENT_REPORT_POLICY);
            if (innerParam instanceof ReportPolicy) {
                return (ReportPolicy) innerParam;
            }
            return null;
        }
        return null;
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public EndExposurePolicy getElementScrollEndExposePolicy(Object obj) {
        return (EndExposurePolicy) ReportPolicyOperator.getReportPolicy(obj, InnerKey.ELEMENT_SCROLL_END_EXPOSE_POLICY, EndExposurePolicy.class);
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public ExposurePolicy getElementScrollExposePolicy(Object obj) {
        return (ExposurePolicy) ReportPolicyOperator.getReportPolicy(obj, InnerKey.ELEMENT_SCROLL_EXPOSE_POLICY, ExposurePolicy.class);
    }

    public IEventDynamicParams getEventDynamicParams() {
        return this.mEventDynamicParams;
    }

    @NonNull
    public Set<View> getPageCache(@NonNull Context context) {
        return this.mPageInfoCacheCtrl.getPageStore(context);
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public PageInfo getPageInfo(View view) {
        if (view == null) {
            return PageManager.getInstance().getCurrentPageInfo();
        }
        return findOwnerPage(view);
    }

    public IPageParamsFormatter getPageParamsFormatter() {
        return this.mPageParamsFormatter;
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public PageReportPolicy getPageReportPolicy(Object obj) {
        if (!checkPageObjectArgument(obj)) {
            return null;
        }
        Object innerParam = DataRWProxy.getInnerParam(obj, InnerKey.PAGE_REPORT_POLICY);
        if (innerParam instanceof PageReportPolicy) {
            return (PageReportPolicy) innerParam;
        }
        return PageReportPolicy.REPORT_ALL;
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public Integer getPageSearchMode(Object obj) {
        Object innerParam = DataRWProxy.getInnerParam(obj, InnerKey.PAGE_SEARCH_MODE);
        if (innerParam instanceof Integer) {
            return Integer.valueOf(((Integer) innerParam).intValue());
        }
        return null;
    }

    @Nullable
    public Map<String, Object> getPublicParam() {
        return this.mPublicParam;
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    @NonNull
    public IPublicParamInterface getPublicParamInterface() {
        return PublicParamImpl.getInstance();
    }

    @NonNull
    public Collection<IReporter> getReporter() {
        return this.mUnmodifiableReporters;
    }

    public String getSampleSceneId() {
        return getConfiguration().remoteConfigSceneId();
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void ignorePageInOutEvent(Object obj, boolean z16) {
        if (isDebugMode()) {
            Log.d(TAG, "ignorePageInOutEvent(), object=" + obj + ", ignore=" + z16);
        }
        if (checkPageObjectArgument(obj)) {
            DataRWProxy.setInnerParam(obj, InnerKey.PAGE_REPORT_IGNORE, Boolean.valueOf(z16));
        }
    }

    public boolean isDataCollectEnable() {
        return getConfiguration().isDefaultDataCollectEnable();
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public boolean isDebugMode() {
        return this.mDebugMode;
    }

    public synchronized boolean isInit() {
        return this.isInit;
    }

    public boolean isReportEnable() {
        return true;
    }

    public boolean isSampleDisable() {
        if (!isDebugMode() && !VisualDebugManager.getInstance().isStarted()) {
            return false;
        }
        return true;
    }

    public boolean isTestMode() {
        return this.mTestMode;
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void markAsPageBodyView(View view) {
        if (isDebugMode()) {
            Log.d(TAG, "markAsPageBodyView(), view=" + view);
        }
        PageBodyStatistician.getInstance().markAsPageBodyView(view, null);
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void notifyViewDetach(View view, View view2) {
        if (isDebugMode()) {
            Log.d(TAG, "notifyViewDetach(), parentView=" + view + ",view=" + view2);
        }
        if (view2 != null && PageFinder.isPage(view2)) {
            PageSwitchObserver.getInstance().onPageViewInvisible(view2);
            PageSwitchObserver.getInstance().onPageViewVisible(view);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void onActivityPreResume(Activity activity) {
        AppEventReporter.getInstance().onActivityPreResume(activity);
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void onActivityPreStarted(Activity activity) {
        AppEventReporter.getInstance().onActivityPreStarted(activity);
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    @Nullable
    public Map<String, Object> pageInfoForView(String str, View view) {
        Object page;
        PageInfo findOwnerPage = findOwnerPage(view);
        if (findOwnerPage == null) {
            page = null;
        } else {
            page = findOwnerPage.getPage();
        }
        if (page == null) {
            return null;
        }
        return PageUtils.getPageInfo(str, page, findOwnerPage.getPageHashCode());
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void pageLogicDestroy(Object obj) {
        if (isDebugMode()) {
            Log.i(TAG, "clearPageCreRefPageParams: object = " + obj);
        }
        if (!PageFinder.isPage(obj)) {
            return;
        }
        PageSwitchObserver.getInstance().onPageViewInvisible(PageFinder.getPageView(obj));
        PageManager.getInstance().clearPageContext(obj);
        setPageId(obj, null, true);
        setPageContentId(obj, null, true);
        resetPageParams(obj);
        ExposurePolicyHelper.clearEleExposureMap(obj);
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    @Nullable
    public Map<String, Object> paramsForView(String str, View view) {
        FinalData build;
        PathData collect = ReversedDataCollector.collect(view);
        if (collect == null || (build = DataBuilderFactory.obtain().build(str, collect)) == null) {
            return null;
        }
        HashMap hashMap = new HashMap(build.getEventParams());
        ReusablePool.recycle(build);
        return hashMap;
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void registerEventDynamicParams(IEventDynamicParams iEventDynamicParams) {
        if (getInstance().isDebugMode()) {
            Log.d(TAG, "registerEventDynamicParams(), dynamicParams=" + iEventDynamicParams);
        }
        this.mEventDynamicParams = iEventDynamicParams;
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void registerSessionChangeListener(ISessionChangeListener iSessionChangeListener) {
        AppEventReporter.getInstance().registerSessionChangeListener(iSessionChangeListener);
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void removeAllElementParams(Object obj) {
        if (isDebugMode()) {
            Log.d(TAG, "removeAllElementParams(), object=" + obj);
        }
        if (checkElementObjectArgument(obj)) {
            DataRWProxy.removeAllElementParams(obj);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void removeAllPageParams(Object obj) {
        if (isDebugMode()) {
            Log.d(TAG, "removeAllPageParams(), object=" + obj);
        }
        if (checkPageObjectArgument(obj)) {
            DataRWProxy.removeAllPageParams(obj);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void removeElementParam(Object obj, String str) {
        if (isDebugMode()) {
            Log.d(TAG, "removeElementParam(), object=" + obj + ", key=" + str);
        }
        if (checkElementObjectArgument(obj)) {
            DataRWProxy.removeElementParam(obj, str);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void removePageParam(Object obj, String str) {
        if (isDebugMode()) {
            Log.d(TAG, "removePageParam(), object=" + obj + ", key=" + str);
        }
        if (checkPageObjectArgument(obj)) {
            DataRWProxy.removePageParam(obj, str);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void removePublicParam(String str) {
        Map<String, Object> map;
        if (isDebugMode()) {
            Log.d(TAG, "removePublicParam(), key=" + str);
        }
        if (!TextUtils.isEmpty(str) && (map = this.mPublicParam) != null) {
            map.remove(str);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void reportCustomEvent(EventData eventData) {
        if (isInit()) {
            reportEvent(eventData);
            return;
        }
        synchronized (this) {
            if (isInit()) {
                reportEvent(eventData);
            } else {
                CustomEventStagingManager.getInstance().save(eventData);
            }
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public boolean reportEvent(String str, Map<String, ?> map) {
        return reportEvent(str, null, map);
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public boolean reportEventWithoutFormat(String str, Map<String, Object> map, String str2) {
        Log.d(TAG, "reportEvent(), eventId=" + str + ", appKey=" + str2 + ", map=" + map);
        if (TextUtils.isEmpty(str)) {
            if (!isDebugMode()) {
                return false;
            }
            throw new IllegalArgumentException("reportEvent, eventId is empty");
        }
        FinalData finalData = (FinalData) ReusablePool.obtain(FinalData.class);
        finalData.setEventKey(str);
        if (map != null) {
            finalData.putAll(map);
        }
        FinalDataTarget.handleWithoutFormat(null, finalData, str2);
        return true;
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void reportPgIn(Object obj) {
        reportPgIn(obj, true);
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void reportPgOut(Object obj) {
        View pageView = PageFinder.getPageView(obj);
        if (pageView == null) {
            Log.e(TAG, "reportPgOut() pageView == null,so return...");
            return;
        }
        PageInfo findRelatedPage = PageFinder.findRelatedPage(pageView);
        if (findRelatedPage == null) {
            Log.e(TAG, "reportPgOut() -> pageInfo==null,so return...-> pageView=" + pageView);
            return;
        }
        PageReporter.getInstance().doReportPgOut(findRelatedPage, true, false);
        PageContextManager.getInstance().remove(findRelatedPage.getPageHashCode());
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void reportStdEvent(StdEventCode stdEventCode, IEventParamsBuilder iEventParamsBuilder) {
        if (isDebugMode()) {
            Log.d(TAG, "reportStdEvent(), eventCode = " + stdEventCode + ", builder = " + iEventParamsBuilder);
        }
        if (!StdEventParamChecker.checkParamBuilder(stdEventCode, iEventParamsBuilder)) {
            return;
        }
        reportEvent(stdEventCode.codeName, iEventParamsBuilder.build());
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void reportUserPrivacy(String str, Map<String, String> map) {
        UserPrivacyEventReporter.getInstance().handleUserPrivacy(str, map);
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void resetElementParams(Object obj) {
        if (isDebugMode()) {
            Log.d(TAG, "resetElementParams(), object=" + obj);
        }
        if (checkElementObjectArgument(obj)) {
            DataRWProxy.removeAllElementParams(obj);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void resetPageParams(Object obj) {
        if (isDebugMode()) {
            Log.d(TAG, "resetPageParams(), object=" + obj);
        }
        if (checkPageObjectArgument(obj)) {
            DataRWProxy.removeAllPageParams(obj);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void resetPageStats() {
        PageManager.getInstance().resetPagePath();
    }

    public boolean sampleTestEnabled() {
        return this.mEnableSampleTest;
    }

    public Sampler sampler() {
        return this.sampler;
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void setAudioTimerListener(Object obj, IAudioTimerListener iAudioTimerListener) {
        DataRWProxy.putExtendParam(obj, DTConstants.DTExtendMapKey.AUDIO_TIMER_LISTENER, new WeakReference(iAudioTimerListener));
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void setClickReportInterval(View view, long j3) {
        if (isDebugMode()) {
            Log.d(TAG, "setClickReportInterval(), view = " + view + ", interval = " + j3);
        }
        if (view == null) {
            return;
        }
        DataRWProxy.setInnerParam(view, InnerKey.CLICK_INTERVAL, Long.valueOf(j3));
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void setCollectProcessName(boolean z16) {
        ProcessUtils.setCollectProcessName(z16);
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void setDataCollectEnable(boolean z16) {
        if (isDebugMode()) {
            Log.d(TAG, "setDataCollectEnable(), enable=" + z16);
        }
        Configuration configuration = this.mConfiguration;
        if (configuration == null) {
            this.mConfiguration = Configuration.builder().defaultDataCollectEnable(z16).build();
        } else {
            configuration.setDefaultDataCollectEnable(z16);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void setDebugMode(boolean z16) {
        this.mDebugMode = z16;
        ListenerMgr.setDebug(z16);
        if (isDebugMode()) {
            Log.d(TAG, "setDebugMode(), debugMode=" + z16);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void setDetectionInterceptor(IDetectionInterceptor iDetectionInterceptor) {
        DetectionInterceptors.setDetectionInterceptor(iDetectionInterceptor);
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void setDetectionMode(@DetectionMode int i3) {
        DetectionPolicy.setDetectionMode(i3);
    }

    public void setElementBizReady(@NonNull Object obj) {
        ElementExposureReporter.getInstance().setElementBizReady(obj, true);
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void setElementClickPolicy(Object obj, ClickPolicy clickPolicy) {
        ReportPolicyOperator.setReportPolicy(obj, clickPolicy, InnerKey.ELEMENT_CLICK_POLICY);
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void setElementDynamicParams(Object obj, IElementDynamicParams iElementDynamicParams) {
        if (isDebugMode()) {
            Log.d(TAG, "setElementDynamicParams(), object=" + obj + ", provider=" + iElementDynamicParams);
        }
        if (checkElementObjectArgument(obj)) {
            DataRWProxy.setElementDynamicParam(obj, iElementDynamicParams);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void setElementEndExposePolicy(Object obj, EndExposurePolicy endExposurePolicy) {
        ReportPolicyOperator.setReportPolicy(obj, endExposurePolicy, InnerKey.ELEMENT_END_EXPOSE_POLICY);
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void setElementExposePolicy(Object obj, ExposurePolicy exposurePolicy) {
        ReportPolicyOperator.setReportPolicy(obj, exposurePolicy, InnerKey.ELEMENT_EXPOSE_POLICY);
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void setElementExposureAreaLimit(Object obj, boolean z16) {
        if (checkElementObjectArgument(obj)) {
            DataRWProxy.putExtendParam(obj, DTConstants.DTExtendMapKey.VIEW_EXPOSURE_AREA_LIMIT, Boolean.valueOf(z16));
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void setElementExposureDetectionEnabled(Object obj, boolean z16) {
        if (isDebugMode()) {
            Log.d(TAG, "setElementExposureDetectionEnabled(), element = " + obj + ", enabled = " + z16);
        }
        if (checkElementObjectArgument(obj)) {
            DataRWProxy.setInnerParam(obj, InnerKey.ELEMENT_DETECTION_ENABLE, Boolean.valueOf(z16));
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void setElementExposureMinRate(Object obj, double d16) {
        if (isDebugMode()) {
            Log.d(TAG, "setElementExposureMinRate(), object=" + obj + ", rate=" + d16);
        }
        if (checkElementObjectArgument(obj)) {
            DataRWProxy.setInnerParam(obj, InnerKey.ELEMENT_EXPOSURE_MIN_RATE, Double.valueOf(d16));
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void setElementExposureMinTime(Object obj, long j3) {
        if (isDebugMode()) {
            Log.d(TAG, "setElementExposureMinTime(), object=" + obj + ", timeMills=" + j3);
        }
        if (checkElementObjectArgument(obj)) {
            DataRWProxy.setInnerParam(obj, InnerKey.ELEMENT_EXPOSURE_MIN_TIME, Long.valueOf(j3));
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void setElementId(Object obj, String str, boolean z16) {
        if (isDebugMode()) {
            Log.d(TAG, "setElementId(), object=" + obj + ", elementId=" + str);
        }
        if (checkElementObjectArgument(obj)) {
            ElementExposureReporter.getInstance().setElementBizReady(obj, z16);
            DataRWProxy.setElementId(obj, str);
        }
    }

    public void setElementId2EventId2SampleRate(Map<String, Map<String, Float>> map) {
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, Map<String, Float>> entry : map.entrySet()) {
                setElementSampleRate(entry.getKey(), entry.getValue());
            }
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void setElementParam(Object obj, String str, Object obj2) {
        if (isDebugMode()) {
            Log.d(TAG, "setElementParam(), object=" + obj + ", key=" + str + ", value=" + obj2);
        }
        if (checkElementObjectArgument(obj)) {
            DataRWProxy.setElementParam(obj, str, obj2);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void setElementParams(Object obj, Map<String, ?> map) {
        if (isDebugMode()) {
            Log.d(TAG, "setElementParams(), object=" + obj + ", map=" + map);
        }
        if (checkElementObjectArgument(obj)) {
            DataRWProxy.setElementParams(obj, map);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void setElementReportBeforeClick(Object obj, boolean z16) {
        DTConstants.ClickEventSource clickEventSource;
        if (checkElementObjectArgument(obj)) {
            if (z16) {
                clickEventSource = DTConstants.ClickEventSource.METHOND_BEFORE;
            } else {
                clickEventSource = DTConstants.ClickEventSource.METHOND_AFTER;
            }
            DataRWProxy.putExtendParam(obj, DTConstants.DTExtendMapKey.VIEW_REPORT_BEFORE_CLICK, clickEventSource);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void setElementReportBeforeLongClick(Object obj, boolean z16) {
        DTConstants.ClickEventSource clickEventSource;
        if (checkElementObjectArgument(obj)) {
            if (z16) {
                clickEventSource = DTConstants.ClickEventSource.METHOND_BEFORE;
            } else {
                clickEventSource = DTConstants.ClickEventSource.METHOND_AFTER;
            }
            DataRWProxy.putExtendParam(obj, DTConstants.DTExtendMapKey.VIEW_REPORT_BEFORE_LONG_CLICK, clickEventSource);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    @Deprecated
    public void setElementReportPolicy(Object obj, ReportPolicy reportPolicy) {
        ClickPolicy clickPolicy;
        ExposurePolicy exposurePolicy;
        EndExposurePolicy endExposurePolicy;
        if (isDebugMode()) {
            Log.d(TAG, "setElementReportPolicy(), object=" + obj + ", policy=" + reportPolicy.name());
        }
        if (checkElementObjectArgument(obj)) {
            if (reportPolicy.reportClick) {
                clickPolicy = ClickPolicy.REPORT_ALL;
            } else {
                clickPolicy = ClickPolicy.REPORT_NONE;
            }
            setElementClickPolicy(obj, clickPolicy);
            if (reportPolicy.reportExposure) {
                exposurePolicy = ExposurePolicy.REPORT_ALL;
            } else {
                exposurePolicy = ExposurePolicy.REPORT_NONE;
            }
            setElementExposePolicy(obj, exposurePolicy);
            if (reportPolicy.reportExposure) {
                endExposurePolicy = EndExposurePolicy.REPORT_ALL;
            } else {
                endExposurePolicy = EndExposurePolicy.REPORT_NONE;
            }
            setElementEndExposePolicy(obj, endExposurePolicy);
            DataRWProxy.setInnerParam(obj, InnerKey.ELEMENT_REPORT_POLICY, reportPolicy);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void setElementReuseIdentifier(Object obj, String str) {
        if (isDebugMode()) {
            Log.d(TAG, "setElementReuseIdentifier(), element = " + obj + ", identifier = " + str);
        }
        if (obj == null) {
            return;
        }
        DataRWProxy.setInnerParam(obj, InnerKey.ELEMENT_IDENTIFIER, str);
    }

    public void setElementSampleRate(Map<String, Float> map) {
        if ((!this.mEnableSampleTest && isSampleDisable()) || map == null || map.size() == 0) {
            return;
        }
        for (Map.Entry<String, Float> entry : map.entrySet()) {
            setElementSampleRate(entry.getKey(), entry.getValue().floatValue());
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void setElementScrollEndExposePolicy(Object obj, EndExposurePolicy endExposurePolicy) {
        ReportPolicyOperator.setReportPolicy(obj, endExposurePolicy, InnerKey.ELEMENT_SCROLL_END_EXPOSE_POLICY);
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void setElementScrollExposePolicy(Object obj, ExposurePolicy exposurePolicy) {
        ReportPolicyOperator.setReportPolicy(obj, exposurePolicy, InnerKey.ELEMENT_SCROLL_EXPOSE_POLICY);
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void setElementVirtualParentParams(Object obj, int i3, String str, Map<String, Object> map) {
        if (isDebugMode()) {
            Log.d(TAG, "setElementParentParams(), " + i3 + map);
        }
        if (checkElementObjectArgument(obj)) {
            DataRWProxy.setElementVirtualParentParams(obj, i3, str, map);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void setEventAdditionalReport(IAdditionalReportListener iAdditionalReportListener) {
        AppEventReporter.getInstance().setEventAdditionalReport(iAdditionalReportListener);
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void setEventDynamicParams(Object obj, @Nullable IDynamicParams iDynamicParams) {
        if (isDebugMode()) {
            Log.d(TAG, "setElementDynamicParams(), object=" + obj + ", provider=" + iDynamicParams);
        }
        if (checkElementObjectArgument(obj) || checkPageObjectArgument(obj)) {
            DataRWProxy.setEventDynamicParam(obj, iDynamicParams);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void setEventType(Object obj, EventAgingType eventAgingType) {
        if (isDebugMode()) {
            Log.d(TAG, "setEventType(), object=" + obj + ", eventType=" + eventAgingType);
        }
        if (checkPageObjectArgument(obj)) {
            DataRWProxy.setEventType(obj, eventAgingType);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void setLogicParent(View view, View view2) {
        if (isDebugMode()) {
            Log.d(TAG, "setLogicParent(), child = " + view + ", logicParent = " + view2);
        }
        if (view == null) {
            return;
        }
        if (view2 == null) {
            DataRWProxy.removeInnerParam(view, InnerKey.LOGIC_PARENT);
        } else {
            DataRWProxy.setInnerParam(view, InnerKey.LOGIC_PARENT, new WeakReference(view2));
        }
        PageSwitchObserver.getInstance().onPageViewVisible(view.getRootView());
    }

    public void setPageBizReady(@NonNull Object obj) {
        PageReporter.getInstance().setPageBizReady(obj, true);
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void setPageBodyContentRange(View view, int i3, int i16) {
        if (isDebugMode()) {
            Log.d(TAG, "setPageBodyContentRange(), view=" + view + ", rangeStart=" + i3 + ", rangeEnd=" + i16);
        }
        PageBodyStatistician.getInstance().setPageBodyContentRange(view, i3, i16);
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void setPageContentId(Object obj, String str) {
        setPageContentId(obj, str, false);
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void setPageEventListener(Object obj, IPageEventListener iPageEventListener) {
        PageEventListenerMgr.setPageEventListener(obj, iPageEventListener);
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void setPageId(final Object obj, final String str, final boolean z16) {
        if (isDebugMode()) {
            Log.d(TAG, "setPageId(), object=" + obj + ", pageId=" + str);
        }
        ThreadUtils.ensureRunOnUiThread(new Runnable() { // from class: com.tencent.qqlive.module.videoreport.inner.c
            @Override // java.lang.Runnable
            public final void run() {
                VideoReportInner.this.lambda$setPageId$2(obj, z16, str);
            }
        });
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void setPageLinkEnable(Object obj, boolean z16) {
        View view;
        if (obj instanceof Activity) {
            view = ((Activity) obj).getWindow().getDecorView();
        } else if (obj instanceof Dialog) {
            view = ((Dialog) obj).getWindow().getDecorView();
        } else if (obj instanceof View) {
            view = ((View) obj).getRootView();
        } else {
            view = null;
        }
        if (view == null) {
            Log.w(TAG, "object must be instance of Activity\u3001Dialog\u3001View");
        } else {
            DataRWProxy.setInnerParam(view, InnerKey.PAGE_LINK_ENABLE, Boolean.valueOf(z16));
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void setPageParams(final Object obj, final PageParams pageParams) {
        if (isDebugMode()) {
            Log.d(TAG, "setPageParams(), object=" + obj + ", pageParams=" + pageParams);
        }
        ThreadUtils.ensureRunOnUiThread(new Runnable() { // from class: com.tencent.qqlive.module.videoreport.inner.b
            @Override // java.lang.Runnable
            public final void run() {
                VideoReportInner.this.lambda$setPageParams$0(obj, pageParams);
            }
        });
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void setPageParamsFormatter(IPageParamsFormatter iPageParamsFormatter) {
        this.mPageParamsFormatter = iPageParamsFormatter;
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void setPageReportPolicy(Object obj, PageReportPolicy pageReportPolicy) {
        if (checkPageObjectArgument(obj)) {
            DataRWProxy.setInnerParam(obj, InnerKey.PAGE_REPORT_POLICY, pageReportPolicy);
        }
    }

    public void setPageSampleRate(Map<String, Float> map) {
        if ((!this.mEnableSampleTest && isSampleDisable()) || map == null || map.size() == 0) {
            return;
        }
        for (Map.Entry<String, Float> entry : map.entrySet()) {
            setPageSampleRate(entry.getKey(), entry.getValue().floatValue());
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void setPageSearchMode(Object obj, int i3) {
        DataRWProxy.setInnerParam(obj, InnerKey.PAGE_SEARCH_MODE, Integer.valueOf(i3));
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void setPublicParam(String str, Object obj) {
        if (isDebugMode()) {
            Log.d(TAG, "setPublicParam(), key=" + str + ", value=" + obj);
        }
        if (!TextUtils.isEmpty(str)) {
            if (this.mPublicParam == null) {
                this.mPublicParam = new HashMap(1);
            }
            this.mPublicParam.put(str, obj);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void setTestMode(boolean z16) {
        if (isDebugMode()) {
            Log.d(TAG, "setTestMode(), testMode=" + z16);
        }
        this.mTestMode = z16;
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void setVideoReportConfig(@NonNull DTConfig dTConfig) {
        supportPlayerReport(dTConfig.videoReportSupport());
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void startNewSession(SessionChangeReason sessionChangeReason) {
        AppEventReporter.getInstance().startNewSession(sessionChangeReason);
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void startWithComponent(Application application, IVideoReportComponent iVideoReportComponent, ModuleInitPolicy moduleInitPolicy) {
        SimpleTracer.begin("VideoReportInner.startWithComponent");
        if (iVideoReportComponent != null) {
            startWithConfiguration(application, iVideoReportComponent.getConfiguration(), moduleInitPolicy);
        }
        SimpleTracer.end("VideoReportInner.startWithComponent");
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public synchronized void startWithConfiguration(Application application, Configuration configuration, ModuleInitPolicy moduleInitPolicy) {
        if (isInit()) {
            Log.w(TAG, "startWithConfiguration(), already initialized");
            return;
        }
        if (!ThreadUtils.isMainThread()) {
            Log.e(TAG, "startWithConfiguration(), We recommend initializing the \u5927\u540c SDK in the main thread");
        }
        this.mConfiguration = configuration;
        if (isDebugMode()) {
            Log.d(TAG, "startWithConfiguration(), application =" + application + ", configuration =" + configuration);
        }
        if (application != null) {
            application.registerActivityLifecycleCallbacks(EventCollector.getInstance());
            ReportUtils.setContext(application);
            ThreadUtils.injectTaskInterceptor(LazyInitObserver.getInstance());
            ReportUtils.initCrashReport(application);
            UssnUtils.preInitAsync(application);
            SPUtils.preInitAsync(application);
            initiateModules(moduleInitPolicy);
            LazyInitObserver.getInstance().onInitialized();
            loadRemoteConfig(application);
        } else if (isDebugMode()) {
            throw new NullPointerException("Application = null");
        }
        CustomEventStagingManager.getInstance().supplementReportsEvent();
        this.isInit = true;
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void supportAudioReport(boolean z16) {
        DTConfigConstants.config.audioReportSupport(z16);
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void supportNewPlayType(boolean z16) {
        DTConfigConstants.config.newPlayTypeSupport(z16);
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void supportPlayerReport(boolean z16) {
        DTConfigConstants.config.videoReportSupport(z16);
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void supportSeekReport(boolean z16) {
        DTConfigConstants.config.seekReportSupport(z16);
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void supportSpeedRatioReport(boolean z16) {
        DTConfigConstants.config.speedRatioReportSupport(z16);
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void supportWebViewReport(boolean z16) {
        DTConfigConstants.config.webViewReportSupport(z16);
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void traverseExposure() {
        if (isDebugMode()) {
            Log.d(TAG, "traverseExposure(), ");
        }
        ElementExposureReporter.getInstance().traverseExposure();
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void traversePage(View view) {
        if (isDebugMode()) {
            Log.d(TAG, "traversePage(), view = " + view);
        }
        if (view == null) {
            return;
        }
        PageSwitchObserver.getInstance().onPageViewVisible(view);
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void triggerClickInCurrentPage(Map<String, Object> map) {
        if (isDebugMode()) {
            Log.d(TAG, "triggerClickInCurrentPage(),");
        }
        triggerEventInCurrentPage("clck", map);
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void triggerEventInCurrentPage(String str, Map<String, Object> map) {
        if (isDebugMode()) {
            Log.d(TAG, "triggerEventInCurrentPage(), eventKey = " + str);
        }
        if (TextUtils.isEmpty(str)) {
            if (!isDebugMode()) {
                return;
            } else {
                throw new IllegalArgumentException("triggerEventInCurrentPage, eventKey is empty");
            }
        }
        FinalData finalData = (FinalData) ReusablePool.obtain(FinalData.class);
        finalData.setEventKey(str);
        finalData.put("cur_pg", PageReporter.getInstance().getCurPageReportInfo(str));
        finalData.putAll(map);
        FinalDataTarget.handle(null, finalData);
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void triggerExposureInCurrentPage(List<Map<String, Object>> list) {
        if (list != null && !list.isEmpty()) {
            Iterator<Map<String, Object>> it = list.iterator();
            while (it.hasNext()) {
                triggerEventInCurrentPage("imp", it.next());
            }
        } else if (isDebugMode()) {
            Log.d(TAG, "triggerExposureInCurrentPage(), paramsList is empty.");
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void unbindVideoPlayerInfo(@NonNull Object obj) {
        VideoReportManager.getInstance().unbindVideoInfo(obj);
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void updateAudioInfo(Object obj, @NonNull AudioEntity audioEntity, @Nullable Map<String, Object> map) {
        AudioDataManager.getInstance().updateAudioInfo(obj, audioEntity, map);
    }

    public synchronized void updateConfiguration(Configuration configuration) {
        Configuration configuration2 = this.mConfiguration;
        if (configuration2 != null && configuration != null) {
            configuration2.update(configuration);
            return;
        }
        this.mConfiguration = configuration;
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void updateVideoPlayerInfo(@NonNull Object obj, @NonNull VideoBaseEntity videoBaseEntity) {
        VideoReportManager.getInstance().updateVideoInfo(obj, videoBaseEntity);
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    @Nullable
    public Map<String, Object> viewTreeParamsForView(String str, View view) {
        Map<String, Object> paramsForView = paramsForView(str, view);
        if (paramsForView != null) {
            paramsForView.remove("cur_pg");
        }
        return paramsForView;
    }

    VideoReportInner() {
        this.sampler = new SamplerImpl();
        this.remoteConfig = null;
        this.mPageInfoCacheCtrl = new PageInfoCacheController();
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        this.mReporters = copyOnWriteArraySet;
        this.mUnmodifiableReporters = Collections.unmodifiableCollection(copyOnWriteArraySet);
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void addReporter(IReporter iReporter) {
        if (isDebugMode()) {
            Log.d(TAG, "addReporter(), reporter=" + iReporter);
        }
        if (iReporter != null) {
            this.mReporters.add(iReporter);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public boolean reportEvent(String str, Object obj, Map<String, ?> map) {
        return reportEvent(EventData.builder().withSource(obj).withId(str).withParams(map != null ? new HashMap(map) : null).build());
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void reportPgIn(Object obj, boolean z16) {
        PageInfo currentPageInfo;
        View pageView = PageFinder.getPageView(obj);
        if (pageView == null) {
            Log.e(TAG, "reportPgIn() pageView == null,so return...");
            return;
        }
        if (z16 && pageView.getVisibility() != 0) {
            Log.e(TAG, "reportPgIn() -> pageView.getVisibility()!=View.VISIBLE,so return... -> pageView=" + pageView);
            return;
        }
        PageInfo findRelatedPage = PageFinder.findRelatedPage(pageView);
        if (findRelatedPage == null) {
            Log.e(TAG, "reportPgIn() -> pageInfo==null,so return...-> pageView=" + pageView);
            return;
        }
        if (PageContextManager.getInstance().get(findRelatedPage.getPageHashCode()) == null && (currentPageInfo = PageManager.getInstance().getCurrentPageInfo()) != null) {
            DataEntity dataEntity = DataBinder.getDataEntity(currentPageInfo.getPage());
            int curPgStp = PageManager.getInstance().getCurPgStp();
            PageManager.getInstance().addPgStep();
            PageContextManager.getInstance().set(findRelatedPage.getPageHashCode(), new PageContext(curPgStp + 1, curPgStp, curPgStp, DataBinder.getDataEntity(obj), dataEntity, dataEntity));
        }
        PageReporter.getInstance().doReportPageIn(findRelatedPage, false);
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void setPageContentId(Object obj, String str, boolean z16) {
        if (isDebugMode()) {
            Log.d(TAG, "setPageId(), object=" + obj + ", pageContentId=" + str);
        }
        if (checkPageObjectArgument(obj)) {
            DataRWProxy.setPageContentId(obj, str);
            if (z16) {
                DataRWProxy.setInnerParam(obj, InnerKey.PAGE_LAST_CONTENT_ID, null);
            }
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public VideoReportPageInfo getPageInfo() {
        Object page;
        PageInfo currentPageInfo = PageManager.getInstance().getCurrentPageInfo();
        if (currentPageInfo == null || (page = currentPageInfo.getPage()) == null) {
            return null;
        }
        return new VideoReportPageInfo(page, currentPageInfo.getPageView(), DataRWProxy.getPageId(page), DataRWProxy.getPageParams(page), null);
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void markAsPageBodyView(View view, IScrollReader iScrollReader) {
        if (isDebugMode()) {
            Log.d(TAG, "markAsPageBodyView(), view=" + view);
        }
        PageBodyStatistician.getInstance().markAsPageBodyView(view, iScrollReader);
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public void setPageParams(final Object obj, final String str, final Object obj2) {
        if (isDebugMode()) {
            Log.d(TAG, "setPageParams(), object=" + obj + ", key=" + str + ", value=" + obj2);
        }
        ThreadUtils.ensureRunOnUiThread(new Runnable() { // from class: com.tencent.qqlive.module.videoreport.inner.a
            @Override // java.lang.Runnable
            public final void run() {
                VideoReportInner.this.lambda$setPageParams$1(obj, str, obj2);
            }
        });
    }

    public void setElementSampleRate(String str, float f16) {
        if (this.mEnableSampleTest || !isSampleDisable()) {
            SampleMutex.setEidSampleMode(1);
            SampleInfoManager.getInstance().setSampleRate(2, str, f16);
        }
    }

    public void setPageSampleRate(String str, float f16) {
        if (this.mEnableSampleTest || !isSampleDisable()) {
            SampleInfoManager.getInstance().setSampleRate(1, str, f16);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inner.IVideoReport
    public boolean reportEvent(EventData eventData) {
        if (isDebugMode()) {
            Log.d(TAG, "reportEvent(), eventData=" + eventData);
        }
        if (TextUtils.isEmpty(eventData.getId())) {
            if (isDebugMode()) {
                throw new IllegalArgumentException("reportEvent, eventId is empty");
            }
            return false;
        }
        if (eventData.getSource() == null) {
            FinalData finalData = (FinalData) ReusablePool.obtain(FinalData.class);
            finalData.setEventKey(eventData.getId());
            finalData.setEventType(eventData.getType());
            finalData.putAll(eventData.getParams());
            FinalDataTarget.handle(null, finalData);
            return true;
        }
        if (!checkTrackObjectArgument(eventData.getSource())) {
            return false;
        }
        if (reportCustomPageEvent(eventData)) {
            return true;
        }
        return reportCustomElementEvent(eventData);
    }

    public void setElementSampleRate(String str, Map<String, Float> map) {
        if (this.mEnableSampleTest || !isSampleDisable()) {
            SampleMutex.setEidSampleMode(2);
            SampleInfoManager.getInstance().setElementSampleRate(str, map);
        }
    }
}
