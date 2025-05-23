package com.tencent.biz.pubaccount.weishi.verticalvideo.report;

import UserGrowth.stFeedOpInfo;
import UserGrowth.stJumpInfo;
import UserGrowth.stOpVideo;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stVideoTag;
import android.net.Uri;
import android.text.TextUtils;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.biz.pubaccount.weishi.player.WSPlayerWrapper;
import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi.report.WSStatisticsReporter;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.util.r;
import com.tencent.biz.pubaccount.weishi.util.v;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.pubaccount.weishi.verticalvideo.data.j;
import com.tencent.biz.pubaccount.weishi.verticalvideo.utils.e;
import com.tencent.biz.qqstory.utils.l;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamematrix.gmcg.sdk.nonage.report.CGNonAgeReport;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.qqnt.kernel.nativeinterface.RichErrorCode;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes32.dex */
public class c {

    /* renamed from: b, reason: collision with root package name */
    private static int f82287b;

    /* renamed from: c, reason: collision with root package name */
    private static String f82288c;

    /* renamed from: d, reason: collision with root package name */
    private static String f82289d;

    /* renamed from: a, reason: collision with root package name */
    private static final Set<String> f82286a = new HashSet();

    /* renamed from: e, reason: collision with root package name */
    private static String f82290e = "";

    public static void A(String str, String str2, stSimpleMetaFeed stsimplemetafeed, Map<String, String> map) {
        t(str, str2, "like", stsimplemetafeed, 1001003, "", map);
    }

    public static void B(String str, String str2, stSimpleMetaFeed stsimplemetafeed, Map<String, String> map) {
        E(str, str2, "drama_updated", stsimplemetafeed, "", map);
    }

    public static void C(String str, String str2, stSimpleMetaFeed stsimplemetafeed, int i3, Map<String, String> map) {
        t(str, str2, "drama_follow", stsimplemetafeed, i3, "", map);
    }

    public static void D(List<j> list, boolean z16, boolean z17, int i3, String str, String str2) {
        String str3;
        String str4;
        stSimpleMetaFeed stsimplemetafeed;
        HashMap hashMap = new HashMap();
        if (z16) {
            str3 = "1";
        } else {
            str3 = "2";
        }
        hashMap.put("trigger_type", str3);
        if (z17) {
            str4 = "true";
        } else {
            str4 = "false";
        }
        hashMap.put("request_result", str4);
        if (!z17) {
            hashMap.put("failure_type", String.valueOf(i3));
            E(str, str2, "floating_layer_request", null, "", hashMap);
            return;
        }
        if (list != null && list.size() > 0 && (list.get(0).e() instanceof stSimpleMetaFeed)) {
            stSimpleMetaFeed e16 = list.get(0).e();
            StringBuilder sb5 = new StringBuilder();
            for (j jVar : list) {
                if (!TextUtils.isEmpty(jVar.e().f25129id)) {
                    sb5.append(jVar.e().f25129id);
                    sb5.append("_");
                }
            }
            if (list.size() > 1) {
                sb5.deleteCharAt(sb5.length() - 1);
            }
            hashMap.put("feedid_list", sb5.toString());
            stsimplemetafeed = e16;
        } else {
            hashMap.put("feedid_list", "");
            stsimplemetafeed = null;
        }
        E(str, str2, "floating_layer_request", stsimplemetafeed, "", hashMap);
    }

    public static void E(String str, String str2, String str3, stSimpleMetaFeed stsimplemetafeed, String str4, Map<String, String> map) {
        WSStatisticsReporter.Builder operationId = a(str).addParams(WSPublicAccReport.getInstance().getFeedsBaseParams(str3, 0, stsimplemetafeed)).setOperationId(str4);
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(QCircleLpReportDc05507.KEY_PLAY_SCENE, str2);
        operationId.addExtParams(map);
        b(operationId, "gzh_exposure");
    }

