package com.tencent.mobileqq.mini.report;

import android.text.TextUtils;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0006\u0018\u0000 \r2\u00020\u0001:\u0002\r\u000eB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\tJ<\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/mini/report/MiniAppDesktopDtReportHelper;", "", "()V", "miniAppDesktopCommonPageReport", "", "eventId", "", AdMetricTag.EVENT_NAME, "pageElementMap", "", "miniAppDesktopCommonReport", "elementMap", "pageId", "Companion", "SingletonHolder", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppDesktopDtReportHelper {
    public static final String DT_APP_POSITION = "app_position";
    private static final String DT_CUR_PG = "cur_pg";
    public static final String DT_LIST_NAME = "list_name";
    public static final String DT_MINI_AD_ID = "adID";
    public static final String DT_MINI_APPLET_PRIMARY_TAB = "applet_primary_tab";
    public static final String DT_MINI_APP_HOST_SCENE = "host_scene";
    public static final String DT_MINI_APP_ID = "applet_appid";
    public static final String DT_MINI_APP_SOURCE = "applet_source";
    public static final String DT_MINI_APP_TYPE = "applet_type";
    public static final String DT_MINI_ITEM_ID = "itemId";
    public static final String DT_MINI_MODULE_NAME = "module_name";
    public static final String DT_MINI_PARENT_EID = "parent_eid";
    public static final String DT_MINI_PRIMARY_TAB = "primary_tab";
    public static final String DT_MINI_SECONDARY_TAB = "secondary_tab";
    public static final String DT_MINI_TAB_NAME = "tab_name";
    public static final String DT_MINI_TRACE_INFO = "traceInfo";
    public static final int DT_QQ_MINI_APP_TYPE = 1;
    public static final int DT_WX_MINI_APP_TYPE = 2;
    public static final String EVENT_CLICK = "qq_clck";
    public static final String EVENT_EXP = "qq_imp";
    public static final String MINI_APP_APPLET_CLOSE_BUTTON = "em_applet_close_button";
    public static final String MINI_APP_EM_ADD_APPLET = "em_applet_add_applet";
    public static final String MINI_APP_EM_APPLET = "em_applet_item";
    public static final String MINI_APP_EM_APPLET_BANNER = "em_applet_banner";
    public static final String MINI_APP_EM_APPLET_MENU_BUTTON = "em_applet_menu_button";
    public static final String MINI_APP_EM_APPLET_NO_RESULT = "em_applet_no_result";
    public static final String MINI_APP_EM_APPLET_PERSONAL_MODULE = "em_applet_personal_module";
    public static final String MINI_APP_EM_APPLET_RECENTLY_USE_MODULE = "em_applet_recently_use_module";
    public static final String MINI_APP_EM_APPLET_RECOMMEND_MODULE = "em_applet_recommend_module";
    public static final String MINI_APP_EM_APPLET_TEENAGER_MODE_TIP = "em_applet_teenager_mode_tip";
    public static final String MINI_APP_EM_DELETE_APPLET = "em_applet_delete_applet";
    public static final String MINI_APP_EM_LEADERBOARD_MODULE = "em_applet_leaderboard_module";
    public static final String MINI_APP_EM_LIMITED_TIME_RECOMMENDED_MODULE = "em_applet_promotion_module";
    public static final String MINI_APP_EM_PRIMARY_TAB = "em_applet_primary_tab";
    public static final String MINI_APP_EM_SEARCH_BOX = "em_applet_search_box";
    public static final String MINI_APP_EM_SEE_MORE = "em_applet_see_more";
    public static final String MINI_APP_GOTO_WX_APPLET_BUTTON = "em_applet_goto_wx_applet_button";
    public static final String MINI_APP_PG_APPLET_HOME_DROP_DOWN = "pg_applet_home_drop_down";
    public static final String MINI_APP_PG_APPLET_PERSONAL_LEVEL2 = "pg_applet_personal_level2";
    public static final String MINI_APP_PG_APPLET_RECENTLY_USE_LEVEL2 = "pg_applet_recently_use_level2";
    public static final String MINI_APP_REPORT_KEY_APP_KEY = "0AND06A49O0PML4Z";
    private static final String TAG = "MiniAppDesktopDtReportHelper";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final MiniAppDesktopDtReportHelper instance = SingletonHolder.INSTANCE.getHolder();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0011\u0010/\u001a\u000200\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u00102\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/mini/report/MiniAppDesktopDtReportHelper$Companion;", "", "()V", "DT_APP_POSITION", "", "DT_CUR_PG", "DT_LIST_NAME", "DT_MINI_AD_ID", "DT_MINI_APPLET_PRIMARY_TAB", "DT_MINI_APP_HOST_SCENE", "DT_MINI_APP_ID", "DT_MINI_APP_SOURCE", "DT_MINI_APP_TYPE", "DT_MINI_ITEM_ID", "DT_MINI_MODULE_NAME", "DT_MINI_PARENT_EID", "DT_MINI_PRIMARY_TAB", "DT_MINI_SECONDARY_TAB", "DT_MINI_TAB_NAME", "DT_MINI_TRACE_INFO", "DT_QQ_MINI_APP_TYPE", "", "DT_WX_MINI_APP_TYPE", "EVENT_CLICK", "EVENT_EXP", "MINI_APP_APPLET_CLOSE_BUTTON", "MINI_APP_EM_ADD_APPLET", "MINI_APP_EM_APPLET", "MINI_APP_EM_APPLET_BANNER", "MINI_APP_EM_APPLET_MENU_BUTTON", "MINI_APP_EM_APPLET_NO_RESULT", "MINI_APP_EM_APPLET_PERSONAL_MODULE", "MINI_APP_EM_APPLET_RECENTLY_USE_MODULE", "MINI_APP_EM_APPLET_RECOMMEND_MODULE", "MINI_APP_EM_APPLET_TEENAGER_MODE_TIP", "MINI_APP_EM_DELETE_APPLET", "MINI_APP_EM_LEADERBOARD_MODULE", "MINI_APP_EM_LIMITED_TIME_RECOMMENDED_MODULE", "MINI_APP_EM_PRIMARY_TAB", "MINI_APP_EM_SEARCH_BOX", "MINI_APP_EM_SEE_MORE", "MINI_APP_GOTO_WX_APPLET_BUTTON", "MINI_APP_PG_APPLET_HOME_DROP_DOWN", "MINI_APP_PG_APPLET_PERSONAL_LEVEL2", "MINI_APP_PG_APPLET_RECENTLY_USE_LEVEL2", "MINI_APP_REPORT_KEY_APP_KEY", "TAG", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "Lcom/tencent/mobileqq/mini/report/MiniAppDesktopDtReportHelper;", "getInstance", "()Lcom/tencent/mobileqq/mini/report/MiniAppDesktopDtReportHelper;", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MiniAppDesktopDtReportHelper getInstance() {
            return MiniAppDesktopDtReportHelper.instance;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c2\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/mini/report/MiniAppDesktopDtReportHelper$SingletonHolder;", "", "()V", "holder", "Lcom/tencent/mobileqq/mini/report/MiniAppDesktopDtReportHelper;", "getHolder", "()Lcom/tencent/mobileqq/mini/report/MiniAppDesktopDtReportHelper;", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    private static final class SingletonHolder {
        public static final SingletonHolder INSTANCE = new SingletonHolder();
        private static final MiniAppDesktopDtReportHelper holder = new MiniAppDesktopDtReportHelper(null);

        SingletonHolder() {
        }

        public final MiniAppDesktopDtReportHelper getHolder() {
            return holder;
        }
    }

    public /* synthetic */ MiniAppDesktopDtReportHelper(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final void miniAppDesktopCommonPageReport(String eventId, String eventName, Map<String, String> pageElementMap) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(pageElementMap, "pageElementMap");
        HashMap hashMap = new HashMap();
        if (!pageElementMap.containsKey("pgid")) {
            pageElementMap.put("pgid", MINI_APP_PG_APPLET_HOME_DROP_DOWN);
            hashMap.put("pgid", MINI_APP_PG_APPLET_HOME_DROP_DOWN);
        }
        hashMap.put("cur_pg", pageElementMap);
        if (!TextUtils.isEmpty(eventName)) {
            hashMap.put("eid", eventName);
        }
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0AND06A49O0PML4Z");
        VideoReport.reportEvent(eventId, hashMap);
        QLog.d(TAG, 1, "eventId:" + eventId + " eventName:" + eventName + " eventParams:" + hashMap);
    }

    public final void miniAppDesktopCommonReport(String eventId, String eventName, Map<String, String> elementMap, String pageId) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(elementMap, "elementMap");
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        if (pageId != null) {
            if (pageId.length() == 0) {
                hashMap2.put("pgid", MINI_APP_PG_APPLET_HOME_DROP_DOWN);
                hashMap.put("pgid", MINI_APP_PG_APPLET_HOME_DROP_DOWN);
            } else {
                hashMap2.put("pgid", pageId);
                hashMap.put("pgid", pageId);
            }
        }
        hashMap.put("cur_pg", hashMap2);
        if (!TextUtils.isEmpty(eventName)) {
            hashMap.put("eid", eventName);
        }
        if (!elementMap.isEmpty()) {
            hashMap.putAll(elementMap);
        }
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0AND06A49O0PML4Z");
        VideoReport.reportEvent(eventId, hashMap);
        QLog.d(TAG, 1, "eventId:" + eventId + " eventName:" + eventName + " eventParams:" + hashMap);
    }

    MiniAppDesktopDtReportHelper() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void miniAppDesktopCommonReport$default(MiniAppDesktopDtReportHelper miniAppDesktopDtReportHelper, String str, String str2, Map map, String str3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str2 = "";
        }
        if ((i3 & 4) != 0) {
            map = new HashMap();
        }
        if ((i3 & 8) != 0) {
            str3 = "";
        }
        miniAppDesktopDtReportHelper.miniAppDesktopCommonReport(str, str2, map, str3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void miniAppDesktopCommonPageReport$default(MiniAppDesktopDtReportHelper miniAppDesktopDtReportHelper, String str, String str2, Map map, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str2 = "";
        }
        if ((i3 & 4) != 0) {
            map = new HashMap();
        }
        miniAppDesktopDtReportHelper.miniAppDesktopCommonPageReport(str, str2, map);
    }
}
