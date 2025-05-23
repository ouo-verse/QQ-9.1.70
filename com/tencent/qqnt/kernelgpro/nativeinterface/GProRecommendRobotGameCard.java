package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProRecommendRobotGameCard implements Serializable {
    public GProRecommendRobotInfo robotInfo;
    public ArrayList<GProRecommendRobotTextChannel> robotTextChannel;
    long serialVersionUID;

    public GProRecommendRobotGameCard() {
        this.serialVersionUID = 1L;
        this.robotInfo = new GProRecommendRobotInfo();
        this.robotTextChannel = new ArrayList<>();
    }

    public GProRecommendRobotInfo getRobotInfo() {
        return this.robotInfo;
    }

    public ArrayList<GProRecommendRobotTextChannel> getRobotTextChannel() {
        return this.robotTextChannel;
    }

    public String toString() {
        return "GProRecommendRobotGameCard{robotInfo=" + this.robotInfo + ",robotTextChannel=" + this.robotTextChannel + ",}";
    }

    public GProRecommendRobotGameCard(GProRecommendRobotInfo gProRecommendRobotInfo, ArrayList<GProRecommendRobotTextChannel> arrayList) {
        this.serialVersionUID = 1L;
        this.robotInfo = new GProRecommendRobotInfo();
        new ArrayList();
        this.robotInfo = gProRecommendRobotInfo;
        this.robotTextChannel = arrayList;
    }
}
