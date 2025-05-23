package com.tencent.mobileqq.mini.entry;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes33.dex */
public class RecommendMiniAppEntity extends Entity implements Serializable {

    @unique
    public String appId;
    public String appName;
    public int recommendType;

    public RecommendMiniAppEntity() {
    }

    public String toString() {
        return "appId: " + this.appId + ", appName: " + this.appName + ", recommendType: " + this.recommendType;
    }

    public RecommendMiniAppEntity(String str, String str2, int i3) {
        this.appId = str;
        this.appName = str2;
        this.recommendType = i3;
    }
}
