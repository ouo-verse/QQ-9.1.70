package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ConcurrentModificationException;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public class SimpleArrayMap<K, V> {
    private static final int BASE_SIZE = 4;
    private static final int CACHE_SIZE = 10;
    private static final boolean CONCURRENT_MODIFICATION_EXCEPTIONS = true;
    private static final boolean DEBUG = false;
    private static final String TAG = "ArrayMap";

    @Nullable
    static Object[] mBaseCache;
    static int mBaseCacheSize;

    @Nullable
    static Object[] mTwiceBaseCache;
    static int mTwiceBaseCacheSize;
    Object[] mArray;
    int[] mHashes;
    int mSize;

    public SimpleArrayMap() {
        this.mHashes = ContainerHelpers.EMPTY_INTS;
        this.mArray = ContainerHelpers.EMPTY_OBJECTS;
        this.mSize = 0;
    }

    private void allocArrays(int i3) {
        if (i3 == 8) {
            synchronized (SimpleArrayMap.class) {
                Object[] objArr = mTwiceBaseCache;
                if (objArr != null) {
                    this.mArray = objArr;
                    mTwiceBaseCache = (Object[]) objArr[0];
                    this.mHashes = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    mTwiceBaseCacheSize--;
                    return;
                }
            }
        } else if (i3 == 4) {
            synchronized (SimpleArrayMap.class) {
                Object[] objArr2 = mBaseCache;
                if (objArr2 != null) {
                    this.mArray = objArr2;
                    mBaseCache = (Object[]) objArr2[0];
                    this.mHashes = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    mBaseCacheSize--;
                    return;
                }
            }
        }
        this.mHashes = new int[i3];
        this.mArray = new Object[i3 << 1];
    }

    private static int binarySearchHashes(int[] iArr, int i3, int i16) {
        try {
            return ContainerHelpers.binarySearch(iArr, i3, i16);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    private static void freeArrays(int[] iArr, Object[] objArr, int i3) {
        if (iArr.length == 8) {
            synchronized (SimpleArrayMap.class) {
                if (mTwiceBaseCacheSize < 10) {
                    objArr[0] = mTwiceBaseCache;
                    objArr[1] = iArr;
                    for (int i16 = (i3 << 1) - 1; i16 >= 2; i16--) {
                        objArr[i16] = null;
                    }
                    mTwiceBaseCache = objArr;
                    mTwiceBaseCacheSize++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (SimpleArrayMap.class) {
                if (mBaseCacheSize < 10) {
                    objArr[0] = mBaseCache;
                    objArr[1] = iArr;
                    for (int i17 = (i3 << 1) - 1; i17 >= 2; i17--) {
                        objArr[i17] = null;
                    }
                    mBaseCache = objArr;
                    mBaseCacheSize++;
                }
            }
        }
    }

    public void clear() {
        int i3 = this.mSize;
        if (i3 > 0) {
            int[] iArr = this.mHashes;
            Object[] objArr = this.mArray;
            this.mHashes = ContainerHelpers.EMPTY_INTS;
            this.mArray = ContainerHelpers.EMPTY_OBJECTS;
            this.mSize = 0;
            freeArrays(iArr, objArr, i3);
        }
        if (this.mSize <= 0) {
        } else {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(@Nullable Object obj) {
        if (indexOfKey(obj) >= 0) {
            return true;
        }
        return false;
    }

    public boolean containsValue(Object obj) {
        if (indexOfValue(obj) >= 0) {
            return true;
        }
        return false;
    }

    public void ensureCapacity(int i3) {
        int i16 = this.mSize;
        int[] iArr = this.mHashes;
        if (iArr.length < i3) {
            Object[] objArr = this.mArray;
            allocArrays(i3);
            if (this.mSize > 0) {
                System.arraycopy(iArr, 0, this.mHashes, 0, i16);
                System.arraycopy(objArr, 0, this.mArray, 0, i16 << 1);
            }
            freeArrays(iArr, objArr, i16);
        }
        if (this.mSize == i16) {
        } else {
            throw new ConcurrentModificationException();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SimpleArrayMap) {
            SimpleArrayMap simpleArrayMap = (SimpleArrayMap) obj;
            if (size() != simpleArrayMap.size()) {
                return false;
            }
            for (int i3 = 0; i3 < this.mSize; i3++) {
                try {
                    K keyAt = keyAt(i3);
                    V valueAt = valueAt(i3);
                    Object obj2 = simpleArrayMap.get(keyAt);
                    if (valueAt == null) {
                        if (obj2 != null || !simpleArrayMap.containsKey(keyAt)) {
                            return false;
                        }
                    } else if (!valueAt.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            for (int i16 = 0; i16 < this.mSize; i16++) {
                try {
                    K keyAt2 = keyAt(i16);
                    V valueAt2 = valueAt(i16);
                    Object obj3 = map.get(keyAt2);
                    if (valueAt2 == null) {
                        if (obj3 != null || !map.containsKey(keyAt2)) {
                            return false;
                        }
                    } else if (!valueAt2.equals(obj3)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    @Nullable
    public V get(Object obj) {
        return getOrDefault(obj, null);
    }

    public V getOrDefault(Object obj, V v3) {
        int indexOfKey = indexOfKey(obj);
        if (indexOfKey >= 0) {
            return (V) this.mArray[(indexOfKey << 1) + 1];
        }
        return v3;
    }

    public int hashCode() {
        int hashCode;
        int[] iArr = this.mHashes;
        Object[] objArr = this.mArray;
        int i3 = this.mSize;
        int i16 = 1;
        int i17 = 0;
        int i18 = 0;
        while (i17 < i3) {
            Object obj = objArr[i16];
            int i19 = iArr[i17];
            if (obj == null) {
                hashCode = 0;
            } else {
                hashCode = obj.hashCode();
            }
            i18 += hashCode ^ i19;
            i17++;
            i16 += 2;
        }
        return i18;
    }

    int indexOf(Object obj, int i3) {
        int i16 = this.mSize;
        if (i16 == 0) {
            return -1;
        }
        int binarySearchHashes = binarySearchHashes(this.mHashes, i16, i3);
        if (binarySearchHashes < 0) {
            return binarySearchHashes;
        }
        if (obj.equals(this.mArray[binarySearchHashes << 1])) {
            return binarySearchHashes;
        }
        int i17 = binarySearchHashes + 1;
        while (i17 < i16 && this.mHashes[i17] == i3) {
            if (obj.equals(this.mArray[i17 << 1])) {
                return i17;
            }
            i17++;
        }
        for (int i18 = binarySearchHashes - 1; i18 >= 0 && this.mHashes[i18] == i3; i18--) {
            if (obj.equals(this.mArray[i18 << 1])) {
                return i18;
            }
        }
        return ~i17;
    }

    public int indexOfKey(@Nullable Object obj) {
        if (obj == null) {
            return indexOfNull();
        }
        return indexOf(obj, obj.hashCode());
    }

    int indexOfNull() {
        int i3 = this.mSize;
        if (i3 == 0) {
            return -1;
        }
        int binarySearchHashes = binarySearchHashes(this.mHashes, i3, 0);
        if (binarySearchHashes < 0) {
            return binarySearchHashes;
        }
        if (this.mArray[binarySearchHashes << 1] == null) {
            return binarySearchHashes;
        }
        int i16 = binarySearchHashes + 1;
        while (i16 < i3 && this.mHashes[i16] == 0) {
            if (this.mArray[i16 << 1] == null) {
                return i16;
            }
            i16++;
        }
        for (int i17 = binarySearchHashes - 1; i17 >= 0 && this.mHashes[i17] == 0; i17--) {
            if (this.mArray[i17 << 1] == null) {
                return i17;
            }
        }
        return ~i16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int indexOfValue(Object obj) {
        int i3 = this.mSize * 2;
        Object[] objArr = this.mArray;
        if (obj == null) {
            for (int i16 = 1; i16 < i3; i16 += 2) {
                if (objArr[i16] == null) {
                    return i16 >> 1;
                }
            }
            return -1;
        }
        for (int i17 = 1; i17 < i3; i17 += 2) {
            if (obj.equals(objArr[i17])) {
                return i17 >> 1;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        if (this.mSize <= 0) {
            return true;
        }
        return false;
    }

    public K keyAt(int i3) {
        return (K) this.mArray[i3 << 1];
    }

    @Nullable
    public V put(K k3, V v3) {
        int i3;
        int indexOf;
        int i16 = this.mSize;
        if (k3 == null) {
            indexOf = indexOfNull();
            i3 = 0;
        } else {
            int hashCode = k3.hashCode();
            i3 = hashCode;
            indexOf = indexOf(k3, hashCode);
        }
        if (indexOf >= 0) {
            int i17 = (indexOf << 1) + 1;
            Object[] objArr = this.mArray;
            V v16 = (V) objArr[i17];
            objArr[i17] = v3;
            return v16;
        }
        int i18 = ~indexOf;
        int[] iArr = this.mHashes;
        if (i16 >= iArr.length) {
            int i19 = 8;
            if (i16 >= 8) {
                i19 = (i16 >> 1) + i16;
            } else if (i16 < 4) {
                i19 = 4;
            }
            Object[] objArr2 = this.mArray;
            allocArrays(i19);
            if (i16 == this.mSize) {
                int[] iArr2 = this.mHashes;
                if (iArr2.length > 0) {
                    System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                    System.arraycopy(objArr2, 0, this.mArray, 0, objArr2.length);
                }
                freeArrays(iArr, objArr2, i16);
            } else {
                throw new ConcurrentModificationException();
            }
        }
        if (i18 < i16) {
            int[] iArr3 = this.mHashes;
            int i26 = i18 + 1;
            System.arraycopy(iArr3, i18, iArr3, i26, i16 - i18);
            Object[] objArr3 = this.mArray;
            System.arraycopy(objArr3, i18 << 1, objArr3, i26 << 1, (this.mSize - i18) << 1);
        }
        int i27 = this.mSize;
        if (i16 == i27) {
            int[] iArr4 = this.mHashes;
            if (i18 < iArr4.length) {
                iArr4[i18] = i3;
                Object[] objArr4 = this.mArray;
                int i28 = i18 << 1;
                objArr4[i28] = k3;
                objArr4[i28 + 1] = v3;
                this.mSize = i27 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public void putAll(@NonNull SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        int i3 = simpleArrayMap.mSize;
        ensureCapacity(this.mSize + i3);
        if (this.mSize == 0) {
            if (i3 > 0) {
                System.arraycopy(simpleArrayMap.mHashes, 0, this.mHashes, 0, i3);
                System.arraycopy(simpleArrayMap.mArray, 0, this.mArray, 0, i3 << 1);
                this.mSize = i3;
                return;
            }
            return;
        }
        for (int i16 = 0; i16 < i3; i16++) {
            put(simpleArrayMap.keyAt(i16), simpleArrayMap.valueAt(i16));
        }
    }

    @Nullable
    public V putIfAbsent(K k3, V v3) {
        V v16 = get(k3);
        if (v16 == null) {
            return put(k3, v3);
        }
        return v16;
    }

    @Nullable
    public V remove(Object obj) {
        int indexOfKey = indexOfKey(obj);
        if (indexOfKey >= 0) {
            return removeAt(indexOfKey);
        }
        return null;
    }

    public V removeAt(int i3) {
        Object[] objArr = this.mArray;
        int i16 = i3 << 1;
        V v3 = (V) objArr[i16 + 1];
        int i17 = this.mSize;
        int i18 = 0;
        if (i17 <= 1) {
            freeArrays(this.mHashes, objArr, i17);
            this.mHashes = ContainerHelpers.EMPTY_INTS;
            this.mArray = ContainerHelpers.EMPTY_OBJECTS;
        } else {
            int i19 = i17 - 1;
            int[] iArr = this.mHashes;
            int i26 = 8;
            if (iArr.length > 8 && i17 < iArr.length / 3) {
                if (i17 > 8) {
                    i26 = i17 + (i17 >> 1);
                }
                allocArrays(i26);
                if (i17 == this.mSize) {
                    if (i3 > 0) {
                        System.arraycopy(iArr, 0, this.mHashes, 0, i3);
                        System.arraycopy(objArr, 0, this.mArray, 0, i16);
                    }
                    if (i3 < i19) {
                        int i27 = i3 + 1;
                        int i28 = i19 - i3;
                        System.arraycopy(iArr, i27, this.mHashes, i3, i28);
                        System.arraycopy(objArr, i27 << 1, this.mArray, i16, i28 << 1);
                    }
                } else {
                    throw new ConcurrentModificationException();
                }
            } else {
                if (i3 < i19) {
                    int i29 = i3 + 1;
                    int i36 = i19 - i3;
                    System.arraycopy(iArr, i29, iArr, i3, i36);
                    Object[] objArr2 = this.mArray;
                    System.arraycopy(objArr2, i29 << 1, objArr2, i16, i36 << 1);
                }
                Object[] objArr3 = this.mArray;
                int i37 = i19 << 1;
                objArr3[i37] = null;
                objArr3[i37 + 1] = null;
            }
            i18 = i19;
        }
        if (i17 == this.mSize) {
            this.mSize = i18;
            return v3;
        }
        throw new ConcurrentModificationException();
    }

    @Nullable
    public V replace(K k3, V v3) {
        int indexOfKey = indexOfKey(k3);
        if (indexOfKey >= 0) {
            return setValueAt(indexOfKey, v3);
        }
        return null;
    }

    public V setValueAt(int i3, V v3) {
        int i16 = (i3 << 1) + 1;
        Object[] objArr = this.mArray;
        V v16 = (V) objArr[i16];
        objArr[i16] = v3;
        return v16;
    }

    public int size() {
        return this.mSize;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb5 = new StringBuilder(this.mSize * 28);
        sb5.append('{');
        for (int i3 = 0; i3 < this.mSize; i3++) {
            if (i3 > 0) {
                sb5.append(", ");
            }
            K keyAt = keyAt(i3);
            if (keyAt != this) {
                sb5.append(keyAt);
            } else {
                sb5.append("(this Map)");
            }
            sb5.append('=');
            V valueAt = valueAt(i3);
            if (valueAt != this) {
                sb5.append(valueAt);
            } else {
                sb5.append("(this Map)");
            }
        }
        sb5.append('}');
        return sb5.toString();
    }

    public V valueAt(int i3) {
        return (V) this.mArray[(i3 << 1) + 1];
    }

    public boolean remove(Object obj, Object obj2) {
        int indexOfKey = indexOfKey(obj);
        if (indexOfKey < 0) {
            return false;
        }
        V valueAt = valueAt(indexOfKey);
        if (obj2 != valueAt && (obj2 == null || !obj2.equals(valueAt))) {
            return false;
        }
        removeAt(indexOfKey);
        return true;
    }

    public boolean replace(K k3, V v3, V v16) {
        int indexOfKey = indexOfKey(k3);
        if (indexOfKey < 0) {
            return false;
        }
        V valueAt = valueAt(indexOfKey);
        if (valueAt != v3 && (v3 == null || !v3.equals(valueAt))) {
            return false;
        }
        setValueAt(indexOfKey, v16);
        return true;
    }

    public SimpleArrayMap(int i3) {
        if (i3 == 0) {
            this.mHashes = ContainerHelpers.EMPTY_INTS;
            this.mArray = ContainerHelpers.EMPTY_OBJECTS;
        } else {
            allocArrays(i3);
        }
        this.mSize = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SimpleArrayMap(SimpleArrayMap<K, V> simpleArrayMap) {
        this();
        if (simpleArrayMap != 0) {
            putAll(simpleArrayMap);
        }
    }
}
