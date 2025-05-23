package com.tencent.hippykotlin.demo.pages.adelie.module;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class AdelieRedDotModule$Companion$RedDotInfo {
    public final int bizType;
    public final String redDotText;
    public final String revokeId;
    public final long robotUin;

    public AdelieRedDotModule$Companion$RedDotInfo(String str, long j3, String str2, int i3) {
        this.revokeId = str;
        this.robotUin = j3;
        this.redDotText = str2;
        this.bizType = i3;
    }

    public final int hashCode() {
        return this.bizType + BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.redDotText, AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.robotUin, this.revokeId.hashCode() * 31, 31), 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("RedDotInfo(revokeId=");
        m3.append(this.revokeId);
        m3.append(", robotUin=");
        m3.append(this.robotUin);
        m3.append(", redDotText=");
        m3.append(this.redDotText);
        m3.append(", bizType=");
        return AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1.m(m3, this.bizType, ')');
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdelieRedDotModule$Companion$RedDotInfo)) {
            return false;
        }
        AdelieRedDotModule$Companion$RedDotInfo adelieRedDotModule$Companion$RedDotInfo = (AdelieRedDotModule$Companion$RedDotInfo) obj;
        return Intrinsics.areEqual(this.revokeId, adelieRedDotModule$Companion$RedDotInfo.revokeId) && this.robotUin == adelieRedDotModule$Companion$RedDotInfo.robotUin && Intrinsics.areEqual(this.redDotText, adelieRedDotModule$Companion$RedDotInfo.redDotText) && this.bizType == adelieRedDotModule$Companion$RedDotInfo.bizType;
    }
}
