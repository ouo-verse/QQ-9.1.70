package com.tencent.ntcompose.foundation.event;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.FrameEventKt;
import com.tencent.kuikly.core.base.event.TouchParams;
import com.tencent.kuikly.core.base.event.VisibilityEventKt;
import com.tencent.kuikly.core.base.event.j;
import com.tencent.kuikly.core.exception.PagerNotFoundExceptionKt;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.internal.GroupEvent;
import com.tencent.ntcompose.core.ComposeRenderView;
import com.tencent.ntcompose.core.f;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010JJ\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0016J\u0018\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/ntcompose/foundation/event/ViewEventPropUpdater;", "Lcom/tencent/ntcompose/core/f;", "Lcom/tencent/ntcompose/core/ComposeRenderView;", "view", "", "propKey", "", "propArg0", "propArg1", "propArg2", "propArg3", "propArg4", "", "setPropToView", "resetPropToView", "<init>", "()V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ViewEventPropUpdater implements f {

    /* renamed from: a, reason: collision with root package name */
    public static final ViewEventPropUpdater f339229a = new ViewEventPropUpdater();

    ViewEventPropUpdater() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float b(j jVar, j jVar2) {
        float pageX = jVar2.getPageX() - jVar.getPageX();
        float pageY = jVar2.getPageY() - jVar.getPageY();
        return (float) Math.sqrt((pageX * pageX) + (pageY * pageY));
    }

    @Override // com.tencent.ntcompose.core.f
    public void resetPropToView(ComposeRenderView view, String propKey) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(propKey, "propKey");
    }

    /* JADX WARN: Type inference failed for: r0v26, types: [com.tencent.kuikly.core.base.Attr] */
    /* JADX WARN: Type inference failed for: r1v12, types: [com.tencent.kuikly.core.base.Attr] */
    /* JADX WARN: Type inference failed for: r5v3, types: [com.tencent.kuikly.core.base.BaseObject, com.tencent.kuikly.core.base.event.Event] */
    @Override // com.tencent.ntcompose.core.f
    public void setPropToView(final ComposeRenderView view, String propKey, final Object propArg0, Object propArg1, Object propArg2, Object propArg3, Object propArg4) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        final ?? viewEvent = view.b().getViewEvent();
        switch (propKey.hashCode()) {
            case -1651924047:
                if (propKey.equals("hitTestSelf")) {
                    boolean z16 = viewEvent instanceof GroupEvent;
                    if (!z16 && com.tencent.ntcompose.activity.b.a().getPageData().u()) {
                        PagerNotFoundExceptionKt.a("\u53f6\u5b50\u8282\u70b9\u4e0d\u652f\u6301HitTestSelf\u4e8b\u4ef6\uff0c\u8bf7\u7528Box/Column/Row\u7b49\u5bb9\u5668\u8282\u70b9");
                        return;
                    }
                    GroupEvent groupEvent = z16 ? (GroupEvent) viewEvent : null;
                    if (groupEvent != null) {
                        Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Function0<kotlin.Unit>");
                        groupEvent.hitTestSelf((Function0) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propArg0, 0));
                        return;
                    }
                    return;
                }
                return;
            case -1521507596:
                if (propKey.equals("didAppear")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = 'parma')] kotlin.Any?, kotlin.Unit>{ com.tencent.kuikly.core.base.event.IEventKt.EventHandlerFn }");
                    VisibilityEventKt.b(viewEvent, (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propArg0, 1));
                    return;
                }
                return;
            case -1049644499:
                if (propKey.equals("addLayoutFrameDidChange")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Function1<com.tencent.kuikly.core.layout.Frame, kotlin.Unit>");
                    FrameEventKt.a(viewEvent, (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propArg0, 1));
                    return;
                }
                return;
            case -394355112:
                if (propKey.equals("pointerInteropFilter")) {
                    boolean z17 = viewEvent instanceof GroupEvent;
                    if (!z17 && com.tencent.ntcompose.activity.b.a().getPageData().u()) {
                        PagerNotFoundExceptionKt.a("\u53f6\u5b50\u8282\u70b9\u4e0d\u652f\u6301pointerInteropFilter\u4e8b\u4ef6\uff0c\u8bf7\u7528Box/Column/Row\u7b49\u5bb9\u5668\u8282\u70b9");
                    }
                    if (!z17 || viewEvent.getExtProps().containsKey("pointerInteropFilter")) {
                        return;
                    }
                    viewEvent.getExtProps().put("pointerInteropFilter", Boolean.TRUE);
                    final String str = "touchDownParamsKey";
                    final String str2 = "touchDownTimeKey";
                    final String str3 = "touchActionKey";
                    final String str4 = "touchParamsKey";
                    final float f16 = 10.0f;
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Function1<com.tencent.ntcompose.foundation.event.MotionEvent, kotlin.Unit>");
                    final Function1 function1 = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propArg0, 1);
                    GroupEvent groupEvent2 = (GroupEvent) viewEvent;
                    final float f17 = 10.0f;
                    groupEvent2.touchDown(new Function1<TouchParams, Unit>() { // from class: com.tencent.ntcompose.foundation.event.ViewEventPropUpdater$setPropToView$6
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(TouchParams touchParams) {
                            invoke2(touchParams);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(TouchParams it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            Event.this.getExtProps().put(str, it);
                            final long a16 = zz0.a.f453719a.a();
                            Event.this.getExtProps().put(str2, Long.valueOf(a16));
                            Event.this.getExtProps().put(str3, "down");
                            Event.this.getExtProps().put(str4, it);
                            function1.invoke(MotionEvent.INSTANCE.a(it, 0));
                            if (it.c().size() == 1) {
                                final Event event = Event.this;
                                final String str5 = str2;
                                final String str6 = str3;
                                final String str7 = str4;
                                final String str8 = str;
                                final float f18 = f17;
                                final Function1<MotionEvent, Unit> function12 = function1;
                                TimerKt.d(300, new Function0<Unit>() { // from class: com.tencent.ntcompose.foundation.event.ViewEventPropUpdater$setPropToView$6.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                        invoke2();
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2() {
                                        float b16;
                                        if (Intrinsics.areEqual(Event.this.getExtProps().get(str5), Long.valueOf(a16))) {
                                            if (Intrinsics.areEqual(Event.this.getExtProps().get(str6), "down") || Intrinsics.areEqual(Event.this.getExtProps().get(str6), "move")) {
                                                Object obj = Event.this.getExtProps().get(str7);
                                                TouchParams touchParams = obj instanceof TouchParams ? (TouchParams) obj : null;
                                                Object obj2 = Event.this.getExtProps().get(str8);
                                                TouchParams touchParams2 = obj2 instanceof TouchParams ? (TouchParams) obj2 : null;
                                                if (touchParams == null || touchParams2 == null || touchParams.c().size() != 1) {
                                                    return;
                                                }
                                                b16 = ViewEventPropUpdater.b(touchParams.c().get(0), touchParams2.c().get(0));
                                                if (b16 < f18) {
                                                    function12.invoke(new MotionEvent(1, touchParams.getX(), touchParams.getY(), Math.max(touchParams.c().size(), 1), touchParams.getPageX(), touchParams.getPageY(), touchParams.c(), false, true, 128, null));
                                                }
                                            }
                                        }
                                    }
                                });
                            }
                        }
                    });
                    groupEvent2.touchMove(new Function1<TouchParams, Unit>() { // from class: com.tencent.ntcompose.foundation.event.ViewEventPropUpdater$setPropToView$7
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(TouchParams touchParams) {
                            invoke2(touchParams);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(TouchParams it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            Event.this.getExtProps().put(str4, it);
                            Event.this.getExtProps().put(str3, "move");
                            function1.invoke(MotionEvent.INSTANCE.a(it, 1));
                        }
                    });
                    final long j3 = 300;
                    groupEvent2.touchUp(new Function1<TouchParams, Unit>() { // from class: com.tencent.ntcompose.foundation.event.ViewEventPropUpdater$setPropToView$8
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(TouchParams touchParams) {
                            invoke2(touchParams);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(TouchParams it) {
                            float b16;
                            Intrinsics.checkNotNullParameter(it, "it");
                            Event.this.getExtProps().put(str4, it);
                            Event.this.getExtProps().put(str3, it.getIsCancelEvent() ? "cancel" : "up");
                            boolean z18 = false;
                            if (!it.getIsCancelEvent()) {
                                Object obj = Event.this.getExtProps().get(str2);
                                Long l3 = obj instanceof Long ? (Long) obj : null;
                                long longValue = l3 != null ? l3.longValue() : 0L;
                                Object obj2 = Event.this.getExtProps().get(str);
                                TouchParams touchParams = obj2 instanceof TouchParams ? (TouchParams) obj2 : null;
                                if (longValue != 0 && zz0.a.f453719a.a() - longValue <= j3 && touchParams != null && touchParams.c().size() == 1 && it.c().size() == 1) {
                                    b16 = ViewEventPropUpdater.b(touchParams.c().get(0), it.c().get(0));
                                    if (b16 < f16) {
                                        z18 = true;
                                    }
                                }
                            }
                            function1.invoke(new MotionEvent(it.getIsCancelEvent() ? 3 : 2, it.getX(), it.getY(), Math.max(it.c().size(), 1), it.getPageX(), it.getPageY(), it.c(), z18, false, 256, null));
                        }
                    });
                    return;
                }
                return;
            case -323196444:
                if (propKey.equals("didDisappear")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = 'parma')] kotlin.Any?, kotlin.Unit>{ com.tencent.kuikly.core.base.event.IEventKt.EventHandlerFn }");
                    VisibilityEventKt.c(viewEvent, (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propArg0, 1));
                    return;
                }
                return;
            case -245381209:
                if (propKey.equals("pan_gesture")) {
                    ?? viewAttr = view.b().getViewAttr();
                    Integer num = propArg1 instanceof Integer ? (Integer) propArg1 : null;
                    viewAttr.minimumPanTouches(num != null ? num.intValue() : 1);
                    ?? viewAttr2 = view.b().getViewAttr();
                    PanDirection panDirection = propArg2 instanceof PanDirection ? (PanDirection) propArg2 : null;
                    viewAttr2.panDirection(panDirection != null ? panDirection.ordinal() : 0);
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Function1<com.tencent.kuikly.core.base.event.PanGestureParams, kotlin.Unit>");
                    viewEvent.pan((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propArg0, 1));
                    return;
                }
                return;
            case -140590073:
                if (propKey.equals("willAppear")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = 'parma')] kotlin.Any?, kotlin.Unit>{ com.tencent.kuikly.core.base.event.IEventKt.EventHandlerFn }");
                    VisibilityEventKt.e(viewEvent, (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propArg0, 1));
                    return;
                }
                return;
            case 94750088:
                if (propKey.equals("click")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Function1<com.tencent.kuikly.core.base.event.ClickParams, kotlin.Unit>");
                    viewEvent.click((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propArg0, 1));
                    return;
                }
                return;
            case 144204125:
                if (propKey.equals("combinedClickable")) {
                    Function1 function12 = TypeIntrinsics.isFunctionOfArity(propArg0, 1) ? (Function1) propArg0 : null;
                    if (function12 != null) {
                        viewEvent.click(function12);
                    }
                    Function1 function13 = TypeIntrinsics.isFunctionOfArity(propArg1, 1) ? (Function1) propArg1 : null;
                    if (function13 != null) {
                        viewEvent.doubleClick(function13);
                    }
                    Function1 function14 = TypeIntrinsics.isFunctionOfArity(propArg2, 1) ? (Function1) propArg2 : null;
                    if (function14 != null) {
                        viewEvent.longPress(function14);
                        return;
                    }
                    return;
                }
                return;
            case 558543140:
                if (propKey.equals("renderViewDidCreated")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = 'parma')] kotlin.Any?, kotlin.Unit>{ com.tencent.kuikly.core.base.event.IEventKt.EventHandlerFn }");
                    FrameEventKt.f(viewEvent, (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propArg0, 1));
                    return;
                }
                return;
            case 621824668:
                if (propKey.equals("renderViewDidRemoved")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = 'parma')] kotlin.Any?, kotlin.Unit>{ com.tencent.kuikly.core.base.event.IEventKt.EventHandlerFn }");
                    FrameEventKt.g(viewEvent, (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propArg0, 1));
                    return;
                }
                return;
            case 721708559:
                if (propKey.equals("appearPercentage")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Function1<kotlin.Float, kotlin.Unit>");
                    VisibilityEventKt.a(viewEvent, (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propArg0, 1));
                    return;
                }
                return;
            case 1359173035:
                if (propKey.equals("onGlobalPosition")) {
                    FrameEventKt.c(viewEvent, new Function1<com.tencent.kuikly.core.layout.d, Unit>() { // from class: com.tencent.ntcompose.foundation.event.ViewEventPropUpdater$setPropToView$5
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(com.tencent.kuikly.core.layout.d dVar) {
                            invoke2(dVar);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(com.tencent.kuikly.core.layout.d it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            Object obj = propArg0;
                            Function1 function15 = TypeIntrinsics.isFunctionOfArity(obj, 1) ? (Function1) obj : null;
                            if (function15 != null) {
                                function15.invoke(ap3.c.b(view.b()));
                            }
                        }
                    });
                    return;
                }
                return;
            case 1393970161:
                if (propKey.equals("willDisappear")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = 'parma')] kotlin.Any?, kotlin.Unit>{ com.tencent.kuikly.core.base.event.IEventKt.EventHandlerFn }");
                    VisibilityEventKt.f(viewEvent, (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propArg0, 1));
                    return;
                }
                return;
            case 1412636412:
                if (propKey.equals("onPlaced")) {
                    FrameEventKt.d(viewEvent, new Function1<com.tencent.kuikly.core.layout.d, Unit>() { // from class: com.tencent.ntcompose.foundation.event.ViewEventPropUpdater$setPropToView$4
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(com.tencent.kuikly.core.layout.d dVar) {
                            invoke2(dVar);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(com.tencent.kuikly.core.layout.d it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            Object obj = propArg0;
                            Function1 function15 = TypeIntrinsics.isFunctionOfArity(obj, 1) ? (Function1) obj : null;
                            if (function15 != null) {
                                function15.invoke(ap3.c.b(view.b()));
                            }
                        }
                    });
                    return;
                }
                return;
            case 1696714772:
                if (propKey.equals(MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED)) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Function1<com.tencent.kuikly.core.base.Size, kotlin.Unit>");
                    FrameEventKt.e(viewEvent, (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propArg0, 1));
                    return;
                }
                return;
            default:
                return;
        }
    }
}
