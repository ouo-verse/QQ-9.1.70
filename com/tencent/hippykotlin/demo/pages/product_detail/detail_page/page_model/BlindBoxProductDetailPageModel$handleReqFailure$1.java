package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.page_model;

import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.define.ProductDetailPageState;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes31.dex */
public final class BlindBoxProductDetailPageModel$handleReqFailure$1 extends Lambda implements Function2<Integer, String, Unit> {
    public final /* synthetic */ BlindBoxProductDetailPageModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BlindBoxProductDetailPageModel$handleReqFailure$1(BlindBoxProductDetailPageModel blindBoxProductDetailPageModel) {
        super(2);
        this.this$0 = blindBoxProductDetailPageModel;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Unit invoke(Integer num, String str) {
        int intValue = num.intValue();
        Utils.INSTANCE.logToNative("BlindBoxProductDetailPageModel failure, " + intValue + "  " + str);
        BlindBoxProductDetailPageModel blindBoxProductDetailPageModel = this.this$0;
        blindBoxProductDetailPageModel.pageState$delegate.setValue(blindBoxProductDetailPageModel, BlindBoxProductDetailPageModel.$$delegatedProperties[0], ProductDetailPageState.FAILURE);
        return Unit.INSTANCE;
    }
}
