package com.tencent.biz.pubaccount.accountdetail.api.impl;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

/* loaded from: classes32.dex */
public class PublicAccountDynamicInfoEntityImpl extends Entity {
    public byte[] dynamicInfoData = null;

    @unique
    public String puin;
}
