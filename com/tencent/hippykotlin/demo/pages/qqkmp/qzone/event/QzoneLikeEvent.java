package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.event;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonLike;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUnionID;
import com.tencent.hippykotlin.demo.pages.qzone.data.CommonCellLike;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0000\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/event/QzoneLikeEvent;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/event/QzoneOperateEvent;", "action", "", "unionID", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUnionID;", "cellLike", "Lcom/tencent/hippykotlin/demo/pages/qzone/data/CommonCellLike;", "commonLike", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonLike;", "linkedMediaId", "(Ljava/lang/String;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUnionID;Lcom/tencent/hippykotlin/demo/pages/qzone/data/CommonCellLike;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonLike;Ljava/lang/String;)V", "getAction", "()Ljava/lang/String;", "setAction", "(Ljava/lang/String;)V", "getCellLike", "()Lcom/tencent/hippykotlin/demo/pages/qzone/data/CommonCellLike;", "setCellLike", "(Lcom/tencent/hippykotlin/demo/pages/qzone/data/CommonCellLike;)V", "getCommonLike", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonLike;", "setCommonLike", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonLike;)V", "getLinkedMediaId", "setLinkedMediaId", "getUnionID", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUnionID;", "setUnionID", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUnionID;)V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QzoneLikeEvent extends QzoneOperateEvent {
    private String action;
    private CommonCellLike cellLike;
    private CommonLike commonLike;
    private String linkedMediaId;
    private CommonUnionID unionID;

    public /* synthetic */ QzoneLikeEvent(String str, CommonUnionID commonUnionID, CommonCellLike commonCellLike, CommonLike commonLike, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, commonUnionID, (i3 & 4) != 0 ? null : commonCellLike, (i3 & 8) != 0 ? null : commonLike, (i3 & 16) != 0 ? null : str2);
    }

    @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.event.QzoneOperateEvent
    public String getAction() {
        return this.action;
    }

    public final CommonCellLike getCellLike() {
        return this.cellLike;
    }

    public final CommonLike getCommonLike() {
        return this.commonLike;
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

    public final void setCellLike(CommonCellLike commonCellLike) {
        this.cellLike = commonCellLike;
    }

    public final void setCommonLike(CommonLike commonLike) {
        this.commonLike = commonLike;
    }

    public final void setLinkedMediaId(String str) {
        this.linkedMediaId = str;
    }

    @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.event.QzoneOperateEvent
    public void setUnionID(CommonUnionID commonUnionID) {
        this.unionID = commonUnionID;
    }

    public QzoneLikeEvent(String str, CommonUnionID commonUnionID, CommonCellLike commonCellLike, CommonLike commonLike, String str2) {
        super(commonUnionID, str);
        this.action = str;
        this.unionID = commonUnionID;
        this.cellLike = commonCellLike;
        this.commonLike = commonLike;
        this.linkedMediaId = str2;
    }
}
