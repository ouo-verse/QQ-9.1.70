package com.tencent.mobileqq.search.searchdetail.filter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.search.searchdetail.filter.i;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import hp2.x;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001&B/\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0018\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000b0\u0012\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u001c\u0010\b\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0016J\u001c\u0010\f\u001a\u00020\u000b2\n\u0010\t\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\n\u001a\u00020\u0003H\u0016R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R&\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000b0\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\"\u0010\u001c\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR6\u0010#\u001a\u0016\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/filter/i;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/search/searchdetail/filter/i$a;", "", "getItemCount", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "m0", "holder", "position", "", "l0", "", "Lcom/tencent/mobileqq/search/searchdetail/filter/e;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "items", "Lkotlin/Function2;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/jvm/functions/Function2;", "onItemClick", "D", "I", "k0", "()I", "o0", "(I)V", "selectedPosition", "Landroid/view/View;", "E", "getOnPickerItemCreatedCallback", "()Lkotlin/jvm/functions/Function2;", "n0", "(Lkotlin/jvm/functions/Function2;)V", "onPickerItemCreatedCallback", "<init>", "(Ljava/util/List;Lkotlin/jvm/functions/Function2;)V", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class i extends RecyclerView.Adapter<a> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Function2<Integer, RuleFilter, Unit> onItemClick;

    /* renamed from: D, reason: from kotlin metadata */
    private int selectedPosition;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private Function2<? super View, ? super RuleFilter, Unit> onPickerItemCreatedCallback;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<RuleFilter> items;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/filter/i$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lhp2/x;", "E", "Lhp2/x;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lhp2/x;", "binding", "Landroid/view/View;", "itemView", "<init>", "(Lcom/tencent/mobileqq/search/searchdetail/filter/i;Landroid/view/View;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public final class a extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final x binding;
        final /* synthetic */ i F;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull final i iVar, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.F = iVar;
            x e16 = x.e(itemView);
            Intrinsics.checkNotNullExpressionValue(e16, "bind(itemView)");
            itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.searchdetail.filter.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    i.a.n(i.this, this, view);
                }
            });
            this.binding = e16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void n(i this$0, a this$1, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            int selectedPosition = this$0.getSelectedPosition();
            this$0.o0(this$1.getAdapterPosition());
            this$0.notifyItemChanged(selectedPosition);
            this$0.notifyItemChanged(this$0.getSelectedPosition());
            this$0.onItemClick.invoke(Integer.valueOf(this$1.getAdapterPosition()), this$0.items.get(this$1.getAdapterPosition()));
            EventCollector.getInstance().onViewClicked(view);
        }

        @NotNull
        /* renamed from: m, reason: from getter */
        public final x getBinding() {
            return this.binding;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i(@NotNull List<RuleFilter> items, @NotNull Function2<? super Integer, ? super RuleFilter, Unit> onItemClick) {
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(onItemClick, "onItemClick");
        this.items = items;
        this.onItemClick = onItemClick;
        this.selectedPosition = -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    /* renamed from: k0, reason: from getter */
    public final int getSelectedPosition() {
        return this.selectedPosition;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull a holder, int position) {
        boolean z16;
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (position == this.selectedPosition) {
            z16 = true;
        } else {
            z16 = false;
        }
        ImageView imageView = holder.getBinding().f405785b;
        Boolean valueOf = Boolean.valueOf(z16);
        imageView.setVisibility(0);
        if (((View) com.tencent.guild.aio.util.ex.g.a(valueOf, imageView)) == null) {
            imageView.setVisibility(8);
        }
        RuleFilter ruleFilter = this.items.get(position);
        holder.getBinding().f405786c.setText(this.items.get(position).getName());
        Function2<? super View, ? super RuleFilter, Unit> function2 = this.onPickerItemCreatedCallback;
        if (function2 != null) {
            View itemView = holder.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            function2.invoke(itemView, ruleFilter);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.h2p, parent, false);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return new a(this, view);
    }

    public final void n0(@Nullable Function2<? super View, ? super RuleFilter, Unit> function2) {
        this.onPickerItemCreatedCallback = function2;
    }

    public final void o0(int i3) {
        this.selectedPosition = i3;
    }
}
