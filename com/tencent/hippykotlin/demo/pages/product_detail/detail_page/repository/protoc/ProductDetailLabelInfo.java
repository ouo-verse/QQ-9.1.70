package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc;

import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.QQAudioParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class ProductDetailLabelInfo implements ISSOModel {
    public final String backgroundColor;
    public final String borderColor;
    public final int height;
    public final String picToken;
    public final String picUrl;
    public final String text;
    public final String textColor;
    public final String textPrefix;
    public final int textStyleType;
    public final int width;

    public ProductDetailLabelInfo() {
        this(null, null, null, null, 0, null, null, 0, 0, null, 1023, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.v("background_color", this.backgroundColor);
        eVar.v("text_color", this.textColor);
        eVar.v("text", this.text);
        eVar.v("text_prefix", this.textPrefix);
        eVar.t("text_style_type", this.textStyleType);
        eVar.v(LayoutAttrDefine.BorderColor, this.borderColor);
        eVar.v("pic_url", this.picUrl);
        eVar.t("width", this.width);
        eVar.t("height", this.height);
        eVar.v("pic_token", this.picToken);
        return eVar;
    }

    public final int hashCode() {
        return this.picToken.hashCode() + QQAudioParams$$ExternalSyntheticOutline0.m(this.height, QQAudioParams$$ExternalSyntheticOutline0.m(this.width, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.picUrl, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.borderColor, QQAudioParams$$ExternalSyntheticOutline0.m(this.textStyleType, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.textPrefix, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.text, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.textColor, this.backgroundColor.hashCode() * 31, 31), 31), 31), 31), 31), 31), 31), 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ProductDetailLabelInfo(backgroundColor=");
        m3.append(this.backgroundColor);
        m3.append(", textColor=");
        m3.append(this.textColor);
        m3.append(", text=");
        m3.append(this.text);
        m3.append(", textPrefix=");
        m3.append(this.textPrefix);
        m3.append(", textStyleType=");
        m3.append(this.textStyleType);
        m3.append(", borderColor=");
        m3.append(this.borderColor);
        m3.append(", picUrl=");
        m3.append(this.picUrl);
        m3.append(", width=");
        m3.append(this.width);
        m3.append(", height=");
        m3.append(this.height);
        m3.append(", picToken=");
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.picToken, ')');
    }

    public ProductDetailLabelInfo(String str, String str2, String str3, String str4, int i3, String str5, String str6, int i16, int i17, String str7) {
        this.backgroundColor = str;
        this.textColor = str2;
        this.text = str3;
        this.textPrefix = str4;
        this.textStyleType = i3;
        this.borderColor = str5;
        this.picUrl = str6;
        this.width = i16;
        this.height = i17;
        this.picToken = str7;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductDetailLabelInfo)) {
            return false;
        }
        ProductDetailLabelInfo productDetailLabelInfo = (ProductDetailLabelInfo) obj;
        return Intrinsics.areEqual(this.backgroundColor, productDetailLabelInfo.backgroundColor) && Intrinsics.areEqual(this.textColor, productDetailLabelInfo.textColor) && Intrinsics.areEqual(this.text, productDetailLabelInfo.text) && Intrinsics.areEqual(this.textPrefix, productDetailLabelInfo.textPrefix) && this.textStyleType == productDetailLabelInfo.textStyleType && Intrinsics.areEqual(this.borderColor, productDetailLabelInfo.borderColor) && Intrinsics.areEqual(this.picUrl, productDetailLabelInfo.picUrl) && this.width == productDetailLabelInfo.width && this.height == productDetailLabelInfo.height && Intrinsics.areEqual(this.picToken, productDetailLabelInfo.picToken);
    }

    public /* synthetic */ ProductDetailLabelInfo(String str, String str2, String str3, String str4, int i3, String str5, String str6, int i16, int i17, String str7, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "", "", "", 0, "", "", 0, 0, "");
    }
}
