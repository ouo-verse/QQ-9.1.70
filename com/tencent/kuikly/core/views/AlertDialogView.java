package com.tencent.kuikly.core.views;

import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.EventName;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.directives.LoopDirectivesView;
import com.tencent.kuikly.core.directives.LoopDirectivesViewKt;
import com.tencent.kuikly.core.views.compose.ButtonView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
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
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J%\u0010\u000b\u001a\u001f\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\b\u0012\u0004\u0012\u00020\u00040\u0007j\u0002`\t\u00a2\u0006\u0002\b\nH\u0002JJ\u0010\u0011\u001a\u001f\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\b\u0012\u0004\u0012\u00020\u00040\u0007j\u0002`\t\u00a2\u0006\u0002\b\n2\u001b\u0010\u000e\u001a\u0017\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00040\u0007j\u0002`\r\u00a2\u0006\u0002\b\n2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J-\u0010\u0014\u001a\u001f\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\b\u0012\u0004\u0012\u00020\u00040\u0007j\u0002`\t\u00a2\u0006\u0002\b\n2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u0003H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016R+\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00128B@BX\u0082\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/kuikly/core/views/AlertDialogView;", "Lcom/tencent/kuikly/core/base/ab;", "Lcom/tencent/kuikly/core/views/j;", "Lcom/tencent/kuikly/core/views/k;", "", "v", "u", "Lkotlin/Function1;", "Lcom/tencent/kuikly/core/base/ViewContainer;", "Lcom/tencent/kuikly/core/base/ViewBuilder;", "Lkotlin/ExtensionFunctionType;", "body", "Lcom/tencent/kuikly/core/views/ce;", "Lcom/tencent/kuikly/core/views/ActionButtonTitleAttr;", "buttonTitleAttr", "", "index", "p", "", "isVertical", ReportConstant.COSTREPORT_PREFIX, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", "didInit", "<set-?>", "a", "Lkotlin/properties/ReadWriteProperty;", "t", "()Z", "w", "(Z)V", "showAlerting", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class AlertDialogView extends com.tencent.kuikly.core.base.ab<j, k> {

    /* renamed from: b, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f118278b = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(AlertDialogView.class, "showAlerting", "getShowAlerting()Z", 0))};

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ReadWriteProperty showAlerting = c01.c.a(Boolean.FALSE);

    private final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.kuikly.core.views.AlertDialogView$body$1
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
                final AlertDialogView alertDialogView = AlertDialogView.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.kuikly.core.views.AlertDialogView$body$1.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        boolean t16;
                        t16 = AlertDialogView.this.t();
                        return Boolean.valueOf(t16 || AlertDialogView.l(AlertDialogView.this).n());
                    }
                };
                final AlertDialogView alertDialogView2 = AlertDialogView.this;
                ConditionViewKt.c(viewContainer, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.kuikly.core.views.AlertDialogView$body$1.2
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
                        boolean inWindow = AlertDialogView.l(AlertDialogView.this).getInWindow();
                        final AlertDialogView alertDialogView3 = AlertDialogView.this;
                        bb.a(vif, inWindow, new Function1<ModalView, Unit>() { // from class: com.tencent.kuikly.core.views.AlertDialogView.body.1.2.1
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
                                Modal.attr(new Function1<com.tencent.kuikly.core.base.m, Unit>() { // from class: com.tencent.kuikly.core.views.AlertDialogView.body.1.2.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(com.tencent.kuikly.core.base.m mVar) {
                                        invoke2(mVar);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(com.tencent.kuikly.core.base.m attr) {
                                        Intrinsics.checkNotNullParameter(attr, "$this$attr");
                                        attr.allCenter();
                                    }
                                });
                                TransitionType transitionType = TransitionType.FADE_IN_OUT;
                                final AlertDialogView alertDialogView4 = AlertDialogView.this;
                                TransitionViewKt.a(Modal, transitionType, new Function1<TransitionView, Unit>() { // from class: com.tencent.kuikly.core.views.AlertDialogView.body.1.2.1.2
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
                                        final AlertDialogView alertDialogView5 = AlertDialogView.this;
                                        TransitionView.attr(new Function1<ci, Unit>() { // from class: com.tencent.kuikly.core.views.AlertDialogView.body.1.2.1.2.1
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
                                                attr.r(AlertDialogView.l(AlertDialogView.this).n());
                                                attr.absolutePositionAllZero();
                                                attr.h(b.Companion.p(com.tencent.kuikly.core.base.b.INSTANCE, 0.3f, 0.8f, 0.9f, null, 8, null));
                                            }
                                        });
                                        final AlertDialogView alertDialogView6 = AlertDialogView.this;
                                        TransitionView.event(new Function1<cj, Unit>() { // from class: com.tencent.kuikly.core.views.AlertDialogView.body.1.2.1.2.2
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
                                                final AlertDialogView alertDialogView7 = AlertDialogView.this;
                                                event.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.kuikly.core.views.AlertDialogView.body.1.2.1.2.2.1
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
                                                        Function1<ClickParams, Unit> k3 = AlertDialogView.m(AlertDialogView.this).k();
                                                        if (k3 != null) {
                                                            k3.invoke(it);
                                                        }
                                                        AlertDialogView.m(AlertDialogView.this).onFireEvent(EventName.CLICK.getValue(), it);
                                                    }
                                                });
                                            }
                                        });
                                        Function1<ViewContainer<?, ?>, Unit> j3 = AlertDialogView.l(AlertDialogView.this).j();
                                        if (j3 != null) {
                                            j3.invoke(TransitionView);
                                        }
                                    }
                                });
                                TransitionType transitionType2 = TransitionType.CUSTOM;
                                final AlertDialogView alertDialogView5 = AlertDialogView.this;
                                TransitionViewKt.a(Modal, transitionType2, new Function1<TransitionView, Unit>() { // from class: com.tencent.kuikly.core.views.AlertDialogView.body.1.2.1.3
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
                                        final AlertDialogView alertDialogView6 = AlertDialogView.this;
                                        TransitionView.attr(new Function1<ci, Unit>() { // from class: com.tencent.kuikly.core.views.AlertDialogView.body.1.2.1.3.1
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
                                                attr.r(AlertDialogView.l(AlertDialogView.this).n());
                                                attr.i(new Function1<Attr, Unit>() { // from class: com.tencent.kuikly.core.views.AlertDialogView.body.1.2.1.3.1.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public /* bridge */ /* synthetic */ Unit invoke(Attr attr2) {
                                                        invoke2(attr2);
                                                        return Unit.INSTANCE;
                                                    }

                                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                    public final void invoke2(Attr customBeginAnimationAttr) {
                                                        Intrinsics.checkNotNullParameter(customBeginAnimationAttr, "$this$customBeginAnimationAttr");
                                                        customBeginAnimationAttr.m147opacity(0.0f);
                                                        customBeginAnimationAttr.transform(new com.tencent.kuikly.core.base.u(0.7f, 0.7f));
                                                    }
                                                });
                                                attr.j(new Function1<Attr, Unit>() { // from class: com.tencent.kuikly.core.views.AlertDialogView.body.1.2.1.3.1.2
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public /* bridge */ /* synthetic */ Unit invoke(Attr attr2) {
                                                        invoke2(attr2);
                                                        return Unit.INSTANCE;
                                                    }

                                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                    public final void invoke2(Attr customEndAnimationAttr) {
                                                        Intrinsics.checkNotNullParameter(customEndAnimationAttr, "$this$customEndAnimationAttr");
                                                        customEndAnimationAttr.m147opacity(1.0f);
                                                        customEndAnimationAttr.transform(new com.tencent.kuikly.core.base.u(1.0f, 1.0f));
                                                    }
                                                });
                                                attr.h(b.Companion.p(com.tencent.kuikly.core.base.b.INSTANCE, 0.3f, 0.8f, 0.9f, null, 8, null));
                                            }
                                        });
                                        final AlertDialogView alertDialogView7 = AlertDialogView.this;
                                        TransitionView.event(new Function1<cj, Unit>() { // from class: com.tencent.kuikly.core.views.AlertDialogView.body.1.2.1.3.2
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
                                                final AlertDialogView alertDialogView8 = AlertDialogView.this;
                                                event.transitionFinish(new Function1<Boolean, Unit>() { // from class: com.tencent.kuikly.core.views.AlertDialogView.body.1.2.1.3.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                                        invoke(bool.booleanValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(boolean z16) {
                                                        boolean t16;
                                                        Function0<Unit> j3;
                                                        AlertDialogView.this.w(z16);
                                                        t16 = AlertDialogView.this.t();
                                                        if (t16 || AlertDialogView.l(AlertDialogView.this).n() || (j3 = AlertDialogView.m(AlertDialogView.this).j()) == null) {
                                                            return;
                                                        }
                                                        j3.invoke();
                                                    }
                                                });
                                            }
                                        });
                                        final AlertDialogView alertDialogView8 = AlertDialogView.this;
                                        w.a(TransitionView, new Function1<v, Unit>() { // from class: com.tencent.kuikly.core.views.AlertDialogView.body.1.2.1.3.3
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
                                                View.event(new Function1<u, Unit>() { // from class: com.tencent.kuikly.core.views.AlertDialogView.body.1.2.1.3.3.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public /* bridge */ /* synthetic */ Unit invoke(u uVar) {
                                                        invoke2(uVar);
                                                        return Unit.INSTANCE;
                                                    }

                                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                    public final void invoke2(u event) {
                                                        Intrinsics.checkNotNullParameter(event, "$this$event");
                                                        event.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.kuikly.core.views.AlertDialogView.body.1.2.1.3.3.1.1
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
                                                Function1<ViewContainer<?, ?>, Unit> k3 = AlertDialogView.l(AlertDialogView.this).k();
                                                if (k3 != null) {
                                                    k3.invoke(View);
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
    public static final /* synthetic */ j l(AlertDialogView alertDialogView) {
        return (j) alertDialogView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ k m(AlertDialogView alertDialogView) {
        return (k) alertDialogView.getEvent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Function1<ViewContainer<?, ?>, Unit> p(final Function1<? super ce, Unit> buttonTitleAttr, final int index) {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.kuikly.core.views.AlertDialogView$createActionButton$1
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
                final Function1<ce, Unit> function1 = buttonTitleAttr;
                final AlertDialogView alertDialogView = this;
                final int i3 = index;
                com.tencent.kuikly.core.views.compose.c.a(viewContainer, new Function1<ButtonView, Unit>() { // from class: com.tencent.kuikly.core.views.AlertDialogView$createActionButton$1.1
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
                        final Function1<ce, Unit> function12 = function1;
                        Button.attr(new Function1<com.tencent.kuikly.core.views.compose.a, Unit>() { // from class: com.tencent.kuikly.core.views.AlertDialogView.createActionButton.1.1.1
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
                                attr.mo141height(44.0f);
                                attr.m140flex(1.0f);
                                final Function1<ce, Unit> function13 = function12;
                                attr.q(new Function1<ce, Unit>() { // from class: com.tencent.kuikly.core.views.AlertDialogView.createActionButton.1.1.1.1
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
                                        titleAttr.fontWeight500();
                                        ce.fontSize$default(titleAttr, 17.0f, null, 2, null);
                                        titleAttr.mo141height(22.0f);
                                        titleAttr.color(4278221567L);
                                        function13.invoke(titleAttr);
                                    }
                                });
                                attr.highlightBackgroundColor(new com.tencent.kuikly.core.base.h(0, 0, 0, 0.1f));
                            }
                        });
                        final AlertDialogView alertDialogView2 = alertDialogView;
                        final int i16 = i3;
                        Button.event(new Function1<com.tencent.kuikly.core.views.compose.b, Unit>() { // from class: com.tencent.kuikly.core.views.AlertDialogView.createActionButton.1.1.2
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
                                final AlertDialogView alertDialogView3 = AlertDialogView.this;
                                final int i17 = i16;
                                event.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.kuikly.core.views.AlertDialogView.createActionButton.1.1.2.1
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
                                        Function1<Integer, Unit> l3 = AlertDialogView.m(AlertDialogView.this).l();
                                        if (l3 != null) {
                                            l3.invoke(Integer.valueOf(i17));
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
    public final Function1<ViewContainer<?, ?>, Unit> s(final boolean isVertical) {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.kuikly.core.views.AlertDialogView$createLineView$1
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
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.kuikly.core.views.AlertDialogView$createLineView$1.1
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
                        View.attr(new Function1<t, Unit>() { // from class: com.tencent.kuikly.core.views.AlertDialogView.createLineView.1.1.1
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
    public final boolean t() {
        return ((Boolean) this.showAlerting.getValue(this, f118278b[0])).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void u() {
        if (((j) getAttr()).j() != null) {
            return;
        }
        ((j) getAttr()).p(new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.kuikly.core.views.AlertDialogView$initBackgroundViewCreator$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ViewContainer<?, ?> viewContainer) {
                invoke2(viewContainer);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ViewContainer<?, ?> viewContainer) {
                Intrinsics.checkNotNullParameter(viewContainer, "$this$null");
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.kuikly.core.views.AlertDialogView$initBackgroundViewCreator$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(v vVar) {
                        invoke2(vVar);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(v View) {
                        Intrinsics.checkNotNullParameter(View, "$this$View");
                        View.attr(new Function1<t, Unit>() { // from class: com.tencent.kuikly.core.views.AlertDialogView.initBackgroundViewCreator.1.1.1
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
    private final void v() {
        if (((j) getAttr()).k() != null) {
            return;
        }
        ((j) getAttr()).q(new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.kuikly.core.views.AlertDialogView$initContentViewCreator$1
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
                final AlertDialogView alertDialogView = AlertDialogView.this;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.kuikly.core.views.AlertDialogView$initContentViewCreator$1.1
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
                        View.attr(new Function1<t, Unit>() { // from class: com.tencent.kuikly.core.views.AlertDialogView.initContentViewCreator.1.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(t tVar) {
                                invoke2(tVar);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(t attr) {
                                Intrinsics.checkNotNullParameter(attr, "$this$attr");
                                attr.borderRadius(14.0f);
                                attr.mo153width(270.0f);
                                if (attr.getPager().isNightMode()) {
                                    attr.mo113backgroundColor(new com.tencent.kuikly.core.base.h(0, 0, 0, 0.85f));
                                } else {
                                    attr.mo113backgroundColor(new com.tencent.kuikly.core.base.h(255, 255, 255, 0.75f));
                                }
                            }
                        });
                        o.a(View, new Function1<n, Unit>() { // from class: com.tencent.kuikly.core.views.AlertDialogView.initContentViewCreator.1.1.2
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(n nVar) {
                                invoke2(nVar);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(n Blur) {
                                Intrinsics.checkNotNullParameter(Blur, "$this$Blur");
                                Blur.attr(new Function1<m, Unit>() { // from class: com.tencent.kuikly.core.views.AlertDialogView.initContentViewCreator.1.1.2.1
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
                        final AlertDialogView alertDialogView2 = AlertDialogView.this;
                        w.a(View, new Function1<v, Unit>() { // from class: com.tencent.kuikly.core.views.AlertDialogView.initContentViewCreator.1.1.3
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
                                View2.attr(new Function1<t, Unit>() { // from class: com.tencent.kuikly.core.views.AlertDialogView.initContentViewCreator.1.1.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(t tVar) {
                                        invoke2(tVar);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(t attr) {
                                        Intrinsics.checkNotNullParameter(attr, "$this$attr");
                                        attr.margin(20.0f, 16.0f, 20.0f, 16.0f);
                                        attr.allCenter();
                                    }
                                });
                                final AlertDialogView alertDialogView3 = AlertDialogView.this;
                                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.kuikly.core.views.AlertDialogView.initContentViewCreator.1.1.3.2
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Boolean.valueOf(AlertDialogView.l(AlertDialogView.this).o().length() > 0);
                                    }
                                };
                                final AlertDialogView alertDialogView4 = AlertDialogView.this;
                                ConditionViewKt.c(View2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.kuikly.core.views.AlertDialogView.initContentViewCreator.1.1.3.3
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
                                        final AlertDialogView alertDialogView5 = AlertDialogView.this;
                                        cg.a(vif, new Function1<TextView, Unit>() { // from class: com.tencent.kuikly.core.views.AlertDialogView.initContentViewCreator.1.1.3.3.1
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
                                                final AlertDialogView alertDialogView6 = AlertDialogView.this;
                                                Text.attr(new Function1<ce, Unit>() { // from class: com.tencent.kuikly.core.views.AlertDialogView.initContentViewCreator.1.1.3.3.1.1
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
                                                        ce.fontSize$default(attr, 17.0f, null, 2, null);
                                                        attr.lineHeight(22.0f);
                                                        attr.text(AlertDialogView.l(AlertDialogView.this).o());
                                                        attr.color(attr.getPager().isNightMode() ? com.tencent.kuikly.core.base.h.INSTANCE.m() : com.tencent.kuikly.core.base.h.INSTANCE.b());
                                                        attr.textAlignCenter();
                                                        attr.fontWeightSemisolid();
                                                    }
                                                });
                                            }
                                        });
                                    }
                                });
                                final AlertDialogView alertDialogView5 = AlertDialogView.this;
                                Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.kuikly.core.views.AlertDialogView.initContentViewCreator.1.1.3.4
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Boolean.valueOf(AlertDialogView.l(AlertDialogView.this).m().length() > 0);
                                    }
                                };
                                final AlertDialogView alertDialogView6 = AlertDialogView.this;
                                ConditionViewKt.c(View2, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.kuikly.core.views.AlertDialogView.initContentViewCreator.1.1.3.5
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
                                        final AlertDialogView alertDialogView7 = AlertDialogView.this;
                                        cg.a(vif, new Function1<TextView, Unit>() { // from class: com.tencent.kuikly.core.views.AlertDialogView.initContentViewCreator.1.1.3.5.1
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
                                                final AlertDialogView alertDialogView8 = AlertDialogView.this;
                                                Text.attr(new Function1<ce, Unit>() { // from class: com.tencent.kuikly.core.views.AlertDialogView.initContentViewCreator.1.1.3.5.1.1
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
                                                        attr.text(AlertDialogView.l(AlertDialogView.this).m());
                                                        attr.color(attr.getPager().isNightMode() ? com.tencent.kuikly.core.base.h.INSTANCE.m() : com.tencent.kuikly.core.base.h.INSTANCE.b());
                                                        attr.textAlignCenter();
                                                    }
                                                });
                                            }
                                        });
                                    }
                                });
                            }
                        });
                        final AlertDialogView alertDialogView3 = AlertDialogView.this;
                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.kuikly.core.views.AlertDialogView.initContentViewCreator.1.1.4
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Boolean.valueOf(AlertDialogView.l(AlertDialogView.this).i().size() == 2);
                            }
                        };
                        final AlertDialogView alertDialogView4 = AlertDialogView.this;
                        ConditionViewKt.c(View, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.kuikly.core.views.AlertDialogView.initContentViewCreator.1.1.5
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
                                Function1 s16;
                                Intrinsics.checkNotNullParameter(vif, "$this$vif");
                                s16 = AlertDialogView.this.s(false);
                                s16.invoke(vif);
                                final AlertDialogView alertDialogView5 = AlertDialogView.this;
                                w.a(vif, new Function1<v, Unit>() { // from class: com.tencent.kuikly.core.views.AlertDialogView.initContentViewCreator.1.1.5.1
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
                                        Function1 p16;
                                        Function1 s17;
                                        Function1 p17;
                                        Intrinsics.checkNotNullParameter(View2, "$this$View");
                                        View2.attr(new Function1<t, Unit>() { // from class: com.tencent.kuikly.core.views.AlertDialogView.initContentViewCreator.1.1.5.1.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(t tVar) {
                                                invoke2(tVar);
                                                return Unit.INSTANCE;
                                            }

                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(t attr) {
                                                Intrinsics.checkNotNullParameter(attr, "$this$attr");
                                                attr.flexDirectionRow();
                                                attr.mo141height(44.0f);
                                                attr.justifyContentSpaceBetween();
                                            }
                                        });
                                        AlertDialogView alertDialogView6 = AlertDialogView.this;
                                        p16 = alertDialogView6.p(AlertDialogView.l(alertDialogView6).i().get(0), 0);
                                        p16.invoke(View2);
                                        s17 = AlertDialogView.this.s(true);
                                        s17.invoke(View2);
                                        AlertDialogView alertDialogView7 = AlertDialogView.this;
                                        p17 = alertDialogView7.p(AlertDialogView.l(alertDialogView7).i().get(1), 1);
                                        p17.invoke(View2);
                                    }
                                });
                            }
                        });
                        final AlertDialogView alertDialogView5 = AlertDialogView.this;
                        ConditionViewKt.a(View, new Function1<ConditionView, Unit>() { // from class: com.tencent.kuikly.core.views.AlertDialogView.initContentViewCreator.1.1.6
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
                                final AlertDialogView alertDialogView6 = AlertDialogView.this;
                                Function0<com.tencent.kuikly.core.reactive.collection.c<Function1<? super ce, ? extends Unit>>> function02 = new Function0<com.tencent.kuikly.core.reactive.collection.c<Function1<? super ce, ? extends Unit>>>() { // from class: com.tencent.kuikly.core.views.AlertDialogView.initContentViewCreator.1.1.6.1
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final com.tencent.kuikly.core.reactive.collection.c<Function1<? super ce, ? extends Unit>> invoke() {
                                        return AlertDialogView.l(AlertDialogView.this).i();
                                    }
                                };
                                final AlertDialogView alertDialogView7 = AlertDialogView.this;
                                LoopDirectivesViewKt.a(velse, function02, new Function2<LoopDirectivesView<Function1<? super ce, ? extends Unit>>, Function1<? super ce, ? extends Unit>, Unit>() { // from class: com.tencent.kuikly.core.views.AlertDialogView.initContentViewCreator.1.1.6.2
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
                                        final AlertDialogView alertDialogView8 = AlertDialogView.this;
                                        w.a(vfor, new Function1<v, Unit>() { // from class: com.tencent.kuikly.core.views.AlertDialogView.initContentViewCreator.1.1.6.2.1
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

                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(v View2) {
                                                Function1 s16;
                                                Function1 p16;
                                                Intrinsics.checkNotNullParameter(View2, "$this$View");
                                                s16 = AlertDialogView.this.s(false);
                                                s16.invoke(View2);
                                                AlertDialogView alertDialogView9 = AlertDialogView.this;
                                                p16 = alertDialogView9.p(buttonTitleAttr, AlertDialogView.l(alertDialogView9).i().indexOf(buttonTitleAttr));
                                                p16.invoke(View2);
                                            }
                                        });
                                    }
                                });
                            }
                        });
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(boolean z16) {
        this.showAlerting.setValue(this, f118278b[0], Boolean.valueOf(z16));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public void didInit() {
        super.didInit();
        w(((j) getAttr()).n());
        v();
        u();
        body().invoke(this);
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public j createAttr() {
        return new j();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public k createEvent() {
        return new k();
    }
}
