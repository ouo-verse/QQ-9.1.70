package kotlinx.coroutines.channels;

import com.tencent.mobileqq.highway.utils.BdhLogUtil;
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
/* JADX INFO: Add missing generic type declarations: [V] */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00020\u0003H\u008a@"}, d2 = {"E", BdhLogUtil.LogTag.Tag_Req, "V", "Lkotlinx/coroutines/channels/ProducerScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$zip$2", f = "Deprecated.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {415, 397, 399}, m = "invokeSuspend", n = {"$this$produce", "otherIterator", "$this$consume$iv$iv", "$this$produce", "otherIterator", "$this$consume$iv$iv", "element1"}, s = {"L$0", "L$1", "L$3", "L$0", "L$1", "L$3", "L$5"})
/* loaded from: classes28.dex */
public final class ChannelsKt__DeprecatedKt$zip$2<V> extends SuspendLambda implements Function2<ProducerScope<? super V>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ReceiveChannel<R> $other;
    final /* synthetic */ ReceiveChannel<E> $this_zip;
    final /* synthetic */ Function2<E, R, V> $transform;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelsKt__DeprecatedKt$zip$2(ReceiveChannel<? extends R> receiveChannel, ReceiveChannel<? extends E> receiveChannel2, Function2<? super E, ? super R, ? extends V> function2, Continuation<? super ChannelsKt__DeprecatedKt$zip$2> continuation) {
        super(2, continuation);
        this.$other = receiveChannel;
        this.$this_zip = receiveChannel2;
        this.$transform = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$zip$2 channelsKt__DeprecatedKt$zip$2 = new ChannelsKt__DeprecatedKt$zip$2(this.$other, this.$this_zip, this.$transform, continuation);
        channelsKt__DeprecatedKt$zip$2.L$0 = obj;
        return channelsKt__DeprecatedKt$zip$2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0094, code lost:
    
        r14 = r0;
        r0 = r1;
        r1 = r6;
        r6 = r8;
        r7 = r9;
        r8 = r10;
        r9 = r11;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00ba A[Catch: all -> 0x0057, TRY_LEAVE, TryCatch #3 {all -> 0x0057, blocks: (B:15:0x00b2, B:17:0x00ba, B:38:0x010a, B:49:0x004b), top: B:48:0x004b }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ea A[Catch: all -> 0x0107, TRY_LEAVE, TryCatch #2 {all -> 0x0107, blocks: (B:22:0x00da, B:25:0x00ea), top: B:21:0x00da }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x010a A[Catch: all -> 0x0057, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x0057, blocks: (B:15:0x00b2, B:17:0x00ba, B:38:0x010a, B:49:0x004b), top: B:48:0x004b }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        ReceiveChannel receiveChannel;
        Function2 function2;
        ProducerScope producerScope;
        ChannelsKt__DeprecatedKt$zip$2<V> channelsKt__DeprecatedKt$zip$2;
        ChannelIterator channelIterator;
        ChannelIterator it;
        ReceiveChannel receiveChannel2;
        ProducerScope producerScope2;
        ChannelIterator channelIterator2;
        Function2 function22;
        ReceiveChannel receiveChannel3;
        Object obj2;
        ChannelIterator channelIterator3;
        Object obj3;
        ChannelsKt__DeprecatedKt$zip$2<V> channelsKt__DeprecatedKt$zip$22;
        ProducerScope producerScope3;
        ChannelIterator channelIterator4;
        Function2 function23;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3) {
                            it = (ChannelIterator) this.L$4;
                            receiveChannel = (ReceiveChannel) this.L$3;
                            function2 = (Function2) this.L$2;
                            channelIterator = (ChannelIterator) this.L$1;
                            producerScope = (ProducerScope) this.L$0;
                            ResultKt.throwOnFailure(obj);
                            channelsKt__DeprecatedKt$zip$2 = this;
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        Object obj4 = this.L$5;
                        channelIterator3 = (ChannelIterator) this.L$4;
                        receiveChannel2 = (ReceiveChannel) this.L$3;
                        Function2 function24 = (Function2) this.L$2;
                        ChannelIterator channelIterator5 = (ChannelIterator) this.L$1;
                        ProducerScope producerScope4 = (ProducerScope) this.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            producerScope2 = producerScope4;
                            channelIterator2 = channelIterator5;
                            function22 = function24;
                            receiveChannel3 = receiveChannel2;
                            obj2 = obj4;
                            obj3 = coroutine_suspended;
                            channelsKt__DeprecatedKt$zip$22 = this;
                        } catch (Throwable th5) {
                            th = th5;
                            receiveChannel = receiveChannel2;
                            try {
                                throw th;
                            } catch (Throwable th6) {
                                ChannelsKt.cancelConsumed(receiveChannel, th);
                                throw th6;
                            }
                        }
                        try {
                            if (((Boolean) obj).booleanValue()) {
                                channelsKt__DeprecatedKt$zip$2 = channelsKt__DeprecatedKt$zip$22;
                                coroutine_suspended = obj3;
                                it = channelIterator3;
                                receiveChannel = receiveChannel3;
                                function2 = function22;
                                channelIterator = channelIterator2;
                                producerScope = producerScope2;
                            } else {
                                Object invoke = function22.invoke(obj2, channelIterator2.next());
                                channelsKt__DeprecatedKt$zip$22.L$0 = producerScope2;
                                channelsKt__DeprecatedKt$zip$22.L$1 = channelIterator2;
                                channelsKt__DeprecatedKt$zip$22.L$2 = function22;
                                channelsKt__DeprecatedKt$zip$22.L$3 = receiveChannel3;
                                channelsKt__DeprecatedKt$zip$22.L$4 = channelIterator3;
                                channelsKt__DeprecatedKt$zip$22.L$5 = null;
                                channelsKt__DeprecatedKt$zip$22.label = 3;
                                if (producerScope2.send(invoke, channelsKt__DeprecatedKt$zip$22) == obj3) {
                                    return obj3;
                                }
                                channelsKt__DeprecatedKt$zip$2 = channelsKt__DeprecatedKt$zip$22;
                                coroutine_suspended = obj3;
                                it = channelIterator3;
                                receiveChannel = receiveChannel3;
                                function2 = function22;
                                channelIterator = channelIterator2;
                                producerScope = producerScope2;
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            receiveChannel = receiveChannel3;
                            throw th;
                        }
                    }
                } else {
                    ChannelIterator channelIterator6 = (ChannelIterator) this.L$4;
                    ReceiveChannel receiveChannel4 = (ReceiveChannel) this.L$3;
                    Function2 function25 = (Function2) this.L$2;
                    ChannelIterator channelIterator7 = (ChannelIterator) this.L$1;
                    ProducerScope producerScope5 = (ProducerScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    producerScope3 = producerScope5;
                    channelIterator4 = channelIterator7;
                    function23 = function25;
                    receiveChannel2 = receiveChannel4;
                    channelIterator3 = channelIterator6;
                    obj3 = coroutine_suspended;
                    channelsKt__DeprecatedKt$zip$22 = this;
                    if (!((Boolean) obj).booleanValue()) {
                        Object next = channelIterator3.next();
                        channelsKt__DeprecatedKt$zip$22.L$0 = producerScope3;
                        channelsKt__DeprecatedKt$zip$22.L$1 = channelIterator4;
                        channelsKt__DeprecatedKt$zip$22.L$2 = function23;
                        channelsKt__DeprecatedKt$zip$22.L$3 = receiveChannel2;
                        channelsKt__DeprecatedKt$zip$22.L$4 = channelIterator3;
                        channelsKt__DeprecatedKt$zip$22.L$5 = next;
                        channelsKt__DeprecatedKt$zip$22.label = 2;
                        Object hasNext = channelIterator4.hasNext(channelsKt__DeprecatedKt$zip$22);
                        if (hasNext == obj3) {
                            return obj3;
                        }
                        ReceiveChannel receiveChannel5 = receiveChannel2;
                        obj2 = next;
                        obj = hasNext;
                        producerScope2 = producerScope3;
                        channelIterator2 = channelIterator4;
                        function22 = function23;
                        receiveChannel3 = receiveChannel5;
                        if (((Boolean) obj).booleanValue()) {
                        }
                    } else {
                        Unit unit = Unit.INSTANCE;
                        ChannelsKt.cancelConsumed(receiveChannel2, null);
                        return Unit.INSTANCE;
                    }
                }
            } else {
                ResultKt.throwOnFailure(obj);
                ProducerScope producerScope6 = (ProducerScope) this.L$0;
                ChannelIterator it5 = this.$other.iterator();
                receiveChannel = this.$this_zip;
                function2 = this.$transform;
                producerScope = producerScope6;
                channelsKt__DeprecatedKt$zip$2 = this;
                channelIterator = it5;
                it = receiveChannel.iterator();
            }
            channelsKt__DeprecatedKt$zip$2.L$0 = producerScope;
            channelsKt__DeprecatedKt$zip$2.L$1 = channelIterator;
            channelsKt__DeprecatedKt$zip$2.L$2 = function2;
            channelsKt__DeprecatedKt$zip$2.L$3 = receiveChannel;
            channelsKt__DeprecatedKt$zip$2.L$4 = it;
            channelsKt__DeprecatedKt$zip$2.L$5 = null;
            channelsKt__DeprecatedKt$zip$2.label = 1;
            Object hasNext2 = it.hasNext(channelsKt__DeprecatedKt$zip$2);
            if (hasNext2 == coroutine_suspended) {
                return coroutine_suspended;
            }
            Object obj5 = coroutine_suspended;
            channelsKt__DeprecatedKt$zip$22 = channelsKt__DeprecatedKt$zip$2;
            obj = hasNext2;
            producerScope3 = producerScope;
            channelIterator4 = channelIterator;
            function23 = function2;
            receiveChannel2 = receiveChannel;
            channelIterator3 = it;
            obj3 = obj5;
            if (!((Boolean) obj).booleanValue()) {
            }
        } catch (Throwable th8) {
            th = th8;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull ProducerScope<? super V> producerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ChannelsKt__DeprecatedKt$zip$2) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
