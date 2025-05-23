package com.tencent.mobileqq.search.business.contact.part;

import com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter;
import com.tencent.mobileqq.search.business.contact.entity.UIType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/search/business/contact/part/b;", "Lcom/tencent/biz/richframework/part/adapter/AsyncListDifferDelegationAdapter;", "Lcom/tencent/mobileqq/search/business/contact/entity/UIType;", "Lcom/tencent/mobileqq/search/business/contact/part/d;", "diffCallback", "Lcom/tencent/mobileqq/search/business/contact/part/h;", "delegatesManager", "<init>", "(Lcom/tencent/mobileqq/search/business/contact/part/d;Lcom/tencent/mobileqq/search/business/contact/part/h;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class b extends AsyncListDifferDelegationAdapter<UIType> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull d diffCallback, @NotNull h delegatesManager) {
        super(diffCallback, delegatesManager);
        Intrinsics.checkNotNullParameter(diffCallback, "diffCallback");
        Intrinsics.checkNotNullParameter(delegatesManager, "delegatesManager");
    }
}
