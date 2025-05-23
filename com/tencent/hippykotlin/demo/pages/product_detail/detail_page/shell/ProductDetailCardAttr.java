package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell;

import com.tencent.kuikly.core.base.k;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public class ProductDetailCardAttr extends k {
    public IProductDetailCardViewModel viewModel;

    public final IProductDetailCardViewModel getViewModel() {
        IProductDetailCardViewModel iProductDetailCardViewModel = this.viewModel;
        if (iProductDetailCardViewModel != null) {
            return iProductDetailCardViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }
}
