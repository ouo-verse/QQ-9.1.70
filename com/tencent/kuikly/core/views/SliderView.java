package com.tencent.kuikly.core.views;

import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.PanGestureParams;
import com.tencent.kuikly.core.exception.PagerNotFoundExceptionKt;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016J!\u0010\u000e\u001a\u00020\u00062\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u000b\u00a2\u0006\u0002\b\fH\u0016J%\u0010\u0011\u001a\u001f\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000f\u0012\u0004\u0012\u00020\u00060\u000bj\u0002`\u0010\u00a2\u0006\u0002\b\fH\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/kuikly/core/views/SliderView;", "Lcom/tencent/kuikly/core/base/ComposeView;", "Lcom/tencent/kuikly/core/views/bp;", "Lcom/tencent/kuikly/core/views/bq;", "Lcom/tencent/kuikly/core/base/event/h;", "params", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", "l", "didInit", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "init", "attr", "Lcom/tencent/kuikly/core/base/ViewContainer;", "Lcom/tencent/kuikly/core/base/ViewBuilder;", "body", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class SliderView extends ComposeView<bp, bq> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ bp h(SliderView sliderView) {
        return (bp) sliderView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ bq i(SliderView sliderView) {
        return (bq) sliderView.getEvent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void m(PanGestureParams params) {
        float y16;
        float K;
        float m3;
        Function1<PanGestureParams, Unit> i3;
        Function1<PanGestureParams, Unit> h16;
        if (((bp) getAttr()).getDirectionHorizontal()) {
            y16 = params.getX() - ((bp) getAttr()).n();
            K = getFlexNode().U() - ((bp) getAttr()).n();
            m3 = ((bp) getAttr()).o();
        } else {
            y16 = params.getY() - ((bp) getAttr()).p();
            K = getFlexNode().K() - ((bp) getAttr()).p();
            m3 = ((bp) getAttr()).m();
        }
        ((bp) getAttr()).B(Math.max(0.0f, Math.min(y16 / (K - m3), 1.0f)));
        if (Intrinsics.areEqual(params.getState(), "start") && (h16 = ((bq) getEvent()).h()) != null) {
            h16.invoke(params);
        }
        if (!Intrinsics.areEqual(params.getState(), "end") || (i3 = ((bq) getEvent()).i()) == null) {
            return;
        }
        i3.invoke(params);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.DeclarativeBaseView, com.tencent.kuikly.core.base.q
    public void attr(Function1<? super bp, Unit> init) {
        Intrinsics.checkNotNullParameter(init, "init");
        super.attr(init);
        final boolean directionHorizontal = ((bp) getAttr()).getDirectionHorizontal();
        if (((bp) getAttr()).z() == null) {
            ((bp) getAttr()).N(new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.kuikly.core.views.SliderView$attr$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ViewContainer<?, ?> viewContainer) {
                    invoke2(viewContainer);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ViewContainer<?, ?> trackViewCreator) {
                    Intrinsics.checkNotNullParameter(trackViewCreator, "$this$trackViewCreator");
                    final boolean z16 = directionHorizontal;
                    final SliderView sliderView = this;
                    w.a(trackViewCreator, new Function1<v, Unit>() { // from class: com.tencent.kuikly.core.views.SliderView$attr$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(v vVar) {
                            invoke2(vVar);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(v View) {
                            Intrinsics.checkNotNullParameter(View, "$this$View");
                            final boolean z17 = z16;
                            final SliderView sliderView2 = sliderView;
                            View.attr(new Function1<t, Unit>() { // from class: com.tencent.kuikly.core.views.SliderView.attr.1.1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(t tVar) {
                                    invoke2(tVar);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(t attr) {
                                    Intrinsics.checkNotNullParameter(attr, "$this$attr");
                                    if (z17) {
                                        attr.mo141height(SliderView.h(sliderView2).y());
                                    } else {
                                        attr.mo153width(SliderView.h(sliderView2).y());
                                    }
                                    attr.mo113backgroundColor(SliderView.h(sliderView2).x());
                                    attr.borderRadius(SliderView.h(sliderView2).y() / 2.0f);
                                }
                            });
                        }
                    });
                }
            });
        }
        if (((bp) getAttr()).r() == null) {
            ((bp) getAttr()).A(new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.kuikly.core.views.SliderView$attr$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ViewContainer<?, ?> viewContainer) {
                    invoke2(viewContainer);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ViewContainer<?, ?> progressViewCreator) {
                    Intrinsics.checkNotNullParameter(progressViewCreator, "$this$progressViewCreator");
                    final boolean z16 = directionHorizontal;
                    final SliderView sliderView = this;
                    w.a(progressViewCreator, new Function1<v, Unit>() { // from class: com.tencent.kuikly.core.views.SliderView$attr$2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(v vVar) {
                            invoke2(vVar);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(v View) {
                            Intrinsics.checkNotNullParameter(View, "$this$View");
                            final boolean z17 = z16;
                            final SliderView sliderView2 = sliderView;
                            View.attr(new Function1<t, Unit>() { // from class: com.tencent.kuikly.core.views.SliderView.attr.2.1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(t tVar) {
                                    invoke2(tVar);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(t attr) {
                                    Intrinsics.checkNotNullParameter(attr, "$this$attr");
                                    if (z17) {
                                        attr.mo141height(SliderView.h(sliderView2).y());
                                    } else {
                                        attr.mo153width(SliderView.h(sliderView2).y());
                                    }
                                    attr.mo113backgroundColor(SliderView.h(sliderView2).q());
                                    attr.borderRadius(SliderView.h(sliderView2).y() / 2.0f);
                                }
                            });
                        }
                    });
                }
            });
        }
        if (((bp) getAttr()).w() == null) {
            ((bp) getAttr()).L(new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.kuikly.core.views.SliderView$attr$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ViewContainer<?, ?> viewContainer) {
                    invoke2(viewContainer);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ViewContainer<?, ?> thumbViewCreator) {
                    Intrinsics.checkNotNullParameter(thumbViewCreator, "$this$thumbViewCreator");
                    final SliderView sliderView = SliderView.this;
                    w.a(thumbViewCreator, new Function1<v, Unit>() { // from class: com.tencent.kuikly.core.views.SliderView$attr$3.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(v vVar) {
                            invoke2(vVar);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(v View) {
                            Intrinsics.checkNotNullParameter(View, "$this$View");
                            final SliderView sliderView2 = SliderView.this;
                            View.attr(new Function1<t, Unit>() { // from class: com.tencent.kuikly.core.views.SliderView.attr.3.1.1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(t tVar) {
                                    invoke2(tVar);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(t attr) {
                                    Intrinsics.checkNotNullParameter(attr, "$this$attr");
                                    attr.size(SliderView.h(SliderView.this).v().getWidth(), SliderView.h(SliderView.this).v().getHeight());
                                    attr.borderRadius(SliderView.h(SliderView.this).v().getHeight() / 2.0f);
                                    attr.mo113backgroundColor(SliderView.h(SliderView.this).u());
                                }
                            });
                        }
                    });
                }
            });
        }
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.kuikly.core.views.SliderView$body$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ViewContainer<?, ?> viewContainer) {
                invoke2(viewContainer);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ViewContainer<?, ?> viewContainer) {
                Intrinsics.checkNotNullParameter(viewContainer, "$this$null");
                final SliderView sliderView = SliderView.this;
                viewContainer.attr(new Function1<com.tencent.kuikly.core.base.m, Unit>() { // from class: com.tencent.kuikly.core.views.SliderView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(com.tencent.kuikly.core.base.m mVar) {
                        invoke2(mVar);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(com.tencent.kuikly.core.base.m attr) {
                        Intrinsics.checkNotNullParameter(attr, "$this$attr");
                        if (SliderView.h(SliderView.this).getDirectionHorizontal()) {
                            attr.flexDirectionRow();
                        } else {
                            attr.flexDirectionColumn();
                        }
                    }
                });
                final SliderView sliderView2 = SliderView.this;
                viewContainer.event(new Function1<Event, Unit>() { // from class: com.tencent.kuikly.core.views.SliderView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Event event) {
                        invoke2(event);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Event event) {
                        Intrinsics.checkNotNullParameter(event, "$this$event");
                        final SliderView sliderView3 = SliderView.this;
                        event.pan(new Function1<PanGestureParams, Unit>() { // from class: com.tencent.kuikly.core.views.SliderView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(PanGestureParams panGestureParams) {
                                invoke2(panGestureParams);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(PanGestureParams it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                SliderView.this.m(it);
                            }
                        });
                    }
                });
                final SliderView sliderView3 = SliderView.this;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.kuikly.core.views.SliderView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(v vVar) {
                        invoke2(vVar);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(v View) {
                        Intrinsics.checkNotNullParameter(View, "$this$View");
                        final SliderView sliderView4 = SliderView.this;
                        View.attr(new Function1<t, Unit>() { // from class: com.tencent.kuikly.core.views.SliderView.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(t tVar) {
                                invoke2(tVar);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(t attr) {
                                Intrinsics.checkNotNullParameter(attr, "$this$attr");
                                float n3 = SliderView.h(SliderView.this).n();
                                attr.absolutePosition(SliderView.h(SliderView.this).p(), n3, SliderView.h(SliderView.this).m(), SliderView.h(SliderView.this).o());
                                if (SliderView.h(SliderView.this).getDirectionHorizontal()) {
                                    attr.flexDirectionColumn();
                                } else {
                                    attr.flexDirectionRow();
                                }
                                attr.justifyContentCenter();
                            }
                        });
                        Function1<ViewContainer<?, ?>, Unit> z16 = SliderView.h(SliderView.this).z();
                        if (z16 != null) {
                            z16.invoke(View);
                        }
                    }
                });
                final SliderView sliderView4 = SliderView.this;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.kuikly.core.views.SliderView$body$1.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(v vVar) {
                        invoke2(vVar);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(v View) {
                        Intrinsics.checkNotNullParameter(View, "$this$View");
                        final SliderView sliderView5 = SliderView.this;
                        View.attr(new Function1<t, Unit>() { // from class: com.tencent.kuikly.core.views.SliderView.body.1.4.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(t tVar) {
                                invoke2(tVar);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(t attr) {
                                Intrinsics.checkNotNullParameter(attr, "$this$attr");
                                attr.justifyContentCenter();
                                if (SliderView.h(SliderView.this).getDirectionHorizontal()) {
                                    attr.flexDirectionColumn();
                                    Attr.absolutePosition$default(attr, SliderView.h(SliderView.this).p(), SliderView.h(SliderView.this).n(), SliderView.h(SliderView.this).m(), 0.0f, 8, null);
                                    attr.mo153width(SliderView.h(SliderView.this).j() * SliderView.h(SliderView.this).k());
                                    return;
                                }
                                attr.flexDirectionRow();
                                Attr.absolutePosition$default(attr, SliderView.h(SliderView.this).p(), SliderView.h(SliderView.this).n(), 0.0f, SliderView.h(SliderView.this).o(), 4, null);
                                attr.mo141height(SliderView.h(SliderView.this).i() * SliderView.h(SliderView.this).k());
                            }
                        });
                        Function1<ViewContainer<?, ?>, Unit> r16 = SliderView.h(SliderView.this).r();
                        if (r16 != null) {
                            r16.invoke(View);
                        }
                    }
                });
                final SliderView sliderView5 = SliderView.this;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.kuikly.core.views.SliderView$body$1.5
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(v vVar) {
                        invoke2(vVar);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(v View) {
                        Intrinsics.checkNotNullParameter(View, "$this$View");
                        final SliderView sliderView6 = SliderView.this;
                        View.attr(new Function1<t, Unit>() { // from class: com.tencent.kuikly.core.views.SliderView.body.1.5.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(t tVar) {
                                invoke2(tVar);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(t attr) {
                                Intrinsics.checkNotNullParameter(attr, "$this$attr");
                                attr.allCenter();
                                if (SliderView.h(SliderView.this).getDirectionHorizontal()) {
                                    attr.transform(new com.tencent.kuikly.core.base.y(-0.5f, 0.0f, 0.0f, 0.0f, 12, null));
                                    attr.marginLeft(SliderView.h(SliderView.this).n() + (SliderView.h(SliderView.this).j() * SliderView.h(SliderView.this).k()));
                                } else {
                                    attr.transform(new com.tencent.kuikly.core.base.y(0.0f, -0.5f, 0.0f, 0.0f, 12, null));
                                    attr.marginTop(SliderView.h(SliderView.this).p() + (SliderView.h(SliderView.this).i() * SliderView.h(SliderView.this).k()));
                                }
                            }
                        });
                        Function1<ViewContainer<?, ?>, Unit> w3 = SliderView.h(SliderView.this).w();
                        if (w3 != null) {
                            w3.invoke(View);
                        }
                    }
                });
            }
        };
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x006a, code lost:
    
        if ((java.lang.Float.isNaN(r0) || java.lang.Float.isNaN(Float.NaN) ? java.lang.Float.isNaN(r0) && java.lang.Float.isNaN(Float.NaN) : java.lang.Math.abs(Float.NaN - r0) < 1.0E-5f) != false) goto L32;
     */
    @Override // com.tencent.kuikly.core.base.ComposeView, com.tencent.kuikly.core.base.AbstractBaseView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void didInit() {
        float U = getFlexNode().U();
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        if (!(Float.isNaN(U) || Float.isNaN(Float.NaN) ? Float.isNaN(U) && Float.isNaN(Float.NaN) : Math.abs(Float.NaN - U) < 1.0E-5f)) {
            float K = getFlexNode().K();
        }
        PagerNotFoundExceptionKt.a("Slider\u7ec4\u4ef6\u9700\u8981\u8bbe\u7f6e\u5bbd\u5ea6\u548c\u9ad8\u5ea6\uff08attr { size(xxx, xxx)}\uff09");
        super.didInit();
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        bindValueChange(new Function0<Object>() { // from class: com.tencent.kuikly.core.views.SliderView$didInit$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Float.valueOf(SliderView.h(SliderView.this).k());
            }
        }, new Function1<Object, Unit>() { // from class: com.tencent.kuikly.core.views.SliderView$didInit$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object it) {
                Function1<Float, Unit> j3;
                Intrinsics.checkNotNullParameter(it, "it");
                if (Ref.BooleanRef.this.element || (j3 = SliderView.i(this).j()) == null) {
                    return;
                }
                j3.invoke(Float.valueOf(SliderView.h(this).k()));
            }
        });
        booleanRef.element = false;
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public bp createAttr() {
        return new bp();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public bq createEvent() {
        return new bq();
    }
}
