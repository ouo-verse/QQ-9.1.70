package com.tencent.mobileqq.guild.quicksearch.resultview.feed;

import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.guild.aio.util.ex.ViewExtKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.quicksearch.model.SearchData;
import com.tencent.mobileqq.guild.quicksearch.viewmodel.QuickSearchViewModel;
import com.tencent.mobileqq.guild.util.cw;
import com.tencent.mobileqq.guild.widget.OverScrollRecyclerViewWithHeaderFooter;
import com.tencent.qqlive.module.videoreport.VideoReport;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/resultview/feed/QuickSearchFeedFilterBarPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "initView", "initViewModel", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/mobileqq/guild/quicksearch/viewmodel/QuickSearchViewModel;", "d", "Lcom/tencent/mobileqq/guild/quicksearch/viewmodel/QuickSearchViewModel;", "getViewModel", "()Lcom/tencent/mobileqq/guild/quicksearch/viewmodel/QuickSearchViewModel;", "viewModel", "Landroid/view/ViewGroup;", "e", "Landroid/view/ViewGroup;", "selectTitle", "Lcom/tencent/mobileqq/guild/widget/OverScrollRecyclerViewWithHeaderFooter;", "f", "Lcom/tencent/mobileqq/guild/widget/OverScrollRecyclerViewWithHeaderFooter;", "feedListView", "<init>", "(Lcom/tencent/mobileqq/guild/quicksearch/viewmodel/QuickSearchViewModel;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class QuickSearchFeedFilterBarPart extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QuickSearchViewModel viewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ViewGroup selectTitle;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private OverScrollRecyclerViewWithHeaderFooter feedListView;

    public QuickSearchFeedFilterBarPart(@NotNull QuickSearchViewModel viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.viewModel = viewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void initView() {
        View findViewById = getPartRootView().findViewById(R.id.f82814hw);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.selector_title)");
        this.selectTitle = (ViewGroup) findViewById;
        View findViewById2 = getPartRootView().findViewById(R.id.i4m);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.recycler_view)");
        this.feedListView = (OverScrollRecyclerViewWithHeaderFooter) findViewById2;
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter = this.feedListView;
        ViewGroup viewGroup = null;
        if (overScrollRecyclerViewWithHeaderFooter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedListView");
            overScrollRecyclerViewWithHeaderFooter = null;
        }
        ViewGroup viewGroup2 = this.selectTitle;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectTitle");
        } else {
            viewGroup = viewGroup2;
        }
        new y(overScrollRecyclerViewWithHeaderFooter, viewGroup).i();
    }

    private final void initViewModel() {
        LiveData<Integer> g26 = this.viewModel.g2();
        LifecycleOwner a16 = com.tencent.mobileqq.guild.discoveryv2.content.part.d.a(this);
        final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.guild.quicksearch.resultview.feed.QuickSearchFeedFilterBarPart$initViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer num) {
                ViewGroup viewGroup;
                if (num != null && num.intValue() == 1) {
                    viewGroup = QuickSearchFeedFilterBarPart.this.selectTitle;
                    if (viewGroup == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("selectTitle");
                        viewGroup = null;
                    }
                    viewGroup.setTranslationY(0.0f);
                }
            }
        };
        g26.observe(a16, new Observer() { // from class: com.tencent.mobileqq.guild.quicksearch.resultview.feed.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QuickSearchFeedFilterBarPart.C9(Function1.this, obj);
            }
        });
        MediatorLiveData<Pair<Integer, SearchData>> h26 = this.viewModel.h2();
        LifecycleOwner a17 = com.tencent.mobileqq.guild.discoveryv2.content.part.d.a(this);
        final Function1<Pair<? extends Integer, ? extends SearchData>, Unit> function12 = new Function1<Pair<? extends Integer, ? extends SearchData>, Unit>() { // from class: com.tencent.mobileqq.guild.quicksearch.resultview.feed.QuickSearchFeedFilterBarPart$initViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends Integer, ? extends SearchData> pair) {
                invoke2((Pair<Integer, SearchData>) pair);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:38:0x002d, code lost:
            
                if ((r6 != null ? r6.getSource() : null) == com.tencent.mobileqq.guild.quicksearch.model.GuildSearchActionSource.FILTER_PANEL) goto L29;
             */
            /* JADX WARN: Code restructure failed: missing block: B:49:0x0047, code lost:
            
                if ((r6 != null ? r6.getSource() : null) == com.tencent.mobileqq.guild.quicksearch.model.GuildSearchActionSource.FILTER_PANEL) goto L29;
             */
            /* JADX WARN: Removed duplicated region for block: B:11:0x0060  */
            /* JADX WARN: Removed duplicated region for block: B:14:0x0069  */
            /* JADX WARN: Removed duplicated region for block: B:16:0x0070  */
            /* JADX WARN: Removed duplicated region for block: B:19:0x007d  */
            /* JADX WARN: Removed duplicated region for block: B:21:0x0087  */
            /* JADX WARN: Removed duplicated region for block: B:30:0x008a  */
            /* JADX WARN: Removed duplicated region for block: B:31:0x0084  */
            /* JADX WARN: Removed duplicated region for block: B:8:0x0055  */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2(Pair<Integer, SearchData> pair) {
                boolean z16;
                ViewGroup viewGroup;
                boolean z17;
                ViewGroup viewGroup2;
                OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter;
                Integer first = pair.getFirst();
                SearchData second = pair.getSecond();
                OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter2 = null;
                if (first == null || first.intValue() != 0) {
                    if (first == null || first.intValue() != 1) {
                        if (!((second == null || second.d()) ? false : true)) {
                        }
                        z16 = true;
                    }
                    viewGroup = QuickSearchFeedFilterBarPart.this.selectTitle;
                    if (viewGroup == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("selectTitle");
                        viewGroup = null;
                    }
                    z17 = viewGroup.getVisibility() == 0;
                    viewGroup2 = QuickSearchFeedFilterBarPart.this.selectTitle;
                    if (viewGroup2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("selectTitle");
                        viewGroup2 = null;
                    }
                    viewGroup2.setVisibility(z16 ? 0 : 8);
                    overScrollRecyclerViewWithHeaderFooter = QuickSearchFeedFilterBarPart.this.feedListView;
                    if (overScrollRecyclerViewWithHeaderFooter != null) {
                        Intrinsics.throwUninitializedPropertyAccessException("feedListView");
                    } else {
                        overScrollRecyclerViewWithHeaderFooter2 = overScrollRecyclerViewWithHeaderFooter;
                    }
                    ViewExtKt.f(overScrollRecyclerViewWithHeaderFooter2, (int) cw.c(!z16 ? 48.0f : 0.0f));
                    if (z17 && z16) {
                        VideoReport.traverseExposure();
                        return;
                    }
                }
                z16 = false;
                viewGroup = QuickSearchFeedFilterBarPart.this.selectTitle;
                if (viewGroup == null) {
                }
                if (viewGroup.getVisibility() == 0) {
                }
                viewGroup2 = QuickSearchFeedFilterBarPart.this.selectTitle;
                if (viewGroup2 == null) {
                }
                viewGroup2.setVisibility(z16 ? 0 : 8);
                overScrollRecyclerViewWithHeaderFooter = QuickSearchFeedFilterBarPart.this.feedListView;
                if (overScrollRecyclerViewWithHeaderFooter != null) {
                }
                ViewExtKt.f(overScrollRecyclerViewWithHeaderFooter2, (int) cw.c(!z16 ? 48.0f : 0.0f));
                if (z17) {
                }
            }
        };
        h26.observe(a17, new Observer() { // from class: com.tencent.mobileqq.guild.quicksearch.resultview.feed.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QuickSearchFeedFilterBarPart.D9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        initView();
        initViewModel();
    }
}
