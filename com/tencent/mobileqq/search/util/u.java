package com.tencent.mobileqq.search.util;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes18.dex */
public class u {

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f285077d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Map f285078e;

        a(View view, Map map) {
            this.f285077d = view;
            this.f285078e = map;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            VideoReport.reportEvent("dt_clck", this.f285077d, this.f285078e);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f285079a;

        /* renamed from: b, reason: collision with root package name */
        public String f285080b;

        /* renamed from: c, reason: collision with root package name */
        public String f285081c;

        /* renamed from: d, reason: collision with root package name */
        public String f285082d;

        /* renamed from: e, reason: collision with root package name */
        public String f285083e;

        /* renamed from: f, reason: collision with root package name */
        public String f285084f;

        /* renamed from: g, reason: collision with root package name */
        public String f285085g;

        /* renamed from: h, reason: collision with root package name */
        public String f285086h = "0";

        /* renamed from: i, reason: collision with root package name */
        public String f285087i;

        /* renamed from: j, reason: collision with root package name */
        public String f285088j;

        /* renamed from: k, reason: collision with root package name */
        public String f285089k;

        private static void a(Map<String, String> map, String str, String str2) {
            if (!TextUtils.isEmpty(str2)) {
                map.put(str, str2);
            }
        }

        public Map<String, String> b() {
            HashMap hashMap = new HashMap(6);
            a(hashMap, "hot_search_text_id", this.f285079a);
            a(hashMap, "hot_search_text", this.f285080b);
            a(hashMap, "hot_search_first_source", this.f285081c);
            a(hashMap, "hot_search_second_source", this.f285082d);
            a(hashMap, "hot_search_text_position", this.f285083e);
            a(hashMap, "hot_search_display_type", this.f285084f);
            a(hashMap, "hot_search_display_tag_type", this.f285085g);
            a(hashMap, "hot_search_is_operated", this.f285086h);
            a(hashMap, "hot_search_content_type", this.f285087i);
            a(hashMap, "hot_search_live_room_id", this.f285088j);
            a(hashMap, "hot_search_live_status", this.f285089k);
            return hashMap;
        }
    }

    public static Map<String, Object> a(int i3, boolean z16) {
        HashMap hashMap = new HashMap();
        hashMap.put("is_open", Integer.valueOf(z16 ? 1 : 0));
        hashMap.put("state_type", Integer.valueOf(i3));
        return hashMap;
    }

    public static void b(View view) {
        if (view == null) {
            return;
        }
        VideoReport.reportEvent("clck", view, null);
    }

    public static void c(View view, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("is_shading", 1);
        hashMap.put("literal_text", str);
        VideoReport.setElementParams(view, hashMap);
        VideoReport.reportEvent("dt_imp", view, hashMap);
    }

