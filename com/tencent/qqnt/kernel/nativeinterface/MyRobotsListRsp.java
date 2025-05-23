package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class MyRobotsListRsp {
    public boolean haveNextPage;
    public boolean isRefresh;
    public long selfUin;
    public byte[] pagingCookie = new byte[0];
    public String dataVersion = "";
    public RobotSummary summary = new RobotSummary();
    public ArrayList<MyRobotListInfo> robots = new ArrayList<>();
    public String selfUid = "";
    public String selfNick = "";
    public RobotActivity robotActivity = new RobotActivity();

    public String getDataVersion() {
        return this.dataVersion;
    }

    public boolean getHaveNextPage() {
        return this.haveNextPage;
    }

    public boolean getIsRefresh() {
        return this.isRefresh;
    }

    public byte[] getPagingCookie() {
        return this.pagingCookie;
    }

    public RobotActivity getRobotActivity() {
        return this.robotActivity;
    }

    public ArrayList<MyRobotListInfo> getRobots() {
        return this.robots;
    }

    public String getSelfNick() {
        return this.selfNick;
    }

    public String getSelfUid() {
        return this.selfUid;
    }

    public long getSelfUin() {
        return this.selfUin;
    }

    public RobotSummary getSummary() {
        return this.summary;
    }
}
