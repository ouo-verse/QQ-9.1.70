package com.tencent.biz.qqcircle.immersive.utils;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudCommon$BytesEntry;
import feedcloud.FeedCloudCommon$StCommonExt;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class an {

    /* renamed from: a, reason: collision with root package name */
    private static String f90130a = "";

    /* renamed from: b, reason: collision with root package name */
    private static String f90131b = "";

    public static int a(QCircleInitBean qCircleInitBean, int i3) {
        if (d(qCircleInitBean)) {
            return 505;
        }
        return i3;
    }

    public static String b(QCircleInitBean qCircleInitBean, String str) {
        if (d(qCircleInitBean)) {
            return QCircleDaTongConstant.PageId.PG_XSJ_EXPLORE_TAB_PAGE;
        }
        return str;
    }

    private static boolean c(QCircleInitBean qCircleInitBean) {
        if (qCircleInitBean != null && qCircleInitBean.getExtraTypeInfo() != null && qCircleInitBean.getExtraTypeInfo().sourceType == 85) {
            return true;
        }
        return false;
    }

    public static boolean d(QCircleInitBean qCircleInitBean) {
        QCircleReportBean fromReportBean;
        String dtPageId;
        boolean z16;
        if (qCircleInitBean == null) {
            fromReportBean = null;
        } else {
            try {
                fromReportBean = qCircleInitBean.getFromReportBean();
            } catch (Throwable th5) {
                QLog.e("QFSProbeUtils", 1, "[isProbeTabScene] ex: ", th5);
                return false;
            }
        }
        String str = "";
        if (fromReportBean == null) {
            dtPageId = "";
        } else {
            dtPageId = fromReportBean.getDtPageId();
        }
        if (fromReportBean != null) {
            str = fromReportBean.getDtFromPageId();
        }
        if (!TextUtils.equals(dtPageId, QCircleDaTongConstant.PageId.PG_XSJ_EXPLORE_TAB_PAGE) && !TextUtils.equals(str, QCircleDaTongConstant.PageId.PG_XSJ_EXPLORE_TAB_PAGE) && !c(qCircleInitBean)) {
            z16 = false;
            if (TextUtils.equals(f90130a, dtPageId) || !TextUtils.equals(f90131b, str)) {
                QLog.d("QFSProbeUtils", 2, "[isProbeTabScene] dtPageId: " + dtPageId + " | dtFromPageId: " + str);
                f90130a = dtPageId;
                f90131b = str;
            }
            return z16;
        }
        z16 = true;
        if (TextUtils.equals(f90130a, dtPageId)) {
        }
        QLog.d("QFSProbeUtils", 2, "[isProbeTabScene] dtPageId: " + dtPageId + " | dtFromPageId: " + str);
        f90130a = dtPageId;
        f90131b = str;
        return z16;
    }

    public static void e(BaseRequest baseRequest, byte[] bArr) {
        String traceId;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[printTranInfo] traceId: ");
        if (baseRequest == null) {
            traceId = "";
        } else {
            traceId = baseRequest.getTraceId();
        }
        sb5.append(traceId);
        QLog.d("QFSProbeUtils", 1, sb5.toString());
        if (bArr != null && bArr.length > 0) {
            QLog.d("QFSProbeUtils", 1, "[printTranInfo] trans byte length: " + bArr.length);
        }
    }

    public static void f(FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt, byte[] bArr) {
        if (feedCloudCommon$StCommonExt != null && feedCloudCommon$StCommonExt.mapBytesInfo != null && bArr != null && bArr.length != 0) {
            feedCloudCommon$StCommonExt.setHasFlag(true);
            List<FeedCloudCommon$BytesEntry> list = feedCloudCommon$StCommonExt.mapBytesInfo.get();
            FeedCloudCommon$BytesEntry feedCloudCommon$BytesEntry = new FeedCloudCommon$BytesEntry();
            feedCloudCommon$BytesEntry.key.set("common_reddot_insert_info");
            feedCloudCommon$BytesEntry.value.set(ByteStringMicro.copyFrom(bArr));
            list.add(feedCloudCommon$BytesEntry);
            QLog.e("QFSProbeUtils", 1, "[putTransInfo] refreshAction current trans info size=" + bArr.length);
        }
    }
}
