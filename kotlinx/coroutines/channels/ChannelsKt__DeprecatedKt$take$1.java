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
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$take$1", f = "Deprecated.kt", i = {0, 1}, l = {223, 224}, m = "invokeSuspend", n = {"remaining", "remaining"}, s = {"I$0", "I$0"})
/* loaded from: classes28.dex */
final class ChannelsKt__DeprecatedKt$take$1 extends SuspendLambda implements Function2<ProducerScope<Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $n;
    final /* synthetic */ ReceiveChannel<Object> $this_take;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelsKt__DeprecatedKt$take$1(int i3, ReceiveChannel<Object> receiveChannel, Continuation<? super ChannelsKt__DeprecatedKt$take$1> continuation) {
        super(2, continuation);
        this.$n = i3;
        this.$this_take = receiveChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$take$1 channelsKt__DeprecatedKt$take$1 = new ChannelsKt__DeprecatedKt$take$1(this.$n, this.$this_take, continuation);
        channelsKt__DeprecatedKt$take$1.L$0 = obj;
        return channelsKt__DeprecatedKt$take$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0061 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0087  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0081 -> B:6:0x0083). Please report as a decompilation issue!!! */
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
        ChannelIterator<Object> it;
        ChannelsKt__DeprecatedKt$take$1 channelsKt__DeprecatedKt$take$1;
        ChannelsKt__DeprecatedKt$take$1 channelsKt__DeprecatedKt$take$12;
        ProducerScope producerScope2;
        Object hasNext;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i16 = this.label;
        if (i16 != 0) {
            if (i16 != 1) {
                if (i16 == 2) {
                    i3 = this.I$0;
                    it = (ChannelIterator) this.L$1;
                    ProducerScope producerScope3 = (ProducerScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    producerScope = producerScope3;
                    channelsKt__DeprecatedKt$take$1 = this;
                    i3--;
                    if (i3 == 0) {
                        return Unit.INSTANCE;
                    }
                    channelsKt__DeprecatedKt$take$1.L$0 = producerScope;
                    channelsKt__DeprecatedKt$take$1.L$1 = it;
                    channelsKt__DeprecatedKt$take$1.I$0 = i3;
                    channelsKt__DeprecatedKt$take$1.label = 1;
                    hasNext = it.hasNext(channelsKt__DeprecatedKt$take$1);
                    if (hasNext == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    ChannelsKt__DeprecatedKt$take$1 channelsKt__DeprecatedKt$take$13 = channelsKt__DeprecatedKt$take$1;
                    producerScope2 = producerScope;
                    obj = hasNext;
                    channelsKt__DeprecatedKt$take$12 = channelsKt__DeprecatedKt$take$13;
                    if (!((Boolean) obj).booleanValue()) {
                        Object next = it.next();
                        channelsKt__DeprecatedKt$take$12.L$0 = producerScope2;
                        channelsKt__DeprecatedKt$take$12.L$1 = it;
                        channelsKt__DeprecatedKt$take$12.I$0 = i3;
                        channelsKt__DeprecatedKt$take$12.label = 2;
                        if (producerScope2.send(next, channelsKt__DeprecatedKt$take$12) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        producerScope = producerScope2;
                        channelsKt__DeprecatedKt$take$1 = channelsKt__DeprecatedKt$take$12;
                        i3--;
                        if (i3 == 0) {
                        }
                        channelsKt__DeprecatedKt$take$1.L$0 = producerScope;
                        channelsKt__DeprecatedKt$take$1.L$1 = it;
                        channelsKt__DeprecatedKt$take$1.I$0 = i3;
                        channelsKt__DeprecatedKt$take$1.label = 1;
                        hasNext = it.hasNext(channelsKt__DeprecatedKt$take$1);
                        if (hasNext == coroutine_suspended) {
                        }
                    } else {
                        return Unit.INSTANCE;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                i3 = this.I$0;
                it = (ChannelIterator) this.L$1;
                producerScope2 = (ProducerScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                channelsKt__DeprecatedKt$take$12 = this;
                if (!((Boolean) obj).booleanValue()) {
                }
            }
        } else {
            ResultKt.throwOnFailure(obj);
            producerScope = (ProducerScope) this.L$0;
            i3 = this.$n;
            if (i3 == 0) {
                return Unit.INSTANCE;
            }
            if (i3 >= 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                it = this.$this_take.iterator();
                channelsKt__DeprecatedKt$take$1 = this;
                channelsKt__DeprecatedKt$take$1.L$0 = producerScope;
                channelsKt__DeprecatedKt$take$1.L$1 = it;
                channelsKt__DeprecatedKt$take$1.I$0 = i3;
                channelsKt__DeprecatedKt$take$1.label = 1;
                hasNext = it.hasNext(channelsKt__DeprecatedKt$take$1);
                if (hasNext == coroutine_suspended) {
                }
            } else {
                throw new IllegalArgumentException(("Requested element count " + i3 + " is less than zero.").toString());
            }
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull ProducerScope<Object> producerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ChannelsKt__DeprecatedKt$take$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
