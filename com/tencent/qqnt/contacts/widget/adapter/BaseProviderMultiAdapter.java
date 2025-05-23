package com.tencent.qqnt.contacts.widget.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007\u00a2\u0006\u0004\b2\u00103J\u001e\u0010\b\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0007\u001a\u00020\u0006H$J\u0016\u0010\f\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0016J\u0018\u0010\u000e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\u0006H\u0014J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0003H\u0016J\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0014H\u0014J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0003H\u0016J\u0018\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\u0006H\u0016J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J&\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0016J\b\u0010 \u001a\u00020\u0006H\u0016J\u0010\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020\u0006H\u0014J\u0018\u0010&\u001a\u00020\u000b2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010$H\u0016R\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000'8\u0006\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R'\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t0,8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\u00a8\u00064"}, d2 = {"Lcom/tencent/qqnt/contacts/widget/adapter/BaseProviderMultiAdapter;", "T", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/qqnt/contacts/widget/adapter/a;", "", "data", "", "position", "l0", "Lcom/tencent/qqnt/contacts/widget/adapter/provider/a;", "provider", "", "i0", "viewType", "k0", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "onAttachedToRecyclerView", "holder", "r0", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "t0", "s0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "q0", "getItemViewType", "o0", "", "", "payloads", "p0", "getItemCount", "type", "", "n0", "", "list", "u0", "Ljava/util/concurrent/CopyOnWriteArrayList;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/concurrent/CopyOnWriteArrayList;", "j0", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroid/util/SparseArray;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "m0", "()Landroid/util/SparseArray;", "mItemProviders", "<init>", "()V", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public abstract class BaseProviderMultiAdapter<T> extends RecyclerView.Adapter<com.tencent.qqnt.contacts.widget.adapter.a> {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy mItemProviders;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CopyOnWriteArrayList<T> data;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/qqnt/contacts/widget/adapter/BaseProviderMultiAdapter$a", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "", "position", "getSpanSize", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class a extends GridLayoutManager.SpanSizeLookup {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaseProviderMultiAdapter<T> f355906a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ RecyclerView.LayoutManager f355907b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ GridLayoutManager.SpanSizeLookup f355908c;

        a(BaseProviderMultiAdapter<T> baseProviderMultiAdapter, RecyclerView.LayoutManager layoutManager, GridLayoutManager.SpanSizeLookup spanSizeLookup) {
            this.f355906a = baseProviderMultiAdapter;
            this.f355907b = layoutManager;
            this.f355908c = spanSizeLookup;
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
            if (this.f355906a.n0(this.f355906a.getItemViewType(position))) {
                return ((GridLayoutManager) this.f355907b).getSpanCount();
            }
            return this.f355908c.getSpanSize(position);
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

    private final SparseArray<com.tencent.qqnt.contacts.widget.adapter.provider.a<T>> m0() {
        return (SparseArray) this.mItemProviders.getValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return this.data.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this, position)).intValue();
        }
        return l0(this.data, position);
    }

    public void i0(@NotNull com.tencent.qqnt.contacts.widget.adapter.provider.a<T> provider) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) provider);
            return;
        }
        Intrinsics.checkNotNullParameter(provider, "provider");
        provider.k(this);
        m0().put(provider.f(), provider);
    }

    @NotNull
    public final CopyOnWriteArrayList<T> j0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (CopyOnWriteArrayList) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.data;
    }

    @Nullable
    protected com.tencent.qqnt.contacts.widget.adapter.provider.a<T> k0(int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.qqnt.contacts.widget.adapter.provider.a) iPatchRedirector.redirect((short) 4, (Object) this, viewType);
        }
        return m0().get(viewType);
    }

    protected abstract int l0(@NotNull List<? extends T> data, int position);

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean n0(int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, type)).booleanValue();
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull com.tencent.qqnt.contacts.widget.adapter.a holder, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) holder, position);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        com.tencent.qqnt.contacts.widget.adapter.provider.a<T> k06 = k0(holder.getItemViewType());
        Intrinsics.checkNotNull(k06);
        k06.a(holder, this.data.get(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NotNull RecyclerView recyclerView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) recyclerView);
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

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull com.tencent.qqnt.contacts.widget.adapter.a holder, int position, @NotNull List<Object> payloads) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, holder, Integer.valueOf(position), payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.onBindViewHolder(holder, position, payloads);
        com.tencent.qqnt.contacts.widget.adapter.provider.a<T> k06 = k0(holder.getItemViewType());
        Intrinsics.checkNotNull(k06);
        k06.b(holder, this.data.get(position), payloads);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public com.tencent.qqnt.contacts.widget.adapter.a onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (com.tencent.qqnt.contacts.widget.adapter.a) iPatchRedirector.redirect((short) 9, (Object) this, (Object) parent, viewType);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        com.tencent.qqnt.contacts.widget.adapter.provider.a<T> k06 = k0(viewType);
        if (k06 != null) {
            Context context = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "parent.context");
            k06.l(context);
            com.tencent.qqnt.contacts.widget.adapter.a g16 = k06.g(parent, viewType);
            k06.j(g16, viewType);
            return g16;
        }
        throw new IllegalStateException(("ViewType: " + viewType + " no such provider found\uff0cplease use addItemProvider() first!").toString());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public void onViewAttachedToWindow(@NotNull com.tencent.qqnt.contacts.widget.adapter.a holder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) holder);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewAttachedToWindow(holder);
        if (n0(holder.getItemViewType())) {
            t0(holder);
        }
        com.tencent.qqnt.contacts.widget.adapter.provider.a<T> k06 = k0(holder.getItemViewType());
        if (k06 != null) {
            k06.h(holder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: s0, reason: merged with bridge method [inline-methods] */
    public void onViewDetachedFromWindow(@NotNull com.tencent.qqnt.contacts.widget.adapter.a holder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) holder);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewDetachedFromWindow(holder);
        com.tencent.qqnt.contacts.widget.adapter.provider.a<T> k06 = k0(holder.getItemViewType());
        if (k06 != null) {
            k06.i(holder);
        }
    }

    protected void t0(@NotNull RecyclerView.ViewHolder holder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) holder);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
            ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
        }
    }

    public void u0(@Nullable Collection<? extends T> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) list);
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
}
