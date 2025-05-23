package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGuildRobotInlineLayout {
    public int action;
    public ArrayList<GProGuildRobotInlineLayoutData> layoutDataList;
    public String title;
    public int type;

    public GProGuildRobotInlineLayout() {
        this.title = "";
        this.layoutDataList = new ArrayList<>();
    }

    public int getAction() {
        return this.action;
    }

    public ArrayList<GProGuildRobotInlineLayoutData> getLayoutDataList() {
        return this.layoutDataList;
    }

    public String getTitle() {
        return this.title;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "GProGuildRobotInlineLayout{type=" + this.type + ",action=" + this.action + ",title=" + this.title + ",layoutDataList=" + this.layoutDataList + ",}";
    }

    public GProGuildRobotInlineLayout(int i3, int i16, String str, ArrayList<GProGuildRobotInlineLayoutData> arrayList) {
        this.title = "";
        new ArrayList();
        this.type = i3;
        this.action = i16;
        this.title = str;
        this.layoutDataList = arrayList;
    }
}
