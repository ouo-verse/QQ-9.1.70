package com.tencent.qqlive.module.videoreport.report.element;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.InnerKey;
import com.tencent.qqlive.module.videoreport.data.DataBinder;
import com.tencent.qqlive.module.videoreport.data.DataEntity;
import com.tencent.qqlive.module.videoreport.data.DataEntityOperator;
import com.tencent.qqlive.module.videoreport.data.DataRWProxy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.page.PageFinder;
import com.tencent.qqlive.module.videoreport.page.PageInfo;
import com.tencent.qqlive.module.videoreport.reportdata.PathDataUtils;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ReportHelper {
    private static final String TAG = "element.ReportHelper";

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public enum ExposureReason {
        CAN_REPORT(true, "can report"),
        EMPTY_ELEMENT_ID(false, "empty element id"),
        REPORT_NONE(false, "exposure policy is REPORT_NONE"),
        HAVE_REPORTED(false, "exposure policy is REPORT_FIRST and have reported"),
        UNKNOWN(false, "unknown");

        public final boolean canReport;
        public final String message;

        ExposureReason(boolean z16, String str) {
            this.canReport = z16;
            this.message = str;
        }
    }

    public static boolean allPageReportEnabled(PageInfo pageInfo) {
        View pageView;
        if (pageInfo == null || (pageView = pageInfo.getPageView()) == null) {
            return false;
        }
        Object innerParam = DataRWProxy.getInnerParam(pageView, InnerKey.PAGE_COLLECT_ALL_ENABLE);
        if (!(innerParam instanceof Boolean) || !((Boolean) innerParam).booleanValue()) {
            return false;
        }
        return true;
    }

    public static boolean allowReportClick(@Nullable DataEntity dataEntity) {
        if (emptyElementId(dataEntity)) {
            if (VideoReportInner.getInstance().isDebugMode()) {
                Log.d(TAG, "allowReportClick: empty elementId " + dataEntity);
            }
            return false;
        }
        if (getClickPolicy(dataEntity) != ClickPolicy.REPORT_ALL) {
            if (VideoReportInner.getInstance().isDebugMode()) {
                Log.d(TAG, "allowReportClick: policy not allow " + dataEntity);
            }
            return false;
        }
        return true;
    }

    public static boolean androidXRVExposureEnabled(View view) {
        Object extendParam = DataRWProxy.getExtendParam(view, DTConstants.DTExtendMapKey.ENABLE_ANDROID_RV_EXPOSURE, Boolean.FALSE);
        if (extendParam instanceof Boolean) {
            return ((Boolean) extendParam).booleanValue();
        }
        return false;
    }

    public static ExposureReason checkExposureReason(Object obj, String str, View view) {
        return checkExposureReason(obj, str, view, false);
    }

    private static boolean emptyElementId(@Nullable DataEntity dataEntity) {
        if (dataEntity != null && !TextUtils.isEmpty(DataEntityOperator.getElementId(dataEntity))) {
            return false;
        }
        return true;
    }

    private static View findLogicParent(DataEntity dataEntity) {
        WeakReference weakReference;
        if (dataEntity == null || (weakReference = (WeakReference) DataEntityOperator.getInnerParam(dataEntity, InnerKey.LOGIC_PARENT)) == null) {
            return null;
        }
        return (View) weakReference.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static View findParent(View view, DataEntity dataEntity) {
        View findLogicParent = findLogicParent(dataEntity);
        if (findLogicParent != null) {
            return findLogicParent;
        }
        Object parent = view.getParent();
        if (parent instanceof View) {
            return (View) parent;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static View findPathParent(View view, DataEntity dataEntity) {
        do {
            view = findParent(view, dataEntity);
            if (view == null) {
                return null;
            }
            dataEntity = DataBinder.getDataEntity(view);
            if (PathDataUtils.canCollect(dataEntity)) {
                return view;
            }
        } while (PageFinder.findRelatedPage(view) == null);
        return view;
    }

    @NonNull
    public static ClickPolicy getClickPolicy(DataEntity dataEntity) {
        ClickPolicy clickPolicy = (ClickPolicy) DataEntityOperator.getInnerParam(dataEntity, InnerKey.ELEMENT_CLICK_POLICY);
        if (clickPolicy == null) {
            return VideoReportInner.getInstance().getConfiguration().getElementClickPolicy();
        }
        return clickPolicy;
    }

    private static double getElementExposureMinRate(@Nullable DataEntity dataEntity) {
        double elementExposureMinRate = VideoReportInner.getInstance().getConfiguration().getElementExposureMinRate();
        if (dataEntity == null) {
            return elementExposureMinRate;
        }
        Double d16 = (Double) DataEntityOperator.getInnerParam(dataEntity, InnerKey.ELEMENT_EXPOSURE_MIN_RATE);
        if (d16 != null) {
            return d16.doubleValue();
        }
        return elementExposureMinRate;
    }

    @NonNull
    public static EndExposurePolicy getEndExposePolicy(DataEntity dataEntity) {
        EndExposurePolicy endExposurePolicy = (EndExposurePolicy) DataEntityOperator.getInnerParam(dataEntity, InnerKey.ELEMENT_END_EXPOSE_POLICY);
        if (endExposurePolicy == null) {
            return VideoReportInner.getInstance().getConfiguration().getElementEndExposePolicy();
        }
        return endExposurePolicy;
    }

    @NonNull
    public static ExposurePolicy getExposePolicy(DataEntity dataEntity) {
        ExposurePolicy exposurePolicy = (ExposurePolicy) DataEntityOperator.getInnerParam(dataEntity, InnerKey.ELEMENT_EXPOSE_POLICY);
        if (exposurePolicy == null) {
            return VideoReportInner.getInstance().getConfiguration().getElementExposePolicy();
        }
        return exposurePolicy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long getExposureMinTime(@Nullable DataEntity dataEntity) {
        long elementExposureMinTime = VideoReportInner.getInstance().getConfiguration().getElementExposureMinTime();
        if (dataEntity == null) {
            return elementExposureMinTime;
        }
        Long l3 = (Long) DataEntityOperator.getInnerParam(dataEntity, InnerKey.ELEMENT_EXPOSURE_MIN_TIME);
        if (l3 != null) {
            return l3.longValue();
        }
        return elementExposureMinTime;
    }

    @NonNull
    public static EndExposurePolicy getScrollEndExposePolicy(DataEntity dataEntity) {
        EndExposurePolicy endExposurePolicy = (EndExposurePolicy) DataEntityOperator.getInnerParam(dataEntity, InnerKey.ELEMENT_SCROLL_END_EXPOSE_POLICY);
        if (endExposurePolicy == null) {
            return VideoReportInner.getInstance().getConfiguration().getElementScrollEndExposePolicy();
        }
        return endExposurePolicy;
    }

    @NonNull
    public static ExposurePolicy getScrollExposePolicy(DataEntity dataEntity) {
        ExposurePolicy exposurePolicy = (ExposurePolicy) DataEntityOperator.getInnerParam(dataEntity, InnerKey.ELEMENT_SCROLL_EXPOSE_POLICY);
        if (exposurePolicy == null) {
            return VideoReportInner.getInstance().getConfiguration().getElementScrollExposePolicy();
        }
        return exposurePolicy;
    }

    private static ExposureReason handleReportFirstPolicy(Object obj, String str, View view, boolean z16) {
        EleExposeInfo eleExposeInfo = ExposurePolicyHelper.getEleExposeInfo(obj, view, str, z16);
        if (eleExposeInfo == null) {
            return ExposureReason.CAN_REPORT;
        }
        if (!eleExposeInfo.hasReport()) {
            return ExposureReason.CAN_REPORT;
        }
        if (eleExposeInfo.reportOverTime()) {
            return ExposureReason.CAN_REPORT;
        }
        return ExposureReason.HAVE_REPORTED;
    }

    public static boolean isEnablePageLink(Object obj) {
        Object innerParam = DataRWProxy.getInnerParam(obj, InnerKey.PAGE_LINK_ENABLE);
        if (innerParam == null) {
            return VideoReportInner.getInstance().getConfiguration().isEnablePageLink();
        }
        if ((innerParam instanceof Boolean) && ((Boolean) innerParam).booleanValue()) {
            return true;
        }
        return false;
    }

    public static boolean isEventReportEnable(int i3) {
        if ((VideoReportInner.getInstance().getConfiguration().getAudioEventPolicy() & i3) == i3) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isViewExposed(View view, double d16) {
        if (view == null) {
            return false;
        }
        double elementExposureMinRate = getElementExposureMinRate(DataBinder.getDataEntity(view));
        if (d16 <= 0.0d || d16 < elementExposureMinRate) {
            return false;
        }
        return true;
    }

    public static boolean needReportClick(Object obj, DTConstants.ClickEventSource clickEventSource) {
        Object extendParam = DataRWProxy.getExtendParam(obj, DTConstants.DTExtendMapKey.VIEW_REPORT_BEFORE_CLICK);
        if (extendParam == null) {
            extendParam = VideoReportInner.getInstance().getConfiguration().getElementClickSource();
        }
        if (extendParam != clickEventSource) {
            if (VideoReportInner.getInstance().isDebugMode()) {
                Log.d(TAG, "needReportClick: source skip " + clickEventSource);
                return false;
            }
            return false;
        }
        return true;
    }

    public static boolean needReportLongClick(Object obj, DTConstants.ClickEventSource clickEventSource) {
        Object extendParam = DataRWProxy.getExtendParam(obj, DTConstants.DTExtendMapKey.VIEW_REPORT_BEFORE_LONG_CLICK);
        if (extendParam == null) {
            extendParam = VideoReportInner.getInstance().getConfiguration().getElementLongClickSource();
        }
        if (extendParam != clickEventSource) {
            if (VideoReportInner.getInstance().isDebugMode()) {
                Log.d(TAG, "needReportLongClick: source skip " + clickEventSource);
                return false;
            }
            return false;
        }
        return true;
    }

    public static boolean reportEndExposure(@Nullable View view, boolean z16) {
        EndExposurePolicy endExposePolicy;
        DataEntity dataEntity = DataBinder.getDataEntity(view);
        if (emptyElementId(dataEntity)) {
            return false;
        }
        if (z16) {
            endExposePolicy = getScrollEndExposePolicy(dataEntity);
        } else {
            endExposePolicy = getEndExposePolicy(dataEntity);
        }
        if (EndExposurePolicy.REPORT_ALL != endExposePolicy) {
            return false;
        }
        return true;
    }

    public static boolean reportExposure(Object obj, String str, View view) {
        return reportExposure(obj, str, view, false);
    }

    private static ExposureReason checkExposureReason(Object obj, String str, View view, boolean z16) {
        ExposurePolicy exposePolicy;
        DataEntity dataEntity = DataBinder.getDataEntity(view);
        if (emptyElementId(dataEntity)) {
            return ExposureReason.EMPTY_ELEMENT_ID;
        }
        if (z16) {
            exposePolicy = getScrollExposePolicy(dataEntity);
        } else {
            exposePolicy = getExposePolicy(dataEntity);
        }
        if (exposePolicy == ExposurePolicy.REPORT_NONE) {
            return ExposureReason.REPORT_NONE;
        }
        if (exposePolicy == ExposurePolicy.REPORT_ALL) {
            return ExposureReason.CAN_REPORT;
        }
        if (exposePolicy == ExposurePolicy.REPORT_FIRST) {
            return handleReportFirstPolicy(obj, str, view, z16);
        }
        return ExposureReason.UNKNOWN;
    }

    public static boolean reportExposure(Object obj, String str, View view, boolean z16) {
        ExposureReason checkExposureReason = checkExposureReason(obj, str, view, z16);
        return checkExposureReason != null && checkExposureReason.canReport;
    }
}
