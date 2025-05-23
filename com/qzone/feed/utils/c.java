package com.qzone.feed.utils;

import com.qzone.common.account.LoginData;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellAlbumEntrance;
import com.qzone.util.ak;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.vip.pb.TianShuAccess;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class c {
    private static TianShuAccess.AdItem c(BusinessFeedData businessFeedData) {
        CellAlbumEntrance cellAlbumEntrance = businessFeedData.cellAlbumEntrance;
        if (cellAlbumEntrance == null) {
            QLog.d("MakeDynamicUtil", 1, "genAdItem, albumEntrance is null ");
            return null;
        }
        Map<String, String> map = cellAlbumEntrance.busi_param;
        if (map != null && !map.isEmpty()) {
            try {
                String str = map.get("tianshu_adid");
                int parseInt = Integer.parseInt(map.get("tianshu_itemid"));
                String str2 = map.get("tianshu_traceinfo");
                QLog.d("MakeDynamicUtil", 1, "genAdItem, adId: " + str + ", itemId: " + parseInt + ", traceInfo: " + str2);
                TianShuAccess.AdItem adItem = new TianShuAccess.AdItem();
                adItem.iAdId.set(parseInt);
                adItem.traceinfo.set(str2);
                return adItem;
            } catch (Exception e16) {
                QLog.w("MakeDynamicUtil", 1, "genAdItem, error ", e16);
                return null;
            }
        }
        QLog.d("MakeDynamicUtil", 1, "genAdItem, busiParam is null or empty ");
        return null;
    }

    public static int d() {
        return u5.b.H("MAKE_DYNAMIC_STATUS", 1, LoginData.getInstance().getUin());
    }

    public static void f(BusinessFeedData businessFeedData) {
        j(businessFeedData);
        LpReportInfo_pf00064.allReport(87, 7, 2);
    }

    public static boolean h(BusinessFeedData businessFeedData) {
        return k(businessFeedData);
    }

    public static void i(int i3) {
        u5.b.r0("MAKE_DYNAMIC_STATUS", i3, LoginData.getInstance().getUin());
    }

    private static void j(BusinessFeedData businessFeedData) {
        TianShuAccess.AdItem c16 = c(businessFeedData);
        if (c16 == null) {
            return;
        }
        QLog.d("MakeDynamicUtil", 1, "tianShuReportQCircleClick ");
        ak.g(c16, 102);
    }

    private static boolean k(BusinessFeedData businessFeedData) {
        TianShuAccess.AdItem c16 = c(businessFeedData);
        if (c16 == null) {
            return false;
        }
        QLog.d("MakeDynamicUtil", 1, "tianShuReportQCircleExpose ");
        ak.g(c16, 101);
        return true;
    }

    public static void a() {
        LpReportInfo_pf00064.allReport(87, 1, 1, "0");
    }

    public static void b() {
        LpReportInfo_pf00064.allReport(87, 1, 1, "1");
    }

    public static void e() {
        LpReportInfo_pf00064.allReport(87, 1, 2);
    }

    public static void g(BusinessFeedData businessFeedData) {
        LpReportInfo_pf00064.allReport(87, 7, 1);
    }
}
