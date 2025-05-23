package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class MutualMark {
    public Integer closeFlag;
    public long continueDays;
    public float count;
    public ResourceInfo gradeResourceInfo;
    public boolean hasRemindInContact;
    public String iconFormat;
    public long iconStatus;
    public Long iconStatusEndTime;
    public String iconUrl;
    public boolean isWearing;
    public long lastActionTime;
    public Long lastChangTime;
    public long level;
    public long lightUpTime;
    public long markFlag;
    public Integer markVersion;
    public String maxVersion;
    public String minVersion;
    public int orderNum;
    public Long remindAnimStartTime;
    public ResourceInfo resourceInfo;
    public String strCluster;
    public long subLevel;
    public long type;

    public MutualMark() {
    }

    public Integer getCloseFlag() {
        return this.closeFlag;
    }

    public long getContinueDays() {
        return this.continueDays;
    }

    public float getCount() {
        return this.count;
    }

    public ResourceInfo getGradeResourceInfo() {
        return this.gradeResourceInfo;
    }

    public boolean getHasRemindInContact() {
        return this.hasRemindInContact;
    }

    public String getIconFormat() {
        return this.iconFormat;
    }

    public long getIconStatus() {
        return this.iconStatus;
    }

    public Long getIconStatusEndTime() {
        return this.iconStatusEndTime;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public boolean getIsWearing() {
        return this.isWearing;
    }

    public long getLastActionTime() {
        return this.lastActionTime;
    }

    public Long getLastChangTime() {
        return this.lastChangTime;
    }

    public long getLevel() {
        return this.level;
    }

    public long getLightUpTime() {
        return this.lightUpTime;
    }

    public long getMarkFlag() {
        return this.markFlag;
    }

    public Integer getMarkVersion() {
        return this.markVersion;
    }

    public String getMaxVersion() {
        return this.maxVersion;
    }

    public String getMinVersion() {
        return this.minVersion;
    }

    public int getOrderNum() {
        return this.orderNum;
    }

    public Long getRemindAnimStartTime() {
        return this.remindAnimStartTime;
    }

    public ResourceInfo getResourceInfo() {
        return this.resourceInfo;
    }

    public String getStrCluster() {
        return this.strCluster;
    }

    public long getSubLevel() {
        return this.subLevel;
    }

    public long getType() {
        return this.type;
    }

    public MutualMark(long j3, long j16, long j17, float f16, long j18, long j19, long j26, long j27, Long l3, Integer num, String str, ResourceInfo resourceInfo, ResourceInfo resourceInfo2, String str2, String str3, String str4, Integer num2, long j28, boolean z16, String str5, int i3, Long l16, boolean z17, Long l17) {
        this.markFlag = j3;
        this.type = j16;
        this.level = j17;
        this.count = f16;
        this.continueDays = j18;
        this.lastActionTime = j19;
        this.iconStatus = j26;
        this.subLevel = j27;
        this.iconStatusEndTime = l3;
        this.closeFlag = num;
        this.strCluster = str;
        this.resourceInfo = resourceInfo;
        this.gradeResourceInfo = resourceInfo2;
        this.minVersion = str2;
        this.maxVersion = str3;
        this.iconUrl = str4;
        this.markVersion = num2;
        this.lightUpTime = j28;
        this.isWearing = z16;
        this.iconFormat = str5;
        this.orderNum = i3;
        this.lastChangTime = l16;
        this.hasRemindInContact = z17;
        this.remindAnimStartTime = l17;
    }
}
