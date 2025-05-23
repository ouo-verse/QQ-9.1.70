package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.viewmodel;

import com.tencent.ecommerce.base.location.IECLocationServiceProxy;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchTroopTabContentViewModelKt {
    public static final SortRule defaultSortRule;
    public static final TroopLabel defaultTroopLabel;
    public static final City emptyCity;
    public static final County emptyCounty;
    public static final PlaceInfo emptyPlaceInfo;
    public static final Province emptyProvince;

    static {
        List emptyList;
        List emptyList2;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        emptyProvince = new Province(IECLocationServiceProxy.ALL_REGION, emptyList, 0);
        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
        emptyCity = new City("", emptyList2, 0);
        emptyCounty = new County("", 0);
        emptyPlaceInfo = new PlaceInfo(null, null, null, 7, null);
        defaultSortRule = new SortRule("\u667a\u80fd\u6392\u5e8f", 1);
        defaultTroopLabel = new TroopLabel("\u4eba\u6570\u4e0d\u9650", "1");
    }

    public static final SortRule getDefaultSortRule() {
        return defaultSortRule;
    }

    public static final TroopLabel getDefaultTroopLabel() {
        return defaultTroopLabel;
    }

    public static final City getEmptyCity() {
        return emptyCity;
    }

    public static final County getEmptyCounty() {
        return emptyCounty;
    }

    public static final PlaceInfo getEmptyPlaceInfo() {
        return emptyPlaceInfo;
    }

    public static final Province getEmptyProvince() {
        return emptyProvince;
    }
}
