package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupRobotQzoneInfo {
    public boolean hasOpenQQZone;
    public String updateTipsString = "";
    public String jumpUrl = "";
    public ArrayList<GroupRobotQzoneData> imageList = new ArrayList<>();

    public boolean getHasOpenQQZone() {
        return this.hasOpenQQZone;
    }

    public ArrayList<GroupRobotQzoneData> getImageList() {
        return this.imageList;
    }

    public String getJumpUrl() {
        return this.jumpUrl;
    }

    public String getUpdateTipsString() {
        return this.updateTipsString;
    }

    public String toString() {
        return "GroupRobotQzoneInfo{updateTipsString=" + this.updateTipsString + ",jumpUrl=" + this.jumpUrl + ",hasOpenQQZone=" + this.hasOpenQQZone + ",imageList=" + this.imageList + ",}";
    }
}
