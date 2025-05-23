package androidx.compose.runtime.collection;

import androidx.compose.runtime.ActualJvm_jvmKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0004\b\u0001\u0010\u00032\u00020\u0002B\u000f\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00028\u0000H\u0086\u0002\u00a2\u0006\u0002\u0010\u0018J\u0012\u0010\u0019\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002H\u0002J\"\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001c\u001a\u00020\u0005H\u0002JD\u0010\u001d\u001a\u00020\u001e26\u0010\u001f\u001a2\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00118\u0001\u00a2\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u001e0 H\u0086\b\u00f8\u0001\u0000J\u0018\u0010$\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0017\u001a\u00028\u0000H\u0086\u0002\u00a2\u0006\u0002\u0010%J\u0006\u0010&\u001a\u00020\u0016J\u0006\u0010'\u001a\u00020\u0016J\u0013\u0010(\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u0018J/\u0010)\u001a\u00020\u001e2!\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u00118\u0001\u00a2\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u00160*H\u0086\b\u00f8\u0001\u0000J\u001e\u0010+\u001a\u00020\u001e2\u0006\u0010\u0017\u001a\u00028\u00002\u0006\u0010#\u001a\u00028\u0001H\u0086\u0002\u00a2\u0006\u0002\u0010,R$\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\bX\u0080\u000e\u00a2\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\u0005X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0006R$\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\bX\u0080\u000e\u00a2\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\f\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006-"}, d2 = {"Landroidx/compose/runtime/collection/IdentityArrayMap;", "Key", "", "Value", "capacity", "", "(I)V", "keys", "", "getKeys$runtime_release", "()[Ljava/lang/Object;", "setKeys$runtime_release", "([Ljava/lang/Object;)V", "[Ljava/lang/Object;", "size", "getSize$runtime_release", "()I", "setSize$runtime_release", "values", "getValues$runtime_release", "setValues$runtime_release", "contains", "", "key", "(Ljava/lang/Object;)Z", "find", "findExactIndex", "midIndex", "keyHash", "forEach", "", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "value", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "isEmpty", "isNotEmpty", "remove", "removeValueIf", "Lkotlin/Function1;", "set", "(Ljava/lang/Object;Ljava/lang/Object;)V", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes39.dex */
public final class IdentityArrayMap<Key, Value> {
    private Object[] keys;
    private int size;
    private Object[] values;

    public IdentityArrayMap() {
        this(0, 1, null);
    }

    private final int find(Object key) {
        int identityHashCode = ActualJvm_jvmKt.identityHashCode(key);
        int i3 = this.size - 1;
        int i16 = 0;
        while (i16 <= i3) {
            int i17 = (i16 + i3) >>> 1;
            Object obj = this.keys[i17];
            int identityHashCode2 = ActualJvm_jvmKt.identityHashCode(obj);
            if (identityHashCode2 < identityHashCode) {
                i16 = i17 + 1;
            } else {
                if (identityHashCode2 <= identityHashCode) {
                    return key == obj ? i17 : findExactIndex(i17, key, identityHashCode);
                }
                i3 = i17 - 1;
            }
        }
        return -(i16 + 1);
    }

    public final boolean contains(Key key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return find(key) >= 0;
    }

    public final void forEach(Function2<? super Key, ? super Value, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        int size = getSize();
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = getKeys()[i3];
            if (obj != null) {
                block.invoke(obj, getValues()[i3]);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type Key of androidx.compose.runtime.collection.IdentityArrayMap");
            }
        }
    }

    public final Value get(Key key) {
        Intrinsics.checkNotNullParameter(key, "key");
        int find = find(key);
        if (find >= 0) {
            return (Value) this.values[find];
        }
        return null;
    }

    /* renamed from: getKeys$runtime_release, reason: from getter */
    public final Object[] getKeys() {
        return this.keys;
    }

    /* renamed from: getSize$runtime_release, reason: from getter */
    public final int getSize() {
        return this.size;
    }

    /* renamed from: getValues$runtime_release, reason: from getter */
    public final Object[] getValues() {
        return this.values;
    }

    public final boolean isEmpty() {
        return this.size == 0;
    }

    public final boolean isNotEmpty() {
        return this.size > 0;
    }

    public final boolean remove(Key key) {
        Intrinsics.checkNotNullParameter(key, "key");
        int find = find(key);
        if (find < 0) {
            return false;
        }
        int i3 = this.size;
        Object[] objArr = this.keys;
        Object[] objArr2 = this.values;
        int i16 = find + 1;
        ArraysKt___ArraysJvmKt.copyInto(objArr, objArr, find, i16, i3);
        ArraysKt___ArraysJvmKt.copyInto(objArr2, objArr2, find, i16, i3);
        int i17 = i3 - 1;
        objArr[i17] = null;
        objArr2[i17] = null;
        this.size = i17;
        return true;
    }

    public final void removeValueIf(Function1<? super Value, Boolean> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        int size = getSize();
        int i3 = 0;
        for (int i16 = 0; i16 < size; i16++) {
            Object obj = getValues()[i16];
            if (!block.invoke(obj).booleanValue()) {
                if (i3 != i16) {
                    getKeys()[i3] = getKeys()[i16];
                    getValues()[i3] = obj;
                }
                i3++;
            }
        }
        if (getSize() > i3) {
            int size2 = getSize();
            for (int i17 = i3; i17 < size2; i17++) {
                getKeys()[i17] = null;
                getValues()[i17] = null;
            }
            setSize$runtime_release(i3);
        }
    }

    public final void set(Key key, Value value) {
        Object[] objArr;
        Intrinsics.checkNotNullParameter(key, "key");
        int find = find(key);
        if (find >= 0) {
            this.values[find] = value;
            return;
        }
        int i3 = -(find + 1);
        int i16 = this.size;
        Object[] objArr2 = this.keys;
        boolean z16 = i16 == objArr2.length;
        Object[] objArr3 = z16 ? new Object[i16 * 2] : objArr2;
        int i17 = i3 + 1;
        ArraysKt___ArraysJvmKt.copyInto(objArr2, objArr3, i17, i3, i16);
        if (z16) {
            ArraysKt___ArraysJvmKt.copyInto$default(this.keys, objArr3, 0, 0, i3, 6, (Object) null);
        }
        objArr3[i3] = key;
        this.keys = objArr3;
        if (z16) {
            objArr = new Object[this.size * 2];
        } else {
            objArr = this.values;
        }
        ArraysKt___ArraysJvmKt.copyInto(this.values, objArr, i17, i3, this.size);
        if (z16) {
            ArraysKt___ArraysJvmKt.copyInto$default(this.values, objArr, 0, 0, i3, 6, (Object) null);
        }
        objArr[i3] = value;
        this.values = objArr;
        this.size++;
    }

    public final void setKeys$runtime_release(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<set-?>");
        this.keys = objArr;
    }

    public final void setSize$runtime_release(int i3) {
        this.size = i3;
    }

    public final void setValues$runtime_release(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<set-?>");
        this.values = objArr;
    }

    public IdentityArrayMap(int i3) {
        this.keys = new Object[i3];
        this.values = new Object[i3];
    }

    public /* synthetic */ IdentityArrayMap(int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 16 : i3);
    }

    private final int findExactIndex(int midIndex, Object key, int keyHash) {
        for (int i3 = midIndex - 1; -1 < i3; i3--) {
            Object obj = this.keys[i3];
            if (obj == key) {
                return i3;
            }
            if (ActualJvm_jvmKt.identityHashCode(obj) != keyHash) {
                break;
            }
        }
        int i16 = midIndex + 1;
        int i17 = this.size;
        while (true) {
            if (i16 < i17) {
                Object obj2 = this.keys[i16];
                if (obj2 == key) {
                    return i16;
                }
                if (ActualJvm_jvmKt.identityHashCode(obj2) != keyHash) {
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
}
