package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.event;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUnionID;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/event/QzoneTopEvent;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/event/QzoneOperateEvent;", "action", "", "unionID", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUnionID;", "(Ljava/lang/String;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUnionID;)V", "getAction", "()Ljava/lang/String;", "setAction", "(Ljava/lang/String;)V", "getUnionID", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUnionID;", "setUnionID", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUnionID;)V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QzoneTopEvent extends QzoneOperateEvent {
    private String action;
    private CommonUnionID unionID;

    public QzoneTopEvent(String str, CommonUnionID commonUnionID) {
        super(commonUnionID, str);
        this.action = str;
        this.unionID = commonUnionID;
    }

    @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.event.QzoneOperateEvent
    public String getAction() {
        return this.action;
    }

    @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.event.QzoneOperateEvent
    public CommonUnionID getUnionID() {
        return this.unionID;
    }

    @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.event.QzoneOperateEvent
    public void setAction(String str) {
        this.action = str;
    }

    @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.event.QzoneOperateEvent
    public void setUnionID(CommonUnionID commonUnionID) {
        this.unionID = commonUnionID;
    }
}
