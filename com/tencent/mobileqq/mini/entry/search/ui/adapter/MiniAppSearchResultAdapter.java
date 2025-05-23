package com.tencent.mobileqq.mini.entry.search.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerViewHelper;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchDetailApi;
import com.tencent.mobileqq.search.searchdetail.a;
import com.tencent.mobileqq.search.searchdetail.d;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import sp2.b;
import sp2.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002()B\u0007\u00a2\u0006\u0004\b&\u0010'J\u000e\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u00020\u0002H\u0002J\f\u0010\u0007\u001a\u00020\u0006*\u00020\u0005H\u0002J\u0016\u0010\u000b\u001a\u00020\u00062\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bJ\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0018\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\b\u0010\u0018\u001a\u00020\u0012H\u0016J\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u0012H\u0016R\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u001cR\u001b\u0010\"\u001a\u00020\u001d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\t0#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/search/ui/adapter/MiniAppSearchResultAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/search/searchdetail/d;", "ioc", "Landroid/view/View;", "", "adjust", "", "Lcom/tencent/mobileqq/search/searchdetail/a;", "newList", "setData", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "onAttachedToRecyclerView", "onDetachedFromRecyclerView", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "onCreateViewHolder", "holder", "position", "onBindViewHolder", "getItemCount", "getItemViewType", "", "getItemId", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/tencent/mobileqq/search/api/ISearchDetailApi;", "detailSearchApi$delegate", "Lkotlin/Lazy;", "getDetailSearchApi", "()Lcom/tencent/mobileqq/search/api/ISearchDetailApi;", "detailSearchApi", "", "appList", "Ljava/util/List;", "<init>", "()V", "MiniAppViewHolder", "TitleViewHolder", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class MiniAppSearchResultAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final List<a> appList;

    /* renamed from: detailSearchApi$delegate, reason: from kotlin metadata */
    private final Lazy detailSearchApi;
    private RecyclerView recyclerView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/search/ui/adapter/MiniAppSearchResultAdapter$MiniAppViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lsp2/c;", "real", "Lsp2/c;", "getReal", "()Lsp2/c;", "<init>", "(Lsp2/c;)V", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class MiniAppViewHolder extends RecyclerView.ViewHolder {
        private final c real;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MiniAppViewHolder(c real) {
            super(real.getView());
            Intrinsics.checkNotNullParameter(real, "real");
            this.real = real;
        }

        public final c getReal() {
            return this.real;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/search/ui/adapter/MiniAppSearchResultAdapter$TitleViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lsp2/b;", "real", "Lsp2/b;", "getReal", "()Lsp2/b;", "<init>", "(Lsp2/b;)V", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class TitleViewHolder extends RecyclerView.ViewHolder {
        private final b real;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TitleViewHolder(b real) {
            super(real.getView());
            Intrinsics.checkNotNullParameter(real, "real");
            this.real = real;
        }

        public final b getReal() {
            return this.real;
        }
    }

    public MiniAppSearchResultAdapter() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ISearchDetailApi>() { // from class: com.tencent.mobileqq.mini.entry.search.ui.adapter.MiniAppSearchResultAdapter$detailSearchApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ISearchDetailApi invoke() {
                return (ISearchDetailApi) QRoute.api(ISearchDetailApi.class);
            }
        });
        this.detailSearchApi = lazy;
        this.appList = new ArrayList();
    }

    private final void adjust(View view) {
        view.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
    }

    private final ISearchDetailApi getDetailSearchApi() {
        return (ISearchDetailApi) this.detailSearchApi.getValue();
    }

    private final d ioc(RecyclerView.ViewHolder viewHolder) {
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            RecyclerViewHelper recyclerViewHelper = RecyclerViewHelper.INSTANCE;
            View itemView = viewHolder.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            recyclerView = recyclerViewHelper.getOwnerRecyclerView(itemView);
        }
        return (d) RFWIocAbilityProvider.g().getIocInterface(d.class, viewHolder.itemView, recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.appList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        return this.appList.get(position).getItemId().hashCode();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return this.appList.get(position).getItemType();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerView = recyclerView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        d ioc = ioc(holder);
        if (holder instanceof MiniAppViewHolder) {
            ((MiniAppViewHolder) holder).getReal().a(this.appList.get(position), position, null, ioc);
        } else if (holder instanceof TitleViewHolder) {
            ((TitleViewHolder) holder).getReal().a(this.appList.get(position), position, null, ioc);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Context context = parent.getContext();
        if (viewType == 7) {
            ISearchDetailApi detailSearchApi = getDetailSearchApi();
            Intrinsics.checkNotNullExpressionValue(detailSearchApi, "detailSearchApi");
            Intrinsics.checkNotNullExpressionValue(context, "context");
            b b16 = ISearchDetailApi.a.b(detailSearchApi, context, null, 2, null);
            adjust(b16.getView());
            return new TitleViewHolder(b16);
        }
        if (viewType == 22) {
            ISearchDetailApi detailSearchApi2 = getDetailSearchApi();
            Intrinsics.checkNotNullExpressionValue(detailSearchApi2, "detailSearchApi");
            Intrinsics.checkNotNullExpressionValue(context, "context");
            c a16 = ISearchDetailApi.a.a(detailSearchApi2, context, null, 2, null);
            adjust(a16.getView());
            return new MiniAppViewHolder(a16);
        }
        throw new IllegalArgumentException("Invalid view type: " + viewType);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onDetachedFromRecyclerView(recyclerView);
        this.recyclerView = null;
    }

    public final void setData(final List<? extends a> newList) {
        final List list;
        list = CollectionsKt___CollectionsKt.toList(this.appList);
        if (newList == null) {
            newList = CollectionsKt__CollectionsKt.emptyList();
        }
        DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new DiffUtil.Callback() { // from class: com.tencent.mobileqq.mini.entry.search.ui.adapter.MiniAppSearchResultAdapter$setData$diffResult$1
            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public boolean areContentsTheSame(int oldPos, int newPos) {
                return list.get(oldPos).a(newList.get(newPos));
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public boolean areItemsTheSame(int oldPos, int newPos) {
                return list.get(oldPos).b(newList.get(newPos));
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public int getNewListSize() {
                return newList.size();
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public int getOldListSize() {
                return list.size();
            }
        });
        Intrinsics.checkNotNullExpressionValue(calculateDiff, "oldList = appList.toList\u2026wList[newPos])\n        })");
        this.appList.clear();
        this.appList.addAll(newList);
        calculateDiff.dispatchUpdatesTo(this);
        VideoReport.traversePage(this.recyclerView);
    }
}
