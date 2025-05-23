package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProMemberInfo implements Serializable {
    public String avatarMeta;
    public int gender;
    long serialVersionUID;
    public long tinyId;

    public GProMemberInfo() {
        this.serialVersionUID = 1L;
        this.avatarMeta = "";
    }

    public String getAvatarMeta() {
        return this.avatarMeta;
    }

    public int getGender() {
        return this.gender;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public String toString() {
        return "GProMemberInfo{tinyId=" + this.tinyId + ",gender=" + this.gender + ",avatarMeta=" + this.avatarMeta + ",}";
    }

    public GProMemberInfo(long j3, int i3, String str) {
        this.serialVersionUID = 1L;
        this.tinyId = j3;
        this.gender = i3;
        this.avatarMeta = str;
    }
}
