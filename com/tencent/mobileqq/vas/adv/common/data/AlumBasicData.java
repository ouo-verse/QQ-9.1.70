package com.tencent.mobileqq.vas.adv.common.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.gdtad.statistics.GdtOriginalExposureReporter;
import com.tencent.gdtad.statistics.GdtReporter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.vas.adv.common.pb.vac_adv_get;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes20.dex */
public class AlumBasicData implements Parcelable {
    public static final int ADV_CLICK = 2;
    public static final int ADV_EFFECTIVE_EXPOSURE = 4;
    public static final int ADV_EXPOSURE = 1;
    public static final int ADV_FEEDBACK = 3;
    public static final int ADV_TYPE_PIC = 0;
    public static final int ADV_TYPE_VIDEO = 1;
    public static final int ALBUM_SOURCE_FROM_GROUP = 2;
    public static final int ALBUM_SOURCE_FROM_QZONE = 1;
    public static final Parcelable.Creator<AlumBasicData> CREATOR = new a();
    private static final String EXP_KEY_AD_CLICK_BLOCK_SWIPE_RIGHT = "ad_click_block_swipe_right";
    private static final String EXP_KEY_AD_MULTIPLE_EXPOSURE = "allow_multiple_exposure";
    private static final int EXP_KEY_AD_NEGATIVE_FEEDBACK_NEW_ICON = 10002;
    private static final String EXP_KEY_AD_RSQ_WAITING_TIME = "max_wait_time_in_millisecond";
    private static final String EXP_KEY_AD_SHOW_SWIPE_LEFT_PROMPT = "show_swipe_left_prompt";
    private static final String EXP_KEY_MINIAPP_AD_PRELOAD = "mini_program_preload";
    private static final String EXP_VALUE_AD_NEGATIVE_FEEDBACK_NEW_ICON = "1";
    public static final int EXP_VALUE_MINIAPP_AD_PRELOAD = 1;
    public static final int MINI_PROGRAM_TYPE = 11;
    private static final String TAG = "AlumBasicData";
    public qq_ad_get.QQAdGetRsp.AdInfo adInfo;
    public int adinfolength;
    public String advLogoUrl;
    public String advTextText;
    public String advTextTitle;
    public int advType;
    public String advimageUrl;
    public long aid;
    public int autoPlay;
    public String clickUrl;
    public List<DropData> dropList;
    public Map<String, String> extendInfos;
    public int hasExposed;
    public int imageHeight;
    public int imageWith;
    public int innerAdShowType;
    public boolean isDtExpoReport;
    public boolean isFeedxLayer;
    public boolean isOriginalExposureReport;
    public String leftBottomText;
    public String negativeFeedbackUrl;
    public int preloadMiniApp;
    public String qqbexposureInfor;
    public String recCookie;
    public VasAdvServiceCode retCode;
    public String rightBottomButton;
    public int sourceFrom;
    public String traceId;
    public String videoReportUrl;
    public int videoShowTime;
    public String videoUrl;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class DropData {
        public int actionType;
        public String content;
        public String jumpUrl;
        public String logoUrl;

        public static DropData creatFromPb(vac_adv_get.DropList dropList) {
            if (dropList == null) {
                return null;
            }
            DropData dropData = new DropData();
            dropData.actionType = dropList.action_type.get();
            dropData.content = dropList.optext.get();
            dropData.logoUrl = dropList.iconurl.get();
            dropData.jumpUrl = dropList.jumpurl.get();
            return dropData;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements Parcelable.Creator<AlumBasicData> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AlumBasicData createFromParcel(Parcel parcel) {
            return new AlumBasicData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public AlumBasicData[] newArray(int i3) {
            return new AlumBasicData[i3];
        }
    }

    public AlumBasicData() {
        this.sourceFrom = 1;
        this.traceId = "";
        this.leftBottomText = "";
        this.rightBottomButton = "";
        this.advLogoUrl = "";
        this.dropList = new ArrayList();
        this.hasExposed = 0;
        this.videoUrl = "";
        this.advType = -1;
        this.innerAdShowType = -1;
        this.videoReportUrl = "";
        this.isOriginalExposureReport = false;
        this.isDtExpoReport = false;
        this.extendInfos = new HashMap();
    }

    public static AlumBasicData createFromPb(vac_adv_get.VacAdvMetaMsg vacAdvMetaMsg, Map<String, String> map) {
        AlumBasicData alumBasicData = new AlumBasicData();
        if (vacAdvMetaMsg == null) {
            return null;
        }
        alumBasicData.recCookie = vacAdvMetaMsg.recomm_cookie.get();
        alumBasicData.extendInfos = map;
        return updateBasicDataWithAdInfo(alumBasicData, vacAdvMetaMsg.adv_rsp.get());
    }

    public static AlumBasicData createFrombyte(byte[] bArr) {
        qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo reportInfo;
        AlumBasicData alumBasicData = new AlumBasicData();
        if (bArr != null) {
            try {
            } catch (Exception e16) {
                QLog.e(TAG, 1, "createFrombyte  from byte error " + e16);
            }
            if (bArr.length != 0) {
                QLog.i(TAG, 1, " begin createFrombyte");
                vac_adv_get.VacFeedsAdvMetaInfo vacFeedsAdvMetaInfo = new vac_adv_get.VacFeedsAdvMetaInfo();
                vacFeedsAdvMetaInfo.mergeFrom(bArr);
                qq_ad_get.QQAdGetRsp.AdInfo adInfo = vacFeedsAdvMetaInfo.adv_rsp.get();
                alumBasicData.adInfo = adInfo;
                alumBasicData.recCookie = vacFeedsAdvMetaInfo.recomm_cookie.get();
                parseDisplayInfoFiled(alumBasicData, adInfo);
                if (vacFeedsAdvMetaInfo.default_conf.has() && vacFeedsAdvMetaInfo.default_conf.get() != null) {
                    if (TextUtils.isEmpty(alumBasicData.leftBottomText) && vacFeedsAdvMetaInfo.default_conf.left_bottom_text.has()) {
                        alumBasicData.leftBottomText = vacFeedsAdvMetaInfo.default_conf.left_bottom_text.get();
                    }
                    if (TextUtils.isEmpty(alumBasicData.rightBottomButton) && vacFeedsAdvMetaInfo.default_conf.right_bottom_button.has()) {
                        alumBasicData.rightBottomButton = vacFeedsAdvMetaInfo.default_conf.right_bottom_button.get();
                    }
                }
                if (vacFeedsAdvMetaInfo.droplist.has() && vacFeedsAdvMetaInfo.droplist.get() != null && vacFeedsAdvMetaInfo.droplist.get().size() != 0) {
                    for (int i3 = 0; i3 < vacFeedsAdvMetaInfo.droplist.get().size(); i3++) {
                        alumBasicData.dropList.add(DropData.creatFromPb(vacFeedsAdvMetaInfo.droplist.get().get(i3)));
                    }
                }
                if (adInfo != null && (reportInfo = adInfo.report_info) != null) {
                    qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo reportInfo2 = reportInfo.get();
                    alumBasicData.qqbexposureInfor = reportInfo2.exposure_url.get();
                    alumBasicData.negativeFeedbackUrl = reportInfo2.negative_feedback_url.get();
                    alumBasicData.clickUrl = reportInfo2.click_url.get();
                    if (adInfo.report_info.trace_info != null) {
                        alumBasicData.aid = reportInfo2.trace_info.aid.get();
                        alumBasicData.traceId = reportInfo2.trace_info.traceid.get();
                    }
                }
                return alumBasicData;
            }
        }
        QLog.i(TAG, 1, " bytes is null");
        return null;
    }

    private String getOriginalIExposureUrl(AlumBasicData alumBasicData, boolean z16) {
        qq_ad_get.QQAdGetRsp.AdInfo adInfo;
        qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo reportInfo;
        PBStringField pBStringField;
        String str = "";
        if (alumBasicData == null || (adInfo = alumBasicData.adInfo) == null || (reportInfo = adInfo.report_info) == null || (pBStringField = reportInfo.original_exposure_url) == null || TextUtils.isEmpty(pBStringField.get())) {
            return "";
        }
        try {
            str = alumBasicData.adInfo.report_info.original_exposure_url.get();
            if (!TextUtils.isEmpty(str)) {
                return GdtOriginalExposureReporter.replaceUrlMacros(str, alumBasicData.adInfo.product_type.get(), z16);
            }
            return str;
        } catch (Exception e16) {
            e16.printStackTrace();
            return str;
        }
    }

    private static void parseBottomBtnTxt(AlumBasicData alumBasicData, qq_ad_get.QQAdGetRsp.AdInfo adInfo) {
        if (adInfo.display_info.button_info.has() && adInfo.display_info.button_info.get() != null && adInfo.display_info.button_info.get().size() > 0) {
            boolean z16 = false;
            boolean z17 = false;
            for (int i3 = 0; i3 < adInfo.display_info.button_info.get().size(); i3++) {
                qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo buttonInfo = adInfo.display_info.button_info.get(i3);
                if (!z16 && buttonInfo.pos.get() == 2 && !TextUtils.isEmpty(buttonInfo.txt.get())) {
                    alumBasicData.rightBottomButton = buttonInfo.txt.get();
                    z16 = true;
                }
                if (!z17 && buttonInfo.pos.get() == 1 && !TextUtils.isEmpty(buttonInfo.txt.get())) {
                    alumBasicData.leftBottomText = buttonInfo.txt.get();
                    z17 = true;
                }
                if (z17 && z16) {
                    return;
                }
            }
        }
    }

    private static void parseDisplayInfoFiled(AlumBasicData alumBasicData, qq_ad_get.QQAdGetRsp.AdInfo adInfo) {
        if (adInfo != null && adInfo.display_info.get() != null) {
            qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo basicInfo = adInfo.display_info.basic_info.get();
            if (basicInfo != null) {
                alumBasicData.advimageUrl = basicInfo.img.get();
                alumBasicData.advTextText = basicInfo.txt.get();
                alumBasicData.imageWith = basicInfo.pic_width.get();
                alumBasicData.imageHeight = basicInfo.pic_height.get();
            }
            if (adInfo.display_info.advertiser_info.get() != null) {
                alumBasicData.advTextTitle = adInfo.display_info.advertiser_info.corporate_image_name.get();
                alumBasicData.advLogoUrl = adInfo.display_info.advertiser_info.corporate_logo.get();
            }
            if (adInfo.display_info.button_info.has() && adInfo.display_info.button_info.get() != null && adInfo.display_info.button_info.get().size() > 0) {
                for (int i3 = 0; i3 < adInfo.display_info.button_info.get().size(); i3++) {
                    qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo buttonInfo = adInfo.display_info.button_info.get(i3);
                    if (buttonInfo.pos.get() == 2 && !TextUtils.isEmpty(buttonInfo.txt.get())) {
                        alumBasicData.rightBottomButton = buttonInfo.txt.get();
                    }
                    if (buttonInfo.pos.get() == 1 && !TextUtils.isEmpty(buttonInfo.txt.get())) {
                        alumBasicData.leftBottomText = buttonInfo.txt.get();
                    }
                }
            }
            QLog.i(TAG, 1, " basicData.advTextTitle=" + alumBasicData.advTextTitle);
        }
    }

    private static AlumBasicData updateBasicDataWithAdInfo(AlumBasicData alumBasicData, qq_ad_get.QQAdGetRsp.AdInfo adInfo) {
        PBStringField pBStringField;
        qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo reportInfo;
        String str;
        int i3;
        if (alumBasicData == null) {
            return null;
        }
        alumBasicData.adInfo = adInfo;
        if (adInfo != null && adInfo.display_info.get() != null) {
            qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo basicInfo = adInfo.display_info.basic_info.get();
            if (basicInfo != null) {
                alumBasicData.advimageUrl = basicInfo.img.get();
                alumBasicData.advTextText = basicInfo.txt.get();
                alumBasicData.imageWith = basicInfo.pic_width.get();
                alumBasicData.imageHeight = basicInfo.pic_height.get();
                if (TextUtils.isEmpty(alumBasicData.advimageUrl)) {
                    i3 = -1;
                } else {
                    i3 = 0;
                }
                alumBasicData.advType = i3;
            }
            if (adInfo.display_info.advertiser_info.get() != null) {
                alumBasicData.advTextTitle = adInfo.display_info.advertiser_info.corporate_image_name.get();
                alumBasicData.advLogoUrl = adInfo.display_info.advertiser_info.corporate_logo.get();
            }
            qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.VideoInfo videoInfo = adInfo.display_info.video_info.get();
            if (videoInfo != null) {
                alumBasicData.videoUrl = videoInfo.video_url.get();
                alumBasicData.videoShowTime = videoInfo.media_duration.get();
                alumBasicData.autoPlay = !videoInfo.no_auto_play.get() ? 1 : 0;
                if (!TextUtils.isEmpty(alumBasicData.videoUrl)) {
                    alumBasicData.advType = 1;
                }
            }
            parseBottomBtnTxt(alumBasicData, adInfo);
        }
        if (adInfo != null && (reportInfo = adInfo.report_info) != null) {
            qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo reportInfo2 = reportInfo.get();
            alumBasicData.qqbexposureInfor = reportInfo2.exposure_url.get();
            alumBasicData.negativeFeedbackUrl = reportInfo2.negative_feedback_url.get();
            alumBasicData.clickUrl = reportInfo2.click_url.get();
            if (adInfo.report_info.trace_info != null) {
                alumBasicData.aid = reportInfo2.trace_info.aid.get();
                alumBasicData.traceId = reportInfo2.trace_info.traceid.get();
            }
            if (reportInfo2.video_report_url.get() == null) {
                str = "";
            } else {
                str = reportInfo2.video_report_url.get();
            }
            alumBasicData.videoReportUrl = str;
        }
        if (adInfo != null && (pBStringField = adInfo.ext_json) != null) {
            String str2 = pBStringField.get();
            if (!TextUtils.isEmpty(str2)) {
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    if (jSONObject.has(EXP_KEY_MINIAPP_AD_PRELOAD)) {
                        alumBasicData.preloadMiniApp = jSONObject.getInt(EXP_KEY_MINIAPP_AD_PRELOAD);
                    }
                    alumBasicData.innerAdShowType = jSONObject.optInt("inner_adshowtype", -1);
                } catch (Exception e16) {
                    QLog.e(TAG, 2, e16.toString());
                }
            }
        }
        return alumBasicData;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean disableTouchSlideBack() {
        if (!this.extendInfos.containsKey(EXP_KEY_AD_CLICK_BLOCK_SWIPE_RIGHT)) {
            return false;
        }
        try {
            if (Integer.parseInt(this.extendInfos.get(EXP_KEY_AD_CLICK_BLOCK_SWIPE_RIGHT)) != 1) {
                return false;
            }
            return true;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "disableTouchSlideBack parse error" + e16);
            return false;
        }
    }

    public int getAdRsqWaitingTime() {
        if (!this.extendInfos.containsKey(EXP_KEY_AD_RSQ_WAITING_TIME)) {
            return 0;
        }
        try {
            return Integer.parseInt(this.extendInfos.get(EXP_KEY_AD_RSQ_WAITING_TIME));
        } catch (Exception unused) {
            QLog.e(TAG, 1, "AdRspWatingTime parse error");
            return 0;
        }
    }

    public boolean isAdMultiExposed() {
        try {
            if (!this.extendInfos.containsKey(EXP_KEY_AD_MULTIPLE_EXPOSURE)) {
                return false;
            }
            if (!TextUtils.equals(this.extendInfos.get(EXP_KEY_AD_MULTIPLE_EXPOSURE), "1")) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            QLog.e(TAG, 1, "AdMultiExposed parse error");
            return false;
        }
    }

    public boolean isLimitAdRsqWaitingTime() {
        if (getAdRsqWaitingTime() != -1) {
            return true;
        }
        return false;
    }

    public boolean isPicAdvType() {
        if (this.advType == 0) {
            return true;
        }
        return false;
    }

    public boolean isShowLeftSlideTip() {
        try {
            if (!this.extendInfos.containsKey(EXP_KEY_AD_SHOW_SWIPE_LEFT_PROMPT)) {
                return false;
            }
            if (!TextUtils.equals(this.extendInfos.get(EXP_KEY_AD_SHOW_SWIPE_LEFT_PROMPT), "1")) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            QLog.e(TAG, 1, "isShowLeftSlideTip parse error");
            return false;
        }
    }

    public boolean isUseAdNegativeFeedbackNewIcon() {
        qq_ad_get.QQAdGetRsp.AdInfo.Ext ext;
        qq_ad_get.QQAdGetRsp.AdInfo adInfo = this.adInfo;
        if (adInfo != null && (ext = adInfo.ext) != null) {
            for (qq_ad_get.QQAdGetRsp.AdInfo.ExpParam expParam : ext.exp_map.get()) {
                if (expParam.key.get() == 10002 && "1".equals(expParam.value.get())) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public boolean isVerticalPic() {
        if (this.innerAdShowType == 2) {
            return true;
        }
        return false;
    }

    public boolean isVerticalVideo() {
        if (this.innerAdShowType == 4) {
            return true;
        }
        return false;
    }

    public boolean isVideoAdvType() {
        if (this.advType == 1) {
            return true;
        }
        return false;
    }

    public void originalExposureReport(AlumBasicData alumBasicData, boolean z16) {
        if (alumBasicData == null) {
            return;
        }
        String originalIExposureUrl = getOriginalIExposureUrl(alumBasicData, z16);
        if (!TextUtils.isEmpty(originalIExposureUrl) && !alumBasicData.isOriginalExposureReport) {
            GdtReporter.doCgiReport(originalIExposureUrl);
            alumBasicData.isOriginalExposureReport = true;
            QZLog.i(TAG, "GDT_CGI_REPORT" + originalIExposureUrl);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.recCookie);
        parcel.writeString(this.advimageUrl);
        parcel.writeString(this.advTextTitle);
        parcel.writeString(this.advTextText);
        parcel.writeInt(this.imageWith);
        parcel.writeInt(this.imageHeight);
        parcel.writeString(this.qqbexposureInfor);
        parcel.writeString(this.negativeFeedbackUrl);
        parcel.writeString(this.clickUrl);
        parcel.writeLong(this.aid);
        parcel.writeString(this.traceId);
        int i16 = 0;
        try {
            byte[] byteArray = this.adInfo.toByteArray();
            i16 = byteArray.length;
            parcel.writeInt(i16);
            parcel.writeByteArray(byteArray);
        } catch (Exception e16) {
            parcel.writeInt(i16);
            QLog.e(TAG, 1, "AlumBasicData writeToParcel  error " + e16);
        }
        parcel.writeString(this.leftBottomText);
        parcel.writeString(this.rightBottomButton);
        parcel.writeList(this.dropList);
        parcel.writeInt(this.hasExposed);
        parcel.writeString(this.videoUrl);
        parcel.writeInt(this.videoShowTime);
        parcel.writeInt(this.autoPlay);
        parcel.writeInt(this.advType);
        parcel.writeInt(this.preloadMiniApp);
        parcel.writeString(this.advLogoUrl);
        parcel.writeString(this.videoReportUrl);
    }

    public static AlumBasicData createFromPb(qq_ad_get.QQAdGetRsp.PosAdInfo posAdInfo, Map<String, String> map) {
        AlumBasicData alumBasicData = new AlumBasicData();
        if (posAdInfo == null) {
            return null;
        }
        alumBasicData.extendInfos = map;
        return updateBasicDataWithAdInfo(alumBasicData, posAdInfo.ads_info.get(0));
    }

    protected AlumBasicData(Parcel parcel) {
        this.sourceFrom = 1;
        this.traceId = "";
        this.leftBottomText = "";
        this.rightBottomButton = "";
        this.advLogoUrl = "";
        this.dropList = new ArrayList();
        this.hasExposed = 0;
        this.videoUrl = "";
        this.advType = -1;
        this.innerAdShowType = -1;
        this.videoReportUrl = "";
        this.isOriginalExposureReport = false;
        this.isDtExpoReport = false;
        this.extendInfos = new HashMap();
        this.recCookie = parcel.readString();
        this.advimageUrl = parcel.readString();
        this.advTextTitle = parcel.readString();
        this.advTextText = parcel.readString();
        this.imageWith = parcel.readInt();
        this.imageHeight = parcel.readInt();
        this.qqbexposureInfor = parcel.readString();
        this.negativeFeedbackUrl = parcel.readString();
        this.clickUrl = parcel.readString();
        this.aid = parcel.readLong();
        this.traceId = parcel.readString();
        int readInt = parcel.readInt();
        this.adinfolength = readInt;
        if (readInt > 0) {
            byte[] bArr = new byte[readInt];
            parcel.readByteArray(bArr);
            qq_ad_get.QQAdGetRsp.AdInfo adInfo = new qq_ad_get.QQAdGetRsp.AdInfo();
            this.adInfo = adInfo;
            try {
                adInfo.mergeFrom(bArr);
            } catch (Exception e16) {
                QLog.e(TAG, 1, "parse ad info from byte error " + e16);
            }
        }
        this.leftBottomText = parcel.readString();
        this.rightBottomButton = parcel.readString();
        parcel.readList(this.dropList, DropData.class.getClassLoader());
        this.hasExposed = parcel.readInt();
        this.videoUrl = parcel.readString();
        this.videoShowTime = parcel.readInt();
        this.autoPlay = parcel.readInt();
        this.advType = parcel.readInt();
        this.preloadMiniApp = parcel.readInt();
        this.advLogoUrl = parcel.readString();
        this.videoReportUrl = parcel.readString();
    }
}
