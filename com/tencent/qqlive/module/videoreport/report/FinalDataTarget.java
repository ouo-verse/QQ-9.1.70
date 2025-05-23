package com.tencent.qqlive.module.videoreport.report;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qqlive.module.videoreport.IBizDataProcessor;
import com.tencent.qqlive.module.videoreport.common.EventAgingType;
import com.tencent.qqlive.module.videoreport.common.IReporter;
import com.tencent.qqlive.module.videoreport.common.ReportEvent;
import com.tencent.qqlive.module.videoreport.dtreport.reportchannel.DTAppKeyExtractor;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.reportdata.FinalData;
import com.tencent.qqlive.module.videoreport.sample.SampleInfoManager;
import com.tencent.qqlive.module.videoreport.staging.EventStashManager;
import com.tencent.qqlive.module.videoreport.task.ThreadUtils;
import com.tencent.qqlive.module.videoreport.utils.BaseUtils;
import com.tencent.qqlive.module.videoreport.utils.IFormatter;
import com.tencent.qqlive.module.videoreport.utils.ListenerMgr;
import com.tencent.qqlive.module.videoreport.utils.reuse.ReusablePool;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class FinalDataTarget {
    private static ListenerMgr<IFinalDataHandleListener> sListenerMgr = new ListenerMgr<>();
    private static ThreadLocal<NotifyCallbackImpl> sNotifyCallbacks = new ThreadLocal<NotifyCallbackImpl>() { // from class: com.tencent.qqlive.module.videoreport.report.FinalDataTarget.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public NotifyCallbackImpl initialValue() {
            return new NotifyCallbackImpl();
        }
    };

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface IFinalDataHandleListener {
        void onHandleFinalData(Object obj, @NonNull FinalData finalData, @NonNull Map<String, Object> map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class NotifyCallbackImpl implements ListenerMgr.INotifyCallback<IFinalDataHandleListener> {
        Object mEventObj;
        FinalData mFinalData;
        Map<String, Object> mInnerPublicParams;

        NotifyCallbackImpl() {
        }

        public void reset() {
            this.mEventObj = null;
            this.mFinalData = null;
            this.mInnerPublicParams = null;
        }

        void setNotifyData(Object obj, FinalData finalData, Map<String, Object> map) {
            this.mEventObj = obj;
            this.mFinalData = finalData;
            this.mInnerPublicParams = map;
        }

        @Override // com.tencent.qqlive.module.videoreport.utils.ListenerMgr.INotifyCallback
        public void onNotify(IFinalDataHandleListener iFinalDataHandleListener) {
            iFinalDataHandleListener.onHandleFinalData(this.mEventObj, this.mFinalData, this.mInnerPublicParams);
        }
    }

    @NonNull
    private static ReportEvent getReportEvent(Object obj, String str, EventAgingType eventAgingType, Map<String, Object> map, String str2) {
        EventAgingType eventAgingType2;
        String transformEvent = DTReportHelper.transformEvent(str);
        Map<String, String> paramsMap = DTReportHelper.getParamsMap(map);
        if (DTReportHelper.shouldReportImmediately(transformEvent)) {
            eventAgingType2 = EventAgingType.REALTIME;
        } else {
            eventAgingType2 = EventAgingType.NORMAL;
        }
        EventAgingType eventAgingType3 = (EventAgingType) BaseUtils.nullAs(eventAgingType, eventAgingType2);
        return ReportEvent.builder().withSource(obj).withKey(transformEvent).withParams(paramsMap).withRawParams(map).withAppKey(str2).withType(eventAgingType3).withSampleHit(SampleInfoManager.getInstance().isSampleHit(obj, str)).build();
    }

    public static void handle(Object obj, @Nullable FinalData finalData) {
        innerHandler(obj, finalData, false, false);
    }

    public static void handleInMainThread(Object obj, @Nullable FinalData finalData) {
        innerHandler(obj, finalData, true, false);
    }

    public static void handleWithStash(Object obj, @Nullable FinalData finalData) {
        innerHandler(obj, finalData, false, true);
    }

    public static void handleWithoutFormat(final Object obj, @Nullable final FinalData finalData, final String str) {
        if (finalData == null) {
            return;
        }
        final HashMap hashMap = new HashMap();
        PublicParamImpl.getInstance().addRealtimeExternalParams(hashMap);
        PublicParamImpl.getInstance().addRealtimeInnerParam(hashMap);
        final boolean isSampleHit = SampleInfoManager.getInstance().isSampleHit(obj, finalData.eventKey);
        ThreadUtils.execTask(new Runnable() { // from class: com.tencent.qqlive.module.videoreport.report.FinalDataTarget.2
            @Override // java.lang.Runnable
            public void run() {
                PublicParamImpl.getInstance().addNonRealtimeInnerParam(hashMap);
                PublicParamImpl.getInstance().addNonRealtimeExternalParams(hashMap);
                PublicParamImpl.getInstance().addVisualDebugInnerParam(obj, hashMap);
                if (isSampleHit) {
                    PublicParamImpl.getInstance().addStatisticsInnerParam(str, finalData.eventKey, hashMap);
                }
                HashMap hashMap2 = new HashMap();
                Map<String, Object> map = finalData.eventParams;
                if (map != null) {
                    hashMap2.putAll(map);
                }
                hashMap2.putAll(hashMap);
                if (!VideoReportInner.getInstance().isReportEnable()) {
                    FinalDataTarget.recycleObject(finalData);
                    return;
                }
                Object obj2 = obj;
                FinalData finalData2 = finalData;
                FinalDataTarget.reportEvent(obj2, finalData2.eventKey, finalData2.eventType, hashMap2, str);
                FinalDataTarget.recycleObject(finalData);
            }
        }, false);
    }

    private static void innerHandler(final Object obj, @Nullable final FinalData finalData, boolean z16, final boolean z17) {
        if (finalData == null) {
            return;
        }
        final HashMap hashMap = new HashMap();
        PublicParamImpl.getInstance().addRealtimeExternalParams(hashMap);
        PublicParamImpl.getInstance().addRealtimeInnerParam(hashMap);
        notifyListener(obj, finalData, hashMap);
        final boolean isSampleHit = SampleInfoManager.getInstance().isSampleHit(obj, finalData.eventKey);
        ThreadUtils.execTask(new Runnable() { // from class: com.tencent.qqlive.module.videoreport.report.FinalDataTarget.3
            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap2;
                PublicParamImpl.getInstance().addNonRealtimeInnerParam(hashMap);
                PublicParamImpl.getInstance().addNonRealtimeExternalParams(hashMap);
                PublicParamImpl.getInstance().addVisualDebugInnerParam(obj, hashMap);
                FinalDataTarget.processBizParams(finalData, hashMap);
                IFormatter formatter = VideoReportInner.getInstance().getConfiguration().getFormatter();
                FinalData finalData2 = finalData;
                String str = finalData2.eventKey;
                Map<String, Object> map = hashMap;
                if (finalData2.eventParams == null) {
                    hashMap2 = null;
                } else {
                    hashMap2 = new HashMap(finalData.eventParams);
                }
                Map<String, Object> formatEvent = formatter.formatEvent(str, map, hashMap2);
                String appKey = DTAppKeyExtractor.getAppKey(finalData.eventKey, formatEvent);
                if (!z17 && isSampleHit) {
                    PublicParamImpl.getInstance().addStatisticsInnerParam(appKey, finalData.eventKey, formatEvent);
                }
                if (!VideoReportInner.getInstance().isReportEnable()) {
                    FinalDataTarget.recycleObject(finalData);
                    return;
                }
                if (z17) {
                    FinalDataTarget.stashEvent(finalData.eventKey, formatEvent, appKey);
                } else {
                    Object obj2 = obj;
                    FinalData finalData3 = finalData;
                    FinalDataTarget.reportEvent(obj2, finalData3.eventKey, finalData3.eventType, formatEvent, appKey);
                }
                FinalDataTarget.recycleObject(finalData);
            }
        }, z16);
    }

    private static void notifyListener(Object obj, @NonNull FinalData finalData, @NonNull Map<String, Object> map) {
        NotifyCallbackImpl notifyCallbackImpl = sNotifyCallbacks.get();
        notifyCallbackImpl.setNotifyData(obj, finalData, map);
        sListenerMgr.startNotify(notifyCallbackImpl);
        notifyCallbackImpl.reset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void processBizParams(FinalData finalData, Map<String, Object> map) {
        IBizDataProcessor bizDataProcessor = VideoReportInner.getInstance().getConfiguration().getBizDataProcessor();
        if (bizDataProcessor != null) {
            try {
                Map<String, Object> process = bizDataProcessor.process(finalData.eventKey, Collections.unmodifiableMap(finalData.eventParams), Collections.unmodifiableMap(map));
                if (process != null) {
                    finalData.putAll(process);
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void recycleObject(@NonNull FinalData finalData) {
        ReusablePool.recycle(finalData);
    }

    public static void registerListener(IFinalDataHandleListener iFinalDataHandleListener) {
        sListenerMgr.register(iFinalDataHandleListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void reportEvent(Object obj, String str, EventAgingType eventAgingType, Map<String, Object> map, String str2) {
        ReportEvent reportEvent = getReportEvent(obj, str, eventAgingType, map, str2);
        VideoReportInner.getInstance().sampler().sample(reportEvent);
        for (IReporter iReporter : VideoReportInner.getInstance().getReporter()) {
            if (iReporter != null) {
                iReporter.report(reportEvent);
            }
        }
        EventStashManager.getInstance().cancelStashEvent(str, map);
    }

    public static void reportStashEvent(Object obj, String str, Map<String, Object> map, String str2) {
        if (SampleInfoManager.getInstance().isSampleHit(obj, str)) {
            PublicParamImpl.getInstance().addStatisticsInnerParam(str2, str, map);
        }
        reportEvent(obj, str, null, map, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void stashEvent(String str, Map<String, Object> map, String str2) {
        EventStashManager.getInstance().stashEvent(str, map, str2);
    }
}
