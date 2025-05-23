package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupNotifyTargetMsg {
    public long groupCode;
    public long seq;
    public boolean setBlackList;
    public GroupNotifyMsgType type = GroupNotifyMsgType.values()[0];
    public String postscript = "";
    public String operateData = "";
    public byte[] operateTransInfo = new byte[0];

    public long getGroupCode() {
        return this.groupCode;
    }

    public String getOperateData() {
        return this.operateData;
    }

    public byte[] getOperateTransInfo() {
        return this.operateTransInfo;
    }

    public String getPostscript() {
        return this.postscript;
    }

    public long getSeq() {
        return this.seq;
    }

    public boolean getSetBlackList() {
        return this.setBlackList;
    }

    public GroupNotifyMsgType getType() {
        return this.type;
    }

    public String toString() {
        return "GroupNotifyTargetMsg{seq=" + this.seq + ",type=" + this.type + ",groupCode=" + this.groupCode + ",postscript=" + this.postscript + ",setBlackList=" + this.setBlackList + ",operateData=" + this.operateData + ",operateTransInfo=" + this.operateTransInfo + ",}";
    }
}
