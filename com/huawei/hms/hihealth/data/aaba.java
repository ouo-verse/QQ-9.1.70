package com.huawei.hms.hihealth.data;

import android.os.Parcelable;
import com.huawei.hms.health.aabq;
import com.huawei.hms.health.aabv;
import com.huawei.hms.health.aabw;
import com.huawei.hms.health.aaby;

/* compiled from: P */
/* loaded from: classes2.dex */
public class aaba extends aabq {
    public static final Parcelable.Creator<aaba> CREATOR = new aabq.aab(aaba.class);

    @aaby(id = 1)
    private int aab;

    @aaby(id = 2)
    private int aaba;

    @aaby(id = 3)
    private int aabb;

    @aabw
    public aaba(@aabv(id = 1) int i3, @aabv(id = 2) int i16, @aabv(id = 3) int i17) {
        this.aab = i3;
        this.aaba = i16;
        this.aabb = i17;
    }

    public int aab() {
        return this.aabb;
    }

    public int aaba() {
        return this.aaba;
    }

    public int aabb() {
        return this.aab;
    }

    public String toString() {
        StringBuilder aab = com.huawei.hms.health.aab.aab("FlowControlPolicy{timeRange=");
        aab.append(this.aab);
        aab.append(", threshold=");
        aab.append(this.aaba);
        aab.append(", limitTimes=");
        aab.append(this.aabb);
        aab.append('}');
        return aab.toString();
    }
}
