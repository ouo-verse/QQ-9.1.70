package com.qzone.proxy.feedcomponent.model.gdt;

import NS_MOBILE_FEEDS.cnst.ADV_DESC;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.commoncode.module.gdt.GdtFeedUtilForQZone;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.ViewSectionType;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.proxy.feedcomponent.model.VideoUrl;
import com.qzone.proxy.feedcomponent.model.gdt.reporter.GdtCarouselCardReporterForQzone;
import com.qzone.proxy.feedcomponent.ui.c;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.gdt.tangram.ad.qzone.embedded.b;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.statistics.GdtOriginalExposureReporter;
import com.tencent.gdtad.statistics.GdtReporter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv;
import com.tencent.mobileqq.qzoneplayer.video.VideoPlayInfo;
import com.tencent.open.base.MD5Utils;
import g6.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes39.dex */
public final class GdtAdFeedUtil {
    private static final int EXPOSURE_URL_KEY_IN_COOKIE = 1;
    private static final String EXP_KEY_DEPRECATE_LEFT_TEXT = "114872";
    private static final int IMG2_KEY = 9;
    private static final int LABEL_AD_KEY = 23;
    private static final String REPORT_TYPE_EXP_KEY = "103396";
    public static final String TAG = "GdtAdFeedUtil";

