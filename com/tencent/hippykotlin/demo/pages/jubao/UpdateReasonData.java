package com.tencent.hippykotlin.demo.pages.jubao;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.QQAudioParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class UpdateReasonData {
    public final int alarm;
    public final String desc;
    public final int flag;

    public UpdateReasonData(String str, int i3, int i16) {
        this.desc = str;
        this.flag = i3;
        this.alarm = i16;
    }

    public final int hashCode() {
        return this.alarm + QQAudioParams$$ExternalSyntheticOutline0.m(this.flag, this.desc.hashCode() * 31, 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("UpdateReasonData(desc=");
        m3.append(this.desc);
        m3.append(", flag=");
        m3.append(this.flag);
        m3.append(", alarm=");
        return AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1.m(m3, this.alarm, ')');
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UpdateReasonData)) {
            return false;
        }
        UpdateReasonData updateReasonData = (UpdateReasonData) obj;
        return Intrinsics.areEqual(this.desc, updateReasonData.desc) && this.flag == updateReasonData.flag && this.alarm == updateReasonData.alarm;
    }
}
