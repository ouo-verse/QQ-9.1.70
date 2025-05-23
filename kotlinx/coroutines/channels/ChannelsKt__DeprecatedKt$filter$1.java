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
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filter$1", f = "Deprecated.kt", i = {0, 1, 1, 2}, l = {178, 179, 179}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "e", "$this$produce"}, s = {"L$0", "L$0", "L$2", "L$0"})
/* loaded from: classes28.dex */
public final class ChannelsKt__DeprecatedKt$filter$1<E> extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<E, Continuation<? super Boolean>, Object> $predicate;
    final /* synthetic */ ReceiveChannel<E> $this_filter;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelsKt__DeprecatedKt$filter$1(ReceiveChannel<? extends E> receiveChannel, Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super ChannelsKt__DeprecatedKt$filter$1> continuation) {
        super(2, continuation);
        this.$this_filter = receiveChannel;
        this.$predicate = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$filter$1 channelsKt__DeprecatedKt$filter$1 = new ChannelsKt__DeprecatedKt$filter$1(this.$this_filter, this.$predicate, continuation);
        channelsKt__DeprecatedKt$filter$1.L$0 = obj;
        return channelsKt__DeprecatedKt$filter$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0058, code lost:
    
        r11 = r0;
        r0 = r1;
        r1 = r6;
        r6 = r8;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0066 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00aa  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        ChannelIterator<E> it;
        ProducerScope producerScope;
        ChannelIterator<E> channelIterator;
        Object obj2;
        ChannelsKt__DeprecatedKt$filter$1<E> channelsKt__DeprecatedKt$filter$1;
        ChannelsKt__DeprecatedKt$filter$1<E> channelsKt__DeprecatedKt$filter$12;
        ProducerScope producerScope2;
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
                    channelIterator = (ChannelIterator) this.L$1;
                    ProducerScope producerScope3 = (ProducerScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    ProducerScope producerScope4 = producerScope3;
                    E e16 = obj3;
                    obj2 = coroutine_suspended;
                    channelsKt__DeprecatedKt$filter$1 = this;
                    if (((Boolean) obj).booleanValue()) {
                        channelsKt__DeprecatedKt$filter$1.L$0 = producerScope4;
                        channelsKt__DeprecatedKt$filter$1.L$1 = channelIterator;
                        channelsKt__DeprecatedKt$filter$1.L$2 = null;
                        channelsKt__DeprecatedKt$filter$1.label = 3;
                        if (producerScope4.send(e16, channelsKt__DeprecatedKt$filter$1) == obj2) {
                            return obj2;
                        }
                    }
                    channelsKt__DeprecatedKt$filter$12 = channelsKt__DeprecatedKt$filter$1;
                    coroutine_suspended = obj2;
                    it = channelIterator;
                    producerScope = producerScope4;
                    channelsKt__DeprecatedKt$filter$12.L$0 = producerScope;
                    channelsKt__DeprecatedKt$filter$12.L$1 = it;
                    channelsKt__DeprecatedKt$filter$12.L$2 = null;
                    channelsKt__DeprecatedKt$filter$12.label = 1;
                    hasNext = it.hasNext(channelsKt__DeprecatedKt$filter$12);
                    if (hasNext == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    Object obj4 = coroutine_suspended;
                    channelsKt__DeprecatedKt$filter$1 = channelsKt__DeprecatedKt$filter$12;
                    obj = hasNext;
                    producerScope2 = producerScope;
                    channelIterator = it;
                    obj2 = obj4;
                    if (!((Boolean) obj).booleanValue()) {
                        E next = channelIterator.next();
                        Function2<E, Continuation<? super Boolean>, Object> function2 = channelsKt__DeprecatedKt$filter$1.$predicate;
                        channelsKt__DeprecatedKt$filter$1.L$0 = producerScope2;
                        channelsKt__DeprecatedKt$filter$1.L$1 = channelIterator;
                        channelsKt__DeprecatedKt$filter$1.L$2 = next;
                        channelsKt__DeprecatedKt$filter$1.label = 2;
                        Object invoke = function2.invoke(next, channelsKt__DeprecatedKt$filter$1);
                        if (invoke == obj2) {
                            return obj2;
                        }
                        ProducerScope producerScope5 = producerScope2;
                        e16 = next;
                        obj = invoke;
                        producerScope4 = producerScope5;
                        if (((Boolean) obj).booleanValue()) {
                        }
                        channelsKt__DeprecatedKt$filter$12 = channelsKt__DeprecatedKt$filter$1;
                        coroutine_suspended = obj2;
                        it = channelIterator;
                        producerScope = producerScope4;
                        channelsKt__DeprecatedKt$filter$12.L$0 = producerScope;
                        channelsKt__DeprecatedKt$filter$12.L$1 = it;
                        channelsKt__DeprecatedKt$filter$12.L$2 = null;
                        channelsKt__DeprecatedKt$filter$12.label = 1;
                        hasNext = it.hasNext(channelsKt__DeprecatedKt$filter$12);
                        if (hasNext == coroutine_suspended) {
                        }
                    } else {
                        return Unit.INSTANCE;
                    }
                }
            } else {
                ChannelIterator<E> channelIterator2 = (ChannelIterator) this.L$1;
                ProducerScope producerScope6 = (ProducerScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                producerScope2 = producerScope6;
                channelIterator = channelIterator2;
                obj2 = coroutine_suspended;
                channelsKt__DeprecatedKt$filter$1 = this;
                if (!((Boolean) obj).booleanValue()) {
                }
            }
        } else {
            ResultKt.throwOnFailure(obj);
            ProducerScope producerScope7 = (ProducerScope) this.L$0;
            it = this.$this_filter.iterator();
            producerScope = producerScope7;
        }
        channelsKt__DeprecatedKt$filter$12 = this;
        channelsKt__DeprecatedKt$filter$12.L$0 = producerScope;
        channelsKt__DeprecatedKt$filter$12.L$1 = it;
        channelsKt__DeprecatedKt$filter$12.L$2 = null;
        channelsKt__DeprecatedKt$filter$12.label = 1;
        hasNext = it.hasNext(channelsKt__DeprecatedKt$filter$12);
        if (hasNext == coroutine_suspended) {
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull ProducerScope<? super E> producerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ChannelsKt__DeprecatedKt$filter$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
