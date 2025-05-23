package com.tencent.biz.pubaccount.weishi.report;

import UserGrowth.stSimpleMetaFeed;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi.comment.m;
import com.tencent.biz.pubaccount.weishi.report.WSStatisticsReporter;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.util.v;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes32.dex */
public class b {
    private static WSStatisticsReporter.Builder a(String str) {
        return new WSStatisticsReporter.Builder().setTabId(e(str)).setSopName(str).setTestId(bb.x(10003)).setPushId(v.b().c()).setFlush(true);
    }

    private static void b(WSStatisticsReporter.Builder builder, String str) {
        builder.build(str).report();
    }

    public static String c(String str) {
        if (WSPublicAccReport.SOP_NAME_VIDEO_PLAY.equals(str)) {
            return "comment_entry";
        }
        if (WSPublicAccReport.SOP_NAME_FOCUS.equals(str)) {
            return "dynamics_comment_entry";
        }
        WSPublicAccReport.SOP_NAME_FOCUS_FALLBACK.equals(str);
        return "dynamics_comment_entry";
    }

    public static String d(String str) {
        if (g(str)) {
            return "comment_page";
        }
        if (WSPublicAccReport.SOP_NAME_FOCUS.equals(str)) {
            return "dynamics_comment_page";
        }
        WSPublicAccReport.SOP_NAME_FOCUS_FALLBACK.equals(str);
        return "dynamics_comment_page";
    }

    public static String e(String str) {
        if (g(str)) {
            return com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.m();
        }
        return "";
    }

    public static String f(String str) {
        if (g(str)) {
            return "comment_tag";
        }
        if (WSPublicAccReport.SOP_NAME_FOCUS.equals(str)) {
            return "dynamics_comment_tag";
        }
        WSPublicAccReport.SOP_NAME_FOCUS_FALLBACK.equals(str);
        return "dynamics_comment_tag";
    }

    public static boolean g(String str) {
        return TextUtils.equals(str, WSPublicAccReport.SOP_NAME_VIDEO_PLAY) || TextUtils.equals(str, "collection_videoplay") || TextUtils.equals(str, "monofeed") || TextUtils.equals(str, "feeds_fullscreen") || TextUtils.equals(str, "drama_fullscreen_videoplay");
    }

    public static void h(m mVar, Map<String, String> map) {
        Map<String, String> g16 = mVar.g();
        if (g16 == null) {
            g16 = new HashMap<>();
        }
        g16.putAll(map);
        t("longpress_jubao", mVar.e(), 1003012, g16, mVar.h());
    }

    public static void i(m mVar, Map<String, String> map) {
        Map<String, String> g16 = mVar.g();
        if (g16 == null) {
            g16 = new HashMap<>();
        }
        g16.putAll(map);
        u("longpress_jubao", mVar.e(), g16, mVar.h());
    }

    public static void l(String str, int i3, int i16, stSimpleMetaFeed stsimplemetafeed) {
        t("dynamics_comment_entry_text" + i3, str, i16, null, stsimplemetafeed);
    }

    public static void p(String str, String str2, int i3, stSimpleMetaFeed stsimplemetafeed, boolean z16, boolean z17, int i16, Map<String, String> map) {
        String str3;
        if (TextUtils.equals(str, WSPublicAccReport.SOP_NAME_FOCUS)) {
            str3 = "dynamics_comment_page_reply" + i3;
        } else if (z16) {
            str3 = "comment_page_reply_explicit";
        } else {
            str3 = "comment_page_reply";
        }
        int i17 = z17 ? 1002002 : 1002003;
        if (map == null) {
            map = new HashMap<>();
        }
        if (!TextUtils.equals(str, WSPublicAccReport.SOP_NAME_FOCUS)) {
            map.put(QCircleLpReportDc05507.KEY_PLAY_SCENE, str2);
        }
        map.put(QCircleSchemeAttr.WebView.OPEN_TYPE, String.valueOf(i16));
        t(str3, str, i17, map, stsimplemetafeed);
    }

    public static void r(String str, String str2, String str3, int i3, stSimpleMetaFeed stsimplemetafeed) {
        HashMap hashMap;
        if (TextUtils.equals(str, WSPublicAccReport.SOP_NAME_FOCUS)) {
            hashMap = null;
        } else {
            hashMap = new HashMap();
            hashMap.put(QCircleLpReportDc05507.KEY_PLAY_SCENE, str2);
        }
        t(str3, str, i3, hashMap, stsimplemetafeed);
    }

