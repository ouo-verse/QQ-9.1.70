package jy2;

import android.app.Activity;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.biz.qcircleshadow.lib.HostStaticInvokeHelper;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.biz.richframework.video.rfw.player.RFWTVKPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.init.RFWPlayerConfig;
import com.tencent.biz.richframework.video.rfw.player.init.RFWPlayerManger;
import com.tencent.common.config.AppSetting;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.account.qqconnect.TVideoQQConnectToken;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.login.QAdLoginDefine$LoginCookieKey;
import com.tencent.mobileqq.tvideo.base.TVideoLayerDetailFeedsPageFragment;
import com.tencent.mobileqq.tvideo.base.TVideoLayerFeedsPageFragment;
import com.tencent.mobileqq.tvideo.base.TVideoLayerMultiTabPageFragment;
import com.tencent.mobileqq.tvideo.event.QFSTVideoScreenChangeReloadEvent;
import com.tencent.mobileqq.tvideo.net.utils.TVideoConfig;
import com.tencent.mobileqq.winkpublish.common.WinkPublishEnvironment;
import com.tencent.paysdk.data.VideoInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.TVKUserInfo;
import com.tencent.qqlive.tvkplayer.api.asset.TVKAssetFactory;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import com.tencent.tvideo.protocol.pb.AdFeedInfo;
import com.tencent.tvideo.protocol.pb.AdFeedVideoInfo;
import com.tencent.tvideo.protocol.pb.AdImmersivePoster;
import feedcloud.FeedCloudMeta$StFeed;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import pw2.p;
import tvideo.Ads;
import tvideo.AttitudeInfo;
import tvideo.CoverBaseInfo;
import tvideo.FeedData;
import tvideo.Video;
import tvideo.VideoBaseInfo;
import tvideo.VideoPlot;
import tvideo.VideoPlotDetails;
import vx2.FeedItemPlayRate;
import zt2.k;

