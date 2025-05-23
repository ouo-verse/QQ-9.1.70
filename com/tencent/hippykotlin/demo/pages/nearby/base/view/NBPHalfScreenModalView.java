package com.tencent.hippykotlin.demo.pages.nearby.base.view;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ECTransitionAttr;
import com.tencent.hippykotlin.demo.pages.base.ECTransitionEvent;
import com.tencent.hippykotlin.demo.pages.base.ECTransitionView;
import com.tencent.hippykotlin.demo.pages.base.ECTransitionViewKt;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.ScrollParams;
import com.tencent.kuikly.core.views.ScrollerAttr;
import com.tencent.kuikly.core.views.aa;
import com.tencent.kuikly.core.views.ab;
import com.tencent.kuikly.core.views.ac;
import com.tencent.kuikly.core.views.ao;
import com.tencent.kuikly.core.views.ap;
import com.tencent.kuikly.core.views.aq;
import com.tencent.kuikly.core.views.ar;
import com.tencent.kuikly.core.views.co;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class NBPHalfScreenModalView extends ComposeView<NBPHalfScreenModalAttr, NBPHalfScreenModalEvent> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPHalfScreenModalView.class, "touchable", "getTouchable()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPHalfScreenModalView.class, "animationOpen", "getAnimationOpen()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPHalfScreenModalView.class, "scrollEnable", "getScrollEnable()Z", 0)};
    public final ReadWriteProperty animationOpen$delegate;
    public Function1<? super ViewContainer<?, ?>, Unit> contentBuilder;
    public final ReadWriteProperty scrollEnable$delegate;
    public Function1<? super ViewContainer<?, ?>, Unit> topLevelExtraBuilder;
    public final ReadWriteProperty touchable$delegate;

    public NBPHalfScreenModalView() {
        Boolean bool = Boolean.FALSE;
        this.touchable$delegate = c.a(bool);
        this.animationOpen$delegate = c.a(bool);
        this.contentBuilder = new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPHalfScreenModalView$contentBuilder$1
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(ViewContainer<?, ?> viewContainer) {
                return Unit.INSTANCE;
            }
        };
        this.scrollEnable$delegate = c.a(Boolean.TRUE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NBPHalfScreenModalAttr access$getAttr(NBPHalfScreenModalView nBPHalfScreenModalView) {
        return (NBPHalfScreenModalAttr) nBPHalfScreenModalView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NBPHalfScreenModalEvent access$getEvent(NBPHalfScreenModalView nBPHalfScreenModalView) {
        return (NBPHalfScreenModalEvent) nBPHalfScreenModalView.getEvent();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPHalfScreenModalView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final NBPHalfScreenModalView nBPHalfScreenModalView = NBPHalfScreenModalView.this;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPHalfScreenModalView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        boolean booleanValue;
                        boolean booleanValue2;
                        m mVar2 = mVar;
                        booleanValue = ((Boolean) r0.animationOpen$delegate.getValue(NBPHalfScreenModalView.this, NBPHalfScreenModalView.$$delegatedProperties[1])).booleanValue();
                        if (booleanValue) {
                            mVar2.mo113backgroundColor(QUIToken.color$default("overlay_dark"));
                        } else {
                            mVar2.mo113backgroundColor(h.INSTANCE.j());
                        }
                        mVar2.justifyContentFlexEnd();
                        b f16 = b.Companion.f(b.INSTANCE, 0.25f, null, 2, null);
                        booleanValue2 = ((Boolean) r1.animationOpen$delegate.getValue(NBPHalfScreenModalView.this, NBPHalfScreenModalView.$$delegatedProperties[1])).booleanValue();
                        mVar2.animate(f16, Boolean.valueOf(booleanValue2));
                        return Unit.INSTANCE;
                    }
                });
                final NBPHalfScreenModalView nBPHalfScreenModalView2 = NBPHalfScreenModalView.this;
                viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPHalfScreenModalView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Event event) {
                        final NBPHalfScreenModalView nBPHalfScreenModalView3 = NBPHalfScreenModalView.this;
                        event.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPHalfScreenModalView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ClickParams clickParams) {
                                NBPHalfScreenModalView.this.setAnimationOpen(false);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPHalfScreenModalView nBPHalfScreenModalView3 = NBPHalfScreenModalView.this;
                ECTransitionViewKt.TransitionFromBottomView(viewContainer2, new Function1<ECTransitionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPHalfScreenModalView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ECTransitionView eCTransitionView) {
                        ECTransitionView eCTransitionView2 = eCTransitionView;
                        final NBPHalfScreenModalView nBPHalfScreenModalView4 = NBPHalfScreenModalView.this;
                        eCTransitionView2.attr(new Function1<ECTransitionAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPHalfScreenModalView.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ECTransitionAttr eCTransitionAttr) {
                                boolean booleanValue;
                                ECTransitionAttr eCTransitionAttr2 = eCTransitionAttr;
                                eCTransitionAttr2.flexDirectionColumn();
                                eCTransitionAttr2.size(eCTransitionAttr2.getPagerData().m(), NBPHalfScreenModalView.access$getAttr(NBPHalfScreenModalView.this).contentHeight);
                                NBPHalfScreenModalView nBPHalfScreenModalView5 = NBPHalfScreenModalView.this;
                                eCTransitionAttr2.m151touchEnable(((Boolean) nBPHalfScreenModalView5.touchable$delegate.getValue(nBPHalfScreenModalView5, NBPHalfScreenModalView.$$delegatedProperties[0])).booleanValue());
                                booleanValue = ((Boolean) r0.animationOpen$delegate.getValue(NBPHalfScreenModalView.this, NBPHalfScreenModalView.$$delegatedProperties[1])).booleanValue();
                                eCTransitionAttr2.setTransitionAppear(booleanValue);
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPHalfScreenModalView nBPHalfScreenModalView5 = NBPHalfScreenModalView.this;
                        eCTransitionView2.event(new Function1<ECTransitionEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPHalfScreenModalView.body.1.3.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ECTransitionEvent eCTransitionEvent) {
                                ECTransitionEvent eCTransitionEvent2 = eCTransitionEvent;
                                final NBPHalfScreenModalView nBPHalfScreenModalView6 = NBPHalfScreenModalView.this;
                                eCTransitionEvent2.transitionFinish(new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPHalfScreenModalView.body.1.3.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Boolean bool) {
                                        if (!bool.booleanValue()) {
                                            Function1<Object, Unit> function1 = NBPHalfScreenModalView.access$getEvent(NBPHalfScreenModalView.this).onCloseHandler;
                                            if (function1 != null) {
                                                function1.invoke(null);
                                            }
                                        } else {
                                            NBPHalfScreenModalView nBPHalfScreenModalView7 = NBPHalfScreenModalView.this;
                                            nBPHalfScreenModalView7.touchable$delegate.setValue(nBPHalfScreenModalView7, NBPHalfScreenModalView.$$delegatedProperties[0], Boolean.TRUE);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                eCTransitionEvent2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPHalfScreenModalView.body.1.3.2.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPHalfScreenModalView nBPHalfScreenModalView6 = NBPHalfScreenModalView.this;
                        ar.a(eCTransitionView2, new Function1<aq<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPHalfScreenModalView.body.1.3.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(aq<?, ?> aqVar) {
                                aq<?, ?> aqVar2 = aqVar;
                                final NBPHalfScreenModalView nBPHalfScreenModalView7 = NBPHalfScreenModalView.this;
                                aqVar2.attr(new Function1<ao, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPHalfScreenModalView.body.1.3.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ao aoVar) {
                                        ao aoVar2 = aoVar;
                                        aoVar2.m140flex(1.0f);
                                        aoVar2.flexDirectionColumn();
                                        aoVar2.showScrollerIndicator(false);
                                        aoVar2.size(aoVar2.getPagerData().m(), NBPHalfScreenModalView.access$getAttr(NBPHalfScreenModalView.this).contentHeight);
                                        aoVar2.positionAbsolute();
                                        aoVar2.m138bottom(0.0f);
                                        aoVar2.justifyContentCenter();
                                        NBPHalfScreenModalView nBPHalfScreenModalView8 = NBPHalfScreenModalView.this;
                                        ReadWriteProperty readWriteProperty = nBPHalfScreenModalView8.touchable$delegate;
                                        KProperty<?>[] kPropertyArr = NBPHalfScreenModalView.$$delegatedProperties;
                                        aoVar2.m151touchEnable(((Boolean) readWriteProperty.getValue(nBPHalfScreenModalView8, kPropertyArr[0])).booleanValue());
                                        if (NBPHalfScreenModalView.access$getAttr(NBPHalfScreenModalView.this).supportDragToClose) {
                                            NBPHalfScreenModalView nBPHalfScreenModalView9 = NBPHalfScreenModalView.this;
                                            aoVar2.scrollEnable(((Boolean) nBPHalfScreenModalView9.scrollEnable$delegate.getValue(nBPHalfScreenModalView9, kPropertyArr[2])).booleanValue());
                                            NBPHalfScreenModalView nBPHalfScreenModalView10 = NBPHalfScreenModalView.this;
                                            ScrollerAttr.bouncesEnable$default(aoVar2, ((Boolean) nBPHalfScreenModalView10.scrollEnable$delegate.getValue(nBPHalfScreenModalView10, kPropertyArr[2])).booleanValue(), false, 2, null);
                                        } else {
                                            aoVar2.scrollEnable(false);
                                            ScrollerAttr.bouncesEnable$default(aoVar2, false, false, 2, null);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPHalfScreenModalView nBPHalfScreenModalView8 = NBPHalfScreenModalView.this;
                                aqVar2.event(new Function1<ap, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPHalfScreenModalView.body.1.3.3.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ap apVar) {
                                        final ap apVar2 = apVar;
                                        final NBPHalfScreenModalView nBPHalfScreenModalView9 = NBPHalfScreenModalView.this;
                                        apVar2.willDragEndBySync(new Function1<co, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPHalfScreenModalView.body.1.3.3.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(co coVar) {
                                                co coVar2 = coVar;
                                                NBPHalfScreenModalView nBPHalfScreenModalView10 = NBPHalfScreenModalView.this;
                                                KProperty<Object>[] kPropertyArr = NBPHalfScreenModalView.$$delegatedProperties;
                                                nBPHalfScreenModalView10.getClass();
                                                if (coVar2.getOffsetY() < 0.0f && Math.abs(coVar2.getOffsetY()) > 70.0f) {
                                                    nBPHalfScreenModalView10.setAnimationOpen(false);
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        apVar2.dragBegin(new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPHalfScreenModalView.body.1.3.3.2.2
                                            @Override // kotlin.jvm.functions.Function1
                                            public final /* bridge */ /* synthetic */ Unit invoke(ScrollParams scrollParams) {
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPHalfScreenModalView nBPHalfScreenModalView10 = NBPHalfScreenModalView.this;
                                        apVar2.dragEnd(new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPHalfScreenModalView.body.1.3.3.2.3
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ScrollParams scrollParams) {
                                                if (ap.this.getPager().getPageData().getIsIOS()) {
                                                    NBPHalfScreenModalView nBPHalfScreenModalView11 = nBPHalfScreenModalView10;
                                                    nBPHalfScreenModalView11.scrollEnable$delegate.setValue(nBPHalfScreenModalView11, NBPHalfScreenModalView.$$delegatedProperties[2], Boolean.FALSE);
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPHalfScreenModalView nBPHalfScreenModalView11 = NBPHalfScreenModalView.this;
                                        apVar2.scrollEnd(new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPHalfScreenModalView.body.1.3.3.2.4
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ScrollParams scrollParams) {
                                                if (ap.this.getPager().getPageData().getIsIOS()) {
                                                    ap apVar3 = ap.this;
                                                    final NBPHalfScreenModalView nBPHalfScreenModalView12 = nBPHalfScreenModalView11;
                                                    Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPHalfScreenModalView.body.1.3.3.2.4.1
                                                        {
                                                            super(0);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function0
                                                        public final Unit invoke() {
                                                            NBPHalfScreenModalView nBPHalfScreenModalView13 = NBPHalfScreenModalView.this;
                                                            nBPHalfScreenModalView13.scrollEnable$delegate.setValue(nBPHalfScreenModalView13, NBPHalfScreenModalView.$$delegatedProperties[2], Boolean.TRUE);
                                                            return Unit.INSTANCE;
                                                        }
                                                    };
                                                    KProperty<Object>[] kPropertyArr = IPagerIdKtxKt.$$delegatedProperties;
                                                    TimerKt.e(apVar3.getPagerId(), 100, function0);
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPHalfScreenModalView nBPHalfScreenModalView9 = NBPHalfScreenModalView.this;
                                ac.b(aqVar2, new Function1<ab, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPHalfScreenModalView.body.1.3.3.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ab abVar) {
                                        ab abVar2 = abVar;
                                        final NBPHalfScreenModalView nBPHalfScreenModalView10 = NBPHalfScreenModalView.this;
                                        abVar2.attr(new Function1<aa, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPHalfScreenModalView.body.1.3.3.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(aa aaVar) {
                                                aa aaVar2 = aaVar;
                                                aaVar2.size(aaVar2.getPagerData().m(), NBPHalfScreenModalView.access$getAttr(NBPHalfScreenModalView.this).contentHeight);
                                                aaVar2.mo113backgroundColor(QUIToken.color$default("bg_middle_light"));
                                                aaVar2.borderRadius(NBPHalfScreenModalView.access$getAttr(NBPHalfScreenModalView.this).contentBorderRadius, NBPHalfScreenModalView.access$getAttr(NBPHalfScreenModalView.this).contentBorderRadius, 0.0f, 0.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        NBPHalfScreenModalView.this.contentBuilder.invoke(abVar2);
                                        return Unit.INSTANCE;
                                    }
                                });
                                w.a(aqVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPHalfScreenModalView.body.1.3.3.4
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar) {
                                        vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPHalfScreenModalView.body.1.3.3.4.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.size(tVar2.getPagerData().m(), 10.0f);
                                                tVar2.mo113backgroundColor(QUIToken.color$default("bg_middle_light"));
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
                Function1<? super ViewContainer<?, ?>, Unit> function1 = NBPHalfScreenModalView.this.topLevelExtraBuilder;
                if (function1 != null) {
                    function1.invoke(viewContainer2);
                }
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new NBPHalfScreenModalAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NBPHalfScreenModalEvent();
    }

    public final void setAnimationOpen(boolean z16) {
        this.animationOpen$delegate.setValue(this, $$delegatedProperties[1], Boolean.valueOf(z16));
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void viewDidLayout() {
        super.viewDidLayout();
        setAnimationOpen(true);
    }
}
