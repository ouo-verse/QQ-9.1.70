package com.tencent.mobileqq.search.searchdetail.content.part;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.widgets.bj;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.search.searchdetail.content.viewmodel.k;
import com.tencent.mobileqq.search.searchdetail.filter.RuleFilter;
import com.tencent.mobileqq.search.searchdetail.filter.SearchFilterButton;
import com.tencent.mobileqq.search.searchdetail.filter.SearchRulePickerView;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import cooperation.qzone.QZoneShareManager;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0018\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u000f\u0012\u0006\u0010/\u001a\u00020\u0001\u00a2\u0006\u0004\bN\u0010OJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001f\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fJZ\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00112\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0018\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00060\u00182\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00060\u001aJ\u0016\u0010!\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u0004JL\u0010,\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u000f2\u0014\b\u0002\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020%0$2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'2\b\b\u0002\u0010*\u001a\u00020)2\b\b\u0002\u0010+\u001a\u00020)R\u0014\u0010/\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\"\u00107\u001a\u0002008\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u0010?\u001a\u0002088\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R$\u0010F\u001a\u0004\u0018\u00010\u00118\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER$\u0010M\u001a\u0004\u0018\u00010\u00048\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010L\u00a8\u0006P"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/part/BaseSearchTabFilterPart;", "Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/k;", "T", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "Landroid/content/Context;", "context", "vm", "L9", "(Landroid/content/Context;Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/k;)V", "Landroidx/constraintlayout/widget/ConstraintLayout;", HippyNestedScrollComponent.PRIORITY_PARENT, "", QZoneShareManager.QZONE_SHARE_VIDEO_TEXT, "Lcom/tencent/mobileqq/search/searchdetail/filter/SearchFilterButton;", "A9", "Landroid/widget/FrameLayout;", "filterButton", "", "Lcom/tencent/mobileqq/search/searchdetail/filter/e;", "data", "Lkotlin/Function2;", "onPickerItemCreatedCallback", "Lkotlin/Function1;", "", "onRuleSelected", "Lcom/tencent/mobileqq/search/searchdetail/filter/SearchRulePickerView;", "B9", "button", "filterView", "E9", "view", "eid", "", "", "params", "Lcom/tencent/qqlive/module/videoreport/data/IDynamicParams;", "dynamicParams", "", "needAsync", "enableImpression", "G9", "d", "Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/k;", "viewModel", "Lhp2/s;", "e", "Lhp2/s;", "D9", "()Lhp2/s;", "K9", "(Lhp2/s;)V", "parentBinding", "Lhp2/t;", "f", "Lhp2/t;", "C9", "()Lhp2/t;", "J9", "(Lhp2/t;)V", "filterContentBinding", tl.h.F, "Lcom/tencent/mobileqq/search/searchdetail/filter/SearchFilterButton;", "getPreviousSelectedFilterButton", "()Lcom/tencent/mobileqq/search/searchdetail/filter/SearchFilterButton;", "setPreviousSelectedFilterButton", "(Lcom/tencent/mobileqq/search/searchdetail/filter/SearchFilterButton;)V", "previousSelectedFilterButton", "i", "Landroid/view/View;", "getPreviousPickerView", "()Landroid/view/View;", "setPreviousPickerView", "(Landroid/view/View;)V", "previousPickerView", "<init>", "(Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/k;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public abstract class BaseSearchTabFilterPart<T extends com.tencent.mobileqq.search.searchdetail.content.viewmodel.k> extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.search.searchdetail.content.viewmodel.k viewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    protected hp2.s parentBinding;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    protected hp2.t filterContentBinding;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private SearchFilterButton previousSelectedFilterButton;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View previousPickerView;

    public BaseSearchTabFilterPart(@NotNull com.tencent.mobileqq.search.searchdetail.content.viewmodel.k viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.viewModel = viewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(BaseSearchTabFilterPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SearchFilterButton searchFilterButton = this$0.previousSelectedFilterButton;
        if (searchFilterButton != null) {
            searchFilterButton.setSelected(false);
        }
        View view2 = this$0.previousPickerView;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        this$0.C9().f405749b.setVisibility(8);
        EventCollector.getInstance().onViewClicked(view);
    }

    public static /* synthetic */ void H9(BaseSearchTabFilterPart baseSearchTabFilterPart, View view, String str, Map map, IDynamicParams iDynamicParams, boolean z16, boolean z17, int i3, Object obj) {
        boolean z18;
        boolean z19;
        if (obj == null) {
            if ((i3 & 4) != 0) {
                map = MapsKt__MapsKt.emptyMap();
            }
            Map map2 = map;
            if ((i3 & 8) != 0) {
                iDynamicParams = null;
            }
            IDynamicParams iDynamicParams2 = iDynamicParams;
            if ((i3 & 16) != 0) {
                z18 = true;
            } else {
                z18 = z16;
            }
            if ((i3 & 32) != 0) {
                z19 = true;
            } else {
                z19 = z17;
            }
            baseSearchTabFilterPart.G9(view, str, map2, iDynamicParams2, z18, z19);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: report");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(View view, String eid, boolean z16, Map params, IDynamicParams iDynamicParams) {
        Intrinsics.checkNotNullParameter(view, "$view");
        Intrinsics.checkNotNullParameter(eid, "$eid");
        Intrinsics.checkNotNullParameter(params, "$params");
        VideoReport.setElementId(view, eid);
        if (!z16) {
            VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        }
        if (!params.isEmpty()) {
            VideoReport.setElementParams(view, params);
        }
        if (iDynamicParams != null) {
            VideoReport.setEventDynamicParams(view, iDynamicParams);
        }
    }

    @NotNull
    public final SearchFilterButton A9(@NotNull Context context, @NotNull ConstraintLayout parent, @NotNull String defaultText) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(defaultText, "defaultText");
        SearchFilterButton searchFilterButton = new SearchFilterButton(context, null, 2, null);
        searchFilterButton.setId(View.generateViewId());
        searchFilterButton.setText(defaultText);
        parent.addView(searchFilterButton, new ConstraintLayout.LayoutParams(0, bj.a(36)));
        return searchFilterButton;
    }

    @NotNull
    public final SearchRulePickerView B9(@NotNull Context context, @NotNull FrameLayout parent, @NotNull final SearchFilterButton filterButton, @NotNull List<RuleFilter> data, @NotNull Function2<? super View, ? super RuleFilter, Unit> onPickerItemCreatedCallback, @NotNull final Function1<? super Integer, Unit> onRuleSelected) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(filterButton, "filterButton");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(onPickerItemCreatedCallback, "onPickerItemCreatedCallback");
        Intrinsics.checkNotNullParameter(onRuleSelected, "onRuleSelected");
        final SearchRulePickerView searchRulePickerView = new SearchRulePickerView(context);
        searchRulePickerView.setId(View.generateViewId());
        searchRulePickerView.setVisibility(8);
        parent.addView(searchRulePickerView, new FrameLayout.LayoutParams(-1, -2));
        searchRulePickerView.setData(data, 0, onPickerItemCreatedCallback);
        searchRulePickerView.setOnRuleSelectedCallback(new Function2<Integer, RuleFilter, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.part.BaseSearchTabFilterPart$createRulePickerView$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, RuleFilter ruleFilter) {
                invoke(num.intValue(), ruleFilter);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, @NotNull RuleFilter filter) {
                Intrinsics.checkNotNullParameter(filter, "filter");
                onRuleSelected.invoke(Integer.valueOf(i3));
                filterButton.setText(filter.getName());
                filterButton.setSelected(false);
                this.C9().f405749b.setVisibility(8);
                searchRulePickerView.setVisibility(8);
            }
        });
        return searchRulePickerView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final hp2.t C9() {
        hp2.t tVar = this.filterContentBinding;
        if (tVar != null) {
            return tVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("filterContentBinding");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final hp2.s D9() {
        hp2.s sVar = this.parentBinding;
        if (sVar != null) {
            return sVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("parentBinding");
        return null;
    }

    public final void E9(@NotNull SearchFilterButton button, @NotNull View filterView) {
        View view;
        SearchFilterButton searchFilterButton;
        Intrinsics.checkNotNullParameter(button, "button");
        Intrinsics.checkNotNullParameter(filterView, "filterView");
        boolean z16 = true;
        button.setSelected(!button.isSelected());
        if (!Intrinsics.areEqual(button, this.previousSelectedFilterButton)) {
            SearchFilterButton searchFilterButton2 = this.previousSelectedFilterButton;
            if (searchFilterButton2 == null || !searchFilterButton2.isSelected()) {
                z16 = false;
            }
            if (z16 && (searchFilterButton = this.previousSelectedFilterButton) != null) {
                searchFilterButton.setSelected(false);
            }
        }
        this.previousSelectedFilterButton = button;
        FrameLayout frameLayout = C9().f405749b;
        Boolean valueOf = Boolean.valueOf(button.isSelected());
        frameLayout.setVisibility(0);
        if (((View) com.tencent.guild.aio.util.ex.g.a(valueOf, frameLayout)) == null) {
            frameLayout.setVisibility(8);
        }
        Boolean valueOf2 = Boolean.valueOf(button.isSelected());
        filterView.setVisibility(0);
        if (((View) com.tencent.guild.aio.util.ex.g.a(valueOf2, filterView)) == null) {
            filterView.setVisibility(8);
        }
        if (!Intrinsics.areEqual(filterView, this.previousPickerView) && (view = this.previousPickerView) != null) {
            view.setVisibility(8);
        }
        this.previousPickerView = filterView;
    }

    public final void G9(@NotNull final View view, @NotNull final String eid, @NotNull final Map<String, ? extends Object> params, @Nullable final IDynamicParams dynamicParams, boolean needAsync, final boolean enableImpression) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(eid, "eid");
        Intrinsics.checkNotNullParameter(params, "params");
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.search.searchdetail.content.part.b
            @Override // java.lang.Runnable
            public final void run() {
                BaseSearchTabFilterPart.I9(view, eid, enableImpression, params, dynamicParams);
            }
        };
        if (needAsync) {
            view.post(runnable);
        } else {
            runnable.run();
        }
    }

    protected final void J9(@NotNull hp2.t tVar) {
        Intrinsics.checkNotNullParameter(tVar, "<set-?>");
        this.filterContentBinding = tVar;
    }

    protected final void K9(@NotNull hp2.s sVar) {
        Intrinsics.checkNotNullParameter(sVar, "<set-?>");
        this.parentBinding = sVar;
    }

    public abstract void L9(@NotNull Context context, @NotNull T vm5);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        com.tencent.mobileqq.search.searchdetail.content.viewmodel.k kVar = this.viewModel;
        if (!(kVar instanceof com.tencent.mobileqq.search.searchdetail.content.viewmodel.k)) {
            kVar = null;
        }
        if (kVar != null) {
            hp2.s e16 = hp2.s.e(rootView);
            Intrinsics.checkNotNullExpressionValue(e16, "bind(rootView)");
            K9(e16);
            D9().f405747i.setVisibility(0);
            hp2.t e17 = hp2.t.e(D9().f405746h.inflate());
            Intrinsics.checkNotNullExpressionValue(e17, "bind(contentView)");
            J9(e17);
            C9().f405749b.setVisibility(8);
            C9().f405749b.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.searchdetail.content.part.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseSearchTabFilterPart.F9(BaseSearchTabFilterPart.this, view);
                }
            });
            Context context = rootView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
            L9(context, kVar);
        }
    }
}
