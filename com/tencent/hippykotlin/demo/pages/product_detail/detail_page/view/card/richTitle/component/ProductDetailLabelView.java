package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.richTitle.component;

import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailLabelInfo;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* loaded from: classes31.dex */
public final class ProductDetailLabelView extends ComposeView<ProductDetailLabelAttr, l> {
    public static final /* synthetic */ int $r8$clinit = 0;

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ ProductDetailLabelAttr access$getAttr(ProductDetailLabelView productDetailLabelView) {
        return (ProductDetailLabelAttr) productDetailLabelView.getAttr();
    }

    public static final boolean access$isImageLabel(ProductDetailLabelView productDetailLabelView, ProductDetailLabelInfo productDetailLabelInfo) {
        productDetailLabelView.getClass();
        if (productDetailLabelInfo.picToken.length() > 0) {
            return true;
        }
        return productDetailLabelInfo.picUrl.length() > 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final ArrayList<ProductDetailLabelInfo> arrayList = ((ProductDetailLabelAttr) getAttr()).labels;
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.richTitle.component.ProductDetailLabelView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final ArrayList<ProductDetailLabelInfo> arrayList2 = arrayList;
                final ProductDetailLabelView productDetailLabelView = this;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.richTitle.component.ProductDetailLabelView$body$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.richTitle.component.ProductDetailLabelView.body.1.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                Attr.absolutePosition$default(tVar2, 0.0f, 0.0f, 0.0f, 0.0f, 12, null);
                                tVar2.mo141height(20.0f);
                                tVar2.alignItemsCenter();
                                tVar2.flexDirectionRow();
                                return Unit.INSTANCE;
                            }
                        });
                        final ArrayList<ProductDetailLabelInfo> arrayList3 = arrayList2;
                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.richTitle.component.ProductDetailLabelView.body.1.1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Boolean.valueOf(arrayList3 != null);
                            }
                        };
                        final ArrayList<ProductDetailLabelInfo> arrayList4 = arrayList2;
                        final ProductDetailLabelView productDetailLabelView2 = productDetailLabelView;
                        ConditionViewKt.c(vVar2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.richTitle.component.ProductDetailLabelView.body.1.1.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                ConditionView conditionView2 = conditionView;
                                ArrayList<ProductDetailLabelInfo> arrayList5 = arrayList4;
                                if (arrayList5 != null) {
                                    final ProductDetailLabelView productDetailLabelView3 = productDetailLabelView2;
                                    for (final ProductDetailLabelInfo productDetailLabelInfo : arrayList5) {
                                        ConditionViewKt.c(conditionView2, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.richTitle.component.ProductDetailLabelView$body$1$1$3$1$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                return Boolean.valueOf(ProductDetailLabelView.access$isImageLabel(ProductDetailLabelView.this, productDetailLabelInfo));
                                            }
                                        }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.richTitle.component.ProductDetailLabelView$body$1$1$3$1$2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ConditionView conditionView3) {
                                                final ProductDetailLabelView productDetailLabelView4 = ProductDetailLabelView.this;
                                                final ProductDetailLabelInfo productDetailLabelInfo2 = productDetailLabelInfo;
                                                ah.a(conditionView3, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.richTitle.component.ProductDetailLabelView$body$1$1$3$1$2.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ImageView imageView) {
                                                        final ProductDetailLabelView productDetailLabelView5 = ProductDetailLabelView.this;
                                                        final ProductDetailLabelInfo productDetailLabelInfo3 = productDetailLabelInfo2;
                                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.richTitle.component.ProductDetailLabelView.body.1.1.3.1.2.1.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(af afVar) {
                                                                String str;
                                                                af afVar2 = afVar;
                                                                ProductDetailLabelView productDetailLabelView6 = ProductDetailLabelView.this;
                                                                ProductDetailLabelInfo productDetailLabelInfo4 = productDetailLabelInfo3;
                                                                int i3 = ProductDetailLabelView.$r8$clinit;
                                                                productDetailLabelView6.getClass();
                                                                float f16 = productDetailLabelInfo4.width;
                                                                ProductDetailLabelView productDetailLabelView7 = ProductDetailLabelView.this;
                                                                ProductDetailLabelInfo productDetailLabelInfo5 = productDetailLabelInfo3;
                                                                productDetailLabelView7.getClass();
                                                                afVar2.size(f16, productDetailLabelInfo5.height);
                                                                ProductDetailLabelView productDetailLabelView8 = ProductDetailLabelView.this;
                                                                ProductDetailLabelInfo productDetailLabelInfo6 = productDetailLabelInfo3;
                                                                productDetailLabelView8.getClass();
                                                                if (productDetailLabelInfo6.picToken.length() > 0) {
                                                                    str = productDetailLabelInfo6.picToken;
                                                                } else {
                                                                    if (productDetailLabelInfo6.picUrl.length() > 0) {
                                                                        str = productDetailLabelInfo6.picUrl;
                                                                    } else {
                                                                        str = "";
                                                                    }
                                                                }
                                                                b.a.b(afVar2, str, false, 2, null);
                                                                afVar2.marginRight(4.0f);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                ProductDetailLabelAttr access$getAttr = ProductDetailLabelView.access$getAttr(ProductDetailLabelView.this);
                                                float f16 = access$getAttr.headIndent;
                                                ProductDetailLabelView productDetailLabelView5 = ProductDetailLabelView.this;
                                                ProductDetailLabelInfo productDetailLabelInfo3 = productDetailLabelInfo;
                                                productDetailLabelView5.getClass();
                                                access$getAttr.headIndent = productDetailLabelInfo3.width + 4.0f + f16;
                                                return Unit.INSTANCE;
                                            }
                                        });
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        ConditionViewKt.a(vVar2, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.richTitle.component.ProductDetailLabelView.body.1.1.4
                            @Override // kotlin.jvm.functions.Function1
                            public final /* bridge */ /* synthetic */ Unit invoke(ConditionView conditionView) {
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new ProductDetailLabelAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final float getHeadLabelIndent() {
        return ((ProductDetailLabelAttr) getAttr()).headIndent;
    }
}
