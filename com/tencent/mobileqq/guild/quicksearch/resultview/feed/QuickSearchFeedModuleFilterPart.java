package com.tencent.mobileqq.guild.quicksearch.resultview.feed;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.quicksearch.adapter.QuickSearchModuleInfo;
import com.tencent.mobileqq.guild.quicksearch.viewmodel.QuickSearchFilterViewModel;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.bt;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchFeedGroupInfo;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u00a2\u0006\u0004\b>\u0010?J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\bH\u0002J\b\u0010\u000e\u001a\u00020\bH\u0002J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\u001fR\u0016\u0010$\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010\u0017R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010.\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010\u0017R\u0014\u00101\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b/\u00100R\u001b\u00107\u001a\u0002028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\"\u0010=\u001a\u0010\u0012\u0004\u0012\u000209\u0012\u0006\b\u0001\u0012\u00020:088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010<\u00a8\u0006@"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/resultview/feed/QuickSearchFeedModuleFilterPart;", "Lcom/tencent/biz/richframework/part/Part;", "", com.tencent.luggage.wxa.c8.c.G, "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildSearchFeedGroupInfo;", "info", "", "selected", "", "Y9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "R9", "initViewModel", "Q9", "onInitView", "Lcom/tencent/mobileqq/guild/quicksearch/viewmodel/QuickSearchFilterViewModel;", "d", "Lcom/tencent/mobileqq/guild/quicksearch/viewmodel/QuickSearchFilterViewModel;", "getViewModel", "()Lcom/tencent/mobileqq/guild/quicksearch/viewmodel/QuickSearchFilterViewModel;", "viewModel", "e", "Landroid/view/View;", "buttonContainer", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "actionName", "Landroid/widget/ImageView;", tl.h.F, "Landroid/widget/ImageView;", "arrowIconView", "i", "closeIconView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "modulePanel", "Lcom/tencent/mobileqq/guild/quicksearch/resultview/feed/MaxHeightFrameLayout;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/quicksearch/resultview/feed/MaxHeightFrameLayout;", "moduleFrame", "Landroidx/recyclerview/widget/RecyclerView;", "D", "Landroidx/recyclerview/widget/RecyclerView;", "moduleListView", "E", "noModuleView", UserInfo.SEX_FEMALE, "I", "filterBoxReportType", "Lcom/tencent/mobileqq/guild/quicksearch/adapter/f;", "G", "Lkotlin/Lazy;", "P9", "()Lcom/tencent/mobileqq/guild/quicksearch/adapter/f;", "sortListAdapter", "Ljava/util/HashMap;", "", "", "H", "Ljava/util/HashMap;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "<init>", "(Lcom/tencent/mobileqq/guild/quicksearch/viewmodel/QuickSearchFilterViewModel;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class QuickSearchFeedModuleFilterPart extends Part {

    /* renamed from: C, reason: from kotlin metadata */
    private MaxHeightFrameLayout moduleFrame;

    /* renamed from: D, reason: from kotlin metadata */
    private RecyclerView moduleListView;

    /* renamed from: E, reason: from kotlin metadata */
    private View noModuleView;

    /* renamed from: F, reason: from kotlin metadata */
    private final int filterBoxReportType;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy sortListAdapter;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final HashMap<String, ? extends Object> reportParams;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QuickSearchFilterViewModel viewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View buttonContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView actionName;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView arrowIconView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView closeIconView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private View modulePanel;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/guild/quicksearch/resultview/feed/QuickSearchFeedModuleFilterPart$a", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "onGlobalLayout", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            View view = QuickSearchFeedModuleFilterPart.this.modulePanel;
            MaxHeightFrameLayout maxHeightFrameLayout = null;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("modulePanel");
                view = null;
            }
            if (view.getHeight() > 0) {
                View view2 = QuickSearchFeedModuleFilterPart.this.modulePanel;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("modulePanel");
                    view2 = null;
                }
                view2.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                int a16 = (int) (com.tencent.mobileqq.util.x.f(QuickSearchFeedModuleFilterPart.this.getContext()).a() * 0.24d);
                View view3 = QuickSearchFeedModuleFilterPart.this.modulePanel;
                if (view3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("modulePanel");
                    view3 = null;
                }
                int height = view3.getHeight() - a16;
                MaxHeightFrameLayout maxHeightFrameLayout2 = QuickSearchFeedModuleFilterPart.this.moduleFrame;
                if (maxHeightFrameLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("moduleFrame");
                } else {
                    maxHeightFrameLayout = maxHeightFrameLayout2;
                }
                maxHeightFrameLayout.setMaxHeight(height);
            }
        }
    }

    public QuickSearchFeedModuleFilterPart(@NotNull QuickSearchFilterViewModel viewModel) {
        Lazy lazy;
        HashMap<String, ? extends Object> hashMapOf;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.viewModel = viewModel;
        this.filterBoxReportType = 2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.guild.quicksearch.adapter.f>() { // from class: com.tencent.mobileqq.guild.quicksearch.resultview.feed.QuickSearchFeedModuleFilterPart$sortListAdapter$2

            /* JADX INFO: Access modifiers changed from: package-private */
            @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.mobileqq.guild.quicksearch.resultview.feed.QuickSearchFeedModuleFilterPart$sortListAdapter$2$1, reason: invalid class name */
            /* loaded from: classes14.dex */
            public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<Integer, IGProGuildSearchFeedGroupInfo, Boolean, Unit> {
                AnonymousClass1(Object obj) {
                    super(3, obj, QuickSearchFeedModuleFilterPart.class, "onSelectedItem", "onSelectedItem(ILcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildSearchFeedGroupInfo;Z)V", 0);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, IGProGuildSearchFeedGroupInfo iGProGuildSearchFeedGroupInfo, Boolean bool) {
                    invoke(num.intValue(), iGProGuildSearchFeedGroupInfo, bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3, @NotNull IGProGuildSearchFeedGroupInfo p16, boolean z16) {
                    Intrinsics.checkNotNullParameter(p16, "p1");
                    ((QuickSearchFeedModuleFilterPart) this.receiver).Y9(i3, p16, z16);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.mobileqq.guild.quicksearch.adapter.f invoke() {
                int i3;
                i3 = QuickSearchFeedModuleFilterPart.this.filterBoxReportType;
                return new com.tencent.mobileqq.guild.quicksearch.adapter.f(i3, new AnonymousClass1(QuickSearchFeedModuleFilterPart.this));
            }
        });
        this.sortListAdapter = lazy;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("search_trace_id", kw1.a.f413327a.b()), TuplesKt.to("sgrp_filter_box_type", 2));
        this.reportParams = hashMapOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.guild.quicksearch.adapter.f P9() {
        return (com.tencent.mobileqq.guild.quicksearch.adapter.f) this.sortListAdapter.getValue();
    }

    private final void Q9() {
        View view = this.buttonContainer;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buttonContainer");
            view = null;
        }
        bt.c(view, "em_sgrp_filter_box", this.reportParams, ClickPolicy.REPORT_ALL, ExposurePolicy.REPORT_ALL, EndExposurePolicy.REPORT_NONE);
    }

    private final void R9(View rootView) {
        View findViewById = rootView.findViewById(R.id.fhu);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.panel)");
        this.modulePanel = findViewById;
        View findViewById2 = rootView.findViewById(R.id.zd8);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.module_frame)");
        this.moduleFrame = (MaxHeightFrameLayout) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.amr);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.button_container)");
        this.buttonContainer = findViewById3;
        View view = null;
        if (findViewById3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buttonContainer");
            findViewById3 = null;
        }
        View findViewById4 = findViewById3.findViewById(R.id.f1057766x);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "buttonContainer.findViewById(R.id.tv_action_name)");
        this.actionName = (TextView) findViewById4;
        View view2 = this.buttonContainer;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buttonContainer");
            view2 = null;
        }
        View findViewById5 = view2.findViewById(R.id.dtx);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "buttonContainer.findViewById(R.id.iv_arrow)");
        this.arrowIconView = (ImageView) findViewById5;
        View view3 = this.buttonContainer;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buttonContainer");
            view3 = null;
        }
        View findViewById6 = view3.findViewById(R.id.y1g);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "buttonContainer.findViewById(R.id.iv_clear)");
        ImageView imageView = (ImageView) findViewById6;
        this.closeIconView = imageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeIconView");
            imageView = null;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.quicksearch.resultview.feed.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                QuickSearchFeedModuleFilterPart.S9(QuickSearchFeedModuleFilterPart.this, view4);
            }
        });
        View view4 = this.buttonContainer;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buttonContainer");
            view4 = null;
        }
        view4.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.quicksearch.resultview.feed.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view5) {
                QuickSearchFeedModuleFilterPart.T9(QuickSearchFeedModuleFilterPart.this, view5);
            }
        });
        View view5 = this.modulePanel;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("modulePanel");
            view5 = null;
        }
        view5.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.quicksearch.resultview.feed.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view6) {
                QuickSearchFeedModuleFilterPart.U9(QuickSearchFeedModuleFilterPart.this, view6);
            }
        });
        View findViewById7 = rootView.findViewById(R.id.zd9);
        RecyclerView recyclerView = (RecyclerView) findViewById7;
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(P9());
        Intrinsics.checkNotNullExpressionValue(findViewById7, "rootView.findViewById<Re\u2026sortListAdapter\n        }");
        this.moduleListView = recyclerView;
        View findViewById8 = rootView.findViewById(R.id.zrr);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "rootView.findViewById(R.id.no_module)");
        this.noModuleView = findViewById8;
        View view6 = this.modulePanel;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("modulePanel");
        } else {
            view = view6;
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S9(QuickSearchFeedModuleFilterPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Intrinsics.areEqual(this$0.viewModel.i2().getValue(), Boolean.TRUE)) {
            this$0.viewModel.e2();
            this$0.viewModel.c2();
            this$0.viewModel.x2();
        } else {
            this$0.viewModel.c2();
            this$0.viewModel.y2();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T9(QuickSearchFeedModuleFilterPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Intrinsics.areEqual(this$0.viewModel.i2().getValue(), Boolean.TRUE)) {
            this$0.viewModel.e2();
            this$0.viewModel.x2();
        } else {
            this$0.viewModel.v2();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U9(QuickSearchFeedModuleFilterPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.viewModel.e2();
        this$0.viewModel.x2();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y9(int pos, IGProGuildSearchFeedGroupInfo info, boolean selected) {
        this.viewModel.z2(pos, info, selected);
    }

    private final void initViewModel() {
        LiveData<Boolean> i26 = this.viewModel.i2();
        LifecycleOwner a16 = com.tencent.mobileqq.guild.discoveryv2.content.part.d.a(this);
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.quicksearch.resultview.feed.QuickSearchFeedModuleFilterPart$initViewModel$1
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
                View view = QuickSearchFeedModuleFilterPart.this.modulePanel;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("modulePanel");
                    view = null;
                }
                view.setVisibility(0);
                if (((View) com.tencent.guild.aio.util.ex.g.a(bool, view)) == null) {
                    view.setVisibility(8);
                }
            }
        };
        i26.observe(a16, new Observer() { // from class: com.tencent.mobileqq.guild.quicksearch.resultview.feed.t
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QuickSearchFeedModuleFilterPart.V9(Function1.this, obj);
            }
        });
        LiveData<List<QuickSearchModuleInfo>> j26 = this.viewModel.j2();
        LifecycleOwner a17 = com.tencent.mobileqq.guild.discoveryv2.content.part.d.a(this);
        final Function1<List<? extends QuickSearchModuleInfo>, Unit> function12 = new Function1<List<? extends QuickSearchModuleInfo>, Unit>() { // from class: com.tencent.mobileqq.guild.quicksearch.resultview.feed.QuickSearchFeedModuleFilterPart$initViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends QuickSearchModuleInfo> list) {
                invoke2((List<QuickSearchModuleInfo>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<QuickSearchModuleInfo> moduleList) {
                com.tencent.mobileqq.guild.quicksearch.adapter.f P9;
                RecyclerView recyclerView;
                View view;
                P9 = QuickSearchFeedModuleFilterPart.this.P9();
                Intrinsics.checkNotNullExpressionValue(moduleList, "moduleList");
                P9.setData(moduleList);
                recyclerView = QuickSearchFeedModuleFilterPart.this.moduleListView;
                View view2 = null;
                if (recyclerView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("moduleListView");
                    recyclerView = null;
                }
                recyclerView.setVisibility(moduleList.isEmpty() ^ true ? 0 : 8);
                view = QuickSearchFeedModuleFilterPart.this.noModuleView;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("noModuleView");
                } else {
                    view2 = view;
                }
                view2.setVisibility(moduleList.isEmpty() ? 0 : 8);
            }
        };
        j26.observe(a17, new Observer() { // from class: com.tencent.mobileqq.guild.quicksearch.resultview.feed.u
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QuickSearchFeedModuleFilterPart.W9(Function1.this, obj);
            }
        });
        final String string = getContext().getResources().getString(R.string.f155521hq);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026ild_search_module_filter)");
        LiveData<Pair<Boolean, Integer>> k26 = this.viewModel.k2();
        LifecycleOwner a18 = com.tencent.mobileqq.guild.discoveryv2.content.part.d.a(this);
        final Function1<Pair<? extends Boolean, ? extends Integer>, Unit> function13 = new Function1<Pair<? extends Boolean, ? extends Integer>, Unit>() { // from class: com.tencent.mobileqq.guild.quicksearch.resultview.feed.QuickSearchFeedModuleFilterPart$initViewModel$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends Boolean, ? extends Integer> pair) {
                invoke2((Pair<Boolean, Integer>) pair);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Pair<Boolean, Integer> pair) {
                TextView textView;
                ImageView imageView;
                ImageView imageView2;
                ImageView imageView3;
                ImageView imageView4;
                TextView textView2;
                View view;
                TextView textView3;
                View view2;
                TextView textView4;
                ImageView imageView5;
                ImageView imageView6;
                ImageView imageView7;
                int intValue = pair.getSecond().intValue();
                boolean booleanValue = pair.getFirst().booleanValue();
                Integer valueOf = Integer.valueOf(R.color.qui_common_brand_standard);
                View view3 = null;
                if (intValue > 0) {
                    textView4 = QuickSearchFeedModuleFilterPart.this.actionName;
                    if (textView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("actionName");
                        textView4 = null;
                    }
                    textView4.setText(string + "(" + intValue + ")");
                    imageView5 = QuickSearchFeedModuleFilterPart.this.closeIconView;
                    if (imageView5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("closeIconView");
                        imageView5 = null;
                    }
                    imageView5.setVisibility(0);
                    imageView6 = QuickSearchFeedModuleFilterPart.this.closeIconView;
                    if (imageView6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("closeIconView");
                        imageView6 = null;
                    }
                    GuildUIUtils.d(imageView6, R.drawable.guild_quick_search_close_icon, valueOf);
                    imageView7 = QuickSearchFeedModuleFilterPart.this.arrowIconView;
                    if (imageView7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("arrowIconView");
                        imageView7 = null;
                    }
                    imageView7.setVisibility(8);
                } else {
                    textView = QuickSearchFeedModuleFilterPart.this.actionName;
                    if (textView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("actionName");
                        textView = null;
                    }
                    textView.setText(string);
                    imageView = QuickSearchFeedModuleFilterPart.this.closeIconView;
                    if (imageView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("closeIconView");
                        imageView = null;
                    }
                    imageView.setVisibility(8);
                    imageView2 = QuickSearchFeedModuleFilterPart.this.arrowIconView;
                    if (imageView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("arrowIconView");
                        imageView2 = null;
                    }
                    imageView2.setVisibility(0);
                    if (booleanValue) {
                        imageView4 = QuickSearchFeedModuleFilterPart.this.arrowIconView;
                        if (imageView4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("arrowIconView");
                            imageView4 = null;
                        }
                        GuildUIUtils.d(imageView4, R.drawable.qui_chevron_up, valueOf);
                    } else {
                        imageView3 = QuickSearchFeedModuleFilterPart.this.arrowIconView;
                        if (imageView3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("arrowIconView");
                            imageView3 = null;
                        }
                        GuildUIUtils.d(imageView3, R.drawable.qui_chevron_down, Integer.valueOf(R.color.qui_common_text_primary));
                    }
                }
                if (booleanValue || intValue > 0) {
                    textView2 = QuickSearchFeedModuleFilterPart.this.actionName;
                    if (textView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("actionName");
                        textView2 = null;
                    }
                    textView2.setTextColor(QuickSearchFeedModuleFilterPart.this.getContext().getResources().getColor(R.color.qui_common_brand_standard));
                    view = QuickSearchFeedModuleFilterPart.this.buttonContainer;
                    if (view == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("buttonContainer");
                    } else {
                        view3 = view;
                    }
                    view3.setBackgroundResource(R.drawable.guild_quick_filter_qui_brand_standard_bg);
                    return;
                }
                textView3 = QuickSearchFeedModuleFilterPart.this.actionName;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("actionName");
                    textView3 = null;
                }
                textView3.setTextColor(QuickSearchFeedModuleFilterPart.this.getContext().getResources().getColorStateList(R.color.f157160bt1));
                view2 = QuickSearchFeedModuleFilterPart.this.buttonContainer;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("buttonContainer");
                } else {
                    view3 = view2;
                }
                view3.setBackgroundResource(R.drawable.guild_quick_filter_bg);
            }
        };
        k26.observe(a18, new Observer() { // from class: com.tencent.mobileqq.guild.quicksearch.resultview.feed.v
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QuickSearchFeedModuleFilterPart.X9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        R9(rootView);
        initViewModel();
        Q9();
    }
}
