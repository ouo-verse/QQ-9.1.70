package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGuildRobotCardRecommendRsp {
    public ArrayList<GProGuildRobotInfo> bots;
    public int maxRecommendIcon;
    public int moreNum;
    public long nextUpdateTimestamp;
    public String text;

    public GProGuildRobotCardRecommendRsp() {
        this.text = "";
        this.bots = new ArrayList<>();
    }

    public ArrayList<GProGuildRobotInfo> getBots() {
        return this.bots;
    }

    public int getMaxRecommendIcon() {
        return this.maxRecommendIcon;
    }

    public int getMoreNum() {
        return this.moreNum;
    }

    public long getNextUpdateTimestamp() {
        return this.nextUpdateTimestamp;
    }

    public String getText() {
        return this.text;
    }

    public String toString() {
        return "GProGuildRobotCardRecommendRsp{text=" + this.text + ",bots=" + this.bots + ",moreNum=" + this.moreNum + ",nextUpdateTimestamp=" + this.nextUpdateTimestamp + ",maxRecommendIcon=" + this.maxRecommendIcon + ",}";
    }

    public GProGuildRobotCardRecommendRsp(String str, ArrayList<GProGuildRobotInfo> arrayList, int i3, long j3, int i16) {
        this.text = "";
        new ArrayList();
        this.text = str;
        this.bots = arrayList;
        this.moreNum = i3;
        this.nextUpdateTimestamp = j3;
        this.maxRecommendIcon = i16;
    }
}
