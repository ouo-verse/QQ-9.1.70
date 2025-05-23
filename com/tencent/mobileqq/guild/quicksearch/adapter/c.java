package com.tencent.mobileqq.guild.quicksearch.adapter;

import com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/adapter/c;", "Lcom/tencent/biz/richframework/part/adapter/AsyncListDifferDelegationAdapter;", "Lzg1/a;", "", "position", "", "getItemId", "Lcom/tencent/mobileqq/guild/quicksearch/adapter/g;", "diffCallback", "Lcom/tencent/mobileqq/guild/quicksearch/adapter/a;", "delegatesManager", "<init>", "(Lcom/tencent/mobileqq/guild/quicksearch/adapter/g;Lcom/tencent/mobileqq/guild/quicksearch/adapter/a;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class c extends AsyncListDifferDelegationAdapter<zg1.a> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull g diffCallback, @NotNull a delegatesManager) {
        super(diffCallback, delegatesManager);
        Intrinsics.checkNotNullParameter(diffCallback, "diffCallback");
        Intrinsics.checkNotNullParameter(delegatesManager, "delegatesManager");
    }

    @Override // com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        return getItems().get(position).getItemId();
    }
}
