package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupSpaceResult {
    public boolean allUpload;
    public String clientWording;
    public int retCode;
    public String retMsg;
    public long totalSpace;
    public long usedSpace;

    public GroupSpaceResult() {
        this.retMsg = "";
        this.clientWording = "";
    }

    public boolean getAllUpload() {
        return this.allUpload;
    }

    public String getClientWording() {
        return this.clientWording;
    }

    public int getRetCode() {
        return this.retCode;
    }

    public String getRetMsg() {
        return this.retMsg;
    }

    public long getTotalSpace() {
        return this.totalSpace;
    }

    public long getUsedSpace() {
        return this.usedSpace;
    }

    public GroupSpaceResult(int i3, String str, String str2, long j3, long j16, boolean z16) {
        this.retCode = i3;
        this.retMsg = str;
        this.clientWording = str2;
        this.totalSpace = j3;
        this.usedSpace = j16;
        this.allUpload = z16;
    }
}
