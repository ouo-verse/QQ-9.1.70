package com.tencent.kuikly.core.views.internal;

import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.EventName;
import com.tencent.kuikly.core.base.event.TouchParams;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J \u0010\u0007\u001a\u00020\u00042\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u0005H\u0016J \u0010\b\u001a\u00020\u00042\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u0005H\u0016J \u0010\t\u001a\u00020\u00042\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u0005H\u0016J\u0016\u0010\f\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\nH\u0016J\u0016\u0010\r\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\nH\u0016RK\u0010\u0014\u001a2\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u00050\u000ej\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u0005`\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013RK\u0010\u0017\u001a2\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u00050\u000ej\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u0005`\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/kuikly/core/views/internal/GroupEvent;", "Lcom/tencent/kuikly/core/base/event/Event;", "Lkotlin/Function1;", "Lcom/tencent/kuikly/core/base/event/k;", "", "Lcom/tencent/kuikly/core/views/internal/TouchEventHandlerFn;", "handler", "touchDown", "touchUp", "touchMove", "Lkotlin/Function0;", "handlerFn", "screenFrame", "hitTestSelf", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "touchDownHandlers$delegate", "Lkotlin/Lazy;", "getTouchDownHandlers", "()Ljava/util/ArrayList;", "touchDownHandlers", "touchUpHandlers$delegate", "getTouchUpHandlers", "touchUpHandlers", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public class GroupEvent extends Event {

    /* renamed from: touchDownHandlers$delegate, reason: from kotlin metadata */
    private final Lazy touchDownHandlers;

    /* renamed from: touchUpHandlers$delegate, reason: from kotlin metadata */
    private final Lazy touchUpHandlers;

    public GroupEvent() {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.touchDownHandlers = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<ArrayList<Function1<? super TouchParams, ? extends Unit>>>() { // from class: com.tencent.kuikly.core.views.internal.GroupEvent$touchDownHandlers$2
            @Override // kotlin.jvm.functions.Function0
            public final ArrayList<Function1<? super TouchParams, ? extends Unit>> invoke() {
                return new ArrayList<>();
            }
        });
        this.touchUpHandlers = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<ArrayList<Function1<? super TouchParams, ? extends Unit>>>() { // from class: com.tencent.kuikly.core.views.internal.GroupEvent$touchUpHandlers$2
            @Override // kotlin.jvm.functions.Function0
            public final ArrayList<Function1<? super TouchParams, ? extends Unit>> invoke() {
                return new ArrayList<>();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ArrayList<Function1<TouchParams, Unit>> getTouchDownHandlers() {
        return (ArrayList) this.touchDownHandlers.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ArrayList<Function1<TouchParams, Unit>> getTouchUpHandlers() {
        return (ArrayList) this.touchUpHandlers.getValue();
    }

    public void hitTestSelf(final Function0<Unit> handlerFn) {
        Intrinsics.checkNotNullParameter(handlerFn, "handlerFn");
        register(EventName.HIT_TEST_SELF.getValue(), new Function1<Object, Unit>() { // from class: com.tencent.kuikly.core.views.internal.GroupEvent$hitTestSelf$1
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
            public final void invoke2(Object obj) {
                handlerFn.invoke();
            }
        }, false);
    }

    public void screenFrame(final Function0<Unit> handlerFn) {
        Intrinsics.checkNotNullParameter(handlerFn, "handlerFn");
        register(EventName.SCREEN_FRAME.getValue(), new Function1<Object, Unit>() { // from class: com.tencent.kuikly.core.views.internal.GroupEvent$screenFrame$1
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
            public final void invoke2(Object obj) {
                handlerFn.invoke();
            }
        }, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void touchDown(Function1<? super TouchParams, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        if (getTouchDownHandlers().isEmpty()) {
            register(EventName.TOUCH_DOWN.getValue(), new Function1<Object, Unit>() { // from class: com.tencent.kuikly.core.views.internal.GroupEvent$touchDown$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                    invoke2(obj);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object obj) {
                    ArrayList touchDownHandlers;
                    TouchParams a16 = TouchParams.INSTANCE.a(obj);
                    touchDownHandlers = GroupEvent.this.getTouchDownHandlers();
                    Iterator it = touchDownHandlers.iterator();
                    while (it.hasNext()) {
                        ((Function1) it.next()).invoke(a16);
                    }
                }
            });
        }
        getTouchDownHandlers().add(handler);
    }

    public void touchMove(final Function1<? super TouchParams, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        register(EventName.TOUCH_MOVE.getValue(), new Function1<Object, Unit>() { // from class: com.tencent.kuikly.core.views.internal.GroupEvent$touchMove$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                handler.invoke(TouchParams.INSTANCE.a(obj));
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void touchUp(Function1<? super TouchParams, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        if (getTouchUpHandlers().isEmpty()) {
            register(EventName.TOUCH_UP.getValue(), new Function1<Object, Unit>() { // from class: com.tencent.kuikly.core.views.internal.GroupEvent$touchUp$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                    invoke2(obj);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object obj) {
                    ArrayList touchUpHandlers;
                    TouchParams a16 = TouchParams.INSTANCE.a(obj);
                    touchUpHandlers = GroupEvent.this.getTouchUpHandlers();
                    Iterator it = touchUpHandlers.iterator();
                    while (it.hasNext()) {
                        ((Function1) it.next()).invoke(a16);
                    }
                }
            });
        }
        getTouchUpHandlers().add(handler);
    }
}
