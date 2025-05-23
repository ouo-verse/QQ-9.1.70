package androidx.compose.runtime.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000b\u001a\u00020\fJ\u0018\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\t\u00a8\u0006\u0012"}, d2 = {"Landroidx/compose/runtime/internal/ThreadMap;", "", "size", "", "keys", "", "values", "", "(I[J[Ljava/lang/Object;)V", "[Ljava/lang/Object;", "find", "key", "", "get", "newWith", "value", "trySet", "", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes39.dex */
public final class ThreadMap {
    private final long[] keys;
    private final int size;
    private final Object[] values;

    public ThreadMap(int i3, long[] keys, Object[] values) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        Intrinsics.checkNotNullParameter(values, "values");
        this.size = i3;
        this.keys = keys;
        this.values = values;
    }

    private final int find(long key) {
        int i3 = this.size - 1;
        if (i3 == -1) {
            return -1;
        }
        int i16 = 0;
        if (i3 == 0) {
            long j3 = this.keys[0];
            if (j3 == key) {
                return 0;
            }
            return j3 > key ? -2 : -1;
        }
        while (i16 <= i3) {
            int i17 = (i16 + i3) >>> 1;
            long j16 = this.keys[i17] - key;
            if (j16 < 0) {
                i16 = i17 + 1;
            } else {
                if (j16 <= 0) {
                    return i17;
                }
                i3 = i17 - 1;
            }
        }
        return -(i16 + 1);
    }

    public final Object get(long key) {
        int find = find(key);
        if (find >= 0) {
            return this.values[find];
        }
        return null;
    }

    public final ThreadMap newWith(long key, Object value) {
        int i3 = this.size;
        Object[] objArr = this.values;
        int length = objArr.length;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        while (true) {
            if (i17 >= length) {
                break;
            }
            if (objArr[i17] != null) {
                i18++;
            }
            i17++;
        }
        int i19 = i18 + 1;
        long[] jArr = new long[i19];
        Object[] objArr2 = new Object[i19];
        if (i19 > 1) {
            int i26 = 0;
            while (true) {
                if (i16 >= i19 || i26 >= i3) {
                    break;
                }
                long j3 = this.keys[i26];
                Object obj = this.values[i26];
                if (j3 > key) {
                    jArr[i16] = key;
                    objArr2[i16] = value;
                    i16++;
                    break;
                }
                if (obj != null) {
                    jArr[i16] = j3;
                    objArr2[i16] = obj;
                    i16++;
                }
                i26++;
            }
            if (i26 == i3) {
                int i27 = i19 - 1;
                jArr[i27] = key;
                objArr2[i27] = value;
            } else {
                while (i16 < i19) {
                    long j16 = this.keys[i26];
                    Object obj2 = this.values[i26];
                    if (obj2 != null) {
                        jArr[i16] = j16;
                        objArr2[i16] = obj2;
                        i16++;
                    }
                    i26++;
                }
            }
        } else {
            jArr[0] = key;
            objArr2[0] = value;
        }
        return new ThreadMap(i19, jArr, objArr2);
    }

    public final boolean trySet(long key, Object value) {
        int find = find(key);
        if (find < 0) {
            return false;
        }
        this.values[find] = value;
        return true;
    }
}
