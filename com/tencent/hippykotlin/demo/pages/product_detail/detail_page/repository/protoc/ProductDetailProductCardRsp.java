package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc;

import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.QQAudioParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.hippykotlin.demo.pages.base.ISSOModelFactory;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class ProductDetailProductCardRsp implements ISSOModel {
    public static final ISSOModelFactory<ProductDetailProductCardRsp> Factory = new ProductDetailProductCardRsp$Companion$Factory$1();
    public final ProductDetailActiveInfo activeInfo;
    public final int bizType;
    public final ProductDetailBulletin bulletin;
    public final ProductDetailButton button;
    public final ProductDetailDeliveryInfo deliveryInfo;
    public final boolean hideShare;
    public final ProductDetailProduct product;
    public final ProductDetailShop shop;
    public final ProductDetailService shopService;
    public final String spuId;
    public final int status;
    public final ProductDetailUserRight userRight;

    public ProductDetailProductCardRsp() {
        this(null, 0, 0, false, null, null, null, null, null, null, null, null, 4095, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.v("spu_id", this.spuId);
        eVar.t("biz_type", this.bizType);
        eVar.t("status", this.status);
        eVar.w("hide_share", this.hideShare);
        ProductDetailProduct productDetailProduct = this.product;
        if (productDetailProduct != null) {
            eVar.v("product", productDetailProduct.encode());
        }
        ProductDetailShop productDetailShop = this.shop;
        if (productDetailShop != null) {
            eVar.v("shop", productDetailShop.encode());
        }
        ProductDetailService productDetailService = this.shopService;
        if (productDetailService != null) {
            eVar.v("shop_service", productDetailService.encode());
        }
        ProductDetailButton productDetailButton = this.button;
        if (productDetailButton != null) {
            eVar.v("button", productDetailButton.encode());
        }
        ProductDetailBulletin productDetailBulletin = this.bulletin;
        if (productDetailBulletin != null) {
            eVar.v("bulletin", productDetailBulletin.encode());
        }
        ProductDetailUserRight productDetailUserRight = this.userRight;
        if (productDetailUserRight != null) {
            eVar.v("user_right", productDetailUserRight.encode());
        }
        ProductDetailActiveInfo productDetailActiveInfo = this.activeInfo;
        if (productDetailActiveInfo != null) {
            eVar.v("active_info", productDetailActiveInfo.encode());
        }
        ProductDetailDeliveryInfo productDetailDeliveryInfo = this.deliveryInfo;
        if (productDetailDeliveryInfo != null) {
            eVar.v("delivery_info", productDetailDeliveryInfo.encode());
        }
        return eVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int m3 = QQAudioParams$$ExternalSyntheticOutline0.m(this.status, QQAudioParams$$ExternalSyntheticOutline0.m(this.bizType, this.spuId.hashCode() * 31, 31), 31);
        boolean z16 = this.hideShare;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (m3 + i3) * 31;
        ProductDetailProduct productDetailProduct = this.product;
        int hashCode = (i16 + (productDetailProduct == null ? 0 : productDetailProduct.hashCode())) * 31;
        ProductDetailShop productDetailShop = this.shop;
        int hashCode2 = (hashCode + (productDetailShop == null ? 0 : productDetailShop.hashCode())) * 31;
        ProductDetailService productDetailService = this.shopService;
        int hashCode3 = (hashCode2 + (productDetailService == null ? 0 : productDetailService.hashCode())) * 31;
        ProductDetailButton productDetailButton = this.button;
        int hashCode4 = (hashCode3 + (productDetailButton == null ? 0 : productDetailButton.hashCode())) * 31;
        ProductDetailBulletin productDetailBulletin = this.bulletin;
        int hashCode5 = (hashCode4 + (productDetailBulletin == null ? 0 : productDetailBulletin.hashCode())) * 31;
        ProductDetailUserRight productDetailUserRight = this.userRight;
        int hashCode6 = (hashCode5 + (productDetailUserRight == null ? 0 : productDetailUserRight.hashCode())) * 31;
        ProductDetailActiveInfo productDetailActiveInfo = this.activeInfo;
        int hashCode7 = (hashCode6 + (productDetailActiveInfo == null ? 0 : productDetailActiveInfo.hashCode())) * 31;
        ProductDetailDeliveryInfo productDetailDeliveryInfo = this.deliveryInfo;
        return hashCode7 + (productDetailDeliveryInfo != null ? productDetailDeliveryInfo.hashCode() : 0);
    }

    public final String toString() {
        return "ProductDetailProductCardRsp(spuId=" + this.spuId + ", bizType=" + this.bizType + ", status=" + this.status + ", hideShare=" + this.hideShare + ", product=" + this.product + ", shop=" + this.shop + ", shopService=" + this.shopService + ", button=" + this.button + ", bulletin=" + this.bulletin + ", userRight=" + this.userRight + ", activeInfo=" + this.activeInfo + ", deliveryInfo=" + this.deliveryInfo + ')';
    }

    public ProductDetailProductCardRsp(String str, int i3, int i16, boolean z16, ProductDetailProduct productDetailProduct, ProductDetailShop productDetailShop, ProductDetailService productDetailService, ProductDetailButton productDetailButton, ProductDetailBulletin productDetailBulletin, ProductDetailUserRight productDetailUserRight, ProductDetailActiveInfo productDetailActiveInfo, ProductDetailDeliveryInfo productDetailDeliveryInfo) {
        this.spuId = str;
        this.bizType = i3;
        this.status = i16;
        this.hideShare = z16;
        this.product = productDetailProduct;
        this.shop = productDetailShop;
        this.shopService = productDetailService;
        this.button = productDetailButton;
        this.bulletin = productDetailBulletin;
        this.userRight = productDetailUserRight;
        this.activeInfo = productDetailActiveInfo;
        this.deliveryInfo = productDetailDeliveryInfo;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductDetailProductCardRsp)) {
            return false;
        }
        ProductDetailProductCardRsp productDetailProductCardRsp = (ProductDetailProductCardRsp) obj;
        return Intrinsics.areEqual(this.spuId, productDetailProductCardRsp.spuId) && this.bizType == productDetailProductCardRsp.bizType && this.status == productDetailProductCardRsp.status && this.hideShare == productDetailProductCardRsp.hideShare && Intrinsics.areEqual(this.product, productDetailProductCardRsp.product) && Intrinsics.areEqual(this.shop, productDetailProductCardRsp.shop) && Intrinsics.areEqual(this.shopService, productDetailProductCardRsp.shopService) && Intrinsics.areEqual(this.button, productDetailProductCardRsp.button) && Intrinsics.areEqual(this.bulletin, productDetailProductCardRsp.bulletin) && Intrinsics.areEqual(this.userRight, productDetailProductCardRsp.userRight) && Intrinsics.areEqual(this.activeInfo, productDetailProductCardRsp.activeInfo) && Intrinsics.areEqual(this.deliveryInfo, productDetailProductCardRsp.deliveryInfo);
    }

    public /* synthetic */ ProductDetailProductCardRsp(String str, int i3, int i16, boolean z16, ProductDetailProduct productDetailProduct, ProductDetailShop productDetailShop, ProductDetailService productDetailService, ProductDetailButton productDetailButton, ProductDetailBulletin productDetailBulletin, ProductDetailUserRight productDetailUserRight, ProductDetailActiveInfo productDetailActiveInfo, ProductDetailDeliveryInfo productDetailDeliveryInfo, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this("", 0, 0, false, null, null, null, null, null, null, null, null);
    }
}
