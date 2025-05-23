package com.qzone.proxy.feedcomponent.model;

import android.text.TextUtils;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.qzone.proxy.feedcomponent.text.TextCellParser;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;

/* compiled from: P */
/* loaded from: classes39.dex */
public class ClickedComment implements CellTextView.OnTextOperater, SmartParcelable {

    @NeedParcel
    public ClickedPoint clickedPoint;

    @NeedParcel
    public int cmtIndex;

    @NeedParcel
    Comment comment;

    @NeedParcel
    public boolean isComment;

    @NeedParcel
    public boolean isDoubleClickComment;

    @NeedParcel
    int position;

    @NeedParcel
    Reply reply;

    @NeedParcel
    public int replyIndex;

    public ClickedPoint getClickedPoint() {
        return this.clickedPoint;
    }

    public Comment getComment() {
        return this.comment;
    }

    public int getPosition() {
        return this.position;
    }

    public Reply getReply() {
        return this.reply;
    }

    public String getText() {
        String str;
        Reply reply = this.reply;
        String str2 = "";
        if (reply == null) {
            str = "";
        } else {
            str = reply.content;
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        Comment comment = this.comment;
        if (comment != null) {
            str2 = comment.comment;
        }
        return str2;
    }

    @Override // com.qzone.proxy.feedcomponent.text.CellTextView.OnTextOperater
    public void onCopy() {
        if (TextUtils.isEmpty(getText())) {
            return;
        }
        com.qzone.adapter.feedcomponent.i.H().s(TextCellParser.toPlainText(getText()));
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public void setPosition(int i3) {
        this.position = i3;
    }

    public void setReply(Reply reply) {
        this.reply = reply;
    }

    @Override // com.qzone.proxy.feedcomponent.text.CellTextView.OnTextOperater
    public void onCancle() {
    }
}
