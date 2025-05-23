package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.viewmodel;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class RankRule {

    /* renamed from: id, reason: collision with root package name */
    public final int f114296id;
    public final String text;

    public RankRule(String str, int i3) {
        this.text = str;
        this.f114296id = i3;
    }

    public final int hashCode() {
        return this.f114296id + (this.text.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("RankRule(text=");
        m3.append(this.text);
        m3.append(", id=");
        return AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1.m(m3, this.f114296id, ')');
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RankRule)) {
            return false;
        }
        RankRule rankRule = (RankRule) obj;
        return Intrinsics.areEqual(this.text, rankRule.text) && this.f114296id == rankRule.f114296id;
    }
}
