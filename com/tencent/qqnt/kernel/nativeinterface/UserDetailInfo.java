package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class UserDetailInfo implements IKernelModel {
    public BaseExtendedInfo commonExt;
    public boolean isBuddy;
    public UserSimpleInfo simpleInfo;
    public String uid;
    public long uin;

    public UserDetailInfo() {
        this.uid = "";
    }

    public BaseExtendedInfo getCommonExt() {
        return this.commonExt;
    }

    public boolean getIsBuddy() {
        return this.isBuddy;
    }

    public UserSimpleInfo getSimpleInfo() {
        return this.simpleInfo;
    }

    public String getUid() {
        return this.uid;
    }

    public long getUin() {
        return this.uin;
    }

    public void setCommonExt(BaseExtendedInfo baseExtendedInfo) {
        this.commonExt = baseExtendedInfo;
    }

    public void setIsBuddy(boolean z16) {
        this.isBuddy = z16;
    }

    public void setSimpleInfo(UserSimpleInfo userSimpleInfo) {
        this.simpleInfo = userSimpleInfo;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void setUin(long j3) {
        this.uin = j3;
    }

    public UserDetailInfo(String str, long j3, boolean z16, UserSimpleInfo userSimpleInfo, BaseExtendedInfo baseExtendedInfo) {
        this.uid = str;
        this.uin = j3;
        this.isBuddy = z16;
        this.simpleInfo = userSimpleInfo;
        this.commonExt = baseExtendedInfo;
    }
}
