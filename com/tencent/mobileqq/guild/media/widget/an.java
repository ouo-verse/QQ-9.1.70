package com.tencent.mobileqq.guild.media.widget;

import androidx.recyclerview.widget.DiffUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/an;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/tencent/mobileqq/guild/media/widget/be;", "oldItem", "newItem", "", "b", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class an extends DiffUtil.ItemCallback<RaiseHandData> {
    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean areContentsTheSame(@NotNull RaiseHandData oldItem, @NotNull RaiseHandData newItem) {
        Intrinsics.checkNotNullParameter(oldItem, "oldItem");
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return Intrinsics.areEqual(oldItem, newItem);
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean areItemsTheSame(@NotNull RaiseHandData oldItem, @NotNull RaiseHandData newItem) {
        Intrinsics.checkNotNullParameter(oldItem, "oldItem");
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if (Intrinsics.areEqual(oldItem.getTinyId(), newItem.getTinyId()) && Intrinsics.areEqual(oldItem.getAvatarMeta(), newItem.getAvatarMeta()) && Intrinsics.areEqual(oldItem.getNickName(), newItem.getNickName())) {
            return true;
        }
        return false;
    }
}
