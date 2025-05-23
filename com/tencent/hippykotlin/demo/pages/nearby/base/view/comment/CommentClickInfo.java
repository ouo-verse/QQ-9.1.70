package com.tencent.hippykotlin.demo.pages.nearby.base.view.comment;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.detail.model.BoxType$EnumUnboxingSharedUtility;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import kotlin.jvm.internal.Intrinsics;
import s35.af;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class CommentClickInfo {
    public final NBPCommentVO comment;
    public final NBPReplyVO reply;
    public final int type;

    public CommentClickInfo(int i3, NBPCommentVO nBPCommentVO, NBPReplyVO nBPReplyVO) {
        this.type = i3;
        this.comment = nBPCommentVO;
        this.reply = nBPReplyVO;
    }

    public final af getUser() {
        NBPReplyVO nBPReplyVO = this.reply;
        if (!(nBPReplyVO != null)) {
            return this.comment.user;
        }
        if (nBPReplyVO != null) {
            return nBPReplyVO.user;
        }
        return null;
    }

    public final int hashCode() {
        int hashCode = (this.comment.hashCode() + (BoxType$EnumUnboxingSharedUtility.ordinal(this.type) * 31)) * 31;
        NBPReplyVO nBPReplyVO = this.reply;
        return hashCode + (nBPReplyVO == null ? 0 : nBPReplyVO.raw.hashCode());
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("CommentClickInfo(type=");
        m3.append(CommentClickInfo$ClickType$EnumUnboxingLocalUtility.stringValueOf(this.type));
        m3.append(", comment=");
        m3.append(this.comment);
        m3.append(", reply=");
        m3.append(this.reply);
        m3.append(')');
        return m3.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CommentClickInfo)) {
            return false;
        }
        CommentClickInfo commentClickInfo = (CommentClickInfo) obj;
        return this.type == commentClickInfo.type && Intrinsics.areEqual(this.comment, commentClickInfo.comment) && Intrinsics.areEqual(this.reply, commentClickInfo.reply);
    }
}
