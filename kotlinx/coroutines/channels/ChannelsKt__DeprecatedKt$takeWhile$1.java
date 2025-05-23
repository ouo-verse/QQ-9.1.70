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

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u008a@"}, d2 = {"E", "Lkotlinx/coroutines/channels/ProducerScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$takeWhile$1", f = "Deprecated.kt", i = {0, 1, 1}, l = {234, 235, 236}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "e"}, s = {"L$0", "L$0", "L$2"})
/* loaded from: classes28.dex */
final class ChannelsKt__DeprecatedKt$takeWhile$1 extends SuspendLambda implements Function2<ProducerScope<Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<Object, Continuation<? super Boolean>, Object> $predicate;
    final /* synthetic */ ReceiveChannel<Object> $this_takeWhile;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelsKt__DeprecatedKt$takeWhile$1(ReceiveChannel<Object> receiveChannel, Function2<Object, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super ChannelsKt__DeprecatedKt$takeWhile$1> continuation) {
        super(2, continuation);
        this.$this_takeWhile = receiveChannel;
        this.$predicate = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$takeWhile$1 channelsKt__DeprecatedKt$takeWhile$1 = new ChannelsKt__DeprecatedKt$takeWhile$1(this.$this_takeWhile, this.$predicate, continuation);
        channelsKt__DeprecatedKt$takeWhile$1.L$0 = obj;
        return channelsKt__DeprecatedKt$takeWhile$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0064 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ad  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00a8 -> B:8:0x0058). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        ChannelIterator<Object> it;
        ProducerScope producerScope;
        Object obj2;
        ChannelsKt__DeprecatedKt$takeWhile$1 channelsKt__DeprecatedKt$takeWhile$1;
        ChannelsKt__DeprecatedKt$takeWhile$1 channelsKt__DeprecatedKt$takeWhile$12;
        ProducerScope producerScope2;
        ChannelIterator<Object> channelIterator;
        Object hasNext;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        it = (ChannelIterator) this.L$1;
                        producerScope = (ProducerScope) this.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    Object obj3 = this.L$2;
                    ChannelIterator<Object> channelIterator2 = (ChannelIterator) this.L$1;
                    ProducerScope producerScope3 = (ProducerScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    ProducerScope producerScope4 = producerScope3;
                    ChannelIterator<Object> channelIterator3 = channelIterator2;
                    Object obj4 = obj3;
                    obj2 = coroutine_suspended;
                    channelsKt__DeprecatedKt$takeWhile$1 = this;
                    if (((Boolean) obj).booleanValue()) {
                        return Unit.INSTANCE;
                    }
                    channelsKt__DeprecatedKt$takeWhile$1.L$0 = producerScope4;
                    channelsKt__DeprecatedKt$takeWhile$1.L$1 = channelIterator3;
                    channelsKt__DeprecatedKt$takeWhile$1.L$2 = null;
                    channelsKt__DeprecatedKt$takeWhile$1.label = 3;
                    if (producerScope4.send(obj4, channelsKt__DeprecatedKt$takeWhile$1) == obj2) {
                        return obj2;
                    }
                    channelsKt__DeprecatedKt$takeWhile$12 = channelsKt__DeprecatedKt$takeWhile$1;
                    coroutine_suspended = obj2;
                    it = channelIterator3;
                    producerScope = producerScope4;
                    channelsKt__DeprecatedKt$takeWhile$12.L$0 = producerScope;
                    channelsKt__DeprecatedKt$takeWhile$12.L$1 = it;
                    channelsKt__DeprecatedKt$takeWhile$12.label = 1;
                    hasNext = it.hasNext(channelsKt__DeprecatedKt$takeWhile$12);
                    if (hasNext != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    Object obj5 = coroutine_suspended;
                    channelsKt__DeprecatedKt$takeWhile$1 = channelsKt__DeprecatedKt$takeWhile$12;
                    obj = hasNext;
                    producerScope2 = producerScope;
                    channelIterator = it;
                    obj2 = obj5;
                    if (!((Boolean) obj).booleanValue()) {
                        Object next = channelIterator.next();
                        Function2<Object, Continuation<? super Boolean>, Object> function2 = channelsKt__DeprecatedKt$takeWhile$1.$predicate;
                        channelsKt__DeprecatedKt$takeWhile$1.L$0 = producerScope2;
                        channelsKt__DeprecatedKt$takeWhile$1.L$1 = channelIterator;
                        channelsKt__DeprecatedKt$takeWhile$1.L$2 = next;
                        channelsKt__DeprecatedKt$takeWhile$1.label = 2;
                        Object invoke = function2.invoke(next, channelsKt__DeprecatedKt$takeWhile$1);
                        if (invoke == obj2) {
                            return obj2;
                        }
                        ChannelIterator<Object> channelIterator4 = channelIterator;
                        obj4 = next;
                        obj = invoke;
                        producerScope4 = producerScope2;
                        channelIterator3 = channelIterator4;
                        if (((Boolean) obj).booleanValue()) {
                        }
                    } else {
                        return Unit.INSTANCE;
                    }
                }
            } else {
                ChannelIterator<Object> channelIterator5 = (ChannelIterator) this.L$1;
                ProducerScope producerScope5 = (ProducerScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                producerScope2 = producerScope5;
                channelIterator = channelIterator5;
                obj2 = coroutine_suspended;
                channelsKt__DeprecatedKt$takeWhile$1 = this;
                if (!((Boolean) obj).booleanValue()) {
                }
            }
        } else {
            ResultKt.throwOnFailure(obj);
            ProducerScope producerScope6 = (ProducerScope) this.L$0;
            it = this.$this_takeWhile.iterator();
            producerScope = producerScope6;
        }
        channelsKt__DeprecatedKt$takeWhile$12 = this;
        channelsKt__DeprecatedKt$takeWhile$12.L$0 = producerScope;
        channelsKt__DeprecatedKt$takeWhile$12.L$1 = it;
        channelsKt__DeprecatedKt$takeWhile$12.label = 1;
        hasNext = it.hasNext(channelsKt__DeprecatedKt$takeWhile$12);
        if (hasNext != coroutine_suspended) {
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull ProducerScope<Object> producerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ChannelsKt__DeprecatedKt$takeWhile$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
