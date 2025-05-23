package kotlin.collections;

import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010(\n\u0002\b\b\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007B\u001d\u0012\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\fJ\u0013\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u0016J\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0018\u001a\u00020\u0006J\u0016\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00020\u0006H\u0096\u0002\u00a2\u0006\u0002\u0010\u001bJ\u0006\u0010\u001c\u001a\u00020\u001dJ\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\u0096\u0002J\u000e\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u0006J\u0015\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tH\u0014\u00a2\u0006\u0002\u0010#J'\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u00010\t\"\u0004\b\u0001\u0010\u00012\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H\u00010\tH\u0014\u00a2\u0006\u0002\u0010%J\u0015\u0010&\u001a\u00020\u0006*\u00020\u00062\u0006\u0010!\u001a\u00020\u0006H\u0082\bR\u0018\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006@RX\u0096\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006'"}, d2 = {"Lkotlin/collections/RingBuffer;", "T", "Lkotlin/collections/AbstractList;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "capacity", "", "(I)V", "buffer", "", "", "filledSize", "([Ljava/lang/Object;I)V", "[Ljava/lang/Object;", "<set-?>", "size", "getSize", "()I", "startIndex", "add", "", DTConstants.TAG.ELEMENT, "(Ljava/lang/Object;)V", "expanded", "maxCapacity", "get", "index", "(I)Ljava/lang/Object;", "isFull", "", "iterator", "", "removeFirst", DomainData.DOMAIN_NAME, "toArray", "()[Ljava/lang/Object;", HippyControllerProps.ARRAY, "([Ljava/lang/Object;)[Ljava/lang/Object;", "forward", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes28.dex */
final class RingBuffer<T> extends AbstractList<T> implements RandomAccess {

    @NotNull
    private final Object[] buffer;
    private final int capacity;
    private int size;
    private int startIndex;

    public RingBuffer(@NotNull Object[] buffer, int i3) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        this.buffer = buffer;
        if (i3 >= 0) {
            if (i3 <= buffer.length) {
                this.capacity = buffer.length;
                this.size = i3;
                return;
            }
            throw new IllegalArgumentException(("ring buffer filled size: " + i3 + " cannot be larger than the buffer size: " + buffer.length).toString());
        }
        throw new IllegalArgumentException(("ring buffer filled size should not be negative but it is " + i3).toString());
    }

    private final int forward(int i3, int i16) {
        return (i3 + i16) % this.capacity;
    }

    @Override // java.util.Collection, java.util.List
    public final void add(T element) {
        if (!isFull()) {
            this.buffer[(this.startIndex + size()) % this.capacity] = element;
            this.size = size() + 1;
            return;
        }
        throw new IllegalStateException("ring buffer is full");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final RingBuffer<T> expanded(int maxCapacity) {
        int coerceAtMost;
        Object[] array;
        int i3 = this.capacity;
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(i3 + (i3 >> 1) + 1, maxCapacity);
        if (this.startIndex == 0) {
            array = Arrays.copyOf(this.buffer, coerceAtMost);
            Intrinsics.checkNotNullExpressionValue(array, "copyOf(this, newSize)");
        } else {
            array = toArray(new Object[coerceAtMost]);
        }
        return new RingBuffer<>(array, size());
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public T get(int index) {
        AbstractList.INSTANCE.checkElementIndex$kotlin_stdlib(index, size());
        return (T) this.buffer[(this.startIndex + index) % this.capacity];
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.size;
    }

    public final boolean isFull() {
        if (size() == this.capacity) {
            return true;
        }
        return false;
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    @NotNull
    public Iterator<T> iterator() {
        return new AbstractIterator<T>(this) { // from class: kotlin.collections.RingBuffer$iterator$1
            private int count;
            private int index;
            final /* synthetic */ RingBuffer<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                int i3;
                this.this$0 = this;
                this.count = this.size();
                i3 = ((RingBuffer) this).startIndex;
                this.index = i3;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.collections.AbstractIterator
            protected void computeNext() {
                Object[] objArr;
                if (this.count != 0) {
                    objArr = ((RingBuffer) this.this$0).buffer;
                    setNext(objArr[this.index]);
                    this.index = (this.index + 1) % ((RingBuffer) this.this$0).capacity;
                    this.count--;
                    return;
                }
                done();
            }
        };
    }

    public final void removeFirst(int n3) {
        boolean z16;
        boolean z17 = true;
        if (n3 >= 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (n3 > size()) {
                z17 = false;
            }
            if (z17) {
                if (n3 > 0) {
                    int i3 = this.startIndex;
                    int i16 = (i3 + n3) % this.capacity;
                    if (i3 > i16) {
                        ArraysKt___ArraysJvmKt.fill(this.buffer, (Object) null, i3, this.capacity);
                        ArraysKt___ArraysJvmKt.fill(this.buffer, (Object) null, 0, i16);
                    } else {
                        ArraysKt___ArraysJvmKt.fill(this.buffer, (Object) null, i3, i16);
                    }
                    this.startIndex = i16;
                    this.size = size() - n3;
                    return;
                }
                return;
            }
            throw new IllegalArgumentException(("n shouldn't be greater than the buffer size: n = " + n3 + ", size = " + size()).toString());
        }
        throw new IllegalArgumentException(("n shouldn't be negative but it is " + n3).toString());
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    @NotNull
    public <T> T[] toArray(@NotNull T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        if (array.length < size()) {
            array = (T[]) Arrays.copyOf(array, size());
            Intrinsics.checkNotNullExpressionValue(array, "copyOf(this, newSize)");
        }
        int size = size();
        int i3 = 0;
        int i16 = 0;
        for (int i17 = this.startIndex; i16 < size && i17 < this.capacity; i17++) {
            array[i16] = this.buffer[i17];
            i16++;
        }
        while (i16 < size) {
            array[i16] = this.buffer[i3];
            i16++;
            i3++;
        }
        if (array.length > size()) {
            array[size()] = null;
        }
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.RingBuffer.toArray>");
        return array;
    }

    public RingBuffer(int i3) {
        this(new Object[i3], 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    @NotNull
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
