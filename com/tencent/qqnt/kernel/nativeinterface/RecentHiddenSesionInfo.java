package com.tencent.qqnt.kernel.nativeinterface;

import com.tencent.smtt.sdk.stat.MttLoader;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class RecentHiddenSesionInfo {
    public int chatType;
    public boolean isHidden;
    public boolean isPushAVOnlineNotify;
    public boolean isPushOnlineNotify;
    public long msgTime;
    public String peerUid;
    public String peerUin;
    public long version;

    public RecentHiddenSesionInfo() {
        this.peerUid = "";
        this.peerUin = "";
    }

    public int getChatType() {
        return this.chatType;
    }

    public boolean getIsHidden() {
        return this.isHidden;
    }

    public boolean getIsPushAVOnlineNotify() {
        return this.isPushAVOnlineNotify;
    }

    public boolean getIsPushOnlineNotify() {
        return this.isPushOnlineNotify;
    }

    public long getMsgTime() {
        return this.msgTime;
    }

    public String getPeerUid() {
        return this.peerUid;
    }

    public String getPeerUin() {
        return this.peerUin;
    }

    public long getVersion() {
        return this.version;
    }

    public String toString() {
        return "RecentHiddenSesionInfo{peerUid=" + this.peerUid + ",peerUin=" + this.peerUin + ",chatType=" + this.chatType + ",isHidden=" + this.isHidden + ",isPushOnlineNotify=" + this.isPushOnlineNotify + ",isPushAVOnlineNotify=" + this.isPushAVOnlineNotify + ",msgTime=" + this.msgTime + MttLoader.QQBROWSER_PARAMS_VERSION + this.version + ",}";
    }

    public RecentHiddenSesionInfo(String str, String str2, int i3, boolean z16, boolean z17, boolean z18, long j3, long j16) {
        this.peerUid = str;
        this.peerUin = str2;
        this.chatType = i3;
        this.isHidden = z16;
        this.isPushOnlineNotify = z17;
        this.isPushAVOnlineNotify = z18;
        this.msgTime = j3;
        this.version = j16;
    }
}
