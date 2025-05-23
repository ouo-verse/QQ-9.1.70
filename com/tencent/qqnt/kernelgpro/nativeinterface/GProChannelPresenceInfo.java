package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProChannelPresenceInfo {
    public ArrayList<GProChannelPresenceItemInfo> itemList = new ArrayList<>();
    public long playSpeed;
    public int templateId;

    public ArrayList<GProChannelPresenceItemInfo> getItemList() {
        return this.itemList;
    }

    public long getPlaySpeed() {
        return this.playSpeed;
    }

    public int getTemplateId() {
        return this.templateId;
    }

    public String toString() {
        return "GProChannelPresenceInfo{templateId=" + this.templateId + ",itemList=" + this.itemList + ",playSpeed=" + this.playSpeed + ",}";
    }
}
