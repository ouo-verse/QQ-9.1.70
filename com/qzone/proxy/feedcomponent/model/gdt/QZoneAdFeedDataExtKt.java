package com.qzone.proxy.feedcomponent.model.gdt;

import android.graphics.Color;
import android.text.TextUtils;
import com.qzone.commoncode.module.gdt.GdtFeedUtilForQZone;
import com.qzone.proxy.feedcomponent.b;
import com.qzone.proxy.feedcomponent.manager.a;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.model.CellOperationInfo;
import com.qzone.proxy.feedcomponent.model.CellPictureInfo;
import com.qzone.proxy.feedcomponent.model.CellRecommAction;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdFeedData;
import com.tencent.mobileqq.mini.share.MiniProgramOpenSdkUtil;
import com.tencent.mobileqq.qzoneplayer.video.VideoPlayInfo;
import com.tencent.mobileqq.vas.adv.common.pb.vac_adv_get;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc05502;
import cooperation.vip.pb.TianShuAccess;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b'\n\u0002\u0010\u0002\n\u0002\b\n\u001a\f\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u001a\f\u0010\u0003\u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u001a\u000e\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u0004\u0018\u00010\u0002\u001a\f\u0010\u0006\u001a\u00020\u0007*\u0004\u0018\u00010\u0002\u001a\f\u0010\b\u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u001a\f\u0010\t\u001a\u00020\u0007*\u0004\u0018\u00010\u0002\u001a\f\u0010\n\u001a\u00020\u0007*\u0004\u0018\u00010\u0002\u001a\f\u0010\u000b\u001a\u00020\u0007*\u0004\u0018\u00010\u0002\u001a\f\u0010\f\u001a\u00020\u0007*\u0004\u0018\u00010\u0002\u001a\f\u0010\r\u001a\u00020\u0007*\u0004\u0018\u00010\u0002\u001a\f\u0010\u000e\u001a\u00020\u0007*\u0004\u0018\u00010\u0002\u001a\f\u0010\u000f\u001a\u00020\u0007*\u0004\u0018\u00010\u0002\u001a\u0014\u0010\u0010\u001a\u00020\u0007*\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\u0001\u001a\u0014\u0010\u0012\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\u0007\u001a\f\u0010\u0013\u001a\u00020\u0007*\u0004\u0018\u00010\u0002\u001a\f\u0010\u0014\u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u001a\f\u0010\u0015\u001a\u00020\u0016*\u0004\u0018\u00010\u0002\u001a\f\u0010\u0017\u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u001a\u0016\u0010\u0018\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0019*\u0004\u0018\u00010\u0002\u001a\f\u0010\u001a\u001a\u00020\u0007*\u0004\u0018\u00010\u0002\u001a\f\u0010\u001b\u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u001a\f\u0010\u001c\u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u001a\f\u0010\u001d\u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u001a\u0014\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u0019*\u0004\u0018\u00010\u0002\u001a\f\u0010 \u001a\u00020\u0007*\u0004\u0018\u00010\u0002\u001a \u0010!\u001a\u00020\u0001*\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\"2\u0006\u0010\u0011\u001a\u00020\u0007\u001a\u001c\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u00070$j\b\u0012\u0004\u0012\u00020\u0007`%*\u0004\u0018\u00010\u0002\u001a\u001c\u0010&\u001a\u0012\u0012\u0004\u0012\u00020\u00070$j\b\u0012\u0004\u0012\u00020\u0007`%*\u0004\u0018\u00010\u0002\u001a\u0012\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u0019*\u0004\u0018\u00010\u0002\u001a\f\u0010)\u001a\u00020\u0007*\u0004\u0018\u00010\u0002\u001a\f\u0010*\u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u001a\f\u0010+\u001a\u00020\u0007*\u0004\u0018\u00010\u0002\u001a\f\u0010,\u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u001a\u000e\u0010-\u001a\u0004\u0018\u00010.*\u0004\u0018\u00010\u0002\u001a\u000e\u0010/\u001a\u0004\u0018\u000100*\u0004\u0018\u00010\u0002\u001a\f\u00101\u001a\u00020\u0007*\u0004\u0018\u00010\u0002\u001a \u00102\u001a\u00020\u0007*\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\"2\u0006\u0010\u0011\u001a\u00020\u0007\u001a\u000e\u00103\u001a\u0004\u0018\u000104*\u0004\u0018\u00010\u0002\u001a\f\u00105\u001a\u000206*\u0004\u0018\u00010\u0002\u001a\f\u00107\u001a\u000206*\u0004\u0018\u00010\u0002\u001a\f\u00108\u001a\u000206*\u0004\u0018\u00010\u0002\u001a\f\u00109\u001a\u000206*\u0004\u0018\u00010\u0002\u001a\f\u0010:\u001a\u000206*\u0004\u0018\u00010\u0002\u001a\f\u0010;\u001a\u000206*\u0004\u0018\u00010\u0002\u001a\f\u0010<\u001a\u000206*\u0004\u0018\u00010\u0002\u001a\f\u0010=\u001a\u000206*\u0004\u0018\u00010\u0002\u001a\f\u0010>\u001a\u000206*\u0004\u0018\u00010\u0002\u001a\f\u0010?\u001a\u000206*\u0004\u0018\u00010\u0002\u001a\f\u0010@\u001a\u000206*\u0004\u0018\u00010\u0002\u001a\f\u0010A\u001a\u000206*\u0004\u0018\u00010\u0002\u001a\f\u0010B\u001a\u000206*\u0004\u0018\u00010\u0002\u001a\f\u0010C\u001a\u000206*\u0004\u0018\u00010\u0002\u001a\f\u0010D\u001a\u000206*\u0004\u0018\u00010\u0002\u001a\f\u0010E\u001a\u000206*\u0004\u0018\u00010\u0002\u001a\f\u0010F\u001a\u000206*\u0004\u0018\u00010\u0002\u001a\f\u0010G\u001a\u000206*\u0004\u0018\u00010\u0002\u001a\f\u0010H\u001a\u000206*\u0004\u0018\u00010\u0002\u001a\f\u0010I\u001a\u000206*\u0004\u0018\u00010\u0002\u001a\f\u0010J\u001a\u000206*\u0004\u0018\u00010\u0002\u001a\f\u0010K\u001a\u000206*\u0004\u0018\u00010\u0002\u001a\f\u0010L\u001a\u000206*\u0004\u0018\u00010\u0002\u001a\f\u0010M\u001a\u000206*\u0004\u0018\u00010\u0002\u001a\f\u0010N\u001a\u000206*\u0004\u0018\u00010\u0002\u001a\f\u0010O\u001a\u000206*\u0004\u0018\u00010\u0002\u001a\f\u0010P\u001a\u000206*\u0004\u0018\u00010\u0002\u001a\f\u0010Q\u001a\u000206*\u0004\u0018\u00010\u0002\u001a\f\u0010R\u001a\u000206*\u0004\u0018\u00010\u0002\u001a\f\u0010S\u001a\u000206*\u0004\u0018\u00010\u0002\u001a\f\u0010T\u001a\u000206*\u0004\u0018\u00010\u0002\u001a\f\u0010U\u001a\u000206*\u0004\u0018\u00010\u0002\u001a\f\u0010V\u001a\u000206*\u0004\u0018\u00010\u0002\u001a\f\u0010W\u001a\u000206*\u0004\u0018\u00010\u0002\u001a\f\u0010X\u001a\u000206*\u0004\u0018\u00010\u0002\u001a\f\u0010Y\u001a\u000206*\u0004\u0018\u00010\u0002\u001a\f\u0010Z\u001a\u000206*\u0004\u0018\u00010\u0002\u001a\f\u0010[\u001a\u000206*\u0004\u0018\u00010\u0002\u001a\f\u0010\\\u001a\u000206*\u0004\u0018\u00010\u0002\u001a\f\u0010]\u001a\u00020^*\u0004\u0018\u00010\u0002\u001a\f\u0010_\u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u001a\f\u0010`\u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u001a\u0014\u0010a\u001a\u00020^*\u0004\u0018\u00010\u00022\u0006\u0010b\u001a\u000206\u001a\u0014\u0010c\u001a\u00020^*\u0004\u0018\u00010\u00022\u0006\u0010d\u001a\u000204\u001a\f\u0010e\u001a\u00020\u0007*\u0004\u0018\u00010\u0002\u001a\f\u0010f\u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u001a\f\u0010g\u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u00a8\u0006h"}, d2 = {"getAdFirstCategory", "", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "getAdOuterLayerDownloadValue", "getAdPicture", "Lcom/qzone/proxy/feedcomponent/model/PictureUrl;", "getAdPictureUrl", "", "getAdSecondCategory", "getAdvId", "getAid", "getC2SApiClickUrl", "getC2SApiExposureUrl", "getC2SVideoPlayDuration", "getC2SVideoPlayUrl", "getDynamicBgUrl", "getFeedDataExtendInfoValue", "key", "getFeedDataIntValueCurrencyPassField", "getGDTMiniProgramType", "getGdtAdvAnimationBarColor", "getGdtAdvAnimationBarLoc", "", "getGdtAdvAnimationBarTime", "getGdtAdvThirdPlatformPlayerReportURL", "", "getGdtEffectCGIUrl", "getGdtInnerAdShowType", "getGdtVideoHeight", "getGdtVideoWidth", "getGestureStageInfo", "Lcom/qzone/proxy/feedcomponent/model/gdt/QZoneAdFeedData$GestureStageInfo;", "getImaxAdVideoUrl", "getIntValue", "", "getLabelsContentFromCurrencyPassFieldSafely", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getLabelsContentFromExtendInfoSafely", "getMDPAInfos", "Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$BasicInfo$MaterialInfo;", "getPictureOriginalUrl", "getPostype", "getRewardLandingPageUrl", "getShakeAdVisiblePercent", "getTianshuData", "Lcom/qzone/proxy/feedcomponent/model/gdt/QZoneAdTianshuFeedData;", "getTianshuMsg", "Lcom/tencent/mobileqq/vas/adv/common/pb/vac_adv_get$TianShuMsg;", "getTraceId", HippyTextInputController.COMMAND_getValue, "getVideoPlayInfoForReportAdPlay", "Lcom/tencent/mobileqq/qzoneplayer/video/VideoPlayInfo;", "hasGdtAdvAnimationBarColor", "", "isAdFeedVideoNeedAutoPlay", "isAdLandingPageVideoNeedAutoPlay", "isAdLittleIconStyle", "isAdTopInDetail", "isAddGroupAdv", "isAdvContainerSixGridStyle", "isAppAd", "isBrandOptimizationAdv", "isButtonAnimationStyleAdv", "isDanmakuAdv", "isDeepLink", "isGDTAdvFeed", "isGDTForwardFeed", "isGdt185AdVideo", "isGdt585ABTest", "isGdt585AdVideo", "isGdt585LiveAd", "isGdtAdvAnimationBarStyle", "isGestureAd", "isHitAdOuterLayerDownload", "isHitLeftTextAndLabelExp", "isLocalAd", "isLogoNickAdStyle", "isMDPAFeedData", "isMDPAStyleA", "isMDPAStyleB", "isMiniAppGdtAdv", "isNativeAd", "isNativeAdStyleA", "isNativeAdStyleB", "isNeedRequestRecommendAd", "isNeedShowRecommendAd", "isNotGdtAdvFeed", "isRewardAd", "isRewardAdRealTimeRequest", "isShowingRecommendAd", "isTianshuAd", "isTouchFlipAdv", "parseGestureStageInfo", "", "recommendAdRequestDelay", "recommendAdStayTime", "setIsGdtVideoClickedForPlayReport", "isClicked", "setVideoPlayInfoForReportAdPlay", "videoPlayInfo", "shakeAdNewStyle", "shakeAdScreenBottomPercent", "shakeAdScreenShowTime", "qzone_df_impl_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes39.dex */
public final class QZoneAdFeedDataExtKt {
    public static final int getAdOuterLayerDownloadValue(BusinessFeedData businessFeedData) {
        return getFeedDataIntValueCurrencyPassField(businessFeedData, "outer_layer_download");
    }

