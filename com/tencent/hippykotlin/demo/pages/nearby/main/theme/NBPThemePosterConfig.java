package com.tencent.hippykotlin.demo.pages.nearby.main.theme;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;

/* loaded from: classes31.dex */
public final class NBPThemePosterConfig {
    public static final Companion Companion = new Companion();
    public final String arkFrameUrl;
    public final String arkImageFallbackUrl;
    public final String arkLocFontColor;
    public final String arkTitleFontColor;
    public final String coBuilderTagBgColor;
    public final String coBuilderTagFontColor;
    public final String frameUrl;
    public final String imageFallbackUrl;
    public final String locTagBgColor;
    public final String locTagFontColor;
    public final String locTagIconUrl;
    public final String nicknameFontColor;
    public final String qzoneShareAppId;
    public final String staticQRCodeUrl;
    public final String titleFallbackText;
    public final String titleFontColor;
    public final String wxShareDesc;
    public final String wxShareH5Url;
    public final String wxShareImageFallbackUrl;
    public final String wxShareMyFeedDesc;
    public final String wxShareMyFeedTitle;
    public final String wxShareOtherFeedDesc;
    public final String wxShareOtherFeedTitle;
    public final String wxShareTextBgUrl;
    public final String wxShareTextFontColor;
    public final String wxShareTitle;