    public static void G(String str, String str2, stSimpleMetaFeed stsimplemetafeed, Map<String, String> map) {
        E(str, str2, "mini_videoplay_tips", stsimplemetafeed, "", map);
    }

    public static void H(String str, String str2, stSimpleMetaFeed stsimplemetafeed, Map<String, String> map) {
        t(str, str2, "follow", stsimplemetafeed, RichErrorCode.KUNKNOW, "", map);
    }

    public static void I(int i3, stSimpleMetaFeed stsimplemetafeed, String str, String str2) {
        t(str, str2, "gamevideo.save", stsimplemetafeed, i3, "", null);
    }

    public static void J(stSimpleMetaFeed stsimplemetafeed, String str, String str2) {
        E(str, str2, "gamevideo.save", stsimplemetafeed, "", null);
    }

    public static void K(String str, String str2, stSimpleMetaFeed stsimplemetafeed) {
        t(str, str2, "home_icon", stsimplemetafeed, 1000001, "", null);
    }

    public static void N(String str, String str2, stSimpleMetaFeed stsimplemetafeed) {
        String str3;
        HashMap hashMap = new HashMap();
        if (stsimplemetafeed != null) {
            str3 = i(stsimplemetafeed.opVideo);
        } else {
            str3 = "0";
        }
        hashMap.put("material_type", str3);
        t(str, str2, "more_operations", stsimplemetafeed, 1000001, "", hashMap);
    }

    public static void O(String str, String str2, Map<String, String> map) {
        if (!TextUtils.isEmpty(str2)) {
            map.put(QCircleLpReportDc05507.KEY_PLAY_SCENE, str2);
        }
        WSPublicAccReport.getInstance().reportPageVisitEnter(str, map);
    }

    public static void P(String str, String str2, Map<String, String> map) {
        if (!TextUtils.isEmpty(str2)) {
            map.put(QCircleLpReportDc05507.KEY_PLAY_SCENE, str2);
        }
        WSPublicAccReport.getInstance().reportPageVisitExit(str, map);
    }

    public static void Q(String str, String str2, int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put("status_type", String.valueOf(i3));
        t(str, str2, "quit_btn", null, 1000001, "", hashMap);
    }

    private static void R(String str, String str2, String str3, String str4, j jVar, Map<String, String> map, int i3) {
        String str5;
        int i16;
        stFeedOpInfo stfeedopinfo;
        stSimpleMetaFeed e16 = jVar.e();
        if (e16 != null && (stfeedopinfo = e16.opInfo) != null) {
            str5 = stfeedopinfo.traceId;
            i16 = e16.video_type;
        } else {
            str5 = "";
            i16 = 0;
        }
        map.put(QCircleLpReportDc05507.KEY_PLAY_SCENE, str4);
        map.put("type", String.valueOf(i16));
        b(a(str2).addParams(WSPublicAccReport.getInstance().getFeedsBaseParams(str3, i3, e16, str5, "")).addExtParams(map), str);
    }

    public static void S(String str, String str2, int i3, j jVar, String str3, boolean z16) {
        T(str, str2, "videotag_rich", i3, jVar, str3, z16, null);
    }

    public static void U(String str, String str2, String str3, int i3, j jVar, boolean z16, Map<String, String> map) {
        T(str, str2, str3, i3, jVar, "", z16, map);
    }

    public static void V(String str, String str2, j jVar) {
        W(str, str2, "videotag_rich", jVar, false, null);
    }

    public static void Y(String str, String str2, stSimpleMetaFeed stsimplemetafeed, Map<String, String> map) {
        E(str, str2, "comment_roll", stsimplemetafeed, "", map);
    }

    public static void Z(String str, String str2, stSimpleMetaFeed stsimplemetafeed, Map<String, String> map) {
        E(str, str2, "hot_comment_look", stsimplemetafeed, "", map);
    }

