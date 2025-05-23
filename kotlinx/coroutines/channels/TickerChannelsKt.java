package kotlinx.coroutines.channels;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.AbstractTimeSource;
import kotlinx.coroutines.AbstractTimeSourceKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.EventLoop_commonKt;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.ObsoleteCoroutinesApi;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a/\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007\u001a/\u0010\b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007\u001a4\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2 = {"fixedDelayTicker", "", "delayMillis", "", "initialDelayMillis", WadlProxyConsts.CHANNEL, "Lkotlinx/coroutines/channels/SendChannel;", "(JJLkotlinx/coroutines/channels/SendChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fixedPeriodTicker", RemoteMessageConst.Notification.TICKER, "Lkotlinx/coroutines/channels/ReceiveChannel;", "context", "Lkotlin/coroutines/CoroutineContext;", "mode", "Lkotlinx/coroutines/channels/TickerMode;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class TickerChannelsKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0072 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0080 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x007e -> B:12:0x0034). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object fixedDelayTicker(long j3, long j16, SendChannel<? super Unit> sendChannel, Continuation<? super Unit> continuation) {
        TickerChannelsKt$fixedDelayTicker$1 tickerChannelsKt$fixedDelayTicker$1;
        Object coroutine_suspended;
        int i3;
        SendChannel<? super Unit> sendChannel2;
        Unit unit;
        if (continuation instanceof TickerChannelsKt$fixedDelayTicker$1) {
            tickerChannelsKt$fixedDelayTicker$1 = (TickerChannelsKt$fixedDelayTicker$1) continuation;
            int i16 = tickerChannelsKt$fixedDelayTicker$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                tickerChannelsKt$fixedDelayTicker$1.label = i16 - Integer.MIN_VALUE;
                Object obj = tickerChannelsKt$fixedDelayTicker$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = tickerChannelsKt$fixedDelayTicker$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 == 3) {
                                j3 = tickerChannelsKt$fixedDelayTicker$1.J$0;
                                sendChannel2 = (SendChannel) tickerChannelsKt$fixedDelayTicker$1.L$0;
                                ResultKt.throwOnFailure(obj);
                                sendChannel = sendChannel2;
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            j3 = tickerChannelsKt$fixedDelayTicker$1.J$0;
                            sendChannel2 = (SendChannel) tickerChannelsKt$fixedDelayTicker$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            tickerChannelsKt$fixedDelayTicker$1.L$0 = sendChannel2;
                            tickerChannelsKt$fixedDelayTicker$1.J$0 = j3;
                            tickerChannelsKt$fixedDelayTicker$1.label = 3;
                            if (DelayKt.delay(j3, tickerChannelsKt$fixedDelayTicker$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            sendChannel = sendChannel2;
                        }
                    } else {
                        j3 = tickerChannelsKt$fixedDelayTicker$1.J$0;
                        sendChannel = (SendChannel) tickerChannelsKt$fixedDelayTicker$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    tickerChannelsKt$fixedDelayTicker$1.L$0 = sendChannel;
                    tickerChannelsKt$fixedDelayTicker$1.J$0 = j3;
                    tickerChannelsKt$fixedDelayTicker$1.label = 1;
                    if (DelayKt.delay(j16, tickerChannelsKt$fixedDelayTicker$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                unit = Unit.INSTANCE;
                tickerChannelsKt$fixedDelayTicker$1.L$0 = sendChannel;
                tickerChannelsKt$fixedDelayTicker$1.J$0 = j3;
                tickerChannelsKt$fixedDelayTicker$1.label = 2;
                if (sendChannel.send(unit, tickerChannelsKt$fixedDelayTicker$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                sendChannel2 = sendChannel;
                tickerChannelsKt$fixedDelayTicker$1.L$0 = sendChannel2;
                tickerChannelsKt$fixedDelayTicker$1.J$0 = j3;
                tickerChannelsKt$fixedDelayTicker$1.label = 3;
                if (DelayKt.delay(j3, tickerChannelsKt$fixedDelayTicker$1) == coroutine_suspended) {
                }
                sendChannel = sendChannel2;
                unit = Unit.INSTANCE;
                tickerChannelsKt$fixedDelayTicker$1.L$0 = sendChannel;
                tickerChannelsKt$fixedDelayTicker$1.J$0 = j3;
                tickerChannelsKt$fixedDelayTicker$1.label = 2;
                if (sendChannel.send(unit, tickerChannelsKt$fixedDelayTicker$1) == coroutine_suspended) {
                }
            }
        }
        tickerChannelsKt$fixedDelayTicker$1 = new TickerChannelsKt$fixedDelayTicker$1(continuation);
        Object obj2 = tickerChannelsKt$fixedDelayTicker$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = tickerChannelsKt$fixedDelayTicker$1.label;
        if (i3 == 0) {
        }
        unit = Unit.INSTANCE;
        tickerChannelsKt$fixedDelayTicker$1.L$0 = sendChannel;
        tickerChannelsKt$fixedDelayTicker$1.J$0 = j3;
        tickerChannelsKt$fixedDelayTicker$1.label = 2;
        if (sendChannel.send(unit, tickerChannelsKt$fixedDelayTicker$1) == coroutine_suspended) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00bc A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0115 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00fd -> B:15:0x00ab). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0113 -> B:13:0x003d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object fixedPeriodTicker(long j3, long j16, SendChannel<? super Unit> sendChannel, Continuation<? super Unit> continuation) {
        TickerChannelsKt$fixedPeriodTicker$1 tickerChannelsKt$fixedPeriodTicker$1;
        Object coroutine_suspended;
        int i3;
        long nanoTime;
        SendChannel sendChannel2;
        long j17;
        long j18;
        long delayToNanos;
        long j19;
        long j26;
        SendChannel sendChannel3;
        char c16;
        long j27;
        AbstractTimeSource timeSource;
        long nanoTime2;
        long coerceAtLeast;
        char c17;
        long delayNanosToMillis;
        char c18;
        Unit unit;
        if (continuation instanceof TickerChannelsKt$fixedPeriodTicker$1) {
            tickerChannelsKt$fixedPeriodTicker$1 = (TickerChannelsKt$fixedPeriodTicker$1) continuation;
            int i16 = tickerChannelsKt$fixedPeriodTicker$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                tickerChannelsKt$fixedPeriodTicker$1.label = i16 - Integer.MIN_VALUE;
                Object obj = tickerChannelsKt$fixedPeriodTicker$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = tickerChannelsKt$fixedPeriodTicker$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 != 3) {
                                if (i3 == 4) {
                                    j26 = tickerChannelsKt$fixedPeriodTicker$1.J$1;
                                    j27 = tickerChannelsKt$fixedPeriodTicker$1.J$0;
                                    sendChannel3 = (SendChannel) tickerChannelsKt$fixedPeriodTicker$1.L$0;
                                    ResultKt.throwOnFailure(obj);
                                    c18 = 4;
                                    c17 = 3;
                                    long j28 = j26;
                                    j18 = j27;
                                    delayToNanos = j28;
                                    sendChannel2 = sendChannel3;
                                    long j29 = j18 + delayToNanos;
                                    unit = Unit.INSTANCE;
                                    tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel2;
                                    tickerChannelsKt$fixedPeriodTicker$1.J$0 = j29;
                                    tickerChannelsKt$fixedPeriodTicker$1.J$1 = delayToNanos;
                                    tickerChannelsKt$fixedPeriodTicker$1.label = 2;
                                    if (sendChannel2.send(unit, tickerChannelsKt$fixedPeriodTicker$1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    sendChannel3 = sendChannel2;
                                    j26 = delayToNanos;
                                    j27 = j29;
                                    timeSource = AbstractTimeSourceKt.getTimeSource();
                                    if (timeSource != null) {
                                        nanoTime2 = System.nanoTime();
                                    } else {
                                        nanoTime2 = timeSource.nanoTime();
                                    }
                                    coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(j27 - nanoTime2, 0L);
                                    if (coerceAtLeast != 0 && j26 != 0) {
                                        long j36 = j26 - ((nanoTime2 - j27) % j26);
                                        j19 = nanoTime2 + j36;
                                        long delayNanosToMillis2 = EventLoop_commonKt.delayNanosToMillis(j36);
                                        tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel3;
                                        tickerChannelsKt$fixedPeriodTicker$1.J$0 = j19;
                                        tickerChannelsKt$fixedPeriodTicker$1.J$1 = j26;
                                        c16 = 3;
                                        tickerChannelsKt$fixedPeriodTicker$1.label = 3;
                                        if (DelayKt.delay(delayNanosToMillis2, tickerChannelsKt$fixedPeriodTicker$1) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        long j37 = j26;
                                        j18 = j19;
                                        delayToNanos = j37;
                                        sendChannel2 = sendChannel3;
                                        long j292 = j18 + delayToNanos;
                                        unit = Unit.INSTANCE;
                                        tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel2;
                                        tickerChannelsKt$fixedPeriodTicker$1.J$0 = j292;
                                        tickerChannelsKt$fixedPeriodTicker$1.J$1 = delayToNanos;
                                        tickerChannelsKt$fixedPeriodTicker$1.label = 2;
                                        if (sendChannel2.send(unit, tickerChannelsKt$fixedPeriodTicker$1) == coroutine_suspended) {
                                        }
                                    } else {
                                        c17 = 3;
                                        delayNanosToMillis = EventLoop_commonKt.delayNanosToMillis(coerceAtLeast);
                                        tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel3;
                                        tickerChannelsKt$fixedPeriodTicker$1.J$0 = j27;
                                        tickerChannelsKt$fixedPeriodTicker$1.J$1 = j26;
                                        c18 = 4;
                                        tickerChannelsKt$fixedPeriodTicker$1.label = 4;
                                        if (DelayKt.delay(delayNanosToMillis, tickerChannelsKt$fixedPeriodTicker$1) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        long j282 = j26;
                                        j18 = j27;
                                        delayToNanos = j282;
                                        sendChannel2 = sendChannel3;
                                        long j2922 = j18 + delayToNanos;
                                        unit = Unit.INSTANCE;
                                        tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel2;
                                        tickerChannelsKt$fixedPeriodTicker$1.J$0 = j2922;
                                        tickerChannelsKt$fixedPeriodTicker$1.J$1 = delayToNanos;
                                        tickerChannelsKt$fixedPeriodTicker$1.label = 2;
                                        if (sendChannel2.send(unit, tickerChannelsKt$fixedPeriodTicker$1) == coroutine_suspended) {
                                        }
                                    }
                                } else {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                            } else {
                                j26 = tickerChannelsKt$fixedPeriodTicker$1.J$1;
                                j19 = tickerChannelsKt$fixedPeriodTicker$1.J$0;
                                sendChannel3 = (SendChannel) tickerChannelsKt$fixedPeriodTicker$1.L$0;
                                ResultKt.throwOnFailure(obj);
                                c16 = 3;
                                long j372 = j26;
                                j18 = j19;
                                delayToNanos = j372;
                                sendChannel2 = sendChannel3;
                                long j29222 = j18 + delayToNanos;
                                unit = Unit.INSTANCE;
                                tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel2;
                                tickerChannelsKt$fixedPeriodTicker$1.J$0 = j29222;
                                tickerChannelsKt$fixedPeriodTicker$1.J$1 = delayToNanos;
                                tickerChannelsKt$fixedPeriodTicker$1.label = 2;
                                if (sendChannel2.send(unit, tickerChannelsKt$fixedPeriodTicker$1) == coroutine_suspended) {
                                }
                            }
                        } else {
                            j26 = tickerChannelsKt$fixedPeriodTicker$1.J$1;
                            j27 = tickerChannelsKt$fixedPeriodTicker$1.J$0;
                            sendChannel3 = (SendChannel) tickerChannelsKt$fixedPeriodTicker$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            timeSource = AbstractTimeSourceKt.getTimeSource();
                            if (timeSource != null) {
                            }
                            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(j27 - nanoTime2, 0L);
                            if (coerceAtLeast != 0) {
                            }
                            c17 = 3;
                            delayNanosToMillis = EventLoop_commonKt.delayNanosToMillis(coerceAtLeast);
                            tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel3;
                            tickerChannelsKt$fixedPeriodTicker$1.J$0 = j27;
                            tickerChannelsKt$fixedPeriodTicker$1.J$1 = j26;
                            c18 = 4;
                            tickerChannelsKt$fixedPeriodTicker$1.label = 4;
                            if (DelayKt.delay(delayNanosToMillis, tickerChannelsKt$fixedPeriodTicker$1) == coroutine_suspended) {
                            }
                            long j2822 = j26;
                            j18 = j27;
                            delayToNanos = j2822;
                            sendChannel2 = sendChannel3;
                            long j292222 = j18 + delayToNanos;
                            unit = Unit.INSTANCE;
                            tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel2;
                            tickerChannelsKt$fixedPeriodTicker$1.J$0 = j292222;
                            tickerChannelsKt$fixedPeriodTicker$1.J$1 = delayToNanos;
                            tickerChannelsKt$fixedPeriodTicker$1.label = 2;
                            if (sendChannel2.send(unit, tickerChannelsKt$fixedPeriodTicker$1) == coroutine_suspended) {
                            }
                        }
                    } else {
                        j18 = tickerChannelsKt$fixedPeriodTicker$1.J$1;
                        long j38 = tickerChannelsKt$fixedPeriodTicker$1.J$0;
                        SendChannel sendChannel4 = (SendChannel) tickerChannelsKt$fixedPeriodTicker$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        sendChannel2 = sendChannel4;
                        j17 = j38;
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    AbstractTimeSource timeSource2 = AbstractTimeSourceKt.getTimeSource();
                    if (timeSource2 == null) {
                        nanoTime = System.nanoTime();
                    } else {
                        nanoTime = timeSource2.nanoTime();
                    }
                    long delayToNanos2 = nanoTime + EventLoop_commonKt.delayToNanos(j16);
                    sendChannel2 = sendChannel;
                    tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel2;
                    j17 = j3;
                    tickerChannelsKt$fixedPeriodTicker$1.J$0 = j17;
                    tickerChannelsKt$fixedPeriodTicker$1.J$1 = delayToNanos2;
                    tickerChannelsKt$fixedPeriodTicker$1.label = 1;
                    if (DelayKt.delay(j16, tickerChannelsKt$fixedPeriodTicker$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    j18 = delayToNanos2;
                }
                delayToNanos = EventLoop_commonKt.delayToNanos(j17);
                long j2922222 = j18 + delayToNanos;
                unit = Unit.INSTANCE;
                tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel2;
                tickerChannelsKt$fixedPeriodTicker$1.J$0 = j2922222;
                tickerChannelsKt$fixedPeriodTicker$1.J$1 = delayToNanos;
                tickerChannelsKt$fixedPeriodTicker$1.label = 2;
                if (sendChannel2.send(unit, tickerChannelsKt$fixedPeriodTicker$1) == coroutine_suspended) {
                }
            }
        }
        tickerChannelsKt$fixedPeriodTicker$1 = new TickerChannelsKt$fixedPeriodTicker$1(continuation);
        Object obj2 = tickerChannelsKt$fixedPeriodTicker$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = tickerChannelsKt$fixedPeriodTicker$1.label;
        if (i3 == 0) {
        }
        delayToNanos = EventLoop_commonKt.delayToNanos(j17);
        long j29222222 = j18 + delayToNanos;
        unit = Unit.INSTANCE;
        tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel2;
        tickerChannelsKt$fixedPeriodTicker$1.J$0 = j29222222;
        tickerChannelsKt$fixedPeriodTicker$1.J$1 = delayToNanos;
        tickerChannelsKt$fixedPeriodTicker$1.label = 2;
        if (sendChannel2.send(unit, tickerChannelsKt$fixedPeriodTicker$1) == coroutine_suspended) {
        }
    }

    @ObsoleteCoroutinesApi
    @NotNull
    public static final ReceiveChannel<Unit> ticker(long j3, long j16, @NotNull CoroutineContext coroutineContext, @NotNull TickerMode tickerMode) {
        boolean z16;
        boolean z17 = true;
        if (j3 >= 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (j16 < 0) {
                z17 = false;
            }
            if (z17) {
                return ProduceKt.produce(GlobalScope.INSTANCE, Dispatchers.getUnconfined().plus(coroutineContext), 0, new TickerChannelsKt$ticker$3(tickerMode, j3, j16, null));
            }
            throw new IllegalArgumentException(("Expected non-negative initial delay, but has " + j16 + " ms").toString());
        }
        throw new IllegalArgumentException(("Expected non-negative delay, but has " + j3 + " ms").toString());
    }

    public static /* synthetic */ ReceiveChannel ticker$default(long j3, long j16, CoroutineContext coroutineContext, TickerMode tickerMode, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            j16 = j3;
        }
        if ((i3 & 4) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i3 & 8) != 0) {
            tickerMode = TickerMode.FIXED_PERIOD;
        }
        return ticker(j3, j16, coroutineContext, tickerMode);
    }
}
