package com.tencent.state.template.push;

import com.tencent.state.common.push.PushBasic;
import com.tencent.state.common.push.PushMessage;
import com.tencent.state.template.data.PKResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\nJ\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00108F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/state/template/push/ChoosePKTagMessage;", "Lcom/tencent/state/common/push/PushMessage;", "type", "", "info", "Lcom/tencent/state/common/push/PushBasic;", "uin", "", "roomId", "option", "(ILcom/tencent/state/common/push/PushBasic;JJI)V", "getInfo", "()Lcom/tencent/state/common/push/PushBasic;", "getOption", "()I", "pkResult", "Lcom/tencent/state/template/data/PKResult;", "getPkResult", "()Lcom/tencent/state/template/data/PKResult;", "getRoomId", "()J", "getType", "getUin", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ChoosePKTagMessage extends PushMessage {
    private final PushBasic info;
    private final int option;
    private final long roomId;
    private final int type;
    private final long uin;

    public ChoosePKTagMessage(int i3, PushBasic info, long j3, long j16, int i16) {
        Intrinsics.checkNotNullParameter(info, "info");
        this.type = i3;
        this.info = info;
        this.uin = j3;
        this.roomId = j16;
        this.option = i16;
    }

    @Override // com.tencent.state.common.push.PushMessage
    public PushBasic getInfo() {
        return this.info;
    }

    public final int getOption() {
        return this.option;
    }

    public final PKResult getPkResult() {
        int i3 = this.option;
        if (i3 == 1) {
            return PKResult.SUPPORT;
        }
        if (i3 != 2) {
            return PKResult.UNSELECTED;
        }
        return PKResult.OPPOSE;
    }

    public final long getRoomId() {
        return this.roomId;
    }

    @Override // com.tencent.state.common.push.PushMessage
    public int getType() {
        return this.type;
    }

    public final long getUin() {
        return this.uin;
    }

    public String toString() {
        return "ChoosePKTagMessage(type=" + getType() + ", uin: " + this.uin + ", roomId: " + this.roomId + ", option: " + this.option + ')';
    }
}
