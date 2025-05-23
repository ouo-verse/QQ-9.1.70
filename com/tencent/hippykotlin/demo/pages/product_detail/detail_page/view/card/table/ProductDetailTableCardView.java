package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.table;

import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailProperty;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailCardViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailCardAttr;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailCardView;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.e;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.f;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.directives.LoopDirectivesView;
import com.tencent.kuikly.core.directives.LoopDirectivesViewKt;
import com.tencent.kuikly.core.reactive.collection.c;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class ProductDetailTableCardView extends ProductDetailCardView {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        IProductDetailCardViewModel viewModel = ((ProductDetailCardAttr) getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.table.ProductDetailTableCardViewModel");
        final ProductDetailTableCardViewModel productDetailTableCardViewModel = (ProductDetailTableCardViewModel) viewModel;
        productDetailTableCardViewModel.initTableData();
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.table.ProductDetailTableCardView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final ProductDetailTableCardViewModel productDetailTableCardViewModel2 = ProductDetailTableCardViewModel.this;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.table.ProductDetailTableCardView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.mo153width(mVar2.getPagerData().m());
                        mVar2.mo113backgroundColor(ProductDetailTableCardViewModel.this.tokenColor("qecommerce_skin_color_bg_default"));
                        return Unit.INSTANCE;
                    }
                });
                final ProductDetailTableCardViewModel productDetailTableCardViewModel3 = ProductDetailTableCardViewModel.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.table.ProductDetailTableCardView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final ProductDetailTableCardViewModel productDetailTableCardViewModel4 = ProductDetailTableCardViewModel.this;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.table.ProductDetailTableCardView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.marginLeft(16.0f);
                                tVar2.marginRight(16.0f);
                                tVar2.m136border(new e(1.0f, BorderStyle.SOLID, ProductDetailTableCardViewModel.this.tokenColor("qecommerce_skin_color_divider")));
                                tVar2.m137borderRadius(new f(4.0f, 4.0f, 4.0f, 4.0f));
                                tVar2.m140flex(1.0f);
                                tVar2.marginBottom(12.0f);
                                tVar2.flexDirectionColumn();
                                tVar2.justifyContentFlexStart();
                                return Unit.INSTANCE;
                            }
                        });
                        final ProductDetailTableCardViewModel productDetailTableCardViewModel5 = ProductDetailTableCardViewModel.this;
                        Function0<c<ProductDetailProperty>> function0 = new Function0<c<ProductDetailProperty>>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.table.ProductDetailTableCardView.body.1.2.2
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final c<ProductDetailProperty> invoke() {
                                return ProductDetailTableCardViewModel.this.tableData();
                            }
                        };
                        final ProductDetailTableCardViewModel productDetailTableCardViewModel6 = ProductDetailTableCardViewModel.this;
                        LoopDirectivesViewKt.a(vVar2, function0, new Function2<LoopDirectivesView<ProductDetailProperty>, ProductDetailProperty, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.table.ProductDetailTableCardView.body.1.2.3
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Unit invoke(LoopDirectivesView<ProductDetailProperty> loopDirectivesView, ProductDetailProperty productDetailProperty) {
                                final ProductDetailProperty productDetailProperty2 = productDetailProperty;
                                final ProductDetailTableCardViewModel productDetailTableCardViewModel7 = ProductDetailTableCardViewModel.this;
                                w.a(loopDirectivesView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.table.ProductDetailTableCardView.body.1.2.3.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        v vVar4 = vVar3;
                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.table.ProductDetailTableCardView.body.1.2.3.1.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.flexDirectionColumn();
                                                tVar2.justifyContentFlexStart();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final ProductDetailTableCardViewModel productDetailTableCardViewModel8 = ProductDetailTableCardViewModel.this;
                                        final ProductDetailProperty productDetailProperty3 = productDetailProperty2;
                                        w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.table.ProductDetailTableCardView.body.1.2.3.1.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar5) {
                                                v vVar6 = vVar5;
                                                vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.table.ProductDetailTableCardView.body.1.2.3.1.2.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.flexDirectionRow();
                                                        tVar2.justifyContentFlexStart();
                                                        tVar2.mo141height(40.0f);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final ProductDetailTableCardViewModel productDetailTableCardViewModel9 = ProductDetailTableCardViewModel.this;
                                                final ProductDetailProperty productDetailProperty4 = productDetailProperty3;
                                                vVar6.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.table.ProductDetailTableCardView.body.1.2.3.1.2.2
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(u uVar) {
                                                        final ProductDetailTableCardViewModel productDetailTableCardViewModel10 = ProductDetailTableCardViewModel.this;
                                                        final ProductDetailProperty productDetailProperty5 = productDetailProperty4;
                                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.table.ProductDetailTableCardView.body.1.2.3.1.2.2.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                ProductDetailTableCardViewModel.this.cellClickEvent(productDetailProperty5);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final ProductDetailTableCardViewModel productDetailTableCardViewModel10 = ProductDetailTableCardViewModel.this;
                                                final ProductDetailProperty productDetailProperty5 = productDetailProperty3;
                                                w.a(vVar6, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.table.ProductDetailTableCardView.body.1.2.3.1.2.3
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar7) {
                                                        v vVar8 = vVar7;
                                                        final ProductDetailTableCardViewModel productDetailTableCardViewModel11 = ProductDetailTableCardViewModel.this;
                                                        vVar8.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.table.ProductDetailTableCardView.body.1.2.3.1.2.3.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(t tVar) {
                                                                t tVar2 = tVar;
                                                                tVar2.m140flex(35.0f);
                                                                tVar2.mo141height(40.0f);
                                                                tVar2.mo113backgroundColor(ProductDetailTableCardViewModel.this.tokenColor("qecommerce_skin_color_bg_backplate"));
                                                                tVar2.flexDirectionRow();
                                                                tVar2.alignItemsCenter();
                                                                tVar2.justifyContentFlexStart();
                                                                tVar2.paddingLeft(16.0f);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final ProductDetailTableCardViewModel productDetailTableCardViewModel12 = ProductDetailTableCardViewModel.this;
                                                        final ProductDetailProperty productDetailProperty6 = productDetailProperty5;
                                                        cg.a(vVar8, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.table.ProductDetailTableCardView.body.1.2.3.1.2.3.2
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextView textView) {
                                                                final ProductDetailTableCardViewModel productDetailTableCardViewModel13 = ProductDetailTableCardViewModel.this;
                                                                final ProductDetailProperty productDetailProperty7 = productDetailProperty6;
                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.table.ProductDetailTableCardView.body.1.2.3.1.2.3.2.1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ce ceVar) {
                                                                        ce ceVar2 = ceVar;
                                                                        ceVar2.lines(1);
                                                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                                        ceVar2.textAlignLeft();
                                                                        ceVar2.textOverFlowTail();
                                                                        ceVar2.mo153width((float) (((ceVar2.getPagerData().m() - 32) * 0.35d) - 32));
                                                                        ceVar2.color(ProductDetailTableCardViewModel.this.tokenColor("qecommerce_skin_color_text_secondary"));
                                                                        ceVar2.text(productDetailProperty7.name);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final ProductDetailTableCardViewModel productDetailTableCardViewModel11 = ProductDetailTableCardViewModel.this;
                                                final ProductDetailProperty productDetailProperty6 = productDetailProperty3;
                                                w.a(vVar6, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.table.ProductDetailTableCardView.body.1.2.3.1.2.4
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar7) {
                                                        v vVar8 = vVar7;
                                                        final ProductDetailTableCardViewModel productDetailTableCardViewModel12 = ProductDetailTableCardViewModel.this;
                                                        vVar8.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.table.ProductDetailTableCardView.body.1.2.3.1.2.4.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(t tVar) {
                                                                t tVar2 = tVar;
                                                                tVar2.m140flex(65.0f);
                                                                tVar2.mo141height(40.0f);
                                                                tVar2.mo113backgroundColor(ProductDetailTableCardViewModel.this.tokenColor("qecommerce_skin_color_bg_default"));
                                                                tVar2.flexDirectionRow();
                                                                tVar2.alignItemsCenter();
                                                                tVar2.justifyContentFlexEnd();
                                                                tVar2.paddingRight(16.0f);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final ProductDetailTableCardViewModel productDetailTableCardViewModel13 = ProductDetailTableCardViewModel.this;
                                                        final ProductDetailProperty productDetailProperty7 = productDetailProperty6;
                                                        cg.a(vVar8, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.table.ProductDetailTableCardView.body.1.2.3.1.2.4.2
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextView textView) {
                                                                final ProductDetailTableCardViewModel productDetailTableCardViewModel14 = ProductDetailTableCardViewModel.this;
                                                                final ProductDetailProperty productDetailProperty8 = productDetailProperty7;
                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.table.ProductDetailTableCardView.body.1.2.3.1.2.4.2.1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ce ceVar) {
                                                                        ce ceVar2 = ceVar;
                                                                        ceVar2.lines(2);
                                                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                                        ceVar2.textAlignRight();
                                                                        ceVar2.textOverFlowTail();
                                                                        ceVar2.mo153width((float) (((ceVar2.getPagerData().m() - 32) * 0.65d) - 32));
                                                                        ceVar2.color(ProductDetailTableCardViewModel.this.tokenColor("qecommerce_skin_color_text_primary"));
                                                                        ceVar2.text(productDetailProperty8.value);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final ProductDetailTableCardViewModel productDetailTableCardViewModel9 = ProductDetailTableCardViewModel.this;
                                        w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.table.ProductDetailTableCardView.body.1.2.3.1.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar5) {
                                                final ProductDetailTableCardViewModel productDetailTableCardViewModel10 = ProductDetailTableCardViewModel.this;
                                                vVar5.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.table.ProductDetailTableCardView.body.1.2.3.1.3.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.mo141height(1.0f);
                                                        tVar2.mo113backgroundColor(ProductDetailTableCardViewModel.this.tokenColor("qecommerce_skin_color_divider"));
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final ProductDetailTableCardViewModel productDetailTableCardViewModel4 = ProductDetailTableCardViewModel.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.table.ProductDetailTableCardView$body$1.3
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(!ProductDetailTableCardViewModel.this.isExpanded());
                    }
                };
                final ProductDetailTableCardViewModel productDetailTableCardViewModel5 = ProductDetailTableCardViewModel.this;
                ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.table.ProductDetailTableCardView$body$1.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final ProductDetailTableCardViewModel productDetailTableCardViewModel6 = ProductDetailTableCardViewModel.this;
                        w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.table.ProductDetailTableCardView.body.1.4.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.table.ProductDetailTableCardView.body.1.4.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.flexDirectionRow();
                                        tVar2.justifyContentFlexStart();
                                        tVar2.mo141height(16.0f);
                                        tVar2.allCenter();
                                        tVar2.mo141height(30.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final ProductDetailTableCardViewModel productDetailTableCardViewModel7 = ProductDetailTableCardViewModel.this;
                                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.table.ProductDetailTableCardView.body.1.4.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final ProductDetailTableCardViewModel productDetailTableCardViewModel8 = ProductDetailTableCardViewModel.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.table.ProductDetailTableCardView.body.1.4.1.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ceVar2.text("\u5c55\u5f00");
                                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                ceVar2.color(ProductDetailTableCardViewModel.this.tokenColor("qecommerce_skin_color_text_secondary"));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.table.ProductDetailTableCardView.body.1.4.1.3
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.table.ProductDetailTableCardView.body.1.4.1.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                af afVar2 = afVar;
                                                afVar2.mo153width(16.0f).mo141height(16.0f);
                                                b.a.b(afVar2, "qecommerce_white_icon_general_arrow_down_secondary", false, 2, null);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final ProductDetailTableCardViewModel productDetailTableCardViewModel8 = ProductDetailTableCardViewModel.this;
                                vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.table.ProductDetailTableCardView.body.1.4.1.4
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(u uVar) {
                                        final ProductDetailTableCardViewModel productDetailTableCardViewModel9 = ProductDetailTableCardViewModel.this;
                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.table.ProductDetailTableCardView.body.1.4.1.4.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                ProductDetailTableCardViewModel.this.switchToFullData();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
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
}
