package androidx.core.util;

import android.util.LongSparseArray;
import androidx.annotation.RequiresApi;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.LongIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010(\n\u0000\u001a!\u0010\u0006\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0087\n\u001a!\u0010\n\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0087\b\u001a&\u0010\u000b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\f\u001a\u0002H\u0002H\u0087\b\u00a2\u0006\u0002\u0010\r\u001aT\u0010\u000e\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000326\u0010\u0010\u001a2\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\b\u0012\u0013\u0012\u0011H\u0002\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u000f0\u0011H\u0087\b\u00f8\u0001\u0000\u001a.\u0010\u0014\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0015\u001a\u0002H\u0002H\u0087\b\u00a2\u0006\u0002\u0010\u0016\u001a7\u0010\u0017\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0018H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019\u001a\u0019\u0010\u001a\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0087\b\u001a\u0019\u0010\u001b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0087\b\u001a\u0018\u0010\u001c\u001a\u00020\u001d\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007\u001a-\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0087\u0002\u001a&\u0010 \u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007\u001a-\u0010!\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u0002H\u0002H\u0007\u00a2\u0006\u0002\u0010\"\u001a.\u0010#\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u0002H\u0002H\u0087\n\u00a2\u0006\u0002\u0010$\u001a\u001e\u0010%\u001a\b\u0012\u0004\u0012\u0002H\u00020&\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007\"\"\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00038\u00c7\u0002\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006'"}, d2 = {"size", "", "T", "Landroid/util/LongSparseArray;", "getSize", "(Landroid/util/LongSparseArray;)I", "contains", "", "key", "", "containsKey", "containsValue", "value", "(Landroid/util/LongSparseArray;Ljava/lang/Object;)Z", "forEach", "", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "getOrDefault", RemoteHandleConst.PARAM_DEFAULT_VALUE, "(Landroid/util/LongSparseArray;JLjava/lang/Object;)Ljava/lang/Object;", "getOrElse", "Lkotlin/Function0;", "(Landroid/util/LongSparseArray;JLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isEmpty", "isNotEmpty", "keyIterator", "Lkotlin/collections/LongIterator;", QCircleDaTongConstant.ElementParamValue.PLUS, "other", "putAll", "remove", "(Landroid/util/LongSparseArray;JLjava/lang/Object;)Z", "set", "(Landroid/util/LongSparseArray;JLjava/lang/Object;)V", "valueIterator", "", "core-ktx_release"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class LongSparseArrayKt {
    @RequiresApi(16)
    public static final <T> boolean contains(@NotNull LongSparseArray<T> contains, long j3) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        if (contains.indexOfKey(j3) >= 0) {
            return true;
        }
        return false;
    }

    @RequiresApi(16)
    public static final <T> boolean containsKey(@NotNull LongSparseArray<T> containsKey, long j3) {
        Intrinsics.checkNotNullParameter(containsKey, "$this$containsKey");
        if (containsKey.indexOfKey(j3) >= 0) {
            return true;
        }
        return false;
    }

    @RequiresApi(16)
    public static final <T> boolean containsValue(@NotNull LongSparseArray<T> containsValue, T t16) {
        Intrinsics.checkNotNullParameter(containsValue, "$this$containsValue");
        if (containsValue.indexOfValue(t16) >= 0) {
            return true;
        }
        return false;
    }

    @RequiresApi(16)
    public static final <T> void forEach(@NotNull LongSparseArray<T> forEach, @NotNull Function2<? super Long, ? super T, Unit> action) {
        Intrinsics.checkNotNullParameter(forEach, "$this$forEach");
        Intrinsics.checkNotNullParameter(action, "action");
        int size = forEach.size();
        for (int i3 = 0; i3 < size; i3++) {
            action.invoke(Long.valueOf(forEach.keyAt(i3)), forEach.valueAt(i3));
        }
    }

    @RequiresApi(16)
    public static final <T> T getOrDefault(@NotNull LongSparseArray<T> getOrDefault, long j3, T t16) {
        Intrinsics.checkNotNullParameter(getOrDefault, "$this$getOrDefault");
        T t17 = getOrDefault.get(j3);
        if (t17 != null) {
            return t17;
        }
        return t16;
    }

    @RequiresApi(16)
    public static final <T> T getOrElse(@NotNull LongSparseArray<T> getOrElse, long j3, @NotNull Function0<? extends T> defaultValue) {
        Intrinsics.checkNotNullParameter(getOrElse, "$this$getOrElse");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        T t16 = getOrElse.get(j3);
        if (t16 == null) {
            return defaultValue.invoke();
        }
        return t16;
    }

    @RequiresApi(16)
    public static final <T> int getSize(@NotNull LongSparseArray<T> size) {
        Intrinsics.checkNotNullParameter(size, "$this$size");
        return size.size();
    }

    @RequiresApi(16)
    public static final <T> boolean isEmpty(@NotNull LongSparseArray<T> isEmpty) {
        Intrinsics.checkNotNullParameter(isEmpty, "$this$isEmpty");
        if (isEmpty.size() == 0) {
            return true;
        }
        return false;
    }

    @RequiresApi(16)
    public static final <T> boolean isNotEmpty(@NotNull LongSparseArray<T> isNotEmpty) {
        Intrinsics.checkNotNullParameter(isNotEmpty, "$this$isNotEmpty");
        if (isNotEmpty.size() != 0) {
            return true;
        }
        return false;
    }

    @RequiresApi(16)
    @NotNull
    public static final <T> LongIterator keyIterator(@NotNull final LongSparseArray<T> keyIterator) {
        Intrinsics.checkNotNullParameter(keyIterator, "$this$keyIterator");
        return new LongIterator() { // from class: androidx.core.util.LongSparseArrayKt$keyIterator$1
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

            @Override // kotlin.collections.LongIterator
            public long nextLong() {
                LongSparseArray longSparseArray = keyIterator;
                int i3 = this.index;
                this.index = i3 + 1;
                return longSparseArray.keyAt(i3);
            }

            public final void setIndex(int i3) {
                this.index = i3;
            }
        };
    }

    @RequiresApi(16)
    @NotNull
    public static final <T> LongSparseArray<T> plus(@NotNull LongSparseArray<T> plus, @NotNull LongSparseArray<T> other) {
        Intrinsics.checkNotNullParameter(plus, "$this$plus");
        Intrinsics.checkNotNullParameter(other, "other");
        LongSparseArray<T> longSparseArray = new LongSparseArray<>(plus.size() + other.size());
        putAll(longSparseArray, plus);
        putAll(longSparseArray, other);
        return longSparseArray;
    }

    @RequiresApi(16)
    public static final <T> void putAll(@NotNull LongSparseArray<T> putAll, @NotNull LongSparseArray<T> other) {
        Intrinsics.checkNotNullParameter(putAll, "$this$putAll");
        Intrinsics.checkNotNullParameter(other, "other");
        int size = other.size();
        for (int i3 = 0; i3 < size; i3++) {
            putAll.put(other.keyAt(i3), other.valueAt(i3));
        }
    }

    @RequiresApi(16)
    public static final <T> boolean remove(@NotNull LongSparseArray<T> remove, long j3, T t16) {
        Intrinsics.checkNotNullParameter(remove, "$this$remove");
        int indexOfKey = remove.indexOfKey(j3);
        if (indexOfKey >= 0 && Intrinsics.areEqual(t16, remove.valueAt(indexOfKey))) {
            remove.removeAt(indexOfKey);
            return true;
        }
        return false;
    }

    @RequiresApi(16)
    public static final <T> void set(@NotNull LongSparseArray<T> set, long j3, T t16) {
        Intrinsics.checkNotNullParameter(set, "$this$set");
        set.put(j3, t16);
    }

    @RequiresApi(16)
    @NotNull
    public static final <T> Iterator<T> valueIterator(@NotNull LongSparseArray<T> valueIterator) {
        Intrinsics.checkNotNullParameter(valueIterator, "$this$valueIterator");
        return new LongSparseArrayKt$valueIterator$1(valueIterator);
    }
}
