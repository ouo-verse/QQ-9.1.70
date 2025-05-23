package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
/* synthetic */ class SafeCollectorKt$emitFun$1 extends FunctionReferenceImpl implements Function3<FlowCollector<? super Object>, Object, Unit>, SuspendFunction {
    public static final SafeCollectorKt$emitFun$1 INSTANCE = new SafeCollectorKt$emitFun$1();

    SafeCollectorKt$emitFun$1() {
        super(3, FlowCollector.class, "emit", "emit(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    @Nullable
    public final Object invoke(@NotNull FlowCollector<Object> flowCollector, @Nullable Object obj, @NotNull Continuation<? super Unit> continuation) {
        return flowCollector.emit(obj, continuation);
    }
}
