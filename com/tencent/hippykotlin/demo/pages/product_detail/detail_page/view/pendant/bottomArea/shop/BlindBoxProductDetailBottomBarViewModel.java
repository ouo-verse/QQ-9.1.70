package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.page_model.IBlindBoxProductDetailBottomBarViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailEvent;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailPendantAttr;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.ProductDetailBaseViewModel;
import com.tencent.kuikly.core.base.ComposeView;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class BlindBoxProductDetailBottomBarViewModel extends ProductDetailBaseViewModel implements IBlindBoxProductDetailBottomBarViewModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(BlindBoxProductDetailBottomBarViewModel.class, "assistButtonEnable", "getAssistButtonEnable()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(BlindBoxProductDetailBottomBarViewModel.class, "assistButtonText", "getAssistButtonText()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(BlindBoxProductDetailBottomBarViewModel.class, "assistButtonJumpUrl", "getAssistButtonJumpUrl()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(BlindBoxProductDetailBottomBarViewModel.class, "firstLotteryButtonType", "getFirstLotteryButtonType()I", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(BlindBoxProductDetailBottomBarViewModel.class, "firstLotteryButtonEnable", "getFirstLotteryButtonEnable()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(BlindBoxProductDetailBottomBarViewModel.class, "firstLotteryButtonText", "getFirstLotteryButtonText()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(BlindBoxProductDetailBottomBarViewModel.class, "firstLotteryButtonPrice", "getFirstLotteryButtonPrice()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(BlindBoxProductDetailBottomBarViewModel.class, "firstLotteryButtonJumpUrl", "getFirstLotteryButtonJumpUrl()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(BlindBoxProductDetailBottomBarViewModel.class, "secondLotteryButtonType", "getSecondLotteryButtonType()I", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(BlindBoxProductDetailBottomBarViewModel.class, "secondLotteryButtonEnable", "getSecondLotteryButtonEnable()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(BlindBoxProductDetailBottomBarViewModel.class, "secondLotteryButtonText", "getSecondLotteryButtonText()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(BlindBoxProductDetailBottomBarViewModel.class, "secondLotteryButtonPrice", "getSecondLotteryButtonPrice()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(BlindBoxProductDetailBottomBarViewModel.class, "secondLotteryButtonJumpUrl", "getSecondLotteryButtonJumpUrl()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(BlindBoxProductDetailBottomBarViewModel.class, "containsTwoLotteryButton", "getContainsTwoLotteryButton()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(BlindBoxProductDetailBottomBarViewModel.class, "showBlindBoxInfo", "getShowBlindBoxInfo()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(BlindBoxProductDetailBottomBarViewModel.class, "blindBoxCoverUrl", "getBlindBoxCoverUrl()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(BlindBoxProductDetailBottomBarViewModel.class, "blindBoxTitle", "getBlindBoxTitle()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(BlindBoxProductDetailBottomBarViewModel.class, "tryPlayButtonJumUrl", "getTryPlayButtonJumUrl()Ljava/lang/String;", 0)};
    public final ReadWriteProperty assistButtonEnable$delegate;
    public final ReadWriteProperty assistButtonJumpUrl$delegate;
    public final ReadWriteProperty assistButtonText$delegate;
    public final ReadWriteProperty blindBoxCoverUrl$delegate;
    public final ReadWriteProperty blindBoxTitle$delegate;
    public final String boxId;
    public final ReadWriteProperty containsTwoLotteryButton$delegate;
    public final ReadWriteProperty firstLotteryButtonEnable$delegate;
    public final ReadWriteProperty firstLotteryButtonJumpUrl$delegate;
    public final ReadWriteProperty firstLotteryButtonPrice$delegate;
    public final ReadWriteProperty firstLotteryButtonText$delegate;
    public final ReadWriteProperty firstLotteryButtonType$delegate;
    public final ReadWriteProperty secondLotteryButtonEnable$delegate;
    public final ReadWriteProperty secondLotteryButtonJumpUrl$delegate;
    public final ReadWriteProperty secondLotteryButtonPrice$delegate;
    public final ReadWriteProperty secondLotteryButtonText$delegate;
    public final ReadWriteProperty secondLotteryButtonType$delegate;
    public final ReadWriteProperty showBlindBoxInfo$delegate;
    public final String spuId;
    public final ReadWriteProperty tryPlayButtonJumUrl$delegate;
    public float width;
    public final boolean disableNightMode = true;
    public float height = BlindBoxProductDetailBottomBar.Companion.getBottomBarHeight();

    public BlindBoxProductDetailBottomBarViewModel(String str, String str2) {
        this.spuId = str;
        this.boxId = str2;
        Boolean bool = Boolean.FALSE;
        this.assistButtonEnable$delegate = c.a(bool);
        this.assistButtonText$delegate = c.a("");
        this.assistButtonJumpUrl$delegate = c.a("");
        this.firstLotteryButtonType$delegate = c.a(0);
        this.firstLotteryButtonEnable$delegate = c.a(bool);
        this.firstLotteryButtonText$delegate = c.a("");
        this.firstLotteryButtonPrice$delegate = c.a("");
        this.firstLotteryButtonJumpUrl$delegate = c.a("");
        this.secondLotteryButtonType$delegate = c.a(0);
        this.secondLotteryButtonEnable$delegate = c.a(bool);
        this.secondLotteryButtonText$delegate = c.a("");
        this.secondLotteryButtonPrice$delegate = c.a("");
        this.secondLotteryButtonJumpUrl$delegate = c.a("");
        this.containsTwoLotteryButton$delegate = c.a(bool);
        this.showBlindBoxInfo$delegate = c.a(bool);
        this.blindBoxCoverUrl$delegate = c.a("");
        this.blindBoxTitle$delegate = c.a("");
        this.tryPlayButtonJumUrl$delegate = c.a("");
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.ProductDetailBaseViewModel
    public final boolean getDisableNightMode() {
        return this.disableNightMode;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPendantViewModel
    public final ComposeView<ProductDetailPendantAttr, ProductDetailEvent> getPendantView() {
        return new BlindBoxProductDetailBottomBar();
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.page_model.IBlindBoxProductDetailBottomBarViewModel
    public final void setHeight(float f16) {
        this.height = f16;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPendantViewModel
    public final float viewHeight() {
        return this.height;
    }
}
