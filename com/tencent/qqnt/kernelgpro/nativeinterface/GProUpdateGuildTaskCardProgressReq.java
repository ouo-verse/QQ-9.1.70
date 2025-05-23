package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProUpdateGuildTaskCardProgressReq {
    public long guildId;
    public ArrayList<GProGuildTaskCardUpdateProgress> tasksList = new ArrayList<>();

    public long getGuildId() {
        return this.guildId;
    }

    public ArrayList<GProGuildTaskCardUpdateProgress> getTasksList() {
        return this.tasksList;
    }

    public String toString() {
        return "GProUpdateGuildTaskCardProgressReq{guildId=" + this.guildId + ",tasksList=" + this.tasksList + ",}";
    }
}
