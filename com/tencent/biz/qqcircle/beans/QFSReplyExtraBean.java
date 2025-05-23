package com.tencent.biz.qqcircle.beans;

import android.view.View;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSReplyExtraBean {
    private QFSCommentItemInfo mCircleCommentItemInfo;
    private QFSReplyItemInfo mQFSReplyItemInfo;
    private int mReplyPosition;
    private WeakReference<View> mViewWf;

    public QFSReplyExtraBean(QFSCommentItemInfo qFSCommentItemInfo, QFSReplyItemInfo qFSReplyItemInfo, int i3) {
        this.mCircleCommentItemInfo = qFSCommentItemInfo;
        this.mQFSReplyItemInfo = qFSReplyItemInfo;
        this.mReplyPosition = i3;
    }

    public QFSCommentItemInfo getCircleCommentItemInfo() {
        return this.mCircleCommentItemInfo;
    }

    public QFSReplyItemInfo getQCircleReplyItemInfo() {
        return this.mQFSReplyItemInfo;
    }

    public int getReplyPosition() {
        return this.mReplyPosition;
    }

    @Nullable
    public View getView() {
        WeakReference<View> weakReference = this.mViewWf;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public void setCircleCommentItemInfo(QFSCommentItemInfo qFSCommentItemInfo) {
        this.mCircleCommentItemInfo = qFSCommentItemInfo;
    }

    public void setQCircleReplyItemInfo(QFSReplyItemInfo qFSReplyItemInfo) {
        this.mQFSReplyItemInfo = qFSReplyItemInfo;
    }

    public void setReplyPosition(int i3) {
        this.mReplyPosition = i3;
    }

    public void setView(@Nullable View view) {
        this.mViewWf = new WeakReference<>(view);
    }

    public String toString() {
        return "QFSReplyExtraBean{mCircleCommentItemInfo=" + this.mCircleCommentItemInfo + ", mQFSReplyItemInfo=" + this.mQFSReplyItemInfo + ", mReplyPosition=" + this.mReplyPosition + ", mViewWf=" + this.mViewWf + '}';
    }
}
