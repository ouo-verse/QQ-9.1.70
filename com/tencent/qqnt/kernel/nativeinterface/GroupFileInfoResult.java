package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupFileInfoResult {
    public String clientWording;
    public GroupFileInfo fileInfo;
    public int retCode;
    public String retMsg;

    public GroupFileInfoResult() {
        this.retMsg = "";
        this.clientWording = "";
        this.fileInfo = new GroupFileInfo();
    }

    public String getClientWording() {
        return this.clientWording;
    }

    public GroupFileInfo getFileInfo() {
        return this.fileInfo;
    }

    public int getRetCode() {
        return this.retCode;
    }

    public String getRetMsg() {
        return this.retMsg;
    }

    public GroupFileInfoResult(int i3, String str, String str2, GroupFileInfo groupFileInfo) {
        this.retMsg = "";
        this.clientWording = "";
        new GroupFileInfo();
        this.retCode = i3;
        this.retMsg = str;
        this.clientWording = str2;
        this.fileInfo = groupFileInfo;
    }
}
