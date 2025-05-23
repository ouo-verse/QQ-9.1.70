package gy2;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheQzoneVipData;
import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.login.QAdLoginDefine$LoginCookieKey;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportParam;
import com.tencent.mobileqq.tvideo.floatingwindow.j;
import com.tencent.mobileqq.tvideo.player.TVideoQFSVideoView;
import com.tencent.mobileqq.tvideo.temporaryauth.d;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.screen.ScreenUtils;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.dtreport.api.DefaultTVKDataProvider;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoEntity;
import com.tencent.qqlive.module.videoreport.page.VideoReportPageInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.superplayer.api.ISuperPlayer;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qqcircle.utils.NetworkState;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.HashMap;
import java.util.Map;
import jy2.g;
import tvideo.Video;
import tvideo.VideoBaseInfo;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<String, String> f403886a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private static final Map<Integer, Object> f403887b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private static final Map<String, Object> f403888c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private static final Map<String, Object> f403889d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    private static final Map<String, Object> f403890e = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    private static Video f403891f;

    public static void A(Video video) {
        f403891f = video;
    }

    public static void B(String str, String str2) {
        Map<String, Object> map = f403890e;
        map.put("cid", str);
        map.put("vid", str2);
    }

    public static void C(Map<String, String> map) {
        if (map != null) {
            f403890e.putAll(map);
        }
    }

    public static void D(bu2.a aVar) {
        Map<String, Object> map = f403888c;
        map.put(QAdLoginDefine$LoginCookieKey.MAIN_LOGIN, "qq");
        if (aVar != null) {
            map.put("qq_openid", aVar.getOpenId());
            map.put(QAdLoginDefine$LoginCookieKey.WX_VUSERID, Long.valueOf(aVar.getVideoUserId()));
            map.put(WidgetCacheQzoneVipData.ISVIP, Integer.valueOf(aVar.getIsVip() ? 1 : 0));
        } else {
            map.put(QAdLoginDefine$LoginCookieKey.WX_VUSERID, "");
            map.put(WidgetCacheQzoneVipData.ISVIP, -1);
        }
    }

    public static void E(String str, String str2, int i3, String str3) {
        Map<String, Object> map = f403889d;
        map.put("cid", str);
        map.put("vid", str2);
        map.put("play_end_state_time", Integer.valueOf(i3));
        map.put("quit_way", str3);
    }

    public static void F(int i3, Map<String, String> map) {
        Map<Integer, Object> map2 = f403887b;
        if (map2 != null && map != null) {
            map2.put(Integer.valueOf(i3), map);
        }
    }

    public static void a(String str) {
        f403886a.put("client_exp_id", str);
    }

    private static void b(Video video, Map<String, Object> map, int i3) {
        VideoBaseInfo videoBaseInfo;
        if (video != null && (videoBaseInfo = video.video_base_info) != null) {
            String str = videoBaseInfo.vid;
            if (str != null) {
                map.put(DefaultTVKDataProvider.KEY_FML_VID, str);
                map.put(DefaultTVKDataProvider.KEY_PLAY_VID, videoBaseInfo.vid);
                map.put("material_vid", videoBaseInfo.material_aspect_vid);
            }
            String str2 = videoBaseInfo.cid;
            if (str2 != null) {
                map.put(DefaultTVKDataProvider.KEY_FML_CID, str2);
            }
            map.put("material_starting_time", Integer.valueOf(videoBaseInfo.material_starting_time));
            map.put("material_end_time", Integer.valueOf(videoBaseInfo.material_end_time));
            map.put("material_length", Integer.valueOf(videoBaseInfo.material_end_time - videoBaseInfo.material_starting_time));
            Map<String, String> map2 = video.report_map;
            if (map2 != null) {
                map.putAll(map2);
            }
            Object obj = f403887b.get(Integer.valueOf(p(i3)));
            if (obj instanceof Map) {
                map.putAll((Map) obj);
            }
            Map<String, Object> map3 = f403888c;
            if (map3 != null) {
                map.putAll(map3);
            }
            Map<String, String> map4 = f403886a;
            if (map4 != null) {
                map.putAll(map4);
            }
            B(videoBaseInfo.cid, videoBaseInfo.vid);
        }
    }

    private static void c(Map<String, Object> map) {
        map.put(DefaultTVKDataProvider.KEY_PLAY_SOURCE, 1);
        map.put("stream_direction", 1);
        map.put("is_reject_play", 0);
        map.put("is_auto_play", 1);
        map.put(DTParamKey.REPORT_KEY_VIDEO_CONTENT_TYPE, 2);
    }

    public static void d() {
        f403886a.put("is_agree_private", ny2.a.f421586a.a());
    }

    public static void e(b bVar, TVideoQFSVideoView tVideoQFSVideoView) {
        int i3;
        if (bVar == null) {
            return;
        }
        FeedCloudMeta$StFeed d16 = bVar.d();
        Video f16 = bVar.f();
        TVKNetVideoInfo e16 = bVar.e();
        if (d16 != null && f16 != null && e16 != null) {
            f403891f = f16;
            HashMap hashMap = new HashMap();
            hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0AND0N9K8652HOG8");
            hashMap.put("auto_type", n(d16));
            if (d.d() && bVar.g()) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            hashMap.put("is_exp_user", Integer.valueOf(i3));
            c(hashMap);
            b(f16, hashMap, bVar.c());
            hashMap.put(DefaultTVKDataProvider.KEY_PAY_TYPE, Integer.valueOf(q(e16)));
            hashMap.put(DefaultTVKDataProvider.KEY_PAY_STATUS, Integer.valueOf(e16.getMediaVideoState()));
            VideoEntity build = new VideoEntity.Builder().setContentId(bVar.b()).setPage((Object) "page_ugqqoa_play").setContentType(2).setVideoDuration(bVar.a()).setVideoView((View) tVideoQFSVideoView).addCustomParams((Map<String, ?>) hashMap).ignoreReport(false).bizReady(true).build();
            ISuperPlayer superPlayer = tVideoQFSVideoView.getSuperPlayer();
            if (superPlayer != null) {
                VideoReport.bindVideoPlayerInfo(superPlayer, build);
            }
        }
    }

    public static PageParams f(String str, Map<String, Object> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        Map<String, String> map2 = f403886a;
        if (map2 != null) {
            map.putAll(map2);
        }
        Map<String, Object> map3 = f403888c;
        if (map3 != null) {
            map.putAll(map3);
        }
        d();
        return k(str, map);
    }

    public static Map<String, Object> g() {
        return j(null, "playbox");
    }

    public static Map<String, Object> h(String str) {
        return j(null, str);
    }

    public static Map<String, Object> i(Video video) {
        return j(video, "playbox");
    }

    public static Map<String, Object> j(Video video, String str) {
        Map<String, String> map;
        VideoBaseInfo videoBaseInfo;
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0AND0N9K8652HOG8");
        hashMap.put(VRReportDefine$ReportParam.AD_MOD_ID, "sp_playbox");
        hashMap.put("sub_mod_id", str);
        hashMap.put("ztid", Integer.valueOf(ox2.b.e().d()));
        if (video != null && (videoBaseInfo = video.video_base_info) != null) {
            hashMap.put("vid", videoBaseInfo.vid);
            hashMap.put("cid", video.video_base_info.cid);
            hashMap.put("material_vid", video.video_base_info.material_aspect_vid);
        }
        if (video != null && (map = video.report_map) != null) {
            hashMap.putAll(map);
        }
        d();
        Map<String, String> map2 = f403886a;
        if (map2 != null) {
            hashMap.putAll(map2);
        }
        Map<String, Object> map3 = f403888c;
        if (map3 != null) {
            hashMap.putAll(map3);
        }
        return hashMap;
    }

    private static PageParams k(String str, Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        if (map != null && map.size() > 0) {
            hashMap.putAll(map);
        }
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0AND0N9K8652HOG8");
        hashMap.put(QCircleDaTongConstant.PageParam.PAGE_SUBCLASS, str);
        hashMap.put("ztid", Integer.valueOf(ox2.b.e().d()));
        return new PageParams(hashMap);
    }

    public static void l() {
        f403886a.clear();
        f403887b.clear();
        f403888c.clear();
        f403889d.clear();
        f403891f = null;
    }

    public static Map<String, Object> m(Video video, int i3) {
        HashMap hashMap = new HashMap();
        if (video != null && video.video_base_info != null) {
            Map<String, Object> j3 = j(video, "playbox");
            if (j3 != null) {
                hashMap.putAll(j3);
            }
            hashMap.put(QAdVrReportParams.ParamKey.PLAYBOX_TYPE, Integer.valueOf(r()));
            hashMap.put("rtype", "vid");
            hashMap.put("mod_title", video.video_base_info.plot_title);
            hashMap.put("material_vid", video.video_base_info.material_aspect_vid);
            hashMap.put("material_starting_time", Integer.valueOf(video.video_base_info.material_starting_time));
            hashMap.put("material_end_time", Integer.valueOf(video.video_base_info.material_end_time));
            hashMap.put("poster_type", "immersive_vertical_video");
            Object obj = f403887b.get(Integer.valueOf(i3));
            if (obj instanceof Map) {
                hashMap.putAll((Map) obj);
            }
        }
        return hashMap;
    }

    private static String n(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (g.E(feedCloudMeta$StFeed)) {
            return "next_video";
        }
        return WSPublicAccReport.SOP_NAME_FOCUS;
    }

    public static Map<String, Object> o() {
        Map<String, Object> map = f403890e;
        map.putAll(f403886a);
        return map;
    }

    private static int p(int i3) {
        return (int) Math.ceil(i3 / 5);
    }

    private static int q(@NonNull TVKNetVideoInfo tVKNetVideoInfo) {
        int st5 = tVKNetVideoInfo.getSt();
        if (8 == st5) {
            return 1;
        }
        int payCh = tVKNetVideoInfo.getPayCh();
        if (payCh > 0 && 2 == st5) {
            return 2;
        }
        if (payCh == 0 && 2 == st5) {
            return 0;
        }
        return 9;
    }

    public static int r() {
        try {
            if (!ScreenUtils.isLandscape()) {
                return 1;
            }
            return 2;
        } catch (Exception e16) {
            QLog.d("TVideoReportUtil", 4, "getPlayBoxType Exception " + e16);
            return 1;
        }
    }

    public static Map<String, Object> s() {
        return f403889d;
    }

    public static Video t() {
        return f403891f;
    }

    public static void u(boolean z16, boolean z17) {
        Object obj;
        Map<String, Object> map;
        String str;
        try {
            Map<String, Object> g16 = g();
            g16.putAll(s());
            g16.put("eid", "go_back");
            String str2 = "1";
            if (j.g()) {
                obj = "1";
            } else {
                obj = "0";
            }
            g16.put("is_enable_float_screen", obj);
            if (!z16) {
                str2 = "0";
            }
            g16.put("is_enable_float_screen_play", str2);
            VideoReportPageInfo pageInfo = VideoReport.getPageInfo();
            if (pageInfo != null && (map = pageInfo.pageParams) != null) {
                if (z17) {
                    str = "page_ugqqoa_sec_play";
                } else {
                    str = "page_ugqqoa_play";
                }
                map.put("pgid", str);
                g16.put("cur_pg", pageInfo.pageParams);
            }
            VideoReport.reportEvent("clck", g16);
        } catch (Exception e16) {
            QLog.i("TVideoReportUtil", 1, "reportCloseEvent Exception " + e16);
        }
    }

    public static void v(String str, View view) {
        Map<String, Object> g16 = g();
        g16.put("button_status", str);
        VideoReport.setElementParams(view, g16);
        VideoReport.reportEvent("clck", view, null);
    }

    public static void w(@Nullable Map<String, String> map) {
        if (map != null) {
            f403886a.putAll(map);
        }
        f403886a.put("network_type", NetworkState.getNetworkType() + "");
    }

    public static void x(View view, Map<String, Object> map) {
        Map<String, Object> g16 = g();
        if (map != null && !map.isEmpty()) {
            g16.putAll(map);
        }
        VideoReport.setElementParams(view, g16);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.setElementId(view, "poster_other");
    }

    public static void y(@Nullable String str) {
        if (str != null) {
            f403886a.put("pg_ref_chnl", str);
        }
    }

    public static void z(View view) {
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.setElementId(view, "play_button");
    }
}
