package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class UserPermission {
    public String friendUid;
    public long friendUin;
    public Boolean onlyChat;
    public Boolean qzoneNotWatch;
    public Boolean qzoneNotWatched;

    public UserPermission() {
        this.friendUid = "";
    }

    public String getFriendUid() {
        return this.friendUid;
    }

    public long getFriendUin() {
        return this.friendUin;
    }

    public Boolean getOnlyChat() {
        return this.onlyChat;
    }

    public Boolean getQzoneNotWatch() {
        return this.qzoneNotWatch;
    }

    public Boolean getQzoneNotWatched() {
        return this.qzoneNotWatched;
    }

    public UserPermission(long j3, String str, Boolean bool, Boolean bool2, Boolean bool3) {
        this.friendUin = j3;
        this.friendUid = str;
        this.onlyChat = bool;
        this.qzoneNotWatch = bool2;
        this.qzoneNotWatched = bool3;
    }
}
