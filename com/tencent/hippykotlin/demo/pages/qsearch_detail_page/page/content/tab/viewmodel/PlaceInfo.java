package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.viewmodel;

import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes32.dex */
public final class PlaceInfo {
    public final City city;
    public final int cityId;
    public final County county;
    public final String displayText;
    public final Province province;

    public PlaceInfo() {
        this(null, null, null, 7, null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof PlaceInfo)) {
            return false;
        }
        PlaceInfo placeInfo = (PlaceInfo) obj;
        return Intrinsics.areEqual(placeInfo.displayText, this.displayText) && placeInfo.cityId == this.cityId;
    }

    public PlaceInfo(Province province, City city, County county) {
        this.province = province;
        this.city = city;
        this.county = county;
        if (!Intrinsics.areEqual(county.text, IProfileCardConst.NAME_NO_LIMIT)) {
            this.displayText = county.text;
            this.cityId = county.f114294id;
        } else if (!Intrinsics.areEqual(city.text, IProfileCardConst.NAME_NO_LIMIT)) {
            this.displayText = city.text;
            this.cityId = city.f114292id;
        } else {
            this.displayText = province.text;
            this.cityId = province.f114295id;
        }
    }

    public /* synthetic */ PlaceInfo(Province province, City city, County county, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(QSearchTroopTabContentViewModelKt.getEmptyProvince(), QSearchTroopTabContentViewModelKt.getEmptyCity(), QSearchTroopTabContentViewModelKt.getEmptyCounty());
    }
}
