package com.tencent.gdtad.aditem;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.AdClickLocationParams;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.util.AdUriUtil;
import com.tencent.ad.tangram.views.feedback.AdFeedbackItemModel;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.pb.PBStringField;
import java.io.ByteArrayOutputStream;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get;
import tencent.gdt.qq_common;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GdtAd implements Externalizable, Parcelable, Ad {
    public static final int AREA_CLICKABLE = 2;
    public static final Parcelable.Creator<GdtAd> CREATOR = new a();
    public static final int EXP_KEY_EXPERIMENT = 100329;
    public static final int EXP_KEY_MOTIVE_VIDEO_AD_CARD_STYLE = 117088;
    public static final int EXP_KEY_MOTIVE_VIDEO_FEEDBACK_STYLE = 109756;
    private static final int EXP_KEY_MOTIVE_VIDEO_FORCE_PORTRAIT_ENABLE = 154303;
    private static final int EXP_KEY_MOTIVE_VIDEO_NONE_BUTTON_ENABLE = 152095;
    public static final String EXP_VALUE_CHANGE_MOTIVE_VIDEO = "2";
    public static final String EXP_VALUE_MOTIVE_VIDEO_FEEDBACK_STYLE = "1";
    public static final int FULL_SCREEN_CLICKABLE = 4;
    public static final int ONLY_BUTTON_CLICKABLE = 1;
    public static final int ONLY_PART_CLICKABLE = 3;
    public static final int REPORT_STATE_FINISHED = 2;
    public static final int REPORT_STATE_INIT = -1;
    public static final int REPORT_STATE_PENDING = 1;
    private static final String SHAKE_AND_CLICK_INTERACTIVE = "ShakeAndClickInteractive";
    private static final String SHAKE_PLUS_INTERACTIVE = "ShakePlusInteractive";
    private static final String SLIDE_AND_CLICK_INTERACTIVE = "SlideAndClickInteractive";
    private static final String TAG = "GdtAd";

    @Nullable
    public qq_ad_get.QQAdGetRsp.AdInfo info;
    private qq_ad_get.QQAdGetRsp.AdInfo.Ext mExt;
    public int reportState = -1;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a implements Parcelable.Creator<GdtAd> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GdtAd createFromParcel(@NonNull Parcel parcel) {
            return new GdtAd(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public GdtAd[] newArray(int i3) {
            return new GdtAd[i3];
        }
    }

    public GdtAd() {
    }

    private boolean checkDisplayCode(String str) {
        if (isValid() && this.info.display_info.interactive.display_code_list.has() && !TextUtils.isEmpty(str)) {
            List<String> list = this.info.display_info.interactive.display_code_list.get();
            for (int i3 = 0; list != null && i3 < list.size(); i3++) {
                if (str.equals(list.get(i3))) {
                    return true;
                }
            }
        }
        return false;
    }

    private static String getButtonTextFromListOrderedByPriorityDESC(List<String> list) {
        if (list != null && !list.isEmpty()) {
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    return str;
                }
            }
        }
        return null;
    }

    private String getButtonTextImpl(int i3, int i16) {
        return getButtonTextFromListOrderedByPriorityDESC(getButtonTextListOrderedByPriorityDESC(i3, i16));
    }

    private List<String> getButtonTextListOrderedByPriorityDESC(int i3, int i16) {
        if ((i16 != Integer.MIN_VALUE && (i16 < 0 || i16 > 100)) || !isValid()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        qq_ad_get.QQAdGetRsp.AdInfo.Ext.ExtraButtonTxt extraButtonText = getExtraButtonText();
        if (extraButtonText == null) {
            extraButtonText = new qq_ad_get.QQAdGetRsp.AdInfo.Ext.ExtraButtonTxt();
        }
        if (i3 != 5) {
            if (i3 != 6) {
                if (i3 != 7) {
                    if (i3 != 9) {
                        arrayList.add(extraButtonText.app_not_download.get());
                    } else {
                        arrayList.add(extraButtonText.app_installed.get());
                    }
                } else {
                    arrayList.add(extraButtonText.app_downloaded.get());
                }
            } else {
                arrayList.add(extraButtonText.app_download_paused.get());
            }
        } else {
            arrayList.add(extraButtonText.app_downloading.get().replace("__PERCENT__", i16 + "%"));
        }
        if (!this.info.display_info.button_info.isEmpty()) {
            arrayList.add(this.info.display_info.button_info.get(0).txt.get());
        }
        return arrayList;
    }

    private long getExperimentLongParam(int i3, long j3) {
        String experimentParam = getExperimentParam(i3);
        if (TextUtils.isEmpty(experimentParam)) {
            return j3;
        }
        try {
            return Long.parseLong(experimentParam);
        } catch (Throwable th5) {
            GdtLog.e(TAG, "getExperimentLongParam", th5);
            return j3;
        }
    }

    @Nullable
    private qq_ad_get.QQAdGetRsp.AdInfo.Ext getExtFromExtJson() {
        qq_ad_get.QQAdGetRsp.AdInfo.Ext ext = this.mExt;
        if (ext != null) {
            return ext;
        }
        if (!isValid() || TextUtils.isEmpty(this.info.ext_json.get())) {
            return null;
        }
        try {
            qq_ad_get.QQAdGetRsp.AdInfo.Ext ext2 = (qq_ad_get.QQAdGetRsp.AdInfo.Ext) GdtJsonPbUtil.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo.Ext(), new JSONObject(this.info.ext_json.get()));
            this.mExt = ext2;
            return ext2;
        } catch (Throwable th5) {
            GdtLog.i(TAG, "getExtFromExtJson", th5);
            return null;
        }
    }

    private qq_ad_get.QQAdGetRsp.AdInfo.Ext.ExtraButtonTxt getExtraButtonText() {
        qq_ad_get.QQAdGetRsp.AdInfo.Ext extFromExtJson = getExtFromExtJson();
        if (extFromExtJson != null) {
            return extFromExtJson.extra_button_txt.get();
        }
        return null;
    }

    private boolean hasExtensionType(int i3) {
        List<Integer> list;
        if (!isValid()) {
            return false;
        }
        if (this.info.display_info.basic_info.ad_extension_type.has()) {
            list = this.info.display_info.basic_info.ad_extension_type.get();
        } else {
            list = null;
        }
        GdtLog.i(TAG, "[hasExtensionType] extensionType:" + i3 + " extensionTypeList:" + list);
        if (list == null || list.isEmpty()) {
            return false;
        }
        return list.contains(Integer.valueOf(i3));
    }

    @Nullable
    private byte[] readBytes(@NonNull ObjectInput objectInput, int i3) {
        if (i3 <= 0) {
            return null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i16 = 0;
            while (true) {
                if (i16 >= i3) {
                    break;
                }
                byte[] bArr = new byte[i3 - i16];
                int read = objectInput.read(bArr);
                if (read < 0) {
                    GdtLog.e(TAG, "readBytes error");
                    break;
                }
                i16 += read;
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byteArrayOutputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (i16 == i3 && byteArray.length == i3) {
                return byteArray;
            }
            GdtLog.e(TAG, "readBytes error");
            return null;
        } catch (Throwable th5) {
            GdtLog.e(TAG, "readBytes", th5);
            return null;
        }
    }

    public boolean canBidAdShake() {
        return checkDisplayCode(SHAKE_AND_CLICK_INTERACTIVE);
    }

    public boolean canContractAdShake() {
        return checkDisplayCode(SHAKE_PLUS_INTERACTIVE);
    }

    public boolean canLeftSlide() {
        return checkDisplayCode(SLIDE_AND_CLICK_INTERACTIVE);
    }

    public boolean canPreloadForQQMINIProgram() {
        qq_ad_get.QQAdGetRsp.AdInfo.Ext extFromExtJson = getExtFromExtJson();
        if (extFromExtJson == null || extFromExtJson.mini_program_preload.get() != 1) {
            return false;
        }
        return true;
    }

    public boolean canShowCustomDialog() {
        qq_ad_get.QQAdGetRsp.AdInfo.Ext extFromExtJson = getExtFromExtJson();
        if (extFromExtJson != null && extFromExtJson.is_show_dialog_before_reward.get() == 1) {
            return true;
        }
        return false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.ad.tangram.Ad
    public boolean disableLaunchApp() {
        qq_ad_get.QQAdGetRsp.AdInfo.Ext extFromExtJson = getExtFromExtJson();
        if (extFromExtJson != null) {
            return extFromExtJson.disable_jump_app_home.get();
        }
        return false;
    }

    @Override // com.tencent.ad.tangram.Ad
    public long getAId() {
        if (isValid()) {
            return this.info.report_info.trace_info.aid.get();
        }
        return WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
    }

    public List<qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ActionAreaItem> getActionAreaItems() {
        if (isValid()) {
            return this.info.display_info.action_area_item.get();
        }
        return null;
    }

    public int getAdCardStyle() {
        int i3;
        List<qq_ad_get.QQAdGetRsp.AdInfo.ExpParam> expMap;
        if (isValid() && (expMap = getExpMap()) != null) {
            for (int i16 = 0; i16 < expMap.size(); i16++) {
                if (expMap.get(i16).key.get() == 117088) {
                    i3 = Integer.parseInt(expMap.get(i16).value.get());
                    break;
                }
            }
        }
        i3 = 1;
        if (i3 != 3) {
            return 1;
        }
        return 3;
    }

    public qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo.MaterialInfo getAdMaterialInfo() {
        if (!isValid()) {
            return null;
        }
        List<qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo.MaterialInfo> list = this.info.display_info.basic_info.materials.get();
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public String getAdSelectedUrl() {
        if (isValid()) {
            return this.info.report_info.imp_stay_report_url.get();
        }
        return null;
    }

    public long getAdvertiserId() {
        if (isValid()) {
            return this.info.display_info.advertiser_info.advertiser_id.get();
        }
        return WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
    }

    public String getAdvertiser_corporate_image_name() {
        if (isValid()) {
            return this.info.display_info.advertiser_info.corporate_image_name.get();
        }
        return "";
    }

    public String getAdvertiser_corporate_logo() {
        if (isValid()) {
            return this.info.display_info.advertiser_info.corporate_logo.get();
        }
        return "";
    }

    public String getAmsBannerGuideUrl() {
        if (!isValid() || !this.info.display_info.basic_info.img3_url.has()) {
            return "";
        }
        return this.info.display_info.basic_info.img3_url.get();
    }

    public String getAmsBannerPushStr() {
        if (!isValid() || !this.info.passthrough_push_ad_info.has()) {
            return "";
        }
        return this.info.passthrough_push_ad_info.get();
    }

    @Override // com.tencent.ad.tangram.Ad
    public String getAppChannelAppName() {
        qq_ad_get.QQAdGetRsp.AdInfo.Ext extFromExtJson = getExtFromExtJson();
        if (extFromExtJson != null && extFromExtJson.app_channel_info.app_name.has()) {
            return extFromExtJson.app_channel_info.app_name.get();
        }
        return null;
    }

    @Override // com.tencent.ad.tangram.Ad
    public String getAppChannelAuthorName() {
        qq_ad_get.QQAdGetRsp.AdInfo.Ext extFromExtJson = getExtFromExtJson();
        if (extFromExtJson != null && extFromExtJson.app_channel_info.author_name.has()) {
            return extFromExtJson.app_channel_info.author_name.get();
        }
        return null;
    }

    public String getAppChannelDeveloper() {
        qq_ad_get.QQAdGetRsp.AdInfo.Ext extFromExtJson = getExtFromExtJson();
        if (extFromExtJson != null && extFromExtJson.app_channel_info.developer.has()) {
            return extFromExtJson.app_channel_info.developer.get();
        }
        return null;
    }

    @Override // com.tencent.ad.tangram.Ad
    public String getAppChannelFeatureListUrl() {
        qq_ad_get.QQAdGetRsp.AdInfo.Ext extFromExtJson = getExtFromExtJson();
        if (extFromExtJson != null && extFromExtJson.app_channel_info.description_url.has()) {
            return extFromExtJson.app_channel_info.description_url.get();
        }
        return null;
    }

    @Override // com.tencent.ad.tangram.Ad
    public String getAppChannelICPNumber() {
        qq_ad_get.QQAdGetRsp.AdInfo.Ext extFromExtJson = getExtFromExtJson();
        if (extFromExtJson != null && extFromExtJson.app_channel_info.icp_number.has()) {
            return extFromExtJson.app_channel_info.icp_number.get();
        }
        return null;
    }

    public long getAppChannelPackageSize() {
        qq_ad_get.QQAdGetRsp.AdInfo.Ext extFromExtJson = getExtFromExtJson();
        if (extFromExtJson != null && extFromExtJson.app_channel_info.package_size_bytes.has()) {
            return extFromExtJson.app_channel_info.package_size_bytes.get();
        }
        return WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
    }

    @Override // com.tencent.ad.tangram.Ad
    public String getAppChannelPermissionUrl() {
        qq_ad_get.QQAdGetRsp.AdInfo.Ext extFromExtJson = getExtFromExtJson();
        if (extFromExtJson != null && extFromExtJson.app_channel_info.permissions_url.has()) {
            return extFromExtJson.app_channel_info.permissions_url.get();
        }
        return null;
    }

    @Override // com.tencent.ad.tangram.Ad
    public String getAppChannelPrivacyUrl() {
        qq_ad_get.QQAdGetRsp.AdInfo.Ext extFromExtJson = getExtFromExtJson();
        if (extFromExtJson != null && extFromExtJson.app_channel_info.privacy_agreement_url.has()) {
            return extFromExtJson.app_channel_info.privacy_agreement_url.get();
        }
        return null;
    }

    @Override // com.tencent.ad.tangram.Ad
    public String getAppChannelSuitableAge() {
        qq_ad_get.QQAdGetRsp.AdInfo.Ext extFromExtJson = getExtFromExtJson();
        if (extFromExtJson != null && extFromExtJson.app_channel_info.suitable_age.has()) {
            return extFromExtJson.app_channel_info.suitable_age.get();
        }
        return null;
    }

    @Override // com.tencent.ad.tangram.Ad
    public String getAppChannelVersionName() {
        qq_ad_get.QQAdGetRsp.AdInfo.Ext extFromExtJson = getExtFromExtJson();
        if (extFromExtJson != null && extFromExtJson.app_channel_info.version_name.has()) {
            return extFromExtJson.app_channel_info.version_name.get();
        }
        return null;
    }

    @Override // com.tencent.ad.tangram.Ad
    public String getAppDeeplink(AdClickLocationParams adClickLocationParams) {
        if (adClickLocationParams == null) {
            adClickLocationParams = new AdClickLocationParams();
        }
        if (isValid() && adClickLocationParams.isValid(this)) {
            if (adClickLocationParams.isDefault()) {
                return this.info.app_info.customized_invoke_url.get();
            }
            if (adClickLocationParams.isValidForCarouselAd(this)) {
                qq_ad_get.QQAdGetRsp.AdInfo.Ext extFromExtJson = getExtFromExtJson();
                if (extFromExtJson == null) {
                    return null;
                }
                return extFromExtJson.carousel_ad_items.get().get(adClickLocationParams.indexOfCarouselAd).deep_link.get();
            }
            if (adClickLocationParams.isValidForMPDA(this)) {
                return this.info.display_info.basic_info.materials.get().get(adClickLocationParams.indexOfMPDA).schema_url.get();
            }
        }
        return null;
    }

    public long getAppDownloadNum() {
        if (isValid()) {
            return this.info.app_info.download_num.get();
        }
        return 0L;
    }

    @Override // com.tencent.ad.tangram.Ad
    public String getAppDownloadUrlApi() {
        qq_ad_get.QQAdGetRsp.AdInfo.Ext extFromExtJson = getExtFromExtJson();
        if (extFromExtJson != null && extFromExtJson.download_api_url.has()) {
            return extFromExtJson.download_api_url.get();
        }
        return null;
    }

    @Override // com.tencent.ad.tangram.Ad
    public String getAppIconUrl() {
        if (isAppProductType() && this.info.app_info.app_logo_url.has()) {
            return this.info.app_info.app_logo_url.get();
        }
        return null;
    }

    @Override // com.tencent.ad.tangram.Ad
    public String getAppId() {
        if (isAppProductType()) {
            return this.info.app_info.android_app_id.get();
        }
        return null;
    }

    @Override // com.tencent.ad.tangram.Ad
    public String getAppMarketDeeplink() {
        qq_ad_get.QQAdGetRsp.AdInfo.Ext extFromExtJson;
        if (!isAppProductType() || (extFromExtJson = getExtFromExtJson()) == null) {
            return null;
        }
        return extFromExtJson.jump_android_market_info.market_deep_link.get();
    }

    @Override // com.tencent.ad.tangram.Ad
    public int getAppMarketJumpType() {
        Integer num;
        if (!isAppProductType()) {
            return 0;
        }
        qq_ad_get.QQAdGetRsp.AdInfo.Ext extFromExtJson = getExtFromExtJson();
        if (extFromExtJson != null) {
            num = Integer.valueOf(extFromExtJson.jump_android_market_info.market_jump_type.get());
        } else {
            num = null;
        }
        return num.intValue();
    }

    @Override // com.tencent.ad.tangram.Ad
    public List<String> getAppMarketPackageName() {
        if (!isAppProductType()) {
            return null;
        }
        try {
            return getExtFromExtJson().jump_android_market_info.market_package_name.get();
        } catch (Throwable th5) {
            GdtLog.i(TAG, "getAppMarketPackageName", th5);
            return null;
        }
    }

    @Override // com.tencent.ad.tangram.Ad
    public String getAppName() {
        if (isAppProductType()) {
            return this.info.app_info.app_name.get();
        }
        return null;
    }

    @Override // com.tencent.ad.tangram.Ad
    public String getAppPackageName() {
        if (!isAppProductType() && !isJDProductType()) {
            return null;
        }
        return this.info.app_info.app_package_name.get();
    }

    public int getAppScore() {
        if (isValid()) {
            return this.info.app_info.app_score_num.get();
        }
        return 0;
    }

    public int getBannerInvalidClickXPercent() {
        List<qq_ad_get.QQAdGetRsp.AdInfo.ExpParam> expMap;
        if (isValid() && (expMap = getExpMap()) != null) {
            for (int i3 = 0; i3 < expMap.size(); i3++) {
                if (expMap.get(i3).key.get() == 101164) {
                    return Integer.parseInt(expMap.get(i3).value.get());
                }
            }
            return Integer.MIN_VALUE;
        }
        return Integer.MIN_VALUE;
    }

    public int getBannerInvalidClickYPercent() {
        List<qq_ad_get.QQAdGetRsp.AdInfo.ExpParam> expMap;
        if (isValid() && (expMap = getExpMap()) != null) {
            for (int i3 = 0; i3 < expMap.size(); i3++) {
                if (expMap.get(i3).key.get() == 101166) {
                    return Integer.parseInt(expMap.get(i3).value.get());
                }
            }
            return Integer.MIN_VALUE;
        }
        return Integer.MIN_VALUE;
    }

    @NonNull
    public String getBasic_img() {
        if (isValid()) {
            return this.info.display_info.basic_info.img.get();
        }
        return "";
    }

    public int getBigBottomAdCardShowTime() {
        qq_ad_get.QQAdGetRsp.AdInfo.Ext extFromExtJson = getExtFromExtJson();
        if (extFromExtJson != null) {
            return extFromExtJson.bottomcard_show_delay_time.get();
        }
        return 5;
    }

    public int getBottomCardLoadTime() {
        return 2;
    }

    @Nullable
    public String getBottomCardUrl() {
        if (isValid()) {
            return this.info.display_info.video_info.bottom_card_url.get();
        }
        return null;
    }

    public long getButtonDelayTime() {
        if (getExtFromExtJson() != null) {
            return r0.button_delay_time.get();
        }
        return 0L;
    }

    public String getButtonText(boolean z16) {
        return getButtonTextImpl(z16 ? 9 : 0, Integer.MIN_VALUE);
    }

    public int getCardBackgroundFormat() {
        if (isValid() && this.info.display_info.basic_info.card_background_img_format.has()) {
            return this.info.display_info.basic_info.card_background_img_format.get();
        }
        return 0;
    }

    public String getCardBackgroundUrl() {
        if (isValid()) {
            return this.info.display_info.basic_info.card_background_url.get();
        }
        return null;
    }

    @Override // com.tencent.ad.tangram.Ad
    public int getCarouselAdCount() {
        qq_ad_get.QQAdGetRsp.AdInfo.Ext extFromExtJson = getExtFromExtJson();
        if (extFromExtJson != null) {
            return extFromExtJson.carousel_ad_items.size();
        }
        return 0;
    }

    public int getClickAreaFromBottom() {
        qq_ad_get.QQAdGetRsp.AdInfo.Ext extFromExtJson = getExtFromExtJson();
        if (extFromExtJson != null) {
            return extFromExtJson.click_area_from_bottom.get();
        }
        return Integer.MIN_VALUE;
    }

    public int getClickMode() {
        qq_ad_get.QQAdGetRsp.AdInfo.Ext extFromExtJson = getExtFromExtJson();
        if (extFromExtJson != null) {
            return extFromExtJson.fullscreen_click_mode.get();
        }
        return Integer.MIN_VALUE;
    }

    public int getCountdownTimeSecs() {
        if (getExtFromExtJson() == null) {
            return Integer.MIN_VALUE;
        }
        return (int) (r0.countdown_end_time.get() - (System.currentTimeMillis() / 1000));
    }

    @Override // com.tencent.ad.tangram.Ad
    public int getCreativeSize() {
        if (isValid()) {
            return this.info.display_info.creative_size.get();
        }
        return Integer.MIN_VALUE;
    }

    public String getCustomRewardText() {
        if (isValid() && this.info.reward_info.customized_reward_txt.has()) {
            return this.info.reward_info.customized_reward_txt.get();
        }
        return null;
    }

    public List<String> getDanmakuContents() {
        qq_ad_get.QQAdGetRsp.AdInfo.Ext extFromExtJson = getExtFromExtJson();
        if (extFromExtJson != null) {
            return extFromExtJson.bullet_screen.get();
        }
        return null;
    }

    @Nullable
    public String getDescription() {
        if (isValid()) {
            return this.info.display_info.basic_info.desc.get();
        }
        return null;
    }

    @Override // com.tencent.ad.tangram.Ad
    public int getDestType() {
        if (isValid()) {
            return this.info.dest_info.dest_type.get();
        }
        return Integer.MIN_VALUE;
    }

    public int getEndcardLoadTime() {
        if (!isValid() || !this.info.display_info.video_info.endcard_load_time.has()) {
            return 5;
        }
        return this.info.display_info.video_info.endcard_load_time.get();
    }

    @Nullable
    public String getEndcardUrl() {
        if (isValid()) {
            return this.info.display_info.video_info.endcard.get();
        }
        return null;
    }

    @Nullable
    public List<qq_ad_get.QQAdGetRsp.AdInfo.ExpParam> getExpMap() {
        qq_ad_get.QQAdGetRsp.AdInfo.Ext extFromExtJson = getExtFromExtJson();
        if (extFromExtJson != null) {
            return extFromExtJson.exp_map.get();
        }
        return new ArrayList();
    }

    public int getExperimentIntegerParam(int i3, int i16) {
        String experimentParam = getExperimentParam(i3);
        if (TextUtils.isEmpty(experimentParam)) {
            return i16;
        }
        try {
            return Integer.parseInt(experimentParam);
        } catch (Throwable th5) {
            GdtLog.e(TAG, "getExperimentLongParam", th5);
            return i16;
        }
    }

    public String getExperimentParam(int i3) {
        List<qq_ad_get.QQAdGetRsp.AdInfo.ExpParam> expMap;
        if (!isValid() || (expMap = getExpMap()) == null) {
            return "";
        }
        int size = expMap.size();
        for (int i16 = 0; i16 < size; i16++) {
            qq_ad_get.QQAdGetRsp.AdInfo.ExpParam expParam = expMap.get(i16);
            if (expParam != null && i3 == expParam.key.get()) {
                return expParam.value.get();
            }
        }
        return "";
    }

    @Override // com.tencent.ad.tangram.Ad
    public String getExtJSON() {
        if (isValid()) {
            return this.info.ext_json.get();
        }
        return null;
    }

    @Override // com.tencent.ad.tangram.Ad
    public List<?> getFeedbackItems() {
        if (!isValid()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(this.info.report_info.neg_fb_items.get().size());
        for (qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.NegativeFeedbackItem negativeFeedbackItem : this.info.report_info.neg_fb_items.get()) {
            AdFeedbackItemModel adFeedbackItemModel = new AdFeedbackItemModel();
            adFeedbackItemModel.mReportType = negativeFeedbackItem.report_type.get();
            adFeedbackItemModel.mActionType = negativeFeedbackItem.action_type.get();
            adFeedbackItemModel.mIconUrl = negativeFeedbackItem.icon_url.get();
            adFeedbackItemModel.mJumpUrl = negativeFeedbackItem.jump_url.get();
            adFeedbackItemModel.mText = negativeFeedbackItem.text.get();
            arrayList.add(adFeedbackItemModel);
        }
        return arrayList;
    }

    @NonNull
    public List<qq_common.FloatingTip> getFloatingTips() {
        qq_ad_get.QQAdGetRsp.AdInfo.Ext extFromExtJson = getExtFromExtJson();
        return extFromExtJson != null ? extFromExtJson.floating_tips.get() : new ArrayList();
    }

    @Nullable
    public GdtImageData getImageData() {
        if (!isValid()) {
            return null;
        }
        GdtImageData gdtImageData = new GdtImageData();
        gdtImageData.url = this.info.display_info.basic_info.img.get();
        gdtImageData.width = this.info.display_info.basic_info.pic_width.get();
        gdtImageData.height = this.info.display_info.basic_info.pic_height.get();
        if (gdtImageData.isValid()) {
            return gdtImageData;
        }
        return null;
    }

    @Override // com.tencent.ad.tangram.Ad
    public int getInnerShowType() {
        qq_ad_get.QQAdGetRsp.AdInfo.Ext extFromExtJson = getExtFromExtJson();
        if (extFromExtJson != null) {
            return extFromExtJson.inner_adshowtype.get();
        }
        return 0;
    }

    public String getInteractiveTipTxt() {
        qq_ad_get.QQAdGetRsp.AdInfo.Ext extFromExtJson = getExtFromExtJson();
        if (extFromExtJson != null) {
            return extFromExtJson.interactive_tip_txt.get();
        }
        return "";
    }

    public String getLabel() {
        if (!isValid() || this.info.display_info.basic_info.element_structure_content.label.size() <= 0) {
            return null;
        }
        return this.info.display_info.basic_info.element_structure_content.label.get(0).content.get();
    }

    public List<qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo.CreativeElementStructureContent.Label> getLabelList() {
        if (!isValid() || this.info.display_info.basic_info.element_structure_content.label.size() <= 0) {
            return null;
        }
        return this.info.display_info.basic_info.element_structure_content.label.get();
    }

    public qq_common.LocalStoreInfo getLocalStoreInfo() {
        qq_ad_get.QQAdGetRsp.AdInfo.Ext extFromExtJson = getExtFromExtJson();
        if (extFromExtJson != null) {
            return extFromExtJson.local_store_info;
        }
        return null;
    }

    @Override // com.tencent.ad.tangram.Ad
    public int getMDPACount() {
        if (!isValid()) {
            return 0;
        }
        return this.info.display_info.basic_info.materials.get().size();
    }

    @Nullable
    public String getMarketPendantImageUrl() {
        if (!isValid()) {
            return null;
        }
        return this.info.display_info.basic_info.marketing_pendant.get();
    }

    public long getMinIntervalMillisBetweenExposureAndClick() {
        List<qq_ad_get.QQAdGetRsp.AdInfo.ExpParam> expMap;
        if (isValid() && (expMap = getExpMap()) != null) {
            for (int i3 = 0; i3 < expMap.size(); i3++) {
                if (expMap.get(i3).key.get() == 101168) {
                    return Long.parseLong(expMap.get(i3).value.get());
                }
            }
            return WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        }
        return WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
    }

    public String getMotiveButtonText() {
        if (isValid() && this.info.display_info.button_info.has() && !this.info.display_info.button_info.isEmpty()) {
            return this.info.display_info.button_info.get(0).txt.get();
        }
        return "";
    }

    public qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.PopupPosterInfo getMotivePupInfo() {
        qq_ad_get.QQAdGetRsp.AdInfo adInfo = this.info;
        if (adInfo != null && adInfo.display_info.popup_poster_info.get() != null) {
            return this.info.display_info.popup_poster_info.get();
        }
        return null;
    }

    public int getMotiveVideoBottomCardClickModel() {
        qq_ad_get.QQAdGetRsp.AdInfo.Ext extFromExtJson = getExtFromExtJson();
        if (extFromExtJson != null) {
            return extFromExtJson.bottomcard_click_mode.get();
        }
        return 1;
    }

    public int getMotiveVideoEndCardClickModel() {
        qq_ad_get.QQAdGetRsp.AdInfo.Ext extFromExtJson = getExtFromExtJson();
        if (extFromExtJson != null) {
            return extFromExtJson.endcard_click_mode.get();
        }
        return 1;
    }

    public String getMsgRedPointReportUrl() {
        if (isValid()) {
            return this.info.report_info.pre_exposure_action_report_url.get();
        }
        return null;
    }

    public List<qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.MultiClickAreaInfo> getMultiClickAreaInfo() {
        qq_ad_get.QQAdGetRsp.AdInfo adInfo = this.info;
        if (adInfo != null && adInfo.display_info.multi_click_area_info.get() != null) {
            return this.info.display_info.multi_click_area_info.get();
        }
        return new ArrayList();
    }

    public long getNocoId() {
        if (isValid()) {
            return this.info.report_info.trace_info.noco_id.get();
        }
        return WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
    }

    public String getOlympicInterPageImage() {
        qq_ad_get.QQAdGetRsp.AdInfo.Ext extFromExtJson = getExtFromExtJson();
        if (extFromExtJson != null && extFromExtJson.img2.has()) {
            return extFromExtJson.img2.get();
        }
        return "";
    }

    @Nullable
    public String getOriginalExposureUrl() {
        if (isValid()) {
            return this.info.report_info.original_exposure_url.get();
        }
        return null;
    }

    @Override // com.tencent.ad.tangram.Ad
    public String getPosId() {
        String str;
        String urlForClick = getUrlForClick();
        if (TextUtils.isEmpty(urlForClick)) {
            AdLog.e(TAG, "getPosId error");
            return null;
        }
        Uri parse = AdUriUtil.parse(urlForClick);
        if (parse != null) {
            str = AdUriUtil.getQueryParameter(parse, "pid");
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str;
    }

    public String getPosterCoverUrl() {
        if (isValid()) {
            return this.info.display_info.floating_zone.image_url.get();
        }
        return null;
    }

    @Override // com.tencent.ad.tangram.Ad
    public int getProductType() {
        if (isValid()) {
            return this.info.product_type.get();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.tencent.ad.tangram.Ad
    public String getQuickAppDeeplink() {
        qq_ad_get.QQAdGetRsp.AdInfo.Ext extFromExtJson = getExtFromExtJson();
        if (extFromExtJson != null) {
            return extFromExtJson.quick_app_link.get();
        }
        return null;
    }

    @Override // com.tencent.ad.tangram.Ad
    public int getRelationTarget() {
        qq_ad_get.QQAdGetRsp.AdInfo.Ext extFromExtJson = getExtFromExtJson();
        if (extFromExtJson != null) {
            return extFromExtJson.relation_target.get();
        }
        return Integer.MIN_VALUE;
    }

    public int getRenderType() {
        if (com.tencent.mobileqq.ad.debug.a.f186830a.i()) {
            return 1;
        }
        if (isValid()) {
            return this.info.reward_info.render_type.get();
        }
        return Integer.MIN_VALUE;
    }

    public String getRewardPassThroughData() {
        if (isValid()) {
            return this.info.reward_info.pass_through_data.get();
        }
        return "";
    }

    public int getRewardPlayType() {
        if (isValid() && this.info.reward_info.play_type.has()) {
            return this.info.reward_info.play_type.get();
        }
        return Integer.MIN_VALUE;
    }

    public String getRewardTemplateId() {
        if (isValid()) {
            return this.info.dynamic_info.template_id.get();
        }
        return "";
    }

    public String getRewardTemplateIdFromPassThrough() {
        if (isValid() && !TextUtils.isEmpty(this.info.reward_info.pass_through_data.get())) {
            try {
                qq_ad_get.QQAdGetRsp.AdInfo.RewardInfo.PassThroughData passThroughData = (qq_ad_get.QQAdGetRsp.AdInfo.RewardInfo.PassThroughData) qq_ad_get.QQAdGetRsp.AdInfo.RewardInfo.PassThroughData.class.cast(GdtJsonPbUtil.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo.RewardInfo.PassThroughData(), new JSONObject(this.info.reward_info.pass_through_data.get())));
                if (passThroughData == null || !passThroughData.dynamic_template_info.template_id.has()) {
                    return null;
                }
                return String.valueOf(passThroughData.dynamic_template_info.template_id.get());
            } catch (Throwable th5) {
                GdtLog.e(TAG, "getRewardTemplateIdFromPassThrough", th5);
            }
        }
        return null;
    }

    public int getRewardTime() {
        if (isValid()) {
            return this.info.reward_info.reward_time.get();
        }
        return Integer.MIN_VALUE;
    }

    public int getRewardType() {
        if (isValid() && !TextUtils.isEmpty(this.info.reward_info.pass_through_data.get())) {
            try {
                qq_ad_get.QQAdGetRsp.AdInfo.RewardInfo.PassThroughData passThroughData = (qq_ad_get.QQAdGetRsp.AdInfo.RewardInfo.PassThroughData) qq_ad_get.QQAdGetRsp.AdInfo.RewardInfo.PassThroughData.class.cast(GdtJsonPbUtil.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo.RewardInfo.PassThroughData(), new JSONObject(this.info.reward_info.pass_through_data.get())));
                if (passThroughData != null) {
                    return passThroughData.reward_type.get();
                }
                return Integer.MIN_VALUE;
            } catch (Throwable th5) {
                GdtLog.e(TAG, "getRewardType", th5);
                return Integer.MIN_VALUE;
            }
        }
        return Integer.MIN_VALUE;
    }

    public String getSpaceBackgroundImageUrl() {
        if (isValid() && this.info.display_info.ad_space_info.background_img_url.has()) {
            return this.info.display_info.ad_space_info.background_img_url.get();
        }
        return null;
    }

    public int getSpaceFrequencyTimeSeconds() {
        if (isValid() && this.info.display_info.ad_space_info.frequency_time.has()) {
            return this.info.display_info.ad_space_info.frequency_time.get();
        }
        return Integer.MIN_VALUE;
    }

    public int getSpaceSlideThreshold() {
        if (isValid() && this.info.display_info.ad_space_info.slide_threshold.has()) {
            return this.info.display_info.ad_space_info.slide_threshold.get();
        }
        return Integer.MIN_VALUE;
    }

    public int getStyle() {
        if (isValid()) {
            return this.info.exp_info.qq_game_video_ad_style.get();
        }
        return 0;
    }

    @Override // com.tencent.ad.tangram.Ad
    public String getTencent_video_id() {
        if (isValid()) {
            return this.info.display_info.video_info.tencent_video_id.get();
        }
        return null;
    }

    @Nullable
    public String getText() {
        if (isValid()) {
            return this.info.display_info.basic_info.txt.get();
        }
        return null;
    }

    public String getTopLeftIconUrl() {
        if (isValid()) {
            return this.info.display_info.basic_info.top_left_icon_url.get();
        }
        return null;
    }

    @Override // com.tencent.ad.tangram.Ad
    @Nullable
    public String getTraceId() {
        if (isValid()) {
            return this.info.report_info.trace_info.traceid.get();
        }
        return null;
    }

    @Override // com.tencent.ad.tangram.Ad
    public String getUrlForAction() {
        if (isValid()) {
            return this.info.report_info.landing_page_report_url.get();
        }
        return null;
    }

    @Override // com.tencent.ad.tangram.Ad
    public String getUrlForClick() {
        if (isValid()) {
            return this.info.report_info.click_url.get();
        }
        return null;
    }

    @Override // com.tencent.ad.tangram.Ad
    public String getUrlForEffect() {
        if (isValid()) {
            return this.info.report_info.effect_url.get();
        }
        return null;
    }

    @Override // com.tencent.ad.tangram.Ad
    public String getUrlForFeedBack() {
        if (isValid()) {
            return this.info.report_info.negative_feedback_url.get();
        }
        return null;
    }

    @Override // com.tencent.ad.tangram.Ad
    public String getUrlForImpression() {
        if (isValid()) {
            return this.info.report_info.exposure_url.get();
        }
        return null;
    }

    @Override // com.tencent.ad.tangram.Ad
    public String getUrlForLandingPage() {
        if (isValid()) {
            return this.info.dest_info.landing_page.get();
        }
        return null;
    }

    @Override // com.tencent.ad.tangram.Ad
    public String getUrlForRewardLandingPage() {
        if (isValid()) {
            return this.info.dest_info.reward_landing_page_url.get();
        }
        return null;
    }

    @Override // com.tencent.ad.tangram.Ad
    public String getVia() {
        if (isValid()) {
            return this.info.report_info.trace_info.via.get();
        }
        return null;
    }

    public int getVideoDuration() {
        if (isValid() && this.info.display_info.video_info.media_duration.has()) {
            return this.info.display_info.video_info.media_duration.get();
        }
        return Integer.MIN_VALUE;
    }

    public int getVideoEmergencyTimeSeconds(int i3) {
        return getExperimentIntegerParam(120611, i3);
    }

    @Override // com.tencent.ad.tangram.Ad
    public int getVideoHeight() {
        if (isValid() && this.info.display_info.video_info.height.has()) {
            return this.info.display_info.video_info.height.get();
        }
        return Integer.MIN_VALUE;
    }

    public boolean getVideoNoAutoPlay() {
        if (isValid() && this.info.display_info.video_info.no_auto_play.get()) {
            return true;
        }
        return false;
    }

    public int getVideoPreloadDurationSeconds(int i3) {
        return getExperimentIntegerParam(120608, i3);
    }

    @Nullable
    public String getVideoReportUrl() {
        if (isValid()) {
            return this.info.report_info.video_report_url.get();
        }
        return null;
    }

    public int getVideoSafePlayTimeSeconds(int i3) {
        return getExperimentIntegerParam(120612, i3);
    }

    public String getVideoUrl() {
        if (isValid()) {
            return this.info.display_info.video_info.video_url.get();
        }
        return null;
    }

    @Override // com.tencent.ad.tangram.Ad
    public int getVideoWidth() {
        if (isValid() && this.info.display_info.video_info.width.has()) {
            return this.info.display_info.video_info.width.get();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.tencent.ad.tangram.Ad
    public String getViewId(AdClickLocationParams adClickLocationParams) {
        qq_ad_get.QQAdGetRsp.AdInfo.Ext extFromExtJson;
        if (adClickLocationParams == null) {
            adClickLocationParams = new AdClickLocationParams();
        }
        if (!adClickLocationParams.isValid(this)) {
            return null;
        }
        if (!adClickLocationParams.isDefault() && !adClickLocationParams.isValidForMPDA(this)) {
            if (!adClickLocationParams.isValidForCarouselAd(this) || (extFromExtJson = getExtFromExtJson()) == null) {
                return null;
            }
            return extFromExtJson.carousel_ad_items.get().get(adClickLocationParams.indexOfCarouselAd).view_id.get();
        }
        if (isValid()) {
            return this.info.report_info.trace_info.view_id.get();
        }
        return null;
    }

    @Override // com.tencent.ad.tangram.Ad
    @Nullable
    public String getWXCanvasExtInfo(AdClickLocationParams adClickLocationParams) {
        qq_ad_get.QQAdGetRsp.AdInfo.Ext extFromExtJson;
        if (!isWXCanvasAd()) {
            return null;
        }
        if (adClickLocationParams == null) {
            adClickLocationParams = new AdClickLocationParams();
        }
        if (!adClickLocationParams.isValid(this) || (extFromExtJson = getExtFromExtJson()) == null || !adClickLocationParams.isDefault()) {
            return null;
        }
        return extFromExtJson.wechat_canvas_ext_info.get();
    }

    @Override // com.tencent.ad.tangram.Ad
    public String getWXChannelAppID() {
        if (isValid()) {
            return this.info.wechat_app_info.app_id.get();
        }
        return null;
    }

    public String getWXCustomerServiceAdditionalText() {
        if (isValid() && this.info.dest_info.half_screen_card_config.additional_txt.has()) {
            return this.info.dest_info.half_screen_card_config.additional_txt.get();
        }
        return null;
    }

    public String getWXCustomerServiceConsultingText() {
        if (isValid() && this.info.dest_info.half_screen_card_config.consulting_txt.has()) {
            return this.info.dest_info.half_screen_card_config.consulting_txt.get();
        }
        return null;
    }

    public long getWXCustomerServiceKuiklyMinVersion() {
        String experimentParam = getExperimentParam(158777);
        if (TextUtils.isEmpty(experimentParam)) {
            return WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        }
        try {
            return Long.parseLong(experimentParam);
        } catch (Throwable th5) {
            GdtLog.e(TAG, "[getKuiklyLocalMinVersion]", th5);
            return WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        }
    }

    @Override // com.tencent.ad.tangram.Ad
    public int getWXMINIGameJumpType() {
        qq_ad_get.QQAdGetRsp.AdInfo.Ext extFromExtJson;
        if (!isWXMINIGameProductType() || (extFromExtJson = getExtFromExtJson()) == null) {
            return Integer.MIN_VALUE;
        }
        return extFromExtJson.wx_minigame_jump_type.get();
    }

    @Override // com.tencent.ad.tangram.Ad
    public String getWXMINIProgramAppID(AdClickLocationParams adClickLocationParams) {
        if (!isWXMINIProgramOrWXMINIGameProductType()) {
            return null;
        }
        if (adClickLocationParams == null) {
            adClickLocationParams = new AdClickLocationParams();
        }
        if (!adClickLocationParams.isValid(this)) {
            return null;
        }
        if (!adClickLocationParams.isDefault() && !adClickLocationParams.isValidForCarouselAd(this) && !adClickLocationParams.isValidForMPDA(this)) {
            return null;
        }
        return this.info.wechat_app_info.wechat_appid.get();
    }

    @Override // com.tencent.ad.tangram.Ad
    public int getWXMINIProgramOpenType(AdClickLocationParams adClickLocationParams) {
        qq_ad_get.QQAdGetRsp.AdInfo.Ext extFromExtJson = getExtFromExtJson();
        if (extFromExtJson != null) {
            return extFromExtJson.wechat_mini_program_open_type.get();
        }
        return 0;
    }

    @Override // com.tencent.ad.tangram.Ad
    @Nullable
    public String getWXMINIProgramPath(AdClickLocationParams adClickLocationParams) {
        if (!isWXMINIProgramOrWXMINIGameProductType()) {
            return null;
        }
        if (adClickLocationParams == null) {
            adClickLocationParams = new AdClickLocationParams();
        }
        if (!adClickLocationParams.isValid(this)) {
            return null;
        }
        if (adClickLocationParams.isDefault()) {
            return this.info.wechat_app_info.app_path.get();
        }
        if (adClickLocationParams.isValidForCarouselAd(this)) {
            qq_ad_get.QQAdGetRsp.AdInfo.Ext extFromExtJson = getExtFromExtJson();
            if (extFromExtJson == null) {
                return null;
            }
            return extFromExtJson.carousel_ad_items.get().get(adClickLocationParams.indexOfCarouselAd).wechat_app_path.get();
        }
        if (!adClickLocationParams.isValidForMPDA(this)) {
            return null;
        }
        return this.info.display_info.basic_info.materials.get().get(adClickLocationParams.indexOfMPDA).wx_mini_program_path.get();
    }

    @Override // com.tencent.ad.tangram.Ad
    @Nullable
    public String getWXMINIProgramTraceData(AdClickLocationParams adClickLocationParams) {
        if (!isWXMINIProgramOrWXMINIGameProductType()) {
            return null;
        }
        if (adClickLocationParams == null) {
            adClickLocationParams = new AdClickLocationParams();
        }
        if (!adClickLocationParams.isValid(this)) {
            return null;
        }
        if (!adClickLocationParams.isDefault() && !adClickLocationParams.isValidForCarouselAd(this) && !adClickLocationParams.isValidForMPDA(this)) {
            return null;
        }
        return this.info.wechat_app_info.ad_trace_data.get();
    }

    @Override // com.tencent.ad.tangram.Ad
    @Nullable
    public String getWXMINIProgramUserName(AdClickLocationParams adClickLocationParams) {
        if (!isWXMINIProgramOrWXMINIGameProductType()) {
            return null;
        }
        if (adClickLocationParams == null) {
            adClickLocationParams = new AdClickLocationParams();
        }
        if (!adClickLocationParams.isValid(this)) {
            return null;
        }
        if (!adClickLocationParams.isDefault() && !adClickLocationParams.isValidForCarouselAd(this) && !adClickLocationParams.isValidForMPDA(this)) {
            return null;
        }
        return this.info.wechat_app_info.app_username.get();
    }

    @Override // com.tencent.ad.tangram.Ad
    @Nullable
    public String getWXToken(AdClickLocationParams adClickLocationParams) {
        if (!isWXMINIProgramOrWXMINIGameProductType()) {
            return null;
        }
        if (adClickLocationParams == null) {
            adClickLocationParams = new AdClickLocationParams();
        }
        if (!adClickLocationParams.isValid(this)) {
            return null;
        }
        if (!adClickLocationParams.isDefault() && !adClickLocationParams.isValidForCarouselAd(this) && !adClickLocationParams.isValidForMPDA(this)) {
            return null;
        }
        return this.info.wechat_app_info.app_token.get();
    }

    @Override // com.tencent.ad.tangram.Ad
    public boolean isAppProductType() {
        if (getProductType() == 12) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.ad.tangram.Ad
    public boolean isAppXiJing() {
        if (isAppProductType() && getDestType() == 1) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.ad.tangram.Ad
    public boolean isAppXiJingDefault() {
        if (isAppProductType() && getDestType() == 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.ad.tangram.Ad
    public boolean isAppXiJingFengling() {
        if (isAppProductType() && getDestType() == 4) {
            return true;
        }
        return false;
    }

    public boolean isContractAd() {
        if (isValid()) {
            return this.info.display_info.basic_info.is_contract_ad.get();
        }
        return false;
    }

    @Override // com.tencent.ad.tangram.Ad
    public boolean isDeeplinkFallbackToUrl() {
        qq_ad_get.QQAdGetRsp.AdInfo.Ext extFromExtJson = getExtFromExtJson();
        if (extFromExtJson != null && extFromExtJson.landingpage_open_type.has() && extFromExtJson.landingpage_open_type.get() == 2) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.ad.tangram.Ad
    public boolean isDownloadEnabled() {
        if (isValid() && this.info.display_info.outer_layer_download.has() && this.info.display_info.outer_layer_download.get() == 1) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.ad.tangram.Ad
    public boolean isEnableHalfScreenDownload() {
        qq_ad_get.QQAdGetRsp.AdInfo.Ext extFromExtJson = getExtFromExtJson();
        if (extFromExtJson != null && extFromExtJson.enable_half_card.has() && extFromExtJson.enable_half_card.get() == 1) {
            return true;
        }
        return false;
    }

    public boolean isExperiment(int i3, @Nullable String str) {
        List<qq_ad_get.QQAdGetRsp.AdInfo.ExpParam> expMap;
        if (!isValid() || TextUtils.isEmpty(str) || (expMap = getExpMap()) == null) {
            return false;
        }
        int size = expMap.size();
        for (int i16 = 0; i16 < size; i16++) {
            qq_ad_get.QQAdGetRsp.AdInfo.ExpParam expParam = expMap.get(i16);
            if (expParam != null && i3 == expParam.key.get() && str.equals(expParam.value.get())) {
                return true;
            }
        }
        return false;
    }

    public boolean isInterstitial() {
        qq_ad_get.QQAdGetRsp.AdInfo.Ext extFromExtJson = getExtFromExtJson();
        if (extFromExtJson == null || extFromExtJson.render_pos_type.get() != 2) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.ad.tangram.Ad
    public boolean isJDProductType() {
        if (getProductType() == 25) {
            return true;
        }
        return false;
    }

    public boolean isMotiveAd() {
        if (isValid() && this.info.reward_info.render_type.has()) {
            return true;
        }
        return false;
    }

    public boolean isMotiveBrowsingFromExtJson() {
        qq_ad_get.QQAdGetRsp.AdInfo.Ext extFromExtJson = getExtFromExtJson();
        if (extFromExtJson != null && extFromExtJson.is_reward_page.get()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.ad.tangram.Ad
    public boolean isOlympicInterPageType() {
        if (isValid() && this.info.dest_info.need_olympic_middle_page.has() && this.info.dest_info.need_olympic_middle_page.get()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.ad.tangram.Ad
    public boolean isQQMINIProgram() {
        if (isValid() && this.info.display_info.mini_program_type.get() == 11) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.ad.tangram.Ad
    public boolean isQuickAppProductType() {
        if (getProductType() == 53) {
            return true;
        }
        return false;
    }

    public boolean isRewardAdForcePortrait() {
        List<qq_ad_get.QQAdGetRsp.AdInfo.ExpParam> expMap;
        if (isValid() && (expMap = getExpMap()) != null) {
            for (int i3 = 0; i3 < expMap.size(); i3++) {
                if (expMap.get(i3).key.get() == EXP_KEY_MOTIVE_VIDEO_FORCE_PORTRAIT_ENABLE) {
                    if (Integer.parseInt(expMap.get(i3).value.get()) != 1) {
                        return false;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isSupportNoneButtonStyle() {
        List<qq_ad_get.QQAdGetRsp.AdInfo.ExpParam> expMap;
        if (isValid() && (expMap = getExpMap()) != null) {
            for (int i3 = 0; i3 < expMap.size(); i3++) {
                if (expMap.get(i3).key.get() == EXP_KEY_MOTIVE_VIDEO_NONE_BUTTON_ENABLE) {
                    if (Integer.parseInt(expMap.get(i3).value.get()) != 1) {
                        return true;
                    }
                    return false;
                }
            }
        }
        return true;
    }

    @Override // com.tencent.ad.tangram.Ad
    public boolean isTripleLink() {
        qq_ad_get.QQAdGetRsp.AdInfo.Ext extFromExtJson = getExtFromExtJson();
        if (extFromExtJson != null && extFromExtJson.is_third_link_ad.has() && extFromExtJson.is_third_link_ad.get() == 1) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.ad.tangram.Ad
    public boolean isValid() {
        if (this.info != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.ad.tangram.Ad
    public boolean isVideoOnTopDisabled() {
        qq_ad_get.QQAdGetRsp.AdInfo.Ext extFromExtJson = getExtFromExtJson();
        if (extFromExtJson != null) {
            return extFromExtJson.disable_video_on_top.get();
        }
        return false;
    }

    public boolean isVideoPCDNEnabled() {
        return isExperiment(119700, "1");
    }

    @Override // com.tencent.ad.tangram.Ad
    public boolean isWXCanvasAd() {
        if (isValid() && this.info.dest_info.dest_type.get() == 12) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.ad.tangram.Ad
    public boolean isWXCustomerService() {
        return false;
    }

    @Override // com.tencent.ad.tangram.Ad
    public boolean isWXMINIGameProductType() {
        if (!isValid() || getProductType() != 46) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.ad.tangram.Ad
    public boolean isWXMINIProgram() {
        boolean isValid = isValid();
        if (isValid) {
            qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo displayInfo = this.info.display_info;
            if (displayInfo != null && displayInfo.mini_program_type.get() == 3) {
                isValid = true;
            } else {
                isValid = false;
            }
        }
        return isValid | isTripleLink();
    }

    @Override // com.tencent.ad.tangram.Ad
    public boolean isWXMINIProgramOrWXMINIGameProductType() {
        if (!isWXMINIProgram() && !isWXMINIGameProductType()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.ad.tangram.Ad
    public boolean isXijingByExtensionType() {
        return hasExtensionType(17);
    }

    @Override // java.io.Externalizable
    public void readExternal(@Nullable ObjectInput objectInput) throws IOException, ClassNotFoundException {
        byte[] readBytes;
        if (objectInput == null) {
            GdtLog.e(TAG, "readExternal error");
            return;
        }
        try {
            int readInt = objectInput.readInt();
            if (readInt > 0 && (readBytes = readBytes(objectInput, readInt)) != null && readBytes.length > 0) {
                qq_ad_get.QQAdGetRsp.AdInfo adInfo = new qq_ad_get.QQAdGetRsp.AdInfo();
                adInfo.mergeFrom(readBytes);
                this.info = adInfo;
            }
        } catch (Throwable th5) {
            GdtLog.e(TAG, "readExternal", th5);
        }
    }

    public void replaceUrlForClick(String str, String str2) {
        if (!TextUtils.isEmpty(getUrlForClick())) {
            PBStringField pBStringField = this.info.report_info.click_url;
            pBStringField.set(pBStringField.get().replace(str, str2));
        }
    }

    @NonNull
    public String toString() {
        Object pbToJson;
        if (isValid() && (pbToJson = GdtJsonPbUtil.pbToJson(this.info)) != null && !JSONObject.NULL.equals(pbToJson)) {
            return pbToJson.toString();
        }
        return "";
    }

    @Override // java.io.Externalizable
    public void writeExternal(@Nullable ObjectOutput objectOutput) throws IOException {
        qq_ad_get.QQAdGetRsp.AdInfo adInfo;
        byte[] byteArray;
        if (objectOutput != null && (adInfo = this.info) != null) {
            if (adInfo != null) {
                try {
                    byteArray = adInfo.toByteArray();
                } catch (Throwable th5) {
                    GdtLog.e(TAG, "writeExternal", th5);
                    return;
                }
            } else {
                byteArray = null;
            }
            if (byteArray != null && byteArray.length > 0) {
                objectOutput.writeInt(byteArray.length);
                objectOutput.write(byteArray);
                return;
            } else {
                objectOutput.writeInt(0);
                return;
            }
        }
        GdtLog.e(TAG, "writeExternal error");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@Nullable Parcel parcel, int i3) {
        qq_ad_get.QQAdGetRsp.AdInfo adInfo;
        int i16;
        if (parcel != null && (adInfo = this.info) != null) {
            try {
                byte[] byteArray = adInfo.toByteArray();
                if (byteArray != null) {
                    i16 = byteArray.length;
                } else {
                    i16 = 0;
                }
                parcel.writeInt(i16);
                if (i16 <= 0) {
                    GdtLog.e(TAG, "writeToParcel error");
                    return;
                } else {
                    parcel.writeByteArray(byteArray);
                    return;
                }
            } catch (Throwable th5) {
                GdtLog.e(TAG, "writeToParcel", th5);
                return;
            }
        }
        GdtLog.e(TAG, "writeToParcel error");
    }

    @Override // com.tencent.ad.tangram.Ad
    public String getButtonText(int i3, int i16) {
        if (i16 < 0 || i16 > 100) {
            return null;
        }
        return getButtonTextImpl(i3, i16);
    }

    @Override // com.tencent.ad.tangram.Ad
    @Nullable
    public String getUrlForClick(AdClickLocationParams adClickLocationParams) {
        if (adClickLocationParams == null) {
            adClickLocationParams = new AdClickLocationParams();
        }
        if (!adClickLocationParams.isValid(this)) {
            return null;
        }
        if (adClickLocationParams.isDefault()) {
            return getUrlForClick();
        }
        if (adClickLocationParams.isValidForCarouselAd(this)) {
            qq_ad_get.QQAdGetRsp.AdInfo.Ext extFromExtJson = getExtFromExtJson();
            if (extFromExtJson != null) {
                return extFromExtJson.carousel_ad_items.get().get(adClickLocationParams.indexOfCarouselAd).click_url.get();
            }
            return null;
        }
        if (isValid() && adClickLocationParams.isValidForMPDA(this)) {
            return this.info.display_info.basic_info.materials.get().get(adClickLocationParams.indexOfMPDA).click_url.get();
        }
        return null;
    }

    @Override // com.tencent.ad.tangram.Ad
    @Nullable
    public String getUrlForLandingPage(AdClickLocationParams adClickLocationParams) {
        if (adClickLocationParams == null) {
            adClickLocationParams = new AdClickLocationParams();
        }
        if (!adClickLocationParams.isValid(this)) {
            return null;
        }
        if (adClickLocationParams.isDefault()) {
            return getUrlForLandingPage();
        }
        if (adClickLocationParams.isValidForCarouselAd(this)) {
            qq_ad_get.QQAdGetRsp.AdInfo.Ext extFromExtJson = getExtFromExtJson();
            if (extFromExtJson != null) {
                return extFromExtJson.carousel_ad_items.get().get(adClickLocationParams.indexOfCarouselAd).landingpage_url.get();
            }
            return null;
        }
        if (isValid() && adClickLocationParams.isValidForMPDA(this)) {
            return this.info.display_info.basic_info.materials.get().get(adClickLocationParams.indexOfMPDA).landingpage_url.get();
        }
        return null;
    }

    @Override // com.tencent.ad.tangram.Ad
    public String getVideoUrl(AdClickLocationParams adClickLocationParams) {
        qq_ad_get.QQAdGetRsp.AdInfo.Ext extFromExtJson;
        if (adClickLocationParams == null) {
            adClickLocationParams = new AdClickLocationParams();
        }
        if (!adClickLocationParams.isValid(this)) {
            return null;
        }
        if (adClickLocationParams.isDefault()) {
            return getVideoUrl();
        }
        if (adClickLocationParams.isValidForCarouselAd(this) && (extFromExtJson = getExtFromExtJson()) != null && extFromExtJson.carousel_ad_items.has()) {
            return extFromExtJson.carousel_ad_items.get().get(adClickLocationParams.indexOfCarouselAd).video_url.get();
        }
        return null;
    }

    public GdtAd(qq_ad_get.QQAdGetRsp.AdInfo adInfo) {
        this.info = adInfo;
    }

    @Nullable
    public qq_common.FloatingTip getFloatingTips(int i3) {
        List<qq_common.FloatingTip> floatingTips = getFloatingTips();
        for (int i16 = 0; i16 < floatingTips.size(); i16++) {
            if (floatingTips.get(i16) != null && floatingTips.get(i16).type.get() == i3) {
                return floatingTips.get(i16);
            }
        }
        return null;
    }

    protected GdtAd(@NonNull Parcel parcel) {
        try {
            int readInt = parcel.readInt();
            if (readInt <= 0) {
                GdtLog.e(TAG, "GdtAd(Parcel in) error");
                return;
            }
            byte[] bArr = new byte[readInt];
            parcel.readByteArray(bArr);
            qq_ad_get.QQAdGetRsp.AdInfo adInfo = new qq_ad_get.QQAdGetRsp.AdInfo();
            adInfo.mergeFrom(bArr);
            this.info = adInfo;
        } catch (Throwable th5) {
            GdtLog.e(TAG, "GdtAd(Parcel in)", th5);
        }
    }

    @Nullable
    public GdtImageData getImageData(int i3) {
        if (!isValid() || i3 < 0 || i3 >= this.info.display_info.muti_pic_text_info.image.size()) {
            return null;
        }
        GdtImageData gdtImageData = new GdtImageData();
        gdtImageData.url = this.info.display_info.muti_pic_text_info.image.get(i3);
        gdtImageData.width = this.info.display_info.basic_info.pic_width.get();
        gdtImageData.height = this.info.display_info.basic_info.pic_height.get();
        return gdtImageData;
    }

    @Nullable
    public String getViewId() {
        if (isValid()) {
            return this.info.report_info.trace_info.view_id.get();
        }
        return null;
    }
}
