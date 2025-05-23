package com.tencent.biz.pubaccount.weishi.recommend;

import UserGrowth.stCollection;
import UserGrowth.stH5OpInfo;
import UserGrowth.stOpVideo;
import UserGrowth.stReportItem;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stVideoTag;
import UserGrowth.stWaterFallItemStrategy;
import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi.report.WSStatisticsReporter;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a {
    private static WSStatisticsReporter.Builder a(String str, String str2, int i3, String str3) {
        return new WSStatisticsReporter.Builder().setSopName(str).setTabId(str3).setTestId(bb.x(i3)).setPushId(WSPublicAccReport.getInstance().getPushId()).setOperationId(str2).setFlush(true);
    }

    private static void b(WSStatisticsReporter.Builder builder, String str) {
        builder.build(str).report();
    }

    public static void c(String str, stSimpleMetaFeed stsimplemetafeed, stReportItem streportitem, int i3, String str2) {
        b(a("feeds", "", 1, str2).addParams(WSPublicAccReport.getInstance().getFeedsBaseParams("feeds_video" + streportitem.upos, i3, stsimplemetafeed)).addExtParams(e(stsimplemetafeed, streportitem)), str);
    }

    private static Map<String, String> e(stSimpleMetaFeed stsimplemetafeed, stReportItem streportitem) {
        String str;
        String str2;
        stVideoTag stvideotag;
        stVideoTag stvideotag2;
        stCollection stcollection;
        HashMap hashMap = new HashMap();
        String str3 = "";
        if (stsimplemetafeed == null || (stcollection = stsimplemetafeed.collection) == null) {
            str = "";
        } else {
            str = stcollection.cid;
        }
        hashMap.put("collection_id", str);
        hashMap.put("cardtype", String.valueOf(streportitem.card_type));
        hashMap.put("poolType", String.valueOf(streportitem.pool_type));
        hashMap.put("ratioW", String.valueOf(streportitem.ratioW));
        hashMap.put("ratioH", String.valueOf(streportitem.ratioH));
        hashMap.put("isFullSpan", String.valueOf(streportitem.isFullSpan));
        hashMap.put("type", String.valueOf(streportitem.video_type));
        hashMap.put("opvideo_type", d(stsimplemetafeed));
        hashMap.put("material_type", d(stsimplemetafeed));
        hashMap.put(ProfileCardDtReportUtil.DT_REPORT_PARAM_COVER_TYPE, bb.i(stsimplemetafeed));
        hashMap.put("isCallWeishi", h(stsimplemetafeed));
        hashMap.put("isDownloadWeishi", i(stsimplemetafeed));
        if (stsimplemetafeed == null || (stvideotag2 = stsimplemetafeed.videoTag) == null) {
            str2 = "";
        } else {
            str2 = String.valueOf(stvideotag2.tagId);
        }
        hashMap.put("tag_id", str2);
        if (stsimplemetafeed != null && (stvideotag = stsimplemetafeed.bottomTag) != null) {
            str3 = String.valueOf(stvideotag.tagId);
        }
        hashMap.put("label_type", str3);
        return hashMap;
    }

    private static Map<String, String> f(String str, boolean z16) {
        String str2;
        HashMap hashMap = new HashMap();
        if (str == null) {
            str = "";
        }
        hashMap.put("micro_drama_id", str);
        if (z16) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        hashMap.put("is_update", str2);
        return hashMap;
    }

    private static Map<String, String> g(int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put("position", "history_drama_card" + (i3 + 1));
        hashMap.put("feed_id", "");
        hashMap.put("owner_id", "");
        return hashMap;
    }

    public static void j(int i3, int i16, int i17, stCollection stcollection, stSimpleMetaFeed stsimplemetafeed, String str) {
        Map<String, String> feedsBaseParams = WSPublicAccReport.getInstance().getFeedsBaseParams("feeds_item_card" + (i3 + 1), i17, stsimplemetafeed);
        HashMap hashMap = new HashMap();
        hashMap.put("index", String.valueOf(i16 + 1));
        hashMap.put("collection_id", stcollection.cid);
        b(a("feeds", "", 1, str).addParams(feedsBaseParams).addExtParams(hashMap), "gzh_click");
    }

    public static void k(int i3, stSimpleMetaFeed stsimplemetafeed, String str, String str2) {
        Map<String, String> feedsBaseParams = WSPublicAccReport.getInstance().getFeedsBaseParams("feeds_item_card" + (i3 + 1), 0, stsimplemetafeed);
        HashMap hashMap = new HashMap();
        hashMap.put("feeds_item_list", str);
        b(a("feeds", "", 1, str2).addParams(feedsBaseParams).addExtParams(hashMap), "gzh_exposure");
    }

    public static void l(int i3, String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("position", "feeds_loadmore_request");
        hashMap.put("feed_id", "");
        hashMap.put("owner_id", "");
        HashMap hashMap2 = new HashMap();
        hashMap2.put("failure_type", String.valueOf(i3));
        hashMap2.put("feedid_list", str);
        hashMap2.put("traceid_list", str2);
        b(a("feeds", "", 1, str3).addParams(hashMap).addExtParams(hashMap2), "gzh_exposure");
    }

    public static void m(boolean z16, boolean z17, int i3, String str) {
        String str2;
        HashMap hashMap = new HashMap();
        hashMap.put("position", "feeds_refresh_request");
        hashMap.put("feed_id", "");
        hashMap.put("owner_id", "");
        HashMap hashMap2 = new HashMap();
        hashMap2.put("failure_type", String.valueOf(i3));
        if (z16 || z17) {
            if (z16) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            hashMap2.put("is_auto_refresh", str2);
        }
        b(a("feeds", "", 1, str).addParams(hashMap).addExtParams(hashMap2), "gzh_exposure");
    }

    public static void n(String str, int i3, String str2, boolean z16) {
        Map<String, String> g16 = g(i3);
        g16.put("action_id", "1000001");
        b(a("feeds", "", 1, str).addParams(g16).addExtParams(f(str2, z16)), "gzh_click");
    }

    public static void o(String str, int i3, String str2, boolean z16) {
        Map<String, String> g16 = g(i3);
        b(a("feeds", "", 1, str).addParams(g16).addExtParams(f(str2, z16)), "gzh_exposure");
    }

    public static void p(String str, int i3, int i16, int i17, String str2, String str3) {
        Map<String, String> feedsBaseParamsWithoutFeed = WSPublicAccReport.getInstance().getFeedsBaseParamsWithoutFeed("msg_extry", i16);
        feedsBaseParamsWithoutFeed.put("global_key", com.tencent.biz.pubaccount.weishi.report.c.b().c(str2));
        HashMap hashMap = new HashMap();
        hashMap.put("type", String.valueOf(i3));
        b(a("feeds", String.valueOf(i17), 4, str3).addParams(feedsBaseParamsWithoutFeed).addExtParams(hashMap), str);
    }

    public static void q(String str, int i3, stSimpleMetaFeed stsimplemetafeed, String str2) {
        stH5OpInfo sth5opinfo;
        Map<String, String> map;
        String str3;
        Map<String, String> feedsBaseParams = WSPublicAccReport.getInstance().getFeedsBaseParams("opcard", i3, stsimplemetafeed);
        if (stsimplemetafeed == null || (sth5opinfo = stsimplemetafeed.h5_op_info) == null) {
            sth5opinfo = null;
            map = null;
        } else {
            map = sth5opinfo.exp;
        }
        if (sth5opinfo != null) {
            str3 = String.valueOf(sth5opinfo.f25120id);
        } else {
            str3 = "";
        }
        b(a("feeds", str3, 1, str2).addParams(feedsBaseParams).addExtParams(map), str);
    }

    public static void r(stSimpleMetaFeed stsimplemetafeed, int i3, int i16, int i17, String str) {
        Map<String, String> feedsBaseParams = WSPublicAccReport.getInstance().getFeedsBaseParams("feeds_data", 0, stsimplemetafeed);
        HashMap hashMap = new HashMap();
        hashMap.put("preload_status", String.valueOf(i3));
        hashMap.put("feeds_list_type", String.valueOf(i16));
        hashMap.put("preload_count", String.valueOf(i17));
        b(a("feeds", "", 1, str).addParams(feedsBaseParams).addExtParams(hashMap), "gzh_exposure");
    }

    private static String d(stSimpleMetaFeed stsimplemetafeed) {
        stOpVideo stopvideo;
        return String.valueOf((stsimplemetafeed == null || (stopvideo = stsimplemetafeed.opVideo) == null) ? 0 : stopvideo.videoType);
    }

    private static String h(stSimpleMetaFeed stsimplemetafeed) {
        stWaterFallItemStrategy stwaterfallitemstrategy;
        if (stsimplemetafeed != null && (stwaterfallitemstrategy = stsimplemetafeed.waterFallItemStrategy) != null && stwaterfallitemstrategy.isCallWeishi) {
            return "1";
        }
        return "0";
    }

    private static String i(stSimpleMetaFeed stsimplemetafeed) {
        stWaterFallItemStrategy stwaterfallitemstrategy;
        if (stsimplemetafeed != null && (stwaterfallitemstrategy = stsimplemetafeed.waterFallItemStrategy) != null && stwaterfallitemstrategy.isDonwloadWeish) {
            return "1";
        }
        return "0";
    }
}
