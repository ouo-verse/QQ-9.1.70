package com.tencent.qqlive.module.videoreport.report.element;

import android.os.SystemClock;
import android.view.View;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.constants.InnerKey;
import com.tencent.qqlive.module.videoreport.data.DataRWProxy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqlive.module.videoreport.exposure.AreaInfo;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.report.element.IExposureRecorder;
import com.tencent.qqlive.module.videoreport.utils.ListenerMgr;
import com.tencent.qqlive.module.videoreport.utils.ReportUtils;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes22.dex */
public class ExposureRecorderImpl implements IExposureRecorder {
    private static final String TAG = "ExposureRecorderImpl";
    private final Map<Long, IExposureRecorder.ExposureInfoWrapper> mExposedId;
    private ListenerMgr<IExposureRecorder.OnExposureStatusListener> mListenerMgr;
    private final Map<Long, IExposureRecorder.ExposureInfoWrapper> mUnmodifiableExposedId;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class InstanceHolder {
        private static final ExposureRecorderImpl INSTANCE = new ExposureRecorderImpl();

        InstanceHolder() {
        }
    }

    public static ExposureRecorderImpl getInstance() {
        return InstanceHolder.INSTANCE;
    }

    private void removeRecords(long j3) {
        final IExposureRecorder.ExposureInfoWrapper remove = this.mExposedId.remove(Long.valueOf(j3));
        if (remove == null) {
            return;
        }
        final long elapsedRealtime = SystemClock.elapsedRealtime() - remove.exposureTime;
        this.mListenerMgr.startNotify(new ListenerMgr.INotifyCallback<IExposureRecorder.OnExposureStatusListener>() { // from class: com.tencent.qqlive.module.videoreport.report.element.ExposureRecorderImpl.1
            @Override // com.tencent.qqlive.module.videoreport.utils.ListenerMgr.INotifyCallback
            public void onNotify(IExposureRecorder.OnExposureStatusListener onExposureStatusListener) {
                onExposureStatusListener.onViewUnexposed(remove, elapsedRealtime);
            }
        });
    }

    @Override // com.tencent.qqlive.module.videoreport.report.element.IExposureRecorder
    public void clearExposure() {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.d(TAG, "clearExposure: ");
        }
        markUnexposed(new HashSet(this.mExposedId.keySet()));
    }

    @Override // com.tencent.qqlive.module.videoreport.report.element.IExposureRecorder
    public Map<Long, IExposureRecorder.ExposureInfoWrapper> getExposedRecords() {
        return this.mUnmodifiableExposedId;
    }

    @Override // com.tencent.qqlive.module.videoreport.report.element.IExposureRecorder
    public boolean isExposed(long j3) {
        return this.mExposedId.containsKey(Long.valueOf(j3));
    }

    @Override // com.tencent.qqlive.module.videoreport.report.element.IExposureRecorder
    public void markExposed(ExposureElementInfo exposureElementInfo) {
        View view;
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.d(TAG, "markExposed: exposureElementInfo = " + exposureElementInfo);
        }
        if (exposureElementInfo == null || (view = exposureElementInfo.getView()) == null) {
            return;
        }
        long calcElementUniqueId = ReportUtils.calcElementUniqueId(view);
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.d(TAG, "markExposed: identifier = " + DataRWProxy.getInnerParam(view, InnerKey.ELEMENT_IDENTIFIER) + "\uff0c uniqueId = " + calcElementUniqueId);
        }
        this.mExposedId.put(Long.valueOf(calcElementUniqueId), new IExposureRecorder.ExposureInfoWrapper(exposureElementInfo, SystemClock.elapsedRealtime()));
    }

    @Override // com.tencent.qqlive.module.videoreport.report.element.IExposureRecorder
    public void markUnexposed(long j3) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.d(TAG, "markUnexposed: target = " + j3);
        }
        removeRecords(j3);
    }

    @Override // com.tencent.qqlive.module.videoreport.report.element.IExposureRecorder
    public void registerOnExposureStatusListener(IExposureRecorder.OnExposureStatusListener onExposureStatusListener) {
        this.mListenerMgr.register(onExposureStatusListener);
    }

    @Override // com.tencent.qqlive.module.videoreport.report.element.IExposureRecorder
    public void updateAreaInfo(long j3, AreaInfo areaInfo) {
        boolean z16;
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.d(TAG, "updateAreaInfo: uniqueId = " + j3 + ", areaInfo = " + areaInfo);
        }
        IExposureRecorder.ExposureInfoWrapper exposureInfoWrapper = this.mExposedId.get(Long.valueOf(j3));
        if (exposureInfoWrapper == null) {
            return;
        }
        if (exposureInfoWrapper.exposureView.get() != null) {
            z16 = ((Boolean) DataRWProxy.getExtendParam(exposureInfoWrapper.exposureView.get(), DTConstants.DTExtendMapKey.VIEW_EXPOSURE_AREA_LIMIT, Boolean.TRUE)).booleanValue();
        } else {
            z16 = true;
        }
        AreaInfo areaInfo2 = exposureInfoWrapper.areaInfo;
        if (z16 && areaInfo2 != null && areaInfo2.exposureRate > areaInfo.exposureRate) {
            return;
        }
        exposureInfoWrapper.areaInfo = areaInfo;
    }

    ExposureRecorderImpl() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.mExposedId = concurrentHashMap;
        this.mUnmodifiableExposedId = Collections.unmodifiableMap(concurrentHashMap);
        this.mListenerMgr = new ListenerMgr<>();
    }

    @Override // com.tencent.qqlive.module.videoreport.report.element.IExposureRecorder
    public void markUnexposed(Collection<Long> collection) {
        if (collection != null) {
            for (Long l3 : collection) {
                if (l3 != null) {
                    removeRecords(l3.longValue());
                }
            }
        }
    }
}
