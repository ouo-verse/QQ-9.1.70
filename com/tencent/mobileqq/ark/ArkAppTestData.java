package com.tencent.mobileqq.ark;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ArkAppTestData extends Entity {
    public long date;

    @unique
    public String name;
    public String value;
}
