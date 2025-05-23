package com.tencent.gamematrix.gmcg.sdk.nonage.report;

import androidx.annotation.Nullable;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.gamematrix.gmcg.sdk.config.CGGlbConfig;
import com.tencent.gamematrix.gmcg.sdk.nonage.CGNonAgeProtectModule;
import com.tencent.gamematrix.gmcg.webrtc.monitor.CGTdmDataReport;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGNonAgeReport {
    public static final String EVENT_ACTION = "action";
    public static final String EVENT_APP_CHANNEL = "app_version";
    public static final String EVENT_CHANNEL = "channel_info";
    public static final String EVENT_DATA = "date";
    public static final String EVENT_EXTRA_INFO = "extra_info";
    public static final String EVENT_GAME_ID = "game_id";
    public static final String EVENT_NAME = "event_name";
    public static final String EVENT_PAGE_NAME = "page_name";
    public static final String EVENT_TIME = "event_time";
    public static final String EVENT_TYPE = "event_type";
    public static final String EVENT_UID = "uid";

    public static String getCurrentInString() {
        return new SimpleDateFormat(DateUtil.DATE_FORMAT_14).format(new Date());
    }

    public static void report(@Nullable Map<String, String> map) {
        if (map == null) {
            return;
        }
        map.put(EVENT_CHANNEL, CGGlbConfig.getAppBizNo());
        map.put("app_version", "3.0.0.241111110.3.9-SNAPSHOT");
        map.put("platform_type", "SDK");
        map.put("event_time", getCurrentInString());
        map.put("date", getCurrentInString());
        map.put("game_id", CGNonAgeProtectModule.getInstance().getGameId());
        CGTdmDataReport.reportData(20016, "ufo_business_data", map);
    }

    public static void reportLoginSuccess() {
    }

    public static void reportQrCodeShow() {
    }

    public static void reportDialogShow(String str, String str2) {
    }

    public static void reportDialogClick(String str, String str2, boolean z16) {
    }
}
