package com.tencent.mobileqq.qcoroutine.souce;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.atomicfu.AtomicArray;
import kotlinx.atomicfu.AtomicFU;
import kotlinx.atomicfu.AtomicFU_commonKt;
import kotlinx.atomicfu.AtomicLong;
import kotlinx.atomicfu.AtomicRef;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0000\u0018\u0000 \u0013*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001:\u0002\u0011\u0010B\u0017\u0012\u0006\u0010!\u001a\u00020\u0003\u0012\u0006\u0010$\u001a\u00020\"\u00a2\u0006\u0004\b'\u0010(J3\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00028\u0000H\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ,\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u00062\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003H\u0002J\b\u0010\r\u001a\u00020\fH\u0002J \u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0000j\b\u0012\u0004\u0012\u00028\u0000`\u00062\u0006\u0010\u000e\u001a\u00020\fH\u0002J \u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0000j\b\u0012\u0004\u0012\u00028\u0000`\u00062\u0006\u0010\u000e\u001a\u00020\fH\u0002J\u0015\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001J\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000R\u0014\u0010\u0016\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0015R.\u0010\u0019\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u00060\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u001bR\u001c\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001eR\u0014\u0010!\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010\u0015R\u0014\u0010$\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010#R\u0011\u0010&\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b \u0010%\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/qcoroutine/souce/b;", "", "E", "", "index", DTConstants.TAG.ELEMENT, "Lcom/tencent/mobileqq/qcoroutine/souce/Core;", "d", "(ILjava/lang/Object;)Lcom/tencent/mobileqq/qcoroutine/souce/b;", "oldHead", "newHead", "i", "", "f", "state", "c", "b", "a", "(Ljava/lang/Object;)I", h.F, "g", "I", "mask", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/atomicfu/AtomicRef;", "_next", "Lkotlinx/atomicfu/AtomicLong;", "Lkotlinx/atomicfu/AtomicLong;", "_state", "Lkotlinx/atomicfu/AtomicArray;", "Lkotlinx/atomicfu/AtomicArray;", HippyControllerProps.ARRAY, "e", "capacity", "", "Z", "singleConsumer", "()I", "size", "<init>", "(IZ)V", "QCoroutine_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes16.dex */
public final class b<E> {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final e f261847g;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int mask;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final AtomicRef<b<E>> _next;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final AtomicLong _state;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final AtomicArray<Object> array;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int capacity;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final boolean singleConsumer;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\u0015\u0010\u0004\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0086\u0004J\u0012\u0010\u0007\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u0012\u0010\t\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\b\u001a\u00020\u0005J\n\u0010\n\u001a\u00020\u0005*\u00020\u0002R\u0014\u0010\u000b\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\fR\u0014\u0010\u0010\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\fR\u0014\u0010\u0013\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\fR\u0014\u0010\u0015\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\fR\u0014\u0010\u0017\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\fR\u0014\u0010\u0018\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\fR\u0014\u0010\u0019\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\fR\u0014\u0010\u001b\u001a\u00020\u001a8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0011R\u0014\u0010\u001e\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\f\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/qcoroutine/souce/b$a;", "", "", "other", "d", "", "newHead", "b", "newTail", "c", "a", "ADD_CLOSED", "I", "ADD_FROZEN", "ADD_SUCCESS", "CAPACITY_BITS", "CLOSED_MASK", "J", "CLOSED_SHIFT", "FROZEN_MASK", "FROZEN_SHIFT", "HEAD_MASK", "HEAD_SHIFT", "INITIAL_CAPACITY", "MAX_CAPACITY_MASK", "MIN_ADD_SPIN_CAPACITY", "Lcom/tencent/mobileqq/qcoroutine/souce/e;", "REMOVE_FROZEN", "Lcom/tencent/mobileqq/qcoroutine/souce/e;", "TAIL_MASK", "TAIL_SHIFT", "<init>", "()V", "QCoroutine_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.mobileqq.qcoroutine.souce.b$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                return;
            }
            iPatchRedirector.redirect((short) 6, (Object) this);
        }

        public final int a(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, j3)).intValue();
            }
            if ((j3 & LockFreeTaskQueueCore.CLOSED_MASK) != 0) {
                return 2;
            }
            return 1;
        }

        public final long b(long j3, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Long) iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), Integer.valueOf(i3))).longValue();
            }
            return d(j3, LockFreeTaskQueueCore.HEAD_MASK) | (i3 << 0);
        }

        public final long c(long j3, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Long) iPatchRedirector.redirect((short) 3, this, Long.valueOf(j3), Integer.valueOf(i3))).longValue();
            }
            return d(j3, LockFreeTaskQueueCore.TAIL_MASK) | (i3 << 30);
        }

        public final long d(long j3, long j16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return ((Long) iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Long.valueOf(j16))).longValue();
            }
            return j3 & (~j16);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
                return;
            }
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/qcoroutine/souce/b$b;", "", "", "a", "I", "index", "<init>", "(I)V", "QCoroutine_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.mobileqq.qcoroutine.souce.b$b, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public static final class C8283b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @JvmField
        public final int index;

        public C8283b(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3);
            } else {
                this.index = i3;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11961);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
            f261847g = new e("REMOVE_FROZEN");
        }
    }

    public b(int i3, boolean z16) {
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        this.capacity = i3;
        this.singleConsumer = z16;
        int i16 = i3 - 1;
        this.mask = i16;
        this._next = AtomicFU.atomic((Object) null);
        this._state = AtomicFU.atomic(0L);
        this.array = AtomicFU_commonKt.atomicArrayOfNulls(i3);
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

    private final b<E> b(long state) {
        b<E> bVar = new b<>(this.capacity * 2, this.singleConsumer);
        int i3 = (int) ((LockFreeTaskQueueCore.HEAD_MASK & state) >> 0);
        int i16 = (int) ((LockFreeTaskQueueCore.TAIL_MASK & state) >> 30);
        while (true) {
            int i17 = this.mask;
            if ((i3 & i17) != (i16 & i17)) {
                Object value = this.array.get(i17 & i3).getValue();
                if (value == null) {
                    value = new C8283b(i3);
                }
                bVar.array.get(bVar.mask & i3).setValue(value);
                i3++;
            } else {
                bVar._state.setValue(INSTANCE.d(state, 1152921504606846976L));
                return bVar;
            }
        }
    }

    private final b<E> c(long state) {
        AtomicRef<b<E>> atomicRef = this._next;
        while (true) {
            b<E> value = atomicRef.getValue();
            if (value != null) {
                return value;
            }
            this._next.compareAndSet(null, b(state));
        }
    }

    private final b<E> d(int index, E element) {
        Object value = this.array.get(this.mask & index).getValue();
        if ((value instanceof C8283b) && ((C8283b) value).index == index) {
            this.array.get(index & this.mask).setValue(element);
            return this;
        }
        return null;
    }

    private final long f() {
        long value;
        long j3;
        AtomicLong atomicLong = this._state;
        do {
            value = atomicLong.getValue();
            if ((value & 1152921504606846976L) != 0) {
                return value;
            }
            j3 = 1152921504606846976L | value;
        } while (!atomicLong.compareAndSet(value, j3));
        return j3;
    }

    private final b<E> i(int oldHead, int newHead) {
        long value;
        int i3;
        AtomicLong atomicLong = this._state;
        do {
            value = atomicLong.getValue();
            i3 = (int) ((LockFreeTaskQueueCore.HEAD_MASK & value) >> 0);
            if ((1152921504606846976L & value) != 0) {
                return g();
            }
        } while (!this._state.compareAndSet(value, INSTANCE.b(value, newHead)));
        this.array.get(this.mask & i3).setValue(null);
        return null;
    }

    public final int a(@NotNull E element) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) element)).intValue();
        }
        Intrinsics.checkNotNullParameter(element, "element");
        AtomicLong atomicLong = this._state;
        while (true) {
            long value = atomicLong.getValue();
            if ((3458764513820540928L & value) != 0) {
                return INSTANCE.a(value);
            }
            int i3 = (int) ((LockFreeTaskQueueCore.HEAD_MASK & value) >> 0);
            int i16 = (int) ((LockFreeTaskQueueCore.TAIL_MASK & value) >> 30);
            int i17 = this.mask;
            if (((i16 + 2) & i17) == (i3 & i17)) {
                return 1;
            }
            if (!this.singleConsumer && this.array.get(i16 & i17).getValue() != null) {
                int i18 = this.capacity;
                if (i18 < 1024 || ((i16 - i3) & LockFreeTaskQueueCore.MAX_CAPACITY_MASK) > (i18 >> 1)) {
                    break;
                }
            } else if (this._state.compareAndSet(value, INSTANCE.c(value, (i16 + 1) & LockFreeTaskQueueCore.MAX_CAPACITY_MASK))) {
                this.array.get(i16 & i17).setValue(element);
                b<E> bVar = this;
                while ((bVar._state.getValue() & 1152921504606846976L) != 0 && (bVar = bVar.g().d(i16, element)) != null) {
                }
                return 0;
            }
        }
        return 1;
    }

    public final int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        long value = this._state.getValue();
        return (((int) ((value & LockFreeTaskQueueCore.TAIL_MASK) >> 30)) - ((int) ((LockFreeTaskQueueCore.HEAD_MASK & value) >> 0))) & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
    }

    @NotNull
    public final b<E> g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (b) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return c(f());
    }

    @Nullable
    public final Object h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return iPatchRedirector.redirect((short) 5, (Object) this);
        }
        AtomicLong atomicLong = this._state;
        while (true) {
            long value = atomicLong.getValue();
            if ((1152921504606846976L & value) != 0) {
                return f261847g;
            }
            int i3 = (int) ((LockFreeTaskQueueCore.HEAD_MASK & value) >> 0);
            int i16 = (int) ((LockFreeTaskQueueCore.TAIL_MASK & value) >> 30);
            int i17 = this.mask;
            if ((i16 & i17) == (i3 & i17)) {
                return null;
            }
            Object value2 = this.array.get(i17 & i3).getValue();
            if (value2 == null) {
                if (this.singleConsumer) {
                    return null;
                }
            } else {
                if (value2 instanceof C8283b) {
                    return null;
                }
                int i18 = (i3 + 1) & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
                if (this._state.compareAndSet(value, INSTANCE.b(value, i18))) {
                    this.array.get(this.mask & i3).setValue(null);
                    return value2;
                }
                if (this.singleConsumer) {
                    b<E> bVar = this;
                    do {
                        bVar = bVar.i(i3, i18);
                    } while (bVar != null);
                    return value2;
                }
            }
        }
    }
}
