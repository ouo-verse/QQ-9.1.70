package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class AiGenBotInfoReq {
    public MyBotInfo myBotInfo = new MyBotInfo();
    public AiGenBotInfoOperationType genType = AiGenBotInfoOperationType.values()[0];
    public String botTemplate = "";

    public String getBotTemplate() {
        return this.botTemplate;
    }

    public AiGenBotInfoOperationType getGenType() {
        return this.genType;
    }

    public MyBotInfo getMyBotInfo() {
        return this.myBotInfo;
    }

    public String toString() {
        return "AiGenBotInfoReq{myBotInfo=" + this.myBotInfo + ",genType=" + this.genType + ",botTemplate=" + this.botTemplate + ",}";
    }
}
