package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProActiveUser implements Serializable {
    public long age;
    public String avatarMeta;
    public String cityName;
    public int gender;
    public long guildId;
    public boolean isQQFriend;
    public String nickName;
    public String openid;
    long serialVersionUID;
    public long stateType;
    public long tinyid;

    public GProActiveUser() {
        this.serialVersionUID = 1L;
        this.nickName = "";
        this.avatarMeta = "";
        this.cityName = "";
        this.openid = "";
    }

    public long getAge() {
        return this.age;
    }

    public String getAvatarMeta() {
        return this.avatarMeta;
    }

    public String getCityName() {
        return this.cityName;
    }

    public int getGender() {
        return this.gender;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public boolean getIsQQFriend() {
        return this.isQQFriend;
    }

    public String getNickName() {
        return this.nickName;
    }

    public String getOpenid() {
        return this.openid;
    }

    public long getStateType() {
        return this.stateType;
    }

    public long getTinyid() {
        return this.tinyid;
    }

    public String toString() {
        return "GProActiveUser{tinyid=" + this.tinyid + ",nickName=" + this.nickName + ",gender=" + this.gender + ",avatarMeta=" + this.avatarMeta + ",age=" + this.age + ",stateType=" + this.stateType + ",cityName=" + this.cityName + ",guildId=" + this.guildId + ",isQQFriend=" + this.isQQFriend + ",openid=" + this.openid + ",}";
    }

    public GProActiveUser(long j3, String str, int i3, String str2, long j16, long j17, String str3, long j18, boolean z16, String str4) {
        this.serialVersionUID = 1L;
        this.tinyid = j3;
        this.nickName = str;
        this.gender = i3;
        this.avatarMeta = str2;
        this.age = j16;
        this.stateType = j17;
        this.cityName = str3;
        this.guildId = j18;
        this.isQQFriend = z16;
        this.openid = str4;
    }
}
