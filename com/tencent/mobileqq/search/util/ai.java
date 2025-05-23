package com.tencent.mobileqq.search.util;

import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.page.VideoReportPageInfo;
import com.tencent.shadow.dynamic.host.Constant;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ai {
    public static String a(String str, String str2, int i3) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("search_query_text", str);
            jSONObject.put("trace_id", str2);
            jSONObject.put("jump_type", i3);
            return jSONObject.toString();
        } catch (JSONException e16) {
            QLog.e("Search.DaTong.More", 2, "[generateTransInfo] exception" + e16);
            return "";
        }
    }

    protected static String b(Map map, String str) {
        if (map == null || !map.containsKey(str)) {
            return "";
        }
        return map.get(str).toString();
    }

    public static void c(View view) {
        VideoReport.setElementId(view, "em_back_button");
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    public static void d(View view) {
        VideoReport.setElementId(view, "em_cancel_button");
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    public static void e(View view, long j3) {
        int i3;
        if (view == null) {
            return;
        }
        if (j3 == Constant.FROM_ID_UNINSTALL_PLUGIN || j3 == 1108) {
            VideoReport.setElementId(view, "em_more_result_button");
            VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
            VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
            if (j3 == Constant.FROM_ID_UNINSTALL_PLUGIN) {
                i3 = 2;
            } else {
                i3 = 3;
            }
            VideoReport.setElementParam(view, "model_type", Integer.valueOf(i3));
        }
    }

    public static void f(View view, String str, String str2) {
        VideoReport.setElementId(view, "em_more_result");
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementParam(view, "more_result_count", str);
        VideoReport.setElementParam(view, "more_display_type", str2);
    }

    public static void g(QBaseActivity qBaseActivity, View view, String str, String str2, String str3) {
        VideoReport.addToDetectionWhitelist(qBaseActivity);
        VideoReport.setPageId(view, "pg_bas_search_more_no_result");
        VideoReport.setPageParams(view, "search_query_text", str2);
        VideoReport.setPageParams(view, "search_node_type", str);
        VideoReport.setPageParams(view, "trace_id", str3);
    }

    public static void h(QBaseActivity qBaseActivity, View view, Map<String, Object> map) {
        VideoReport.addToDetectionWhitelist(qBaseActivity);
        VideoReport.setPageId(view, "pg_search_people_no_result");
        VideoReport.setPageParams(view, new PageParams((Map<String, ?>) map));
    }

    public static void i(QBaseActivity qBaseActivity, View view, String str, String str2, String str3, String str4) {
        String str5;
        VideoReport.addToDetectionWhitelist(qBaseActivity);
        VideoReport.setPageId(view, "pg_search_more_result");
        VideoReportPageInfo pageInfo = VideoReport.getPageInfo();
        if (pageInfo != null) {
            str5 = b(pageInfo.pageParams, "source_entrance_type");
            if (TextUtils.isEmpty(str2)) {
                str2 = b(pageInfo.pageParams, "search_trace_id");
            }
            if (TextUtils.isEmpty(str3)) {
                str3 = b(pageInfo.pageParams, "search_query_text");
            }
        } else {
            str5 = "";
        }
        VideoReport.setPageParams(view, "search_query_text", str3);
        VideoReport.setPageParams(view, "source_entrance_type", str5);
        VideoReport.setPageParams(view, "search_node_type", str);
        VideoReport.setPageParams(view, "search_trace_id", str2);
        VideoReport.setPageParams(view, "trace_id", str4);
    }

    public static void j(QBaseActivity qBaseActivity, View view, Map<String, Object> map, boolean z16) {
        String str;
        VideoReport.addToDetectionWhitelist(qBaseActivity);
        if (z16) {
            str = "pg_search_people_more_result";
        } else {
            str = "pg_search_people_result";
        }
        VideoReport.setPageId(view, str);
        VideoReport.setPageParams(view, new PageParams((Map<String, ?>) map));
    }

    public static void k(View view, View view2, int i3) {
        VideoReport.setElementId(view, "em_search_result_channel");
        VideoReport.setElementId(view2, "em_search_result_channel_more");
        VideoReport.setElementClickPolicy(view2, ClickPolicy.REPORT_NONE);
        VideoReport.setElementParam(view, "more_result_count", Integer.valueOf(i3));
    }

    public static void l(View view) {
        VideoReport.setElementId(view, "em_search_bar");
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    public static void m(View view) {
        VideoReport.setElementId(view, "em_search_result_channel_unit");
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
    }
}
