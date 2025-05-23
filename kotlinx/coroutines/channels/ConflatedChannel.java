package kotlinx.coroutines.channels;

import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.AbstractSendChannel;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;
import org.aspectj.lang.JoinPoint;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B'\u0012 \u0010\u0003\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0006\u00a2\u0006\u0002\u0010\u0007J\u0016\u0010\u0018\u001a\u00020\r2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0014J\u0015\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00028\u0000H\u0014\u00a2\u0006\u0002\u0010\u001dJ!\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00028\u00002\n\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030 H\u0014\u00a2\u0006\u0002\u0010!J\u0010\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\rH\u0014J\n\u0010$\u001a\u0004\u0018\u00010\u0017H\u0014J\u0016\u0010%\u001a\u0004\u0018\u00010\u00172\n\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030 H\u0014J\u0014\u0010&\u001a\u0004\u0018\u00010'2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0017H\u0002R\u0014\u0010\b\u001a\u00020\t8TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\r8DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\r8DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\r8DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\r8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u000eR\u0012\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006("}, d2 = {"Lkotlinx/coroutines/channels/ConflatedChannel;", "E", "Lkotlinx/coroutines/channels/AbstractChannel;", "onUndeliveredElement", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "(Lkotlin/jvm/functions/Function1;)V", "bufferDebugString", "", "getBufferDebugString", "()Ljava/lang/String;", "isBufferAlwaysEmpty", "", "()Z", "isBufferAlwaysFull", "isBufferEmpty", "isBufferFull", "isEmpty", JoinPoint.SYNCHRONIZATION_LOCK, "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "value", "", "enqueueReceiveInternal", "receive", "Lkotlinx/coroutines/channels/Receive;", "offerInternal", DTConstants.TAG.ELEMENT, "(Ljava/lang/Object;)Ljava/lang/Object;", "offerSelectInternal", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "onCancelIdempotent", "wasClosed", "pollInternal", "pollSelectInternal", "updateValueLocked", "Lkotlinx/coroutines/internal/UndeliveredElementException;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public class ConflatedChannel<E> extends AbstractChannel<E> {

    @NotNull
    private final ReentrantLock lock;

    @Nullable
    private Object value;

    public ConflatedChannel(@Nullable Function1<? super E, Unit> function1) {
        super(function1);
        this.lock = new ReentrantLock();
        this.value = AbstractChannelKt.EMPTY;
    }

    private final UndeliveredElementException updateValueLocked(Object element) {
        Function1<E, Unit> function1;
        Object obj = this.value;
        UndeliveredElementException undeliveredElementException = null;
        if (obj != AbstractChannelKt.EMPTY && (function1 = this.onUndeliveredElement) != null) {
            undeliveredElementException = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(function1, obj, null, 2, null);
        }
        this.value = element;
        return undeliveredElementException;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected boolean enqueueReceiveInternal(@NotNull Receive<? super E> receive) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return super.enqueueReceiveInternal(receive);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    @NotNull
    protected String getBufferDebugString() {
        return "(value=" + this.value + ')';
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected final boolean isBufferAlwaysEmpty() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    protected final boolean isBufferAlwaysFull() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected final boolean isBufferEmpty() {
        if (this.value == AbstractChannelKt.EMPTY) {
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    protected final boolean isBufferFull() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel, kotlinx.coroutines.channels.ReceiveChannel
    public boolean isEmpty() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return isEmptyImpl();
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x001a, code lost:
    
        if ((r1 instanceof kotlinx.coroutines.channels.Closed) == false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0025, code lost:
    
        if (r1.tryResumeReceive(r4, null) == null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0027, code lost:
    
        r2 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0029, code lost:
    
        r0.unlock();
        r1.completeResumeReceive(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0033, code lost:
    
        return r1.getOfferResult();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x001f, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0034, code lost:
    
        r4 = updateValueLocked(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0038, code lost:
    
        if (r4 != null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x003f, code lost:
    
        return kotlinx.coroutines.channels.AbstractChannelKt.OFFER_SUCCESS;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0040, code lost:
    
        throw r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x000f, code lost:
    
        if (r3.value == kotlinx.coroutines.channels.AbstractChannelKt.EMPTY) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0011, code lost:
    
        r1 = takeFirstReceiveOrPeekClosed();
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0015, code lost:
    
        if (r1 != null) goto L10;
     */
    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object offerInternal(E element) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Closed<?> closedForSend = getClosedForSend();
            if (closedForSend != null) {
                return closedForSend;
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    @NotNull
    protected Object offerSelectInternal(E element, @NotNull SelectInstance<?> select) {
        Object performAtomicTrySelect;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Closed<?> closedForSend = getClosedForSend();
            if (closedForSend == null) {
                if (this.value == AbstractChannelKt.EMPTY) {
                    do {
                        AbstractSendChannel.TryOfferDesc<E> describeTryOffer = describeTryOffer(element);
                        performAtomicTrySelect = select.performAtomicTrySelect(describeTryOffer);
                        if (performAtomicTrySelect == null) {
                            ReceiveOrClosed<? super E> result = describeTryOffer.getResult();
                            Unit unit = Unit.INSTANCE;
                            reentrantLock.unlock();
                            Intrinsics.checkNotNull(result);
                            ReceiveOrClosed<? super E> receiveOrClosed = result;
                            receiveOrClosed.completeResumeReceive(element);
                            return receiveOrClosed.getOfferResult();
                        }
                        if (performAtomicTrySelect == AbstractChannelKt.OFFER_FAILED) {
                        }
                    } while (performAtomicTrySelect == AtomicKt.RETRY_ATOMIC);
                    if (performAtomicTrySelect != SelectKt.getALREADY_SELECTED() && !(performAtomicTrySelect instanceof Closed)) {
                        throw new IllegalStateException(Intrinsics.stringPlus("performAtomicTrySelect(describeTryOffer) returned ", performAtomicTrySelect).toString());
                    }
                    return performAtomicTrySelect;
                }
                if (!select.trySelect()) {
                    return SelectKt.getALREADY_SELECTED();
                }
                UndeliveredElementException updateValueLocked = updateValueLocked(element);
                if (updateValueLocked == null) {
                    return AbstractChannelKt.OFFER_SUCCESS;
                }
                throw updateValueLocked;
            }
            return closedForSend;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected void onCancelIdempotent(boolean wasClosed) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            UndeliveredElementException updateValueLocked = updateValueLocked(AbstractChannelKt.EMPTY);
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            super.onCancelIdempotent(wasClosed);
            if (updateValueLocked == null) {
            } else {
                throw updateValueLocked;
            }
        } catch (Throwable th5) {
            reentrantLock.unlock();
            throw th5;
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    @Nullable
    protected Object pollInternal() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Object obj = this.value;
            Symbol symbol = AbstractChannelKt.EMPTY;
            if (obj == symbol) {
                Object closedForSend = getClosedForSend();
                if (closedForSend == null) {
                    closedForSend = AbstractChannelKt.POLL_FAILED;
                }
                return closedForSend;
            }
            this.value = symbol;
            Unit unit = Unit.INSTANCE;
            return obj;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    @Nullable
    protected Object pollSelectInternal(@NotNull SelectInstance<?> select) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Object obj = this.value;
            Symbol symbol = AbstractChannelKt.EMPTY;
            if (obj == symbol) {
                Object closedForSend = getClosedForSend();
                if (closedForSend == null) {
                    closedForSend = AbstractChannelKt.POLL_FAILED;
                }
                return closedForSend;
            }
            if (!select.trySelect()) {
                return SelectKt.getALREADY_SELECTED();
            }
            Object obj2 = this.value;
            this.value = symbol;
            Unit unit = Unit.INSTANCE;
            return obj2;
        } finally {
            reentrantLock.unlock();
        }
    }
}
