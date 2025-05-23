package com.tencent.biz.qqcircle.immersive.feed.ad;

import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ae {
    public static void a(View view, e30.b bVar, String str, Map<String, Object> map) {
        if (bVar != null && bVar.g() != null && view != null && !TextUtils.isEmpty(str)) {
            VideoReport.setElementId(view, str);
            VideoReport.setElementReuseIdentifier(view, str + bVar.g().f398449id.get());
            VideoReport.setElementParams(view, map);
            VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        }
    }

    public static QCircleExtraTypeInfo b(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        QCircleExtraTypeInfo qCircleExtraTypeInfo = new QCircleExtraTypeInfo();
        qCircleExtraTypeInfo.mDataPosition = i3;
        qCircleExtraTypeInfo.mFeed = feedCloudMeta$StFeed;
        return qCircleExtraTypeInfo;
    }

    public static Map<String, Object> c(String str, String str2, GdtAd gdtAd, int i3) {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(i3 + 1));
        buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
        buildElementParams.put("xsj_custom_pgid", str);
        if (!TextUtils.isEmpty(str2)) {
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMERCIAL_ADCARD_THREE_STAGE, str2);
        }
        d(gdtAd, buildElementParams);
        return buildElementParams;
    }

    public static void d(GdtAd gdtAd, Map<String, Object> map) {
        if (gdtAd != null && gdtAd.isValid()) {
            map.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMERCIAL_ADS_ID, Long.valueOf(gdtAd.getAId()));
            map.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMERCIAL_ADS_TRACE_ID, gdtAd.getTraceId());
            map.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMERCIAL_ADS_POS_ID, gdtAd.getPosId());
            map.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMERCIAL_ADS_URL, gdtAd.getUrlForClick());
        }
    }

    public static void e(View view, String str) {
        if (view != null && !TextUtils.isEmpty(str)) {
            VideoReport.setElementId(view, str);
            VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        }
    }
}
