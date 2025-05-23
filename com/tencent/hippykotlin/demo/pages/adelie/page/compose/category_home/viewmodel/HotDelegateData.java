package com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.viewmodel;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import g25.a;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class HotDelegateData extends AbsDelegateData {
    public final List<a> cards;

    public final int hashCode() {
        return this.cards.hashCode();
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("HotDelegateData(cards=");
        m3.append(this.cards);
        m3.append(')');
        return m3.toString();
    }

    public HotDelegateData(List<a> list) {
        super(2);
        this.cards = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof HotDelegateData) && Intrinsics.areEqual(this.cards, ((HotDelegateData) obj).cards);
    }
}
