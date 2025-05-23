package com.tencent.mobileqq.guild.feed.batchmanage.search.part;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.os.BundleKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.PartIOCKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.guild.feed.batchmanage.search.fragment.FeedBatchManageSearchResultFragment;
import com.tencent.mobileqq.guild.feed.batchmanage.search.part.FeedBatchManageSearchLayerPart$onSearchClickDynamicParam$2;
import com.tencent.mobileqq.guild.feed.batchmanage.search.viewmodel.FeedBatchManageSearchArgs;
import com.tencent.mobileqq.guild.feed.batchmanage.viewmodel.FeedBatchManageSearchPreparationViewModel;
import com.tencent.mobileqq.search.api.impl.SearchGuildDaTongApiImpl;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.search.QUISearchBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.util.InputMethodUtil;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000;\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\n*\u0001\u001f\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0001'B\u0007\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0003H\u0002J\b\u0010\u0011\u001a\u00020\tH\u0002J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0003H\u0002R\u001b\u0010\u0018\u001a\u00020\u00038VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R#\u0010\u001e\u001a\n \u001a*\u0004\u0018\u00010\u00190\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010#\u001a\u00020\u001f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010\u0015\u001a\u0004\b!\u0010\"\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/guild/feed/batchmanage/search/part/FeedBatchManageSearchLayerPart;", "Lcom/tencent/biz/richframework/part/Part;", "Lco1/g;", "Landroid/view/View;", "K9", "Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;", "H9", "Landroid/widget/TextView;", "tipView", "", "R9", "Lcom/tencent/mobileqq/widget/search/QUISearchBar;", "searchBar", "F9", "P9", "entranceView", "N9", "L9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "M9", "d", "Lkotlin/Lazy;", "O0", "()Landroid/view/View;", "hostView", "Lcom/tencent/mobileqq/guild/feed/batchmanage/viewmodel/FeedBatchManageSearchPreparationViewModel;", "kotlin.jvm.PlatformType", "e", "J9", "()Lcom/tencent/mobileqq/guild/feed/batchmanage/viewmodel/FeedBatchManageSearchPreparationViewModel;", "viewModel", "com/tencent/mobileqq/guild/feed/batchmanage/search/part/FeedBatchManageSearchLayerPart$onSearchClickDynamicParam$2$a", "f", "I9", "()Lcom/tencent/mobileqq/guild/feed/batchmanage/search/part/FeedBatchManageSearchLayerPart$onSearchClickDynamicParam$2$a;", "onSearchClickDynamicParam", "<init>", "()V", tl.h.F, "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedBatchManageSearchLayerPart extends Part implements co1.g {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final a f218237h = new a(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy hostView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy onSearchClickDynamicParam;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/batchmanage/search/part/FeedBatchManageSearchLayerPart$a;", "", "", "SHOW_KEYBOARD_DELAY", "J", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/feed/batchmanage/search/part/FeedBatchManageSearchLayerPart$c", "Lcom/tencent/mobileqq/widget/search/QUISearchBar$ActionCallback;", "", "onCancel", "", "onClear", "onBack", "", "onSearch", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements QUISearchBar.ActionCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QUISearchBar f218242a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ FeedBatchManageSearchLayerPart f218243b;

        c(QUISearchBar qUISearchBar, FeedBatchManageSearchLayerPart feedBatchManageSearchLayerPart) {
            this.f218242a = qUISearchBar;
            this.f218243b = feedBatchManageSearchLayerPart;
        }

        @Override // com.tencent.mobileqq.widget.search.QUISearchBar.ActionCallback
        public boolean onBack() {
            return true;
        }

        @Override // com.tencent.mobileqq.widget.search.QUISearchBar.ActionCallback
        public int onCancel() {
            InputMethodUtil.hide(this.f218242a.getInputWidget());
            vi1.d dVar = (vi1.d) PartIOCKt.getIocInterface(this.f218243b, vi1.d.class);
            if (dVar != null) {
                dVar.e5(true);
            }
            InputMethodUtil.hide(this.f218242a.getInputWidget());
            return 2;
        }

        @Override // com.tencent.mobileqq.widget.search.QUISearchBar.ActionCallback
        public boolean onClear() {
            return false;
        }

        @Override // com.tencent.mobileqq.widget.search.QUISearchBar.ActionCallback
        public void onSearch() {
            yl1.b bVar = yl1.b.f450589a;
            QuickPinyinEditText inputWidget = this.f218242a.getInputWidget();
            Intrinsics.checkNotNullExpressionValue(inputWidget, "searchBar.inputWidget");
            bVar.e(inputWidget, "em_sgrp_discover_search_kb_btn", this.f218243b.I9().getDynamicParams("clck"));
            this.f218243b.L9();
            this.f218242a.getInputWidget().getText().clear();
        }
    }

    public FeedBatchManageSearchLayerPart() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<View>() { // from class: com.tencent.mobileqq.guild.feed.batchmanage.search.part.FeedBatchManageSearchLayerPart$hostView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final View invoke() {
                View K9;
                K9 = FeedBatchManageSearchLayerPart.this.K9();
                return K9;
            }
        });
        this.hostView = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<FeedBatchManageSearchPreparationViewModel>() { // from class: com.tencent.mobileqq.guild.feed.batchmanage.search.part.FeedBatchManageSearchLayerPart$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FeedBatchManageSearchPreparationViewModel invoke() {
                return (FeedBatchManageSearchPreparationViewModel) FeedBatchManageSearchLayerPart.this.getViewModel(FeedBatchManageSearchPreparationViewModel.class);
            }
        });
        this.viewModel = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<FeedBatchManageSearchLayerPart$onSearchClickDynamicParam$2.a>() { // from class: com.tencent.mobileqq.guild.feed.batchmanage.search.part.FeedBatchManageSearchLayerPart$onSearchClickDynamicParam$2

            @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/feed/batchmanage/search/part/FeedBatchManageSearchLayerPart$onSearchClickDynamicParam$2$a", "Lcom/tencent/qqlive/module/videoreport/data/IDynamicParams;", "", "event", "", "", "getDynamicParams", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes13.dex */
            public static final class a implements IDynamicParams {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ FeedBatchManageSearchLayerPart f218244a;

                a(FeedBatchManageSearchLayerPart feedBatchManageSearchLayerPart) {
                    this.f218244a = feedBatchManageSearchLayerPart;
                }

                @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
                @NotNull
                public Map<String, Object> getDynamicParams(@Nullable String event) {
                    Map<String, Object> mapOf;
                    Map<String, Object> emptyMap;
                    if (!Intrinsics.areEqual(event, "clck")) {
                        emptyMap = MapsKt__MapsKt.emptyMap();
                        return emptyMap;
                    }
                    String value = this.f218244a.J9().L1().getValue();
                    if (value == null) {
                        value = "";
                    }
                    mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(SearchGuildDaTongApiImpl.GUILD_SEARCH_ITEM_RECALL_QUERY, value));
                    return mapOf;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                return new a(FeedBatchManageSearchLayerPart.this);
            }
        });
        this.onSearchClickDynamicParam = lazy3;
    }

    private final void F9(QUISearchBar searchBar) {
        QuickPinyinEditText inputWidget = searchBar.getInputWidget();
        Intrinsics.checkNotNullExpressionValue(inputWidget, "searchBar.inputWidget");
        inputWidget.addTextChangedListener(new b());
        searchBar.setActionCallback(new c(searchBar, this));
        MutableLiveData<Integer> M1 = J9().M1();
        LifecycleOwner c16 = com.tencent.mobileqq.guild.feed.part.a.c(this);
        final FeedBatchManageSearchLayerPart$bindSearchBarUserIntent$3 feedBatchManageSearchLayerPart$bindSearchBarUserIntent$3 = new FeedBatchManageSearchLayerPart$bindSearchBarUserIntent$3(searchBar);
        M1.observe(c16, new Observer() { // from class: com.tencent.mobileqq.guild.feed.batchmanage.search.part.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FeedBatchManageSearchLayerPart.G9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final ConstraintLayout.LayoutParams H9() {
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(0, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = getContext().getResources().getDimensionPixelOffset(R.dimen.c9y);
        int dimensionPixelOffset = getContext().getResources().getDimensionPixelOffset(R.dimen.f158713n2);
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = dimensionPixelOffset;
        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = dimensionPixelOffset;
        layoutParams.startToStart = 0;
        layoutParams.endToEnd = 0;
        layoutParams.topToTop = 0;
        layoutParams.bottomToBottom = 0;
        layoutParams.horizontalBias = 0.0f;
        layoutParams.matchConstraintDefaultWidth = 1;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FeedBatchManageSearchLayerPart$onSearchClickDynamicParam$2.a I9() {
        return (FeedBatchManageSearchLayerPart$onSearchClickDynamicParam$2.a) this.onSearchClickDynamicParam.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FeedBatchManageSearchPreparationViewModel J9() {
        return (FeedBatchManageSearchPreparationViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View K9() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setGravity(48);
        QUISearchBar qUISearchBar = new QUISearchBar(linearLayout.getContext());
        String string = qUISearchBar.getContext().getResources().getString(R.string.f143770mz);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026ld_feed_batch_search_tip)");
        qUISearchBar.setEtInputHint(string);
        qUISearchBar.updateStyle(2);
        F9(qUISearchBar);
        linearLayout.addView(qUISearchBar, new LinearLayout.LayoutParams(-1, linearLayout.getResources().getDimensionPixelSize(R.dimen.c_i)));
        ConstraintLayout constraintLayout = new ConstraintLayout(linearLayout.getContext());
        TextView textView = new TextView(constraintLayout.getContext());
        R9(textView);
        P9(textView);
        constraintLayout.addView(textView, H9());
        View view = new View(constraintLayout.getContext());
        view.setBackgroundResource(R.drawable.qui_divider_border_standard);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-1, constraintLayout.getResources().getDimensionPixelSize(R.dimen.c9u));
        layoutParams.bottomToBottom = 0;
        Unit unit = Unit.INSTANCE;
        constraintLayout.addView(view, layoutParams);
        linearLayout.addView(constraintLayout, new LinearLayout.LayoutParams(-1, -2));
        N9(constraintLayout);
        M9(linearLayout);
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L9() {
        boolean z16;
        Serializable serializable;
        long j3;
        String str;
        String value = J9().L1().getValue();
        if (value != null && value.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.w("FeedBatchManagement.Search.Layer", 1, "keyword is empty now");
            return;
        }
        vi1.b bVar = (vi1.b) PartIOCKt.getIocInterface(this, vi1.b.class);
        if (bVar == null) {
            return;
        }
        FeedBatchManageSearchArgs feedBatchManageSearchArgs = new FeedBatchManageSearchArgs(bVar.getContact(), vi1.c.e(bVar));
        Bundle arguments = bVar.getArguments();
        if (arguments != null) {
            serializable = arguments.getSerializable("source");
        } else {
            serializable = null;
        }
        vi1.f fVar = (vi1.f) PartIOCKt.getIocInterface(this, vi1.f.class);
        if (fVar != null) {
            j3 = fVar.g();
        } else {
            j3 = 0;
        }
        vi1.f fVar2 = (vi1.f) PartIOCKt.getIocInterface(this, vi1.f.class);
        if (fVar2 == null || (str = fVar2.b()) == null) {
            str = "";
        }
        Context context = getContext();
        Intent intent = new Intent();
        intent.putExtra("search_request", BundleKt.bundleOf(TuplesKt.to("keyword", value), TuplesKt.to("search_args", feedBatchManageSearchArgs)));
        intent.putExtra("source_page_hashcode", getContext().hashCode());
        intent.putExtra("selected_channel_id", j3);
        intent.putExtra("selected_channel_name", str);
        intent.putExtra("source", serializable);
        QPublicFragmentActivity.start(context, intent, FeedBatchManageSearchResultFragment.class);
    }

    private final void M9(View rootView) {
        LinkedHashMap linkedMapOf;
        VideoReport.setPageId(rootView, "pg_sgrp_forum_batch_search");
        VideoReport.setPageReportPolicy(rootView, PageReportPolicy.REPORT_NONE);
        vi1.b bVar = (vi1.b) PartIOCKt.getIocInterface(this, vi1.b.class);
        if (bVar != null) {
            linkedMapOf = MapsKt__MapsKt.linkedMapOf(TuplesKt.to("sgrp_user_type", com.tencent.mobileqq.guild.feed.report.f.o(bVar.getContact().getGuildId())), TuplesKt.to("sgrp_channel_id", bVar.getContact().getGuildId()));
            VideoReport.setPageParams(rootView, new PageParams(linkedMapOf));
        }
    }

    private final void N9(final View entranceView) {
        MutableLiveData<String> L1 = J9().L1();
        LifecycleOwner c16 = com.tencent.mobileqq.guild.feed.part.a.c(this);
        final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: com.tencent.mobileqq.guild.feed.batchmanage.search.part.FeedBatchManageSearchLayerPart$setUpSearchEntrance$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                entranceView.setVisibility((str == null || str.length() == 0) ^ true ? 0 : 8);
            }
        };
        L1.observe(c16, new Observer() { // from class: com.tencent.mobileqq.guild.feed.batchmanage.search.part.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FeedBatchManageSearchLayerPart.O9(Function1.this, obj);
            }
        });
        jt1.b.b(entranceView, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.feed.batchmanage.search.part.FeedBatchManageSearchLayerPart$setUpSearchEntrance$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                FeedBatchManageSearchLayerPart.this.L9();
                yl1.b.f450589a.e(it, "em_sgrp_search_content", FeedBatchManageSearchLayerPart.this.I9().getDynamicParams("clck"));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void P9(final TextView tipView) {
        MutableLiveData<String> L1 = J9().L1();
        LifecycleOwner c16 = com.tencent.mobileqq.guild.feed.part.a.c(this);
        final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: com.tencent.mobileqq.guild.feed.batchmanage.search.part.FeedBatchManageSearchLayerPart$setUpSearchEntranceTipView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                if (str == null || str.length() == 0) {
                    return;
                }
                tipView.setText(this.getContext().getString(R.string.f145220qw, str));
            }
        };
        L1.observe(c16, new Observer() { // from class: com.tencent.mobileqq.guild.feed.batchmanage.search.part.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FeedBatchManageSearchLayerPart.Q9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void R9(TextView tipView) {
        tipView.setTextColor(ResourcesCompat.getColorStateList(tipView.getResources(), R.color.qui_common_text_link, null));
        tipView.setTextSize(16.0f);
        tipView.setMaxLines(2);
        tipView.setEllipsize(TextUtils.TruncateAt.END);
    }

    @Override // co1.g
    @NotNull
    public View O0() {
        return (View) this.hostView.getValue();
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J*\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016J*\u0010\u000e\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\u000f\u00b8\u0006\u0000"}, d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "Landroid/text/Editable;", ReportConstant.COSTREPORT_PREFIX, "", "afterTextChanged", "", "text", "", "start", "count", "after", "beforeTextChanged", "before", "onTextChanged", "core-ktx_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable s16) {
            FeedBatchManageSearchLayerPart.this.J9().L1().setValue(String.valueOf(s16));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence text, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence text, int start, int before, int count) {
        }
    }
}
