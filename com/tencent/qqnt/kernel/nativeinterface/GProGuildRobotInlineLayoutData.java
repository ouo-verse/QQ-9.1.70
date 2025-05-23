package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGuildRobotInlineLayoutData {
    public String actionData;
    public GProGuildRobotInlineRenderData renderData;

    public GProGuildRobotInlineLayoutData() {
        this.actionData = "";
        this.renderData = new GProGuildRobotInlineRenderData();
    }

    public String getActionData() {
        return this.actionData;
    }

    public GProGuildRobotInlineRenderData getRenderData() {
        return this.renderData;
    }

    public String toString() {
        return "GProGuildRobotInlineLayoutData{actionData=" + this.actionData + ",renderData=" + this.renderData + ",}";
    }

    public GProGuildRobotInlineLayoutData(String str, GProGuildRobotInlineRenderData gProGuildRobotInlineRenderData) {
        this.actionData = "";
        new GProGuildRobotInlineRenderData();
        this.actionData = str;
        this.renderData = gProGuildRobotInlineRenderData;
    }
}
