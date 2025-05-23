package com.tencent.hippykotlin.demo.pages.foundation.components;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.module.p;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.c;
import com.tencent.kuikly.core.views.PullDownHeaderView;
import com.tencent.kuikly.core.views.ScrollParams;
import com.tencent.kuikly.core.views.ScrollerAttr;
import com.tencent.kuikly.core.views.TransitionType;
import com.tencent.kuikly.core.views.TransitionView;
import com.tencent.kuikly.core.views.TransitionViewKt;
import com.tencent.kuikly.core.views.aa;
import com.tencent.kuikly.core.views.ab;
import com.tencent.kuikly.core.views.ac;
import com.tencent.kuikly.core.views.ao;
import com.tencent.kuikly.core.views.ap;
import com.tencent.kuikly.core.views.aq;
import com.tencent.kuikly.core.views.ar;
import com.tencent.kuikly.core.views.bh;
import com.tencent.kuikly.core.views.bi;
import com.tencent.kuikly.core.views.bj;
import com.tencent.kuikly.core.views.ci;
import com.tencent.kuikly.core.views.cj;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class HalfFloatingLayerView extends ComposeView<HalfFloatingLayerAttr, HalfFloatingLayerEvent> implements c {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(HalfFloatingLayerView.class, "floatingLayerAppear", "getFloatingLayerAppear()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(HalfFloatingLayerView.class, "bgMaskColor", "getBgMaskColor()Lcom/tencent/kuikly/core/base/Color;", 0)};
    public final ReadWriteProperty floatingLayerAppear$delegate = c01.c.a(Boolean.TRUE);
    public final ReadWriteProperty bgMaskColor$delegate = c01.c.a(new h(0, 0, 0, 0.3f));

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ HalfFloatingLayerAttr access$getAttr(HalfFloatingLayerView halfFloatingLayerView) {
        return (HalfFloatingLayerAttr) halfFloatingLayerView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final float access$getFloatingLayerHeight(HalfFloatingLayerView halfFloatingLayerView) {
        HalfFloatingLayerAttr halfFloatingLayerAttr = (HalfFloatingLayerAttr) halfFloatingLayerView.getAttr();
        return ((Number) halfFloatingLayerAttr.floatingLayerHeight$delegate.getValue(halfFloatingLayerAttr, HalfFloatingLayerAttr.$$delegatedProperties[0])).floatValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        this.bgMaskColor$delegate.setValue(this, $$delegatedProperties[1], new h(0, 0, 0, ((HalfFloatingLayerAttr) getAttr()).bgMaskColorAlpha));
        if (((HalfFloatingLayerEvent) getEvent()).closeHandlerFn == null) {
            ((HalfFloatingLayerEvent) getEvent()).closeHandlerFn = new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.components.HalfFloatingLayerView$body$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object obj) {
                    ((p) HalfFloatingLayerView.this.getPager().acquireModule("KRRouterModule")).a();
                    return Unit.INSTANCE;
                }
            };
        }
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.components.HalfFloatingLayerView$body$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                TransitionType transitionType = TransitionType.FADE_IN_OUT;
                final HalfFloatingLayerView halfFloatingLayerView = HalfFloatingLayerView.this;
                TransitionViewKt.a(viewContainer2, transitionType, new Function1<TransitionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.components.HalfFloatingLayerView$body$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TransitionView transitionView) {
                        TransitionView transitionView2 = transitionView;
                        final HalfFloatingLayerView halfFloatingLayerView2 = HalfFloatingLayerView.this;
                        transitionView2.attr(new Function1<ci, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.components.HalfFloatingLayerView.body.2.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ci ciVar) {
                                ci ciVar2 = ciVar;
                                ciVar2.absolutePositionAllZero();
                                HalfFloatingLayerView halfFloatingLayerView3 = HalfFloatingLayerView.this;
                                ReadWriteProperty readWriteProperty = halfFloatingLayerView3.bgMaskColor$delegate;
                                KProperty<?>[] kPropertyArr = HalfFloatingLayerView.$$delegatedProperties;
                                ciVar2.mo113backgroundColor((h) readWriteProperty.getValue(halfFloatingLayerView3, kPropertyArr[1]));
                                HalfFloatingLayerView halfFloatingLayerView4 = HalfFloatingLayerView.this;
                                ciVar2.r(((Boolean) halfFloatingLayerView4.floatingLayerAppear$delegate.getValue(halfFloatingLayerView4, kPropertyArr[0])).booleanValue());
                                return Unit.INSTANCE;
                            }
                        });
                        final HalfFloatingLayerView halfFloatingLayerView3 = HalfFloatingLayerView.this;
                        transitionView2.event(new Function1<cj, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.components.HalfFloatingLayerView.body.2.1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(cj cjVar) {
                                cj cjVar2 = cjVar;
                                final HalfFloatingLayerView halfFloatingLayerView4 = HalfFloatingLayerView.this;
                                cjVar2.transitionFinish(new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.components.HalfFloatingLayerView.body.2.1.2.1
                                    {
                                        super(1);
                                    }

                                    /* JADX WARN: Multi-variable type inference failed */
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Boolean bool) {
                                        Function1<Object, Unit> function1;
                                        if (!bool.booleanValue() && (function1 = ((HalfFloatingLayerEvent) HalfFloatingLayerView.this.getViewEvent()).closeHandlerFn) != null) {
                                            function1.invoke(null);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                final HalfFloatingLayerView halfFloatingLayerView5 = HalfFloatingLayerView.this;
                                cjVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.components.HalfFloatingLayerView.body.2.1.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        HalfFloatingLayerView halfFloatingLayerView6 = HalfFloatingLayerView.this;
                                        halfFloatingLayerView6.floatingLayerAppear$delegate.setValue(halfFloatingLayerView6, HalfFloatingLayerView.$$delegatedProperties[0], Boolean.FALSE);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.components.HalfFloatingLayerView$body$2.2
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.components.HalfFloatingLayerView.body.2.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                tVar.m140flex(1.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                TransitionType transitionType2 = TransitionType.DIRECTION_FROM_BOTTOM;
                final HalfFloatingLayerView halfFloatingLayerView2 = HalfFloatingLayerView.this;
                TransitionViewKt.a(viewContainer2, transitionType2, new Function1<TransitionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.components.HalfFloatingLayerView$body$2.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TransitionView transitionView) {
                        TransitionView transitionView2 = transitionView;
                        final HalfFloatingLayerView halfFloatingLayerView3 = HalfFloatingLayerView.this;
                        transitionView2.attr(new Function1<ci, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.components.HalfFloatingLayerView.body.2.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ci ciVar) {
                                ci ciVar2 = ciVar;
                                ciVar2.mo141height(HalfFloatingLayerView.access$getFloatingLayerHeight(HalfFloatingLayerView.this));
                                HalfFloatingLayerView halfFloatingLayerView4 = HalfFloatingLayerView.this;
                                ciVar2.r(((Boolean) halfFloatingLayerView4.floatingLayerAppear$delegate.getValue(halfFloatingLayerView4, HalfFloatingLayerView.$$delegatedProperties[0])).booleanValue());
                                return Unit.INSTANCE;
                            }
                        });
                        final HalfFloatingLayerView halfFloatingLayerView4 = HalfFloatingLayerView.this;
                        ar.a(transitionView2, new Function1<aq<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.components.HalfFloatingLayerView.body.2.3.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(aq<?, ?> aqVar) {
                                aq<?, ?> aqVar2 = aqVar;
                                final HalfFloatingLayerView halfFloatingLayerView5 = HalfFloatingLayerView.this;
                                aqVar2.attr(new Function1<ao, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.components.HalfFloatingLayerView.body.2.3.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ao aoVar) {
                                        ao aoVar2 = aoVar;
                                        aoVar2.borderRadius(HalfFloatingLayerView.access$getAttr(HalfFloatingLayerView.this).boardBorderRadius, HalfFloatingLayerView.access$getAttr(HalfFloatingLayerView.this).boardBorderRadius, 0.0f, 0.0f);
                                        ScrollerAttr.bouncesEnable$default(aoVar2, false, false, 2, null);
                                        aoVar2.m140flex(1.0f);
                                        aoVar2.mo113backgroundColor(h.INSTANCE.j());
                                        aoVar2.showScrollerIndicator(false);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final HalfFloatingLayerView halfFloatingLayerView6 = HalfFloatingLayerView.this;
                                aqVar2.event(new Function1<ap, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.components.HalfFloatingLayerView.body.2.3.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ap apVar) {
                                        final HalfFloatingLayerView halfFloatingLayerView7 = HalfFloatingLayerView.this;
                                        apVar.scroll(new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.components.HalfFloatingLayerView.body.2.3.2.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ScrollParams scrollParams) {
                                                float f16 = HalfFloatingLayerView.access$getAttr(HalfFloatingLayerView.this).bgMaskColorAlpha;
                                                float min = Math.min((scrollParams.getOffsetY() / HalfFloatingLayerView.access$getFloatingLayerHeight(HalfFloatingLayerView.this)) * f16, f16);
                                                HalfFloatingLayerView halfFloatingLayerView8 = HalfFloatingLayerView.this;
                                                halfFloatingLayerView8.bgMaskColor$delegate.setValue(halfFloatingLayerView8, HalfFloatingLayerView.$$delegatedProperties[1], new h(0, 0, 0, min));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final HalfFloatingLayerView halfFloatingLayerView7 = HalfFloatingLayerView.this;
                                bj.a(aqVar2, new Function1<PullDownHeaderView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.components.HalfFloatingLayerView.body.2.3.2.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(PullDownHeaderView pullDownHeaderView) {
                                        PullDownHeaderView pullDownHeaderView2 = pullDownHeaderView;
                                        final HalfFloatingLayerView halfFloatingLayerView8 = HalfFloatingLayerView.this;
                                        pullDownHeaderView2.attr(new Function1<bh, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.components.HalfFloatingLayerView.body.2.3.2.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(bh bhVar) {
                                                bhVar.mo141height(HalfFloatingLayerView.access$getFloatingLayerHeight(HalfFloatingLayerView.this));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final HalfFloatingLayerView halfFloatingLayerView9 = HalfFloatingLayerView.this;
                                        pullDownHeaderView2.event(new Function1<bi, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.components.HalfFloatingLayerView.body.2.3.2.3.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(bi biVar) {
                                                bi biVar2 = biVar;
                                                final HalfFloatingLayerView halfFloatingLayerView10 = HalfFloatingLayerView.this;
                                                biVar2.h(new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.components.HalfFloatingLayerView.body.2.3.2.3.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(Object obj) {
                                                        Function1<Object, Unit> function1 = ((HalfFloatingLayerEvent) HalfFloatingLayerView.this.getViewEvent()).closeHandlerFn;
                                                        if (function1 != null) {
                                                            function1.invoke(null);
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                biVar2.k(new Function1<Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.components.HalfFloatingLayerView.body.2.3.2.3.2.2
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(Float f16) {
                                                        float floatValue = f16.floatValue();
                                                        KLog.INSTANCE.i("tag", "pullPercentage:" + floatValue);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final HalfFloatingLayerView halfFloatingLayerView8 = HalfFloatingLayerView.this;
                                ac.b(aqVar2, new Function1<ab, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.components.HalfFloatingLayerView.body.2.3.2.4
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ab abVar) {
                                        ab abVar2 = abVar;
                                        final HalfFloatingLayerView halfFloatingLayerView9 = HalfFloatingLayerView.this;
                                        abVar2.attr(new Function1<aa, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.components.HalfFloatingLayerView.body.2.3.2.4.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(aa aaVar) {
                                                aa aaVar2 = aaVar;
                                                aaVar2.borderRadius(HalfFloatingLayerView.access$getAttr(HalfFloatingLayerView.this).boardBorderRadius, HalfFloatingLayerView.access$getAttr(HalfFloatingLayerView.this).boardBorderRadius, 0.0f, 0.0f);
                                                aaVar2.mo113backgroundColor(HalfFloatingLayerView.access$getAttr(HalfFloatingLayerView.this).boardBgColor);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        Function1<? super ViewContainer<?, ?>, Unit> function1 = HalfFloatingLayerView.access$getAttr(HalfFloatingLayerView.this).boardIndicatorBarBuilder;
                                        if (function1 != null) {
                                            function1.invoke(abVar2);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                Function1<? super aq<?, ?>, Unit> function1 = HalfFloatingLayerView.access$getAttr(HalfFloatingLayerView.this).boardBuilder;
                                if (function1 != null) {
                                    function1.invoke(aqVar2);
                                }
                                final HalfFloatingLayerView halfFloatingLayerView9 = HalfFloatingLayerView.this;
                                w.a(aqVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.components.HalfFloatingLayerView.body.2.3.2.5
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar) {
                                        v vVar2 = vVar;
                                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.components.HalfFloatingLayerView.body.2.3.2.5.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                tVar.mo141height(0.1f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final HalfFloatingLayerView halfFloatingLayerView10 = HalfFloatingLayerView.this;
                                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.components.HalfFloatingLayerView.body.2.3.2.5.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar3) {
                                                final HalfFloatingLayerView halfFloatingLayerView11 = HalfFloatingLayerView.this;
                                                vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.components.HalfFloatingLayerView.body.2.3.2.5.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        Attr.absolutePosition$default(tVar2, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                                        tVar2.mo141height(1000.0f);
                                                        tVar2.m142left(0.0f);
                                                        tVar2.m149right(0.0f);
                                                        tVar2.m150top(0.0f);
                                                        tVar2.mo113backgroundColor(HalfFloatingLayerView.access$getAttr(HalfFloatingLayerView.this).boardBgColor);
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
        return new HalfFloatingLayerAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new HalfFloatingLayerEvent();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        super.created();
    }

    @Override // com.tencent.kuikly.core.base.DeclarativeBaseView
    public final void didMoveToParentView() {
        super.didMoveToParentView();
        getPager().addPagerEventObserver(this);
    }

    @Override // com.tencent.kuikly.core.base.ComposeView, com.tencent.kuikly.core.base.ViewContainer, com.tencent.kuikly.core.base.DeclarativeBaseView
    public final void didRemoveFromParentView() {
        super.didRemoveFromParentView();
        getPager().removePagerEventObserver(this);
    }

    @Override // com.tencent.kuikly.core.pager.c
    public final void onPagerEvent(String str, e eVar) {
        if (Intrinsics.areEqual(str, "onModalModeBackPressed")) {
            this.floatingLayerAppear$delegate.setValue(this, $$delegatedProperties[0], Boolean.FALSE);
        }
    }

    @Override // com.tencent.kuikly.core.pager.c
    public final void onRootViewSizeChanged(double d16, double d17) {
        c.a.a(this, d16, d17);
    }
}
