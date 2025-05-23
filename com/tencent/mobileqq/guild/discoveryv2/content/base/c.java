package com.tencent.mobileqq.guild.discoveryv2.content.base;

import com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegatesManager;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.delegate.MyTabEmptyDelegate;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.delegate.aa;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.delegate.feedlist.RecommendFeedDelegate;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.delegate.feedlist.RecommendFeedDelegateKt;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.delegate.m;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.delegate.n;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.delegate.o;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.delegate.p;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.delegate.q;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.delegate.r;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.delegate.s;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.delegate.t;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.delegate.u;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.delegate.v;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.delegate.w;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.delegate.x;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.delegate.y;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.delegate.z;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/base/c;", "Lcom/tencent/biz/richframework/part/adapter/delegate/AdapterDelegatesManager;", "", "Lcom/tencent/mobileqq/guild/discoveryv2/content/base/h;", "", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class c extends AdapterDelegatesManager<List<? extends h>> {
    public c() {
        addDelegate(new u());
        addDelegate(new vh1.e());
        addDelegate(new sh1.a());
        addDelegate(new com.tencent.mobileqq.guild.discoveryv2.content.recommend.delegate.i());
        addDelegate(new aa());
        addDelegate(new p());
        addDelegate(new x());
        addDelegate(new w());
        addDelegate(new v());
        addDelegate(new r());
        addDelegate(new com.tencent.mobileqq.guild.discoveryv2.content.recommend.delegate.k());
        addDelegate(new com.tencent.mobileqq.guild.discoveryv2.content.recommend.delegate.l());
        addDelegate(new n());
        addDelegate(new m());
        addDelegate(new o());
        addDelegate(new com.tencent.mobileqq.guild.discoveryv2.content.recommend.delegate.h());
        addDelegate(new q());
        addDelegate(new y());
        addDelegate(new t());
        addDelegate(new s());
        addDelegate(new com.tencent.mobileqq.guild.discoveryv2.content.recommend.delegate.j());
        addDelegate(new xh1.c());
        addDelegate(new com.tencent.mobileqq.guild.discoveryv2.content.recommend.delegate.f());
        addDelegate(new MyTabEmptyDelegate());
        addDelegate(new com.tencent.mobileqq.guild.discoveryv2.content.recommend.delegate.e());
        addDelegate(new z());
        addDelegate(new com.tencent.mobileqq.guild.discoveryv2.content.recommend.delegate.a());
        setFallbackDelegate(com.tencent.mobileqq.guild.discoveryv2.content.recommend.delegate.b.a());
        a();
    }

    private final void a() {
        Iterator<T> it = RecommendFeedDelegateKt.b().iterator();
        while (it.hasNext()) {
            addDelegate((RecommendFeedDelegate) it.next());
        }
    }
}
