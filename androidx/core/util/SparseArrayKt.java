package androidx.core.util;

import android.util.SparseArray;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010(\n\u0000\u001a!\u0010\u0006\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\u0001H\u0086\n\u001a!\u0010\t\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\u0001H\u0086\b\u001a&\u0010\n\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u000b\u001a\u0002H\u0002H\u0086\b\u00a2\u0006\u0002\u0010\f\u001aT\u0010\r\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000326\u0010\u000f\u001a2\u0012\u0013\u0012\u00110\u0001\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\b\u0012\u0013\u0012\u0011H\u0002\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u000e0\u0010H\u0086\b\u00f8\u0001\u0000\u001a.\u0010\u0013\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u0002H\u0002H\u0086\b\u00a2\u0006\u0002\u0010\u0015\u001a7\u0010\u0016\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\u00012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0017H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018\u001a\u0019\u0010\u0019\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086\b\u001a\u0019\u0010\u001a\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086\b\u001a\u0016\u0010\u001b\u001a\u00020\u001c\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003\u001a-\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086\u0002\u001a$\u0010\u001f\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\u001a+\u0010 \u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u0002H\u0002\u00a2\u0006\u0002\u0010!\u001a.\u0010\"\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u0002H\u0002H\u0086\n\u00a2\u0006\u0002\u0010#\u001a\u001c\u0010$\u001a\b\u0012\u0004\u0012\u0002H\u00020%\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\"\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00038\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006&"}, d2 = {"size", "", "T", "Landroid/util/SparseArray;", "getSize", "(Landroid/util/SparseArray;)I", "contains", "", "key", "containsKey", "containsValue", "value", "(Landroid/util/SparseArray;Ljava/lang/Object;)Z", "forEach", "", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "getOrDefault", RemoteHandleConst.PARAM_DEFAULT_VALUE, "(Landroid/util/SparseArray;ILjava/lang/Object;)Ljava/lang/Object;", "getOrElse", "Lkotlin/Function0;", "(Landroid/util/SparseArray;ILkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isEmpty", "isNotEmpty", "keyIterator", "Lkotlin/collections/IntIterator;", QCircleDaTongConstant.ElementParamValue.PLUS, "other", "putAll", "remove", "(Landroid/util/SparseArray;ILjava/lang/Object;)Z", "set", "(Landroid/util/SparseArray;ILjava/lang/Object;)V", "valueIterator", "", "core-ktx_release"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class SparseArrayKt {
    public static final <T> boolean contains(@NotNull SparseArray<T> contains, int i3) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        if (contains.indexOfKey(i3) >= 0) {
            return true;
        }
        return false;
    }

    public static final <T> boolean containsKey(@NotNull SparseArray<T> containsKey, int i3) {
        Intrinsics.checkNotNullParameter(containsKey, "$this$containsKey");
        if (containsKey.indexOfKey(i3) >= 0) {
            return true;
        }
        return false;
    }

    public static final <T> boolean containsValue(@NotNull SparseArray<T> containsValue, T t16) {
        Intrinsics.checkNotNullParameter(containsValue, "$this$containsValue");
        if (containsValue.indexOfValue(t16) >= 0) {
            return true;
        }
        return false;
    }

    public static final <T> void forEach(@NotNull SparseArray<T> forEach, @NotNull Function2<? super Integer, ? super T, Unit> action) {
        Intrinsics.checkNotNullParameter(forEach, "$this$forEach");
        Intrinsics.checkNotNullParameter(action, "action");
        int size = forEach.size();
        for (int i3 = 0; i3 < size; i3++) {
            action.invoke(Integer.valueOf(forEach.keyAt(i3)), forEach.valueAt(i3));
        }
    }

    public static final <T> T getOrDefault(@NotNull SparseArray<T> getOrDefault, int i3, T t16) {
        Intrinsics.checkNotNullParameter(getOrDefault, "$this$getOrDefault");
        T t17 = getOrDefault.get(i3);
        if (t17 != null) {
            return t17;
        }
        return t16;
    }

    public static final <T> T getOrElse(@NotNull SparseArray<T> getOrElse, int i3, @NotNull Function0<? extends T> defaultValue) {
        Intrinsics.checkNotNullParameter(getOrElse, "$this$getOrElse");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        T t16 = getOrElse.get(i3);
        if (t16 == null) {
            return defaultValue.invoke();
        }
        return t16;
    }

    public static final <T> int getSize(@NotNull SparseArray<T> size) {
        Intrinsics.checkNotNullParameter(size, "$this$size");
        return size.size();
    }

    public static final <T> boolean isEmpty(@NotNull SparseArray<T> isEmpty) {
        Intrinsics.checkNotNullParameter(isEmpty, "$this$isEmpty");
        if (isEmpty.size() == 0) {
            return true;
        }
        return false;
    }

    public static final <T> boolean isNotEmpty(@NotNull SparseArray<T> isNotEmpty) {
        Intrinsics.checkNotNullParameter(isNotEmpty, "$this$isNotEmpty");
        if (isNotEmpty.size() != 0) {
            return true;
        }
        return false;
    }

    @NotNull
    public static final <T> IntIterator keyIterator(@NotNull final SparseArray<T> keyIterator) {
        Intrinsics.checkNotNullParameter(keyIterator, "$this$keyIterator");
        return new IntIterator() { // from class: androidx.core.util.SparseArrayKt$keyIterator$1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.index < keyIterator.size()) {
                    return true;
                }
                return false;
            }

            @Override // kotlin.collections.IntIterator
            public int nextInt() {
                SparseArray sparseArray = keyIterator;
                int i3 = this.index;
                this.index = i3 + 1;
                return sparseArray.keyAt(i3);
            }

            public final void setIndex(int i3) {
                this.index = i3;
            }
        };
    }

    @NotNull
    public static final <T> SparseArray<T> plus(@NotNull SparseArray<T> plus, @NotNull SparseArray<T> other) {
        Intrinsics.checkNotNullParameter(plus, "$this$plus");
        Intrinsics.checkNotNullParameter(other, "other");
        SparseArray<T> sparseArray = new SparseArray<>(plus.size() + other.size());
        putAll(sparseArray, plus);
        putAll(sparseArray, other);
        return sparseArray;
    }

    public static final <T> void putAll(@NotNull SparseArray<T> putAll, @NotNull SparseArray<T> other) {
        Intrinsics.checkNotNullParameter(putAll, "$this$putAll");
        Intrinsics.checkNotNullParameter(other, "other");
        int size = other.size();
        for (int i3 = 0; i3 < size; i3++) {
            putAll.put(other.keyAt(i3), other.valueAt(i3));
        }
    }

    public static final <T> boolean remove(@NotNull SparseArray<T> remove, int i3, T t16) {
        Intrinsics.checkNotNullParameter(remove, "$this$remove");
        int indexOfKey = remove.indexOfKey(i3);
        if (indexOfKey >= 0 && Intrinsics.areEqual(t16, remove.valueAt(indexOfKey))) {
            remove.removeAt(indexOfKey);
            return true;
        }
        return false;
    }

    public static final <T> void set(@NotNull SparseArray<T> set, int i3, T t16) {
        Intrinsics.checkNotNullParameter(set, "$this$set");
        set.put(i3, t16);
    }

    @NotNull
    public static final <T> Iterator<T> valueIterator(@NotNull SparseArray<T> valueIterator) {
        Intrinsics.checkNotNullParameter(valueIterator, "$this$valueIterator");
        return new SparseArrayKt$valueIterator$1(valueIterator);
    }
}
