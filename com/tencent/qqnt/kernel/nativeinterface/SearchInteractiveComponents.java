package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SearchInteractiveComponents {
    public SearchIcon likeIcon = new SearchIcon();
    public SearchIcon commentIcon = new SearchIcon();
    public SearchIcon shareIcon = new SearchIcon();
    public SearchReportInfo reportInfo = new SearchReportInfo();
    public SearchJump jumpLink = new SearchJump();

    public SearchIcon getCommentIcon() {
        return this.commentIcon;
    }

    public SearchJump getJumpLink() {
        return this.jumpLink;
    }

    public SearchIcon getLikeIcon() {
        return this.likeIcon;
    }

    public SearchReportInfo getReportInfo() {
        return this.reportInfo;
    }

    public SearchIcon getShareIcon() {
        return this.shareIcon;
    }

    public String toString() {
        return "SearchInteractiveComponents{likeIcon=" + this.likeIcon + ",commentIcon=" + this.commentIcon + ",shareIcon=" + this.shareIcon + ",reportInfo=" + this.reportInfo + ",jumpLink=" + this.jumpLink + ",}";
    }
}
