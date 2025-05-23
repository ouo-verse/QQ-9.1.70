package com.tencent.mobileqq.mini.entry;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MiniAppLocalSearchEntity extends Entity implements Serializable {

    @unique
    public String appId;
    public String appName;
    public String desc;
    public String iconUrl;
    public int miniAppType;
    public String miniIconUrl;
    public int reportType;
    public String schema;
    public int showMask;

    public MiniAppLocalSearchEntity() {
    }

    public String toString() {
        return "appId: " + this.appId + ", appName: " + this.appName + ", iconUrl: " + this.iconUrl + ", showMask: " + this.showMask + ", miniAppType: " + this.miniAppType + ", miniIconUrl: " + this.miniIconUrl + ", schema: " + this.schema;
    }

    public MiniAppLocalSearchEntity(String str, String str2, String str3, String str4, int i3, int i16, String str5, String str6) {
        this.appId = str;
        this.appName = str2;
        this.iconUrl = str3;
        this.desc = str4;
        this.showMask = i3;
        this.miniAppType = i16;
        this.schema = str5;
        this.miniIconUrl = str6;
    }
}
