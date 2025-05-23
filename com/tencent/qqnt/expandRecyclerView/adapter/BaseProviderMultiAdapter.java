package com.tencent.qqnt.expandRecyclerView.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqnt.chathistory.ui.base.item.e;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007\u00a2\u0006\u0004\bJ\u0010KJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001e\u0010\u000b\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b2\u0006\u0010\n\u001a\u00020\u0004H$J\u0016\u0010\u000e\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\fH\u0016J\u0018\u0010\u0010\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u0004H\u0014J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0003H\u0016J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0016H\u0014J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0003H\u0016J\u0018\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0016J\u0018\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0004H\u0016J&\u0010!\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00042\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0016J\b\u0010\"\u001a\u00020\u0004H\u0016J\u0010\u0010%\u001a\u00020$2\u0006\u0010#\u001a\u00020\u0004H\u0014J \u0010(\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\u00042\f\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000&H\u0016J\u0018\u0010)\u001a\u00020\u00062\u000e\b\u0001\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000&H\u0016J\u0017\u0010*\u001a\u00020\u00062\u0006\u0010\t\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b*\u0010+J\u0010\u0010,\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\u0004J\u0018\u0010.\u001a\u00020\u00062\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010&H\u0016R\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000/8\u0006\u00a2\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R*\u0010;\u001a\u00020$2\u0006\u00104\u001a\u00020$8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R$\u0010C\u001a\u0004\u0018\u00010<8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR'\u0010I\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f0D8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\u00a8\u0006L"}, d2 = {"Lcom/tencent/qqnt/expandRecyclerView/adapter/BaseProviderMultiAdapter;", "T", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/qqnt/expandRecyclerView/adapter/a;", "", "size", "", "l0", "", "data", "position", "o0", "Lcom/tencent/qqnt/expandRecyclerView/adapter/provider/a;", "provider", "k0", "viewType", "n0", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "onAttachedToRecyclerView", "holder", "v0", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "A0", "w0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "u0", "getItemViewType", "s0", "", "", "payloads", "t0", "getItemCount", "type", "", "r0", "", "newData", "i0", "j0", "x0", "(Ljava/lang/Object;)V", "y0", "list", "B0", "Ljava/util/concurrent/CopyOnWriteArrayList;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/concurrent/CopyOnWriteArrayList;", "m0", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "value", BdhLogUtil.LogTag.Tag_Conn, "Z", "getCanLoadMore", "()Z", "z0", "(Z)V", "canLoadMore", "Landroid/view/View$OnClickListener;", "D", "Landroid/view/View$OnClickListener;", "p0", "()Landroid/view/View$OnClickListener;", "C0", "(Landroid/view/View$OnClickListener;)V", "loadMoreAction", "Landroid/util/SparseArray;", "E", "Lkotlin/Lazy;", "q0", "()Landroid/util/SparseArray;", "mItemProviders", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public abstract class BaseProviderMultiAdapter<T> extends RecyclerView.Adapter<com.tencent.qqnt.expandRecyclerView.adapter.a> {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    private boolean canLoadMore;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private View.OnClickListener loadMoreAction;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy mItemProviders;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CopyOnWriteArrayList<T> data;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/qqnt/expandRecyclerView/adapter/BaseProviderMultiAdapter$a", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "", "position", "getSpanSize", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class a extends GridLayoutManager.SpanSizeLookup {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaseProviderMultiAdapter<T> f356713a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ RecyclerView.LayoutManager f356714b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ GridLayoutManager.SpanSizeLookup f356715c;

        a(BaseProviderMultiAdapter<T> baseProviderMultiAdapter, RecyclerView.LayoutManager layoutManager, GridLayoutManager.SpanSizeLookup spanSizeLookup) {
            this.f356713a = baseProviderMultiAdapter;
            this.f356714b = layoutManager;
            this.f356715c = spanSizeLookup;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, baseProviderMultiAdapter, layoutManager, spanSizeLookup);
            }
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int position) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, position)).intValue();
            }
            if (this.f356713a.r0(this.f356713a.getItemViewType(position))) {
                return ((GridLayoutManager) this.f356714b).getSpanCount();
            }
            return this.f356715c.getSpanSize(position);
        }
    }

    public BaseProviderMultiAdapter() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.data = new CopyOnWriteArrayList<>();
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) BaseProviderMultiAdapter$mItemProviders$2.INSTANCE);
        this.mItemProviders = lazy;
    }

    private final void l0(int size) {
        if (this.data.size() == size) {
            notifyDataSetChanged();
        }
    }

    private final SparseArray<com.tencent.qqnt.expandRecyclerView.adapter.provider.a<T>> q0() {
        return (SparseArray) this.mItemProviders.getValue();
    }

    protected void A0(@NotNull RecyclerView.ViewHolder holder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) holder);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
            ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
        }
    }

    public void B0(@Nullable Collection<? extends T> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) list);
            return;
        }
        CopyOnWriteArrayList<T> copyOnWriteArrayList = this.data;
        boolean z16 = false;
        if (list != copyOnWriteArrayList) {
            copyOnWriteArrayList.clear();
            if (list == null || list.isEmpty()) {
                z16 = true;
            }
            if (!z16) {
                this.data.addAll(list);
            }
        } else {
            if (list == null || list.isEmpty()) {
                z16 = true;
            }
            if (!z16) {
                ArrayList arrayList = new ArrayList(list);
                this.data.clear();
                this.data.addAll(arrayList);
            } else {
                this.data.clear();
            }
        }
        notifyDataSetChanged();
    }

    public final void C0(@Nullable View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) onClickListener);
        } else {
            this.loadMoreAction = onClickListener;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        return this.data.size() + (this.canLoadMore ? 1 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this, position)).intValue();
        }
        if (this.canLoadMore && position == this.data.size()) {
            return 10;
        }
        if (position >= this.data.size()) {
            return -1;
        }
        return o0(this.data, position);
    }

    public void i0(@IntRange(from = 0) int position, @NotNull Collection<? extends T> newData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, position, (Object) newData);
            return;
        }
        Intrinsics.checkNotNullParameter(newData, "newData");
        this.data.addAll(position, newData);
        notifyItemRangeInserted(position, newData.size());
        l0(newData.size());
    }

    public void j0(@NonNull @NotNull Collection<? extends T> newData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) newData);
            return;
        }
        Intrinsics.checkNotNullParameter(newData, "newData");
        this.data.addAll(newData);
        notifyItemRangeInserted(this.data.size() - newData.size(), newData.size());
        l0(newData.size());
    }

    public void k0(@NotNull com.tencent.qqnt.expandRecyclerView.adapter.provider.a<T> provider) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) provider);
            return;
        }
        Intrinsics.checkNotNullParameter(provider, "provider");
        provider.k(this);
        q0().put(provider.f(), provider);
    }

    @NotNull
    public final CopyOnWriteArrayList<T> m0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (CopyOnWriteArrayList) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.data;
    }

    @Nullable
    protected com.tencent.qqnt.expandRecyclerView.adapter.provider.a<T> n0(int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (com.tencent.qqnt.expandRecyclerView.adapter.provider.a) iPatchRedirector.redirect((short) 8, (Object) this, viewType);
        }
        return q0().get(viewType);
    }

    protected abstract int o0(@NotNull List<? extends T> data, int position);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NotNull RecyclerView recyclerView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) recyclerView);
            return;
        }
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            gridLayoutManager.setSpanSizeLookup(new a(this, layoutManager, gridLayoutManager.getSpanSizeLookup()));
        }
    }

    @Nullable
    public final View.OnClickListener p0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View.OnClickListener) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.loadMoreAction;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean r0(int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, type)).booleanValue();
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: s0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull com.tencent.qqnt.expandRecyclerView.adapter.a holder, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) holder, position);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (this.canLoadMore && position == this.data.size()) {
            com.tencent.qqnt.expandRecyclerView.adapter.provider.a<T> n06 = n0(holder.getItemViewType());
            Intrinsics.checkNotNull(n06);
            n06.a(holder, new e());
        } else {
            com.tencent.qqnt.expandRecyclerView.adapter.provider.a<T> n07 = n0(holder.getItemViewType());
            Intrinsics.checkNotNull(n07);
            n07.a(holder, this.data.get(position));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: t0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull com.tencent.qqnt.expandRecyclerView.adapter.a holder, int position, @NotNull List<Object> payloads) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, holder, Integer.valueOf(position), payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.onBindViewHolder(holder, position, payloads);
        if (this.canLoadMore && position == this.data.size()) {
            return;
        }
        com.tencent.qqnt.expandRecyclerView.adapter.provider.a<T> n06 = n0(holder.getItemViewType());
        Intrinsics.checkNotNull(n06);
        n06.b(holder, this.data.get(position), payloads);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: u0, reason: merged with bridge method [inline-methods] */
    public com.tencent.qqnt.expandRecyclerView.adapter.a onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (com.tencent.qqnt.expandRecyclerView.adapter.a) iPatchRedirector.redirect((short) 13, (Object) this, (Object) parent, viewType);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        com.tencent.qqnt.expandRecyclerView.adapter.provider.a<T> n06 = n0(viewType);
        if (n06 != null) {
            Context context = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "parent.context");
            n06.l(context);
            com.tencent.qqnt.expandRecyclerView.adapter.a g16 = n06.g(parent, viewType);
            n06.j(g16, viewType);
            return g16;
        }
        throw new IllegalStateException(("ViewType: " + viewType + " no such provider found\uff0cplease use addItemProvider() first!").toString());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: v0, reason: merged with bridge method [inline-methods] */
    public void onViewAttachedToWindow(@NotNull com.tencent.qqnt.expandRecyclerView.adapter.a holder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) holder);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewAttachedToWindow(holder);
        if (r0(holder.getItemViewType())) {
            A0(holder);
        }
        com.tencent.qqnt.expandRecyclerView.adapter.provider.a<T> n06 = n0(holder.getItemViewType());
        if (n06 != null) {
            n06.h(holder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: w0, reason: merged with bridge method [inline-methods] */
    public void onViewDetachedFromWindow(@NotNull com.tencent.qqnt.expandRecyclerView.adapter.a holder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) holder);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewDetachedFromWindow(holder);
        com.tencent.qqnt.expandRecyclerView.adapter.provider.a<T> n06 = n0(holder.getItemViewType());
        if (n06 != null) {
            n06.i(holder);
        }
    }

    public void x0(T data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) data);
            return;
        }
        int indexOf = this.data.indexOf(data);
        if (indexOf == -1) {
            return;
        }
        y0(indexOf);
    }

    public final void y0(@IntRange(from = 0) int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, position);
        } else {
            if (position >= this.data.size()) {
                return;
            }
            this.data.remove(position);
            notifyItemRemoved(position);
            l0(0);
            notifyItemRangeChanged(position, this.data.size() - position);
        }
    }

    public final void z0(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else if (this.canLoadMore != z16) {
            if (z16) {
                notifyItemInserted(getItemCount());
            } else {
                notifyItemRemoved(getItemCount());
            }
            this.canLoadMore = z16;
        }
    }
}
