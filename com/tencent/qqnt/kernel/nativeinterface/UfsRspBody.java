package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class UfsRspBody {
    public boolean containMaskedWord;
    public int exhibitionFlags;
    public int isEndTopic;
    public boolean isHidePersonGroupSearchNode;
    public float kwTimeliness;
    public int resultCode;
    public int triggerNetwordNum;
    public String errorMsg = "";
    public ArrayList<UfsResultItemGroup> itemGroups = new ArrayList<>();
    public ArrayList<UfsTabItemGroup> tabGroups = new ArrayList<>();
    public byte[] cookieTopic = new byte[0];
    public byte[] searchVer = new byte[0];
    public ArrayList<UfsSearchBusiSortInfo> searchBusiSortInfos = new ArrayList<>();

    public boolean getContainMaskedWord() {
        return this.containMaskedWord;
    }

    public byte[] getCookieTopic() {
        return this.cookieTopic;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public int getExhibitionFlags() {
        return this.exhibitionFlags;
    }

    public int getIsEndTopic() {
        return this.isEndTopic;
    }

    public boolean getIsHidePersonGroupSearchNode() {
        return this.isHidePersonGroupSearchNode;
    }

    public ArrayList<UfsResultItemGroup> getItemGroups() {
        return this.itemGroups;
    }

    public float getKwTimeliness() {
        return this.kwTimeliness;
    }

    public int getResultCode() {
        return this.resultCode;
    }

    public ArrayList<UfsSearchBusiSortInfo> getSearchBusiSortInfos() {
        return this.searchBusiSortInfos;
    }

    public byte[] getSearchVer() {
        return this.searchVer;
    }

    public ArrayList<UfsTabItemGroup> getTabGroups() {
        return this.tabGroups;
    }

    public int getTriggerNetwordNum() {
        return this.triggerNetwordNum;
    }

    public String toString() {
        return "UfsRspBody{resultCode=" + this.resultCode + ",errorMsg=" + this.errorMsg + ",itemGroups=" + this.itemGroups + ",tabGroups=" + this.tabGroups + ",isEndTopic=" + this.isEndTopic + ",cookieTopic=" + this.cookieTopic + ",searchVer=" + this.searchVer + ",triggerNetwordNum=" + this.triggerNetwordNum + ",kwTimeliness=" + this.kwTimeliness + ",exhibitionFlags=" + this.exhibitionFlags + ",containMaskedWord=" + this.containMaskedWord + ",isHidePersonGroupSearchNode=" + this.isHidePersonGroupSearchNode + ",searchBusiSortInfos=" + this.searchBusiSortInfos + ",}";
    }
}
