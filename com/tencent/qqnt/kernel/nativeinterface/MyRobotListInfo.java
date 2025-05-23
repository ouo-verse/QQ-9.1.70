package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class MyRobotListInfo {
    public long robotUin;
    public String name = "";
    public String desc = "";
    public String uid = "";
    public String avatar = "";
    public RobotSummary summary = new RobotSummary();
    public RobotSummary sevenDaySummary = new RobotSummary();
    public RobotSummaryChangeRate summaryChangeRate = new RobotSummaryChangeRate();
    public ArrayList<RobotActivityLabel> robotActivityLabelList = new ArrayList<>();

    public String getAvatar() {
        return this.avatar;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<RobotActivityLabel> getRobotActivityLabelList() {
        return this.robotActivityLabelList;
    }

    public long getRobotUin() {
        return this.robotUin;
    }

    public RobotSummary getSevenDaySummary() {
        return this.sevenDaySummary;
    }

    public RobotSummary getSummary() {
        return this.summary;
    }

    public RobotSummaryChangeRate getSummaryChangeRate() {
        return this.summaryChangeRate;
    }

    public String getUid() {
        return this.uid;
    }
}
