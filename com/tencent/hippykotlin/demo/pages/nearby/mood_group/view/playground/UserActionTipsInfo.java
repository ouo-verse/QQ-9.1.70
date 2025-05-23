package com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground;

import com.tencent.aegiskmm.d;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.nearby.compose_base.geometry.Point;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class UserActionTipsInfo {
    public final long tid;
    public final String tipsIcon;
    public final String tipsMsg;
    public final Point userTopCenter;

    public UserActionTipsInfo(long j3, String str, String str2, Point point) {
        this.tid = j3;
        this.tipsIcon = str;
        this.tipsMsg = str2;
        this.userTopCenter = point;
    }

    public final int hashCode() {
        return this.userTopCenter.hashCode() + BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.tipsMsg, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.tipsIcon, d.a(this.tid) * 31, 31), 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("UserActionTipsInfo(tid=");
        m3.append(this.tid);
        m3.append(", tipsIcon=");
        m3.append(this.tipsIcon);
        m3.append(", tipsMsg=");
        m3.append(this.tipsMsg);
        m3.append(", userTopCenter=");
        m3.append(this.userTopCenter);
        m3.append(')');
        return m3.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserActionTipsInfo)) {
            return false;
        }
        UserActionTipsInfo userActionTipsInfo = (UserActionTipsInfo) obj;
        return this.tid == userActionTipsInfo.tid && Intrinsics.areEqual(this.tipsIcon, userActionTipsInfo.tipsIcon) && Intrinsics.areEqual(this.tipsMsg, userActionTipsInfo.tipsMsg) && Intrinsics.areEqual(this.userTopCenter, userActionTipsInfo.userTopCenter);
    }
}
