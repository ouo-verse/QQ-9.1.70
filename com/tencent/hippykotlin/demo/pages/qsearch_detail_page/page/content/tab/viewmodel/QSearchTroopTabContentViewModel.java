package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.viewmodel;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.RefreshListState;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.UnifySearchCity;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.UnifySearchDistrict;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.UnifySearchGeoInfo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.UnifySearchGroupConditonFilter;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.UnifySearchGroupContentRankType;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.UnifySearchGroupSearchFilterCondition;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.UnifySearchProvince;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.UnifySearchTabInfo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.QSearchLBSPermissionHelper;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.repo.GroupConditonFilterCustom;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.repo.GroupSearchFilterConditionCustom;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.repo.QSearchContentNetRepo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.repo.QSearchTroopContentNetRepo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util.QSearchPagePerfReporter;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util.QSearchUtilKt;
import com.tencent.kuikly.core.pager.g;
import com.tencent.kuikly.core.reactive.collection.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kuikly.com.tencent.trpcprotocol.search.unifysearch.b;
import kuikly.com.tencent.trpcprotocol.search.unifysearch.d;
import kuikly.com.tencent.trpcprotocol.search.unifysearch.f;
import kuikly.com.tencent.trpcprotocol.search.unifysearch.h;
import kuikly.com.tencent.trpcprotocol.search.unifysearch.i;
import kuikly.com.tencent.trpcprotocol.search.unifysearch.o;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchTroopTabContentViewModel extends QSearchTabContentViewModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {IPagerIdKtxKt$$ExternalSyntheticOutline0.m(QSearchTroopTabContentViewModel.class, "sortRules", "getSortRules()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), IPagerIdKtxKt$$ExternalSyntheticOutline0.m(QSearchTroopTabContentViewModel.class, "troopLabels", "getTroopLabels()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), IPagerIdKtxKt$$ExternalSyntheticOutline0.m(QSearchTroopTabContentViewModel.class, "provinceList", "getProvinceList()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchTroopTabContentViewModel.class, "selectedSortRule", "getSelectedSortRule()Lcom/tencent/hippykotlin/demo/pages/qsearch_detail_page/page/content/tab/viewmodel/SortRule;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchTroopTabContentViewModel.class, "selectedTroopLabel", "getSelectedTroopLabel()Lcom/tencent/hippykotlin/demo/pages/qsearch_detail_page/page/content/tab/viewmodel/TroopLabel;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchTroopTabContentViewModel.class, "selectedPlace", "getSelectedPlace()Lcom/tencent/hippykotlin/demo/pages/qsearch_detail_page/page/content/tab/viewmodel/PlaceInfo;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchTroopTabContentViewModel.class, "highlightProvince", "getHighlightProvince()Lcom/tencent/hippykotlin/demo/pages/qsearch_detail_page/page/content/tab/viewmodel/Province;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchTroopTabContentViewModel.class, "highlightCity", "getHighlightCity()Lcom/tencent/hippykotlin/demo/pages/qsearch_detail_page/page/content/tab/viewmodel/City;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchTroopTabContentViewModel.class, "highlightCounty", "getHighlightCounty()Lcom/tencent/hippykotlin/demo/pages/qsearch_detail_page/page/content/tab/viewmodel/County;", 0)};
    public final ReadWriteProperty highlightCity$delegate;
    public final ReadWriteProperty highlightCounty$delegate;
    public final ReadWriteProperty highlightProvince$delegate;
    public boolean isConditionUpdated;
    public final ReadWriteProperty provinceList$delegate;
    public final ReadWriteProperty selectedPlace$delegate;
    public final ReadWriteProperty selectedSortRule$delegate;
    public final ReadWriteProperty selectedTroopLabel$delegate;
    public final ReadWriteProperty sortRules$delegate;
    public final ReadWriteProperty troopLabels$delegate;

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.viewmodel.QSearchTabContentViewModel
    public final QSearchContentNetRepo createContentNetRepo(g gVar, UnifySearchTabInfo unifySearchTabInfo, boolean z16) {
        return new QSearchTroopContentNetRepo(gVar.getAppVersion(), gVar, unifySearchTabInfo, z16);
    }

    public final City getHighlightCity() {
        return (City) this.highlightCity$delegate.getValue(this, $$delegatedProperties[7]);
    }

    public final County getHighlightCounty() {
        return (County) this.highlightCounty$delegate.getValue(this, $$delegatedProperties[8]);
    }

    public final Province getHighlightProvince() {
        return (Province) this.highlightProvince$delegate.getValue(this, $$delegatedProperties[6]);
    }

    public final c<Province> getProvinceList() {
        return (c) this.provinceList$delegate.getValue(this, $$delegatedProperties[2]);
    }

    public final PlaceInfo getSelectedPlace() {
        return (PlaceInfo) this.selectedPlace$delegate.getValue(this, $$delegatedProperties[5]);
    }

    public final SortRule getSelectedSortRule() {
        return (SortRule) this.selectedSortRule$delegate.getValue(this, $$delegatedProperties[3]);
    }

    public final TroopLabel getSelectedTroopLabel() {
        return (TroopLabel) this.selectedTroopLabel$delegate.getValue(this, $$delegatedProperties[4]);
    }

    public final c<SortRule> getSortRules() {
        return (c) this.sortRules$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final c<TroopLabel> getTroopLabels() {
        return (c) this.troopLabels$delegate.getValue(this, $$delegatedProperties[1]);
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.viewmodel.QSearchTabContentViewModel
    public final void loadData(String str, int i3, boolean z16, Function2<? super Boolean, ? super Boolean, Unit> function2) {
        List listOf;
        List listOf2;
        if (!this.isConditionUpdated && Intrinsics.areEqual(str, this.keyword) && Intrinsics.areEqual(getListState(), RefreshListState.Loading.INSTANCE)) {
            return;
        }
        this.isConditionUpdated = false;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("QSearchTroopTabContentViewModel loadData begin: ");
        m3.append(getSelectedSortRule().f114297id);
        m3.append('-');
        m3.append(getSelectedTroopLabel().text);
        m3.append('-');
        m3.append(getSelectedPlace().cityId);
        m3.append(" geoInfo=");
        m3.append(getSelectedPlace().province.text);
        m3.append('-');
        m3.append(getSelectedPlace().city.text);
        m3.append('-');
        m3.append(getSelectedPlace().county.text);
        QSearchUtilKt.fastLog(m3.toString(), true);
        QSearchContentNetRepo qSearchContentNetRepo = this.repo;
        Intrinsics.checkNotNull(qSearchContentNetRepo, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.repo.QSearchTroopContentNetRepo");
        int i16 = getSelectedSortRule().f114297id;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(getSelectedTroopLabel().text);
        kuikly.com.tencent.trpcprotocol.search.unifysearch.g gVar = new kuikly.com.tencent.trpcprotocol.search.unifysearch.g(i16, listOf, new f(getSelectedPlace().cityId, 23), 8);
        int i17 = getSelectedSortRule().f114297id;
        listOf2 = CollectionsKt__CollectionsJVMKt.listOf(getSelectedTroopLabel().text);
        ((QSearchTroopContentNetRepo) qSearchContentNetRepo).conditionFilter = new GroupConditonFilterCustom(gVar, new UnifySearchGroupConditonFilter(i17, listOf2, new UnifySearchGeoInfo(getSelectedPlace().cityId)));
        if (str.length() == 0) {
            this.keyword = "";
            reset();
            return;
        }
        if (!Intrinsics.areEqual(this.keyword, str) || this.querySource != i3) {
            reset();
        }
        this.keyword = str;
        this.querySource = i3;
        innerLoadData(function2);
    }

    public final void setHighlightCity(City city) {
        this.highlightCity$delegate.setValue(this, $$delegatedProperties[7], city);
    }

    public final void setHighlightCounty(County county) {
        this.highlightCounty$delegate.setValue(this, $$delegatedProperties[8], county);
    }

    public final void setHighlightProvince(Province province) {
        this.highlightProvince$delegate.setValue(this, $$delegatedProperties[6], province);
    }

    public final void setSelectedPlace(PlaceInfo placeInfo) {
        this.selectedPlace$delegate.setValue(this, $$delegatedProperties[5], placeInfo);
    }

    public final void setSelectedSortRule(SortRule sortRule) {
        this.selectedSortRule$delegate.setValue(this, $$delegatedProperties[3], sortRule);
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x028f, code lost:
    
        if (r3 != null) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0118, code lost:
    
        if (r4 != null) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void updateConditions(GroupSearchFilterConditionCustom groupSearchFilterConditionCustom) {
        List emptyList;
        Object firstOrNull;
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        List emptyList2;
        int collectionSizeOrDefault3;
        List emptyList3;
        int collectionSizeOrDefault4;
        List emptyList4;
        Object firstOrNull2;
        int collectionSizeOrDefault5;
        int collectionSizeOrDefault6;
        Iterator it;
        List list;
        int collectionSizeOrDefault7;
        Iterator it5;
        List list2;
        int collectionSizeOrDefault8;
        getSortRules().clear();
        getTroopLabels().clear();
        getProvinceList().clear();
        setSelectedSortRule(QSearchTroopTabContentViewModelKt.defaultSortRule);
        this.selectedTroopLabel$delegate.setValue(this, $$delegatedProperties[4], QSearchTroopTabContentViewModelKt.defaultTroopLabel);
        setSelectedPlace(QSearchTroopTabContentViewModelKt.emptyPlaceInfo);
        setHighlightProvince(QSearchTroopTabContentViewModelKt.emptyProvince);
        setHighlightCity(QSearchTroopTabContentViewModelKt.emptyCity);
        setHighlightCounty(QSearchTroopTabContentViewModelKt.emptyCounty);
        i iVar = groupSearchFilterConditionCustom.oidbFilter;
        int i3 = 10;
        if (iVar != null) {
            List<String> list3 = iVar.f413206d;
            int size = list3.size();
            for (int i16 = 0; i16 < size; i16++) {
                getTroopLabels().add(new TroopLabel(list3.get(i16), ""));
            }
            c<Province> provinceList = getProvinceList();
            List<o> list4 = iVar.f413207e;
            if (list4 != null) {
                collectionSizeOrDefault6 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list4, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault6);
                Iterator it6 = list4.iterator();
                while (it6.hasNext()) {
                    o oVar = (o) it6.next();
                    String str = oVar.f413232d;
                    List<b> list5 = oVar.f413233e;
                    if (list5 != null) {
                        collectionSizeOrDefault7 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list5, i3);
                        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault7);
                        for (b bVar : list5) {
                            String str2 = bVar.f413176d;
                            List<d> list6 = bVar.f413178f;
                            if (list6 != null) {
                                it5 = it6;
                                collectionSizeOrDefault8 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list6, i3);
                                ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault8);
                                for (Iterator it7 = list6.iterator(); it7.hasNext(); it7 = it7) {
                                    d dVar = (d) it7.next();
                                    arrayList3.add(new County(dVar.f413186d, dVar.f413187e));
                                }
                                list2 = CollectionsKt___CollectionsKt.toList(arrayList3);
                                if (list2 != null) {
                                    arrayList2.add(new City(str2, list2, bVar.f413179h));
                                    it6 = it5;
                                    i3 = 10;
                                }
                            } else {
                                it5 = it6;
                            }
                            list2 = CollectionsKt__CollectionsKt.emptyList();
                            arrayList2.add(new City(str2, list2, bVar.f413179h));
                            it6 = it5;
                            i3 = 10;
                        }
                        it = it6;
                        list = CollectionsKt___CollectionsKt.toList(arrayList2);
                        if (list != null) {
                            arrayList.add(new Province(str, list, oVar.f413234f));
                            it6 = it;
                            i3 = 10;
                        }
                    } else {
                        it = it6;
                    }
                    list = CollectionsKt__CollectionsKt.emptyList();
                    arrayList.add(new Province(str, list, oVar.f413234f));
                    it6 = it;
                    i3 = 10;
                }
                emptyList4 = CollectionsKt___CollectionsKt.toList(arrayList);
            }
            emptyList4 = CollectionsKt__CollectionsKt.emptyList();
            provinceList.addAll(emptyList4);
            if (!getProvinceList().isEmpty()) {
                setHighlightProvince(getProvinceList().get(0));
                if (!getHighlightProvince().cityList.isEmpty()) {
                    setHighlightCity(getHighlightProvince().cityList.get(0));
                    if (!getHighlightCity().countyList.isEmpty()) {
                        setHighlightCounty(getHighlightCity().countyList.get(0));
                    }
                }
            }
            setSelectedPlace(new PlaceInfo(getHighlightProvince(), getHighlightCity(), getHighlightCounty()));
            List<h> list7 = iVar.f413208f;
            if (list7 != null) {
                c<SortRule> sortRules = getSortRules();
                collectionSizeOrDefault5 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list7, 10);
                ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault5);
                for (h hVar : list7) {
                    arrayList4.add(new SortRule(hVar.f413204e, hVar.f413203d));
                }
                sortRules.addAll(arrayList4);
            }
            firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) getSortRules());
            SortRule sortRule = (SortRule) firstOrNull2;
            if (sortRule != null) {
                setSelectedSortRule(sortRule);
            }
        }
        UnifySearchGroupSearchFilterCondition unifySearchGroupSearchFilterCondition = groupSearchFilterConditionCustom.msfFilter;
        if (unifySearchGroupSearchFilterCondition != null) {
            List<String> list8 = unifySearchGroupSearchFilterCondition.tags;
            if (list8 != null) {
                int size2 = list8.size();
                for (int i17 = 0; i17 < size2; i17++) {
                    getTroopLabels().add(new TroopLabel(list8.get(i17), ""));
                }
            }
            c<Province> provinceList2 = getProvinceList();
            List<UnifySearchProvince> list9 = unifySearchGroupSearchFilterCondition.geoInfo;
            if (list9 != null) {
                collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list9, 10);
                ArrayList arrayList5 = new ArrayList(collectionSizeOrDefault2);
                for (UnifySearchProvince unifySearchProvince : list9) {
                    String str3 = unifySearchProvince.name;
                    List<UnifySearchCity> list10 = unifySearchProvince.citys;
                    if (list10 != null) {
                        collectionSizeOrDefault3 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list10, 10);
                        ArrayList arrayList6 = new ArrayList(collectionSizeOrDefault3);
                        for (UnifySearchCity unifySearchCity : list10) {
                            String str4 = unifySearchCity.name;
                            List<UnifySearchDistrict> list11 = unifySearchCity.districtsNew;
                            if (list11 != null) {
                                collectionSizeOrDefault4 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list11, 10);
                                ArrayList arrayList7 = new ArrayList(collectionSizeOrDefault4);
                                for (UnifySearchDistrict unifySearchDistrict : list11) {
                                    arrayList7.add(new County(unifySearchDistrict.name, unifySearchDistrict.cityId));
                                }
                                emptyList3 = CollectionsKt___CollectionsKt.toList(arrayList7);
                                if (emptyList3 != null) {
                                    arrayList6.add(new City(str4, emptyList3, unifySearchCity.cityId));
                                }
                            }
                            emptyList3 = CollectionsKt__CollectionsKt.emptyList();
                            arrayList6.add(new City(str4, emptyList3, unifySearchCity.cityId));
                        }
                        emptyList2 = CollectionsKt___CollectionsKt.toList(arrayList6);
                        if (emptyList2 != null) {
                            arrayList5.add(new Province(str3, emptyList2, unifySearchProvince.cityId));
                        }
                    }
                    emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                    arrayList5.add(new Province(str3, emptyList2, unifySearchProvince.cityId));
                }
                emptyList = CollectionsKt___CollectionsKt.toList(arrayList5);
            }
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            provinceList2.addAll(emptyList);
            if (!getProvinceList().isEmpty()) {
                setHighlightProvince(getProvinceList().get(0));
                if (!getHighlightProvince().cityList.isEmpty()) {
                    setHighlightCity(getHighlightProvince().cityList.get(0));
                    if (!getHighlightCity().countyList.isEmpty()) {
                        setHighlightCounty(getHighlightCity().countyList.get(0));
                    }
                }
            }
            setSelectedPlace(new PlaceInfo(getHighlightProvince(), getHighlightCity(), getHighlightCounty()));
            List<UnifySearchGroupContentRankType> list12 = unifySearchGroupSearchFilterCondition.groupContentRankType;
            if (list12 != null) {
                c<SortRule> sortRules2 = getSortRules();
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list12, 10);
                ArrayList arrayList8 = new ArrayList(collectionSizeOrDefault);
                for (UnifySearchGroupContentRankType unifySearchGroupContentRankType : list12) {
                    arrayList8.add(new SortRule(unifySearchGroupContentRankType.rankTypeText, unifySearchGroupContentRankType.rankTypeId));
                }
                sortRules2.addAll(arrayList8);
            }
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) getSortRules());
            SortRule sortRule2 = (SortRule) firstOrNull;
            if (sortRule2 != null) {
                setSelectedSortRule(sortRule2);
            }
        }
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("QSearchTroopTabContentViewModel updateConditions sort:");
        m3.append(getSortRules().size());
        m3.append(" labels:");
        m3.append(getTroopLabels().size());
        m3.append(" province:");
        m3.append(getProvinceList().size());
        QSearchUtilKt.fastLog(m3.toString(), true);
    }

    public QSearchTroopTabContentViewModel(UnifySearchTabInfo unifySearchTabInfo, GroupSearchFilterConditionCustom groupSearchFilterConditionCustom, g gVar, QSearchPagePerfReporter qSearchPagePerfReporter, QSearchLBSPermissionHelper qSearchLBSPermissionHelper, boolean z16) {
        super(unifySearchTabInfo, gVar, qSearchPagePerfReporter, qSearchLBSPermissionHelper, z16);
        this.sortRules$delegate = c01.c.b();
        this.troopLabels$delegate = c01.c.b();
        this.provinceList$delegate = c01.c.b();
        this.selectedSortRule$delegate = c01.c.a(QSearchTroopTabContentViewModelKt.getDefaultSortRule());
        this.selectedTroopLabel$delegate = c01.c.a(QSearchTroopTabContentViewModelKt.getDefaultTroopLabel());
        this.selectedPlace$delegate = c01.c.a(QSearchTroopTabContentViewModelKt.getEmptyPlaceInfo());
        this.highlightProvince$delegate = c01.c.a(QSearchTroopTabContentViewModelKt.getEmptyProvince());
        this.highlightCity$delegate = c01.c.a(QSearchTroopTabContentViewModelKt.getEmptyCity());
        this.highlightCounty$delegate = c01.c.a(QSearchTroopTabContentViewModelKt.getEmptyCounty());
        this.isConditionUpdated = true;
        updateConditions(groupSearchFilterConditionCustom);
    }
}
