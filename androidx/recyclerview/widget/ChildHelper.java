package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes.dex */
public class ChildHelper {
    private static final boolean DEBUG = false;
    private static final String TAG = "ChildrenHelper";
    final Callback mCallback;
    final Bucket mBucket = new Bucket();
    final List<View> mHiddenViews = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class Bucket {
        static final int BITS_PER_WORD = 64;
        static final long LAST_BIT = Long.MIN_VALUE;
        long mData = 0;
        Bucket mNext;

        Bucket() {
        }

        private void ensureNext() {
            if (this.mNext == null) {
                this.mNext = new Bucket();
            }
        }

        void clear(int i3) {
            if (i3 >= 64) {
                Bucket bucket = this.mNext;
                if (bucket != null) {
                    bucket.clear(i3 - 64);
                    return;
                }
                return;
            }
            this.mData &= ~(1 << i3);
        }

        int countOnesBefore(int i3) {
            Bucket bucket = this.mNext;
            if (bucket == null) {
                if (i3 >= 64) {
                    return Long.bitCount(this.mData);
                }
                return Long.bitCount(this.mData & ((1 << i3) - 1));
            }
            if (i3 < 64) {
                return Long.bitCount(this.mData & ((1 << i3) - 1));
            }
            return bucket.countOnesBefore(i3 - 64) + Long.bitCount(this.mData);
        }

        boolean get(int i3) {
            if (i3 >= 64) {
                ensureNext();
                return this.mNext.get(i3 - 64);
            }
            if ((this.mData & (1 << i3)) != 0) {
                return true;
            }
            return false;
        }

        void insert(int i3, boolean z16) {
            boolean z17;
            if (i3 >= 64) {
                ensureNext();
                this.mNext.insert(i3 - 64, z16);
                return;
            }
            long j3 = this.mData;
            if ((Long.MIN_VALUE & j3) != 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            long j16 = (1 << i3) - 1;
            this.mData = ((j3 & (~j16)) << 1) | (j3 & j16);
            if (z16) {
                set(i3);
            } else {
                clear(i3);
            }
            if (z17 || this.mNext != null) {
                ensureNext();
                this.mNext.insert(0, z17);
            }
        }

        boolean remove(int i3) {
            boolean z16;
            if (i3 >= 64) {
                ensureNext();
                return this.mNext.remove(i3 - 64);
            }
            long j3 = 1 << i3;
            long j16 = this.mData;
            if ((j16 & j3) != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            long j17 = j16 & (~j3);
            this.mData = j17;
            long j18 = j3 - 1;
            this.mData = (j17 & j18) | Long.rotateRight((~j18) & j17, 1);
            Bucket bucket = this.mNext;
            if (bucket != null) {
                if (bucket.get(0)) {
                    set(63);
                }
                this.mNext.remove(0);
            }
            return z16;
        }

        void reset() {
            this.mData = 0L;
            Bucket bucket = this.mNext;
            if (bucket != null) {
                bucket.reset();
            }
        }

        void set(int i3) {
            if (i3 >= 64) {
                ensureNext();
                this.mNext.set(i3 - 64);
            } else {
                this.mData |= 1 << i3;
            }
        }

        public String toString() {
            if (this.mNext == null) {
                return Long.toBinaryString(this.mData);
            }
            return this.mNext.toString() + "xx" + Long.toBinaryString(this.mData);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface Callback {
        void addView(View view, int i3);

        void attachViewToParent(View view, int i3, ViewGroup.LayoutParams layoutParams);

        void detachViewFromParent(int i3);

        View getChildAt(int i3);

        int getChildCount();

        RecyclerView.ViewHolder getChildViewHolder(View view);

        int indexOfChild(View view);

        void onEnteredHiddenState(View view);

        void onLeftHiddenState(View view);

        void removeAllViews();

        void removeViewAt(int i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChildHelper(Callback callback) {
        this.mCallback = callback;
    }

    private int getOffset(int i3) {
        if (i3 < 0) {
            return -1;
        }
        int childCount = this.mCallback.getChildCount();
        int i16 = i3;
        while (i16 < childCount) {
            int countOnesBefore = i3 - (i16 - this.mBucket.countOnesBefore(i16));
            if (countOnesBefore == 0) {
                while (this.mBucket.get(i16)) {
                    i16++;
                }
                return i16;
            }
            i16 += countOnesBefore;
        }
        return -1;
    }

    private void hideViewInternal(View view) {
        this.mHiddenViews.add(view);
        this.mCallback.onEnteredHiddenState(view);
    }

    private boolean unhideViewInternal(View view) {
        if (this.mHiddenViews.remove(view)) {
            this.mCallback.onLeftHiddenState(view);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addView(View view, boolean z16) {
        addView(view, -1, z16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void attachViewToParent(View view, int i3, ViewGroup.LayoutParams layoutParams, boolean z16) {
        int offset;
        if (i3 < 0) {
            offset = this.mCallback.getChildCount();
        } else {
            offset = getOffset(i3);
        }
        this.mBucket.insert(offset, z16);
        if (z16) {
            hideViewInternal(view);
        }
        this.mCallback.attachViewToParent(view, offset, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void detachViewFromParent(int i3) {
        int offset = getOffset(i3);
        this.mBucket.remove(offset);
        this.mCallback.detachViewFromParent(offset);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View findHiddenNonRemovedView(int i3) {
        int size = this.mHiddenViews.size();
        for (int i16 = 0; i16 < size; i16++) {
            View view = this.mHiddenViews.get(i16);
            RecyclerView.ViewHolder childViewHolder = this.mCallback.getChildViewHolder(view);
            if (childViewHolder.getLayoutPosition() == i3 && !childViewHolder.isInvalid() && !childViewHolder.isRemoved()) {
                return view;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View getChildAt(int i3) {
        return this.mCallback.getChildAt(getOffset(i3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getChildCount() {
        return this.mCallback.getChildCount() - this.mHiddenViews.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View getUnfilteredChildAt(int i3) {
        return this.mCallback.getChildAt(i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getUnfilteredChildCount() {
        return this.mCallback.getChildCount();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void hide(View view) {
        int indexOfChild = this.mCallback.indexOfChild(view);
        if (indexOfChild >= 0) {
            this.mBucket.set(indexOfChild);
            hideViewInternal(view);
        } else {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int indexOfChild(View view) {
        int indexOfChild = this.mCallback.indexOfChild(view);
        if (indexOfChild == -1 || this.mBucket.get(indexOfChild)) {
            return -1;
        }
        return indexOfChild - this.mBucket.countOnesBefore(indexOfChild);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isHidden(View view) {
        return this.mHiddenViews.contains(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeAllViewsUnfiltered() {
        this.mBucket.reset();
        for (int size = this.mHiddenViews.size() - 1; size >= 0; size--) {
            this.mCallback.onLeftHiddenState(this.mHiddenViews.get(size));
            this.mHiddenViews.remove(size);
        }
        this.mCallback.removeAllViews();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeView(View view) {
        int indexOfChild = this.mCallback.indexOfChild(view);
        if (indexOfChild < 0) {
            return;
        }
        if (this.mBucket.remove(indexOfChild)) {
            unhideViewInternal(view);
        }
        this.mCallback.removeViewAt(indexOfChild);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeViewAt(int i3) {
        int offset = getOffset(i3);
        View childAt = this.mCallback.getChildAt(offset);
        if (childAt == null) {
            return;
        }
        if (this.mBucket.remove(offset)) {
            unhideViewInternal(childAt);
        }
        this.mCallback.removeViewAt(offset);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean removeViewIfHidden(View view) {
        int indexOfChild = this.mCallback.indexOfChild(view);
        if (indexOfChild == -1) {
            unhideViewInternal(view);
            return true;
        }
        if (this.mBucket.get(indexOfChild)) {
            this.mBucket.remove(indexOfChild);
            unhideViewInternal(view);
            this.mCallback.removeViewAt(indexOfChild);
            return true;
        }
        return false;
    }

    public String toString() {
        return this.mBucket.toString() + ", hidden list:" + this.mHiddenViews.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void unhide(View view) {
        int indexOfChild = this.mCallback.indexOfChild(view);
        if (indexOfChild >= 0) {
            if (this.mBucket.get(indexOfChild)) {
                this.mBucket.clear(indexOfChild);
                unhideViewInternal(view);
                return;
            } else {
                throw new RuntimeException("trying to unhide a view that was not hidden" + view);
            }
        }
        throw new IllegalArgumentException("view is not a child, cannot hide " + view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addView(View view, int i3, boolean z16) {
        int offset;
        if (i3 < 0) {
            offset = this.mCallback.getChildCount();
        } else {
            offset = getOffset(i3);
        }
        this.mBucket.insert(offset, z16);
        if (z16) {
            hideViewInternal(view);
        }
        this.mCallback.addView(view, offset);
    }
}
