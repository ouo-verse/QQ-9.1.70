package com.tencent.mobileqq.mini.entity;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

/* compiled from: P */
/* loaded from: classes33.dex */
public class AppBubbleRecordEntity extends Entity {

    @unique
    public String appId;
    public int showTimes = 0;
    public long timestamp = 0;
    public String text = "";
    public int clickCount = 1;

    public boolean shouldShowAppBubble() {
        return this.showTimes < this.clickCount;
    }

    public String toString() {
        return getClass().getSimpleName() + "{appId=" + this.appId + ", showTimes=" + this.showTimes + ", timestamp=" + this.timestamp + ", text=" + this.text + ", clickCount=" + this.clickCount + '}';
    }
}
