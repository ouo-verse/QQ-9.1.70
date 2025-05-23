package com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.impl;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.ads.data.AdParam;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.adinfo.QAdPlayStrategyDefine$PlayStrategyKey;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.QADNetStatus;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdVideoInfoDefine$StrategyAdParams;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadutils.QAdDeviceUtils;
import com.tencent.qcircle.weseevideo.common.constants.QzoneCameraConst;
import com.tencent.qqlive.ona.protocol.jce.AdFreeFlowItem;
import com.tencent.qqlive.ona.protocol.jce.AdInsideTraceInfo;
import com.tencent.qqlive.ona.protocol.jce.AdInsideVideoItem;
import com.tencent.qqlive.ona.protocol.jce.AdInsideVideoRequest;
import com.tencent.qqlive.ona.protocol.jce.AdOfflineInfo;
import com.tencent.qqlive.ona.protocol.jce.AdPageInfo;
import com.tencent.qqlive.ona.protocol.jce.AdSdkRequestInfo;
import com.tencent.qqlive.ona.protocol.jce.AdVideoInfo;
import com.tencent.qqlive.ona.protocol.jce.AdVideoPlatformInfo;
import com.tencent.qqlive.ona.protocol.jce.AdcPoster;
import com.tencent.qqlive.playerinterface.QAdUserInfo;
import com.tencent.qqlive.playerinterface.QAdVideoItem;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kt3.j;
import ow2.c;
import pw2.i;
import pw2.n;
import pw2.y;

/* compiled from: P */
/* loaded from: classes19.dex */
public class QAdVideoHelper {

    /* renamed from: a, reason: collision with root package name */
    private static Map<Integer, ConcurrentHashMap<String, Integer>> f303628a = new ConcurrentHashMap();

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes19.dex */
    public @interface NetType {
        public static final int NET_2G = 2;
        public static final int NET_3G = 3;
        public static final int NET_4G = 4;
        public static final int NET_WIFI = 1;
        public static final int NO_NET_SERVER = 0;
    }

    static {
        l();
        k();
        m();
        j();
    }

    public static ArrayList<QAdVideoItem> a(com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.c[] cVarArr, String str) {
        AdInsideVideoItem adInsideVideoItem;
        if (cVarArr != null && cVarArr.length != 0) {
            ArrayList<QAdVideoItem> arrayList = new ArrayList<>();
            for (com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.c cVar : cVarArr) {
                if (cVar != null && (adInsideVideoItem = cVar.f303589a) != null && (adInsideVideoItem.videoItem != null || adInsideVideoItem.posterItem != null)) {
                    QAdVideoItem qAdVideoItem = new QAdVideoItem();
                    if (cVar.f303589a.videoItem != null) {
                        qAdVideoItem.i(str);
                        qAdVideoItem.s(cVar.f303589a.videoItem.vid);
                        qAdVideoItem.k(cVar.f303589a.videoItem.duration);
                        qAdVideoItem.l(String.valueOf(cVar.f303589a.videoItem.encodeFormat));
                        qAdVideoItem.n(cVar.f303589a.videoItem.fileSize);
                        qAdVideoItem.m(cVar.f303589a.videoItem.md5);
                        qAdVideoItem.g(cVar.f303590b);
                        qAdVideoItem.j(cVar.f303592d);
                        qAdVideoItem.r(cVar.f303589a.videoItem.url);
                        qAdVideoItem.h(cVar.f303591c);
                    }
                    AdcPoster adcPoster = cVar.f303589a.posterItem;
                    if (adcPoster != null) {
                        qAdVideoItem.o(adcPoster.duration);
                        qAdVideoItem.p(cVar.f303589a.posterItem.imageUrl);
                    }
                    qAdVideoItem.q(false);
                    arrayList.add(qAdVideoItem);
                }
            }
            return arrayList;
        }
        return null;
    }

