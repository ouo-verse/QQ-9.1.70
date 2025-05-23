package com.tencent.mobileqq.zplan.minihome;

import androidx.recyclerview.widget.DiffUtil;
import com.tencent.mobileqq.zplan.minihome.data.ServerFurnitureDesc;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/zplan/minihome/u;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Ln55/a;", "oldItem", "newItem", "", "b", "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class u extends DiffUtil.ItemCallback<n55.a> {
    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean areContentsTheSame(n55.a oldItem, n55.a newItem) {
        ServerFurnitureDesc a16;
        Intrinsics.checkNotNullParameter(oldItem, "oldItem");
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        ServerFurnitureDesc.Companion companion = ServerFurnitureDesc.INSTANCE;
        ServerFurnitureDesc a17 = companion.a(oldItem.f418399h);
        return a17 != null && (a16 = companion.a(newItem.f418399h)) != null && a17.getId() == a16.getId() && a17.getSubState() == a16.getSubState();
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean areItemsTheSame(n55.a oldItem, n55.a newItem) {
        ServerFurnitureDesc a16;
        Intrinsics.checkNotNullParameter(oldItem, "oldItem");
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        ServerFurnitureDesc.Companion companion = ServerFurnitureDesc.INSTANCE;
        ServerFurnitureDesc a17 = companion.a(oldItem.f418399h);
        return a17 != null && (a16 = companion.a(newItem.f418399h)) != null && a17.getId() == a16.getId() && a17.getSubState() == a16.getSubState();
    }
}
