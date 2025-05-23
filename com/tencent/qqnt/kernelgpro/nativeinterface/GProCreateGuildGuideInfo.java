package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProCreateGuildGuideInfo {
    public long guildId;
    public int skipStatus;
    public ArrayList<GProTaskInfo> taskList = new ArrayList<>();

    public long getGuildId() {
        return this.guildId;
    }

    public int getSkipStatus() {
        return this.skipStatus;
    }

    public ArrayList<GProTaskInfo> getTaskList() {
        return this.taskList;
    }

    public String toString() {
        return "GProCreateGuildGuideInfo{guildId=" + this.guildId + ",skipStatus=" + this.skipStatus + ",taskList=" + this.taskList + ",}";
    }
}