    private static AdInsideTraceInfo b(Map<String, String> map) {
        if (y.i(map)) {
            return null;
        }
        String str = map.get("trace_id");
        String str2 = map.get("scene_id");
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return null;
        }
        AdInsideTraceInfo adInsideTraceInfo = new AdInsideTraceInfo();
        String str3 = map.get(QzoneCameraConst.Tag.ARG_PARAM_VIDEO_START_TIME);
        if (!TextUtils.isEmpty(str3)) {
            adInsideTraceInfo.videoStartTime = Long.parseLong(str3);
        }
        adInsideTraceInfo.sceneId = str2;
        adInsideTraceInfo.traceId = str;
        return adInsideTraceInfo;
    }

    public static ju2.a c(AdInsideVideoRequest adInsideVideoRequest, String str, long j3, int i3) {
        ju2.a aVar = new ju2.a();
        aVar.f410959a = str;
        aVar.f410960b = i3;
        aVar.f410964f = adInsideVideoRequest.adVipState;
        aVar.f410963e = adInsideVideoRequest.adVideoInfo;
        aVar.f410965g = adInsideVideoRequest.adPageInfo;
        aVar.f410966h = adInsideVideoRequest.adOfflineInfo;
        aVar.f410968j = adInsideVideoRequest.adSdkRequestInfo;
        aVar.f410967i = adInsideVideoRequest.adVideoPlatformInfo;
        aVar.f410961c = j3;
        aVar.f410962d = adInsideVideoRequest.screenMode;
        return aVar;
    }

    public static tu2.a d(j jVar) {
        if (jVar != null) {
            tu2.a aVar = new tu2.a();
            aVar.g(jVar.b());
            aVar.h(jVar.c());
            aVar.k(jVar.g());
            aVar.j(jVar.f());
            aVar.i(jVar.d());
            aVar.l(jVar.i());
            return aVar;
        }
        return null;
    }

    public static tu2.b e(QAdUserInfo qAdUserInfo) {
        if (qAdUserInfo != null) {
            tu2.b bVar = new tu2.b();
            bVar.d(qAdUserInfo.a());
            bVar.e(qAdUserInfo.b());
            bVar.f(qAdUserInfo.h());
            return bVar;
        }
        return null;
    }

    public static AdFreeFlowItem f(Map<String, String> map) {
        if (!y.i(map) && !QAdDeviceUtils.A()) {
            AdFreeFlowItem adFreeFlowItem = new AdFreeFlowItem();
            if (map.containsKey("cmcc")) {
                adFreeFlowItem.flowType = 2;
                adFreeFlowItem.userMob = map.get("cmcc");
            } else if (map.containsKey("telcom")) {
                adFreeFlowItem.flowType = 3;
                adFreeFlowItem.userMob = map.get("telcom");
            } else if (map.containsKey("unicom")) {
                adFreeFlowItem.flowType = 1;
                adFreeFlowItem.userMob = map.get("unicom");
                String str = map.get("unicomtype");
                if (!TextUtils.isEmpty(str) && i.n(str)) {
                    adFreeFlowItem.flowSubType = Integer.parseInt(str);
                }
            }
            return adFreeFlowItem;
        }
        return null;
    }

    public static int g(j jVar) {
        if (jVar == null) {
            return 0;
        }
        ConcurrentHashMap<String, Integer> concurrentHashMap = f303628a.get(Integer.valueOf(jVar.f()));
        if (concurrentHashMap == null) {
            concurrentHashMap = f303628a.get(5);
        }
        Integer num = concurrentHashMap.get(i(jVar));
        if (num == null) {
            num = concurrentHashMap.get("default_play_mode_key");
        }
        return num.intValue();
    }

    public static int h(j jVar, String str) {
        if (!o(jVar)) {
            return 0;
        }
        if (TextUtils.isEmpty(str)) {
            str = QAdDeviceUtils.j();
        }
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -665462704:
                if (str.equals(QADNetStatus.UNAVAILABLE)) {
                    c16 = 0;
                    break;
                }
                break;
            case 1653:
                if (str.equals(QADNetStatus.G_2)) {
                    c16 = 1;
                    break;
                }
                break;
            case 1684:
                if (str.equals(QADNetStatus.G_3)) {
                    c16 = 2;
                    break;
                }
                break;
            case 1715:
                if (str.equals(QADNetStatus.G_4)) {
                    c16 = 3;
                    break;
                }
                break;
            case 3649301:
                if (str.equals("wifi")) {
                    c16 = 4;
                    break;
                }
                break;
            case 3662605:
                if (str.equals(QADNetStatus.WWAN)) {
                    c16 = 5;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                return 3;
            case 1:
            case 2:
            case 3:
            case 5:
                return 2;
            case 4:
                return 1;
            default:
                return 0;
        }
    }

    @Nullable
    private static String i(@NonNull j jVar) {
        Map<String, Object> a16 = jVar.a();
        if (a16 != null && (a16.get("PLAY_STRATEGY") instanceof String)) {
            return String.valueOf(a16.get("PLAY_STRATEGY"));
        }
        return "key_invalid";
    }

    private static void j() {
        ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("default_play_mode_key", 1);
        concurrentHashMap.put(QAdPlayStrategyDefine$PlayStrategyKey.SHORT_VIDEO, 8);
        concurrentHashMap.put(QAdPlayStrategyDefine$PlayStrategyKey.LONG_VIDEO, 11);
        concurrentHashMap.put(QAdPlayStrategyDefine$PlayStrategyKey.WHY_ME_DETAIL_VIDEO, 10);
        concurrentHashMap.put(QAdPlayStrategyDefine$PlayStrategyKey.VERTICAL_VIDEO, 15);
        concurrentHashMap.put(QAdPlayStrategyDefine$PlayStrategyKey.VR_VIDEO, 4);
        concurrentHashMap.put(QAdPlayStrategyDefine$PlayStrategyKey.NO_AD, 4);
        concurrentHashMap.put(QAdPlayStrategyDefine$PlayStrategyKey.MULTI_CAMERA_VIDEO, 12);
        concurrentHashMap.put(QAdPlayStrategyDefine$PlayStrategyKey.HOT_SPOT_LIVE, 14);
        concurrentHashMap.put(QAdPlayStrategyDefine$PlayStrategyKey.HOT_SPOT_NORMAL, 13);
        concurrentHashMap.put(QAdPlayStrategyDefine$PlayStrategyKey.NO_AD_SUBMARINE, 16);
        concurrentHashMap.put("key_invalid", 0);
        f303628a.put(5, concurrentHashMap);
        f303628a.put(2, concurrentHashMap);
    }

    private static void k() {
        ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("default_play_mode_key", 3);
        concurrentHashMap.put(QAdPlayStrategyDefine$PlayStrategyKey.NO_AD, 4);
        f303628a.put(4, concurrentHashMap);
    }

    private static void l() {
        ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("default_play_mode_key", 3);
        f303628a.put(3, concurrentHashMap);
    }

    private static void m() {
        ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("default_play_mode_key", 2);
        concurrentHashMap.put("key_invalid", 2);
        concurrentHashMap.put(QAdPlayStrategyDefine$PlayStrategyKey.MULTI_CAMERA_VIDEO, 12);
        f303628a.put(1, concurrentHashMap);
    }

    public static boolean n(j jVar) {
        if (jVar != null && jVar.a() != null) {
            Object obj = jVar.a().get(QAdVideoInfoDefine$StrategyAdParams.IS_SCROLL_ENABLE);
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
            return true;
        }
        return true;
    }

    private static boolean o(j jVar) {
        if (jVar == null) {
            return false;
        }
        if (3 != jVar.f() && 4 != jVar.f()) {
            return false;
        }
        return true;
    }

    public static AdInsideVideoRequest p(Context context, j jVar, String str, QAdUserInfo qAdUserInfo, String str2, int i3, ArrayList<String> arrayList) {
        if (jVar != null && qAdUserInfo != null) {
            AdInsideVideoRequest adInsideVideoRequest = new AdInsideVideoRequest();
            adInsideVideoRequest.requestAdType = i3;
            adInsideVideoRequest.adVideoInfo = y(jVar, str);
            adInsideVideoRequest.adVipState = x(qAdUserInfo);
            adInsideVideoRequest.adPageInfo = s(jVar);
            ow2.c b16 = new c.b().c(QAdDeviceUtils.j()).b();
            adInsideVideoRequest.adOfflineInfo = r(jVar, b16);
            adInsideVideoRequest.adVideoPlatformInfo = u(str2, b16, true);
            adInsideVideoRequest.adSdkRequestInfo = t(str2);
            adInsideVideoRequest.freeFlowItem = q();
            adInsideVideoRequest.filterMap = ku2.a.c().b();
            if (arrayList != null) {
                adInsideVideoRequest.watchedVidList = arrayList;
            }
            if (context != null) {
                adInsideVideoRequest.screenMode = w(jVar, context);
            }
            return adInsideVideoRequest;
        }
        return null;
    }

    public static AdFreeFlowItem q() {
        n.e("QAdVideoHelper", "makeFreeFlowInfo");
        return f(kt3.g.a());
    }

    public static AdOfflineInfo r(j jVar, ow2.c cVar) {
        String str;
        n.e("QAdVideoHelper", "setAdOfflineRequest");
        AdOfflineInfo adOfflineInfo = new AdOfflineInfo();
        if (cVar != null) {
            str = cVar.a();
        } else {
            str = null;
        }
        adOfflineInfo.offlineVideoType = h(jVar, str);
        return adOfflineInfo;
    }

    public static AdPageInfo s(j jVar) {
        n.e("QAdVideoHelper", "setAdPageInfoToRequest");
        AdPageInfo adPageInfo = new AdPageInfo();
        adPageInfo.adPlayMode = g(jVar);
        n.e("QAdVideoHelper", "adPlayMode=" + adPageInfo.adPlayMode);
        Map<String, String> c16 = jVar.c();
        try {
            adPageInfo.style = Integer.parseInt(c16.get("style"));
        } catch (NumberFormatException unused) {
            n.e("QAdVideoHelper", " Get style, number format exception");
        }
        adPageInfo.channelId = c16.get("channelId");
        adPageInfo.page = c16.get("page");
        adPageInfo.flowId = jVar.e();
        Map<String, String> b16 = jVar.b();
        adPageInfo.reportKey = b16.get(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_KEY);
        adPageInfo.reportParams = b16.get(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS);
        adPageInfo.traceInfo = b(c16);
        return adPageInfo;
    }

    public static AdSdkRequestInfo t(String str) {
        n.e("QAdVideoHelper", "setAdSdkRequestInfoToRequest");
        AdSdkRequestInfo adSdkRequestInfo = new AdSdkRequestInfo();
        adSdkRequestInfo.sdkversion = QAdDeviceUtils.c();
        adSdkRequestInfo.requestid = str;
        adSdkRequestInfo.appversion = QAdDeviceUtils.v();
        adSdkRequestInfo.requestCookie = pw2.c.h();
        n.e("QAdVideoHelper", "setAdSdkRequestInfoToRequest cookie = " + adSdkRequestInfo.requestCookie);
        return adSdkRequestInfo;
    }

    public static AdVideoPlatformInfo u(String str, ow2.c cVar, boolean z16) {
        return pw2.c.f(str);
    }

    public static void v(QAdUserInfo qAdUserInfo) {
        lv2.b.c().q(qAdUserInfo.f());
        if (!TextUtils.isEmpty(qAdUserInfo.a())) {
            String str = "openid=" + qAdUserInfo.d() + ";access_token=" + qAdUserInfo.a() + ";oauth_consumer_key=" + qAdUserInfo.c() + ";pf=" + qAdUserInfo.e();
            if (!TextUtils.isEmpty(qAdUserInfo.b())) {
                str = str + ";" + qAdUserInfo.b();
            }
            lv2.b.c().l(str);
            return;
        }
        lv2.b.c().l(qAdUserInfo.b());
    }

    public static int w(j jVar, Context context) {
        n.e("QAdVideoHelper", "setScreenMode");
        if (g(jVar) != 15) {
            if (y.k(context)) {
                return 2;
            }
            return 1;
        }
        return 3;
    }

    public static int x(QAdUserInfo qAdUserInfo) {
        n.e("QAdVideoHelper", "setUserInfoToRequest");
        if (TextUtils.isEmpty(qAdUserInfo.a()) && TextUtils.isEmpty(qAdUserInfo.b())) {
            return 0;
        }
        if (qAdUserInfo.h()) {
            return 2;
        }
        if (qAdUserInfo.g() == 2) {
            return 11;
        }
        if (qAdUserInfo.g() == 3) {
            return 8;
        }
        return 1;
    }

    public static AdVideoInfo y(j jVar, String str) {
        n.e("QAdVideoHelper", "setVideoInfoToRequest");
        AdVideoInfo adVideoInfo = new AdVideoInfo();
        adVideoInfo.vid = jVar.i();
        adVideoInfo.coverId = jVar.d();
        adVideoInfo.flowId = jVar.e();
        String str2 = adVideoInfo.vid;
        if (str2 != null && str2.equals(jVar.d())) {
            adVideoInfo.coverId = "";
        }
        if (1 == jVar.f()) {
            adVideoInfo.isLive = 1;
        }
        Map<String, String> c16 = jVar.c();
        adVideoInfo.livepId = c16.get("livepid");
        adVideoInfo.lid = c16.get("lid");
        try {
            adVideoInfo.tpId = Integer.parseInt(c16.get(AdParam.TPID));
        } catch (NumberFormatException unused) {
            n.e("QAdVideoHelper", " Get tpid, number format exception");
        }
        adVideoInfo.defn = "hd";
        if (!TextUtils.isEmpty(str)) {
            if (str.equalsIgnoreCase("mp4")) {
                str = "hd";
            }
            adVideoInfo.defn = str;
        }
        adVideoInfo.preVid = jVar.g();
        return adVideoInfo;
    }
}
