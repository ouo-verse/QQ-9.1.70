package com.tencent.qqnt.chathistory.ui.base;

import com.tencent.qqnt.chathistory.util.ExtensionsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a \u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/expandRecyclerView/adapter/provider/b;", "Lkotlin/Function1;", "Lcom/tencent/qqnt/expandRecyclerView/adapter/node/b;", "", "predicate", "", "a", "chathistory_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class q {
    public static final void a(@NotNull com.tencent.qqnt.expandRecyclerView.adapter.provider.b bVar, @NotNull Function1<? super com.tencent.qqnt.expandRecyclerView.adapter.node.b, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i3 = 0;
        for (Object obj : bVar.m0()) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            com.tencent.qqnt.expandRecyclerView.adapter.node.b bVar2 = (com.tencent.qqnt.expandRecyclerView.adapter.node.b) obj;
            if (bVar2 instanceof TailDefaultItemModel) {
                ((TailDefaultItemModel) bVar2).g(ExtensionsKt.z(bVar, predicate));
                bVar.notifyItemChanged(i3);
                return;
            }
            i3 = i16;
        }
    }
}
