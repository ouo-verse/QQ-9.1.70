package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.QQAudioParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.hippykotlin.demo.pages.base.ISSOModelFactory;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class SellerProductCardRsp implements ISSOModel {
    public static final ISSOModelFactory<SellerProductCardRsp> Factory = new SellerProductCardRsp$Companion$Factory$1();
    public final int bizType;
    public final DeliveryInfo deliveryInfo;
    public boolean isAdd;
    public final boolean isSample;
    public final ArrayList<ProductDetailLabelInfo> labels;
    public final ArrayList<ProductDetailLabelInfo> prodTags;
    public final Product product;
    public final Promote promote;
    public final ArrayList<String> ruleDesc;
    public final Shop shop;
    public final Service shopService;
    public final String source;
    public final String spuId;
    public final int status;
    public final String url;

    public SellerProductCardRsp() {
        this(null, 0, 0, null, null, null, null, null, null, null, null, false, false, null, null, 32767, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.v("spu_id", this.spuId);
        eVar.t("biz_type", this.bizType);
        eVar.t("status", this.status);
        Product product = this.product;
        if (product != null) {
            eVar.v("product", product.encode());
        }
        b bVar = new b();
        ArrayList<ProductDetailLabelInfo> arrayList = this.labels;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                bVar.t(((ProductDetailLabelInfo) it.next()).encode());
            }
        }
        eVar.v("labels", bVar);
        eVar.v("source", this.source);
        eVar.v("url", this.url);
        Shop shop = this.shop;
        if (shop != null) {
            eVar.v("shop", shop.encode());
        }
        Service service = this.shopService;
        if (service != null) {
            eVar.v("shop_service", service.encode());
        }
        b bVar2 = new b();
        ArrayList<ProductDetailLabelInfo> arrayList2 = this.prodTags;
        if (arrayList2 != null) {
            Iterator<T> it5 = arrayList2.iterator();
            while (it5.hasNext()) {
                bVar2.t(((ProductDetailLabelInfo) it5.next()).encode());
            }
        }
        eVar.v("prod_tags", bVar2);
        Promote promote = this.promote;
        if (promote != null) {
            eVar.v(WinkDaTongReportConstant.ElementParamValue.XSJ_BANNER_TYPE_PROMOTE, promote.encode());
        }
        eVar.w("is_add", this.isAdd);
        eVar.w("is_sample", this.isSample);
        b bVar3 = new b();
        ArrayList<String> arrayList3 = this.ruleDesc;
        if (arrayList3 != null) {
            Iterator<T> it6 = arrayList3.iterator();
            while (it6.hasNext()) {
                bVar3.t((String) it6.next());
            }
        }
        eVar.v("rule_desc", bVar3);
        DeliveryInfo deliveryInfo = this.deliveryInfo;
        if (deliveryInfo != null) {
            eVar.v("delivery_info", deliveryInfo.encode());
        }
        return eVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int m3 = QQAudioParams$$ExternalSyntheticOutline0.m(this.status, QQAudioParams$$ExternalSyntheticOutline0.m(this.bizType, this.spuId.hashCode() * 31, 31), 31);
        Product product = this.product;
        int hashCode = (m3 + (product == null ? 0 : product.hashCode())) * 31;
        ArrayList<ProductDetailLabelInfo> arrayList = this.labels;
        int m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.url, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.source, (hashCode + (arrayList == null ? 0 : arrayList.hashCode())) * 31, 31), 31);
        Shop shop = this.shop;
        int hashCode2 = (m16 + (shop == null ? 0 : shop.hashCode())) * 31;
        Service service = this.shopService;
        int hashCode3 = (hashCode2 + (service == null ? 0 : service.hashCode())) * 31;
        ArrayList<ProductDetailLabelInfo> arrayList2 = this.prodTags;
        int hashCode4 = (hashCode3 + (arrayList2 == null ? 0 : arrayList2.hashCode())) * 31;
        Promote promote = this.promote;
        int hashCode5 = (hashCode4 + (promote == null ? 0 : promote.hashCode())) * 31;
        boolean z16 = this.isAdd;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (hashCode5 + i3) * 31;
        boolean z17 = this.isSample;
        int i17 = (i16 + (z17 ? 1 : z17 ? 1 : 0)) * 31;
        ArrayList<String> arrayList3 = this.ruleDesc;
        int hashCode6 = (i17 + (arrayList3 == null ? 0 : arrayList3.hashCode())) * 31;
        DeliveryInfo deliveryInfo = this.deliveryInfo;
        return hashCode6 + (deliveryInfo != null ? deliveryInfo.hashCode() : 0);
    }

    public final String toString() {
        return "SellerProductCardRsp(spuId=" + this.spuId + ", bizType=" + this.bizType + ", status=" + this.status + ", product=" + this.product + ", labels=" + this.labels + ", source=" + this.source + ", url=" + this.url + ", shop=" + this.shop + ", shopService=" + this.shopService + ", prodTags=" + this.prodTags + ", promote=" + this.promote + ", isAdd=" + this.isAdd + ", isSample=" + this.isSample + ", ruleDesc=" + this.ruleDesc + ", deliveryInfo=" + this.deliveryInfo + ')';
    }

    public SellerProductCardRsp(String str, int i3, int i16, Product product, ArrayList<ProductDetailLabelInfo> arrayList, String str2, String str3, Shop shop, Service service, ArrayList<ProductDetailLabelInfo> arrayList2, Promote promote, boolean z16, boolean z17, ArrayList<String> arrayList3, DeliveryInfo deliveryInfo) {
        this.spuId = str;
        this.bizType = i3;
        this.status = i16;
        this.product = product;
        this.labels = arrayList;
        this.source = str2;
        this.url = str3;
        this.shop = shop;
        this.shopService = service;
        this.prodTags = arrayList2;
        this.promote = promote;
        this.isAdd = z16;
        this.isSample = z17;
        this.ruleDesc = arrayList3;
        this.deliveryInfo = deliveryInfo;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SellerProductCardRsp)) {
            return false;
        }
        SellerProductCardRsp sellerProductCardRsp = (SellerProductCardRsp) obj;
        return Intrinsics.areEqual(this.spuId, sellerProductCardRsp.spuId) && this.bizType == sellerProductCardRsp.bizType && this.status == sellerProductCardRsp.status && Intrinsics.areEqual(this.product, sellerProductCardRsp.product) && Intrinsics.areEqual(this.labels, sellerProductCardRsp.labels) && Intrinsics.areEqual(this.source, sellerProductCardRsp.source) && Intrinsics.areEqual(this.url, sellerProductCardRsp.url) && Intrinsics.areEqual(this.shop, sellerProductCardRsp.shop) && Intrinsics.areEqual(this.shopService, sellerProductCardRsp.shopService) && Intrinsics.areEqual(this.prodTags, sellerProductCardRsp.prodTags) && Intrinsics.areEqual(this.promote, sellerProductCardRsp.promote) && this.isAdd == sellerProductCardRsp.isAdd && this.isSample == sellerProductCardRsp.isSample && Intrinsics.areEqual(this.ruleDesc, sellerProductCardRsp.ruleDesc) && Intrinsics.areEqual(this.deliveryInfo, sellerProductCardRsp.deliveryInfo);
    }

    public /* synthetic */ SellerProductCardRsp(String str, int i3, int i16, Product product, ArrayList arrayList, String str2, String str3, Shop shop, Service service, ArrayList arrayList2, Promote promote, boolean z16, boolean z17, ArrayList arrayList3, DeliveryInfo deliveryInfo, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this("", 0, 0, null, null, "", "", null, null, null, null, false, false, null, null);
    }
}
