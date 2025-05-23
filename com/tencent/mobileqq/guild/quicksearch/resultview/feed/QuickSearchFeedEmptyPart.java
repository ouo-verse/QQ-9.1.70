package com.tencent.mobileqq.guild.quicksearch.resultview.feed;

import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.GuildQUIEmptyState;
import com.tencent.mobileqq.guild.quicksearch.model.SearchData;
import com.tencent.mobileqq.guild.quicksearch.viewmodel.QuickSearchViewModel;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/resultview/feed/QuickSearchFeedEmptyPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "B9", "A9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/mobileqq/guild/quicksearch/viewmodel/QuickSearchViewModel;", "d", "Lcom/tencent/mobileqq/guild/quicksearch/viewmodel/QuickSearchViewModel;", "getViewModel", "()Lcom/tencent/mobileqq/guild/quicksearch/viewmodel/QuickSearchViewModel;", "viewModel", "Landroid/widget/FrameLayout;", "e", "Landroid/widget/FrameLayout;", "emptyView", "Lcom/tencent/mobileqq/guild/component/GuildQUIEmptyState;", "f", "Lcom/tencent/mobileqq/guild/component/GuildQUIEmptyState;", "emptyState", "<init>", "(Lcom/tencent/mobileqq/guild/quicksearch/viewmodel/QuickSearchViewModel;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class QuickSearchFeedEmptyPart extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QuickSearchViewModel viewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private FrameLayout emptyView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private GuildQUIEmptyState emptyState;

    public QuickSearchFeedEmptyPart(@NotNull QuickSearchViewModel viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.viewModel = viewModel;
    }

    private final void A9() {
        FrameLayout frameLayout = this.emptyView;
        GuildQUIEmptyState guildQUIEmptyState = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyView");
            frameLayout = null;
        }
        frameLayout.setVisibility(8);
        GuildQUIEmptyState.a s16 = new GuildQUIEmptyState.a(getContext()).s(6);
        String r16 = QQGuildUIUtil.r(R.string.f152541_o);
        Intrinsics.checkNotNullExpressionValue(r16, "getString(R.string.guild\u2026uick_search_empty_result)");
        this.emptyState = s16.u(r16).r(false).o(0).n(true).a();
        FrameLayout frameLayout2 = this.emptyView;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyView");
            frameLayout2 = null;
        }
        GuildQUIEmptyState guildQUIEmptyState2 = this.emptyState;
        if (guildQUIEmptyState2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyState");
        } else {
            guildQUIEmptyState = guildQUIEmptyState2;
        }
        frameLayout2.addView(guildQUIEmptyState);
    }

    private final void B9() {
        FrameLayout frameLayout = this.emptyView;
        FrameLayout frameLayout2 = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyView");
            frameLayout = null;
        }
        VideoReport.setElementId(frameLayout, "em_sgrp_search_empty");
        FrameLayout frameLayout3 = this.emptyView;
        if (frameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyView");
            frameLayout3 = null;
        }
        VideoReport.setElementParam(frameLayout3, "search_trace_id", kw1.a.f413327a.b());
        FrameLayout frameLayout4 = this.emptyView;
        if (frameLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyView");
        } else {
            frameLayout2 = frameLayout4;
        }
        VideoReport.setElementExposePolicy(frameLayout2, ExposurePolicy.REPORT_ALL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.uug);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.empty_result_layout)");
        this.emptyView = (FrameLayout) findViewById;
        A9();
        MediatorLiveData<Pair<Integer, SearchData>> h26 = this.viewModel.h2();
        LifecycleOwner a16 = com.tencent.mobileqq.guild.discoveryv2.content.part.d.a(this);
        final Function1<Pair<? extends Integer, ? extends SearchData>, Unit> function1 = new Function1<Pair<? extends Integer, ? extends SearchData>, Unit>() { // from class: com.tencent.mobileqq.guild.quicksearch.resultview.feed.QuickSearchFeedEmptyPart$onInitView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends Integer, ? extends SearchData> pair) {
                invoke2((Pair<Integer, SearchData>) pair);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:13:0x0032, code lost:
            
                if (((r5 == null || r5.d()) ? false : true) == false) goto L19;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2(Pair<Integer, SearchData> pair) {
                FrameLayout frameLayout;
                boolean z16;
                Integer first = pair.getFirst();
                SearchData second = pair.getSecond();
                frameLayout = QuickSearchFeedEmptyPart.this.emptyView;
                if (frameLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("emptyView");
                    frameLayout = null;
                }
                if (first != null && first.intValue() == 4) {
                    z16 = true;
                }
                z16 = false;
                frameLayout.setVisibility(z16 ? 0 : 8);
            }
        };
        h26.observe(a16, new Observer() { // from class: com.tencent.mobileqq.guild.quicksearch.resultview.feed.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QuickSearchFeedEmptyPart.C9(Function1.this, obj);
            }
        });
        B9();
    }
}
