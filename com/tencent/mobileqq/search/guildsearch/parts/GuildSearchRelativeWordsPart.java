package com.tencent.mobileqq.search.guildsearch.parts;

import android.view.View;
import android.view.ViewStub;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.search.searchdetail.searchbox.v;
import com.tencent.mobileqq.search.searchdetail.searchbox.views.OverScrollRecyclerViewWithHeaderFooter;
import com.tencent.mobileqq.search.util.ap;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rp2.c;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ;2\u00020\u0001:\u0001<B\u0007\u00a2\u0006\u0004\b9\u0010:J+\u0010\t\u001a\u00020\u00072!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0002H\u0002J\u0012\u0010\u000b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0016J\u001c\u0010\u0010\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016R\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010 \u001a\u00020\u00198\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010+\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u001b\u00104\u001a\u00020\f8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R \u00108\u001a\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020\u00070\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/search/guildsearch/parts/GuildSearchRelativeWordsPart;", "Lcom/tencent/biz/richframework/part/Part;", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "searchLayout", "", "block", "E9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "action", "", "args", "handleBroadcastMessage", "Landroid/view/ViewStub;", "d", "Landroid/view/ViewStub;", "J9", "()Landroid/view/ViewStub;", "L9", "(Landroid/view/ViewStub;)V", "vtSearchLayout", "Landroidx/recyclerview/widget/LinearLayoutManager;", "e", "Landroidx/recyclerview/widget/LinearLayoutManager;", "H9", "()Landroidx/recyclerview/widget/LinearLayoutManager;", "K9", "(Landroidx/recyclerview/widget/LinearLayoutManager;)V", "linearLayoutManager", "Lcom/tencent/mobileqq/search/searchdetail/searchbox/views/OverScrollRecyclerViewWithHeaderFooter;", "f", "Lcom/tencent/mobileqq/search/searchdetail/searchbox/views/OverScrollRecyclerViewWithHeaderFooter;", "searchRecycleView", "Lcom/tencent/mobileqq/search/searchdetail/searchbox/v;", tl.h.F, "Lcom/tencent/mobileqq/search/searchdetail/searchbox/v;", "suggestAdapter", "i", "Landroid/view/View;", "searchLayoutInflated", "Lcom/tencent/mobileqq/search/guildsearch/parts/GuildSearchRelativeViewModel;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/search/guildsearch/parts/GuildSearchRelativeViewModel;", "viewModel", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "I9", "()Ljava/lang/String;", "sessionId", "Lrp2/a;", "D", "Lkotlin/jvm/functions/Function1;", "adapterItemEventListener", "<init>", "()V", "E", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class GuildSearchRelativeWordsPart extends Part {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy sessionId;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Function1<rp2.a, Unit> adapterItemEventListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public ViewStub vtSearchLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public LinearLayoutManager linearLayoutManager;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private OverScrollRecyclerViewWithHeaderFooter searchRecycleView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private v suggestAdapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View searchLayoutInflated;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildSearchRelativeViewModel viewModel;

    public GuildSearchRelativeWordsPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.search.guildsearch.parts.GuildSearchRelativeWordsPart$sessionId$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                return System.currentTimeMillis() + "_" + ap.f285014a.a();
            }
        });
        this.sessionId = lazy;
        this.adapterItemEventListener = new GuildSearchRelativeWordsPart$adapterItemEventListener$1(this);
    }

    private final void E9(final Function1<? super View, Unit> block) {
        View view = this.searchLayoutInflated;
        if (view == null) {
            J9().setOnInflateListener(new ViewStub.OnInflateListener() { // from class: com.tencent.mobileqq.search.guildsearch.parts.h
                @Override // android.view.ViewStub.OnInflateListener
                public final void onInflate(ViewStub viewStub, View view2) {
                    GuildSearchRelativeWordsPart.F9(GuildSearchRelativeWordsPart.this, block, viewStub, view2);
                }
            });
            this.searchLayoutInflated = J9().inflate();
        } else if (view != null) {
            block.invoke(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(final GuildSearchRelativeWordsPart this$0, Function1 block, ViewStub viewStub, View view) {
        LiveData<List<c.SearchSuggestKeywordData>> O1;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(block, "$block");
        QLog.i("QQSearch.Local.Guild.GuildSearchRelativeWordsPart", 1, "inflate the search list");
        View findViewById = view.findViewById(R.id.yfi);
        Intrinsics.checkNotNullExpressionValue(findViewById, "inflated.findViewById(R.id.layout_search)");
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter = (OverScrollRecyclerViewWithHeaderFooter) view.findViewById(R.id.f790148m);
        this$0.searchRecycleView = overScrollRecyclerViewWithHeaderFooter;
        if (overScrollRecyclerViewWithHeaderFooter != null) {
            overScrollRecyclerViewWithHeaderFooter.setOverScrollMode(2);
        }
        this$0.K9(new LinearLayoutManager(this$0.getContext()));
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter2 = this$0.searchRecycleView;
        if (overScrollRecyclerViewWithHeaderFooter2 != null) {
            overScrollRecyclerViewWithHeaderFooter2.setLayoutManager(this$0.H9());
        }
        GuildSearchRelativeViewModel guildSearchRelativeViewModel = this$0.viewModel;
        if (guildSearchRelativeViewModel != null && (O1 = guildSearchRelativeViewModel.O1()) != null) {
            LifecycleOwner hostLifecycleOwner = this$0.getPartHost().getHostLifecycleOwner();
            final Function1<List<? extends c.SearchSuggestKeywordData>, Unit> function1 = new Function1<List<? extends c.SearchSuggestKeywordData>, Unit>() { // from class: com.tencent.mobileqq.search.guildsearch.parts.GuildSearchRelativeWordsPart$ensureInflated$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(List<? extends c.SearchSuggestKeywordData> list) {
                    invoke2((List<c.SearchSuggestKeywordData>) list);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(List<c.SearchSuggestKeywordData> it) {
                    Function1 function12;
                    OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter3;
                    OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter4;
                    OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter5;
                    RecyclerView.Adapter adapter;
                    v vVar;
                    Object broadcastGetMessage = GuildSearchRelativeWordsPart.this.broadcastGetMessage("MESSAGE_GET_CURRENT_KEYWORD", null);
                    String str = broadcastGetMessage instanceof String ? (String) broadcastGetMessage : null;
                    if (str == null) {
                        QLog.e("QQSearch.Local.Guild.GuildSearchRelativeWordsPart", 1, "empty keyword in search bar");
                        return;
                    }
                    GuildSearchRelativeWordsPart guildSearchRelativeWordsPart = GuildSearchRelativeWordsPart.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    String I9 = GuildSearchRelativeWordsPart.this.I9();
                    function12 = GuildSearchRelativeWordsPart.this.adapterItemEventListener;
                    guildSearchRelativeWordsPart.suggestAdapter = new v(it, str, I9, function12);
                    overScrollRecyclerViewWithHeaderFooter3 = GuildSearchRelativeWordsPart.this.searchRecycleView;
                    if (overScrollRecyclerViewWithHeaderFooter3 != null) {
                        vVar = GuildSearchRelativeWordsPart.this.suggestAdapter;
                        overScrollRecyclerViewWithHeaderFooter3.setAdapter(vVar);
                    }
                    overScrollRecyclerViewWithHeaderFooter4 = GuildSearchRelativeWordsPart.this.searchRecycleView;
                    if (overScrollRecyclerViewWithHeaderFooter4 != null && (adapter = overScrollRecyclerViewWithHeaderFooter4.getAdapter()) != null) {
                        adapter.notifyDataSetChanged();
                    }
                    overScrollRecyclerViewWithHeaderFooter5 = GuildSearchRelativeWordsPart.this.searchRecycleView;
                    VideoReport.traversePage(overScrollRecyclerViewWithHeaderFooter5);
                }
            };
            O1.observe(hostLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.search.guildsearch.parts.i
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    GuildSearchRelativeWordsPart.G9(Function1.this, obj);
                }
            });
        }
        block.invoke(findViewById);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @NotNull
    public final LinearLayoutManager H9() {
        LinearLayoutManager linearLayoutManager = this.linearLayoutManager;
        if (linearLayoutManager != null) {
            return linearLayoutManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("linearLayoutManager");
        return null;
    }

    @NotNull
    public final String I9() {
        return (String) this.sessionId.getValue();
    }

    @NotNull
    public final ViewStub J9() {
        ViewStub viewStub = this.vtSearchLayout;
        if (viewStub != null) {
            return viewStub;
        }
        Intrinsics.throwUninitializedPropertyAccessException("vtSearchLayout");
        return null;
    }

    public final void K9(@NotNull LinearLayoutManager linearLayoutManager) {
        Intrinsics.checkNotNullParameter(linearLayoutManager, "<set-?>");
        this.linearLayoutManager = linearLayoutManager;
    }

    public final void L9(@NotNull ViewStub viewStub) {
        Intrinsics.checkNotNullParameter(viewStub, "<set-?>");
        this.vtSearchLayout = viewStub;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        if (Intrinsics.areEqual(action, "MESSAGE_HIDE_SEARCH_FRAME")) {
            Logger.f235387a.d().i("QQSearch.Local.Guild.GuildSearchRelativeWordsPart", 1, "MESSAGE_HIDE_SEARCH_FRAME");
            E9(new Function1<View, Unit>() { // from class: com.tencent.mobileqq.search.guildsearch.parts.GuildSearchRelativeWordsPart$handleBroadcastMessage$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull View it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    it.setVisibility(8);
                    VideoReport.traverseExposure();
                }
            });
        } else if (Intrinsics.areEqual(action, "MESSAGE_SHOW_SEARCH_FRAME")) {
            Logger.f235387a.d().i("QQSearch.Local.Guild.GuildSearchRelativeWordsPart", 1, "MESSAGE_SHOW_SEARCH_FRAME");
            E9(new Function1<View, Unit>() { // from class: com.tencent.mobileqq.search.guildsearch.parts.GuildSearchRelativeWordsPart$handleBroadcastMessage$4
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull View it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    it.setVisibility(0);
                }
            });
        } else {
            super.handleBroadcastMessage(action, args);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        super.onInitView(rootView);
        if (rootView == null) {
            return;
        }
        View findViewById = rootView.findViewById(R.id.f72683ri);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.relative_search_layout)");
        L9((ViewStub) findViewById);
        this.viewModel = (GuildSearchRelativeViewModel) getViewModel(GuildSearchRelativeViewModel.class);
    }
}
