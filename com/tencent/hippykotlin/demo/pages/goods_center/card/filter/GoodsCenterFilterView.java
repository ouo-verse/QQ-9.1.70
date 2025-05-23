package com.tencent.hippykotlin.demo.pages.goods_center.card.filter;

import com.tencent.hippykotlin.demo.pages.base.ISkinColor;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterFilterCond;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterFilterOption;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.a;
import com.tencent.kuikly.core.base.attr.c;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.directives.BindDirectivesView;
import com.tencent.kuikly.core.directives.BindDirectivesViewKt;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.ck;
import com.tencent.kuikly.core.views.cm;
import com.tencent.kuikly.core.views.cn;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GoodsCenterFilterView extends ComposeView<GoodsCenterFilterAttr, l> {
    public static final /* synthetic */ int $r8$clinit = 0;

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ GoodsCenterFilterAttr access$getAttr(GoodsCenterFilterView goodsCenterFilterView) {
        return (GoodsCenterFilterAttr) goodsCenterFilterView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterFilterView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final GoodsCenterFilterView goodsCenterFilterView = GoodsCenterFilterView.this;
                GoodsCenterFilterViewMode goodsCenterFilterViewMode = GoodsCenterFilterView.access$getAttr(goodsCenterFilterView).filterCondViewModel;
                final GoodsCenterFilterCond goodsCenterFilterCond = goodsCenterFilterViewMode != null ? goodsCenterFilterViewMode.filterCond : null;
                ConditionViewKt.c(viewContainer2, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterFilterView$body$1.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(GoodsCenterFilterCond.this != null);
                    }
                }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterFilterView$body$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        ConditionView conditionView2 = conditionView;
                        final GoodsCenterFilterCond goodsCenterFilterCond2 = GoodsCenterFilterCond.this;
                        if (goodsCenterFilterCond2 == null) {
                            goodsCenterFilterCond2 = new GoodsCenterFilterCond(0, null, null, false, 15, null);
                        }
                        final GoodsCenterFilterView goodsCenterFilterView2 = goodsCenterFilterView;
                        w.a(conditionView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterFilterView.body.1.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterFilterView.body.1.2.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.flexDirectionColumn();
                                        tVar2.padding(8.0f, 16.0f, 0.0f, 16.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final GoodsCenterFilterCond goodsCenterFilterCond3 = GoodsCenterFilterCond.this;
                                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterFilterView.body.1.2.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final GoodsCenterFilterCond goodsCenterFilterCond4 = GoodsCenterFilterCond.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterFilterView.body.1.2.1.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                h hVar;
                                                ce ceVar2 = ceVar;
                                                ceVar2.value(GoodsCenterFilterCond.this.name);
                                                ce fontSize$default = ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_primary", false);
                                                fontSize$default.color(hVar);
                                                ceVar2.marginBottom(8.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final GoodsCenterFilterCond goodsCenterFilterCond4 = GoodsCenterFilterCond.this;
                                final GoodsCenterFilterView goodsCenterFilterView3 = goodsCenterFilterView2;
                                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterFilterView.body.1.2.1.3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        v vVar4 = vVar3;
                                        final GoodsCenterFilterCond goodsCenterFilterCond5 = GoodsCenterFilterCond.this;
                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterFilterView.body.1.2.1.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                int i3;
                                                t tVar2 = tVar;
                                                int size = GoodsCenterFilterCond.this.options.size();
                                                if (size > 0) {
                                                    int i16 = size / 3;
                                                    if (size % 3 != 0) {
                                                        i16++;
                                                    }
                                                    i3 = (i16 * 36) - 8;
                                                } else {
                                                    i3 = 0;
                                                }
                                                tVar2.mo141height(i3);
                                                tVar2.m140flex(1.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final GoodsCenterFilterCond goodsCenterFilterCond6 = GoodsCenterFilterCond.this;
                                        final GoodsCenterFilterView goodsCenterFilterView4 = goodsCenterFilterView3;
                                        cn.a(vVar4, new Function1<cm, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterFilterView.body.1.2.1.3.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(cm cmVar) {
                                                cm cmVar2 = cmVar;
                                                cmVar2.attr(new Function1<ck, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterFilterView.body.1.2.1.3.2.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ck ckVar) {
                                                        ck ckVar2 = ckVar;
                                                        ckVar2.w(ckVar2.getPagerData().m() - 32.0f);
                                                        ckVar2.h(3);
                                                        ckVar2.u(8.0f);
                                                        ckVar2.t(8.0f);
                                                        ckVar2.m140flex(1.0f).alignSelfStretch();
                                                        a.C5863a.a(ckVar2, 8.0f, 16.0f, 0.0f, 16.0f, 4, null);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                List<GoodsCenterFilterOption> list = GoodsCenterFilterCond.this.options;
                                                final GoodsCenterFilterView goodsCenterFilterView5 = goodsCenterFilterView4;
                                                for (final GoodsCenterFilterOption goodsCenterFilterOption : list) {
                                                    int i3 = GoodsCenterFilterView.$r8$clinit;
                                                    goodsCenterFilterView5.getClass();
                                                    new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterFilterView$buildCondFilterOptionItem$1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                                            final GoodsCenterFilterViewMode goodsCenterFilterViewMode2 = GoodsCenterFilterView.access$getAttr(GoodsCenterFilterView.this).filterCondViewModel;
                                                            final GoodsCenterFilterOption goodsCenterFilterOption2 = goodsCenterFilterOption;
                                                            Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterFilterView$buildCondFilterOptionItem$1.1
                                                                {
                                                                    super(0);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function0
                                                                public final Object invoke() {
                                                                    return Boolean.valueOf(GoodsCenterFilterOption.this.isSelected());
                                                                }
                                                            };
                                                            final GoodsCenterFilterOption goodsCenterFilterOption3 = goodsCenterFilterOption;
                                                            BindDirectivesViewKt.a(viewContainer3, function0, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterFilterView$buildCondFilterOptionItem$1.2
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(BindDirectivesView bindDirectivesView) {
                                                                    final GoodsCenterFilterOption goodsCenterFilterOption4 = GoodsCenterFilterOption.this;
                                                                    final GoodsCenterFilterViewMode goodsCenterFilterViewMode3 = goodsCenterFilterViewMode2;
                                                                    w.a(bindDirectivesView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterFilterView.buildCondFilterOptionItem.1.2.1
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(v vVar5) {
                                                                            v vVar6 = vVar5;
                                                                            final GoodsCenterFilterOption goodsCenterFilterOption5 = GoodsCenterFilterOption.this;
                                                                            vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterFilterView.buildCondFilterOptionItem.1.2.1.1
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(t tVar) {
                                                                                    String str;
                                                                                    h hVar;
                                                                                    t tVar2 = tVar;
                                                                                    tVar2.mo141height(28.0f);
                                                                                    tVar2.borderRadius(14.0f);
                                                                                    ISkinColor skinColor = IPagerIdKtxKt.getSkinColor(tVar2);
                                                                                    if (GoodsCenterFilterOption.this.isSelected()) {
                                                                                        str = "qecommerce_skin_color_tag_light";
                                                                                    } else {
                                                                                        str = "qecommerce_skin_color_btn_secondary_red_normal";
                                                                                    }
                                                                                    hVar = skinColor.tokenColor(str, false);
                                                                                    tVar2.mo113backgroundColor(hVar);
                                                                                    c.a.a(tVar2, 0.0f, 4.0f, 0.0f, 4.0f, 5, null);
                                                                                    tVar2.allCenter();
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            });
                                                                            final GoodsCenterFilterViewMode goodsCenterFilterViewMode4 = goodsCenterFilterViewMode3;
                                                                            final GoodsCenterFilterOption goodsCenterFilterOption6 = GoodsCenterFilterOption.this;
                                                                            vVar6.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterFilterView.buildCondFilterOptionItem.1.2.1.2
                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(u uVar) {
                                                                                    final GoodsCenterFilterViewMode goodsCenterFilterViewMode5 = GoodsCenterFilterViewMode.this;
                                                                                    final GoodsCenterFilterOption goodsCenterFilterOption7 = goodsCenterFilterOption6;
                                                                                    uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterFilterView.buildCondFilterOptionItem.1.2.1.2.1
                                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                        {
                                                                                            super(1);
                                                                                        }

                                                                                        @Override // kotlin.jvm.functions.Function1
                                                                                        public final Unit invoke(ClickParams clickParams) {
                                                                                            boolean z16;
                                                                                            GoodsCenterFilterViewMode goodsCenterFilterViewMode6 = GoodsCenterFilterViewMode.this;
                                                                                            if (goodsCenterFilterViewMode6 != null) {
                                                                                                GoodsCenterFilterOption goodsCenterFilterOption8 = goodsCenterFilterOption7;
                                                                                                Iterator<GoodsCenterFilterOption> it = goodsCenterFilterViewMode6.filterCond.options.iterator();
                                                                                                while (true) {
                                                                                                    if (!it.hasNext()) {
                                                                                                        break;
                                                                                                    }
                                                                                                    GoodsCenterFilterOption next = it.next();
                                                                                                    if (Intrinsics.areEqual(next, goodsCenterFilterOption8)) {
                                                                                                        if (next.isSelected()) {
                                                                                                            Iterator<GoodsCenterFilterOption> it5 = goodsCenterFilterViewMode6.filterCond.options.iterator();
                                                                                                            while (true) {
                                                                                                                if (!it5.hasNext()) {
                                                                                                                    z16 = true;
                                                                                                                    break;
                                                                                                                }
                                                                                                                GoodsCenterFilterOption next2 = it5.next();
                                                                                                                if (!Intrinsics.areEqual(next2, goodsCenterFilterOption8) && next2.isSelected()) {
                                                                                                                    z16 = false;
                                                                                                                    break;
                                                                                                                }
                                                                                                            }
                                                                                                            if (!z16) {
                                                                                                                next.setSelected(false);
                                                                                                            }
                                                                                                        }
                                                                                                        if (!next.isSelected()) {
                                                                                                            next.setSelected(true);
                                                                                                            GoodsCenterFilterCond goodsCenterFilterCond7 = goodsCenterFilterViewMode6.filterCond;
                                                                                                            if (goodsCenterFilterCond7.multi && !next.mutex) {
                                                                                                                for (GoodsCenterFilterOption goodsCenterFilterOption9 : goodsCenterFilterCond7.options) {
                                                                                                                    if (goodsCenterFilterOption9.mutex) {
                                                                                                                        goodsCenterFilterOption9.setSelected(false);
                                                                                                                    }
                                                                                                                }
                                                                                                            } else {
                                                                                                                for (GoodsCenterFilterOption goodsCenterFilterOption10 : goodsCenterFilterCond7.options) {
                                                                                                                    if (!Intrinsics.areEqual(goodsCenterFilterOption10, goodsCenterFilterOption8) && goodsCenterFilterOption10.isSelected()) {
                                                                                                                        goodsCenterFilterOption10.setSelected(false);
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                            Utils.INSTANCE.currentBridgeModule().callNativeMethod("closeKeyboard", null, null);
                                                                                            return Unit.INSTANCE;
                                                                                        }
                                                                                    });
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            });
                                                                            final GoodsCenterFilterOption goodsCenterFilterOption7 = GoodsCenterFilterOption.this;
                                                                            cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterFilterView.buildCondFilterOptionItem.1.2.1.3
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(TextView textView) {
                                                                                    final GoodsCenterFilterOption goodsCenterFilterOption8 = GoodsCenterFilterOption.this;
                                                                                    textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterFilterView.buildCondFilterOptionItem.1.2.1.3.1
                                                                                        {
                                                                                            super(1);
                                                                                        }

                                                                                        @Override // kotlin.jvm.functions.Function1
                                                                                        public final Unit invoke(ce ceVar) {
                                                                                            String str;
                                                                                            h hVar;
                                                                                            ce ceVar2 = ceVar;
                                                                                            ISkinColor skinColor = IPagerIdKtxKt.getSkinColor(ceVar2);
                                                                                            if (GoodsCenterFilterOption.this.isSelected()) {
                                                                                                str = "qecommerce_skin_color_btn_primary_red_normal";
                                                                                            } else {
                                                                                                str = "qecommerce_skin_color_text_secondary";
                                                                                            }
                                                                                            hVar = skinColor.tokenColor(str, false);
                                                                                            ceVar2.color(hVar);
                                                                                            ceVar2.text(GoodsCenterFilterOption.this.name);
                                                                                            ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                                                            ceVar2.textAlignCenter();
                                                                                            ceVar2.lines(1);
                                                                                            ceVar2.textOverFlowClip();
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
                                                    }.invoke(cmVar2);
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
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new GoodsCenterFilterAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}