    public NBPThemePosterConfig() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 67108863, null);
    }

    public final String getWxShareDesc(String str) {
        Long longOrNull;
        boolean isBlank;
        boolean isBlank2;
        UserDataManager userDataManager = UserDataManager.INSTANCE;
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(str);
        if (userDataManager.isHostTid(longOrNull)) {
            String str2 = this.wxShareMyFeedDesc;
            isBlank2 = StringsKt__StringsJVMKt.isBlank(str2);
            return isBlank2 ? this.wxShareDesc : str2;
        }
        String str3 = this.wxShareOtherFeedDesc;
        isBlank = StringsKt__StringsJVMKt.isBlank(str3);
        return isBlank ? this.wxShareDesc : str3;
    }

    public final String getWxShareH5Url(int i3, String str, String str2) {
        String replace$default;
        String replace$default2;
        String replace$default3;
        String replace$default4;
        replace$default = StringsKt__StringsJVMKt.replace$default(this.wxShareH5Url, "{tinyId}", str, false, 4, (Object) null);
        replace$default2 = StringsKt__StringsJVMKt.replace$default(replace$default, "{openId}", str, false, 4, (Object) null);
        replace$default3 = StringsKt__StringsJVMKt.replace$default(replace$default2, "{feedId}", str2, false, 4, (Object) null);
        replace$default4 = StringsKt__StringsJVMKt.replace$default(replace$default3, "{appId}", String.valueOf(i3), false, 4, (Object) null);
        return replace$default4;
    }

    public final String getWxShareTitle(String str) {
        Long longOrNull;
        boolean isBlank;
        boolean isBlank2;
        UserDataManager userDataManager = UserDataManager.INSTANCE;
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(str);
        if (userDataManager.isHostTid(longOrNull)) {
            String str2 = this.wxShareMyFeedTitle;
            isBlank2 = StringsKt__StringsJVMKt.isBlank(str2);
            return isBlank2 ? this.wxShareTitle : str2;
        }
        String str3 = this.wxShareOtherFeedTitle;
        isBlank = StringsKt__StringsJVMKt.isBlank(str3);
        return isBlank ? this.wxShareTitle : str3;
    }

    public final int hashCode() {
        return this.qzoneShareAppId.hashCode() + BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.staticQRCodeUrl, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.wxShareImageFallbackUrl, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.wxShareTextBgUrl, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.wxShareTextFontColor, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.wxShareH5Url, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.wxShareOtherFeedDesc, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.wxShareOtherFeedTitle, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.wxShareMyFeedDesc, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.wxShareMyFeedTitle, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.wxShareDesc, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.wxShareTitle, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.arkLocFontColor, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.arkTitleFontColor, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.arkImageFallbackUrl, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.arkFrameUrl, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.coBuilderTagBgColor, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.coBuilderTagFontColor, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.locTagBgColor, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.locTagFontColor, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.locTagIconUrl, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.imageFallbackUrl, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.titleFallbackText, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.nicknameFontColor, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.titleFontColor, this.frameUrl.hashCode() * 31, 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31);
    }

    public final String toString() {
        return "NBPThemePosterConfig(frameUrl=" + this.frameUrl + ", titleFontColor=" + this.titleFontColor + ", nicknameFontColor=" + this.nicknameFontColor + ", titleFallbackText=" + this.titleFallbackText + ", imageFallbackUrl=" + this.imageFallbackUrl + ", locTagIconUrl=" + this.locTagIconUrl + ", locTagFontColor=" + this.locTagFontColor + ", locTagBgColor=" + this.locTagBgColor + ", coBuilderTagFontColor=" + this.coBuilderTagFontColor + ", coBuilderTagBgColor=" + this.coBuilderTagBgColor + ", arkFrameUrl=" + this.arkFrameUrl + ", arkImageFallbackUrl=" + this.arkImageFallbackUrl + ", arkTitleFontColor=" + this.arkTitleFontColor + ", arkLocFontColor=" + this.arkLocFontColor + ", wxShareTitle=" + this.wxShareTitle + ", wxShareDesc=" + this.wxShareDesc + ", wxShareMyFeedTitle=" + this.wxShareMyFeedTitle + ", wxShareMyFeedDesc=" + this.wxShareMyFeedDesc + ", wxShareOtherFeedTitle=" + this.wxShareOtherFeedTitle + ", wxShareOtherFeedDesc=" + this.wxShareOtherFeedDesc + ", wxShareH5Url=" + this.wxShareH5Url + ", wxShareTextFontColor=" + this.wxShareTextFontColor + ", wxShareTextBgUrl=" + this.wxShareTextBgUrl + ", wxShareImageFallbackUrl=" + this.wxShareImageFallbackUrl + ", staticQRCodeUrl=" + this.staticQRCodeUrl + ", qzoneShareAppId=" + this.qzoneShareAppId + ')';
    }

    /* loaded from: classes31.dex */
    public static final class Companion {
        public final NBPThemePosterConfig parseJson(e eVar) {
            try {
                return new NBPThemePosterConfig(eVar.p("frame_url"), eVar.p("title_font_color"), eVar.p("nickname_font_color"), eVar.p("title_fallback_text"), eVar.p("image_fallback_url"), eVar.p("loc_tag_icon_url"), eVar.p("loc_tag_font_color"), eVar.p("loc_tag_bg_color"), eVar.p("co_builder_tag_font_color"), eVar.p("co_builder_tag_bg_color"), eVar.p("ark_frame_url"), eVar.q("ark_image_fallback_url", "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_qHoTyUkQvId.png"), eVar.p("ark_title_font_color"), eVar.p("ark_loc_font_color"), eVar.p("wx_share_title"), eVar.p("wx_share_desc"), eVar.p("wx_share_my_feed_title"), eVar.p("wx_share_my_feed_desc"), eVar.p("wx_share_other_feed_title"), eVar.p("wx_share_other_feed_desc"), eVar.p("wx_share_h5_url"), eVar.p("wx_share_text_font_color"), eVar.p("wx_share_text_bg_url"), eVar.p("wx_share_image_fallback_url"), eVar.q("static_qrcode_url", "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_amrtvyb35lu.jpg"), eVar.q("qzone_share_app_id", "qzevent_21"));
            } catch (Exception unused) {
                return null;
            }
        }
    }

    public NBPThemePosterConfig(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, String str24, String str25, String str26) {
        this.frameUrl = str;
        this.titleFontColor = str2;
        this.nicknameFontColor = str3;
        this.titleFallbackText = str4;
        this.imageFallbackUrl = str5;
        this.locTagIconUrl = str6;
        this.locTagFontColor = str7;
        this.locTagBgColor = str8;
        this.coBuilderTagFontColor = str9;
        this.coBuilderTagBgColor = str10;
        this.arkFrameUrl = str11;
        this.arkImageFallbackUrl = str12;
        this.arkTitleFontColor = str13;
        this.arkLocFontColor = str14;
        this.wxShareTitle = str15;
        this.wxShareDesc = str16;
        this.wxShareMyFeedTitle = str17;
        this.wxShareMyFeedDesc = str18;
        this.wxShareOtherFeedTitle = str19;
        this.wxShareOtherFeedDesc = str20;
        this.wxShareH5Url = str21;
        this.wxShareTextFontColor = str22;
        this.wxShareTextBgUrl = str23;
        this.wxShareImageFallbackUrl = str24;
        this.staticQRCodeUrl = str25;
        this.qzoneShareAppId = str26;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NBPThemePosterConfig)) {
            return false;
        }
        NBPThemePosterConfig nBPThemePosterConfig = (NBPThemePosterConfig) obj;
        return Intrinsics.areEqual(this.frameUrl, nBPThemePosterConfig.frameUrl) && Intrinsics.areEqual(this.titleFontColor, nBPThemePosterConfig.titleFontColor) && Intrinsics.areEqual(this.nicknameFontColor, nBPThemePosterConfig.nicknameFontColor) && Intrinsics.areEqual(this.titleFallbackText, nBPThemePosterConfig.titleFallbackText) && Intrinsics.areEqual(this.imageFallbackUrl, nBPThemePosterConfig.imageFallbackUrl) && Intrinsics.areEqual(this.locTagIconUrl, nBPThemePosterConfig.locTagIconUrl) && Intrinsics.areEqual(this.locTagFontColor, nBPThemePosterConfig.locTagFontColor) && Intrinsics.areEqual(this.locTagBgColor, nBPThemePosterConfig.locTagBgColor) && Intrinsics.areEqual(this.coBuilderTagFontColor, nBPThemePosterConfig.coBuilderTagFontColor) && Intrinsics.areEqual(this.coBuilderTagBgColor, nBPThemePosterConfig.coBuilderTagBgColor) && Intrinsics.areEqual(this.arkFrameUrl, nBPThemePosterConfig.arkFrameUrl) && Intrinsics.areEqual(this.arkImageFallbackUrl, nBPThemePosterConfig.arkImageFallbackUrl) && Intrinsics.areEqual(this.arkTitleFontColor, nBPThemePosterConfig.arkTitleFontColor) && Intrinsics.areEqual(this.arkLocFontColor, nBPThemePosterConfig.arkLocFontColor) && Intrinsics.areEqual(this.wxShareTitle, nBPThemePosterConfig.wxShareTitle) && Intrinsics.areEqual(this.wxShareDesc, nBPThemePosterConfig.wxShareDesc) && Intrinsics.areEqual(this.wxShareMyFeedTitle, nBPThemePosterConfig.wxShareMyFeedTitle) && Intrinsics.areEqual(this.wxShareMyFeedDesc, nBPThemePosterConfig.wxShareMyFeedDesc) && Intrinsics.areEqual(this.wxShareOtherFeedTitle, nBPThemePosterConfig.wxShareOtherFeedTitle) && Intrinsics.areEqual(this.wxShareOtherFeedDesc, nBPThemePosterConfig.wxShareOtherFeedDesc) && Intrinsics.areEqual(this.wxShareH5Url, nBPThemePosterConfig.wxShareH5Url) && Intrinsics.areEqual(this.wxShareTextFontColor, nBPThemePosterConfig.wxShareTextFontColor) && Intrinsics.areEqual(this.wxShareTextBgUrl, nBPThemePosterConfig.wxShareTextBgUrl) && Intrinsics.areEqual(this.wxShareImageFallbackUrl, nBPThemePosterConfig.wxShareImageFallbackUrl) && Intrinsics.areEqual(this.staticQRCodeUrl, nBPThemePosterConfig.staticQRCodeUrl) && Intrinsics.areEqual(this.qzoneShareAppId, nBPThemePosterConfig.qzoneShareAppId);
    }

    public /* synthetic */ NBPThemePosterConfig(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, String str24, String str25, String str26, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "");
    }
}
