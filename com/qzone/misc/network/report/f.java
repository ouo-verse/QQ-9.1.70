package com.qzone.misc.network.report;

import android.content.Context;
import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import cooperation.qzone.util.QZLog;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes39.dex */
public class f {
    public static String h(BusinessFeedData businessFeedData) {
        if (businessFeedData != null && businessFeedData.isAdFeeds() && businessFeedData.getOperationInfoV2() != null && businessFeedData.getOperationInfoV2().cookie.size() > 0) {
            String str = businessFeedData.getOperationInfoV2().cookie.get(0);
            if (str.equals("outlink")) {
                return "outlink";
            }
            if (str.equals("app")) {
                return "app";
            }
            if (str.equals("page")) {
                return "certify_page";
            }
            if (str.equals("page_outlink")) {
                return "certify_page_outlink";
            }
        }
        return "not_ads";
    }

    public static String i(int i3, int i16) {
        return "{\"click_scene\":\"" + i3 + "\",\"click_pos\":\"" + i16 + "\",\"pos_attribute\":\"0\"}";
    }

    public static String j(int i3, int i16, int i17) {
        return "{\"click_scene\":\"" + i3 + "\",\"click_pos\":\"" + i16 + "\",\"pos_attribute\":\"" + i17 + "\",\"click_time\":\"" + String.valueOf(System.currentTimeMillis()) + "\"}";
    }

    public static int l(int i3) {
        if (i3 == 17) {
            return 5001;
        }
        return i3;
    }

    public static void m(String str, Context context, String str2, BusinessFeedData businessFeedData) {
        if (businessFeedData.isGDTAdvFeed()) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("businessFeedData", businessFeedData);
        yo.d.e(str, context, str2, hashMap);
    }

    public static void b(BusinessFeedData businessFeedData, int i3, int i16) {
        c(businessFeedData, i3, i16, true);
    }

    public static void a(BusinessFeedData businessFeedData, int i3, int i16) {
        if (businessFeedData == null || !businessFeedData.isGDTAdvFeed()) {
            return;
        }
        QZoneWriteOperationService.v0().L(businessFeedData.getOperationInfo().cookie, i3, 0, 0, 0, i16, false, false, null, null, 0L, false, false, null, true, businessFeedData);
    }

    public static void c(BusinessFeedData businessFeedData, int i3, int i16, boolean z16) {
        if (businessFeedData == null || !businessFeedData.isBrandUgcAdvFeeds() || i3 == 0) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("click_scene", i3 + "");
            jSONObject.put("click_pos", i16 + "");
        } catch (JSONException e16) {
            QZLog.w("VideoTopicReport", "JSON err:" + e16);
        }
        QZoneWriteOperationService.v0().L(businessFeedData.getOperationInfo().cookie, z16 ? 5001 : 5000, 0, 0, 0, 0, false, false, null, null, 0L, false, false, jSONObject.toString(), false, businessFeedData);
    }

    private static void d(BusinessFeedData businessFeedData, int i3) {
        if (businessFeedData == null || !businessFeedData.isBrandUgcAdvFeeds()) {
            return;
        }
        QZoneWriteOperationService.v0().L(businessFeedData.getOperationInfo().cookie, i3, 0, 0, 0, 0, false, false, null, null, 0L, false, false, null, true, businessFeedData);
    }

    public static void e(BusinessFeedData businessFeedData) {
        d(businessFeedData, 2009);
    }

    public static void n(BusinessFeedData businessFeedData) {
        d(businessFeedData, 2010);
    }

    public static void o(BusinessFeedData businessFeedData) {
        d(businessFeedData, 2011);
    }

    public static void p(BusinessFeedData businessFeedData) {
        d(businessFeedData, 2007);
    }

    public static void f(BusinessFeedData businessFeedData) {
        a(businessFeedData, 2013, 1);
    }

    public static void g(BusinessFeedData businessFeedData) {
        a(businessFeedData, 2013, 0);
    }

    public static String k(int i3, String str) {
        return i3 == 17 ? i(0, 6) : str;
    }
}
