package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GetArgMsgConfigReqInfo {
    public ArrayList<ArkMsgBaseInfo> arkMsgBaseInfos = new ArrayList<>();
    public int reqType;

    public ArrayList<ArkMsgBaseInfo> getArkMsgBaseInfos() {
        return this.arkMsgBaseInfos;
    }

    public int getReqType() {
        return this.reqType;
    }

    public String toString() {
        return "GetArgMsgConfigReqInfo{reqType=" + this.reqType + ",arkMsgBaseInfos=" + this.arkMsgBaseInfos + ",}";
    }
}
