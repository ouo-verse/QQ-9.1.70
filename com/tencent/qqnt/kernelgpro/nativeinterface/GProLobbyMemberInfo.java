package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProLobbyMemberInfo implements Serializable {
    public boolean playing;
    public long tinyId;
    public long uin;
    long serialVersionUID = 1;
    public String nickName = "";
    public String avatar = "";

    public String getAvatar() {
        return this.avatar;
    }

    public String getNickName() {
        return this.nickName;
    }

    public boolean getPlaying() {
        return this.playing;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public long getUin() {
        return this.uin;
    }

    public String toString() {
        return "GProLobbyMemberInfo{uin=" + this.uin + ",tinyId=" + this.tinyId + ",nickName=" + this.nickName + ",avatar=" + this.avatar + ",playing=" + this.playing + ",}";
    }
}
