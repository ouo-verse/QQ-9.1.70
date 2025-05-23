package com.tencent.qqmini.proxyimpl;

import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoPageData;
import com.tencent.gdtad.util.GdtUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes34.dex */
public class bf {
    public static GdtMotiveVideoPageData a(GdtAd gdtAd, String str, int i3) {
        String str2;
        if (gdtAd == null) {
            return null;
        }
        GdtMotiveVideoPageData gdtMotiveVideoPageData = new GdtMotiveVideoPageData();
        gdtMotiveVideoPageData.productType = gdtAd.getProductType();
        gdtMotiveVideoPageData.vSize = gdtAd.getCreativeSize();
        gdtMotiveVideoPageData.screenOrientation = i3;
        gdtMotiveVideoPageData.adId = gdtAd.getAdvertiserId();
        gdtMotiveVideoPageData.vid = gdtAd.getTencent_video_id();
        String videoUrl = gdtAd.getVideoUrl();
        gdtMotiveVideoPageData.url = videoUrl;
        if (!TextUtils.isEmpty(videoUrl) && gdtMotiveVideoPageData.url.startsWith("https://")) {
            gdtMotiveVideoPageData.url = gdtMotiveVideoPageData.url.replaceFirst("https://", "http://");
        }
        if (gdtAd.getImageData() == null) {
            str2 = "";
        } else {
            str2 = gdtAd.getImageData().url;
        }
        gdtMotiveVideoPageData.previewImgUrl = str2;
        gdtMotiveVideoPageData.bannerImgName = gdtAd.getAdvertiser_corporate_image_name();
        gdtMotiveVideoPageData.bannerBaseInfoText = gdtAd.getText();
        gdtMotiveVideoPageData.bannerLogo = gdtAd.getAdvertiser_corporate_logo();
        gdtMotiveVideoPageData.interactiveTipTxt = gdtAd.getInteractiveTipTxt();
        gdtMotiveVideoPageData.exposureUrl = gdtAd.getUrlForImpression();
        gdtMotiveVideoPageData.appScore = Double.valueOf(gdtAd.getAppScore()).doubleValue();
        gdtMotiveVideoPageData.downloadNum = gdtAd.getAppDownloadNum();
        gdtMotiveVideoPageData.style = gdtAd.getStyle();
        gdtMotiveVideoPageData.endcardUrl = gdtAd.getEndcardUrl();
        gdtMotiveVideoPageData.endcardLoadTime = gdtAd.getEndcardLoadTime();
        gdtMotiveVideoPageData.bottomCardUrl = gdtAd.getBottomCardUrl();
        gdtMotiveVideoPageData.bottomCardLoadTime = gdtAd.getBottomCardLoadTime();
        gdtMotiveVideoPageData.adsContent = str;
        gdtMotiveVideoPageData.processId = MobileQQ.sProcessId;
        gdtMotiveVideoPageData.passThroughData = gdtAd.getRewardPassThroughData();
        gdtMotiveVideoPageData.rewardType = gdtAd.getRewardType();
        gdtMotiveVideoPageData.renderType = gdtAd.getRenderType();
        gdtMotiveVideoPageData.playType = gdtAd.getRewardPlayType();
        gdtMotiveVideoPageData.hippyParams = GdtUtil.buildHippyParams(gdtAd);
        if (gdtAd.isRewardAdForcePortrait()) {
            QLog.d("[minigame] RewardedVideoAdPlugin", 1, "force portrait");
            gdtMotiveVideoPageData.screenOrientation = 1;
            gdtMotiveVideoPageData.isForcePortrait = true;
        }
        QLog.d("[minigame] RewardedVideoAdPlugin", 2, "mockMVPageData productType= " + gdtMotiveVideoPageData.productType + " vSize=" + gdtMotiveVideoPageData.vSize + " adId=" + gdtMotiveVideoPageData.adId + " vid=" + gdtMotiveVideoPageData.vid + " url=" + gdtMotiveVideoPageData.url + " previewImgUrl=" + gdtMotiveVideoPageData.previewImgUrl + " bannerImgName=" + gdtMotiveVideoPageData.bannerImgName + " bannerBaseInfoText=" + gdtMotiveVideoPageData.bannerBaseInfoText + " bannerLogo=" + gdtMotiveVideoPageData.bannerLogo + " exposureUrl=" + gdtMotiveVideoPageData.exposureUrl + " appScore=" + gdtMotiveVideoPageData.appScore + " downloadNum=" + gdtMotiveVideoPageData.downloadNum);
        return gdtMotiveVideoPageData;
    }
}
