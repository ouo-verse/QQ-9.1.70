package com.tencent.mobileqq.triton.internal.lifecycle;

import com.tencent.mobileqq.triton.TritonEngine;
import com.tencent.mobileqq.triton.engine.EngineState;
import com.tencent.mobileqq.triton.internal.engine.EngineContext;
import com.tencent.mobileqq.triton.lifecycle.LifeCycle;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 \u001b*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u001bB\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bB\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bB\u000f\b\u0012\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\fJ)\u0010\u0018\u001a\u00020\u00132!\u0010\u0019\u001a\u001d\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00130\u000fJ)\u0010\u001a\u001a\u00020\u00132!\u0010\u0019\u001a\u001d\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00130\u000fR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R/\u0010\r\u001a#\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00130\u000f0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R&\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00028\u0000@FX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\f\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;", "T", "", "initialValue", "lifeCycleOwner", "Lcom/tencent/mobileqq/triton/internal/lifecycle/LifeCycleOwner;", "engineLock", "Ljava/util/concurrent/locks/Lock;", "(Ljava/lang/Object;Lcom/tencent/mobileqq/triton/internal/lifecycle/LifeCycleOwner;Ljava/util/concurrent/locks/Lock;)V", "engineContext", "Lcom/tencent/mobileqq/triton/internal/engine/EngineContext;", "(Ljava/lang/Object;Lcom/tencent/mobileqq/triton/internal/engine/EngineContext;)V", "(Ljava/lang/Object;)V", "observers", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "value", "", HippyTextInputController.COMMAND_getValue, "()Ljava/lang/Object;", HippyTextInputController.COMMAND_setValue, "Ljava/lang/Object;", "observe", "observer", "unobserve", "Companion", "Triton_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final class ValueHolder<T> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Lock engineLock;
    private final LifeCycleOwner lifeCycleOwner;
    private final CopyOnWriteArrayList<Function1<T, Unit>> observers;
    private volatile T value;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u00052\u0006\u0010\u0006\u001a\u0002H\u0005\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder$Companion;", "", "()V", "just", "Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;", "T", "initialValue", "(Ljava/lang/Object;)Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;", "Triton_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes19.dex */
    public static final class Companion {
        Companion() {
        }

        @NotNull
        public final <T> ValueHolder<T> just(T initialValue) {
            return new ValueHolder<>(initialValue, (DefaultConstructorMarker) null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ ValueHolder(Object obj, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj);
    }

    public final T getValue() {
        return this.value;
    }

    public final void observe(@NotNull Function1<? super T, Unit> observer) {
        EngineState engineState;
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        LifeCycleOwner lifeCycleOwner = this.lifeCycleOwner;
        if (lifeCycleOwner != null) {
            engineState = lifeCycleOwner.getEngineState();
        } else {
            engineState = null;
        }
        if (engineState == EngineState.DESTROYED) {
            return;
        }
        this.observers.addIfAbsent(observer);
        observer.invoke(this.value);
    }

    public final void setValue(T t16) {
        this.value = t16;
        if (this.engineLock != null) {
            Iterator<T> it = this.observers.iterator();
            while (it.hasNext()) {
                Function1 function1 = (Function1) it.next();
                Lock lock = this.engineLock;
                lock.lock();
                try {
                    function1.invoke(t16);
                    Unit unit = Unit.INSTANCE;
                } finally {
                    lock.unlock();
                }
            }
            return;
        }
        Iterator<T> it5 = this.observers.iterator();
        while (it5.hasNext()) {
            ((Function1) it5.next()).invoke(t16);
        }
    }

    public final void unobserve(@NotNull Function1<? super T, Unit> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        this.observers.remove(observer);
    }

    public ValueHolder(T t16, @NotNull LifeCycleOwner lifeCycleOwner, @NotNull Lock engineLock) {
        Intrinsics.checkParameterIsNotNull(lifeCycleOwner, "lifeCycleOwner");
        Intrinsics.checkParameterIsNotNull(engineLock, "engineLock");
        this.observers = new CopyOnWriteArrayList<>();
        setValue(t16);
        this.lifeCycleOwner = lifeCycleOwner;
        this.engineLock = engineLock;
        lifeCycleOwner.observeLifeCycle(new LifeCycle() { // from class: com.tencent.mobileqq.triton.internal.lifecycle.ValueHolder.1
            @Override // com.tencent.mobileqq.triton.lifecycle.LifeCycle
            public void onDestroy() {
                ValueHolder.this.observers.clear();
            }

            @Override // com.tencent.mobileqq.triton.lifecycle.LifeCycle
            public void onFirstFrame() {
                LifeCycle.DefaultImpls.onFirstFrame(this);
            }

            @Override // com.tencent.mobileqq.triton.lifecycle.LifeCycle
            public void onGameLaunched(@NotNull TritonEngine engine) {
                Intrinsics.checkParameterIsNotNull(engine, "engine");
                LifeCycle.DefaultImpls.onGameLaunched(this, engine);
            }

            @Override // com.tencent.mobileqq.triton.lifecycle.LifeCycle
            public void onStart() {
                LifeCycle.DefaultImpls.onStart(this);
            }

            @Override // com.tencent.mobileqq.triton.lifecycle.LifeCycle
            public void onStop() {
                LifeCycle.DefaultImpls.onStop(this);
            }
        });
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ValueHolder(T t16, @NotNull EngineContext engineContext) {
        this(t16, engineContext.getLifeCycleOwner(), engineContext.getLock());
        Intrinsics.checkParameterIsNotNull(engineContext, "engineContext");
    }

    ValueHolder(T t16) {
        this.observers = new CopyOnWriteArrayList<>();
        setValue(t16);
        this.lifeCycleOwner = null;
        this.engineLock = null;
    }
}
