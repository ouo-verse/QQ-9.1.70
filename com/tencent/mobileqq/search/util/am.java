package com.tencent.mobileqq.search.util;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.search.api.impl.SearchGuildDaTongApiImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class am {

    /* renamed from: a, reason: collision with root package name */
    private static HashMap<String, a> f285003a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private static HashMap<String, HashMap> f285004b = new HashMap<>();

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<View> f285005a;

        public a(View view) {
            this.f285005a = new WeakReference<>(view);
        }

        public View a() {
            return this.f285005a.get();
        }
    }

    public static JSONObject a(String str, long j3, String str2, long j16, com.tencent.mobileqq.search.business.contact.entity.a aVar, String str3, long j17) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("node_type", 1);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("matched_value", str);
            }
            jSONObject.put("recent_index", j3);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("matched_field", str2);
            }
            jSONObject.put("degree", j16);
            if (aVar != null) {
                JSONArray jSONArray = new JSONArray();
                if (aVar.f282923a) {
                    jSONArray.mo162put("Recent");
                }
                if (aVar.f282924b) {
                    jSONArray.mo162put("Gathered");
                }
                if (aVar.f282925c) {
                    jSONArray.mo162put("Special");
                }
                if (aVar.f282926d) {
                    jSONArray.mo162put("NewTroop");
                }
                jSONObject.put("attributes", jSONArray);
            }
            if (!TextUtils.isEmpty(str3)) {
                jSONObject.put("sub_type", str3);
            }
            jSONObject.put("last_message_time", j17);
            return jSONObject;
        } catch (Exception e16) {
            QLog.d("Search.DaTong.ResultPage", 1, "buildContactExtraInfo", e16);
            return null;
        }
    }

    public static JSONObject b(List<com.tencent.mobileqq.search.business.contact.entity.e> list, long j3, com.tencent.mobileqq.search.business.contact.entity.d dVar, String str) {
        String str2;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("node_type", 2);
            if (list != null && !list.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                JSONArray jSONArray2 = new JSONArray();
                for (com.tencent.mobileqq.search.business.contact.entity.e eVar : list) {
                    if (eVar != null && eVar.f282933a != null && (str2 = eVar.f282934b) != null) {
                        jSONArray.mo162put(str2);
                        jSONArray2.mo162put(eVar.f282933a);
                    }
                }
                jSONObject.put("matched_values", jSONArray);
                jSONObject.put("match_fields", jSONArray2);
            }
            jSONObject.put("recent_index", j3);
            if (dVar != null) {
                JSONArray jSONArray3 = new JSONArray();
                if (dVar.f282931a) {
                    jSONArray3.mo162put("Recent");
                }
                if (dVar.f282932b) {
                    jSONArray3.mo162put("NewTroop");
                }
                jSONObject.put("attributes", jSONArray3);
            }
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("sub_type", str);
            }
            return jSONObject;
        } catch (Exception e16) {
            QLog.d("Search.DaTong.ResultPage", 1, "buildGroupExtraInfo", e16);
            return null;
        }
    }

    private static void c(String str) {
        View e16 = e(str);
        if (e16 != null) {
            VideoReport.setElementId(e16, "em_more_result_button");
            VideoReport.setElementExposePolicy(e16, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementClickPolicy(e16, ClickPolicy.REPORT_ALL);
            l(e16, str);
        }
    }

    public static String d(int i3, String str) {
        try {
            UUID b16 = ba.b(f(i3), str);
            if (b16 != null) {
                return b16.toString();
            }
            return "";
        } catch (Exception e16) {
            QLog.d("Search.DaTong.ResultPage", 1, "getDocId failed: " + e16);
            return "";
        }
    }

    @Nullable
    private static View e(String str) {
        a aVar;
        if (!f285003a.containsKey(str) || (aVar = f285003a.get(str)) == null) {
            return null;
        }
        return aVar.a();
    }

    public static String f(int i3) {
        if (i3 != 6) {
            if (i3 != 7) {
                if (i3 != 13) {
                    if (i3 != 18) {
                        if (i3 != 22) {
                            if (i3 != 15) {
                                if (i3 != 16) {
                                    return "others";
                                }
                                return "document";
                            }
                            return "favorite";
                        }
                        return WadlProxyConsts.CHANNEL;
                    }
                    return "qqcircle";
                }
                return "chat_history";
            }
            return "group_chat";
        }
        return "contacts";
    }

    public static HashMap g(String str) {
        if (f285004b.containsKey(str)) {
            return f285004b.get(str);
        }
        return null;
    }

    public static void h(View view, View view2, String str, String str2, String str3, String str4) {
        if (view != null && view2 != null) {
            VideoReport.setPageId(view2, str);
            VideoReport.setPageParams(view2, "source_entrance_type", str2);
            VideoReport.setPageParams(view2, "search_trace_id", str3);
            VideoReport.setPageParams(view2, "search_query_text", str4);
            ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_NONE;
            VideoReport.setElementExposePolicy(view2, exposurePolicy);
            ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
            VideoReport.setElementClickPolicy(view2, clickPolicy);
            VideoReport.setElementId(view, "em_cancel_button");
            VideoReport.setElementExposePolicy(view, exposurePolicy);
            VideoReport.setElementClickPolicy(view, clickPolicy);
            VideoReport.reportEvent("imp", view, null);
        }
    }

    public static void i(View view, String str) {
        f285003a.put(str, new a(view));
    }

    public static void j(int i3, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("result_node_position", String.valueOf(i3));
        hashMap.put("result_display_type", str);
        hashMap.put("search_node_type", str2);
        f285004b.put(str2, hashMap);
    }

    public static void k(View view, int i3) {
        l(view, String.valueOf(i3));
    }

    public static void l(View view, String str) {
        HashMap g16 = g(str);
        if (g16 == null) {
            return;
        }
        VideoReport.setElementParams(view, g16);
    }

    public static void m(View view, int i3, String str, String str2, String str3, int i16, String str4, String str5) {
        VideoReport.setElementParam(view, "activation_result_count", String.valueOf(i16));
        VideoReport.setElementParam(view, SearchGuildDaTongApiImpl.CHILD_DOC_TYPE, str4);
        n(view, i3, str, str2, str3, str5);
    }

    public static void n(View view, int i3, String str, String str2, String str3, String str4) {
        VideoReport.setElementId(view, "em_result_node");
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementParam(view, "result_node_position", String.valueOf(i3));
        VideoReport.setElementParam(view, "result_display_type", str);
        VideoReport.setElementParam(view, "search_node_type", str2);
        VideoReport.setElementReuseIdentifier(view, str3);
        j(i3, str, str2);
        c(str2);
    }

    public static void o(View view, String str, String str2) {
        v(view, str);
        View e16 = e(str2);
        if (e16 != null) {
            VideoReport.setElementParam(e16, "qq_xsj_transfer_info", str);
        }
    }

    public static void p(View view, View view2, String str, String str2, String str3, String str4, String str5) {
        if (view != null && view2 != null) {
            VideoReport.setPageId(view2, str2);
            VideoReport.setPageParams(view2, "source_entrance_type", str3);
            VideoReport.setPageParams(view2, "search_trace_id", str4);
            VideoReport.setPageParams(view2, "search_query_text", str5);
            ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_NONE;
            VideoReport.setElementExposePolicy(view2, exposurePolicy);
            ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
            VideoReport.setElementClickPolicy(view2, clickPolicy);
            VideoReport.setElementId(view, "em_search_bar");
            VideoReport.setElementParam(view, "activation_grey_text", str);
            VideoReport.setElementExposePolicy(view, exposurePolicy);
            VideoReport.setElementClickPolicy(view, clickPolicy);
            VideoReport.reportEvent("imp", view, null);
        }
    }

    public static void q(View view, View view2, String str, String str2, String str3, String str4) {
        if (view != null && view2 != null) {
            VideoReport.setPageId(view2, str);
            VideoReport.setPageParams(view2, "source_entrance_type", str2);
            VideoReport.setPageParams(view2, "search_trace_id", str3);
            VideoReport.setPageParams(view2, "search_query_text", str4);
            ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_NONE;
            VideoReport.setElementExposePolicy(view2, exposurePolicy);
            ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
            VideoReport.setElementClickPolicy(view2, clickPolicy);
            VideoReport.setElementId(view, "em_query_clear_button");
            VideoReport.setElementExposePolicy(view, exposurePolicy);
            VideoReport.setElementClickPolicy(view, clickPolicy);
            VideoReport.reportEvent("imp", view, null);
        }
    }

    public static void r(View view, String str, String str2, String str3, int i3, int i16, String str4, String str5) {
        s(view, str, str2, str3, i3, i16, str4, str5, null);
    }

    public static void s(View view, String str, String str2, String str3, int i3, int i16, String str4, String str5, JSONObject jSONObject) {
        VideoReport.setElementId(view, "em_single_result");
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementParam(view, "recall_reason", str5);
        VideoReport.setElementParam(view, "search_name_text", str);
        VideoReport.setElementParam(view, SearchGuildDaTongApiImpl.CHILD_DOC_TYPE, str2);
        if (!TextUtils.isEmpty(str3)) {
            VideoReport.setElementParam(view, "search_single_doc_id", str3);
        }
        VideoReport.setElementParam(view, "search_single_doc_position", String.valueOf(i3));
        if (i16 >= 0) {
            VideoReport.setElementParam(view, "serial_number", String.valueOf(i16));
        }
        if (jSONObject != null) {
            VideoReport.setElementParam(view, "node_extra_info", jSONObject);
        }
        VideoReport.setElementReuseIdentifier(view, str4);
    }

    public static void t(View view, String str, String str2, String str3, int i3, int i16, String str4, String str5, JSONObject jSONObject, Map<String, String> map) {
        s(view, str, str2, str3, i3, i16, str4, str5, jSONObject);
        if (map != null && !map.isEmpty()) {
            for (String str6 : map.keySet()) {
                VideoReport.setElementParam(view, str6, map.get(str6));
            }
        }
    }

    public static void u(View view, String str) {
        VideoReport.setElementParam(view, "trans_info", str);
    }

    public static void v(View view, String str) {
        VideoReport.setElementParam(view, "qq_xsj_transfer_info", str);
    }
}
