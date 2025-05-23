package com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page;

import com.tencent.hippykotlin.demo.pages.base.SkinColor;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class ASDRefundAmountCardView extends ComposeView<ASDRefundAmountCardViewAttr, l> {
    public final ASDRefundAmountCardViewAttr viewAttr = new ASDRefundAmountCardViewAttr();

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDRefundAmountCardView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDRefundAmountCardView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.mo113backgroundColor(SkinColor.INSTANCE.fgColor(mVar2.getPagerId()));
                        mVar2.padding(16.0f);
                        return Unit.INSTANCE;
                    }
                });
                final ASDRefundAmountCardView aSDRefundAmountCardView = ASDRefundAmountCardView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDRefundAmountCardView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDRefundAmountCardView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                tVar.flexDirectionRow().justifyContentSpaceBetween().alignItemsCenter();
                                return Unit.INSTANCE;
                            }
                        });
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDRefundAmountCardView.body.1.2.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDRefundAmountCardView.body.1.2.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ce.fontSize$default(ceVar2, 15.0f, null, 2, null).fontWeightMedium().text("\u5408\u8ba1\u9000\u6b3e").color(SkinColor.INSTANCE.blackTextColor(ceVar2.getPagerId()));
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final ASDRefundAmountCardView aSDRefundAmountCardView2 = ASDRefundAmountCardView.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDRefundAmountCardView.body.1.2.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDRefundAmountCardView.body.1.2.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.flexDirectionRow().alignItemsCenter();
                                        tVar2.mo141height(16.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final ASDRefundAmountCardView aSDRefundAmountCardView3 = ASDRefundAmountCardView.this;
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDRefundAmountCardView.body.1.2.3.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final ASDRefundAmountCardView aSDRefundAmountCardView4 = ASDRefundAmountCardView.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDRefundAmountCardView.body.1.2.3.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null).color(SkinColor.INSTANCE.subTextColor(ceVar2.getPagerId())).marginRight(8.0f);
                                                StringBuilder sb5 = new StringBuilder();
                                                sb5.append('\u5171');
                                                ASDRefundAmountCardViewAttr aSDRefundAmountCardViewAttr = ASDRefundAmountCardView.this.viewAttr;
                                                sb5.append((String) aSDRefundAmountCardViewAttr.goodsNum$delegate.getValue(aSDRefundAmountCardViewAttr, ASDRefundAmountCardViewAttr.$$delegatedProperties[0]));
                                                sb5.append("\u4ef6\u5546\u54c1");
                                                ceVar2.text(sb5.toString());
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final ASDRefundAmountCardView aSDRefundAmountCardView4 = ASDRefundAmountCardView.this;
                                vVar4.addChild(new ASDAmountView(), new Function1<ASDAmountView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDRefundAmountCardView.body.1.2.3.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ASDAmountView aSDAmountView) {
                                        final ASDRefundAmountCardView aSDRefundAmountCardView5 = ASDRefundAmountCardView.this;
                                        aSDAmountView.attr(new Function1<ASDAmountViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDRefundAmountCardView.body.1.2.3.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ASDAmountViewAttr aSDAmountViewAttr) {
                                                ASDRefundAmountCardViewAttr aSDRefundAmountCardViewAttr = ASDRefundAmountCardView.this.viewAttr;
                                                aSDAmountViewAttr.amountString((String) aSDRefundAmountCardViewAttr.refundAmount$delegate.getValue(aSDRefundAmountCardViewAttr, ASDRefundAmountCardViewAttr.$$delegatedProperties[1]));
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
                final ASDRefundAmountCardView aSDRefundAmountCardView2 = ASDRefundAmountCardView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDRefundAmountCardView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDRefundAmountCardView.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.flexDirectionRow().justifyContentSpaceBetween().alignItemsCenter();
                                tVar2.marginTop(16.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDRefundAmountCardView.body.1.3.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDRefundAmountCardView.body.1.3.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null).text("\u7533\u8bf7\u91d1\u989d").color(SkinColor.INSTANCE.subTextColor(ceVar2.getPagerId()));
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final ASDRefundAmountCardView aSDRefundAmountCardView3 = ASDRefundAmountCardView.this;
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDRefundAmountCardView.body.1.3.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final ASDRefundAmountCardView aSDRefundAmountCardView4 = ASDRefundAmountCardView.this;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDRefundAmountCardView.body.1.3.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null).color(SkinColor.INSTANCE.subTextColor(ceVar2.getPagerId()));
                                        StringBuilder sb5 = new StringBuilder();
                                        sb5.append('\u00a5');
                                        ASDRefundAmountCardViewAttr aSDRefundAmountCardViewAttr = ASDRefundAmountCardView.this.viewAttr;
                                        sb5.append((String) aSDRefundAmountCardViewAttr.refundAmount$delegate.getValue(aSDRefundAmountCardViewAttr, ASDRefundAmountCardViewAttr.$$delegatedProperties[1]));
                                        ceVar2.text(sb5.toString());
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
        return this.viewAttr;
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}
