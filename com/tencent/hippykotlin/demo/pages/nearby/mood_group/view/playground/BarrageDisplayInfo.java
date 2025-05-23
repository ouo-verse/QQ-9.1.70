package com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.data.NBPMoodGroupConfig;
import h35.a;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class BarrageDisplayInfo {
    public final a barrage;
    public final NBPMoodGroupConfig.BarrageReplyInteractionConfig replyInteractionConfig;
    public final NBPMoodGroupConfig.BubbleConfig uiConfig;

    public BarrageDisplayInfo(a aVar, NBPMoodGroupConfig.BubbleConfig bubbleConfig, NBPMoodGroupConfig.BarrageReplyInteractionConfig barrageReplyInteractionConfig) {
        this.barrage = aVar;
        this.uiConfig = bubbleConfig;
        this.replyInteractionConfig = barrageReplyInteractionConfig;
    }

    public final int hashCode() {
        int hashCode = (this.uiConfig.hashCode() + (this.barrage.hashCode() * 31)) * 31;
        NBPMoodGroupConfig.BarrageReplyInteractionConfig barrageReplyInteractionConfig = this.replyInteractionConfig;
        return hashCode + (barrageReplyInteractionConfig == null ? 0 : barrageReplyInteractionConfig.hashCode());
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("BarrageDisplayInfo(barrage=");
        m3.append(this.barrage);
        m3.append(", uiConfig=");
        m3.append(this.uiConfig);
        m3.append(", replyInteractionConfig=");
        m3.append(this.replyInteractionConfig);
        m3.append(')');
        return m3.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BarrageDisplayInfo)) {
            return false;
        }
        BarrageDisplayInfo barrageDisplayInfo = (BarrageDisplayInfo) obj;
        return Intrinsics.areEqual(this.barrage, barrageDisplayInfo.barrage) && Intrinsics.areEqual(this.uiConfig, barrageDisplayInfo.uiConfig) && Intrinsics.areEqual(this.replyInteractionConfig, barrageDisplayInfo.replyInteractionConfig);
    }
}
