package androidx.compose.runtime.collection;

import androidx.compose.runtime.ActualJvm_jvmKt;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\fJ&\u0010\u001d\u001a\u00020\u001e2\u0018\u0010\u001f\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u001e0 H\u0086\b\u00f8\u0001\u0000J\u0012\u0010!\u001a\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u0002J\"\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00012\u0006\u0010$\u001a\u00020\fH\u0002J&\u0010%\u001a\u00020\u001a2\u0018\u0010&\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u001a0 H\u0086\b\u00f8\u0001\u0000J\u0011\u0010'\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u0001H\u0086\u0002J\u000e\u0010(\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u0001J&\u0010)\u001a\u00020\u001a2\u0018\u0010\u001f\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u001e0 H\u0086\b\u00f8\u0001\u0000R.\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00048\u0000@\u0000X\u0081\u000e\u00a2\u0006\u0016\n\u0002\u0010\n\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u00020\f8\u0000@\u0000X\u0081\u000e\u00a2\u0006\u0014\n\u0000\u0012\u0004\b\r\u0010\u0002\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u00020\u00138\u0000@\u0000X\u0081\u000e\u00a2\u0006\u0014\n\u0000\u0012\u0004\b\u0014\u0010\u0002\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006*"}, d2 = {"Landroidx/compose/runtime/collection/IdentityArrayIntMap;", "", "()V", "keys", "", "getKeys$annotations", "getKeys", "()[Ljava/lang/Object;", "setKeys", "([Ljava/lang/Object;)V", "[Ljava/lang/Object;", "size", "", "getSize$annotations", "getSize", "()I", "setSize", "(I)V", "values", "", "getValues$annotations", "getValues", "()[I", "setValues", "([I)V", "add", "", "key", "value", SemanticAttributes.DbCassandraConsistencyLevelValues.ANY, "", "predicate", "Lkotlin/Function2;", "find", "findExactIndex", "midIndex", "valueHash", "forEach", "block", "get", "remove", "removeValueIf", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes39.dex */
public final class IdentityArrayIntMap {
    private int size;
    private Object[] keys = new Object[4];
    private int[] values = new int[4];

    private final int find(Object key) {
        int i3 = this.size - 1;
        int identityHashCode = ActualJvm_jvmKt.identityHashCode(key);
        int i16 = 0;
        while (i16 <= i3) {
            int i17 = (i16 + i3) >>> 1;
            Object obj = this.keys[i17];
            int identityHashCode2 = ActualJvm_jvmKt.identityHashCode(obj);
            if (identityHashCode2 < identityHashCode) {
                i16 = i17 + 1;
            } else {
                if (identityHashCode2 <= identityHashCode) {
                    return obj == key ? i17 : findExactIndex(i17, key, identityHashCode);
                }
                i3 = i17 - 1;
            }
        }
        return -(i16 + 1);
    }

    public final void add(Object key, int value) {
        int i3;
        Intrinsics.checkNotNullParameter(key, "key");
        if (this.size > 0) {
            i3 = find(key);
            if (i3 >= 0) {
                this.values[i3] = value;
                return;
            }
        } else {
            i3 = -1;
        }
        int i16 = -(i3 + 1);
        int i17 = this.size;
        Object[] objArr = this.keys;
        if (i17 != objArr.length) {
            int i18 = i16 + 1;
            ArraysKt___ArraysJvmKt.copyInto(objArr, objArr, i18, i16, i17);
            int[] iArr = this.values;
            ArraysKt___ArraysJvmKt.copyInto(iArr, iArr, i18, i16, this.size);
        } else {
            Object[] objArr2 = new Object[objArr.length * 2];
            int[] iArr2 = new int[objArr.length * 2];
            int i19 = i16 + 1;
            ArraysKt___ArraysJvmKt.copyInto(objArr, objArr2, i19, i16, i17);
            ArraysKt___ArraysJvmKt.copyInto(this.values, iArr2, i19, i16, this.size);
            ArraysKt___ArraysJvmKt.copyInto$default(this.keys, objArr2, 0, 0, i16, 6, (Object) null);
            ArraysKt___ArraysJvmKt.copyInto$default(this.values, iArr2, 0, 0, i16, 6, (Object) null);
            this.keys = objArr2;
            this.values = iArr2;
        }
        this.keys[i16] = key;
        this.values[i16] = value;
        this.size++;
    }

    public final boolean any(Function2<Object, ? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int size = getSize();
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = getKeys()[i3];
            if (obj != null) {
                if (predicate.invoke(obj, Integer.valueOf(getValues()[i3])).booleanValue()) {
                    return true;
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
            }
        }
        return false;
    }

    public final void forEach(Function2<Object, ? super Integer, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        int size = getSize();
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = getKeys()[i3];
            if (obj != null) {
                block.invoke(obj, Integer.valueOf(getValues()[i3]));
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
            }
        }
    }

    public final int get(Object key) {
        Intrinsics.checkNotNullParameter(key, "key");
        int find = find(key);
        if (find >= 0) {
            return this.values[find];
        }
        throw new IllegalStateException("Key not found".toString());
    }

    public final Object[] getKeys() {
        return this.keys;
    }

    public final int getSize() {
        return this.size;
    }

    public final int[] getValues() {
        return this.values;
    }

    public final boolean remove(Object key) {
        Intrinsics.checkNotNullParameter(key, "key");
        int find = find(key);
        if (find < 0) {
            return false;
        }
        int i3 = this.size;
        if (find < i3 - 1) {
            Object[] objArr = this.keys;
            int i16 = find + 1;
            ArraysKt___ArraysJvmKt.copyInto(objArr, objArr, find, i16, i3);
            int[] iArr = this.values;
            ArraysKt___ArraysJvmKt.copyInto(iArr, iArr, find, i16, this.size);
        }
        int i17 = this.size - 1;
        this.size = i17;
        this.keys[i17] = null;
        return true;
    }

    public final void removeValueIf(Function2<Object, ? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int size = getSize();
        int i3 = 0;
        for (int i16 = 0; i16 < size; i16++) {
            Object obj = getKeys()[i16];
            if (obj != null) {
                int i17 = getValues()[i16];
                if (!predicate.invoke(obj, Integer.valueOf(i17)).booleanValue()) {
                    if (i3 != i16) {
                        getKeys()[i3] = obj;
                        getValues()[i3] = i17;
                    }
                    i3++;
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
            }
        }
        int size2 = getSize();
        for (int i18 = i3; i18 < size2; i18++) {
            getKeys()[i18] = null;
        }
        setSize(i3);
    }

    public final void setKeys(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<set-?>");
        this.keys = objArr;
    }

    public final void setSize(int i3) {
        this.size = i3;
    }

    public final void setValues(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<set-?>");
        this.values = iArr;
    }

    private final int findExactIndex(int midIndex, Object value, int valueHash) {
        for (int i3 = midIndex - 1; -1 < i3; i3--) {
            Object obj = this.keys[i3];
            if (obj == value) {
                return i3;
            }
            if (ActualJvm_jvmKt.identityHashCode(obj) != valueHash) {
                break;
            }
        }
        int i16 = midIndex + 1;
        int i17 = this.size;
        while (true) {
            if (i16 < i17) {
                Object obj2 = this.keys[i16];
                if (obj2 == value) {
                    return i16;
                }
                if (ActualJvm_jvmKt.identityHashCode(obj2) != valueHash) {
                    break;
                }
                i16++;
            } else {
                i16 = this.size;
                break;
            }
        }
        return -(i16 + 1);
    }

    public static /* synthetic */ void getKeys$annotations() {
    }

    public static /* synthetic */ void getSize$annotations() {
    }

    public static /* synthetic */ void getValues$annotations() {
    }
}
