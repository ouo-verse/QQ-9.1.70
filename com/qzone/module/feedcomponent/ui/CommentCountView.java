package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.qzone.proxy.feedcomponent.model.CellCommentInfo;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CommentCountView extends FeedCountView {
    public CommentCountView(Context context) {
        super(context);
    }

    public void setRemarkStr(String str, CellCommentInfo cellCommentInfo) {
        SubAreaShell subAreaShell = this.countShell;
        if (subAreaShell != null) {
            SubAreaShell.recycle(subAreaShell);
            this.countShell = null;
        }
        this.hasRemark = true;
        SubAreaShell obtain = SubAreaShell.obtain(AreaManager.getInstance().getCommentCountInfoArea(getDisplayStr(cellCommentInfo), null, true));
        this.countShell = obtain;
        obtain.setOnClickListener(this.onClickListener);
        this.countShell.setParent(this);
    }

    public CommentCountView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CommentCountView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }

    protected String getDisplayStr(CellCommentInfo cellCommentInfo) {
        if (cellCommentInfo == null || cellCommentInfo.realCount <= 0) {
            return null;
        }
        return com.qzone.adapter.feedcomponent.i.H().T("QZoneSetting", "Feed_Comment_Count_Desc", "\u8bc4\u8bba%s");
    }

    public boolean setCommentCountInfo(CellCommentInfo cellCommentInfo) {
        if (cellCommentInfo == null || cellCommentInfo.realCount <= 0) {
            return false;
        }
        SubAreaShell obtain = SubAreaShell.obtain(AreaManager.getInstance().getCommentCountInfoArea(getDisplayStr(cellCommentInfo), cellCommentInfo.feedkey + "comment_count_" + cellCommentInfo.realCount));
        this.countShell = obtain;
        obtain.setOnClickListener(this.onClickListener);
        this.countShell.setParent(this);
        return true;
    }
}
