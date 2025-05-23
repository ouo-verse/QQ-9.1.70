package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.viewmodel;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class TroopLabel {

    /* renamed from: id, reason: collision with root package name */
    public final String f114298id;
    public final String text;

    public TroopLabel(String str, String str2) {
        this.text = str;
        this.f114298id = str2;
    }

    public final int hashCode() {
        return this.f114298id.hashCode() + (this.text.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("TroopLabel(text=");
        m3.append(this.text);
        m3.append(", id=");
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.f114298id, ')');
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TroopLabel)) {
            return false;
        }
        TroopLabel troopLabel = (TroopLabel) obj;
        return Intrinsics.areEqual(this.text, troopLabel.text) && Intrinsics.areEqual(this.f114298id, troopLabel.f114298id);
    }
}
