package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.coupon;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterViewModel$fetchEditSwitchSetting$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.lib.vas_report_utils.VasBusinessReportData$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.SchemeParamExtensionKt;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailLabelInfo;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailPrice;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailProduct;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailProductCardRsp;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailShop;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.shop.ProductDetailShopRepository;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.shop.model.ProductDetailInfo;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailCardAttr;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailEvent;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.ProductDetailCardBaseViewModel;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import defpackage.j;
import java.util.ArrayList;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.Typography;

/* loaded from: classes31.dex */
public final class ProductDetailShopCouponViewModel extends ProductDetailCardBaseViewModel implements IProductDetailCouponViewModel {
    public final ProductDetailInfo info;
    public final e params;

    public ProductDetailShopCouponViewModel(e eVar, boolean z16) {
        super(z16);
        this.params = eVar;
        this.info = ProductDetailShopRepository.INSTANCE.getProductInfoCache(SchemeParamExtensionKt.schemeSpuId(eVar));
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.coupon.IProductDetailCouponViewModel
    public final ArrayList<ProductDetailLabelInfo> couponList() {
        ProductDetailProductCardRsp productDetailProductCardRsp;
        ProductDetailProduct productDetailProduct;
        ArrayList<ProductDetailLabelInfo> arrayList;
        ArrayList<ProductDetailLabelInfo> arrayList2 = new ArrayList<>();
        ProductDetailInfo productDetailInfo = this.info;
        return (productDetailInfo == null || (productDetailProductCardRsp = productDetailInfo.detail) == null || (productDetailProduct = productDetailProductCardRsp.product) == null || (arrayList = productDetailProduct.prodTags) == null) ? arrayList2 : arrayList;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailCardViewModel
    public final ComposeView<ProductDetailCardAttr, ProductDetailEvent> getCardView() {
        return new ProductDetailShopCouponView();
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x00af, code lost:
    
        if ((r2.length() == 0) != false) goto L62;
     */
    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.coupon.IProductDetailCouponViewModel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onTap() {
        String str;
        String str2;
        boolean contains$default;
        ProductDetailProductCardRsp productDetailProductCardRsp;
        ProductDetailProduct productDetailProduct;
        ProductDetailPrice productDetailPrice;
        ProductDetailProductCardRsp productDetailProductCardRsp2;
        ProductDetailProduct productDetailProduct2;
        ProductDetailPrice productDetailPrice2;
        ProductDetailProductCardRsp productDetailProductCardRsp3;
        ProductDetailShop productDetailShop;
        ProductDetailShopRepository productDetailShopRepository = ProductDetailShopRepository.INSTANCE;
        ProductDetailInfo detailInfo = ProductDetailShopRepository.cache.getDetailInfo(this.params.p("spu_id"));
        String p16 = this.params.p("spu_id");
        String str3 = "";
        if (detailInfo == null || (productDetailProductCardRsp3 = detailInfo.detail) == null || (productDetailShop = productDetailProductCardRsp3.shop) == null || (str = productDetailShop.f114242id) == null) {
            str = "";
        }
        if (detailInfo == null || (productDetailProductCardRsp2 = detailInfo.detail) == null || (productDetailProduct2 = productDetailProductCardRsp2.product) == null || (productDetailPrice2 = productDetailProduct2.price) == null || (str2 = productDetailPrice2.discountPriceTxt) == null) {
            str2 = "";
        }
        if ((str2.length() == 0) && (detailInfo == null || (productDetailProductCardRsp = detailInfo.detail) == null || (productDetailProduct = productDetailProductCardRsp.product) == null || (productDetailPrice = productDetailProduct.price) == null || (str2 = productDetailPrice.priceTxt) == null)) {
            str2 = "";
        }
        int k3 = this.params.k(WadlProxyConsts.CHANNEL, 0);
        String q16 = this.params.q("ext", "");
        if (q16.length() > 0) {
            str3 = new e(q16).p("seller_media_id");
        }
        if (!(str.length() == 0)) {
            if (!(p16.length() == 0)) {
                if (!(str2.length() == 0)) {
                }
            }
        }
        KLog kLog = KLog.INSTANCE;
        StringBuilder a16 = j.a("Coupon page scheme generate error! shopId:", str, ", spuId:", p16, ", price:");
        a16.append(str2);
        a16.append(", mediaId:");
        a16.append(str3);
        kLog.e("KTVShopDetail", a16.toString());
        StringBuilder sb5 = new StringBuilder(OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0.m(VasBusinessReportData$$ExternalSyntheticOutline0.m(AdelieManagerCenterViewModel$fetchEditSwitchSetting$1$$ExternalSyntheticOutline0.m("mqqapi://ecommerce/open?target=52&channel=", k3, "&page_name=obtain_coupon_page&from=1&shop_id=", str, "&spu_id="), p16, "&minimum_price=", str2, "&media_id="), str3, "&scene=1&modal_mode=1"));
        String schemeAmsClickID = SchemeParamExtensionKt.schemeAmsClickID(this.params);
        if (schemeAmsClickID.length() > 0) {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) sb5, (CharSequence) "qz_gdt", false, 2, (Object) null);
            if (!contains$default) {
                sb5.append(Typography.amp + "qz_gdt=" + schemeAmsClickID);
            }
        }
        BridgeModule.openPage$default(Utils.INSTANCE.currentBridgeModule(), sb5.toString(), false, null, null, 30);
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.coupon.IProductDetailCouponViewModel
    public final boolean shouldShow() {
        ProductDetailProductCardRsp productDetailProductCardRsp;
        ProductDetailProduct productDetailProduct;
        ArrayList<ProductDetailLabelInfo> arrayList;
        ProductDetailInfo productDetailInfo = this.info;
        return (productDetailInfo == null || (productDetailProductCardRsp = productDetailInfo.detail) == null || (productDetailProduct = productDetailProductCardRsp.product) == null || (arrayList = productDetailProduct.prodTags) == null || !(arrayList.isEmpty() ^ true)) ? false : true;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.coupon.IProductDetailCouponViewModel
    public final boolean showGetCouponBtn() {
        return true;
    }
}
