package com.tencent.qqnt.kernelpublic.nativeinterface;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class Contact implements Serializable {
    public int chatType;
    public String guildId;
    public String peerUid;
    long serialVersionUID;

    public Contact() {
        this.serialVersionUID = 1L;
        this.peerUid = "";
        this.guildId = "";
    }

    public int getChatType() {
        return this.chatType;
    }

    public String getGuildId() {
        return this.guildId;
    }

    public String getPeerUid() {
        return this.peerUid;
    }

    public void setChatType(int i3) {
        this.chatType = i3;
    }

    public void setGuildId(String str) {
        this.guildId = str;
    }

    public void setPeerUid(String str) {
        this.peerUid = str;
    }

    public String toString() {
        return "Contact{chatType=" + this.chatType + ",peerUid=" + this.peerUid + ",guildId=" + this.guildId + ",}";
    }

    public Contact(int i3, String str, String str2) {
        this.serialVersionUID = 1L;
        this.chatType = i3;
        this.peerUid = str;
        this.guildId = str2;
    }
}
