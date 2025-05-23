package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.event;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellPermission;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUnionID;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/event/QzonePermissionEvent;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/event/QzoneOperateEvent;", "action", "", "unionID", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUnionID;", QCircleDaTongConstant.ElementParamValue.PERMISSION, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellPermission;", "(Ljava/lang/String;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUnionID;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellPermission;)V", "getAction", "()Ljava/lang/String;", "setAction", "(Ljava/lang/String;)V", "getPermission", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellPermission;", "setPermission", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellPermission;)V", "getUnionID", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUnionID;", "setUnionID", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUnionID;)V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QzonePermissionEvent extends QzoneOperateEvent {
    private String action;
    private CommonCellPermission permission;
    private CommonUnionID unionID;

    public QzonePermissionEvent(String str, CommonUnionID commonUnionID, CommonCellPermission commonCellPermission) {
        super(commonUnionID, str);
        this.action = str;
        this.unionID = commonUnionID;
        this.permission = commonCellPermission;
    }

    @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.event.QzoneOperateEvent
    public String getAction() {
        return this.action;
    }

    public final CommonCellPermission getPermission() {
        return this.permission;
    }

    @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.event.QzoneOperateEvent
    public CommonUnionID getUnionID() {
        return this.unionID;
    }

    @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.event.QzoneOperateEvent
    public void setAction(String str) {
        this.action = str;
    }

    public final void setPermission(CommonCellPermission commonCellPermission) {
        this.permission = commonCellPermission;
    }

    @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.event.QzoneOperateEvent
    public void setUnionID(CommonUnionID commonUnionID) {
        this.unionID = commonUnionID;
    }
}
