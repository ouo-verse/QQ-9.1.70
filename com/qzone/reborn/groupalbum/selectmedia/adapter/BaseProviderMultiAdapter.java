package com.qzone.reborn.groupalbum.selectmedia.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import zi.d;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007\u00a2\u0006\u0004\bG\u0010HJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001e\u0010\u000b\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b2\u0006\u0010\n\u001a\u00020\u0004H$J\u0016\u0010\u000e\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\fH\u0016J\u0018\u0010\u0010\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u0004H\u0014J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0003H\u0016J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0016H\u0014J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0003H\u0016J\u0018\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0016J\u0018\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0004H\u0016J&\u0010!\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00042\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0016J\b\u0010\"\u001a\u00020\u0004H\u0016J\u0010\u0010%\u001a\u00020$2\u0006\u0010#\u001a\u00020\u0004H\u0014J \u0010(\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\u00042\f\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000&H\u0016J\u0018\u0010)\u001a\u00020\u00062\u000e\b\u0001\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000&H\u0016J\u0018\u0010+\u001a\u00020\u00062\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010&H\u0016R\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000,8\u0006\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R*\u00108\u001a\u00020$2\u0006\u00101\u001a\u00020$8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R$\u0010@\u001a\u0004\u0018\u0001098\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R'\u0010F\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f0A8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\u00a8\u0006I"}, d2 = {"Lcom/qzone/reborn/groupalbum/selectmedia/adapter/BaseProviderMultiAdapter;", "T", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/qzone/reborn/groupalbum/selectmedia/adapter/a;", "", "size", "", "l0", "", "data", "position", "o0", "Lxi/a;", "provider", "k0", "viewType", "n0", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "onAttachedToRecyclerView", "holder", "v0", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "y0", "w0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "u0", "getItemViewType", "s0", "", "", "payloads", "t0", "getItemCount", "type", "", "r0", "", "newData", "i0", "j0", "list", "z0", "Ljava/util/concurrent/CopyOnWriteArrayList;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/concurrent/CopyOnWriteArrayList;", "m0", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "value", BdhLogUtil.LogTag.Tag_Conn, "Z", "getCanLoadMore", "()Z", "x0", "(Z)V", "canLoadMore", "Landroid/view/View$OnClickListener;", "D", "Landroid/view/View$OnClickListener;", "p0", "()Landroid/view/View$OnClickListener;", "A0", "(Landroid/view/View$OnClickListener;)V", "loadMoreAction", "Landroid/util/SparseArray;", "E", "Lkotlin/Lazy;", "q0", "()Landroid/util/SparseArray;", "mItemProviders", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public abstract class BaseProviderMultiAdapter<T> extends RecyclerView.Adapter<com.qzone.reborn.groupalbum.selectmedia.adapter.a> {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean canLoadMore;

    /* renamed from: D, reason: from kotlin metadata */
    private View.OnClickListener loadMoreAction;

    /* renamed from: E, reason: from kotlin metadata */
    private final Lazy mItemProviders;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final CopyOnWriteArrayList<T> data = new CopyOnWriteArrayList<>();

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/qzone/reborn/groupalbum/selectmedia/adapter/BaseProviderMultiAdapter$a", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "", "position", "getSpanSize", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class a extends GridLayoutManager.SpanSizeLookup {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaseProviderMultiAdapter<T> f56903a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ RecyclerView.LayoutManager f56904b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ GridLayoutManager.SpanSizeLookup f56905c;

        a(BaseProviderMultiAdapter<T> baseProviderMultiAdapter, RecyclerView.LayoutManager layoutManager, GridLayoutManager.SpanSizeLookup spanSizeLookup) {
            this.f56903a = baseProviderMultiAdapter;
            this.f56904b = layoutManager;
            this.f56905c = spanSizeLookup;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int position) {
            if (this.f56903a.r0(this.f56903a.getItemViewType(position))) {
                return ((GridLayoutManager) this.f56904b).getSpanCount();
            }
            return this.f56905c.getSpanSize(position);
        }
    }

    public BaseProviderMultiAdapter() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<SparseArray<xi.a<T>>>() { // from class: com.qzone.reborn.groupalbum.selectmedia.adapter.BaseProviderMultiAdapter$mItemProviders$2
            @Override // kotlin.jvm.functions.Function0
            public final SparseArray<xi.a<T>> invoke() {
                return new SparseArray<>();
            }
        });
        this.mItemProviders = lazy;
    }

    private final void l0(int size) {
        if (this.data.size() == size) {
            notifyDataSetChanged();
        }
    }

    private final SparseArray<xi.a<T>> q0() {
        return (SparseArray) this.mItemProviders.getValue();
    }

    public final void A0(View.OnClickListener onClickListener) {
        this.loadMoreAction = onClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.data.size() + (this.canLoadMore ? 1 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        if (this.canLoadMore && position == this.data.size()) {
            return 10;
        }
        if (position >= this.data.size()) {
            return -1;
        }
        return o0(this.data, position);
    }

    public void i0(int position, Collection<? extends T> newData) {
        Intrinsics.checkNotNullParameter(newData, "newData");
        this.data.addAll(position, newData);
        notifyItemRangeInserted(position, newData.size());
        l0(newData.size());
    }

    public void j0(Collection<? extends T> newData) {
        Intrinsics.checkNotNullParameter(newData, "newData");
        this.data.addAll(newData);
        notifyItemRangeInserted(this.data.size() - newData.size(), newData.size());
        l0(newData.size());
    }

    public void k0(xi.a<T> provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        provider.k(this);
        q0().put(provider.f(), provider);
    }

    public final CopyOnWriteArrayList<T> m0() {
        return this.data;
    }

    protected xi.a<T> n0(int viewType) {
        return q0().get(viewType);
    }

    protected abstract int o0(List<? extends T> data, int position);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            gridLayoutManager.setSpanSizeLookup(new a(this, layoutManager, gridLayoutManager.getSpanSizeLookup()));
        }
    }

    /* renamed from: p0, reason: from getter */
    public final View.OnClickListener getLoadMoreAction() {
        return this.loadMoreAction;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean r0(int type) {
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: s0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(com.qzone.reborn.groupalbum.selectmedia.adapter.a holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (this.canLoadMore && position == this.data.size()) {
            xi.a<T> n06 = n0(holder.getItemViewType());
            Intrinsics.checkNotNull(n06);
            n06.a(holder, new d());
        } else {
            xi.a<T> n07 = n0(holder.getItemViewType());
            Intrinsics.checkNotNull(n07);
            n07.a(holder, this.data.get(position));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: t0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(com.qzone.reborn.groupalbum.selectmedia.adapter.a holder, int position, List<Object> payloads) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.onBindViewHolder(holder, position, payloads);
        if (this.canLoadMore && position == this.data.size()) {
            return;
        }
        xi.a<T> n06 = n0(holder.getItemViewType());
        Intrinsics.checkNotNull(n06);
        n06.b(holder, this.data.get(position), payloads);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: u0, reason: merged with bridge method [inline-methods] */
    public com.qzone.reborn.groupalbum.selectmedia.adapter.a onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        xi.a<T> n06 = n0(viewType);
        if (n06 != null) {
            Context context = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "parent.context");
            n06.l(context);
            com.qzone.reborn.groupalbum.selectmedia.adapter.a g16 = n06.g(parent, viewType);
            n06.j(g16, viewType);
            return g16;
        }
        throw new IllegalStateException(("ViewType: " + viewType + " no such provider found\uff0cplease use addItemProvider() first!").toString());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: v0, reason: merged with bridge method [inline-methods] */
    public void onViewAttachedToWindow(com.qzone.reborn.groupalbum.selectmedia.adapter.a holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewAttachedToWindow(holder);
        if (r0(holder.getItemViewType())) {
            y0(holder);
        }
        xi.a<T> n06 = n0(holder.getItemViewType());
        if (n06 != null) {
            n06.h(holder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: w0, reason: merged with bridge method [inline-methods] */
    public void onViewDetachedFromWindow(com.qzone.reborn.groupalbum.selectmedia.adapter.a holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewDetachedFromWindow(holder);
        xi.a<T> n06 = n0(holder.getItemViewType());
        if (n06 != null) {
            n06.i(holder);
        }
    }

    public final void x0(boolean z16) {
        if (this.canLoadMore != z16) {
            if (z16) {
                notifyItemInserted(getItemCount());
            } else {
                notifyItemRemoved(getItemCount());
            }
            this.canLoadMore = z16;
        }
    }

    protected void y0(RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
            ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
        }
    }

    public void z0(Collection<? extends T> list) {
        CopyOnWriteArrayList<T> copyOnWriteArrayList = this.data;
        if (list != copyOnWriteArrayList) {
            copyOnWriteArrayList.clear();
            if (!(list == null || list.isEmpty())) {
                this.data.addAll(list);
            }
        } else {
            if (!(list == null || list.isEmpty())) {
                ArrayList arrayList = new ArrayList(list);
                this.data.clear();
                this.data.addAll(arrayList);
            } else {
                this.data.clear();
            }
        }
        notifyDataSetChanged();
    }
}
