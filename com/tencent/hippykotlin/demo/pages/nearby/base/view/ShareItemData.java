package com.tencent.hippykotlin.demo.pages.nearby.base.view;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ShareItemData {
    public final int action;
    public final String icon;
    public final String text;

    public ShareItemData(String str, String str2, int i3) {
        this.text = str;
        this.icon = str2;
        this.action = i3;
    }

    public final int hashCode() {
        return this.action + BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.icon, this.text.hashCode() * 31, 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ShareItemData(text=");
        m3.append(this.text);
        m3.append(", icon=");
        m3.append(this.icon);
        m3.append(", action=");
        return AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1.m(m3, this.action, ')');
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShareItemData)) {
            return false;
        }
        ShareItemData shareItemData = (ShareItemData) obj;
        return Intrinsics.areEqual(this.text, shareItemData.text) && Intrinsics.areEqual(this.icon, shareItemData.icon) && this.action == shareItemData.action;
    }
}
