package com.tencent.mobileqq.mini.entity;

import com.tencent.mobileqq.persistence.Entity;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniGameStartupReportEntity extends Entity {
    public String adFlag;
    public long apkgSize;
    public String apkgState;
    public String appId;
    public int appInfoFlag;
    public int appType;
    public String eventName;
    public String extReportData;
    public String gameEngineFlag;
    public String mode;
    public long occurredTime;
    public String preloadFlag;
    public long relativeTime;
    public String startupFlag;
    public String startupId;
    public int startupScene;
    public String versionId;
    public int versionType;
    public String via;

    public String toString() {
        return "MiniGameStartupReportEntity{startupId='" + this.startupId + "', appId='" + this.appId + "', startupScene=" + this.startupScene + ", occurredTime=" + this.occurredTime + ", eventName='" + this.eventName + "', relativeTime=" + this.relativeTime + ", appInfoFlag=" + this.appInfoFlag + ", gameEngineFlag='" + this.gameEngineFlag + "', startupFlag='" + this.startupFlag + "', preloadFlag='" + this.preloadFlag + "', adFlag='" + this.adFlag + "', apkgState='" + this.apkgState + "', apkgSize=" + this.apkgSize + ", appType=" + this.appType + ", versionType=" + this.versionType + ", versionId=" + this.versionId + ", via=" + this.via + ", mode=" + this.mode + ", extReportData=" + this.extReportData + '}';
    }
}
