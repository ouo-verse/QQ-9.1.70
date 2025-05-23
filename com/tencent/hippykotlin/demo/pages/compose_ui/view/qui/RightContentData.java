package com.tencent.hippykotlin.demo.pages.compose_ui.view.qui;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class RightContentData {
    public final Function0<Unit> rightClickCallback;
    public final Function0<Unit> rightClickDidAppearCallback;
    public final String rightIconCircleColor;
    public final String rightIconColor;
    public final String rightIconUrl;
    public final String rightText;
    public final String rightTextColor;

    public RightContentData() {
        this(null, 0 == true ? 1 : 0, 127);
    }

    public final int hashCode() {
        String str = this.rightText;
        int m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.rightTextColor, (str == null ? 0 : str.hashCode()) * 31, 31);
        String str2 = this.rightIconUrl;
        int m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.rightIconCircleColor, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.rightIconColor, (m3 + (str2 == null ? 0 : str2.hashCode())) * 31, 31), 31);
        Function0<Unit> function0 = this.rightClickDidAppearCallback;
        int hashCode = (m16 + (function0 == null ? 0 : function0.hashCode())) * 31;
        Function0<Unit> function02 = this.rightClickCallback;
        return hashCode + (function02 != null ? function02.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("RightContentData(rightText=");
        m3.append(this.rightText);
        m3.append(", rightTextColor=");
        m3.append(this.rightTextColor);
        m3.append(", rightIconUrl=");
        m3.append(this.rightIconUrl);
        m3.append(", rightIconColor=");
        m3.append(this.rightIconColor);
        m3.append(", rightIconCircleColor=");
        m3.append(this.rightIconCircleColor);
        m3.append(", rightClickDidAppearCallback=");
        m3.append(this.rightClickDidAppearCallback);
        m3.append(", rightClickCallback=");
        m3.append(this.rightClickCallback);
        m3.append(')');
        return m3.toString();
    }

    public RightContentData(String str, String str2, String str3, String str4, String str5, Function0<Unit> function0, Function0<Unit> function02) {
        this.rightText = str;
        this.rightTextColor = str2;
        this.rightIconUrl = str3;
        this.rightIconColor = str4;
        this.rightIconCircleColor = str5;
        this.rightClickDidAppearCallback = function0;
        this.rightClickCallback = function02;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RightContentData)) {
            return false;
        }
        RightContentData rightContentData = (RightContentData) obj;
        return Intrinsics.areEqual(this.rightText, rightContentData.rightText) && Intrinsics.areEqual(this.rightTextColor, rightContentData.rightTextColor) && Intrinsics.areEqual(this.rightIconUrl, rightContentData.rightIconUrl) && Intrinsics.areEqual(this.rightIconColor, rightContentData.rightIconColor) && Intrinsics.areEqual(this.rightIconCircleColor, rightContentData.rightIconCircleColor) && Intrinsics.areEqual(this.rightClickDidAppearCallback, rightContentData.rightClickDidAppearCallback) && Intrinsics.areEqual(this.rightClickCallback, rightContentData.rightClickCallback);
    }

    public /* synthetic */ RightContentData(String str, Function0 function0, int i3) {
        this(null, (i3 & 2) != 0 ? "text_nav_secondary" : null, (i3 & 4) != 0 ? null : str, (i3 & 8) != 0 ? "icon_nav_secondary" : null, (i3 & 16) != 0 ? "icon_allwhite_primary" : null, null, (i3 & 64) != 0 ? null : function0);
    }
}
