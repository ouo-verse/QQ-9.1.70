package com.tencent.mobileqq.mini.apkgEntity;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppInfoEntity extends Entity {
    public static final String TAG = "MiniAppInfoEntity";

    @unique
    public String appId;
    public byte[] appInfo;
    public long timeStamp;

    public String toString() {
        return "MiniAppInfoEntity{appId='" + this.appId + "', timeStamp='" + this.timeStamp + "'}";
    }
}
