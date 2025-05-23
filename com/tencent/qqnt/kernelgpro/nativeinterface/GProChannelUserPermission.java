package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProChannelUserPermission implements Serializable {
    public boolean allowComment;
    public boolean allowDeleteFeed;
    public boolean allowEditFeed;
    public boolean allowMoveFeed;
    public boolean allowReadFeed;
    public boolean allowSetFeedGlobalBanner;
    public boolean allowTopFeed;
    public boolean allowWriteFeed;
    public int notAllowCommentCode;
    long serialVersionUID = 1;

    public boolean getAllowComment() {
        return this.allowComment;
    }

    public boolean getAllowDeleteFeed() {
        return this.allowDeleteFeed;
    }

    public boolean getAllowEditFeed() {
        return this.allowEditFeed;
    }

    public boolean getAllowMoveFeed() {
        return this.allowMoveFeed;
    }

    public boolean getAllowReadFeed() {
        return this.allowReadFeed;
    }

    public boolean getAllowSetFeedGlobalBanner() {
        return this.allowSetFeedGlobalBanner;
    }

    public boolean getAllowTopFeed() {
        return this.allowTopFeed;
    }

    public boolean getAllowWriteFeed() {
        return this.allowWriteFeed;
    }

    public int getNotAllowCommentCode() {
        return this.notAllowCommentCode;
    }

    public String toString() {
        return "GProChannelUserPermission{allowReadFeed=" + this.allowReadFeed + ",allowWriteFeed=" + this.allowWriteFeed + ",allowTopFeed=" + this.allowTopFeed + ",allowSetFeedGlobalBanner=" + this.allowSetFeedGlobalBanner + ",allowDeleteFeed=" + this.allowDeleteFeed + ",allowMoveFeed=" + this.allowMoveFeed + ",allowEditFeed=" + this.allowEditFeed + ",allowComment=" + this.allowComment + ",notAllowCommentCode=" + this.notAllowCommentCode + ",}";
    }
}
