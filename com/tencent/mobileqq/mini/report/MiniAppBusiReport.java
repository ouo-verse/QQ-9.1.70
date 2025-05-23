package com.tencent.mobileqq.mini.report;

import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppBusiReport {
    public static final String ACTION_SHOPPING_FOLDER = "shopping_folder";
    public static final String RESERVE_ACTION_MESSAGE = "message";
    public static final String RESERVE_ACTION_SEARCH = "search";
    public static final String SUB_ACTION_CLICK = "click";
    public static final String SUB_ACTION_EXPO = "expo";
    public static final String TAG = "MiniAppBusiReport";
    public static long lastEschopExpoReportTime;

    public static void report(String str, String str2, String str3, String str4) {
        QLog.d(TAG, 2, "report actionType:" + str + "  subAction:" + str2 + " reserves:" + str3 + "  reserves2:" + str4);
        MiniProgramLpReportDC04239.reportAsync(str, str2, str3, str4);
    }

    public static void reportEshopExpo(String str, String str2) {
        if (System.currentTimeMillis() > lastEschopExpoReportTime + QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.SECONDARY_KEY_MINI_APP_ECSHOP_EXPO_TIME_LIMIT, 2000)) {
            report("shopping_folder", "expo", str, str2);
            lastEschopExpoReportTime = System.currentTimeMillis();
        }
    }
}
