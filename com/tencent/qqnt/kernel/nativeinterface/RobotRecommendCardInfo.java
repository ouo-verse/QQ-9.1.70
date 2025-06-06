package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class RobotRecommendCardInfo {
    public String cardId = "";
    public String name = "";
    public String desc = "";
    public String jumpUrl = "";
    public ArrayList<RobotCoreInfo> robots = new ArrayList<>();
    public RobotRecommendCardInfoType type = RobotRecommendCardInfoType.values()[0];

    public String getCardId() {
        return this.cardId;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getJumpUrl() {
        return this.jumpUrl;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<RobotCoreInfo> getRobots() {
        return this.robots;
    }

    public RobotRecommendCardInfoType getType() {
        return this.type;
    }
}
