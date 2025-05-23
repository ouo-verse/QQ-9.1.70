package com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.viewmodel;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import g25.a;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class RoleDelegateData extends AbsDelegateData {
    public final a card;

    public final int hashCode() {
        return this.card.hashCode();
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("RoleDelegateData(card=");
        m3.append(this.card);
        m3.append(')');
        return m3.toString();
    }

    public RoleDelegateData(a aVar) {
        super(3);
        this.card = aVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RoleDelegateData) && Intrinsics.areEqual(this.card, ((RoleDelegateData) obj).card);
    }
}
