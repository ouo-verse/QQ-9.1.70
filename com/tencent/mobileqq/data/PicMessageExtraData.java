package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.emoticon.StickerInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qphone.base.util.QLog;
import tencent.im.msg.hummer.resv3.CustomFaceExtPb$AnimationImageShow;
import tencent.im.msg.hummer.resv3.CustomFaceExtPb$ResvAttr;
import tencent.im.msg.hummer.resv6.NotOnlineImageExtPb$ResvAttr;

/* loaded from: classes10.dex */
public class PicMessageExtraData {
    public CustomFaceExtPb$AnimationImageShow animationImageShow;
    public int customFaceType;
    public String doutuSupplier;
    public String emojiId;
    public String emojiPkgId;
    public int from;
    public String iconUrl;
    public int imageBizType;
    public int jumpId;
    public String mAdEmoDescStr;
    public String mAdEmoJumpUrl;
    public String mDownloadIndex;
    public String mOriginImageMd5;
    public String mTemplateId;
    public String mTemplateName;
    public ZPlanPicExtraData mZPlanPicInfo;
    public String packageName;
    public String source;
    public StickerInfo stickerInfo;
    public String textSummary;
    public String webUrl;

    public PicMessageExtraData() {
        this.doutuSupplier = "";
        this.textSummary = "";
        this.from = 0;
    }

    public CustomFaceExtPb$ResvAttr getCustomFaceResvAttr() {
        CustomFaceExtPb$ResvAttr customFaceExtPb$ResvAttr = new CustomFaceExtPb$ResvAttr();
        customFaceExtPb$ResvAttr.uint32_image_biz_type.set(this.imageBizType);
        customFaceExtPb$ResvAttr.uint32_customface_type.set(this.customFaceType);
        customFaceExtPb$ResvAttr.string_doutu_suppliers.set(this.doutuSupplier);
        try {
            String str = this.emojiPkgId;
            if (str != null) {
                customFaceExtPb$ResvAttr.uint32_emoji_packageid.set(Integer.parseInt(str));
            }
            String str2 = this.emojiId;
            if (str2 != null) {
                customFaceExtPb$ResvAttr.uint32_emoji_id.set(Integer.parseInt(str2));
            }
        } catch (NumberFormatException e16) {
            e16.printStackTrace();
        }
        CustomFaceExtPb$AnimationImageShow customFaceExtPb$AnimationImageShow = this.animationImageShow;
        if (customFaceExtPb$AnimationImageShow != null && customFaceExtPb$AnimationImageShow.has()) {
            customFaceExtPb$ResvAttr.msg_image_show.set(this.animationImageShow);
        }
        if (!TextUtils.isEmpty(this.textSummary)) {
            customFaceExtPb$ResvAttr.bytes_text_summary.set(ByteStringMicro.copyFromUtf8(this.textSummary));
        }
        customFaceExtPb$ResvAttr.uint32_emoji_from.set(this.from);
        if (!TextUtils.isEmpty(this.source)) {
            customFaceExtPb$ResvAttr.string_emoji_source.set(this.source);
        }
        if (!TextUtils.isEmpty(this.webUrl)) {
            customFaceExtPb$ResvAttr.string_emoji_webUrl.set(this.webUrl);
        }
        if (!TextUtils.isEmpty(this.iconUrl)) {
            customFaceExtPb$ResvAttr.string_emoji_iconUrl.set(this.iconUrl);
        }
        if (!TextUtils.isEmpty(this.packageName)) {
            customFaceExtPb$ResvAttr.string_emoji_marketFaceName.set(this.packageName);
        }
        if (!TextUtils.isEmpty(this.mTemplateId)) {
            customFaceExtPb$ResvAttr.string_camera_capture_templateinfo.set(this.mTemplateId);
        }
        if (!TextUtils.isEmpty(this.mTemplateName)) {
            customFaceExtPb$ResvAttr.string_camera_capture_materialname.set(this.mTemplateName);
        }
        if (!TextUtils.isEmpty(this.mAdEmoJumpUrl)) {
            customFaceExtPb$ResvAttr.string_ad_emo_jump_url.set(this.mAdEmoJumpUrl);
        }
        if (!TextUtils.isEmpty(this.mAdEmoDescStr)) {
            customFaceExtPb$ResvAttr.string_ad_emo_desc_str.set(this.mAdEmoDescStr);
        }
        if (!TextUtils.isEmpty(this.mDownloadIndex)) {
            customFaceExtPb$ResvAttr.bytes_download_index.set(ByteStringMicro.copyFromUtf8(this.mDownloadIndex));
        }
        ZPlanPicExtraData zPlanPicExtraData = this.mZPlanPicInfo;
        if (zPlanPicExtraData != null) {
            customFaceExtPb$ResvAttr.msg_zplan_sticker.set(ZPlanPicExtraData.parseZPlanPicExtraDataToQunInfo(zPlanPicExtraData));
        }
        if (!TextUtils.isEmpty(this.mOriginImageMd5)) {
            customFaceExtPb$ResvAttr.bytes_original_image_md5_new.set(ByteStringMicro.copyFromUtf8(this.mOriginImageMd5));
        }
        return customFaceExtPb$ResvAttr;
    }