    public static final String getAdPictureUrl(BusinessFeedData businessFeedData) {
        PictureUrl adPicture = getAdPicture(businessFeedData);
        String str = adPicture != null ? adPicture.url : null;
        return str == null ? "" : str;
    }

    public static final int getFeedDataIntValueCurrencyPassField(BusinessFeedData businessFeedData, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (businessFeedData == null) {
            return Integer.MIN_VALUE;
        }
        try {
            String valueFromCurrencyPassField = businessFeedData.getValueFromCurrencyPassField(key);
            Intrinsics.checkNotNullExpressionValue(valueFromCurrencyPassField, "this.getValueFromCurrencyPassField(key)");
            return Integer.parseInt(valueFromCurrencyPassField);
        } catch (NumberFormatException unused) {
            return Integer.MIN_VALUE;
        }
    }

    public static final int getIntValue(Map<String, String> map, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (map == null) {
            return 0;
        }
        try {
            String str = map.get(key);
            if (str != null) {
                return Integer.parseInt(str);
            }
            return 0;
        } catch (Exception e16) {
            QLog.e(QZoneAdFeedData.INSTANCE.getTAG(), 1, "[getIntValue] error, e:" + e16);
            return 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0022 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0023 A[Catch: Exception -> 0x0054, TryCatch #0 {Exception -> 0x0054, blocks: (B:7:0x000c, B:9:0x0016, B:15:0x0023, B:17:0x002e, B:19:0x0040, B:21:0x004a), top: B:6:0x000c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final ArrayList<String> getLabelsContentFromCurrencyPassFieldSafely(BusinessFeedData businessFeedData) {
        String valueFromCurrencyPassField;
        int i3;
        boolean z16;
        ArrayList<String> arrayList = new ArrayList<>();
        if (businessFeedData == null) {
            return arrayList;
        }
        try {
            valueFromCurrencyPassField = businessFeedData.getValueFromCurrencyPassField("element_structure_content");
        } catch (Exception e16) {
            QLog.e(QZoneAdFeedData.INSTANCE.getTAG(), 1, "getLabelsContentFromCurrencyPassFieldSafely", e16);
        }
        if (valueFromCurrencyPassField != null && valueFromCurrencyPassField.length() != 0) {
            z16 = false;
            if (!z16) {
                return arrayList;
            }
            JSONArray jSONArray = new JSONArray(valueFromCurrencyPassField);
            int length = jSONArray.length();
            for (i3 = 0; i3 < length; i3++) {
                Object obj = jSONArray.get(i3);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONObject");
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject.has("content") && !TextUtils.isEmpty(jSONObject.optString("content"))) {
                    arrayList.add(jSONObject.optString("content"));
                }
            }
            return arrayList;
        }
        z16 = true;
        if (!z16) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003a A[Catch: Exception -> 0x007d, TryCatch #0 {Exception -> 0x007d, blocks: (B:7:0x000c, B:9:0x0012, B:11:0x0018, B:13:0x001e, B:15:0x002d, B:21:0x003a, B:23:0x0056, B:25:0x0068, B:27:0x0072), top: B:6:0x000c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final ArrayList<String> getLabelsContentFromExtendInfoSafely(BusinessFeedData businessFeedData) {
        Map<Integer, String> map;
        boolean z16;
        ArrayList<String> arrayList = new ArrayList<>();
        if (businessFeedData == null) {
            return arrayList;
        }
        try {
            CellRecommAction recommAction = businessFeedData.getRecommAction();
            map = recommAction != null ? recommAction.extendInfo : null;
        } catch (Exception e16) {
            QLog.e(QZoneAdFeedData.INSTANCE.getTAG(), 1, "getLabelsContentFromExtendInfoSafely", e16);
        }
        if (map != null && !map.isEmpty()) {
            String str = map.get(23);
            if (str != null && str.length() != 0) {
                z16 = false;
                if (z16) {
                    JSONArray jSONArray = new JSONObject(map.get(23)).getJSONArray("label");
                    int length = jSONArray.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        Object obj = jSONArray.get(i3);
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONObject");
                        JSONObject jSONObject = (JSONObject) obj;
                        if (jSONObject.has("content") && !TextUtils.isEmpty(jSONObject.optString("content"))) {
                            arrayList.add(jSONObject.optString("content"));
                        }
                    }
                    return arrayList;
                }
            }
            z16 = true;
            if (z16) {
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0032 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0033 A[Catch: JSONException -> 0x00bc, TryCatch #0 {JSONException -> 0x00bc, blocks: (B:9:0x001c, B:11:0x0026, B:18:0x0033, B:20:0x003e, B:25:0x0045), top: B:8:0x001c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final List<qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo.MaterialInfo> getMDPAInfos(BusinessFeedData businessFeedData) {
        boolean z16;
        ArrayList arrayList = new ArrayList();
        if ((businessFeedData != null ? businessFeedData.getRecommAction() : null) != null && !TextUtils.isEmpty(businessFeedData.getRecommAction().currency_pass_field)) {
            try {
                String j3 = GdtFeedUtilForQZone.j(businessFeedData, "materials");
                if (j3 != null && j3.length() != 0) {
                    z16 = false;
                    if (!z16) {
                        return arrayList;
                    }
                    JSONArray jSONArray = new JSONArray(j3);
                    int length = jSONArray.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                        if (optJSONObject != null) {
                            qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo.MaterialInfo materialInfo = new qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo.MaterialInfo();
                            materialInfo.image_url.set(optJSONObject.optString("image_url"));
                            materialInfo.template_image_url.set(optJSONObject.optString("template_image_url"));
                            materialInfo.title.set(optJSONObject.optString("title"));
                            materialInfo.price.set(optJSONObject.optString("price"));
                            materialInfo.original_price.set(optJSONObject.optString("original_price"));
                            materialInfo.click_url.set(optJSONObject.optString("click_url"));
                            materialInfo.schema_url.set(optJSONObject.optString(QZoneAdTianshuFeedData.KEY_SCHEMA_URL));
                            materialInfo.wx_mini_program_path.set(optJSONObject.optString("wx_mini_program_path"));
                            materialInfo.universal_link.set(optJSONObject.optString("universal_link"));
                            arrayList.add(materialInfo);
                        }
                    }
                }
                z16 = true;
                if (!z16) {
                }
            } catch (JSONException e16) {
                QLog.e(QZoneAdFeedData.INSTANCE.getTAG(), 1, "getMDPAInfos exception :" + e16);
            }
        }
        return arrayList;
    }

    public static final QZoneAdTianshuFeedData getTianshuData(BusinessFeedData businessFeedData) {
        vac_adv_get.NonstandardAdInfo nonstandardAdInfo;
        TianShuAccess.AdItem adItem;
        QZoneAdTianshuFeedData qZoneAdTianshuFeedData = new QZoneAdTianshuFeedData();
        if (businessFeedData == null) {
            return null;
        }
        vac_adv_get.TianShuMsg tianshuMsg = getTianshuMsg(businessFeedData);
        if (((tianshuMsg == null || (nonstandardAdInfo = tianshuMsg.adv) == null || (adItem = nonstandardAdInfo.ad_item) == null) ? null : adItem.argList) == null) {
            return null;
        }
        vac_adv_get.NonstandardAdInfo nonstandardAdInfo2 = tianshuMsg.adv;
        TianShuAccess.AdItem adItem2 = nonstandardAdInfo2 != null ? nonstandardAdInfo2.ad_item : null;
        if (adItem2 == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (TianShuAccess.MapEntry mapEntry : adItem2.argList.get()) {
            String str = mapEntry.key.get();
            Intrinsics.checkNotNullExpressionValue(str, "mapEntry.key.get()");
            String str2 = mapEntry.value.get();
            Intrinsics.checkNotNullExpressionValue(str2, "mapEntry.value.get()");
            hashMap.put(str, str2);
        }
        qZoneAdTianshuFeedData.setAid(String.valueOf(adItem2.iAdId.get()));
        String str3 = tianshuMsg.trace_id.get();
        Intrinsics.checkNotNullExpressionValue(str3, "tianshuMsg.trace_id.get()");
        qZoneAdTianshuFeedData.setTraceId(str3);
        qZoneAdTianshuFeedData.setAdPosType(tianshuMsg.ad_pos_type.get());
        qZoneAdTianshuFeedData.setIconUrl(getValue(hashMap, QZoneAdTianshuFeedData.KEY_ICON));
        qZoneAdTianshuFeedData.setTitle(getValue(hashMap, QZoneAdTianshuFeedData.KEY_TITLE));
        qZoneAdTianshuFeedData.setDesc(getValue(hashMap, "subtitle"));
        qZoneAdTianshuFeedData.setBtnText(getValue(hashMap, QZoneAdTianshuFeedData.KEY_BUTTON_TEXT));
        qZoneAdTianshuFeedData.setAdSourceUrl(getValue(hashMap, QZoneAdTianshuFeedData.KEY_SOURCE_URL));
        qZoneAdTianshuFeedData.setAdType(getValue(hashMap, QZoneAdTianshuFeedData.KEY_AD_TYPE));
        qZoneAdTianshuFeedData.setJumpType(getValue(hashMap, "jump_type"));
        qZoneAdTianshuFeedData.setVideoCoverUrl(getValue(hashMap, QZoneAdTianshuFeedData.KEY_VIDEO_COVER_URL));
        qZoneAdTianshuFeedData.setH5Url(getValue(hashMap, "jump_url"));
        qZoneAdTianshuFeedData.setSchemaUrl(getValue(hashMap, QZoneAdTianshuFeedData.KEY_SCHEMA_URL));
        qZoneAdTianshuFeedData.setWxUserName(getValue(hashMap, QZoneAdTianshuFeedData.KEY_WX_USERNAME));
        qZoneAdTianshuFeedData.setWxPath(getValue(hashMap, QZoneAdTianshuFeedData.KEY_WX_PATH));
        String str4 = tianshuMsg.adv.report_attachment.get();
        if (str4 == null) {
            str4 = "";
        }
        qZoneAdTianshuFeedData.setReportAttachment(str4);
        qZoneAdTianshuFeedData.setWidth(getIntValue(hashMap, QZoneAdTianshuFeedData.KEY_WIDTH));
        qZoneAdTianshuFeedData.setHeight(getIntValue(hashMap, QZoneAdTianshuFeedData.KEY_HEIGHT));
        return qZoneAdTianshuFeedData;
    }

    public static final String getValue(Map<String, String> map, String key) {
        String str;
        Intrinsics.checkNotNullParameter(key, "key");
        return (map == null || (str = map.get(key)) == null) ? "" : str;
    }

    public static final boolean isHitAdOuterLayerDownload(BusinessFeedData businessFeedData) {
        return getAdOuterLayerDownloadValue(businessFeedData) == 1;
    }

    public static final boolean isHitLeftTextAndLabelExp(BusinessFeedData businessFeedData) {
        return GdtAdFeedUtil.isHitExpByExpMap(businessFeedData, QZoneAdFeedData.EXP_LEFT_TEXT_AND_LABEL_KEY, "1");
    }

    public static final boolean isLogoNickAdStyle(BusinessFeedData businessFeedData) {
        if ((businessFeedData != null ? businessFeedData.getRecommAction() : null) != null && !TextUtils.isEmpty(businessFeedData.getRecommAction().currency_pass_field)) {
            try {
                JSONObject jSONObject = new JSONObject(businessFeedData.getRecommAction().currency_pass_field);
                String string = jSONObject.getString("sdk_pass_data");
                Intrinsics.checkNotNullExpressionValue(string, "currencyPassFieldJSON.getString(\"sdk_pass_data\")");
                String substring = string.substring(0, jSONObject.getString("sdk_pass_data").length() - 1);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                JSONArray jSONArray = new JSONObject(substring).getJSONArray("exp_map");
                if (jSONArray.length() > 0) {
                    int length = jSONArray.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        Object obj = jSONArray.get(i3);
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONObject");
                        JSONObject jSONObject2 = (JSONObject) obj;
                        if (jSONObject2.has("key") && jSONObject2.getInt("key") == 100478 && jSONObject2.has("value") && jSONObject2.getInt("value") == 2) {
                            return true;
                        }
                    }
                }
            } catch (Throwable th5) {
                b.c("friendFeedsStyle erro: ", "error info: " + th5);
            }
        }
        return false;
    }

    public static final boolean isMDPAStyleA(BusinessFeedData businessFeedData) {
        return isMDPAFeedData(businessFeedData) && GdtAdFeedUtil.isHitExpByExpMap(businessFeedData, QZoneAdFeedData.INSTANCE.getEXP_MDPA_STYLE(), "1");
    }

    public static final boolean isMDPAStyleB(BusinessFeedData businessFeedData) {
        return isMDPAFeedData(businessFeedData) && GdtAdFeedUtil.isHitExpByExpMap(businessFeedData, QZoneAdFeedData.INSTANCE.getEXP_MDPA_STYLE(), "2");
    }

    public static final boolean isNativeAd(BusinessFeedData businessFeedData) {
        return isNativeAdStyleA(businessFeedData) || isNativeAdStyleB(businessFeedData);
    }

    public static final void parseGestureStageInfo(BusinessFeedData businessFeedData) {
        if (businessFeedData != null) {
            List<QZoneAdFeedData.GestureStageInfo> gestureStageInfoList = businessFeedData.getAdData().getGestureStageInfoList();
            if (gestureStageInfoList == null || gestureStageInfoList.isEmpty()) {
                try {
                    JSONArray optJSONArray = new JSONObject(businessFeedData.getRecommAction().currency_pass_field).optJSONArray("gesture_stage_infos");
                    if (optJSONArray != null && optJSONArray.length() != 0) {
                        ArrayList arrayList = new ArrayList();
                        int length = optJSONArray.length();
                        for (int i3 = 0; i3 < length; i3++) {
                            Object obj = optJSONArray.get(i3);
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONObject");
                            JSONObject jSONObject = (JSONObject) obj;
                            QZoneAdFeedData.GestureStageInfo gestureStageInfo = new QZoneAdFeedData.GestureStageInfo();
                            gestureStageInfo.setStageType(jSONObject.optInt("type", 0));
                            gestureStageInfo.setBeginTimeS(jSONObject.optInt(QCircleLpReportDc05502.KEY_BEGIN_TIME, 0));
                            gestureStageInfo.setEndTimeS(jSONObject.optInt("end_time", 0));
                            String optString = jSONObject.optString("icon_url", "");
                            Intrinsics.checkNotNullExpressionValue(optString, "json.optString(\"icon_url\", \"\")");
                            gestureStageInfo.setIconUrl(optString);
                            String optString2 = jSONObject.optString("tips_1", "");
                            Intrinsics.checkNotNullExpressionValue(optString2, "json.optString(\"tips_1\", \"\")");
                            gestureStageInfo.setTipFirstLine(optString2);
                            String optString3 = jSONObject.optString("tips_2", "");
                            Intrinsics.checkNotNullExpressionValue(optString3, "json.optString(\"tips_2\", \"\")");
                            gestureStageInfo.setTipSecondLine(optString3);
                            arrayList.add(gestureStageInfo);
                        }
                        if (arrayList.isEmpty()) {
                            return;
                        }
                        businessFeedData.getAdData().setGestureStageInfoList(arrayList);
                        QLog.d(QZoneAdFeedData.INSTANCE.getTAG(), 2, "parseGestureStageInfo finish");
                    }
                } catch (Throwable th5) {
                    QLog.e(QZoneAdFeedData.INSTANCE.getTAG(), 1, "getGestureStageInfo error:", th5);
                }
            }
        }
    }

    public static final void setVideoPlayInfoForReportAdPlay(BusinessFeedData businessFeedData, VideoPlayInfo videoPlayInfo) {
        Intrinsics.checkNotNullParameter(videoPlayInfo, "videoPlayInfo");
        QZoneAdFeedData adData = businessFeedData != null ? businessFeedData.getAdData() : null;
        if (adData == null) {
            return;
        }
        adData.setGdtVideoPlayInfoForReportAdPlay(videoPlayInfo);
    }

    public static final int getAdFirstCategory(BusinessFeedData businessFeedData) {
        try {
            return Integer.parseInt(getFeedDataExtendInfoValue(businessFeedData, 36));
        } catch (Exception e16) {
            QLog.e(QZoneAdFeedData.INSTANCE.getTAG(), 1, "[getAdFirstCategory] error, e:" + e16);
            return 0;
        }
    }

    public static final int getAdSecondCategory(BusinessFeedData businessFeedData) {
        try {
            return Integer.parseInt(getFeedDataExtendInfoValue(businessFeedData, 37));
        } catch (Exception e16) {
            QLog.e(QZoneAdFeedData.INSTANCE.getTAG(), 1, "[getAdSecondCategory] error, e:" + e16);
            return 0;
        }
    }

    public static final String getAdvId(BusinessFeedData businessFeedData) {
        String valueFromCurrencyPassField = businessFeedData != null ? businessFeedData.getValueFromCurrencyPassField("advertiser_id") : null;
        return valueFromCurrencyPassField == null ? "" : valueFromCurrencyPassField;
    }

    public static final String getAid(BusinessFeedData businessFeedData) {
        CellOperationInfo operationInfoV2;
        Map<Integer, String> map;
        String str;
        return (businessFeedData == null || (operationInfoV2 = businessFeedData.getOperationInfoV2()) == null || (map = operationInfoV2.cookie) == null || (str = map.get(7)) == null) ? "" : str;
    }

    public static final String getC2SApiClickUrl(BusinessFeedData businessFeedData) {
        String valueFromCurrencyPassField = businessFeedData != null ? businessFeedData.getValueFromCurrencyPassField("api_click_monitor_url") : null;
        return valueFromCurrencyPassField == null ? "" : valueFromCurrencyPassField;
    }

    public static final String getC2SApiExposureUrl(BusinessFeedData businessFeedData) {
        String valueFromCurrencyPassField = businessFeedData != null ? businessFeedData.getValueFromCurrencyPassField("api_exposure_monitor_url") : null;
        return valueFromCurrencyPassField == null ? "" : valueFromCurrencyPassField;
    }

    public static final String getC2SVideoPlayDuration(BusinessFeedData businessFeedData) {
        String valueFromCurrencyPassField = businessFeedData != null ? businessFeedData.getValueFromCurrencyPassField("video_play_duration") : null;
        return valueFromCurrencyPassField == null ? "" : valueFromCurrencyPassField;
    }

    public static final String getC2SVideoPlayUrl(BusinessFeedData businessFeedData) {
        String valueFromCurrencyPassField = businessFeedData != null ? businessFeedData.getValueFromCurrencyPassField("video_play_monitor_url") : null;
        return valueFromCurrencyPassField == null ? "" : valueFromCurrencyPassField;
    }

    public static final String getDynamicBgUrl(BusinessFeedData businessFeedData) {
        String valueFromCurrencyPassField = businessFeedData != null ? businessFeedData.getValueFromCurrencyPassField("mask_image_url") : null;
        return valueFromCurrencyPassField == null ? "" : valueFromCurrencyPassField;
    }

    public static final String getFeedDataExtendInfoValue(BusinessFeedData businessFeedData, int i3) {
        CellRecommAction recommAction;
        if (((businessFeedData == null || (recommAction = businessFeedData.getRecommAction()) == null) ? null : recommAction.extendInfo) == null) {
            return "";
        }
        Map<Integer, String> map = businessFeedData.getRecommAction().extendInfo;
        Intrinsics.checkNotNullExpressionValue(map, "this.recommAction.extendInfo");
        String str = map.get(Integer.valueOf(i3));
        return str != null ? str : "";
    }

    public static final String getGDTMiniProgramType(BusinessFeedData businessFeedData) {
        String valueFromCurrencyPassField = businessFeedData != null ? businessFeedData.getValueFromCurrencyPassField(MiniProgramOpenSdkUtil.ATTR_SHARE_TO_QQ_MINI_PROGRAM_TYPE) : null;
        return valueFromCurrencyPassField == null ? "" : valueFromCurrencyPassField;
    }

    public static final int getGdtAdvAnimationBarColor(BusinessFeedData businessFeedData) {
        String valueFromCurrencyPassField;
        if (businessFeedData != null) {
            try {
                valueFromCurrencyPassField = businessFeedData.getValueFromCurrencyPassField("bar_color");
            } catch (Exception e16) {
                e16.printStackTrace();
                return -6721463;
            }
        } else {
            valueFromCurrencyPassField = null;
        }
        if (valueFromCurrencyPassField == null) {
            return -6721463;
        }
        if (!(valueFromCurrencyPassField.length() > 0)) {
            return -6721463;
        }
        if (valueFromCurrencyPassField.charAt(0) != '#') {
            valueFromCurrencyPassField = "#" + valueFromCurrencyPassField;
        }
        return Color.parseColor(valueFromCurrencyPassField);
    }

    public static final List<String> getGdtAdvThirdPlatformPlayerReportURL(BusinessFeedData businessFeedData) {
        if (businessFeedData != null) {
            return businessFeedData.getValueFromCurrencyPassFieldArralist("video_play_monitor_url");
        }
        return null;
    }

    public static final String getGdtEffectCGIUrl(BusinessFeedData businessFeedData) {
        String valueFromCurrencyPassField = businessFeedData != null ? businessFeedData.getValueFromCurrencyPassField("effect_url") : null;
        return valueFromCurrencyPassField == null ? "" : valueFromCurrencyPassField;
    }

    public static final List<QZoneAdFeedData.GestureStageInfo> getGestureStageInfo(BusinessFeedData businessFeedData) {
        QZoneAdFeedData adData;
        if (businessFeedData == null || (adData = businessFeedData.getAdData()) == null) {
            return null;
        }
        return adData.getGestureStageInfoList();
    }

    public static final String getImaxAdVideoUrl(BusinessFeedData businessFeedData) {
        String valueFromCurrencyPassField = businessFeedData != null ? businessFeedData.getValueFromCurrencyPassField("video_url2") : null;
        return valueFromCurrencyPassField == null ? "" : valueFromCurrencyPassField;
    }

    public static final String getPictureOriginalUrl(BusinessFeedData businessFeedData) {
        return getFeedDataExtendInfoValue(businessFeedData, 12);
    }

    public static final String getRewardLandingPageUrl(BusinessFeedData businessFeedData) {
        String valueFromCurrencyPassField = businessFeedData != null ? businessFeedData.getValueFromCurrencyPassField("reward_landing_page_url") : null;
        return valueFromCurrencyPassField == null ? "" : valueFromCurrencyPassField;
    }

    public static final int getShakeAdVisiblePercent(BusinessFeedData businessFeedData) {
        try {
            return Integer.parseInt(getFeedDataExtendInfoValue(businessFeedData, 31));
        } catch (Exception unused) {
            return 0;
        }
    }

    public static final String getTraceId(BusinessFeedData businessFeedData) {
        CellOperationInfo operationInfoV2;
        Map<Integer, String> map;
        String str;
        return (businessFeedData == null || (operationInfoV2 = businessFeedData.getOperationInfoV2()) == null || (map = operationInfoV2.cookie) == null || (str = map.get(3)) == null) ? "" : str;
    }

    public static final VideoPlayInfo getVideoPlayInfoForReportAdPlay(BusinessFeedData businessFeedData) {
        QZoneAdFeedData adData;
        if (businessFeedData == null || (adData = businessFeedData.getAdData()) == null) {
            return null;
        }
        return adData.getGdtVideoPlayInfoForReportAdPlay();
    }

    public static final boolean hasGdtAdvAnimationBarColor(BusinessFeedData businessFeedData) {
        return !TextUtils.isEmpty(businessFeedData != null ? businessFeedData.getValueFromCurrencyPassField("bar_color") : null);
    }

    public static final boolean isAdFeedVideoNeedAutoPlay(BusinessFeedData businessFeedData) {
        return Intrinsics.areEqual(getFeedDataExtendInfoValue(businessFeedData, 33), "2");
    }

    public static final boolean isAdLandingPageVideoNeedAutoPlay(BusinessFeedData businessFeedData) {
        String feedDataExtendInfoValue = getFeedDataExtendInfoValue(businessFeedData, 33);
        return Intrinsics.areEqual(feedDataExtendInfoValue, "1") || Intrinsics.areEqual(feedDataExtendInfoValue, "2");
    }

    public static final boolean isAdLittleIconStyle(BusinessFeedData businessFeedData) {
        return (businessFeedData == null || isLocalAd(businessFeedData) || businessFeedData.isBrandUgcAdvFeeds() || !businessFeedData.isGDTAdvFeed() || businessFeedData.getRecommHeader() == null || businessFeedData.feedType != 4097) ? false : true;
    }

    public static final boolean isAdTopInDetail(BusinessFeedData businessFeedData) {
        Integer num;
        CellFeedCommInfo feedCommInfo = businessFeedData != null ? businessFeedData.getFeedCommInfo() : null;
        return (feedCommInfo == null || feedCommInfo.getStMapABTest() == null || !feedCommInfo.getStMapABTest().containsKey(33) || (num = feedCommInfo.getStMapABTest().get(33)) == null || num.intValue() != 1) ? false : true;
    }

    public static final boolean isAdvContainerSixGridStyle(BusinessFeedData businessFeedData) {
        return businessFeedData != null && businessFeedData.isGDTAdvFeed() && businessFeedData.getPictureInfo() != null && businessFeedData.getPictureInfo().pics.size() == 6;
    }

    public static final boolean isAppAd(BusinessFeedData businessFeedData) {
        return businessFeedData != null && Intrinsics.areEqual("app", businessFeedData.getFeedTypeStr());
    }

    public static final boolean isBrandOptimizationAdv(BusinessFeedData businessFeedData) {
        CellRecommAction recommAction;
        if (((businessFeedData == null || (recommAction = businessFeedData.getRecommAction()) == null) ? null : recommAction.extendInfo) == null) {
            return false;
        }
        try {
            if (businessFeedData.getRecommAction().extendInfo.containsKey(10)) {
                return Intrinsics.areEqual(QZoneAdFeedData.INSTANCE.getAD_SHOW_TYPE_OF_BRAND_OPTIMIZATION(), businessFeedData.getRecommAction().extendInfo.get(10));
            }
            return false;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public static final boolean isButtonAnimationStyleAdv(BusinessFeedData businessFeedData) {
        if (businessFeedData != null && businessFeedData.isGDTAdvFeed() && businessFeedData.getFeedCommInfo() != null && businessFeedData.getFeedCommInfo().getStMapABTest().containsKey(22)) {
            Integer num = businessFeedData.getFeedCommInfo().getStMapABTest().get(22);
            Intrinsics.checkNotNull(num);
            if (num.intValue() > 0 && businessFeedData.getOperationInfoV2() != null && !TextUtils.isEmpty(businessFeedData.getOperationInfoV2().gdtAdvButtonGifUrl)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean isDeepLink(BusinessFeedData businessFeedData) {
        CellOperationInfo cellOperationInfo;
        return (businessFeedData == null || (cellOperationInfo = businessFeedData.cellOperationInfo) == null || TextUtils.isEmpty(cellOperationInfo.schemaPageUrl)) ? false : true;
    }

    public static final boolean isGDTAdvFeed(BusinessFeedData businessFeedData) {
        CellFeedCommInfo feedCommInfoV2 = businessFeedData != null ? businessFeedData.getFeedCommInfoV2() : null;
        if (feedCommInfoV2 != null) {
            return feedCommInfoV2.isGDTAdvFeed();
        }
        return false;
    }

    public static final boolean isGdtAdvAnimationBarStyle(BusinessFeedData businessFeedData) {
        return businessFeedData != null && businessFeedData.isGDTAdvFeed() && (getGdtAdvAnimationBarLoc(businessFeedData) > 0.0f || getGdtAdvAnimationBarTime(businessFeedData) > 0) && hasGdtAdvAnimationBarColor(businessFeedData);
    }

    public static final boolean isGestureAd(BusinessFeedData businessFeedData) {
        Map<Integer, String> map;
        CellRecommAction recommAction;
        if (((businessFeedData == null || (recommAction = businessFeedData.getRecommAction()) == null) ? null : recommAction.extendInfo) == null || (map = businessFeedData.getRecommAction().extendInfo) == null) {
            return false;
        }
        try {
            QZoneAdFeedData adData = businessFeedData.getAdData();
            QZoneAdFeedData.Companion companion = QZoneAdFeedData.INSTANCE;
            String str = map.get(Integer.valueOf(companion.getGESTURE_AD_BEGIN_TIME_KEY()));
            String str2 = "0";
            if (str == null) {
                str = "0";
            }
            adData.setGestureAdBeginTime(Integer.parseInt(str));
            QZoneAdFeedData adData2 = businessFeedData.getAdData();
            String str3 = map.get(Integer.valueOf(companion.getGESTURE_AD_END_TIME_KEY()));
            if (str3 != null) {
                str2 = str3;
            }
            adData2.setGestureAdEndTime(Integer.parseInt(str2));
            if (businessFeedData.getAdData().getGestureAdBeginTime() <= 0 || businessFeedData.getAdData().getGestureAdEndTime() <= 0) {
                return false;
            }
            return businessFeedData.getAdData().getGestureAdBeginTime() < businessFeedData.getAdData().getGestureAdEndTime();
        } catch (Throwable th5) {
            b.c(QZoneAdFeedData.INSTANCE.getTAG(), "[isGestureAd]" + th5);
            return false;
        }
    }

    public static final boolean isLocalAd(BusinessFeedData businessFeedData) {
        return businessFeedData != null && Intrinsics.areEqual("local_adv", businessFeedData.getFeedTypeStr());
    }

    public static final boolean isMiniAppGdtAdv(BusinessFeedData businessFeedData) {
        String valueFromCurrencyPassField = businessFeedData != null ? businessFeedData.getValueFromCurrencyPassField(MiniProgramOpenSdkUtil.ATTR_SHARE_TO_QQ_MINI_PROGRAM_TYPE) : null;
        return !TextUtils.isEmpty(valueFromCurrencyPassField) && Intrinsics.areEqual("11", valueFromCurrencyPassField);
    }

    public static final boolean isNativeAdStyleA(BusinessFeedData businessFeedData) {
        return Intrinsics.areEqual(getFeedDataExtendInfoValue(businessFeedData, 32), "thumbs_up");
    }

    public static final boolean isNativeAdStyleB(BusinessFeedData businessFeedData) {
        return Intrinsics.areEqual(getFeedDataExtendInfoValue(businessFeedData, 32), "actions");
    }

    public static final boolean isNeedRequestRecommendAd(BusinessFeedData businessFeedData) {
        return Intrinsics.areEqual(getFeedDataExtendInfoValue(businessFeedData, 38), "1");
    }

    public static final boolean isNeedShowRecommendAd(BusinessFeedData businessFeedData) {
        QZoneAdFeedData adData;
        if (businessFeedData == null || (adData = businessFeedData.getAdData()) == null) {
            return false;
        }
        return adData.getIsNeedShowRecommendAd();
    }

    public static final boolean isRewardAd(BusinessFeedData businessFeedData) {
        return Intrinsics.areEqual(getFeedDataExtendInfoValue(businessFeedData, 34), QZoneAdFeedData.AD_REWARD);
    }

    public static final boolean isRewardAdRealTimeRequest(BusinessFeedData businessFeedData) {
        return !Intrinsics.areEqual(getFeedDataExtendInfoValue(businessFeedData, 35), "1");
    }

    public static final boolean isShowingRecommendAd(BusinessFeedData businessFeedData) {
        QZoneAdFeedData adData;
        if (businessFeedData == null || (adData = businessFeedData.getAdData()) == null) {
            return false;
        }
        return adData.getIsShowingRecommendAd();
    }

    public static final boolean isTianshuAd(BusinessFeedData businessFeedData) {
        return Intrinsics.areEqual(getFeedDataExtendInfoValue(businessFeedData, 34), "TianShu");
    }

    public static final int recommendAdRequestDelay(BusinessFeedData businessFeedData) {
        String feedDataExtendInfoValue = getFeedDataExtendInfoValue(businessFeedData, 42);
        if (feedDataExtendInfoValue.length() == 0) {
            return 500;
        }
        return Integer.parseInt(feedDataExtendInfoValue);
    }

    public static final int recommendAdStayTime(BusinessFeedData businessFeedData) {
        String feedDataExtendInfoValue = getFeedDataExtendInfoValue(businessFeedData, 43);
        if (feedDataExtendInfoValue.length() == 0) {
            return 1000;
        }
        return Integer.parseInt(feedDataExtendInfoValue);
    }

    public static final void setIsGdtVideoClickedForPlayReport(BusinessFeedData businessFeedData, boolean z16) {
        QZoneAdFeedData adData;
        VideoPlayInfo gdtVideoPlayInfoForReportAdPlay = (businessFeedData == null || (adData = businessFeedData.getAdData()) == null) ? null : adData.getGdtVideoPlayInfoForReportAdPlay();
        if (gdtVideoPlayInfoForReportAdPlay == null) {
            return;
        }
        gdtVideoPlayInfoForReportAdPlay.isGdtAdClicked = z16;
    }

    public static final String shakeAdNewStyle(BusinessFeedData businessFeedData) {
        return getFeedDataExtendInfoValue(businessFeedData, 41);
    }

    public static final int shakeAdScreenBottomPercent(BusinessFeedData businessFeedData) {
        String feedDataExtendInfoValue = getFeedDataExtendInfoValue(businessFeedData, 39);
        if (feedDataExtendInfoValue.length() == 0) {
            return 0;
        }
        return Integer.parseInt(feedDataExtendInfoValue);
    }

    public static final int shakeAdScreenShowTime(BusinessFeedData businessFeedData) {
        String feedDataExtendInfoValue = getFeedDataExtendInfoValue(businessFeedData, 40);
        if (feedDataExtendInfoValue.length() == 0) {
            return 0;
        }
        return Integer.parseInt(feedDataExtendInfoValue);
    }

    public static final PictureUrl getAdPicture(BusinessFeedData businessFeedData) {
        CellPictureInfo pictureInfo;
        ArrayList<PictureItem> arrayList;
        PictureItem pictureItem;
        CellPictureInfo pictureInfo2;
        ArrayList<PictureItem> arrayList2 = (businessFeedData == null || (pictureInfo2 = businessFeedData.getPictureInfo()) == null) ? null : pictureInfo2.pics;
        if (arrayList2 == null || arrayList2.isEmpty()) {
            return new PictureUrl();
        }
        if (businessFeedData == null || (pictureInfo = businessFeedData.getPictureInfo()) == null || (arrayList = pictureInfo.pics) == null || (pictureItem = arrayList.get(0)) == null) {
            return null;
        }
        return pictureItem.originUrl;
    }

    public static final float getGdtAdvAnimationBarLoc(BusinessFeedData businessFeedData) {
        Integer num;
        CellFeedCommInfo feedCommInfo = businessFeedData != null ? businessFeedData.getFeedCommInfo() : null;
        if ((feedCommInfo != null ? feedCommInfo.getStMapABTest() : null) == null || !feedCommInfo.getStMapABTest().containsKey(27) || (num = feedCommInfo.getStMapABTest().get(27)) == null || num.intValue() <= 0) {
            return -1.0f;
        }
        return 1.0f / num.intValue();
    }

    public static final int getGdtAdvAnimationBarTime(BusinessFeedData businessFeedData) {
        Integer num;
        CellFeedCommInfo feedCommInfo = businessFeedData != null ? businessFeedData.getFeedCommInfo() : null;
        if ((feedCommInfo != null ? feedCommInfo.getStMapABTest() : null) == null || !feedCommInfo.getStMapABTest().containsKey(28) || (num = feedCommInfo.getStMapABTest().get(28)) == null || num.intValue() <= 0) {
            return -1;
        }
        return num.intValue();
    }

    public static final int getPostype(BusinessFeedData businessFeedData) {
        Map<Integer, String> map;
        String str;
        if (businessFeedData == null) {
            return 0;
        }
        try {
            CellOperationInfo cellOperationInfo = businessFeedData.cellOperationInfo;
            if (cellOperationInfo == null || (map = cellOperationInfo.cookie) == null || (str = map.get(10)) == null) {
                return 0;
            }
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static final vac_adv_get.TianShuMsg getTianshuMsg(BusinessFeedData businessFeedData) {
        String str;
        CellRecommAction recommAction;
        String str2 = (businessFeedData == null || (recommAction = businessFeedData.getRecommAction()) == null) ? null : recommAction.currency_pass_field;
        if (str2 == null || str2.length() == 0) {
            return null;
        }
        if (businessFeedData != null) {
            try {
                CellRecommAction recommAction2 = businessFeedData.getRecommAction();
                if (recommAction2 != null) {
                    str = recommAction2.currency_pass_field;
                    return new vac_adv_get.TianShuMsg().mergeFrom(a.a(str));
                }
            } catch (Exception unused) {
                return null;
            }
        }
        str = null;
        return new vac_adv_get.TianShuMsg().mergeFrom(a.a(str));
    }

    public static final boolean isAddGroupAdv(BusinessFeedData businessFeedData) {
        CellRecommAction recommAction = businessFeedData != null ? businessFeedData.getRecommAction() : null;
        if ((recommAction != null ? recommAction.extendInfo : null) == null) {
            return false;
        }
        try {
            if (recommAction.extendInfo.containsKey(10)) {
                return Intrinsics.areEqual(QZoneAdFeedData.INSTANCE.getAD_SHOW_TYPE_OF_ADD_GROUP(), recommAction.extendInfo.get(10));
            }
            return false;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public static final boolean isGDTForwardFeed(BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return false;
        }
        CellFeedCommInfo feedCommInfo = businessFeedData.getFeedCommInfo();
        return feedCommInfo != null ? feedCommInfo.isGDTForwardAdvFeed() : false;
    }

    public static final boolean isGdt185AdVideo(BusinessFeedData businessFeedData) {
        return businessFeedData != null && businessFeedData.getVideoInfo() != null && businessFeedData.isGDTAdvFeed() && businessFeedData.isVideo() && businessFeedData.getVideoInfo().width == 1280 && businessFeedData.getVideoInfo().height == 720;
    }

    public static final boolean isGdt585ABTest(BusinessFeedData businessFeedData) {
        Map<Integer, String> map;
        return (businessFeedData == null || businessFeedData.getRecommAction() == null || (map = businessFeedData.getRecommAction().extendInfo) == null || !map.containsKey(21) || TextUtils.isEmpty(map.get(21))) ? false : true;
    }

    public static final boolean isGdt585AdVideo(BusinessFeedData businessFeedData) {
        return businessFeedData != null && businessFeedData.getVideoInfo() != null && businessFeedData.isGDTAdvFeed() && businessFeedData.isVideo() && businessFeedData.getVideoInfo().width == 720 && businessFeedData.getVideoInfo().height == 1280;
    }

    public static final boolean isGdt585LiveAd(BusinessFeedData businessFeedData) {
        Map<Integer, String> map;
        return businessFeedData != null && isGdt585AdVideo(businessFeedData) && businessFeedData.getRecommAction() != null && (map = businessFeedData.getRecommAction().extendInfo) != null && map.containsKey(26) && Intrinsics.areEqual("1", map.get(26));
    }

    public static final boolean isMDPAFeedData(BusinessFeedData businessFeedData) {
        return businessFeedData != null && businessFeedData.isGDTAdvFeed() && getFeedDataIntValueCurrencyPassField(businessFeedData, "mdpa_render_type") == 1;
    }

    public static final boolean isNotGdtAdvFeed(BusinessFeedData businessFeedData) {
        if (businessFeedData != null) {
            return isRewardAd(businessFeedData) || isTianshuAd(businessFeedData);
        }
        return false;
    }

    public static final boolean isDanmakuAdv(BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return false;
        }
        Boolean isDanmukuAdv = businessFeedData.getAdData().getIsDanmukuAdv();
        if (isDanmukuAdv != null) {
            return isDanmukuAdv.booleanValue();
        }
        try {
            JSONArray jSONArray = new JSONArray(GdtAdFeedUtil.getValueFromSdkPassData(businessFeedData, "bullet_screen"));
            if (jSONArray.length() != 0) {
                businessFeedData.getAdData().setDanmukuAdv(Boolean.TRUE);
                businessFeedData.getAdData().setDanmakuAdContents(new String[0]);
                int length = jSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    businessFeedData.getAdData().getDanmakuAdContents()[i3] = jSONArray.get(i3).toString();
                }
            }
        } catch (Exception e16) {
            QLog.e(QZoneAdFeedData.INSTANCE.getTAG(), 1, "isDanmakuAdv json error" + e16);
        }
        Boolean isDanmukuAdv2 = businessFeedData.getAdData().getIsDanmukuAdv();
        if (isDanmukuAdv2 != null) {
            return isDanmukuAdv2.booleanValue();
        }
        return false;
    }

    public static final boolean isTouchFlipAdv(BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return false;
        }
        CellPictureInfo pictureInfo = businessFeedData.getPictureInfo();
        return ((businessFeedData.isAdFeeds() || businessFeedData.isGDTAdvFeed() || isGDTForwardFeed(businessFeedData)) && pictureInfo != null && pictureInfo.animationType != 0 && pictureInfo.pics.size() == 2) || (businessFeedData.isForwardFeed() && isGDTForwardFeed(businessFeedData) && isTouchFlipAdv(businessFeedData.getOriginalInfoSafe()));
    }

    public static final int getGdtInnerAdShowType(BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return Integer.MIN_VALUE;
        }
        if (businessFeedData.getAdData().getMInnerAdShowType() == Integer.MIN_VALUE) {
            try {
                QZoneAdFeedData adData = businessFeedData.getAdData();
                String valueFromSdkPassData = GdtAdFeedUtil.getValueFromSdkPassData(businessFeedData, "inner_adshowtype");
                Intrinsics.checkNotNullExpressionValue(valueFromSdkPassData, "getValueFromSdkPassData(\u2026      \"inner_adshowtype\")");
                adData.setMInnerAdShowType(Integer.parseInt(valueFromSdkPassData));
            } catch (Throwable th5) {
                QLog.e(QZoneAdFeedData.INSTANCE.getTAG(), 2, "innerAdShowType to Int error:" + th5);
            }
        }
        return businessFeedData.getAdData().getMInnerAdShowType();
    }

    public static final int getGdtVideoHeight(BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return Integer.MIN_VALUE;
        }
        if (businessFeedData.getAdData().getVideoHeight() == Integer.MIN_VALUE) {
            businessFeedData.getAdData().setVideoHeight(getFeedDataIntValueCurrencyPassField(businessFeedData, "video_height"));
        }
        return businessFeedData.getAdData().getVideoHeight();
    }

    public static final int getGdtVideoWidth(BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return Integer.MIN_VALUE;
        }
        if (businessFeedData.getAdData().getVideoWidth() == Integer.MIN_VALUE) {
            businessFeedData.getAdData().setVideoWidth(getFeedDataIntValueCurrencyPassField(businessFeedData, "video_width"));
        }
        return businessFeedData.getAdData().getVideoWidth();
    }
}
