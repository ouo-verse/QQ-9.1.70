package com.tencent.mobileqq.search.searchdetail.content.base;

import com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegatesManager;
import com.tencent.mobileqq.search.searchdetail.banner.i;
import com.tencent.mobileqq.search.searchdetail.banner.k;
import com.tencent.mobileqq.search.searchdetail.banner.l;
import com.tencent.mobileqq.search.searchdetail.content.template.ab;
import com.tencent.mobileqq.search.searchdetail.content.template.j;
import com.tencent.mobileqq.search.searchdetail.content.template.s;
import com.tencent.mobileqq.search.searchdetail.content.template.v;
import com.tencent.mobileqq.search.searchdetail.content.template.x;
import com.tencent.mobileqq.search.searchdetail.content.template.z;
import com.tencent.mobileqq.search.searchdetail.multimedia.u;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/base/f;", "Lcom/tencent/biz/richframework/part/adapter/delegate/AdapterDelegatesManager;", "", "Lcom/tencent/mobileqq/search/searchdetail/c;", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class f extends AdapterDelegatesManager<List<? extends com.tencent.mobileqq.search.searchdetail.c>> {
    public f() {
        addDelegate(new u());
        addDelegate(new l());
        addDelegate(new k());
        addDelegate(new i());
        addDelegate(new s());
        addDelegate(new ab());
        addDelegate(new com.tencent.mobileqq.search.searchdetail.content.template.h());
        addDelegate(new com.tencent.mobileqq.search.searchdetail.function.c());
        addDelegate(new com.tencent.mobileqq.search.searchdetail.expression.c());
        addDelegate(new z());
        addDelegate(new com.tencent.mobileqq.search.searchdetail.content.template.playlet.a());
        addDelegate(new lp2.a());
        addDelegate(new lp2.d());
        addDelegate(new com.tencent.mobileqq.search.searchdetail.content.template.k());
        setFallbackDelegate(new j());
        addDelegate(new com.tencent.mobileqq.search.searchdetail.content.template.l());
        addDelegate(new com.tencent.mobileqq.search.searchdetail.content.template.e());
        addDelegate(new v());
        addDelegate(new com.tencent.mobileqq.search.searchdetail.content.template.ai.a());
        addDelegate(new x());
        addDelegate(new com.tencent.mobileqq.search.tux.c());
        addDelegate(new com.tencent.mobileqq.search.searchdetail.content.wxminapp.a());
    }
}