/* compiled from: P */
/* loaded from: classes19.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private static int f411170a = -1;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f411171b;

    public static boolean A(Video video) {
        VideoBaseInfo videoBaseInfo;
        if (video != null && (videoBaseInfo = video.video_base_info) != null && !TextUtils.isEmpty(videoBaseInfo.stream_ratio)) {
            try {
                if (Double.parseDouble(video.video_base_info.stream_ratio) > 1.0d) {
                    return false;
                }
                return true;
            } catch (Exception e16) {
                QLog.d("TVideoUtils", 1, "isFullScreenVideo Exception : " + e16);
            }
        }
        return false;
    }

    public static boolean B() {
        if (MobileQQ.sProcessId == 1) {
            return true;
        }
        return false;
    }

    public static boolean C(Video video) {
        VideoBaseInfo videoBaseInfo;
        if (video != null && (videoBaseInfo = video.video_base_info) != null && videoBaseInfo.video_type == 101) {
            return true;
        }
        return false;
    }

    public static boolean D(Part part) {
        if (part != null && (part.getPartHost() instanceof TVideoLayerMultiTabPageFragment)) {
            return true;
        }
        return false;
    }

    public static boolean E(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        PBStringField pBStringField;
        if (feedCloudMeta$StFeed != null && (pBStringField = feedCloudMeta$StFeed.f398449id) != null) {
            return pBStringField.get().contains("tvideo_feed_id_replace_");
        }
        return false;
    }

    public static boolean F(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        PBStringField pBStringField;
        if (feedCloudMeta$StFeed != null && (pBStringField = feedCloudMeta$StFeed.f398449id) != null && pBStringField.get() != null) {
            return feedCloudMeta$StFeed.f398449id.get().contains("tvideo_feed_id_replace_");
        }
        return false;
    }

    public static boolean G(VideoPlotDetails videoPlotDetails, Video video) {
        CoverBaseInfo coverBaseInfo;
        VideoBaseInfo videoBaseInfo;
        if (videoPlotDetails == null || video == null || (coverBaseInfo = videoPlotDetails.cover_base_info) == null || (videoBaseInfo = video.video_base_info) == null) {
            return false;
        }
        return TextUtils.equals(coverBaseInfo.cid, videoBaseInfo.cid);
    }

    public static boolean H(FeedItemPlayRate feedItemPlayRate, Video video, int i3) {
        if (feedItemPlayRate == null || video == null || video.video_base_info == null || i3 != feedItemPlayRate.getPos()) {
            return false;
        }
        if (feedItemPlayRate.getCid() != null && feedItemPlayRate.getCid().equals(video.video_base_info.cid)) {
            return true;
        }
        if (feedItemPlayRate.getVid() == null || !feedItemPlayRate.getVid().equals(video.video_base_info.vid)) {
            return false;
        }
        return true;
    }

    public static boolean I() {
        int i3;
        try {
            i3 = Settings.System.getInt(e().getApplicationContext().getContentResolver(), "accelerometer_rotation");
        } catch (Exception e16) {
            e16.printStackTrace();
            i3 = 0;
        }
        if (i3 != 1) {
            return false;
        }
        return true;
    }

    public static boolean J(Video video) {
        VideoBaseInfo videoBaseInfo;
        if (video != null && (videoBaseInfo = video.video_base_info) != null && videoBaseInfo.is_short_video) {
            return true;
        }
        return false;
    }

    public static boolean K() {
        return false;
    }

    public static boolean L(Part part) {
        if (part == null) {
            return false;
        }
        Activity activity = part.getActivity();
        IPartHost partHost = part.getPartHost();
        if (Foreground.getTopActivity() != activity) {
            return false;
        }
        if ((partHost instanceof TVideoLayerFeedsPageFragment) && !((TVideoLayerFeedsPageFragment) partHost).isResumed()) {
            return false;
        }
        return true;
    }

    public static void M(int i3) {
        QFSTVideoScreenChangeReloadEvent qFSTVideoScreenChangeReloadEvent = new QFSTVideoScreenChangeReloadEvent();
        qFSTVideoScreenChangeReloadEvent.setOrientation(i3);
        SimpleEventBus.getInstance().dispatchEvent(qFSTVideoScreenChangeReloadEvent);
    }

    private static void N(e30.b bVar, Ads ads) {
        AdFeedVideoInfo adFeedVideoInfo;
        FeedCloudMeta$StFeed g16 = bVar.g();
        if (g16 != null && ads != null) {
            try {
                AdImmersivePoster adImmersivePoster = (AdImmersivePoster) p.c(AdImmersivePoster.class, ((AdFeedInfo) p.c(AdFeedInfo.class, ads.ad_feed_info)).data);
                if (adImmersivePoster != null && (adFeedVideoInfo = adImmersivePoster.video_info) != null) {
                    g16.f398449id.set(adFeedVideoInfo.vid);
                    g16.video.fileId.set(adImmersivePoster.video_info.vid);
                }
            } catch (Exception e16) {
                QLog.d("TVideoUtils", 4, "setAdVideoFeedPreId Exception = " + e16);
            }
        }
    }

    public static void O(boolean z16) {
        f411171b = z16;
    }

    public static void P(int i3) {
        f411170a = i3;
    }

    public static void Q(Activity activity, int i3) {
        R(activity, i3, true);
    }

    public static void R(Activity activity, int i3, boolean z16) {
        if (!AppSetting.t(activity) && activity != null && !activity.isFinishing()) {
            f411171b = z16;
            activity.setRequestedOrientation(i3);
            P(i3);
            M(i3);
        }
    }

    public static boolean S(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        PBBytesField pBBytesField;
        if (feedCloudMeta$StFeed != null && (pBBytesField = feedCloudMeta$StFeed.busiData) != null) {
            try {
                FeedData decode = FeedData.ADAPTER.decode(pBBytesField.get().toByteArray());
                if (decode == null) {
                    return false;
                }
                if (decode.video == null) {
                    if (decode.ads == null) {
                        return false;
                    }
                }
                return true;
            } catch (Exception e16) {
                QLog.d("TVideoUtils", 4, "stfeedHasTVideoData Exception = " + e16);
            }
        }
        return false;
    }

    public static boolean T(Video video) {
        VideoBaseInfo videoBaseInfo;
        AttitudeInfo attitudeInfo;
        if (video != null && (videoBaseInfo = video.video_base_info) != null && (attitudeInfo = videoBaseInfo.attitude_info) != null) {
            return attitudeInfo.is_attitude_available;
        }
        return false;
    }

    public static void a(List<String> list, String str, String str2) {
        list.add(com.tencent.mobileqq.webview.swift.cookie.b.b(str, str2, "qq.com", false));
    }

    public static List<String> b() {
        ArrayList arrayList = new ArrayList();
        a(arrayList, "vdevice_qimei36", TVideoConfig.f304492a.k());
        bu2.a i3 = zt2.e.f453199a.i();
        if (i3 == null) {
            return arrayList;
        }
        a(arrayList, QAdLoginDefine$LoginCookieKey.MAIN_LOGIN, "qq");
        a(arrayList, QAdLoginDefine$LoginCookieKey.QQ_VUSERID, i3.getVideoUserId() + "");
        a(arrayList, QAdLoginDefine$LoginCookieKey.QQ_VUSESSION, i3.getVideoSessionKey());
        a(arrayList, QAdLoginDefine$LoginCookieKey.QQ_APPID, "102031143");
        a(arrayList, QAdLoginDefine$LoginCookieKey.QQ_OPENID, i3.getOpenId());
        a(arrayList, QAdLoginDefine$LoginCookieKey.QQ_ACCESS_TOKEN, i3.getCom.huawei.hms.support.feature.result.CommonConstant.KEY_ACCESS_TOKEN java.lang.String());
        a(arrayList, "video_appid", "3000063");
        String nickName = i3.getNickName();
        if (!TextUtils.isEmpty(nickName)) {
            try {
                nickName = URLEncoder.encode(i3.getNickName(), "UTF-8");
            } catch (UnsupportedEncodingException e16) {
                e16.printStackTrace();
            }
        }
        a(arrayList, "qq_nick", nickName);
        a(arrayList, "qq_head", i3.getHeadImageUrl());
        a(arrayList, "video_platform", TVideoConfig.f304492a.h() + "");
        return arrayList;
    }

    public static List<String> c() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(com.tencent.mobileqq.webview.swift.cookie.b.b("q36", TVideoConfig.f304492a.k(), "v.qq.com", false));
        return arrayList;
    }

    public static String d(long j3) {
        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        if (j3 < 10000) {
            return String.valueOf(j3);
        }
        if (j3 < SafeBitmapFactory.PX_THRESHOID_DEFAULTS) {
            return decimalFormat.format(j3 / 10000.0d) + "\u4e07";
        }
        return decimalFormat.format(j3 / 1.0E8d) + "\u4ebf";
    }

    public static AppRuntime e() {
        return WinkPublishEnvironment.getAppRuntime();
    }

    public static VideoInfo f(Video video) {
        VideoBaseInfo videoBaseInfo;
        if (video != null && (videoBaseInfo = video.video_base_info) != null) {
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.v(videoBaseInfo.vid);
            videoInfo.q(videoBaseInfo.cid);
            CoverBaseInfo coverBaseInfo = video.cover_base_info;
            if (coverBaseInfo != null) {
                videoInfo.u(coverBaseInfo.title);
            }
            videoInfo.r(VideoInfo.PlayerType.VOD);
            videoInfo.t(0);
            return videoInfo;
        }
        return null;
    }

    public static String g(Video video) {
        CoverBaseInfo coverBaseInfo;
        if (video != null && (coverBaseInfo = video.cover_base_info) != null) {
            return coverBaseInfo.title;
        }
        return "";
    }

    public static int h() {
        return f411170a;
    }

    public static final String i(String str) {
        zt2.e eVar = zt2.e.f453199a;
        bu2.a i3 = eVar.i();
        TVideoQQConnectToken j3 = eVar.j();
        if (i3 != null && j3 != null) {
            String str2 = "; vqq_openid=" + j3.getOpenId() + "; vqq_access_token=" + j3.getAccessToken() + "; main_login=qq; vqq_appid=102031143; vqq_vuserid=" + i3.getVideoUserId() + "; vqq_vusession=" + i3.getVideoSessionKey() + "; vqq_nickname=" + i3.getNickName() + "; vdevice_qimei36=" + TVideoConfig.f304492a.k();
            QLog.d("TVideoUtils", 4, "getTVKPlayerOptions getLoginCookie " + str2);
            return HostStaticInvokeHelper.getPlayerCookie() + str2;
        }
        QLog.d("TVideoUtils", 1, "silentlogin getTVKPlayerOptions not login vid = " + str);
        k.a(str);
        return "";
    }

    public static int j(Video video) {
        VideoBaseInfo videoBaseInfo;
        if (video != null && (videoBaseInfo = video.video_base_info) != null) {
            return videoBaseInfo.material_starting_time;
        }
        return 0;
    }

    public static String k(Video video) {
        VideoBaseInfo videoBaseInfo;
        if (video != null && (videoBaseInfo = video.video_base_info) != null) {
            return videoBaseInfo.material_aspect_vid;
        }
        return "";
    }

    public static String l(boolean z16) {
        return "";
    }

    public static String m(String str) {
        try {
            QLog.d("TVideoUtils", 1, " temporaryauthpay data = " + str);
            Mac mac = Mac.getInstance(KeyPropertiesCompact.KEY_ALGORITHM_HMAC_SHA1);
            mac.init(new SecretKeySpec("RitZYJJu".getBytes(), mac.getAlgorithm()));
            String trim = new String(Base64.encode(mac.doFinal(str.getBytes()), 0)).trim();
            QLog.d("TVideoUtils", 1, " temporaryauthpay signature = " + trim);
            return trim;
        } catch (Exception e16) {
            e16.printStackTrace();
            return "";
        }
    }

    public static TVKPlayerVideoInfo n(Video video) {
        String str;
        String str2;
        VideoBaseInfo videoBaseInfo;
        if (video != null && (videoBaseInfo = video.video_base_info) != null) {
            str = videoBaseInfo.vid;
            str2 = videoBaseInfo.cid;
        } else {
            str = "";
            str2 = "";
        }
        TVKPlayerVideoInfo tVKPlayerVideoInfo = new TVKPlayerVideoInfo(TVKAssetFactory.createOnlineVodVidAsset(str, str2));
        tVKPlayerVideoInfo.setPlayType(2);
        tVKPlayerVideoInfo.addExtraRequestParamsMap("scene", "playerUiType=10&ext_platform=6220303");
        tVKPlayerVideoInfo.addExtraRequestParamsMap("clip", "4");
        String k3 = k(video);
        if (!TextUtils.isEmpty(k3)) {
            tVKPlayerVideoInfo.addExtraRequestParamsMap("srccontenid", k3);
        }
        return tVKPlayerVideoInfo;
    }

    public static RFWTVKPlayerOptions o(FeedCloudMeta$StFeed feedCloudMeta$StFeed, Video video, long j3) {
        if (video == null) {
            return null;
        }
        TVKUserInfo tVKUserInfo = new TVKUserInfo();
        tVKUserInfo.setLoginType(TVKUserInfo.LoginType.LOGIN_QQ);
        tVKUserInfo.setUin(RFWApplication.getAccountId());
        tVKUserInfo.setLoginCookie(i(video.video_base_info.vid));
        TVKPlayerVideoInfo n3 = n(video);
        if ((n3 != null && feedCloudMeta$StFeed != null && feedCloudMeta$StFeed.f398449id.get().contains("share_fake_")) || feedCloudMeta$StFeed.f398449id.get().contains("tvideo_feed_id_replace_")) {
            n3.addExtraRequestParamsMap("track", "");
            QLog.d("TVideoUtils", 4, "getTVKPlayerOptions addExtraRequestParamsMap");
        }
        return RFWTVKPlayerOptions.obtain().setTVKPlayerVideoInfo(n3).setStartPositionMilSec(j3).setSkipEndMilSec(c.f411160a.a(video)).setTVKUserInfo(tVKUserInfo).setDefinition(hy2.a.f406605a.a());
    }

    public static Ads p(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        Ads build = new Ads.a().build();
        try {
            return FeedData.ADAPTER.decode(feedCloudMeta$StFeed.busiData.get().toByteArray()).ads;
        } catch (Exception e16) {
            QLog.d("TVideoUtils", 4, "getTVideoAd Exception = " + e16);
            return build;
        }
    }

    public static Video q(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        Video build = new Video.a().build();
        try {
            return FeedData.ADAPTER.decode(feedCloudMeta$StFeed.busiData.get().toByteArray()).video;
        } catch (Exception e16) {
            QLog.d("TVideoUtils", 4, "getTVideoFeed Exception = " + e16);
            return build;
        }
    }

    public static String r() {
        String account = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
        if (TextUtils.isEmpty(account)) {
            return "0";
        }
        return account;
    }

    public static String s(Video video) {
        VideoBaseInfo videoBaseInfo;
        if (video != null && (videoBaseInfo = video.video_base_info) != null) {
            return videoBaseInfo.vid;
        }
        return "";
    }

    public static void t() {
        if (RFWPlayerManger.g(QCircleHostConstants._SceneID.TENCENT_VIDEO_PLAYER()).hasInit()) {
            return;
        }
        RFWPlayerManger.g(QCircleHostConstants._SceneID.TENCENT_VIDEO_PLAYER()).init(new RFWPlayerConfig.RFWPlayerInitBuilder().setTVKVideoPlayerOptionFetch(new zx2.b()).setIFeedConvert(new zx2.a()).build());
    }

    public static boolean u(Part part) {
        if (!y(part) && !L(part)) {
            return true;
        }
        return false;
    }

    public static boolean v(e30.b bVar) {
        if (bVar == null || bVar.g() == null) {
            return false;
        }
        Ads ads = null;
        try {
            ads = FeedData.ADAPTER.decode(bVar.g().busiData.get().toByteArray()).ads;
            N(bVar, ads);
        } catch (Exception e16) {
            QLog.d("TVideoUtils", 4, "isAdVideoFeed Exception = " + e16);
        }
        if (ads == null) {
            return false;
        }
        return true;
    }

    public static boolean w() {
        return f411171b;
    }

    public static boolean x(Video video, VideoPlot videoPlot) {
        VideoBaseInfo videoBaseInfo;
        VideoBaseInfo videoBaseInfo2;
        if (video != null && (videoBaseInfo = video.video_base_info) != null && videoPlot != null && (videoBaseInfo2 = videoPlot.video_base_info) != null) {
            return TextUtils.equals(videoBaseInfo.vid, videoBaseInfo2.vid);
        }
        return false;
    }

    public static boolean y(Part part) {
        if (part != null && (part.getPartHost() instanceof TVideoLayerDetailFeedsPageFragment)) {
            return true;
        }
        return false;
    }

    public static boolean z(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        PBStringField pBStringField;
        if (feedCloudMeta$StFeed != null && (pBStringField = feedCloudMeta$StFeed.f398449id) != null) {
            return pBStringField.get().contains("share_fake_");
        }
        return false;
    }
}
