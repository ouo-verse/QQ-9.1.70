package com.tencent.state.template.push;

import com.tencent.state.common.push.PushBasic;
import com.tencent.state.common.push.PushMessage;
import com.tencent.state.data.UserCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\b\u0010\u0017\u001a\u00020\u0007H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/state/template/push/RoomInteractionEndInteractionMessage;", "Lcom/tencent/state/common/push/PushMessage;", "type", "", "info", "Lcom/tencent/state/common/push/PushBasic;", "billNo", "", "uin", "", "profile", "Lcom/tencent/state/data/UserCommon;", "(ILcom/tencent/state/common/push/PushBasic;Ljava/lang/String;JLcom/tencent/state/data/UserCommon;)V", "getBillNo", "()Ljava/lang/String;", "getInfo", "()Lcom/tencent/state/common/push/PushBasic;", "getProfile", "()Lcom/tencent/state/data/UserCommon;", "getType", "()I", "getUin", "()J", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class RoomInteractionEndInteractionMessage extends PushMessage {
    private final String billNo;
    private final PushBasic info;
    private final UserCommon profile;
    private final int type;
    private final long uin;

    public RoomInteractionEndInteractionMessage(int i3, PushBasic info, String billNo, long j3, UserCommon profile) {
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(billNo, "billNo");
        Intrinsics.checkNotNullParameter(profile, "profile");
        this.type = i3;
        this.info = info;
        this.billNo = billNo;
        this.uin = j3;
        this.profile = profile;
    }

    public final String getBillNo() {
        return this.billNo;
    }

    @Override // com.tencent.state.common.push.PushMessage
    public PushBasic getInfo() {
        return this.info;
    }

    public final UserCommon getProfile() {
        return this.profile;
    }

    @Override // com.tencent.state.common.push.PushMessage
    public int getType() {
        return this.type;
    }

    public final long getUin() {
        return this.uin;
    }

    public String toString() {
        return "RoomInteractionEndInteractionMessage(type=" + getType() + ", info=" + getInfo() + ", billNo=" + this.billNo + ", uin=" + this.uin + ", profile=" + this.profile + ')';
    }
}