    public NotOnlineImageExtPb$ResvAttr getOfflineImageResvAttr() {
        NotOnlineImageExtPb$ResvAttr notOnlineImageExtPb$ResvAttr = new NotOnlineImageExtPb$ResvAttr();
        notOnlineImageExtPb$ResvAttr.uint32_image_biz_type.set(this.imageBizType);
        notOnlineImageExtPb$ResvAttr.uint32_customface_type.set(this.customFaceType);
        notOnlineImageExtPb$ResvAttr.string_doutu_suppliers.set(this.doutuSupplier);
        try {
            String str = this.emojiPkgId;
            if (str != null) {
                notOnlineImageExtPb$ResvAttr.uint32_emoji_packageid.set(Integer.parseInt(str));
            }
            String str2 = this.emojiId;
            if (str2 != null) {
                notOnlineImageExtPb$ResvAttr.uint32_emoji_id.set(Integer.parseInt(str2));
            }
        } catch (NumberFormatException e16) {
            e16.printStackTrace();
        }
        if (!TextUtils.isEmpty(this.textSummary)) {
            notOnlineImageExtPb$ResvAttr.bytes_text_summary.set(ByteStringMicro.copyFromUtf8(this.textSummary));
        }
        notOnlineImageExtPb$ResvAttr.uint32_emoji_from.set(this.from);
        if (!TextUtils.isEmpty(this.source)) {
            notOnlineImageExtPb$ResvAttr.string_emoji_source.set(this.source);
        }
        if (!TextUtils.isEmpty(this.webUrl)) {
            notOnlineImageExtPb$ResvAttr.string_emoji_webUrl.set(this.webUrl);
        }
        if (!TextUtils.isEmpty(this.iconUrl)) {
            notOnlineImageExtPb$ResvAttr.string_emoji_iconUrl.set(this.iconUrl);
        }
        if (!TextUtils.isEmpty(this.packageName)) {
            notOnlineImageExtPb$ResvAttr.string_emoji_marketFaceName.set(this.packageName);
        }
        if (!TextUtils.isEmpty(this.mTemplateId)) {
            notOnlineImageExtPb$ResvAttr.string_camera_capture_templateinfo.set(this.mTemplateId);
        }
        if (!TextUtils.isEmpty(this.mTemplateName)) {
            notOnlineImageExtPb$ResvAttr.string_camera_capture_materialname.set(this.mTemplateName);
        }
        if (!TextUtils.isEmpty(this.mAdEmoJumpUrl)) {
            notOnlineImageExtPb$ResvAttr.string_ad_emo_jump_url.set(this.mAdEmoJumpUrl);
        }
        if (!TextUtils.isEmpty(this.mAdEmoDescStr)) {
            notOnlineImageExtPb$ResvAttr.string_ad_emo_desc_str.set(this.mAdEmoDescStr);
        }
        ZPlanPicExtraData zPlanPicExtraData = this.mZPlanPicInfo;
        if (zPlanPicExtraData != null) {
            notOnlineImageExtPb$ResvAttr.msg_zplan_sticker.set(ZPlanPicExtraData.parseZPlanPicExtraDataToC2CInfo(zPlanPicExtraData));
        }
        if (!TextUtils.isEmpty(this.mOriginImageMd5)) {
            notOnlineImageExtPb$ResvAttr.bytes_original_image_md5_new.set(ByteStringMicro.copyFromUtf8(this.mOriginImageMd5));
        }
        return notOnlineImageExtPb$ResvAttr;
    }

