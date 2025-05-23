package com.tencent.hippykotlin.demo.pages.base;

import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.BindDirectivesView;
import com.tencent.kuikly.core.directives.BindDirectivesViewKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECStateView extends ComposeView<ECStateViewAttr, ECStateViewEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ ECStateViewAttr access$getAttr(ECStateView eCStateView) {
        return (ECStateViewAttr) eCStateView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ ECStateViewEvent access$getEvent(ECStateView eCStateView) {
        return (ECStateViewEvent) eCStateView.getEvent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = this;
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECStateView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final Ref.ObjectRef<ECStateView> objectRef2 = objectRef;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECStateView$body$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.absolutePositionAllZero();
                        mVar2.m152visibility(ECStateView.access$getAttr(objectRef2.element).getState() != NetworkState.Success);
                        return Unit.INSTANCE;
                    }
                });
                final Ref.ObjectRef<ECStateView> objectRef3 = objectRef;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECStateView$body$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ECStateView.access$getAttr(objectRef3.element).getState();
                    }
                };
                final Ref.ObjectRef<ECStateView> objectRef4 = objectRef;
                final ECStateView eCStateView = this;
                BindDirectivesViewKt.a(viewContainer2, function0, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECStateView$body$1.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(BindDirectivesView bindDirectivesView) {
                        BindDirectivesView bindDirectivesView2 = bindDirectivesView;
                        int ordinal = ECStateView.access$getAttr(objectRef4.element).getState().ordinal();
                        if (ordinal != 1) {
                            Unit unit = null;
                            if (ordinal == 2) {
                                Function1<? super ViewContainer<?, ?>, Unit> function1 = ECStateView.access$getAttr(objectRef4.element).errorViewBuilder;
                                if (function1 != null) {
                                    function1.invoke(bindDirectivesView2);
                                    unit = Unit.INSTANCE;
                                }
                                if (unit == null) {
                                    final ECStateView eCStateView2 = eCStateView;
                                    final Ref.ObjectRef<ECStateView> objectRef5 = objectRef4;
                                    ECErrorViewKt.ErrorView(bindDirectivesView2, new Function1<ECErrorView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECStateView.body.1.3.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ECErrorView eCErrorView) {
                                            ECErrorView eCErrorView2 = eCErrorView;
                                            final ECStateView eCStateView3 = ECStateView.this;
                                            final Ref.ObjectRef<ECStateView> objectRef6 = objectRef5;
                                            eCErrorView2.attr(new Function1<ErrorViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECStateView.body.1.3.2.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ErrorViewAttr errorViewAttr) {
                                                    ErrorViewAttr errorViewAttr2 = errorViewAttr;
                                                    errorViewAttr2.positionTop = Float.valueOf(0.0f);
                                                    String str = ECStateView.access$getAttr(ECStateView.this).errorImageToken;
                                                    if (str != null) {
                                                        errorViewAttr2.errorImgToken = str;
                                                    }
                                                    h hVar = ECStateView.access$getAttr(ECStateView.this).errorTextColor;
                                                    if (hVar != null) {
                                                        errorViewAttr2.textColor = hVar;
                                                    }
                                                    errorViewAttr2.buttonBgColor = ECStateView.access$getAttr(objectRef6.element).buttonBgColor;
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final ECStateView eCStateView4 = ECStateView.this;
                                            eCErrorView2.event(new Function1<ErrorViewEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECStateView.body.1.3.2.2
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ErrorViewEvent errorViewEvent) {
                                                    final ECStateView eCStateView5 = ECStateView.this;
                                                    errorViewEvent.registerEvent("clickRetryButton", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECStateView.body.1.3.2.2.1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(Object obj) {
                                                            Function0<Unit> function02 = ECStateView.access$getEvent(ECStateView.this).retryHandler;
                                                            if (function02 != null) {
                                                                function02.invoke();
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
                                }
                            } else if (ordinal == 3) {
                                Function1<? super ViewContainer<?, ?>, Unit> function12 = ECStateView.access$getAttr(objectRef4.element).emptyViewBuilder;
                                if (function12 != null) {
                                    function12.invoke(bindDirectivesView2);
                                    unit = Unit.INSTANCE;
                                }
                                if (unit == null) {
                                    final ECStateView eCStateView3 = eCStateView;
                                    bindDirectivesView2.addChild(new ECEmptyViewView(), new Function1<ECEmptyViewView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECStateView.body.1.3.3
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ECEmptyViewView eCEmptyViewView) {
                                            final ECStateView eCStateView4 = ECStateView.this;
                                            eCEmptyViewView.attr(new Function1<ECEmptyViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECStateView.body.1.3.3.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ECEmptyViewAttr eCEmptyViewAttr) {
                                                    ECEmptyViewAttr eCEmptyViewAttr2 = eCEmptyViewAttr;
                                                    eCEmptyViewAttr2.emptyText$delegate.setValue(eCEmptyViewAttr2, ECEmptyViewAttr.$$delegatedProperties[0], ECStateView.access$getAttr(ECStateView.this).emptyText);
                                                    h hVar = ECStateView.access$getAttr(ECStateView.this).emptyTextColor;
                                                    if (hVar != null) {
                                                        eCEmptyViewAttr2.textColor = hVar;
                                                    }
                                                    String str = ECStateView.access$getAttr(ECStateView.this).emptyImgToken;
                                                    if (str != null) {
                                                        eCEmptyViewAttr2.emptyImgToken = str;
                                                    }
                                                    h hVar2 = ECStateView.access$getAttr(ECStateView.this).emptyViewBackgroundColor;
                                                    if (hVar2 != null) {
                                                        eCEmptyViewAttr2.backgroundColor = hVar2;
                                                    }
                                                    eCEmptyViewAttr2.positionTop = Float.valueOf(0.0f);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                }
                            } else if (ordinal == 4) {
                                ECStateView.access$getAttr(eCStateView).m152visibility(false);
                            }
                        } else {
                            final Ref.ObjectRef<ECStateView> objectRef6 = objectRef4;
                            ECLoadingViewKt.ECLoading(bindDirectivesView2, new Function1<ECLoadingView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECStateView.body.1.3.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(ECLoadingView eCLoadingView) {
                                    final Ref.ObjectRef<ECStateView> objectRef7 = objectRef6;
                                    eCLoadingView.attr(new Function1<ECLoadingAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECStateView.body.1.3.1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ECLoadingAttr eCLoadingAttr) {
                                            ECLoadingAttr eCLoadingAttr2 = eCLoadingAttr;
                                            eCLoadingAttr2.delayShow = true;
                                            Integer num = ECStateView.access$getAttr(objectRef7.element).loadingDelay;
                                            if (num != null) {
                                                eCLoadingAttr2.delayTime = num.intValue();
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                        }
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new ECStateViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new ECStateViewEvent();
    }
}
