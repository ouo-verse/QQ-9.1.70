package com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground;

import com.tencent.aegiskmm.d;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.nearby.compose_base.geometry.Point;
import h35.a;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class UserActionMenuInfo {
    public final a barrage;
    public final long tid;
    public final Point userTopCenter;

    public UserActionMenuInfo(long j3, a aVar, Point point) {
        this.tid = j3;
        this.barrage = aVar;
        this.userTopCenter = point;
    }

    public final int hashCode() {
        int a16 = d.a(this.tid) * 31;
        a aVar = this.barrage;
        return this.userTopCenter.hashCode() + ((a16 + (aVar == null ? 0 : aVar.hashCode())) * 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("UserActionMenuInfo(tid=");
        m3.append(this.tid);
        m3.append(", barrage=");
        m3.append(this.barrage);
        m3.append(", userTopCenter=");
        m3.append(this.userTopCenter);
        m3.append(')');
        return m3.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserActionMenuInfo)) {
            return false;
        }
        UserActionMenuInfo userActionMenuInfo = (UserActionMenuInfo) obj;
        return this.tid == userActionMenuInfo.tid && Intrinsics.areEqual(this.barrage, userActionMenuInfo.barrage) && Intrinsics.areEqual(this.userTopCenter, userActionMenuInfo.userTopCenter);
    }
}
