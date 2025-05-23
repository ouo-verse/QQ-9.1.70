package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.priceDescription;

import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterRangeFilterView$body$1$1$3$2$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailCardView;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.coupon.ProductDetailShopCouponView$body$2$2$3$2$1$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.views.RichTextAttr;
import com.tencent.kuikly.core.views.RichTextView;
import com.tencent.kuikly.core.views.RichTextViewKt;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cf;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes31.dex */
public final class ProductDetailPriceDescriptionView extends ProductDetailCardView {
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.priceDescription.ProductDetailPriceDescriptionView$body$1
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.priceDescription.ProductDetailPriceDescriptionView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        h hVar;
                        m mVar2 = mVar;
                        mVar2.flexDirectionColumn();
                        mVar2.mo153width(mVar2.getPagerData().m());
                        mVar2.alignItemsCenter();
                        hVar = IPagerIdKtxKt.getSkinColor(mVar2).tokenColor("qecommerce_skin_color_bg_default", false);
                        mVar2.mo113backgroundColor(hVar);
                        return Unit.INSTANCE;
                    }
                });
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.priceDescription.ProductDetailPriceDescriptionView$body$1.2
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.priceDescription.ProductDetailPriceDescriptionView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.mo153width(tVar2.getPagerData().m());
                                tVar2.justifyContentFlexStart();
                                tVar2.alignItemsCenter();
                                tVar2.flexDirectionRow();
                                tVar2.marginBottom(13.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.priceDescription.ProductDetailPriceDescriptionView.body.1.2.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.priceDescription.ProductDetailPriceDescriptionView.body.1.2.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.m140flex(1.0f);
                                        tVar2.mo141height(0.5f);
                                        tVar2.marginLeft(16.0f);
                                        tVar2.marginRight(12.0f);
                                        GoodsCenterRangeFilterView$body$1$1$3$2$1$$ExternalSyntheticOutline0.m(tVar2, "qecommerce_skin_color_divider", false, 2, null);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.priceDescription.ProductDetailPriceDescriptionView.body.1.2.3
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.priceDescription.ProductDetailPriceDescriptionView.body.1.2.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ceVar2.m140flex(0.0f);
                                        ceVar2.text("\u4ef7\u683c\u8bf4\u660e");
                                        ProductDetailShopCouponView$body$2$2$3$2$1$$ExternalSyntheticOutline0.m(ceVar2, 13.0f, null, 2, null, ceVar2, "qecommerce_skin_color_text_secondary", false, 2, null);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.priceDescription.ProductDetailPriceDescriptionView.body.1.2.4
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.priceDescription.ProductDetailPriceDescriptionView.body.1.2.4.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.m140flex(1.0f);
                                        tVar2.mo141height(0.5f);
                                        tVar2.marginLeft(12.0f);
                                        tVar2.marginRight(16.0f);
                                        GoodsCenterRangeFilterView$body$1$1$3$2$1$$ExternalSyntheticOutline0.m(tVar2, "qecommerce_skin_color_divider", false, 2, null);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                RichTextViewKt.b(viewContainer2, new Function1<RichTextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.priceDescription.ProductDetailPriceDescriptionView$body$1.3
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(RichTextView richTextView) {
                        RichTextView richTextView2 = richTextView;
                        richTextView2.attr(new Function1<RichTextAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.priceDescription.ProductDetailPriceDescriptionView.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(RichTextAttr richTextAttr) {
                                h hVar;
                                RichTextAttr richTextAttr2 = richTextAttr;
                                richTextAttr2.margin(8.0f, 16.0f, 12.0f, 16.0f);
                                richTextAttr2.mo153width(richTextAttr2.getPagerData().m() - 32.0f);
                                richTextAttr2.lineHeight(19.6f);
                                richTextAttr2.paragraphSpacing(12.0f);
                                hVar = IPagerIdKtxKt.getSkinColor(richTextAttr2).tokenColor("qecommerce_skin_color_bg_default", false);
                                richTextAttr2.mo113backgroundColor(hVar);
                                return Unit.INSTANCE;
                            }
                        });
                        RichTextViewKt.c(richTextView2, new Function1<cf, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.priceDescription.ProductDetailPriceDescriptionView.body.1.3.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(cf cfVar) {
                                h hVar;
                                cf cfVar2 = cfVar;
                                cfVar2.text("\u5212\u7ebf\u4ef7\u683c\uff1a\u5546\u54c1\u7684\u4e13\u67dc\u4ef7\u3001\u540a\u724c\u4ef7\u3001\u6b63\u54c1\u96f6\u552e\u4ef7\u3001\u5382\u5546\u6307\u5bfc\u4ef7\u6216\u8be5\u5546\u54c1\u7684\u66fe\u7ecf\u5c55\u793a\u8fc7\u7684\u9500\u552e\u4ef7\u7b49\uff0c\u5e76\u975e\u539f\u4ef7\uff0c\u4ec5\u4f9b\u53c2\u8003\u3002\n\u672a\u5212\u7ebf\u4ef7\u683c\uff1a\u5546\u54c1\u7684\u5b9e\u65f6\u6807\u4ef7\uff0c\u4e0d\u56e0\u8868\u8ff0\u7684\u5dee\u5f02\u6539\u53d8\u6027\u8d28\u3002\u5177\u4f53\u6210\u4ea4\u4ef7\u683c\u6839\u636e\u5546\u54c1\u53c2\u52a0\u6d3b\u52a8\uff0c\u6216\u4f1a\u5458\u4f7f\u7528\u4f18\u60e0\u5238\u3001\u79ef\u5206\u7b49\u53d1\u751f\u53d8\u5316\uff0c\u6700\u7ec8\u4ee5\u8ba2\u5355\u7ed3\u7b97\u9875\u4ef7\u683c\u4e3a\u51c6\u3002\n\u5546\u5bb6\u8be6\u60c5\u9875(\u542b\u4e3b\u56fe)\u4ee5\u56fe\u7247\u6216\u6587\u5b57\u5f62\u5f0f\u6807\u6ce8\u7684\u4e00\u53e3\u4ef7\u3001\u4fc3\u9500\u4ef7\u3001\u4f18\u60e0\u4ef7\u7b49\u4ef7\u683c\u53ef\u80fd\u662f\u5728\u4f7f\u7528\u4f18\u60e0\u5238\u3001\u6ee1\u51cf\u6216\u7279\u5b9a\u4f18\u60e0\u6d3b\u52a8\u548c\u65f6\u6bb5\u7b49\u60c5\u5f62\u4e0b\u7684\u4ef7\u683c\uff0c\u5177\u4f53\u8bf7\u4ee5\u7ed3\u7b97\u9875\u9762\u7684\u6807\u4ef7\u3001\u4f18\u60e0\u6761\u4ef6\u6216\u6d3b\u52a8\u89c4\u5219\u4e3a\u51c6\u3002");
                                hVar = IPagerIdKtxKt.getSkinColor(cfVar2).tokenColor("qecommerce_skin_color_text_secondary", false);
                                cfVar2.color(hVar);
                                ce.fontSize$default(cfVar2, 12.0f, null, 2, null);
                                cfVar2.fontWeight400();
                                return Unit.INSTANCE;
                            }
                        });
                        RichTextViewKt.c(richTextView2, new Function1<cf, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.priceDescription.ProductDetailPriceDescriptionView.body.1.3.3
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(cf cfVar) {
                                h hVar;
                                final cf cfVar2 = cfVar;
                                cfVar2.text("\u300aQQ\u5c0f\u5e97\u5546\u54c1\u4ef7\u683c\u7ba1\u7406\u89c4\u8303\u300b");
                                cfVar2.fontWeight400();
                                ce.fontSize$default(cfVar2, 12.0f, null, 2, null);
                                hVar = IPagerIdKtxKt.getSkinColor(cfVar2).tokenColor("qecommerce_skin_color_text_link", false);
                                cfVar2.color(hVar);
                                cfVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.priceDescription.ProductDetailPriceDescriptionView.body.1.3.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        BridgeModule.openPage$default(IPagerIdKtxKt.getBridgeModule(cf.this), "https://docs.qq.com/doc/p/0c3ff492a9c5e12022e7bc05bc1f6bba12f57b1e?dver=3.0.0", false, null, null, 30);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        RichTextViewKt.c(richTextView2, new Function1<cf, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.priceDescription.ProductDetailPriceDescriptionView.body.1.3.4
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(cf cfVar) {
                                h hVar;
                                cf cfVar2 = cfVar;
                                cfVar2.text("\u3002\u82e5\u5546\u5bb6\u5355\u72ec\u5bf9\u5212\u7ebf\u4ef7\u683c\u8fdb\u884c\u8bf4\u660e\u7684\uff0c\u4ee5\u5546\u5bb6\u7684\u8868\u8ff0\u4e3a\u51c6\u3002");
                                hVar = IPagerIdKtxKt.getSkinColor(cfVar2).tokenColor("qecommerce_skin_color_text_secondary", false);
                                cfVar2.color(hVar);
                                ce.fontSize$default(cfVar2, 12.0f, null, 2, null);
                                cfVar2.fontWeight400();
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
