package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class RobotRecommendCardsRsp {
    public boolean haveNextPage;
    public boolean isRefresh;
    public byte[] pagingCookie = new byte[0];
    public String dataVersion = "";
    public RobotTabInfo tabInfo = new RobotTabInfo();
    public ArrayList<RobotTabInfo> tabs = new ArrayList<>();
    public ArrayList<RobotRecommendCard> cards = new ArrayList<>();
    public ArrayList<RobotGuideInfo> guides = new ArrayList<>();

    public ArrayList<RobotRecommendCard> getCards() {
        return this.cards;
    }

    public String getDataVersion() {
        return this.dataVersion;
    }

    public ArrayList<RobotGuideInfo> getGuides() {
        return this.guides;
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

    public RobotTabInfo getTabInfo() {
        return this.tabInfo;
    }

    public ArrayList<RobotTabInfo> getTabs() {
        return this.tabs;
    }
}
