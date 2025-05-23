package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.detail.model.BoxType$EnumUnboxingSharedUtility;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.report.IReportParamsBuilder;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailActiveInfo;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailButton;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailButtonItem;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailProductCardRsp;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.shop.ProductDetailShopRepository;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.shop.model.ProductDetailInfo;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPendantViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailEvent;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailPendantAttr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.Typography;

/* loaded from: classes31.dex */
public final class ProductDetailShopBottomViewModel implements IProductDetailPendantViewModel {
    public final Lazy info$delegate;
    public final e params;
    public IReportParamsBuilder reportParams;
    public final String spuId;

    public ProductDetailShopBottomViewModel(String str, e eVar, IReportParamsBuilder iReportParamsBuilder) {
        Lazy lazy;
        this.spuId = str;
        this.params = eVar;
        this.reportParams = iReportParamsBuilder;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ProductDetailInfo>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.ProductDetailShopBottomViewModel$info$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ProductDetailInfo invoke() {
                ProductDetailShopRepository productDetailShopRepository = ProductDetailShopRepository.INSTANCE;
                return ProductDetailShopRepository.cache.getDetailInfo(ProductDetailShopBottomViewModel.this.spuId);
            }
        });
        this.info$delegate = lazy;
    }

    public static String appendParamToScheme$default(ProductDetailShopBottomViewModel productDetailShopBottomViewModel, String str, String str2, String str3) {
        boolean contains$default;
        if (str.length() == 0) {
            return str3;
        }
        if (str2.length() == 0) {
            return str3;
        }
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) str3, (CharSequence) str, false, 2, (Object) null);
        if (contains$default) {
            return str3;
        }
        return str3 + Typography.amp + str + '=' + str2;
    }

    public final ProductDetailButtonItem[] bottomInfoArray() {
        ProductDetailProductCardRsp productDetailProductCardRsp;
        ProductDetailButton productDetailButton;
        ArrayList<ProductDetailButtonItem> arrayList;
        ProductDetailInfo info = getInfo();
        if (info != null && (productDetailProductCardRsp = info.detail) != null && (productDetailButton = productDetailProductCardRsp.button) != null && (arrayList = productDetailButton.buttonItem) != null) {
            Object[] array = arrayList.toArray(new ProductDetailButtonItem[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            ProductDetailButtonItem[] productDetailButtonItemArr = (ProductDetailButtonItem[]) array;
            if (productDetailButtonItemArr != null) {
                return productDetailButtonItemArr;
            }
        }
        return new ProductDetailButtonItem[0];
    }

    public final ProductDetailInfo getInfo() {
        return (ProductDetailInfo) this.info$delegate.getValue();
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPendantViewModel
    public final ComposeView<ProductDetailPendantAttr, ProductDetailEvent> getPendantView() {
        return new ProductDetailShopBottomView();
    }

    public final boolean isBigBtnEnabled() {
        ProductDetailProductCardRsp productDetailProductCardRsp;
        ProductDetailActiveInfo productDetailActiveInfo;
        int i3;
        if (productStatus$enumunboxing$() != 2) {
            return false;
        }
        ProductDetailInfo info = getInfo();
        return info == null || (productDetailProductCardRsp = info.detail) == null || (productDetailActiveInfo = productDetailProductCardRsp.activeInfo) == null || (i3 = productDetailActiveInfo.activeDetailStatus) == 0 || 2 == i3;
    }

    public final int productStatus$enumunboxing$() {
        ProductDetailProductCardRsp productDetailProductCardRsp;
        ProductDetailInfo info = getInfo();
        int i3 = 0;
        int i16 = (info == null || (productDetailProductCardRsp = info.detail) == null) ? 0 : productDetailProductCardRsp.status;
        int[] values = BoxType$EnumUnboxingSharedUtility.values(5);
        int length = values.length;
        int i17 = 0;
        while (true) {
            if (i17 >= length) {
                break;
            }
            int i18 = values[i17];
            if (BoxType$EnumUnboxingSharedUtility.ordinal(i18) == i16) {
                i3 = i18;
                break;
            }
            i17++;
        }
        if (i3 == 0) {
            return 1;
        }
        return i3;
    }
}
