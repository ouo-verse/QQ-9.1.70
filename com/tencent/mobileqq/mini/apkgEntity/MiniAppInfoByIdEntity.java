package com.tencent.mobileqq.mini.apkgEntity;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.REPLACE, columnNames = "appId,entryPath")
/* loaded from: classes33.dex */
public class MiniAppInfoByIdEntity extends Entity {
    public String appId;
    public byte[] appInfo;
    public String entryPath;
    public long timeStamp;

    public String toString() {
        return "MiniAppInfoByIdEntity{appId='" + this.appId + "'entryPath='" + this.entryPath + "', timeStamp='" + this.timeStamp + "'}";
    }
}
