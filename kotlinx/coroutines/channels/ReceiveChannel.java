package kotlinx.coroutines.channels;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectInstance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0017J\u0014\u0010\u0014\u001a\u00020\u00042\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017H'J\u001a\u0010\u0014\u001a\u00020\u00152\u0010\b\u0002\u0010\u0016\u001a\n\u0018\u00010\u0018j\u0004\u0018\u0001`\u0019H&J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bH\u00a6\u0002J\u000f\u0010\u001c\u001a\u0004\u0018\u00018\u0000H\u0017\u00a2\u0006\u0002\u0010\u001dJ\u0011\u0010\u001e\u001a\u00028\u0000H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001fJ\"\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u00a6@\u00f8\u0001\u0000\u00f8\u0001\u0000\u00f8\u0001\u0001\u00f8\u0001\u0002\u00a2\u0006\u0004\b!\u0010\u001fJ\u0013\u0010\"\u001a\u0004\u0018\u00018\u0000H\u0097@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001fJ\u001e\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH&\u00f8\u0001\u0000\u00f8\u0001\u0001\u00f8\u0001\u0002\u00a2\u0006\u0004\b$\u0010\u001dR\u001a\u0010\u0003\u001a\u00020\u00048&X\u00a7\u0004\u00a2\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0007R\u001a\u0010\b\u001a\u00020\u00048&X\u00a7\u0004\u00a2\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0007R\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR!\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f0\u000bX\u00a6\u0004\u00f8\u0001\u0000\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\rR\"\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u000b8VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u0013\u0010\r\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006%"}, d2 = {"Lkotlinx/coroutines/channels/ReceiveChannel;", "E", "", "isClosedForReceive", "", "isClosedForReceive$annotations", "()V", "()Z", "isEmpty", "isEmpty$annotations", "onReceive", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnReceive", "()Lkotlinx/coroutines/selects/SelectClause1;", "onReceiveCatching", "Lkotlinx/coroutines/channels/ChannelResult;", "getOnReceiveCatching", "onReceiveOrNull", "getOnReceiveOrNull$annotations", "getOnReceiveOrNull", "cancel", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "iterator", "Lkotlinx/coroutines/channels/ChannelIterator;", "poll", "()Ljava/lang/Object;", "receive", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveCatching", "receiveCatching-JP2dKIU", "receiveOrNull", "tryReceive", "tryReceive-PtdJZtk", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public interface ReceiveChannel<E> {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes28.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void cancel$default(ReceiveChannel receiveChannel, CancellationException cancellationException, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i3 & 1) != 0) {
                cancellationException = null;
            }
            receiveChannel.cancel(cancellationException);
        }

        @NotNull
        public static <E> SelectClause1<E> getOnReceiveOrNull(@NotNull final ReceiveChannel<? extends E> receiveChannel) {
            return new SelectClause1<E>() { // from class: kotlinx.coroutines.channels.ReceiveChannel$onReceiveOrNull$1
                @Override // kotlinx.coroutines.selects.SelectClause1
                @InternalCoroutinesApi
                public <R> void registerSelectClause1(@NotNull SelectInstance<? super R> select, @NotNull Function2<? super E, ? super Continuation<? super R>, ? extends Object> block) {
                    receiveChannel.getOnReceiveCatching().registerSelectClause1(select, new ReceiveChannel$onReceiveOrNull$1$registerSelectClause1$1(block, null));
                }
            };
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith = @ReplaceWith(expression = "tryReceive().getOrNull()", imports = {}))
        @Nullable
        public static <E> E poll(@NotNull ReceiveChannel<? extends E> receiveChannel) {
            Object mo2002tryReceivePtdJZtk = receiveChannel.mo2002tryReceivePtdJZtk();
            if (ChannelResult.m2018isSuccessimpl(mo2002tryReceivePtdJZtk)) {
                return (E) ChannelResult.m2014getOrThrowimpl(mo2002tryReceivePtdJZtk);
            }
            Throwable m2012exceptionOrNullimpl = ChannelResult.m2012exceptionOrNullimpl(mo2002tryReceivePtdJZtk);
            if (m2012exceptionOrNullimpl == null) {
                return null;
            }
            throw StackTraceRecoveryKt.recoverStackTrace(m2012exceptionOrNullimpl);
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0038  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
        @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @ReplaceWith(expression = "receiveCatching().getOrNull()", imports = {}))
        @LowPriorityInOverloadResolution
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static <E> Object receiveOrNull(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull Continuation<? super E> continuation) {
            ReceiveChannel$receiveOrNull$1 receiveChannel$receiveOrNull$1;
            int i3;
            Object mo2001receiveCatchingJP2dKIU;
            if (continuation instanceof ReceiveChannel$receiveOrNull$1) {
                receiveChannel$receiveOrNull$1 = (ReceiveChannel$receiveOrNull$1) continuation;
                int i16 = receiveChannel$receiveOrNull$1.label;
                if ((i16 & Integer.MIN_VALUE) != 0) {
                    receiveChannel$receiveOrNull$1.label = i16 - Integer.MIN_VALUE;
                    Object obj = receiveChannel$receiveOrNull$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = receiveChannel$receiveOrNull$1.label;
                    if (i3 == 0) {
                        if (i3 == 1) {
                            ResultKt.throwOnFailure(obj);
                            mo2001receiveCatchingJP2dKIU = ((ChannelResult) obj).getHolder();
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        receiveChannel$receiveOrNull$1.label = 1;
                        mo2001receiveCatchingJP2dKIU = receiveChannel.mo2001receiveCatchingJP2dKIU(receiveChannel$receiveOrNull$1);
                        if (mo2001receiveCatchingJP2dKIU == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return ChannelResult.m2013getOrNullimpl(mo2001receiveCatchingJP2dKIU);
                }
            }
            receiveChannel$receiveOrNull$1 = new ReceiveChannel$receiveOrNull$1(continuation);
            Object obj2 = receiveChannel$receiveOrNull$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i3 = receiveChannel$receiveOrNull$1.label;
            if (i3 == 0) {
            }
            return ChannelResult.m2013getOrNullimpl(mo2001receiveCatchingJP2dKIU);
        }

        public static /* synthetic */ boolean cancel$default(ReceiveChannel receiveChannel, Throwable th5, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i3 & 1) != 0) {
                th5 = null;
            }
            return receiveChannel.cancel(th5);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in favor of onReceiveCatching extension", replaceWith = @ReplaceWith(expression = "onReceiveCatching", imports = {}))
        public static /* synthetic */ void getOnReceiveOrNull$annotations() {
        }

        @ExperimentalCoroutinesApi
        public static /* synthetic */ void isClosedForReceive$annotations() {
        }

        @ExperimentalCoroutinesApi
        public static /* synthetic */ void isEmpty$annotations() {
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* synthetic */ void cancel();

    void cancel(@Nullable CancellationException cause);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* synthetic */ boolean cancel(Throwable cause);

    @NotNull
    SelectClause1<E> getOnReceive();

    @NotNull
    SelectClause1<ChannelResult<E>> getOnReceiveCatching();

    @NotNull
    SelectClause1<E> getOnReceiveOrNull();

    boolean isClosedForReceive();

    boolean isEmpty();

    @NotNull
    ChannelIterator<E> iterator();

    @Deprecated(level = DeprecationLevel.WARNING, message = "Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith = @ReplaceWith(expression = "tryReceive().getOrNull()", imports = {}))
    @Nullable
    E poll();

    @Nullable
    Object receive(@NotNull Continuation<? super E> continuation);

    @Nullable
    /* renamed from: receiveCatching-JP2dKIU */
    Object mo2001receiveCatchingJP2dKIU(@NotNull Continuation<? super ChannelResult<? extends E>> continuation);

    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @ReplaceWith(expression = "receiveCatching().getOrNull()", imports = {}))
    @LowPriorityInOverloadResolution
    @Nullable
    Object receiveOrNull(@NotNull Continuation<? super E> continuation);

    @NotNull
    /* renamed from: tryReceive-PtdJZtk */
    Object mo2002tryReceivePtdJZtk();
}
