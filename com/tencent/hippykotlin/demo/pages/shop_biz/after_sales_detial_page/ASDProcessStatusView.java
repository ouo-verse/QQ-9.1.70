package com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page;

import com.tencent.hippykotlin.demo.pages.base.SkinColor;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.attr.c;
import com.tencent.kuikly.core.base.e;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.directives.LoopDirectivesView;
import com.tencent.kuikly.core.directives.LoopDirectivesViewKt;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.RichTextAttr;
import com.tencent.kuikly.core.views.RichTextView;
import com.tencent.kuikly.core.views.RichTextViewKt;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* loaded from: classes33.dex */
public final class ASDProcessStatusView extends ComposeView<ASDProcessStatusViewAttr, l> {
    public ASDProcessStatusViewAttr viewAttr = new ASDProcessStatusViewAttr();

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDProcessStatusView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDProcessStatusView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.mo113backgroundColor(SkinColor.INSTANCE.fgColor(mVar2.getPagerId()));
                        return Unit.INSTANCE;
                    }
                });
                final ASDProcessStatusView aSDProcessStatusView = ASDProcessStatusView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDProcessStatusView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDProcessStatusView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.paddingBottom(16.0f);
                                if (SkinColor.INSTANCE.isNightMode(tVar2.getPagerId())) {
                                    Direction direction = Direction.TO_RIGHT;
                                    h.Companion companion = h.INSTANCE;
                                    tVar2.mo135backgroundLinearGradient(direction, new j(companion.b(), 0.0f), new j(companion.b(), 1.0f));
                                } else {
                                    tVar2.mo135backgroundLinearGradient(Direction.TO_RIGHT, new j(new h("qecommerce_color_btn_gradient01_normal"), 0.0f), new j(new h("qecommerce_color_btn_gradient02_normal"), 1.0f));
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDProcessStatusView.body.1.2.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDProcessStatusView.body.1.2.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        af afVar2 = afVar;
                                        afVar2.absolutePosition(0.0f, 0.0f, 0.0f, 0.0f);
                                        b.a.b(afVar2, "qecommerce_skin_order_bg", false, 2, null);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final ASDProcessStatusView aSDProcessStatusView2 = ASDProcessStatusView.this;
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDProcessStatusView.body.1.2.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final ASDProcessStatusView aSDProcessStatusView3 = ASDProcessStatusView.this;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDProcessStatusView.body.1.2.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ce.fontSize$default(ceVar2, 18.0f, null, 2, null);
                                        ceVar2.fontWeightMedium();
                                        if (SkinColor.INSTANCE.isNightMode(ceVar2.getPagerId())) {
                                            ceVar2.color(new h(4294914928L));
                                        } else {
                                            ceVar2.color(h.INSTANCE.m());
                                        }
                                        c.a.a(ceVar2, 16.0f, 16.0f, 0.0f, 0.0f, 12, null);
                                        ASDProcessStatusViewAttr aSDProcessStatusViewAttr = ASDProcessStatusView.this.viewAttr;
                                        ceVar2.text((String) aSDProcessStatusViewAttr.title$delegate.getValue(aSDProcessStatusViewAttr, ASDProcessStatusViewAttr.$$delegatedProperties[1]));
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final ASDProcessStatusView aSDProcessStatusView3 = ASDProcessStatusView.this;
                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDProcessStatusView.body.1.2.4
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                ASDProcessStatusViewAttr aSDProcessStatusViewAttr = ASDProcessStatusView.this.viewAttr;
                                return (String) aSDProcessStatusViewAttr.subTitle$delegate.getValue(aSDProcessStatusViewAttr, ASDProcessStatusViewAttr.$$delegatedProperties[2]);
                            }
                        };
                        final ASDProcessStatusView aSDProcessStatusView4 = ASDProcessStatusView.this;
                        ConditionViewKt.c(vVar2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDProcessStatusView.body.1.2.5
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                final ASDProcessStatusView aSDProcessStatusView5 = ASDProcessStatusView.this;
                                cg.a(conditionView, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDProcessStatusView.body.1.2.5.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final ASDProcessStatusView aSDProcessStatusView6 = ASDProcessStatusView.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDProcessStatusView.body.1.2.5.1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ce.fontSize$default(ceVar2, 13.0f, null, 2, null);
                                                ceVar2.color(SkinColor.whiteTextColor);
                                                ceVar2.marginTop(6.0f);
                                                ceVar2.marginLeft(16.0f);
                                                ASDProcessStatusViewAttr aSDProcessStatusViewAttr = ASDProcessStatusView.this.viewAttr;
                                                ceVar2.text((String) aSDProcessStatusViewAttr.subTitle$delegate.getValue(aSDProcessStatusViewAttr, ASDProcessStatusViewAttr.$$delegatedProperties[2]));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final ASDProcessStatusView aSDProcessStatusView5 = ASDProcessStatusView.this;
                        Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDProcessStatusView.body.1.2.6
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Boolean.valueOf(!ASDProcessStatusView.this.viewAttr.getProcessStatusList().isEmpty());
                            }
                        };
                        final ASDProcessStatusView aSDProcessStatusView6 = ASDProcessStatusView.this;
                        ConditionViewKt.c(vVar2, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDProcessStatusView.body.1.2.7
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                final ASDProcessStatusView aSDProcessStatusView7 = ASDProcessStatusView.this;
                                w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDProcessStatusView.body.1.2.7.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        v vVar4 = vVar3;
                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDProcessStatusView.body.1.2.7.1.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.margin(7.0f, 38.0f, 24.0f, 38.0f);
                                                tVar2.flexDirectionRow();
                                                tVar2.alignItemsCenter();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final ASDProcessStatusView aSDProcessStatusView8 = ASDProcessStatusView.this;
                                        LoopDirectivesViewKt.a(vVar4, new Function0<com.tencent.kuikly.core.reactive.collection.c<ProcessStatusItem>>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDProcessStatusView.body.1.2.7.1.2
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final com.tencent.kuikly.core.reactive.collection.c<ProcessStatusItem> invoke() {
                                                return ASDProcessStatusView.this.viewAttr.getProcessStatusList();
                                            }
                                        }, new Function2<LoopDirectivesView<ProcessStatusItem>, ProcessStatusItem, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDProcessStatusView.body.1.2.7.1.3
                                            @Override // kotlin.jvm.functions.Function2
                                            public final Unit invoke(LoopDirectivesView<ProcessStatusItem> loopDirectivesView, ProcessStatusItem processStatusItem) {
                                                final ProcessStatusItem processStatusItem2 = processStatusItem;
                                                w.a(loopDirectivesView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDProcessStatusView.body.1.2.7.1.3.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar5) {
                                                        v vVar6 = vVar5;
                                                        final ProcessStatusItem processStatusItem3 = ProcessStatusItem.this;
                                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDProcessStatusView.body.1.2.7.1.3.1.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(t tVar) {
                                                                t tVar2 = tVar;
                                                                if (ProcessStatusItem.this.index > 0) {
                                                                    tVar2.m140flex(1.0f);
                                                                }
                                                                tVar2.flexDirectionRow();
                                                                tVar2.alignItemsCenter();
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final ProcessStatusItem processStatusItem4 = ProcessStatusItem.this;
                                                        if (processStatusItem4.index > 0) {
                                                            vVar6.addChild(new ASDProcessStatusLine(), new Function1<ASDProcessStatusLine, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDProcessStatusView.body.1.2.7.1.3.1.2
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ASDProcessStatusLine aSDProcessStatusLine) {
                                                                    final ProcessStatusItem processStatusItem5 = ProcessStatusItem.this;
                                                                    aSDProcessStatusLine.attr(new Function1<ASDProcessStatusLineAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDProcessStatusView.body.1.2.7.1.3.1.2.1
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(ASDProcessStatusLineAttr aSDProcessStatusLineAttr) {
                                                                            ASDProcessStatusLineAttr aSDProcessStatusLineAttr2 = aSDProcessStatusLineAttr;
                                                                            aSDProcessStatusLineAttr2.m140flex(1.0f);
                                                                            aSDProcessStatusLineAttr2.dottedLine = ProcessStatusItem.this.dottedLine;
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                        }
                                                        final ProcessStatusItem processStatusItem5 = ProcessStatusItem.this;
                                                        w.a(vVar6, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDProcessStatusView.body.1.2.7.1.3.1.3
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(v vVar7) {
                                                                v vVar8 = vVar7;
                                                                vVar8.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDProcessStatusView.body.1.2.7.1.3.1.3.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(t tVar) {
                                                                        t tVar2 = tVar;
                                                                        tVar2.size(8.0f, 8.0f);
                                                                        tVar2.allCenter();
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final ProcessStatusItem processStatusItem6 = ProcessStatusItem.this;
                                                                w.a(vVar8, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDProcessStatusView.body.1.2.7.1.3.1.3.2
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(v vVar9) {
                                                                        final ProcessStatusItem processStatusItem7 = ProcessStatusItem.this;
                                                                        vVar9.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDProcessStatusView.body.1.2.7.1.3.1.3.2.1
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(t tVar) {
                                                                                t tVar2 = tVar;
                                                                                tVar2.absolutePosition(0.0f, 0.0f, 0.0f, 0.0f);
                                                                                tVar2.size(8.0f, 8.0f);
                                                                                tVar2.borderRadius(4.0f);
                                                                                if (ProcessStatusItem.this.dottedLine) {
                                                                                    tVar2.m136border(new e(1.0f, BorderStyle.SOLID, SkinColor.whiteTextColor));
                                                                                } else {
                                                                                    tVar2.mo113backgroundColor(SkinColor.whiteTextColor);
                                                                                }
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final ProcessStatusItem processStatusItem7 = ProcessStatusItem.this;
                                                                w.a(vVar8, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDProcessStatusView.body.1.2.7.1.3.1.3.3
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(v vVar9) {
                                                                        v vVar10 = vVar9;
                                                                        vVar10.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDProcessStatusView.body.1.2.7.1.3.1.3.3.1
                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(t tVar) {
                                                                                t tVar2 = tVar;
                                                                                tVar2.mo153width(100.0f);
                                                                                tVar2.mo141height(36.0f);
                                                                                tVar2.allCenter();
                                                                                tVar2.marginTop(40.0f);
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        final ProcessStatusItem processStatusItem8 = ProcessStatusItem.this;
                                                                        cg.a(vVar10, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDProcessStatusView.body.1.2.7.1.3.1.3.3.2
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(TextView textView) {
                                                                                final ProcessStatusItem processStatusItem9 = ProcessStatusItem.this;
                                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDProcessStatusView.body.1.2.7.1.3.1.3.3.2.1
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(ce ceVar) {
                                                                                        ce ceVar2 = ceVar;
                                                                                        ceVar2.color(SkinColor.whiteTextColor);
                                                                                        ceVar2.fontWeightNormal();
                                                                                        ce.fontSize$default(ceVar2, 13.0f, null, 2, null);
                                                                                        ceVar2.text(ProcessStatusItem.this.statusText);
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
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final ASDProcessStatusView aSDProcessStatusView2 = ASDProcessStatusView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDProcessStatusView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        final ASDProcessStatusView aSDProcessStatusView3 = ASDProcessStatusView.this;
                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDProcessStatusView.body.1.3.1
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                ASDProcessStatusViewAttr aSDProcessStatusViewAttr = ASDProcessStatusView.this.viewAttr;
                                return Boolean.valueOf(!((ArrayList) aSDProcessStatusViewAttr.hyperTextSpanList$delegate.getValue(aSDProcessStatusViewAttr, ASDProcessStatusViewAttr.$$delegatedProperties[3])).isEmpty());
                            }
                        };
                        final ASDProcessStatusView aSDProcessStatusView4 = ASDProcessStatusView.this;
                        ConditionViewKt.c(vVar, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDProcessStatusView.body.1.3.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                final ASDProcessStatusView aSDProcessStatusView5 = ASDProcessStatusView.this;
                                RichTextViewKt.b(conditionView, new Function1<RichTextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDProcessStatusView.body.1.3.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(RichTextView richTextView) {
                                        final ASDProcessStatusView aSDProcessStatusView6 = ASDProcessStatusView.this;
                                        richTextView.attr(new Function1<RichTextAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDProcessStatusView.body.1.3.2.1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(RichTextAttr richTextAttr) {
                                                RichTextAttr richTextAttr2 = richTextAttr;
                                                richTextAttr2.margin(16.0f);
                                                ASDProcessStatusViewAttr aSDProcessStatusViewAttr = ASDProcessStatusView.this.viewAttr;
                                                richTextAttr2.spans((ArrayList) aSDProcessStatusViewAttr.hyperTextSpanList$delegate.getValue(aSDProcessStatusViewAttr, ASDProcessStatusViewAttr.$$delegatedProperties[3]));
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

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        super.created();
    }
}