    private static WSStatisticsReporter.Builder a(String str) {
        return new WSStatisticsReporter.Builder().setTabId(f82289d).setSopName(l(str)).setTestId(n(str)).setPushId(v.b().c()).setFlush(true);
    }

    private static void b(WSStatisticsReporter.Builder builder, String str) {
        builder.build(str).report();
    }

    public static void b0(String str, String str2, stSimpleMetaFeed stsimplemetafeed, Map<String, String> map) {
        E(str, str2, "forward", stsimplemetafeed, "", map);
    }

    private static void c(Map<String, String> map, int i3) {
        map.put("commerce_type", e(i3));
        map.put("businesstag_type", String.valueOf(i3));
    }

    public static void c0(String str, String str2, int i3, stSimpleMetaFeed stsimplemetafeed, Map<String, String> map) {
        t(str, str2, "forward", stsimplemetafeed, i3, "", map);
    }

    private static void d(Map<String, String> map, String str) {
        try {
            Uri parse = Uri.parse(str);
            String queryParameter = parse.getQueryParameter("roomid");
            String queryParameter2 = parse.getQueryParameter("source");
            map.put(AudienceReportConst.ROOM_ID, queryParameter);
            map.put("source", queryParameter2);
        } catch (Exception e16) {
            x.d(e16.getLocalizedMessage());
        }
    }

    private static String f(String str) {
        if (TextUtils.equals(str, "recommend_tab")) {
            return f82288c;
        }
        return "";
    }

    private static int g(String str) {
        if (TextUtils.equals(str, "recommend_tab")) {
            return f82287b + 1;
        }
        return 0;
    }

    private static Map<String, String> h(String str, int i3, stSimpleMetaFeed stsimplemetafeed, Map<String, String> map) {
        String str2;
        String str3;
        HashMap hashMap = new HashMap();
        if (map != null) {
            hashMap.putAll(map);
        }
        hashMap.put("poolType", String.valueOf(stsimplemetafeed.videoPoolType));
        hashMap.put("type", String.valueOf(stsimplemetafeed.video_type));
        stOpVideo stopvideo = stsimplemetafeed.opVideo;
        hashMap.put("opvideo_type", i(stopvideo));
        hashMap.put("material_type", i(stopvideo));
        hashMap.put(ProfileCardDtReportUtil.DT_REPORT_PARAM_COVER_TYPE, bb.j(stsimplemetafeed, false));
        stVideoTag stvideotag = stsimplemetafeed.videoTag;
        String str4 = "0";
        if (stvideotag == null) {
            str2 = "0";
        } else {
            str2 = String.valueOf(stvideotag.tagId);
        }
        hashMap.put("tag_id", str2);
        stVideoTag stvideotag2 = stsimplemetafeed.bottomTag;
        if (stvideotag2 == null) {
            str3 = "0";
        } else {
            str3 = String.valueOf(stvideotag2.tagId);
        }
        hashMap.put("feeds_label_type", str3);
        if (r.u(stsimplemetafeed.poster)) {
            str4 = "1";
        }
        hashMap.put("is_livenow", str4);
        hashMap.put("feeds_index", String.valueOf(g(str)));
        hashMap.put("feeds_feedid", f(str));
        WSPublicAccReport.b recommendFullScreenInfo = WSPublicAccReport.getInstance().getRecommendFullScreenInfo();
        if (i3 == 0 && recommendFullScreenInfo.b()) {
            hashMap.put("is_cache_info", String.valueOf(recommendFullScreenInfo.d()));
            hashMap.put("is_cache_file", String.valueOf(recommendFullScreenInfo.c()));
            hashMap.put("exp_duration", String.valueOf(recommendFullScreenInfo.a()));
        }
        return hashMap;
    }

    public static void h0(String str, String str2, stSimpleMetaFeed stsimplemetafeed, Map<String, String> map) {
        t(str, str2, "video_title", stsimplemetafeed, !l.c(BaseApplicationImpl.getApplication()) ? 1000002 : 1000003, "", map);
    }

