package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.viewmodel;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes32.dex */
public final class Province {
    public final List<City> cityList;

    /* renamed from: id, reason: collision with root package name */
    public final int f114295id;
    public final String text;

    public Province(String str, List<City> list, int i3) {
        this.text = str;
        this.cityList = list;
        this.f114295id = i3;
    }

    public final int hashCode() {
        return this.f114295id + ((this.cityList.hashCode() + (this.text.hashCode() * 31)) * 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("Province(text=");
        m3.append(this.text);
        m3.append(", cityList=");
        m3.append(this.cityList);
        m3.append(", id=");
        return AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1.m(m3, this.f114295id, ')');
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Province)) {
            return false;
        }
        Province province = (Province) obj;
        return Intrinsics.areEqual(this.text, province.text) && Intrinsics.areEqual(this.cityList, province.cityList) && this.f114295id == province.f114295id;
    }
}
