package kotlinx.coroutines.flow;

import com.tencent.luggage.wxa.rf.d;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.SelectInstance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u008a@"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/flow/FlowCollector;", "downstream", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1", f = "Delay.kt", i = {}, l = {224, d.CTRL_INDEX}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes28.dex */
public final class FlowKt__DelayKt$debounceInternal$1<T> extends SuspendLambda implements Function3<CoroutineScope, FlowCollector<? super T>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow<T> $this_debounceInternal;
    final /* synthetic */ Function1<T, Long> $timeoutMillisSelector;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__DelayKt$debounceInternal$1(Function1<? super T, Long> function1, Flow<? extends T> flow, Continuation<? super FlowKt__DelayKt$debounceInternal$1> continuation) {
        super(3, continuation);
        this.$timeoutMillisSelector = function1;
        this.$this_debounceInternal = flow;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:50|26|30|31|32|33|(1:35)|36|37|(1:39)|(1:41)(1:42)) */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00f9, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00fa, code lost:
    
        r10.handleBuilderException(r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e2 A[Catch: all -> 0x00f9, TryCatch #0 {all -> 0x00f9, blocks: (B:33:0x00de, B:35:0x00e2, B:36:0x00ec), top: B:32:0x00de }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x010c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x010d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x010d -> B:6:0x0070). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        FlowCollector flowCollector;
        FlowKt__DelayKt$debounceInternal$1<T> flowKt__DelayKt$debounceInternal$1;
        ReceiveChannel produce$default;
        Ref.ObjectRef objectRef;
        Ref.LongRef longRef;
        Object obj2;
        Object result;
        Object coroutine_suspended2;
        boolean z16;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    Ref.ObjectRef objectRef2 = (Ref.ObjectRef) this.L$2;
                    ReceiveChannel receiveChannel = (ReceiveChannel) this.L$1;
                    FlowCollector flowCollector2 = (FlowCollector) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    flowCollector = flowCollector2;
                    produce$default = receiveChannel;
                    objectRef = objectRef2;
                    flowKt__DelayKt$debounceInternal$1 = this;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                Ref.LongRef longRef2 = (Ref.LongRef) this.L$3;
                objectRef = (Ref.ObjectRef) this.L$2;
                produce$default = (ReceiveChannel) this.L$1;
                flowCollector = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(obj);
                longRef = longRef2;
                flowKt__DelayKt$debounceInternal$1 = this;
                objectRef.element = null;
                FlowKt__DelayKt$debounceInternal$1<T> flowKt__DelayKt$debounceInternal$12 = flowKt__DelayKt$debounceInternal$1;
                obj2 = coroutine_suspended;
                Ref.LongRef longRef3 = longRef;
                FlowCollector flowCollector3 = flowCollector;
                ReceiveChannel receiveChannel2 = produce$default;
                flowKt__DelayKt$debounceInternal$12.L$0 = flowCollector3;
                flowKt__DelayKt$debounceInternal$12.L$1 = receiveChannel2;
                flowKt__DelayKt$debounceInternal$12.L$2 = objectRef;
                flowKt__DelayKt$debounceInternal$12.L$3 = longRef3;
                flowKt__DelayKt$debounceInternal$12.label = 2;
                SelectInstance selectInstance = new SelectInstance(flowKt__DelayKt$debounceInternal$12);
                if (objectRef.element != null) {
                    selectInstance.onTimeout(longRef3.element, new FlowKt__DelayKt$debounceInternal$1$3$1(flowCollector3, objectRef, null));
                }
                selectInstance.invoke(receiveChannel2.getOnReceiveCatching(), new FlowKt__DelayKt$debounceInternal$1$3$2(objectRef, flowCollector3, null));
                result = selectInstance.getResult();
                coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (result == coroutine_suspended2) {
                    DebugProbes.probeCoroutineSuspended(flowKt__DelayKt$debounceInternal$12);
                }
                if (result != obj2) {
                    return obj2;
                }
                coroutine_suspended = obj2;
                flowKt__DelayKt$debounceInternal$1 = flowKt__DelayKt$debounceInternal$12;
                produce$default = receiveChannel2;
                flowCollector = flowCollector3;
            }
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            flowCollector = (FlowCollector) this.L$1;
            flowKt__DelayKt$debounceInternal$1 = this;
            produce$default = ProduceKt.produce$default(coroutineScope, null, 0, new FlowKt__DelayKt$debounceInternal$1$values$1(this.$this_debounceInternal, null), 3, null);
            objectRef = new Ref.ObjectRef();
        }
        if (objectRef.element != NullSurrogateKt.DONE) {
            longRef = new Ref.LongRef();
            T t16 = objectRef.element;
            if (t16 != null) {
                Function1<T, Long> function1 = flowKt__DelayKt$debounceInternal$1.$timeoutMillisSelector;
                Symbol symbol = NullSurrogateKt.NULL;
                if (t16 == symbol) {
                    t16 = null;
                }
                long longValue = function1.invoke(t16).longValue();
                longRef.element = longValue;
                if (longValue >= 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    if (longValue == 0) {
                        T t17 = objectRef.element;
                        if (t17 == symbol) {
                            t17 = null;
                        }
                        flowKt__DelayKt$debounceInternal$1.L$0 = flowCollector;
                        flowKt__DelayKt$debounceInternal$1.L$1 = produce$default;
                        flowKt__DelayKt$debounceInternal$1.L$2 = objectRef;
                        flowKt__DelayKt$debounceInternal$1.L$3 = longRef;
                        flowKt__DelayKt$debounceInternal$1.label = 1;
                        if (flowCollector.emit(t17, flowKt__DelayKt$debounceInternal$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        objectRef.element = null;
                    }
                } else {
                    throw new IllegalArgumentException("Debounce timeout should not be negative".toString());
                }
            }
            FlowKt__DelayKt$debounceInternal$1<T> flowKt__DelayKt$debounceInternal$122 = flowKt__DelayKt$debounceInternal$1;
            obj2 = coroutine_suspended;
            Ref.LongRef longRef32 = longRef;
            FlowCollector flowCollector32 = flowCollector;
            ReceiveChannel receiveChannel22 = produce$default;
            flowKt__DelayKt$debounceInternal$122.L$0 = flowCollector32;
            flowKt__DelayKt$debounceInternal$122.L$1 = receiveChannel22;
            flowKt__DelayKt$debounceInternal$122.L$2 = objectRef;
            flowKt__DelayKt$debounceInternal$122.L$3 = longRef32;
            flowKt__DelayKt$debounceInternal$122.label = 2;
            SelectInstance selectInstance2 = new SelectInstance(flowKt__DelayKt$debounceInternal$122);
            if (objectRef.element != null) {
            }
            selectInstance2.invoke(receiveChannel22.getOnReceiveCatching(), new FlowKt__DelayKt$debounceInternal$1$3$2(objectRef, flowCollector32, null));
            result = selectInstance2.getResult();
            coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (result == coroutine_suspended2) {
            }
            if (result != obj2) {
            }
        } else {
            return Unit.INSTANCE;
        }
    }

    @Override // kotlin.jvm.functions.Function3
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @NotNull FlowCollector<? super T> flowCollector, @Nullable Continuation<? super Unit> continuation) {
        FlowKt__DelayKt$debounceInternal$1 flowKt__DelayKt$debounceInternal$1 = new FlowKt__DelayKt$debounceInternal$1(this.$timeoutMillisSelector, this.$this_debounceInternal, continuation);
        flowKt__DelayKt$debounceInternal$1.L$0 = coroutineScope;
        flowKt__DelayKt$debounceInternal$1.L$1 = flowCollector;
        return flowKt__DelayKt$debounceInternal$1.invokeSuspend(Unit.INSTANCE);
    }
}
