package androidx.recyclerview.widget;

import android.util.Log;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.annotation.WorkerThread;
import androidx.recyclerview.widget.ThreadUtil;
import androidx.recyclerview.widget.TileList;

/* compiled from: P */
/* loaded from: classes.dex */
public class AsyncListUtil<T> {
    static final boolean DEBUG = false;
    static final String TAG = "AsyncListUtil";
    boolean mAllowScrollHints;
    private final ThreadUtil.BackgroundCallback<T> mBackgroundCallback;
    final ThreadUtil.BackgroundCallback<T> mBackgroundProxy;
    final DataCallback<T> mDataCallback;
    private final ThreadUtil.MainThreadCallback<T> mMainThreadCallback;
    final ThreadUtil.MainThreadCallback<T> mMainThreadProxy;
    final Class<T> mTClass;
    final TileList<T> mTileList;
    final int mTileSize;
    final ViewCallback mViewCallback;
    final int[] mTmpRange = new int[2];
    final int[] mPrevRange = new int[2];
    final int[] mTmpRangeExtended = new int[2];
    private int mScrollHint = 0;
    int mItemCount = 0;
    int mDisplayedGeneration = 0;
    int mRequestedGeneration = 0;
    final SparseIntArray mMissingPositions = new SparseIntArray();

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static abstract class ViewCallback {
        public static final int HINT_SCROLL_ASC = 2;
        public static final int HINT_SCROLL_DESC = 1;
        public static final int HINT_SCROLL_NONE = 0;

        @UiThread
        public void extendRangeInto(@NonNull int[] iArr, @NonNull int[] iArr2, int i3) {
            int i16;
            int i17 = iArr[1];
            int i18 = iArr[0];
            int i19 = (i17 - i18) + 1;
            int i26 = i19 / 2;
            if (i3 == 1) {
                i16 = i19;
            } else {
                i16 = i26;
            }
            iArr2[0] = i18 - i16;
            if (i3 != 2) {
                i19 = i26;
            }
            iArr2[1] = i17 + i19;
        }

        @UiThread
        public abstract void getItemRangeInto(@NonNull int[] iArr);

        @UiThread
        public abstract void onDataRefresh();

        @UiThread
        public abstract void onItemLoaded(int i3);
    }

