package androidx.compose.runtime;

import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001b\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u001f\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J\u000e\u0010\u0015\u001a\u00028\u0000H\u0096\u0003\u00a2\u0006\u0002\u0010\fJ\u0015\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00130\u0017H\u0096\u0003R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\n\u001a\u00028\u0000X\u0096\u000f\u00a2\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0018"}, d2 = {"Landroidx/compose/runtime/ProduceStateScopeImpl;", "T", "Landroidx/compose/runtime/ProduceStateScope;", "Landroidx/compose/runtime/MutableState;", "state", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "(Landroidx/compose/runtime/MutableState;Lkotlin/coroutines/CoroutineContext;)V", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "value", HippyTextInputController.COMMAND_getValue, "()Ljava/lang/Object;", HippyTextInputController.COMMAND_setValue, "(Ljava/lang/Object;)V", "awaitDispose", "", "onDispose", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "component1", "component2", "Lkotlin/Function1;", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes39.dex */
public final class ProduceStateScopeImpl<T> implements ProduceStateScope<T>, MutableState<T> {
    private final /* synthetic */ MutableState<T> $$delegate_0;
    private final CoroutineContext coroutineContext;

    public ProduceStateScopeImpl(MutableState<T> state, CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        this.coroutineContext = coroutineContext;
        this.$$delegate_0 = state;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    @Override // androidx.compose.runtime.ProduceStateScope
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object awaitDispose(Function0<Unit> function0, Continuation<?> continuation) {
        ProduceStateScopeImpl$awaitDispose$1 produceStateScopeImpl$awaitDispose$1;
        Object coroutine_suspended;
        int i3;
        Continuation intercepted;
        Object coroutine_suspended2;
        try {
            if (continuation instanceof ProduceStateScopeImpl$awaitDispose$1) {
                produceStateScopeImpl$awaitDispose$1 = (ProduceStateScopeImpl$awaitDispose$1) continuation;
                int i16 = produceStateScopeImpl$awaitDispose$1.label;
                if ((i16 & Integer.MIN_VALUE) != 0) {
                    produceStateScopeImpl$awaitDispose$1.label = i16 - Integer.MIN_VALUE;
                    Object obj = produceStateScopeImpl$awaitDispose$1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = produceStateScopeImpl$awaitDispose$1.label;
                    if (i3 != 0) {
                        ResultKt.throwOnFailure(obj);
                        produceStateScopeImpl$awaitDispose$1.L$0 = function0;
                        produceStateScopeImpl$awaitDispose$1.label = 1;
                        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(produceStateScopeImpl$awaitDispose$1);
                        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
                        cancellableContinuationImpl.initCancellability();
                        Object result = cancellableContinuationImpl.getResult();
                        coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (result == coroutine_suspended2) {
                            DebugProbes.probeCoroutineSuspended(produceStateScopeImpl$awaitDispose$1);
                        }
                        if (result == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i3 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        function0 = (Function0) produceStateScopeImpl$awaitDispose$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    throw new KotlinNothingValueException();
                }
            }
            if (i3 != 0) {
            }
            throw new KotlinNothingValueException();
        } catch (Throwable th5) {
            function0.invoke();
            throw th5;
        }
        produceStateScopeImpl$awaitDispose$1 = new ProduceStateScopeImpl$awaitDispose$1(this, continuation);
        Object obj2 = produceStateScopeImpl$awaitDispose$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = produceStateScopeImpl$awaitDispose$1.label;
    }

    @Override // androidx.compose.runtime.MutableState
    public T component1() {
        return this.$$delegate_0.component1();
    }

    @Override // androidx.compose.runtime.MutableState
    public Function1<T, Unit> component2() {
        return this.$$delegate_0.component2();
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // androidx.compose.runtime.MutableState, androidx.compose.runtime.State
    public T getValue() {
        return this.$$delegate_0.getValue();
    }

    @Override // androidx.compose.runtime.MutableState
    public void setValue(T t16) {
        this.$$delegate_0.setValue(t16);
    }
}
