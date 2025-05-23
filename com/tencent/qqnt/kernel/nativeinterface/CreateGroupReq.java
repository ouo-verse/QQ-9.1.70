package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class CreateGroupReq {
    public int createOption;
    public CreateGroupInfo createGroupInfo = new CreateGroupInfo();
    public SelectGroupCodeInfo selectGroupCodeInfo = new SelectGroupCodeInfo();
    public CreateGroupReqExt extInfo = new CreateGroupReqExt();

    public CreateGroupInfo getCreateGroupInfo() {
        return this.createGroupInfo;
    }

    public int getCreateOption() {
        return this.createOption;
    }

    public CreateGroupReqExt getExtInfo() {
        return this.extInfo;
    }

    public SelectGroupCodeInfo getSelectGroupCodeInfo() {
        return this.selectGroupCodeInfo;
    }

    public String toString() {
        return "CreateGroupReq{createOption=" + this.createOption + ",createGroupInfo=" + this.createGroupInfo + ",selectGroupCodeInfo=" + this.selectGroupCodeInfo + ",extInfo=" + this.extInfo + ",}";
    }
}
