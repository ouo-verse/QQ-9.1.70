package com.tencent.mobileqq.mini.apkgEntity;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppShowInfoEntity extends Entity {

    @unique
    public String appId;
    public String appName;
    public String desc;
    public int engineType;
    public String gameApprovalNumber;
    public String gameCopyrightInfo;
    public String gameOperatingCompany;
    public String gamePublicationCompany;
    public String gamePublicationNumber;
    public String gameRegistrationNumber;
    public String icon;
    public boolean interMode;
    public int miniAppType;
    public int reportType;
    public long timeStamp;

    public String toString() {
        return "MiniAppShowInfoEntity{appId='" + this.appId + "', appName='" + this.appName + "', icon='" + this.icon + "', desc='" + this.desc + "', reportType=" + this.reportType + ", engineType=" + this.engineType + ", interMode=" + this.interMode + ", timeStamp='" + this.timeStamp + "', miniAppType='" + this.miniAppType + "', gameRegistrationNumber='" + this.gameRegistrationNumber + "'}";
    }
}
