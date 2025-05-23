package com.tencent.mobileqq.search.searchdetail.content.viewmodel;

import android.app.Activity;
import androidx.lifecycle.MutableLiveData;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.search.searchdetail.content.SearchCity;
import com.tencent.mobileqq.search.searchdetail.content.SearchDetailTabContentFragment;
import com.tencent.mobileqq.search.searchdetail.content.SearchDistrict;
import com.tencent.mobileqq.search.searchdetail.content.SearchGroupContentRankType;
import com.tencent.mobileqq.search.searchdetail.content.SearchGroupFilterConditionLocal;
import com.tencent.mobileqq.search.searchdetail.content.SearchGroupFilterManager;
import com.tencent.mobileqq.search.searchdetail.content.SearchProvince;
import com.tencent.mobileqq.search.searchdetail.content.repo.LoadMoreType;
import com.tencent.mobileqq.search.searchdetail.content.repo.RefreshType;
import com.tencent.qqmini.sdk.widget.ToastView;
import com.tencent.qqnt.kernel.nativeinterface.SearchGeoInfo;
import com.tencent.qqnt.kernel.nativeinterface.SearchGroupConditonFilter;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import cooperation.qqcircle.report.QCircleLpReportDc05494;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0016\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u0016\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u0016\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000f\u001a\u00020\u0007J(\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\tH\u0016J \u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\tH\u0016R\"\u0010\u001f\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001d\u0010&\u001a\b\u0012\u0004\u0012\u00020!0 8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/SearchDetailTroopTabViewModel;", "Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/k;", "Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/m;", "W2", "Landroid/app/Activity;", "context", "sortRule", "", "c3", "", "tag", "d3", "Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/e;", QCircleLpReportDc05494.KEY_PLACE, "b3", ICustomDataEditor.STRING_ARRAY_PARAM_3, "keyword", "Lcom/tencent/mobileqq/search/searchdetail/content/repo/RefreshType;", "refreshType", "source", "R2", "Lcom/tencent/mobileqq/search/searchdetail/content/repo/LoadMoreType;", "loadMoreType", NowProxyConstants.AccountInfoKey.A2, "Lcom/tencent/qqnt/kernel/nativeinterface/SearchGroupConditonFilter;", "W", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchGroupConditonFilter;", "Y2", "()Lcom/tencent/qqnt/kernel/nativeinterface/SearchGroupConditonFilter;", "setGroupFilter", "(Lcom/tencent/qqnt/kernel/nativeinterface/SearchGroupConditonFilter;)V", "groupFilter", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/b;", "X", "Landroidx/lifecycle/MutableLiveData;", "V2", "()Landroidx/lifecycle/MutableLiveData;", "conditionInfoLiveData", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SearchDetailTroopTabViewModel extends k {

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private SearchGroupConditonFilter groupFilter = new SearchGroupConditonFilter();

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<ConditionInfo> conditionInfoLiveData = new MutableLiveData<>();

    @Override // com.tencent.mobileqq.search.searchdetail.content.viewmodel.k
    public void A2(@NotNull String keyword, @NotNull LoadMoreType loadMoreType, @NotNull String source) {
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        Intrinsics.checkNotNullParameter(loadMoreType, "loadMoreType");
        Intrinsics.checkNotNullParameter(source, "source");
        e2(keyword, null, this.groupFilter, source, loadMoreType);
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.viewmodel.k
    public void R2(@NotNull Activity context, @NotNull String keyword, @NotNull RefreshType refreshType, @NotNull String source) {
        boolean z16;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        Intrinsics.checkNotNullParameter(refreshType, "refreshType");
        Intrinsics.checkNotNullParameter(source, "source");
        SearchDetailTabContentFragment.PageData pageData = getPageData();
        if (pageData != null) {
            z16 = pageData.getDisableCorrectionQuery();
        } else {
            z16 = false;
        }
        f2(context, keyword, z16, refreshType, null, this.groupFilter, source);
    }

    @NotNull
    public final MutableLiveData<ConditionInfo> V2() {
        return this.conditionInfoLiveData;
    }

    @Nullable
    public final SortRule W2() {
        boolean z16;
        ConditionInfo value = this.conditionInfoLiveData.getValue();
        Object obj = null;
        if (value != null) {
            Iterator<T> it = value.b().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (((SortRule) next).getId() == this.groupFilter.groupRankType) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    obj = next;
                    break;
                }
            }
            return (SortRule) obj;
        }
        Logger.f235387a.d().i("QQSearch.NetDetail.SearchDetailTabContentViewModel", 1, "getCurrentSortRule but condition not init!");
        return null;
    }

    @NotNull
    /* renamed from: Y2, reason: from getter */
    public final SearchGroupConditonFilter getGroupFilter() {
        return this.groupFilter;
    }

    public final void a3() {
        SearchGroupFilterManager.f283869a.d(new Function1<SearchGroupFilterConditionLocal, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.viewmodel.SearchDetailTroopTabViewModel$loadFilters$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SearchGroupFilterConditionLocal searchGroupFilterConditionLocal) {
                invoke2(searchGroupFilterConditionLocal);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull SearchGroupFilterConditionLocal condition) {
                int collectionSizeOrDefault;
                Intrinsics.checkNotNullParameter(condition, "condition");
                ArrayList arrayList = new ArrayList();
                for (SearchGroupContentRankType searchGroupContentRankType : condition.c()) {
                    arrayList.add(new SortRule(searchGroupContentRankType.getRankTypeText(), searchGroupContentRankType.getRankTypeId()));
                }
                ArrayList arrayList2 = new ArrayList();
                Iterator<T> it = condition.e().iterator();
                while (it.hasNext()) {
                    arrayList2.add(new TroopLabel((String) it.next(), null, 2, null));
                }
                ArrayList arrayList3 = new ArrayList();
                ArrayList<SearchProvince> a16 = condition.a();
                SearchDetailTroopTabViewModel searchDetailTroopTabViewModel = SearchDetailTroopTabViewModel.this;
                for (SearchProvince searchProvince : a16) {
                    ArrayList arrayList4 = new ArrayList();
                    for (SearchCity searchCity : searchProvince.b()) {
                        if (searchCity != null) {
                            String name = searchCity.getName();
                            ArrayList<SearchDistrict> b16 = searchCity.b();
                            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(b16, 10);
                            ArrayList arrayList5 = new ArrayList(collectionSizeOrDefault);
                            for (SearchDistrict searchDistrict : b16) {
                                arrayList5.add(new District(searchDistrict.getName(), searchDistrict.getCityId()));
                            }
                            arrayList4.add(new City(name, arrayList5, searchCity.getCityId()));
                        }
                    }
                    arrayList3.add(new Province(searchProvince.getName(), arrayList4, searchProvince.getCityId()));
                    searchDetailTroopTabViewModel.V2().setValue(new ConditionInfo(arrayList, arrayList2, arrayList3));
                }
            }
        });
    }

    public final void b3(@NotNull Activity context, @NotNull e place) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(place, "place");
        int id5 = place.getDistrict().getId();
        if (Intrinsics.areEqual(place.getDistrict().getText(), IProfileCardConst.NAME_NO_LIMIT)) {
            id5 = place.getCity().getId();
            if (Intrinsics.areEqual(place.getCity().getText(), IProfileCardConst.NAME_NO_LIMIT)) {
                id5 = place.getProvince().getId();
            }
        }
        SearchGroupConditonFilter searchGroupConditonFilter = this.groupFilter;
        SearchGeoInfo searchGeoInfo = new SearchGeoInfo();
        searchGeoInfo.province = place.getProvince().getText();
        searchGeoInfo.city = place.getCity().getText();
        searchGeoInfo.cityId = id5;
        searchGeoInfo.district = place.getDistrict().getText();
        searchGroupConditonFilter.geoInfo = searchGeoInfo;
        Q2(ToastView.ICON_LOADING);
        SearchDetailTabContentFragment.PageData pageData = getPageData();
        if (pageData == null || (str = pageData.getKeyword()) == null) {
            str = "";
        }
        R2(context, str, RefreshType.TYPE_FINGER_PULL2REFRESH, "setPlace");
    }

    public final void c3(@NotNull Activity context, @NotNull SortRule sortRule) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sortRule, "sortRule");
        this.groupFilter.groupRankType = sortRule.getId();
        Q2(ToastView.ICON_LOADING);
        SearchDetailTabContentFragment.PageData pageData = getPageData();
        if (pageData == null || (str = pageData.getKeyword()) == null) {
            str = "";
        }
        R2(context, str, RefreshType.TYPE_FINGER_PULL2REFRESH, "setSortRule");
    }

    public final void d3(@NotNull Activity context, @NotNull String tag) {
        ArrayList<String> arrayListOf;
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(tag, "tag");
        SearchGroupConditonFilter searchGroupConditonFilter = this.groupFilter;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(tag);
        searchGroupConditonFilter.tags = arrayListOf;
        Q2(ToastView.ICON_LOADING);
        SearchDetailTabContentFragment.PageData pageData = getPageData();
        if (pageData == null || (str = pageData.getKeyword()) == null) {
            str = "";
        }
        R2(context, str, RefreshType.TYPE_FINGER_PULL2REFRESH, "setTag");
    }
}