    public AsyncListUtil(@NonNull Class<T> cls, int i3, @NonNull DataCallback<T> dataCallback, @NonNull ViewCallback viewCallback) {
        ThreadUtil.MainThreadCallback<T> mainThreadCallback = new ThreadUtil.MainThreadCallback<T>() { // from class: androidx.recyclerview.widget.AsyncListUtil.1
            private boolean isRequestedGeneration(int i16) {
                if (i16 == AsyncListUtil.this.mRequestedGeneration) {
                    return true;
                }
                return false;
            }

            private void recycleAllTiles() {
                for (int i16 = 0; i16 < AsyncListUtil.this.mTileList.size(); i16++) {
                    AsyncListUtil asyncListUtil = AsyncListUtil.this;
                    asyncListUtil.mBackgroundProxy.recycleTile(asyncListUtil.mTileList.getAtIndex(i16));
                }
                AsyncListUtil.this.mTileList.clear();
            }

            @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
            public void addTile(int i16, TileList.Tile<T> tile) {
                if (!isRequestedGeneration(i16)) {
                    AsyncListUtil.this.mBackgroundProxy.recycleTile(tile);
                    return;
                }
                TileList.Tile<T> addOrReplace = AsyncListUtil.this.mTileList.addOrReplace(tile);
                if (addOrReplace != null) {
                    Log.e(AsyncListUtil.TAG, "duplicate tile @" + addOrReplace.mStartPosition);
                    AsyncListUtil.this.mBackgroundProxy.recycleTile(addOrReplace);
                }
                int i17 = tile.mStartPosition + tile.mItemCount;
                int i18 = 0;
                while (i18 < AsyncListUtil.this.mMissingPositions.size()) {
                    int keyAt = AsyncListUtil.this.mMissingPositions.keyAt(i18);
                    if (tile.mStartPosition <= keyAt && keyAt < i17) {
                        AsyncListUtil.this.mMissingPositions.removeAt(i18);
                        AsyncListUtil.this.mViewCallback.onItemLoaded(keyAt);
                    } else {
                        i18++;
                    }
                }
            }

            @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
            public void removeTile(int i16, int i17) {
                if (!isRequestedGeneration(i16)) {
                    return;
                }
                TileList.Tile<T> removeAtPos = AsyncListUtil.this.mTileList.removeAtPos(i17);
                if (removeAtPos == null) {
                    Log.e(AsyncListUtil.TAG, "tile not found @" + i17);
                    return;
                }
                AsyncListUtil.this.mBackgroundProxy.recycleTile(removeAtPos);
            }

            @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
            public void updateItemCount(int i16, int i17) {
                if (!isRequestedGeneration(i16)) {
                    return;
                }
                AsyncListUtil asyncListUtil = AsyncListUtil.this;
                asyncListUtil.mItemCount = i17;
                asyncListUtil.mViewCallback.onDataRefresh();
                AsyncListUtil asyncListUtil2 = AsyncListUtil.this;
                asyncListUtil2.mDisplayedGeneration = asyncListUtil2.mRequestedGeneration;
                recycleAllTiles();
                AsyncListUtil asyncListUtil3 = AsyncListUtil.this;
                asyncListUtil3.mAllowScrollHints = false;
                asyncListUtil3.updateRange();
            }
        };
        this.mMainThreadCallback = mainThreadCallback;
        ThreadUtil.BackgroundCallback<T> backgroundCallback = new ThreadUtil.BackgroundCallback<T>() { // from class: androidx.recyclerview.widget.AsyncListUtil.2
            private int mFirstRequiredTileStart;
            private int mGeneration;
            private int mItemCount;
            private int mLastRequiredTileStart;
            final SparseBooleanArray mLoadedTiles = new SparseBooleanArray();
            private TileList.Tile<T> mRecycledRoot;

            private TileList.Tile<T> acquireTile() {
                TileList.Tile<T> tile = this.mRecycledRoot;
                if (tile != null) {
                    this.mRecycledRoot = tile.mNext;
                    return tile;
                }
                AsyncListUtil asyncListUtil = AsyncListUtil.this;
                return new TileList.Tile<>(asyncListUtil.mTClass, asyncListUtil.mTileSize);
            }

            private void addTile(TileList.Tile<T> tile) {
                this.mLoadedTiles.put(tile.mStartPosition, true);
                AsyncListUtil.this.mMainThreadProxy.addTile(this.mGeneration, tile);
            }

            private void flushTileCache(int i16) {
                int maxCachedTiles = AsyncListUtil.this.mDataCallback.getMaxCachedTiles();
                while (this.mLoadedTiles.size() >= maxCachedTiles) {
                    int keyAt = this.mLoadedTiles.keyAt(0);
                    SparseBooleanArray sparseBooleanArray = this.mLoadedTiles;
                    int keyAt2 = sparseBooleanArray.keyAt(sparseBooleanArray.size() - 1);
                    int i17 = this.mFirstRequiredTileStart - keyAt;
                    int i18 = keyAt2 - this.mLastRequiredTileStart;
                    if (i17 > 0 && (i17 >= i18 || i16 == 2)) {
                        removeTile(keyAt);
                    } else if (i18 > 0) {
                        if (i17 < i18 || i16 == 1) {
                            removeTile(keyAt2);
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }

            private int getTileStart(int i16) {
                return i16 - (i16 % AsyncListUtil.this.mTileSize);
            }

            private boolean isTileLoaded(int i16) {
                return this.mLoadedTiles.get(i16);
            }

            private void log(String str, Object... objArr) {
                Log.d(AsyncListUtil.TAG, "[BKGR] " + String.format(str, objArr));
            }

            private void removeTile(int i16) {
                this.mLoadedTiles.delete(i16);
                AsyncListUtil.this.mMainThreadProxy.removeTile(this.mGeneration, i16);
            }

            private void requestTiles(int i16, int i17, int i18, boolean z16) {
                int i19;
                int i26 = i16;
                while (i26 <= i17) {
                    if (z16) {
                        i19 = (i17 + i16) - i26;
                    } else {
                        i19 = i26;
                    }
                    AsyncListUtil.this.mBackgroundProxy.loadTile(i19, i18);
                    i26 += AsyncListUtil.this.mTileSize;
                }
            }

            @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
            public void loadTile(int i16, int i17) {
                if (isTileLoaded(i16)) {
                    return;
                }
                TileList.Tile<T> acquireTile = acquireTile();
                acquireTile.mStartPosition = i16;
                int min = Math.min(AsyncListUtil.this.mTileSize, this.mItemCount - i16);
                acquireTile.mItemCount = min;
                AsyncListUtil.this.mDataCallback.fillData(acquireTile.mItems, acquireTile.mStartPosition, min);
                flushTileCache(i17);
                addTile(acquireTile);
            }

            @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
            public void recycleTile(TileList.Tile<T> tile) {
                AsyncListUtil.this.mDataCallback.recycleData(tile.mItems, tile.mItemCount);
                tile.mNext = this.mRecycledRoot;
                this.mRecycledRoot = tile;
            }

            @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
            public void refresh(int i16) {
                this.mGeneration = i16;
                this.mLoadedTiles.clear();
                int refreshData = AsyncListUtil.this.mDataCallback.refreshData();
                this.mItemCount = refreshData;
                AsyncListUtil.this.mMainThreadProxy.updateItemCount(this.mGeneration, refreshData);
            }

            @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
            public void updateRange(int i16, int i17, int i18, int i19, int i26) {
                if (i16 > i17) {
                    return;
                }
                int tileStart = getTileStart(i16);
                int tileStart2 = getTileStart(i17);
                this.mFirstRequiredTileStart = getTileStart(i18);
                int tileStart3 = getTileStart(i19);
                this.mLastRequiredTileStart = tileStart3;
                if (i26 == 1) {
                    requestTiles(this.mFirstRequiredTileStart, tileStart2, i26, true);
                    requestTiles(tileStart2 + AsyncListUtil.this.mTileSize, this.mLastRequiredTileStart, i26, false);
                } else {
                    requestTiles(tileStart, tileStart3, i26, false);
                    requestTiles(this.mFirstRequiredTileStart, tileStart - AsyncListUtil.this.mTileSize, i26, true);
                }
            }
        };
        this.mBackgroundCallback = backgroundCallback;
        this.mTClass = cls;
        this.mTileSize = i3;
        this.mDataCallback = dataCallback;
        this.mViewCallback = viewCallback;
        this.mTileList = new TileList<>(i3);
        MessageThreadUtil messageThreadUtil = new MessageThreadUtil();
        this.mMainThreadProxy = messageThreadUtil.getMainThreadProxy(mainThreadCallback);
        this.mBackgroundProxy = messageThreadUtil.getBackgroundProxy(backgroundCallback);
        refresh();
    }

    private boolean isRefreshPending() {
        if (this.mRequestedGeneration != this.mDisplayedGeneration) {
            return true;
        }
        return false;
    }

    @Nullable
    public T getItem(int i3) {
        if (i3 >= 0 && i3 < this.mItemCount) {
            T itemAt = this.mTileList.getItemAt(i3);
            if (itemAt == null && !isRefreshPending()) {
                this.mMissingPositions.put(i3, 0);
            }
            return itemAt;
        }
        throw new IndexOutOfBoundsException(i3 + " is not within 0 and " + this.mItemCount);
    }

    public int getItemCount() {
        return this.mItemCount;
    }

    void log(String str, Object... objArr) {
        Log.d(TAG, "[MAIN] " + String.format(str, objArr));
    }

    public void onRangeChanged() {
        if (isRefreshPending()) {
            return;
        }
        updateRange();
        this.mAllowScrollHints = true;
    }

    public void refresh() {
        this.mMissingPositions.clear();
        ThreadUtil.BackgroundCallback<T> backgroundCallback = this.mBackgroundProxy;
        int i3 = this.mRequestedGeneration + 1;
        this.mRequestedGeneration = i3;
        backgroundCallback.refresh(i3);
    }

    void updateRange() {
        int i3;
        this.mViewCallback.getItemRangeInto(this.mTmpRange);
        int[] iArr = this.mTmpRange;
        int i16 = iArr[0];
        int i17 = iArr[1];
        if (i16 > i17 || i16 < 0 || i17 >= this.mItemCount) {
            return;
        }
        if (!this.mAllowScrollHints) {
            this.mScrollHint = 0;
        } else {
            int[] iArr2 = this.mPrevRange;
            if (i16 <= iArr2[1] && (i3 = iArr2[0]) <= i17) {
                if (i16 < i3) {
                    this.mScrollHint = 1;
                } else if (i16 > i3) {
                    this.mScrollHint = 2;
                }
            } else {
                this.mScrollHint = 0;
            }
        }
        int[] iArr3 = this.mPrevRange;
        iArr3[0] = i16;
        iArr3[1] = i17;
        this.mViewCallback.extendRangeInto(iArr, this.mTmpRangeExtended, this.mScrollHint);
        int[] iArr4 = this.mTmpRangeExtended;
        iArr4[0] = Math.min(this.mTmpRange[0], Math.max(iArr4[0], 0));
        int[] iArr5 = this.mTmpRangeExtended;
        iArr5[1] = Math.max(this.mTmpRange[1], Math.min(iArr5[1], this.mItemCount - 1));
        ThreadUtil.BackgroundCallback<T> backgroundCallback = this.mBackgroundProxy;
        int[] iArr6 = this.mTmpRange;
        int i18 = iArr6[0];
        int i19 = iArr6[1];
        int[] iArr7 = this.mTmpRangeExtended;
        backgroundCallback.updateRange(i18, i19, iArr7[0], iArr7[1], this.mScrollHint);
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static abstract class DataCallback<T> {
        @WorkerThread
        public abstract void fillData(@NonNull T[] tArr, int i3, int i16);

        @WorkerThread
        public int getMaxCachedTiles() {
            return 10;
        }

        @WorkerThread
        public abstract int refreshData();

        @WorkerThread
        public void recycleData(@NonNull T[] tArr, int i3) {
        }
    }
}
