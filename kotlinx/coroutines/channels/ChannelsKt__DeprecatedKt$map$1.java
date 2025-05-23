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
/* JADX INFO: Add missing generic type declarations: [R] */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u0002H\u008a@"}, d2 = {"E", BdhLogUtil.LogTag.Tag_Req, "Lkotlinx/coroutines/channels/ProducerScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$map$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 2, 2}, l = {415, 288, 288}, m = "invokeSuspend", n = {"$this$produce", "$this$consume$iv$iv", "$this$produce", "$this$consume$iv$iv", "$this$produce", "$this$consume$iv$iv"}, s = {"L$0", "L$2", "L$0", "L$2", "L$0", "L$2"})
/* loaded from: classes28.dex */
public final class ChannelsKt__DeprecatedKt$map$1<R> extends SuspendLambda implements Function2<ProducerScope<? super R>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ReceiveChannel<E> $this_map;
    final /* synthetic */ Function2<E, Continuation<? super R>, Object> $transform;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelsKt__DeprecatedKt$map$1(ReceiveChannel<? extends E> receiveChannel, Function2<? super E, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super ChannelsKt__DeprecatedKt$map$1> continuation) {
        super(2, continuation);
        this.$this_map = receiveChannel;
        this.$transform = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$map$1 channelsKt__DeprecatedKt$map$1 = new ChannelsKt__DeprecatedKt$map$1(this.$this_map, this.$transform, continuation);
        channelsKt__DeprecatedKt$map$1.L$0 = obj;
        return channelsKt__DeprecatedKt$map$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0094 A[Catch: all -> 0x00d2, TRY_LEAVE, TryCatch #0 {all -> 0x00d2, blocks: (B:8:0x0022, B:10:0x0077, B:15:0x008c, B:17:0x0094, B:34:0x00ca, B:45:0x005f, B:48:0x006f), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00c3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ca A[Catch: all -> 0x00d2, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x00d2, blocks: (B:8:0x0022, B:10:0x0077, B:15:0x008c, B:17:0x0094, B:34:0x00ca, B:45:0x005f, B:48:0x006f), top: B:2:0x000a }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x00c4 -> B:10:0x0077). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        ReceiveChannel receiveChannel;
        ProducerScope producerScope;
        ChannelsKt__DeprecatedKt$map$1<R> channelsKt__DeprecatedKt$map$1;
        Function2 function2;
        ChannelIterator it;
        ReceiveChannel receiveChannel2;
        ChannelsKt__DeprecatedKt$map$1<R> channelsKt__DeprecatedKt$map$12;
        ProducerScope producerScope2;
        Function2 function22;
        ChannelIterator channelIterator;
        ProducerScope producerScope3;
        ChannelsKt__DeprecatedKt$map$1<R> channelsKt__DeprecatedKt$map$13;
        ProducerScope producerScope4;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3) {
                            it = (ChannelIterator) this.L$3;
                            receiveChannel = (ReceiveChannel) this.L$2;
                            function2 = (Function2) this.L$1;
                            ProducerScope producerScope5 = (ProducerScope) this.L$0;
                            ResultKt.throwOnFailure(obj);
                            producerScope = producerScope5;
                            channelsKt__DeprecatedKt$map$1 = this;
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        producerScope3 = (ProducerScope) this.L$4;
                        channelIterator = (ChannelIterator) this.L$3;
                        receiveChannel2 = (ReceiveChannel) this.L$2;
                        function22 = (Function2) this.L$1;
                        producerScope2 = (ProducerScope) this.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            channelsKt__DeprecatedKt$map$12 = this;
                            channelsKt__DeprecatedKt$map$12.L$0 = producerScope2;
                            channelsKt__DeprecatedKt$map$12.L$1 = function22;
                            channelsKt__DeprecatedKt$map$12.L$2 = receiveChannel2;
                            channelsKt__DeprecatedKt$map$12.L$3 = channelIterator;
                            channelsKt__DeprecatedKt$map$12.L$4 = null;
                            channelsKt__DeprecatedKt$map$12.label = 3;
                            if (producerScope3.send(obj, channelsKt__DeprecatedKt$map$12) != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            it = channelIterator;
                            receiveChannel = receiveChannel2;
                            function2 = function22;
                            producerScope = producerScope2;
                            channelsKt__DeprecatedKt$map$1 = channelsKt__DeprecatedKt$map$12;
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
                    }
                } else {
                    it = (ChannelIterator) this.L$3;
                    receiveChannel = (ReceiveChannel) this.L$2;
                    function2 = (Function2) this.L$1;
                    producerScope4 = (ProducerScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    channelsKt__DeprecatedKt$map$13 = this;
                    if (!((Boolean) obj).booleanValue()) {
                        Object next = it.next();
                        channelsKt__DeprecatedKt$map$13.L$0 = producerScope4;
                        channelsKt__DeprecatedKt$map$13.L$1 = function2;
                        channelsKt__DeprecatedKt$map$13.L$2 = receiveChannel;
                        channelsKt__DeprecatedKt$map$13.L$3 = it;
                        channelsKt__DeprecatedKt$map$13.L$4 = producerScope4;
                        channelsKt__DeprecatedKt$map$13.label = 2;
                        obj = function2.invoke(next, channelsKt__DeprecatedKt$map$13);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        channelsKt__DeprecatedKt$map$12 = channelsKt__DeprecatedKt$map$13;
                        producerScope2 = producerScope4;
                        function22 = function2;
                        receiveChannel2 = receiveChannel;
                        channelIterator = it;
                        producerScope3 = producerScope2;
                        channelsKt__DeprecatedKt$map$12.L$0 = producerScope2;
                        channelsKt__DeprecatedKt$map$12.L$1 = function22;
                        channelsKt__DeprecatedKt$map$12.L$2 = receiveChannel2;
                        channelsKt__DeprecatedKt$map$12.L$3 = channelIterator;
                        channelsKt__DeprecatedKt$map$12.L$4 = null;
                        channelsKt__DeprecatedKt$map$12.label = 3;
                        if (producerScope3.send(obj, channelsKt__DeprecatedKt$map$12) != coroutine_suspended) {
                        }
                    } else {
                        Unit unit = Unit.INSTANCE;
                        ChannelsKt.cancelConsumed(receiveChannel, null);
                        return Unit.INSTANCE;
                    }
                }
            } else {
                ResultKt.throwOnFailure(obj);
                producerScope = (ProducerScope) this.L$0;
                receiveChannel = this.$this_map;
                channelsKt__DeprecatedKt$map$1 = this;
                function2 = this.$transform;
                it = receiveChannel.iterator();
            }
            channelsKt__DeprecatedKt$map$1.L$0 = producerScope;
            channelsKt__DeprecatedKt$map$1.L$1 = function2;
            channelsKt__DeprecatedKt$map$1.L$2 = receiveChannel;
            channelsKt__DeprecatedKt$map$1.L$3 = it;
            channelsKt__DeprecatedKt$map$1.label = 1;
            Object hasNext = it.hasNext(channelsKt__DeprecatedKt$map$1);
            if (hasNext == coroutine_suspended) {
                return coroutine_suspended;
            }
            ChannelsKt__DeprecatedKt$map$1<R> channelsKt__DeprecatedKt$map$14 = channelsKt__DeprecatedKt$map$1;
            producerScope4 = producerScope;
            obj = hasNext;
            channelsKt__DeprecatedKt$map$13 = channelsKt__DeprecatedKt$map$14;
            if (!((Boolean) obj).booleanValue()) {
            }
        } catch (Throwable th7) {
            th = th7;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull ProducerScope<? super R> producerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ChannelsKt__DeprecatedKt$map$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
