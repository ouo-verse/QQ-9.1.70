package com.tencent.mobileqq.ar.model;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ArDownloadInfo extends Entity {
    public int dailyRetryCount;
    public long dailyStartTime;

    @unique
    public String md5;
    public int totalRetryCount;

    public String toString() {
        return "ArDownloadInfo{md5='" + this.md5 + "', dailyRetryCount=" + this.dailyRetryCount + ", dailyStartTime=" + this.dailyStartTime + ", totalRetryCount=" + this.totalRetryCount + '}';
    }
}
