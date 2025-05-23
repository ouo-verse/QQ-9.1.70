package androidx.recyclerview.widget;

import android.view.View;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes.dex */
class ViewBoundsCheck {
    static final int CVE_PVE_POS = 12;
    static final int CVE_PVS_POS = 8;
    static final int CVS_PVE_POS = 4;
    static final int CVS_PVS_POS = 0;
    static final int EQ = 2;
    static final int FLAG_CVE_EQ_PVE = 8192;
    static final int FLAG_CVE_EQ_PVS = 512;
    static final int FLAG_CVE_GT_PVE = 4096;
    static final int FLAG_CVE_GT_PVS = 256;
    static final int FLAG_CVE_LT_PVE = 16384;
    static final int FLAG_CVE_LT_PVS = 1024;
    static final int FLAG_CVS_EQ_PVE = 32;
    static final int FLAG_CVS_EQ_PVS = 2;
    static final int FLAG_CVS_GT_PVE = 16;
    static final int FLAG_CVS_GT_PVS = 1;
    static final int FLAG_CVS_LT_PVE = 64;
    static final int FLAG_CVS_LT_PVS = 4;
    static final int GT = 1;
    static final int LT = 4;
    static final int MASK = 7;
    BoundFlags mBoundFlags = new BoundFlags();
    final Callback mCallback;

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class BoundFlags {
        int mBoundFlags = 0;
        int mChildEnd;
        int mChildStart;
        int mRvEnd;
        int mRvStart;

        BoundFlags() {
        }

        void addFlags(int i3) {
            this.mBoundFlags = i3 | this.mBoundFlags;
        }

        boolean boundsMatch() {
            int i3 = this.mBoundFlags;
            if ((i3 & 7) != 0 && (i3 & (compare(this.mChildStart, this.mRvStart) << 0)) == 0) {
                return false;
            }
            int i16 = this.mBoundFlags;
            if ((i16 & 112) != 0 && (i16 & (compare(this.mChildStart, this.mRvEnd) << 4)) == 0) {
                return false;
            }
            int i17 = this.mBoundFlags;
            if ((i17 & 1792) != 0 && (i17 & (compare(this.mChildEnd, this.mRvStart) << 8)) == 0) {
                return false;
            }
            int i18 = this.mBoundFlags;
            if ((i18 & 28672) != 0 && (i18 & (compare(this.mChildEnd, this.mRvEnd) << 12)) == 0) {
                return false;
            }
            return true;
        }

        int compare(int i3, int i16) {
            if (i3 > i16) {
                return 1;
            }
            if (i3 == i16) {
                return 2;
            }
            return 4;
        }

        void resetFlags() {
            this.mBoundFlags = 0;
        }

        void setBounds(int i3, int i16, int i17, int i18) {
            this.mRvStart = i3;
            this.mRvEnd = i16;
            this.mChildStart = i17;
            this.mChildEnd = i18;
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    interface Callback {
        View getChildAt(int i3);

        int getChildEnd(View view);

        int getChildStart(View view);

        int getParentEnd();

        int getParentStart();
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface ViewBounds {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewBoundsCheck(Callback callback) {
        this.mCallback = callback;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View findOneViewWithinBoundFlags(int i3, int i16, int i17, int i18) {
        int i19;
        int parentStart = this.mCallback.getParentStart();
        int parentEnd = this.mCallback.getParentEnd();
        if (i16 > i3) {
            i19 = 1;
        } else {
            i19 = -1;
        }
        View view = null;
        while (i3 != i16) {
            View childAt = this.mCallback.getChildAt(i3);
            this.mBoundFlags.setBounds(parentStart, parentEnd, this.mCallback.getChildStart(childAt), this.mCallback.getChildEnd(childAt));
            if (i17 != 0) {
                this.mBoundFlags.resetFlags();
                this.mBoundFlags.addFlags(i17);
                if (this.mBoundFlags.boundsMatch()) {
                    return childAt;
                }
            }
            if (i18 != 0) {
                this.mBoundFlags.resetFlags();
                this.mBoundFlags.addFlags(i18);
                if (this.mBoundFlags.boundsMatch()) {
                    view = childAt;
                }
            }
            i3 += i19;
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isViewWithinBoundFlags(View view, int i3) {
        this.mBoundFlags.setBounds(this.mCallback.getParentStart(), this.mCallback.getParentEnd(), this.mCallback.getChildStart(view), this.mCallback.getChildEnd(view));
        if (i3 != 0) {
            this.mBoundFlags.resetFlags();
            this.mBoundFlags.addFlags(i3);
            return this.mBoundFlags.boundsMatch();
        }
        return false;
    }
}