    private static int j(int i3) {
        if (i3 == 5) {
            return 0;
        }
        if (i3 == 3) {
            return 1;
        }
        return 2;
    }

    private static String k(ez.a aVar) {
        if ((aVar instanceof ez.b) && ((ez.b) aVar).e() == 9) {
            return "4";
        }
        if (aVar != null) {
            return String.valueOf(aVar.d());
        }
        return "";
    }

    public static void k0(String str) {
        f82288c = str;
    }

    public static String l(String str) {
        if (TextUtils.equals(str, "aio_home_page")) {
            return "monofeed";
        }
        if (!TextUtils.equals(str, "vertical_layer_collection") && !TextUtils.equals(str, "vertical_layer_collection_of_card")) {
            if (!TextUtils.equals(str, "drama_preview") && !TextUtils.equals(str, "drama_history") && !TextUtils.equals(str, "drama_collection")) {
                if (TextUtils.equals(str, "essence_tab")) {
                    return "monofeed";
                }
                return WSPublicAccReport.SOP_NAME_VIDEO_PLAY;
            }
            return "drama_fullscreen_videoplay";
        }
        return "collection_videoplay";
    }

    public static void l0(int i3) {
        f82287b = i3;
    }

    public static String m() {
        return f82289d;
    }

    public static void m0(String str) {
        f82289d = str;
    }

    public static String n(String str) {
        if (TextUtils.equals(str, "follow_tab")) {
            String x16 = bb.x(10);
            return TextUtils.isEmpty(x16) ? bb.x(9) : x16;
        }
        return bb.x(e.l(str));
    }

    public static void q(String str, String str2, stSimpleMetaFeed stsimplemetafeed) {
        t(str, str2, "back_homepage", stsimplemetafeed, 1000001, "", null);
    }

    public static void s(String str, String str2, stSimpleMetaFeed stsimplemetafeed, Map<String, String> map) {
        t(str, str2, "drama_clear", stsimplemetafeed, 1000001, "", map);
    }

    public static void t(String str, String str2, String str3, stSimpleMetaFeed stsimplemetafeed, int i3, String str4, Map<String, String> map) {
        WSStatisticsReporter.Builder operationId = a(str).addParams(WSPublicAccReport.getInstance().getFeedsBaseParams(str3, i3, stsimplemetafeed)).setOperationId(str4);
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(QCircleLpReportDc05507.KEY_PLAY_SCENE, str2);
        operationId.addExtParams(map);
        b(operationId, "gzh_click");
    }

    public static void v(String str, String str2, stSimpleMetaFeed stsimplemetafeed, Map<String, String> map) {
        t(str, str2, "back", stsimplemetafeed, 1000001, "", map);
    }

    public static void w(String str, String str2, stSimpleMetaFeed stsimplemetafeed, int i3, Map<String, String> map) {
        t(str, str2, "bottom_bar", stsimplemetafeed, i3, "", map);
    }

    public static void x(String str, String str2, stSimpleMetaFeed stsimplemetafeed, Map<String, String> map) {
        E(str, str2, "bottom_bar", stsimplemetafeed, "", map);
    }

    public static void y(String str, String str2, stSimpleMetaFeed stsimplemetafeed, Map<String, String> map) {
        E(str, str2, "comment_at_pop", stsimplemetafeed, "", map);
    }

    public static void z(String str, String str2, stSimpleMetaFeed stsimplemetafeed, Map<String, String> map) {
        t(str, str2, "comment_entry", stsimplemetafeed, 1000001, "", map);
    }

    public static void u(String str, String str2, stSimpleMetaFeed stsimplemetafeed) {
        v(str, str2, stsimplemetafeed, null);
    }

