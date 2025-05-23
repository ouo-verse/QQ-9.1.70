package com.tencent.mobileqq.vas.updatesystem.db.entity;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

/* compiled from: P */
/* loaded from: classes20.dex */
public class LocalUpdateEntity extends Entity {
    public static final String TABLE_NAME = "LocalUpdateEntity";
    public String mContent;

    @unique
    public String mItemId;

    public String toString() {
        return "LocalUpdateEntity{itemId='" + this.mItemId + "', mContent='" + this.mContent + "'}";
    }
}
