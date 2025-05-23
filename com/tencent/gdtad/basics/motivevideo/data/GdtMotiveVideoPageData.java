package com.tencent.gdtad.basics.motivevideo.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.gdtad.util.GdtUtil;
import java.io.Serializable;

/* loaded from: classes6.dex */
public class GdtMotiveVideoPageData implements Serializable {
    public static final int CONTAINER_ACTIVITY = 0;
    public static final int CONTAINER_WINDOW = 1;
    public static final int DEFAULT_BOTTOM_CARD_LOAD_SEC = 2;
    public static final int DEFAULT_ENDCARD_LOADTIME = 5;
    public static final int DEFAULT_SHOT_SECONDS = 15;

    @NonNull
    public static String TAG = "GdtMotiveVideoAd";
    public static final int TYPE_MOTIVE_BROWSING = 1;
    public static final int TYPE_MOTIVE_HIPPY = 6;
    public static final int TYPE_MOTIVE_PICTURE_16_9 = 4;
    public static final int TYPE_MOTIVE_PICTURE_9_16 = 5;
    public static final int TYPE_MOTIVE_VIDEO_16_9 = 2;
    public static final int TYPE_MOTIVE_VIDEO_9_16 = 3;
    public static final int TYPE_UNKNOWN = Integer.MIN_VALUE;
    public long adId;
    public String adsContent;
    public String antiSpamParams;
    private String asyncCallbackId;

    @Nullable
    public String bannerBaseInfoText;

    @Nullable
    public String bannerImgName;

    @Nullable
    public String bannerLogo;

    @Nullable
    public String bottomCardUrl;

    @Nullable
    public String endcardUrl;

    @Nullable
    public String exposureUrl;
    public GdtMotiveHippyParams hippyParams;
    public String interactiveTipTxt;
    public long jsState;
    public String motiveBrowsingKey;
    public String passThroughData;
    public String previewImgUrl;
    public int processId;
    public int productType;
    public String refId;
    private String rewardText;
    public boolean supportOpenMotiveAd;
    public String traceId;

    @Nullable
    public String url;

    @Deprecated
    public int vSize;

    @Nullable
    public String vid;
    public String appId = "";
    public long downloadNum = 0;
    public double appScore = 0.0d;
    public int endcardLoadTime = 5;
    public int bottomCardLoadTime = 2;
    public int screenOrientation = 0;
    public boolean isMiniGame = false;
    public boolean enableHippy = true;
    public int style = 0;
    public int containerType = 0;
    private int videoCountDown = 15;
    private int type = Integer.MIN_VALUE;
    public int rewardType = Integer.MIN_VALUE;
    public int renderType = Integer.MIN_VALUE;
    public int playType = Integer.MIN_VALUE;
    public boolean isForcePortrait = false;
    public boolean isLandscapeForcePortrait = false;

    public String getAsyncCallbackId() {
        return this.asyncCallbackId;
    }

    public String getRewardText() {
        return this.rewardText;
    }

    public int getType() {
        if (this.type == Integer.MIN_VALUE || !this.enableHippy) {
            this.type = GdtUtil.parseDataType(this);
        }
        return this.type;
    }

    @Deprecated
    public int getVideoCountDown() {
        return this.videoCountDown;
    }

    public boolean isStyleA() {
        if (this.style == 0) {
            return true;
        }
        return false;
    }

    public boolean isStyleB() {
        if (this.style == 1) {
            return true;
        }
        return false;
    }

    public boolean isStyleC() {
        if (this.style == 2) {
            return true;
        }
        return false;
    }

    public void setAsyncCallbackId(String str) {
        this.asyncCallbackId = str;
    }

    public void setRewardText(String str) {
        this.rewardText = str;
    }

    @Deprecated
    public void setVideoCountDown(int i3) {
        this.videoCountDown = i3;
    }

    public String toString() {
        return "GdtMotiveVideoPageData{vid='" + this.vid + "', vSize=" + this.vSize + ", exposureUrl='" + this.exposureUrl + "', bannerImgName='" + this.bannerImgName + "', bannerBaseInfoText='" + this.bannerBaseInfoText + "', bannerLogo='" + this.bannerLogo + "', productType=" + this.productType + ", previewImgUrl='" + this.previewImgUrl + "', adId=" + this.adId + ", appId='" + this.appId + "', downloadNum=" + this.downloadNum + ", appScore=" + this.appScore + ", jsState=" + this.jsState + ", url='" + this.url + "', endcardUrl='" + this.endcardUrl + "', endcardLoadTime=" + this.endcardLoadTime + ", bottomCardUrl='" + this.bottomCardUrl + "', bottomCardLoadTime=" + this.bottomCardLoadTime + ", traceId='" + this.traceId + "', screenOrientation=" + this.screenOrientation + ", adsContent='" + this.adsContent + "', processId=" + this.processId + ", interactiveTipTxt='" + this.interactiveTipTxt + "', isMiniGame=" + this.isMiniGame + ", enableHippy=" + this.enableHippy + ", style=" + this.style + ", refId='" + this.refId + "', containerType=" + this.containerType + ", videoCountDown=" + this.videoCountDown + ", type=" + this.type + ", hippyParams=" + this.hippyParams + ", rewardType=" + this.rewardType + ", renderType=" + this.renderType + ", playType=" + this.playType + ", passThroughData='" + this.passThroughData + "', supportOpenMotiveAd='" + this.supportOpenMotiveAd + "', rewardText='" + this.rewardText + "', motiveBrowsingKey='" + this.motiveBrowsingKey + "', antiSpamParams='" + this.antiSpamParams + "', asyncCallbackId='" + this.asyncCallbackId + "'}";
    }
}
