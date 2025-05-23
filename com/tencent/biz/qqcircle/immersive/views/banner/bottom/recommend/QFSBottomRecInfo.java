package com.tencent.biz.qqcircle.immersive.views.banner.bottom.recommend;

import android.text.TextUtils;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSBottomRecInfo implements Serializable {
    private String mFeedIdList;
    private boolean mHasOperation;
    private boolean mIsRecOpen;
    private int mScrollX;
    private int mSelectedPos;

    public String getFeedIdList() {
        if (TextUtils.isEmpty(this.mFeedIdList)) {
            return "";
        }
        return this.mFeedIdList;
    }

    public int getScrollX() {
        return this.mScrollX;
    }

    public int getSelectedPos() {
        return this.mSelectedPos;
    }

    public boolean hasOperation() {
        return this.mHasOperation;
    }

    public boolean isRecOpen() {
        return this.mIsRecOpen;
    }

    public QFSBottomRecInfo setFeedIdList(String str) {
        this.mFeedIdList = str;
        return this;
    }

    public void setHasOperation(boolean z16) {
        this.mHasOperation = z16;
    }

    public QFSBottomRecInfo setRecOpen(boolean z16) {
        this.mIsRecOpen = z16;
        return this;
    }

    public QFSBottomRecInfo setScrollX(int i3) {
        this.mScrollX = i3;
        return this;
    }

    public QFSBottomRecInfo setSelectedPos(int i3) {
        this.mSelectedPos = i3;
        return this;
    }
}
