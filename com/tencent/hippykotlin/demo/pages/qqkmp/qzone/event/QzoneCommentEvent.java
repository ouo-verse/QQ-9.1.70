package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.event;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonComment;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUnionID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/event/QzoneCommentEvent;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/event/QzoneOperateEvent;", "action", "", "unionID", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUnionID;", "comment", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonComment;", "linkedMediaId", "(Ljava/lang/String;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUnionID;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonComment;Ljava/lang/String;)V", "getAction", "()Ljava/lang/String;", "setAction", "(Ljava/lang/String;)V", "getComment", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonComment;", "setComment", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonComment;)V", "getLinkedMediaId", "setLinkedMediaId", "getUnionID", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUnionID;", "setUnionID", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUnionID;)V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QzoneCommentEvent extends QzoneOperateEvent {
    private String action;
    private CommonComment comment;
    private String linkedMediaId;
    private CommonUnionID unionID;

    public /* synthetic */ QzoneCommentEvent(String str, CommonUnionID commonUnionID, CommonComment commonComment, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, commonUnionID, commonComment, (i3 & 8) != 0 ? null : str2);
    }

    @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.event.QzoneOperateEvent
    public String getAction() {
        return this.action;
    }

    public final CommonComment getComment() {
        return this.comment;
    }

    public final String getLinkedMediaId() {
        return this.linkedMediaId;
    }

    @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.event.QzoneOperateEvent
    public CommonUnionID getUnionID() {
        return this.unionID;
    }

    @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.event.QzoneOperateEvent
    public void setAction(String str) {
        this.action = str;
    }

    public final void setComment(CommonComment commonComment) {
        this.comment = commonComment;
    }

    public final void setLinkedMediaId(String str) {
        this.linkedMediaId = str;
    }

    @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.event.QzoneOperateEvent
    public void setUnionID(CommonUnionID commonUnionID) {
        this.unionID = commonUnionID;
    }

    public QzoneCommentEvent(String str, CommonUnionID commonUnionID, CommonComment commonComment, String str2) {
        super(commonUnionID, str);
        this.action = str;
        this.unionID = commonUnionID;
        this.comment = commonComment;
        this.linkedMediaId = str2;
    }
}
