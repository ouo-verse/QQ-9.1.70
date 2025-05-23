package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGuildRobotPlusPanelRsp {
    public int nextPage;
    public ArrayList<GProGuildRobotPlusPanelFeature> plusPanelFeatures;

    public GProGuildRobotPlusPanelRsp() {
        this.plusPanelFeatures = new ArrayList<>();
    }

    public int getNextPage() {
        return this.nextPage;
    }

    public ArrayList<GProGuildRobotPlusPanelFeature> getPlusPanelFeatures() {
        return this.plusPanelFeatures;
    }

    public String toString() {
        return "GProGuildRobotPlusPanelRsp{plusPanelFeatures=" + this.plusPanelFeatures + ",nextPage=" + this.nextPage + ",}";
    }

    public GProGuildRobotPlusPanelRsp(ArrayList<GProGuildRobotPlusPanelFeature> arrayList, int i3) {
        new ArrayList();
        this.plusPanelFeatures = arrayList;
        this.nextPage = i3;
    }
}
