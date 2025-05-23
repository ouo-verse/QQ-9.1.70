package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u008a@"}, d2 = {"E", "Lkotlinx/coroutines/channels/ProducerScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterIndexed$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 2}, l = {187, 188, 188}, m = "invokeSuspend", n = {"$this$produce", "index", "$this$produce", "e", "$this$produce"}, s = {"L$0", "I$0", "L$0", "L$2", "L$0"})
/* loaded from: classes28.dex */
final class ChannelsKt__DeprecatedKt$filterIndexed$1 extends SuspendLambda implements Function2<ProducerScope<Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function3<Integer, Object, Continuation<? super Boolean>, Object> $predicate;
    final /* synthetic */ ReceiveChannel<Object> $this_filterIndexed;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelsKt__DeprecatedKt$filterIndexed$1(ReceiveChannel<Object> receiveChannel, Function3<? super Integer, Object, ? super Continuation<? super Boolean>, ? extends Object> function3, Continuation<? super ChannelsKt__DeprecatedKt$filterIndexed$1> continuation) {
        super(2, continuation);
        this.$this_filterIndexed = receiveChannel;
        this.$predicate = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$filterIndexed$1 channelsKt__DeprecatedKt$filterIndexed$1 = new ChannelsKt__DeprecatedKt$filterIndexed$1(this.$this_filterIndexed, this.$predicate, continuation);
        channelsKt__DeprecatedKt$filterIndexed$1.L$0 = obj;
        return channelsKt__DeprecatedKt$filterIndexed$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0067, code lost:
    
        r13 = r0;
        r0 = r1;
        r7 = r8;
        r1 = r10;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c6  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        ProducerScope producerScope;
        ChannelsKt__DeprecatedKt$filterIndexed$1 channelsKt__DeprecatedKt$filterIndexed$1;
        ChannelIterator<Object> it;
        int i3;
        ChannelIterator<Object> channelIterator;
        int i16;
        ProducerScope producerScope2;
        Object obj2;
        Object obj3;
        ChannelsKt__DeprecatedKt$filterIndexed$1 channelsKt__DeprecatedKt$filterIndexed$12;
        ChannelIterator<Object> channelIterator2;
        int i17;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i18 = this.label;
        if (i18 != 0) {
            if (i18 != 1) {
                if (i18 != 2) {
                    if (i18 == 3) {
                        i3 = this.I$0;
                        it = (ChannelIterator) this.L$1;
                        producerScope = (ProducerScope) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        channelsKt__DeprecatedKt$filterIndexed$1 = this;
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    int i19 = this.I$0;
                    Object obj4 = this.L$2;
                    ChannelIterator<Object> channelIterator3 = (ChannelIterator) this.L$1;
                    producerScope2 = (ProducerScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    i16 = i19;
                    obj3 = coroutine_suspended;
                    channelsKt__DeprecatedKt$filterIndexed$12 = this;
                    channelIterator = channelIterator3;
                    obj2 = obj4;
                    it = channelIterator;
                    if (((Boolean) obj).booleanValue()) {
                        channelsKt__DeprecatedKt$filterIndexed$12.L$0 = producerScope2;
                        channelsKt__DeprecatedKt$filterIndexed$12.L$1 = it;
                        channelsKt__DeprecatedKt$filterIndexed$12.L$2 = null;
                        channelsKt__DeprecatedKt$filterIndexed$12.I$0 = i16;
                        channelsKt__DeprecatedKt$filterIndexed$12.label = 3;
                        if (producerScope2.send(obj2, channelsKt__DeprecatedKt$filterIndexed$12) == obj3) {
                            return obj3;
                        }
                    }
                    channelsKt__DeprecatedKt$filterIndexed$1 = channelsKt__DeprecatedKt$filterIndexed$12;
                    coroutine_suspended = obj3;
                    producerScope = producerScope2;
                    i3 = i16;
                }
            } else {
                int i26 = this.I$0;
                ChannelIterator<Object> channelIterator4 = (ChannelIterator) this.L$1;
                ProducerScope producerScope3 = (ProducerScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                producerScope2 = producerScope3;
                channelIterator2 = channelIterator4;
                i17 = i26;
                obj3 = coroutine_suspended;
                channelsKt__DeprecatedKt$filterIndexed$12 = this;
                if (!((Boolean) obj).booleanValue()) {
                    Object next = channelIterator2.next();
                    Function3<Integer, Object, Continuation<? super Boolean>, Object> function3 = channelsKt__DeprecatedKt$filterIndexed$12.$predicate;
                    i16 = i17 + 1;
                    Integer boxInt = Boxing.boxInt(i17);
                    channelsKt__DeprecatedKt$filterIndexed$12.L$0 = producerScope2;
                    channelsKt__DeprecatedKt$filterIndexed$12.L$1 = channelIterator2;
                    channelsKt__DeprecatedKt$filterIndexed$12.L$2 = next;
                    channelsKt__DeprecatedKt$filterIndexed$12.I$0 = i16;
                    channelsKt__DeprecatedKt$filterIndexed$12.label = 2;
                    Object invoke = function3.invoke(boxInt, next, channelsKt__DeprecatedKt$filterIndexed$12);
                    if (invoke == obj3) {
                        return obj3;
                    }
                    channelIterator = channelIterator2;
                    obj2 = next;
                    obj = invoke;
                    it = channelIterator;
                    if (((Boolean) obj).booleanValue()) {
                    }
                    channelsKt__DeprecatedKt$filterIndexed$1 = channelsKt__DeprecatedKt$filterIndexed$12;
                    coroutine_suspended = obj3;
                    producerScope = producerScope2;
                    i3 = i16;
                } else {
                    return Unit.INSTANCE;
                }
            }
        } else {
            ResultKt.throwOnFailure(obj);
            producerScope = (ProducerScope) this.L$0;
            channelsKt__DeprecatedKt$filterIndexed$1 = this;
            it = this.$this_filterIndexed.iterator();
            i3 = 0;
        }
        channelsKt__DeprecatedKt$filterIndexed$1.L$0 = producerScope;
        channelsKt__DeprecatedKt$filterIndexed$1.L$1 = it;
        channelsKt__DeprecatedKt$filterIndexed$1.L$2 = null;
        channelsKt__DeprecatedKt$filterIndexed$1.I$0 = i3;
        channelsKt__DeprecatedKt$filterIndexed$1.label = 1;
        Object hasNext = it.hasNext(channelsKt__DeprecatedKt$filterIndexed$1);
        if (hasNext == coroutine_suspended) {
            return coroutine_suspended;
        }
        Object obj5 = coroutine_suspended;
        channelsKt__DeprecatedKt$filterIndexed$12 = channelsKt__DeprecatedKt$filterIndexed$1;
        obj = hasNext;
        producerScope2 = producerScope;
        channelIterator2 = it;
        i17 = i3;
        obj3 = obj5;
        if (!((Boolean) obj).booleanValue()) {
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull ProducerScope<Object> producerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ChannelsKt__DeprecatedKt$filterIndexed$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
