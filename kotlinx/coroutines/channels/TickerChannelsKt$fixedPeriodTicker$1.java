package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.TickerChannelsKt", f = "TickerChannels.kt", i = {0, 1}, l = {84, 88, 94, 96}, m = "fixedPeriodTicker", n = {"deadline", "delayNs"}, s = {"J$1", "J$1"})
/* loaded from: classes28.dex */
public final class TickerChannelsKt$fixedPeriodTicker$1 extends ContinuationImpl {
    long J$0;
    long J$1;
    Object L$0;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TickerChannelsKt$fixedPeriodTicker$1(Continuation<? super TickerChannelsKt$fixedPeriodTicker$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object fixedPeriodTicker;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        fixedPeriodTicker = TickerChannelsKt.fixedPeriodTicker(0L, 0L, null, this);
        return fixedPeriodTicker;
    }
}
