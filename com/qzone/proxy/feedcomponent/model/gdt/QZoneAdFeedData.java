package com.qzone.proxy.feedcomponent.model.gdt;

import com.qzone.proxy.feedcomponent.model.gdt.GdtAdFeedUtil;
import com.tencent.ams.xsad.rewarded.dynamic.method.RewardAdMethodHandler;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.qzoneplayer.video.VideoPlayInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 ^2\u00020\u0001:\u0002^_B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\"\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010)\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001c\u0010*\u001a\u0004\u0018\u00010+X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00100\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u001f\"\u0004\b3\u0010!R\u001a\u00104\u001a\u000205X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u00106\"\u0004\b7\u00108R\u001a\u00109\u001a\u000205X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u00106\"\u0004\b:\u00108R\u001a\u0010;\u001a\u000205X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b;\u00106\"\u0004\b<\u00108R\u001a\u0010=\u001a\u000205X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b=\u00106\"\u0004\b>\u00108R\u001e\u0010?\u001a\u0004\u0018\u000105X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010C\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001a\u0010D\u001a\u000205X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bD\u00106\"\u0004\bE\u00108R\u001a\u0010F\u001a\u000205X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bF\u00106\"\u0004\bG\u00108R\u001a\u0010H\u001a\u000205X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bH\u00106\"\u0004\bI\u00108R\u001a\u0010J\u001a\u000205X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bJ\u00106\"\u0004\bK\u00108R\u001a\u0010L\u001a\u000205X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bL\u00106\"\u0004\bM\u00108R\u001a\u0010N\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u0006\"\u0004\bP\u0010\bR \u0010Q\u001a\b\u0012\u0004\u0012\u00020R0\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\u001f\"\u0004\bT\u0010!R\u001a\u0010U\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\u0006\"\u0004\bW\u0010\bR\u001a\u0010X\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bY\u0010\u0006\"\u0004\bZ\u0010\bR\u001a\u0010[\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010\u0006\"\u0004\b]\u0010\b\u00a8\u0006`"}, d2 = {"Lcom/qzone/proxy/feedcomponent/model/gdt/QZoneAdFeedData;", "", "()V", "GestureAdBeginTime", "", "getGestureAdBeginTime", "()I", "setGestureAdBeginTime", "(I)V", "GestureAdEndTime", "getGestureAdEndTime", "setGestureAdEndTime", "MDPAClickItemPosition", "getMDPAClickItemPosition", "setMDPAClickItemPosition", "adInfo", "Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;", RewardAdMethodHandler.RewardAdEvent.GET_AD_INFO, "()Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;", "setAdInfo", "(Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;)V", "carouselCardClickedOrManuallyScrolledItemPosition", "getCarouselCardClickedOrManuallyScrolledItemPosition", "setCarouselCardClickedOrManuallyScrolledItemPosition", "carouselCardFirstVisibleItemPosition", "getCarouselCardFirstVisibleItemPosition", "setCarouselCardFirstVisibleItemPosition", "carouselCardInfoList", "", "Lcom/qzone/proxy/feedcomponent/model/gdt/GdtAdFeedUtil$CarouselCardInfo;", "getCarouselCardInfoList", "()Ljava/util/List;", "setCarouselCardInfoList", "(Ljava/util/List;)V", "danmakuAdContents", "", "", "getDanmakuAdContents", "()[Ljava/lang/String;", "setDanmakuAdContents", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "gdtVideoPlayInfoForReportAdPlay", "Lcom/tencent/mobileqq/qzoneplayer/video/VideoPlayInfo;", "getGdtVideoPlayInfoForReportAdPlay", "()Lcom/tencent/mobileqq/qzoneplayer/video/VideoPlayInfo;", "setGdtVideoPlayInfoForReportAdPlay", "(Lcom/tencent/mobileqq/qzoneplayer/video/VideoPlayInfo;)V", "gestureStageInfoList", "Lcom/qzone/proxy/feedcomponent/model/gdt/QZoneAdFeedData$GestureStageInfo;", "getGestureStageInfoList", "setGestureStageInfoList", "isAddGroupAdShow", "", "()Z", "setAddGroupAdShow", "(Z)V", "isBrandOptimizationShow", "setBrandOptimizationShow", "isC2SExposureReported", "setC2SExposureReported", "isCGIExposureReport", "setCGIExposureReport", "isDanmukuAdv", "()Ljava/lang/Boolean;", "setDanmukuAdv", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "isGdtCrossAd", "setGdtCrossAd", "isGdtCrossAdClosed", "setGdtCrossAdClosed", "isNeedShowRecommendAd", "setNeedShowRecommendAd", "isPraised", "setPraised", "isShowingRecommendAd", "setShowingRecommendAd", "mInnerAdShowType", "getMInnerAdShowType", "setMInnerAdShowType", "recommendAdList", "Lcom/tencent/gdtad/aditem/GdtAd;", "getRecommendAdList", "setRecommendAdList", "videoHeight", "getVideoHeight", "setVideoHeight", "videoWidth", "getVideoWidth", "setVideoWidth", "visitCount", "getVisitCount", "setVisitCount", "Companion", "GestureStageInfo", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes39.dex */
public final class QZoneAdFeedData {
    public static final String AD_REWARD = "QzoneActivity";
    public static final String AD_TIANSHU = "TianShu";
    public static final String EXP_LEFT_TEXT_AND_LABEL_KEY = "151291";
    public static final String EXP_REWARD_AD_PRE_REQUEST = "1";
    public static final String EXP_VIDEO_ALL_AUTO_PLAY_VALUE = "2";
    public static final String EXP_VIDEO_LANDING_PAGE_AUTO_PLAY_VALUE = "1";
    public static final int EXTENDINFO_KEY_FIRST_CATEGORY = 36;
    public static final int EXTENDINFO_KEY_NATIVE_AD = 32;
    public static final int EXTENDINFO_KEY_PICTURE_URL = 12;
    public static final int EXTENDINFO_KEY_QZONE_AD_TYPE = 34;
    public static final int EXTENDINFO_KEY_REALTIME_REQUEST_AD = 35;
    public static final int EXTENDINFO_KEY_RECOMMEND_AD_REQUEST_DELAY = 42;
    public static final int EXTENDINFO_KEY_RECOMMEND_AD_REQUEST_SWITCH = 38;
    public static final int EXTENDINFO_KEY_RECOMMEND_AD_STAY_TIME = 43;
    public static final int EXTENDINFO_KEY_SECOND_CATEGORY = 37;
    public static final int EXTENDINFO_KEY_SHAKE_AD_NEW_STYLE = 41;
    public static final int EXTENDINFO_KEY_SHAKE_AD_POSITION_PERCENTAGE = 39;
    public static final int EXTENDINFO_KEY_SHAKE_AD_VISIBLE = 31;
    public static final int EXTENDINFO_KEY_SHAKE_AD_WATING_TIME = 40;
    public static final int EXTENDINFO_KEY_VIDEO_AUTO_PLAY = 33;
    public static final String GDT_VIDEO_HEIGHT = "video_height";
    public static final String GDT_VIDEO_WIDTH = "video_width";
    public static final int GESTURE_STAGE_TYPE_BIG_FINGER = 2;
    public static final int GESTURE_STAGE_TYPE_SMALL_FINGER = 1;
    public static final int GESTURE_STAGE_TYPE_UNKNOWN = 0;
    public static final int LOGO_NICK_AD = 2;
    public static final int QZONE_FRIEND_FEEDS_STYLE = 100478;
    public static final int REWARD_AD_TYPE = 26;
    private int GestureAdBeginTime;
    private int GestureAdEndTime;
    private qq_ad_get.QQAdGetRsp.AdInfo adInfo;
    private List<GdtAdFeedUtil.CarouselCardInfo> carouselCardInfoList;
    private VideoPlayInfo gdtVideoPlayInfoForReportAdPlay;
    private List<GestureStageInfo> gestureStageInfoList;
    private boolean isAddGroupAdShow;
    private boolean isBrandOptimizationShow;
    private boolean isC2SExposureReported;
    private boolean isCGIExposureReport;
    private Boolean isDanmukuAdv;
    private boolean isGdtCrossAd;
    private boolean isGdtCrossAdClosed;
    private boolean isNeedShowRecommendAd;
    private boolean isPraised;
    private boolean isShowingRecommendAd;
    private List<? extends GdtAd> recommendAdList;
    private int visitCount;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "QZoneAdFeedData";
    private static final String AD_SHOW_TYPE_OF_BRAND_OPTIMIZATION = "20";
    private static final String AD_SHOW_TYPE_OF_ADD_GROUP = "25";
    private static final int GESTURE_AD_BEGIN_TIME_KEY = 27;
    private static final int GESTURE_AD_END_TIME_KEY = 28;
    private static final String EXP_MDPA_STYLE = "123756";
    private String[] danmakuAdContents = new String[0];
    private int carouselCardFirstVisibleItemPosition = Integer.MIN_VALUE;
    private int carouselCardClickedOrManuallyScrolledItemPosition = Integer.MIN_VALUE;
    private int MDPAClickItemPosition = Integer.MIN_VALUE;
    private int mInnerAdShowType = Integer.MIN_VALUE;
    private int videoWidth = Integer.MIN_VALUE;
    private int videoHeight = Integer.MIN_VALUE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u001d\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0012X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0012X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0012X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0012X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0012X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0012X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0012X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0012X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0012X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0012X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\u00020\u0012X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\u0012X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010$R\u000e\u0010'\u001a\u00020\u0012X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0012X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0012X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0012X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0012X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0012X\u0086T\u00a2\u0006\u0002\n\u0000R\u0014\u0010-\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0007\u00a8\u0006/"}, d2 = {"Lcom/qzone/proxy/feedcomponent/model/gdt/QZoneAdFeedData$Companion;", "", "()V", "AD_REWARD", "", "AD_SHOW_TYPE_OF_ADD_GROUP", "getAD_SHOW_TYPE_OF_ADD_GROUP", "()Ljava/lang/String;", "AD_SHOW_TYPE_OF_BRAND_OPTIMIZATION", "getAD_SHOW_TYPE_OF_BRAND_OPTIMIZATION", "AD_TIANSHU", "EXP_LEFT_TEXT_AND_LABEL_KEY", "EXP_MDPA_STYLE", "getEXP_MDPA_STYLE", "EXP_REWARD_AD_PRE_REQUEST", "EXP_VIDEO_ALL_AUTO_PLAY_VALUE", "EXP_VIDEO_LANDING_PAGE_AUTO_PLAY_VALUE", "EXTENDINFO_KEY_FIRST_CATEGORY", "", "EXTENDINFO_KEY_NATIVE_AD", "EXTENDINFO_KEY_PICTURE_URL", "EXTENDINFO_KEY_QZONE_AD_TYPE", "EXTENDINFO_KEY_REALTIME_REQUEST_AD", "EXTENDINFO_KEY_RECOMMEND_AD_REQUEST_DELAY", "EXTENDINFO_KEY_RECOMMEND_AD_REQUEST_SWITCH", "EXTENDINFO_KEY_RECOMMEND_AD_STAY_TIME", "EXTENDINFO_KEY_SECOND_CATEGORY", "EXTENDINFO_KEY_SHAKE_AD_NEW_STYLE", "EXTENDINFO_KEY_SHAKE_AD_POSITION_PERCENTAGE", "EXTENDINFO_KEY_SHAKE_AD_VISIBLE", "EXTENDINFO_KEY_SHAKE_AD_WATING_TIME", "EXTENDINFO_KEY_VIDEO_AUTO_PLAY", "GDT_VIDEO_HEIGHT", "GDT_VIDEO_WIDTH", "GESTURE_AD_BEGIN_TIME_KEY", "getGESTURE_AD_BEGIN_TIME_KEY", "()I", "GESTURE_AD_END_TIME_KEY", "getGESTURE_AD_END_TIME_KEY", "GESTURE_STAGE_TYPE_BIG_FINGER", "GESTURE_STAGE_TYPE_SMALL_FINGER", "GESTURE_STAGE_TYPE_UNKNOWN", "LOGO_NICK_AD", "QZONE_FRIEND_FEEDS_STYLE", "REWARD_AD_TYPE", "TAG", "getTAG", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes39.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getAD_SHOW_TYPE_OF_ADD_GROUP() {
            return QZoneAdFeedData.AD_SHOW_TYPE_OF_ADD_GROUP;
        }

        public final String getAD_SHOW_TYPE_OF_BRAND_OPTIMIZATION() {
            return QZoneAdFeedData.AD_SHOW_TYPE_OF_BRAND_OPTIMIZATION;
        }

        public final String getEXP_MDPA_STYLE() {
            return QZoneAdFeedData.EXP_MDPA_STYLE;
        }

        public final int getGESTURE_AD_BEGIN_TIME_KEY() {
            return QZoneAdFeedData.GESTURE_AD_BEGIN_TIME_KEY;
        }

        public final int getGESTURE_AD_END_TIME_KEY() {
            return QZoneAdFeedData.GESTURE_AD_END_TIME_KEY;
        }

        public final String getTAG() {
            return QZoneAdFeedData.TAG;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001a\u0010\u0018\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011\u00a8\u0006\u001b"}, d2 = {"Lcom/qzone/proxy/feedcomponent/model/gdt/QZoneAdFeedData$GestureStageInfo;", "", "()V", "beginTimeS", "", "getBeginTimeS", "()I", "setBeginTimeS", "(I)V", "endTimeS", "getEndTimeS", "setEndTimeS", "iconUrl", "", "getIconUrl", "()Ljava/lang/String;", "setIconUrl", "(Ljava/lang/String;)V", "stageType", "getStageType", "setStageType", "tipFirstLine", "getTipFirstLine", "setTipFirstLine", "tipSecondLine", "getTipSecondLine", "setTipSecondLine", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes39.dex */
    public static final class GestureStageInfo {
        private int beginTimeS;
        private int endTimeS;
        private int stageType;
        private String iconUrl = "";
        private String tipFirstLine = "";
        private String tipSecondLine = "";

        public final int getBeginTimeS() {
            return this.beginTimeS;
        }

        public final int getEndTimeS() {
            return this.endTimeS;
        }

        public final String getIconUrl() {
            return this.iconUrl;
        }

        public final int getStageType() {
            return this.stageType;
        }

        public final String getTipFirstLine() {
            return this.tipFirstLine;
        }

        public final String getTipSecondLine() {
            return this.tipSecondLine;
        }

        public final void setBeginTimeS(int i3) {
            this.beginTimeS = i3;
        }

        public final void setEndTimeS(int i3) {
            this.endTimeS = i3;
        }

        public final void setIconUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.iconUrl = str;
        }

        public final void setStageType(int i3) {
            this.stageType = i3;
        }

        public final void setTipFirstLine(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.tipFirstLine = str;
        }

        public final void setTipSecondLine(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.tipSecondLine = str;
        }
    }

    public QZoneAdFeedData() {
        List<? extends GdtAd> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.recommendAdList = emptyList;
    }

    public final qq_ad_get.QQAdGetRsp.AdInfo getAdInfo() {
        return this.adInfo;
    }

    public final int getCarouselCardClickedOrManuallyScrolledItemPosition() {
        return this.carouselCardClickedOrManuallyScrolledItemPosition;
    }

    public final int getCarouselCardFirstVisibleItemPosition() {
        return this.carouselCardFirstVisibleItemPosition;
    }

    public final List<GdtAdFeedUtil.CarouselCardInfo> getCarouselCardInfoList() {
        return this.carouselCardInfoList;
    }

    public final String[] getDanmakuAdContents() {
        return this.danmakuAdContents;
    }

    public final VideoPlayInfo getGdtVideoPlayInfoForReportAdPlay() {
        return this.gdtVideoPlayInfoForReportAdPlay;
    }

    public final int getGestureAdBeginTime() {
        return this.GestureAdBeginTime;
    }

    public final int getGestureAdEndTime() {
        return this.GestureAdEndTime;
    }

    public final List<GestureStageInfo> getGestureStageInfoList() {
        return this.gestureStageInfoList;
    }

    public final int getMDPAClickItemPosition() {
        return this.MDPAClickItemPosition;
    }

    public final int getMInnerAdShowType() {
        return this.mInnerAdShowType;
    }

    public final List<GdtAd> getRecommendAdList() {
        return this.recommendAdList;
    }

    public final int getVideoHeight() {
        return this.videoHeight;
    }

    public final int getVideoWidth() {
        return this.videoWidth;
    }

    public final int getVisitCount() {
        return this.visitCount;
    }

    /* renamed from: isAddGroupAdShow, reason: from getter */
    public final boolean getIsAddGroupAdShow() {
        return this.isAddGroupAdShow;
    }

    /* renamed from: isBrandOptimizationShow, reason: from getter */
    public final boolean getIsBrandOptimizationShow() {
        return this.isBrandOptimizationShow;
    }

    /* renamed from: isC2SExposureReported, reason: from getter */
    public final boolean getIsC2SExposureReported() {
        return this.isC2SExposureReported;
    }

    /* renamed from: isCGIExposureReport, reason: from getter */
    public final boolean getIsCGIExposureReport() {
        return this.isCGIExposureReport;
    }

    /* renamed from: isDanmukuAdv, reason: from getter */
    public final Boolean getIsDanmukuAdv() {
        return this.isDanmukuAdv;
    }

    /* renamed from: isGdtCrossAd, reason: from getter */
    public final boolean getIsGdtCrossAd() {
        return this.isGdtCrossAd;
    }

    /* renamed from: isGdtCrossAdClosed, reason: from getter */
    public final boolean getIsGdtCrossAdClosed() {
        return this.isGdtCrossAdClosed;
    }

    /* renamed from: isNeedShowRecommendAd, reason: from getter */
    public final boolean getIsNeedShowRecommendAd() {
        return this.isNeedShowRecommendAd;
    }

    /* renamed from: isPraised, reason: from getter */
    public final boolean getIsPraised() {
        return this.isPraised;
    }

    /* renamed from: isShowingRecommendAd, reason: from getter */
    public final boolean getIsShowingRecommendAd() {
        return this.isShowingRecommendAd;
    }

    public final void setAdInfo(qq_ad_get.QQAdGetRsp.AdInfo adInfo) {
        this.adInfo = adInfo;
    }

    public final void setAddGroupAdShow(boolean z16) {
        this.isAddGroupAdShow = z16;
    }

    public final void setBrandOptimizationShow(boolean z16) {
        this.isBrandOptimizationShow = z16;
    }

    public final void setC2SExposureReported(boolean z16) {
        this.isC2SExposureReported = z16;
    }

    public final void setCGIExposureReport(boolean z16) {
        this.isCGIExposureReport = z16;
    }

    public final void setCarouselCardClickedOrManuallyScrolledItemPosition(int i3) {
        this.carouselCardClickedOrManuallyScrolledItemPosition = i3;
    }

    public final void setCarouselCardFirstVisibleItemPosition(int i3) {
        this.carouselCardFirstVisibleItemPosition = i3;
    }

    public final void setCarouselCardInfoList(List<GdtAdFeedUtil.CarouselCardInfo> list) {
        this.carouselCardInfoList = list;
    }

    public final void setDanmakuAdContents(String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "<set-?>");
        this.danmakuAdContents = strArr;
    }

    public final void setDanmukuAdv(Boolean bool) {
        this.isDanmukuAdv = bool;
    }

    public final void setGdtCrossAd(boolean z16) {
        this.isGdtCrossAd = z16;
    }

    public final void setGdtCrossAdClosed(boolean z16) {
        this.isGdtCrossAdClosed = z16;
    }

    public final void setGdtVideoPlayInfoForReportAdPlay(VideoPlayInfo videoPlayInfo) {
        this.gdtVideoPlayInfoForReportAdPlay = videoPlayInfo;
    }

    public final void setGestureAdBeginTime(int i3) {
        this.GestureAdBeginTime = i3;
    }

    public final void setGestureAdEndTime(int i3) {
        this.GestureAdEndTime = i3;
    }

    public final void setGestureStageInfoList(List<GestureStageInfo> list) {
        this.gestureStageInfoList = list;
    }

    public final void setMDPAClickItemPosition(int i3) {
        this.MDPAClickItemPosition = i3;
    }

    public final void setMInnerAdShowType(int i3) {
        this.mInnerAdShowType = i3;
    }

    public final void setNeedShowRecommendAd(boolean z16) {
        this.isNeedShowRecommendAd = z16;
    }

    public final void setPraised(boolean z16) {
        this.isPraised = z16;
    }

    public final void setRecommendAdList(List<? extends GdtAd> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.recommendAdList = list;
    }

    public final void setShowingRecommendAd(boolean z16) {
        this.isShowingRecommendAd = z16;
    }

    public final void setVideoHeight(int i3) {
        this.videoHeight = i3;
    }

    public final void setVideoWidth(int i3) {
        this.videoWidth = i3;
    }

    public final void setVisitCount(int i3) {
        this.visitCount = i3;
    }
}
