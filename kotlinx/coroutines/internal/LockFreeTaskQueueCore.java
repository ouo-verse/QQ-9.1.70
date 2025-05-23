package kotlinx.coroutines.internal;

import ADV_REPORT.mobile_adv_report_req;
import com.google.common.util.concurrent.b;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mtt.hippy.dom.node.TextNode;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0016\b\u0000\u0018\u0000 /*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001:\u0002/0B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00028\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ'\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0000j\b\u0012\u0004\u0012\u00028\u0000`\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0000j\b\u0012\u0004\u0012\u00028\u0000`\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0010J\r\u0010\u0012\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0012\u0010\u0013J3\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u000e2\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\t\u001a\u00028\u0000H\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0017\u0010\u0013J-\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00010\u001b\"\u0004\b\u0001\u0010\u00182\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0019\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\fH\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0013\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u0000\u00a2\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\u0004\b\"\u0010#J3\u0010&\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u000e2\u0006\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u0003H\u0002\u00a2\u0006\u0004\b&\u0010'R\u0016\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010(R\u0013\u0010)\u001a\u00020\u00058F@\u0006\u00a2\u0006\u0006\u001a\u0004\b)\u0010\u0013R\u0016\u0010*\u001a\u00020\u00038\u0002@\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010(R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010+R\u0013\u0010.\u001a\u00020\u00038F@\u0006\u00a2\u0006\u0006\u001a\u0004\b,\u0010-\u00a8\u00061"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "", "E", "", "capacity", "", "singleConsumer", "<init>", "(IZ)V", DTConstants.TAG.ELEMENT, "addLast", "(Ljava/lang/Object;)I", "", "state", "Lkotlinx/coroutines/internal/Core;", "allocateNextCopy", "(J)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "allocateOrGetNextCopy", "close", "()Z", "index", "fillPlaceholder", "(ILjava/lang/Object;)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "isClosed", BdhLogUtil.LogTag.Tag_Req, "Lkotlin/Function1;", "transform", "", "map", "(Lkotlin/jvm/functions/Function1;)Ljava/util/List;", "markFrozen", "()J", "next", "()Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "removeFirstOrNull", "()Ljava/lang/Object;", "oldHead", "newHead", "removeSlowPath", "(II)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "I", "isEmpty", "mask", "Z", "getSize", "()I", "size", "Companion", "Placeholder", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class LockFreeTaskQueueCore<E> {
    public static final int ADD_CLOSED = 2;
    public static final int ADD_FROZEN = 1;
    public static final int ADD_SUCCESS = 0;
    public static final int CAPACITY_BITS = 30;
    public static final long CLOSED_MASK = 2305843009213693952L;
    public static final int CLOSED_SHIFT = 61;
    public static final long FROZEN_MASK = 1152921504606846976L;
    public static final int FROZEN_SHIFT = 60;
    public static final long HEAD_MASK = 1073741823;
    public static final int HEAD_SHIFT = 0;
    public static final int INITIAL_CAPACITY = 8;
    public static final int MAX_CAPACITY_MASK = 1073741823;
    public static final int MIN_ADD_SPIN_CAPACITY = 1024;
    public static final long TAIL_MASK = 1152921503533105152L;
    public static final int TAIL_SHIFT = 30;

    @NotNull
    private volatile /* synthetic */ Object _next = null;

    @NotNull
    private volatile /* synthetic */ long _state = 0;

    @NotNull
    private /* synthetic */ AtomicReferenceArray array;
    private final int capacity;
    private final int mask;
    private final boolean singleConsumer;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @JvmField
    @NotNull
    public static final Symbol REMOVE_FROZEN = new Symbol("REMOVE_FROZEN");
    private static final /* synthetic */ AtomicReferenceFieldUpdater _next$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeTaskQueueCore.class, Object.class, "_next");
    private static final /* synthetic */ AtomicLongFieldUpdater _state$FU = AtomicLongFieldUpdater.newUpdater(LockFreeTaskQueueCore.class, "_state");

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\n\u0010\u0016\u001a\u00020\u0004*\u00020\tJ\u0012\u0010\u0017\u001a\u00020\t*\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0004J\u0012\u0010\u0019\u001a\u00020\t*\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0004JP\u0010\u001b\u001a\u0002H\u001c\"\u0004\b\u0001\u0010\u001c*\u00020\t26\u0010\u001d\u001a2\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\"\u0012\u0004\u0012\u0002H\u001c0\u001eH\u0086\b\u00a2\u0006\u0002\u0010#J\u0015\u0010$\u001a\u00020\t*\u00020\t2\u0006\u0010%\u001a\u00020\tH\u0086\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u00138\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore$Companion;", "", "()V", "ADD_CLOSED", "", "ADD_FROZEN", "ADD_SUCCESS", "CAPACITY_BITS", "CLOSED_MASK", "", "CLOSED_SHIFT", "FROZEN_MASK", "FROZEN_SHIFT", "HEAD_MASK", "HEAD_SHIFT", "INITIAL_CAPACITY", "MAX_CAPACITY_MASK", "MIN_ADD_SPIN_CAPACITY", "REMOVE_FROZEN", "Lkotlinx/coroutines/internal/Symbol;", "TAIL_MASK", "TAIL_SHIFT", "addFailReason", "updateHead", "newHead", "updateTail", "newTail", "withState", "T", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "head", TextNode.MODE_TAIL, "(JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "wo", "other", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes28.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int addFailReason(long j3) {
            if ((j3 & LockFreeTaskQueueCore.CLOSED_MASK) != 0) {
                return 2;
            }
            return 1;
        }

        public final long updateHead(long j3, int i3) {
            return wo(j3, LockFreeTaskQueueCore.HEAD_MASK) | (i3 << 0);
        }

        public final long updateTail(long j3, int i3) {
            return wo(j3, LockFreeTaskQueueCore.TAIL_MASK) | (i3 << 30);
        }

        public final <T> T withState(long j3, @NotNull Function2<? super Integer, ? super Integer, ? extends T> function2) {
            return function2.invoke(Integer.valueOf((int) ((LockFreeTaskQueueCore.HEAD_MASK & j3) >> 0)), Integer.valueOf((int) ((j3 & LockFreeTaskQueueCore.TAIL_MASK) >> 30)));
        }

        public final long wo(long j3, long j16) {
            return j3 & (~j16);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore$Placeholder;", "", "index", "", "(I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes28.dex */
    public static final class Placeholder {

        @JvmField
        public final int index;

        public Placeholder(int i3) {
            this.index = i3;
        }
    }

    public LockFreeTaskQueueCore(int i3, boolean z16) {
        boolean z17;
        this.capacity = i3;
        this.singleConsumer = z16;
        int i16 = i3 - 1;
        this.mask = i16;
        this.array = new AtomicReferenceArray(i3);
        if (i16 <= 1073741823) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            if ((i3 & i16) == 0) {
                return;
            } else {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final LockFreeTaskQueueCore<E> allocateNextCopy(long state) {
        LockFreeTaskQueueCore<E> lockFreeTaskQueueCore = new LockFreeTaskQueueCore<>(this.capacity * 2, this.singleConsumer);
        int i3 = (int) ((HEAD_MASK & state) >> 0);
        int i16 = (int) ((TAIL_MASK & state) >> 30);
        while (true) {
            int i17 = this.mask;
            if ((i3 & i17) != (i16 & i17)) {
                Object obj = this.array.get(i17 & i3);
                if (obj == null) {
                    obj = new Placeholder(i3);
                }
                lockFreeTaskQueueCore.array.set(lockFreeTaskQueueCore.mask & i3, obj);
                i3++;
            } else {
                lockFreeTaskQueueCore._state = INSTANCE.wo(state, 1152921504606846976L);
                return lockFreeTaskQueueCore;
            }
        }
    }

    private final LockFreeTaskQueueCore<E> allocateOrGetNextCopy(long state) {
        while (true) {
            LockFreeTaskQueueCore<E> lockFreeTaskQueueCore = (LockFreeTaskQueueCore) this._next;
            if (lockFreeTaskQueueCore != null) {
                return lockFreeTaskQueueCore;
            }
            b.a(_next$FU, this, null, allocateNextCopy(state));
        }
    }

    private final LockFreeTaskQueueCore<E> fillPlaceholder(int index, E element) {
        Object obj = this.array.get(this.mask & index);
        if ((obj instanceof Placeholder) && ((Placeholder) obj).index == index) {
            this.array.set(index & this.mask, element);
            return this;
        }
        return null;
    }

    private final long markFrozen() {
        long j3;
        long j16;
        do {
            j3 = this._state;
            if ((j3 & 1152921504606846976L) != 0) {
                return j3;
            }
            j16 = j3 | 1152921504606846976L;
        } while (!_state$FU.compareAndSet(this, j3, j16));
        return j16;
    }

    private final LockFreeTaskQueueCore<E> removeSlowPath(int oldHead, int newHead) {
        long j3;
        int i3;
        do {
            j3 = this._state;
            i3 = (int) ((HEAD_MASK & j3) >> 0);
            if ((1152921504606846976L & j3) != 0) {
                return next();
            }
        } while (!_state$FU.compareAndSet(this, j3, INSTANCE.updateHead(j3, newHead)));
        this.array.set(i3 & this.mask, null);
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x004c, code lost:
    
        return 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int addLast(@NotNull E element) {
        while (true) {
            long j3 = this._state;
            if ((3458764513820540928L & j3) != 0) {
                return INSTANCE.addFailReason(j3);
            }
            int i3 = (int) ((HEAD_MASK & j3) >> 0);
            int i16 = (int) ((TAIL_MASK & j3) >> 30);
            int i17 = this.mask;
            if (((i16 + 2) & i17) == (i3 & i17)) {
                return 1;
            }
            if (!this.singleConsumer && this.array.get(i16 & i17) != null) {
                int i18 = this.capacity;
                if (i18 < 1024 || ((i16 - i3) & MAX_CAPACITY_MASK) > (i18 >> 1)) {
                    break;
                }
            } else if (_state$FU.compareAndSet(this, j3, INSTANCE.updateTail(j3, (i16 + 1) & MAX_CAPACITY_MASK))) {
                this.array.set(i16 & i17, element);
                LockFreeTaskQueueCore<E> lockFreeTaskQueueCore = this;
                while ((lockFreeTaskQueueCore._state & 1152921504606846976L) != 0 && (lockFreeTaskQueueCore = lockFreeTaskQueueCore.next().fillPlaceholder(i16, element)) != null) {
                }
                return 0;
            }
        }
    }

    public final boolean close() {
        long j3;
        do {
            j3 = this._state;
            if ((j3 & CLOSED_MASK) != 0) {
                return true;
            }
            if ((1152921504606846976L & j3) != 0) {
                return false;
            }
        } while (!_state$FU.compareAndSet(this, j3, j3 | CLOSED_MASK));
        return true;
    }

    public final int getSize() {
        long j3 = this._state;
        return (((int) ((j3 & TAIL_MASK) >> 30)) - ((int) ((HEAD_MASK & j3) >> 0))) & MAX_CAPACITY_MASK;
    }

    public final boolean isClosed() {
        if ((this._state & CLOSED_MASK) != 0) {
            return true;
        }
        return false;
    }

    public final boolean isEmpty() {
        long j3 = this._state;
        if (((int) ((HEAD_MASK & j3) >> 0)) != ((int) ((j3 & TAIL_MASK) >> 30))) {
            return false;
        }
        return true;
    }

    @NotNull
    public final <R> List<R> map(@NotNull Function1<? super E, ? extends R> transform) {
        ArrayList arrayList = new ArrayList(this.capacity);
        long j3 = this._state;
        int i3 = (int) ((HEAD_MASK & j3) >> 0);
        int i16 = (int) ((j3 & TAIL_MASK) >> 30);
        while (true) {
            int i17 = this.mask;
            if ((i3 & i17) != (i16 & i17)) {
                mobile_adv_report_req mobile_adv_report_reqVar = (Object) this.array.get(i17 & i3);
                if (mobile_adv_report_reqVar != null && !(mobile_adv_report_reqVar instanceof Placeholder)) {
                    arrayList.add(transform.invoke(mobile_adv_report_reqVar));
                }
                i3++;
            } else {
                return arrayList;
            }
        }
    }

    @NotNull
    public final LockFreeTaskQueueCore<E> next() {
        return allocateOrGetNextCopy(markFrozen());
    }

    @Nullable
    public final Object removeFirstOrNull() {
        while (true) {
            long j3 = this._state;
            if ((1152921504606846976L & j3) != 0) {
                return REMOVE_FROZEN;
            }
            int i3 = (int) ((HEAD_MASK & j3) >> 0);
            int i16 = (int) ((TAIL_MASK & j3) >> 30);
            int i17 = this.mask;
            if ((i16 & i17) == (i3 & i17)) {
                return null;
            }
            Object obj = this.array.get(i17 & i3);
            if (obj == null) {
                if (this.singleConsumer) {
                    return null;
                }
            } else {
                if (obj instanceof Placeholder) {
                    return null;
                }
                int i18 = (i3 + 1) & MAX_CAPACITY_MASK;
                if (_state$FU.compareAndSet(this, j3, INSTANCE.updateHead(j3, i18))) {
                    this.array.set(this.mask & i3, null);
                    return obj;
                }
                if (this.singleConsumer) {
                    LockFreeTaskQueueCore<E> lockFreeTaskQueueCore = this;
                    do {
                        lockFreeTaskQueueCore = lockFreeTaskQueueCore.removeSlowPath(i3, i18);
                    } while (lockFreeTaskQueueCore != null);
                    return obj;
                }
            }
        }
    }
}
