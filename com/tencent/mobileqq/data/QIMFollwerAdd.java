package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

/* compiled from: P */
/* loaded from: classes10.dex */
public class QIMFollwerAdd extends Entity {
    public int opType = 1;

    @unique
    public long uin = 0;
    public int gender = -1;
    public String smartRemark = "";
    public String longNick = "";
    public long totalNum = 0;
    public long careSCount = 0;
    public long fansCount = 0;
    public long upTime = 0;
    public boolean isRead = false;
    public String source = "";
}
