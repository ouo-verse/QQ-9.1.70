package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class MiniAppGroupInfoRsp {
    public MiniAppGetGroupInfoResult result = new MiniAppGetGroupInfoResult();
    public MiniAppGroupInfoReq miniAppGroupInfoReq = new MiniAppGroupInfoReq();
    public GroupStatus groupStatus = GroupStatus.values()[0];
    public MiniAppMemberInfo memberInfo = new MiniAppMemberInfo();

    public GroupStatus getGroupStatus() {
        return this.groupStatus;
    }

    public MiniAppMemberInfo getMemberInfo() {
        return this.memberInfo;
    }

    public MiniAppGroupInfoReq getMiniAppGroupInfoReq() {
        return this.miniAppGroupInfoReq;
    }

    public MiniAppGetGroupInfoResult getResult() {
        return this.result;
    }

    public String toString() {
        return "MiniAppGroupInfoRsp{result=" + this.result + ",miniAppGroupInfoReq=" + this.miniAppGroupInfoReq + ",groupStatus=" + this.groupStatus + ",memberInfo=" + this.memberInfo + ",}";
    }
}
