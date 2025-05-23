package com.tencent.mobileqq.mini.entity;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

/* compiled from: P */
/* loaded from: classes33.dex */
public class AppDetainRecordEntity extends Entity {

    @unique
    public String appId;
    public int showTimes = 0;
    public long timestamp = 0;

    public String toString() {
        return "TempEntity{appId=" + this.appId + ", showTimes=" + this.showTimes + ", timestamp=" + this.timestamp + '}';
    }
}
