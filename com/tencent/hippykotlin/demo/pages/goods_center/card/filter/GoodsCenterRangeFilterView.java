package com.tencent.hippykotlin.demo.pages.goods_center.card.filter;

import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterRangeCond;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.reactive.ReactiveObserver;
import com.tencent.kuikly.core.views.InputEvent;
import com.tencent.kuikly.core.views.InputParams;
import com.tencent.kuikly.core.views.InputView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ai;
import com.tencent.kuikly.core.views.am;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GoodsCenterRangeFilterView extends ComposeView<GoodsCenterRangerAttr, l> {
    public aa<InputView> leftInputRef;
    public aa<InputView> rightInputRef;

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ GoodsCenterRangerAttr access$getAttr(GoodsCenterRangeFilterView goodsCenterRangeFilterView) {
        return (GoodsCenterRangerAttr) goodsCenterRangeFilterView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterRangeFilterView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final GoodsCenterRangeFilterView goodsCenterRangeFilterView = GoodsCenterRangeFilterView.this;
                GoodsCenterRangerAttr access$getAttr = GoodsCenterRangeFilterView.access$getAttr(goodsCenterRangeFilterView);
                final GoodsCenterRangeCond goodsCenterRangeCond = (GoodsCenterRangeCond) access$getAttr.rangeCond$delegate.getValue(access$getAttr, GoodsCenterRangerAttr.$$delegatedProperties[0]);
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterRangeFilterView$body$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterRangeFilterView.body.1.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.flexDirectionColumn();
                                tVar2.padding(8.0f, 16.0f, 8.0f, 16.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        final GoodsCenterRangeCond goodsCenterRangeCond2 = GoodsCenterRangeCond.this;
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterRangeFilterView.body.1.1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final GoodsCenterRangeCond goodsCenterRangeCond3 = GoodsCenterRangeCond.this;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterRangeFilterView.body.1.1.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        h hVar;
                                        ce ceVar2 = ceVar;
                                        ceVar2.value(GoodsCenterRangeCond.this.name);
                                        ce fontSize$default = ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                        hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_primary", false);
                                        fontSize$default.color(hVar);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final GoodsCenterRangeCond goodsCenterRangeCond3 = GoodsCenterRangeCond.this;
                        final GoodsCenterRangeFilterView goodsCenterRangeFilterView2 = goodsCenterRangeFilterView;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterRangeFilterView.body.1.1.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterRangeFilterView.body.1.1.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.flexDirectionRow();
                                        tVar2.alignItemsCenter();
                                        tVar2.marginTop(8.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final GoodsCenterRangeCond goodsCenterRangeCond4 = GoodsCenterRangeCond.this;
                                final GoodsCenterRangeFilterView goodsCenterRangeFilterView3 = goodsCenterRangeFilterView2;
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterRangeFilterView.body.1.1.3.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        v vVar6 = vVar5;
                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterRangeFilterView.body.1.1.3.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.mo141height(32.0f);
                                                tVar2.m140flex(1.0f);
                                                tVar2.flexDirectionRow();
                                                tVar2.borderRadius(20.0f);
                                                tVar2.paddingLeft(20.0f);
                                                tVar2.paddingRight(20.0f);
                                                GoodsCenterRangeFilterView$body$1$1$3$2$1$$ExternalSyntheticOutline0.m(tVar2, "qecommerce_skin_color_btn_secondary_red_normal", false, 2, null);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final GoodsCenterRangeCond goodsCenterRangeCond5 = GoodsCenterRangeCond.this;
                                        final GoodsCenterRangeFilterView goodsCenterRangeFilterView4 = goodsCenterRangeFilterView3;
                                        am.a(vVar6, new Function1<InputView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterRangeFilterView.body.1.1.3.2.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(InputView inputView) {
                                                String valueOf;
                                                InputView inputView2 = inputView;
                                                final GoodsCenterRangeFilterView goodsCenterRangeFilterView5 = goodsCenterRangeFilterView4;
                                                inputView2.ref(inputView2, new Function1<aa<InputView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterRangeFilterView.body.1.1.3.2.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(aa<InputView> aaVar) {
                                                        GoodsCenterRangeFilterView.this.leftInputRef = aaVar;
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final GoodsCenterRangeCond goodsCenterRangeCond6 = GoodsCenterRangeCond.this;
                                                final GoodsCenterRangeFilterView goodsCenterRangeFilterView6 = goodsCenterRangeFilterView4;
                                                inputView2.event(new Function1<InputEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterRangeFilterView.body.1.1.3.2.2.2
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(InputEvent inputEvent) {
                                                        InputEvent inputEvent2 = inputEvent;
                                                        final GoodsCenterRangeCond goodsCenterRangeCond7 = GoodsCenterRangeCond.this;
                                                        InputEvent.q(inputEvent2, false, new Function1<InputParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterRangeFilterView.body.1.1.3.2.2.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(InputParams inputParams) {
                                                                boolean isBlank;
                                                                InputParams inputParams2 = inputParams;
                                                                GoodsCenterRangeCond goodsCenterRangeCond8 = GoodsCenterRangeCond.this;
                                                                isBlank = StringsKt__StringsJVMKt.isBlank(inputParams2.getText());
                                                                goodsCenterRangeCond8.lower = isBlank ? -1L : Long.parseLong(inputParams2.getText());
                                                                return Unit.INSTANCE;
                                                            }
                                                        }, 1, null);
                                                        final GoodsCenterRangeCond goodsCenterRangeCond8 = GoodsCenterRangeCond.this;
                                                        final GoodsCenterRangeFilterView goodsCenterRangeFilterView7 = goodsCenterRangeFilterView6;
                                                        inputEvent2.h(new Function1<InputParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterRangeFilterView.body.1.1.3.2.2.2.2
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(InputParams inputParams) {
                                                                GoodsCenterRangeCond goodsCenterRangeCond9 = GoodsCenterRangeCond.this;
                                                                GoodsCenterRangeFilterView goodsCenterRangeFilterView8 = goodsCenterRangeFilterView7;
                                                                long j3 = goodsCenterRangeCond9.lower;
                                                                if (j3 != -1) {
                                                                    long min = Math.min(j3, goodsCenterRangeCond9.maxLimit);
                                                                    goodsCenterRangeCond9.lower = min;
                                                                    goodsCenterRangeCond9.lower = Math.max(min, goodsCenterRangeCond9.minLimit);
                                                                    aa<InputView> aaVar = goodsCenterRangeFilterView8.leftInputRef;
                                                                    if (aaVar == null) {
                                                                        Intrinsics.throwUninitializedPropertyAccessException("leftInputRef");
                                                                        aaVar = null;
                                                                    }
                                                                    InputView b16 = aaVar.b();
                                                                    if (b16 != null) {
                                                                        b16.setText(String.valueOf(goodsCenterRangeCond9.lower));
                                                                    }
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final GoodsCenterRangeCond goodsCenterRangeCond7 = GoodsCenterRangeCond.this;
                                                inputView2.attr(new Function1<ai, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterRangeFilterView.body.1.1.3.2.2.3
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ai aiVar) {
                                                        h hVar;
                                                        ai aiVar2 = aiVar;
                                                        aiVar2.m140flex(1.0f);
                                                        ai.m(aiVar2, 14.0f, null, 2, null);
                                                        hVar = IPagerIdKtxKt.getSkinColor(aiVar2).tokenColor("qecommerce_skin_color_text_secondary", false);
                                                        aiVar2.i(hVar);
                                                        aiVar2.u(GoodsCenterRangeCond.this.lowerTxt);
                                                        aiVar2.h(false);
                                                        aiVar2.C();
                                                        aiVar2.v(h.INSTANCE.e());
                                                        aiVar2.r();
                                                        aiVar2.t(14);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                long j3 = GoodsCenterRangeCond.this.lower;
                                                if (j3 == -1) {
                                                    valueOf = "";
                                                } else {
                                                    valueOf = String.valueOf(j3);
                                                }
                                                inputView2.setText(valueOf);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final GoodsCenterRangeCond goodsCenterRangeCond6 = GoodsCenterRangeCond.this;
                                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterRangeFilterView.body.1.1.3.2.3
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                boolean isBlank;
                                                isBlank = StringsKt__StringsJVMKt.isBlank(GoodsCenterRangeCond.this.unit);
                                                return Boolean.valueOf(!isBlank);
                                            }
                                        };
                                        final GoodsCenterRangeCond goodsCenterRangeCond7 = GoodsCenterRangeCond.this;
                                        ConditionViewKt.c(vVar6, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterRangeFilterView.body.1.1.3.2.4
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ConditionView conditionView) {
                                                final GoodsCenterRangeCond goodsCenterRangeCond8 = GoodsCenterRangeCond.this;
                                                cg.a(conditionView, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterRangeFilterView.body.1.1.3.2.4.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        final GoodsCenterRangeCond goodsCenterRangeCond9 = GoodsCenterRangeCond.this;
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterRangeFilterView.body.1.1.3.2.4.1.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                h hVar;
                                                                ce ceVar2 = ceVar;
                                                                ceVar2.marginLeft(4.0f);
                                                                ceVar2.value(GoodsCenterRangeCond.this.unit);
                                                                ceVar2.alignSelfCenter();
                                                                hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_secondary", false);
                                                                ceVar2.color(hVar);
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
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterRangeFilterView.body.1.1.3.3
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        vVar5.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterRangeFilterView.body.1.1.3.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.mo153width(17.0f);
                                                tVar2.mo141height(1.0f);
                                                tVar2.marginLeft(8.0f);
                                                tVar2.marginRight(8.0f);
                                                GoodsCenterRangeFilterView$body$1$1$3$2$1$$ExternalSyntheticOutline0.m(tVar2, "qecommerce_skin_color_btn_secondary_red_normal", false, 2, null);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final GoodsCenterRangeCond goodsCenterRangeCond5 = GoodsCenterRangeCond.this;
                                final GoodsCenterRangeFilterView goodsCenterRangeFilterView4 = goodsCenterRangeFilterView2;
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterRangeFilterView.body.1.1.3.4
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        v vVar6 = vVar5;
                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterRangeFilterView.body.1.1.3.4.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.mo141height(32.0f);
                                                tVar2.m140flex(1.0f);
                                                tVar2.flexDirectionRow();
                                                tVar2.borderRadius(20.0f);
                                                tVar2.paddingLeft(20.0f);
                                                tVar2.paddingRight(20.0f);
                                                GoodsCenterRangeFilterView$body$1$1$3$2$1$$ExternalSyntheticOutline0.m(tVar2, "qecommerce_skin_color_btn_secondary_red_normal", false, 2, null);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final GoodsCenterRangeCond goodsCenterRangeCond6 = GoodsCenterRangeCond.this;
                                        final GoodsCenterRangeFilterView goodsCenterRangeFilterView5 = goodsCenterRangeFilterView4;
                                        am.a(vVar6, new Function1<InputView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterRangeFilterView.body.1.1.3.4.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(InputView inputView) {
                                                String valueOf;
                                                InputView inputView2 = inputView;
                                                final GoodsCenterRangeFilterView goodsCenterRangeFilterView6 = goodsCenterRangeFilterView5;
                                                inputView2.ref(inputView2, new Function1<aa<InputView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterRangeFilterView.body.1.1.3.4.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(aa<InputView> aaVar) {
                                                        GoodsCenterRangeFilterView.this.rightInputRef = aaVar;
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final GoodsCenterRangeCond goodsCenterRangeCond7 = GoodsCenterRangeCond.this;
                                                final GoodsCenterRangeFilterView goodsCenterRangeFilterView7 = goodsCenterRangeFilterView5;
                                                inputView2.event(new Function1<InputEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterRangeFilterView.body.1.1.3.4.2.2
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(InputEvent inputEvent) {
                                                        InputEvent inputEvent2 = inputEvent;
                                                        final GoodsCenterRangeCond goodsCenterRangeCond8 = GoodsCenterRangeCond.this;
                                                        InputEvent.q(inputEvent2, false, new Function1<InputParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterRangeFilterView.body.1.1.3.4.2.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(InputParams inputParams) {
                                                                boolean isBlank;
                                                                InputParams inputParams2 = inputParams;
                                                                GoodsCenterRangeCond goodsCenterRangeCond9 = GoodsCenterRangeCond.this;
                                                                isBlank = StringsKt__StringsJVMKt.isBlank(inputParams2.getText());
                                                                goodsCenterRangeCond9.upper = isBlank ? -1L : Long.parseLong(inputParams2.getText());
                                                                return Unit.INSTANCE;
                                                            }
                                                        }, 1, null);
                                                        final GoodsCenterRangeCond goodsCenterRangeCond9 = GoodsCenterRangeCond.this;
                                                        final GoodsCenterRangeFilterView goodsCenterRangeFilterView8 = goodsCenterRangeFilterView7;
                                                        inputEvent2.h(new Function1<InputParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterRangeFilterView.body.1.1.3.4.2.2.2
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(InputParams inputParams) {
                                                                GoodsCenterRangeCond goodsCenterRangeCond10 = GoodsCenterRangeCond.this;
                                                                GoodsCenterRangeFilterView goodsCenterRangeFilterView9 = goodsCenterRangeFilterView8;
                                                                long j3 = goodsCenterRangeCond10.upper;
                                                                if (j3 != -1) {
                                                                    long min = Math.min(j3, goodsCenterRangeCond10.maxLimit);
                                                                    goodsCenterRangeCond10.upper = min;
                                                                    goodsCenterRangeCond10.upper = Math.max(min, goodsCenterRangeCond10.minLimit);
                                                                    aa<InputView> aaVar = goodsCenterRangeFilterView9.rightInputRef;
                                                                    if (aaVar == null) {
                                                                        Intrinsics.throwUninitializedPropertyAccessException("rightInputRef");
                                                                        aaVar = null;
                                                                    }
                                                                    InputView b16 = aaVar.b();
                                                                    if (b16 != null) {
                                                                        b16.setText(String.valueOf(goodsCenterRangeCond10.upper));
                                                                    }
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final GoodsCenterRangeCond goodsCenterRangeCond8 = GoodsCenterRangeCond.this;
                                                inputView2.attr(new Function1<ai, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterRangeFilterView.body.1.1.3.4.2.3
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ai aiVar) {
                                                        h hVar;
                                                        ai aiVar2 = aiVar;
                                                        aiVar2.m140flex(1.0f);
                                                        ai.m(aiVar2, 14.0f, null, 2, null);
                                                        hVar = IPagerIdKtxKt.getSkinColor(aiVar2).tokenColor("qecommerce_skin_color_text_secondary", false);
                                                        aiVar2.i(hVar);
                                                        aiVar2.u(GoodsCenterRangeCond.this.upperTxt);
                                                        aiVar2.h(false);
                                                        aiVar2.C();
                                                        aiVar2.v(h.INSTANCE.e());
                                                        aiVar2.r();
                                                        aiVar2.t(14);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                long j3 = GoodsCenterRangeCond.this.upper;
                                                if (j3 == -1) {
                                                    valueOf = "";
                                                } else {
                                                    valueOf = String.valueOf(j3);
                                                }
                                                inputView2.setText(valueOf);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final GoodsCenterRangeCond goodsCenterRangeCond7 = GoodsCenterRangeCond.this;
                                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterRangeFilterView.body.1.1.3.4.3
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                boolean isBlank;
                                                isBlank = StringsKt__StringsJVMKt.isBlank(GoodsCenterRangeCond.this.unit);
                                                return Boolean.valueOf(!isBlank);
                                            }
                                        };
                                        final GoodsCenterRangeCond goodsCenterRangeCond8 = GoodsCenterRangeCond.this;
                                        ConditionViewKt.c(vVar6, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterRangeFilterView.body.1.1.3.4.4
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ConditionView conditionView) {
                                                final GoodsCenterRangeCond goodsCenterRangeCond9 = GoodsCenterRangeCond.this;
                                                cg.a(conditionView, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterRangeFilterView.body.1.1.3.4.4.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        final GoodsCenterRangeCond goodsCenterRangeCond10 = GoodsCenterRangeCond.this;
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterRangeFilterView.body.1.1.3.4.4.1.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                h hVar;
                                                                ce ceVar2 = ceVar;
                                                                ceVar2.marginLeft(4.0f);
                                                                ceVar2.value(GoodsCenterRangeCond.this.unit);
                                                                ceVar2.alignSelfCenter();
                                                                hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_secondary", false);
                                                                ceVar2.color(hVar);
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
                                ReactiveObserver.Companion companion = ReactiveObserver.INSTANCE;
                                final GoodsCenterRangeCond goodsCenterRangeCond6 = GoodsCenterRangeCond.this;
                                final GoodsCenterRangeFilterView goodsCenterRangeFilterView5 = goodsCenterRangeFilterView2;
                                companion.b(goodsCenterRangeCond6, new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterRangeFilterView.body.1.1.3.5
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Boolean bool) {
                                        String valueOf;
                                        bool.booleanValue();
                                        aa<InputView> aaVar = GoodsCenterRangeFilterView.this.leftInputRef;
                                        aa<InputView> aaVar2 = null;
                                        if (aaVar == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("leftInputRef");
                                            aaVar = null;
                                        }
                                        InputView b16 = aaVar.b();
                                        String str = "";
                                        if (b16 != null) {
                                            long j3 = goodsCenterRangeCond6.lower;
                                            if (j3 == -1) {
                                                valueOf = "";
                                            } else {
                                                valueOf = String.valueOf(j3);
                                            }
                                            b16.setText(valueOf);
                                        }
                                        aa<InputView> aaVar3 = GoodsCenterRangeFilterView.this.rightInputRef;
                                        if (aaVar3 == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("rightInputRef");
                                        } else {
                                            aaVar2 = aaVar3;
                                        }
                                        InputView b17 = aaVar2.b();
                                        if (b17 != null) {
                                            long j16 = goodsCenterRangeCond6.upper;
                                            if (j16 != -1) {
                                                str = String.valueOf(j16);
                                            }
                                            b17.setText(str);
                                        }
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
        return new GoodsCenterRangerAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}