    public static void d(View view, View view2, String str, String str2) {
        if (view != null && view2 != null) {
            VideoReport.setPageId(view2, str);
            VideoReport.setPageParams(view2, "source_entrance_type", str2);
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

    public static void e(View view, int i3, String str, String str2, String str3, int i16, int i17) {
        VideoReport.setElementId(view, "em_search_guess_word_item");
        VideoReport.setElementReuseIdentifier(view, String.valueOf(i16));
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementParam(view, "item_index", Integer.valueOf(i3));
        VideoReport.setElementParam(view, "search_query_text", str);
        VideoReport.setElementParam(view, "guess_word_tag_name", str2);
        VideoReport.setElementParam(view, "trans_info", str3);
        VideoReport.setElementParam(view, "btn_type", Integer.valueOf(i17));
    }

    public static void f(View view, @NonNull b bVar) {
        VideoReport.setElementId(view, "em_hot_search_content");
        VideoReport.setElementParams(view, bVar.b());
    }

    public static void g(View view, int i3) {
        VideoReport.setElementId(view, "em_hot_search");
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementParam(view, "activation_hot_search_count", Integer.valueOf(i3));
    }

    public static void h(View view, int i3) {
        if (view == null) {
            return;
        }
        VideoReport.setElementId(view, "em_query_clear_button");
        VideoReport.setElementParam(view, "activation_result_count", Integer.valueOf(i3));
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    public static void i(View view, int i3, String str, String str2) {
        if (view == null) {
            return;
        }
        k(view, "em_delete_button", i3, str, str2);
    }

    public static void j(View view, int i3, String str, String str2) {
        if (view == null) {
            return;
        }
        k(view, "em_recent_search_result", i3, str, str2);
    }

    public static void k(View view, String str, int i3, String str2, String str3) {
        if (view == null) {
            return;
        }
        VideoReport.setElementId(view, str);
        VideoReport.setElementParam(view, "activation_recent_doc_type", str2);
        VideoReport.setElementParam(view, "search_name_text", str3);
        VideoReport.setElementParam(view, "item_index", Integer.valueOf(i3));
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    public static void l(View view, int i3) {
        VideoReport.setElementId(view, "em_recent_search");
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementParam(view, "activation_result_count", Integer.valueOf(i3));
    }

    public static void m(View view, View view2, String str, String str2, String str3, boolean z16) {
        if (view != null && view2 != null) {
            VideoReport.setPageId(view2, str2);
            VideoReport.setPageParams(view2, "source_entrance_type", str3);
            ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_NONE;
            VideoReport.setElementExposePolicy(view2, exposurePolicy);
            ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
            VideoReport.setElementClickPolicy(view2, clickPolicy);
            VideoReport.setElementId(view, "em_bas_search_box");
            HashMap hashMap = new HashMap();
            hashMap.put("is_shading", Integer.valueOf(z16 ? 1 : 0));
            if (z16) {
                hashMap.put("literal_text", str);
            }
            VideoReport.setElementParams(view, hashMap);
            VideoReport.setElementExposePolicy(view, exposurePolicy);
            VideoReport.setElementClickPolicy(view, clickPolicy);
            VideoReport.reportEvent("dt_imp", view, hashMap);
            view.setOnClickListener(new a(view, hashMap));
        }
    }

    public static void n(View view) {
        if (view == null) {
            return;
        }
        VideoReport.setElementId(view, "em_bas_search_popular_image");
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    public static void o(View view, int i3, boolean z16) {
        HashMap hashMap = new HashMap();
        VideoReport.setElementId(view, "em_bas_search_setup_panel_type");
        hashMap.put("is_open", Integer.valueOf(!z16 ? 1 : 0));
        hashMap.put("click_status", Integer.valueOf(z16 ? 1 : 0));
        hashMap.put("state_type", Integer.valueOf(i3));
        VideoReport.setElementParams(view, hashMap);
    }

    public static void p(View view, int i3, boolean z16) {
        VideoReport.setPageId(view, "pg_search_activation_setting");
        VideoReport.setElementId(view, "em_bas_search_setup_panel_type");
        VideoReport.setElementParams(view, a(i3, z16));
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    public static void q(View view) {
        VideoReport.setElementId(view, "em_bas_search_page_setup_button");
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
    }

    public static void r(View view, String str, String str2) {
        VideoReport.setElementId(view, "em_shortcut_button");
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementParam(view, "activation_shortcut_position", str);
        VideoReport.setElementParam(view, "activation_shortcut_type", str2);
    }

    public static void s(View view, String str, String str2, boolean z16, String str3, int i3, int i16) {
        if (view == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("hot_search_text", str);
        hashMap.put("hot_search_text_id", str2);
        hashMap.put("is_manual_operation", Integer.valueOf(z16 ? 1 : 0));
        hashMap.put("hot_search_display_tag_type", str3);
        hashMap.put("serial_number", Integer.valueOf(i3));
        VideoReport.setElementId(view, "em_bas_trending_search_items");
        VideoReport.setElementReuseIdentifier(view, "em_bas_trending_search_items_" + i16);
        VideoReport.setElementParams(view, hashMap);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    public static void t(View view) {
        if (view == null) {
            return;
        }
        VideoReport.setElementId(view, "em_bas_top_trending_searches");
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
    }
}
