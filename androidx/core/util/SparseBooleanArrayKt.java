package androidx.core.util;

import android.util.SparseBooleanArray;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.BooleanIterator;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0086\n\u001a\u0015\u0010\b\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0086\b\u001a\u0015\u0010\t\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\n\u001a\u00020\u0006H\u0086\b\u001aH\u0010\u000b\u001a\u00020\f*\u00020\u000226\u0010\r\u001a2\u0012\u0013\u0012\u00110\u0001\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\f0\u000eH\u0086\b\u00f8\u0001\u0000\u001a\u001d\u0010\u0011\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0006H\u0086\b\u001a&\u0010\u0013\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0014H\u0086\b\u00f8\u0001\u0000\u001a\r\u0010\u0015\u001a\u00020\u0006*\u00020\u0002H\u0086\b\u001a\r\u0010\u0016\u001a\u00020\u0006*\u00020\u0002H\u0086\b\u001a\n\u0010\u0017\u001a\u00020\u0018*\u00020\u0002\u001a\u0015\u0010\u0019\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002H\u0086\u0002\u001a\u0012\u0010\u001b\u001a\u00020\f*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002\u001a\u001a\u0010\u001c\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0006\u001a\u001d\u0010\u001d\u001a\u00020\f*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0006H\u0086\n\u001a\n\u0010\u001e\u001a\u00020\u001f*\u00020\u0002\"\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00028\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006 "}, d2 = {"size", "", "Landroid/util/SparseBooleanArray;", "getSize", "(Landroid/util/SparseBooleanArray;)I", "contains", "", "key", "containsKey", "containsValue", "value", "forEach", "", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "getOrDefault", RemoteHandleConst.PARAM_DEFAULT_VALUE, "getOrElse", "Lkotlin/Function0;", "isEmpty", "isNotEmpty", "keyIterator", "Lkotlin/collections/IntIterator;", QCircleDaTongConstant.ElementParamValue.PLUS, "other", "putAll", "remove", "set", "valueIterator", "Lkotlin/collections/BooleanIterator;", "core-ktx_release"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class SparseBooleanArrayKt {
    public static final boolean contains(@NotNull SparseBooleanArray contains, int i3) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        if (contains.indexOfKey(i3) >= 0) {
            return true;
        }
        return false;
    }

    public static final boolean containsKey(@NotNull SparseBooleanArray containsKey, int i3) {
        Intrinsics.checkNotNullParameter(containsKey, "$this$containsKey");
        if (containsKey.indexOfKey(i3) >= 0) {
            return true;
        }
        return false;
    }

    public static final boolean containsValue(@NotNull SparseBooleanArray containsValue, boolean z16) {
        Intrinsics.checkNotNullParameter(containsValue, "$this$containsValue");
        if (containsValue.indexOfValue(z16) >= 0) {
            return true;
        }
        return false;
    }

    public static final void forEach(@NotNull SparseBooleanArray forEach, @NotNull Function2<? super Integer, ? super Boolean, Unit> action) {
        Intrinsics.checkNotNullParameter(forEach, "$this$forEach");
        Intrinsics.checkNotNullParameter(action, "action");
        int size = forEach.size();
        for (int i3 = 0; i3 < size; i3++) {
            action.invoke(Integer.valueOf(forEach.keyAt(i3)), Boolean.valueOf(forEach.valueAt(i3)));
        }
    }

    public static final boolean getOrDefault(@NotNull SparseBooleanArray getOrDefault, int i3, boolean z16) {
        Intrinsics.checkNotNullParameter(getOrDefault, "$this$getOrDefault");
        return getOrDefault.get(i3, z16);
    }

    public static final boolean getOrElse(@NotNull SparseBooleanArray getOrElse, int i3, @NotNull Function0<Boolean> defaultValue) {
        Intrinsics.checkNotNullParameter(getOrElse, "$this$getOrElse");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        int indexOfKey = getOrElse.indexOfKey(i3);
        if (indexOfKey >= 0) {
            return getOrElse.valueAt(indexOfKey);
        }
        return defaultValue.invoke().booleanValue();
    }

    public static final int getSize(@NotNull SparseBooleanArray size) {
        Intrinsics.checkNotNullParameter(size, "$this$size");
        return size.size();
    }

    public static final boolean isEmpty(@NotNull SparseBooleanArray isEmpty) {
        Intrinsics.checkNotNullParameter(isEmpty, "$this$isEmpty");
        if (isEmpty.size() == 0) {
            return true;
        }
        return false;
    }

    public static final boolean isNotEmpty(@NotNull SparseBooleanArray isNotEmpty) {
        Intrinsics.checkNotNullParameter(isNotEmpty, "$this$isNotEmpty");
        if (isNotEmpty.size() != 0) {
            return true;
        }
        return false;
    }

    @NotNull
    public static final IntIterator keyIterator(@NotNull final SparseBooleanArray keyIterator) {
        Intrinsics.checkNotNullParameter(keyIterator, "$this$keyIterator");
        return new IntIterator() { // from class: androidx.core.util.SparseBooleanArrayKt$keyIterator$1
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
                SparseBooleanArray sparseBooleanArray = keyIterator;
                int i3 = this.index;
                this.index = i3 + 1;
                return sparseBooleanArray.keyAt(i3);
            }

            public final void setIndex(int i3) {
                this.index = i3;
            }
        };
    }

    @NotNull
    public static final SparseBooleanArray plus(@NotNull SparseBooleanArray plus, @NotNull SparseBooleanArray other) {
        Intrinsics.checkNotNullParameter(plus, "$this$plus");
        Intrinsics.checkNotNullParameter(other, "other");
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray(plus.size() + other.size());
        putAll(sparseBooleanArray, plus);
        putAll(sparseBooleanArray, other);
        return sparseBooleanArray;
    }

    public static final void putAll(@NotNull SparseBooleanArray putAll, @NotNull SparseBooleanArray other) {
        Intrinsics.checkNotNullParameter(putAll, "$this$putAll");
        Intrinsics.checkNotNullParameter(other, "other");
        int size = other.size();
        for (int i3 = 0; i3 < size; i3++) {
            putAll.put(other.keyAt(i3), other.valueAt(i3));
        }
    }

    public static final boolean remove(@NotNull SparseBooleanArray remove, int i3, boolean z16) {
        Intrinsics.checkNotNullParameter(remove, "$this$remove");
        int indexOfKey = remove.indexOfKey(i3);
        if (indexOfKey >= 0 && z16 == remove.valueAt(indexOfKey)) {
            remove.delete(i3);
            return true;
        }
        return false;
    }

    public static final void set(@NotNull SparseBooleanArray set, int i3, boolean z16) {
        Intrinsics.checkNotNullParameter(set, "$this$set");
        set.put(i3, z16);
    }

    @NotNull
    public static final BooleanIterator valueIterator(@NotNull final SparseBooleanArray valueIterator) {
        Intrinsics.checkNotNullParameter(valueIterator, "$this$valueIterator");
        return new BooleanIterator() { // from class: androidx.core.util.SparseBooleanArrayKt$valueIterator$1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.index < valueIterator.size()) {
                    return true;
                }
                return false;
            }

            @Override // kotlin.collections.BooleanIterator
            public boolean nextBoolean() {
                SparseBooleanArray sparseBooleanArray = valueIterator;
                int i3 = this.index;
                this.index = i3 + 1;
                return sparseBooleanArray.valueAt(i3);
            }

            public final void setIndex(int i3) {
                this.index = i3;
            }
        };
    }
}
