package com.huawei.hms.hihealth.data;

import android.os.Parcelable;
import com.huawei.hms.health.aabq;
import com.huawei.hms.health.aabv;
import com.huawei.hms.health.aabw;
import com.huawei.hms.health.aaby;

/* compiled from: P */
/* loaded from: classes2.dex */
public class aabb extends aabq {
    public static final Parcelable.Creator<aabb> CREATOR = new aabq.aab(aabb.class);

    @aaby(id = 1)
    private String aab;

    @aaby(id = 2)
    private int aaba;

    @aabw
    public aabb(@aabv(id = 1) String str, @aabv(id = 2) int i3) {
        this.aab = str;
        this.aaba = i3;
    }

    public int aab() {
        return this.aaba;
    }

    public String aaba() {
        return this.aab;
    }

    public String toString() {
        StringBuilder aab = com.huawei.hms.health.aab.aab("InterfaceCachePolicy{interfaceName='");
        aab.append(this.aab);
        aab.append('\'');
        aab.append(", cacheTime=");
        aab.append(this.aaba);
        aab.append('\'');
        aab.append('}');
        return aab.toString();
    }
}
