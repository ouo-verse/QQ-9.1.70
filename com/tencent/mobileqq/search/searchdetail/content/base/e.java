package com.tencent.mobileqq.search.searchdetail.content.base;

import com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/base/e;", "Lcom/tencent/biz/richframework/part/adapter/AsyncListDifferDelegationAdapter;", "Lcom/tencent/mobileqq/search/searchdetail/c;", "", "position", "", "getItemId", "Lcom/tencent/mobileqq/search/searchdetail/content/base/d;", "diffCallback", "Lcom/tencent/mobileqq/search/searchdetail/content/base/f;", "delegatesManager", "<init>", "(Lcom/tencent/mobileqq/search/searchdetail/content/base/d;Lcom/tencent/mobileqq/search/searchdetail/content/base/f;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class e extends AsyncListDifferDelegationAdapter<com.tencent.mobileqq.search.searchdetail.c> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@NotNull d diffCallback, @NotNull f delegatesManager) {
        super(diffCallback, delegatesManager);
        Intrinsics.checkNotNullParameter(diffCallback, "diffCallback");
        Intrinsics.checkNotNullParameter(delegatesManager, "delegatesManager");
    }

    @Override // com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        return getItems().get(position).getItemId().hashCode();
    }
}
