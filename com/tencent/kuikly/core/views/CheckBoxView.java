package com.tencent.kuikly.core.views;

import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.exception.PagerNotFoundExceptionKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J!\u0010\b\u001a\u00020\u00052\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0002\b\u0006H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J%\u0010\f\u001a\u001f\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\n\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u000b\u00a2\u0006\u0002\b\u0006H\u0016J\b\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/kuikly/core/views/CheckBoxView;", "Lcom/tencent/kuikly/core/base/ComposeView;", "Lcom/tencent/kuikly/core/views/q;", "Lcom/tencent/kuikly/core/views/r;", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "init", "attr", "didInit", "Lcom/tencent/kuikly/core/base/ViewContainer;", "Lcom/tencent/kuikly/core/base/ViewBuilder;", "body", "j", "k", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class CheckBoxView extends ComposeView<q, r> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ q h(CheckBoxView checkBoxView) {
        return (q) checkBoxView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ r i(CheckBoxView checkBoxView) {
        return (r) checkBoxView.getEvent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.DeclarativeBaseView, com.tencent.kuikly.core.base.q
    public void attr(Function1<? super q, Unit> init) {
        Intrinsics.checkNotNullParameter(init, "init");
        super.attr(init);
        if (((q) getAttr()).r() == null) {
            ((q) getAttr()).l(new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.kuikly.core.views.CheckBoxView$attr$1
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
                public final void invoke2(ViewContainer<?, ?> defaultViewCreator) {
                    Intrinsics.checkNotNullParameter(defaultViewCreator, "$this$defaultViewCreator");
                    final CheckBoxView checkBoxView = CheckBoxView.this;
                    ah.a(defaultViewCreator, new Function1<ImageView, Unit>() { // from class: com.tencent.kuikly.core.views.CheckBoxView$attr$1.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(ImageView imageView) {
                            invoke2(imageView);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(ImageView Image) {
                            Intrinsics.checkNotNullParameter(Image, "$this$Image");
                            final CheckBoxView checkBoxView2 = CheckBoxView.this;
                            Image.attr(new Function1<af, Unit>() { // from class: com.tencent.kuikly.core.views.CheckBoxView.attr.1.1.1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(af afVar) {
                                    invoke2(afVar);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(af attr) {
                                    Intrinsics.checkNotNullParameter(attr, "$this$attr");
                                    attr.m140flex(1.0f);
                                    attr.o();
                                    b.a.b(attr, CheckBoxView.h(CheckBoxView.this).q(), false, 2, null);
                                }
                            });
                        }
                    });
                }
            });
        }
        if (((q) getAttr()).p() == null) {
            ((q) getAttr()).j(new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.kuikly.core.views.CheckBoxView$attr$2
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
                public final void invoke2(ViewContainer<?, ?> checkedViewCreator) {
                    Intrinsics.checkNotNullParameter(checkedViewCreator, "$this$checkedViewCreator");
                    final CheckBoxView checkBoxView = CheckBoxView.this;
                    ah.a(checkedViewCreator, new Function1<ImageView, Unit>() { // from class: com.tencent.kuikly.core.views.CheckBoxView$attr$2.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(ImageView imageView) {
                            invoke2(imageView);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(ImageView Image) {
                            Intrinsics.checkNotNullParameter(Image, "$this$Image");
                            final CheckBoxView checkBoxView2 = CheckBoxView.this;
                            Image.attr(new Function1<af, Unit>() { // from class: com.tencent.kuikly.core.views.CheckBoxView.attr.2.1.1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(af afVar) {
                                    invoke2(afVar);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(af attr) {
                                    Intrinsics.checkNotNullParameter(attr, "$this$attr");
                                    attr.m140flex(1.0f);
                                    attr.o();
                                    b.a.b(attr, CheckBoxView.h(CheckBoxView.this).o(), false, 2, null);
                                }
                            });
                        }
                    });
                }
            });
        }
        if (((q) getAttr()).u() == null) {
            if (((q) getAttr()).t().length() > 0) {
                ((q) getAttr()).m(new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.kuikly.core.views.CheckBoxView$attr$3
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
                    public final void invoke2(ViewContainer<?, ?> disableViewCreator) {
                        Intrinsics.checkNotNullParameter(disableViewCreator, "$this$disableViewCreator");
                        final CheckBoxView checkBoxView = CheckBoxView.this;
                        ah.a(disableViewCreator, new Function1<ImageView, Unit>() { // from class: com.tencent.kuikly.core.views.CheckBoxView$attr$3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(ImageView imageView) {
                                invoke2(imageView);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(ImageView Image) {
                                Intrinsics.checkNotNullParameter(Image, "$this$Image");
                                final CheckBoxView checkBoxView2 = CheckBoxView.this;
                                Image.attr(new Function1<af, Unit>() { // from class: com.tencent.kuikly.core.views.CheckBoxView.attr.3.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(af afVar) {
                                        invoke2(afVar);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(af attr) {
                                        Intrinsics.checkNotNullParameter(attr, "$this$attr");
                                        attr.m140flex(1.0f);
                                        attr.o();
                                        b.a.b(attr, CheckBoxView.h(CheckBoxView.this).t(), false, 2, null);
                                    }
                                });
                            }
                        });
                    }
                });
            }
        }
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.kuikly.core.views.CheckBoxView$body$1
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
                viewContainer.attr(new Function1<com.tencent.kuikly.core.base.m, Unit>() { // from class: com.tencent.kuikly.core.views.CheckBoxView$body$1.1
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(com.tencent.kuikly.core.base.m attr) {
                        Intrinsics.checkNotNullParameter(attr, "$this$attr");
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(com.tencent.kuikly.core.base.m mVar) {
                        invoke2(mVar);
                        return Unit.INSTANCE;
                    }
                });
                final CheckBoxView checkBoxView = CheckBoxView.this;
                viewContainer.event(new Function1<Event, Unit>() { // from class: com.tencent.kuikly.core.views.CheckBoxView$body$1.2
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
                        final CheckBoxView checkBoxView2 = CheckBoxView.this;
                        event.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.kuikly.core.views.CheckBoxView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                                invoke2(clickParams);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(ClickParams it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                CheckBoxView.h(CheckBoxView.this).v(!CheckBoxView.h(CheckBoxView.this).n());
                            }
                        });
                    }
                });
                final CheckBoxView checkBoxView2 = CheckBoxView.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.kuikly.core.views.CheckBoxView$body$1.3
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        boolean z16 = false;
                        if (CheckBoxView.h(CheckBoxView.this).s()) {
                            if (CheckBoxView.h(CheckBoxView.this).t().length() > 0) {
                                z16 = true;
                            }
                        }
                        return Boolean.valueOf(z16);
                    }
                };
                final CheckBoxView checkBoxView3 = CheckBoxView.this;
                ConditionViewKt.c(viewContainer, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.kuikly.core.views.CheckBoxView$body$1.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ConditionView conditionView) {
                        invoke2(conditionView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(ConditionView vif) {
                        Intrinsics.checkNotNullParameter(vif, "$this$vif");
                        Function1<ViewContainer<?, ?>, Unit> u16 = CheckBoxView.h(CheckBoxView.this).u();
                        if (u16 != null) {
                            u16.invoke(vif);
                        }
                    }
                });
                final CheckBoxView checkBoxView4 = CheckBoxView.this;
                Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.kuikly.core.views.CheckBoxView$body$1.5
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(CheckBoxView.h(CheckBoxView.this).n());
                    }
                };
                final CheckBoxView checkBoxView5 = CheckBoxView.this;
                ConditionViewKt.b(viewContainer, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.kuikly.core.views.CheckBoxView$body$1.6
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ConditionView conditionView) {
                        invoke2(conditionView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(ConditionView velseif) {
                        Intrinsics.checkNotNullParameter(velseif, "$this$velseif");
                        Function1<ViewContainer<?, ?>, Unit> p16 = CheckBoxView.h(CheckBoxView.this).p();
                        if (p16 != null) {
                            p16.invoke(velseif);
                        }
                    }
                });
                final CheckBoxView checkBoxView6 = CheckBoxView.this;
                ConditionViewKt.a(viewContainer, new Function1<ConditionView, Unit>() { // from class: com.tencent.kuikly.core.views.CheckBoxView$body$1.7
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ConditionView conditionView) {
                        invoke2(conditionView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(ConditionView velse) {
                        Intrinsics.checkNotNullParameter(velse, "$this$velse");
                        Function1<ViewContainer<?, ?>, Unit> r16 = CheckBoxView.h(CheckBoxView.this).r();
                        if (r16 != null) {
                            r16.invoke(velse);
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
        PagerNotFoundExceptionKt.a("CheckBox\u7ec4\u4ef6\u9700\u8981\u8bbe\u7f6e\u5bbd\u5ea6\u548c\u9ad8\u5ea6\uff08attr { size(xxx, xxx)}\uff09");
        super.didInit();
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        bindValueChange(new Function0<Object>() { // from class: com.tencent.kuikly.core.views.CheckBoxView$didInit$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(CheckBoxView.h(CheckBoxView.this).n());
            }
        }, new Function1<Object, Unit>() { // from class: com.tencent.kuikly.core.views.CheckBoxView$didInit$2
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
                Function1<Boolean, Unit> i3;
                Intrinsics.checkNotNullParameter(it, "it");
                if (Ref.BooleanRef.this.element || (i3 = CheckBoxView.i(this).i()) == null) {
                    return;
                }
                i3.invoke(Boolean.valueOf(CheckBoxView.h(this).n()));
            }
        });
        booleanRef.element = false;
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public q createAttr() {
        return new q();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public r createEvent() {
        return new r();
    }
}
