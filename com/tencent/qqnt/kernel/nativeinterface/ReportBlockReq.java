package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class ReportBlockReq {
    public int sourceId;
    public int sourceSubId;
    public AccountInfo targetInfo = new AccountInfo();
    public Long troopUin;

    public int getSourceId() {
        return this.sourceId;
    }

    public int getSourceSubId() {
        return this.sourceSubId;
    }

    public AccountInfo getTargetInfo() {
        return this.targetInfo;
    }

    public Long getTroopUin() {
        return this.troopUin;
    }
}
