package com.tencent.mobileqq.triton.internal.touch;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import com.tencent.mobileqq.triton.engine.EngineState;
import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.exception.TritonInitException;
import com.tencent.mobileqq.triton.internal.lifecycle.LifeCycleOwner;
import com.tencent.mobileqq.triton.internal.lifecycle.ValueHolder;
import com.tencent.mobileqq.triton.touch.InputTouchEvent;
import com.tencent.mobileqq.triton.view.GameView;
import com.tencent.qqmini.v8rt.engine.EnginePathProvider;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u001a\u0010\u0004\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00060\u0005\u0012\u001a\u0010\t\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00060\u0005\u0012\u001a\u0010\n\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b\u0018\u00010\u00060\u0005\u00a2\u0006\u0002\u0010\fJ\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u000e\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0016J\b\u0010\u0017\u001a\u00020\u0007H\u0002J\b\u0010\u0018\u001a\u00020\u000bH\u0002J\b\u0010\u0019\u001a\u00020\u0007H\u0002R\"\u0010\t\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\"\u0010\u0004\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\"\u0010\n\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b\u0018\u00010\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/triton/internal/touch/TouchProviderBridge;", "", "lifeCycleOwner", "Lcom/tencent/mobileqq/triton/internal/lifecycle/LifeCycleOwner;", "lastClicksCallbackHolder", "Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;", "Lkotlin/Function1;", "", "", "lastClickInfoCallbackHolder", "lastTouchTimestampCallbackHolder", "", "(Lcom/tencent/mobileqq/triton/internal/lifecycle/LifeCycleOwner;Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;)V", "manager", "Lcom/tencent/mobileqq/triton/internal/touch/TouchEventManager;", "attachView", "view", "Lcom/tencent/mobileqq/triton/view/GameView;", "density", "", "flushTouchEvents", EnginePathProvider.ENGINE_DIR, "Lcom/tencent/mobileqq/triton/engine/TTEngine;", "getLastClicks", "getLastTouchTimestamp", "getTheLastClickInfo", "Triton_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final class TouchProviderBridge {
    private final ValueHolder<Function1<String, Unit>> lastClickInfoCallbackHolder;
    private final ValueHolder<Function1<String, Unit>> lastClicksCallbackHolder;
    private final ValueHolder<Function1<Long, Unit>> lastTouchTimestampCallbackHolder;
    private final LifeCycleOwner lifeCycleOwner;
    private TouchEventManager manager;

    public TouchProviderBridge(@NotNull LifeCycleOwner lifeCycleOwner, @NotNull ValueHolder<Function1<String, Unit>> lastClicksCallbackHolder, @NotNull ValueHolder<Function1<String, Unit>> lastClickInfoCallbackHolder, @NotNull ValueHolder<Function1<Long, Unit>> lastTouchTimestampCallbackHolder) throws TritonInitException {
        Intrinsics.checkParameterIsNotNull(lifeCycleOwner, "lifeCycleOwner");
        Intrinsics.checkParameterIsNotNull(lastClicksCallbackHolder, "lastClicksCallbackHolder");
        Intrinsics.checkParameterIsNotNull(lastClickInfoCallbackHolder, "lastClickInfoCallbackHolder");
        Intrinsics.checkParameterIsNotNull(lastTouchTimestampCallbackHolder, "lastTouchTimestampCallbackHolder");
        this.lifeCycleOwner = lifeCycleOwner;
        this.lastClicksCallbackHolder = lastClicksCallbackHolder;
        this.lastClickInfoCallbackHolder = lastClickInfoCallbackHolder;
        this.lastTouchTimestampCallbackHolder = lastTouchTimestampCallbackHolder;
        lastClicksCallbackHolder.observe(new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.tencent.mobileqq.triton.internal.touch.TouchProviderBridge.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Function1<? super String, Unit> function1) {
                if (function1 != null) {
                    TouchProviderBridge.this.lastClicksCallbackHolder.setValue(null);
                    function1.invoke(TouchProviderBridge.this.getLastClicks());
                }
            }
        });
        lastClickInfoCallbackHolder.observe(new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.tencent.mobileqq.triton.internal.touch.TouchProviderBridge.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Function1<? super String, Unit> function1) {
                if (function1 != null) {
                    TouchProviderBridge.this.lastClickInfoCallbackHolder.setValue(null);
                    function1.invoke(TouchProviderBridge.this.getTheLastClickInfo());
                }
            }
        });
        lastTouchTimestampCallbackHolder.observe(new Function1<Function1<? super Long, ? extends Unit>, Unit>() { // from class: com.tencent.mobileqq.triton.internal.touch.TouchProviderBridge.3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super Long, ? extends Unit> function1) {
                invoke2((Function1<? super Long, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Function1<? super Long, Unit> function1) {
                if (function1 != null) {
                    TouchProviderBridge.this.lastTouchTimestampCallbackHolder.setValue(null);
                    function1.invoke(Long.valueOf(TouchProviderBridge.this.getLastTouchTimestamp()));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getLastClicks() {
        String lastClicks;
        TouchEventManager touchEventManager = this.manager;
        if (touchEventManager == null || (lastClicks = touchEventManager.getLastClicks()) == null) {
            return "";
        }
        return lastClicks;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long getLastTouchTimestamp() {
        TouchEventManager touchEventManager = this.manager;
        if (touchEventManager != null) {
            return touchEventManager.getLastTouchTimestamp();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getTheLastClickInfo() {
        String theLastClickInfo;
        TouchEventManager touchEventManager = this.manager;
        if (touchEventManager == null || (theLastClickInfo = touchEventManager.getTheLastClickInfo()) == null) {
            return "";
        }
        return theLastClickInfo;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void attachView(@NotNull GameView view, float density) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        this.manager = new TouchEventManager(density);
        view.setGameOnTouchListener(new Function1<MotionEvent, Boolean>() { // from class: com.tencent.mobileqq.triton.internal.touch.TouchProviderBridge$attachView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(MotionEvent motionEvent) {
                return Boolean.valueOf(invoke2(motionEvent));
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2(@NotNull MotionEvent event) {
                LifeCycleOwner lifeCycleOwner;
                TouchEventManager touchEventManager;
                TouchEventManager touchEventManager2;
                Intrinsics.checkParameterIsNotNull(event, "event");
                lifeCycleOwner = TouchProviderBridge.this.lifeCycleOwner;
                if (lifeCycleOwner.getEngineState() == EngineState.STARTED) {
                    touchEventManager2 = TouchProviderBridge.this.manager;
                    if (touchEventManager2 != null) {
                        touchEventManager2.onTouchEvent(event);
                    }
                    return true;
                }
                touchEventManager = TouchProviderBridge.this.manager;
                if (touchEventManager != null) {
                    touchEventManager.clear();
                }
                return false;
            }
        });
    }

    public final void flushTouchEvents(@NotNull TTEngine engine) {
        List<InputTouchEvent> list;
        boolean z16;
        Intrinsics.checkParameterIsNotNull(engine, "engine");
        TouchEventManager touchEventManager = this.manager;
        if (touchEventManager != null) {
            list = touchEventManager.flushTouchEvents();
        } else {
            list = null;
        }
        List<InputTouchEvent> list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        for (InputTouchEvent inputTouchEvent : list) {
            engine.nativeOnTouchEvent(engine.getNativeTTAppHandle(), inputTouchEvent.getNativePtr());
            inputTouchEvent.release();
        }
    }
}
