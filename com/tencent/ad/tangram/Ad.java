package com.tencent.ad.tangram;

import android.support.annotation.Nullable;
import com.tencent.ad.tangram.annotation.AdKeep;
import java.util.List;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public interface Ad {
    boolean disableLaunchApp();

    long getAId();

    String getAppChannelAppName();

    String getAppChannelAuthorName();

    String getAppChannelFeatureListUrl();

    String getAppChannelICPNumber();

    String getAppChannelPermissionUrl();

    String getAppChannelPrivacyUrl();

    String getAppChannelSuitableAge();

    String getAppChannelVersionName();

    @Nullable
    String getAppDeeplink(AdClickLocationParams adClickLocationParams);

    String getAppDownloadUrlApi();

    String getAppIconUrl();

    @Nullable
    String getAppId();

    @Nullable
    String getAppMarketDeeplink();

    int getAppMarketJumpType();

    @Nullable
    List<String> getAppMarketPackageName();

    @Nullable
    String getAppName();

    @Nullable
    String getAppPackageName();

    String getButtonText(int i3, int i16);

    int getCarouselAdCount();

    int getCreativeSize();

    int getDestType();

    String getExtJSON();

    @Nullable
    List<?> getFeedbackItems();

    int getInnerShowType();

    int getMDPACount();

    @Nullable
    String getPosId();

    int getProductType();

    String getQuickAppDeeplink();

    int getRelationTarget();

    @Nullable
    String getTencent_video_id();

    @Nullable
    String getTraceId();

    @Nullable
    String getUrlForAction();

    @Nullable
    String getUrlForClick();

    @Nullable
    String getUrlForClick(AdClickLocationParams adClickLocationParams);

    @Nullable
    String getUrlForEffect();

    @Nullable
    String getUrlForFeedBack();

    @Nullable
    String getUrlForImpression();

    @Nullable
    String getUrlForLandingPage();

    @Nullable
    String getUrlForLandingPage(AdClickLocationParams adClickLocationParams);

    String getUrlForRewardLandingPage();

    @Nullable
    String getVia();

    int getVideoHeight();

    @Nullable
    String getVideoUrl(AdClickLocationParams adClickLocationParams);

    int getVideoWidth();

    String getViewId(AdClickLocationParams adClickLocationParams);

    @Nullable
    String getWXCanvasExtInfo(AdClickLocationParams adClickLocationParams);

    @Nullable
    String getWXChannelAppID();

    int getWXMINIGameJumpType();

    String getWXMINIProgramAppID(AdClickLocationParams adClickLocationParams);

    int getWXMINIProgramOpenType(AdClickLocationParams adClickLocationParams);

    @Nullable
    String getWXMINIProgramPath(AdClickLocationParams adClickLocationParams);

    @Nullable
    String getWXMINIProgramTraceData(AdClickLocationParams adClickLocationParams);

    @Nullable
    String getWXMINIProgramUserName(AdClickLocationParams adClickLocationParams);

    @Nullable
    String getWXToken(AdClickLocationParams adClickLocationParams);

    boolean isAppProductType();

    boolean isAppXiJing();

    boolean isAppXiJingDefault();

    boolean isAppXiJingFengling();

    boolean isDeeplinkFallbackToUrl();

    boolean isDownloadEnabled();

    boolean isEnableHalfScreenDownload();

    boolean isJDProductType();

    boolean isOlympicInterPageType();

    boolean isQQMINIProgram();

    boolean isQuickAppProductType();

    boolean isTripleLink();

    boolean isValid();

    boolean isVideoOnTopDisabled();

    boolean isWXCanvasAd();

    boolean isWXCustomerService();

    boolean isWXMINIGameProductType();

    boolean isWXMINIProgram();

    boolean isWXMINIProgramOrWXMINIGameProductType();

    boolean isXijingByExtensionType();
}
