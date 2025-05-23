package com.tencent.hippykotlin.demo.pages.retain.model;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class Button implements ISSOModel {
    public final String leftText;
    public final String rightJumpurl;
    public final String rightText;

    public Button() {
        this(null, null, null, 7, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.v("left_text", this.leftText);
        eVar.v("right_text", this.rightText);
        eVar.v("right_jumpurl", this.rightJumpurl);
        return eVar;
    }

    public final int hashCode() {
        return this.rightJumpurl.hashCode() + BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.rightText, this.leftText.hashCode() * 31, 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("Button(leftText=");
        m3.append(this.leftText);
        m3.append(", rightText=");
        m3.append(this.rightText);
        m3.append(", rightJumpurl=");
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.rightJumpurl, ')');
    }

    public Button(String str, String str2, String str3) {
        this.leftText = str;
        this.rightText = str2;
        this.rightJumpurl = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Button)) {
            return false;
        }
        Button button = (Button) obj;
        return Intrinsics.areEqual(this.leftText, button.leftText) && Intrinsics.areEqual(this.rightText, button.rightText) && Intrinsics.areEqual(this.rightJumpurl, button.rightJumpurl);
    }

    public /* synthetic */ Button(String str, String str2, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "", "");
    }
}
