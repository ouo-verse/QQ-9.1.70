package com.tencent.mobileqq.mini.apkgEntity;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import java.util.Arrays;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.REPLACE, columnNames = "appId,entryPath")
@Deprecated
/* loaded from: classes33.dex */
public class MiniAppByIdEntity extends Entity {
    public String appId;
    public String entryPath;
    public String extData;
    public byte[] extInfo;
    public String extendData;
    public byte[] first;
    public byte[] mDebug;
    public byte[] operInfo;
    public String shareTicket;
    public long timeStamp;

    public String toString() {
        return "MiniAppByIdEntity{appId='" + this.appId + "', entryPath='" + this.entryPath + "', timeStamp='" + this.timeStamp + "', shareTicket='" + this.shareTicket + "', first=" + Arrays.toString(this.first) + ", mDebug=" + Arrays.toString(this.mDebug) + ", extData='" + this.extData + "', operInfo=" + Arrays.toString(this.operInfo) + ", extInfo=" + Arrays.toString(this.extInfo) + ", extendData='" + this.extendData + "'}";
    }
}
