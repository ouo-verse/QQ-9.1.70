package com.tencent.mobileqq.search.searchdetail.content.part;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.widgets.bj;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.search.searchdetail.content.viewmodel.ContentRule;
import com.tencent.mobileqq.search.searchdetail.content.viewmodel.RankRule;
import com.tencent.mobileqq.search.searchdetail.filter.RuleFilter;
import com.tencent.mobileqq.search.searchdetail.filter.SearchFilterButton;
import com.tencent.mobileqq.search.searchdetail.filter.SearchRulePickerView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB\u000f\u0012\u0006\u0010\r\u001a\u00020\n\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/part/ChannelTabFilterPart;", "Lcom/tencent/mobileqq/search/searchdetail/content/part/BaseSearchTabFilterPart;", "Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/h;", "", "isPartEnable", "Landroid/content/Context;", "context", "vm", "", "O9", "Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/k;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/k;", "viewModel", "Lcom/tencent/mobileqq/search/searchdetail/filter/SearchFilterButton;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/search/searchdetail/filter/SearchFilterButton;", "rankFilterButton", "D", "contentFilterButton", "Lcom/tencent/mobileqq/search/searchdetail/filter/SearchRulePickerView;", "E", "Lcom/tencent/mobileqq/search/searchdetail/filter/SearchRulePickerView;", "rankRulePickerView", UserInfo.SEX_FEMALE, "contentRulePickerView", "<init>", "(Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/k;)V", "G", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class ChannelTabFilterPart extends BaseSearchTabFilterPart<com.tencent.mobileqq.search.searchdetail.content.viewmodel.h> {

    /* renamed from: C, reason: from kotlin metadata */
    private SearchFilterButton rankFilterButton;

    /* renamed from: D, reason: from kotlin metadata */
    private SearchFilterButton contentFilterButton;

    /* renamed from: E, reason: from kotlin metadata */
    private SearchRulePickerView rankRulePickerView;

    /* renamed from: F, reason: from kotlin metadata */
    private SearchRulePickerView contentRulePickerView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.search.searchdetail.content.viewmodel.k viewModel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelTabFilterPart(@NotNull com.tencent.mobileqq.search.searchdetail.content.viewmodel.k viewModel) {
        super(viewModel);
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.viewModel = viewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(ChannelTabFilterPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SearchFilterButton searchFilterButton = this$0.rankFilterButton;
        SearchRulePickerView searchRulePickerView = null;
        if (searchFilterButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rankFilterButton");
            searchFilterButton = null;
        }
        SearchRulePickerView searchRulePickerView2 = this$0.rankRulePickerView;
        if (searchRulePickerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rankRulePickerView");
        } else {
            searchRulePickerView = searchRulePickerView2;
        }
        this$0.E9(searchFilterButton, searchRulePickerView);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(ChannelTabFilterPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SearchFilterButton searchFilterButton = this$0.contentFilterButton;
        SearchRulePickerView searchRulePickerView = null;
        if (searchFilterButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentFilterButton");
            searchFilterButton = null;
        }
        SearchRulePickerView searchRulePickerView2 = this$0.contentRulePickerView;
        if (searchRulePickerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentRulePickerView");
        } else {
            searchRulePickerView = searchRulePickerView2;
        }
        this$0.E9(searchFilterButton, searchRulePickerView);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.part.BaseSearchTabFilterPart
    /* renamed from: O9, reason: merged with bridge method [inline-methods] */
    public void L9(@NotNull Context context, @NotNull final com.tencent.mobileqq.search.searchdetail.content.viewmodel.h vm5) {
        Object first;
        Object first2;
        int collectionSizeOrDefault;
        SearchFilterButton searchFilterButton;
        int collectionSizeOrDefault2;
        SearchFilterButton searchFilterButton2;
        SearchFilterButton searchFilterButton3;
        Map mapOf;
        SearchFilterButton searchFilterButton4;
        Map mapOf2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(vm5, "vm");
        ConstraintLayout constraintLayout = D9().f405747i;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "parentBinding.searchFilterHeader");
        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) vm5.W2());
        this.rankFilterButton = A9(context, constraintLayout, ((RankRule) first).getText());
        first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) vm5.V2());
        this.contentFilterButton = A9(context, constraintLayout, ((ContentRule) first2).getText());
        com.tencent.mobileqq.search.util.l.f(constraintLayout, 3, bj.a(8), 0, 0, false, 28, null);
        FrameLayout frameLayout = C9().f405749b;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "filterContentBinding.container");
        List<RankRule> W2 = vm5.W2();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(W2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = W2.iterator();
        while (it.hasNext()) {
            arrayList.add(new RuleFilter(((RankRule) it.next()).getText()));
        }
        SearchFilterButton searchFilterButton5 = this.rankFilterButton;
        if (searchFilterButton5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rankFilterButton");
            searchFilterButton = null;
        } else {
            searchFilterButton = searchFilterButton5;
        }
        this.rankRulePickerView = B9(context, frameLayout, searchFilterButton, arrayList, new Function2<View, RuleFilter, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.part.ChannelTabFilterPart$setupFilterView$1
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
                Map mapOf3;
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(filter, "filter");
                ChannelTabFilterPart channelTabFilterPart = ChannelTabFilterPart.this;
                mapOf3 = MapsKt__MapsKt.mapOf(TuplesKt.to("sort_type", 0), TuplesKt.to("filter_tag", filter.getName()));
                BaseSearchTabFilterPart.H9(channelTabFilterPart, view, "em_bas_screening_panel", mapOf3, null, false, false, 56, null);
            }
        }, new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.part.ChannelTabFilterPart$setupFilterView$2
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
                com.tencent.mobileqq.search.searchdetail.content.viewmodel.h hVar = com.tencent.mobileqq.search.searchdetail.content.viewmodel.h.this;
                Activity activity = this.getActivity();
                Intrinsics.checkNotNullExpressionValue(activity, "activity");
                hVar.a3(activity, com.tencent.mobileqq.search.searchdetail.content.viewmodel.h.this.W2().get(i3));
            }
        });
        List<ContentRule> V2 = vm5.V2();
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(V2, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
        Iterator<T> it5 = V2.iterator();
        while (it5.hasNext()) {
            arrayList2.add(new RuleFilter(((ContentRule) it5.next()).getText()));
        }
        SearchFilterButton searchFilterButton6 = this.contentFilterButton;
        if (searchFilterButton6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentFilterButton");
            searchFilterButton2 = null;
        } else {
            searchFilterButton2 = searchFilterButton6;
        }
        this.contentRulePickerView = B9(context, frameLayout, searchFilterButton2, arrayList2, new Function2<View, RuleFilter, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.part.ChannelTabFilterPart$setupFilterView$3
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
                Map mapOf3;
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(filter, "filter");
                ChannelTabFilterPart channelTabFilterPart = ChannelTabFilterPart.this;
                mapOf3 = MapsKt__MapsKt.mapOf(TuplesKt.to("sort_type", 1), TuplesKt.to("filter_tag", filter.getName()));
                BaseSearchTabFilterPart.H9(channelTabFilterPart, view, "em_bas_screening_panel", mapOf3, null, false, false, 56, null);
            }
        }, new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.part.ChannelTabFilterPart$setupFilterView$4
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
                com.tencent.mobileqq.search.searchdetail.content.viewmodel.h hVar = com.tencent.mobileqq.search.searchdetail.content.viewmodel.h.this;
                Activity activity = this.getActivity();
                Intrinsics.checkNotNullExpressionValue(activity, "activity");
                hVar.Y2(activity, com.tencent.mobileqq.search.searchdetail.content.viewmodel.h.this.V2().get(i3));
            }
        });
        SearchFilterButton searchFilterButton7 = this.rankFilterButton;
        if (searchFilterButton7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rankFilterButton");
            searchFilterButton3 = null;
        } else {
            searchFilterButton3 = searchFilterButton7;
        }
        searchFilterButton3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.searchdetail.content.part.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChannelTabFilterPart.P9(ChannelTabFilterPart.this, view);
            }
        });
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sort_type", 0));
        BaseSearchTabFilterPart.H9(this, searchFilterButton3, "em_bas_channel_tab_sort_area", mapOf, null, false, false, 56, null);
        SearchFilterButton searchFilterButton8 = this.contentFilterButton;
        if (searchFilterButton8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentFilterButton");
            searchFilterButton4 = null;
        } else {
            searchFilterButton4 = searchFilterButton8;
        }
        searchFilterButton4.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.searchdetail.content.part.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChannelTabFilterPart.Q9(ChannelTabFilterPart.this, view);
            }
        });
        mapOf2 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sort_type", 1));
        BaseSearchTabFilterPart.H9(this, searchFilterButton4, "em_bas_channel_tab_sort_area", mapOf2, null, false, false, 56, null);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean isPartEnable() {
        return this.viewModel instanceof com.tencent.mobileqq.search.searchdetail.content.viewmodel.h;
    }
}
