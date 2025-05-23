package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGuildCreatorTaskInfo {
    public int finishedCnt;
    public boolean isAllFinished;
    public int skipStatus;
    public ArrayList<GProTaskInfo> tasks;
    public int totalCnt;

    public GProGuildCreatorTaskInfo() {
        this.tasks = new ArrayList<>();
    }

    public int getFinishedCnt() {
        return this.finishedCnt;
    }

    public boolean getIsAllFinished() {
        return this.isAllFinished;
    }

    public int getSkipStatus() {
        return this.skipStatus;
    }

    public ArrayList<GProTaskInfo> getTasks() {
        return this.tasks;
    }

    public int getTotalCnt() {
        return this.totalCnt;
    }

    public String toString() {
        return "GProGuildCreatorTaskInfo{skipStatus=" + this.skipStatus + ",isAllFinished=" + this.isAllFinished + ",finishedCnt=" + this.finishedCnt + ",totalCnt=" + this.totalCnt + ",tasks=" + this.tasks + ",}";
    }

    public GProGuildCreatorTaskInfo(int i3, boolean z16, int i16, int i17, ArrayList<GProTaskInfo> arrayList) {
        new ArrayList();
        this.skipStatus = i3;
        this.isAllFinished = z16;
        this.finishedCnt = i16;
        this.totalCnt = i17;
        this.tasks = arrayList;
    }
}
