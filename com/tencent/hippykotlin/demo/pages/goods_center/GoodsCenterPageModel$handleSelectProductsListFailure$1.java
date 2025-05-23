package com.tencent.hippykotlin.demo.pages.goods_center;

import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterPage$DeleteAlertDialog$1$2$1$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.log.KLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes31.dex */
public final class GoodsCenterPageModel$handleSelectProductsListFailure$1 extends Lambda implements Function2<Integer, String, Unit> {
    public final /* synthetic */ boolean $isLoadMore;
    public final /* synthetic */ GoodsCenterPageModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoodsCenterPageModel$handleSelectProductsListFailure$1(GoodsCenterPageModel goodsCenterPageModel, boolean z16) {
        super(2);
        this.this$0 = goodsCenterPageModel;
        this.$isLoadMore = z16;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Unit invoke(Integer num, String str) {
        KLog.INSTANCE.e("GoodsCenterPageModel", AdelieManagerCenterPage$DeleteAlertDialog$1$2$1$$ExternalSyntheticOutline0.m("SelectProductsList req failure, ", num.intValue(), "  ", str));
        this.this$0.refreshState$enumunboxing$(this.$isLoadMore ? 6 : 5);
        this.this$0.reportShowPageCostTime$enumunboxing$(3);
        return Unit.INSTANCE;
    }
}
