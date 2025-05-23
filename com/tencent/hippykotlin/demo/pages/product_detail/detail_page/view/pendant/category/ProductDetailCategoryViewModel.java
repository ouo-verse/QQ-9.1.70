package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.category;

import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.define.ProductDetailEventDataCardFrame;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.report.ECDetailPageReportParamsBuilder;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.report.IReportParamsBuilder;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailEvent;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPageDelegate;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPendantViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailEvent;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailPendantAttr;
import com.tencent.kuikly.core.base.ComposeView;
import java.util.Set;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class ProductDetailCategoryViewModel implements IProductDetailPendantViewModel, IProductDetailEvent {
    public float commentCardY;
    public final boolean isHalf;
    public final IProductDetailPageDelegate pageDelegate;
    public float picturesCardY;
    public float recommendCardY;
    public IReportParamsBuilder reportParams;

    public ProductDetailCategoryViewModel() {
        this(false, null, null, 7, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailEvent
    public final Set<String> canHandleEventName() {
        Set<String> mutableSetOf;
        mutableSetOf = SetsKt__SetsKt.mutableSetOf("comment_card_frame_change", "pictures_card_frame_change", "recommend_card_frame_change");
        return mutableSetOf;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPendantViewModel
    public final ComposeView<ProductDetailPendantAttr, ProductDetailEvent> getPendantView() {
        return new ProductDetailCategoryView();
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailEvent
    public final void onEvent(String str, Object obj) {
        ProductDetailEventDataCardFrame productDetailEventDataCardFrame = obj instanceof ProductDetailEventDataCardFrame ? (ProductDetailEventDataCardFrame) obj : null;
        if (productDetailEventDataCardFrame == null) {
            return;
        }
        if (Intrinsics.areEqual(str, "comment_card_frame_change")) {
            this.commentCardY = productDetailEventDataCardFrame.frame.getY() - 44.0f;
        } else if (Intrinsics.areEqual(str, "pictures_card_frame_change")) {
            this.picturesCardY = productDetailEventDataCardFrame.frame.getY() - 44.0f;
        } else if (Intrinsics.areEqual(str, "recommend_card_frame_change")) {
            this.recommendCardY = productDetailEventDataCardFrame.frame.getY() - 44.0f;
        }
    }

    public final void updatePageExpDepth(int i3) {
        IReportParamsBuilder iReportParamsBuilder = this.reportParams;
        ECDetailPageReportParamsBuilder eCDetailPageReportParamsBuilder = iReportParamsBuilder instanceof ECDetailPageReportParamsBuilder ? (ECDetailPageReportParamsBuilder) iReportParamsBuilder : null;
        if (eCDetailPageReportParamsBuilder != null) {
            eCDetailPageReportParamsBuilder.expDepth = Math.max(i3, eCDetailPageReportParamsBuilder.expDepth);
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPendantViewModel
    public final float viewHeight() {
        return 44.0f;
    }

    public ProductDetailCategoryViewModel(boolean z16, IProductDetailPageDelegate iProductDetailPageDelegate, IReportParamsBuilder iReportParamsBuilder) {
        this.isHalf = z16;
        this.pageDelegate = iProductDetailPageDelegate;
        this.reportParams = iReportParamsBuilder;
    }

    public /* synthetic */ ProductDetailCategoryViewModel(boolean z16, IProductDetailPageDelegate iProductDetailPageDelegate, IReportParamsBuilder iReportParamsBuilder, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(false, null, null);
    }
}
