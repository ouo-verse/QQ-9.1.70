package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.viewmodel;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class City {
    public final List<County> countyList;

    /* renamed from: id, reason: collision with root package name */
    public final int f114292id;
    public final String text;

    public City(String str, List<County> list, int i3) {
        this.text = str;
        this.countyList = list;
        this.f114292id = i3;
    }

    public final int hashCode() {
        return this.f114292id + ((this.countyList.hashCode() + (this.text.hashCode() * 31)) * 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("City(text=");
        m3.append(this.text);
        m3.append(", countyList=");
        m3.append(this.countyList);
        m3.append(", id=");
        return AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1.m(m3, this.f114292id, ')');
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof City)) {
            return false;
        }
        City city = (City) obj;
        return Intrinsics.areEqual(this.text, city.text) && Intrinsics.areEqual(this.countyList, city.countyList) && this.f114292id == city.f114292id;
    }
}
