package com.tencent.hippykotlin.demo.pages.retain;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes33.dex */
public final class RetainPopWindowViewUtils$ButtonInfo {
    public final j[] backGroundGradientColor;
    public final Function0<Unit> clickEvent;
    public final String text;
    public final h textColor;

    public RetainPopWindowViewUtils$ButtonInfo(String str, h hVar, j[] jVarArr, Function0<Unit> function0) {
        this.text = str;
        this.textColor = hVar;
        this.backGroundGradientColor = jVarArr;
        this.clickEvent = function0;
    }

    public final int hashCode() {
        return this.clickEvent.hashCode() + ((Arrays.hashCode(this.backGroundGradientColor) + ((this.textColor.hashCode() + (this.text.hashCode() * 31)) * 31)) * 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ButtonInfo(text=");
        m3.append(this.text);
        m3.append(", textColor=");
        m3.append(this.textColor);
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
        if (!(obj instanceof RetainPopWindowViewUtils$ButtonInfo)) {
            return false;
        }
        RetainPopWindowViewUtils$ButtonInfo retainPopWindowViewUtils$ButtonInfo = (RetainPopWindowViewUtils$ButtonInfo) obj;
        return Intrinsics.areEqual(this.text, retainPopWindowViewUtils$ButtonInfo.text) && Intrinsics.areEqual(this.textColor, retainPopWindowViewUtils$ButtonInfo.textColor) && Intrinsics.areEqual(this.backGroundGradientColor, retainPopWindowViewUtils$ButtonInfo.backGroundGradientColor) && Intrinsics.areEqual(this.clickEvent, retainPopWindowViewUtils$ButtonInfo.clickEvent);
    }
}
