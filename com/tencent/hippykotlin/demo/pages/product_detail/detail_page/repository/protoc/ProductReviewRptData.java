package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class ProductReviewRptData implements ISSOModel {
    public static final Companion Companion = new Companion();
    public final ProductReviewAtData atData;
    public final int dataType;
    public final ProductReviewEmojiData emojiData;
    public final ProductReviewHrefData hrefData;
    public final ProductReviewTextData textData;

    public ProductReviewRptData() {
        this(0, null, null, null, null, 31, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.t("data_type", this.dataType);
        ProductReviewTextData productReviewTextData = this.textData;
        if (productReviewTextData != null) {
            eVar.v("text_data", productReviewTextData.encode());
        }
        ProductReviewEmojiData productReviewEmojiData = this.emojiData;
        if (productReviewEmojiData != null) {
            eVar.v("emoji_data", productReviewEmojiData.encode());
        }
        ProductReviewHrefData productReviewHrefData = this.hrefData;
        if (productReviewHrefData != null) {
            eVar.v("href_data", productReviewHrefData.encode());
        }
        ProductReviewAtData productReviewAtData = this.atData;
        if (productReviewAtData != null) {
            eVar.v("at_data", productReviewAtData.encode());
        }
        return eVar;
    }

    public final int hashCode() {
        int i3 = this.dataType * 31;
        ProductReviewTextData productReviewTextData = this.textData;
        int hashCode = (i3 + (productReviewTextData == null ? 0 : productReviewTextData.content.hashCode())) * 31;
        ProductReviewEmojiData productReviewEmojiData = this.emojiData;
        int hashCode2 = (hashCode + (productReviewEmojiData == null ? 0 : productReviewEmojiData.emoji.hashCode())) * 31;
        ProductReviewHrefData productReviewHrefData = this.hrefData;
        int hashCode3 = (hashCode2 + (productReviewHrefData == null ? 0 : productReviewHrefData.hashCode())) * 31;
        ProductReviewAtData productReviewAtData = this.atData;
        return hashCode3 + (productReviewAtData != null ? productReviewAtData.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ProductReviewRptData(dataType=");
        m3.append(this.dataType);
        m3.append(", textData=");
        m3.append(this.textData);
        m3.append(", emojiData=");
        m3.append(this.emojiData);
        m3.append(", hrefData=");
        m3.append(this.hrefData);
        m3.append(", atData=");
        m3.append(this.atData);
        m3.append(')');
        return m3.toString();
    }

    /* loaded from: classes31.dex */
    public static final class Companion {
        public final ProductReviewRptData decode(e eVar) {
            int k3 = eVar.k("data_type", 0);
            e m3 = eVar.m("text_data");
            ProductReviewTextData productReviewTextData = m3 != null ? new ProductReviewTextData(m3.q("content", "")) : null;
            e m16 = eVar.m("emoji_data");
            ProductReviewEmojiData productReviewEmojiData = m16 != null ? new ProductReviewEmojiData(m16.q("emoji", "")) : null;
            e m17 = eVar.m("href_data");
            ProductReviewHrefData productReviewHrefData = m17 != null ? new ProductReviewHrefData(m17.q("content", ""), m17.q("url", ""), m17.q("topic_id", "")) : null;
            e m18 = eVar.m("at_data");
            return new ProductReviewRptData(k3, productReviewTextData, productReviewEmojiData, productReviewHrefData, m18 != null ? new ProductReviewAtData(m18.q("uid", ""), m18.q(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME, ""), m18.q("avatar", ""), m18.q("homepage", ""), m18.q("content", "")) : null);
        }
    }

    public ProductReviewRptData(int i3, ProductReviewTextData productReviewTextData, ProductReviewEmojiData productReviewEmojiData, ProductReviewHrefData productReviewHrefData, ProductReviewAtData productReviewAtData) {
        this.dataType = i3;
        this.textData = productReviewTextData;
        this.emojiData = productReviewEmojiData;
        this.hrefData = productReviewHrefData;
        this.atData = productReviewAtData;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductReviewRptData)) {
            return false;
        }
        ProductReviewRptData productReviewRptData = (ProductReviewRptData) obj;
        return this.dataType == productReviewRptData.dataType && Intrinsics.areEqual(this.textData, productReviewRptData.textData) && Intrinsics.areEqual(this.emojiData, productReviewRptData.emojiData) && Intrinsics.areEqual(this.hrefData, productReviewRptData.hrefData) && Intrinsics.areEqual(this.atData, productReviewRptData.atData);
    }

    public /* synthetic */ ProductReviewRptData(int i3, ProductReviewTextData productReviewTextData, ProductReviewEmojiData productReviewEmojiData, ProductReviewHrefData productReviewHrefData, ProductReviewAtData productReviewAtData, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, null, null, null, null);
    }
}
