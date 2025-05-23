package com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.viewModel;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.CommonCouponItemModel;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service.ShopCouponCouponShowStyleInfo;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service.ShopCouponShowDiscount;
import com.tencent.kuikly.core.base.BaseObject;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Unit;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class MyCouponListItemViewModel extends BaseObject implements IMyCouponListItemViewModel {
    public final int config;
    public final String couponBatchId;
    public final String couponId;
    public final String couponUrl;
    public final ShopCouponCouponShowStyleInfo info;
    public final String pagerId;

    public MyCouponListItemViewModel(String str, String str2, String str3, String str4, ShopCouponCouponShowStyleInfo shopCouponCouponShowStyleInfo, int i3) {
        this.pagerId = str;
        this.couponBatchId = str2;
        this.couponId = str3;
        this.couponUrl = str4;
        this.info = shopCouponCouponShowStyleInfo;
        this.config = i3;
    }

    @Override // com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.viewModel.IMyCouponListItemViewModel
    public final void clickItem() {
        if (MyCouponListItemConfig$EnumUnboxingLocalUtility.getEnabled(this.config)) {
            Utils utils = Utils.INSTANCE;
            BridgeModule.openPage$default(utils.bridgeModule(this.pagerId), this.couponUrl, false, null, null, 30);
            String str = this.pagerId;
            utils.bridgeModule(str).log(LoadFailParams$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("[MyCouponList] jump to use coupon. [url:"), this.couponUrl, ']'));
        } else {
            Utils utils2 = Utils.INSTANCE;
            String str2 = this.pagerId;
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("[MyCouponList] can`t to use coupon, because the coupon invalid. [state:");
            m3.append(MyCouponListItemConfig$EnumUnboxingLocalUtility.name(this.config));
            m3.append(']');
            utils2.bridgeModule(str2).log(m3.toString());
        }
        String str3 = this.couponBatchId;
        BridgeModule bridgeModule = Utils.INSTANCE.bridgeModule(BridgeManager.f117344a.u());
        e m16 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("related_batch_coupon_id", str3);
        Unit unit = Unit.INSTANCE;
        bridgeModule.reportDT("ds_my_coupon_use_clk", m16);
    }

    @Override // com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.viewModel.IMyCouponListItemViewModel
    public final CommonCouponItemModel couponItemModel() {
        String str;
        String str2;
        String str3 = this.couponId;
        ShopCouponCouponShowStyleInfo shopCouponCouponShowStyleInfo = this.info;
        String str4 = shopCouponCouponShowStyleInfo.couponTypeName;
        ShopCouponShowDiscount shopCouponShowDiscount = shopCouponCouponShowStyleInfo.couponShowDiscount;
        String str5 = "";
        if (shopCouponShowDiscount == null || (str = shopCouponShowDiscount.discountAmount) == null) {
            str = "";
        }
        if (shopCouponShowDiscount != null && (str2 = shopCouponShowDiscount.discountThreshold) != null) {
            str5 = str2;
        }
        return new CommonCouponItemModel(str3, str4, str, str5, shopCouponCouponShowStyleInfo.couponIssuerName, shopCouponCouponShowStyleInfo.couponUsableRange, shopCouponCouponShowStyleInfo.couponTimeScope, MyCouponListItemConfig$EnumUnboxingLocalUtility.getEnabled(this.config));
    }

    @Override // com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.viewModel.IMyCouponListItemViewModel
    public final boolean isCanUseCoupon() {
        return MyCouponListItemConfig$EnumUnboxingLocalUtility.getEnabled(this.config);
    }

    @Override // com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.viewModel.IMyCouponListItemViewModel
    public final boolean isInvalidSkeleton() {
        return this.config == 5;
    }

    @Override // com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.viewModel.IMyCouponListItemViewModel
    public final String itemText() {
        return MyCouponListItemConfig$EnumUnboxingLocalUtility.getText(this.config);
    }

    @Override // com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.viewModel.IMyCouponListItemViewModel
    public final String itemTextToken() {
        return MyCouponListItemConfig$EnumUnboxingLocalUtility.getTextToken(this.config);
    }
}
