package kotlinx.coroutines.channels;

import com.google.common.util.concurrent.b;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.tritonaudio.webaudio.AudioContext;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.InlineList;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.LockFreeLinkedList_commonKt;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a6\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u000006:\u0004defgB)\u0012 \u0010\u0005\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0013\u001a\u000e\u0012\u0002\b\u00030\u0011j\u0006\u0012\u0002\b\u0003`\u00122\u0006\u0010\u0010\u001a\u00028\u0000H\u0004\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00152\u0006\u0010\u0010\u001a\u00028\u0000H\u0004\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0019\u001a\u00020\u0018H\u0014\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u001b\u0010\u001f\u001a\u00020\u00032\n\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u001dH\u0002\u00a2\u0006\u0004\b\u001f\u0010 J#\u0010!\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00028\u00002\n\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u001dH\u0002\u00a2\u0006\u0004\b!\u0010\"J\u001b\u0010!\u001a\u00020\b2\n\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u001dH\u0002\u00a2\u0006\u0004\b!\u0010#J)\u0010&\u001a\u00020\u00032\u0018\u0010%\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`$H\u0016\u00a2\u0006\u0004\b&\u0010\u0007J\u0019\u0010'\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002\u00a2\u0006\u0004\b'\u0010(J\u0017\u0010)\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b)\u0010*J\u0017\u0010+\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00028\u0000H\u0014\u00a2\u0006\u0004\b+\u0010,J#\u0010/\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00028\u00002\n\u0010.\u001a\u0006\u0012\u0002\b\u00030-H\u0014\u00a2\u0006\u0004\b/\u00100J\u0017\u00102\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u000201H\u0014\u00a2\u0006\u0004\b2\u00103JX\u00109\u001a\u00020\u0003\"\u0004\b\u0001\u001042\f\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00010-2\u0006\u0010\u0010\u001a\u00028\u00002(\u00108\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u000006\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u000107\u0012\u0006\u0012\u0004\u0018\u00010\u001a05H\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b9\u0010:J\u001b\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00028\u0000H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0019\u0010;J\u001d\u0010=\u001a\b\u0012\u0002\b\u0003\u0018\u00010<2\u0006\u0010\u0010\u001a\u00028\u0000H\u0004\u00a2\u0006\u0004\b=\u0010>J\u001b\u0010?\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00028\u0000H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b?\u0010;J\u0017\u0010@\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010<H\u0014\u00a2\u0006\u0004\b@\u0010AJ\u0011\u0010B\u001a\u0004\u0018\u00010\u0018H\u0004\u00a2\u0006\u0004\bB\u0010CJ\u000f\u0010E\u001a\u00020DH\u0016\u00a2\u0006\u0004\bE\u0010FJ$\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00030G2\u0006\u0010\u0010\u001a\u00028\u0000\u00f8\u0001\u0000\u00f8\u0001\u0001\u00f8\u0001\u0002\u00a2\u0006\u0004\bH\u0010,J+\u0010J\u001a\u00020\u0003*\u0006\u0012\u0002\b\u0003072\u0006\u0010\u0010\u001a\u00028\u00002\n\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u001dH\u0002\u00a2\u0006\u0004\bJ\u0010KR\u0016\u0010M\u001a\u00020D8T@\u0014X\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\bL\u0010FR\u001c\u0010P\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001d8D@\u0004X\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\bN\u0010OR\u001c\u0010R\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001d8D@\u0004X\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\bQ\u0010OR\u0016\u0010S\u001a\u00020\n8$@$X\u00a4\u0004\u00a2\u0006\u0006\u001a\u0004\bS\u0010TR\u0016\u0010U\u001a\u00020\n8$@$X\u00a4\u0004\u00a2\u0006\u0006\u001a\u0004\bU\u0010TR\u0013\u0010V\u001a\u00020\n8F@\u0006\u00a2\u0006\u0006\u001a\u0004\bV\u0010TR\u0016\u0010W\u001a\u00020\n8B@\u0002X\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bW\u0010TR%\u0010[\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u0000060X8F@\u0006\u00a2\u0006\u0006\u001a\u0004\bY\u0010ZR0\u0010\u0005\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u00048\u0004@\u0005X\u0085\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\\R\u001c\u0010^\u001a\u00020]8\u0004@\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b^\u0010_\u001a\u0004\b`\u0010aR\u0016\u0010c\u001a\u00020D8B@\u0002X\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bb\u0010F\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006h"}, d2 = {"Lkotlinx/coroutines/channels/AbstractSendChannel;", "E", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "", "close", "(Ljava/lang/Throwable;)Z", "", "countQueueSize", "()I", DTConstants.TAG.ELEMENT, "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Lkotlinx/coroutines/internal/AddLastDesc;", "describeSendBuffered", "(Ljava/lang/Object;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Lkotlinx/coroutines/channels/AbstractSendChannel$TryOfferDesc;", "describeTryOffer", "(Ljava/lang/Object;)Lkotlinx/coroutines/channels/AbstractSendChannel$TryOfferDesc;", "Lkotlinx/coroutines/channels/Send;", "send", "", "enqueueSend", "(Lkotlinx/coroutines/channels/Send;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/Closed;", AudioContext.State.CLOSED, "helpClose", "(Lkotlinx/coroutines/channels/Closed;)V", "helpCloseAndGetSendException", "(Ljava/lang/Object;Lkotlinx/coroutines/channels/Closed;)Ljava/lang/Throwable;", "(Lkotlinx/coroutines/channels/Closed;)Ljava/lang/Throwable;", "Lkotlinx/coroutines/channels/Handler;", "handler", "invokeOnClose", "invokeOnCloseHandler", "(Ljava/lang/Throwable;)V", "offer", "(Ljava/lang/Object;)Z", "offerInternal", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "offerSelectInternal", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "onClosedIdempotent", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", BdhLogUtil.LogTag.Tag_Req, "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/SendChannel;", "Lkotlin/coroutines/Continuation;", "block", "registerSelectSend", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ReceiveOrClosed;", "sendBuffered", "(Ljava/lang/Object;)Lkotlinx/coroutines/channels/ReceiveOrClosed;", "sendSuspend", "takeFirstReceiveOrPeekClosed", "()Lkotlinx/coroutines/channels/ReceiveOrClosed;", "takeFirstSendOrPeekClosed", "()Lkotlinx/coroutines/channels/Send;", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "trySend", "helpCloseAndResumeWithSendException", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;Lkotlinx/coroutines/channels/Closed;)V", "getBufferDebugString", "bufferDebugString", "getClosedForReceive", "()Lkotlinx/coroutines/channels/Closed;", "closedForReceive", "getClosedForSend", "closedForSend", "isBufferAlwaysFull", "()Z", "isBufferFull", "isClosedForSend", "isFullImpl", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "onSend", "Lkotlin/jvm/functions/Function1;", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", SemanticAttributes.MessagingDestinationKindValues.QUEUE, "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "getQueue", "()Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "getQueueDebugStateString", "queueDebugStateString", "SendBuffered", "SendBufferedDesc", "SendSelect", "TryOfferDesc", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public abstract class AbstractSendChannel<E> implements SendChannel<E> {
    private static final /* synthetic */ AtomicReferenceFieldUpdater onCloseHandler$FU = AtomicReferenceFieldUpdater.newUpdater(AbstractSendChannel.class, Object.class, "onCloseHandler");

    @JvmField
    @Nullable
    protected final Function1<E, Unit> onUndeliveredElement;

    @NotNull
    private final LockFreeLinkedListHead queue = new LockFreeLinkedListHead();

    @NotNull
    private volatile /* synthetic */ Object onCloseHandler = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0012\u0018\u0000*\u0004\b\u0001\u0010\u00012\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0003`\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00028\u0001\u00a2\u0006\u0002\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0014\u00a8\u0006\r"}, d2 = {"Lkotlinx/coroutines/channels/AbstractSendChannel$SendBufferedDesc;", "E", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Lkotlinx/coroutines/channels/AbstractSendChannel$SendBuffered;", "Lkotlinx/coroutines/internal/AddLastDesc;", SemanticAttributes.MessagingDestinationKindValues.QUEUE, "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", DTConstants.TAG.ELEMENT, "(Lkotlinx/coroutines/internal/LockFreeLinkedListHead;Ljava/lang/Object;)V", "failure", "", "affected", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes28.dex */
    public static class SendBufferedDesc<E> extends LockFreeLinkedListNode.AddLastDesc<SendBuffered<? extends E>> {
        public SendBufferedDesc(@NotNull LockFreeLinkedListHead lockFreeLinkedListHead, E e16) {
            super(lockFreeLinkedListHead, new SendBuffered(e16));
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        @Nullable
        protected Object failure(@NotNull LockFreeLinkedListNode affected) {
            if (!(affected instanceof Closed)) {
                if (affected instanceof ReceiveOrClosed) {
                    return AbstractChannelKt.OFFER_FAILED;
                }
                return null;
            }
            return affected;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u0001*\u0004\b\u0002\u0010\u00022\u00020\u00032\u00020\u0004BV\u0012\u0006\u0010\u0005\u001a\u00028\u0001\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00020\t\u0012(\u0010\n\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u000b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\u0014\u0010\u0017\u001a\u00020\u00152\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020\u0015H\u0016R7\u0010\n\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u000b8\u0006X\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\u0004\n\u0002\u0010\u0010R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u00028\u0001X\u0096\u0004\u00a2\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006!"}, d2 = {"Lkotlinx/coroutines/channels/AbstractSendChannel$SendSelect;", "E", BdhLogUtil.LogTag.Tag_Req, "Lkotlinx/coroutines/channels/Send;", "Lkotlinx/coroutines/DisposableHandle;", "pollResult", WadlProxyConsts.CHANNEL, "Lkotlinx/coroutines/channels/AbstractSendChannel;", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/SendChannel;", "Lkotlin/coroutines/Continuation;", "", "(Ljava/lang/Object;Lkotlinx/coroutines/channels/AbstractSendChannel;Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "getPollResult", "()Ljava/lang/Object;", "Ljava/lang/Object;", "completeResumeSend", "", "dispose", "resumeSendClosed", AudioContext.State.CLOSED, "Lkotlinx/coroutines/channels/Closed;", "toString", "", "tryResumeSend", "Lkotlinx/coroutines/internal/Symbol;", "otherOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "undeliveredElement", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes28.dex */
    public static final class SendSelect<E, R> extends Send implements DisposableHandle {

        @JvmField
        @NotNull
        public final Function2<SendChannel<? super E>, Continuation<? super R>, Object> block;

        @JvmField
        @NotNull
        public final AbstractSendChannel<E> channel;
        private final E pollResult;

        @JvmField
        @NotNull
        public final SelectInstance<R> select;

        /* JADX WARN: Multi-variable type inference failed */
        public SendSelect(E e16, @NotNull AbstractSendChannel<E> abstractSendChannel, @NotNull SelectInstance<? super R> selectInstance, @NotNull Function2<? super SendChannel<? super E>, ? super Continuation<? super R>, ? extends Object> function2) {
            this.pollResult = e16;
            this.channel = abstractSendChannel;
            this.select = selectInstance;
            this.block = function2;
        }

        @Override // kotlinx.coroutines.channels.Send
        public void completeResumeSend() {
            CancellableKt.startCoroutineCancellable$default(this.block, this.channel, this.select.getCompletion(), null, 4, null);
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public void dispose() {
            if (!remove()) {
                return;
            }
            undeliveredElement();
        }

        @Override // kotlinx.coroutines.channels.Send
        /* renamed from: getPollResult */
        public E getElement() {
            return this.pollResult;
        }

        @Override // kotlinx.coroutines.channels.Send
        public void resumeSendClosed(@NotNull Closed<?> closed) {
            if (this.select.trySelect()) {
                this.select.resumeSelectWithException(closed.getSendException());
            }
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        @NotNull
        public String toString() {
            return "SendSelect@" + DebugStringsKt.getHexAddress(this) + '(' + getElement() + ")[" + this.channel + ", " + this.select + ']';
        }

        @Override // kotlinx.coroutines.channels.Send
        @Nullable
        public Symbol tryResumeSend(@Nullable LockFreeLinkedListNode.PrepareOp otherOp) {
            return (Symbol) this.select.trySelectOther(otherOp);
        }

        @Override // kotlinx.coroutines.channels.Send
        public void undeliveredElement() {
            Function1<E, Unit> function1 = this.channel.onUndeliveredElement;
            if (function1 != null) {
                OnUndeliveredElementKt.callUndeliveredElement(function1, getElement(), this.select.getCompletion().get$context());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u0000*\u0004\b\u0001\u0010\u00012\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0003`\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00028\u0001\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0014J\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\n\u0010\u000f\u001a\u00060\u0010j\u0002`\u0011H\u0016R\u0012\u0010\u0005\u001a\u00028\u00018\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\t\u00a8\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/channels/AbstractSendChannel$TryOfferDesc;", "E", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "Lkotlinx/coroutines/channels/ReceiveOrClosed;", "Lkotlinx/coroutines/internal/RemoveFirstDesc;", DTConstants.TAG.ELEMENT, SemanticAttributes.MessagingDestinationKindValues.QUEUE, "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/LockFreeLinkedListHead;)V", "Ljava/lang/Object;", "failure", "", "affected", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "onPrepare", "prepareOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "Lkotlinx/coroutines/internal/PrepareOp;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes28.dex */
    public static final class TryOfferDesc<E> extends LockFreeLinkedListNode.RemoveFirstDesc<ReceiveOrClosed<? super E>> {

        @JvmField
        public final E element;

        public TryOfferDesc(E e16, @NotNull LockFreeLinkedListHead lockFreeLinkedListHead) {
            super(lockFreeLinkedListHead);
            this.element = e16;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.RemoveFirstDesc, kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        @Nullable
        protected Object failure(@NotNull LockFreeLinkedListNode affected) {
            if (!(affected instanceof Closed)) {
                if (!(affected instanceof ReceiveOrClosed)) {
                    return AbstractChannelKt.OFFER_FAILED;
                }
                return null;
            }
            return affected;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        @Nullable
        public Object onPrepare(@NotNull LockFreeLinkedListNode.PrepareOp prepareOp) {
            Symbol tryResumeReceive = ((ReceiveOrClosed) prepareOp.affected).tryResumeReceive(this.element, prepareOp);
            if (tryResumeReceive == null) {
                return LockFreeLinkedList_commonKt.REMOVE_PREPARED;
            }
            Object obj = AtomicKt.RETRY_ATOMIC;
            if (tryResumeReceive == obj) {
                return obj;
            }
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AbstractSendChannel(@Nullable Function1<? super E, Unit> function1) {
        this.onUndeliveredElement = function1;
    }

    private final int countQueueSize() {
        LockFreeLinkedListHead lockFreeLinkedListHead = this.queue;
        int i3 = 0;
        for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) lockFreeLinkedListHead.getNext(); !Intrinsics.areEqual(lockFreeLinkedListNode, lockFreeLinkedListHead); lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode()) {
            if (lockFreeLinkedListNode instanceof LockFreeLinkedListNode) {
                i3++;
            }
        }
        return i3;
    }

    private final String getQueueDebugStateString() {
        String stringPlus;
        LockFreeLinkedListNode nextNode = this.queue.getNextNode();
        if (nextNode == this.queue) {
            return "EmptyQueue";
        }
        if (nextNode instanceof Closed) {
            stringPlus = nextNode.toString();
        } else if (nextNode instanceof Receive) {
            stringPlus = "ReceiveQueued";
        } else if (nextNode instanceof Send) {
            stringPlus = "SendQueued";
        } else {
            stringPlus = Intrinsics.stringPlus("UNEXPECTED:", nextNode);
        }
        LockFreeLinkedListNode prevNode = this.queue.getPrevNode();
        if (prevNode != nextNode) {
            String str = stringPlus + ",queueSize=" + countQueueSize();
            if (prevNode instanceof Closed) {
                return str + ",closedForSend=" + prevNode;
            }
            return str;
        }
        return stringPlus;
    }

    private final void helpClose(Closed<?> closed) {
        Receive receive;
        Object m2039constructorimpl$default = InlineList.m2039constructorimpl$default(null, 1, null);
        while (true) {
            LockFreeLinkedListNode prevNode = closed.getPrevNode();
            if (prevNode instanceof Receive) {
                receive = (Receive) prevNode;
            } else {
                receive = null;
            }
            if (receive == null) {
                break;
            } else if (!receive.remove()) {
                receive.helpRemove();
            } else {
                m2039constructorimpl$default = InlineList.m2044plusFjFbRPM(m2039constructorimpl$default, receive);
            }
        }
        if (m2039constructorimpl$default != null) {
            if (!(m2039constructorimpl$default instanceof ArrayList)) {
                ((Receive) m2039constructorimpl$default).resumeReceiveClosed(closed);
            } else {
                ArrayList arrayList = (ArrayList) m2039constructorimpl$default;
                int size = arrayList.size() - 1;
                if (size >= 0) {
                    while (true) {
                        int i3 = size - 1;
                        ((Receive) arrayList.get(size)).resumeReceiveClosed(closed);
                        if (i3 < 0) {
                            break;
                        } else {
                            size = i3;
                        }
                    }
                }
            }
        }
        onClosedIdempotent(closed);
    }

    private final Throwable helpCloseAndGetSendException(Closed<?> closed) {
        helpClose(closed);
        return closed.getSendException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void helpCloseAndResumeWithSendException(Continuation<?> continuation, E e16, Closed<?> closed) {
        UndeliveredElementException callUndeliveredElementCatchingException$default;
        helpClose(closed);
        Throwable sendException = closed.getSendException();
        Function1<E, Unit> function1 = this.onUndeliveredElement;
        if (function1 != null && (callUndeliveredElementCatchingException$default = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(function1, e16, null, 2, null)) != null) {
            ExceptionsKt__ExceptionsKt.addSuppressed(callUndeliveredElementCatchingException$default, sendException);
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(callUndeliveredElementCatchingException$default)));
        } else {
            Result.Companion companion2 = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(sendException)));
        }
    }

    private final void invokeOnCloseHandler(Throwable cause) {
        Symbol symbol;
        Object obj = this.onCloseHandler;
        if (obj != null && obj != (symbol = AbstractChannelKt.HANDLER_INVOKED) && b.a(onCloseHandler$FU, this, obj, symbol)) {
            ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj, 1)).invoke(cause);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isFullImpl() {
        if (!(this.queue.getNextNode() instanceof ReceiveOrClosed) && isBufferFull()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <R> void registerSelectSend(SelectInstance<? super R> select, E element, Function2<? super SendChannel<? super E>, ? super Continuation<? super R>, ? extends Object> block) {
        while (!select.isSelected()) {
            if (isFullImpl()) {
                SendSelect sendSelect = new SendSelect(element, this, select, block);
                Object enqueueSend = enqueueSend(sendSelect);
                if (enqueueSend == null) {
                    select.disposeOnSelect(sendSelect);
                    return;
                }
                if (!(enqueueSend instanceof Closed)) {
                    if (enqueueSend != AbstractChannelKt.ENQUEUE_FAILED && !(enqueueSend instanceof Receive)) {
                        throw new IllegalStateException(("enqueueSend returned " + enqueueSend + TokenParser.SP).toString());
                    }
                } else {
                    throw StackTraceRecoveryKt.recoverStackTrace(helpCloseAndGetSendException(element, (Closed) enqueueSend));
                }
            }
            Object offerSelectInternal = offerSelectInternal(element, select);
            if (offerSelectInternal == SelectKt.getALREADY_SELECTED()) {
                return;
            }
            if (offerSelectInternal != AbstractChannelKt.OFFER_FAILED && offerSelectInternal != AtomicKt.RETRY_ATOMIC) {
                if (offerSelectInternal == AbstractChannelKt.OFFER_SUCCESS) {
                    UndispatchedKt.startCoroutineUnintercepted(block, this, select.getCompletion());
                    return;
                } else {
                    if (offerSelectInternal instanceof Closed) {
                        throw StackTraceRecoveryKt.recoverStackTrace(helpCloseAndGetSendException(element, (Closed) offerSelectInternal));
                    }
                    throw new IllegalStateException(Intrinsics.stringPlus("offerSelectInternal returned ", offerSelectInternal).toString());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x006e, code lost:
    
        r4 = r0.getResult();
        r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0076, code lost:
    
        if (r4 != r0) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0078, code lost:
    
        kotlin.coroutines.jvm.internal.DebugProbes.probeCoroutineSuspended(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x007b, code lost:
    
        r5 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x007f, code lost:
    
        if (r4 != r5) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0081, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0084, code lost:
    
        return kotlin.Unit.INSTANCE;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object sendSuspend(E e16, Continuation<? super Unit> continuation) {
        Continuation intercepted;
        Send sendElementWithUndeliveredHandler;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(intercepted);
        while (true) {
            if (isFullImpl()) {
                if (this.onUndeliveredElement == null) {
                    sendElementWithUndeliveredHandler = new SendElement(e16, orCreateCancellableContinuation);
                } else {
                    sendElementWithUndeliveredHandler = new SendElementWithUndeliveredHandler(e16, orCreateCancellableContinuation, this.onUndeliveredElement);
                }
                Object enqueueSend = enqueueSend(sendElementWithUndeliveredHandler);
                if (enqueueSend == null) {
                    CancellableContinuationKt.removeOnCancellation(orCreateCancellableContinuation, sendElementWithUndeliveredHandler);
                    break;
                }
                if (enqueueSend instanceof Closed) {
                    helpCloseAndResumeWithSendException(orCreateCancellableContinuation, e16, (Closed) enqueueSend);
                    break;
                }
                if (enqueueSend != AbstractChannelKt.ENQUEUE_FAILED && !(enqueueSend instanceof Receive)) {
                    throw new IllegalStateException(Intrinsics.stringPlus("enqueueSend returned ", enqueueSend).toString());
                }
            }
            Object offerInternal = offerInternal(e16);
            if (offerInternal == AbstractChannelKt.OFFER_SUCCESS) {
                orCreateCancellableContinuation.resumeWith(Result.m476constructorimpl(Unit.INSTANCE));
                break;
            }
            if (offerInternal != AbstractChannelKt.OFFER_FAILED) {
                if (offerInternal instanceof Closed) {
                    helpCloseAndResumeWithSendException(orCreateCancellableContinuation, e16, (Closed) offerInternal);
                } else {
                    throw new IllegalStateException(Intrinsics.stringPlus("offerInternal returned ", offerInternal).toString());
                }
            }
        }
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    /* renamed from: close */
    public boolean cancel(@Nullable Throwable cause) {
        boolean z16;
        Closed<?> closed = new Closed<>(cause);
        LockFreeLinkedListNode lockFreeLinkedListNode = this.queue;
        while (true) {
            LockFreeLinkedListNode prevNode = lockFreeLinkedListNode.getPrevNode();
            z16 = true;
            if (!(!(prevNode instanceof Closed))) {
                z16 = false;
                break;
            }
            if (prevNode.addNext(closed, lockFreeLinkedListNode)) {
                break;
            }
        }
        if (!z16) {
            closed = (Closed) this.queue.getPrevNode();
        }
        helpClose(closed);
        if (z16) {
            invokeOnCloseHandler(cause);
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final LockFreeLinkedListNode.AddLastDesc<?> describeSendBuffered(E element) {
        return new SendBufferedDesc(this.queue, element);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final TryOfferDesc<E> describeTryOffer(E element) {
        return new TryOfferDesc<>(element, this.queue);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public Object enqueueSend(@NotNull final Send send) {
        boolean z16;
        LockFreeLinkedListNode prevNode;
        if (isBufferAlwaysFull()) {
            LockFreeLinkedListNode lockFreeLinkedListNode = this.queue;
            do {
                prevNode = lockFreeLinkedListNode.getPrevNode();
                if (prevNode instanceof ReceiveOrClosed) {
                    return prevNode;
                }
            } while (!prevNode.addNext(send, lockFreeLinkedListNode));
            return null;
        }
        LockFreeLinkedListNode lockFreeLinkedListNode2 = this.queue;
        LockFreeLinkedListNode.CondAddOp condAddOp = new LockFreeLinkedListNode.CondAddOp(this) { // from class: kotlinx.coroutines.channels.AbstractSendChannel$enqueueSend$$inlined$addLastIfPrevAndIf$1
            final /* synthetic */ AbstractSendChannel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(LockFreeLinkedListNode.this);
                this.this$0 = this;
            }

            @Override // kotlinx.coroutines.internal.AtomicOp
            @Nullable
            public Object prepare(@NotNull LockFreeLinkedListNode affected) {
                if (this.this$0.isBufferFull()) {
                    return null;
                }
                return LockFreeLinkedListKt.getCONDITION_FALSE();
            }
        };
        while (true) {
            LockFreeLinkedListNode prevNode2 = lockFreeLinkedListNode2.getPrevNode();
            if (prevNode2 instanceof ReceiveOrClosed) {
                return prevNode2;
            }
            int tryCondAddNext = prevNode2.tryCondAddNext(send, lockFreeLinkedListNode2, condAddOp);
            z16 = true;
            if (tryCondAddNext != 1) {
                if (tryCondAddNext == 2) {
                    z16 = false;
                    break;
                }
            } else {
                break;
            }
        }
        if (!z16) {
            return AbstractChannelKt.ENQUEUE_FAILED;
        }
        return null;
    }

    @NotNull
    protected String getBufferDebugString() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final Closed<?> getClosedForReceive() {
        Closed<?> closed;
        LockFreeLinkedListNode nextNode = this.queue.getNextNode();
        if (nextNode instanceof Closed) {
            closed = (Closed) nextNode;
        } else {
            closed = null;
        }
        if (closed == null) {
            return null;
        }
        helpClose(closed);
        return closed;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final Closed<?> getClosedForSend() {
        Closed<?> closed;
        LockFreeLinkedListNode prevNode = this.queue.getPrevNode();
        if (prevNode instanceof Closed) {
            closed = (Closed) prevNode;
        } else {
            closed = null;
        }
        if (closed == null) {
            return null;
        }
        helpClose(closed);
        return closed;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    @NotNull
    public final SelectClause2<E, SendChannel<E>> getOnSend() {
        return new SelectClause2<E, SendChannel<? super E>>(this) { // from class: kotlinx.coroutines.channels.AbstractSendChannel$onSend$1
            final /* synthetic */ AbstractSendChannel<E> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.this$0 = this;
            }

            @Override // kotlinx.coroutines.selects.SelectClause2
            public <R> void registerSelectClause2(@NotNull SelectInstance<? super R> select, E param, @NotNull Function2<? super SendChannel<? super E>, ? super Continuation<? super R>, ? extends Object> block) {
                this.this$0.registerSelectSend(select, param, block);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final LockFreeLinkedListHead getQueue() {
        return this.queue;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public void invokeOnClose(@NotNull Function1<? super Throwable, Unit> handler) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = onCloseHandler$FU;
        if (!b.a(atomicReferenceFieldUpdater, this, null, handler)) {
            Object obj = this.onCloseHandler;
            if (obj == AbstractChannelKt.HANDLER_INVOKED) {
                throw new IllegalStateException("Another handler was already registered and successfully invoked");
            }
            throw new IllegalStateException(Intrinsics.stringPlus("Another handler was already registered: ", obj));
        }
        Closed<?> closedForSend = getClosedForSend();
        if (closedForSend != null && b.a(atomicReferenceFieldUpdater, this, handler, AbstractChannelKt.HANDLER_INVOKED)) {
            handler.invoke(closedForSend.closeCause);
        }
    }

    protected abstract boolean isBufferAlwaysFull();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean isBufferFull();

    @Override // kotlinx.coroutines.channels.SendChannel
    public final boolean isClosedForSend() {
        if (getClosedForSend() != null) {
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean offer(E element) {
        UndeliveredElementException callUndeliveredElementCatchingException$default;
        try {
            return SendChannel.DefaultImpls.offer(this, element);
        } catch (Throwable th5) {
            Function1<E, Unit> function1 = this.onUndeliveredElement;
            if (function1 != null && (callUndeliveredElementCatchingException$default = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(function1, element, null, 2, null)) != null) {
                ExceptionsKt__ExceptionsKt.addSuppressed(callUndeliveredElementCatchingException$default, th5);
                throw callUndeliveredElementCatchingException$default;
            }
            throw th5;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public Object offerInternal(E element) {
        ReceiveOrClosed<E> takeFirstReceiveOrPeekClosed;
        do {
            takeFirstReceiveOrPeekClosed = takeFirstReceiveOrPeekClosed();
            if (takeFirstReceiveOrPeekClosed == null) {
                return AbstractChannelKt.OFFER_FAILED;
            }
        } while (takeFirstReceiveOrPeekClosed.tryResumeReceive(element, null) == null);
        takeFirstReceiveOrPeekClosed.completeResumeReceive(element);
        return takeFirstReceiveOrPeekClosed.getOfferResult();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public Object offerSelectInternal(E element, @NotNull SelectInstance<?> select) {
        TryOfferDesc<E> describeTryOffer = describeTryOffer(element);
        Object performAtomicTrySelect = select.performAtomicTrySelect(describeTryOffer);
        if (performAtomicTrySelect != null) {
            return performAtomicTrySelect;
        }
        ReceiveOrClosed<? super E> result = describeTryOffer.getResult();
        result.completeResumeReceive(element);
        return result.getOfferResult();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    @Nullable
    public final Object send(E e16, @NotNull Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        if (offerInternal(e16) == AbstractChannelKt.OFFER_SUCCESS) {
            return Unit.INSTANCE;
        }
        Object sendSuspend = sendSuspend(e16, continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (sendSuspend == coroutine_suspended) {
            return sendSuspend;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public final ReceiveOrClosed<?> sendBuffered(E element) {
        LockFreeLinkedListNode prevNode;
        LockFreeLinkedListHead lockFreeLinkedListHead = this.queue;
        SendBuffered sendBuffered = new SendBuffered(element);
        do {
            prevNode = lockFreeLinkedListHead.getPrevNode();
            if (prevNode instanceof ReceiveOrClosed) {
                return (ReceiveOrClosed) prevNode;
            }
        } while (!prevNode.addNext(sendBuffered, lockFreeLinkedListHead));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [kotlinx.coroutines.internal.LockFreeLinkedListNode] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    @Nullable
    public ReceiveOrClosed<E> takeFirstReceiveOrPeekClosed() {
        ?? r16;
        LockFreeLinkedListNode removeOrNext;
        LockFreeLinkedListHead lockFreeLinkedListHead = this.queue;
        while (true) {
            r16 = (LockFreeLinkedListNode) lockFreeLinkedListHead.getNext();
            if (r16 != lockFreeLinkedListHead && (r16 instanceof ReceiveOrClosed)) {
                if (((((ReceiveOrClosed) r16) instanceof Closed) && !r16.isRemoved()) || (removeOrNext = r16.removeOrNext()) == null) {
                    break;
                }
                removeOrNext.helpRemovePrev();
            }
        }
        r16 = 0;
        return (ReceiveOrClosed) r16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final Send takeFirstSendOrPeekClosed() {
        LockFreeLinkedListNode lockFreeLinkedListNode;
        LockFreeLinkedListNode removeOrNext;
        LockFreeLinkedListHead lockFreeLinkedListHead = this.queue;
        while (true) {
            lockFreeLinkedListNode = (LockFreeLinkedListNode) lockFreeLinkedListHead.getNext();
            if (lockFreeLinkedListNode != lockFreeLinkedListHead && (lockFreeLinkedListNode instanceof Send)) {
                if (((((Send) lockFreeLinkedListNode) instanceof Closed) && !lockFreeLinkedListNode.isRemoved()) || (removeOrNext = lockFreeLinkedListNode.removeOrNext()) == null) {
                    break;
                }
                removeOrNext.helpRemovePrev();
            }
        }
        lockFreeLinkedListNode = null;
        return (Send) lockFreeLinkedListNode;
    }

    @NotNull
    public String toString() {
        return DebugStringsKt.getClassSimpleName(this) + '@' + DebugStringsKt.getHexAddress(this) + '{' + getQueueDebugStateString() + '}' + getBufferDebugString();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    @NotNull
    /* renamed from: trySend-JP2dKIU, reason: not valid java name */
    public final Object mo2003trySendJP2dKIU(E element) {
        Object offerInternal = offerInternal(element);
        if (offerInternal == AbstractChannelKt.OFFER_SUCCESS) {
            return ChannelResult.INSTANCE.m2023successJP2dKIU(Unit.INSTANCE);
        }
        if (offerInternal == AbstractChannelKt.OFFER_FAILED) {
            Closed<?> closedForSend = getClosedForSend();
            if (closedForSend == null) {
                return ChannelResult.INSTANCE.m2022failurePtdJZtk();
            }
            return ChannelResult.INSTANCE.m2021closedJP2dKIU(helpCloseAndGetSendException(closedForSend));
        }
        if (offerInternal instanceof Closed) {
            return ChannelResult.INSTANCE.m2021closedJP2dKIU(helpCloseAndGetSendException((Closed) offerInternal));
        }
        throw new IllegalStateException(Intrinsics.stringPlus("trySend returned ", offerInternal).toString());
    }

    private final Throwable helpCloseAndGetSendException(E element, Closed<?> closed) {
        UndeliveredElementException callUndeliveredElementCatchingException$default;
        helpClose(closed);
        Function1<E, Unit> function1 = this.onUndeliveredElement;
        if (function1 != null && (callUndeliveredElementCatchingException$default = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(function1, element, null, 2, null)) != null) {
            ExceptionsKt__ExceptionsKt.addSuppressed(callUndeliveredElementCatchingException$default, closed.getSendException());
            throw callUndeliveredElementCatchingException$default;
        }
        return closed.getSendException();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0001\u00a2\u0006\u0002\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0014\u0010\f\u001a\u00020\u000b2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u0012\u0010\u0003\u001a\u00028\u00018\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0015"}, d2 = {"Lkotlinx/coroutines/channels/AbstractSendChannel$SendBuffered;", "E", "Lkotlinx/coroutines/channels/Send;", DTConstants.TAG.ELEMENT, "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "pollResult", "", "getPollResult", "()Ljava/lang/Object;", "completeResumeSend", "", "resumeSendClosed", AudioContext.State.CLOSED, "Lkotlinx/coroutines/channels/Closed;", "toString", "", "tryResumeSend", "Lkotlinx/coroutines/internal/Symbol;", "otherOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes28.dex */
    public static final class SendBuffered<E> extends Send {

        @JvmField
        public final E element;

        public SendBuffered(E e16) {
            this.element = e16;
        }

        @Override // kotlinx.coroutines.channels.Send
        @Nullable
        /* renamed from: getPollResult, reason: from getter */
        public Object getElement() {
            return this.element;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        @NotNull
        public String toString() {
            return "SendBuffered@" + DebugStringsKt.getHexAddress(this) + '(' + this.element + ')';
        }

        @Override // kotlinx.coroutines.channels.Send
        @Nullable
        public Symbol tryResumeSend(@Nullable LockFreeLinkedListNode.PrepareOp otherOp) {
            Symbol symbol = CancellableContinuationImplKt.RESUME_TOKEN;
            if (otherOp != null) {
                otherOp.finishPrepare();
            }
            return symbol;
        }

        @Override // kotlinx.coroutines.channels.Send
        public void completeResumeSend() {
        }

        @Override // kotlinx.coroutines.channels.Send
        public void resumeSendClosed(@NotNull Closed<?> closed) {
        }
    }

    protected void onClosedIdempotent(@NotNull LockFreeLinkedListNode closed) {
    }
}
