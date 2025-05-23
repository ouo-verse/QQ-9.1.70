package com.tencent.mobileqq.vas.updatesystem.db.entity;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

/* compiled from: P */
/* loaded from: classes20.dex */
public class LocalFileMd5Entity extends Entity {
    public static final String TABLE_NAME = "LocalFileMd5Entity";
    public String mContent;

    @unique
    public String mItemId;

    public String toString() {
        return "LocalFileMd5Entity{itemId='" + this.mItemId + "', mContent='" + this.mContent + "'}";
    }
}
