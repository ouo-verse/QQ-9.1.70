package com.tencent.gdtad.util;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveHippyParams;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoModel;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoPageData;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GdtUtil {
    public static final String TAG = "GdtUtil";

    public static int adapterToAndroidScreenOrientation(int i3) {
        if (1 == i3) {
            return 0;
        }
        if (2 != i3) {
            return 1;
        }
        return 8;
    }

    public static GdtMotiveHippyParams buildHippyParams(GdtAd gdtAd) {
        if (gdtAd == null) {
            return null;
        }
        GdtMotiveHippyParams gdtMotiveHippyParams = new GdtMotiveHippyParams();
        String rewardTemplateIdFromPassThrough = gdtAd.getRewardTemplateIdFromPassThrough();
        if (!TextUtils.isEmpty(rewardTemplateIdFromPassThrough)) {
            gdtMotiveHippyParams.setTemplateId(rewardTemplateIdFromPassThrough);
        } else {
            gdtMotiveHippyParams.setTemplateId(gdtAd.getRewardTemplateId());
        }
        return gdtMotiveHippyParams;
    }

    @Nullable
    public static GdtMotiveVideoPageData createMVPageData(@Nullable qq_ad_get.QQAdGetRsp.AdInfo adInfo, int i3) {
        String str;
        GdtAd gdtAd = new GdtAd(adInfo);
        Object obj = null;
        if (gdtAd.info != null) {
            GdtMotiveVideoPageData gdtMotiveVideoPageData = new GdtMotiveVideoPageData();
            gdtMotiveVideoPageData.productType = gdtAd.getProductType();
            gdtMotiveVideoPageData.screenOrientation = i3;
            gdtMotiveVideoPageData.adId = gdtAd.getAdvertiserId();
            gdtMotiveVideoPageData.vid = gdtAd.getTencent_video_id();
            gdtMotiveVideoPageData.url = gdtAd.getVideoUrl();
            GdtLog.e(TAG, "VideoUrl " + gdtMotiveVideoPageData.url);
            String str2 = "";
            if (gdtAd.getImageData() == null) {
                str = "";
            } else {
                str = gdtAd.getImageData().url;
            }
            gdtMotiveVideoPageData.previewImgUrl = str;
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
            if (adInfo != null) {
                obj = GdtJsonPbUtil.pbToJson(adInfo);
            }
            if (obj != null) {
                str2 = obj.toString();
            }
            gdtMotiveVideoPageData.adsContent = str2;
            gdtMotiveVideoPageData.processId = MobileQQ.sProcessId;
            gdtMotiveVideoPageData.rewardType = gdtAd.getRewardType();
            gdtMotiveVideoPageData.renderType = gdtAd.getRenderType();
            gdtMotiveVideoPageData.playType = gdtAd.getRewardPlayType();
            gdtMotiveVideoPageData.passThroughData = gdtAd.getRewardPassThroughData();
            gdtMotiveVideoPageData.hippyParams = buildHippyParams(gdtAd);
            return gdtMotiveVideoPageData;
        }
        QLog.e(TAG, 1, "createMVPageData error " + adInfo + " portrait " + i3);
        return null;
    }

    public static int getRewardTime(@Nullable GdtMotiveVideoModel gdtMotiveVideoModel) {
        int i3;
        if (gdtMotiveVideoModel != null && gdtMotiveVideoModel.getGdtAd() != null) {
            i3 = gdtMotiveVideoModel.getGdtAd().getRewardTime();
        } else {
            i3 = 0;
        }
        if (i3 <= 0 && gdtMotiveVideoModel != null && gdtMotiveVideoModel.getGdtMotiveVideoPageData() != null) {
            i3 = gdtMotiveVideoModel.getGdtMotiveVideoPageData().getVideoCountDown();
        }
        if (i3 <= 0) {
            return 15;
        }
        return i3;
    }

    public static boolean isAppInstall(@Nullable Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            boolean isAppInstalled = PackageUtil.isAppInstalled(context, str);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "isAppInstall pkg:" + str + " " + isAppInstalled);
            }
            return isAppInstalled;
        }
        return false;
    }

    public static int parseDataType(GdtMotiveVideoPageData gdtMotiveVideoPageData) {
        return parseDataType(parseGdtAdFromString(gdtMotiveVideoPageData), gdtMotiveVideoPageData != null && gdtMotiveVideoPageData.enableHippy);
    }

    public static GdtAd parseGdtAdFromString(GdtMotiveVideoPageData gdtMotiveVideoPageData) {
        if (gdtMotiveVideoPageData != null && !TextUtils.isEmpty(gdtMotiveVideoPageData.adsContent)) {
            try {
                return new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo) GdtJsonPbUtil.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo(), new JSONObject(gdtMotiveVideoPageData.adsContent)));
            } catch (Throwable th5) {
                GdtLog.e(TAG, "[reportForMotiveAd]", th5);
            }
        }
        return null;
    }

    private static int parseDataType(GdtAd gdtAd, boolean z16) {
        if (gdtAd == null || !gdtAd.isValid()) {
            return Integer.MIN_VALUE;
        }
        if (z16 && gdtAd.getRenderType() == 2) {
            return 6;
        }
        if (gdtAd.isMotiveBrowsingFromExtJson()) {
            return 1;
        }
        int innerShowType = gdtAd.getInnerShowType();
        if (innerShowType == 1) {
            return 4;
        }
        if (innerShowType == 2) {
            return 5;
        }
        if (innerShowType == 3) {
            return 2;
        }
        if (innerShowType != 4) {
            int creativeSize = gdtAd.getCreativeSize();
            if (creativeSize == 1735) {
                return 1;
            }
            if (creativeSize != 585 && creativeSize != 866) {
                if (creativeSize == 185 || creativeSize == 1766 || creativeSize == 351) {
                    return 2;
                }
                if (creativeSize == 710) {
                    return 5;
                }
                return creativeSize == 65 ? 4 : 1;
            }
        }
        return 3;
    }
}
