package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class ListRobotRsp {
    public boolean haveNextPage;
    public boolean isPoolRefresh;
    public int maxRobotNum;
    public ArrayList<GroupRobotInfoFor0x91ee> tabRobots = new ArrayList<>();
    public GroupTabInfo tabInfo = new GroupTabInfo();
    public ArrayList<GroupRobotInfoFor0x91ee> addedRobots = new ArrayList<>();
    public byte[] rspPagingCookie = new byte[0];
    public String dataVersion = "";

    public ArrayList<GroupRobotInfoFor0x91ee> getAddedRobots() {
        return this.addedRobots;
    }

    public String getDataVersion() {
        return this.dataVersion;
    }

    public boolean getHaveNextPage() {
        return this.haveNextPage;
    }

    public boolean getIsPoolRefresh() {
        return this.isPoolRefresh;
    }

    public int getMaxRobotNum() {
        return this.maxRobotNum;
    }

    public byte[] getRspPagingCookie() {
        return this.rspPagingCookie;
    }

    public GroupTabInfo getTabInfo() {
        return this.tabInfo;
    }

    public ArrayList<GroupRobotInfoFor0x91ee> getTabRobots() {
        return this.tabRobots;
    }

    public String toString() {
        return "ListRobotRsp{tabRobots=" + this.tabRobots + ",tabInfo=" + this.tabInfo + ",addedRobots=" + this.addedRobots + ",maxRobotNum=" + this.maxRobotNum + ",rspPagingCookie=" + this.rspPagingCookie + ",haveNextPage=" + this.haveNextPage + ",dataVersion=" + this.dataVersion + ",isPoolRefresh=" + this.isPoolRefresh + ",}";
    }
}
