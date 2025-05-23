package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ArraySet<E> implements Collection<E>, Set<E> {
    private static final int BASE_SIZE = 4;
    private static final int CACHE_SIZE = 10;
    private static final boolean DEBUG = false;
    private static final int[] INT = new int[0];
    private static final Object[] OBJECT = new Object[0];
    private static final String TAG = "ArraySet";

    @Nullable
    private static Object[] sBaseCache;
    private static int sBaseCacheSize;

    @Nullable
    private static Object[] sTwiceBaseCache;
    private static int sTwiceBaseCacheSize;
    Object[] mArray;
    private MapCollections<E, E> mCollections;
    private int[] mHashes;
    int mSize;

    public ArraySet() {
        this(0);
    }

    private void allocArrays(int i3) {
        if (i3 == 8) {
            synchronized (ArraySet.class) {
                Object[] objArr = sTwiceBaseCache;
                if (objArr != null) {
                    this.mArray = objArr;
                    sTwiceBaseCache = (Object[]) objArr[0];
                    this.mHashes = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    sTwiceBaseCacheSize--;
                    return;
                }
            }
        } else if (i3 == 4) {
            synchronized (ArraySet.class) {
                Object[] objArr2 = sBaseCache;
                if (objArr2 != null) {
                    this.mArray = objArr2;
                    sBaseCache = (Object[]) objArr2[0];
                    this.mHashes = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    sBaseCacheSize--;
                    return;
                }
            }
        }
        this.mHashes = new int[i3];
        this.mArray = new Object[i3];
    }

    private static void freeArrays(int[] iArr, Object[] objArr, int i3) {
        if (iArr.length == 8) {
            synchronized (ArraySet.class) {
                if (sTwiceBaseCacheSize < 10) {
                    objArr[0] = sTwiceBaseCache;
                    objArr[1] = iArr;
                    for (int i16 = i3 - 1; i16 >= 2; i16--) {
                        objArr[i16] = null;
                    }
                    sTwiceBaseCache = objArr;
                    sTwiceBaseCacheSize++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (ArraySet.class) {
                if (sBaseCacheSize < 10) {
                    objArr[0] = sBaseCache;
                    objArr[1] = iArr;
                    for (int i17 = i3 - 1; i17 >= 2; i17--) {
                        objArr[i17] = null;
                    }
                    sBaseCache = objArr;
                    sBaseCacheSize++;
                }
            }
        }
    }

    private MapCollections<E, E> getCollection() {
        if (this.mCollections == null) {
            this.mCollections = new MapCollections<E, E>() { // from class: androidx.collection.ArraySet.1
                @Override // androidx.collection.MapCollections
                protected void colClear() {
                    ArraySet.this.clear();
                }

                @Override // androidx.collection.MapCollections
                protected Object colGetEntry(int i3, int i16) {
                    return ArraySet.this.mArray[i3];
                }

                @Override // androidx.collection.MapCollections
                protected Map<E, E> colGetMap() {
                    throw new UnsupportedOperationException("not a map");
                }

                @Override // androidx.collection.MapCollections
                protected int colGetSize() {
                    return ArraySet.this.mSize;
                }

                @Override // androidx.collection.MapCollections
                protected int colIndexOfKey(Object obj) {
                    return ArraySet.this.indexOf(obj);
                }

                @Override // androidx.collection.MapCollections
                protected int colIndexOfValue(Object obj) {
                    return ArraySet.this.indexOf(obj);
                }

                @Override // androidx.collection.MapCollections
                protected void colPut(E e16, E e17) {
                    ArraySet.this.add(e16);
                }

                @Override // androidx.collection.MapCollections
                protected void colRemoveAt(int i3) {
                    ArraySet.this.removeAt(i3);
                }

                @Override // androidx.collection.MapCollections
                protected E colSetValue(int i3, E e16) {
                    throw new UnsupportedOperationException("not a map");
                }
            };
        }
        return this.mCollections;
    }

    private int indexOf(Object obj, int i3) {
        int i16 = this.mSize;
        if (i16 == 0) {
            return -1;
        }
        int binarySearch = ContainerHelpers.binarySearch(this.mHashes, i16, i3);
        if (binarySearch < 0 || obj.equals(this.mArray[binarySearch])) {
            return binarySearch;
        }
        int i17 = binarySearch + 1;
        while (i17 < i16 && this.mHashes[i17] == i3) {
            if (obj.equals(this.mArray[i17])) {
                return i17;
            }
            i17++;
        }
        for (int i18 = binarySearch - 1; i18 >= 0 && this.mHashes[i18] == i3; i18--) {
            if (obj.equals(this.mArray[i18])) {
                return i18;
            }
        }
        return ~i17;
    }

    private int indexOfNull() {
        int i3 = this.mSize;
        if (i3 == 0) {
            return -1;
        }
        int binarySearch = ContainerHelpers.binarySearch(this.mHashes, i3, 0);
        if (binarySearch < 0) {
            return binarySearch;
        }
        if (this.mArray[binarySearch] == null) {
            return binarySearch;
        }
        int i16 = binarySearch + 1;
        while (i16 < i3 && this.mHashes[i16] == 0) {
            if (this.mArray[i16] == null) {
                return i16;
            }
            i16++;
        }
        for (int i17 = binarySearch - 1; i17 >= 0 && this.mHashes[i17] == 0; i17--) {
            if (this.mArray[i17] == null) {
                return i17;
            }
        }
        return ~i16;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(@Nullable E e16) {
        int i3;
        int indexOf;
        if (e16 == null) {
            indexOf = indexOfNull();
            i3 = 0;
        } else {
            int hashCode = e16.hashCode();
            i3 = hashCode;
            indexOf = indexOf(e16, hashCode);
        }
        if (indexOf >= 0) {
            return false;
        }
        int i16 = ~indexOf;
        int i17 = this.mSize;
        int[] iArr = this.mHashes;
        if (i17 >= iArr.length) {
            int i18 = 8;
            if (i17 >= 8) {
                i18 = (i17 >> 1) + i17;
            } else if (i17 < 4) {
                i18 = 4;
            }
            Object[] objArr = this.mArray;
            allocArrays(i18);
            int[] iArr2 = this.mHashes;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.mArray, 0, objArr.length);
            }
            freeArrays(iArr, objArr, this.mSize);
        }
        int i19 = this.mSize;
        if (i16 < i19) {
            int[] iArr3 = this.mHashes;
            int i26 = i16 + 1;
            System.arraycopy(iArr3, i16, iArr3, i26, i19 - i16);
            Object[] objArr2 = this.mArray;
            System.arraycopy(objArr2, i16, objArr2, i26, this.mSize - i16);
        }
        this.mHashes[i16] = i3;
        this.mArray[i16] = e16;
        this.mSize++;
        return true;
    }

    public void addAll(@NonNull ArraySet<? extends E> arraySet) {
        int i3 = arraySet.mSize;
        ensureCapacity(this.mSize + i3);
        if (this.mSize != 0) {
            for (int i16 = 0; i16 < i3; i16++) {
                add(arraySet.valueAt(i16));
            }
        } else if (i3 > 0) {
            System.arraycopy(arraySet.mHashes, 0, this.mHashes, 0, i3);
            System.arraycopy(arraySet.mArray, 0, this.mArray, 0, i3);
            this.mSize = i3;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i3 = this.mSize;
        if (i3 != 0) {
            freeArrays(this.mHashes, this.mArray, i3);
            this.mHashes = INT;
            this.mArray = OBJECT;
            this.mSize = 0;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(@Nullable Object obj) {
        if (indexOf(obj) >= 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(@NonNull Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public void ensureCapacity(int i3) {
        int[] iArr = this.mHashes;
        if (iArr.length < i3) {
            Object[] objArr = this.mArray;
            allocArrays(i3);
            int i16 = this.mSize;
            if (i16 > 0) {
                System.arraycopy(iArr, 0, this.mHashes, 0, i16);
                System.arraycopy(objArr, 0, this.mArray, 0, this.mSize);
            }
            freeArrays(iArr, objArr, this.mSize);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            for (int i3 = 0; i3 < this.mSize; i3++) {
                try {
                    if (!set.contains(valueAt(i3))) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArr = this.mHashes;
        int i3 = this.mSize;
        int i16 = 0;
        for (int i17 = 0; i17 < i3; i17++) {
            i16 += iArr[i17];
        }
        return i16;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        if (this.mSize <= 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return getCollection().getKeySet().iterator();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(@Nullable Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf >= 0) {
            removeAt(indexOf);
            return true;
        }
        return false;
    }

    public boolean removeAll(@NonNull ArraySet<? extends E> arraySet) {
        int i3 = arraySet.mSize;
        int i16 = this.mSize;
        for (int i17 = 0; i17 < i3; i17++) {
            remove(arraySet.valueAt(i17));
        }
        return i16 != this.mSize;
    }

    public E removeAt(int i3) {
        Object[] objArr = this.mArray;
        E e16 = (E) objArr[i3];
        int i16 = this.mSize;
        if (i16 <= 1) {
            freeArrays(this.mHashes, objArr, i16);
            this.mHashes = INT;
            this.mArray = OBJECT;
            this.mSize = 0;
        } else {
            int[] iArr = this.mHashes;
            int i17 = 8;
            if (iArr.length > 8 && i16 < iArr.length / 3) {
                if (i16 > 8) {
                    i17 = i16 + (i16 >> 1);
                }
                allocArrays(i17);
                this.mSize--;
                if (i3 > 0) {
                    System.arraycopy(iArr, 0, this.mHashes, 0, i3);
                    System.arraycopy(objArr, 0, this.mArray, 0, i3);
                }
                int i18 = this.mSize;
                if (i3 < i18) {
                    int i19 = i3 + 1;
                    System.arraycopy(iArr, i19, this.mHashes, i3, i18 - i3);
                    System.arraycopy(objArr, i19, this.mArray, i3, this.mSize - i3);
                }
            } else {
                int i26 = i16 - 1;
                this.mSize = i26;
                if (i3 < i26) {
                    int i27 = i3 + 1;
                    System.arraycopy(iArr, i27, iArr, i3, i26 - i3);
                    Object[] objArr2 = this.mArray;
                    System.arraycopy(objArr2, i27, objArr2, i3, this.mSize - i3);
                }
                this.mArray[this.mSize] = null;
            }
        }
        return e16;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(@NonNull Collection<?> collection) {
        boolean z16 = false;
        for (int i3 = this.mSize - 1; i3 >= 0; i3--) {
            if (!collection.contains(this.mArray[i3])) {
                removeAt(i3);
                z16 = true;
            }
        }
        return z16;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.mSize;
    }

    @Override // java.util.Collection, java.util.Set
    @NonNull
    public Object[] toArray() {
        int i3 = this.mSize;
        Object[] objArr = new Object[i3];
        System.arraycopy(this.mArray, 0, objArr, 0, i3);
        return objArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb5 = new StringBuilder(this.mSize * 14);
        sb5.append('{');
        for (int i3 = 0; i3 < this.mSize; i3++) {
            if (i3 > 0) {
                sb5.append(", ");
            }
            E valueAt = valueAt(i3);
            if (valueAt != this) {
                sb5.append(valueAt);
            } else {
                sb5.append("(this Set)");
            }
        }
        sb5.append('}');
        return sb5.toString();
    }

    @Nullable
    public E valueAt(int i3) {
        return (E) this.mArray[i3];
    }

    public ArraySet(int i3) {
        if (i3 == 0) {
            this.mHashes = INT;
            this.mArray = OBJECT;
        } else {
            allocArrays(i3);
        }
        this.mSize = 0;
    }

    @Override // java.util.Collection, java.util.Set
    @NonNull
    public <T> T[] toArray(@NonNull T[] tArr) {
        if (tArr.length < this.mSize) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.mSize));
        }
        System.arraycopy(this.mArray, 0, tArr, 0, this.mSize);
        int length = tArr.length;
        int i3 = this.mSize;
        if (length > i3) {
            tArr[i3] = null;
        }
        return tArr;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(@NonNull Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean z16 = false;
        while (it.hasNext()) {
            z16 |= remove(it.next());
        }
        return z16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ArraySet(@Nullable ArraySet<E> arraySet) {
        this();
        if (arraySet != 0) {
            addAll((ArraySet) arraySet);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(@NonNull Collection<? extends E> collection) {
        ensureCapacity(this.mSize + collection.size());
        Iterator<? extends E> it = collection.iterator();
        boolean z16 = false;
        while (it.hasNext()) {
            z16 |= add(it.next());
        }
        return z16;
    }

    public int indexOf(@Nullable Object obj) {
        return obj == null ? indexOfNull() : indexOf(obj, obj.hashCode());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ArraySet(@Nullable Collection<E> collection) {
        this();
        if (collection != 0) {
            addAll(collection);
        }
    }
}
