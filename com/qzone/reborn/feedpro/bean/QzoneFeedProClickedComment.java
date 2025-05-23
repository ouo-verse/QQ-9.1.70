package com.qzone.reborn.feedpro.bean;

import android.text.TextUtils;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.proxy.feedcomponent.model.ClickedPoint;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.qzone.proxy.feedcomponent.text.TextCellParser;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonComment;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonReply;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.CommonFeedDataUtilKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010(\u001a\u0004\u0018\u00010)J\b\u0010*\u001a\u00020+H\u0016J\b\u0010,\u001a\u00020+H\u0016R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0018\"\u0004\b\u0014\u0010\u0019R\u001e\u0010\u001a\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0018\"\u0004\b\u001b\u0010\u0019R\u001e\u0010\u001c\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000fR \u0010\u001f\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010%\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\r\"\u0004\b'\u0010\u000f\u00a8\u0006-"}, d2 = {"Lcom/qzone/reborn/feedpro/bean/QzoneFeedProClickedComment;", "Lcom/qzone/proxy/feedcomponent/text/CellTextView$OnTextOperater;", "Lcom/tencent/component/app/common/SmartParcelable;", "()V", "clickedPoint", "Lcom/qzone/proxy/feedcomponent/model/ClickedPoint;", "getClickedPoint", "()Lcom/qzone/proxy/feedcomponent/model/ClickedPoint;", "setClickedPoint", "(Lcom/qzone/proxy/feedcomponent/model/ClickedPoint;)V", "cmtIndex", "", "getCmtIndex", "()I", "setCmtIndex", "(I)V", "comment", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonComment;", "getComment", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonComment;", "setComment", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonComment;)V", "isComment", "", "()Z", "(Z)V", "isDoubleClickComment", "setDoubleClickComment", "position", "getPosition", "setPosition", "reply", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonReply;", "getReply", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonReply;", "setReply", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonReply;)V", "replyIndex", "getReplyIndex", "setReplyIndex", "getText", "", "onCancle", "", "onCopy", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QzoneFeedProClickedComment implements CellTextView.OnTextOperater, SmartParcelable {

    @NeedParcel
    private ClickedPoint clickedPoint;

    @NeedParcel
    private int cmtIndex;

    @NeedParcel
    private CommonComment comment;

    @NeedParcel
    private boolean isComment;

    @NeedParcel
    private boolean isDoubleClickComment;

    @NeedParcel
    private int position;

    @NeedParcel
    private CommonReply reply;

    @NeedParcel
    private int replyIndex;

    public final ClickedPoint getClickedPoint() {
        return this.clickedPoint;
    }

    public final int getCmtIndex() {
        return this.cmtIndex;
    }

    public final CommonComment getComment() {
        return this.comment;
    }

    public final int getPosition() {
        return this.position;
    }

    public final CommonReply getReply() {
        return this.reply;
    }

    public final int getReplyIndex() {
        return this.replyIndex;
    }

    public final String getText() {
        String str;
        CommonReply commonReply = this.reply;
        String str2 = "";
        if (commonReply == null) {
            str = "";
        } else {
            Intrinsics.checkNotNull(commonReply);
            str = CommonFeedDataUtilKt.msgToString(commonReply.getContent());
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        CommonComment commonComment = this.comment;
        if (commonComment != null) {
            Intrinsics.checkNotNull(commonComment);
            str2 = CommonFeedDataUtilKt.msgToString(commonComment.getContent());
        }
        return str2;
    }

    /* renamed from: isComment, reason: from getter */
    public final boolean getIsComment() {
        return this.isComment;
    }

    /* renamed from: isDoubleClickComment, reason: from getter */
    public final boolean getIsDoubleClickComment() {
        return this.isDoubleClickComment;
    }

    @Override // com.qzone.proxy.feedcomponent.text.CellTextView.OnTextOperater
    public void onCopy() {
        if (TextUtils.isEmpty(getText())) {
            return;
        }
        i.H().s(TextCellParser.toPlainText(getText()));
    }

    public final void setClickedPoint(ClickedPoint clickedPoint) {
        this.clickedPoint = clickedPoint;
    }

    public final void setCmtIndex(int i3) {
        this.cmtIndex = i3;
    }

    public final void setComment(CommonComment commonComment) {
        this.comment = commonComment;
    }

    public final void setDoubleClickComment(boolean z16) {
        this.isDoubleClickComment = z16;
    }

    public final void setPosition(int i3) {
        this.position = i3;
    }

    public final void setReply(CommonReply commonReply) {
        this.reply = commonReply;
    }

    public final void setReplyIndex(int i3) {
        this.replyIndex = i3;
    }

    public final void setComment(boolean z16) {
        this.isComment = z16;
    }

    @Override // com.qzone.proxy.feedcomponent.text.CellTextView.OnTextOperater
    public void onCancle() {
    }
}
