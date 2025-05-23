package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class MsgAbstractElementData {
    public String content;
    public String customContent;
    public int elementType;
    public Integer index;
    public Integer onlineFileMsgCnt;

    public MsgAbstractElementData() {
    }

    public String getContent() {
        return this.content;
    }

    public String getCustomContent() {
        return this.customContent;
    }

    public int getElementType() {
        return this.elementType;
    }

    public Integer getIndex() {
        return this.index;
    }

    public Integer getOnlineFileMsgCnt() {
        return this.onlineFileMsgCnt;
    }

    public String toString() {
        return "MsgAbstractElementData{elementType=" + this.elementType + ",content=" + this.content + ",customContent=" + this.customContent + ",index=" + this.index + ",onlineFileMsgCnt=" + this.onlineFileMsgCnt + ",}";
    }

    public MsgAbstractElementData(int i3, String str, String str2, Integer num, Integer num2) {
        this.elementType = i3;
        this.content = str;
        this.customContent = str2;
        this.index = num;
        this.onlineFileMsgCnt = num2;
    }
}
