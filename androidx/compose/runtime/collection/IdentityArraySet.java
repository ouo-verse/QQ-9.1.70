package androidx.compose.runtime.collection;

import androidx.compose.runtime.ActualJvm_jvmKt;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010(\n\u0002\b\u0004\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0013\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u0016J\u0006\u0010\u0017\u001a\u00020\u0018J\u0016\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0002\u0010\u0016J\u0016\u0010\u001b\u001a\u00020\u00142\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001dH\u0016J\u0012\u0010\u001e\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0002J\"\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00022\u0006\u0010!\u001a\u00020\u0006H\u0002J+\u0010\"\u001a\u00020\u00182\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00180$H\u0086\b\u00f8\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0016\u0010%\u001a\u00028\u00002\u0006\u0010&\u001a\u00020\u0006H\u0086\u0002\u00a2\u0006\u0002\u0010'J\b\u0010(\u001a\u00020\u0014H\u0016J\u0006\u0010)\u001a\u00020\u0014J\u000f\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000+H\u0096\u0002J\u0013\u0010,\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u0016J \u0010-\u001a\u00020\u00182\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00140$H\u0086\b\u00f8\u0001\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR.\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f8\u0000@\u0000X\u0081\u000e\u00a2\u0006\u0016\n\u0002\u0010\u0012\u0012\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006/"}, d2 = {"Landroidx/compose/runtime/collection/IdentityArraySet;", "T", "", "", "()V", "size", "", "getSize", "()I", "setSize", "(I)V", "values", "", "getValues$annotations", "getValues", "()[Ljava/lang/Object;", "setValues", "([Ljava/lang/Object;)V", "[Ljava/lang/Object;", "add", "", "value", "(Ljava/lang/Object;)Z", QCircleLpReportDc05507.KEY_CLEAR, "", "contains", DTConstants.TAG.ELEMENT, "containsAll", DTParamKey.REPORT_KEY_VISUAL_ELEMENTS, "", "find", "findExactIndex", "midIndex", "valueHash", "forEach", "block", "Lkotlin/Function1;", "get", "index", "(I)Ljava/lang/Object;", "isEmpty", "isNotEmpty", "iterator", "", "remove", "removeValueIf", "predicate", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes39.dex */
public final class IdentityArraySet<T> implements Set<T>, KMappedMarker {
    private int size;
    private Object[] values = new Object[16];

    private final int find(Object value) {
        int size = size() - 1;
        int identityHashCode = ActualJvm_jvmKt.identityHashCode(value);
        int i3 = 0;
        while (i3 <= size) {
            int i16 = (i3 + size) >>> 1;
            T t16 = get(i16);
            int identityHashCode2 = ActualJvm_jvmKt.identityHashCode(t16);
            if (identityHashCode2 < identityHashCode) {
                i3 = i16 + 1;
            } else {
                if (identityHashCode2 <= identityHashCode) {
                    return t16 == value ? i16 : findExactIndex(i16, value, identityHashCode);
                }
                size = i16 - 1;
            }
        }
        return -(i3 + 1);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean add(T value) {
        int i3;
        Intrinsics.checkNotNullParameter(value, "value");
        if (size() > 0) {
            i3 = find(value);
            if (i3 >= 0) {
                return false;
            }
        } else {
            i3 = -1;
        }
        int i16 = -(i3 + 1);
        int size = size();
        Object[] objArr = this.values;
        if (size == objArr.length) {
            Object[] objArr2 = new Object[objArr.length * 2];
            ArraysKt.copyInto(objArr, objArr2, i16 + 1, i16, size());
            ArraysKt.copyInto$default(this.values, objArr2, 0, 0, i16, 6, (Object) null);
            this.values = objArr2;
        } else {
            ArraysKt.copyInto(objArr, objArr, i16 + 1, i16, size());
        }
        this.values[i16] = value;
        setSize(size() + 1);
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public final void clear() {
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            this.values[i3] = null;
        }
        setSize(0);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Collection<? extends Object> collection = elements;
        if (collection.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final void forEach(Function1<? super T, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            block.invoke(get(i3));
        }
    }

    public final T get(int index) {
        T t16 = (T) this.values[index];
        if (t16 != null) {
            return t16;
        }
        throw new NullPointerException("null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
    }

    public int getSize() {
        return this.size;
    }

    public final Object[] getValues() {
        return this.values;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return size() == 0;
    }

    public final boolean isNotEmpty() {
        return size() > 0;
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return new IdentityArraySet$iterator$1(this);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void removeValueIf(Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int size = size();
        int i3 = 0;
        for (int i16 = 0; i16 < size; i16++) {
            Object obj = getValues()[i16];
            if (obj != null) {
                if (!predicate.invoke(obj).booleanValue()) {
                    if (i3 != i16) {
                        getValues()[i3] = obj;
                    }
                    i3++;
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
            }
        }
        int size2 = size();
        for (int i17 = i3; i17 < size2; i17++) {
            getValues()[i17] = null;
        }
        setSize(i3);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void setSize(int i3) {
        this.size = i3;
    }

    public final void setValues(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<set-?>");
        this.values = objArr;
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.Set, java.util.Collection
    public <T> T[] toArray(T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return (T[]) CollectionToArray.toArray(this, array);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean contains(Object element) {
        return element != null && find(element) >= 0;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean remove(T value) {
        int find;
        if (value == null || (find = find(value)) < 0) {
            return false;
        }
        if (find < size() - 1) {
            Object[] objArr = this.values;
            ArraysKt.copyInto(objArr, objArr, find, find + 1, size());
        }
        setSize(size() - 1);
        this.values[size()] = null;
        return true;
    }

    private final int findExactIndex(int midIndex, Object value, int valueHash) {
        for (int i3 = midIndex - 1; -1 < i3; i3--) {
            Object obj = this.values[i3];
            if (obj == value) {
                return i3;
            }
            if (ActualJvm_jvmKt.identityHashCode(obj) != valueHash) {
                break;
            }
        }
        int i16 = midIndex + 1;
        int size = size();
        while (true) {
            if (i16 < size) {
                Object obj2 = this.values[i16];
                if (obj2 == value) {
                    return i16;
                }
                if (ActualJvm_jvmKt.identityHashCode(obj2) != valueHash) {
                    break;
                }
                i16++;
            } else {
                i16 = size();
                break;
            }
        }
        return -(i16 + 1);
    }

    public static /* synthetic */ void getValues$annotations() {
    }
}
