package com.tencent.mobileqq.panel.bubble;

import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.panel.FontBubble;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.api.DefaultTVKDataProvider;
import com.tencent.util.URLUtil;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.qzone.mobilereport.MobileReportManager;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public class d {
    static IPatchRedirector $redirector_;

    private static String a(int i3) {
        if (i3 == 3) {
            return WadlProxyConsts.OPER_TYPE_MONITOR;
        }
        return "31";
    }

    private static String b(int i3) {
        if (i3 == 3) {
            return "3001021";
        }
        return "3001001";
    }

    private static String c(int i3) {
        if (i3 != 2) {
            if (i3 != 4) {
                if (i3 != 5) {
                    if (i3 != 21) {
                        if (i3 != 22) {
                            return "unknown";
                        }
                    }
                }
                return "svip";
            }
            return "vip";
        }
        return "antiao";
    }

    public static String d(String str, int i3, int i16, String str2) {
        String str3;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        if (str.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
            str3 = "&trace_detail=base64-";
        } else {
            str3 = "?trace_detail=base64-";
        }
        try {
            jSONObject.put("appid", "DressVip");
            jSONObject.put("page_id", b(i3));
            jSONObject.put("module_id", a(i3));
            jSONObject.put("item_id", String.valueOf(i16));
            jSONObject.put("item_type", b(i3));
            jSONObject.put("str_ruleid", str2);
            return str3 + com.tencent.mobileqq.musicpendant.a.f(jSONObject.toString());
        } catch (Exception e16) {
            QLog.e("VasAioRecommendReporter", 1, "json exception" + e16);
            return str3;
        }
    }

    public static void e(int i3, int i16, String str) {
        MobileReportManager.getInstance().reportAction("DressVip", b(i3), a(i3), "", String.valueOf(i16), b(i3), 102, 0, str);
    }

    public static void f(int i3, int i16, String str) {
        MobileReportManager.getInstance().reportAction("DressVip", b(i3), a(i3), "", String.valueOf(i16), b(i3), 101, 0, str);
    }

    public static void g(int i3, int i16, String str) {
        MobileReportManager.getInstance().reportAction("DressVip", b(i3), a(i3), "", String.valueOf(i16), b(i3), 113, 0, str);
    }

    public static void h(FontBubble fontBubble, String str) {
        int i3;
        String str2 = "";
        int i16 = fontBubble.panelType;
        if (i16 == 3) {
            i3 = fontBubble.fontId;
        } else {
            i3 = fontBubble.bubbleId;
        }
        try {
            String a16 = cc2.c.a(URLUtil.decodeUrl(fontBubble.payUrl), "tpd");
            if (a16 != null && !a16.isEmpty()) {
                str2 = new JSONObject().put("aid", new JSONObject(a16).optString("aid", "")).put(DefaultTVKDataProvider.KEY_PAY_TYPE, c(fontBubble.feeType)).toString();
            }
        } catch (IllegalArgumentException e16) {
            QLog.e("VasAioRecommendReporter", 1, "reportRecommendOpenPay: decode payUrl error. " + e16.getMessage());
        } catch (JSONException e17) {
            QLog.e("VasAioRecommendReporter", 1, "reportRecommendOpenPay: get urlParam tpd error. " + e17.getMessage());
        }
        MobileReportManager.getInstance().reportAction("DressVip", b(i16), a(i16), "", String.valueOf(i3), "", b(i16), 109, fontBubble.price, 0, str, str2, "");
    }

    public static void i(int i3, String str) {
        MobileReportManager.getInstance().reportAction("DressVip", b(i3), a(i3), "", "view_more", "4", 102, 0, str);
    }

    public static void j(int i3, String str) {
        MobileReportManager.getInstance().reportAction("DressVip", b(i3), a(i3), "", "", "", 111, 0, str);
    }
}
