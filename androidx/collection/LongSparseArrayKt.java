package androidx.collection;

import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.LongIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010(\n\u0000\u001a!\u0010\u0006\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0086\n\u001aQ\u0010\n\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000326\u0010\f\u001a2\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\b\u0012\u0013\u0012\u0011H\u0002\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u000b0\rH\u0086\b\u001a.\u0010\u0011\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u0002H\u0002H\u0086\b\u00a2\u0006\u0002\u0010\u0013\u001a4\u0010\u0014\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0015H\u0086\b\u00a2\u0006\u0002\u0010\u0016\u001a\u0019\u0010\u0017\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086\b\u001a\u0016\u0010\u0018\u001a\u00020\u0019\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003\u001a-\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086\u0002\u001a-\u0010\u001c\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u0002H\u0002H\u0007\u00a2\u0006\u0002\u0010\u001d\u001a.\u0010\u001e\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u0002H\u0002H\u0086\n\u00a2\u0006\u0002\u0010\u001f\u001a\u001c\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u00020!\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\"\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00038\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006\""}, d2 = {"size", "", "T", "Landroidx/collection/LongSparseArray;", "getSize", "(Landroidx/collection/LongSparseArray;)I", "contains", "", "key", "", "forEach", "", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "value", "getOrDefault", RemoteHandleConst.PARAM_DEFAULT_VALUE, "(Landroidx/collection/LongSparseArray;JLjava/lang/Object;)Ljava/lang/Object;", "getOrElse", "Lkotlin/Function0;", "(Landroidx/collection/LongSparseArray;JLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isNotEmpty", "keyIterator", "Lkotlin/collections/LongIterator;", QCircleDaTongConstant.ElementParamValue.PLUS, "other", "remove", "(Landroidx/collection/LongSparseArray;JLjava/lang/Object;)Z", "set", "(Landroidx/collection/LongSparseArray;JLjava/lang/Object;)V", "valueIterator", "", "collection-ktx"}, k = 2, mv = {1, 1, 13})
/* loaded from: classes.dex */
public final class LongSparseArrayKt {
    public static final <T> boolean contains(@NotNull LongSparseArray<T> receiver$0, long j3) {
        Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
        return receiver$0.containsKey(j3);
    }

    public static final <T> void forEach(@NotNull LongSparseArray<T> receiver$0, @NotNull Function2<? super Long, ? super T, Unit> action) {
        Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
        Intrinsics.checkParameterIsNotNull(action, "action");
        int size = receiver$0.size();
        for (int i3 = 0; i3 < size; i3++) {
            action.invoke(Long.valueOf(receiver$0.keyAt(i3)), receiver$0.valueAt(i3));
        }
    }

    public static final <T> T getOrDefault(@NotNull LongSparseArray<T> receiver$0, long j3, T t16) {
        Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
        return receiver$0.get(j3, t16);
    }

    public static final <T> T getOrElse(@NotNull LongSparseArray<T> receiver$0, long j3, @NotNull Function0<? extends T> defaultValue) {
        Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
        Intrinsics.checkParameterIsNotNull(defaultValue, "defaultValue");
        T t16 = receiver$0.get(j3);
        if (t16 == null) {
            return defaultValue.invoke();
        }
        return t16;
    }

    public static final <T> int getSize(@NotNull LongSparseArray<T> receiver$0) {
        Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
        return receiver$0.size();
    }

    public static final <T> boolean isNotEmpty(@NotNull LongSparseArray<T> receiver$0) {
        Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
        return !receiver$0.isEmpty();
    }

    @NotNull
    public static final <T> LongIterator keyIterator(@NotNull final LongSparseArray<T> receiver$0) {
        Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
        return new LongIterator() { // from class: androidx.collection.LongSparseArrayKt$keyIterator$1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.index < receiver$0.size()) {
                    return true;
                }
                return false;
            }

            @Override // kotlin.collections.LongIterator
            public long nextLong() {
                LongSparseArray longSparseArray = receiver$0;
                int i3 = this.index;
                this.index = i3 + 1;
                return longSparseArray.keyAt(i3);
            }

            public final void setIndex(int i3) {
                this.index = i3;
            }
        };
    }

    @NotNull
    public static final <T> LongSparseArray<T> plus(@NotNull LongSparseArray<T> receiver$0, @NotNull LongSparseArray<T> other) {
        Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
        Intrinsics.checkParameterIsNotNull(other, "other");
        LongSparseArray<T> longSparseArray = new LongSparseArray<>(receiver$0.size() + other.size());
        longSparseArray.putAll(receiver$0);
        longSparseArray.putAll(other);
        return longSparseArray;
    }

    @Deprecated(message = "Replaced with member function. Remove extension import!")
    public static final <T> boolean remove(@NotNull LongSparseArray<T> receiver$0, long j3, T t16) {
        Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
        return receiver$0.remove(j3, t16);
    }

    public static final <T> void set(@NotNull LongSparseArray<T> receiver$0, long j3, T t16) {
        Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
        receiver$0.put(j3, t16);
    }

    @NotNull
    public static final <T> Iterator<T> valueIterator(@NotNull LongSparseArray<T> receiver$0) {
        Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
        return new LongSparseArrayKt$valueIterator$1(receiver$0);
    }
}
