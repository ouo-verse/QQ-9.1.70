package com.tencent.mobileqq.search.business.contact.part;

import com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegatesManager;
import com.tencent.mobileqq.search.business.contact.entity.UIType;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/search/business/contact/part/h;", "Lcom/tencent/biz/richframework/part/adapter/delegate/AdapterDelegatesManager;", "", "Lcom/tencent/mobileqq/search/business/contact/entity/UIType;", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class h extends AdapterDelegatesManager<List<? extends UIType>> {
    public h() {
        addDelegate(new BuddyContactsSearchDelegate());
        addDelegate(new TitleContactsSearchDelegate());
        addDelegate(new TroopContactsSearchDelegate());
        addDelegate(new o());
        addDelegate(new p());
    }
}
