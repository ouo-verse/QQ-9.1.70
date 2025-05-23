package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProAISearchSessionMsg {
    public long createTime;
    public boolean isFold;
    public int modelType;
    public int msgStatus;
    public int type;
    public long uin;
    public String msgId = "";
    public GProAISearchMsgContent content = new GProAISearchMsgContent();
    public String coupleId = "";
    public String msgShareSummary = "";

    public GProAISearchMsgContent getContent() {
        return this.content;
    }

    public String getCoupleId() {
        return this.coupleId;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public boolean getIsFold() {
        return this.isFold;
    }

    public int getModelType() {
        return this.modelType;
    }

    public String getMsgId() {
        return this.msgId;
    }

    public String getMsgShareSummary() {
        return this.msgShareSummary;
    }

    public int getMsgStatus() {
        return this.msgStatus;
    }

    public int getType() {
        return this.type;
    }

    public long getUin() {
        return this.uin;
    }

    public String toString() {
        return "GProAISearchSessionMsg{msgId=" + this.msgId + ",content=" + this.content + ",type=" + this.type + ",createTime=" + this.createTime + ",modelType=" + this.modelType + ",coupleId=" + this.coupleId + ",uin=" + this.uin + ",msgShareSummary=" + this.msgShareSummary + ",isFold=" + this.isFold + ",msgStatus=" + this.msgStatus + ",}";
    }
}
