package com.tencent.mobileqq.mini.report;

import android.text.TextUtils;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0003\u0018\u0000 \n2\u00020\u0001:\u0002\n\u000bB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J2\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\tH\u0007\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/mini/report/MiniAppSearchDtReportHelper;", "", "()V", "miniAppSearchCommonReport", "", "eventId", "", AdMetricTag.EVENT_NAME, "elementMap", "", "Companion", "SingletonHolder", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppSearchDtReportHelper {
    public static final String DT_APP_POSITION = "app_position";
    private static final String DT_CUR_PG = "cur_pg";
    public static final String DT_ELEMENT_CLASSIFICATION_NAME = "classification_name";
    public static final String DT_ELEMENT_SEARCH_QUERY_TEXT = "search_query_text";
    public static final String DT_LIST_NAME = "list_name";
    public static final String DT_MINI_APP_ID = "min_appid";
    public static final String DT_MINI_APP_TYPE = "applet_type";
    public static final String EVENT_CLICK = "qq_clck";
    public static final String EVENT_EXP = "qq_imp";
    public static final String MINI_APP_EM_APPLET = "em_applet";
    public static final String MINI_APP_EM_APPLET_CLASSIFICATION_SELECTION = "em_applet_classification_selection";
    public static final String MINI_APP_EM_APPLET_CLEAR_HISTORICAL = "em_applet_clear_historical";
    public static final String MINI_APP_EM_APPLET_EVERYONE_MODULES = "em_applet_everyone_modules";
    public static final String MINI_APP_EM_APPLET_HISTORICAL_TERMS = "em_applet_historical_terms";
    public static final String MINI_APP_EM_APPLET_RECENTLY_SEARCHING = "em_applet_recently_searching";
    public static final String MINI_APP_EM_APPLET_SEARCH_BOX = "em_applet_search_box";
    public static final String MINI_APP_EM_APPLET_SEARCH_RESULTS_ENTRIES = "em_applet_search_results_entries";
    private static final String MINI_APP_PG_APPLET_SEARCH = "pg_applet_search";
    private static final String TAG = "MiniAppSearchDtReportHelper";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final MiniAppSearchDtReportHelper instance = SingletonHolder.INSTANCE.getHolder();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001a\u00020\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/mini/report/MiniAppSearchDtReportHelper$Companion;", "", "()V", "DT_APP_POSITION", "", "DT_CUR_PG", "DT_ELEMENT_CLASSIFICATION_NAME", "DT_ELEMENT_SEARCH_QUERY_TEXT", "DT_LIST_NAME", "DT_MINI_APP_ID", "DT_MINI_APP_TYPE", "EVENT_CLICK", "EVENT_EXP", "MINI_APP_EM_APPLET", "MINI_APP_EM_APPLET_CLASSIFICATION_SELECTION", "MINI_APP_EM_APPLET_CLEAR_HISTORICAL", "MINI_APP_EM_APPLET_EVERYONE_MODULES", "MINI_APP_EM_APPLET_HISTORICAL_TERMS", "MINI_APP_EM_APPLET_RECENTLY_SEARCHING", "MINI_APP_EM_APPLET_SEARCH_BOX", "MINI_APP_EM_APPLET_SEARCH_RESULTS_ENTRIES", "MINI_APP_PG_APPLET_SEARCH", "TAG", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "Lcom/tencent/mobileqq/mini/report/MiniAppSearchDtReportHelper;", "getInstance", "()Lcom/tencent/mobileqq/mini/report/MiniAppSearchDtReportHelper;", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MiniAppSearchDtReportHelper getInstance() {
            return MiniAppSearchDtReportHelper.instance;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c2\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/mini/report/MiniAppSearchDtReportHelper$SingletonHolder;", "", "()V", "holder", "Lcom/tencent/mobileqq/mini/report/MiniAppSearchDtReportHelper;", "getHolder", "()Lcom/tencent/mobileqq/mini/report/MiniAppSearchDtReportHelper;", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    private static final class SingletonHolder {
        public static final SingletonHolder INSTANCE = new SingletonHolder();
        private static final MiniAppSearchDtReportHelper holder = new MiniAppSearchDtReportHelper(null);

        SingletonHolder() {
        }

        public final MiniAppSearchDtReportHelper getHolder() {
            return holder;
        }
    }

    public /* synthetic */ MiniAppSearchDtReportHelper(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final void miniAppSearchCommonReport(String eventId) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        miniAppSearchCommonReport$default(this, eventId, null, null, 6, null);
    }

    MiniAppSearchDtReportHelper() {
    }

    public final void miniAppSearchCommonReport(String eventId, String eventName) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        miniAppSearchCommonReport$default(this, eventId, eventName, null, 4, null);
    }

    public final void miniAppSearchCommonReport(String eventId, String eventName, Map<String, String> elementMap) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(elementMap, "elementMap");
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap2.put("pgid", MINI_APP_PG_APPLET_SEARCH);
        hashMap.put("pgid", MINI_APP_PG_APPLET_SEARCH);
        hashMap.put("cur_pg", hashMap2);
        if (!TextUtils.isEmpty(eventName)) {
            hashMap.put("eid", eventName);
        }
        if (!elementMap.isEmpty()) {
            hashMap.putAll(elementMap);
        }
        VideoReport.reportEvent(eventId, hashMap);
        QLog.d(TAG, 1, "eventId:" + eventId + " eventName:" + eventName + " eventParams:" + hashMap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void miniAppSearchCommonReport$default(MiniAppSearchDtReportHelper miniAppSearchDtReportHelper, String str, String str2, Map map, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str2 = "";
        }
        if ((i3 & 4) != 0) {
            map = new HashMap();
        }
        miniAppSearchDtReportHelper.miniAppSearchCommonReport(str, str2, map);
    }
}
