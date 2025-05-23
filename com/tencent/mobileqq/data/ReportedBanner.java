package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ReportedBanner extends Entity {

    @unique
    public long cid;
    public long endtime;
    public String md5;
}
