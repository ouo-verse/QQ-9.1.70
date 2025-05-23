package androidx.appcompat.widget;

/* compiled from: P */
/* loaded from: classes.dex */
class RtlSpacingHelper {
    public static final int UNDEFINED = Integer.MIN_VALUE;
    private int mLeft = 0;
    private int mRight = 0;
    private int mStart = Integer.MIN_VALUE;
    private int mEnd = Integer.MIN_VALUE;
    private int mExplicitLeft = 0;
    private int mExplicitRight = 0;
    private boolean mIsRtl = false;
    private boolean mIsRelative = false;

    public int getEnd() {
        if (this.mIsRtl) {
            return this.mLeft;
        }
        return this.mRight;
    }

    public int getLeft() {
        return this.mLeft;
    }

    public int getRight() {
        return this.mRight;
    }

    public int getStart() {
        if (this.mIsRtl) {
            return this.mRight;
        }
        return this.mLeft;
    }

    public void setAbsolute(int i3, int i16) {
        this.mIsRelative = false;
        if (i3 != Integer.MIN_VALUE) {
            this.mExplicitLeft = i3;
            this.mLeft = i3;
        }
        if (i16 != Integer.MIN_VALUE) {
            this.mExplicitRight = i16;
            this.mRight = i16;
        }
    }

    public void setDirection(boolean z16) {
        if (z16 == this.mIsRtl) {
            return;
        }
        this.mIsRtl = z16;
        if (this.mIsRelative) {
            if (z16) {
                int i3 = this.mEnd;
                if (i3 == Integer.MIN_VALUE) {
                    i3 = this.mExplicitLeft;
                }
                this.mLeft = i3;
                int i16 = this.mStart;
                if (i16 == Integer.MIN_VALUE) {
                    i16 = this.mExplicitRight;
                }
                this.mRight = i16;
                return;
            }
            int i17 = this.mStart;
            if (i17 == Integer.MIN_VALUE) {
                i17 = this.mExplicitLeft;
            }
            this.mLeft = i17;
            int i18 = this.mEnd;
            if (i18 == Integer.MIN_VALUE) {
                i18 = this.mExplicitRight;
            }
            this.mRight = i18;
            return;
        }
        this.mLeft = this.mExplicitLeft;
        this.mRight = this.mExplicitRight;
    }

    public void setRelative(int i3, int i16) {
        this.mStart = i3;
        this.mEnd = i16;
        this.mIsRelative = true;
        if (this.mIsRtl) {
            if (i16 != Integer.MIN_VALUE) {
                this.mLeft = i16;
            }
            if (i3 != Integer.MIN_VALUE) {
                this.mRight = i3;
                return;
            }
            return;
        }
        if (i3 != Integer.MIN_VALUE) {
            this.mLeft = i3;
        }
        if (i16 != Integer.MIN_VALUE) {
            this.mRight = i16;
        }
    }
}