    public boolean isCustomFace() {
        if (this.imageBizType == 1) {
            return true;
        }
        return false;
    }

    public boolean isDiyDouTu() {
        if (isCustomFace() && 2 == this.customFaceType) {
            return true;
        }
        return false;
    }

    public boolean isDoutu() {
        if (this.imageBizType == 3) {
            return true;
        }
        return false;
    }

    public boolean isEmotion() {
        if (!isCustomFace() && !isStickerPics() && !isStickerAdPic() && !isDiyDouTu() && !isHotPics() && !isZhitu() && !isSelfieFace() && !isDoutu() && !isRelatedEmo() && !isHotSearch() && !isZPlanPic()) {
            return false;
        }
        return true;
    }

    public boolean isHotPics() {
        if (this.imageBizType == 2) {
            return true;
        }
        return false;
    }

    public boolean isHotSearch() {
        if (this.imageBizType == 13) {
            return true;
        }
        return false;
    }

    public boolean isRelatedEmo() {
        if (this.imageBizType == 10) {
            return true;
        }
        return false;
    }

    public boolean isSelfieFace() {
        if (this.imageBizType == 8) {
            return true;
        }
        return false;
    }

    public boolean isStickerAdPic() {
        if (this.imageBizType == 9) {
            return true;
        }
        return false;
    }

    public boolean isStickerPics() {
        if (this.imageBizType == 7) {
            return true;
        }
        return false;
    }

    public boolean isZPlanPic() {
        ZPlanPicExtraData zPlanPicExtraData = this.mZPlanPicInfo;
        if (zPlanPicExtraData != null && zPlanPicExtraData.getId() > 0) {
            return true;
        }
        return false;
    }

    public boolean isZhitu() {
        if (this.imageBizType == 4) {
            return true;
        }
        return false;
    }

    public void setAdEmoDescStr(String str) {
        this.mAdEmoDescStr = str;
        if (QLog.isColorLevel() && str != null) {
            QLog.d("PicMessageExtraData", 2, "adEmoDescStr, length = " + str.length());
        }
    }

    public void setAdEmoJumpUrl(String str) {
        this.mAdEmoJumpUrl = str;
        if (QLog.isColorLevel() && str != null) {
            QLog.d("PicMessageExtraData", 2, "setAdEmoJumpUrl, length = " + str.length());
        }
    }

