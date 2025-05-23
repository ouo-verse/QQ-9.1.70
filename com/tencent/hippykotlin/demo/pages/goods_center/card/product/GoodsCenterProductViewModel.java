package com.tencent.hippykotlin.demo.pages.goods_center.card.product;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterFilterCond;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterProductInfo;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterRangeCond;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterCardAttr;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterEvent;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterCardViewModel;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsJVMKt;

/* loaded from: classes31.dex */
public final class GoodsCenterProductViewModel implements IGoodsCenterCardViewModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GoodsCenterProductViewModel.class, "isAdded", "isAdded()Z", 0)};
    public final List<GoodsCenterFilterCond> filterCondList;
    public final ReadWriteProperty isAdded$delegate = c.a(Boolean.FALSE);
    public final GoodsCenterProductInfo productInfo;
    public final List<GoodsCenterRangeCond> rangeCondList;

    public GoodsCenterProductViewModel(GoodsCenterProductInfo goodsCenterProductInfo, List<GoodsCenterFilterCond> list, List<GoodsCenterRangeCond> list2) {
        this.productInfo = goodsCenterProductInfo;
        this.filterCondList = list;
        this.rangeCondList = list2;
        setAdded(goodsCenterProductInfo.inWindow);
        k.b((k) com.tencent.kuikly.core.manager.c.f117352a.k(BridgeManager.f117344a.u()).acquireModule("KRNotifyModule"), "ECWindowAddNotification", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductViewModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar) {
                boolean equals$default;
                e eVar2 = eVar;
                equals$default = StringsKt__StringsJVMKt.equals$default(eVar2 != null ? eVar2.p("productID") : null, GoodsCenterProductViewModel.this.productInfo.saasProductId, false, 2, null);
                if (equals$default) {
                    GoodsCenterProductViewModel goodsCenterProductViewModel = GoodsCenterProductViewModel.this;
                    goodsCenterProductViewModel.isAdded$delegate.setValue(goodsCenterProductViewModel, GoodsCenterProductViewModel.$$delegatedProperties[0], Boolean.TRUE);
                }
                return Unit.INSTANCE;
            }
        }, 2, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterCardViewModel
    public final ComposeView<GoodsCenterCardAttr, GoodsCenterEvent> getCardView() {
        return new GoodsCenterProductView();
    }

    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterCardViewModel
    public final boolean isTopOfCard() {
        return false;
    }

    public final void setAdded(boolean z16) {
        this.isAdded$delegate.setValue(this, $$delegatedProperties[0], Boolean.valueOf(z16));
    }
}
