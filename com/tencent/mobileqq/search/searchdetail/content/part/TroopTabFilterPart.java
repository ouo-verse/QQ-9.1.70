package com.tencent.mobileqq.search.searchdetail.content.part;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSBottomDynamicGuideEvent;
import com.tencent.biz.qqcircle.widgets.bj;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.search.searchdetail.content.SearchDetailTabContentFragment;
import com.tencent.mobileqq.search.searchdetail.content.viewmodel.City;
import com.tencent.mobileqq.search.searchdetail.content.viewmodel.ConditionInfo;
import com.tencent.mobileqq.search.searchdetail.content.viewmodel.District;
import com.tencent.mobileqq.search.searchdetail.content.viewmodel.Province;
import com.tencent.mobileqq.search.searchdetail.content.viewmodel.SearchDetailTroopTabViewModel;
import com.tencent.mobileqq.search.searchdetail.content.viewmodel.SortRule;
import com.tencent.mobileqq.search.searchdetail.content.viewmodel.TroopLabel;
import com.tencent.mobileqq.search.searchdetail.filter.CityFilter;
import com.tencent.mobileqq.search.searchdetail.filter.DistrictFilter;
import com.tencent.mobileqq.search.searchdetail.filter.ProvinceFilter;
import com.tencent.mobileqq.search.searchdetail.filter.RuleFilter;
import com.tencent.mobileqq.search.searchdetail.filter.SearchFilterButton;
import com.tencent.mobileqq.search.searchdetail.filter.SearchPlacePickerView;
import com.tencent.mobileqq.search.searchdetail.filter.SearchRulePickerView;
import com.tencent.mobileqq.search.searchdetail.filter.SearchTagPickerView;
import com.tencent.mobileqq.search.searchdetail.filter.TagFilter;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u0000 D2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001EB\u0017\u0012\u0006\u0010-\u001a\u00020*\u0012\u0006\u00101\u001a\u00020.\u00a2\u0006\u0004\bB\u0010CJ6\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0002H\u0002J6\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00072\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J6\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00072\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\\\u0010\"\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00182\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00072\u0018\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u001d0\u001b2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u001d0\u001fH\u0002Jh\u0010&\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00182\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0018\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u001d0\u001b2\u001e\u0010%\u001a\u001a\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u001d0$H\u0002J\b\u0010(\u001a\u00020'H\u0016J\u0018\u0010)\u001a\u00020\u001d2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00104\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00106\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00103R\u0016\u00108\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u00103R\u0018\u0010;\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010>\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010A\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@\u00a8\u0006F"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/part/TroopTabFilterPart;", "Lcom/tencent/mobileqq/search/searchdetail/content/part/BaseSearchTabFilterPart;", "Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/SearchDetailTroopTabViewModel;", "Landroid/content/Context;", "context", "Landroid/widget/FrameLayout;", "pickerContainer", "", "Lcom/tencent/mobileqq/search/searchdetail/filter/d;", "placeData", "Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/b;", "condition", "vm", "Lcom/tencent/mobileqq/search/searchdetail/filter/SearchPlacePickerView;", "V9", "Lcom/tencent/mobileqq/search/searchdetail/filter/j;", "tagsData", "Lcom/tencent/mobileqq/search/searchdetail/filter/SearchTagPickerView;", "X9", "Lcom/tencent/mobileqq/search/searchdetail/filter/e;", "sortRulesData", "Lcom/tencent/mobileqq/search/searchdetail/filter/SearchRulePickerView;", "W9", HippyNestedScrollComponent.PRIORITY_PARENT, "Lcom/tencent/mobileqq/search/searchdetail/filter/SearchFilterButton;", "filterButton", "data", "Lkotlin/Function2;", "Landroid/view/View;", "", "onPickerItemCreatedCallback", "Lkotlin/Function1;", "", "onRuleSelected", "U9", "", "Lkotlin/Function3;", "onPlaceSelected", "T9", "", "isPartEnable", "Y9", "Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/k;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/k;", "viewModel", "Landroidx/lifecycle/LifecycleOwner;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/LifecycleOwner;", "viewLifecycleOwner", "D", "Lcom/tencent/mobileqq/search/searchdetail/filter/SearchFilterButton;", "sortFilterButton", "E", "tagFilterButton", UserInfo.SEX_FEMALE, "placeFilterButton", "G", "Lcom/tencent/mobileqq/search/searchdetail/filter/SearchRulePickerView;", "sortFilterPickerView", "H", "Lcom/tencent/mobileqq/search/searchdetail/filter/SearchTagPickerView;", "tagFilterPickerView", "I", "Lcom/tencent/mobileqq/search/searchdetail/filter/SearchPlacePickerView;", "placePickerView", "<init>", "(Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/k;Landroidx/lifecycle/LifecycleOwner;)V", "J", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class TroopTabFilterPart extends BaseSearchTabFilterPart<SearchDetailTroopTabViewModel> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final LifecycleOwner viewLifecycleOwner;

    /* renamed from: D, reason: from kotlin metadata */
    private SearchFilterButton sortFilterButton;

    /* renamed from: E, reason: from kotlin metadata */
    private SearchFilterButton tagFilterButton;

    /* renamed from: F, reason: from kotlin metadata */
    private SearchFilterButton placeFilterButton;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private SearchRulePickerView sortFilterPickerView;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private SearchTagPickerView tagFilterPickerView;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private SearchPlacePickerView placePickerView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.search.searchdetail.content.viewmodel.k viewModel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopTabFilterPart(@NotNull com.tencent.mobileqq.search.searchdetail.content.viewmodel.k viewModel, @NotNull LifecycleOwner viewLifecycleOwner) {
        super(viewModel);
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(viewLifecycleOwner, "viewLifecycleOwner");
        this.viewModel = viewModel;
        this.viewLifecycleOwner = viewLifecycleOwner;
    }

    private final SearchPlacePickerView T9(Context context, FrameLayout parent, final SearchFilterButton filterButton, List<ProvinceFilter> data, Function2<? super View, ? super String, Unit> onPickerItemCreatedCallback, final Function3<? super Integer, ? super Integer, ? super Integer, Unit> onPlaceSelected) {
        final SearchPlacePickerView searchPlacePickerView = new SearchPlacePickerView(context);
        searchPlacePickerView.setId(View.generateViewId());
        searchPlacePickerView.setVisibility(8);
        searchPlacePickerView.setData(data, onPickerItemCreatedCallback);
        parent.addView(searchPlacePickerView, new FrameLayout.LayoutParams(-1, bj.a(QFSBottomDynamicGuideEvent.DYNAMIC_GUIDE_BUTTON_TYPE)));
        searchPlacePickerView.setOnPlaceSelectedCallback(new Function3<Integer, Integer, Integer, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.part.TroopTabFilterPart$createPlacePickerView$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2, Integer num3) {
                invoke(num.intValue(), num2.intValue(), num3.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, int i16, int i17) {
                onPlaceSelected.invoke(Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                filterButton.setSelected(false);
                this.C9().f405749b.setVisibility(8);
                searchPlacePickerView.setVisibility(8);
            }
        });
        return searchPlacePickerView;
    }

    private final SearchTagPickerView U9(Context context, FrameLayout parent, final SearchFilterButton filterButton, List<TagFilter> data, Function2<? super View, ? super TagFilter, Unit> onPickerItemCreatedCallback, final Function1<? super Integer, Unit> onRuleSelected) {
        final SearchTagPickerView searchTagPickerView = new SearchTagPickerView(context);
        searchTagPickerView.setId(View.generateViewId());
        searchTagPickerView.setVisibility(8);
        parent.addView(searchTagPickerView, new FrameLayout.LayoutParams(-1, -2));
        searchTagPickerView.setData(data, onPickerItemCreatedCallback);
        searchTagPickerView.setOnTagSelectedCallback(new Function2<Integer, TagFilter, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.part.TroopTabFilterPart$createTagPickerView$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, TagFilter tagFilter) {
                invoke(num.intValue(), tagFilter);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, @NotNull TagFilter filter) {
                Intrinsics.checkNotNullParameter(filter, "filter");
                onRuleSelected.invoke(Integer.valueOf(i3));
                filterButton.setText(filter.getName());
                filterButton.setSelected(false);
                this.C9().f405749b.setVisibility(8);
                searchTagPickerView.setVisibility(8);
            }
        });
        return searchTagPickerView;
    }

    private final SearchPlacePickerView V9(Context context, FrameLayout pickerContainer, List<ProvinceFilter> placeData, final ConditionInfo condition, final SearchDetailTroopTabViewModel vm5) {
        SearchFilterButton searchFilterButton = this.placeFilterButton;
        if (searchFilterButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("placeFilterButton");
            searchFilterButton = null;
        }
        return T9(context, pickerContainer, searchFilterButton, placeData, new Function2<View, String, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.part.TroopTabFilterPart$initPlacePickerView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view, String str) {
                invoke2(view, str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View view, @NotNull String filter) {
                com.tencent.mobileqq.search.searchdetail.content.viewmodel.k kVar;
                String str;
                com.tencent.mobileqq.search.searchdetail.content.viewmodel.k kVar2;
                Map mapOf;
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(filter, "filter");
                TroopTabFilterPart troopTabFilterPart = TroopTabFilterPart.this;
                Pair[] pairArr = new Pair[4];
                kVar = troopTabFilterPart.viewModel;
                SearchDetailTabContentFragment.PageData pageData = kVar.getPageData();
                if (pageData == null || (str = pageData.getKeyword()) == null) {
                    str = "";
                }
                pairArr[0] = TuplesKt.to("search_query_text", str);
                kVar2 = TroopTabFilterPart.this.viewModel;
                SearchDetailTabContentFragment.PageData pageData2 = kVar2.getPageData();
                pairArr[1] = TuplesKt.to("query_source", Integer.valueOf(pageData2 != null ? pageData2.getQuerySource() : 0));
                pairArr[2] = TuplesKt.to("first_tag", 3);
                pairArr[3] = TuplesKt.to("tag_text", filter);
                mapOf = MapsKt__MapsKt.mapOf(pairArr);
                BaseSearchTabFilterPart.H9(troopTabFilterPart, view, "em_bas_group_search_secondary_tag", mapOf, null, false, false, 24, null);
            }
        }, new Function3<Integer, Integer, Integer, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.part.TroopTabFilterPart$initPlacePickerView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2, Integer num3) {
                invoke(num.intValue(), num2.intValue(), num3.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, int i16, int i17) {
                String text;
                SearchFilterButton searchFilterButton2;
                Province province = ConditionInfo.this.a().get(i3);
                Intrinsics.checkNotNullExpressionValue(province, "condition.places[provinceIndex]");
                Province province2 = province;
                City city = province2.a().get(i16);
                District district = city.a().get(i17);
                boolean z16 = !Intrinsics.areEqual(city.getText(), IProfileCardConst.NAME_NO_LIMIT);
                boolean z17 = !Intrinsics.areEqual(district.getText(), IProfileCardConst.NAME_NO_LIMIT);
                if (z16) {
                    text = z17 ? district.getText() : city.getText();
                } else {
                    text = province2.getText();
                }
                searchFilterButton2 = this.placeFilterButton;
                if (searchFilterButton2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("placeFilterButton");
                    searchFilterButton2 = null;
                }
                searchFilterButton2.setText(text);
                SearchDetailTroopTabViewModel searchDetailTroopTabViewModel = vm5;
                Activity activity = this.getActivity();
                Intrinsics.checkNotNullExpressionValue(activity, "activity");
                searchDetailTroopTabViewModel.b3(activity, new com.tencent.mobileqq.search.searchdetail.content.viewmodel.e(province2, city, district));
            }
        });
    }

    private final SearchRulePickerView W9(Context context, FrameLayout pickerContainer, List<RuleFilter> sortRulesData, final SearchDetailTroopTabViewModel vm5, final ConditionInfo condition) {
        SearchFilterButton searchFilterButton = this.sortFilterButton;
        if (searchFilterButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sortFilterButton");
            searchFilterButton = null;
        }
        return B9(context, pickerContainer, searchFilterButton, sortRulesData, new Function2<View, RuleFilter, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.part.TroopTabFilterPart$initRulePickerView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view, RuleFilter ruleFilter) {
                invoke2(view, ruleFilter);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View view, @NotNull RuleFilter filter) {
                com.tencent.mobileqq.search.searchdetail.content.viewmodel.k kVar;
                String str;
                com.tencent.mobileqq.search.searchdetail.content.viewmodel.k kVar2;
                Map mapOf;
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(filter, "filter");
                TroopTabFilterPart troopTabFilterPart = TroopTabFilterPart.this;
                Pair[] pairArr = new Pair[4];
                kVar = troopTabFilterPart.viewModel;
                SearchDetailTabContentFragment.PageData pageData = kVar.getPageData();
                if (pageData == null || (str = pageData.getKeyword()) == null) {
                    str = "";
                }
                pairArr[0] = TuplesKt.to("search_query_text", str);
                kVar2 = TroopTabFilterPart.this.viewModel;
                SearchDetailTabContentFragment.PageData pageData2 = kVar2.getPageData();
                pairArr[1] = TuplesKt.to("query_source", Integer.valueOf(pageData2 != null ? pageData2.getQuerySource() : 0));
                pairArr[2] = TuplesKt.to("first_tag", 1);
                pairArr[3] = TuplesKt.to("tag_text", filter.getName());
                mapOf = MapsKt__MapsKt.mapOf(pairArr);
                BaseSearchTabFilterPart.H9(troopTabFilterPart, view, "em_bas_group_search_secondary_tag", mapOf, null, false, false, 24, null);
            }
        }, new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.part.TroopTabFilterPart$initRulePickerView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i3) {
                SearchDetailTroopTabViewModel searchDetailTroopTabViewModel = SearchDetailTroopTabViewModel.this;
                Activity activity = this.getActivity();
                Intrinsics.checkNotNullExpressionValue(activity, "activity");
                SortRule sortRule = condition.b().get(i3);
                Intrinsics.checkNotNullExpressionValue(sortRule, "condition.sortRules[index]");
                searchDetailTroopTabViewModel.c3(activity, sortRule);
            }
        });
    }

    private final SearchTagPickerView X9(Context context, FrameLayout pickerContainer, List<TagFilter> tagsData, final SearchDetailTroopTabViewModel vm5, final ConditionInfo condition) {
        SearchFilterButton searchFilterButton = this.tagFilterButton;
        if (searchFilterButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tagFilterButton");
            searchFilterButton = null;
        }
        return U9(context, pickerContainer, searchFilterButton, tagsData, new Function2<View, TagFilter, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.part.TroopTabFilterPart$initTagPickerView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view, TagFilter tagFilter) {
                invoke2(view, tagFilter);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View view, @NotNull TagFilter filter) {
                com.tencent.mobileqq.search.searchdetail.content.viewmodel.k kVar;
                String str;
                com.tencent.mobileqq.search.searchdetail.content.viewmodel.k kVar2;
                Map mapOf;
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(filter, "filter");
                TroopTabFilterPart troopTabFilterPart = TroopTabFilterPart.this;
                Pair[] pairArr = new Pair[4];
                kVar = troopTabFilterPart.viewModel;
                SearchDetailTabContentFragment.PageData pageData = kVar.getPageData();
                if (pageData == null || (str = pageData.getKeyword()) == null) {
                    str = "";
                }
                pairArr[0] = TuplesKt.to("search_query_text", str);
                kVar2 = TroopTabFilterPart.this.viewModel;
                SearchDetailTabContentFragment.PageData pageData2 = kVar2.getPageData();
                pairArr[1] = TuplesKt.to("query_source", Integer.valueOf(pageData2 != null ? pageData2.getQuerySource() : 0));
                pairArr[2] = TuplesKt.to("first_tag", 2);
                pairArr[3] = TuplesKt.to("tag_text", filter.getName());
                mapOf = MapsKt__MapsKt.mapOf(pairArr);
                BaseSearchTabFilterPart.H9(troopTabFilterPart, view, "em_bas_group_search_secondary_tag", mapOf, null, false, false, 24, null);
            }
        }, new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.part.TroopTabFilterPart$initTagPickerView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i3) {
                SearchDetailTroopTabViewModel searchDetailTroopTabViewModel = SearchDetailTroopTabViewModel.this;
                Activity activity = this.getActivity();
                Intrinsics.checkNotNullExpressionValue(activity, "activity");
                searchDetailTroopTabViewModel.d3(activity, condition.c().get(i3).getText());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z9(TroopTabFilterPart this$0, SearchDetailTroopTabViewModel vm5, Context context, FrameLayout pickerContainer, View view) {
        int collectionSizeOrDefault;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(vm5, "$vm");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(pickerContainer, "$pickerContainer");
        View view2 = this$0.tagFilterPickerView;
        SearchFilterButton searchFilterButton = null;
        if (view2 != null) {
            SearchFilterButton searchFilterButton2 = this$0.tagFilterButton;
            if (searchFilterButton2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tagFilterButton");
            } else {
                searchFilterButton = searchFilterButton2;
            }
            this$0.E9(searchFilterButton, view2);
        } else {
            ConditionInfo value = vm5.V2().getValue();
            if (value != null) {
                ArrayList<TroopLabel> c16 = value.c();
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(c16, 10);
                List<TagFilter> arrayList = new ArrayList<>(collectionSizeOrDefault);
                Iterator<T> it = c16.iterator();
                while (it.hasNext()) {
                    arrayList.add(new TagFilter(((TroopLabel) it.next()).getText()));
                }
                SearchTagPickerView X9 = this$0.X9(context, pickerContainer, arrayList, vm5, value);
                this$0.tagFilterPickerView = X9;
                if (X9 != null) {
                    SearchFilterButton searchFilterButton3 = this$0.tagFilterButton;
                    if (searchFilterButton3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("tagFilterButton");
                    } else {
                        searchFilterButton = searchFilterButton3;
                    }
                    this$0.E9(searchFilterButton, X9);
                }
            } else {
                Logger.f235387a.d().w("QQSearch.NetDetail.TroopTabFilterPart", 1, "tagFilterPickerView not init");
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map aa(TroopTabFilterPart this$0, String str) {
        String str2;
        Map mapOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Pair[] pairArr = new Pair[3];
        SearchDetailTabContentFragment.PageData pageData = this$0.viewModel.getPageData();
        if (pageData == null || (str2 = pageData.getKeyword()) == null) {
            str2 = "";
        }
        int i3 = 0;
        pairArr[0] = TuplesKt.to("search_query_text", str2);
        SearchDetailTabContentFragment.PageData pageData2 = this$0.viewModel.getPageData();
        if (pageData2 != null) {
            i3 = pageData2.getQuerySource();
        }
        pairArr[1] = TuplesKt.to("query_source", Integer.valueOf(i3));
        pairArr[2] = TuplesKt.to("first_tag", 2);
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        return mapOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ba(TroopTabFilterPart this$0, SearchDetailTroopTabViewModel vm5, Context context, FrameLayout pickerContainer, View view) {
        int collectionSizeOrDefault;
        SearchFilterButton searchFilterButton;
        int collectionSizeOrDefault2;
        int collectionSizeOrDefault3;
        SearchFilterButton searchFilterButton2;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(vm5, "$vm");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(pickerContainer, "$pickerContainer");
        View view2 = this$0.placePickerView;
        if (view2 != null) {
            SearchFilterButton searchFilterButton3 = this$0.placeFilterButton;
            if (searchFilterButton3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("placeFilterButton");
                searchFilterButton2 = null;
            } else {
                searchFilterButton2 = searchFilterButton3;
            }
            this$0.E9(searchFilterButton2, view2);
        } else {
            ConditionInfo value = vm5.V2().getValue();
            if (value != null) {
                ArrayList<Province> a16 = value.a();
                int i3 = 10;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(a16, 10);
                List<ProvinceFilter> arrayList = new ArrayList<>(collectionSizeOrDefault);
                Iterator it = a16.iterator();
                while (it.hasNext()) {
                    Province province = (Province) it.next();
                    String text = province.getText();
                    List<City> a17 = province.a();
                    collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(a17, i3);
                    ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
                    for (City city : a17) {
                        String text2 = city.getText();
                        List<District> a18 = city.a();
                        Iterator it5 = it;
                        collectionSizeOrDefault3 = CollectionsKt__IterablesKt.collectionSizeOrDefault(a18, i3);
                        ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault3);
                        Iterator<T> it6 = a18.iterator();
                        while (it6.hasNext()) {
                            arrayList3.add(new DistrictFilter(((District) it6.next()).getText()));
                        }
                        arrayList2.add(new CityFilter(text2, arrayList3));
                        it = it5;
                        i3 = 10;
                    }
                    arrayList.add(new ProvinceFilter(text, arrayList2));
                    it = it;
                    i3 = 10;
                }
                SearchPlacePickerView V9 = this$0.V9(context, pickerContainer, arrayList, value, vm5);
                this$0.placePickerView = V9;
                if (V9 != null) {
                    SearchFilterButton searchFilterButton4 = this$0.placeFilterButton;
                    if (searchFilterButton4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("placeFilterButton");
                        searchFilterButton = null;
                    } else {
                        searchFilterButton = searchFilterButton4;
                    }
                    this$0.E9(searchFilterButton, V9);
                }
            } else {
                Logger.f235387a.d().w("QQSearch.NetDetail.TroopTabFilterPart", 1, "placePickerView not init");
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ca(TroopTabFilterPart this$0, SearchDetailTroopTabViewModel vm5, Context context, FrameLayout pickerContainer, View view) {
        int collectionSizeOrDefault;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(vm5, "$vm");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(pickerContainer, "$pickerContainer");
        View view2 = this$0.sortFilterPickerView;
        SearchFilterButton searchFilterButton = null;
        if (view2 != null) {
            SearchFilterButton searchFilterButton2 = this$0.sortFilterButton;
            if (searchFilterButton2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sortFilterButton");
            } else {
                searchFilterButton = searchFilterButton2;
            }
            this$0.E9(searchFilterButton, view2);
        } else {
            ConditionInfo value = vm5.V2().getValue();
            if (value != null) {
                ArrayList<SortRule> b16 = value.b();
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(b16, 10);
                List<RuleFilter> arrayList = new ArrayList<>(collectionSizeOrDefault);
                Iterator<T> it = b16.iterator();
                while (it.hasNext()) {
                    arrayList.add(new RuleFilter(((SortRule) it.next()).getText()));
                }
                SearchRulePickerView W9 = this$0.W9(context, pickerContainer, arrayList, vm5, value);
                this$0.sortFilterPickerView = W9;
                if (W9 != null) {
                    SearchFilterButton searchFilterButton3 = this$0.sortFilterButton;
                    if (searchFilterButton3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("sortFilterButton");
                    } else {
                        searchFilterButton = searchFilterButton3;
                    }
                    this$0.E9(searchFilterButton, W9);
                }
            } else {
                Logger.f235387a.d().w("QQSearch.NetDetail.TroopTabFilterPart", 1, "sortFilterPickerView not init");
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map da(TroopTabFilterPart this$0, String str) {
        String str2;
        Map mapOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Pair[] pairArr = new Pair[3];
        SearchDetailTabContentFragment.PageData pageData = this$0.viewModel.getPageData();
        if (pageData == null || (str2 = pageData.getKeyword()) == null) {
            str2 = "";
        }
        int i3 = 0;
        pairArr[0] = TuplesKt.to("search_query_text", str2);
        SearchDetailTabContentFragment.PageData pageData2 = this$0.viewModel.getPageData();
        if (pageData2 != null) {
            i3 = pageData2.getQuerySource();
        }
        pairArr[1] = TuplesKt.to("query_source", Integer.valueOf(i3));
        pairArr[2] = TuplesKt.to("first_tag", 1);
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        return mapOf;
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.part.BaseSearchTabFilterPart
    /* renamed from: Y9, reason: merged with bridge method [inline-methods] */
    public void L9(@NotNull final Context context, @NotNull final SearchDetailTroopTabViewModel vm5) {
        SearchFilterButton searchFilterButton;
        SearchFilterButton searchFilterButton2;
        SearchFilterButton searchFilterButton3;
        String str;
        Map mapOf;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(vm5, "vm");
        ConstraintLayout constraintLayout = D9().f405747i;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "parentBinding.searchFilterHeader");
        this.sortFilterButton = A9(context, constraintLayout, com.tencent.mobileqq.search.searchdetail.content.viewmodel.l.a().getText());
        ConstraintLayout constraintLayout2 = D9().f405747i;
        Intrinsics.checkNotNullExpressionValue(constraintLayout2, "parentBinding.searchFilterHeader");
        this.tagFilterButton = A9(context, constraintLayout2, com.tencent.mobileqq.search.searchdetail.content.viewmodel.l.b().getText());
        ConstraintLayout constraintLayout3 = D9().f405747i;
        Intrinsics.checkNotNullExpressionValue(constraintLayout3, "parentBinding.searchFilterHeader");
        this.placeFilterButton = A9(context, constraintLayout3, com.tencent.mobileqq.search.searchdetail.content.viewmodel.l.e().getText());
        ConstraintLayout constraintLayout4 = D9().f405747i;
        Intrinsics.checkNotNullExpressionValue(constraintLayout4, "parentBinding.searchFilterHeader");
        com.tencent.mobileqq.search.util.l.f(constraintLayout4, 3, bj.a(8), 0, 0, false, 28, null);
        final FrameLayout frameLayout = C9().f405749b;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "filterContentBinding.container");
        vm5.a3();
        SearchFilterButton searchFilterButton4 = this.sortFilterButton;
        if (searchFilterButton4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sortFilterButton");
            searchFilterButton = null;
        } else {
            searchFilterButton = searchFilterButton4;
        }
        searchFilterButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.searchdetail.content.part.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopTabFilterPart.ca(TroopTabFilterPart.this, vm5, context, frameLayout, view);
            }
        });
        BaseSearchTabFilterPart.H9(this, searchFilterButton, "em_bas_group_screening_box", null, new IDynamicParams() { // from class: com.tencent.mobileqq.search.searchdetail.content.part.x
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str2) {
                Map da5;
                da5 = TroopTabFilterPart.da(TroopTabFilterPart.this, str2);
                return da5;
            }
        }, false, false, 52, null);
        SearchFilterButton searchFilterButton5 = this.tagFilterButton;
        if (searchFilterButton5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tagFilterButton");
            searchFilterButton2 = null;
        } else {
            searchFilterButton2 = searchFilterButton5;
        }
        searchFilterButton2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.searchdetail.content.part.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopTabFilterPart.Z9(TroopTabFilterPart.this, vm5, context, frameLayout, view);
            }
        });
        BaseSearchTabFilterPart.H9(this, searchFilterButton2, "em_bas_group_screening_box", null, new IDynamicParams() { // from class: com.tencent.mobileqq.search.searchdetail.content.part.z
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str2) {
                Map aa5;
                aa5 = TroopTabFilterPart.aa(TroopTabFilterPart.this, str2);
                return aa5;
            }
        }, false, false, 52, null);
        SearchFilterButton searchFilterButton6 = this.placeFilterButton;
        if (searchFilterButton6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("placeFilterButton");
            searchFilterButton3 = null;
        } else {
            searchFilterButton3 = searchFilterButton6;
        }
        searchFilterButton3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.searchdetail.content.part.aa
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopTabFilterPart.ba(TroopTabFilterPart.this, vm5, context, frameLayout, view);
            }
        });
        Pair[] pairArr = new Pair[3];
        SearchDetailTabContentFragment.PageData pageData = this.viewModel.getPageData();
        if (pageData == null || (str = pageData.getKeyword()) == null) {
            str = "";
        }
        int i3 = 0;
        pairArr[0] = TuplesKt.to("search_query_text", str);
        SearchDetailTabContentFragment.PageData pageData2 = this.viewModel.getPageData();
        if (pageData2 != null) {
            i3 = pageData2.getQuerySource();
        }
        pairArr[1] = TuplesKt.to("query_source", Integer.valueOf(i3));
        pairArr[2] = TuplesKt.to("first_tag", 3);
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        BaseSearchTabFilterPart.H9(this, searchFilterButton3, "em_bas_group_screening_box", mapOf, null, false, false, 56, null);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean isPartEnable() {
        return this.viewModel instanceof SearchDetailTroopTabViewModel;
    }
}
