package kotlin.collections.builders;

import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.collections.AbstractMutableList;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableListIterator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010+\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u00042\b\u0012\u0004\u0012\u0002H\u00010\u00052\u00060\u0006j\u0002`\u0007:\u0001VB\u0007\b\u0016\u00a2\u0006\u0002\u0010\bB\u000f\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bBM\b\u0002\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\r\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000\u0012\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000\u00a2\u0006\u0002\u0010\u0014J\u0015\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u001dJ\u001d\u0010\u001b\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010 J\u001e\u0010!\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\n2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016J\u0016\u0010!\u001a\u00020\u00112\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016J&\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\n2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#2\u0006\u0010&\u001a\u00020\nH\u0002J\u001d\u0010'\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00028\u0000H\u0002\u00a2\u0006\u0002\u0010 J\f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000)J\b\u0010*\u001a\u00020\u001eH\u0002J\b\u0010+\u001a\u00020\u001eH\u0016J\u0014\u0010,\u001a\u00020\u00112\n\u0010-\u001a\u0006\u0012\u0002\b\u00030)H\u0002J\u0010\u0010.\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020\nH\u0002J\u0010\u00100\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\nH\u0002J\u0013\u00101\u001a\u00020\u00112\b\u0010-\u001a\u0004\u0018\u000102H\u0096\u0002J\u0016\u00103\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\nH\u0096\u0002\u00a2\u0006\u0002\u00104J\b\u00105\u001a\u00020\nH\u0016J\u0015\u00106\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u00107J\u0018\u00108\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\nH\u0002J\b\u00109\u001a\u00020\u0011H\u0016J\u000f\u0010:\u001a\b\u0012\u0004\u0012\u00028\u00000;H\u0096\u0002J\u0015\u0010<\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u00107J\u000e\u0010=\u001a\b\u0012\u0004\u0012\u00028\u00000>H\u0016J\u0016\u0010=\u001a\b\u0012\u0004\u0012\u00028\u00000>2\u0006\u0010\u001f\u001a\u00020\nH\u0016J\u0015\u0010?\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u001dJ\u0016\u0010@\u001a\u00020\u00112\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016J\u0015\u0010A\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\nH\u0016\u00a2\u0006\u0002\u00104J\u0015\u0010B\u001a\u00028\u00002\u0006\u0010%\u001a\u00020\nH\u0002\u00a2\u0006\u0002\u00104J\u0018\u0010C\u001a\u00020\u001e2\u0006\u0010D\u001a\u00020\n2\u0006\u0010E\u001a\u00020\nH\u0002J\u0016\u0010F\u001a\u00020\u00112\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016J.\u0010G\u001a\u00020\n2\u0006\u0010D\u001a\u00020\n2\u0006\u0010E\u001a\u00020\n2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#2\u0006\u0010H\u001a\u00020\u0011H\u0002J\u001e\u0010I\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0002\u0010JJ\u001e\u0010K\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010L\u001a\u00020\n2\u0006\u0010M\u001a\u00020\nH\u0016J\u0015\u0010N\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001020\rH\u0016\u00a2\u0006\u0002\u0010OJ'\u0010N\u001a\b\u0012\u0004\u0012\u0002HP0\r\"\u0004\b\u0001\u0010P2\f\u0010Q\u001a\b\u0012\u0004\u0012\u0002HP0\rH\u0016\u00a2\u0006\u0002\u0010RJ\b\u0010S\u001a\u00020TH\u0016J\b\u0010U\u001a\u000202H\u0002R\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0015R\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00118BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u00020\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006W"}, d2 = {"Lkotlin/collections/builders/ListBuilder;", "E", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "Lkotlin/collections/AbstractMutableList;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "()V", "initialCapacity", "", "(I)V", HippyControllerProps.ARRAY, "", "offset", "length", "isReadOnly", "", "backing", "root", "([Ljava/lang/Object;IIZLkotlin/collections/builders/ListBuilder;Lkotlin/collections/builders/ListBuilder;)V", "[Ljava/lang/Object;", "isEffectivelyReadOnly", "()Z", "size", "getSize", "()I", "add", DTConstants.TAG.ELEMENT, "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", DTParamKey.REPORT_KEY_VISUAL_ELEMENTS, "", "addAllInternal", "i", DomainData.DOMAIN_NAME, "addAtInternal", "build", "", "checkIsMutable", QCircleLpReportDc05507.KEY_CLEAR, "contentEquals", "other", "ensureCapacity", "minCapacity", "ensureExtraCapacity", "equals", "", "get", "(I)Ljava/lang/Object;", "hashCode", "indexOf", "(Ljava/lang/Object;)I", "insertAtInternal", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "remove", "removeAll", "removeAt", "removeAtInternal", "removeRangeInternal", "rangeOffset", "rangeLength", "retainAll", "retainOrRemoveAllInternal", "retain", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "fromIndex", "toIndex", "toArray", "()[Ljava/lang/Object;", "T", "destination", "([Ljava/lang/Object;)[Ljava/lang/Object;", "toString", "", "writeReplace", "Itr", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class ListBuilder<E> extends AbstractMutableList<E> implements RandomAccess, Serializable {

    @NotNull
    private E[] array;

    @Nullable
    private final ListBuilder<E> backing;
    private boolean isReadOnly;
    private int length;
    private int offset;

    @Nullable
    private final ListBuilder<E> root;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001d\b\u0016\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0001H\u0016\u00a2\u0006\u0002\u0010\fJ\t\u0010\r\u001a\u00020\u000eH\u0096\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u000e\u0010\u0010\u001a\u00028\u0001H\u0096\u0002\u00a2\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\r\u0010\u0013\u001a\u00028\u0001H\u0016\u00a2\u0006\u0002\u0010\u0011J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\b\u0010\u0015\u001a\u00020\nH\u0016J\u0015\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0001H\u0016\u00a2\u0006\u0002\u0010\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lkotlin/collections/builders/ListBuilder$Itr;", "E", "", "list", "Lkotlin/collections/builders/ListBuilder;", "index", "", "(Lkotlin/collections/builders/ListBuilder;I)V", "lastIndex", "add", "", DTConstants.TAG.ELEMENT, "(Ljava/lang/Object;)V", "hasNext", "", "hasPrevious", "next", "()Ljava/lang/Object;", "nextIndex", "previous", "previousIndex", "remove", "set", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes28.dex */
    private static final class Itr<E> implements ListIterator<E>, KMutableListIterator {
        private int index;
        private int lastIndex;

        @NotNull
        private final ListBuilder<E> list;

        public Itr(@NotNull ListBuilder<E> list, int i3) {
            Intrinsics.checkNotNullParameter(list, "list");
            this.list = list;
            this.index = i3;
            this.lastIndex = -1;
        }

        @Override // java.util.ListIterator
        public void add(E element) {
            ListBuilder<E> listBuilder = this.list;
            int i3 = this.index;
            this.index = i3 + 1;
            listBuilder.add(i3, element);
            this.lastIndex = -1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            if (this.index < ((ListBuilder) this.list).length) {
                return true;
            }
            return false;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            if (this.index > 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public E next() {
            if (this.index < ((ListBuilder) this.list).length) {
                int i3 = this.index;
                this.index = i3 + 1;
                this.lastIndex = i3;
                return (E) ((ListBuilder) this.list).array[((ListBuilder) this.list).offset + this.lastIndex];
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.index;
        }

        @Override // java.util.ListIterator
        public E previous() {
            int i3 = this.index;
            if (i3 > 0) {
                int i16 = i3 - 1;
                this.index = i16;
                this.lastIndex = i16;
                return (E) ((ListBuilder) this.list).array[((ListBuilder) this.list).offset + this.lastIndex];
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.index - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            boolean z16;
            int i3 = this.lastIndex;
            if (i3 != -1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                this.list.remove(i3);
                this.index = this.lastIndex;
                this.lastIndex = -1;
                return;
            }
            throw new IllegalStateException("Call next() or previous() before removing element from the iterator.".toString());
        }

        @Override // java.util.ListIterator
        public void set(E element) {
            boolean z16;
            int i3 = this.lastIndex;
            if (i3 != -1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                this.list.set(i3, element);
                return;
            }
            throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.".toString());
        }
    }

    ListBuilder(E[] eArr, int i3, int i16, boolean z16, ListBuilder<E> listBuilder, ListBuilder<E> listBuilder2) {
        this.array = eArr;
        this.offset = i3;
        this.length = i16;
        this.isReadOnly = z16;
        this.backing = listBuilder;
        this.root = listBuilder2;
    }

    private final void addAllInternal(int i3, Collection<? extends E> elements, int n3) {
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            listBuilder.addAllInternal(i3, elements, n3);
            this.array = this.backing.array;
            this.length += n3;
        } else {
            insertAtInternal(i3, n3);
            Iterator<? extends E> it = elements.iterator();
            for (int i16 = 0; i16 < n3; i16++) {
                this.array[i3 + i16] = it.next();
            }
        }
    }

    private final void addAtInternal(int i3, E element) {
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            listBuilder.addAtInternal(i3, element);
            this.array = this.backing.array;
            this.length++;
        } else {
            insertAtInternal(i3, 1);
            this.array[i3] = element;
        }
    }

    private final void checkIsMutable() {
        if (!isEffectivelyReadOnly()) {
        } else {
            throw new UnsupportedOperationException();
        }
    }

    private final boolean contentEquals(List<?> other) {
        boolean subarrayContentEquals;
        subarrayContentEquals = ListBuilderKt.subarrayContentEquals(this.array, this.offset, this.length, other);
        return subarrayContentEquals;
    }

    private final void ensureCapacity(int minCapacity) {
        if (this.backing == null) {
            if (minCapacity >= 0) {
                E[] eArr = this.array;
                if (minCapacity > eArr.length) {
                    this.array = (E[]) ListBuilderKt.copyOfUninitializedElements(this.array, ArrayDeque.INSTANCE.newCapacity$kotlin_stdlib(eArr.length, minCapacity));
                    return;
                }
                return;
            }
            throw new OutOfMemoryError();
        }
        throw new IllegalStateException();
    }

    private final void ensureExtraCapacity(int n3) {
        ensureCapacity(this.length + n3);
    }

    private final void insertAtInternal(int i3, int n3) {
        ensureExtraCapacity(n3);
        E[] eArr = this.array;
        ArraysKt___ArraysJvmKt.copyInto(eArr, eArr, i3 + n3, i3, this.offset + this.length);
        this.length += n3;
    }

    private final boolean isEffectivelyReadOnly() {
        ListBuilder<E> listBuilder;
        if (!this.isReadOnly && ((listBuilder = this.root) == null || !listBuilder.isReadOnly)) {
            return false;
        }
        return true;
    }

    private final E removeAtInternal(int i3) {
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            this.length--;
            return listBuilder.removeAtInternal(i3);
        }
        E[] eArr = this.array;
        E e16 = eArr[i3];
        ArraysKt___ArraysJvmKt.copyInto(eArr, eArr, i3, i3 + 1, this.offset + this.length);
        ListBuilderKt.resetAt(this.array, (this.offset + this.length) - 1);
        this.length--;
        return e16;
    }

    private final void removeRangeInternal(int rangeOffset, int rangeLength) {
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            listBuilder.removeRangeInternal(rangeOffset, rangeLength);
        } else {
            E[] eArr = this.array;
            ArraysKt___ArraysJvmKt.copyInto(eArr, eArr, rangeOffset, rangeOffset + rangeLength, this.length);
            E[] eArr2 = this.array;
            int i3 = this.length;
            ListBuilderKt.resetRange(eArr2, i3 - rangeLength, i3);
        }
        this.length -= rangeLength;
    }

    private final int retainOrRemoveAllInternal(int rangeOffset, int rangeLength, Collection<? extends E> elements, boolean retain) {
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            int retainOrRemoveAllInternal = listBuilder.retainOrRemoveAllInternal(rangeOffset, rangeLength, elements, retain);
            this.length -= retainOrRemoveAllInternal;
            return retainOrRemoveAllInternal;
        }
        int i3 = 0;
        int i16 = 0;
        while (i3 < rangeLength) {
            int i17 = rangeOffset + i3;
            if (elements.contains(this.array[i17]) == retain) {
                E[] eArr = this.array;
                i3++;
                eArr[i16 + rangeOffset] = eArr[i17];
                i16++;
            } else {
                i3++;
            }
        }
        int i18 = rangeLength - i16;
        E[] eArr2 = this.array;
        ArraysKt___ArraysJvmKt.copyInto(eArr2, eArr2, rangeOffset + i16, rangeLength + rangeOffset, this.length);
        E[] eArr3 = this.array;
        int i19 = this.length;
        ListBuilderKt.resetRange(eArr3, i19 - i18, i19);
        this.length -= i18;
        return i18;
    }

    private final Object writeReplace() {
        if (isEffectivelyReadOnly()) {
            return new SerializedCollection(this, 0);
        }
        throw new NotSerializableException("The list cannot be serialized while it is being built.");
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E element) {
        checkIsMutable();
        addAtInternal(this.offset + this.length, element);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(@NotNull Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        checkIsMutable();
        int size = elements.size();
        addAllInternal(this.offset + this.length, elements, size);
        return size > 0;
    }

    @NotNull
    public final List<E> build() {
        if (this.backing == null) {
            checkIsMutable();
            this.isReadOnly = true;
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        checkIsMutable();
        removeRangeInternal(this.offset, this.length);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(@Nullable Object other) {
        if (other != this && (!(other instanceof List) || !contentEquals((List) other))) {
            return false;
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int index) {
        AbstractList.INSTANCE.checkElementIndex$kotlin_stdlib(index, this.length);
        return this.array[this.offset + index];
    }

    @Override // kotlin.collections.AbstractMutableList
    public int getSize() {
        return this.length;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int subarrayContentHashCode;
        subarrayContentHashCode = ListBuilderKt.subarrayContentHashCode(this.array, this.offset, this.length);
        return subarrayContentHashCode;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object element) {
        for (int i3 = 0; i3 < this.length; i3++) {
            if (Intrinsics.areEqual(this.array[this.offset + i3], element)) {
                return i3;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        if (this.length == 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    @NotNull
    public Iterator<E> iterator() {
        return new Itr(this, 0);
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object element) {
        for (int i3 = this.length - 1; i3 >= 0; i3--) {
            if (Intrinsics.areEqual(this.array[this.offset + i3], element)) {
                return i3;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    @NotNull
    public ListIterator<E> listIterator() {
        return new Itr(this, 0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object element) {
        checkIsMutable();
        int indexOf = indexOf(element);
        if (indexOf >= 0) {
            remove(indexOf);
        }
        if (indexOf >= 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(@NotNull Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        checkIsMutable();
        if (retainOrRemoveAllInternal(this.offset, this.length, elements, false) <= 0) {
            return false;
        }
        return true;
    }

    @Override // kotlin.collections.AbstractMutableList
    public E removeAt(int index) {
        checkIsMutable();
        AbstractList.INSTANCE.checkElementIndex$kotlin_stdlib(index, this.length);
        return removeAtInternal(this.offset + index);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(@NotNull Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        checkIsMutable();
        if (retainOrRemoveAllInternal(this.offset, this.length, elements, true) > 0) {
            return true;
        }
        return false;
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public E set(int index, E element) {
        checkIsMutable();
        AbstractList.INSTANCE.checkElementIndex$kotlin_stdlib(index, this.length);
        E[] eArr = this.array;
        int i3 = this.offset;
        E e16 = eArr[i3 + index];
        eArr[i3 + index] = element;
        return e16;
    }

    @Override // java.util.AbstractList, java.util.List
    @NotNull
    public List<E> subList(int fromIndex, int toIndex) {
        ListBuilder<E> listBuilder;
        AbstractList.INSTANCE.checkRangeIndexes$kotlin_stdlib(fromIndex, toIndex, this.length);
        E[] eArr = this.array;
        int i3 = this.offset + fromIndex;
        int i16 = toIndex - fromIndex;
        boolean z16 = this.isReadOnly;
        ListBuilder<E> listBuilder2 = this.root;
        if (listBuilder2 == null) {
            listBuilder = this;
        } else {
            listBuilder = listBuilder2;
        }
        return new ListBuilder(eArr, i3, i16, z16, this, listBuilder);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    @NotNull
    public <T> T[] toArray(@NotNull T[] destination) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        int length = destination.length;
        int i3 = this.length;
        if (length < i3) {
            E[] eArr = this.array;
            int i16 = this.offset;
            T[] tArr = (T[]) Arrays.copyOfRange(eArr, i16, i3 + i16, destination.getClass());
            Intrinsics.checkNotNullExpressionValue(tArr, "copyOfRange(array, offse\u2026h, destination.javaClass)");
            return tArr;
        }
        E[] eArr2 = this.array;
        Intrinsics.checkNotNull(eArr2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.builders.ListBuilder.toArray>");
        int i17 = this.offset;
        ArraysKt___ArraysJvmKt.copyInto(eArr2, destination, 0, i17, this.length + i17);
        int length2 = destination.length;
        int i18 = this.length;
        if (length2 > i18) {
            destination[i18] = null;
        }
        return destination;
    }

    @Override // java.util.AbstractCollection
    @NotNull
    public String toString() {
        String subarrayContentToString;
        subarrayContentToString = ListBuilderKt.subarrayContentToString(this.array, this.offset, this.length);
        return subarrayContentToString;
    }

    @Override // java.util.AbstractList, java.util.List
    @NotNull
    public ListIterator<E> listIterator(int index) {
        AbstractList.INSTANCE.checkPositionIndex$kotlin_stdlib(index, this.length);
        return new Itr(this, index);
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public void add(int index, E element) {
        checkIsMutable();
        AbstractList.INSTANCE.checkPositionIndex$kotlin_stdlib(index, this.length);
        addAtInternal(this.offset + index, element);
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int index, @NotNull Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        checkIsMutable();
        AbstractList.INSTANCE.checkPositionIndex$kotlin_stdlib(index, this.length);
        int size = elements.size();
        addAllInternal(this.offset + index, elements, size);
        return size > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    @NotNull
    public Object[] toArray() {
        Object[] copyOfRange;
        E[] eArr = this.array;
        int i3 = this.offset;
        copyOfRange = ArraysKt___ArraysJvmKt.copyOfRange(eArr, i3, this.length + i3);
        Intrinsics.checkNotNull(copyOfRange, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        return copyOfRange;
    }

    public ListBuilder() {
        this(10);
    }

    public ListBuilder(int i3) {
        this(ListBuilderKt.arrayOfUninitializedElements(i3), 0, 0, false, null, null);
    }
}
