package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [E] */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u008a@"}, d2 = {"E", "Lkotlinx/coroutines/channels/ProducerScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "kotlinx.coroutines.channels.BroadcastKt$broadcast$2", f = "Broadcast.kt", i = {0, 1}, l = {53, 54}, m = "invokeSuspend", n = {"$this$broadcast", "$this$broadcast"}, s = {"L$0", "L$0"})
/* loaded from: classes28.dex */
public final class BroadcastKt$broadcast$2<E> extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ReceiveChannel<E> $this_broadcast;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BroadcastKt$broadcast$2(ReceiveChannel<? extends E> receiveChannel, Continuation<? super BroadcastKt$broadcast$2> continuation) {
        super(2, continuation);
        this.$this_broadcast = receiveChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        BroadcastKt$broadcast$2 broadcastKt$broadcast$2 = new BroadcastKt$broadcast$2(this.$this_broadcast, continuation);
        broadcastKt$broadcast$2.L$0 = obj;
        return broadcastKt$broadcast$2;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x004b A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0069 -> B:7:0x003f). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        ProducerScope producerScope;
        ChannelIterator<E> it;
        BroadcastKt$broadcast$2<E> broadcastKt$broadcast$2;
        Object hasNext;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    it = (ChannelIterator) this.L$1;
                    ProducerScope producerScope2 = (ProducerScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    producerScope = producerScope2;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                it = (ChannelIterator) this.L$1;
                ProducerScope producerScope3 = (ProducerScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                BroadcastKt$broadcast$2<E> broadcastKt$broadcast$22 = this;
                if (!((Boolean) obj).booleanValue()) {
                    E next = it.next();
                    broadcastKt$broadcast$22.L$0 = producerScope3;
                    broadcastKt$broadcast$22.L$1 = it;
                    broadcastKt$broadcast$22.label = 2;
                    if (producerScope3.send(next, broadcastKt$broadcast$22) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    producerScope = producerScope3;
                    broadcastKt$broadcast$2 = broadcastKt$broadcast$22;
                    broadcastKt$broadcast$2.L$0 = producerScope;
                    broadcastKt$broadcast$2.L$1 = it;
                    broadcastKt$broadcast$2.label = 1;
                    hasNext = it.hasNext(broadcastKt$broadcast$2);
                    if (hasNext != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    BroadcastKt$broadcast$2<E> broadcastKt$broadcast$23 = broadcastKt$broadcast$2;
                    producerScope3 = producerScope;
                    obj = hasNext;
                    broadcastKt$broadcast$22 = broadcastKt$broadcast$23;
                    if (!((Boolean) obj).booleanValue()) {
                        return Unit.INSTANCE;
                    }
                }
            }
        } else {
            ResultKt.throwOnFailure(obj);
            producerScope = (ProducerScope) this.L$0;
            it = this.$this_broadcast.iterator();
        }
        broadcastKt$broadcast$2 = this;
        broadcastKt$broadcast$2.L$0 = producerScope;
        broadcastKt$broadcast$2.L$1 = it;
        broadcastKt$broadcast$2.label = 1;
        hasNext = it.hasNext(broadcastKt$broadcast$2);
        if (hasNext != coroutine_suspended) {
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull ProducerScope<? super E> producerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((BroadcastKt$broadcast$2) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