    public static void F(int i3, String str, String str2, stSimpleMetaFeed stsimplemetafeed, Map<String, String> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        Map<String, String> map2 = map;
        map2.put("videoplay_status", String.valueOf(j(i3)));
        t(str, str2, "mini_videoplay", stsimplemetafeed, 1000001, "", map2);
    }

    public static void L(String str, String str2, int i3, stSimpleMetaFeed stsimplemetafeed) {
        String str3;
        if ((stsimplemetafeed != null ? stsimplemetafeed.weishiButton : null) == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        WSStatisticsReporter.Builder addParams = a(str).addParams(WSPublicAccReport.getInstance().getFeedsBaseParams("jump_weishi", i3, stsimplemetafeed));
        hashMap.put(QCircleLpReportDc05507.KEY_PLAY_SCENE, str2);
        if (TextUtils.equals(str, "share")) {
            str3 = "1";
        } else {
            str3 = "0";
        }
        hashMap.put("is_schema", str3);
        addParams.addExtParams(hashMap);
        b(addParams, "gzh_click");
    }

    public static void M(String str, String str2, boolean z16, stSimpleMetaFeed stsimplemetafeed, Map<String, String> map) {
        if (z16) {
            t(str, str2, "like", stsimplemetafeed, 1001001, "", map);
        } else {
            t(str, str2, "like", stsimplemetafeed, 1001002, "", map);
        }
    }

    public static void X(String str, String str2, stSimpleMetaFeed stsimplemetafeed, int i3, Map<String, String> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        Map<String, String> map2 = map;
        map2.put("module", String.valueOf(i3));
        t(str, str2, "comment_roll_module", stsimplemetafeed, 1000001, "", map2);
    }

    public static void a0(String str, String str2, stSimpleMetaFeed stsimplemetafeed, int i3, Map<String, String> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        Map<String, String> map2 = map;
        map2.put(PictureConst.PHOTO_COMMENT_NUM, String.valueOf(i3));
        E(str, str2, "comment_roll_end", stsimplemetafeed, "", map2);
    }

    private static void g0(String str, String str2, int i3, com.tencent.biz.pubaccount.weishi.player.e eVar, boolean z16, int i16, Map<String, String> map) {
        com.tencent.biz.pubaccount.weishi.player.l lVar;
        if (eVar == null || (lVar = eVar.f81127c) == null || e.b(f82286a, i3, lVar)) {
            return;
        }
        if (i3 == 1) {
            f82290e = e.i(lVar.f81166a);
        }
        HashMap hashMap = new HashMap();
        hashMap.put(CGNonAgeReport.EVENT_TYPE, i3 + "");
        hashMap.put("feed_id", lVar.f81166a);
        hashMap.put("owner_id", lVar.f81181p);
        if (i3 == 2) {
            WSPlayerWrapper wSPlayerWrapper = eVar.f81129e;
            long Q = wSPlayerWrapper == null ? 0L : wSPlayerWrapper.Q(z16);
            long z17 = wSPlayerWrapper != null ? wSPlayerWrapper.z() : 0L;
            hashMap.put("duration", String.valueOf(Q));
            hashMap.put("last_location", String.valueOf(z17));
            x.i("WSSpeedDurationCalculator", "reportTotalPlayTime:" + Q);
            hashMap.put("act_duration", String.valueOf(u10.b.f438046a.a()));
        }
        hashMap.put("video_length", String.valueOf(lVar.f81169d));
        hashMap.put("recommend_id", "");
        hashMap.put("poolType", String.valueOf(lVar.f81176k));
        hashMap.put("global_key", com.tencent.biz.pubaccount.weishi.report.c.b().c(lVar.f81182q));
        hashMap.put(QCircleLpReportDc05507.KEY_PLAY_ID, f82290e);
        x.j("WS_VIDEO_PLAY_TIME", "[WSVerticalBeaconReport.java][reportVerticalVideoPlay] title:" + lVar.f81175j + ", map:" + hashMap.toString());
        if (map == null) {
            map = new HashMap<>();
        }
        map.put("type", String.valueOf(lVar.f81177l));
        map.put(ProfileCardDtReportUtil.DT_REPORT_PARAM_COVER_TYPE, bb.k(lVar.f81173h));
        map.put("material_type", String.valueOf(lVar.f81184s));
        map.put(QCircleLpReportDc05507.KEY_PLAY_SCENE, str2);
        map.put("tag_id", String.valueOf(eVar.f81127c.f81185t));
        map.put("feeds_label_type", String.valueOf(eVar.f81127c.f81186u));
        map.put("videoplay_index", String.valueOf(i16 + 1));
        map.put("feeds_index", String.valueOf(g(str)));
        map.put("feeds_feedid", f(str));
        b(a(str).addParams(hashMap).addExtParams(map).addObjectParams("feed_pass_key", lVar.f81183r).setOperationId(""), "gzh_video_play");
    }

    private static String i(stOpVideo stopvideo) {
        return String.valueOf(stopvideo != null ? stopvideo.videoType : 0);
    }

    public static void o(String str, String str2, int i3, stSimpleMetaFeed stsimplemetafeed, Map<String, String> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        Map<String, String> map2 = map;
        String str3 = "0";
        if (stsimplemetafeed != null && r.u(stsimplemetafeed.poster)) {
            str3 = "1";
        }
        map2.put("is_livenow", str3);
        t(str, str2, "profile", stsimplemetafeed, i3, "", map2);
    }

    public static void p(String str, String str2, String str3, int i3, stSimpleMetaFeed stsimplemetafeed, Map<String, String> map) {
        String str4;
        if (stsimplemetafeed != null) {
            str4 = stsimplemetafeed.poster_id;
        } else {
            str4 = "";
        }
        if (TextUtils.equals(str4, bb.q())) {
            bb.W("homepage_main");
        } else {
            bb.W("homepage_guest");
        }
        if (map == null) {
            map = new HashMap<>();
        }
        Map<String, String> map2 = map;
        if (stsimplemetafeed != null) {
            map2.put("type", String.valueOf(stsimplemetafeed.video_type));
        }
        t(str, str2, str3, stsimplemetafeed, i3, "", map2);
    }

    public static void d0(m10.d dVar) {
        if (dVar == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(CGNonAgeReport.EVENT_TYPE, dVar.f415968a);
        hashMap.put("feed_id", dVar.f415971d);
        hashMap.put("owner_id", dVar.f415972e);
        hashMap.put("video_length", String.valueOf(dVar.f415973f));
        HashMap hashMap2 = new HashMap();
        hashMap2.put("from", dVar.f415969b);
        hashMap2.put(QCircleLpReportDc05507.KEY_PLAY_SCENE, dVar.f415970c);
        hashMap2.put("onstartopen_time", String.valueOf(dVar.f415974g));
        hashMap2.put("oncreate_time", String.valueOf(dVar.f415975h));
        hashMap2.put("onviewcreated_time", String.valueOf(dVar.f415976i));
        hashMap2.put("onbindholder_time", String.valueOf(dVar.f415977j));
        hashMap2.put("onplayvideo_time", String.valueOf(dVar.f415978k));
        hashMap2.put("onvideostarted_time", String.valueOf(dVar.f415979l));
        hashMap2.put("onoverall_time", String.valueOf(dVar.f415980m));
        hashMap2.put("error_code", dVar.f415981n);
        hashMap2.put("error_msg", dVar.f415982o);
        x.j("WSVerticalDeltaTimeLog", "[WSVerticalBeaconReport.java][reportVerticalPlayAction] map:" + hashMap.toString() + ", extMap:" + hashMap2.toString());
        b(a(dVar.f415969b).addParams(hashMap).addExtParams(hashMap2).setOperationId(""), "gzh_play_action");
    }

    private static String e(int i3) {
        if (i3 == 5) {
            return "2";
        }
        if (i3 == 10000) {
            return "5";
        }
        return "4";
    }

    public static void e0(String str, String str2, int i3, stSimpleMetaFeed stsimplemetafeed, boolean z16, Map<String, String> map) {
        if (stsimplemetafeed == null) {
            return;
        }
        t(str, str2, "fullscreen_videoplay_video" + (i3 + 1), stsimplemetafeed, z16 ? 1007001 : 1007002, "", h(str, i3, stsimplemetafeed, map));
    }

    public static void f0(String str, String str2, int i3, stSimpleMetaFeed stsimplemetafeed, Map<String, String> map) {
        if (stsimplemetafeed == null) {
            return;
        }
        E(str, str2, "fullscreen_videoplay_video" + (i3 + 1), stsimplemetafeed, "", h(str, i3, stsimplemetafeed, map));
    }

    public static void r(String str, String str2, int i3, stJumpInfo stjumpinfo) {
        if (stjumpinfo == null) {
            return;
        }
        Map<String, String> feedsBaseParamsWithoutFeed = WSPublicAccReport.getInstance().getFeedsBaseParamsWithoutFeed("blockpage", i3);
        feedsBaseParamsWithoutFeed.put("global_key", com.tencent.biz.pubaccount.weishi.report.c.b().c(stjumpinfo.trace_id));
        HashMap hashMap = new HashMap();
        hashMap.put(QCircleLpReportDc05507.KEY_PLAY_SCENE, str2);
        Map<String, String> map = stjumpinfo.mapExt;
        if (map != null) {
            hashMap.putAll(map);
        }
        b(a(str).addParams(feedsBaseParamsWithoutFeed).addExtParams(hashMap).setOperationId(String.valueOf(stjumpinfo.f25121id)), "gzh_click");
    }

    public static void T(String str, String str2, String str3, int i3, j jVar, String str4, boolean z16, Map<String, String> map) {
        String str5;
        if (jVar == null) {
            return;
        }
        if (map == null) {
            map = new HashMap<>();
        }
        Map<String, String> map2 = map;
        ez.a f16 = jVar.f();
        map2.put("rich_type", k(f16));
        if (z16) {
            str5 = "1";
        } else {
            str5 = "0";
        }
        map2.put("card_type", str5);
        if (f16 instanceof ez.b) {
            ez.b bVar = (ez.b) f16;
            c(map2, bVar.e());
            if (bVar.e() == 5) {
                d(map2, str4);
            }
        } else if (f16 instanceof ez.c) {
            map2.put("upload_from", "0040");
        }
        R("gzh_click", str, str3, str2, jVar, map2, i3);
    }

    public static void W(String str, String str2, String str3, j jVar, boolean z16, Map<String, String> map) {
        String str4;
        if (jVar == null) {
            return;
        }
        if (map == null) {
            map = new HashMap<>();
        }
        Map<String, String> map2 = map;
        ez.a f16 = jVar.f();
        map2.put("rich_type", k(f16));
        if (z16) {
            str4 = "1";
        } else {
            str4 = "0";
        }
        map2.put("card_type", str4);
        if (f16 instanceof ez.b) {
            c(map2, ((ez.b) f16).e());
        } else if (f16 instanceof ez.c) {
            map2.put("upload_from", "0040");
        }
        R("gzh_exposure", str, str3, str2, jVar, map2, 0);
    }

    public static void i0(String str, String str2, com.tencent.biz.pubaccount.weishi.player.e eVar, int i3, Map<String, String> map) {
        g0(str, str2, 1, eVar, false, i3, map);
    }

    public static void j0(String str, String str2, com.tencent.biz.pubaccount.weishi.player.e eVar, boolean z16, int i3, Map<String, String> map) {
        g0(str, str2, 2, eVar, z16, i3, map);
        com.tencent.biz.pubaccount.weishi.report.dc898.d.m(eVar, z16);
    }
}
