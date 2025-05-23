package kotlinx.coroutines.channels;

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
@DebugMetadata(c = "kotlinx.coroutines.channels.TickerChannelsKt", f = "TickerChannels.kt", i = {0, 0, 1, 1, 2, 2}, l = {106, 108, 109}, m = "fixedDelayTicker", n = {WadlProxyConsts.CHANNEL, "delayMillis", WadlProxyConsts.CHANNEL, "delayMillis", WadlProxyConsts.CHANNEL, "delayMillis"}, s = {"L$0", "J$0", "L$0", "J$0", "L$0", "J$0"})
/* loaded from: classes28.dex */
public final class TickerChannelsKt$fixedDelayTicker$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TickerChannelsKt$fixedDelayTicker$1(Continuation<? super TickerChannelsKt$fixedDelayTicker$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object fixedDelayTicker;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        fixedDelayTicker = TickerChannelsKt.fixedDelayTicker(0L, 0L, null, this);
        return fixedDelayTicker;
    }
}
