package com.tencent.mobileqq.mini.entry.search.report;

import android.app.Activity;
import android.view.View;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aB\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00012\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00162\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016\u001a\u0016\u0010\u0019\u001a\u00020\u0012*\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u001a\u001c\u0010\u001d\u001a\u00020\u0012*\u0004\u0018\u00010\u001a2\u0006\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020 \u001a,\u0010\u001d\u001a\u00020\u0012*\u0004\u0018\u00010\u001a2\u0006\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$\u001aL\u0010\u001d\u001a\u00020\u0012*\u0004\u0018\u00010\u001a2\u0006\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0014\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00162\b\u0010&\u001a\u0004\u0018\u00010\u0001\u001a(\u0010'\u001a\u00020\u0012*\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020\u00012\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00170\u0016\u001a\f\u0010*\u001a\u00020\u0012*\u0004\u0018\u00010\u001a\u001a\f\u0010+\u001a\u00020\u0012*\u0004\u0018\u00010\u001a\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006,"}, d2 = {"DT_CUR_PG", "", "EM_ID_APPLET_BACK_BUTTON", "EM_ID_APPLET_CANCEL_BUTTON", "EM_ID_APPLET_CLEAR_KEYWORD_BUTTON", "EM_ID_APPLET_HISTORY_CLEAR_BUTTON", "EM_ID_APPLET_HISTORY_CLEAR_ICON", "EM_ID_APPLET_HISTORY_DELETE_BUTTON", "EM_ID_APPLET_HISTORY_FINISH_BUTTON", "EM_ID_APPLET_HISTORY_KEYWORD_ITEM", "EM_ID_APPLET_HISTORY_SEARCH", "EM_ID_APPLET_REQUEST_FAIL_TOAST", "EM_ID_NO_RESULT", "EM_PARAM_APPLET_KEYWORD_NAME", "MINI_APP_REPORT_KEY_APP_KEY", "PG_ID_APPLET_DROP_DOWN_SEARCH", "PG_PARAM_APPLET_PAGE_SOURCE", "reportEvent", "", "eventKey", "elementId", "eventParam", "", "", "pageParam", "bindDynamicParams", "Landroid/view/View;", "provider", "Lcom/tencent/qqlive/module/videoreport/data/IDynamicParams;", "bindElementReportInfo", "elementID", IECDtReport.ACTION_CLICK_POLICY, "Lcom/tencent/qqlive/module/videoreport/constants/ClickPolicy;", IECDtReport.ACTION_EXPOSE_POLICY, "Lcom/tencent/qqlive/module/videoreport/constants/ExposurePolicy;", "endExposePolicy", "Lcom/tencent/qqlive/module/videoreport/constants/EndExposurePolicy;", "params", IECDtReport.ACTION_IDENTIFIER, "bindPageReportInfo", "Landroid/app/Activity;", "pageId", "reportPgIn", "reportPgOut", "qqmini_impl_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class SearchDtReportExtKt {
    public static final String DT_CUR_PG = "cur_pg";
    public static final String EM_ID_APPLET_BACK_BUTTON = "em_applet_back_button";
    public static final String EM_ID_APPLET_CANCEL_BUTTON = "em_applet_cancel_button";
    public static final String EM_ID_APPLET_CLEAR_KEYWORD_BUTTON = "em_applet_clear_keyword_button";
    public static final String EM_ID_APPLET_HISTORY_CLEAR_BUTTON = "em_applet_clear_button";
    public static final String EM_ID_APPLET_HISTORY_CLEAR_ICON = "em_applet_clear_icon";
    public static final String EM_ID_APPLET_HISTORY_DELETE_BUTTON = "em_applet_delete_button";
    public static final String EM_ID_APPLET_HISTORY_FINISH_BUTTON = "em_applet_finish_button";
    public static final String EM_ID_APPLET_HISTORY_KEYWORD_ITEM = "em_applet_keyword_item";
    public static final String EM_ID_APPLET_HISTORY_SEARCH = "em_applet_history_search";
    public static final String EM_ID_APPLET_REQUEST_FAIL_TOAST = "em_applet_request_fail_toast";
    public static final String EM_ID_NO_RESULT = "em_applet_no_result";
    public static final String EM_PARAM_APPLET_KEYWORD_NAME = "applet_keyword_name";
    public static final String MINI_APP_REPORT_KEY_APP_KEY = "0AND06A49O0PML4Z";
    public static final String PG_ID_APPLET_DROP_DOWN_SEARCH = "pg_applet_drop_down_search_home";
    public static final String PG_PARAM_APPLET_PAGE_SOURCE = "applet_page_source";

    public static final void bindElementReportInfo(View view, String elementID, ClickPolicy clickPolicy) {
        Intrinsics.checkNotNullParameter(elementID, "elementID");
        Intrinsics.checkNotNullParameter(clickPolicy, "clickPolicy");
        bindElementReportInfo(view, elementID, clickPolicy, ExposurePolicy.REPORT_NONE, EndExposurePolicy.REPORT_NONE);
    }

    public static final void bindPageReportInfo(Activity activity, String pageId, Map<String, ? extends Object> params) {
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        Intrinsics.checkNotNullParameter(params, "params");
        if (activity == null) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(params);
        linkedHashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0AND06A49O0PML4Z");
        VideoReport.setPageId(activity, pageId);
        VideoReport.setPageParams(activity, new PageParams(linkedHashMap));
        VideoReport.setPageReportPolicy(activity, PageReportPolicy.REPORT_ALL);
        VideoReport.addToDetectionWhitelist(activity);
    }

    public static final void reportEvent(String eventKey, String elementId, Map<String, ? extends Object> map, Map<String, ? extends Object> map2) {
        Intrinsics.checkNotNullParameter(eventKey, "eventKey");
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0AND06A49O0PML4Z");
        linkedHashMap.put("dt_pgid", PG_ID_APPLET_DROP_DOWN_SEARCH);
        linkedHashMap.put("dt_eid", elementId);
        if (map != null) {
            linkedHashMap.putAll(map);
        }
        if (map2 != null) {
            linkedHashMap.put("cur_pg", map2);
        }
        VideoReport.reportEvent(eventKey, linkedHashMap);
    }

    public static final void reportPgIn(View view) {
        VideoReport.reportPgIn(view);
    }

    public static final void reportPgOut(View view) {
        VideoReport.reportPgOut(view);
    }

    public static final void bindElementReportInfo(View view, String elementID, ClickPolicy clickPolicy, ExposurePolicy exposePolicy, EndExposurePolicy endExposePolicy) {
        Intrinsics.checkNotNullParameter(elementID, "elementID");
        Intrinsics.checkNotNullParameter(clickPolicy, "clickPolicy");
        Intrinsics.checkNotNullParameter(exposePolicy, "exposePolicy");
        Intrinsics.checkNotNullParameter(endExposePolicy, "endExposePolicy");
        bindElementReportInfo(view, elementID, clickPolicy, exposePolicy, endExposePolicy, null, null);
    }

    public static final void bindElementReportInfo(View view, String elementID, ClickPolicy clickPolicy, ExposurePolicy exposePolicy, EndExposurePolicy endExposePolicy, Map<String, ? extends Object> map, String str) {
        Intrinsics.checkNotNullParameter(elementID, "elementID");
        Intrinsics.checkNotNullParameter(clickPolicy, "clickPolicy");
        Intrinsics.checkNotNullParameter(exposePolicy, "exposePolicy");
        Intrinsics.checkNotNullParameter(endExposePolicy, "endExposePolicy");
        if (view == null) {
            return;
        }
        VideoReport.setElementId(view, elementID);
        VideoReport.setElementClickPolicy(view, clickPolicy);
        VideoReport.setElementExposePolicy(view, exposePolicy);
        VideoReport.setElementEndExposePolicy(view, endExposePolicy);
        if (str != null) {
            VideoReport.setElementReuseIdentifier(view, str);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (map != null) {
            linkedHashMap.putAll(map);
        }
        linkedHashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0AND06A49O0PML4Z");
        VideoReport.setElementParams(view, linkedHashMap);
    }

    public static final void bindDynamicParams(View view, IDynamicParams iDynamicParams) {
        if (view == null) {
            return;
        }
        VideoReport.setEventDynamicParams(view, iDynamicParams);
    }
}
