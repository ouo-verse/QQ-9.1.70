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
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$drop$1", f = "Deprecated.kt", i = {0}, l = {151, 156, 157}, m = "invokeSuspend", n = {"remaining"}, s = {"I$0"})
/* loaded from: classes28.dex */
final class ChannelsKt__DeprecatedKt$drop$1 extends SuspendLambda implements Function2<ProducerScope<Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $n;
    final /* synthetic */ ReceiveChannel<Object> $this_drop;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelsKt__DeprecatedKt$drop$1(int i3, ReceiveChannel<Object> receiveChannel, Continuation<? super ChannelsKt__DeprecatedKt$drop$1> continuation) {
        super(2, continuation);
        this.$n = i3;
        this.$this_drop = receiveChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$drop$1 channelsKt__DeprecatedKt$drop$1 = new ChannelsKt__DeprecatedKt$drop$1(this.$n, this.$this_drop, continuation);
        channelsKt__DeprecatedKt$drop$1.L$0 = obj;
        return channelsKt__DeprecatedKt$drop$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0077 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x00ac A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x00c9 -> B:7:0x00a0). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x0078 -> B:24:0x007f). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        ProducerScope producerScope;
        int i3;
        boolean z16;
        Object obj2;
        ChannelsKt__DeprecatedKt$drop$1 channelsKt__DeprecatedKt$drop$1;
        ChannelIterator<Object> it;
        ProducerScope producerScope2;
        ChannelsKt__DeprecatedKt$drop$1 channelsKt__DeprecatedKt$drop$12;
        ChannelIterator<Object> it5;
        Object hasNext;
        ProducerScope producerScope3;
        Object hasNext2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i16 = this.label;
        if (i16 != 0) {
            if (i16 != 1) {
                if (i16 != 2) {
                    if (i16 == 3) {
                        ChannelIterator<Object> channelIterator = (ChannelIterator) this.L$1;
                        ProducerScope producerScope4 = (ProducerScope) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        producerScope = producerScope4;
                        it5 = channelIterator;
                        obj2 = coroutine_suspended;
                        channelsKt__DeprecatedKt$drop$1 = this;
                        channelsKt__DeprecatedKt$drop$1.L$0 = producerScope;
                        channelsKt__DeprecatedKt$drop$1.L$1 = it5;
                        channelsKt__DeprecatedKt$drop$1.label = 2;
                        hasNext2 = it5.hasNext(channelsKt__DeprecatedKt$drop$1);
                        if (hasNext2 != obj2) {
                            return obj2;
                        }
                        producerScope3 = producerScope;
                        obj = hasNext2;
                        if (!((Boolean) obj).booleanValue()) {
                            Object next = it5.next();
                            channelsKt__DeprecatedKt$drop$1.L$0 = producerScope3;
                            channelsKt__DeprecatedKt$drop$1.L$1 = it5;
                            channelsKt__DeprecatedKt$drop$1.label = 3;
                            if (producerScope3.send(next, channelsKt__DeprecatedKt$drop$1) == obj2) {
                                return obj2;
                            }
                            producerScope = producerScope3;
                            channelsKt__DeprecatedKt$drop$1.L$0 = producerScope;
                            channelsKt__DeprecatedKt$drop$1.L$1 = it5;
                            channelsKt__DeprecatedKt$drop$1.label = 2;
                            hasNext2 = it5.hasNext(channelsKt__DeprecatedKt$drop$1);
                            if (hasNext2 != obj2) {
                            }
                        } else {
                            return Unit.INSTANCE;
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ChannelIterator<Object> channelIterator2 = (ChannelIterator) this.L$1;
                    ProducerScope producerScope5 = (ProducerScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    producerScope3 = producerScope5;
                    it5 = channelIterator2;
                    obj2 = coroutine_suspended;
                    channelsKt__DeprecatedKt$drop$1 = this;
                    if (!((Boolean) obj).booleanValue()) {
                    }
                }
            } else {
                int i17 = this.I$0;
                ChannelIterator<Object> channelIterator3 = (ChannelIterator) this.L$1;
                ProducerScope producerScope6 = (ProducerScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                ProducerScope producerScope7 = producerScope6;
                ChannelIterator<Object> channelIterator4 = channelIterator3;
                int i18 = i17;
                obj2 = coroutine_suspended;
                channelsKt__DeprecatedKt$drop$1 = this;
                if (((Boolean) obj).booleanValue()) {
                    channelIterator4.next();
                    int i19 = i18 - 1;
                    if (i19 != 0) {
                        it = channelIterator4;
                        producerScope2 = producerScope7;
                        Object obj3 = obj2;
                        i3 = i19;
                        channelsKt__DeprecatedKt$drop$12 = channelsKt__DeprecatedKt$drop$1;
                        coroutine_suspended = obj3;
                        channelsKt__DeprecatedKt$drop$12.L$0 = producerScope2;
                        channelsKt__DeprecatedKt$drop$12.L$1 = it;
                        channelsKt__DeprecatedKt$drop$12.I$0 = i3;
                        channelsKt__DeprecatedKt$drop$12.label = 1;
                        hasNext = it.hasNext(channelsKt__DeprecatedKt$drop$12);
                        if (hasNext != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        Object obj4 = coroutine_suspended;
                        channelsKt__DeprecatedKt$drop$1 = channelsKt__DeprecatedKt$drop$12;
                        obj = hasNext;
                        producerScope7 = producerScope2;
                        channelIterator4 = it;
                        i18 = i3;
                        obj2 = obj4;
                        if (((Boolean) obj).booleanValue()) {
                        }
                    }
                }
                producerScope = producerScope7;
                it5 = channelsKt__DeprecatedKt$drop$1.$this_drop.iterator();
                channelsKt__DeprecatedKt$drop$1.L$0 = producerScope;
                channelsKt__DeprecatedKt$drop$1.L$1 = it5;
                channelsKt__DeprecatedKt$drop$1.label = 2;
                hasNext2 = it5.hasNext(channelsKt__DeprecatedKt$drop$1);
                if (hasNext2 != obj2) {
                }
            }
        } else {
            ResultKt.throwOnFailure(obj);
            producerScope = (ProducerScope) this.L$0;
            i3 = this.$n;
            if (i3 >= 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                if (i3 > 0) {
                    it = this.$this_drop.iterator();
                    producerScope2 = producerScope;
                    channelsKt__DeprecatedKt$drop$12 = this;
                    channelsKt__DeprecatedKt$drop$12.L$0 = producerScope2;
                    channelsKt__DeprecatedKt$drop$12.L$1 = it;
                    channelsKt__DeprecatedKt$drop$12.I$0 = i3;
                    channelsKt__DeprecatedKt$drop$12.label = 1;
                    hasNext = it.hasNext(channelsKt__DeprecatedKt$drop$12);
                    if (hasNext != coroutine_suspended) {
                    }
                } else {
                    obj2 = coroutine_suspended;
                    channelsKt__DeprecatedKt$drop$1 = this;
                    it5 = channelsKt__DeprecatedKt$drop$1.$this_drop.iterator();
                    channelsKt__DeprecatedKt$drop$1.L$0 = producerScope;
                    channelsKt__DeprecatedKt$drop$1.L$1 = it5;
                    channelsKt__DeprecatedKt$drop$1.label = 2;
                    hasNext2 = it5.hasNext(channelsKt__DeprecatedKt$drop$1);
                    if (hasNext2 != obj2) {
                    }
                }
            } else {
                throw new IllegalArgumentException(("Requested element count " + i3 + " is less than zero.").toString());
            }
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull ProducerScope<Object> producerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ChannelsKt__DeprecatedKt$drop$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
