package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class CreateGroupResult {
    public int createOption;
    public long groupCode;
    public int groupSize;
    public long ownerUin;
    public ArrayList<SecurityInfo> securityInfo = new ArrayList<>();
    public String sign = "";

    public CreateGroupResult() {
    }

    public int getCreateOption() {
        return this.createOption;
    }

    public long getGroupCode() {
        return this.groupCode;
    }

    public int getGroupSize() {
        return this.groupSize;
    }

    public long getOwnerUin() {
        return this.ownerUin;
    }

    public ArrayList<SecurityInfo> getSecurityInfo() {
        return this.securityInfo;
    }

    public String getSign() {
        return this.sign;
    }

    public String toString() {
        return "CreateGroupResult{groupCode=" + this.groupCode + ",securityInfo=" + this.securityInfo + ",createOption=" + this.createOption + ",ownerUin=" + this.ownerUin + ",groupSize=" + this.groupSize + ",sign=" + this.sign + ",}";
    }

    public CreateGroupResult(long j3) {
        this.groupCode = j3;
    }
}
