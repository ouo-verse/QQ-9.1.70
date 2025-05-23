package com.tencent.hippykotlin.demo.pages.qqflash_transfer.model;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.QQAudioParams$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.h;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class QQFTShareItem {
    public final int action;
    public final String iconUrl;
    public final h imageTintColor;
    public final Function0<Unit> onClick;
    public final String text;
    public final String tokenName;

    public QQFTShareItem(String str, String str2, int i3, String str3, h hVar, Function0<Unit> function0) {
        this.text = str;
        this.iconUrl = str2;
        this.action = i3;
        this.tokenName = str3;
        this.imageTintColor = hVar;
        this.onClick = function0;
    }

    public final int hashCode() {
        int m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.tokenName, QQAudioParams$$ExternalSyntheticOutline0.m(this.action, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.iconUrl, this.text.hashCode() * 31, 31), 31), 31);
        h hVar = this.imageTintColor;
        int hashCode = (m3 + (hVar == null ? 0 : hVar.hashCode())) * 31;
        Function0<Unit> function0 = this.onClick;
        return hashCode + (function0 != null ? function0.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("QQFTShareItem(text=");
        m3.append(this.text);
        m3.append(", iconUrl=");
        m3.append(this.iconUrl);
        m3.append(", action=");
        m3.append(this.action);
        m3.append(", tokenName=");
        m3.append(this.tokenName);
        m3.append(", imageTintColor=");
        m3.append(this.imageTintColor);
        m3.append(", onClick=");
        m3.append(this.onClick);
        m3.append(')');
        return m3.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QQFTShareItem)) {
            return false;
        }
        QQFTShareItem qQFTShareItem = (QQFTShareItem) obj;
        return Intrinsics.areEqual(this.text, qQFTShareItem.text) && Intrinsics.areEqual(this.iconUrl, qQFTShareItem.iconUrl) && this.action == qQFTShareItem.action && Intrinsics.areEqual(this.tokenName, qQFTShareItem.tokenName) && Intrinsics.areEqual(this.imageTintColor, qQFTShareItem.imageTintColor) && Intrinsics.areEqual(this.onClick, qQFTShareItem.onClick);
    }

    public /* synthetic */ QQFTShareItem(String str, String str2, int i3, String str3, int i16) {
        this(str, str2, i3, (i16 & 8) != 0 ? "" : str3, null, null);
    }
}
