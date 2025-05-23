package com.tencent.mobileqq.guild.base.recyclerview.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.guild.base.recyclerview.provider.BaseItemProvider;
import com.tencent.mobileqq.guild.base.recyclerview.viewholder.BaseViewHolder;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u0002B\u0019\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010(\u00a2\u0006\u0004\b)\u0010*J\u001e\u0010\b\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0007\u001a\u00020\u0006H$J\u0016\u0010\f\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0016J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0006H\u0014J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0003H\u0016J\u001f\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00028\u0000H\u0014\u00a2\u0006\u0004\b\u0015\u0010\u0016J-\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00028\u00002\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0004H\u0014\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0006H\u0014J\u0018\u0010\u001d\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00020\u0006H\u0014J\u0010\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0003H\u0016J\u0010\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0003H\u0016J\u0010\u0010 \u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u0003H\u0014J\u0018\u0010!\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0006H\u0014R'\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t0\"8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/guild/base/recyclerview/adapter/BaseProviderMultiAdapter;", "T", "Lcom/tencent/mobileqq/guild/base/recyclerview/adapter/e;", "Lcom/tencent/mobileqq/guild/base/recyclerview/viewholder/BaseViewHolder;", "", "data", "", "position", "g1", "Lcom/tencent/mobileqq/guild/base/recyclerview/provider/BaseItemProvider;", "provider", "", "Y0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "L0", "r0", "holder", "j1", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "m0", "(Lcom/tencent/mobileqq/guild/base/recyclerview/viewholder/BaseViewHolder;Ljava/lang/Object;)V", "", "payloads", "n0", "(Lcom/tencent/mobileqq/guild/base/recyclerview/viewholder/BaseViewHolder;Ljava/lang/Object;Ljava/util/List;)V", "viewHolder", "k0", "f1", "O0", "i1", "c1", "Z0", "Landroid/util/SparseArray;", "V", "Lkotlin/Lazy;", "h1", "()Landroid/util/SparseArray;", "mItemProviders", "", "<init>", "(Ljava/util/List;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public abstract class BaseProviderMultiAdapter<T> extends e<T, BaseViewHolder> {

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final Lazy mItemProviders;

    public BaseProviderMultiAdapter() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a1(BaseViewHolder viewHolder, BaseProviderMultiAdapter this$0, BaseItemProvider provider, View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(viewHolder, "$viewHolder");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(provider, "$provider");
        int adapterPosition = viewHolder.getAdapterPosition();
        if (adapterPosition != -1) {
            int u06 = adapterPosition - this$0.u0();
            Intrinsics.checkNotNullExpressionValue(v3, "v");
            provider.l(viewHolder, v3, this$0.getData().get(u06), u06);
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean b1(BaseViewHolder viewHolder, BaseProviderMultiAdapter this$0, BaseItemProvider provider, View v3) {
        Intrinsics.checkNotNullParameter(viewHolder, "$viewHolder");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(provider, "$provider");
        int adapterPosition = viewHolder.getAdapterPosition();
        if (adapterPosition == -1) {
            return false;
        }
        int u06 = adapterPosition - this$0.u0();
        Intrinsics.checkNotNullExpressionValue(v3, "v");
        return provider.m(viewHolder, v3, this$0.getData().get(u06), u06);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d1(BaseViewHolder viewHolder, BaseProviderMultiAdapter this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(viewHolder, "$viewHolder");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int adapterPosition = viewHolder.getAdapterPosition();
        if (adapterPosition != -1) {
            int u06 = adapterPosition - this$0.u0();
            BaseItemProvider<T> baseItemProvider = this$0.h1().get(viewHolder.getItemViewType());
            Intrinsics.checkNotNullExpressionValue(it, "it");
            baseItemProvider.n(viewHolder, it, this$0.getData().get(u06), u06);
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean e1(BaseViewHolder viewHolder, BaseProviderMultiAdapter this$0, View it) {
        Intrinsics.checkNotNullParameter(viewHolder, "$viewHolder");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int adapterPosition = viewHolder.getAdapterPosition();
        if (adapterPosition == -1) {
            return false;
        }
        int u06 = adapterPosition - this$0.u0();
        BaseItemProvider<T> baseItemProvider = this$0.h1().get(viewHolder.getItemViewType());
        Intrinsics.checkNotNullExpressionValue(it, "it");
        return baseItemProvider.p(viewHolder, it, this$0.getData().get(u06), u06);
    }

    private final SparseArray<BaseItemProvider<T>> h1() {
        return (SparseArray) this.mItemProviders.getValue();
    }

    @Override // com.tencent.mobileqq.guild.base.recyclerview.adapter.e
    @NotNull
    protected BaseViewHolder L0(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        BaseItemProvider<T> f16 = f1(viewType);
        if (f16 != null) {
            Context context = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "parent.context");
            f16.v(context);
            BaseViewHolder o16 = f16.o(parent, viewType);
            f16.s(o16, viewType);
            return o16;
        }
        throw new IllegalStateException(("ViewType: " + viewType + " no such provider found\uff0cplease use addItemProvider() first!").toString());
    }

    @Override // com.tencent.mobileqq.guild.base.recyclerview.adapter.e, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: O0, reason: merged with bridge method [inline-methods] */
    public void onViewAttachedToWindow(@NotNull BaseViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewAttachedToWindow(holder);
        BaseItemProvider<T> f16 = f1(holder.getItemViewType());
        if (f16 != null) {
            f16.q(holder);
        }
    }

    public void Y0(@NotNull BaseItemProvider<T> provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        provider.u(this);
        h1().put(provider.i(), provider);
    }

    protected void Z0(@NotNull final BaseViewHolder viewHolder, int viewType) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        z0();
        final BaseItemProvider<T> f16 = f1(viewType);
        if (f16 == null) {
            return;
        }
        Iterator<T> it = f16.d().iterator();
        while (it.hasNext()) {
            View findViewById = viewHolder.itemView.findViewById(((Number) it.next()).intValue());
            if (findViewById != null) {
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<View>(id)");
                if (!findViewById.isClickable()) {
                    findViewById.setClickable(true);
                }
                findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.base.recyclerview.adapter.c
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        BaseProviderMultiAdapter.a1(BaseViewHolder.this, this, f16, view);
                    }
                });
            }
        }
        A0();
        final BaseItemProvider<T> f17 = f1(viewType);
        if (f17 == null) {
            return;
        }
        Iterator<T> it5 = f17.e().iterator();
        while (it5.hasNext()) {
            View findViewById2 = viewHolder.itemView.findViewById(((Number) it5.next()).intValue());
            if (findViewById2 != null) {
                Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById<View>(id)");
                if (!findViewById2.isLongClickable()) {
                    findViewById2.setLongClickable(true);
                }
                findViewById2.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.mobileqq.guild.base.recyclerview.adapter.d
                    @Override // android.view.View.OnLongClickListener
                    public final boolean onLongClick(View view) {
                        boolean b16;
                        b16 = BaseProviderMultiAdapter.b1(BaseViewHolder.this, this, f17, view);
                        return b16;
                    }
                });
            }
        }
    }

    protected void c1(@NotNull final BaseViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        B0();
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.base.recyclerview.adapter.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseProviderMultiAdapter.d1(BaseViewHolder.this, this, view);
            }
        });
        C0();
        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.mobileqq.guild.base.recyclerview.adapter.b
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean e16;
                e16 = BaseProviderMultiAdapter.e1(BaseViewHolder.this, this, view);
                return e16;
            }
        });
    }

    @Nullable
    protected BaseItemProvider<T> f1(int viewType) {
        return h1().get(viewType);
    }

    protected abstract int g1(@NotNull List<? extends T> data, int position);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i1, reason: merged with bridge method [inline-methods] */
    public void onViewDetachedFromWindow(@NotNull BaseViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewDetachedFromWindow(holder);
        BaseItemProvider<T> f16 = f1(holder.getItemViewType());
        if (f16 != null) {
            f16.r(holder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j1, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(@NotNull BaseViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewRecycled(holder);
        BaseItemProvider<T> f16 = f1(holder.getItemViewType());
        if (f16 != null) {
            f16.t(holder);
        }
    }

    @Override // com.tencent.mobileqq.guild.base.recyclerview.adapter.e
    protected void k0(@NotNull BaseViewHolder viewHolder, int viewType) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        super.k0(viewHolder, viewType);
        c1(viewHolder);
        Z0(viewHolder, viewType);
    }

    @Override // com.tencent.mobileqq.guild.base.recyclerview.adapter.e
    protected void m0(@NotNull BaseViewHolder holder, T item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        BaseItemProvider<T> f16 = f1(holder.getItemViewType());
        Intrinsics.checkNotNull(f16);
        f16.a(holder, item);
    }

    @Override // com.tencent.mobileqq.guild.base.recyclerview.adapter.e
    protected void n0(@NotNull BaseViewHolder holder, T item, @NotNull List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        BaseItemProvider<T> f16 = f1(holder.getItemViewType());
        Intrinsics.checkNotNull(f16);
        f16.b(holder, item, payloads);
    }

    @Override // com.tencent.mobileqq.guild.base.recyclerview.adapter.e
    protected int r0(int position) {
        return g1(getData(), position);
    }

    public /* synthetic */ BaseProviderMultiAdapter(List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : list);
    }

    public BaseProviderMultiAdapter(@Nullable List<T> list) {
        super(0, list);
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<SparseArray<BaseItemProvider<T>>>() { // from class: com.tencent.mobileqq.guild.base.recyclerview.adapter.BaseProviderMultiAdapter$mItemProviders$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final SparseArray<BaseItemProvider<T>> invoke() {
                return new SparseArray<>();
            }
        });
        this.mItemProviders = lazy;
    }
}
