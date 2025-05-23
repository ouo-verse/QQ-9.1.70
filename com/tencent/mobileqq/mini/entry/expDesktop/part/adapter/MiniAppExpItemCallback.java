package com.tencent.mobileqq.mini.entry.expDesktop.part.adapter;

import androidx.recyclerview.widget.DiffUtil;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/part/adapter/MiniAppExpItemCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopItemInfo;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "getChangePayload", "", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppExpItemCallback extends DiffUtil.ItemCallback<DesktopItemInfo> {
    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public boolean areContentsTheSame(DesktopItemInfo oldItem, DesktopItemInfo newItem) {
        Intrinsics.checkNotNullParameter(oldItem, "oldItem");
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        Boolean areContentsTheSame = oldItem.areContentsTheSame(newItem);
        Intrinsics.checkNotNullExpressionValue(areContentsTheSame, "oldItem.areContentsTheSame(newItem)");
        return areContentsTheSame.booleanValue();
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public boolean areItemsTheSame(DesktopItemInfo oldItem, DesktopItemInfo newItem) {
        Intrinsics.checkNotNullParameter(oldItem, "oldItem");
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        Boolean areItemsTheSame = oldItem.areItemsTheSame(newItem);
        Intrinsics.checkNotNullExpressionValue(areItemsTheSame, "oldItem.areItemsTheSame(newItem)");
        return areItemsTheSame.booleanValue();
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public Object getChangePayload(DesktopItemInfo oldItem, DesktopItemInfo newItem) {
        Intrinsics.checkNotNullParameter(oldItem, "oldItem");
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return oldItem.getChangePayload(newItem);
    }
}
