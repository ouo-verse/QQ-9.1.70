package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.pictures;

import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailPicInfo;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailCardViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailCardAttr;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailCardView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.views.ImageEvent;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class ProductDetailPicturesView extends ProductDetailCardView {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        IProductDetailCardViewModel viewModel = ((ProductDetailCardAttr) getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.pictures.ProductDetailPicturesViewModel");
        final ProductDetailPicturesViewModel productDetailPicturesViewModel = (ProductDetailPicturesViewModel) viewModel;
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.pictures.ProductDetailPicturesView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final ProductDetailPicturesViewModel productDetailPicturesViewModel2 = ProductDetailPicturesViewModel.this;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.pictures.ProductDetailPicturesView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.mo153width(mVar2.getPagerData().m());
                        mVar2.mo113backgroundColor(ProductDetailPicturesViewModel.this.tokenColor("qecommerce_skin_color_bg_default"));
                        return Unit.INSTANCE;
                    }
                });
                final ProductDetailPicturesViewModel productDetailPicturesViewModel3 = ProductDetailPicturesViewModel.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.pictures.ProductDetailPicturesView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.pictures.ProductDetailPicturesView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.paddingLeft(16.0f);
                                tVar2.mo153width(tVar2.getPagerData().m());
                                tVar2.flexDirectionColumn();
                                tVar2.justifyContentFlexStart();
                                tVar2.marginBottom(12.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        ArrayList<ProductDetailPicInfo> detailPicArray = ProductDetailPicturesViewModel.this.getDetailPicArray();
                        if (detailPicArray != null) {
                            final ProductDetailPicturesViewModel productDetailPicturesViewModel4 = ProductDetailPicturesViewModel.this;
                            final int i3 = 0;
                            for (Object obj : detailPicArray) {
                                int i16 = i3 + 1;
                                if (i3 < 0) {
                                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                                }
                                final ProductDetailPicInfo productDetailPicInfo = (ProductDetailPicInfo) obj;
                                ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.pictures.ProductDetailPicturesView$body$1$2$2$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        ImageView imageView2 = imageView;
                                        final ProductDetailPicInfo productDetailPicInfo2 = ProductDetailPicInfo.this;
                                        imageView2.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.pictures.ProductDetailPicturesView$body$1$2$2$1$1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                af afVar2 = afVar;
                                                ProductDetailPicInfo productDetailPicInfo3 = ProductDetailPicInfo.this;
                                                float f16 = productDetailPicInfo3.height / productDetailPicInfo3.width;
                                                float m3 = afVar2.getPagerData().m() - 32;
                                                afVar2.mo141height(f16 * m3);
                                                afVar2.mo153width(m3);
                                                b.a.b(afVar2, ProductDetailPicInfo.this.url, false, 2, null);
                                                afVar2.q();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final ProductDetailPicturesViewModel productDetailPicturesViewModel5 = productDetailPicturesViewModel4;
                                        final int i17 = i3;
                                        imageView2.event(new Function1<ImageEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.pictures.ProductDetailPicturesView$body$1$2$2$1$1.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ImageEvent imageEvent) {
                                                final ProductDetailPicturesViewModel productDetailPicturesViewModel6 = ProductDetailPicturesViewModel.this;
                                                final int i18 = i17;
                                                imageEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.pictures.ProductDetailPicturesView.body.1.2.2.1.1.2.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        ProductDetailPicturesViewModel.this.showPhotoBrowser(i18);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                i3 = i16;
                            }
                        }
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }
}
