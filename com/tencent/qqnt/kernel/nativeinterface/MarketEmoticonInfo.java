package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class MarketEmoticonInfo {
    public int businessId;
    public int result;
    public int segmentFlag;
    public int timeStamp;
    public RoamEmojiTab roamEmojiTab = new RoamEmojiTab();
    public ArrayList<CommonTabEmojiInfo> emojiNewTabs = new ArrayList<>();

    public int getBusinessId() {
        return this.businessId;
    }

    public ArrayList<CommonTabEmojiInfo> getEmojiNewTabs() {
        return this.emojiNewTabs;
    }

    public int getResult() {
        return this.result;
    }

    public RoamEmojiTab getRoamEmojiTab() {
        return this.roamEmojiTab;
    }

    public int getSegmentFlag() {
        return this.segmentFlag;
    }

    public int getTimeStamp() {
        return this.timeStamp;
    }

    public String toString() {
        return "MarketEmoticonInfo{timeStamp=" + this.timeStamp + ",segmentFlag=" + this.segmentFlag + ",result=" + this.result + ",businessId=" + this.businessId + ",roamEmojiTab=" + this.roamEmojiTab + ",emojiNewTabs=" + this.emojiNewTabs + ",}";
    }
}
