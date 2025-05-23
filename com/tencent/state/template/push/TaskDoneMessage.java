package com.tencent.state.template.push;

import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.state.common.push.PushBasic;
import com.tencent.state.common.push.PushMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\tJ\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/state/template/push/TaskDoneMessage;", "Lcom/tencent/state/common/push/PushMessage;", "type", "", "info", "Lcom/tencent/state/common/push/PushBasic;", "uin", "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "(ILcom/tencent/state/common/push/PushBasic;JI)V", "getInfo", "()Lcom/tencent/state/common/push/PushBasic;", "getTaskId", "()I", "getType", "getUin", "()J", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class TaskDoneMessage extends PushMessage {
    private final PushBasic info;
    private final int taskId;
    private final int type;
    private final long uin;

    public TaskDoneMessage(int i3, PushBasic info, long j3, int i16) {
        Intrinsics.checkNotNullParameter(info, "info");
        this.type = i3;
        this.info = info;
        this.uin = j3;
        this.taskId = i16;
    }

    @Override // com.tencent.state.common.push.PushMessage
    public PushBasic getInfo() {
        return this.info;
    }

    public final int getTaskId() {
        return this.taskId;
    }

    @Override // com.tencent.state.common.push.PushMessage
    public int getType() {
        return this.type;
    }

    public final long getUin() {
        return this.uin;
    }

    public String toString() {
        return "TaskDoneMessage(type=" + getType() + ", uin: " + this.uin + ", uin: " + this.uin + ", taskId: " + this.taskId + ')';
    }
}
