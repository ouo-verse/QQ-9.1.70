package com.tencent.mobileqq.guild.quicksearch.resultview.feed;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.quicksearch.model.QuickSearchSortType;
import com.tencent.mobileqq.guild.quicksearch.viewmodel.QuickSearchFilterViewModel;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.bt;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.util.InputMethodUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001d\u0010$\u001a\u0004\u0018\u00010\u001f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/resultview/feed/QuickSearchFeedSortFilterPart;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/mobileqq/guild/quicksearch/model/QuickSearchSortType;", "F9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "I9", "initViewModel", "onInitView", "Lcom/tencent/mobileqq/guild/quicksearch/viewmodel/QuickSearchFilterViewModel;", "d", "Lcom/tencent/mobileqq/guild/quicksearch/viewmodel/QuickSearchFilterViewModel;", "H9", "()Lcom/tencent/mobileqq/guild/quicksearch/viewmodel/QuickSearchFilterViewModel;", "viewModel", "e", "Landroid/view/View;", "rightActionLayout", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "actionName", "Landroid/widget/ImageView;", tl.h.F, "Landroid/widget/ImageView;", "arrowIconView", "", "i", "Ljava/util/List;", "sortTypeList", "Lcom/tencent/mobileqq/guild/quicksearch/resultview/feed/SortOptionPopupWindow;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Lazy;", "G9", "()Lcom/tencent/mobileqq/guild/quicksearch/resultview/feed/SortOptionPopupWindow;", "popupWindow", "<init>", "(Lcom/tencent/mobileqq/guild/quicksearch/viewmodel/QuickSearchFilterViewModel;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class QuickSearchFeedSortFilterPart extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QuickSearchFilterViewModel viewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View rightActionLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView actionName;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView arrowIconView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<QuickSearchSortType> sortTypeList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy popupWindow;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", NodeProps.ON_CLICK, "(Landroid/view/View;)V", "com/tencent/mobileqq/guild/base/extension/l", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f231773d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QuickSearchFeedSortFilterPart f231774e;

        public a(View view, QuickSearchFeedSortFilterPart quickSearchFeedSortFilterPart) {
            this.f231773d = view;
            this.f231774e = quickSearchFeedSortFilterPart;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!com.tencent.mobileqq.guild.util.o.c("fastClickGuard")) {
                SortOptionPopupWindow G9 = this.f231774e.G9();
                if (G9 != null) {
                    View view2 = this.f231774e.rightActionLayout;
                    if (view2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("rightActionLayout");
                        view2 = null;
                    }
                    G9.m(view2, this.f231774e.F9().getRankType());
                }
                this.f231774e.getViewModel().w2();
                InputMethodUtil.hide(this.f231774e.getActivity());
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public QuickSearchFeedSortFilterPart(@NotNull QuickSearchFilterViewModel viewModel) {
        ArrayList arrayListOf;
        Lazy lazy;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.viewModel = viewModel;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QuickSearchSortType.SMART, QuickSearchSortType.TIME);
        this.sortTypeList = arrayListOf;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<SortOptionPopupWindow>() { // from class: com.tencent.mobileqq.guild.quicksearch.resultview.feed.QuickSearchFeedSortFilterPart$popupWindow$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final SortOptionPopupWindow invoke() {
                List list;
                Context context = QuickSearchFeedSortFilterPart.this.getContext();
                if (context == null) {
                    return null;
                }
                final QuickSearchFeedSortFilterPart quickSearchFeedSortFilterPart = QuickSearchFeedSortFilterPart.this;
                int rankType = quickSearchFeedSortFilterPart.F9().getRankType();
                list = quickSearchFeedSortFilterPart.sortTypeList;
                return new SortOptionPopupWindow(context, list, rankType, new Function1<QuickSearchSortType, Unit>() { // from class: com.tencent.mobileqq.guild.quicksearch.resultview.feed.QuickSearchFeedSortFilterPart$popupWindow$2$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(QuickSearchSortType quickSearchSortType) {
                        invoke2(quickSearchSortType);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull QuickSearchSortType selectedType) {
                        Intrinsics.checkNotNullParameter(selectedType, "selectedType");
                        if (QuickSearchFeedSortFilterPart.this.getViewModel().n2().getValue() != selectedType) {
                            View view = QuickSearchFeedSortFilterPart.this.rightActionLayout;
                            if (view == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("rightActionLayout");
                                view = null;
                            }
                            VideoReport.clearElementExposure(view, false);
                        }
                        QuickSearchFeedSortFilterPart.this.getViewModel().A2(selectedType);
                    }
                });
            }
        });
        this.popupWindow = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QuickSearchSortType F9() {
        QuickSearchSortType value = this.viewModel.n2().getValue();
        if (value == null) {
            return QuickSearchSortType.SMART;
        }
        return value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SortOptionPopupWindow G9() {
        return (SortOptionPopupWindow) this.popupWindow.getValue();
    }

    private final void I9(View rootView) {
        View findViewById = rootView.findViewById(R.id.f74443w_);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.right_action_layout)");
        this.rightActionLayout = findViewById;
        View view = null;
        if (findViewById == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightActionLayout");
            findViewById = null;
        }
        View findViewById2 = findViewById.findViewById(R.id.f74453wa);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rightActionLayout.findVi\u2026d(R.id.right_action_text)");
        this.actionName = (TextView) findViewById2;
        View view2 = this.rightActionLayout;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightActionLayout");
            view2 = null;
        }
        View findViewById3 = view2.findViewById(R.id.f74433w9);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rightActionLayout.findVi\u2026(R.id.right_action_image)");
        ImageView imageView = (ImageView) findViewById3;
        this.arrowIconView = imageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("arrowIconView");
            imageView = null;
        }
        GuildUIUtils.d(imageView, R.drawable.guild_search_feed_sort_icon, Integer.valueOf(R.color.qui_common_text_primary));
        View view3 = this.rightActionLayout;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightActionLayout");
        } else {
            view = view3;
        }
        view.setOnClickListener(new a(view, this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void initViewModel() {
        MutableLiveData<QuickSearchSortType> n26 = this.viewModel.n2();
        LifecycleOwner a16 = com.tencent.mobileqq.guild.discoveryv2.content.part.d.a(this);
        final Function1<QuickSearchSortType, Unit> function1 = new Function1<QuickSearchSortType, Unit>() { // from class: com.tencent.mobileqq.guild.quicksearch.resultview.feed.QuickSearchFeedSortFilterPart$initViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QuickSearchSortType quickSearchSortType) {
                invoke2(quickSearchSortType);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(QuickSearchSortType quickSearchSortType) {
                TextView textView;
                View view;
                HashMap hashMapOf;
                textView = QuickSearchFeedSortFilterPart.this.actionName;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("actionName");
                    textView = null;
                }
                textView.setText(quickSearchSortType.getSortName());
                View view2 = QuickSearchFeedSortFilterPart.this.rightActionLayout;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("rightActionLayout");
                    view = null;
                } else {
                    view = view2;
                }
                hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("sgrp_search_forum_sort_type", Integer.valueOf(quickSearchSortType.getReportId())));
                bt.c(view, "em_sgrp_search_forum_sort", hashMapOf, ClickPolicy.REPORT_ALL, ExposurePolicy.REPORT_ALL, EndExposurePolicy.REPORT_NONE);
                VideoReport.traverseExposure();
            }
        };
        n26.observe(a16, new Observer() { // from class: com.tencent.mobileqq.guild.quicksearch.resultview.feed.w
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QuickSearchFeedSortFilterPart.J9(Function1.this, obj);
            }
        });
        MediatorLiveData<Boolean> m26 = this.viewModel.m2();
        LifecycleOwner a17 = com.tencent.mobileqq.guild.discoveryv2.content.part.d.a(this);
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.quicksearch.resultview.feed.QuickSearchFeedSortFilterPart$initViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                View view = QuickSearchFeedSortFilterPart.this.rightActionLayout;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("rightActionLayout");
                    view = null;
                }
                view.setVisibility(Intrinsics.areEqual(bool, Boolean.TRUE) ^ true ? 0 : 8);
            }
        };
        m26.observe(a17, new Observer() { // from class: com.tencent.mobileqq.guild.quicksearch.resultview.feed.x
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QuickSearchFeedSortFilterPart.K9(Function1.this, obj);
            }
        });
    }

    @NotNull
    /* renamed from: H9, reason: from getter */
    public final QuickSearchFilterViewModel getViewModel() {
        return this.viewModel;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        I9(rootView);
        initViewModel();
    }
}
