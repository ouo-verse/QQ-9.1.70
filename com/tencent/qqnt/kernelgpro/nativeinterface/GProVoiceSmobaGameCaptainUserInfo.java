package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProVoiceSmobaGameCaptainUserInfo implements Serializable {
    public String avatarMeta;
    public String nickName;
    long serialVersionUID;

    public GProVoiceSmobaGameCaptainUserInfo() {
        this.serialVersionUID = 1L;
        this.avatarMeta = "";
        this.nickName = "";
    }

    public String getAvatarMeta() {
        return this.avatarMeta;
    }

    public String getNickName() {
        return this.nickName;
    }

    public String toString() {
        return "GProVoiceSmobaGameCaptainUserInfo{avatarMeta=" + this.avatarMeta + ",nickName=" + this.nickName + ",}";
    }

    public GProVoiceSmobaGameCaptainUserInfo(String str, String str2) {
        this.serialVersionUID = 1L;
        this.avatarMeta = str;
        this.nickName = str2;
    }
}
