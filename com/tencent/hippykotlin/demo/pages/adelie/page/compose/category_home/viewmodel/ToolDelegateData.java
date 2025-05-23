package com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.viewmodel;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import g25.a;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ToolDelegateData extends AbsDelegateData {
    public final a card;

    public final int hashCode() {
        return this.card.hashCode();
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ToolDelegateData(card=");
        m3.append(this.card);
        m3.append(')');
        return m3.toString();
    }

    public ToolDelegateData(a aVar) {
        super(4);
        this.card = aVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ToolDelegateData) && Intrinsics.areEqual(this.card, ((ToolDelegateData) obj).card);
    }
}