    public static void s(String str, String str2, String str3, stSimpleMetaFeed stsimplemetafeed) {
        HashMap hashMap;
        if (TextUtils.equals(str, WSPublicAccReport.SOP_NAME_FOCUS)) {
            hashMap = null;
        } else {
            hashMap = new HashMap();
            hashMap.put(QCircleLpReportDc05507.KEY_PLAY_SCENE, str2);
        }
        u(str3, str, hashMap, stsimplemetafeed);
    }

    public static void t(String str, String str2, int i3, Map<String, String> map, stSimpleMetaFeed stsimplemetafeed) {
        WSStatisticsReporter.Builder addParams = a(str2).addParams(WSPublicAccReport.getInstance().getFeedsBaseParams(str, i3, stsimplemetafeed));
        if (map != null && !map.isEmpty()) {
            addParams.addExtParams(map);
        }
        b(addParams, "gzh_click");
    }

    public static void u(String str, String str2, Map<String, String> map, stSimpleMetaFeed stsimplemetafeed) {
        WSStatisticsReporter.Builder addParams = a(str2).addParams(WSPublicAccReport.getInstance().getFeedsBaseParams(str, 0, stsimplemetafeed));
        if (map != null && !map.isEmpty()) {
            addParams.addExtParams(map);
        }
        b(addParams, "gzh_exposure");
    }

    public static void j(String str, String str2, int i3, stSimpleMetaFeed stsimplemetafeed) {
        t(str, str2, i3, null, stsimplemetafeed);
    }

    public static void k(String str, String str2, int i3, stSimpleMetaFeed stsimplemetafeed) {
        t(str2, str, i3, null, stsimplemetafeed);
    }

    public static void m(String str, String str2, String str3, String str4, String str5, String str6, int i3, stSimpleMetaFeed stsimplemetafeed, Map<String, String> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        if (!TextUtils.equals(str, WSPublicAccReport.SOP_NAME_FOCUS)) {
            map.put(QCircleLpReportDc05507.KEY_PLAY_SCENE, str2);
        }
        map.put("comment_id", str3);
        map.put("comment_reply_id", str4);
        map.put("uid", str5);
        map.put("uid_type", str6);
        map.put("index", String.valueOf(i3 + 1));
        u("comment_page_comment", str, map, stsimplemetafeed);
    }

    public static void n(String str, String str2, String str3, int i3, int i16, stSimpleMetaFeed stsimplemetafeed, int i17, Map<String, String> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        if (!TextUtils.equals(str, WSPublicAccReport.SOP_NAME_FOCUS)) {
            map.put(QCircleLpReportDc05507.KEY_PLAY_SCENE, str2);
        }
        map.put("object", String.valueOf(i16));
        map.put(QCircleSchemeAttr.WebView.OPEN_TYPE, String.valueOf(i17));
        t(str3, str, i3, map, stsimplemetafeed);
    }

    public static void o(String str, String str2, String str3, stSimpleMetaFeed stsimplemetafeed, int i3, Map<String, String> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        if (!TextUtils.equals(str, WSPublicAccReport.SOP_NAME_FOCUS)) {
            map = new HashMap<>();
            map.put(QCircleLpReportDc05507.KEY_PLAY_SCENE, str2);
        }
        map.put(QCircleSchemeAttr.WebView.OPEN_TYPE, String.valueOf(i3));
        u(str3, str, map, stsimplemetafeed);
    }

    public static void q(String str, String str2, stSimpleMetaFeed stsimplemetafeed, Map<String, String> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        if (!TextUtils.equals(str, WSPublicAccReport.SOP_NAME_FOCUS)) {
            map.put(QCircleLpReportDc05507.KEY_PLAY_SCENE, str2);
        }
        map.put("btn_status", "0");
        t("comment_page_send", str, 1000001, map, stsimplemetafeed);
    }

    public static void v(String str, String str2, String str3, String str4, int i3, stSimpleMetaFeed stsimplemetafeed, Map<String, String> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        if (!TextUtils.equals(str2, WSPublicAccReport.SOP_NAME_FOCUS)) {
            map.put(QCircleLpReportDc05507.KEY_PLAY_SCENE, str3);
        }
        map.put("uid", str4);
        map.put("uid_type", "1");
        map.put("index", String.valueOf(i3 + 1));
        t(str, str2, 1000001, map, stsimplemetafeed);
    }
}
