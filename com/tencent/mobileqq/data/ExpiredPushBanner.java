package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

/* loaded from: classes10.dex */
public class ExpiredPushBanner extends Entity {

    @unique
    public long cid;
    public long endtime;
    public String md5;
}
