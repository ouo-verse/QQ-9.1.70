package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;

/* compiled from: P */
/* loaded from: classes10.dex */
public class Sqlite extends Entity {
    public String tbl_name;

    @Override // com.tencent.mobileqq.persistence.Entity
    public String getTableName() {
        return "Sqlite_master";
    }
}
