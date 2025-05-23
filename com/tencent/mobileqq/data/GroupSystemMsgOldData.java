package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

/* compiled from: P */
/* loaded from: classes10.dex */
public class GroupSystemMsgOldData extends Entity {
    public long msgtime;

    @unique
    public long uin;
}
