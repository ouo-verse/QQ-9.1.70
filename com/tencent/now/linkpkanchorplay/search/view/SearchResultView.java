package com.tencent.now.linkpkanchorplay.search.view;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.component.core.log.LogUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.now.linkpkanchorplay.invite.model.AnchorTabPageContext;
import com.tencent.now.linkpkanchorplay.search.model.SearchDataModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001,B/\u0012\u0006\u0010'\u001a\u00020&\u0012\u0006\u0010)\u001a\u00020(\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u00a2\u0006\u0004\b*\u0010+J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u0006\u0010\u0004\u001a\u00020\u0002J\u001e\u0010\n\u001a\u00020\u00022\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\bR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\"\u0010\u001b\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0013\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0017\u0010!\u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006-"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/search/view/SearchResultView;", "Landroid/widget/FrameLayout;", "", NodeProps.ON_DETACHED_FROM_WINDOW, "e", "", "Le55/a;", "anchorList", "", "isFirstPage", tl.h.F, "Lbn3/a;", "d", "Lbn3/a;", "searchViewModel", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/tencent/now/linkpkanchorplay/search/view/SearchResultView$b;", "f", "Lcom/tencent/now/linkpkanchorplay/search/view/SearchResultView$b;", "fetchDataHandler", "Lcom/tencent/now/linkpkanchorplay/recommendlist/widget/a;", "Lcom/tencent/now/linkpkanchorplay/recommendlist/widget/a;", "()Lcom/tencent/now/linkpkanchorplay/recommendlist/widget/a;", "setAnchorListAdapter", "(Lcom/tencent/now/linkpkanchorplay/recommendlist/widget/a;)V", "anchorListAdapter", "Landroidx/recyclerview/widget/RecyclerView;", "i", "Landroidx/recyclerview/widget/RecyclerView;", "g", "()Landroidx/recyclerview/widget/RecyclerView;", "recycleView", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "extra", "Landroid/content/Context;", "context", "Lcom/tencent/now/linkpkanchorplay/invite/model/a;", "pageContext", "<init>", "(Landroid/content/Context;Lcom/tencent/now/linkpkanchorplay/invite/model/a;Lbn3/a;Landroidx/lifecycle/LifecycleOwner;Lcom/tencent/now/linkpkanchorplay/search/view/SearchResultView$b;)V", "b", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class SearchResultView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final bn3.a searchViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleOwner lifecycleOwner;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b fetchDataHandler;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.now.linkpkanchorplay.recommendlist.widget.a anchorListAdapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RecyclerView recycleView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String extra;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/now/linkpkanchorplay/search/view/SearchResultView$a", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NotNull RecyclerView recyclerView, int dx5, int dy5) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, dx5, dy5);
            if (SearchResultView.this.getAnchorListAdapter().getNUM_BACKGOURND_ICON() > 0 && SearchResultView.this.getRecycleView().computeVerticalScrollExtent() + SearchResultView.this.getRecycleView().computeVerticalScrollOffset() >= SearchResultView.this.getRecycleView().computeVerticalScrollRange()) {
                SearchResultView.this.fetchDataHandler.a(SearchResultView.this.extra);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/search/view/SearchResultView$b;", "", "", "extra", "", "a", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public interface b {
        void a(@NotNull String extra);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchResultView(@NotNull Context context, @NotNull AnchorTabPageContext pageContext, @NotNull bn3.a searchViewModel, @NotNull LifecycleOwner lifecycleOwner, @NotNull b fetchDataHandler) {
        super(context);
        int i3;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pageContext, "pageContext");
        Intrinsics.checkNotNullParameter(searchViewModel, "searchViewModel");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(fetchDataHandler, "fetchDataHandler");
        this.searchViewModel = searchViewModel;
        this.lifecycleOwner = lifecycleOwner;
        this.fetchDataHandler = fetchDataHandler;
        this.extra = "";
        View.inflate(context, R.layout.f168237ff1, this);
        com.tencent.now.linkpkanchorplay.recommendlist.widget.a aVar = new com.tencent.now.linkpkanchorplay.recommendlist.widget.a(context);
        this.anchorListAdapter = aVar;
        aVar.x0(new e55.a[0]);
        this.anchorListAdapter.y0(pageContext.getCurSelectInviteType());
        if (pageContext.getCurSelectInviteType() == 1) {
            i3 = 2;
        } else {
            i3 = 3;
        }
        this.anchorListAdapter.z0(i3);
        this.anchorListAdapter.q0(R.layout.f168236ff0);
        View findViewById = findViewById(R.id.f71433o5);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<RecyclerVie\u2026.recommend_recycler_view)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.recycleView = recyclerView;
        recyclerView.setAdapter(this.anchorListAdapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.addOnScrollListener(new a());
        searchViewModel.Q1().observe(lifecycleOwner, new Observer() { // from class: com.tencent.now.linkpkanchorplay.search.view.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SearchResultView.b(SearchResultView.this, (SearchDataModel.SearchResult) obj);
            }
        });
        setClickable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(SearchResultView this$0, SearchDataModel.SearchResult searchResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (searchResult != null) {
            this$0.extra = searchResult.getExtra();
            this$0.h(searchResult.a(), searchResult.getIsFirstPage());
        }
    }

    public final void e() {
        this.anchorListAdapter.clearData();
        this.extra = "";
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final com.tencent.now.linkpkanchorplay.recommendlist.widget.a getAnchorListAdapter() {
        return this.anchorListAdapter;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final RecyclerView getRecycleView() {
        return this.recycleView;
    }

    public final void h(@Nullable List<e55.a> anchorList, boolean isFirstPage) {
        if (anchorList != null && !anchorList.isEmpty()) {
            LogUtil.i("SearchDataModel", "updateAnchorList size:" + anchorList.size(), new Object[0]);
            if (isFirstPage) {
                com.tencent.now.linkpkanchorplay.recommendlist.widget.a aVar = this.anchorListAdapter;
                Object[] array = anchorList.toArray(new e55.a[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                aVar.u0((e55.a[]) array);
                return;
            }
            com.tencent.now.linkpkanchorplay.recommendlist.widget.a aVar2 = this.anchorListAdapter;
            Object[] array2 = anchorList.toArray(new e55.a[0]);
            Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            aVar2.x0((e55.a[]) array2);
            return;
        }
        LogUtil.i("SearchDataModel", "updateAnchorList  result is null", new Object[0]);
        if (isFirstPage) {
            this.anchorListAdapter.clearData();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.anchorListAdapter.onDetachedFromRecyclerView(this.recycleView);
    }

    public final void setAnchorListAdapter(@NotNull com.tencent.now.linkpkanchorplay.recommendlist.widget.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.anchorListAdapter = aVar;
    }
}
