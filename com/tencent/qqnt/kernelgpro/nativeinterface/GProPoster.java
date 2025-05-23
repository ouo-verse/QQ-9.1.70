package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProPoster implements Serializable {
    public String avatar;
    public String nick;
    long serialVersionUID;
    public long tinyId;

    public GProPoster() {
        this.serialVersionUID = 1L;
        this.nick = "";
        this.avatar = "";
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getNick() {
        return this.nick;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public String toString() {
        return "GProPoster{tinyId=" + this.tinyId + ",nick=" + this.nick + ",avatar=" + this.avatar + ",}";
    }

    public GProPoster(long j3, String str, String str2) {
        this.serialVersionUID = 1L;
        this.tinyId = j3;
        this.nick = str;
        this.avatar = str2;
    }
}
