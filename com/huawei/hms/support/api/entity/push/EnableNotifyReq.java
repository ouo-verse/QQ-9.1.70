package com.huawei.hms.support.api.entity.push;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* compiled from: P */
/* loaded from: classes2.dex */
public class EnableNotifyReq implements IMessageEntity {

    @Packed
    public boolean enable;

    @Packed
    public String packageName;

    public String getPackageName() {
        return this.packageName;
    }

    public boolean isEnable() {
        return this.enable;
    }

    public void setEnable(boolean z16) {
        this.enable = z16;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public String toString() {
        return "EnableNotifyReq{packageName='" + this.packageName + "', enable=" + this.enable + '}';
    }
}
