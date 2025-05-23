package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.liveIcon;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ExplainEnumLiveStatus;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ExplainGetShopLiveStatusRsp;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ExplainLiveRoomBaseInfo;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.shop.ProductDetailShopRepository;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailEvent;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPendantViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailEvent;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailPendantAttr;
import com.tencent.kuikly.core.base.ComposeView;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.SetsKt__SetsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsJVMKt;

/* loaded from: classes31.dex */
public final class ProductDetailIconViewModel implements IProductDetailPendantViewModel, IProductDetailEvent {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(ProductDetailIconViewModel.class, "needShowLiveIcon", "getNeedShowLiveIcon()Z", 0)};
    public String jumpUrl;
    public int liveStatus;
    public final ReadWriteProperty needShowLiveIcon$delegate;
    public final String spuId;

    public ProductDetailIconViewModel() {
        this(null, 0L, 3, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailEvent
    public final Set<String> canHandleEventName() {
        Set<String> of5;
        of5 = SetsKt__SetsJVMKt.setOf("");
        return of5;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPendantViewModel
    public final ComposeView<ProductDetailPendantAttr, ProductDetailEvent> getPendantView() {
        return new ProductDetailIconView();
    }

    public final Function2<Integer, String, Unit> handleIconError() {
        return new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.liveIcon.ProductDetailIconViewModel$handleIconError$1
            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Integer num, String str) {
                int intValue = num.intValue();
                Utils.INSTANCE.logToNative("handleIconError " + intValue + ", " + str);
                return Unit.INSTANCE;
            }
        };
    }

    public final Function1<ExplainGetShopLiveStatusRsp, Unit> handleIconSuccess() {
        return new Function1<ExplainGetShopLiveStatusRsp, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.liveIcon.ProductDetailIconViewModel$handleIconSuccess$1
            {
                super(1);
            }

            /* JADX WARN: Code restructure failed: missing block: B:11:0x0024, code lost:
            
                if ((!r1) != false) goto L17;
             */
            @Override // kotlin.jvm.functions.Function1
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Unit invoke(ExplainGetShopLiveStatusRsp explainGetShopLiveStatusRsp) {
                boolean isBlank;
                ExplainGetShopLiveStatusRsp explainGetShopLiveStatusRsp2 = explainGetShopLiveStatusRsp;
                ProductDetailIconViewModel productDetailIconViewModel = ProductDetailIconViewModel.this;
                ExplainLiveRoomBaseInfo explainLiveRoomBaseInfo = explainGetShopLiveStatusRsp2.roomInfo;
                String str = explainLiveRoomBaseInfo != null ? explainLiveRoomBaseInfo.roomUrl : null;
                productDetailIconViewModel.jumpUrl = str;
                if (str != null) {
                    boolean z16 = true;
                    if (productDetailIconViewModel.spuId.length() > 0) {
                        isBlank = StringsKt__StringsJVMKt.isBlank(str);
                    }
                    z16 = false;
                    productDetailIconViewModel.needShowLiveIcon$delegate.setValue(productDetailIconViewModel, ProductDetailIconViewModel.$$delegatedProperties[0], Boolean.valueOf(z16));
                }
                ProductDetailIconViewModel productDetailIconViewModel2 = ProductDetailIconViewModel.this;
                ExplainEnumLiveStatus explainEnumLiveStatus = explainGetShopLiveStatusRsp2.status;
                productDetailIconViewModel2.liveStatus = explainEnumLiveStatus != null ? explainEnumLiveStatus.type : 0;
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPendantViewModel
    public final float viewHeight() {
        return 64.0f;
    }

    public ProductDetailIconViewModel(String str, long j3) {
        this.spuId = str;
        ProductDetailShopRepository.INSTANCE.reqLiveIconInfo(str, j3, handleIconSuccess(), handleIconError());
        this.needShowLiveIcon$delegate = c.a(Boolean.FALSE);
    }

    public /* synthetic */ ProductDetailIconViewModel(String str, long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("", 0L);
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailEvent
    public final void onEvent(String str, Object obj) {
    }
}
