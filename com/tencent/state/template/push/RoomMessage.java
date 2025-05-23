package com.tencent.state.template.push;

import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.state.common.push.PushBasic;
import com.tencent.state.common.push.PushMessage;
import com.tencent.state.template.data.SitDownInfo;
import com.tencent.state.template.data.User;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0002\u0010\rJ\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\n\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/state/template/push/RoomFocusMessage;", "Lcom/tencent/state/common/push/PushMessage;", "type", "", "info", "Lcom/tencent/state/common/push/PushBasic;", "roomId", "", QCircleAlphaUserReporter.KEY_USER, "Lcom/tencent/state/template/data/User;", "tableId", WSPublicAccReport.SOP_NAME_FOCUS, "Lcom/tencent/state/template/data/SitDownInfo;", "(ILcom/tencent/state/common/push/PushBasic;JLcom/tencent/state/template/data/User;JLcom/tencent/state/template/data/SitDownInfo;)V", "getFocus", "()Lcom/tencent/state/template/data/SitDownInfo;", "getInfo", "()Lcom/tencent/state/common/push/PushBasic;", "getRoomId", "()J", "getTableId", "getType", "()I", "getUser", "()Lcom/tencent/state/template/data/User;", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.state.template.push.RoomFocusMessage, reason: from toString */
/* loaded from: classes38.dex */
public final class RoomMessage extends PushMessage {
    private final SitDownInfo focus;
    private final PushBasic info;
    private final long roomId;
    private final long tableId;
    private final int type;
    private final User user;

    public RoomMessage(int i3, PushBasic info, long j3, User user, long j16, SitDownInfo focus) {
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(focus, "focus");
        this.type = i3;
        this.info = info;
        this.roomId = j3;
        this.user = user;
        this.tableId = j16;
        this.focus = focus;
    }

    public final SitDownInfo getFocus() {
        return this.focus;
    }

    @Override // com.tencent.state.common.push.PushMessage
    public PushBasic getInfo() {
        return this.info;
    }

    public final long getRoomId() {
        return this.roomId;
    }

    public final long getTableId() {
        return this.tableId;
    }

    @Override // com.tencent.state.common.push.PushMessage
    public int getType() {
        return this.type;
    }

    public final User getUser() {
        return this.user;
    }

    public String toString() {
        return "RoomMessage(type=" + getType() + ", info=" + getInfo() + ", roomId=" + this.roomId + ", user=" + this.user + ", tableId=" + this.tableId + ", focus=" + this.focus + ')';
    }
}
