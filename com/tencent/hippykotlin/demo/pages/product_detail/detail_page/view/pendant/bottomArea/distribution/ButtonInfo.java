package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.distribution;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.kuikly.core.base.j;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ButtonInfo {
    public final j[] backGroundGradientColor;
    public final Function0<Unit> clickEvent;
    public final String text;

    public ButtonInfo(String str, j[] jVarArr, Function0<Unit> function0) {
        this.text = str;
        this.backGroundGradientColor = jVarArr;
        this.clickEvent = function0;
    }

    public final int hashCode() {
        return this.clickEvent.hashCode() + ((Arrays.hashCode(this.backGroundGradientColor) + (this.text.hashCode() * 31)) * 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ButtonInfo(text=");
        m3.append(this.text);
        m3.append(", backGroundGradientColor=");
        m3.append(Arrays.toString(this.backGroundGradientColor));
        m3.append(", clickEvent=");
        m3.append(this.clickEvent);
        m3.append(')');
        return m3.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ButtonInfo)) {
            return false;
        }
        ButtonInfo buttonInfo = (ButtonInfo) obj;
        return Intrinsics.areEqual(this.text, buttonInfo.text) && Intrinsics.areEqual(this.backGroundGradientColor, buttonInfo.backGroundGradientColor) && Intrinsics.areEqual(this.clickEvent, buttonInfo.clickEvent);
    }
}
