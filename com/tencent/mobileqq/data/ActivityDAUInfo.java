package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ActivityDAUInfo extends Entity {

    @unique
    public String activityName;
    public int count;
    public int displayCount;
    public String domain;
    public String pageName;
    public String preActivityList;
    public String reportVersion;
    public long showTime;
    public String webTitle;
}
