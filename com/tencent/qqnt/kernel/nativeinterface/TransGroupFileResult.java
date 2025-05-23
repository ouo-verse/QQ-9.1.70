package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class TransGroupFileResult {
    public GroupFileCommonResult result;
    public int saveBusId;
    public String saveFilePath;

    public TransGroupFileResult() {
        this.result = new GroupFileCommonResult();
        this.saveFilePath = "";
    }

    public GroupFileCommonResult getResult() {
        return this.result;
    }

    public int getSaveBusId() {
        return this.saveBusId;
    }

    public String getSaveFilePath() {
        return this.saveFilePath;
    }

    public TransGroupFileResult(GroupFileCommonResult groupFileCommonResult, int i3, String str) {
        new GroupFileCommonResult();
        this.result = groupFileCommonResult;
        this.saveBusId = i3;
        this.saveFilePath = str;
    }
}
