package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

/* compiled from: P */
/* loaded from: classes.dex */
public class SortedList<T> {
    private static final int CAPACITY_GROWTH = 10;
    private static final int DELETION = 2;
    private static final int INSERTION = 1;
    public static final int INVALID_POSITION = -1;
    private static final int LOOKUP = 4;
    private static final int MIN_CAPACITY = 10;
    private BatchedCallback mBatchedCallback;
    private Callback mCallback;
    T[] mData;
    private int mNewDataStart;
    private T[] mOldData;
    private int mOldDataSize;
    private int mOldDataStart;
    private int mSize;
    private final Class<T> mTClass;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class BatchedCallback<T2> extends Callback<T2> {
        private final BatchingListUpdateCallback mBatchingListUpdateCallback;
        final Callback<T2> mWrappedCallback;

        public BatchedCallback(Callback<T2> callback) {
            this.mWrappedCallback = callback;
            this.mBatchingListUpdateCallback = new BatchingListUpdateCallback(callback);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        public boolean areContentsTheSame(T2 t26, T2 t27) {
            return this.mWrappedCallback.areContentsTheSame(t26, t27);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        public boolean areItemsTheSame(T2 t26, T2 t27) {
            return this.mWrappedCallback.areItemsTheSame(t26, t27);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback, java.util.Comparator
        public int compare(T2 t26, T2 t27) {
            return this.mWrappedCallback.compare(t26, t27);
        }

        public void dispatchLastEvent() {
            this.mBatchingListUpdateCallback.dispatchLastEvent();
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        @Nullable
        public Object getChangePayload(T2 t26, T2 t27) {
            return this.mWrappedCallback.getChangePayload(t26, t27);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        public void onChanged(int i3, int i16) {
            this.mBatchingListUpdateCallback.onChanged(i3, i16, null);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onInserted(int i3, int i16) {
            this.mBatchingListUpdateCallback.onInserted(i3, i16);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onMoved(int i3, int i16) {
            this.mBatchingListUpdateCallback.onMoved(i3, i16);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onRemoved(int i3, int i16) {
            this.mBatchingListUpdateCallback.onRemoved(i3, i16);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback, androidx.recyclerview.widget.ListUpdateCallback
        public void onChanged(int i3, int i16, Object obj) {
            this.mBatchingListUpdateCallback.onChanged(i3, i16, obj);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static abstract class Callback<T2> implements Comparator<T2>, ListUpdateCallback {
        public abstract boolean areContentsTheSame(T2 t26, T2 t27);

        public abstract boolean areItemsTheSame(T2 t26, T2 t27);

        @Override // java.util.Comparator
        public abstract int compare(T2 t26, T2 t27);

        @Nullable
        public Object getChangePayload(T2 t26, T2 t27) {
            return null;
        }

        public abstract void onChanged(int i3, int i16);

        public void onChanged(int i3, int i16, Object obj) {
            onChanged(i3, i16);
        }
    }

    public SortedList(@NonNull Class<T> cls, @NonNull Callback<T> callback) {
        this(cls, callback, 10);
    }

    private void addAllInternal(T[] tArr) {
        if (tArr.length < 1) {
            return;
        }
        int sortAndDedup = sortAndDedup(tArr);
        if (this.mSize == 0) {
            this.mData = tArr;
            this.mSize = sortAndDedup;
            this.mCallback.onInserted(0, sortAndDedup);
            return;
        }
        merge(tArr, sortAndDedup);
    }

    private void addToData(int i3, T t16) {
        int i16 = this.mSize;
        if (i3 <= i16) {
            T[] tArr = this.mData;
            if (i16 == tArr.length) {
                T[] tArr2 = (T[]) ((Object[]) Array.newInstance((Class<?>) this.mTClass, tArr.length + 10));
                System.arraycopy(this.mData, 0, tArr2, 0, i3);
                tArr2[i3] = t16;
                System.arraycopy(this.mData, i3, tArr2, i3 + 1, this.mSize - i3);
                this.mData = tArr2;
            } else {
                System.arraycopy(tArr, i3, tArr, i3 + 1, i16 - i3);
                this.mData[i3] = t16;
            }
            this.mSize++;
            return;
        }
        throw new IndexOutOfBoundsException("cannot add item to " + i3 + " because size is " + this.mSize);
    }

    private T[] copyArray(T[] tArr) {
        T[] tArr2 = (T[]) ((Object[]) Array.newInstance((Class<?>) this.mTClass, tArr.length));
        System.arraycopy(tArr, 0, tArr2, 0, tArr.length);
        return tArr2;
    }

    private int findIndexOf(T t16, T[] tArr, int i3, int i16, int i17) {
        while (i3 < i16) {
            int i18 = (i3 + i16) / 2;
            T t17 = tArr[i18];
            int compare = this.mCallback.compare(t17, t16);
            if (compare < 0) {
                i3 = i18 + 1;
            } else {
                if (compare == 0) {
                    if (this.mCallback.areItemsTheSame(t17, t16)) {
                        return i18;
                    }
                    int linearEqualitySearch = linearEqualitySearch(t16, i18, i3, i16);
                    if (i17 == 1) {
                        if (linearEqualitySearch != -1) {
                            return linearEqualitySearch;
                        }
                        return i18;
                    }
                    return linearEqualitySearch;
                }
                i16 = i18;
            }
        }
        if (i17 != 1) {
            return -1;
        }
        return i3;
    }

    private int findSameItem(T t16, T[] tArr, int i3, int i16) {
        while (i3 < i16) {
            if (this.mCallback.areItemsTheSame(tArr[i3], t16)) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    private int linearEqualitySearch(T t16, int i3, int i16, int i17) {
        T t17;
        for (int i18 = i3 - 1; i18 >= i16; i18--) {
            T t18 = this.mData[i18];
            if (this.mCallback.compare(t18, t16) != 0) {
                break;
            }
            if (this.mCallback.areItemsTheSame(t18, t16)) {
                return i18;
            }
        }
        do {
            i3++;
            if (i3 < i17) {
                t17 = this.mData[i3];
                if (this.mCallback.compare(t17, t16) != 0) {
                    return -1;
                }
            } else {
                return -1;
            }
        } while (!this.mCallback.areItemsTheSame(t17, t16));
        return i3;
    }

    private void merge(T[] tArr, int i3) {
        boolean z16 = !(this.mCallback instanceof BatchedCallback);
        if (z16) {
            beginBatchedUpdates();
        }
        this.mOldData = this.mData;
        int i16 = 0;
        this.mOldDataStart = 0;
        int i17 = this.mSize;
        this.mOldDataSize = i17;
        this.mData = (T[]) ((Object[]) Array.newInstance((Class<?>) this.mTClass, i17 + i3 + 10));
        this.mNewDataStart = 0;
        while (true) {
            int i18 = this.mOldDataStart;
            int i19 = this.mOldDataSize;
            if (i18 >= i19 && i16 >= i3) {
                break;
            }
            if (i18 == i19) {
                int i26 = i3 - i16;
                System.arraycopy(tArr, i16, this.mData, this.mNewDataStart, i26);
                int i27 = this.mNewDataStart + i26;
                this.mNewDataStart = i27;
                this.mSize += i26;
                this.mCallback.onInserted(i27 - i26, i26);
                break;
            }
            if (i16 == i3) {
                int i28 = i19 - i18;
                System.arraycopy(this.mOldData, i18, this.mData, this.mNewDataStart, i28);
                this.mNewDataStart += i28;
                break;
            }
            T t16 = this.mOldData[i18];
            T t17 = tArr[i16];
            int compare = this.mCallback.compare(t16, t17);
            if (compare > 0) {
                T[] tArr2 = this.mData;
                int i29 = this.mNewDataStart;
                int i36 = i29 + 1;
                this.mNewDataStart = i36;
                tArr2[i29] = t17;
                this.mSize++;
                i16++;
                this.mCallback.onInserted(i36 - 1, 1);
            } else if (compare == 0 && this.mCallback.areItemsTheSame(t16, t17)) {
                T[] tArr3 = this.mData;
                int i37 = this.mNewDataStart;
                this.mNewDataStart = i37 + 1;
                tArr3[i37] = t17;
                i16++;
                this.mOldDataStart++;
                if (!this.mCallback.areContentsTheSame(t16, t17)) {
                    Callback callback = this.mCallback;
                    callback.onChanged(this.mNewDataStart - 1, 1, callback.getChangePayload(t16, t17));
                }
            } else {
                T[] tArr4 = this.mData;
                int i38 = this.mNewDataStart;
                this.mNewDataStart = i38 + 1;
                tArr4[i38] = t16;
                this.mOldDataStart++;
            }
        }
        this.mOldData = null;
        if (z16) {
            endBatchedUpdates();
        }
    }

    private void removeItemAtIndex(int i3, boolean z16) {
        T[] tArr = this.mData;
        System.arraycopy(tArr, i3 + 1, tArr, i3, (this.mSize - i3) - 1);
        int i16 = this.mSize - 1;
        this.mSize = i16;
        this.mData[i16] = null;
        if (z16) {
            this.mCallback.onRemoved(i3, 1);
        }
    }

    private void replaceAllInsert(T t16) {
        T[] tArr = this.mData;
        int i3 = this.mNewDataStart;
        tArr[i3] = t16;
        int i16 = i3 + 1;
        this.mNewDataStart = i16;
        this.mSize++;
        this.mCallback.onInserted(i16 - 1, 1);
    }

    private void replaceAllInternal(@NonNull T[] tArr) {
        boolean z16 = !(this.mCallback instanceof BatchedCallback);
        if (z16) {
            beginBatchedUpdates();
        }
        this.mOldDataStart = 0;
        this.mOldDataSize = this.mSize;
        this.mOldData = this.mData;
        this.mNewDataStart = 0;
        int sortAndDedup = sortAndDedup(tArr);
        this.mData = (T[]) ((Object[]) Array.newInstance((Class<?>) this.mTClass, sortAndDedup));
        while (true) {
            int i3 = this.mNewDataStart;
            if (i3 >= sortAndDedup && this.mOldDataStart >= this.mOldDataSize) {
                break;
            }
            int i16 = this.mOldDataStart;
            int i17 = this.mOldDataSize;
            if (i16 >= i17) {
                int i18 = sortAndDedup - i3;
                System.arraycopy(tArr, i3, this.mData, i3, i18);
                this.mNewDataStart += i18;
                this.mSize += i18;
                this.mCallback.onInserted(i3, i18);
                break;
            }
            if (i3 >= sortAndDedup) {
                int i19 = i17 - i16;
                this.mSize -= i19;
                this.mCallback.onRemoved(i3, i19);
                break;
            }
            T t16 = this.mOldData[i16];
            T t17 = tArr[i3];
            int compare = this.mCallback.compare(t16, t17);
            if (compare < 0) {
                replaceAllRemove();
            } else if (compare > 0) {
                replaceAllInsert(t17);
            } else if (!this.mCallback.areItemsTheSame(t16, t17)) {
                replaceAllRemove();
                replaceAllInsert(t17);
            } else {
                T[] tArr2 = this.mData;
                int i26 = this.mNewDataStart;
                tArr2[i26] = t17;
                this.mOldDataStart++;
                this.mNewDataStart = i26 + 1;
                if (!this.mCallback.areContentsTheSame(t16, t17)) {
                    Callback callback = this.mCallback;
                    callback.onChanged(this.mNewDataStart - 1, 1, callback.getChangePayload(t16, t17));
                }
            }
        }
        this.mOldData = null;
        if (z16) {
            endBatchedUpdates();
        }
    }

    private void replaceAllRemove() {
        this.mSize--;
        this.mOldDataStart++;
        this.mCallback.onRemoved(this.mNewDataStart, 1);
    }

    private int sortAndDedup(@NonNull T[] tArr) {
        if (tArr.length == 0) {
            return 0;
        }
        Arrays.sort(tArr, this.mCallback);
        int i3 = 0;
        int i16 = 1;
        for (int i17 = 1; i17 < tArr.length; i17++) {
            T t16 = tArr[i17];
            if (this.mCallback.compare(tArr[i3], t16) == 0) {
                int findSameItem = findSameItem(t16, tArr, i3, i16);
                if (findSameItem != -1) {
                    tArr[findSameItem] = t16;
                } else {
                    if (i16 != i17) {
                        tArr[i16] = t16;
                    }
                    i16++;
                }
            } else {
                if (i16 != i17) {
                    tArr[i16] = t16;
                }
                i3 = i16;
                i16++;
            }
        }
        return i16;
    }

    private void throwIfInMutationOperation() {
        if (this.mOldData == null) {
        } else {
            throw new IllegalStateException("Data cannot be mutated in the middle of a batch update operation such as addAll or replaceAll.");
        }
    }

    public int add(T t16) {
        throwIfInMutationOperation();
        return add(t16, true);
    }

    public void addAll(@NonNull T[] tArr, boolean z16) {
        throwIfInMutationOperation();
        if (tArr.length == 0) {
            return;
        }
        if (z16) {
            addAllInternal(tArr);
        } else {
            addAllInternal(copyArray(tArr));
        }
    }

    public void beginBatchedUpdates() {
        throwIfInMutationOperation();
        Callback callback = this.mCallback;
        if (callback instanceof BatchedCallback) {
            return;
        }
        if (this.mBatchedCallback == null) {
            this.mBatchedCallback = new BatchedCallback(callback);
        }
        this.mCallback = this.mBatchedCallback;
    }

    public void clear() {
        throwIfInMutationOperation();
        int i3 = this.mSize;
        if (i3 == 0) {
            return;
        }
        Arrays.fill(this.mData, 0, i3, (Object) null);
        this.mSize = 0;
        this.mCallback.onRemoved(0, i3);
    }

    public void endBatchedUpdates() {
        throwIfInMutationOperation();
        Callback callback = this.mCallback;
        if (callback instanceof BatchedCallback) {
            ((BatchedCallback) callback).dispatchLastEvent();
        }
        Callback callback2 = this.mCallback;
        BatchedCallback batchedCallback = this.mBatchedCallback;
        if (callback2 == batchedCallback) {
            this.mCallback = batchedCallback.mWrappedCallback;
        }
    }

    public T get(int i3) throws IndexOutOfBoundsException {
        int i16;
        if (i3 < this.mSize && i3 >= 0) {
            T[] tArr = this.mOldData;
            if (tArr != null && i3 >= (i16 = this.mNewDataStart)) {
                return tArr[(i3 - i16) + this.mOldDataStart];
            }
            return this.mData[i3];
        }
        throw new IndexOutOfBoundsException("Asked to get item at " + i3 + " but size is " + this.mSize);
    }

    public int indexOf(T t16) {
        if (this.mOldData != null) {
            int findIndexOf = findIndexOf(t16, this.mData, 0, this.mNewDataStart, 4);
            if (findIndexOf != -1) {
                return findIndexOf;
            }
            int findIndexOf2 = findIndexOf(t16, this.mOldData, this.mOldDataStart, this.mOldDataSize, 4);
            if (findIndexOf2 == -1) {
                return -1;
            }
            return (findIndexOf2 - this.mOldDataStart) + this.mNewDataStart;
        }
        return findIndexOf(t16, this.mData, 0, this.mSize, 4);
    }

    public void recalculatePositionOfItemAt(int i3) {
        throwIfInMutationOperation();
        T t16 = get(i3);
        removeItemAtIndex(i3, false);
        int add = add(t16, false);
        if (i3 != add) {
            this.mCallback.onMoved(i3, add);
        }
    }

    public boolean remove(T t16) {
        throwIfInMutationOperation();
        return remove(t16, true);
    }

    public T removeItemAt(int i3) {
        throwIfInMutationOperation();
        T t16 = get(i3);
        removeItemAtIndex(i3, true);
        return t16;
    }

    public void replaceAll(@NonNull T[] tArr, boolean z16) {
        throwIfInMutationOperation();
        if (z16) {
            replaceAllInternal(tArr);
        } else {
            replaceAllInternal(copyArray(tArr));
        }
    }

    public int size() {
        return this.mSize;
    }

    public void updateItemAt(int i3, T t16) {
        boolean z16;
        throwIfInMutationOperation();
        T t17 = get(i3);
        if (t17 != t16 && this.mCallback.areContentsTheSame(t17, t16)) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (t17 != t16 && this.mCallback.compare(t17, t16) == 0) {
            this.mData[i3] = t16;
            if (z16) {
                Callback callback = this.mCallback;
                callback.onChanged(i3, 1, callback.getChangePayload(t17, t16));
                return;
            }
            return;
        }
        if (z16) {
            Callback callback2 = this.mCallback;
            callback2.onChanged(i3, 1, callback2.getChangePayload(t17, t16));
        }
        removeItemAtIndex(i3, false);
        int add = add(t16, false);
        if (i3 != add) {
            this.mCallback.onMoved(i3, add);
        }
    }

    public SortedList(@NonNull Class<T> cls, @NonNull Callback<T> callback, int i3) {
        this.mTClass = cls;
        this.mData = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, i3));
        this.mCallback = callback;
        this.mSize = 0;
    }

    private int add(T t16, boolean z16) {
        int findIndexOf = findIndexOf(t16, this.mData, 0, this.mSize, 1);
        if (findIndexOf == -1) {
            findIndexOf = 0;
        } else if (findIndexOf < this.mSize) {
            T t17 = this.mData[findIndexOf];
            if (this.mCallback.areItemsTheSame(t17, t16)) {
                if (this.mCallback.areContentsTheSame(t17, t16)) {
                    this.mData[findIndexOf] = t16;
                    return findIndexOf;
                }
                this.mData[findIndexOf] = t16;
                Callback callback = this.mCallback;
                callback.onChanged(findIndexOf, 1, callback.getChangePayload(t17, t16));
                return findIndexOf;
            }
        }
        addToData(findIndexOf, t16);
        if (z16) {
            this.mCallback.onInserted(findIndexOf, 1);
        }
        return findIndexOf;
    }

    private boolean remove(T t16, boolean z16) {
        int findIndexOf = findIndexOf(t16, this.mData, 0, this.mSize, 2);
        if (findIndexOf == -1) {
            return false;
        }
        removeItemAtIndex(findIndexOf, z16);
        return true;
    }

    public void replaceAll(@NonNull T... tArr) {
        replaceAll(tArr, false);
    }

    public void addAll(@NonNull T... tArr) {
        addAll(tArr, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void replaceAll(@NonNull Collection<T> collection) {
        replaceAll(collection.toArray((Object[]) Array.newInstance((Class<?>) this.mTClass, collection.size())), true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void addAll(@NonNull Collection<T> collection) {
        addAll(collection.toArray((Object[]) Array.newInstance((Class<?>) this.mTClass, collection.size())), true);
    }
}
