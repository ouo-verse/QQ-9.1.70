package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.UtilView;

import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailLabelInfo;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.e;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.k;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.utils.a;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes31.dex */
public final class ProductDetailCouponLabelView extends ComposeView<k, l> {
    public final ProductDetailLabelInfo labelInfo;

    public ProductDetailCouponLabelView(ProductDetailLabelInfo productDetailLabelInfo) {
        this.labelInfo = productDetailLabelInfo;
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.UtilView.ProductDetailCouponLabelView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final ProductDetailCouponLabelView productDetailCouponLabelView = ProductDetailCouponLabelView.this;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.UtilView.ProductDetailCouponLabelView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final ProductDetailCouponLabelView productDetailCouponLabelView2 = ProductDetailCouponLabelView.this;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.UtilView.ProductDetailCouponLabelView.body.1.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                h hVar;
                                t tVar2 = tVar;
                                tVar2.mo141height(16.0f);
                                tVar2.borderRadius(2.0f);
                                tVar2.allCenter();
                                BorderStyle borderStyle = BorderStyle.SOLID;
                                hVar = IPagerIdKtxKt.getSkinColor(tVar2).tokenColor(ProductDetailCouponLabelView.this.labelInfo.borderColor, false);
                                tVar2.m136border(new e(0.5f, borderStyle, hVar));
                                tVar2.padding(2.5f, 6.0f, 2.5f, 6.0f);
                                tVar2.flexDirectionRow();
                                tVar2.justifyContentFlexStart();
                                tVar2.alignItemsCenter();
                                tVar2.marginRight(4.0f);
                                if (ProductDetailCouponLabelView.this.labelInfo.backgroundColor.length() > 0) {
                                    tVar2.mo113backgroundColor(new h(a.f118267a.b(ProductDetailCouponLabelView.this.labelInfo.backgroundColor)));
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        if (ProductDetailCouponLabelView.this.labelInfo.textPrefix.length() > 0) {
                            final ProductDetailCouponLabelView productDetailCouponLabelView3 = ProductDetailCouponLabelView.this;
                            cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.UtilView.ProductDetailCouponLabelView.body.1.1.2
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(TextView textView) {
                                    final ProductDetailCouponLabelView productDetailCouponLabelView4 = ProductDetailCouponLabelView.this;
                                    textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.UtilView.ProductDetailCouponLabelView.body.1.1.2.1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ce ceVar) {
                                            h hVar;
                                            ce ceVar2 = ceVar;
                                            ce.fontSize$default(ceVar2, 10.0f, null, 2, null);
                                            ceVar2.fontFamily("PingFang SC");
                                            hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor(ProductDetailCouponLabelView.this.labelInfo.textColor, false);
                                            ceVar2.color(hVar);
                                            ceVar2.text(ProductDetailCouponLabelView.this.labelInfo.textPrefix);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                            final ProductDetailCouponLabelView productDetailCouponLabelView4 = ProductDetailCouponLabelView.this;
                            w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.UtilView.ProductDetailCouponLabelView.body.1.1.3
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(v vVar3) {
                                    final ProductDetailCouponLabelView productDetailCouponLabelView5 = ProductDetailCouponLabelView.this;
                                    vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.UtilView.ProductDetailCouponLabelView.body.1.1.3.1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(t tVar) {
                                            h hVar;
                                            t tVar2 = tVar;
                                            tVar2.size(0.5f, 9.0f);
                                            tVar2.marginLeft(4.0f);
                                            tVar2.marginRight(4.0f);
                                            hVar = IPagerIdKtxKt.getSkinColor(tVar2).tokenColor(ProductDetailCouponLabelView.this.labelInfo.borderColor, false);
                                            tVar2.mo113backgroundColor(hVar);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                        }
                        final ProductDetailCouponLabelView productDetailCouponLabelView5 = ProductDetailCouponLabelView.this;
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.UtilView.ProductDetailCouponLabelView.body.1.1.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final ProductDetailCouponLabelView productDetailCouponLabelView6 = ProductDetailCouponLabelView.this;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.UtilView.ProductDetailCouponLabelView.body.1.1.4.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        h hVar;
                                        ce ceVar2 = ceVar;
                                        ce.fontSize$default(ceVar2, 10.0f, null, 2, null);
                                        ceVar2.fontFamily("PingFang SC");
                                        hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor(ProductDetailCouponLabelView.this.labelInfo.textColor, false);
                                        ceVar2.color(hVar);
                                        ceVar2.text(ProductDetailCouponLabelView.this.labelInfo.text);
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

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new k();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}
