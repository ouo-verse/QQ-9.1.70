package com.qqnt.widget.smartrefreshlayout.layout.constant;

/* compiled from: P */
/* loaded from: classes3.dex */
public enum RefreshState {
    None(0, false, false, false, false, false),
    PullDownToRefresh(1, true, false, false, false, false),
    PullUpToLoad(2, true, false, false, false, false),
    PullDownCanceled(1, false, false, false, false, false),
    PullUpCanceled(2, false, false, false, false, false),
    ReleaseToRefresh(1, true, false, false, false, true),
    ReleaseToLoad(2, true, false, false, false, true),
    ReleaseToTwoLevel(1, true, false, false, true, true),
    TwoLevelReleased(1, false, false, false, true, false),
    RefreshReleased(1, false, false, false, false, false),
    LoadReleased(2, false, false, false, false, false),
    Refreshing(1, false, true, false, false, false),
    Loading(2, false, true, false, false, false),
    TwoLevel(1, false, true, false, true, false),
    RefreshFinish(1, false, false, true, false, false),
    LoadFinish(2, false, false, true, false, false),
    TwoLevelFinish(1, false, false, true, true, false);

    public final boolean isDragging;
    public final boolean isFinishing;
    public final boolean isFooter;
    public final boolean isHeader;
    public final boolean isOpening;
    public final boolean isReleaseToOpening;
    public final boolean isTwoLevel;

    RefreshState(int i3, boolean z16, boolean z17, boolean z18, boolean z19, boolean z26) {
        boolean z27;
        if (i3 == 1) {
            z27 = true;
        } else {
            z27 = false;
        }
        this.isHeader = z27;
        this.isFooter = i3 == 2;
        this.isDragging = z16;
        this.isOpening = z17;
        this.isFinishing = z18;
        this.isTwoLevel = z19;
        this.isReleaseToOpening = z26;
    }

    public RefreshState toFooter() {
        if (this.isHeader && !this.isTwoLevel) {
            return values()[ordinal() + 1];
        }
        return this;
    }

    public RefreshState toHeader() {
        if (this.isFooter && !this.isTwoLevel) {
            return values()[ordinal() - 1];
        }
        return this;
    }
}
