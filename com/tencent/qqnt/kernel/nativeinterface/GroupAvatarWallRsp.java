package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupAvatarWallRsp {
    public long groupCode;
    public GroupPortrait headPortrait = new GroupPortrait();
    public int headPortraitSeq;

    public long getGroupCode() {
        return this.groupCode;
    }

    public GroupPortrait getHeadPortrait() {
        return this.headPortrait;
    }

    public int getHeadPortraitSeq() {
        return this.headPortraitSeq;
    }

    public String toString() {
        return "GroupAvatarWallRsp{groupCode=" + this.groupCode + ",headPortraitSeq=" + this.headPortraitSeq + ",headPortrait=" + this.headPortrait + ",}";
    }
}
