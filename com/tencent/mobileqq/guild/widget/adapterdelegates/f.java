package com.tencent.mobileqq.guild.widget.adapterdelegates;

import androidx.recyclerview.widget.DiffUtil;
import com.tencent.mobileqq.guild.widget.adapterdelegates.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000*\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\t\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\t\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/adapterdelegates/f;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/e;", "T", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "oldItem", "newItem", "", "b", "(Lcom/tencent/mobileqq/guild/widget/adapterdelegates/e;Lcom/tencent/mobileqq/guild/widget/adapterdelegates/e;)Z", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class f<T extends e<T>> extends DiffUtil.ItemCallback<T> {
    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean areContentsTheSame(@NotNull T oldItem, @NotNull T newItem) {
        Intrinsics.checkNotNullParameter(oldItem, "oldItem");
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return oldItem.areContentsTheSame(newItem);
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean areItemsTheSame(@NotNull T oldItem, @NotNull T newItem) {
        Intrinsics.checkNotNullParameter(oldItem, "oldItem");
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return oldItem.areItemsTheSame(newItem);
    }
}
