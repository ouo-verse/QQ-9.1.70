package com.tencent.mobileqq.guild.home.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/home/views/SmartRefreshLayout;", "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", "", "onFinishInflate", "", "direction", "", "canScrollVertically", "Landroidx/recyclerview/widget/RecyclerView;", "d", "Landroidx/recyclerview/widget/RecyclerView;", "refreshContent", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class SmartRefreshLayout extends com.tencent.richframework.widget.refresh.layout.SmartRefreshLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private RecyclerView refreshContent;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmartRefreshLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.view.View
    public boolean canScrollVertically(int direction) {
        RecyclerView recyclerView = this.refreshContent;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshContent");
            recyclerView = null;
        }
        return recyclerView.canScrollVertically(direction);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.richframework.widget.refresh.layout.SmartRefreshLayout, android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        View view = this.mRefreshContent.getView();
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        this.refreshContent = (RecyclerView) view;
    }
}
