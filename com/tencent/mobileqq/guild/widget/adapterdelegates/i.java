package com.tencent.mobileqq.guild.widget.adapterdelegates;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.AdapterListUpdateCallback;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.s;
import com.tencent.mobileqq.guild.widget.adapterdelegates.d;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 ;*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001<B)\u0012\u0006\u00105\u001a\u000204\u0012\b\b\u0002\u00106\u001a\u00020\u0014\u0012\u000e\b\u0002\u00108\u001a\b\u0012\u0004\u0012\u00028\u000007\u00a2\u0006\u0004\b9\u0010:J\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\tH\u0016J(\u0010\u000f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\t2\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010H\u0016J\b\u0010\u0013\u001a\u00020\tH\u0016J\u0012\u0010\u0016\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0019\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u001a\u001a\u00020\tH\u0016J\u0010\u0010\u001b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000bH\u0016J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\r\u001a\u00020\u000bH\u0016J\u0010\u0010\u001f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000bH\u0016J\u0010\u0010 \u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000bH\u0016J\u0010\u0010#\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020!H\u0016J\u0010\u0010$\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020!H\u0016R\u001c\u0010)\u001a\n &*\u0004\u0018\u00010%0%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R&\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030*8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0014\u00103\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/guild/widget/adapterdelegates/i;", "T", "Lcom/tencent/biz/richframework/part/block/MultiViewBlock;", "", "items", "", "setItems", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onCreateViewHolder", "holder", "position", "onBindViewHolder", "", "", "payloads", "getItemCount", "Landroid/os/Bundle;", "initParams", "onInitBlock", "Lcom/tencent/biz/richframework/part/block/base/LoadInfo;", "loadInfo", "loadData", "getViewTypeCount", "getItemViewType", "onViewRecycled", "", "onFailedToRecycleView", "onViewAttachedToWindow", "onViewDetachedFromWindow", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "onAttachedToRecyclerView", "onDetachedFromRecyclerView", "", "kotlin.jvm.PlatformType", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "canonicalName", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/h;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/h;", "i0", "()Lcom/tencent/mobileqq/guild/widget/adapterdelegates/h;", "delegatesManager", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/ViewHolderVisibleAwareNotifier;", "D", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/ViewHolderVisibleAwareNotifier;", "viewHolderVisibleAwareNotifier", "Landroidx/lifecycle/LifecycleOwner;", "viewLifecycleOwner", "bundle", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "diffCallback", "<init>", "(Landroidx/lifecycle/LifecycleOwner;Landroid/os/Bundle;Landroidx/recyclerview/widget/DiffUtil$ItemCallback;)V", "E", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public abstract class i<T> extends MultiViewBlock<T> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final h<List<T>> delegatesManager;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final ViewHolderVisibleAwareNotifier viewHolderVisibleAwareNotifier;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final String canonicalName;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(@NotNull LifecycleOwner viewLifecycleOwner, @NotNull Bundle bundle, @NotNull DiffUtil.ItemCallback<T> diffCallback) {
        super(bundle);
        Intrinsics.checkNotNullParameter(viewLifecycleOwner, "viewLifecycleOwner");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(diffCallback, "diffCallback");
        this.canonicalName = getClass().getCanonicalName();
        this.delegatesManager = new h<>();
        ViewHolderVisibleAwareNotifier viewHolderVisibleAwareNotifier = new ViewHolderVisibleAwareNotifier();
        this.viewHolderVisibleAwareNotifier = viewHolderVisibleAwareNotifier;
        this.mDiffer = new AsyncListDiffer<>(new AdapterListUpdateCallback(this), new AsyncDifferConfig.Builder(diffCallback).setBackgroundThreadExecutor(new d.c()).build());
        ViewHolderVisibleAwareNotifier.c(viewHolderVisibleAwareNotifier, viewLifecycleOwner, null, 2, null);
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.mDiffer.getCurrentList().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        int coerceIn;
        int f16 = this.delegatesManager.f(this.mDiffer.getCurrentList(), position);
        coerceIn = RangesKt___RangesKt.coerceIn(f16, 0, getViewTypeCount() - 1);
        if (f16 != 2147483646 && coerceIn != f16) {
            s.e("Guild.comm.BlockDelegationAdapter", "getItemViewType: " + f16 + " -> " + coerceIn, new IllegalStateException());
        }
        return coerceIn;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public int getViewTypeCount() {
        return this.delegatesManager.h() + 10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final h<List<T>> i0() {
        return this.delegatesManager;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(@Nullable LoadInfo loadInfo) {
        Logger.f235387a.d().d("Guild.comm.BlockDelegationAdapter", 1, "loadData: " + loadInfo);
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        this.delegatesManager.i(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        this.delegatesManager.j(this.mDiffer.getCurrentList(), position, holder, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return this.delegatesManager.l(parent, viewType);
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onDetachedFromRecyclerView(recyclerView);
        this.delegatesManager.m(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public boolean onFailedToRecycleView(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        return this.delegatesManager.n(holder);
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(@Nullable Bundle initParams) {
        Logger.f235387a.d().d("Guild.comm.BlockDelegationAdapter", 1, "onInitBlock");
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        this.viewHolderVisibleAwareNotifier.d(holder);
        this.delegatesManager.o(holder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        this.viewHolderVisibleAwareNotifier.e(holder);
        this.delegatesManager.p(holder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        this.delegatesManager.q(holder);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setItems(@NotNull List<? extends T> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        submitList(items);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        this.delegatesManager.j(this.mDiffer.getCurrentList(), position, holder, payloads);
    }
}
