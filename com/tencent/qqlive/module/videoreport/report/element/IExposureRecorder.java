package com.tencent.qqlive.module.videoreport.report.element;

import android.view.View;
import com.tencent.qqlive.module.videoreport.exposure.AreaInfo;
import com.tencent.qqlive.module.videoreport.reportdata.DataBuilderFactory;
import com.tencent.qqlive.module.videoreport.reportdata.FinalData;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface IExposureRecorder {

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class ExposureInfoWrapper {
        AreaInfo areaInfo;
        final WeakReference<Object> attachedPage;
        final boolean canReportExposureEnd;
        final long exposureTime;
        final WeakReference<View> exposureView;
        FinalData finalData;
        final long uniqueId;

        public ExposureInfoWrapper(ExposureElementInfo exposureElementInfo, long j3) {
            this.exposureTime = j3;
            this.uniqueId = exposureElementInfo.getUniqueId();
            this.exposureView = new WeakReference<>(exposureElementInfo.getView());
            this.attachedPage = new WeakReference<>(exposureElementInfo.getPage());
            this.canReportExposureEnd = ReportHelper.reportEndExposure(exposureElementInfo.getView(), false);
            this.finalData = DataBuilderFactory.obtain().build("imp_end", exposureElementInfo.getPathData());
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class Factory {
        public static IExposureRecorder getInstance() {
            return ExposureRecorderImpl.getInstance();
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface OnExposureStatusListener {
        void onViewUnexposed(ExposureInfoWrapper exposureInfoWrapper, long j3);
    }

    void clearExposure();

    Map<Long, ExposureInfoWrapper> getExposedRecords();

    boolean isExposed(long j3);

    void markExposed(ExposureElementInfo exposureElementInfo);

    void markUnexposed(long j3);

    void markUnexposed(Collection<Long> collection);

    void registerOnExposureStatusListener(OnExposureStatusListener onExposureStatusListener);

    void updateAreaInfo(long j3, AreaInfo areaInfo);
}
