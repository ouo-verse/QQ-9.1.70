package com.qq.e.comm.pi;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Pair;
import android.view.View;
import com.qq.e.comm.pi.SOI;
import com.qq.e.tg.splash.TGSplashAD;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface SOIV2 extends SOI {

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class JoinAdType {
        public static final int DOODLE = 2;
        public static final int ONE_SHOT = 1;
        public static final int UNKNOWN = 0;
    }

    void clickFollowUAd(View view, Object obj);

    void clickJoinAd(View view, Object obj);

    void exposureFollowUAd(Object obj);

    void exposureJoinAd(View view, long j3, Object obj);

    String getAdIconText(Object obj);

    String getAdJson(Object obj);

    String getBarVideoFile(Object obj);

    String getBarVideoUrl(Object obj);

    String getButtonTxt(Object obj);

    String getCl(Object obj);

    String getCorporateImg(Object obj);

    String getCorporateName(Object obj);

    String getDesc(Object obj);

    int getExposureDelay(Object obj);

    int getFollowUAdShowTime(Object obj);

    String getIconFile(Object obj);

    String getIconUrl(Object obj);

    int getInteractiveAdType(Object obj);

    Bitmap getJoinAdImage(BitmapFactory.Options options, Object obj);

    int getJoinAdType(Object obj);

    JSONObject getOneShotWindowAnimationInfo(Object obj);

    List<Pair<String, String>> getOneShotWindowImageList(Object obj);

    Bitmap getOneshotCoverImage(BitmapFactory.Options options, Object obj);

    String getOneshotCoverImagePath(Object obj);

    String getOneshotCoverImageUrl(Object obj);

    String getOneshotSubOrderImagePath(Object obj);

    String getOneshotSubOrderImageUrl(Object obj);

    String getOneshotSubOrderVideoPath(Object obj);

    String getOneshotSubOrderVideoUrl(Object obj);

    JSONObject getPassThroughData(Object obj);

    SOI.AdProductType getSplashProductType(Object obj);

    String getSubOrderAdJson(Object obj);

    String getSubOrderIconFile(Object obj);

    String getSubOrderIconUrl(Object obj);

    String getSubOrderTransparentVideoFile(Object obj);

    String getSubOrderTransparentVideoUrl(Object obj);

    SOI.AdSubType getSubType(Object obj);

    String getTitle(Object obj);

    String getVideoPath(Object obj);

    boolean isAlphaVideoAd(Object obj);

    boolean isContractAd(Object obj);

    boolean isExtendAd(Object obj);

    boolean isFollowUAd(Object obj);

    boolean isHideAdIcon(Object obj);

    boolean isInEffectPlayTime(Object obj);

    boolean isInteractive(Object obj);

    boolean isJoinAd(Object obj);

    boolean isOlympicGallery(Object obj);

    boolean isRealPreViewOrder(Object obj);

    boolean isSplashMute(Object obj);

    boolean isSplashOrderMute(Object obj);

    boolean isTopView(Object obj);

    boolean isVideoAd(Object obj);

    boolean needDoFloatViewAnimation(Object obj);

    boolean needHideLogo(Object obj);

    void reportCost(int i3, int i16, boolean z16, Map map, Object obj);

    void reportJoinAdCost(int i3, Object obj);

    void reportLinkEvent(TGSplashAD.ReportParams reportParams);

    void reportNegativeFeedback(Object obj);

    void reportNoUseSplashReason(int i3, boolean z16, Object obj);
}
