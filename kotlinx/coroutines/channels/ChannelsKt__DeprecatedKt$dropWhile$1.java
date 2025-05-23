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
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$dropWhile$1", f = "Deprecated.kt", i = {0, 1, 1, 2}, l = {164, 165, 166, 170, 171}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "e", "$this$produce"}, s = {"L$0", "L$0", "L$2", "L$0"})
/* loaded from: classes28.dex */
final class ChannelsKt__DeprecatedKt$dropWhile$1 extends SuspendLambda implements Function2<ProducerScope<Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<Object, Continuation<? super Boolean>, Object> $predicate;
    final /* synthetic */ ReceiveChannel<Object> $this_dropWhile;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelsKt__DeprecatedKt$dropWhile$1(ReceiveChannel<Object> receiveChannel, Function2<Object, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super ChannelsKt__DeprecatedKt$dropWhile$1> continuation) {
        super(2, continuation);
        this.$this_dropWhile = receiveChannel;
        this.$predicate = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$dropWhile$1 channelsKt__DeprecatedKt$dropWhile$1 = new ChannelsKt__DeprecatedKt$dropWhile$1(this.$this_dropWhile, this.$predicate, continuation);
        channelsKt__DeprecatedKt$dropWhile$1.L$0 = obj;
        return channelsKt__DeprecatedKt$dropWhile$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x00e6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x009d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0103 -> B:9:0x00da). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00b2 -> B:29:0x00b6). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        ChannelIterator<Object> it;
        ProducerScope producerScope;
        ChannelsKt__DeprecatedKt$dropWhile$1 channelsKt__DeprecatedKt$dropWhile$1;
        ProducerScope producerScope2;
        ChannelIterator<Object> channelIterator;
        Object obj2;
        ChannelsKt__DeprecatedKt$dropWhile$1 channelsKt__DeprecatedKt$dropWhile$12;
        ProducerScope producerScope3;
        Object hasNext;
        ChannelIterator<Object> it5;
        ChannelIterator<Object> channelIterator2;
        Object hasNext2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 == 5) {
                                ChannelIterator<Object> channelIterator3 = (ChannelIterator) this.L$1;
                                ProducerScope producerScope4 = (ProducerScope) this.L$0;
                                ResultKt.throwOnFailure(obj);
                                it5 = channelIterator3;
                                producerScope2 = producerScope4;
                                obj2 = coroutine_suspended;
                                channelsKt__DeprecatedKt$dropWhile$12 = this;
                                channelsKt__DeprecatedKt$dropWhile$12.L$0 = producerScope2;
                                channelsKt__DeprecatedKt$dropWhile$12.L$1 = it5;
                                channelsKt__DeprecatedKt$dropWhile$12.label = 4;
                                hasNext2 = it5.hasNext(channelsKt__DeprecatedKt$dropWhile$12);
                                if (hasNext2 != obj2) {
                                    return obj2;
                                }
                                channelIterator2 = it5;
                                obj = hasNext2;
                                if (!((Boolean) obj).booleanValue()) {
                                    Object next = channelIterator2.next();
                                    channelsKt__DeprecatedKt$dropWhile$12.L$0 = producerScope2;
                                    channelsKt__DeprecatedKt$dropWhile$12.L$1 = channelIterator2;
                                    channelsKt__DeprecatedKt$dropWhile$12.label = 5;
                                    if (producerScope2.send(next, channelsKt__DeprecatedKt$dropWhile$12) == obj2) {
                                        return obj2;
                                    }
                                    it5 = channelIterator2;
                                    channelsKt__DeprecatedKt$dropWhile$12.L$0 = producerScope2;
                                    channelsKt__DeprecatedKt$dropWhile$12.L$1 = it5;
                                    channelsKt__DeprecatedKt$dropWhile$12.label = 4;
                                    hasNext2 = it5.hasNext(channelsKt__DeprecatedKt$dropWhile$12);
                                    if (hasNext2 != obj2) {
                                    }
                                } else {
                                    return Unit.INSTANCE;
                                }
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            ChannelIterator<Object> channelIterator4 = (ChannelIterator) this.L$1;
                            ProducerScope producerScope5 = (ProducerScope) this.L$0;
                            ResultKt.throwOnFailure(obj);
                            producerScope2 = producerScope5;
                            channelIterator2 = channelIterator4;
                            obj2 = coroutine_suspended;
                            channelsKt__DeprecatedKt$dropWhile$12 = this;
                            if (!((Boolean) obj).booleanValue()) {
                            }
                        }
                    } else {
                        ProducerScope producerScope6 = (ProducerScope) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        producerScope3 = producerScope6;
                        obj2 = coroutine_suspended;
                        channelsKt__DeprecatedKt$dropWhile$12 = this;
                        producerScope2 = producerScope3;
                        it5 = channelsKt__DeprecatedKt$dropWhile$12.$this_dropWhile.iterator();
                        channelsKt__DeprecatedKt$dropWhile$12.L$0 = producerScope2;
                        channelsKt__DeprecatedKt$dropWhile$12.L$1 = it5;
                        channelsKt__DeprecatedKt$dropWhile$12.label = 4;
                        hasNext2 = it5.hasNext(channelsKt__DeprecatedKt$dropWhile$12);
                        if (hasNext2 != obj2) {
                        }
                    }
                } else {
                    Object obj3 = this.L$2;
                    channelIterator = (ChannelIterator) this.L$1;
                    ProducerScope producerScope7 = (ProducerScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    producerScope3 = producerScope7;
                    Object obj4 = obj3;
                    obj2 = coroutine_suspended;
                    channelsKt__DeprecatedKt$dropWhile$12 = this;
                    if (((Boolean) obj).booleanValue()) {
                        channelsKt__DeprecatedKt$dropWhile$12.L$0 = producerScope3;
                        channelsKt__DeprecatedKt$dropWhile$12.L$1 = null;
                        channelsKt__DeprecatedKt$dropWhile$12.L$2 = null;
                        channelsKt__DeprecatedKt$dropWhile$12.label = 3;
                        if (producerScope3.send(obj4, channelsKt__DeprecatedKt$dropWhile$12) == obj2) {
                            return obj2;
                        }
                        producerScope2 = producerScope3;
                        it5 = channelsKt__DeprecatedKt$dropWhile$12.$this_dropWhile.iterator();
                        channelsKt__DeprecatedKt$dropWhile$12.L$0 = producerScope2;
                        channelsKt__DeprecatedKt$dropWhile$12.L$1 = it5;
                        channelsKt__DeprecatedKt$dropWhile$12.label = 4;
                        hasNext2 = it5.hasNext(channelsKt__DeprecatedKt$dropWhile$12);
                        if (hasNext2 != obj2) {
                        }
                    } else {
                        channelsKt__DeprecatedKt$dropWhile$1 = channelsKt__DeprecatedKt$dropWhile$12;
                        coroutine_suspended = obj2;
                        it = channelIterator;
                        producerScope = producerScope3;
                        channelsKt__DeprecatedKt$dropWhile$1.L$0 = producerScope;
                        channelsKt__DeprecatedKt$dropWhile$1.L$1 = it;
                        channelsKt__DeprecatedKt$dropWhile$1.L$2 = null;
                        channelsKt__DeprecatedKt$dropWhile$1.label = 1;
                        hasNext = it.hasNext(channelsKt__DeprecatedKt$dropWhile$1);
                        if (hasNext != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        Object obj5 = coroutine_suspended;
                        channelsKt__DeprecatedKt$dropWhile$12 = channelsKt__DeprecatedKt$dropWhile$1;
                        obj = hasNext;
                        producerScope2 = producerScope;
                        channelIterator = it;
                        obj2 = obj5;
                        if (((Boolean) obj).booleanValue()) {
                            Object next2 = channelIterator.next();
                            Function2<Object, Continuation<? super Boolean>, Object> function2 = channelsKt__DeprecatedKt$dropWhile$12.$predicate;
                            channelsKt__DeprecatedKt$dropWhile$12.L$0 = producerScope2;
                            channelsKt__DeprecatedKt$dropWhile$12.L$1 = channelIterator;
                            channelsKt__DeprecatedKt$dropWhile$12.L$2 = next2;
                            channelsKt__DeprecatedKt$dropWhile$12.label = 2;
                            Object invoke = function2.invoke(next2, channelsKt__DeprecatedKt$dropWhile$12);
                            if (invoke == obj2) {
                                return obj2;
                            }
                            ProducerScope producerScope8 = producerScope2;
                            obj4 = next2;
                            obj = invoke;
                            producerScope3 = producerScope8;
                            if (((Boolean) obj).booleanValue()) {
                            }
                        }
                        it5 = channelsKt__DeprecatedKt$dropWhile$12.$this_dropWhile.iterator();
                        channelsKt__DeprecatedKt$dropWhile$12.L$0 = producerScope2;
                        channelsKt__DeprecatedKt$dropWhile$12.L$1 = it5;
                        channelsKt__DeprecatedKt$dropWhile$12.label = 4;
                        hasNext2 = it5.hasNext(channelsKt__DeprecatedKt$dropWhile$12);
                        if (hasNext2 != obj2) {
                        }
                    }
                }
            } else {
                ChannelIterator<Object> channelIterator5 = (ChannelIterator) this.L$1;
                ProducerScope producerScope9 = (ProducerScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                producerScope2 = producerScope9;
                channelIterator = channelIterator5;
                obj2 = coroutine_suspended;
                channelsKt__DeprecatedKt$dropWhile$12 = this;
                if (((Boolean) obj).booleanValue()) {
                }
                it5 = channelsKt__DeprecatedKt$dropWhile$12.$this_dropWhile.iterator();
                channelsKt__DeprecatedKt$dropWhile$12.L$0 = producerScope2;
                channelsKt__DeprecatedKt$dropWhile$12.L$1 = it5;
                channelsKt__DeprecatedKt$dropWhile$12.label = 4;
                hasNext2 = it5.hasNext(channelsKt__DeprecatedKt$dropWhile$12);
                if (hasNext2 != obj2) {
                }
            }
        } else {
            ResultKt.throwOnFailure(obj);
            ProducerScope producerScope10 = (ProducerScope) this.L$0;
            it = this.$this_dropWhile.iterator();
            producerScope = producerScope10;
            channelsKt__DeprecatedKt$dropWhile$1 = this;
            channelsKt__DeprecatedKt$dropWhile$1.L$0 = producerScope;
            channelsKt__DeprecatedKt$dropWhile$1.L$1 = it;
            channelsKt__DeprecatedKt$dropWhile$1.L$2 = null;
            channelsKt__DeprecatedKt$dropWhile$1.label = 1;
            hasNext = it.hasNext(channelsKt__DeprecatedKt$dropWhile$1);
            if (hasNext != coroutine_suspended) {
            }
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull ProducerScope<Object> producerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ChannelsKt__DeprecatedKt$dropWhile$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
