package com.qzone.proxy.feedcomponent.ui;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.qzone.commoncode.module.gdt.GdtFeedUtilForQZone;
import com.qzone.commoncode.module.videorecommend.model.VideoRecommendInfo;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellBottomRecomm;
import com.qzone.proxy.feedcomponent.model.CellLive;
import com.qzone.proxy.feedcomponent.model.CellSummary;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.proxy.feedcomponent.model.VideoUrl;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.mini.share.MiniProgramOpenSdkUtil;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qzoneplayer.video.VideoPlayInfo;
import com.tencent.oskplayer.model.SegmentVideoInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes39.dex */
public class c {
    public static ArrayList<com.qzone.proxy.feedcomponent.model.h> d(BusinessFeedData businessFeedData) {
        VideoInfo videoInfo;
        PictureUrl pictureUrl;
        CellSummary cellSummary;
        ArrayList<VideoRecommendInfo> videoRecommendInfo = businessFeedData.getVideoRecommendInfo();
        if (videoRecommendInfo == null) {
            return null;
        }
        ArrayList<com.qzone.proxy.feedcomponent.model.h> arrayList = new ArrayList<>();
        for (int i3 = 0; i3 < videoRecommendInfo.size(); i3++) {
            com.qzone.proxy.feedcomponent.model.h hVar = new com.qzone.proxy.feedcomponent.model.h();
            VideoRecommendInfo videoRecommendInfo2 = videoRecommendInfo.get(i3);
            if (videoRecommendInfo2 != null && (videoInfo = videoRecommendInfo2.mCellVideoInfo) != null && (pictureUrl = videoInfo.currentUrl) != null && (cellSummary = videoRecommendInfo2.mCellSummary) != null) {
                hVar.f50317a = pictureUrl.url;
                hVar.f50318b = cellSummary.summary;
                hVar.f50319c = videoRecommendInfo2;
                arrayList.add(hVar);
            }
        }
        return arrayList;
    }

    public static void k(Context context, String str, c cVar) {
        if (a(context, str, cVar)) {
            Intent intent = new Intent(BaseApplication.getContext(), (Class<?>) QQBrowserDelegationActivity.class);
            intent.putExtra("url", str);
            intent.putExtra("fromQZone", true);
            intent.putExtra("isVideoUrl", true);
            intent.putExtra("injectrecommend", true);
            intent.putExtra("UrlorData", true);
            intent.putExtra("isnew", true);
            intent.putExtra("source_name", BaseApplication.getContext().getString(R.string.ghh));
            yo.b.a(intent);
            context.startActivity(intent);
        }
    }

    public static void l(Context context, String str, c cVar) {
        Uri parse;
        if (a(context, str, cVar)) {
            Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
            Uri uri = null;
            try {
                try {
                    if (!str.toLowerCase().startsWith("http://") && !str.toLowerCase().startsWith("https://")) {
                        parse = Uri.fromFile(new File(str));
                        uri = parse;
                        intent.setDataAndType(uri, "video/*");
                        intent.addFlags(268435456);
                        context.startActivity(intent);
                    }
                    parse = Uri.parse(str);
                    uri = parse;
                    intent.setDataAndType(uri, "video/*");
                    intent.addFlags(268435456);
                    context.startActivity(intent);
                } catch (ActivityNotFoundException unused) {
                    Intent intent2 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
                    intent2.setDataAndType(uri, "video/mp4");
                    intent2.addFlags(268435456);
                    context.startActivity(intent2);
                }
            } catch (Exception unused2) {
            }
        }
    }

