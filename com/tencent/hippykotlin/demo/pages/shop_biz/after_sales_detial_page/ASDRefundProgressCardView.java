package com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page;

import com.tencent.hippykotlin.demo.pages.base.SkinColor;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.directives.LoopDirectivesView;
import com.tencent.kuikly.core.directives.LoopDirectivesViewKt;
import com.tencent.kuikly.core.reactive.collection.c;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* loaded from: classes33.dex */
public final class ASDRefundProgressCardView extends ComposeView<ASDRefundProgressCardViewAttr, l> {
    public ASDRefundProgressCardViewAttr viewAttr = new ASDRefundProgressCardViewAttr();

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDRefundProgressCardView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDRefundProgressCardView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.mo113backgroundColor(SkinColor.INSTANCE.fgColor(mVar2.getPagerId()));
                        return Unit.INSTANCE;
                    }
                });
                final ASDRefundProgressCardView aSDRefundProgressCardView = ASDRefundProgressCardView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDRefundProgressCardView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDRefundProgressCardView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.margin(16.0f);
                                tVar2.flexDirectionRow();
                                tVar2.justifyContentSpaceBetween();
                                tVar2.alignItemsCenter();
                                return Unit.INSTANCE;
                            }
                        });
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDRefundProgressCardView.body.1.2.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDRefundProgressCardView.body.1.2.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ce.fontSize$default(ceVar2, 15.0f, null, 2, null);
                                        ceVar2.fontWeightMedium();
                                        ceVar2.color(SkinColor.INSTANCE.blackTextColor(ceVar2.getPagerId()));
                                        ceVar2.text("\u5b9e\u9000\u91d1\u989d");
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final ASDRefundProgressCardView aSDRefundProgressCardView2 = ASDRefundProgressCardView.this;
                        vVar2.addChild(new ASDAmountView(), new Function1<ASDAmountView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDRefundProgressCardView.body.1.2.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ASDAmountView aSDAmountView) {
                                final ASDRefundProgressCardView aSDRefundProgressCardView3 = ASDRefundProgressCardView.this;
                                aSDAmountView.attr(new Function1<ASDAmountViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDRefundProgressCardView.body.1.2.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ASDAmountViewAttr aSDAmountViewAttr) {
                                        ASDRefundProgressCardViewAttr aSDRefundProgressCardViewAttr = ASDRefundProgressCardView.this.viewAttr;
                                        aSDAmountViewAttr.amountString((String) aSDRefundProgressCardViewAttr.actualAmount$delegate.getValue(aSDRefundProgressCardViewAttr, ASDRefundProgressCardViewAttr.$$delegatedProperties[0]));
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final ASDRefundProgressCardView aSDRefundProgressCardView2 = ASDRefundProgressCardView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDRefundProgressCardView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        final ASDRefundProgressCardView aSDRefundProgressCardView3 = ASDRefundProgressCardView.this;
                        LoopDirectivesViewKt.a(vVar, new Function0<c<RefundProgressRecord>>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDRefundProgressCardView.body.1.3.1
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final c<RefundProgressRecord> invoke() {
                                return ASDRefundProgressCardView.this.viewAttr.getRefundRecords();
                            }
                        }, new Function2<LoopDirectivesView<RefundProgressRecord>, RefundProgressRecord, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDRefundProgressCardView.body.1.3.2
                            @Override // kotlin.jvm.functions.Function2
                            public final Unit invoke(LoopDirectivesView<RefundProgressRecord> loopDirectivesView, RefundProgressRecord refundProgressRecord) {
                                final RefundProgressRecord refundProgressRecord2 = refundProgressRecord;
                                w.a(loopDirectivesView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDRefundProgressCardView.body.1.3.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar2) {
                                        v vVar3 = vVar2;
                                        vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDRefundProgressCardView.body.1.3.2.1.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.margin(16.0f);
                                                tVar2.marginTop(0.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final RefundProgressRecord refundProgressRecord3 = RefundProgressRecord.this;
                                        w.a(vVar3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDRefundProgressCardView.body.1.3.2.1.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar4) {
                                                v vVar5 = vVar4;
                                                vVar5.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDRefundProgressCardView.body.1.3.2.1.2.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        tVar.flexDirectionRow();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final RefundProgressRecord refundProgressRecord4 = RefundProgressRecord.this;
                                                w.a(vVar5, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDRefundProgressCardView.body.1.3.2.1.2.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar6) {
                                                        v vVar7 = vVar6;
                                                        vVar7.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDRefundProgressCardView.body.1.3.2.1.2.2.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(t tVar) {
                                                                tVar.m140flex(1.0f);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final RefundProgressRecord refundProgressRecord5 = RefundProgressRecord.this;
                                                        cg.a(vVar7, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDRefundProgressCardView.body.1.3.2.1.2.2.2
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextView textView) {
                                                                final RefundProgressRecord refundProgressRecord6 = RefundProgressRecord.this;
                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDRefundProgressCardView.body.1.3.2.1.2.2.2.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ce ceVar) {
                                                                        ce ceVar2 = ceVar;
                                                                        ce.fontSize$default(ceVar2, 15.0f, null, 2, null).fontWeightMedium();
                                                                        ceVar2.text(RefundProgressRecord.this.title);
                                                                        ceVar2.color(SkinColor.INSTANCE.blackTextColor(ceVar2.getPagerId()));
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final RefundProgressRecord refundProgressRecord5 = RefundProgressRecord.this;
                                                cg.a(vVar5, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDRefundProgressCardView.body.1.3.2.1.2.3
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        final RefundProgressRecord refundProgressRecord6 = RefundProgressRecord.this;
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDRefundProgressCardView.body.1.3.2.1.2.3.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                ce ceVar2 = ceVar;
                                                                ce.fontSize$default(ceVar2, 13.0f, null, 2, null);
                                                                ceVar2.text(RefundProgressRecord.this.recordTime);
                                                                ceVar2.marginTop(2.0f);
                                                                ceVar2.color(SkinColor.INSTANCE.subTextColor(ceVar2.getPagerId()));
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final RefundProgressRecord refundProgressRecord4 = RefundProgressRecord.this;
                                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDRefundProgressCardView.body.1.3.2.1.3
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                return RefundProgressRecord.this.content;
                                            }
                                        };
                                        final RefundProgressRecord refundProgressRecord5 = RefundProgressRecord.this;
                                        ConditionViewKt.c(vVar3, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDRefundProgressCardView.body.1.3.2.1.4
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ConditionView conditionView) {
                                                final RefundProgressRecord refundProgressRecord6 = RefundProgressRecord.this;
                                                cg.a(conditionView, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDRefundProgressCardView.body.1.3.2.1.4.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        final RefundProgressRecord refundProgressRecord7 = RefundProgressRecord.this;
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDRefundProgressCardView.body.1.3.2.1.4.1.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                ce ceVar2 = ceVar;
                                                                ceVar2.marginTop(8.0f);
                                                                ce.fontSize$default(ceVar2, 13.0f, null, 2, null);
                                                                ceVar2.color(SkinColor.INSTANCE.blackTextColor(ceVar2.getPagerId()));
                                                                ceVar2.text(RefundProgressRecord.this.content);
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
