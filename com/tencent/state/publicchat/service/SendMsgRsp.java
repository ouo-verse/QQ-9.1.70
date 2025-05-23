package com.tencent.state.publicchat.service;

import com.tencent.state.publicchat.data.MsgInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zs4.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0015\u0010\u0016B\u0013\b\u0016\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u00a2\u0006\u0004\b\u0015\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\u001d\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u00c6\u0001J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\t\u0010\u000b\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0007\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/state/publicchat/service/SendMsgRsp;", "", "Lcom/tencent/state/publicchat/data/MsgInfo;", "component1", "", "component2", "msgInfo", "sendIntervalSecond", "copy", "", "toString", "hashCode", "other", "", "equals", "Lcom/tencent/state/publicchat/data/MsgInfo;", "getMsgInfo", "()Lcom/tencent/state/publicchat/data/MsgInfo;", "I", "getSendIntervalSecond", "()I", "<init>", "(Lcom/tencent/state/publicchat/data/MsgInfo;I)V", "Lzs4/c;", "pb", "(Lzs4/c;)V", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class SendMsgRsp {
    private final MsgInfo msgInfo;
    private final int sendIntervalSecond;

    public SendMsgRsp(MsgInfo msgInfo, int i3) {
        Intrinsics.checkNotNullParameter(msgInfo, "msgInfo");
        this.msgInfo = msgInfo;
        this.sendIntervalSecond = i3;
    }

    /* renamed from: component1, reason: from getter */
    public final MsgInfo getMsgInfo() {
        return this.msgInfo;
    }

    /* renamed from: component2, reason: from getter */
    public final int getSendIntervalSecond() {
        return this.sendIntervalSecond;
    }

    public final SendMsgRsp copy(MsgInfo msgInfo, int sendIntervalSecond) {
        Intrinsics.checkNotNullParameter(msgInfo, "msgInfo");
        return new SendMsgRsp(msgInfo, sendIntervalSecond);
    }

    public final MsgInfo getMsgInfo() {
        return this.msgInfo;
    }

    public final int getSendIntervalSecond() {
        return this.sendIntervalSecond;
    }

    public int hashCode() {
        MsgInfo msgInfo = this.msgInfo;
        return ((msgInfo != null ? msgInfo.hashCode() : 0) * 31) + this.sendIntervalSecond;
    }

    public String toString() {
        return "SendMsgRsp(msgInfo=" + this.msgInfo + ", sendIntervalSecond=" + this.sendIntervalSecond + ")";
    }

    public SendMsgRsp(c cVar) {
        this(new MsgInfo(cVar != null ? cVar.f453173a : null), cVar != null ? cVar.f453174b : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SendMsgRsp)) {
            return false;
        }
        SendMsgRsp sendMsgRsp = (SendMsgRsp) other;
        return Intrinsics.areEqual(this.msgInfo, sendMsgRsp.msgInfo) && this.sendIntervalSecond == sendMsgRsp.sendIntervalSecond;
    }

    public static /* synthetic */ SendMsgRsp copy$default(SendMsgRsp sendMsgRsp, MsgInfo msgInfo, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            msgInfo = sendMsgRsp.msgInfo;
        }
        if ((i16 & 2) != 0) {
            i3 = sendMsgRsp.sendIntervalSecond;
        }
        return sendMsgRsp.copy(msgInfo, i3);
    }
}