    public PicMessageExtraData(CustomFaceExtPb$ResvAttr customFaceExtPb$ResvAttr) {
        this.doutuSupplier = "";
        this.textSummary = "";
        this.from = 0;
        this.imageBizType = customFaceExtPb$ResvAttr.uint32_image_biz_type.get();
        this.customFaceType = customFaceExtPb$ResvAttr.uint32_customface_type.get();
        this.emojiPkgId = String.valueOf(customFaceExtPb$ResvAttr.uint32_emoji_packageid.get());
        this.emojiId = String.valueOf(customFaceExtPb$ResvAttr.uint32_emoji_id.get());
        this.doutuSupplier = String.valueOf(customFaceExtPb$ResvAttr.string_doutu_suppliers.get());
        this.animationImageShow = customFaceExtPb$ResvAttr.msg_image_show.get();
        if (customFaceExtPb$ResvAttr.bytes_text_summary.has()) {
            this.textSummary = customFaceExtPb$ResvAttr.bytes_text_summary.get().toStringUtf8();
        }
        this.from = customFaceExtPb$ResvAttr.uint32_emoji_from.get();
        this.source = customFaceExtPb$ResvAttr.string_emoji_source.get();
        this.webUrl = customFaceExtPb$ResvAttr.string_emoji_webUrl.get();
        this.iconUrl = customFaceExtPb$ResvAttr.string_emoji_iconUrl.get();
        this.packageName = customFaceExtPb$ResvAttr.string_emoji_marketFaceName.get();
        this.mTemplateId = customFaceExtPb$ResvAttr.string_camera_capture_templateinfo.get();
        this.mTemplateName = customFaceExtPb$ResvAttr.string_camera_capture_materialname.get();
        this.mAdEmoJumpUrl = customFaceExtPb$ResvAttr.string_ad_emo_jump_url.get();
        this.mAdEmoDescStr = customFaceExtPb$ResvAttr.string_ad_emo_desc_str.get();
        this.mDownloadIndex = customFaceExtPb$ResvAttr.bytes_download_index.get().toStringUtf8();
        if (customFaceExtPb$ResvAttr.msg_zplan_sticker.has()) {
            this.mZPlanPicInfo = ZPlanPicExtraData.parseCustomInfoToZPlanPicExtraData(customFaceExtPb$ResvAttr.msg_zplan_sticker);
        }
        if (customFaceExtPb$ResvAttr.bytes_original_image_md5_new.has()) {
            this.mOriginImageMd5 = customFaceExtPb$ResvAttr.bytes_original_image_md5_new.get().toStringUtf8();
        }
    }

    public PicMessageExtraData(NotOnlineImageExtPb$ResvAttr notOnlineImageExtPb$ResvAttr) {
        this.doutuSupplier = "";
        this.textSummary = "";
        this.from = 0;
        this.imageBizType = notOnlineImageExtPb$ResvAttr.uint32_image_biz_type.get();
        this.customFaceType = notOnlineImageExtPb$ResvAttr.uint32_customface_type.get();
        this.emojiPkgId = String.valueOf(notOnlineImageExtPb$ResvAttr.uint32_emoji_packageid.get());
        this.emojiId = String.valueOf(notOnlineImageExtPb$ResvAttr.uint32_emoji_id.get());
        this.doutuSupplier = notOnlineImageExtPb$ResvAttr.string_doutu_suppliers.get();
        if (notOnlineImageExtPb$ResvAttr.bytes_text_summary.has()) {
            this.textSummary = notOnlineImageExtPb$ResvAttr.bytes_text_summary.get().toStringUtf8();
        }
        this.from = notOnlineImageExtPb$ResvAttr.uint32_emoji_from.get();
        this.source = notOnlineImageExtPb$ResvAttr.string_emoji_source.get();
        this.webUrl = notOnlineImageExtPb$ResvAttr.string_emoji_webUrl.get();
        this.iconUrl = notOnlineImageExtPb$ResvAttr.string_emoji_iconUrl.get();
        this.packageName = notOnlineImageExtPb$ResvAttr.string_emoji_marketFaceName.get();
        this.mTemplateId = notOnlineImageExtPb$ResvAttr.string_camera_capture_templateinfo.get();
        this.mTemplateName = notOnlineImageExtPb$ResvAttr.string_camera_capture_materialname.get();
        this.mAdEmoJumpUrl = notOnlineImageExtPb$ResvAttr.string_ad_emo_jump_url.get();
        this.mAdEmoDescStr = notOnlineImageExtPb$ResvAttr.string_ad_emo_desc_str.get();
        if (notOnlineImageExtPb$ResvAttr.msg_zplan_sticker.has()) {
            this.mZPlanPicInfo = ZPlanPicExtraData.parseC2CInfoToZPlanPicExtraData(notOnlineImageExtPb$ResvAttr.msg_zplan_sticker);
        }
        if (notOnlineImageExtPb$ResvAttr.bytes_original_image_md5_new.has()) {
            this.mOriginImageMd5 = notOnlineImageExtPb$ResvAttr.bytes_original_image_md5_new.get().toStringUtf8();
        }
    }
}
