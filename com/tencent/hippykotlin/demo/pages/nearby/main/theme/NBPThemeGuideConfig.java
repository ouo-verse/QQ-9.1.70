package com.tencent.hippykotlin.demo.pages.nearby.main.theme;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class NBPThemeGuideConfig {
    public final String icon;
    public final String key;
    public final String text;
    public final String themeId;

    public NBPThemeGuideConfig() {
        this(null, null, null, null, 15, null);
    }

    public final int hashCode() {
        return this.themeId.hashCode() + BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.text, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.icon, this.key.hashCode() * 31, 31), 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("NBPThemeGuideConfig(key=");
        m3.append(this.key);
        m3.append(", icon=");
        m3.append(this.icon);
        m3.append(", text=");
        m3.append(this.text);
        m3.append(", themeId=");
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.themeId, ')');
    }

    public NBPThemeGuideConfig(String str, String str2, String str3, String str4) {
        this.key = str;
        this.icon = str2;
        this.text = str3;
        this.themeId = str4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NBPThemeGuideConfig)) {
            return false;
        }
        NBPThemeGuideConfig nBPThemeGuideConfig = (NBPThemeGuideConfig) obj;
        return Intrinsics.areEqual(this.key, nBPThemeGuideConfig.key) && Intrinsics.areEqual(this.icon, nBPThemeGuideConfig.icon) && Intrinsics.areEqual(this.text, nBPThemeGuideConfig.text) && Intrinsics.areEqual(this.themeId, nBPThemeGuideConfig.themeId);
    }

    public /* synthetic */ NBPThemeGuideConfig(String str, String str2, String str3, String str4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "", "", "");
    }
}
