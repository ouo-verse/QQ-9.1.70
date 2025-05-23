package com.qq.e.comm.pi;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Pair;
import android.view.View;
import java.util.List;
import org.json.JSONObject;

/* compiled from: P */
@Deprecated
/* loaded from: classes3.dex */
public interface SOI {
    public static final int GALLERY_SLIDE_CARD_AD = 1061;
    public static final int GALLERY_SLIDE_CARD_AD_WITHOUT_EASTERPAGE = 1062;
    public static final int INTERACTIVE_AD_AS = 1003;
    public static final int INTERACTIVE_AD_AS_WITHOUT_EP = 1004;
    public static final int INTERACTIVE_AD_CNY = 1001;
    public static final int INTERACTIVE_AD_CW = 1002;
    public static final int INTERACTIVE_AD_GST = 1000;
    public static final int INTERACTIVE_AD_LP = 1005;
    public static final int INTERACTIVE_AD_LP_WITHOUT_EP = 1006;
    public static final int ONESHOT_COST_ANIMATION_CANCEL = 1310307;
    public static final int ONESHOT_COST_ANIMATION_END = 1310306;
    public static final int ONESHOT_COST_ANIMATION_EXPOSURE = 1310323;
    public static final int ONESHOT_COST_ANIMATION_START = 1310305;
    public static final int TOPVIEW_COST_ANIMATION_EXPOSURE = 1310324;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public enum AdProductType {
        APP,
        LINK_WEB,
        MINI_PROGRAM,
        UNKNOWN
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public enum AdSubType {
        IMG,
        VIDEO,
        UNKNOWN
    }

    void clickFollowUAd(View view);

    void clickJoinAd(View view);

    void exposureFollowUAd();

    void exposureJoinAd(View view, long j3);

    String getAdIconText();

    String getAdJson();

    String getBarVideoFile();

    String getBarVideoUrl();

    String getButtonTxt();

    String getCl();

    String getCorporateImg();

    String getCorporateName();

    String getDesc();

    int getExposureDelay();

    int getFollowUAdShowTime();

    String getIconFile();

    String getIconUrl();

    int getInteractiveAdType();

    Bitmap getJoinAdImage(BitmapFactory.Options options);

    JSONObject getOneShotWindowAnimationInfo();

    List<Pair<String, String>> getOneShotWindowImageList();

    Bitmap getOneshotCoverImage(BitmapFactory.Options options);

    String getOneshotCoverImagePath();

    String getOneshotCoverImageUrl();

    String getOneshotSubOrderImagePath();

    String getOneshotSubOrderImageUrl();

    String getOneshotSubOrderVideoPath();

    String getOneshotSubOrderVideoUrl();

    JSONObject getPassThroughData();

    AdProductType getSplashProductType();

    String getSubOrderIconFile();

    String getSubOrderIconUrl();

    String getSubOrderTransparentVideoFile();

    String getSubOrderTransparentVideoUrl();

    AdSubType getSubType();

    String getTitle();

    String getVideoPath();

    boolean isContractAd();

    boolean isExtendAd();

    boolean isFollowUAd();

    boolean isHideAdIcon();

    boolean isInEffectPlayTime();

    boolean isInteractive();

    boolean isJoinAd();

    boolean isRealPreViewOrder();

    boolean isSplashMute();

    boolean isTopView();

    boolean isVideoAd();

    boolean needDoFloatViewAnimation();

    boolean needHideLogo();

    void reportJoinAdCost(int i3);

    void reportNegativeFeedback();
}
