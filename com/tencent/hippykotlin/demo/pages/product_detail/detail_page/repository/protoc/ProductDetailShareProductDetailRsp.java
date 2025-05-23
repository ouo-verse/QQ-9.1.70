package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.hippykotlin.demo.pages.base.ISSOModelFactory;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class ProductDetailShareProductDetailRsp implements ISSOModel {
    public static final ISSOModelFactory<ProductDetailShareProductDetailRsp> Factory = new ISSOModelFactory<ProductDetailShareProductDetailRsp>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailShareProductDetailRsp$Companion$Factory$1
        @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModelFactory
        public final ProductDetailShareProductDetailRsp decode(e eVar) {
            return new ProductDetailShareProductDetailRsp(eVar.q("share_info", ""), eVar.q("pic_url", ""), eVar.q("title", ""), eVar.q("desc", ""), eVar.q("jump_url", ""));
        }
    };
    public final String desc;
    public final String jump_url;
    public final String pic_url;
    public final String share_info;
    public final String title;

    public ProductDetailShareProductDetailRsp() {
        this(null, null, null, null, null, 31, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.v("share_info", this.share_info);
        eVar.v("pic_url", this.pic_url);
        eVar.v("title", this.title);
        eVar.v("desc", this.desc);
        eVar.v("jump_url", this.jump_url);
        return eVar;
    }

    public final int hashCode() {
        return this.jump_url.hashCode() + BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.desc, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.title, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.pic_url, this.share_info.hashCode() * 31, 31), 31), 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ProductDetailShareProductDetailRsp(share_info=");
        m3.append(this.share_info);
        m3.append(", pic_url=");
        m3.append(this.pic_url);
        m3.append(", title=");
        m3.append(this.title);
        m3.append(", desc=");
        m3.append(this.desc);
        m3.append(", jump_url=");
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.jump_url, ')');
    }

    public ProductDetailShareProductDetailRsp(String str, String str2, String str3, String str4, String str5) {
        this.share_info = str;
        this.pic_url = str2;
        this.title = str3;
        this.desc = str4;
        this.jump_url = str5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductDetailShareProductDetailRsp)) {
            return false;
        }
        ProductDetailShareProductDetailRsp productDetailShareProductDetailRsp = (ProductDetailShareProductDetailRsp) obj;
        return Intrinsics.areEqual(this.share_info, productDetailShareProductDetailRsp.share_info) && Intrinsics.areEqual(this.pic_url, productDetailShareProductDetailRsp.pic_url) && Intrinsics.areEqual(this.title, productDetailShareProductDetailRsp.title) && Intrinsics.areEqual(this.desc, productDetailShareProductDetailRsp.desc) && Intrinsics.areEqual(this.jump_url, productDetailShareProductDetailRsp.jump_url);
    }

    public /* synthetic */ ProductDetailShareProductDetailRsp(String str, String str2, String str3, String str4, String str5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "", "", "", "");
    }
}
