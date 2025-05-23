package com.tencent.qqlive.module.videoreport.inner;

import android.app.Activity;
import android.app.Application;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qqlive.module.videoreport.Configuration;
import com.tencent.qqlive.module.videoreport.DetectionMode;
import com.tencent.qqlive.module.videoreport.IAdditionalReportListener;
import com.tencent.qqlive.module.videoreport.IEventDynamicParams;
import com.tencent.qqlive.module.videoreport.IPageParamsFormatter;
import com.tencent.qqlive.module.videoreport.IPublicParamInterface;
import com.tencent.qqlive.module.videoreport.IReporter;
import com.tencent.qqlive.module.videoreport.ISessionChangeListener;
import com.tencent.qqlive.module.videoreport.IVideoReportComponent;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.SessionChangeReason;
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
import com.tencent.qqlive.module.videoreport.page.IPageEventListener;
import com.tencent.qqlive.module.videoreport.page.IScrollReader;
import com.tencent.qqlive.module.videoreport.page.PageInfo;
import com.tencent.qqlive.module.videoreport.page.VideoReportPageInfo;
import com.tencent.qqlive.module.videoreport.remoteconfig.RemoteConfig;
import com.tencent.qqlive.module.videoreport.utils.IDetectionInterceptor;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface IVideoReport {
    @Deprecated
    void addReporter(IReporter iReporter);

    void addReporter(com.tencent.qqlive.module.videoreport.common.IReporter iReporter);

    void addReporters(List<com.tencent.qqlive.module.videoreport.common.IReporter> list);

    void addToDetectionBlacklist(Activity activity);

    void addToDetectionWhitelist(Activity activity);

    void bindAudioPlayerInfo(Object obj, AudioEntity audioEntity);

    void bindRemoteConfig(RemoteConfig remoteConfig);

    void bindSampleConfig(String str);

    void bindSubmitTarget(View view, View view2);

    void bindVideoPlayerInfo(@NonNull Object obj, VideoEntity videoEntity);

    void clearElementExposure(View view, boolean z16);

    void clearPublicParams();

    void doAppOutReport();

    void enableAndroidXRVExposure(RecyclerView recyclerView);

    void enableScrollExposureReport(Object obj, boolean z16);

    PageInfo findOwnerPage(View view);

    ClickPolicy getElementClickPolicy(Object obj);

    EndExposurePolicy getElementEndExposePolicy(Object obj);

    ExposurePolicy getElementExposePolicy(Object obj);

    Map<String, ?> getElementParams(Object obj);

    @Deprecated
    ReportPolicy getElementReportPolicy(Object obj);

    EndExposurePolicy getElementScrollEndExposePolicy(Object obj);

    ExposurePolicy getElementScrollExposePolicy(Object obj);

    PageInfo getPageInfo(View view);

    VideoReportPageInfo getPageInfo();

    PageReportPolicy getPageReportPolicy(Object obj);

    @PageSearchMode
    Integer getPageSearchMode(Object obj);

    @NonNull
    IPublicParamInterface getPublicParamInterface();

    void ignorePageInOutEvent(Object obj, boolean z16);

    boolean isDebugMode();

    void markAsPageBodyView(View view);

    void markAsPageBodyView(View view, IScrollReader iScrollReader);

    void notifyViewDetach(View view, View view2);

    void onActivityPreResume(Activity activity);

    void onActivityPreStarted(Activity activity);

    @Nullable
    Map<String, Object> pageInfoForView(String str, View view);

    void pageLogicDestroy(Object obj);

    @Nullable
    Map<String, Object> paramsForView(String str, View view);

    void registerEventDynamicParams(IEventDynamicParams iEventDynamicParams);

    void registerSessionChangeListener(ISessionChangeListener iSessionChangeListener);

    @Deprecated
    void removeAllElementParams(Object obj);

    void removeAllPageParams(Object obj);

    void removeElementParam(Object obj, String str);

    void removePageParam(Object obj, String str);

    void removePublicParam(String str);

    void reportCustomEvent(EventData eventData);

    boolean reportEvent(EventData eventData);

    boolean reportEvent(String str, Object obj, Map<String, ?> map);

    boolean reportEvent(String str, Map<String, ?> map);

    boolean reportEventWithoutFormat(String str, Map<String, Object> map, String str2);

    void reportPgIn(Object obj);

    void reportPgIn(Object obj, boolean z16);

    void reportPgOut(Object obj);

    void reportStdEvent(StdEventCode stdEventCode, IEventParamsBuilder iEventParamsBuilder);

    void reportUserPrivacy(String str, Map<String, String> map);

    void resetElementParams(Object obj);

    void resetPageParams(Object obj);

    void resetPageStats();

    void setAudioTimerListener(Object obj, IAudioTimerListener iAudioTimerListener);

    void setClickReportInterval(View view, long j3);

    void setCollectProcessName(boolean z16);

    void setDataCollectEnable(boolean z16);

    void setDebugMode(boolean z16);

    void setDetectionInterceptor(IDetectionInterceptor iDetectionInterceptor);

    void setDetectionMode(@DetectionMode int i3);

    void setElementClickPolicy(Object obj, ClickPolicy clickPolicy);

    @Deprecated
    void setElementDynamicParams(Object obj, IElementDynamicParams iElementDynamicParams);

    void setElementEndExposePolicy(Object obj, EndExposurePolicy endExposurePolicy);

    void setElementExposePolicy(Object obj, ExposurePolicy exposurePolicy);

    void setElementExposureAreaLimit(Object obj, boolean z16);

    void setElementExposureDetectionEnabled(Object obj, boolean z16);

    void setElementExposureMinRate(Object obj, double d16);

    void setElementExposureMinTime(Object obj, long j3);

    void setElementId(Object obj, String str, boolean z16);

    void setElementParam(Object obj, String str, Object obj2);

    void setElementParams(Object obj, Map<String, ?> map);

    void setElementReportBeforeClick(Object obj, boolean z16);

    void setElementReportBeforeLongClick(Object obj, boolean z16);

    @Deprecated
    void setElementReportPolicy(Object obj, ReportPolicy reportPolicy);

    void setElementReuseIdentifier(Object obj, String str);

    void setElementScrollEndExposePolicy(Object obj, EndExposurePolicy endExposurePolicy);

    void setElementScrollExposePolicy(Object obj, ExposurePolicy exposurePolicy);

    void setElementVirtualParentParams(Object obj, int i3, String str, Map<String, Object> map);

    void setEventAdditionalReport(IAdditionalReportListener iAdditionalReportListener);

    void setEventDynamicParams(Object obj, @Nullable IDynamicParams iDynamicParams);

    void setEventType(Object obj, EventAgingType eventAgingType);

    void setLogicParent(View view, View view2);

    void setPageBodyContentRange(View view, int i3, int i16);

    void setPageContentId(Object obj, String str);

    void setPageContentId(Object obj, String str, boolean z16);

    void setPageEventListener(Object obj, IPageEventListener iPageEventListener);

    void setPageId(Object obj, String str, boolean z16);

    void setPageLinkEnable(Object obj, boolean z16);

    void setPageParams(Object obj, PageParams pageParams);

    void setPageParams(Object obj, String str, Object obj2);

    void setPageParamsFormatter(IPageParamsFormatter iPageParamsFormatter);

    void setPageReportPolicy(Object obj, PageReportPolicy pageReportPolicy);

    void setPageSearchMode(Object obj, @PageSearchMode int i3);

    void setPublicParam(String str, Object obj);

    void setTestMode(boolean z16);

    @Deprecated
    void setVideoReportConfig(@NonNull DTConfig dTConfig);

    void startNewSession(SessionChangeReason sessionChangeReason);

    void startWithComponent(Application application, IVideoReportComponent iVideoReportComponent, ModuleInitPolicy moduleInitPolicy);

    void startWithConfiguration(Application application, Configuration configuration, ModuleInitPolicy moduleInitPolicy);

    void supportAudioReport(boolean z16);

    void supportNewPlayType(boolean z16);

    void supportPlayerReport(boolean z16);

    void supportSeekReport(boolean z16);

    void supportSpeedRatioReport(boolean z16);

    void supportWebViewReport(boolean z16);

    void traverseExposure();

    void traversePage(View view);

    void triggerClickInCurrentPage(Map<String, Object> map);

    void triggerEventInCurrentPage(String str, Map<String, Object> map);

    void triggerExposureInCurrentPage(List<Map<String, Object>> list);

    void unbindVideoPlayerInfo(@NonNull Object obj);

    void updateAudioInfo(Object obj, @NonNull AudioEntity audioEntity, Map<String, Object> map);

    void updateVideoPlayerInfo(@NonNull Object obj, @NonNull VideoBaseEntity videoBaseEntity);

    @Nullable
    Map<String, Object> viewTreeParamsForView(String str, View view);
}
