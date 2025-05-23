package com.tencent.hippykotlin.demo.pages.qq_intimate_space.share;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.QQAudioParams$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.h;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class ShareItem {
    public final int action;
    public final String icon;
    public final h imageTintColor;
    public final Function0<Unit> onClick;
    public final String text;

    public /* synthetic */ ShareItem(String str, String str2, int i3, h hVar, int i16) {
        this(str, str2, i3, (i16 & 8) != 0 ? null : hVar, (Function0<Unit>) null);
    }

    public final int hashCode() {
        int m3 = QQAudioParams$$ExternalSyntheticOutline0.m(this.action, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.icon, this.text.hashCode() * 31, 31), 31);
        h hVar = this.imageTintColor;
        int hashCode = (m3 + (hVar == null ? 0 : hVar.hashCode())) * 31;
        Function0<Unit> function0 = this.onClick;
        return hashCode + (function0 != null ? function0.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ShareItem(text=");
        m3.append(this.text);
        m3.append(", icon=");
        m3.append(this.icon);
        m3.append(", action=");
        m3.append(this.action);
        m3.append(", imageTintColor=");
        m3.append(this.imageTintColor);
        m3.append(", onClick=");
        m3.append(this.onClick);
        m3.append(')');
        return m3.toString();
    }

    public ShareItem(String str, String str2, int i3, h hVar, Function0<Unit> function0) {
        this.text = str;
        this.icon = str2;
        this.action = i3;
        this.imageTintColor = hVar;
        this.onClick = function0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShareItem)) {
            return false;
        }
        ShareItem shareItem = (ShareItem) obj;
        return Intrinsics.areEqual(this.text, shareItem.text) && Intrinsics.areEqual(this.icon, shareItem.icon) && this.action == shareItem.action && Intrinsics.areEqual(this.imageTintColor, shareItem.imageTintColor) && Intrinsics.areEqual(this.onClick, shareItem.onClick);
    }
}
