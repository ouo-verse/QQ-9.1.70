package com.tencent.mobileqq.search.searchdetail.content.base;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate;
import com.tencent.biz.richframework.part.adapter.section.SectionViewHolder;
import com.tencent.mobileqq.search.searchdetail.c;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00010\u0003B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0014\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0014R$\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/base/a;", "Lcom/tencent/mobileqq/search/searchdetail/c;", "I", "Lcom/tencent/biz/richframework/part/adapter/delegate/AbsItemAdapterDelegate;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Lcom/tencent/biz/richframework/part/adapter/section/SectionViewHolder;", "onCreateViewHolder", "Landroid/view/View;", "d", "Landroid/view/View;", "getMItemView", "()Landroid/view/View;", "setMItemView", "(Landroid/view/View;)V", "mItemView", "e", "Landroid/view/ViewGroup;", "mParentView", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public abstract class a<I extends com.tencent.mobileqq.search.searchdetail.c> extends AbsItemAdapterDelegate<I, com.tencent.mobileqq.search.searchdetail.c> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mItemView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup mParentView;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegate
    @NotNull
    public SectionViewHolder<?> onCreateViewHolder(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        SectionViewHolder<?> onCreateViewHolder = super.onCreateViewHolder(parent);
        Intrinsics.checkNotNullExpressionValue(onCreateViewHolder, "super.onCreateViewHolder(parent)");
        this.mItemView = onCreateViewHolder.itemView;
        this.mParentView = parent;
        return onCreateViewHolder;
    }
}
