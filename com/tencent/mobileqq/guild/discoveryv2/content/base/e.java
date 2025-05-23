package com.tencent.mobileqq.guild.discoveryv2.content.base;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter;
import com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegatesManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0012\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\f0\u001b\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0018\u0010\u000e\u001a\u00020\u00052\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\fH\u0016J\"\u0010\u000e\u001a\u00020\u00052\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0016R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/base/e;", "Lcom/tencent/biz/richframework/part/adapter/AsyncListDifferDelegationAdapter;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/base/h;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "onAttachedToRecyclerView", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "onViewAttachedToWindow", "onViewDetachedFromWindow", "onDetachedFromRecyclerView", "", "items", "setItems", "Ljava/lang/Runnable;", "callback", "", "position", "", "getItemId", "Lcom/tencent/mobileqq/guild/discoveryv2/content/base/g;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/discoveryv2/content/base/g;", "scrollDispatcher", "Lcom/tencent/mobileqq/guild/discoveryv2/content/base/d;", "diffCallback", "Lcom/tencent/biz/richframework/part/adapter/delegate/AdapterDelegatesManager;", "delegatesManager", "<init>", "(Lcom/tencent/mobileqq/guild/discoveryv2/content/base/d;Lcom/tencent/biz/richframework/part/adapter/delegate/AdapterDelegatesManager;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class e extends AsyncListDifferDelegationAdapter<h> {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final g scrollDispatcher;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@NotNull d diffCallback, @NotNull AdapterDelegatesManager<List<h>> delegatesManager) {
        super(diffCallback, delegatesManager);
        Intrinsics.checkNotNullParameter(diffCallback, "diffCallback");
        Intrinsics.checkNotNullParameter(delegatesManager, "delegatesManager");
        this.scrollDispatcher = new g(this);
    }

    @Override // com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        return getItems().get(position).getItemId();
    }

    @Override // com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter, com.tencent.biz.richframework.part.adapter.VisibleNotifyAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        this.scrollDispatcher.b(recyclerView);
    }

    @Override // com.tencent.biz.richframework.part.adapter.VisibleNotifyAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onDetachedFromRecyclerView(recyclerView);
        this.scrollDispatcher.c(recyclerView);
    }

    @Override // com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter, com.tencent.biz.richframework.part.adapter.VisibleNotifyAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewAttachedToWindow(holder);
        this.scrollDispatcher.d(holder);
    }

    @Override // com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter, com.tencent.biz.richframework.part.adapter.VisibleNotifyAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewDetachedFromWindow(holder);
        this.scrollDispatcher.e(holder);
    }

    @Override // com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter
    public void setItems(@Nullable List<h> items) {
        super.setItems(items);
        this.scrollDispatcher.h(items);
    }

    @Override // com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter
    public void setItems(@Nullable List<h> items, @Nullable Runnable callback) {
        super.setItems(items, callback);
        this.scrollDispatcher.h(items);
    }
}
