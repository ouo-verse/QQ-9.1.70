package com.tencent.mobileqq.widget.gridpage;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.widget.gridpage.c;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B-\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u001f\u0010\t\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0011R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/widget/gridpage/a;", "Lcom/tencent/mobileqq/widget/gridpage/c;", "T", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "", "getItemCount", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "j0", "(Landroid/view/ViewGroup;I)Lcom/tencent/mobileqq/widget/gridpage/c;", "holder", "position", "", "i0", "(Lcom/tencent/mobileqq/widget/gridpage/c;I)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "pageItemCount", BdhLogUtil.LogTag.Tag_Conn, "pageIndex", "D", "itemCount", "Lcom/tencent/mobileqq/widget/gridpage/b;", "E", "Lcom/tencent/mobileqq/widget/gridpage/b;", "itemAdapter", "<init>", "(IIILcom/tencent/mobileqq/widget/gridpage/b;)V", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class a<T extends c> extends RecyclerView.Adapter<T> {

    /* renamed from: C, reason: from kotlin metadata */
    private final int pageIndex;

    /* renamed from: D, reason: from kotlin metadata */
    private final int itemCount;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final b<T> itemAdapter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final int pageItemCount;

    public a(int i3, int i16, int i17, @NotNull b<T> itemAdapter) {
        Intrinsics.checkNotNullParameter(itemAdapter, "itemAdapter");
        this.pageItemCount = i3;
        this.pageIndex = i16;
        this.itemCount = i17;
        this.itemAdapter = itemAdapter;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.itemCount;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull T holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        this.itemAdapter.f(holder, (this.pageIndex * this.pageItemCount) + position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public T onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return this.itemAdapter.g(parent, viewType);
    }
}
