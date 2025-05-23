package com.tencent.hippykotlin.demo.pages.nearby.middle_page;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class NBPMiddlePageConfig {
    public final String tmapPOIPagePath;

    public NBPMiddlePageConfig(String str) {
        this.tmapPOIPagePath = str;
    }

    public final int hashCode() {
        return this.tmapPOIPagePath.hashCode();
    }

    public final String toString() {
        return LoadFailParams$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("NBPMiddlePageConfig(tmapPOIPagePath="), this.tmapPOIPagePath, ')');
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof NBPMiddlePageConfig) && Intrinsics.areEqual(this.tmapPOIPagePath, ((NBPMiddlePageConfig) obj).tmapPOIPagePath);
    }
}
