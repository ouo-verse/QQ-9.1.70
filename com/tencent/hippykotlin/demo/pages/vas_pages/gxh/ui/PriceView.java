package com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui;

import com.tencent.hippykotlin.demo.pages.vas_base.extensions.p002float.ImplKt;
import com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken;
import com.tencent.hippykotlin.demo.pages.vas_pages.gxh.extensions.AttrKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* loaded from: classes33.dex */
public final class PriceView extends ComposeView<PriceViewAttr, PriceViewEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ PriceViewAttr access$getAttr(PriceView priceView) {
        return (PriceViewAttr) priceView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.PriceView$body$1
            {
                super(1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                T t16;
                T t17;
                T t18;
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                VasUIToken vasUIToken = VasUIToken.INSTANCE;
                if (!vasUIToken.isDarkMode()) {
                    t16 = new h(4279901214L);
                } else {
                    t16 = new h(4293980404L);
                }
                objectRef.element = t16;
                final Ref.FloatRef floatRef = new Ref.FloatRef();
                floatRef.element = 18.0f;
                final Ref.FloatRef floatRef2 = new Ref.FloatRef();
                floatRef2.element = 14.0f;
                final Ref.FloatRef floatRef3 = new Ref.FloatRef();
                floatRef3.element = 18.0f;
                PriceViewAttr access$getAttr = PriceView.access$getAttr(PriceView.this);
                if (((Boolean) access$getAttr.isInvalid$delegate.getValue(access$getAttr, PriceViewAttr.$$delegatedProperties[1])).booleanValue()) {
                    if (!vasUIToken.isDarkMode()) {
                        t18 = new h(4289111718L);
                    } else {
                        t18 = new h(4284309089L);
                    }
                    objectRef.element = t18;
                    floatRef2.element = 14.0f;
                    floatRef.element = 14.0f;
                } else if (PriceView.access$getAttr(PriceView.this).isDiscount$qecommerce_biz_release()) {
                    if (!vasUIToken.isDarkMode()) {
                        t17 = new h(4286729998L);
                    } else {
                        t17 = new h(4293769836L);
                    }
                    objectRef.element = t17;
                    floatRef.element = 14.0f;
                    floatRef2.element = 12.0f;
                }
                if (PriceView.access$getAttr(PriceView.this).getViewScale$qecommerce_biz_release() > 0.0f) {
                    floatRef.element = PriceView.access$getAttr(PriceView.this).getViewScale$qecommerce_biz_release() * floatRef.element;
                    floatRef2.element = PriceView.access$getAttr(PriceView.this).getViewScale$qecommerce_biz_release() * floatRef2.element;
                    floatRef3.element = PriceView.access$getAttr(PriceView.this).getViewScale$qecommerce_biz_release() * floatRef3.element;
                }
                final PriceView priceView = PriceView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.PriceView$body$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final Ref.FloatRef floatRef4 = Ref.FloatRef.this;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.PriceView.body.1.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.flexDirectionRow();
                                tVar2.alignItemsFlexEnd();
                                tVar2.mo141height(ImplKt.getW(Ref.FloatRef.this.element));
                                return Unit.INSTANCE;
                            }
                        });
                        final PriceView priceView2 = priceView;
                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.PriceView.body.1.1.2
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                PriceViewAttr access$getAttr2 = PriceView.access$getAttr(PriceView.this);
                                return Boolean.valueOf(((Boolean) access$getAttr2.isInvalid$delegate.getValue(access$getAttr2, PriceViewAttr.$$delegatedProperties[1])).booleanValue());
                            }
                        };
                        final Ref.FloatRef floatRef5 = floatRef;
                        final Ref.ObjectRef<h> objectRef2 = objectRef;
                        final PriceView priceView3 = priceView;
                        ConditionViewKt.c(vVar2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.PriceView.body.1.1.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                final Ref.FloatRef floatRef6 = Ref.FloatRef.this;
                                final Ref.ObjectRef<h> objectRef3 = objectRef2;
                                final PriceView priceView4 = priceView3;
                                cg.a(conditionView, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.PriceView.body.1.1.3.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final Ref.FloatRef floatRef7 = Ref.FloatRef.this;
                                        final Ref.ObjectRef<h> objectRef4 = objectRef3;
                                        final PriceView priceView5 = priceView4;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.PriceView.body.1.1.3.1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                AttrKt.fontFamilyDinFont(ceVar2);
                                                ce.fontSize$default(ceVar2, ImplKt.getW(Ref.FloatRef.this.element), null, 2, null);
                                                ceVar2.color(objectRef4.element);
                                                ceVar2.text('\u00a5' + priceView5.getPriceString());
                                                ceVar2.fontWeight400();
                                                ceVar2.textDecorationLineThrough();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final Ref.FloatRef floatRef6 = Ref.FloatRef.this;
                        final PriceView priceView4 = priceView;
                        final Ref.FloatRef floatRef7 = floatRef;
                        final Ref.FloatRef floatRef8 = floatRef2;
                        final Ref.ObjectRef<h> objectRef3 = objectRef;
                        ConditionViewKt.a(vVar2, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.PriceView.body.1.1.4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                final Ref.FloatRef floatRef9 = Ref.FloatRef.this;
                                final PriceView priceView5 = priceView4;
                                final Ref.FloatRef floatRef10 = floatRef7;
                                final Ref.FloatRef floatRef11 = floatRef8;
                                final Ref.ObjectRef<h> objectRef4 = objectRef3;
                                w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.PriceView.body.1.1.4.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        v vVar4 = vVar3;
                                        final Ref.FloatRef floatRef12 = Ref.FloatRef.this;
                                        final PriceView priceView6 = priceView5;
                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.PriceView.body.1.1.4.1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                h hVar;
                                                t tVar2 = tVar;
                                                tVar2.flexDirectionRow();
                                                tVar2.alignItemsCenter();
                                                tVar2.justifyContentCenter();
                                                tVar2.mo141height(ImplKt.getW(Ref.FloatRef.this.element));
                                                if (PriceView.access$getAttr(priceView6).isDiscount$qecommerce_biz_release()) {
                                                    if (!VasUIToken.INSTANCE.isDarkMode()) {
                                                        hVar = new h(4294102678L);
                                                    } else {
                                                        hVar = new h(4288378946L);
                                                    }
                                                    tVar2.mo113backgroundColor(hVar);
                                                    tVar2.mo141height(ImplKt.getW(Ref.FloatRef.this.element));
                                                    tVar2.paddingLeft(ImplKt.getW(4.0f));
                                                    tVar2.paddingRight(ImplKt.getW(4.0f));
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final Ref.FloatRef floatRef13 = floatRef10;
                                        final PriceView priceView7 = priceView5;
                                        final Ref.FloatRef floatRef14 = floatRef11;
                                        final Ref.ObjectRef<h> objectRef5 = objectRef4;
                                        w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.PriceView.body.1.1.4.1.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar5) {
                                                v vVar6 = vVar5;
                                                final Ref.FloatRef floatRef15 = Ref.FloatRef.this;
                                                final PriceView priceView8 = priceView7;
                                                vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.PriceView.body.1.1.4.1.2.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.flexDirectionRow();
                                                        tVar2.alignItemsFlexEnd();
                                                        tVar2.justifyContentCenter();
                                                        tVar2.mo141height(ImplKt.getW(Ref.FloatRef.this.element));
                                                        if (PriceView.access$getAttr(priceView8).isDiscount$qecommerce_biz_release()) {
                                                            tVar2.m146minWidth(ImplKt.getW(28.0f));
                                                            if (priceView8.getPagerData().getIsIOS()) {
                                                                tVar2.marginTop(ImplKt.getW(2.0f));
                                                            }
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final Ref.FloatRef floatRef16 = floatRef14;
                                                final Ref.ObjectRef<h> objectRef6 = objectRef5;
                                                final PriceView priceView9 = priceView7;
                                                cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.PriceView.body.1.1.4.1.2.2
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        final Ref.FloatRef floatRef17 = Ref.FloatRef.this;
                                                        final Ref.ObjectRef<h> objectRef7 = objectRef6;
                                                        final PriceView priceView10 = priceView9;
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.PriceView.body.1.1.4.1.2.2.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                ce ceVar2 = ceVar;
                                                                AttrKt.fontFamilyDinFont(ceVar2);
                                                                ce.fontSize$default(ceVar2, ImplKt.getW(Ref.FloatRef.this.element), null, 2, null);
                                                                ceVar2.color(objectRef7.element);
                                                                ceVar2.text("\u00a5");
                                                                ceVar2.fontWeight400();
                                                                if (priceView10.getPagerData().getIsIOS()) {
                                                                    ceVar2.marginBottom(ImplKt.getW(PriceView.access$getAttr(priceView10).isDiscount$qecommerce_biz_release() ? 1.0f : 2.0f));
                                                                } else {
                                                                    ceVar2.marginBottom(ImplKt.getW(0.04f));
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final Ref.FloatRef floatRef17 = Ref.FloatRef.this;
                                                final Ref.ObjectRef<h> objectRef7 = objectRef5;
                                                final PriceView priceView10 = priceView7;
                                                cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.PriceView.body.1.1.4.1.2.3
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        final Ref.FloatRef floatRef18 = Ref.FloatRef.this;
                                                        final Ref.ObjectRef<h> objectRef8 = objectRef7;
                                                        final PriceView priceView11 = priceView10;
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.PriceView.body.1.1.4.1.2.3.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                ce ceVar2 = ceVar;
                                                                AttrKt.fontFamilyDinFont(ceVar2);
                                                                ce.fontSize$default(ceVar2, ImplKt.getW(Ref.FloatRef.this.element), null, 2, null);
                                                                ceVar2.color(objectRef8.element);
                                                                ceVar2.lineHeight(ImplKt.getW(Ref.FloatRef.this.element));
                                                                ceVar2.text(priceView11.getPriceString());
                                                                ceVar2.fontWeight500();
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
        return new PriceViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new PriceViewEvent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String getPriceString() {
        if (((PriceViewAttr) getAttr()).getPrice$qecommerce_biz_release() % ((float) 1) == 0.0f) {
            return String.valueOf((int) ((PriceViewAttr) getAttr()).getPrice$qecommerce_biz_release());
        }
        return String.valueOf(((PriceViewAttr) getAttr()).getPrice$qecommerce_biz_release());
    }
}
