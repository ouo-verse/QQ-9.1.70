package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell;

import com.tencent.kuikly.core.base.k;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public class ProductDetailPendantAttr extends k {
    public IProductDetailPendantViewModel viewModel;

    public final IProductDetailPendantViewModel getViewModel() {
        IProductDetailPendantViewModel iProductDetailPendantViewModel = this.viewModel;
        if (iProductDetailPendantViewModel != null) {
            return iProductDetailPendantViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }
}
