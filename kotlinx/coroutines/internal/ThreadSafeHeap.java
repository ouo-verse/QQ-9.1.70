package kotlinx.coroutines.internal;

import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.lang.Comparable;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@InternalCoroutinesApi
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0002\u0018\u0002\b\u0017\u0018\u0000*\u0012\b\u0000\u0010\u0003*\u00020\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u000602j\u0002`3B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0000H\u0001\u00a2\u0006\u0004\b\b\u0010\tJ\u0015\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0000\u00a2\u0006\u0004\b\n\u0010\tJ.\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00028\u00002\u0014\u0010\r\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00020\f0\u000bH\u0086\b\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0005J\u0011\u0010\u0011\u001a\u0004\u0018\u00018\u0000H\u0001\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0012J\u0017\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0014H\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00020\u0019H\u0001\u00a2\u0006\u0004\b\u001b\u0010\u001cJ&\u0010\u001e\u001a\u0004\u0018\u00018\u00002\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\f0\u000bH\u0086\b\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0004\b \u0010\u0012J\u0018\u0010\"\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0019H\u0082\u0010\u00a2\u0006\u0004\b\"\u0010#J\u0018\u0010$\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0019H\u0082\u0010\u00a2\u0006\u0004\b$\u0010#J\u001f\u0010&\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u0019H\u0002\u00a2\u0006\u0004\b&\u0010'R \u0010(\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0013\u0010*\u001a\u00020\f8F@\u0006\u00a2\u0006\u0006\u001a\u0004\b*\u0010+R$\u00100\u001a\u00020\u00192\u0006\u0010,\u001a\u00020\u00198F@BX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b-\u0010.\"\u0004\b/\u0010#\u00a8\u00061"}, d2 = {"Lkotlinx/coroutines/internal/ThreadSafeHeap;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "", "T", "<init>", "()V", "node", "", "addImpl", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)V", "addLast", "Lkotlin/Function1;", "", "cond", "addLastIf", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;Lkotlin/jvm/functions/Function1;)Z", QCircleLpReportDc05507.KEY_CLEAR, "firstImpl", "()Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "peek", "", "realloc", "()[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "remove", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)Z", "", "index", "removeAtImpl", "(I)Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "predicate", "removeFirstIf", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "removeFirstOrNull", "i", "siftDownFrom", "(I)V", "siftUpFrom", "j", "swap", "(II)V", "a", "[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "isEmpty", "()Z", "value", "getSize", "()I", "setSize", "size", "kotlinx-coroutines-core", "", "Lkotlinx/coroutines/internal/SynchronizedObject;"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public class ThreadSafeHeap<T extends ThreadSafeHeapNode & Comparable<? super T>> {

    @NotNull
    private volatile /* synthetic */ int _size = 0;

    @Nullable
    private T[] a;

    private final T[] realloc() {
        T[] tArr = this.a;
        if (tArr == null) {
            T[] tArr2 = (T[]) new ThreadSafeHeapNode[4];
            this.a = tArr2;
            return tArr2;
        }
        if (get_size() >= tArr.length) {
            Object[] copyOf = Arrays.copyOf(tArr, get_size() * 2);
            Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, newSize)");
            T[] tArr3 = (T[]) ((ThreadSafeHeapNode[]) copyOf);
            this.a = tArr3;
            return tArr3;
        }
        return tArr;
    }

    private final void setSize(int i3) {
        this._size = i3;
    }

    private final void siftDownFrom(int i3) {
        while (true) {
            int i16 = (i3 * 2) + 1;
            if (i16 >= get_size()) {
                return;
            }
            T[] tArr = this.a;
            Intrinsics.checkNotNull(tArr);
            int i17 = i16 + 1;
            if (i17 < get_size()) {
                T t16 = tArr[i17];
                Intrinsics.checkNotNull(t16);
                T t17 = tArr[i16];
                Intrinsics.checkNotNull(t17);
                if (((Comparable) t16).compareTo(t17) < 0) {
                    i16 = i17;
                }
            }
            T t18 = tArr[i3];
            Intrinsics.checkNotNull(t18);
            T t19 = tArr[i16];
            Intrinsics.checkNotNull(t19);
            if (((Comparable) t18).compareTo(t19) <= 0) {
                return;
            }
            swap(i3, i16);
            i3 = i16;
        }
    }

    private final void siftUpFrom(int i3) {
        while (i3 > 0) {
            T[] tArr = this.a;
            Intrinsics.checkNotNull(tArr);
            int i16 = (i3 - 1) / 2;
            T t16 = tArr[i16];
            Intrinsics.checkNotNull(t16);
            T t17 = tArr[i3];
            Intrinsics.checkNotNull(t17);
            if (((Comparable) t16).compareTo(t17) <= 0) {
                return;
            }
            swap(i3, i16);
            i3 = i16;
        }
    }

    private final void swap(int i3, int j3) {
        T[] tArr = this.a;
        Intrinsics.checkNotNull(tArr);
        T t16 = tArr[j3];
        Intrinsics.checkNotNull(t16);
        T t17 = tArr[i3];
        Intrinsics.checkNotNull(t17);
        tArr[i3] = t16;
        tArr[j3] = t17;
        t16.setIndex(i3);
        t17.setIndex(j3);
    }

    @PublishedApi
    public final void addImpl(@NotNull T node) {
        node.setHeap(this);
        T[] realloc = realloc();
        int i3 = get_size();
        setSize(i3 + 1);
        realloc[i3] = node;
        node.setIndex(i3);
        siftUpFrom(i3);
    }

    public final void addLast(@NotNull T node) {
        synchronized (this) {
            addImpl(node);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final boolean addLastIf(@NotNull T node, @NotNull Function1<? super T, Boolean> cond) {
        boolean z16;
        synchronized (this) {
            try {
                if (cond.invoke(firstImpl()).booleanValue()) {
                    addImpl(node);
                    z16 = true;
                } else {
                    z16 = false;
                }
                InlineMarker.finallyStart(1);
            } catch (Throwable th5) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th5;
            }
        }
        InlineMarker.finallyEnd(1);
        return z16;
    }

    public final void clear() {
        synchronized (this) {
            T[] tArr = this.a;
            if (tArr != null) {
                ArraysKt___ArraysJvmKt.fill$default(tArr, (Object) null, 0, 0, 6, (Object) null);
            }
            this._size = 0;
            Unit unit = Unit.INSTANCE;
        }
    }

    @PublishedApi
    @Nullable
    public final T firstImpl() {
        T[] tArr = this.a;
        if (tArr == null) {
            return null;
        }
        return tArr[0];
    }

    /* renamed from: getSize, reason: from getter */
    public final int get_size() {
        return this._size;
    }

    public final boolean isEmpty() {
        if (get_size() == 0) {
            return true;
        }
        return false;
    }

    @Nullable
    public final T peek() {
        T firstImpl;
        synchronized (this) {
            firstImpl = firstImpl();
        }
        return firstImpl;
    }

    public final boolean remove(@NotNull T node) {
        boolean z16;
        synchronized (this) {
            if (node.getHeap() == null) {
                z16 = false;
            } else {
                removeAtImpl(node.getIndex());
                z16 = true;
            }
        }
        return z16;
    }

    @PublishedApi
    @NotNull
    public final T removeAtImpl(int index) {
        T[] tArr = this.a;
        Intrinsics.checkNotNull(tArr);
        setSize(get_size() - 1);
        if (index < get_size()) {
            swap(index, get_size());
            int i3 = (index - 1) / 2;
            if (index > 0) {
                T t16 = tArr[index];
                Intrinsics.checkNotNull(t16);
                T t17 = tArr[i3];
                Intrinsics.checkNotNull(t17);
                if (((Comparable) t16).compareTo(t17) < 0) {
                    swap(index, i3);
                    siftUpFrom(i3);
                }
            }
            siftDownFrom(index);
        }
        T t18 = tArr[get_size()];
        Intrinsics.checkNotNull(t18);
        t18.setHeap(null);
        t18.setIndex(-1);
        tArr[get_size()] = null;
        return t18;
    }

    @Nullable
    public final T removeFirstIf(@NotNull Function1<? super T, Boolean> predicate) {
        synchronized (this) {
            try {
                T firstImpl = firstImpl();
                T t16 = null;
                if (firstImpl == null) {
                    InlineMarker.finallyStart(2);
                    InlineMarker.finallyEnd(2);
                    return null;
                }
                if (predicate.invoke(firstImpl).booleanValue()) {
                    t16 = removeAtImpl(0);
                }
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                return t16;
            } catch (Throwable th5) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th5;
            }
        }
    }

    @Nullable
    public final T removeFirstOrNull() {
        T t16;
        synchronized (this) {
            if (get_size() > 0) {
                t16 = removeAtImpl(0);
            } else {
                t16 = null;
            }
        }
        return t16;
    }
}
