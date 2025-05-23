package com.tencent.hippykotlin.demo.pages.jubao;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GrayTipData {
    public final String imgUrl;
    public final String jumpUrl;
    public final String text;

    public GrayTipData(String str, String str2, String str3) {
        this.text = str;
        this.imgUrl = str2;
        this.jumpUrl = str3;
    }

    public final int hashCode() {
        return this.jumpUrl.hashCode() + BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.imgUrl, this.text.hashCode() * 31, 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("GrayTipData(text=");
        m3.append(this.text);
        m3.append(", imgUrl=");
        m3.append(this.imgUrl);
        m3.append(", jumpUrl=");
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.jumpUrl, ')');
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GrayTipData)) {
            return false;
        }
        GrayTipData grayTipData = (GrayTipData) obj;
        return Intrinsics.areEqual(this.text, grayTipData.text) && Intrinsics.areEqual(this.imgUrl, grayTipData.imgUrl) && Intrinsics.areEqual(this.jumpUrl, grayTipData.jumpUrl);
    }
}
