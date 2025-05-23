package com.tencent.biz.qqcircle.utils;

import android.text.TextUtils;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class cb {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f92739a = false;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f92740b = false;

    public static boolean a() {
        return uq3.k.a().c("MMKV_KEY_RATE_SHOW_TIPS", false);
    }

    public static boolean b() {
        String b16 = l.b("exp_xsj_video_play_rate_gesture_new");
        if (TextUtils.isEmpty(b16)) {
            QLog.d("QFSRatePlayUtils", 1, "exp name is empty");
            return false;
        }
        if (!"exp_xsj_video_play_rate_gesture_new_B".equals(b16)) {
            return false;
        }
        QLog.d("QFSRatePlayUtils", 1, "hit:exp_xsj_video_play_rate_gesture_new_B");
        return true;
    }

    public static synchronized boolean c() {
        synchronized (cb.class) {
            if (uq3.c.T()) {
                return true;
            }
            QLog.d("QFSRatePlayUtils", 1, "wns close");
            return false;
        }
    }

    public static void d(View view, float f16, FeedCloudMeta$StFeed feedCloudMeta$StFeed, String str) {
        if (view != null && feedCloudMeta$StFeed != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("xsj_feed_id", feedCloudMeta$StFeed.f398449id.get());
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, feedCloudMeta$StFeed.poster.f398463id.get());
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_FAST_FORWARD_TIMES, gb0.b.s(f16));
            hashMap.put("xsj_custom_pgid", str);
            hashMap.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_SPEED_CHOOSE_BUTTON);
            VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_SPEED_CHOOSE_BUTTON);
            VideoReport.reportEvent("ev_xsj_abnormal_clck", view, hashMap);
            QLog.d("QFSRatePlayUtils", 1, "report abnormalClick");
        }
    }

    public static void e(View view, FeedCloudMeta$StFeed feedCloudMeta$StFeed, float f16, String str) {
        if (view != null && feedCloudMeta$StFeed != null) {
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.put("xsj_feed_id", feedCloudMeta$StFeed.f398449id.get());
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, feedCloudMeta$StFeed.poster.f398463id.get());
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FAST_FORWARD_TIMES, gb0.b.s(f16));
            buildElementParams.put("dt_pgid", str);
            VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_BOTTOM_SPEED_BOX);
            VideoReport.setElementParams(view, buildElementParams);
            VideoReport.reportEvent("dt_imp", view, buildElementParams);
        }
    }

    public static void f(View view, String str, FeedCloudMeta$StFeed feedCloudMeta$StFeed, String str2) {
        if (view != null && feedCloudMeta$StFeed != null) {
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.put("xsj_feed_id", feedCloudMeta$StFeed.f398449id.get());
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, feedCloudMeta$StFeed.poster.f398463id.get());
            buildElementParams.put("dt_pgid", str2);
            VideoReport.setElementId(view, str);
            VideoReport.setElementParams(view, buildElementParams);
            VideoReport.reportEvent("dt_imp", view, buildElementParams);
        }
    }

    public static void g(View view, String str, FeedCloudMeta$StFeed feedCloudMeta$StFeed, String str2) {
        if (view != null && feedCloudMeta$StFeed != null) {
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.put("xsj_feed_id", feedCloudMeta$StFeed.f398449id.get());
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, feedCloudMeta$StFeed.poster.f398463id.get());
            buildElementParams.put("dt_pgid", str2);
            buildElementParams.put("dt_eid", str);
            VideoReport.setElementId(view, str);
            VideoReport.setElementParams(view, buildElementParams);
            VideoReport.reportEvent("ev_xsj_abnormal_imp", view, buildElementParams);
        }
    }

    public static void h() {
        uq3.k.a().j("MMKV_KEY_RATE_SHOW_TIPS", true);
    }
}
