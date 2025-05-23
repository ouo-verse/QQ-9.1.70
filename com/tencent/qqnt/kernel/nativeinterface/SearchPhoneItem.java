package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class SearchPhoneItem {
    public int count;
    public boolean didReportDisplay;
    public boolean isQidianMaster;
    public int resultIndex;
    public long time;
    public int type;
    public String key = "";
    public String uin = "";
    public String troopUin = "";
    public String displayName = "";
    public String extraInfo = "";
    public String subText = "";
    public String typeText = "";

    public int getCount() {
        return this.count;
    }

    public boolean getDidReportDisplay() {
        return this.didReportDisplay;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getExtraInfo() {
        return this.extraInfo;
    }

    public boolean getIsQidianMaster() {
        return this.isQidianMaster;
    }

    public String getKey() {
        return this.key;
    }

    public int getResultIndex() {
        return this.resultIndex;
    }

    public String getSubText() {
        return this.subText;
    }

    public long getTime() {
        return this.time;
    }

    public String getTroopUin() {
        return this.troopUin;
    }

    public int getType() {
        return this.type;
    }

    public String getTypeText() {
        return this.typeText;
    }

    public String getUin() {
        return this.uin;
    }

    public String toString() {
        return "SearchPhoneItem{key=" + this.key + ",type=" + this.type + ",uin=" + this.uin + ",troopUin=" + this.troopUin + ",displayName=" + this.displayName + ",extraInfo=" + this.extraInfo + ",count=" + this.count + ",time=" + this.time + ",isQidianMaster=" + this.isQidianMaster + ",resultIndex=" + this.resultIndex + ",didReportDisplay=" + this.didReportDisplay + ",subText=" + this.subText + ",typeText=" + this.typeText + ",}";
    }
}
