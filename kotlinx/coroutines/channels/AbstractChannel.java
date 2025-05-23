package kotlinx.coroutines.channels;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.tritonaudio.webaudio.AudioContext;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BeforeResumeCancelHandler;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.InlineList;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.LockFreeLinkedList_commonKt;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0007STUVWXYB'\u0012 \u0010\u0004\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0007\u00a2\u0006\u0002\u0010\bJ\u0012\u0010\u0019\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0007J\u0016\u0010\u0019\u001a\u00020\u00062\u000e\u0010\u001a\u001a\n\u0018\u00010\u001cj\u0004\u0018\u0001`\u001dJ\u0017\u0010\u001e\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0000\u00a2\u0006\u0002\b\u001fJ\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000!H\u0004J\u0016\u0010\"\u001a\u00020\n2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000$H\u0002J\u0016\u0010%\u001a\u00020\n2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000$H\u0014JR\u0010&\u001a\u00020\n\"\u0004\b\u0001\u0010'2\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H'0)2$\u0010*\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010,\u0012\n\u0012\b\u0012\u0004\u0012\u0002H'0-\u0012\u0006\u0012\u0004\u0018\u00010,0+2\u0006\u0010.\u001a\u00020/H\u0002\u00f8\u0001\u0000\u00a2\u0006\u0002\u00100J\u000f\u00101\u001a\b\u0012\u0004\u0012\u00028\u000002H\u0086\u0002J\u0010\u00103\u001a\u00020\u00062\u0006\u00104\u001a\u00020\nH\u0014J/\u00105\u001a\u00020\u00062\f\u00106\u001a\b\u0012\u0004\u0012\u000208072\n\u00109\u001a\u0006\u0012\u0002\b\u00030:H\u0014\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b;\u0010<J\b\u0010=\u001a\u00020\u0006H\u0014J\b\u0010>\u001a\u00020\u0006H\u0014J\n\u0010?\u001a\u0004\u0018\u00010,H\u0014J\u0016\u0010@\u001a\u0004\u0018\u00010,2\n\u0010(\u001a\u0006\u0012\u0002\b\u00030)H\u0014J\u0011\u0010#\u001a\u00028\u0000H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010AJ\"\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0000\u00f8\u0001\u0002\u00f8\u0001\u0001\u00a2\u0006\u0004\bC\u0010AJ\u001f\u0010D\u001a\u0002H'\"\u0004\b\u0001\u0010'2\u0006\u0010.\u001a\u00020/H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010EJR\u0010F\u001a\u00020\u0006\"\u0004\b\u0001\u0010'2\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H'0)2\u0006\u0010.\u001a\u00020/2$\u0010*\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010,\u0012\n\u0012\b\u0012\u0004\u0012\u0002H'0-\u0012\u0006\u0012\u0004\u0018\u00010,0+H\u0002\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010GJ \u0010H\u001a\u00020\u00062\n\u0010I\u001a\u0006\u0012\u0002\b\u00030J2\n\u0010#\u001a\u0006\u0012\u0002\b\u00030$H\u0002J\u0010\u0010K\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010LH\u0014J\u001c\u0010M\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017\u00f8\u0001\u0000\u00f8\u0001\u0002\u00f8\u0001\u0001\u00a2\u0006\u0004\bN\u0010OJX\u0010P\u001a\u00020\u0006\"\u0004\b\u0001\u0010'* \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010,\u0012\n\u0012\b\u0012\u0004\u0012\u0002H'0-\u0012\u0006\u0012\u0004\u0018\u00010,0+2\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H'0)2\u0006\u0010.\u001a\u00020/2\b\u0010Q\u001a\u0004\u0018\u00010,H\u0002\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010RR\u0014\u0010\t\u001a\u00020\n8DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0012\u0010\r\u001a\u00020\nX\u00a4\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\fR\u0012\u0010\u000e\u001a\u00020\nX\u00a4\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\fR\u0014\u0010\u0010\u001a\u00020\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\fR\u0014\u0010\u0011\u001a\u00020\n8DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\fR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00138F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00170\u00138F\u00f8\u0001\u0000\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0015\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b\u00a1\u001e0\u0001\n\u0002\b!\u00a8\u0006Z"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel;", "E", "Lkotlinx/coroutines/channels/AbstractSendChannel;", "Lkotlinx/coroutines/channels/Channel;", "onUndeliveredElement", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "(Lkotlin/jvm/functions/Function1;)V", "hasReceiveOrClosed", "", "getHasReceiveOrClosed", "()Z", "isBufferAlwaysEmpty", "isBufferEmpty", "isClosedForReceive", "isEmpty", "isEmptyImpl", "onReceive", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnReceive", "()Lkotlinx/coroutines/selects/SelectClause1;", "onReceiveCatching", "Lkotlinx/coroutines/channels/ChannelResult;", "getOnReceiveCatching", "cancel", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cancelInternal", "cancelInternal$kotlinx_coroutines_core", "describeTryPoll", "Lkotlinx/coroutines/channels/AbstractChannel$TryPollDesc;", "enqueueReceive", "receive", "Lkotlinx/coroutines/channels/Receive;", "enqueueReceiveInternal", "enqueueReceiveSelect", BdhLogUtil.LogTag.Tag_Req, "select", "Lkotlinx/coroutines/selects/SelectInstance;", "block", "Lkotlin/Function2;", "", "Lkotlin/coroutines/Continuation;", "receiveMode", "", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;I)Z", "iterator", "Lkotlinx/coroutines/channels/ChannelIterator;", "onCancelIdempotent", "wasClosed", "onCancelIdempotentList", "list", "Lkotlinx/coroutines/internal/InlineList;", "Lkotlinx/coroutines/channels/Send;", AudioContext.State.CLOSED, "Lkotlinx/coroutines/channels/Closed;", "onCancelIdempotentList-w-w6eGU", "(Ljava/lang/Object;Lkotlinx/coroutines/channels/Closed;)V", "onReceiveDequeued", "onReceiveEnqueued", "pollInternal", "pollSelectInternal", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveCatching", "receiveCatching-JP2dKIU", "receiveSuspend", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerSelectReceiveMode", "(Lkotlinx/coroutines/selects/SelectInstance;ILkotlin/jvm/functions/Function2;)V", "removeReceiveOnCancel", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "takeFirstReceiveOrPeekClosed", "Lkotlinx/coroutines/channels/ReceiveOrClosed;", "tryReceive", "tryReceive-PtdJZtk", "()Ljava/lang/Object;", "tryStartBlockUnintercepted", "value", "(Lkotlin/jvm/functions/Function2;Lkotlinx/coroutines/selects/SelectInstance;ILjava/lang/Object;)V", "Itr", "ReceiveElement", "ReceiveElementWithUndeliveredHandler", "ReceiveHasNext", "ReceiveSelect", "RemoveReceiveOnCancel", "TryPollDesc", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public abstract class AbstractChannel<E> extends AbstractSendChannel<E> implements Channel<E> {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\u00a2\u0006\u0002\u0010\u0005J\u0011\u0010\f\u001a\u00020\rH\u0096B\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u0012\u0010\u000f\u001a\u00020\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0011\u0010\u0010\u001a\u00020\rH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u000e\u0010\u0011\u001a\u00028\u0001H\u0096\u0002\u00a2\u0006\u0002\u0010\tR\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$Itr;", "E", "Lkotlinx/coroutines/channels/ChannelIterator;", WadlProxyConsts.CHANNEL, "Lkotlinx/coroutines/channels/AbstractChannel;", "(Lkotlinx/coroutines/channels/AbstractChannel;)V", "result", "", "getResult", "()Ljava/lang/Object;", "setResult", "(Ljava/lang/Object;)V", "hasNext", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasNextResult", "hasNextSuspend", "next", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes28.dex */
    public static final class Itr<E> implements ChannelIterator<E> {

        @JvmField
        @NotNull
        public final AbstractChannel<E> channel;

        @Nullable
        private Object result = AbstractChannelKt.POLL_FAILED;

        public Itr(@NotNull AbstractChannel<E> abstractChannel) {
            this.channel = abstractChannel;
        }

        private final boolean hasNextResult(Object result) {
            if (result instanceof Closed) {
                Closed closed = (Closed) result;
                if (closed.closeCause == null) {
                    return false;
                }
                throw StackTraceRecoveryKt.recoverStackTrace(closed.getReceiveException());
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Object hasNextSuspend(Continuation<? super Boolean> continuation) {
            Continuation intercepted;
            Object coroutine_suspended;
            Function1<Throwable, Unit> bindCancellationFun;
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            CancellableContinuationImpl orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(intercepted);
            ReceiveHasNext receiveHasNext = new ReceiveHasNext(this, orCreateCancellableContinuation);
            while (true) {
                if (this.channel.enqueueReceive(receiveHasNext)) {
                    this.channel.removeReceiveOnCancel(orCreateCancellableContinuation, receiveHasNext);
                    break;
                }
                Object pollInternal = this.channel.pollInternal();
                setResult(pollInternal);
                if (pollInternal instanceof Closed) {
                    Closed closed = (Closed) pollInternal;
                    if (closed.closeCause == null) {
                        orCreateCancellableContinuation.resumeWith(Result.m476constructorimpl(Boxing.boxBoolean(false)));
                    } else {
                        Throwable receiveException = closed.getReceiveException();
                        Result.Companion companion = Result.INSTANCE;
                        orCreateCancellableContinuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(receiveException)));
                    }
                } else if (pollInternal != AbstractChannelKt.POLL_FAILED) {
                    Boolean boxBoolean = Boxing.boxBoolean(true);
                    Function1<E, Unit> function1 = this.channel.onUndeliveredElement;
                    if (function1 == null) {
                        bindCancellationFun = null;
                    } else {
                        bindCancellationFun = OnUndeliveredElementKt.bindCancellationFun(function1, pollInternal, orCreateCancellableContinuation.get$context());
                    }
                    orCreateCancellableContinuation.resume(boxBoolean, bindCancellationFun);
                }
            }
            Object result = orCreateCancellableContinuation.getResult();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (result == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return result;
        }

        @Nullable
        public final Object getResult() {
            return this.result;
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        @Nullable
        public Object hasNext(@NotNull Continuation<? super Boolean> continuation) {
            Object result = getResult();
            Symbol symbol = AbstractChannelKt.POLL_FAILED;
            if (result != symbol) {
                return Boxing.boxBoolean(hasNextResult(getResult()));
            }
            setResult(this.channel.pollInternal());
            if (getResult() != symbol) {
                return Boxing.boxBoolean(hasNextResult(getResult()));
            }
            return hasNextSuspend(continuation);
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.3.0, binary compatibility with versions <= 1.2.x")
        @JvmName(name = "next")
        public /* synthetic */ Object next(Continuation continuation) {
            return ChannelIterator.DefaultImpls.next(this, continuation);
        }

        public final void setResult(@Nullable Object obj) {
            this.result = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlinx.coroutines.channels.ChannelIterator
        public E next() {
            E e16 = (E) this.result;
            if (!(e16 instanceof Closed)) {
                Symbol symbol = AbstractChannelKt.POLL_FAILED;
                if (e16 != symbol) {
                    this.result = symbol;
                    return e16;
                }
                throw new IllegalStateException("'hasNext' should be called prior to 'next' invocation");
            }
            throw StackTraceRecoveryKt.recoverStackTrace(((Closed) e16).getReceiveException());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0012\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001d\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0001H\u0016\u00a2\u0006\u0002\u0010\fJ\u0014\u0010\r\u001a\u00020\n2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u000fH\u0016J\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00028\u0001\u00a2\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0013H\u0016J!\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u000b\u001a\u00028\u00012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016\u00a2\u0006\u0002\u0010\u0018R\u0018\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$ReceiveElement;", "E", "Lkotlinx/coroutines/channels/Receive;", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "receiveMode", "", "(Lkotlinx/coroutines/CancellableContinuation;I)V", "completeResumeReceive", "", "value", "(Ljava/lang/Object;)V", "resumeReceiveClosed", AudioContext.State.CLOSED, "Lkotlinx/coroutines/channels/Closed;", "resumeValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "toString", "", "tryResumeReceive", "Lkotlinx/coroutines/internal/Symbol;", "otherOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Lkotlinx/coroutines/internal/Symbol;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes28.dex */
    public static class ReceiveElement<E> extends Receive<E> {

        @JvmField
        @NotNull
        public final CancellableContinuation<Object> cont;

        @JvmField
        public final int receiveMode;

        public ReceiveElement(@NotNull CancellableContinuation<Object> cancellableContinuation, int i3) {
            this.cont = cancellableContinuation;
            this.receiveMode = i3;
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        public void completeResumeReceive(E value) {
            this.cont.completeResume(CancellableContinuationImplKt.RESUME_TOKEN);
        }

        @Override // kotlinx.coroutines.channels.Receive
        public void resumeReceiveClosed(@NotNull Closed<?> closed) {
            if (this.receiveMode == 1) {
                this.cont.resumeWith(Result.m476constructorimpl(ChannelResult.m2008boximpl(ChannelResult.INSTANCE.m2021closedJP2dKIU(closed.closeCause))));
                return;
            }
            CancellableContinuation<Object> cancellableContinuation = this.cont;
            Throwable receiveException = closed.getReceiveException();
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(receiveException)));
        }

        @Nullable
        public final Object resumeValue(E value) {
            if (this.receiveMode == 1) {
                return ChannelResult.m2008boximpl(ChannelResult.INSTANCE.m2023successJP2dKIU(value));
            }
            return value;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        @NotNull
        public String toString() {
            return "ReceiveElement@" + DebugStringsKt.getHexAddress(this) + "[receiveMode=" + this.receiveMode + ']';
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        @Nullable
        public Symbol tryResumeReceive(E value, @Nullable LockFreeLinkedListNode.PrepareOp otherOp) {
            LockFreeLinkedListNode.AbstractAtomicDesc abstractAtomicDesc;
            CancellableContinuation<Object> cancellableContinuation = this.cont;
            Object resumeValue = resumeValue(value);
            if (otherOp == null) {
                abstractAtomicDesc = null;
            } else {
                abstractAtomicDesc = otherOp.desc;
            }
            if (cancellableContinuation.tryResume(resumeValue, abstractAtomicDesc, resumeOnCancellationFun(value)) == null) {
                return null;
            }
            if (otherOp != null) {
                otherOp.finishPrepare();
            }
            return CancellableContinuationImplKt.RESUME_TOKEN;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002B;\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u001c\u0010\b\u001a\u0018\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00028\u0001`\u000b\u00a2\u0006\u0002\u0010\fJ#\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00028\u0001H\u0016\u00a2\u0006\u0002\u0010\u0010R&\u0010\b\u001a\u0018\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00028\u0001`\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$ReceiveElementWithUndeliveredHandler;", "E", "Lkotlinx/coroutines/channels/AbstractChannel$ReceiveElement;", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "receiveMode", "", "onUndeliveredElement", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "(Lkotlinx/coroutines/CancellableContinuation;ILkotlin/jvm/functions/Function1;)V", "resumeOnCancellationFun", "", "value", "(Ljava/lang/Object;)Lkotlin/jvm/functions/Function1;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes28.dex */
    public static final class ReceiveElementWithUndeliveredHandler<E> extends ReceiveElement<E> {

        @JvmField
        @NotNull
        public final Function1<E, Unit> onUndeliveredElement;

        /* JADX WARN: Multi-variable type inference failed */
        public ReceiveElementWithUndeliveredHandler(@NotNull CancellableContinuation<Object> cancellableContinuation, int i3, @NotNull Function1<? super E, Unit> function1) {
            super(cancellableContinuation, i3);
            this.onUndeliveredElement = function1;
        }

        @Override // kotlinx.coroutines.channels.Receive
        @Nullable
        public Function1<Throwable, Unit> resumeOnCancellationFun(E value) {
            return OnUndeliveredElementKt.bindCancellationFun(this.onUndeliveredElement, value, this.cont.get$context());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0012\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B!\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\u0010\bJ\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0001H\u0016\u00a2\u0006\u0002\u0010\fJ#\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00028\u0001H\u0016\u00a2\u0006\u0002\u0010\u0010J\u0014\u0010\u0011\u001a\u00020\n2\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J!\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u000b\u001a\u00028\u00012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016\u00a2\u0006\u0002\u0010\u001aR\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$ReceiveHasNext;", "E", "Lkotlinx/coroutines/channels/Receive;", "iterator", "Lkotlinx/coroutines/channels/AbstractChannel$Itr;", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlinx/coroutines/channels/AbstractChannel$Itr;Lkotlinx/coroutines/CancellableContinuation;)V", "completeResumeReceive", "", "value", "(Ljava/lang/Object;)V", "resumeOnCancellationFun", "Lkotlin/Function1;", "", "(Ljava/lang/Object;)Lkotlin/jvm/functions/Function1;", "resumeReceiveClosed", AudioContext.State.CLOSED, "Lkotlinx/coroutines/channels/Closed;", "toString", "", "tryResumeReceive", "Lkotlinx/coroutines/internal/Symbol;", "otherOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Lkotlinx/coroutines/internal/Symbol;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes28.dex */
    public static class ReceiveHasNext<E> extends Receive<E> {

        @JvmField
        @NotNull
        public final CancellableContinuation<Boolean> cont;

        @JvmField
        @NotNull
        public final Itr<E> iterator;

        /* JADX WARN: Multi-variable type inference failed */
        public ReceiveHasNext(@NotNull Itr<E> itr, @NotNull CancellableContinuation<? super Boolean> cancellableContinuation) {
            this.iterator = itr;
            this.cont = cancellableContinuation;
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        public void completeResumeReceive(E value) {
            this.iterator.setResult(value);
            this.cont.completeResume(CancellableContinuationImplKt.RESUME_TOKEN);
        }

        @Override // kotlinx.coroutines.channels.Receive
        @Nullable
        public Function1<Throwable, Unit> resumeOnCancellationFun(E value) {
            Function1<E, Unit> function1 = this.iterator.channel.onUndeliveredElement;
            if (function1 == null) {
                return null;
            }
            return OnUndeliveredElementKt.bindCancellationFun(function1, value, this.cont.get$context());
        }

        @Override // kotlinx.coroutines.channels.Receive
        public void resumeReceiveClosed(@NotNull Closed<?> closed) {
            Object tryResumeWithException;
            if (closed.closeCause == null) {
                tryResumeWithException = CancellableContinuation.DefaultImpls.tryResume$default(this.cont, Boolean.FALSE, null, 2, null);
            } else {
                tryResumeWithException = this.cont.tryResumeWithException(closed.getReceiveException());
            }
            if (tryResumeWithException != null) {
                this.iterator.setResult(closed);
                this.cont.completeResume(tryResumeWithException);
            }
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        @NotNull
        public String toString() {
            return Intrinsics.stringPlus("ReceiveHasNext@", DebugStringsKt.getHexAddress(this));
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        @Nullable
        public Symbol tryResumeReceive(E value, @Nullable LockFreeLinkedListNode.PrepareOp otherOp) {
            LockFreeLinkedListNode.AbstractAtomicDesc abstractAtomicDesc;
            CancellableContinuation<Boolean> cancellableContinuation = this.cont;
            Boolean bool = Boolean.TRUE;
            if (otherOp == null) {
                abstractAtomicDesc = null;
            } else {
                abstractAtomicDesc = otherOp.desc;
            }
            if (cancellableContinuation.tryResume(bool, abstractAtomicDesc, resumeOnCancellationFun(value)) == null) {
                return null;
            }
            if (otherOp != null) {
                otherOp.finishPrepare();
            }
            return CancellableContinuationImplKt.RESUME_TOKEN;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u0001*\u0004\b\u0002\u0010\u00022\b\u0012\u0004\u0012\u0002H\u00020\u00032\u00020\u0004BR\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\b\u0012$\u0010\t\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n\u0012\u0006\u0010\r\u001a\u00020\u000e\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u0015\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u0002H\u0016\u00a2\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001a\u00020\u0012H\u0016J#\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00172\u0006\u0010\u0013\u001a\u00028\u0002H\u0016\u00a2\u0006\u0002\u0010\u0019J\u0014\u0010\u001a\u001a\u00020\u00122\n\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J!\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\u0013\u001a\u00028\u00022\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016\u00a2\u0006\u0002\u0010#R3\u0010\t\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n8\u0006X\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\u0004\n\u0002\u0010\u0010R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006$"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$ReceiveSelect;", BdhLogUtil.LogTag.Tag_Req, "E", "Lkotlinx/coroutines/channels/Receive;", "Lkotlinx/coroutines/DisposableHandle;", WadlProxyConsts.CHANNEL, "Lkotlinx/coroutines/channels/AbstractChannel;", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "block", "Lkotlin/Function2;", "", "Lkotlin/coroutines/Continuation;", "receiveMode", "", "(Lkotlinx/coroutines/channels/AbstractChannel;Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;I)V", "Lkotlin/jvm/functions/Function2;", "completeResumeReceive", "", "value", "(Ljava/lang/Object;)V", "dispose", "resumeOnCancellationFun", "Lkotlin/Function1;", "", "(Ljava/lang/Object;)Lkotlin/jvm/functions/Function1;", "resumeReceiveClosed", AudioContext.State.CLOSED, "Lkotlinx/coroutines/channels/Closed;", "toString", "", "tryResumeReceive", "Lkotlinx/coroutines/internal/Symbol;", "otherOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Lkotlinx/coroutines/internal/Symbol;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes28.dex */
    public static final class ReceiveSelect<R, E> extends Receive<E> implements DisposableHandle {

        @JvmField
        @NotNull
        public final Function2<Object, Continuation<? super R>, Object> block;

        @JvmField
        @NotNull
        public final AbstractChannel<E> channel;

        @JvmField
        public final int receiveMode;

        @JvmField
        @NotNull
        public final SelectInstance<R> select;

        /* JADX WARN: Multi-variable type inference failed */
        public ReceiveSelect(@NotNull AbstractChannel<E> abstractChannel, @NotNull SelectInstance<? super R> selectInstance, @NotNull Function2<Object, ? super Continuation<? super R>, ? extends Object> function2, int i3) {
            this.channel = abstractChannel;
            this.select = selectInstance;
            this.block = function2;
            this.receiveMode = i3;
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        public void completeResumeReceive(E value) {
            Object obj;
            Function2<Object, Continuation<? super R>, Object> function2 = this.block;
            if (this.receiveMode == 1) {
                obj = ChannelResult.m2008boximpl(ChannelResult.INSTANCE.m2023successJP2dKIU(value));
            } else {
                obj = value;
            }
            CancellableKt.startCoroutineCancellable(function2, obj, this.select.getCompletion(), resumeOnCancellationFun(value));
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public void dispose() {
            if (remove()) {
                this.channel.onReceiveDequeued();
            }
        }

        @Override // kotlinx.coroutines.channels.Receive
        @Nullable
        public Function1<Throwable, Unit> resumeOnCancellationFun(E value) {
            Function1<E, Unit> function1 = this.channel.onUndeliveredElement;
            if (function1 == null) {
                return null;
            }
            return OnUndeliveredElementKt.bindCancellationFun(function1, value, this.select.getCompletion().get$context());
        }

        @Override // kotlinx.coroutines.channels.Receive
        public void resumeReceiveClosed(@NotNull Closed<?> closed) {
            if (!this.select.trySelect()) {
                return;
            }
            int i3 = this.receiveMode;
            if (i3 != 0) {
                if (i3 == 1) {
                    CancellableKt.startCoroutineCancellable$default(this.block, ChannelResult.m2008boximpl(ChannelResult.INSTANCE.m2021closedJP2dKIU(closed.closeCause)), this.select.getCompletion(), null, 4, null);
                    return;
                }
                return;
            }
            this.select.resumeSelectWithException(closed.getReceiveException());
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        @NotNull
        public String toString() {
            return "ReceiveSelect@" + DebugStringsKt.getHexAddress(this) + '[' + this.select + ",receiveMode=" + this.receiveMode + ']';
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        @Nullable
        public Symbol tryResumeReceive(E value, @Nullable LockFreeLinkedListNode.PrepareOp otherOp) {
            return (Symbol) this.select.trySelectOther(otherOp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u00a2\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0096\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u0012\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$RemoveReceiveOnCancel;", "Lkotlinx/coroutines/BeforeResumeCancelHandler;", "receive", "Lkotlinx/coroutines/channels/Receive;", "(Lkotlinx/coroutines/channels/AbstractChannel;Lkotlinx/coroutines/channels/Receive;)V", "invoke", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes28.dex */
    public final class RemoveReceiveOnCancel extends BeforeResumeCancelHandler {

        @NotNull
        private final Receive<?> receive;

        public RemoveReceiveOnCancel(@NotNull Receive<?> receive) {
            this.receive = receive;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
            invoke2(th5);
            return Unit.INSTANCE;
        }

        @NotNull
        public String toString() {
            return "RemoveReceiveOnCancel[" + this.receive + ']';
        }

        @Override // kotlinx.coroutines.CancelHandlerBase
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public void invoke2(@Nullable Throwable cause) {
            if (this.receive.remove()) {
                AbstractChannel.this.onReceiveDequeued();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u0000*\u0004\b\u0001\u0010\u00012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0014J\u0016\u0010\f\u001a\u0004\u0018\u00010\t2\n\u0010\r\u001a\u00060\u000ej\u0002`\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u000bH\u0016\u00a8\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$TryPollDesc;", "E", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "Lkotlinx/coroutines/channels/Send;", "Lkotlinx/coroutines/internal/RemoveFirstDesc;", SemanticAttributes.MessagingDestinationKindValues.QUEUE, "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "(Lkotlinx/coroutines/internal/LockFreeLinkedListHead;)V", "failure", "", "affected", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "onPrepare", "prepareOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "Lkotlinx/coroutines/internal/PrepareOp;", "onRemoved", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes28.dex */
    public static final class TryPollDesc<E> extends LockFreeLinkedListNode.RemoveFirstDesc<Send> {
        public TryPollDesc(@NotNull LockFreeLinkedListHead lockFreeLinkedListHead) {
            super(lockFreeLinkedListHead);
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.RemoveFirstDesc, kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        @Nullable
        protected Object failure(@NotNull LockFreeLinkedListNode affected) {
            if (!(affected instanceof Closed)) {
                if (!(affected instanceof Send)) {
                    return AbstractChannelKt.POLL_FAILED;
                }
                return null;
            }
            return affected;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        @Nullable
        public Object onPrepare(@NotNull LockFreeLinkedListNode.PrepareOp prepareOp) {
            Symbol tryResumeSend = ((Send) prepareOp.affected).tryResumeSend(prepareOp);
            if (tryResumeSend == null) {
                return LockFreeLinkedList_commonKt.REMOVE_PREPARED;
            }
            Object obj = AtomicKt.RETRY_ATOMIC;
            if (tryResumeSend == obj) {
                return obj;
            }
            return null;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public void onRemoved(@NotNull LockFreeLinkedListNode affected) {
            ((Send) affected).undeliveredElement();
        }
    }

    public AbstractChannel(@Nullable Function1<? super E, Unit> function1) {
        super(function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean enqueueReceive(Receive<? super E> receive) {
        boolean enqueueReceiveInternal = enqueueReceiveInternal(receive);
        if (enqueueReceiveInternal) {
            onReceiveEnqueued();
        }
        return enqueueReceiveInternal;
    }

    private final <R> boolean enqueueReceiveSelect(SelectInstance<? super R> select, Function2<Object, ? super Continuation<? super R>, ? extends Object> block, int receiveMode) {
        ReceiveSelect receiveSelect = new ReceiveSelect(this, select, block, receiveMode);
        boolean enqueueReceive = enqueueReceive(receiveSelect);
        if (enqueueReceive) {
            select.disposeOnSelect(receiveSelect);
        }
        return enqueueReceive;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final <R> Object receiveSuspend(int i3, Continuation<? super R> continuation) {
        Continuation intercepted;
        ReceiveElement receiveElement;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(intercepted);
        if (this.onUndeliveredElement == null) {
            receiveElement = new ReceiveElement(orCreateCancellableContinuation, i3);
        } else {
            receiveElement = new ReceiveElementWithUndeliveredHandler(orCreateCancellableContinuation, i3, this.onUndeliveredElement);
        }
        while (true) {
            if (enqueueReceive(receiveElement)) {
                removeReceiveOnCancel(orCreateCancellableContinuation, receiveElement);
                break;
            }
            Object pollInternal = pollInternal();
            if (pollInternal instanceof Closed) {
                receiveElement.resumeReceiveClosed((Closed) pollInternal);
                break;
            }
            if (pollInternal != AbstractChannelKt.POLL_FAILED) {
                orCreateCancellableContinuation.resume(receiveElement.resumeValue(pollInternal), receiveElement.resumeOnCancellationFun(pollInternal));
                break;
            }
        }
        Object result = orCreateCancellableContinuation.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <R> void registerSelectReceiveMode(SelectInstance<? super R> select, int receiveMode, Function2<Object, ? super Continuation<? super R>, ? extends Object> block) {
        while (!select.isSelected()) {
            if (isEmptyImpl()) {
                if (enqueueReceiveSelect(select, block, receiveMode)) {
                    return;
                }
            } else {
                Object pollSelectInternal = pollSelectInternal(select);
                if (pollSelectInternal == SelectKt.getALREADY_SELECTED()) {
                    return;
                }
                if (pollSelectInternal != AbstractChannelKt.POLL_FAILED && pollSelectInternal != AtomicKt.RETRY_ATOMIC) {
                    tryStartBlockUnintercepted(block, select, receiveMode, pollSelectInternal);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeReceiveOnCancel(CancellableContinuation<?> cont, Receive<?> receive) {
        cont.invokeOnCancellation(new RemoveReceiveOnCancel(receive));
    }

    private final <R> void tryStartBlockUnintercepted(Function2<Object, ? super Continuation<? super R>, ? extends Object> function2, SelectInstance<? super R> selectInstance, int i3, Object obj) {
        Object m2023successJP2dKIU;
        boolean z16 = obj instanceof Closed;
        if (z16) {
            if (i3 != 0) {
                if (i3 != 1 || !selectInstance.trySelect()) {
                    return;
                }
                UndispatchedKt.startCoroutineUnintercepted(function2, ChannelResult.m2008boximpl(ChannelResult.INSTANCE.m2021closedJP2dKIU(((Closed) obj).closeCause)), selectInstance.getCompletion());
                return;
            }
            throw StackTraceRecoveryKt.recoverStackTrace(((Closed) obj).getReceiveException());
        }
        if (i3 == 1) {
            ChannelResult.Companion companion = ChannelResult.INSTANCE;
            if (z16) {
                m2023successJP2dKIU = companion.m2021closedJP2dKIU(((Closed) obj).closeCause);
            } else {
                m2023successJP2dKIU = companion.m2023successJP2dKIU(obj);
            }
            UndispatchedKt.startCoroutineUnintercepted(function2, ChannelResult.m2008boximpl(m2023successJP2dKIU), selectInstance.getCompletion());
            return;
        }
        UndispatchedKt.startCoroutineUnintercepted(function2, obj, selectInstance.getCompletion());
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ void cancel() {
        cancel((CancellationException) null);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /* renamed from: cancelInternal$kotlinx_coroutines_core, reason: merged with bridge method [inline-methods] */
    public final boolean cancel(@Nullable Throwable cause) {
        boolean cancel = cancel(cause);
        onCancelIdempotent(cancel);
        return cancel;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final TryPollDesc<E> describeTryPoll() {
        return new TryPollDesc<>(getQueue());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean enqueueReceiveInternal(@NotNull final Receive<? super E> receive) {
        int tryCondAddNext;
        LockFreeLinkedListNode prevNode;
        if (isBufferAlwaysEmpty()) {
            LockFreeLinkedListNode queue = getQueue();
            do {
                prevNode = queue.getPrevNode();
                if (!(!(prevNode instanceof Send))) {
                    return false;
                }
            } while (!prevNode.addNext(receive, queue));
        } else {
            LockFreeLinkedListNode queue2 = getQueue();
            LockFreeLinkedListNode.CondAddOp condAddOp = new LockFreeLinkedListNode.CondAddOp(this) { // from class: kotlinx.coroutines.channels.AbstractChannel$enqueueReceiveInternal$$inlined$addLastIfPrevAndIf$1
                final /* synthetic */ AbstractChannel this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(LockFreeLinkedListNode.this);
                    this.this$0 = this;
                }

                @Override // kotlinx.coroutines.internal.AtomicOp
                @Nullable
                public Object prepare(@NotNull LockFreeLinkedListNode affected) {
                    if (this.this$0.isBufferEmpty()) {
                        return null;
                    }
                    return LockFreeLinkedListKt.getCONDITION_FALSE();
                }
            };
            do {
                LockFreeLinkedListNode prevNode2 = queue2.getPrevNode();
                if (!(!(prevNode2 instanceof Send))) {
                    return false;
                }
                tryCondAddNext = prevNode2.tryCondAddNext(receive, queue2, condAddOp);
                if (tryCondAddNext != 1) {
                }
            } while (tryCondAddNext != 2);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean getHasReceiveOrClosed() {
        return getQueue().getNextNode() instanceof ReceiveOrClosed;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @NotNull
    public final SelectClause1<E> getOnReceive() {
        return new SelectClause1<E>(this) { // from class: kotlinx.coroutines.channels.AbstractChannel$onReceive$1
            final /* synthetic */ AbstractChannel<E> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.this$0 = this;
            }

            @Override // kotlinx.coroutines.selects.SelectClause1
            public <R> void registerSelectClause1(@NotNull SelectInstance<? super R> select, @NotNull Function2<? super E, ? super Continuation<? super R>, ? extends Object> block) {
                this.this$0.registerSelectReceiveMode(select, 0, block);
            }
        };
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @NotNull
    public final SelectClause1<ChannelResult<E>> getOnReceiveCatching() {
        return new SelectClause1<ChannelResult<? extends E>>(this) { // from class: kotlinx.coroutines.channels.AbstractChannel$onReceiveCatching$1
            final /* synthetic */ AbstractChannel<E> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.this$0 = this;
            }

            @Override // kotlinx.coroutines.selects.SelectClause1
            public <R> void registerSelectClause1(@NotNull SelectInstance<? super R> select, @NotNull Function2<? super ChannelResult<? extends E>, ? super Continuation<? super R>, ? extends Object> block) {
                this.this$0.registerSelectReceiveMode(select, 1, block);
            }
        };
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @NotNull
    public SelectClause1<E> getOnReceiveOrNull() {
        return Channel.DefaultImpls.getOnReceiveOrNull(this);
    }

    protected abstract boolean isBufferAlwaysEmpty();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean isBufferEmpty();

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public boolean isClosedForReceive() {
        if (getClosedForReceive() != null && isBufferEmpty()) {
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public boolean isEmpty() {
        return isEmptyImpl();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean isEmptyImpl() {
        if (!(getQueue().getNextNode() instanceof Send) && isBufferEmpty()) {
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @NotNull
    public final ChannelIterator<E> iterator() {
        return new Itr(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onCancelIdempotent(boolean wasClosed) {
        Closed<?> closedForSend = getClosedForSend();
        if (closedForSend != null) {
            Object m2039constructorimpl$default = InlineList.m2039constructorimpl$default(null, 1, null);
            while (true) {
                LockFreeLinkedListNode prevNode = closedForSend.getPrevNode();
                if (prevNode instanceof LockFreeLinkedListHead) {
                    mo2000onCancelIdempotentListww6eGU(m2039constructorimpl$default, closedForSend);
                    return;
                } else if (!prevNode.remove()) {
                    prevNode.helpRemove();
                } else {
                    m2039constructorimpl$default = InlineList.m2044plusFjFbRPM(m2039constructorimpl$default, (Send) prevNode);
                }
            }
        } else {
            throw new IllegalStateException("Cannot happen".toString());
        }
    }

    /* renamed from: onCancelIdempotentList-w-w6eGU, reason: not valid java name */
    protected void mo2000onCancelIdempotentListww6eGU(@NotNull Object list, @NotNull Closed<?> closed) {
        if (list != null) {
            if (!(list instanceof ArrayList)) {
                ((Send) list).resumeSendClosed(closed);
                return;
            }
            ArrayList arrayList = (ArrayList) list;
            int size = arrayList.size() - 1;
            if (size < 0) {
                return;
            }
            while (true) {
                int i3 = size - 1;
                ((Send) arrayList.get(size)).resumeSendClosed(closed);
                if (i3 >= 0) {
                    size = i3;
                } else {
                    return;
                }
            }
        }
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Deprecated(level = DeprecationLevel.WARNING, message = "Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith = @ReplaceWith(expression = "tryReceive().getOrNull()", imports = {}))
    @Nullable
    public E poll() {
        return (E) Channel.DefaultImpls.poll(this);
    }

    @Nullable
    protected Object pollInternal() {
        while (true) {
            Send takeFirstSendOrPeekClosed = takeFirstSendOrPeekClosed();
            if (takeFirstSendOrPeekClosed == null) {
                return AbstractChannelKt.POLL_FAILED;
            }
            if (takeFirstSendOrPeekClosed.tryResumeSend(null) != null) {
                takeFirstSendOrPeekClosed.completeResumeSend();
                return takeFirstSendOrPeekClosed.getElement();
            }
            takeFirstSendOrPeekClosed.undeliveredElement();
        }
    }

    @Nullable
    protected Object pollSelectInternal(@NotNull SelectInstance<?> select) {
        TryPollDesc<E> describeTryPoll = describeTryPoll();
        Object performAtomicTrySelect = select.performAtomicTrySelect(describeTryPoll);
        if (performAtomicTrySelect != null) {
            return performAtomicTrySelect;
        }
        describeTryPoll.getResult().completeResumeSend();
        return describeTryPoll.getResult().getElement();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Nullable
    public final Object receive(@NotNull Continuation<? super E> continuation) {
        Object pollInternal = pollInternal();
        if (pollInternal != AbstractChannelKt.POLL_FAILED && !(pollInternal instanceof Closed)) {
            return pollInternal;
        }
        return receiveSuspend(0, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Nullable
    /* renamed from: receiveCatching-JP2dKIU, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object mo2001receiveCatchingJP2dKIU(@NotNull Continuation<? super ChannelResult<? extends E>> continuation) {
        AbstractChannel$receiveCatching$1 abstractChannel$receiveCatching$1;
        Object coroutine_suspended;
        int i3;
        if (continuation instanceof AbstractChannel$receiveCatching$1) {
            abstractChannel$receiveCatching$1 = (AbstractChannel$receiveCatching$1) continuation;
            int i16 = abstractChannel$receiveCatching$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                abstractChannel$receiveCatching$1.label = i16 - Integer.MIN_VALUE;
                Object obj = abstractChannel$receiveCatching$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = abstractChannel$receiveCatching$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    Object pollInternal = pollInternal();
                    if (pollInternal != AbstractChannelKt.POLL_FAILED) {
                        if (pollInternal instanceof Closed) {
                            return ChannelResult.INSTANCE.m2021closedJP2dKIU(((Closed) pollInternal).closeCause);
                        }
                        return ChannelResult.INSTANCE.m2023successJP2dKIU(pollInternal);
                    }
                    abstractChannel$receiveCatching$1.label = 1;
                    obj = receiveSuspend(1, abstractChannel$receiveCatching$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return ((ChannelResult) obj).getHolder();
            }
        }
        abstractChannel$receiveCatching$1 = new AbstractChannel$receiveCatching$1(this, continuation);
        Object obj2 = abstractChannel$receiveCatching$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = abstractChannel$receiveCatching$1.label;
        if (i3 == 0) {
        }
        return ((ChannelResult) obj2).getHolder();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @ReplaceWith(expression = "receiveCatching().getOrNull()", imports = {}))
    @LowPriorityInOverloadResolution
    @Nullable
    public Object receiveOrNull(@NotNull Continuation<? super E> continuation) {
        return Channel.DefaultImpls.receiveOrNull(this, continuation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    @Nullable
    public ReceiveOrClosed<E> takeFirstReceiveOrPeekClosed() {
        ReceiveOrClosed<E> takeFirstReceiveOrPeekClosed = super.takeFirstReceiveOrPeekClosed();
        if (takeFirstReceiveOrPeekClosed != null && !(takeFirstReceiveOrPeekClosed instanceof Closed)) {
            onReceiveDequeued();
        }
        return takeFirstReceiveOrPeekClosed;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @NotNull
    /* renamed from: tryReceive-PtdJZtk, reason: not valid java name */
    public final Object mo2002tryReceivePtdJZtk() {
        Object pollInternal = pollInternal();
        if (pollInternal == AbstractChannelKt.POLL_FAILED) {
            return ChannelResult.INSTANCE.m2022failurePtdJZtk();
        }
        if (pollInternal instanceof Closed) {
            return ChannelResult.INSTANCE.m2021closedJP2dKIU(((Closed) pollInternal).closeCause);
        }
        return ChannelResult.INSTANCE.m2023successJP2dKIU(pollInternal);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final void cancel(@Nullable CancellationException cause) {
        if (isClosedForReceive()) {
            return;
        }
        if (cause == null) {
            cause = new CancellationException(Intrinsics.stringPlus(DebugStringsKt.getClassSimpleName(this), " was cancelled"));
        }
        cancel(cause);
    }

    protected void onReceiveDequeued() {
    }

    protected void onReceiveEnqueued() {
    }
}
