package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

/* compiled from: P */
/* loaded from: classes10.dex */
public class OfflineWebRes extends Entity {
    public String bid;
    public String fileName;
    public String hashName;
    public int hitCount = 1;

    @unique
    public String md5;
}
