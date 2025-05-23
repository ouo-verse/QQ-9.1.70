package androidx.core.util;

import android.util.SparseLongArray;
import androidx.annotation.RequiresApi;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.collections.LongIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0087\n\u001a\u0015\u0010\b\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\t\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0087\b\u001aH\u0010\f\u001a\u00020\r*\u00020\u000226\u0010\u000e\u001a2\u0012\u0013\u0012\u00110\u0001\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\r0\u000fH\u0087\b\u00f8\u0001\u0000\u001a\u001d\u0010\u0012\u001a\u00020\u000b*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u000bH\u0087\b\u001a&\u0010\u0014\u001a\u00020\u000b*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0015H\u0087\b\u00f8\u0001\u0000\u001a\r\u0010\u0016\u001a\u00020\u0006*\u00020\u0002H\u0087\b\u001a\r\u0010\u0017\u001a\u00020\u0006*\u00020\u0002H\u0087\b\u001a\f\u0010\u0018\u001a\u00020\u0019*\u00020\u0002H\u0007\u001a\u0015\u0010\u001a\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002H\u0087\u0002\u001a\u0014\u0010\u001c\u001a\u00020\r*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002H\u0007\u001a\u001c\u0010\u001d\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000bH\u0007\u001a\u001d\u0010\u001e\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000bH\u0087\n\u001a\f\u0010\u001f\u001a\u00020 *\u00020\u0002H\u0007\"\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00028\u00c7\u0002\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006!"}, d2 = {"size", "", "Landroid/util/SparseLongArray;", "getSize", "(Landroid/util/SparseLongArray;)I", "contains", "", "key", "containsKey", "containsValue", "value", "", "forEach", "", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "getOrDefault", RemoteHandleConst.PARAM_DEFAULT_VALUE, "getOrElse", "Lkotlin/Function0;", "isEmpty", "isNotEmpty", "keyIterator", "Lkotlin/collections/IntIterator;", QCircleDaTongConstant.ElementParamValue.PLUS, "other", "putAll", "remove", "set", "valueIterator", "Lkotlin/collections/LongIterator;", "core-ktx_release"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class SparseLongArrayKt {
    @RequiresApi(18)
    public static final boolean contains(@NotNull SparseLongArray contains, int i3) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        if (contains.indexOfKey(i3) >= 0) {
            return true;
        }
        return false;
    }

    @RequiresApi(18)
    public static final boolean containsKey(@NotNull SparseLongArray containsKey, int i3) {
        Intrinsics.checkNotNullParameter(containsKey, "$this$containsKey");
        if (containsKey.indexOfKey(i3) >= 0) {
            return true;
        }
        return false;
    }

    @RequiresApi(18)
    public static final boolean containsValue(@NotNull SparseLongArray containsValue, long j3) {
        Intrinsics.checkNotNullParameter(containsValue, "$this$containsValue");
        if (containsValue.indexOfValue(j3) >= 0) {
            return true;
        }
        return false;
    }

    @RequiresApi(18)
    public static final void forEach(@NotNull SparseLongArray forEach, @NotNull Function2<? super Integer, ? super Long, Unit> action) {
        Intrinsics.checkNotNullParameter(forEach, "$this$forEach");
        Intrinsics.checkNotNullParameter(action, "action");
        int size = forEach.size();
        for (int i3 = 0; i3 < size; i3++) {
            action.invoke(Integer.valueOf(forEach.keyAt(i3)), Long.valueOf(forEach.valueAt(i3)));
        }
    }

    @RequiresApi(18)
    public static final long getOrDefault(@NotNull SparseLongArray getOrDefault, int i3, long j3) {
        Intrinsics.checkNotNullParameter(getOrDefault, "$this$getOrDefault");
        return getOrDefault.get(i3, j3);
    }

    @RequiresApi(18)
    public static final long getOrElse(@NotNull SparseLongArray getOrElse, int i3, @NotNull Function0<Long> defaultValue) {
        Intrinsics.checkNotNullParameter(getOrElse, "$this$getOrElse");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        int indexOfKey = getOrElse.indexOfKey(i3);
        if (indexOfKey >= 0) {
            return getOrElse.valueAt(indexOfKey);
        }
        return defaultValue.invoke().longValue();
    }

    @RequiresApi(18)
    public static final int getSize(@NotNull SparseLongArray size) {
        Intrinsics.checkNotNullParameter(size, "$this$size");
        return size.size();
    }

    @RequiresApi(18)
    public static final boolean isEmpty(@NotNull SparseLongArray isEmpty) {
        Intrinsics.checkNotNullParameter(isEmpty, "$this$isEmpty");
        if (isEmpty.size() == 0) {
            return true;
        }
        return false;
    }

    @RequiresApi(18)
    public static final boolean isNotEmpty(@NotNull SparseLongArray isNotEmpty) {
        Intrinsics.checkNotNullParameter(isNotEmpty, "$this$isNotEmpty");
        if (isNotEmpty.size() != 0) {
            return true;
        }
        return false;
    }

    @RequiresApi(18)
    @NotNull
    public static final IntIterator keyIterator(@NotNull final SparseLongArray keyIterator) {
        Intrinsics.checkNotNullParameter(keyIterator, "$this$keyIterator");
        return new IntIterator() { // from class: androidx.core.util.SparseLongArrayKt$keyIterator$1
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
                SparseLongArray sparseLongArray = keyIterator;
                int i3 = this.index;
                this.index = i3 + 1;
                return sparseLongArray.keyAt(i3);
            }

            public final void setIndex(int i3) {
                this.index = i3;
            }
        };
    }

    @RequiresApi(18)
    @NotNull
    public static final SparseLongArray plus(@NotNull SparseLongArray plus, @NotNull SparseLongArray other) {
        Intrinsics.checkNotNullParameter(plus, "$this$plus");
        Intrinsics.checkNotNullParameter(other, "other");
        SparseLongArray sparseLongArray = new SparseLongArray(plus.size() + other.size());
        putAll(sparseLongArray, plus);
        putAll(sparseLongArray, other);
        return sparseLongArray;
    }

    @RequiresApi(18)
    public static final void putAll(@NotNull SparseLongArray putAll, @NotNull SparseLongArray other) {
        Intrinsics.checkNotNullParameter(putAll, "$this$putAll");
        Intrinsics.checkNotNullParameter(other, "other");
        int size = other.size();
        for (int i3 = 0; i3 < size; i3++) {
            putAll.put(other.keyAt(i3), other.valueAt(i3));
        }
    }

    @RequiresApi(18)
    public static final boolean remove(@NotNull SparseLongArray remove, int i3, long j3) {
        Intrinsics.checkNotNullParameter(remove, "$this$remove");
        int indexOfKey = remove.indexOfKey(i3);
        if (indexOfKey >= 0 && j3 == remove.valueAt(indexOfKey)) {
            remove.removeAt(indexOfKey);
            return true;
        }
        return false;
    }

    @RequiresApi(18)
    public static final void set(@NotNull SparseLongArray set, int i3, long j3) {
        Intrinsics.checkNotNullParameter(set, "$this$set");
        set.put(i3, j3);
    }

    @RequiresApi(18)
    @NotNull
    public static final LongIterator valueIterator(@NotNull final SparseLongArray valueIterator) {
        Intrinsics.checkNotNullParameter(valueIterator, "$this$valueIterator");
        return new LongIterator() { // from class: androidx.core.util.SparseLongArrayKt$valueIterator$1
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

            @Override // kotlin.collections.LongIterator
            public long nextLong() {
                SparseLongArray sparseLongArray = valueIterator;
                int i3 = this.index;
                this.index = i3 + 1;
                return sparseLongArray.valueAt(i3);
            }

            public final void setIndex(int i3) {
                this.index = i3;
            }
        };
    }
}
