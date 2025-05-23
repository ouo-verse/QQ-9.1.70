package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.component;

import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.a;
import com.tencent.kuikly.core.base.attr.c;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.BindDirectivesView;
import com.tencent.kuikly.core.directives.BindDirectivesViewKt;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class TimerCountDownView extends ComposeView<TimerCountDownAttr, l> {
    public static final String access$longValueToTimeString(TimerCountDownView timerCountDownView, Long l3) {
        timerCountDownView.getClass();
        if (l3 == null) {
            return "00";
        }
        if (l3.longValue() < 10) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append('0');
            sb5.append(l3);
            return sb5.toString();
        }
        return l3.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final TimerCountDownAttr timerCountDownAttr = (TimerCountDownAttr) getAttr();
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.component.TimerCountDownView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.component.TimerCountDownView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.mo141height(20.0f);
                        mVar2.flexDirectionRow();
                        mVar2.justifyContentCenter();
                        mVar2.alignItemsCenter();
                        return Unit.INSTANCE;
                    }
                });
                final TimerCountDownAttr timerCountDownAttr2 = TimerCountDownAttr.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.component.TimerCountDownView$body$1.2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return TimerCountDownAttr.this.getRemainingTime();
                    }
                };
                final TimerCountDownView timerCountDownView = this;
                final TimerCountDownAttr timerCountDownAttr3 = TimerCountDownAttr.this;
                BindDirectivesViewKt.a(viewContainer2, function0, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.component.TimerCountDownView$body$1.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(BindDirectivesView bindDirectivesView) {
                        BindDirectivesView bindDirectivesView2 = bindDirectivesView;
                        final TimerCountDownView timerCountDownView2 = TimerCountDownView.this;
                        final TimerCountDownAttr timerCountDownAttr4 = timerCountDownAttr3;
                        w.a(bindDirectivesView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.component.TimerCountDownView.body.1.3.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.component.TimerCountDownView.body.1.3.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.mo141height(20.0f);
                                        tVar2.m146minWidth(20.0f);
                                        a.C5863a.a(tVar2, 0.0f, 2.5f, 0.0f, 2.5f, 5, null);
                                        tVar2.mo113backgroundColor(new h(654311423L));
                                        tVar2.allCenter();
                                        tVar2.borderRadius(2.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final TimerCountDownView timerCountDownView3 = TimerCountDownView.this;
                                final TimerCountDownAttr timerCountDownAttr5 = timerCountDownAttr4;
                                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.component.TimerCountDownView.body.1.3.1.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final TimerCountDownView timerCountDownView4 = TimerCountDownView.this;
                                        final TimerCountDownAttr timerCountDownAttr6 = timerCountDownAttr5;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.component.TimerCountDownView.body.1.3.1.2.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                TimerCountDownView timerCountDownView5 = TimerCountDownView.this;
                                                RemainingTime remainingTime = timerCountDownAttr6.getRemainingTime();
                                                ceVar2.value(TimerCountDownView.access$longValueToTimeString(timerCountDownView5, remainingTime != null ? Long.valueOf(remainingTime.remainingDay) : null));
                                                ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                ceVar2.fontWeight500();
                                                ceVar2.color(h.INSTANCE.m());
                                                ceVar2.fontFamily("PingFang SC");
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        cg.a(bindDirectivesView2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.component.TimerCountDownView.body.1.3.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.component.TimerCountDownView.body.1.3.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ceVar2.value("\u5929");
                                        ceVar2.fontWeight500();
                                        ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                        ceVar2.color(h.INSTANCE.m());
                                        ceVar2.fontFamily("PingFang SC");
                                        c.a.a(ceVar2, 0.0f, 4.0f, 0.0f, 4.0f, 5, null);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final TimerCountDownView timerCountDownView3 = TimerCountDownView.this;
                        final TimerCountDownAttr timerCountDownAttr5 = timerCountDownAttr3;
                        w.a(bindDirectivesView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.component.TimerCountDownView.body.1.3.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.component.TimerCountDownView.body.1.3.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.mo141height(20.0f);
                                        tVar2.m146minWidth(20.0f);
                                        a.C5863a.a(tVar2, 0.0f, 2.5f, 0.0f, 2.5f, 5, null);
                                        tVar2.mo113backgroundColor(new h(654311423L));
                                        tVar2.allCenter();
                                        tVar2.borderRadius(2.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final TimerCountDownView timerCountDownView4 = TimerCountDownView.this;
                                final TimerCountDownAttr timerCountDownAttr6 = timerCountDownAttr5;
                                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.component.TimerCountDownView.body.1.3.3.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final TimerCountDownView timerCountDownView5 = TimerCountDownView.this;
                                        final TimerCountDownAttr timerCountDownAttr7 = timerCountDownAttr6;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.component.TimerCountDownView.body.1.3.3.2.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                TimerCountDownView timerCountDownView6 = TimerCountDownView.this;
                                                RemainingTime remainingTime = timerCountDownAttr7.getRemainingTime();
                                                ceVar2.value(TimerCountDownView.access$longValueToTimeString(timerCountDownView6, remainingTime != null ? Long.valueOf(remainingTime.remainingHour) : null));
                                                ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                ceVar2.fontWeight500();
                                                ceVar2.color(h.INSTANCE.m());
                                                ceVar2.fontFamily("PingFang SC");
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        cg.a(bindDirectivesView2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.component.TimerCountDownView.body.1.3.4
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.component.TimerCountDownView.body.1.3.4.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ceVar2.value(":");
                                        ceVar2.fontWeight500();
                                        ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                        ceVar2.color(h.INSTANCE.m());
                                        ceVar2.fontFamily("PingFang SC");
                                        c.a.a(ceVar2, 0.0f, 2.0f, 0.0f, 2.0f, 5, null);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final TimerCountDownView timerCountDownView4 = TimerCountDownView.this;
                        final TimerCountDownAttr timerCountDownAttr6 = timerCountDownAttr3;
                        w.a(bindDirectivesView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.component.TimerCountDownView.body.1.3.5
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.component.TimerCountDownView.body.1.3.5.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.mo141height(20.0f);
                                        tVar2.m146minWidth(20.0f);
                                        a.C5863a.a(tVar2, 0.0f, 2.5f, 0.0f, 2.5f, 5, null);
                                        tVar2.mo113backgroundColor(new h(654311423L));
                                        tVar2.allCenter();
                                        tVar2.borderRadius(2.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final TimerCountDownView timerCountDownView5 = TimerCountDownView.this;
                                final TimerCountDownAttr timerCountDownAttr7 = timerCountDownAttr6;
                                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.component.TimerCountDownView.body.1.3.5.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final TimerCountDownView timerCountDownView6 = TimerCountDownView.this;
                                        final TimerCountDownAttr timerCountDownAttr8 = timerCountDownAttr7;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.component.TimerCountDownView.body.1.3.5.2.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                TimerCountDownView timerCountDownView7 = TimerCountDownView.this;
                                                RemainingTime remainingTime = timerCountDownAttr8.getRemainingTime();
                                                ceVar2.value(TimerCountDownView.access$longValueToTimeString(timerCountDownView7, remainingTime != null ? Long.valueOf(remainingTime.remainingMin) : null));
                                                ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                ceVar2.fontWeight500();
                                                ceVar2.color(h.INSTANCE.m());
                                                ceVar2.fontFamily("PingFang SC");
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        cg.a(bindDirectivesView2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.component.TimerCountDownView.body.1.3.6
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.component.TimerCountDownView.body.1.3.6.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ceVar2.value(":");
                                        ceVar2.fontWeight500();
                                        ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                        ceVar2.color(h.INSTANCE.m());
                                        ceVar2.fontFamily("PingFang SC");
                                        c.a.a(ceVar2, 0.0f, 2.0f, 0.0f, 2.0f, 5, null);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final TimerCountDownView timerCountDownView5 = TimerCountDownView.this;
                        final TimerCountDownAttr timerCountDownAttr7 = timerCountDownAttr3;
                        w.a(bindDirectivesView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.component.TimerCountDownView.body.1.3.7
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.component.TimerCountDownView.body.1.3.7.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.mo141height(20.0f);
                                        tVar2.m146minWidth(20.0f);
                                        a.C5863a.a(tVar2, 0.0f, 2.5f, 0.0f, 2.5f, 5, null);
                                        tVar2.mo113backgroundColor(new h(654311423L));
                                        tVar2.allCenter();
                                        tVar2.borderRadius(2.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final TimerCountDownView timerCountDownView6 = TimerCountDownView.this;
                                final TimerCountDownAttr timerCountDownAttr8 = timerCountDownAttr7;
                                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.component.TimerCountDownView.body.1.3.7.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final TimerCountDownView timerCountDownView7 = TimerCountDownView.this;
                                        final TimerCountDownAttr timerCountDownAttr9 = timerCountDownAttr8;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.component.TimerCountDownView.body.1.3.7.2.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                TimerCountDownView timerCountDownView8 = TimerCountDownView.this;
                                                RemainingTime remainingTime = timerCountDownAttr9.getRemainingTime();
                                                ceVar2.value(TimerCountDownView.access$longValueToTimeString(timerCountDownView8, remainingTime != null ? Long.valueOf(remainingTime.remainingSec) : null));
                                                ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                ceVar2.fontWeight500();
                                                ceVar2.color(h.INSTANCE.m());
                                                ceVar2.fontFamily("PingFang SC");
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
        return new TimerCountDownAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}
