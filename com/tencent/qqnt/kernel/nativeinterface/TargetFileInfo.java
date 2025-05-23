package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class TargetFileInfo {
    public CommonFileInfo commonFileInfo;
    public long targetElemId;
    public long targetMsgId;

    public TargetFileInfo() {
        this.commonFileInfo = new CommonFileInfo();
    }

    public CommonFileInfo getCommonFileInfo() {
        return this.commonFileInfo;
    }

    public long getTargetElemId() {
        return this.targetElemId;
    }

    public long getTargetMsgId() {
        return this.targetMsgId;
    }

    public TargetFileInfo(long j3, long j16, CommonFileInfo commonFileInfo) {
        new CommonFileInfo();
        this.targetMsgId = j3;
        this.targetElemId = j16;
        this.commonFileInfo = commonFileInfo;
    }
}
