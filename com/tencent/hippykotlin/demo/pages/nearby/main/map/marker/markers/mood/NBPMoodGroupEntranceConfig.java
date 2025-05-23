package com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.mood;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.PopoverTriangle$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class NBPMoodGroupEntranceConfig {
    public final float aggregateLevel;
    public final String iconBgUrl;
    public final String iconUrl;
    public final boolean isMoodEntryAdaptive;
    public final float moodBgHeight;
    public final String moodBgUrl;
    public final float moodBgWidth;

    public NBPMoodGroupEntranceConfig(String str, String str2, float f16, boolean z16, String str3, float f17, float f18) {
        this.iconUrl = str;
        this.iconBgUrl = str2;
        this.aggregateLevel = f16;
        this.isMoodEntryAdaptive = z16;
        this.moodBgUrl = str3;
        this.moodBgWidth = f17;
        this.moodBgHeight = f18;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int m3 = PopoverTriangle$$ExternalSyntheticOutline0.m(this.aggregateLevel, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.iconBgUrl, this.iconUrl.hashCode() * 31, 31), 31);
        boolean z16 = this.isMoodEntryAdaptive;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return Float.floatToIntBits(this.moodBgHeight) + PopoverTriangle$$ExternalSyntheticOutline0.m(this.moodBgWidth, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.moodBgUrl, (m3 + i3) * 31, 31), 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("NBPMoodGroupEntranceConfig(iconUrl=");
        m3.append(this.iconUrl);
        m3.append(", iconBgUrl=");
        m3.append(this.iconBgUrl);
        m3.append(", aggregateLevel=");
        m3.append(this.aggregateLevel);
        m3.append(", isMoodEntryAdaptive=");
        m3.append(this.isMoodEntryAdaptive);
        m3.append(", moodBgUrl=");
        m3.append(this.moodBgUrl);
        m3.append(", moodBgWidth=");
        m3.append(this.moodBgWidth);
        m3.append(", moodBgHeight=");
        m3.append(this.moodBgHeight);
        m3.append(')');
        return m3.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NBPMoodGroupEntranceConfig)) {
            return false;
        }
        NBPMoodGroupEntranceConfig nBPMoodGroupEntranceConfig = (NBPMoodGroupEntranceConfig) obj;
        return Intrinsics.areEqual(this.iconUrl, nBPMoodGroupEntranceConfig.iconUrl) && Intrinsics.areEqual(this.iconBgUrl, nBPMoodGroupEntranceConfig.iconBgUrl) && Float.compare(this.aggregateLevel, nBPMoodGroupEntranceConfig.aggregateLevel) == 0 && this.isMoodEntryAdaptive == nBPMoodGroupEntranceConfig.isMoodEntryAdaptive && Intrinsics.areEqual(this.moodBgUrl, nBPMoodGroupEntranceConfig.moodBgUrl) && Float.compare(this.moodBgWidth, nBPMoodGroupEntranceConfig.moodBgWidth) == 0 && Float.compare(this.moodBgHeight, nBPMoodGroupEntranceConfig.moodBgHeight) == 0;
    }
}
