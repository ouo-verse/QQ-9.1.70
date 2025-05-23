package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProCheckInNotifyInfo {
    public long guildId;

    /* renamed from: msg, reason: collision with root package name */
    public String f359284msg = "";

    public long getGuildId() {
        return this.guildId;
    }

    public String getMsg() {
        return this.f359284msg;
    }

    public String toString() {
        return "GProCheckInNotifyInfo{guildId=" + this.guildId + ",msg=" + this.f359284msg + ",}";
    }
}
