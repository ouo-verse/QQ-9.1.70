package com.tencent.kuikly.core.base.event;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.RenderView;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 E2\u00020\u0001:\u0001FB\u0007\u00a2\u0006\u0004\bC\u0010DJ\b\u0010\u0003\u001a\u00020\u0002H\u0002JA\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042'\u0010\f\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00020\u0006j\u0002`\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\rJ9\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042'\u0010\f\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00020\u0006j\u0002`\u000bH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016J3\u0010\u0011\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006j\u0004\u0018\u0001`\u000b2\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0012\u001a\u00020\u0004J\u001a\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u0019\u001a\u00020\u0002H\u0016J\b\u0010\u001a\u001a\u00020\u0002H\u0016J\b\u0010\u001b\u001a\u00020\u0002H\u0016J\u0018\u0010\u001e\u001a\u00020\u00022\u000e\u0010\u001d\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001cH\u0016J\u0018\u0010\u001f\u001a\u00020\u00022\u000e\u0010\u001d\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001cH\u0016J\u001c\u0010\"\u001a\u00020\u00022\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00020\u0006H\u0016J\u001c\u0010#\u001a\u00020\u00022\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00020\u0006H\u0016J\u001c\u0010%\u001a\u00020\u00022\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00020\u0006H\u0016J\u001c\u0010'\u001a\u00020\u00022\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00020\u0006H\u0016J\u001c\u0010)\u001a\u00020\u00022\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00020\u0006H\u0016J#\u0010,\u001a\u00020\u00022\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00020\u0006H\u0000\u00a2\u0006\u0004\b*\u0010+R0\u00100\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020.0-j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020.`/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R7\u00108\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001302j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0013`38BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R0\u00109\u001a\u0010\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00068\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010+R\u001b\u0010B\u001a\u00020>8@X\u0080\u0084\u0002\u00a2\u0006\f\n\u0004\b?\u00105\u001a\u0004\b@\u0010A\u00a8\u0006G"}, d2 = {"Lcom/tencent/kuikly/core/base/event/Event;", "Lcom/tencent/kuikly/core/base/event/b;", "", "setEventsToRenderView", "", AdMetricTag.EVENT_NAME, "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "parma", "Lcom/tencent/kuikly/core/base/event/EventHandlerFn;", "eventHandlerFn", "", "isSync", "register", "isEmpty", "handlerWithEventName", "pluginName", "Lcom/tencent/kuikly/core/base/event/d;", "event", "putPluginEvent", "getPluginEvent", "data", "onFireEvent", "onViewDidRemove", "onRenderViewDidCreated", "onRenderViewDidRemoved", "Lcom/tencent/kuikly/core/base/DeclarativeBaseView;", "view", "onRelativeCoordinatesDidChanged", "onViewLayoutFrameDidChanged", "Lcom/tencent/kuikly/core/base/event/c;", "handler", "click", "doubleClick", "Lcom/tencent/kuikly/core/base/event/e;", "longPress", "Lcom/tencent/kuikly/core/base/event/h;", "pan", "Lcom/tencent/kuikly/core/base/event/a;", "animationCompletion", "listenInternalAnimationCompletion$core_release", "(Lkotlin/jvm/functions/Function1;)V", "listenInternalAnimationCompletion", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "syncMap", "Ljava/util/HashMap;", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "pluginEventsMap$delegate", "Lkotlin/Lazy;", "getPluginEventsMap", "()Ljava/util/LinkedHashMap;", "pluginEventsMap", "internalAnimationCompletion", "Lkotlin/jvm/functions/Function1;", "getInternalAnimationCompletion$core_release", "()Lkotlin/jvm/functions/Function1;", "setInternalAnimationCompletion$core_release", "Lcom/tencent/kuikly/core/base/event/f;", "panHandler$delegate", "getPanHandler$core_release", "()Lcom/tencent/kuikly/core/base/event/f;", "panHandler", "<init>", "()V", "Companion", "a", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public class Event extends b {
    public static final String TAG = "EventCenter";
    private Function1<? super AnimationCompletionParams, Unit> internalAnimationCompletion;

    /* renamed from: panHandler$delegate, reason: from kotlin metadata */
    private final Lazy panHandler;

    /* renamed from: pluginEventsMap$delegate, reason: from kotlin metadata */
    private final Lazy pluginEventsMap;
    private final HashMap<String, Integer> syncMap = new HashMap<>();

    public Event() {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.pluginEventsMap = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<LinkedHashMap<String, d>>() { // from class: com.tencent.kuikly.core.base.event.Event$pluginEventsMap$2
            @Override // kotlin.jvm.functions.Function0
            public final LinkedHashMap<String, d> invoke() {
                return new LinkedHashMap<>();
            }
        });
        this.panHandler = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<f>() { // from class: com.tencent.kuikly.core.base.event.Event$panHandler$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final f invoke() {
                return new f();
            }
        });
    }

    private final LinkedHashMap<String, d> getPluginEventsMap() {
        return (LinkedHashMap) this.pluginEventsMap.getValue();
    }

    private final void setEventsToRenderView() {
        int i3;
        RenderView renderView = getRenderView();
        if (renderView != null) {
            Set<String> keySet = getEventMap().keySet();
            Intrinsics.checkNotNullExpressionValue(keySet, "eventMap.keys");
            for (String key : keySet) {
                Integer it = this.syncMap.get(key);
                if (it != null) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    i3 = it.intValue();
                } else {
                    i3 = 0;
                }
                Intrinsics.checkNotNullExpressionValue(key, "key");
                RenderView.i(renderView, key, i3, false, 4, null);
            }
        }
    }

    public void animationCompletion(final Function1<? super AnimationCompletionParams, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        register(EventName.ANIMATION_COMPLETE.getValue(), new Function1<Object, Unit>() { // from class: com.tencent.kuikly.core.base.event.Event$animationCompletion$1
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
                AnimationCompletionParams a16 = AnimationCompletionParams.INSTANCE.a(obj);
                handler.invoke(a16);
                Function1<AnimationCompletionParams, Unit> internalAnimationCompletion$core_release = this.getInternalAnimationCompletion$core_release();
                if (internalAnimationCompletion$core_release != null) {
                    internalAnimationCompletion$core_release.invoke(a16);
                }
            }
        });
    }

    public void click(final Function1<? super ClickParams, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        register(EventName.CLICK.getValue(), new Function1<Object, Unit>() { // from class: com.tencent.kuikly.core.base.event.Event$click$1
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
                handler.invoke(ClickParams.INSTANCE.a(obj));
            }
        });
    }

    public void doubleClick(final Function1<? super ClickParams, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        register(EventName.DOUBLE_CLICK.getValue(), new Function1<Object, Unit>() { // from class: com.tencent.kuikly.core.base.event.Event$doubleClick$1
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
                handler.invoke(ClickParams.INSTANCE.a(obj));
            }
        });
    }

    public final Function1<AnimationCompletionParams, Unit> getInternalAnimationCompletion$core_release() {
        return this.internalAnimationCompletion;
    }

    public final f getPanHandler$core_release() {
        return (f) this.panHandler.getValue();
    }

    public final d getPluginEvent(String pluginName) {
        Intrinsics.checkNotNullParameter(pluginName, "pluginName");
        return getPluginEventsMap().get(pluginName);
    }

    public final Function1<Object, Unit> handlerWithEventName(String eventName) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        return getEventMap().get(eventName);
    }

    @Override // com.tencent.kuikly.core.base.event.b
    public boolean isEmpty() {
        return super.isEmpty() && getPluginEventsMap().isEmpty();
    }

    public final void listenInternalAnimationCompletion$core_release(Function1<? super AnimationCompletionParams, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.internalAnimationCompletion = handler;
        EventName eventName = EventName.ANIMATION_COMPLETE;
        if (handlerWithEventName(eventName.getValue()) == null) {
            register(eventName.getValue(), new Function1<Object, Unit>() { // from class: com.tencent.kuikly.core.base.event.Event$listenInternalAnimationCompletion$1
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
                    Function1<AnimationCompletionParams, Unit> internalAnimationCompletion$core_release = Event.this.getInternalAnimationCompletion$core_release();
                    if (internalAnimationCompletion$core_release != null) {
                        internalAnimationCompletion$core_release.invoke(AnimationCompletionParams.INSTANCE.a(obj));
                    }
                }
            });
        }
    }

    public void longPress(final Function1<? super LongPressParams, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        register(EventName.LONG_PRESS.getValue(), new Function1<Object, Unit>() { // from class: com.tencent.kuikly.core.base.event.Event$longPress$1
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
                handler.invoke(LongPressParams.INSTANCE.a(obj));
            }
        });
    }

    @Override // com.tencent.kuikly.core.base.event.b, com.tencent.kuikly.core.base.event.d
    public boolean onFireEvent(String eventName, Object data) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        if (super.onFireEvent(eventName, data)) {
            return true;
        }
        Collection<d> values = getPluginEventsMap().values();
        Intrinsics.checkNotNullExpressionValue(values, "pluginEventsMap.values");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            if (((d) it.next()).onFireEvent(eventName, data)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.kuikly.core.base.event.d
    public void onRelativeCoordinatesDidChanged(DeclarativeBaseView<?, ?> view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (getPluginEventsMap().isEmpty()) {
            return;
        }
        Collection<d> values = getPluginEventsMap().values();
        Intrinsics.checkNotNullExpressionValue(values, "pluginEventsMap.values");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            ((d) it.next()).onRelativeCoordinatesDidChanged(view);
        }
    }

    @Override // com.tencent.kuikly.core.base.event.d
    public void onRenderViewDidCreated() {
        setEventsToRenderView();
        Collection<d> values = getPluginEventsMap().values();
        Intrinsics.checkNotNullExpressionValue(values, "pluginEventsMap.values");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            ((d) it.next()).onRenderViewDidCreated();
        }
    }

    @Override // com.tencent.kuikly.core.base.event.d
    public void onRenderViewDidRemoved() {
        Collection<d> values = getPluginEventsMap().values();
        Intrinsics.checkNotNullExpressionValue(values, "pluginEventsMap.values");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            ((d) it.next()).onRenderViewDidRemoved();
        }
    }

    @Override // com.tencent.kuikly.core.base.event.b, com.tencent.kuikly.core.base.event.d
    public void onViewDidRemove() {
        super.onViewDidRemove();
        Collection<d> values = getPluginEventsMap().values();
        Intrinsics.checkNotNullExpressionValue(values, "pluginEventsMap.values");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            ((d) it.next()).onViewDidRemove();
        }
        getPluginEventsMap().clear();
    }

    @Override // com.tencent.kuikly.core.base.event.d
    public void onViewLayoutFrameDidChanged(DeclarativeBaseView<?, ?> view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (getPluginEventsMap().isEmpty()) {
            return;
        }
        Collection<d> values = getPluginEventsMap().values();
        Intrinsics.checkNotNullExpressionValue(values, "pluginEventsMap.values");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            ((d) it.next()).onViewLayoutFrameDidChanged(view);
        }
    }

    public void pan(final Function1<? super PanGestureParams, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        register(EventName.PAN.getValue(), new Function1<Object, Unit>() { // from class: com.tencent.kuikly.core.base.event.Event$pan$1
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
                handler.invoke(Event.this.getPanHandler$core_release().a(obj));
            }
        });
    }

    public final void putPluginEvent(String pluginName, d event) {
        Intrinsics.checkNotNullParameter(pluginName, "pluginName");
        Intrinsics.checkNotNullParameter(event, "event");
        if (pluginName.length() > 0) {
            getPluginEventsMap().put(pluginName, event);
        }
    }

    public final void register(String eventName, Function1<Object, Unit> eventHandlerFn, boolean isSync) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(eventHandlerFn, "eventHandlerFn");
        super.register(eventName, eventHandlerFn);
        this.syncMap.put(eventName, Integer.valueOf(com.tencent.kuikly.core.base.d.b(isSync)));
        RenderView renderView = getRenderView();
        if (renderView != null) {
            RenderView.i(renderView, eventName, com.tencent.kuikly.core.base.d.b(isSync), false, 4, null);
        }
    }

    public final void setInternalAnimationCompletion$core_release(Function1<? super AnimationCompletionParams, Unit> function1) {
        this.internalAnimationCompletion = function1;
    }

    @Override // com.tencent.kuikly.core.base.event.b, com.tencent.kuikly.core.base.event.d
    public void register(String eventName, Function1<Object, Unit> eventHandlerFn) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(eventHandlerFn, "eventHandlerFn");
        super.register(eventName, eventHandlerFn);
        register(eventName, eventHandlerFn, false);
    }

    public static /* synthetic */ void register$default(Event event, String str, Function1 function1, boolean z16, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 4) != 0) {
                z16 = false;
            }
            event.register(str, function1, z16);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: register");
    }
}
