package com.tencent.hippykotlin.demo.pages.foundation.lib.mqq;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class screenShotResult {
    public final String imgPath;
    public final int retCode;

    public screenShotResult(int i3, String str) {
        this.retCode = i3;
        this.imgPath = str;
    }

    public final int hashCode() {
        int i3 = this.retCode * 31;
        String str = this.imgPath;
        return i3 + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("screenShotResult(retCode=");
        m3.append(this.retCode);
        m3.append(", imgPath=");
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.imgPath, ')');
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof screenShotResult)) {
            return false;
        }
        screenShotResult screenshotresult = (screenShotResult) obj;
        return this.retCode == screenshotresult.retCode && Intrinsics.areEqual(this.imgPath, screenshotresult.imgPath);
    }
}
