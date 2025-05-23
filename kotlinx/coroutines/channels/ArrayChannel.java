package kotlinx.coroutines.channels;

import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.AbstractChannel;
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
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000BB9\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012 \u0010\t\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\b\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000e\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00028\u0000H\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0013\u001a\u00020\u00122\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H\u0014\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0014\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00172\u0006\u0010\r\u001a\u00028\u0000H\u0014\u00a2\u0006\u0004\b\u001c\u0010\u001dJ#\u0010 \u001a\u00020\u00172\u0006\u0010\r\u001a\u00028\u00002\n\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030\u001eH\u0014\u00a2\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0012H\u0014\u00a2\u0006\u0004\b#\u0010$J\u0011\u0010%\u001a\u0004\u0018\u00010\u0017H\u0014\u00a2\u0006\u0004\b%\u0010&J\u001d\u0010'\u001a\u0004\u0018\u00010\u00172\n\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030\u001eH\u0014\u00a2\u0006\u0004\b'\u0010(J\u0019\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010\f\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b*\u0010+R\u001e\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00102\u001a\u00020/8T@\u0014X\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b0\u00101R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u00103R\u0016\u00104\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00103R\u0016\u00105\u001a\u00020\u00128D@\u0004X\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b5\u00106R\u0016\u00107\u001a\u00020\u00128D@\u0004X\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b7\u00106R\u0016\u00108\u001a\u00020\u00128D@\u0004X\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b8\u00106R\u0016\u00109\u001a\u00020\u00128D@\u0004X\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b9\u00106R\u0016\u0010:\u001a\u00020\u00128V@\u0016X\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b:\u00106R\u0016\u0010;\u001a\u00020\u00128V@\u0016X\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b;\u00106R\u001a\u0010>\u001a\u00060<j\u0002`=8\u0002@\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010@\u00a8\u0006A"}, d2 = {"Lkotlinx/coroutines/channels/ArrayChannel;", "E", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(ILkotlinx/coroutines/channels/BufferOverflow;Lkotlin/jvm/functions/Function1;)V", "currentSize", DTConstants.TAG.ELEMENT, "enqueueElement", "(ILjava/lang/Object;)V", "Lkotlinx/coroutines/channels/Receive;", "receive", "", "enqueueReceiveInternal", "(Lkotlinx/coroutines/channels/Receive;)Z", "Lkotlinx/coroutines/channels/Send;", "send", "", "enqueueSend", "(Lkotlinx/coroutines/channels/Send;)Ljava/lang/Object;", "ensureCapacity", "(I)V", "offerInternal", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "offerSelectInternal", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "wasClosed", "onCancelIdempotent", "(Z)V", "pollInternal", "()Ljava/lang/Object;", "pollSelectInternal", "(Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/Symbol;", "updateBufferSize", "(I)Lkotlinx/coroutines/internal/Symbol;", "", "buffer", "[Ljava/lang/Object;", "", "getBufferDebugString", "()Ljava/lang/String;", "bufferDebugString", "I", "head", "isBufferAlwaysEmpty", "()Z", "isBufferAlwaysFull", "isBufferEmpty", "isBufferFull", "isClosedForReceive", "isEmpty", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", JoinPoint.SYNCHRONIZATION_LOCK, "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/channels/BufferOverflow;", "kotlinx-coroutines-core", "Lkotlinx/coroutines/channels/AbstractChannel;"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public class ArrayChannel<E> extends AbstractChannel<E> {

    @NotNull
    private Object[] buffer;
    private final int capacity;
    private int head;

    @NotNull
    private final ReentrantLock lock;

    @NotNull
    private final BufferOverflow onBufferOverflow;

    @NotNull
    private volatile /* synthetic */ int size;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes28.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BufferOverflow.valuesCustom().length];
            iArr[BufferOverflow.SUSPEND.ordinal()] = 1;
            iArr[BufferOverflow.DROP_LATEST.ordinal()] = 2;
            iArr[BufferOverflow.DROP_OLDEST.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ArrayChannel(int i3, @NotNull BufferOverflow bufferOverflow, @Nullable Function1<? super E, Unit> function1) {
        super(function1);
        this.capacity = i3;
        this.onBufferOverflow = bufferOverflow;
        if (i3 >= 1) {
            this.lock = new ReentrantLock();
            Object[] objArr = new Object[Math.min(i3, 8)];
            ArraysKt___ArraysJvmKt.fill$default(objArr, AbstractChannelKt.EMPTY, 0, 0, 6, (Object) null);
            Unit unit = Unit.INSTANCE;
            this.buffer = objArr;
            this.size = 0;
            return;
        }
        throw new IllegalArgumentException(("ArrayChannel capacity must be at least 1, but " + i3 + " was specified").toString());
    }

    private final void enqueueElement(int currentSize, E element) {
        if (currentSize < this.capacity) {
            ensureCapacity(currentSize);
            Object[] objArr = this.buffer;
            objArr[(this.head + currentSize) % objArr.length] = element;
        } else {
            Object[] objArr2 = this.buffer;
            int i3 = this.head;
            objArr2[i3 % objArr2.length] = null;
            objArr2[(currentSize + i3) % objArr2.length] = element;
            this.head = (i3 + 1) % objArr2.length;
        }
    }

    private final void ensureCapacity(int currentSize) {
        Object[] objArr = this.buffer;
        if (currentSize >= objArr.length) {
            int min = Math.min(objArr.length * 2, this.capacity);
            Object[] objArr2 = new Object[min];
            if (currentSize > 0) {
                int i3 = 0;
                while (true) {
                    int i16 = i3 + 1;
                    Object[] objArr3 = this.buffer;
                    objArr2[i3] = objArr3[(this.head + i3) % objArr3.length];
                    if (i16 >= currentSize) {
                        break;
                    } else {
                        i3 = i16;
                    }
                }
            }
            ArraysKt___ArraysJvmKt.fill((Symbol[]) objArr2, AbstractChannelKt.EMPTY, currentSize, min);
            this.buffer = objArr2;
            this.head = 0;
        }
    }

    private final Symbol updateBufferSize(int currentSize) {
        if (currentSize < this.capacity) {
            this.size = currentSize + 1;
            return null;
        }
        int i3 = WhenMappings.$EnumSwitchMapping$0[this.onBufferOverflow.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    return null;
                }
                throw new NoWhenBranchMatchedException();
            }
            return AbstractChannelKt.OFFER_SUCCESS;
        }
        return AbstractChannelKt.OFFER_FAILED;
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
    @Nullable
    protected Object enqueueSend(@NotNull Send send) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return super.enqueueSend(send);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    @NotNull
    protected String getBufferDebugString() {
        return "(buffer:capacity=" + this.capacity + ",size=" + this.size + ')';
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
        if (this.size == 0) {
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    protected final boolean isBufferFull() {
        if (this.size == this.capacity && this.onBufferOverflow == BufferOverflow.SUSPEND) {
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel, kotlinx.coroutines.channels.ReceiveChannel
    public boolean isClosedForReceive() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return super.isClosedForReceive();
        } finally {
            reentrantLock.unlock();
        }
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

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001e, code lost:
    
        if ((r2 instanceof kotlinx.coroutines.channels.Closed) == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002b, code lost:
    
        if (r2.tryResumeReceive(r5, null) == null) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002d, code lost:
    
        r4.size = r1;
        r1 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0031, code lost:
    
        r0.unlock();
        r2.completeResumeReceive(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003b, code lost:
    
        return r2.getOfferResult();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0020, code lost:
    
        r4.size = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0025, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003c, code lost:
    
        enqueueElement(r1, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0044, code lost:
    
        return kotlinx.coroutines.channels.AbstractChannelKt.OFFER_SUCCESS;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0013, code lost:
    
        if (r1 == 0) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0015, code lost:
    
        r2 = takeFirstReceiveOrPeekClosed();
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0019, code lost:
    
        if (r2 != null) goto L11;
     */
    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected Object offerInternal(E element) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            int i3 = this.size;
            Closed<?> closedForSend = getClosedForSend();
            if (closedForSend == null) {
                Symbol updateBufferSize = updateBufferSize(i3);
                if (updateBufferSize != null) {
                    return updateBufferSize;
                }
            } else {
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
            int i3 = this.size;
            Closed<?> closedForSend = getClosedForSend();
            if (closedForSend == null) {
                Symbol updateBufferSize = updateBufferSize(i3);
                if (updateBufferSize == null) {
                    if (i3 == 0) {
                        do {
                            AbstractSendChannel.TryOfferDesc<E> describeTryOffer = describeTryOffer(element);
                            performAtomicTrySelect = select.performAtomicTrySelect(describeTryOffer);
                            if (performAtomicTrySelect == null) {
                                this.size = i3;
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
                        this.size = i3;
                        return performAtomicTrySelect;
                    }
                    if (!select.trySelect()) {
                        this.size = i3;
                        return SelectKt.getALREADY_SELECTED();
                    }
                    enqueueElement(i3, element);
                    return AbstractChannelKt.OFFER_SUCCESS;
                }
                return updateBufferSize;
            }
            return closedForSend;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected void onCancelIdempotent(boolean wasClosed) {
        Function1<E, Unit> function1 = this.onUndeliveredElement;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            int i3 = this.size;
            UndeliveredElementException undeliveredElementException = null;
            for (int i16 = 0; i16 < i3; i16++) {
                Object obj = this.buffer[this.head];
                if (function1 != null && obj != AbstractChannelKt.EMPTY) {
                    undeliveredElementException = OnUndeliveredElementKt.callUndeliveredElementCatchingException(function1, obj, undeliveredElementException);
                }
                Object[] objArr = this.buffer;
                int i17 = this.head;
                objArr[i17] = AbstractChannelKt.EMPTY;
                this.head = (i17 + 1) % objArr.length;
            }
            this.size = 0;
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            super.onCancelIdempotent(wasClosed);
            if (undeliveredElementException != null) {
                throw undeliveredElementException;
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
            int i3 = this.size;
            if (i3 == 0) {
                Object closedForSend = getClosedForSend();
                if (closedForSend == null) {
                    closedForSend = AbstractChannelKt.POLL_FAILED;
                }
                return closedForSend;
            }
            Object[] objArr = this.buffer;
            int i16 = this.head;
            Object obj = objArr[i16];
            Send send = null;
            objArr[i16] = null;
            this.size = i3 - 1;
            Object obj2 = AbstractChannelKt.POLL_FAILED;
            boolean z16 = false;
            if (i3 == this.capacity) {
                Send send2 = null;
                while (true) {
                    Send takeFirstSendOrPeekClosed = takeFirstSendOrPeekClosed();
                    if (takeFirstSendOrPeekClosed == null) {
                        send = send2;
                        break;
                    }
                    if (takeFirstSendOrPeekClosed.tryResumeSend(null) != null) {
                        obj2 = takeFirstSendOrPeekClosed.getElement();
                        z16 = true;
                        send = takeFirstSendOrPeekClosed;
                        break;
                    }
                    takeFirstSendOrPeekClosed.undeliveredElement();
                    send2 = takeFirstSendOrPeekClosed;
                }
            }
            if (obj2 != AbstractChannelKt.POLL_FAILED && !(obj2 instanceof Closed)) {
                this.size = i3;
                Object[] objArr2 = this.buffer;
                objArr2[(this.head + i3) % objArr2.length] = obj2;
            }
            this.head = (this.head + 1) % this.buffer.length;
            Unit unit = Unit.INSTANCE;
            if (z16) {
                Intrinsics.checkNotNull(send);
                send.completeResumeSend();
            }
            return obj;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0093 A[Catch: all -> 0x00bc, TRY_LEAVE, TryCatch #0 {all -> 0x00bc, blocks: (B:3:0x0005, B:5:0x0009, B:7:0x000f, B:11:0x0015, B:13:0x0029, B:49:0x0033, B:29:0x0079, B:31:0x007d, B:33:0x0081, B:34:0x00a3, B:39:0x008d, B:41:0x0093, B:15:0x0043, B:17:0x0048, B:21:0x004d, B:23:0x0053, B:26:0x005f, B:44:0x0067, B:45:0x0077), top: B:2:0x0005 }] */
    @Override // kotlinx.coroutines.channels.AbstractChannel
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected Object pollSelectInternal(@NotNull SelectInstance<?> select) {
        boolean z16;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            int i3 = this.size;
            if (i3 == 0) {
                Object closedForSend = getClosedForSend();
                if (closedForSend == null) {
                    closedForSend = AbstractChannelKt.POLL_FAILED;
                }
                return closedForSend;
            }
            Object[] objArr = this.buffer;
            int i16 = this.head;
            Object obj = objArr[i16];
            Object obj2 = null;
            objArr[i16] = null;
            this.size = i3 - 1;
            Object obj3 = AbstractChannelKt.POLL_FAILED;
            if (i3 == this.capacity) {
                while (true) {
                    AbstractChannel.TryPollDesc<E> describeTryPoll = describeTryPoll();
                    Object performAtomicTrySelect = select.performAtomicTrySelect(describeTryPoll);
                    if (performAtomicTrySelect == null) {
                        obj2 = describeTryPoll.getResult();
                        Intrinsics.checkNotNull(obj2);
                        obj3 = ((Send) obj2).getElement();
                        z16 = true;
                        break;
                    }
                    if (performAtomicTrySelect == AbstractChannelKt.POLL_FAILED) {
                        break;
                    }
                    if (performAtomicTrySelect != AtomicKt.RETRY_ATOMIC) {
                        if (performAtomicTrySelect == SelectKt.getALREADY_SELECTED()) {
                            this.size = i3;
                            this.buffer[this.head] = obj;
                            return performAtomicTrySelect;
                        }
                        if (performAtomicTrySelect instanceof Closed) {
                            z16 = true;
                            obj3 = performAtomicTrySelect;
                            obj2 = obj3;
                        } else {
                            throw new IllegalStateException(Intrinsics.stringPlus("performAtomicTrySelect(describeTryOffer) returned ", performAtomicTrySelect).toString());
                        }
                    }
                }
                if (obj3 == AbstractChannelKt.POLL_FAILED && !(obj3 instanceof Closed)) {
                    this.size = i3;
                    Object[] objArr2 = this.buffer;
                    objArr2[(this.head + i3) % objArr2.length] = obj3;
                } else if (!select.trySelect()) {
                    this.size = i3;
                    this.buffer[this.head] = obj;
                    return SelectKt.getALREADY_SELECTED();
                }
                this.head = (this.head + 1) % this.buffer.length;
                Unit unit = Unit.INSTANCE;
                if (z16) {
                    Intrinsics.checkNotNull(obj2);
                    ((Send) obj2).completeResumeSend();
                }
                return obj;
            }
            z16 = false;
            if (obj3 == AbstractChannelKt.POLL_FAILED) {
            }
            if (!select.trySelect()) {
            }
            this.head = (this.head + 1) % this.buffer.length;
            Unit unit2 = Unit.INSTANCE;
            if (z16) {
            }
            return obj;
        } finally {
            reentrantLock.unlock();
        }
    }
}
