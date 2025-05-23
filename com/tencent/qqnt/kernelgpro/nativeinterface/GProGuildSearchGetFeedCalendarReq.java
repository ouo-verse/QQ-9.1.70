package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGuildSearchGetFeedCalendarReq {
    public long guildId;
    public ArrayList<String> months = new ArrayList<>();

    public long getGuildId() {
        return this.guildId;
    }

    public ArrayList<String> getMonths() {
        return this.months;
    }

    public String toString() {
        return "GProGuildSearchGetFeedCalendarReq{guildId=" + this.guildId + ",months=" + this.months + ",}";
    }
}
