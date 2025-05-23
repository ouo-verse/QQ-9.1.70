package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.page_model;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.PopDownMenuLogic$deleteTtsInfo$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.define.ProductDetailPageState;
import com.tencent.kuikly.core.log.KLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes31.dex */
public final class ProductDetailDistributionPageModel$handleReqFailure$1 extends Lambda implements Function2<Integer, String, Unit> {
    public final /* synthetic */ ProductDetailDistributionPageModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProductDetailDistributionPageModel$handleReqFailure$1(ProductDetailDistributionPageModel productDetailDistributionPageModel) {
        super(2);
        this.this$0 = productDetailDistributionPageModel;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Unit invoke(Integer num, String str) {
        int intValue = num.intValue();
        String str2 = str;
        ProductDetailDistributionPageModel productDetailDistributionPageModel = this.this$0;
        productDetailDistributionPageModel.pageState$delegate.setValue(productDetailDistributionPageModel, ProductDetailDistributionPageModel.$$delegatedProperties[0], ProductDetailPageState.FAILURE);
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = PopDownMenuLogic$deleteTtsInfo$1$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("req detail info failure, spuId:["), this.this$0.spuId, "] code:[", intValue, "] msg:[");
        m3.append(str2);
        m3.append(']');
        kLog.e("ProductDetail", m3.toString());
        Utils.INSTANCE.logToNative("failure, " + intValue + "  " + str2);
        return Unit.INSTANCE;
    }
}
