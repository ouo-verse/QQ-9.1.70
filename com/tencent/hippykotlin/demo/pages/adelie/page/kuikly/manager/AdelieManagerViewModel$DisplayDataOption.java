package com.tencent.hippykotlin.demo.pages.adelie.page.kuikly.manager;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class AdelieManagerViewModel$DisplayDataOption {
    public final String jumpUrl;
    public final String option;

    public AdelieManagerViewModel$DisplayDataOption(String str, String str2) {
        this.option = str;
        this.jumpUrl = str2;
    }

    public final int hashCode() {
        return this.jumpUrl.hashCode() + (this.option.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("DisplayDataOption(option=");
        m3.append(this.option);
        m3.append(", jumpUrl=");
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.jumpUrl, ')');
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdelieManagerViewModel$DisplayDataOption)) {
            return false;
        }
        AdelieManagerViewModel$DisplayDataOption adelieManagerViewModel$DisplayDataOption = (AdelieManagerViewModel$DisplayDataOption) obj;
        return Intrinsics.areEqual(this.option, adelieManagerViewModel$DisplayDataOption.option) && Intrinsics.areEqual(this.jumpUrl, adelieManagerViewModel$DisplayDataOption.jumpUrl);
    }
}
