package com.tencent.qqlive.module.videoreport;

import android.app.Activity;
import android.app.Application;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qqlive.module.videoreport.common.EventAgingType;
import com.tencent.qqlive.module.videoreport.common.EventData;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ModuleInitPolicy;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.qqlive.module.videoreport.constants.ReportPolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.qqlive.module.videoreport.data.IElementDynamicParams;
import com.tencent.qqlive.module.videoreport.dtreport.api.DTConfig;
import com.tencent.qqlive.module.videoreport.dtreport.api.PageSearchMode;
import com.tencent.qqlive.module.videoreport.dtreport.audio.api.IAudioTimerListener;
import com.tencent.qqlive.module.videoreport.dtreport.audio.data.AudioEntity;
import com.tencent.qqlive.module.videoreport.dtreport.stdevent.IEventParamsBuilder;
import com.tencent.qqlive.module.videoreport.dtreport.stdevent.StdEventCode;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoBaseEntity;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoEntity;
import com.tencent.qqlive.module.videoreport.dtreport.video.logic.VideoReportManager;
import com.tencent.qqlive.module.videoreport.dtreport.video.logic.a;
import com.tencent.qqlive.module.videoreport.flutter.DTFlutterApi;
import com.tencent.qqlive.module.videoreport.flutter.DTFlutterPageManager;
import com.tencent.qqlive.module.videoreport.inject.InjectHelper;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.page.IPageEventListener;
import com.tencent.qqlive.module.videoreport.page.IScrollReader;
import com.tencent.qqlive.module.videoreport.page.PageInfo;
import com.tencent.qqlive.module.videoreport.page.VideoReportPageInfo;
import com.tencent.qqlive.module.videoreport.remoteconfig.RemoteConfig;
import com.tencent.qqlive.module.videoreport.sample.SampleInfoManager;
import com.tencent.qqlive.module.videoreport.utils.IDetectionInterceptor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class VideoReport {
    private static final String TAG = "VideoReport";

    @Deprecated
    public static void addReporter(IReporter iReporter) {
        VideoReportInner.getInstance().addReporter(iReporter);
    }

    public static void addReporters(List<com.tencent.qqlive.module.videoreport.common.IReporter> list) {
        VideoReportInner.getInstance().addReporters(list);
    }

    public static void addToDetectionBlacklist(Activity activity) {
        VideoReportInner.getInstance().addToDetectionBlacklist(activity);
    }

    public static void addToDetectionWhitelist(Activity activity) {
        VideoReportInner.getInstance().addToDetectionWhitelist(activity);
    }

    public static void bindAudioPlayerInfo(Object obj, AudioEntity audioEntity) {
        VideoReportInner.getInstance().bindAudioPlayerInfo(obj, audioEntity);
    }

    public static void bindFlutter(View view, DTFlutterApi dTFlutterApi) {
        DTFlutterPageManager.getInstance().bindFlutter(view, dTFlutterApi);
    }

    public static void bindRemoteConfig(RemoteConfig remoteConfig) {
        VideoReportInner.getInstance().bindRemoteConfig(remoteConfig);
    }

    public static void bindSampleConfig(String str) {
        VideoReportInner.getInstance().bindSampleConfig(str);
    }

    public static void bindSubmitTarget(View view, View view2) {
        VideoReportInner.getInstance().bindSubmitTarget(view, view2);
    }

    public static void bindVideoPlayerInfo(@NonNull Object obj, VideoEntity videoEntity) {
        VideoReportInner.getInstance().bindVideoPlayerInfo(obj, videoEntity);
    }

    public static void clearAllSampleRate() {
        SampleInfoManager.getInstance().clearPagesSampleRate();
        SampleInfoManager.getInstance().clearElementsSampleRate();
    }

    public static void clearElementExposure(View view, boolean z16) {
        VideoReportInner.getInstance().clearElementExposure(view, z16);
    }

    public static void clearElementsSampleRate() {
        SampleInfoManager.getInstance().clearElementsSampleRate();
    }

    public static void clearPagesSampleRate() {
        SampleInfoManager.getInstance().clearPagesSampleRate();
    }

    public static void clearPublicParams() {
        VideoReportInner.getInstance().clearPublicParams();
    }

    public static void doAppOutReport() {
        VideoReportInner.getInstance().doAppOutReport();
    }

    public static void enableAndroidXRVExposure(RecyclerView recyclerView) {
        VideoReportInner.getInstance().enableAndroidXRVExposure(recyclerView);
    }

    public static void enableCollectAllPage(View view) {
        VideoReportInner.getInstance().enableCollectAllPage(view);
    }

    public static void enableSampleTest(boolean z16) {
        VideoReportInner.getInstance().enableSampleTest(z16);
    }

    public static void enableScrollExposureReport(Object obj, boolean z16) {
        VideoReportInner.getInstance().enableScrollExposureReport(obj, z16);
    }

    public static PageInfo findOwnerPage(View view) {
        return VideoReportInner.getInstance().findOwnerPage(view);
    }

    public static Configuration getConfiguration() {
        return VideoReportInner.getInstance().getConfiguration();
    }

    public static ClickPolicy getElementClickPolicy(Object obj) {
        return VideoReportInner.getInstance().getElementClickPolicy(obj);
    }

    public static EndExposurePolicy getElementEndExposePolicy(Object obj) {
        return VideoReportInner.getInstance().getElementEndExposePolicy(obj);
    }

    public static ExposurePolicy getElementExposePolicy(Object obj) {
        return VideoReportInner.getInstance().getElementExposePolicy(obj);
    }

    @Deprecated
    public static Map<String, ?> getElementParams(Object obj) {
        return VideoReportInner.getInstance().getElementParams(obj);
    }

    @Deprecated
    public static ReportPolicy getElementReportPolicy(Object obj) {
        return VideoReportInner.getInstance().getElementReportPolicy(obj);
    }

    public static EndExposurePolicy getElementScrollEndExposePolicy(Object obj) {
        return VideoReportInner.getInstance().getElementScrollEndExposePolicy(obj);
    }

    public static ExposurePolicy getElementScrollExposePolicy(Object obj) {
        return VideoReportInner.getInstance().getElementScrollExposePolicy(obj);
    }

    public static PageInfo getPageInfo(View view) {
        return VideoReportInner.getInstance().getPageInfo(view);
    }

    public static PageReportPolicy getPageReportPolicy(Object obj) {
        return VideoReportInner.getInstance().getPageReportPolicy(obj);
    }

    @NonNull
    public static IPublicParamInterface getPublicParamInterface() {
        return VideoReportInner.getInstance().getPublicParamInterface();
    }

    public static void ignorePageInOutEvent(Object obj, boolean z16) {
        VideoReportInner.getInstance().ignorePageInOutEvent(obj, z16);
    }

    public static boolean isDebugMode() {
        return VideoReportInner.getInstance().isDebugMode();
    }

    public static boolean isInit() {
        return VideoReportInner.getInstance().isInit();
    }

    public static boolean isInjectSuccess() {
        return InjectHelper.isInjectSuccess();
    }

    public static void markAsPageBodyView(View view) {
        VideoReportInner.getInstance().markAsPageBodyView(view);
    }

    public static void notifyViewDetach(View view, View view2) {
        VideoReportInner.getInstance().notifyViewDetach(view, view2);
    }

    public static void onActivityPreResume(Activity activity) {
        VideoReportInner.getInstance().onActivityPreResume(activity);
    }

    public static void onActivityPreStarted(Activity activity) {
        VideoReportInner.getInstance().onActivityPreStarted(activity);
    }

    @Nullable
    public static Map<String, Object> pageInfoForView(View view) {
        return VideoReportInner.getInstance().pageInfoForView("", view);
    }

    public static void pageLogicDestroy(Object obj) {
        VideoReportInner.getInstance().pageLogicDestroy(obj);
    }

    @Nullable
    @Deprecated
    public static Map<String, Object> paramsForView(View view) {
        return VideoReportInner.getInstance().paramsForView("", view);
    }

    public static void registerEventDynamicParams(IEventDynamicParams iEventDynamicParams) {
        VideoReportInner.getInstance().registerEventDynamicParams(iEventDynamicParams);
    }

    public static void registerSessionChangeListener(ISessionChangeListener iSessionChangeListener) {
        VideoReportInner.getInstance().registerSessionChangeListener(iSessionChangeListener);
    }

    @Deprecated
    public static void removeAllElementParams(Object obj) {
        VideoReportInner.getInstance().removeAllElementParams(obj);
    }

    @Deprecated
    public static void removeAllPageParams(Object obj) {
        VideoReportInner.getInstance().removeAllPageParams(obj);
    }

    public static void removeElementParam(Object obj, String str) {
        VideoReportInner.getInstance().removeElementParam(obj, str);
    }

    public static void removePageParam(Object obj, String str) {
        VideoReportInner.getInstance().removePageParam(obj, str);
    }

    public static void removePublicParam(String str) {
        VideoReportInner.getInstance().removePublicParam(str);
    }

    public static void reportEvent(String str, Map<String, ?> map) {
        reportEvent(str, null, map);
    }

    public static void reportFlutterEvent(String str, Map<String, ?> map) {
        DTFlutterPageManager.getInstance().reportFlutterEvent(str, map);
    }

    public static void reportPgIn(Object obj) {
        VideoReportInner.getInstance().reportPgIn(obj);
    }

    public static void reportPgOut(Object obj) {
        VideoReportInner.getInstance().reportPgOut(obj);
    }

    public static void reportStdEvent(StdEventCode stdEventCode, IEventParamsBuilder iEventParamsBuilder) {
        VideoReportInner.getInstance().reportStdEvent(stdEventCode, iEventParamsBuilder);
    }

    public static void reportUserPrivacy(String str, Map<String, String> map) {
        VideoReportInner.getInstance().reportUserPrivacy(str, map);
    }

    public static void resetElementParams(Object obj) {
        VideoReportInner.getInstance().resetElementParams(obj);
    }

    public static void resetPageParams(Object obj) {
        VideoReportInner.getInstance().resetPageParams(obj);
    }

    public static void resetPageStats() {
        VideoReportInner.getInstance().resetPageStats();
    }

    public static void setAudioTimerListener(Object obj, IAudioTimerListener iAudioTimerListener) {
        VideoReportInner.getInstance().setAudioTimerListener(obj, iAudioTimerListener);
    }

    public static void setClickReportInterval(View view, long j3) {
        VideoReportInner.getInstance().setClickReportInterval(view, j3);
    }

    public static void setCollectProcessName(boolean z16) {
        VideoReportInner.getInstance().setCollectProcessName(z16);
    }

    public static void setDataCollectEnable(boolean z16) {
        VideoReportInner.getInstance().setDataCollectEnable(z16);
    }

    public static void setDebugMode(boolean z16) {
        VideoReportInner.getInstance().setDebugMode(z16);
    }

    public static void setDetectionInterceptor(IDetectionInterceptor iDetectionInterceptor) {
        VideoReportInner.getInstance().setDetectionInterceptor(iDetectionInterceptor);
    }

    public static void setDetectionMode(@DetectionMode int i3) {
        VideoReportInner.getInstance().setDetectionMode(i3);
    }

    public static void setElementBizReady(Object obj) {
        if (obj == null) {
            return;
        }
        VideoReportInner.getInstance().setElementBizReady(obj);
    }

    public static void setElementClickPolicy(Object obj, ClickPolicy clickPolicy) {
        VideoReportInner.getInstance().setElementClickPolicy(obj, clickPolicy);
    }

    @Deprecated
    public static void setElementDynamicParams(Object obj, IElementDynamicParams iElementDynamicParams) {
        VideoReportInner.getInstance().setElementDynamicParams(obj, iElementDynamicParams);
    }

    public static void setElementEndExposePolicy(Object obj, EndExposurePolicy endExposurePolicy) {
        VideoReportInner.getInstance().setElementEndExposePolicy(obj, endExposurePolicy);
    }

    public static void setElementExposePolicy(Object obj, ExposurePolicy exposurePolicy) {
        VideoReportInner.getInstance().setElementExposePolicy(obj, exposurePolicy);
    }

    public static void setElementExposureAreaLimit(Object obj, boolean z16) {
        VideoReportInner.getInstance().setElementExposureAreaLimit(obj, z16);
    }

    public static void setElementExposureDetectionEnabled(View view, boolean z16) {
        VideoReportInner.getInstance().setElementExposureDetectionEnabled(view, z16);
    }

    public static void setElementExposureMinRate(Object obj, double d16) {
        VideoReportInner.getInstance().setElementExposureMinRate(obj, d16);
    }

    public static void setElementExposureMinTime(Object obj, long j3) {
        VideoReportInner.getInstance().setElementExposureMinTime(obj, j3);
    }

    public static void setElementId(Object obj, String str) {
        VideoReportInner.getInstance().setElementId(obj, str, true);
    }

    public static void setElementId2EventId2SampleRate(Map<String, Map<String, Float>> map) {
        VideoReportInner.getInstance().setElementId2EventId2SampleRate(map);
    }

    public static void setElementIdNotBizReady(Object obj, String str) {
        VideoReportInner.getInstance().setElementId(obj, str, false);
    }

    public static void setElementParam(Object obj, String str, Object obj2) {
        VideoReportInner.getInstance().setElementParam(obj, str, obj2);
    }

    public static void setElementParams(Object obj, Map<String, ?> map) {
        VideoReportInner.getInstance().setElementParams(obj, map);
    }

    public static void setElementReportBeforeClick(Object obj, boolean z16) {
        VideoReportInner.getInstance().setElementReportBeforeClick(obj, z16);
    }

    public static void setElementReportBeforeLongClick(Object obj, boolean z16) {
        VideoReportInner.getInstance().setElementReportBeforeLongClick(obj, z16);
    }

    @Deprecated
    public static void setElementReportPolicy(Object obj, ReportPolicy reportPolicy) {
        VideoReportInner.getInstance().setElementReportPolicy(obj, reportPolicy);
    }

    public static void setElementReuseIdentifier(Object obj, String str) {
        VideoReportInner.getInstance().setElementReuseIdentifier(obj, str);
    }

    public static void setElementSampleRate(Map<String, Float> map) {
        VideoReportInner.getInstance().setElementSampleRate(map);
    }

    public static void setElementScrollEndExposePolicy(Object obj, EndExposurePolicy endExposurePolicy) {
        VideoReportInner.getInstance().setElementScrollEndExposePolicy(obj, endExposurePolicy);
    }

    public static void setElementScrollExposePolicy(Object obj, ExposurePolicy exposurePolicy) {
        VideoReportInner.getInstance().setElementScrollExposePolicy(obj, exposurePolicy);
    }

    public static void setElementVirtualParentParams(Object obj, int i3, String str, Map<String, Object> map) {
        VideoReportInner.getInstance().setElementVirtualParentParams(obj, i3, str, map);
    }

    public static void setEventAdditionalReport(IAdditionalReportListener iAdditionalReportListener) {
        VideoReportInner.getInstance().setEventAdditionalReport(iAdditionalReportListener);
    }

    public static void setEventDynamicParams(Object obj, @Nullable IDynamicParams iDynamicParams) {
        VideoReportInner.getInstance().setEventDynamicParams(obj, iDynamicParams);
    }

    public static void setEventType(Object obj, EventAgingType eventAgingType) {
        VideoReportInner.getInstance().setEventType(obj, eventAgingType);
    }

    public static void setLogicParent(View view, View view2) {
        VideoReportInner.getInstance().setLogicParent(view, view2);
    }

    public static void setOnDTPlayInfoChangeListener(a aVar) {
        VideoReportManager.getInstance().setOnDTPlayInfoChangeListener(aVar);
    }

    public static void setPageBizReady(Object obj) {
        if (obj == null) {
            return;
        }
        VideoReportInner.getInstance().setPageBizReady(obj);
    }

    public static void setPageBodyContentRange(View view, int i3, int i16) {
        VideoReportInner.getInstance().setPageBodyContentRange(view, i3, i16);
    }

    public static void setPageContentId(Object obj, String str) {
        VideoReportInner.getInstance().setPageContentId(obj, str);
    }

    public static void setPageEventListener(Object obj, IPageEventListener iPageEventListener) {
        VideoReportInner.getInstance().setPageEventListener(obj, iPageEventListener);
    }

    public static void setPageId(Object obj, String str) {
        VideoReportInner.getInstance().setPageId(obj, str, true);
    }

    public static void setPageIdNotBizReady(Object obj, String str) {
        VideoReportInner.getInstance().setPageId(obj, str, false);
    }

    public static void setPageLinkEnable(Object obj, boolean z16) {
        VideoReportInner.getInstance().setPageLinkEnable(obj, z16);
    }

    public static void setPageParams(Object obj, PageParams pageParams) {
        VideoReportInner.getInstance().setPageParams(obj, pageParams);
    }

    public static void setPageParamsFormatter(IPageParamsFormatter iPageParamsFormatter) {
        VideoReportInner.getInstance().setPageParamsFormatter(iPageParamsFormatter);
    }

    public static void setPageReportPolicy(Object obj, PageReportPolicy pageReportPolicy) {
        VideoReportInner.getInstance().setPageReportPolicy(obj, pageReportPolicy);
    }

    public static void setPageSampleRate(Map<String, Float> map) {
        VideoReportInner.getInstance().setPageSampleRate(map);
    }

    public static void setPageSearchMode(Object obj, @PageSearchMode int i3) {
        VideoReportInner.getInstance().setPageSearchMode(obj, i3);
    }

    public static void setPublicParam(String str, Object obj) {
        VideoReportInner.getInstance().setPublicParam(str, obj);
    }

    @Deprecated
    public static void setVideoReportConfig(@NonNull DTConfig dTConfig) {
        VideoReportInner.getInstance().setVideoReportConfig(dTConfig);
    }

    public static void startNewSession(SessionChangeReason sessionChangeReason) {
        VideoReportInner.getInstance().startNewSession(sessionChangeReason);
    }

    public static void startWithComponent(Application application, IVideoReportComponent iVideoReportComponent) {
        VideoReportInner.getInstance().startWithComponent(application, iVideoReportComponent, ModuleInitPolicy.INIT_ALL);
    }

    public static void startWithConfiguration(Application application, Configuration configuration) {
        VideoReportInner.getInstance().startWithConfiguration(application, configuration, ModuleInitPolicy.INIT_ALL);
    }

    public static void supportAudioReport(boolean z16) {
        VideoReportInner.getInstance().supportAudioReport(z16);
    }

    public static void supportNewPlayType(boolean z16) {
        VideoReportInner.getInstance().supportNewPlayType(z16);
    }

    public static void supportPlayerReport(boolean z16) {
        VideoReportInner.getInstance().supportPlayerReport(z16);
    }

    public static void supportSeekReport(boolean z16) {
        VideoReportInner.getInstance().supportSeekReport(z16);
    }

    public static void supportSpeedRatioReport(boolean z16) {
        VideoReportInner.getInstance().supportSpeedRatioReport(z16);
    }

    public static void supportWebViewReport(boolean z16) {
        VideoReportInner.getInstance().supportWebViewReport(z16);
    }

    public static void traverseExposure() {
        VideoReportInner.getInstance().traverseExposure();
    }

    public static void traversePage(View view) {
        VideoReportInner.getInstance().traversePage(view);
    }

    public static void triggerClickInCurrentPage(Map<String, Object> map) {
        VideoReportInner.getInstance().triggerClickInCurrentPage(map);
    }

    public static void triggerEventInCurrentPage(String str, Map<String, Object> map) {
        VideoReportInner.getInstance().triggerEventInCurrentPage(str, map);
    }

    public static void triggerExposureInCurrentPage(List<Map<String, Object>> list) {
        VideoReportInner.getInstance().triggerExposureInCurrentPage(list);
    }

    public static void unbindVideoPlayerInfo(@NonNull Object obj) {
        VideoReportInner.getInstance().unbindVideoPlayerInfo(obj);
    }

    public static void updateAudioInfo(Object obj, @NonNull AudioEntity audioEntity, @Nullable Map<String, Object> map) {
        VideoReportInner.getInstance().updateAudioInfo(obj, audioEntity, map);
    }

    public static void updateConfiguration(Configuration configuration) {
        VideoReportInner.getInstance().updateConfiguration(configuration);
    }

    public static void updateVideoPlayerInfo(@NonNull Object obj, @NonNull VideoBaseEntity videoBaseEntity) {
        VideoReportInner.getInstance().updateVideoPlayerInfo(obj, videoBaseEntity);
    }

    @Nullable
    @Deprecated
    public static Map<String, Object> viewTreeParamsForView(View view) {
        return VideoReportInner.getInstance().viewTreeParamsForView("", view);
    }

    public static void addReporter(com.tencent.qqlive.module.videoreport.common.IReporter iReporter) {
        VideoReportInner.getInstance().addReporter(iReporter);
    }

    public static VideoReportPageInfo getPageInfo() {
        return VideoReportInner.getInstance().getPageInfo();
    }

    public static void markAsPageBodyView(View view, IScrollReader iScrollReader) {
        VideoReportInner.getInstance().markAsPageBodyView(view, iScrollReader);
    }

    @Nullable
    public static Map<String, Object> pageInfoForView(String str, View view) {
        return VideoReportInner.getInstance().pageInfoForView(str, view);
    }

    @Nullable
    public static Map<String, Object> paramsForView(String str, View view) {
        return VideoReportInner.getInstance().paramsForView(str, view);
    }

    public static void reportEvent(String str, Object obj, Map<String, ?> map) {
        VideoReportInner.getInstance().reportCustomEvent(EventData.builder().withSource(obj).withId(str).withParams(map != null ? new HashMap(map) : null).build());
        if (!VideoReportInner.getInstance().isDebugMode() || str == null) {
            return;
        }
        if (str.contains("pgin") || str.contains("pgout")) {
            Log.e(TAG, " pgin/pgout \u4e8b\u4ef6\u540e\u7eed\u5c06\u4e0d\u518d\u652f\u6301\u81ea\u5b9a\u4e49\u4e0a\u62a5\uff0c\u8bf7\u5207\u6362\u5230 pgin/pgout \u7684\u534a\u81ea\u52a8\u63a5\u53e3\u4e0a\u62a5 -> VideoReport.reportPgIn(Object page)VideoReport.reportPgOut(Object page)");
        }
    }

    public static void reportPgIn(Object obj, boolean z16) {
        VideoReportInner.getInstance().reportPgIn(obj, z16);
    }

    public static void setElementSampleRate(String str, float f16) {
        VideoReportInner.getInstance().setElementSampleRate(str, f16);
    }

    public static void setPageContentId(Object obj, String str, boolean z16) {
        VideoReportInner.getInstance().setPageContentId(obj, str, z16);
    }

    public static void setPageParams(Object obj, String str, Object obj2) {
        VideoReportInner.getInstance().setPageParams(obj, str, obj2);
    }

    public static void setPageSampleRate(String str, float f16) {
        VideoReportInner.getInstance().setPageSampleRate(str, f16);
    }

    public static void startWithComponent(Application application, IVideoReportComponent iVideoReportComponent, ModuleInitPolicy moduleInitPolicy) {
        VideoReportInner.getInstance().startWithComponent(application, iVideoReportComponent, moduleInitPolicy);
    }

    @Nullable
    public static Map<String, Object> viewTreeParamsForView(String str, View view) {
        return VideoReportInner.getInstance().viewTreeParamsForView(str, view);
    }

    public static void setElementSampleRate(String str, Map<String, Float> map) {
        VideoReportInner.getInstance().setElementSampleRate(str, map);
    }

    public static void reportEvent(EventData eventData) {
        VideoReportInner.getInstance().reportCustomEvent(eventData);
    }
}
