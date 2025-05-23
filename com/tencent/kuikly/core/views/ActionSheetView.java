package com.tencent.kuikly.core.views;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.c;
import com.tencent.kuikly.core.base.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.EventName;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.directives.LoopDirectivesView;
import com.tencent.kuikly.core.directives.LoopDirectivesViewKt;
import com.tencent.kuikly.core.views.compose.ButtonView;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J%\u0010\u000b\u001a\u001f\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\b\u0012\u0004\u0012\u00020\u00040\u0007j\u0002`\t\u00a2\u0006\u0002\b\nH\u0002JT\u0010\u0013\u001a\u001f\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\b\u0012\u0004\u0012\u00020\u00040\u0007j\u0002`\t\u00a2\u0006\u0002\b\n2\u001b\u0010\u000e\u001a\u0017\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00040\u0007j\u0002`\r\u00a2\u0006\u0002\b\n2\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u0011H\u0002J-\u0010\u0015\u001a\u001f\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\b\u0012\u0004\u0012\u00020\u00040\u0007j\u0002`\t\u00a2\u0006\u0002\b\n2\u0006\u0010\u0014\u001a\u00020\u0011H\u0002J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0016J\b\u0010\u0018\u001a\u00020\u0004H\u0016R+\u0010 \u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00118B@BX\u0082\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/kuikly/core/views/ActionSheetView;", "Lcom/tencent/kuikly/core/base/ab;", "Lcom/tencent/kuikly/core/views/ActionSheetAttr;", "Lcom/tencent/kuikly/core/views/d;", "", "w", "v", "Lkotlin/Function1;", "Lcom/tencent/kuikly/core/base/ViewContainer;", "Lcom/tencent/kuikly/core/base/ViewBuilder;", "Lkotlin/ExtensionFunctionType;", "body", "Lcom/tencent/kuikly/core/views/ce;", "Lcom/tencent/kuikly/core/views/ActionButtonTitleAttr;", "buttonTitleAttr", "", "index", "", "isBold", "p", "isVertical", "t", "r", ReportConstant.COSTREPORT_PREFIX, "didInit", "<set-?>", "a", "Lkotlin/properties/ReadWriteProperty;", "u", "()Z", HippyTKDListViewAdapter.X, "(Z)V", "showActionSheeting", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class ActionSheetView extends com.tencent.kuikly.core.base.ab<ActionSheetAttr, d> {

    /* renamed from: b, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f118276b = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(ActionSheetView.class, "showActionSheeting", "getShowActionSheeting()Z", 0))};

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ReadWriteProperty showActionSheeting = c01.c.a(Boolean.FALSE);

    private final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.kuikly.core.views.ActionSheetView$body$1
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
                final ActionSheetView actionSheetView = ActionSheetView.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.kuikly.core.views.ActionSheetView$body$1.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        boolean u16;
                        u16 = ActionSheetView.this.u();
                        return Boolean.valueOf(u16 || ActionSheetView.l(ActionSheetView.this).q());
                    }
                };
                final ActionSheetView actionSheetView2 = ActionSheetView.this;
                ConditionViewKt.c(viewContainer, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.kuikly.core.views.ActionSheetView$body$1.2
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
                        boolean inWindow = ActionSheetView.l(ActionSheetView.this).getInWindow();
                        final ActionSheetView actionSheetView3 = ActionSheetView.this;
                        bb.a(vif, inWindow, new Function1<ModalView, Unit>() { // from class: com.tencent.kuikly.core.views.ActionSheetView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(ModalView modalView) {
                                invoke2(modalView);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(ModalView Modal) {
                                Intrinsics.checkNotNullParameter(Modal, "$this$Modal");
                                Modal.attr(new Function1<com.tencent.kuikly.core.base.m, Unit>() { // from class: com.tencent.kuikly.core.views.ActionSheetView.body.1.2.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(com.tencent.kuikly.core.base.m mVar) {
                                        invoke2(mVar);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(com.tencent.kuikly.core.base.m attr) {
                                        Intrinsics.checkNotNullParameter(attr, "$this$attr");
                                        attr.justifyContentFlexEnd();
                                    }
                                });
                                TransitionType transitionType = TransitionType.FADE_IN_OUT;
                                final ActionSheetView actionSheetView4 = ActionSheetView.this;
                                TransitionViewKt.a(Modal, transitionType, new Function1<TransitionView, Unit>() { // from class: com.tencent.kuikly.core.views.ActionSheetView.body.1.2.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(TransitionView transitionView) {
                                        invoke2(transitionView);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(TransitionView TransitionView) {
                                        Intrinsics.checkNotNullParameter(TransitionView, "$this$TransitionView");
                                        final ActionSheetView actionSheetView5 = ActionSheetView.this;
                                        TransitionView.attr(new Function1<ci, Unit>() { // from class: com.tencent.kuikly.core.views.ActionSheetView.body.1.2.1.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(ci ciVar) {
                                                invoke2(ciVar);
                                                return Unit.INSTANCE;
                                            }

                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(ci attr) {
                                                Intrinsics.checkNotNullParameter(attr, "$this$attr");
                                                attr.r(ActionSheetView.l(ActionSheetView.this).q());
                                                attr.absolutePositionAllZero();
                                                attr.h(b.Companion.p(com.tencent.kuikly.core.base.b.INSTANCE, 0.3f, 0.9f, 1.0f, null, 8, null));
                                            }
                                        });
                                        final ActionSheetView actionSheetView6 = ActionSheetView.this;
                                        TransitionView.event(new Function1<cj, Unit>() { // from class: com.tencent.kuikly.core.views.ActionSheetView.body.1.2.1.2.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(cj cjVar) {
                                                invoke2(cjVar);
                                                return Unit.INSTANCE;
                                            }

                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(cj event) {
                                                Intrinsics.checkNotNullParameter(event, "$this$event");
                                                final ActionSheetView actionSheetView7 = ActionSheetView.this;
                                                event.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.kuikly.core.views.ActionSheetView.body.1.2.1.2.2.1
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
                                                        Function1<ClickParams, Unit> l3 = ActionSheetView.m(ActionSheetView.this).l();
                                                        if (l3 != null) {
                                                            l3.invoke(it);
                                                        }
                                                        ActionSheetView.m(ActionSheetView.this).onFireEvent(EventName.CLICK.getValue(), it);
                                                    }
                                                });
                                            }
                                        });
                                        Function1<ViewContainer<?, ?>, Unit> l3 = ActionSheetView.l(ActionSheetView.this).l();
                                        if (l3 != null) {
                                            l3.invoke(TransitionView);
                                        }
                                    }
                                });
                                TransitionType transitionType2 = TransitionType.DIRECTION_FROM_BOTTOM;
                                final ActionSheetView actionSheetView5 = ActionSheetView.this;
                                TransitionViewKt.a(Modal, transitionType2, new Function1<TransitionView, Unit>() { // from class: com.tencent.kuikly.core.views.ActionSheetView.body.1.2.1.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(TransitionView transitionView) {
                                        invoke2(transitionView);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(TransitionView TransitionView) {
                                        Intrinsics.checkNotNullParameter(TransitionView, "$this$TransitionView");
                                        final ActionSheetView actionSheetView6 = ActionSheetView.this;
                                        TransitionView.attr(new Function1<ci, Unit>() { // from class: com.tencent.kuikly.core.views.ActionSheetView.body.1.2.1.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(ci ciVar) {
                                                invoke2(ciVar);
                                                return Unit.INSTANCE;
                                            }

                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(ci attr) {
                                                Intrinsics.checkNotNullParameter(attr, "$this$attr");
                                                attr.r(ActionSheetView.l(ActionSheetView.this).q());
                                                attr.h(b.Companion.p(com.tencent.kuikly.core.base.b.INSTANCE, 0.3f, 0.9f, 1.0f, null, 8, null));
                                            }
                                        });
                                        final ActionSheetView actionSheetView7 = ActionSheetView.this;
                                        TransitionView.event(new Function1<cj, Unit>() { // from class: com.tencent.kuikly.core.views.ActionSheetView.body.1.2.1.3.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(cj cjVar) {
                                                invoke2(cjVar);
                                                return Unit.INSTANCE;
                                            }

                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(cj event) {
                                                Intrinsics.checkNotNullParameter(event, "$this$event");
                                                final ActionSheetView actionSheetView8 = ActionSheetView.this;
                                                event.transitionFinish(new Function1<Boolean, Unit>() { // from class: com.tencent.kuikly.core.views.ActionSheetView.body.1.2.1.3.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                                        invoke(bool.booleanValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(boolean z16) {
                                                        boolean u16;
                                                        Function0<Unit> k3;
                                                        ActionSheetView.this.x(z16);
                                                        u16 = ActionSheetView.this.u();
                                                        if (u16 || ActionSheetView.l(ActionSheetView.this).q() || (k3 = ActionSheetView.m(ActionSheetView.this).k()) == null) {
                                                            return;
                                                        }
                                                        k3.invoke();
                                                    }
                                                });
                                            }
                                        });
                                        final ActionSheetView actionSheetView8 = ActionSheetView.this;
                                        w.a(TransitionView, new Function1<v, Unit>() { // from class: com.tencent.kuikly.core.views.ActionSheetView.body.1.2.1.3.3
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
                                                View.event(new Function1<u, Unit>() { // from class: com.tencent.kuikly.core.views.ActionSheetView.body.1.2.1.3.3.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public /* bridge */ /* synthetic */ Unit invoke(u uVar) {
                                                        invoke2(uVar);
                                                        return Unit.INSTANCE;
                                                    }

                                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                    public final void invoke2(u event) {
                                                        Intrinsics.checkNotNullParameter(event, "$this$event");
                                                        event.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.kuikly.core.views.ActionSheetView.body.1.2.1.3.3.1.1
                                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                            public final void invoke2(ClickParams it) {
                                                                Intrinsics.checkNotNullParameter(it, "it");
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                                                                invoke2(clickParams);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                    }
                                                });
                                                Function1<ViewContainer<?, ?>, Unit> n3 = ActionSheetView.l(ActionSheetView.this).n();
                                                if (n3 != null) {
                                                    n3.invoke(View);
                                                }
                                            }
                                        });
                                    }
                                });
                            }
                        });
                    }
                });
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ ActionSheetAttr l(ActionSheetView actionSheetView) {
        return (ActionSheetAttr) actionSheetView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ d m(ActionSheetView actionSheetView) {
        return (d) actionSheetView.getEvent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Function1<ViewContainer<?, ?>, Unit> p(final Function1<? super ce, Unit> buttonTitleAttr, final int index, final boolean isBold) {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.kuikly.core.views.ActionSheetView$createActionButton$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                final boolean z16 = isBold;
                final Function1<ce, Unit> function1 = buttonTitleAttr;
                final ActionSheetView actionSheetView = this;
                final int i3 = index;
                com.tencent.kuikly.core.views.compose.c.a(viewContainer, new Function1<ButtonView, Unit>() { // from class: com.tencent.kuikly.core.views.ActionSheetView$createActionButton$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ButtonView buttonView) {
                        invoke2(buttonView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(ButtonView Button) {
                        Intrinsics.checkNotNullParameter(Button, "$this$Button");
                        final boolean z17 = z16;
                        final Function1<ce, Unit> function12 = function1;
                        Button.attr(new Function1<com.tencent.kuikly.core.views.compose.a, Unit>() { // from class: com.tencent.kuikly.core.views.ActionSheetView.createActionButton.1.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.kuikly.core.views.compose.a aVar) {
                                invoke2(aVar);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(com.tencent.kuikly.core.views.compose.a attr) {
                                Intrinsics.checkNotNullParameter(attr, "$this$attr");
                                attr.mo141height(56.0f);
                                final boolean z18 = z17;
                                final Function1<ce, Unit> function13 = function12;
                                attr.q(new Function1<ce, Unit>() { // from class: com.tencent.kuikly.core.views.ActionSheetView.createActionButton.1.1.1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(ce ceVar) {
                                        invoke2(ceVar);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(ce titleAttr) {
                                        Intrinsics.checkNotNullParameter(titleAttr, "$this$titleAttr");
                                        ce.fontSize$default(titleAttr, 20.0f, null, 2, null);
                                        titleAttr.mo141height(24.0f);
                                        if (z18) {
                                            titleAttr.fontWeightSemisolid();
                                        } else {
                                            titleAttr.fontWeight400();
                                        }
                                        titleAttr.color(new com.tencent.kuikly.core.base.h(4278221567L));
                                        function13.invoke(titleAttr);
                                    }
                                });
                                attr.highlightBackgroundColor(new com.tencent.kuikly.core.base.h(0, 0, 0, 0.1f));
                            }
                        });
                        final ActionSheetView actionSheetView2 = actionSheetView;
                        final int i16 = i3;
                        Button.event(new Function1<com.tencent.kuikly.core.views.compose.b, Unit>() { // from class: com.tencent.kuikly.core.views.ActionSheetView.createActionButton.1.1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.kuikly.core.views.compose.b bVar) {
                                invoke2(bVar);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(com.tencent.kuikly.core.views.compose.b event) {
                                Intrinsics.checkNotNullParameter(event, "$this$event");
                                final ActionSheetView actionSheetView3 = ActionSheetView.this;
                                final int i17 = i16;
                                event.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.kuikly.core.views.ActionSheetView.createActionButton.1.1.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                        Function1<Integer, Unit> m3 = ActionSheetView.m(ActionSheetView.this).m();
                                        if (m3 != null) {
                                            m3.invoke(Integer.valueOf(i17));
                                        }
                                    }
                                });
                            }
                        });
                    }
                });
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Function1<ViewContainer<?, ?>, Unit> t(final boolean isVertical) {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.kuikly.core.views.ActionSheetView$createLineView$1
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
            public final void invoke2(ViewContainer<?, ?> viewContainer) {
                Intrinsics.checkNotNullParameter(viewContainer, "$this$null");
                final boolean z16 = isVertical;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.kuikly.core.views.ActionSheetView$createLineView$1.1
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
                        View.attr(new Function1<t, Unit>() { // from class: com.tencent.kuikly.core.views.ActionSheetView.createLineView.1.1.1
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
                                    attr.mo153width(0.5f);
                                } else {
                                    attr.mo141height(0.5f);
                                }
                                if (attr.getPager().isNightMode()) {
                                    attr.mo113backgroundColor(new com.tencent.kuikly.core.base.h(255, 255, 255, 0.24f));
                                } else {
                                    attr.mo113backgroundColor(new com.tencent.kuikly.core.base.h(0, 0, 0, 0.24f));
                                }
                            }
                        });
                    }
                });
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean u() {
        return ((Boolean) this.showActionSheeting.getValue(this, f118276b[0])).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void v() {
        if (((ActionSheetAttr) getAttr()).l() != null) {
            return;
        }
        ((ActionSheetAttr) getAttr()).s(new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.kuikly.core.views.ActionSheetView$initBackgroundViewCreator$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ViewContainer<?, ?> viewContainer) {
                invoke2(viewContainer);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ViewContainer<?, ?> viewContainer) {
                Intrinsics.checkNotNullParameter(viewContainer, "$this$null");
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.kuikly.core.views.ActionSheetView$initBackgroundViewCreator$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(v vVar) {
                        invoke2(vVar);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(v View) {
                        Intrinsics.checkNotNullParameter(View, "$this$View");
                        View.attr(new Function1<t, Unit>() { // from class: com.tencent.kuikly.core.views.ActionSheetView.initBackgroundViewCreator.1.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(t tVar) {
                                invoke2(tVar);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(t attr) {
                                Intrinsics.checkNotNullParameter(attr, "$this$attr");
                                attr.absolutePositionAllZero();
                                attr.mo113backgroundColor(new com.tencent.kuikly.core.base.h(0, 0, 0, 0.2f));
                            }
                        });
                    }
                });
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void w() {
        if (((ActionSheetAttr) getAttr()).n() != null) {
            return;
        }
        ((ActionSheetAttr) getAttr()).u(new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.kuikly.core.views.ActionSheetView$initContentViewCreator$1
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
                final ActionSheetView actionSheetView = ActionSheetView.this;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.kuikly.core.views.ActionSheetView$initContentViewCreator$1.1
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
                        View.attr(new Function1<t, Unit>() { // from class: com.tencent.kuikly.core.views.ActionSheetView.initContentViewCreator.1.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(t tVar) {
                                invoke2(tVar);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(t attr) {
                                Intrinsics.checkNotNullParameter(attr, "$this$attr");
                                attr.borderRadius(14.0f);
                                c.a.a(attr, 0.0f, 8.0f, 8.0f, 8.0f, 1, null);
                                if (attr.getPager().isNightMode()) {
                                    attr.mo113backgroundColor(new com.tencent.kuikly.core.base.h(0, 0, 0, 0.85f));
                                } else {
                                    attr.mo113backgroundColor(new com.tencent.kuikly.core.base.h(255, 255, 255, 0.75f));
                                }
                            }
                        });
                        o.a(View, new Function1<n, Unit>() { // from class: com.tencent.kuikly.core.views.ActionSheetView.initContentViewCreator.1.1.2
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(n nVar) {
                                invoke2(nVar);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(n Blur) {
                                Intrinsics.checkNotNullParameter(Blur, "$this$Blur");
                                Blur.attr(new Function1<m, Unit>() { // from class: com.tencent.kuikly.core.views.ActionSheetView.initContentViewCreator.1.1.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(m mVar) {
                                        invoke2(mVar);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(m attr) {
                                        Intrinsics.checkNotNullParameter(attr, "$this$attr");
                                        attr.absolutePositionAllZero();
                                    }
                                });
                            }
                        });
                        final ActionSheetView actionSheetView2 = ActionSheetView.this;
                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.kuikly.core.views.ActionSheetView.initContentViewCreator.1.1.3
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Boolean.valueOf(ActionSheetView.l(ActionSheetView.this).o().length() > 0);
                            }
                        };
                        final ActionSheetView actionSheetView3 = ActionSheetView.this;
                        ConditionViewKt.c(View, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.kuikly.core.views.ActionSheetView.initContentViewCreator.1.1.4
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
                                final ActionSheetView actionSheetView4 = ActionSheetView.this;
                                w.a(vif, new Function1<v, Unit>() { // from class: com.tencent.kuikly.core.views.ActionSheetView.initContentViewCreator.1.1.4.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(v vVar) {
                                        invoke2(vVar);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(v View2) {
                                        Intrinsics.checkNotNullParameter(View2, "$this$View");
                                        View2.attr(new Function1<t, Unit>() { // from class: com.tencent.kuikly.core.views.ActionSheetView.initContentViewCreator.1.1.4.1.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(t tVar) {
                                                invoke2(tVar);
                                                return Unit.INSTANCE;
                                            }

                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(t attr) {
                                                Intrinsics.checkNotNullParameter(attr, "$this$attr");
                                                attr.margin(12.0f);
                                                attr.allCenter();
                                            }
                                        });
                                        final ActionSheetView actionSheetView5 = ActionSheetView.this;
                                        cg.a(View2, new Function1<TextView, Unit>() { // from class: com.tencent.kuikly.core.views.ActionSheetView.initContentViewCreator.1.1.4.1.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                                                invoke2(textView);
                                                return Unit.INSTANCE;
                                            }

                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(TextView Text) {
                                                Intrinsics.checkNotNullParameter(Text, "$this$Text");
                                                final ActionSheetView actionSheetView6 = ActionSheetView.this;
                                                Text.attr(new Function1<ce, Unit>() { // from class: com.tencent.kuikly.core.views.ActionSheetView.initContentViewCreator.1.1.4.1.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public /* bridge */ /* synthetic */ Unit invoke(ce ceVar) {
                                                        invoke2(ceVar);
                                                        return Unit.INSTANCE;
                                                    }

                                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                    public final void invoke2(ce attr) {
                                                        Intrinsics.checkNotNullParameter(attr, "$this$attr");
                                                        ce.fontSize$default(attr, 13.0f, null, 2, null);
                                                        attr.lineHeight(18.0f);
                                                        attr.fontWeightSemisolid();
                                                        attr.text(ActionSheetView.l(ActionSheetView.this).o());
                                                        attr.getPager().isNightMode();
                                                        attr.color(4287202442L);
                                                        attr.textAlignCenter();
                                                    }
                                                });
                                            }
                                        });
                                    }
                                });
                            }
                        });
                        final ActionSheetView actionSheetView4 = ActionSheetView.this;
                        Function0<com.tencent.kuikly.core.reactive.collection.c<Function1<? super ce, ? extends Unit>>> function02 = new Function0<com.tencent.kuikly.core.reactive.collection.c<Function1<? super ce, ? extends Unit>>>() { // from class: com.tencent.kuikly.core.views.ActionSheetView.initContentViewCreator.1.1.5
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final com.tencent.kuikly.core.reactive.collection.c<Function1<? super ce, ? extends Unit>> invoke() {
                                return ActionSheetView.l(ActionSheetView.this).k();
                            }
                        };
                        final ActionSheetView actionSheetView5 = ActionSheetView.this;
                        LoopDirectivesViewKt.a(View, function02, new Function2<LoopDirectivesView<Function1<? super ce, ? extends Unit>>, Function1<? super ce, ? extends Unit>, Unit>() { // from class: com.tencent.kuikly.core.views.ActionSheetView.initContentViewCreator.1.1.6
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(LoopDirectivesView<Function1<? super ce, ? extends Unit>> loopDirectivesView, Function1<? super ce, ? extends Unit> function1) {
                                invoke2((LoopDirectivesView<Function1<ce, Unit>>) loopDirectivesView, (Function1<? super ce, Unit>) function1);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(LoopDirectivesView<Function1<ce, Unit>> vfor, final Function1<? super ce, Unit> buttonTitleAttr) {
                                Intrinsics.checkNotNullParameter(vfor, "$this$vfor");
                                Intrinsics.checkNotNullParameter(buttonTitleAttr, "buttonTitleAttr");
                                final ActionSheetView actionSheetView6 = ActionSheetView.this;
                                w.a(vfor, new Function1<v, Unit>() { // from class: com.tencent.kuikly.core.views.ActionSheetView.initContentViewCreator.1.1.6.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(v vVar) {
                                        invoke2(vVar);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX WARN: Code restructure failed: missing block: B:6:0x002d, code lost:
                                    
                                        if ((com.tencent.kuikly.core.views.ActionSheetView.l(r1).o().length() == 0) == false) goto L9;
                                     */
                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    /*
                                        Code decompiled incorrectly, please refer to instructions dump.
                                    */
                                    public final void invoke2(v View2) {
                                        Function1 t16;
                                        Intrinsics.checkNotNullParameter(View2, "$this$View");
                                        int indexOf = ActionSheetView.l(ActionSheetView.this).k().indexOf(buttonTitleAttr);
                                        if (indexOf == 0) {
                                        }
                                        t16 = ActionSheetView.this.t(false);
                                        t16.invoke(View2);
                                        ActionSheetView.q(ActionSheetView.this, buttonTitleAttr, indexOf + 1, false, 4, null).invoke(View2);
                                    }
                                });
                            }
                        });
                    }
                });
                final ActionSheetView actionSheetView2 = ActionSheetView.this;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.kuikly.core.views.ActionSheetView$initContentViewCreator$1.2
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
                        Function1 p16;
                        Intrinsics.checkNotNullParameter(View, "$this$View");
                        View.attr(new Function1<t, Unit>() { // from class: com.tencent.kuikly.core.views.ActionSheetView.initContentViewCreator.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(t tVar) {
                                invoke2(tVar);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(t attr) {
                                Intrinsics.checkNotNullParameter(attr, "$this$attr");
                                attr.marginBottom(attr.getPagerData().getIsIphoneX() ? 32.0f : 8.0f);
                                attr.marginLeft(8.0f).marginRight(8.0f);
                                if (attr.getPager().isNightMode()) {
                                    attr.mo113backgroundColor(com.tencent.kuikly.core.base.h.INSTANCE.b());
                                } else {
                                    attr.mo113backgroundColor(com.tencent.kuikly.core.base.h.INSTANCE.m());
                                }
                                attr.borderRadius(14.0f);
                            }
                        });
                        ActionSheetView actionSheetView3 = ActionSheetView.this;
                        p16 = actionSheetView3.p(ActionSheetView.l(actionSheetView3).m(), 0, true);
                        p16.invoke(View);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(boolean z16) {
        this.showActionSheeting.setValue(this, f118276b[0], Boolean.valueOf(z16));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public void didInit() {
        super.didInit();
        x(((ActionSheetAttr) getAttr()).q());
        w();
        v();
        body().invoke(this);
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public ActionSheetAttr createAttr() {
        return new ActionSheetAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public d createEvent() {
        return new d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Function1 q(ActionSheetView actionSheetView, Function1 function1, int i3, boolean z16, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            z16 = false;
        }
        return actionSheetView.p(function1, i3, z16);
    }
}
