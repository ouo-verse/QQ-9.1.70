package hl1;

import com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegatesManager;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.FeedMainDelegate;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.LongFeedMainDelegate;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lhl1/h;", "Lcom/tencent/biz/richframework/part/adapter/delegate/AdapterDelegatesManager;", "", "Lhl1/g;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class h extends AdapterDelegatesManager<List<? extends g>> {
    public h() {
        addDelegate(1, new FeedMainDelegate());
        addDelegate(2, new com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.h());
        addDelegate(3, new com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.g());
        addDelegate(12, new LongFeedMainDelegate());
        addDelegate(5, new kl1.c());
        addDelegate(6, new kl1.a());
        addDelegate(7, new kl1.g());
        addDelegate(4, new kl1.b());
        addDelegate(10, new com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.e());
    }
}