    /* compiled from: P */
    /* renamed from: com.qzone.proxy.feedcomponent.model.gdt.GdtAdFeedUtil$1, reason: invalid class name */
    /* loaded from: classes39.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$qzone$proxy$feedcomponent$ViewSectionType;

        static {
            int[] iArr = new int[ViewSectionType.values().length];
            $SwitchMap$com$qzone$proxy$feedcomponent$ViewSectionType = iArr;
            try {
                iArr[ViewSectionType.CONTENT_FEED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$qzone$proxy$feedcomponent$ViewSectionType[ViewSectionType.RECOMM_ACTION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$qzone$proxy$feedcomponent$ViewSectionType[ViewSectionType.GDT_DESCRIPTION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$qzone$proxy$feedcomponent$ViewSectionType[ViewSectionType.GDT_CAROUSEL_CARD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static final class AdFloatTipsInfo {
        public int type = 0;
        public String iconUrl = "";
        public String text = "";
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static final class CarouselCardInfo {
        public String creativeElementId;
        public int videoDurationMs;
        public VideoInfo videoInfo;
        public VideoPlayInfo videoPlayInfo;
        public String imageUrl = "";
        public String videoUrl = "";
        public String clickUrl = "";
        public String weChatAppPath = "";
        public String universalLink = "";
        public String deepLink = "";
        public String viewId = "";
        public String interactiveUrl = "";
        public String desc = "";
        public String landingPageUrl = "";
    }

    public static boolean canShowCrossAd(BusinessFeedData businessFeedData, int i3) {
        return isValidAd(businessFeedData) && isCrossAd(businessFeedData) && !businessFeedData.getAdData().getIsGdtCrossAdClosed() && i3 == 1;
    }

    public static void doEffectiveExposureReport(BusinessFeedData businessFeedData, int i3, int i16) {
        if (isValidAd(businessFeedData)) {
            doAdditionalExposureReport(businessFeedData);
            if (!isExposureReportCgi(businessFeedData)) {
                b.s(businessFeedData, GdtFeedUtilForQZone.d(i3, i16), businessFeedData.getFeedCommInfo().isInstalled, null, i16 == 8);
                return;
            }
            if (businessFeedData.getOperationInfoV2() == null || businessFeedData.getOperationInfoV2().cookie == null) {
                return;
            }
            String str = businessFeedData.getOperationInfoV2().cookie.get(1);
            QZoneAdFeedData adData = businessFeedData.getAdData();
            if (TextUtils.isEmpty(str) || adData.getIsCGIExposureReport()) {
                return;
            }
            GdtReporter.doCgiReport(str + "&slot=" + i3);
            adData.setCGIExposureReport(true);
            if (adData.getIsC2SExposureReported()) {
                return;
            }
            vo.b.m(false, businessFeedData);
            adData.setC2SExposureReported(true);
        }
    }

    public static boolean doOriginalExposureReport(BusinessFeedData businessFeedData, Context context, int i3) {
        if (isValidAd(businessFeedData)) {
            return doOriginalExposureReport(new GdtAd(GdtFeedUtilForQZone.f(businessFeedData)), context, i3);
        }
        return false;
    }

    public static AdFloatTipsInfo[] getAdFloatTipsContainer(BusinessFeedData businessFeedData) {
        LinkedList linkedList = new LinkedList();
        try {
            JSONArray jSONArray = new JSONArray(getValueFromSdkPassData(businessFeedData, "floating_tips"));
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                int optInt = jSONObject.optInt("type");
                String optString = jSONObject.optString("icon_url");
                String optString2 = jSONObject.optString("text");
                AdFloatTipsInfo adFloatTipsInfo = new AdFloatTipsInfo();
                adFloatTipsInfo.iconUrl = optString;
                adFloatTipsInfo.text = optString2;
                adFloatTipsInfo.type = optInt;
                linkedList.addLast(adFloatTipsInfo);
            }
        } catch (Throwable unused) {
        }
        return (AdFloatTipsInfo[]) linkedList.toArray(new AdFloatTipsInfo[0]);
    }

    public static String getButtonText(a.b bVar) {
        return new GdtAd(GdtFeedUtilForQZone.f(bVar.f401409b)).getButtonText(a.d(bVar));
    }

    public static String getDescription(BusinessFeedData businessFeedData) {
        if (!isValidAd(businessFeedData) || businessFeedData.getCellSummaryV2() == null) {
            return null;
        }
        return businessFeedData.getCellSummaryV2().summary;
    }

    public static int getDirectionForCrossAd(BusinessFeedData businessFeedData) {
        try {
            return Integer.parseInt(getValueFromTrackInteractiveField(businessFeedData, "direction"));
        } catch (Throwable unused) {
            return Integer.MIN_VALUE;
        }
    }

    private static List<String> getDisplayCodeList(BusinessFeedData businessFeedData) {
        if (!isValidAd(businessFeedData)) {
            return null;
        }
        try {
            LinkedList linkedList = new LinkedList();
            JSONArray jSONArray = new JSONArray(businessFeedData.getValueFromCurrencyPassField("display_code_list"));
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                String optString = jSONArray.optString(i3);
                if (!TextUtils.isEmpty(optString)) {
                    linkedList.add(optString);
                }
            }
            return linkedList;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getDynamicTagIconUrl(BusinessFeedData businessFeedData) {
        if (!isValidAd(businessFeedData)) {
            return "";
        }
        try {
            JSONArray jSONArray = new JSONArray(businessFeedData.getValueFromCurrencyPassField("element_structure_content"));
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject = (JSONObject) jSONArray.get(i3);
                if (jSONObject != null && jSONObject.has("icon_url") && !TextUtils.isEmpty(jSONObject.getString("icon_url"))) {
                    return jSONObject.getString("icon_url");
                }
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    public static String getExperimentParam(BusinessFeedData businessFeedData, String str) {
        String str2 = "";
        if (isValidAd(businessFeedData)) {
            try {
                JSONArray jSONArray = new JSONArray(getValueFromSdkPassData(businessFeedData, "exp_map"));
                if (jSONArray.length() == 0) {
                    GdtLog.e(TAG, "[isHitExpByExpMap] exp_map is empty");
                } else {
                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                        JSONObject jSONObject = (JSONObject) jSONArray.get(i3);
                        if (jSONObject.has("key") && jSONObject.getString("key").equals(str)) {
                            str2 = jSONObject.getString("value");
                            break;
                        }
                    }
                }
            } catch (Throwable unused) {
                GdtLog.e(TAG, "[isHitExpByExpMap] parse exp map error");
            }
        }
        return str2;
    }

    private static String getFeedViewBackgroundColorForCrossAd(BusinessFeedData businessFeedData) {
        if (isCrossAd(businessFeedData)) {
            return getValueFromTrackInteractiveField(businessFeedData, "background_color");
        }
        return null;
    }

    public static String getImageUrlForCrossAd(BusinessFeedData businessFeedData) {
        return getValueFromTrackInteractiveField(businessFeedData, "image_url");
    }

    public static String[] getIndustryLabels(BusinessFeedData businessFeedData) {
        if (!isValidAd(businessFeedData)) {
            return null;
        }
        String[] labelsContentFromCurrencyPassFieldSafely = getLabelsContentFromCurrencyPassFieldSafely(businessFeedData);
        if (TextUtils.isEmpty(labelsContentFromCurrencyPassFieldSafely[0])) {
            labelsContentFromCurrencyPassFieldSafely = getLabelsContentFromExtendInfoSafely(businessFeedData);
        }
        if (TextUtils.isEmpty(labelsContentFromCurrencyPassFieldSafely[0])) {
            return null;
        }
        return labelsContentFromCurrencyPassFieldSafely;
    }

    public static String getInteractiveUrl(BusinessFeedData businessFeedData) {
        if (isValidAd(businessFeedData)) {
            return businessFeedData.getValueFromCurrencyPassField("interactive_url");
        }
        return null;
    }

    public static String getIpImageForCrossAd(BusinessFeedData businessFeedData) {
        if (!isValidAd(businessFeedData)) {
            return null;
        }
        if (i.H().p1()) {
            if (businessFeedData.getRecommAction() == null || businessFeedData.getRecommAction().extendInfo == null) {
                return null;
            }
            return businessFeedData.getRecommAction().extendInfo.get(9);
        }
        return businessFeedData.getValueFromCurrencyPassField("img3");
    }

    private static String[] getLabelsContentFromCurrencyPassFieldSafely(BusinessFeedData businessFeedData) {
        String[] strArr = new String[3];
        try {
            JSONArray jSONArray = new JSONArray(businessFeedData.getValueFromCurrencyPassField("element_structure_content"));
            int i3 = 0;
            for (int i16 = 0; i16 < jSONArray.length(); i16++) {
                JSONObject jSONObject = (JSONObject) jSONArray.get(i16);
                if (jSONObject != null && jSONObject.has("content") && !TextUtils.isEmpty(jSONObject.getString("content"))) {
                    int i17 = i3 + 1;
                    strArr[i3] = jSONObject.getString("content");
                    i3 = i17;
                }
            }
        } catch (Throwable unused) {
        }
        return strArr;
    }

    private static String[] getLabelsContentFromExtendInfoSafely(BusinessFeedData businessFeedData) {
        Map<Integer, String> map;
        String[] strArr = new String[3];
        try {
            map = businessFeedData.getRecommAction().extendInfo;
        } catch (Throwable unused) {
        }
        if (map.isEmpty()) {
            return strArr;
        }
        JSONArray jSONArray = new JSONObject(map.get(23)).getJSONArray("label");
        int i3 = 0;
        for (int i16 = 0; i16 < jSONArray.length(); i16++) {
            JSONObject jSONObject = (JSONObject) jSONArray.get(i16);
            if (jSONObject.has("content") && !TextUtils.isEmpty(jSONObject.getString("content"))) {
                int i17 = i3 + 1;
                strArr[i3] = jSONObject.getString("content");
                i3 = i17;
            }
        }
        return strArr;
    }

    public static Drawable getMaskImageDrawable(BusinessFeedData businessFeedData) {
        if (!isValidAd(businessFeedData)) {
            return null;
        }
        if (isCrossAd(businessFeedData)) {
            if (i.H().p1()) {
                return new ColorDrawable(2105894);
            }
            try {
                return new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[]{Color.parseColor(getFeedViewBackgroundColorForCrossAd(businessFeedData)), 4095});
            } catch (Throwable unused) {
                return null;
            }
        }
        String valueFromCurrencyPassField = businessFeedData.getValueFromCurrencyPassField("mask_image_url");
        if (TextUtils.isEmpty(valueFromCurrencyPassField)) {
            return null;
        }
        return ImageLoader.getInstance(FeedGlobalEnv.getContext()).loadImage(PictureUrl.calculateImageUrl(valueFromCurrencyPassField), null, null, null);
    }

    public static float getRatioOfImageHeightAndWidthForCrossAd(BusinessFeedData businessFeedData) {
        try {
            return Integer.parseInt(getValueFromTrackInteractiveField(businessFeedData, "image_height")) / 1280.0f;
        } catch (Throwable unused) {
            return 0.0f;
        }
    }

    public static int getShowButtonDelay(BusinessFeedData businessFeedData) {
        if (!isValidAd(businessFeedData)) {
            return 0;
        }
        String valueFromSdkPassData = getValueFromSdkPassData(businessFeedData, "button_delay_time");
        if (TextUtils.isEmpty(valueFromSdkPassData)) {
            return 0;
        }
        try {
            return Integer.parseInt(valueFromSdkPassData);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public static String getSubtitle(BusinessFeedData businessFeedData) {
        if (!isValidAd(businessFeedData) || businessFeedData.getCellSummaryV2() == null || businessFeedData.getCellSummaryV2().mapExt == null) {
            return null;
        }
        return businessFeedData.getCellSummaryV2().mapExt.get(ADV_DESC.value);
    }

    public static String getValueFromSdkPassData(BusinessFeedData businessFeedData, String str) {
        if (!isValidAd(businessFeedData)) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject(businessFeedData.getValueFromCurrencyPassField("sdk_pass_data"));
            if (jSONObject.has(str)) {
                return jSONObject.optString(str);
            }
        } catch (Throwable unused) {
            GdtLog.e(TAG, "[getValueFromSdkPassData] error");
        }
        return "";
    }

    private static String getValueFromTrackInteractiveField(BusinessFeedData businessFeedData, String str) {
        try {
            return new JSONObject(businessFeedData.getValueFromCurrencyPassField("track_interactive")).optString(str);
        } catch (Throwable unused) {
            GdtLog.e(TAG, "[getValueFromTrackInteractiveField] error");
            return "";
        }
    }

    public static String getViewId(BusinessFeedData businessFeedData) {
        if (isValidAd(businessFeedData)) {
            return businessFeedData.getValueFromCurrencyPassField("view_id");
        }
        return null;
    }

    public static boolean isCarouselCard(BusinessFeedData businessFeedData) {
        List<CarouselCardInfo> carouselCardInfoList;
        return (!isValidAd(businessFeedData) || (carouselCardInfoList = businessFeedData.getAdData().getCarouselCardInfoList()) == null || carouselCardInfoList.isEmpty()) ? false : true;
    }

    public static boolean isCrossAd(BusinessFeedData businessFeedData) {
        return isValidAd(businessFeedData) && businessFeedData.getAdData().getIsGdtCrossAd();
    }

    private static boolean isDisplayCodeInList(BusinessFeedData businessFeedData, String str) {
        List<String> displayCodeList;
        if (TextUtils.isEmpty(str) || (displayCodeList = getDisplayCodeList(businessFeedData)) == null) {
            return false;
        }
        Iterator<String> it = displayCodeList.iterator();
        while (it.hasNext()) {
            if (str.equals(it.next())) {
                return true;
            }
        }
        return false;
    }

    private static boolean isExposureReportCgi(BusinessFeedData businessFeedData) {
        return isHitExpByExpMap(businessFeedData, REPORT_TYPE_EXP_KEY, "1");
    }

    public static boolean isHitExpByExpMap(BusinessFeedData businessFeedData, String str, String str2) {
        return getExperimentParam(businessFeedData, str).equals(str2);
    }

    public static boolean isSectionVisible(BusinessFeedData businessFeedData, ViewSectionType viewSectionType) {
        int i3 = AnonymousClass1.$SwitchMap$com$qzone$proxy$feedcomponent$ViewSectionType[viewSectionType.ordinal()];
        if (i3 == 1) {
            return !isCarouselCard(businessFeedData);
        }
        if (i3 == 2) {
            return (isCarouselCard(businessFeedData) || isCrossAd(businessFeedData)) ? false : true;
        }
        if (i3 == 3) {
            return isCarouselCard(businessFeedData) || isCrossAd(businessFeedData);
        }
        if (i3 != 4) {
            return true;
        }
        return isCarouselCard(businessFeedData);
    }

    public static boolean isVerticalVideo(BusinessFeedData businessFeedData) {
        return isValidAd(businessFeedData) && QZoneAdFeedDataExtKt.getGdtInnerAdShowType(businessFeedData) == 4;
    }

    public static void parseCarouselCardInfo(BusinessFeedData businessFeedData, GdtAd gdtAd) {
        if (isValidAd(businessFeedData)) {
            try {
                JSONArray jSONArray = new JSONArray(getValueFromSdkPassData(businessFeedData, "carousel_ad_items"));
                LinkedList linkedList = new LinkedList();
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i3);
                    if (jSONObject != null && !JSONObject.NULL.equals(jSONObject)) {
                        CarouselCardInfo carouselCardInfo = new CarouselCardInfo();
                        carouselCardInfo.imageUrl = jSONObject.optString("image_url");
                        carouselCardInfo.videoUrl = jSONObject.optString("video_url");
                        carouselCardInfo.clickUrl = jSONObject.optString("click_url");
                        carouselCardInfo.weChatAppPath = jSONObject.optString("wechat_app_path");
                        carouselCardInfo.universalLink = jSONObject.optString("universal_link");
                        carouselCardInfo.deepLink = jSONObject.optString("deep_link");
                        carouselCardInfo.viewId = jSONObject.optString("view_id");
                        carouselCardInfo.interactiveUrl = jSONObject.optString("interactive_url");
                        carouselCardInfo.creativeElementId = jSONObject.optString("creative_element_id");
                        carouselCardInfo.videoDurationMs = jSONObject.optInt("video_duration") * 1000;
                        carouselCardInfo.desc = jSONObject.optString("desc");
                        carouselCardInfo.landingPageUrl = jSONObject.optString("landingpage_url");
                        carouselCardInfo.videoInfo = preCalculateVideoInfo(businessFeedData, gdtAd, carouselCardInfo.imageUrl, carouselCardInfo.videoUrl, carouselCardInfo.videoDurationMs);
                        linkedList.add(carouselCardInfo);
                    }
                }
                businessFeedData.getAdData().setCarouselCardInfoList(linkedList);
            } catch (Throwable unused) {
                GdtLog.e(TAG, "[parseCarouselCardInfo] parseError");
            }
        }
    }

    private static VideoInfo preCalculateVideoInfo(BusinessFeedData businessFeedData, GdtAd gdtAd, String str, String str2, int i3) {
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.width = gdtAd != null ? gdtAd.getVideoWidth() : 0;
        videoInfo.height = gdtAd != null ? gdtAd.getVideoHeight() : 0;
        videoInfo.videoTime = i3;
        VideoUrl videoUrl = new VideoUrl();
        videoInfo.videoUrl = videoUrl;
        videoUrl.url = str2;
        PictureUrl pictureUrl = new PictureUrl();
        videoInfo.coverUrl = pictureUrl;
        pictureUrl.url = str;
        return videoInfo;
    }

    private static VideoPlayInfo preCalculateVideoPlayInfo(BusinessFeedData businessFeedData, String str, int i3) {
        if (!isValidAd(businessFeedData) || TextUtils.isEmpty(str)) {
            return null;
        }
        VideoPlayInfo videoPlayInfo = new VideoPlayInfo();
        long j3 = i3;
        videoPlayInfo.videoTime = j3;
        videoPlayInfo.cookie = businessFeedData.getOperationInfoV2() != null ? businessFeedData.getOperationInfoV2().cookie : null;
        videoPlayInfo.m(str, false);
        videoPlayInfo.videoId = MD5Utils.toMD5(str);
        videoPlayInfo.isGdtAd = true;
        videoPlayInfo.isAdFeeds = true;
        videoPlayInfo.isVideoAdv = true;
        videoPlayInfo.isAutoPlay = true;
        videoPlayInfo.showVideoTime = FeedVideoEnv.getShownTimeFromNumeric(j3);
        videoPlayInfo.videoPlayScene = c.f(businessFeedData.feedType);
        return videoPlayInfo;
    }

    public static boolean shouldTryPlayGdtCarouselCardVideo(BusinessFeedData businessFeedData) {
        return isValidAd(businessFeedData) && i.H().m() && isCarouselCard(businessFeedData);
    }

    public static boolean isPanoramaAd(BusinessFeedData businessFeedData) {
        return (businessFeedData == null || businessFeedData.getPictureInfo() == null || businessFeedData.getPictureInfo().actiontype != 62) ? false : true;
    }

    private static boolean isValidAd(BusinessFeedData businessFeedData) {
        return businessFeedData != null && businessFeedData.isGDTAdvFeed();
    }

    private static void doAdditionalExposureReport(BusinessFeedData businessFeedData) {
        if (businessFeedData != null && isCarouselCard(businessFeedData)) {
            GdtCarouselCardReporterForQzone.reportForActionType(businessFeedData, businessFeedData.getAdData().getCarouselCardClickedOrManuallyScrolledItemPosition(), "1");
        }
    }

    public static boolean doOriginalExposureReport(GdtAd gdtAd, Context context, int i3) {
        qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo reportInfo;
        PBStringField pBStringField;
        qq_ad_get.QQAdGetRsp.AdInfo adInfo = gdtAd.info;
        if (adInfo == null || (reportInfo = adInfo.report_info) == null || (pBStringField = reportInfo.original_exposure_url) == null) {
            return false;
        }
        String str = pBStringField.get();
        if (TextUtils.isEmpty(str)) {
            GdtLog.e(TAG, "[doOriginalExposureReport] original report url is empty");
            return false;
        }
        if (i3 >= 0) {
            gdtAd.info.report_info.original_exposure_url.set(str + "&slot=" + i3);
            GdtLog.i(TAG, "[doOriginalExposureReport] position >= 0, so here is feed");
        }
        GdtOriginalExposureReporter.reportOriginalExposure(gdtAd, context);
        return true;
    }

    public static CarouselCardInfo getCarouselCardInfoForPosition(BusinessFeedData businessFeedData, int i3) {
        List<CarouselCardInfo> carouselCardInfoList;
        if (businessFeedData == null || (carouselCardInfoList = businessFeedData.getAdData().getCarouselCardInfoList()) == null || carouselCardInfoList.isEmpty() || i3 < 0) {
            return null;
        }
        return carouselCardInfoList.get(i3 % carouselCardInfoList.size());
    }
}
