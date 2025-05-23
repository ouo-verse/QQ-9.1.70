package kotlinx.coroutines.channels;

import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.view.FilterEnum;
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
@Metadata(d1 = {"\u0000\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u0002H\u008a@"}, d2 = {"E", BdhLogUtil.LogTag.Tag_Req, "Lkotlinx/coroutines/channels/ProducerScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$flatMap$1", f = "Deprecated.kt", i = {0, 1, 2}, l = {FilterEnum.MIC_PTU_TRANS_ROUHE, FilterEnum.MIC_PTU_TRANS_XINXIAN, FilterEnum.MIC_PTU_TRANS_XINXIAN}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "$this$produce"}, s = {"L$0", "L$0", "L$0"})
/* loaded from: classes28.dex */
final class ChannelsKt__DeprecatedKt$flatMap$1 extends SuspendLambda implements Function2<ProducerScope<Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ReceiveChannel<Object> $this_flatMap;
    final /* synthetic */ Function2<Object, Continuation<? super ReceiveChannel<Object>>, Object> $transform;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelsKt__DeprecatedKt$flatMap$1(ReceiveChannel<Object> receiveChannel, Function2<Object, ? super Continuation<? super ReceiveChannel<Object>>, ? extends Object> function2, Continuation<? super ChannelsKt__DeprecatedKt$flatMap$1> continuation) {
        super(2, continuation);
        this.$this_flatMap = receiveChannel;
        this.$transform = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$flatMap$1 channelsKt__DeprecatedKt$flatMap$1 = new ChannelsKt__DeprecatedKt$flatMap$1(this.$this_flatMap, this.$transform, continuation);
        channelsKt__DeprecatedKt$flatMap$1.L$0 = obj;
        return channelsKt__DeprecatedKt$flatMap$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0061 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0091 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0097  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0092 -> B:8:0x0055). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        ChannelIterator<Object> it;
        ProducerScope producerScope;
        ProducerScope producerScope2;
        ChannelIterator<Object> channelIterator;
        Object obj2;
        ChannelsKt__DeprecatedKt$flatMap$1 channelsKt__DeprecatedKt$flatMap$1;
        ChannelsKt__DeprecatedKt$flatMap$1 channelsKt__DeprecatedKt$flatMap$12;
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
                    ChannelIterator<Object> channelIterator2 = (ChannelIterator) this.L$1;
                    ProducerScope producerScope3 = (ProducerScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    producerScope2 = producerScope3;
                    channelIterator = channelIterator2;
                    obj2 = coroutine_suspended;
                    channelsKt__DeprecatedKt$flatMap$1 = this;
                    channelsKt__DeprecatedKt$flatMap$1.L$0 = producerScope2;
                    channelsKt__DeprecatedKt$flatMap$1.L$1 = channelIterator;
                    channelsKt__DeprecatedKt$flatMap$1.label = 3;
                    if (ChannelsKt.toChannel((ReceiveChannel) obj, producerScope2, channelsKt__DeprecatedKt$flatMap$1) != obj2) {
                        return obj2;
                    }
                    channelsKt__DeprecatedKt$flatMap$12 = channelsKt__DeprecatedKt$flatMap$1;
                    coroutine_suspended = obj2;
                    it = channelIterator;
                    producerScope = producerScope2;
                    channelsKt__DeprecatedKt$flatMap$12.L$0 = producerScope;
                    channelsKt__DeprecatedKt$flatMap$12.L$1 = it;
                    channelsKt__DeprecatedKt$flatMap$12.label = 1;
                    hasNext = it.hasNext(channelsKt__DeprecatedKt$flatMap$12);
                    if (hasNext != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    Object obj3 = coroutine_suspended;
                    channelsKt__DeprecatedKt$flatMap$1 = channelsKt__DeprecatedKt$flatMap$12;
                    obj = hasNext;
                    producerScope2 = producerScope;
                    channelIterator = it;
                    obj2 = obj3;
                    if (!((Boolean) obj).booleanValue()) {
                        Object next = channelIterator.next();
                        Function2<Object, Continuation<? super ReceiveChannel<Object>>, Object> function2 = channelsKt__DeprecatedKt$flatMap$1.$transform;
                        channelsKt__DeprecatedKt$flatMap$1.L$0 = producerScope2;
                        channelsKt__DeprecatedKt$flatMap$1.L$1 = channelIterator;
                        channelsKt__DeprecatedKt$flatMap$1.label = 2;
                        obj = function2.invoke(next, channelsKt__DeprecatedKt$flatMap$1);
                        if (obj == obj2) {
                            return obj2;
                        }
                        channelsKt__DeprecatedKt$flatMap$1.L$0 = producerScope2;
                        channelsKt__DeprecatedKt$flatMap$1.L$1 = channelIterator;
                        channelsKt__DeprecatedKt$flatMap$1.label = 3;
                        if (ChannelsKt.toChannel((ReceiveChannel) obj, producerScope2, channelsKt__DeprecatedKt$flatMap$1) != obj2) {
                        }
                    } else {
                        return Unit.INSTANCE;
                    }
                }
            } else {
                ChannelIterator<Object> channelIterator3 = (ChannelIterator) this.L$1;
                ProducerScope producerScope4 = (ProducerScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                producerScope2 = producerScope4;
                channelIterator = channelIterator3;
                obj2 = coroutine_suspended;
                channelsKt__DeprecatedKt$flatMap$1 = this;
                if (!((Boolean) obj).booleanValue()) {
                }
            }
        } else {
            ResultKt.throwOnFailure(obj);
            ProducerScope producerScope5 = (ProducerScope) this.L$0;
            it = this.$this_flatMap.iterator();
            producerScope = producerScope5;
        }
        channelsKt__DeprecatedKt$flatMap$12 = this;
        channelsKt__DeprecatedKt$flatMap$12.L$0 = producerScope;
        channelsKt__DeprecatedKt$flatMap$12.L$1 = it;
        channelsKt__DeprecatedKt$flatMap$12.label = 1;
        hasNext = it.hasNext(channelsKt__DeprecatedKt$flatMap$12);
        if (hasNext != coroutine_suspended) {
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull ProducerScope<Object> producerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ChannelsKt__DeprecatedKt$flatMap$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
