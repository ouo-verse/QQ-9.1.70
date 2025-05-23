package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class RenameGroupFileResult {
    public String fileId;
    public GroupFileCommonResult result;

    public RenameGroupFileResult() {
        this.result = new GroupFileCommonResult();
        this.fileId = "";
    }

    public String getFileId() {
        return this.fileId;
    }

    public GroupFileCommonResult getResult() {
        return this.result;
    }

    public RenameGroupFileResult(GroupFileCommonResult groupFileCommonResult, String str) {
        new GroupFileCommonResult();
        this.result = groupFileCommonResult;
        this.fileId = str;
    }
}
