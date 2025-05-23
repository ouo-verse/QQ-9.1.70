package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class AddFriendBlockedRedPointRsp {
    public AccountInfo acc = new AccountInfo();
    public boolean isShowAddFriendBlockedEntrance;
    public boolean isShowRedPoint;
    public boolean isShowRedPointAtNewFriendBanner;

    public AccountInfo getAcc() {
        return this.acc;
    }

    public boolean getIsShowAddFriendBlockedEntrance() {
        return this.isShowAddFriendBlockedEntrance;
    }

    public boolean getIsShowRedPoint() {
        return this.isShowRedPoint;
    }

    public boolean getIsShowRedPointAtNewFriendBanner() {
        return this.isShowRedPointAtNewFriendBanner;
    }
}
