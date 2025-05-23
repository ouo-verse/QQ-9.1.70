package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class ChangeMyBotReq {
    public ChangeMyBotOperationType operationType = ChangeMyBotOperationType.values()[0];
    public MyBotInfo myBotInfo = new MyBotInfo();

    public MyBotInfo getMyBotInfo() {
        return this.myBotInfo;
    }

    public ChangeMyBotOperationType getOperationType() {
        return this.operationType;
    }

    public String toString() {
        return "ChangeMyBotReq{operationType=" + this.operationType + ",myBotInfo=" + this.myBotInfo + ",}";
    }
}