    public static void m(Context context, BusinessFeedData businessFeedData, int i3, boolean z16, boolean z17, String str) {
        if (context instanceof BasePluginActivity) {
            context = ((BasePluginActivity) context).getOutActivity();
        }
        qq_ad_get.QQAdGetRsp.AdInfo f16 = GdtFeedUtilForQZone.f(businessFeedData);
        try {
            GdtHandler.Params params = new GdtHandler.Params();
            params.videoCeilingSupportedIfInstalled = z17;
            params.activity = new WeakReference<>((Activity) context);
            params.f108486ad = new GdtAd(f16);
            params.reportForClick = true;
            params.sceneID = 0;
            params.componentID = i3;
            params.appAutoDownload = false;
            params.processId = 7;
            params.videoCeilingSupportedIfNotInstalled = z16;
            params.directPlay = true;
            Bundle bundle = new Bundle();
            params.extra = bundle;
            bundle.putString(LaunchParam.KEY_REF_ID, "biz_src_jc_qzone");
            params.antiSpamParams = str;
            ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).handleGdtAdClick(params);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public static VideoPlayInfo b(BusinessFeedData businessFeedData, VideoInfo videoInfo) {
        return c(businessFeedData, videoInfo, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0029 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Map<String, String> e(BusinessFeedData businessFeedData) {
        BusinessFeedData businessFeedData2;
        String str;
        String str2 = null;
        if (businessFeedData != null) {
            if (businessFeedData.getVideoInfo() != null) {
                businessFeedData2 = businessFeedData;
            } else if (businessFeedData.isForwardFeed() && businessFeedData.getOriginalInfo() != null && businessFeedData.getOriginalInfo().getVideoInfo() != null) {
                businessFeedData2 = businessFeedData.getOriginalInfo();
            }
            if (businessFeedData2 != null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("uin", String.valueOf(businessFeedData2.getUser().uin));
            hashMap.put("tid", businessFeedData.getIdInfo().cellId);
            if (businessFeedData2.getVideoInfo() != null) {
                if (NetworkState.isWifiConn()) {
                    if (businessFeedData2.getVideoInfo().highBrUrl != null) {
                        str = businessFeedData2.getVideoInfo().highBrUrl.url;
                        if (TextUtils.isEmpty(str)) {
                            if (businessFeedData2.getVideoInfo().videoUrl != null) {
                                str = businessFeedData2.getVideoInfo().videoUrl.url;
                            }
                        }
                    }
                    str = "";
                    if (TextUtils.isEmpty(str)) {
                    }
                } else {
                    if (businessFeedData2.getVideoInfo().lowBrUrl != null) {
                        str = businessFeedData2.getVideoInfo().lowBrUrl.url;
                        if (TextUtils.isEmpty(str)) {
                        }
                    }
                    str = "";
                    if (TextUtils.isEmpty(str)) {
                    }
                }
                hashMap.put("video_url", str);
                hashMap.put("appid", String.valueOf(businessFeedData2.getFeedCommInfo().appid));
                hashMap.put("feeds_key", businessFeedData2.getFeedCommInfo().feedskey);
                hashMap.put("ad_pos", String.valueOf(-1));
                if (businessFeedData.getOperationInfoV2() != null && businessFeedData.getOperationInfoV2().busiParam != null) {
                    str2 = businessFeedData.getOperationInfoV2().busiParam.get(97);
                }
                hashMap.put("bypass_param", str2 != null ? str2 : "");
                return hashMap;
            }
            str = "";
            hashMap.put("video_url", str);
            hashMap.put("appid", String.valueOf(businessFeedData2.getFeedCommInfo().appid));
            hashMap.put("feeds_key", businessFeedData2.getFeedCommInfo().feedskey);
            hashMap.put("ad_pos", String.valueOf(-1));
            if (businessFeedData.getOperationInfoV2() != null) {
                str2 = businessFeedData.getOperationInfoV2().busiParam.get(97);
            }
            hashMap.put("bypass_param", str2 != null ? str2 : "");
            return hashMap;
        }
        businessFeedData2 = null;
        if (businessFeedData2 != null) {
        }
    }

    private static boolean g(BusinessFeedData businessFeedData) {
        if (businessFeedData == null || businessFeedData.getRecommAction() == null || TextUtils.isEmpty(businessFeedData.getRecommAction().currency_pass_field)) {
            return false;
        }
        try {
            return new JSONObject(businessFeedData.getRecommAction().currency_pass_field).optInt(MiniProgramOpenSdkUtil.ATTR_SHARE_TO_QQ_MINI_PROGRAM_TYPE) == 3;
        } catch (Throwable unused) {
            QZLog.i("FeedVideoHelper", 2, "wechat error code0");
            return false;
        }
    }

    private static boolean a(Context context, String str, c cVar) {
        return (context == null || TextUtils.isEmpty(str)) ? false : true;
    }

    public static VideoPlayInfo c(BusinessFeedData businessFeedData, VideoInfo videoInfo, int i3) {
        VideoUrl videoUrl;
        CellLive cellLive;
        if (businessFeedData == null || videoInfo == null) {
            return null;
        }
        VideoPlayInfo videoPlayInfo = new VideoPlayInfo();
        videoPlayInfo.videoTime = videoInfo.videoTime;
        videoPlayInfo.validVideoTime = videoInfo.validVideoTime;
        videoPlayInfo.isFeedFirstComplete = videoInfo.isFeedFirstComplete;
        if (businessFeedData.getFeedCommInfo() != null) {
            videoPlayInfo.recomtype = businessFeedData.getFeedCommInfo().recomtype;
            videoPlayInfo.isVideoAdv = businessFeedData.getFeedCommInfo().isVideoAdv();
            videoPlayInfo.feedsAppId = businessFeedData.getFeedCommInfo().appid;
        }
        VideoInfo.VideoRemark videoRemark = videoInfo.videoRemark;
        if (videoRemark != null) {
            videoPlayInfo.orgwebsite = videoRemark.orgwebsite;
            videoPlayInfo.displayRemark = videoRemark.getDisplayRemark();
            videoPlayInfo.actionurl = videoInfo.videoRemark.actionurl;
        }
        if (businessFeedData.getOperationInfo() != null) {
            videoPlayInfo.cookie = businessFeedData.getOperationInfo().cookie;
            videoPlayInfo.downloadUrl = businessFeedData.getOperationInfo().downloadUrl;
            if (businessFeedData.getOperationInfo().busiParam != null) {
                videoPlayInfo.triggerHud = businessFeedData.getOperationInfo().busiParam.get(194);
                if (QZLog.isColorLevel()) {
                    QZLog.d("FeedVideoHelper", 2, "[convertToVideoPlayInfo] debugInfo=" + videoPlayInfo.triggerHud);
                }
            }
        }
        if (businessFeedData.getOriginalInfo() != null && businessFeedData.getOriginalInfo().getVideoInfo() != null) {
            if (businessFeedData.getFeedCommInfo().appid != 202) {
                videoPlayInfo.authorUin = businessFeedData.getOriginalInfo().getUser().uin;
                if (businessFeedData.getUser() != null) {
                    videoPlayInfo.reposterUin = businessFeedData.getUser().uin;
                }
            }
        } else if (businessFeedData.getUser() != null) {
            videoPlayInfo.authorUin = businessFeedData.getUser().uin;
        }
        videoPlayInfo.videoFeedType = businessFeedData.feedType;
        videoPlayInfo.isFeedFirst = videoInfo.isFeedFirst;
        videoPlayInfo.videoId = videoInfo.videoId;
        videoPlayInfo.showVideoTime = videoInfo.showVideoTime;
        videoPlayInfo.validVideoTimeDesc = videoInfo.validVideoTimeDesc;
        videoPlayInfo.isCircle = videoInfo.isCircle();
        videoPlayInfo.isAutoPlay = videoInfo.isAutoPlay();
        videoPlayInfo.isAdFeeds = businessFeedData.isAdFeeds();
        videoPlayInfo.isGdtAd = businessFeedData.isGDTAdvFeed();
        videoPlayInfo.isAdvMicro = businessFeedData.isAdvMicroVideo();
        videoPlayInfo.processor = videoInfo.processor;
        videoPlayInfo.width = videoInfo.width;
        videoPlayInfo.height = videoInfo.height;
        videoPlayInfo.originVideoSize = videoInfo.originVideoSize;
        videoPlayInfo.feedKey = businessFeedData.getFeedCommInfoV2().feedskey;
        videoPlayInfo.cellId = businessFeedData.getIdInfo().cellId;
        videoPlayInfo.videoStatus = videoInfo.videoStatus;
        videoPlayInfo.writeFrom = videoInfo.writeFrom;
        videoPlayInfo.playCount = videoInfo.videoplaycnt;
        videoPlayInfo.coverMaxWidth = i3;
        videoPlayInfo.videoPlayOnWifi = videoInfo.isOnWifiPlay;
        videoPlayInfo.feedTime = businessFeedData.getFeedCommInfoV2().time;
        videoPlayInfo.videoHasSetPlayOnWifi = videoInfo.hasSetPlayOnWifi;
        if (businessFeedData.getUser() != null) {
            videoPlayInfo.isOriginalContent = businessFeedData.getUser().displayflag == 1 || !(businessFeedData.getOriginalInfo() == null || businessFeedData.getOriginalInfo().getUser() == null || businessFeedData.getOriginalInfo().getUser().displayflag != 1);
        }
        int i16 = businessFeedData.feedType;
        if (i16 == 4097) {
            videoPlayInfo.videoPlayScene = "1";
        } else if (i16 == 2) {
            videoPlayInfo.videoPlayScene = "3";
        }
        HashMap<Integer, SegmentVideoInfo.StreamInfo> hashMap = new HashMap<>();
        com.qzone.commoncode.module.videorecommend.utils.a.b(hashMap, videoInfo);
        videoPlayInfo.segmentVideoInfo.setStreams(hashMap);
        videoPlayInfo.videoPlayScene = f(businessFeedData.feedType);
        if (businessFeedData.getOperationInfoV2() != null && businessFeedData.getOperationInfoV2().busiParam != null && businessFeedData.getOperationInfoV2().busiParam.containsKey(98)) {
            videoPlayInfo.videoReportInfo = businessFeedData.getOperationInfoV2().busiParam.get(98);
        }
        if (businessFeedData.getVideoInfo() != null) {
            videoPlayInfo.videoSource = String.valueOf(businessFeedData.getVideoInfo().videoSource);
        } else if (businessFeedData.getOriginalInfo() != null && businessFeedData.getOriginalInfo().getVideoInfo() != null) {
            videoPlayInfo.videoSource = String.valueOf(businessFeedData.getOriginalInfo().getVideoInfo().videoSource);
        }
        if (businessFeedData.getOriginalInfo() != null && businessFeedData.getOriginalInfo().getIdInfo() != null) {
            videoPlayInfo.originCellId = businessFeedData.getOriginalInfo().getIdInfo().cellId;
        }
        if (businessFeedData.getOriginalInfo() != null && businessFeedData.getOriginalInfo().getIdInfo() != null) {
            videoPlayInfo.originFeedTime = businessFeedData.getOriginalInfo().getFeedCommInfo().time;
        }
        if (businessFeedData.getFeedCommInfoV2() != null && businessFeedData.getFeedCommInfoV2().extendInfo != null) {
            String str = businessFeedData.getFeedCommInfoV2().extendInfo.get("ugc_feeds_create_time");
            if (!TextUtils.isEmpty(str)) {
                videoPlayInfo.ugcFeedsCreateTime = Long.valueOf(str).longValue() * 1000;
            }
        }
        com.tencent.mobileqq.qzoneplayer.video.PictureUrl pictureUrl = new com.tencent.mobileqq.qzoneplayer.video.PictureUrl();
        PictureUrl pictureUrl2 = videoInfo.coverUrl;
        if (pictureUrl2 != null) {
            pictureUrl.width = pictureUrl2.width;
            pictureUrl.height = pictureUrl2.height;
            pictureUrl.url = pictureUrl2.url;
            pictureUrl.imgUrl = pictureUrl2.imageUrl;
        }
        videoPlayInfo.coverUrl = pictureUrl;
        com.tencent.mobileqq.qzoneplayer.video.PictureUrl pictureUrl3 = new com.tencent.mobileqq.qzoneplayer.video.PictureUrl();
        PictureUrl pictureUrl4 = videoInfo.currentUrl;
        if (pictureUrl4 != null) {
            pictureUrl3.width = pictureUrl4.width;
            pictureUrl3.height = pictureUrl4.height;
            pictureUrl3.url = pictureUrl4.url;
            pictureUrl3.imgUrl = pictureUrl4.imageUrl;
        }
        videoPlayInfo.currentUrl = pictureUrl3;
        videoPlayInfo.videoFeedsReportParam = e(businessFeedData);
        if (businessFeedData.isBrandUgcAdvFeeds()) {
            videoPlayInfo.needAdvReport = true;
        }
        videoPlayInfo.videoFeedsType = 0;
        if (businessFeedData.isLiveVideoFeed() && (cellLive = businessFeedData.getCellLive()) != null) {
            videoPlayInfo.isNotRecordProgress = true;
            videoPlayInfo.isLiveVideo = true;
            videoPlayInfo.liveAppid = 1000360;
            if (cellLive.roomstat == 1) {
                videoPlayInfo.videoFeedsType = 1;
            } else {
                videoPlayInfo.videoFeedsType = 2;
            }
        }
        BusinessFeedData businessFeedData2 = businessFeedData.parentFeedData;
        if (businessFeedData2 != null) {
            videoPlayInfo.isFrdLikeVideo = businessFeedData2.isFrdLikeVideoContainer();
        } else {
            videoPlayInfo.isFrdLikeVideo = false;
        }
        if (businessFeedData.getCellBottomRecomm() != null && businessFeedData.getCellBottomRecomm().anonymity == CellBottomRecomm.TYPE_WEISHI) {
            videoPlayInfo.isWeishiShareVideo = true;
        }
        videoPlayInfo.gaussBackgroundUrl = videoInfo.gauseBackgroudUrl;
        videoPlayInfo.gauseBackgroudImageUrl = videoInfo.gauseBackgroudImageUrl;
        QZLog.i("QzonePhotoUtil", "FeedVideoHelper convertToVideoPlayInfo\uff1avideoInfo.downloadVideoUrl=" + videoInfo.downloadVideoUrl);
        if (TextUtils.isEmpty(videoPlayInfo.downloadUrl) && (videoUrl = videoInfo.downloadVideoUrl) != null) {
            videoPlayInfo.downloadUrl = videoUrl.url;
        }
        return videoPlayInfo;
    }

    public static void i(Context context, VideoInfo videoInfo, c cVar, int i3, String str) {
        j(context, videoInfo, cVar, i3, str, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void j(Context context, VideoInfo videoInfo, c cVar, int i3, String str, BusinessFeedData businessFeedData) {
        String str2;
        String str3;
        String str4;
        if (videoInfo == null) {
            return;
        }
        if (businessFeedData == null || !g(businessFeedData)) {
            if (videoInfo.isOpenWithFloat()) {
                videoInfo.hasVideoPlayed = true;
                return;
            }
            boolean z16 = !NetworkState.isWifiConn();
            if (z16) {
                VideoUrl videoUrl = videoInfo.lowBrUrl;
                str2 = videoUrl != null ? videoUrl.url : null;
                VideoUrl videoUrl2 = videoInfo.highBrUrl;
                if (videoUrl2 != null) {
                    str3 = videoUrl2.url;
                    if (!TextUtils.isEmpty(str2)) {
                        VideoUrl videoUrl3 = videoInfo.videoUrl;
                        String str5 = videoUrl3 != null ? videoUrl3.url : null;
                        if (QZLog.isColorLevel()) {
                            QZLog.i("FeedVideoHelper", 2, "Mobile = " + z16 + ", But main's NULL. So Pick <" + str5 + ">");
                        }
                        str4 = str5;
                    } else {
                        if (QZLog.isColorLevel()) {
                            QZLog.i("FeedVideoHelper", 2, "Mobile = " + z16 + ", So Pick <" + str2 + ">");
                        }
                        str4 = str2;
                    }
                    h(context, videoInfo.actionType, str4, cVar, i3, str3);
                }
            } else {
                VideoUrl videoUrl4 = videoInfo.highBrUrl;
                str2 = videoUrl4 != null ? videoUrl4.url : null;
            }
            str3 = null;
            if (!TextUtils.isEmpty(str2)) {
            }
            h(context, videoInfo.actionType, str4, cVar, i3, str3);
        }
    }

    public static void n(Context context, VideoInfo videoInfo, int i3, BusinessFeedData businessFeedData, FeedElement feedElement) {
        if (videoInfo == null || businessFeedData == null || feedElement == null) {
            return;
        }
        m(context, businessFeedData, feedElement == FeedElement.GESTURE_AD_VIEW ? 35 : 6, true, businessFeedData.isAppAd() && !businessFeedData.isDeepLink(), "");
    }

    public static String f(int i3) {
        if (i3 == 2) {
            return "3";
        }
        if (i3 == 3) {
            return "2";
        }
        if (i3 != 4097) {
            return "";
        }
        return "1";
    }

    public static void h(Context context, int i3, String str, c cVar, int i16, String... strArr) {
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 != 4) {
                    if (i3 != 19) {
                        return;
                    }
                }
            }
            l(context, str, cVar);
            return;
        }
        k(context, str, cVar);
    }
}
