package com.qzone.misc.network.report;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes39.dex */
public class d {
    private static boolean c(int i3) {
        if ((i3 & 1024) > 0) {
            return true;
        }
        return false;
    }

    private static void a(String str, String str2, String str3) {
        ClickReport.r("", "", "", true, str, str2, str3);
    }

    public static void d(BusinessFeedData businessFeedData) {
        if (businessFeedData == null || businessFeedData.getFeedCommInfo() == null || businessFeedData.getGoods() == null || businessFeedData.getFeedCommInfo() == null || !c(businessFeedData.getFeedCommInfo().feedsAttr)) {
            return;
        }
        a("30", "4", b(businessFeedData.getGoods().goodsType));
        if (QZLog.isDevelopLevel()) {
            QZLog.d("QZoneGoumaiFeedLuopanReport", 4, "Type:reportAvatarClick");
        }
    }

    public static void e(BusinessFeedData businessFeedData) {
        if (businessFeedData == null || businessFeedData.getFeedCommInfo() == null || businessFeedData.getGoods() == null || businessFeedData.getFeedCommInfo() == null || !c(businessFeedData.getFeedCommInfo().feedsAttr)) {
            return;
        }
        a("30", "3", b(businessFeedData.getGoods().goodsType));
        if (QZLog.isDevelopLevel()) {
            QZLog.d("QZoneGoumaiFeedLuopanReport", 4, "Type:reportBtClick");
        }
    }

    public static void f(BusinessFeedData businessFeedData) {
        if (businessFeedData == null || businessFeedData.getFeedCommInfo() == null || businessFeedData.getGoods() == null || businessFeedData.getFeedCommInfo() == null || !c(businessFeedData.getFeedCommInfo().feedsAttr)) {
            return;
        }
        a("30", "5", b(businessFeedData.getGoods().goodsType));
        if (QZLog.isDevelopLevel()) {
            QZLog.d("QZoneGoumaiFeedLuopanReport", 4, "Type:reportOtherClick");
        }
    }

    public static void g(BusinessFeedData businessFeedData) {
        if (businessFeedData == null || businessFeedData.getFeedCommInfo() == null || businessFeedData.getGoods() == null || businessFeedData.getFeedCommInfo() == null || !c(businessFeedData.getFeedCommInfo().feedsAttr)) {
            return;
        }
        a("30", "2", b(businessFeedData.getGoods().goodsType));
        if (QZLog.isDevelopLevel()) {
            QZLog.d("QZoneGoumaiFeedLuopanReport", 4, "Type:reportPicClick");
        }
    }

    public static String b(int i3) {
        if (i3 == 1) {
            return "huangzuan";
        }
        if (i3 == 2) {
            return "lvzuan";
        }
        if (i3 != 3) {
            return null;
        }
        return "piaowu";
    }
}
