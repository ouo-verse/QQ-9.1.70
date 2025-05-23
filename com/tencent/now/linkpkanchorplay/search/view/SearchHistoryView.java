package com.tencent.now.linkpkanchorplay.search.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.now.linkpkanchorplay.search.model.SearchHistoryData;
import com.tencent.now.linkpkanchorplay.search.view.SearchHistoryView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\"#B\u001f\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0004\b \u0010!J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0014R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR#\u0010\u0015\u001a\n \u0011*\u0004\u0018\u00010\u00100\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014R\u001b\u0010\u0019\u001a\u00020\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001d\u001a\u00020\u001a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006$"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/search/view/SearchHistoryView;", "Landroid/widget/FrameLayout;", "", "Lcom/tencent/now/linkpkanchorplay/search/model/SearchHistoryData;", "it", "", "i", NodeProps.ON_DETACHED_FROM_WINDOW, "Lbn3/a;", "d", "Lbn3/a;", "searchViewModel", "Landroidx/lifecycle/LifecycleOwner;", "e", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "f", "Lkotlin/Lazy;", "()Landroid/widget/ImageView;", "clearBtn", "Landroidx/recyclerview/widget/RecyclerView;", tl.h.F, "()Landroidx/recyclerview/widget/RecyclerView;", "historyRecyclerView", "Lcom/tencent/now/linkpkanchorplay/search/view/SearchHistoryView$a;", "g", "()Lcom/tencent/now/linkpkanchorplay/search/view/SearchHistoryView$a;", "historyAdapter", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lbn3/a;Landroidx/lifecycle/LifecycleOwner;)V", "a", "b", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class SearchHistoryView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final bn3.a searchViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleOwner lifecycleOwner;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy clearBtn;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy historyRecyclerView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy historyAdapter;

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/search/view/SearchHistoryView$a;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/now/linkpkanchorplay/search/view/SearchHistoryView$b;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "k0", "holder", "position", "", "j0", "getItemCount", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "onAttachedToRecyclerView", "Lbn3/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lbn3/a;", "historyDataModel", "<init>", "(Lbn3/a;)V", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class a extends RecyclerView.Adapter<b> {

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final bn3.a historyDataModel;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/now/linkpkanchorplay/search/view/SearchHistoryView$a$a", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "", "position", "getSpanSize", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.now.linkpkanchorplay.search.view.SearchHistoryView$a$a, reason: collision with other inner class name */
        /* loaded from: classes22.dex */
        public static final class C9248a extends GridLayoutManager.SpanSizeLookup {
            C9248a() {
            }

            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int position) {
                return a.this.historyDataModel.getSearchHistoryModel().b().get(position).getSpanSize();
            }
        }

        public a(@NotNull bn3.a historyDataModel) {
            Intrinsics.checkNotNullParameter(historyDataModel, "historyDataModel");
            this.historyDataModel = historyDataModel;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            return this.historyDataModel.getSearchHistoryModel().b().size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: j0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NotNull b holder, int position) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            holder.p(this.historyDataModel.getSearchHistoryModel().c(this.historyDataModel.getSearchHistoryModel().b().get(position).getSearchWord()));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NotNull
        /* renamed from: k0, reason: merged with bridge method [inline-methods] */
        public b onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ffh, parent, false);
            bn3.a aVar = this.historyDataModel;
            Intrinsics.checkNotNullExpressionValue(view, "view");
            return new b(aVar, view);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onAttachedToRecyclerView(@NotNull RecyclerView recyclerView) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onAttachedToRecyclerView(recyclerView);
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof GridLayoutManager) {
                ((GridLayoutManager) layoutManager).setSpanSizeLookup(new C9248a());
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/search/view/SearchHistoryView$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "o", "", "text", "p", "Lbn3/a;", "E", "Lbn3/a;", "searchViewModel", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "historyText", "Landroid/view/View;", "itemView", "<init>", "(Lbn3/a;Landroid/view/View;)V", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final bn3.a searchViewModel;

        /* renamed from: F, reason: from kotlin metadata */
        @Nullable
        private final TextView historyText;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull bn3.a searchViewModel, @NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(searchViewModel, "searchViewModel");
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.searchViewModel = searchViewModel;
            View findViewById = itemView.findViewById(R.id.f165697xa2);
            Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView = (TextView) findViewById;
            this.historyText = textView;
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.now.linkpkanchorplay.search.view.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SearchHistoryView.b.m(SearchHistoryView.b.this, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void m(b this$0, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.o();
            EventCollector.getInstance().onViewClicked(view);
        }

        private final void o() {
            CharSequence charSequence;
            bn3.a aVar = this.searchViewModel;
            TextView textView = this.historyText;
            if (textView != null) {
                charSequence = textView.getText();
            } else {
                charSequence = null;
            }
            Intrinsics.checkNotNull(charSequence, "null cannot be cast to non-null type kotlin.String");
            aVar.U1((String) charSequence);
        }

        public final void p(@Nullable String text) {
            TextView textView = this.historyText;
            if (textView != null) {
                textView.setText(text);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchHistoryView(@NotNull Context context, @NotNull bn3.a searchViewModel, @NotNull LifecycleOwner lifecycleOwner) {
        super(context);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(searchViewModel, "searchViewModel");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        this.searchViewModel = searchViewModel;
        this.lifecycleOwner = lifecycleOwner;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.now.linkpkanchorplay.search.view.SearchHistoryView$clearBtn$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                return (ImageView) SearchHistoryView.this.findViewById(R.id.txs);
            }
        });
        this.clearBtn = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<RecyclerView>() { // from class: com.tencent.now.linkpkanchorplay.search.view.SearchHistoryView$historyRecyclerView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RecyclerView invoke() {
                return (RecyclerView) SearchHistoryView.this.findViewById(R.id.f165699xa4);
            }
        });
        this.historyRecyclerView = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<a>() { // from class: com.tencent.now.linkpkanchorplay.search.view.SearchHistoryView$historyAdapter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final SearchHistoryView.a invoke() {
                bn3.a aVar;
                aVar = SearchHistoryView.this.searchViewModel;
                return new SearchHistoryView.a(aVar);
            }
        });
        this.historyAdapter = lazy3;
        View.inflate(context, R.layout.ffj, this);
        h().setLayoutManager(new GridLayoutManager(getContext(), 100));
        h().setAdapter(g());
        f().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.now.linkpkanchorplay.search.view.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchHistoryView.c(SearchHistoryView.this, view);
            }
        });
        searchViewModel.P1().observe(lifecycleOwner, new Observer() { // from class: com.tencent.now.linkpkanchorplay.search.view.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SearchHistoryView.d(SearchHistoryView.this, (List) obj);
            }
        });
        i(searchViewModel.getSearchHistoryModel().b());
        setClickable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(SearchHistoryView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.searchViewModel.N1();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(SearchHistoryView this$0, List it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.i(it);
    }

    private final ImageView f() {
        return (ImageView) this.clearBtn.getValue();
    }

    private final a g() {
        return (a) this.historyAdapter.getValue();
    }

    private final RecyclerView h() {
        Object value = this.historyRecyclerView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-historyRecyclerView>(...)");
        return (RecyclerView) value;
    }

    private final void i(List<SearchHistoryData> it) {
        if (!it.isEmpty()) {
            setVisibility(0);
            g().notifyDataSetChanged();
        } else {
            setVisibility(8);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.searchViewModel.onDestroy();
    }
}
