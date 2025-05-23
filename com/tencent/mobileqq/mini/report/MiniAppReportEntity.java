package com.tencent.mobileqq.mini.report;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppReportEntity extends Entity implements Serializable {
    public String appId;
    public String appType;

    @unique
    public String launchId;
    public String subActionType;
    public String verType;

    public MiniAppReportEntity() {
    }

    public String toString() {
        return "launchId: " + this.launchId + ", appId: " + this.appId + ", subActionType: " + this.subActionType + ", appType: " + this.appType + ", verType: " + this.verType;
    }

    public MiniAppReportEntity(String str, String str2, String str3, String str4, String str5) {
        this.launchId = str;
        this.appId = str2;
        this.subActionType = str3;
        this.appType = str4;
        this.verType = str5;
    }
}
