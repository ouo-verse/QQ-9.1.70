package com.tencent.biz.qqcircle.utils;

import android.content.Context;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.views.QFSPageTurnContainer;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ce {

    /* renamed from: a, reason: collision with root package name */
    private static final List<Integer> f92741a = new ArrayList();

    public static void a(@NonNull Context context) {
        f92741a.remove(Integer.valueOf(b(context)));
    }

    public static int b(Context context) {
        if (context == null) {
            QLog.e("QFSScaleVideoUtils", 1, "getContextHashcode error, context is null. ");
            return 0;
        }
        return context.hashCode();
    }

    public static boolean c(@NonNull Context context) {
        return f92741a.contains(Integer.valueOf(b(context)));
    }

    public static void d(View view, String str, FeedCloudMeta$StFeed feedCloudMeta$StFeed, String str2, long j3) {
        if (view != null && feedCloudMeta$StFeed != null) {
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.put("xsj_feed_id", feedCloudMeta$StFeed.f398449id.get());
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_TYPE, Integer.valueOf(feedCloudMeta$StFeed.type.get()));
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, feedCloudMeta$StFeed.poster.f398463id.get());
            buildElementParams.put("xsj_custom_pgid", str2);
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_ACTTYPE, str);
            buildElementParams.put("eid", QCircleDaTongConstant.ElementId.EM_XSJ_CLEAR_SCREEN_INTERFACE);
            if (j3 != 0) {
                buildElementParams.put("duration", String.valueOf(j3));
            }
            VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_CLEAR_SCREEN_INTERFACE);
            VideoReport.reportEvent("ev_xsj_abnormal_clck", view, buildElementParams);
        }
    }

    public static void e(boolean z16, @NonNull ViewParent viewParent) {
        while (viewParent != null) {
            viewParent.requestDisallowInterceptTouchEvent(z16);
            viewParent = viewParent.getParent();
            if (viewParent instanceof QFSPageTurnContainer) {
                ((QFSPageTurnContainer) viewParent).n(z16);
                return;
            }
        }
    }

    public static void f(@NonNull Context context) {
        int b16 = b(context);
        List<Integer> list = f92741a;
        if (list.contains(Integer.valueOf(b16))) {
            QLog.e("QFSScaleVideoUtils", 1, "[setClearContextHashcode] hashcode is exist. ");
        } else {
            list.add(Integer.valueOf(b16));
        }
    }
}
