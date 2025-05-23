package com.tencent.mobileqq.guild.quicksearch.adapter;

import com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegatesManager;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedSearchApi;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/adapter/a;", "Lcom/tencent/biz/richframework/part/adapter/delegate/AdapterDelegatesManager;", "", "Lzg1/a;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a extends AdapterDelegatesManager<List<? extends zg1.a>> {
    public a() {
        Iterator<T> it = ((IGuildFeedSearchApi) QRoute.api(IGuildFeedSearchApi.class)).getFeedSearchListAdapterDelegates().iterator();
        while (it.hasNext()) {
            zg1.c cVar = (zg1.c) it.next();
            addDelegate(cVar.getType(), cVar);
        }
        addDelegate(zg1.a.INSTANCE.b(), new b());
    }
}
