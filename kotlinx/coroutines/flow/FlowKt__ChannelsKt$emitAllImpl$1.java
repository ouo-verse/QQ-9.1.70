package kotlinx.coroutines.flow;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ChannelsKt", f = "Channels.kt", i = {0, 0, 0}, l = {51, 62}, m = "emitAllImpl$FlowKt__ChannelsKt", n = {"$this$emitAllImpl", WadlProxyConsts.CHANNEL, "consume"}, s = {"L$0", "L$1", "Z$0"})
/* loaded from: classes28.dex */
public final class FlowKt__ChannelsKt$emitAllImpl$1<T> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FlowKt__ChannelsKt$emitAllImpl$1(Continuation<? super FlowKt__ChannelsKt$emitAllImpl$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object emitAllImpl$FlowKt__ChannelsKt;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        emitAllImpl$FlowKt__ChannelsKt = FlowKt__ChannelsKt.emitAllImpl$FlowKt__ChannelsKt(null, null, false, this);
        return emitAllImpl$FlowKt__ChannelsKt;
    }
}
