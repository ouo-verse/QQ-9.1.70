package com.qzone.reborn.qzmoment.bean;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZMFolderInitBean extends QZMInitBean {
    private QZMFeedDetailInitBean mFeedDetailInitBean;
    private boolean mIsNeedToJumpFeedDetailPage;
    private boolean mIsNeedToJumpMessagePage;

    public QZMFeedDetailInitBean getFeedDetailInitBean() {
        return this.mFeedDetailInitBean;
    }

    public boolean isNeedToJumpFeedDetailPage() {
        return this.mIsNeedToJumpFeedDetailPage;
    }

    public boolean isNeedToJumpMessagePage() {
        return this.mIsNeedToJumpMessagePage;
    }

    public void setFeedDetailInitBean(QZMFeedDetailInitBean qZMFeedDetailInitBean) {
        this.mFeedDetailInitBean = qZMFeedDetailInitBean;
    }

    public void setIsNeedToJumpFeedDetailPage(boolean z16) {
        this.mIsNeedToJumpFeedDetailPage = z16;
    }

    public void setIsNeedToJumpMessagePage(boolean z16) {
        this.mIsNeedToJumpMessagePage = z16;
    }
}
