package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001H\u008a@"}, d2 = {"E", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/collections/IndexedValue;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$withIndex$1", f = "Deprecated.kt", i = {0, 0, 1}, l = {313, 314}, m = "invokeSuspend", n = {"$this$produce", "index", "$this$produce"}, s = {"L$0", "I$0", "L$0"})
/* loaded from: classes28.dex */
final class ChannelsKt__DeprecatedKt$withIndex$1 extends SuspendLambda implements Function2<ProducerScope<? super IndexedValue<Object>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ReceiveChannel<Object> $this_withIndex;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelsKt__DeprecatedKt$withIndex$1(ReceiveChannel<Object> receiveChannel, Continuation<? super ChannelsKt__DeprecatedKt$withIndex$1> continuation) {
        super(2, continuation);
        this.$this_withIndex = receiveChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$withIndex$1 channelsKt__DeprecatedKt$withIndex$1 = new ChannelsKt__DeprecatedKt$withIndex$1(this.$this_withIndex, continuation);
        channelsKt__DeprecatedKt$withIndex$1.L$0 = obj;
        return channelsKt__DeprecatedKt$withIndex$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0085  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0080 -> B:6:0x0048). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        ProducerScope producerScope;
        ChannelIterator<Object> it;
        int i3;
        ChannelsKt__DeprecatedKt$withIndex$1 channelsKt__DeprecatedKt$withIndex$1;
        ChannelsKt__DeprecatedKt$withIndex$1 channelsKt__DeprecatedKt$withIndex$12;
        ProducerScope producerScope2;
        ChannelIterator<Object> channelIterator;
        int i16;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i17 = this.label;
        if (i17 != 0) {
            if (i17 != 1) {
                if (i17 == 2) {
                    int i18 = this.I$0;
                    ChannelIterator<Object> channelIterator2 = (ChannelIterator) this.L$1;
                    ProducerScope producerScope3 = (ProducerScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    producerScope = producerScope3;
                    channelsKt__DeprecatedKt$withIndex$1 = this;
                    i3 = i18;
                    it = channelIterator2;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                i16 = this.I$0;
                channelIterator = (ChannelIterator) this.L$1;
                producerScope2 = (ProducerScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                channelsKt__DeprecatedKt$withIndex$12 = this;
                if (!((Boolean) obj).booleanValue()) {
                    int i19 = i16 + 1;
                    IndexedValue indexedValue = new IndexedValue(i16, channelIterator.next());
                    channelsKt__DeprecatedKt$withIndex$12.L$0 = producerScope2;
                    channelsKt__DeprecatedKt$withIndex$12.L$1 = channelIterator;
                    channelsKt__DeprecatedKt$withIndex$12.I$0 = i19;
                    channelsKt__DeprecatedKt$withIndex$12.label = 2;
                    if (producerScope2.send(indexedValue, channelsKt__DeprecatedKt$withIndex$12) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    it = channelIterator;
                    producerScope = producerScope2;
                    channelsKt__DeprecatedKt$withIndex$1 = channelsKt__DeprecatedKt$withIndex$12;
                    i3 = i19;
                } else {
                    return Unit.INSTANCE;
                }
            }
        } else {
            ResultKt.throwOnFailure(obj);
            producerScope = (ProducerScope) this.L$0;
            it = this.$this_withIndex.iterator();
            i3 = 0;
            channelsKt__DeprecatedKt$withIndex$1 = this;
        }
        channelsKt__DeprecatedKt$withIndex$1.L$0 = producerScope;
        channelsKt__DeprecatedKt$withIndex$1.L$1 = it;
        channelsKt__DeprecatedKt$withIndex$1.I$0 = i3;
        channelsKt__DeprecatedKt$withIndex$1.label = 1;
        Object hasNext = it.hasNext(channelsKt__DeprecatedKt$withIndex$1);
        if (hasNext == coroutine_suspended) {
            return coroutine_suspended;
        }
        ChannelsKt__DeprecatedKt$withIndex$1 channelsKt__DeprecatedKt$withIndex$13 = channelsKt__DeprecatedKt$withIndex$1;
        producerScope2 = producerScope;
        obj = hasNext;
        channelsKt__DeprecatedKt$withIndex$12 = channelsKt__DeprecatedKt$withIndex$13;
        int i26 = i3;
        channelIterator = it;
        i16 = i26;
        if (!((Boolean) obj).booleanValue()) {
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull ProducerScope<? super IndexedValue<Object>> producerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ChannelsKt__DeprecatedKt$withIndex$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
