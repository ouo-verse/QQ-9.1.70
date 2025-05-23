package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.ButtonInfo;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.page_model.IBlindBoxProductDetailBottomBarViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailEvent;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailPendantAttr;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.ProductDetailBaseViewModel;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Pair;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class BlindBoxProductDetailBottomBarForYiFanShangViewModel extends ProductDetailBaseViewModel implements IBlindBoxProductDetailBottomBarViewModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(BlindBoxProductDetailBottomBarForYiFanShangViewModel.class, "firstButton", "getFirstButton()Lcom/tencent/hippykotlin/demo/pages/activity/blind_box/yifanshang/detail/view/ButtonInfo;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(BlindBoxProductDetailBottomBarForYiFanShangViewModel.class, "secondButton", "getSecondButton()Lcom/tencent/hippykotlin/demo/pages/activity/blind_box/yifanshang/detail/view/ButtonInfo;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(BlindBoxProductDetailBottomBarForYiFanShangViewModel.class, "thirdButton", "getThirdButton()Lcom/tencent/hippykotlin/demo/pages/activity/blind_box/yifanshang/detail/view/ButtonInfo;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(BlindBoxProductDetailBottomBarForYiFanShangViewModel.class, "firstBtnJumpUrl", "getFirstBtnJumpUrl()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(BlindBoxProductDetailBottomBarForYiFanShangViewModel.class, "secondBtnJumpUrl", "getSecondBtnJumpUrl()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(BlindBoxProductDetailBottomBarForYiFanShangViewModel.class, "thirdBtnJumpUrl", "getThirdBtnJumpUrl()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(BlindBoxProductDetailBottomBarForYiFanShangViewModel.class, "cover", "getCover()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(BlindBoxProductDetailBottomBarForYiFanShangViewModel.class, "title", "getTitle()Ljava/lang/String;", 0)};
    public String boxId;
    public String groupId;
    public String spuId;
    public float width;
    public final boolean disableNightMode = true;
    public float height = BlindBoxProductDetailBottomBarForYiFanShang.Companion.getBottomBarHeight();
    public final ReadWriteProperty firstButton$delegate = c.a(new ButtonInfo(true, "\u62bd\u4e00\u5f20", "", false));
    public final ReadWriteProperty secondButton$delegate = c.a(new ButtonInfo(true, "\u62bd\u4e09\u5f20", "", false));
    public final ReadWriteProperty thirdButton$delegate = c.a(new ButtonInfo(true, "\u5168\u6536", "", false));
    public final ReadWriteProperty firstBtnJumpUrl$delegate = c.a("");
    public final ReadWriteProperty secondBtnJumpUrl$delegate = c.a("");
    public final ReadWriteProperty thirdBtnJumpUrl$delegate = c.a("");
    public final ReadWriteProperty cover$delegate = c.a("");
    public final ReadWriteProperty title$delegate = c.a("");

    public BlindBoxProductDetailBottomBarForYiFanShangViewModel(e eVar) {
        this.boxId = "";
        this.spuId = "";
        this.groupId = "";
        e m3 = eVar.m("first_btn_info");
        if (m3 != null) {
            Pair<ButtonInfo, String> fromJson = ButtonInfo.Companion.fromJson(m3);
            ButtonInfo component1 = fromJson.component1();
            String component2 = fromJson.component2();
            setFirstButton(component1);
            setFirstBtnJumpUrl(component2);
        }
        e m16 = eVar.m("second_btn_info");
        if (m16 != null) {
            Pair<ButtonInfo, String> fromJson2 = ButtonInfo.Companion.fromJson(m16);
            ButtonInfo component12 = fromJson2.component1();
            String component22 = fromJson2.component2();
            setSecondButton(component12);
            setSecondBtnJumpUrl(component22);
        }
        e m17 = eVar.m("third_btn_info");
        if (m17 != null) {
            Pair<ButtonInfo, String> fromJson3 = ButtonInfo.Companion.fromJson(m17);
            ButtonInfo component13 = fromJson3.component1();
            String component23 = fromJson3.component2();
            setThirdButton(component13);
            setThirdBtnJumpUrl(component23);
        }
        setCover(eVar.p("cover"));
        setTitle(eVar.p("title"));
        this.boxId = eVar.p("mystery_box_id");
        this.spuId = eVar.p("spu_id");
        this.groupId = eVar.p("group_id");
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.ProductDetailBaseViewModel
    public final boolean getDisableNightMode() {
        return this.disableNightMode;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPendantViewModel
    public final ComposeView<ProductDetailPendantAttr, ProductDetailEvent> getPendantView() {
        return new BlindBoxProductDetailBottomBarForYiFanShang();
    }

    public final void setCover(String str) {
        this.cover$delegate.setValue(this, $$delegatedProperties[6], str);
    }

    public final void setFirstBtnJumpUrl(String str) {
        this.firstBtnJumpUrl$delegate.setValue(this, $$delegatedProperties[3], str);
    }

    public final void setFirstButton(ButtonInfo buttonInfo) {
        this.firstButton$delegate.setValue(this, $$delegatedProperties[0], buttonInfo);
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.page_model.IBlindBoxProductDetailBottomBarViewModel
    public final void setHeight(float f16) {
        this.height = f16;
    }

    public final void setSecondBtnJumpUrl(String str) {
        this.secondBtnJumpUrl$delegate.setValue(this, $$delegatedProperties[4], str);
    }

    public final void setSecondButton(ButtonInfo buttonInfo) {
        this.secondButton$delegate.setValue(this, $$delegatedProperties[1], buttonInfo);
    }

    public final void setThirdBtnJumpUrl(String str) {
        this.thirdBtnJumpUrl$delegate.setValue(this, $$delegatedProperties[5], str);
    }

    public final void setThirdButton(ButtonInfo buttonInfo) {
        this.thirdButton$delegate.setValue(this, $$delegatedProperties[2], buttonInfo);
    }

    public final void setTitle(String str) {
        this.title$delegate.setValue(this, $$delegatedProperties[7], str);
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPendantViewModel
    public final float viewHeight() {
        return this.height;
    }
}
