package com.tencent.mobileqq.guild.discoveryv2.content.recommend.delegate.feedlist;

import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.guild.api.FeedListDelegateSectionFactory;
import com.tencent.mobileqq.guild.api.FeedListDelegateType;
import com.tencent.mobileqq.guild.api.IGuildFeedLayoutApi;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000\"\u001b\u0010\b\u001a\u00020\u00038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007*0\b\u0000\u0010\f\"\u0014\u0012\u0010\b\u0001\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\n0\t2\u0014\u0012\u0010\b\u0001\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\n0\t\u00a8\u0006\r"}, d2 = {"", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/delegate/feedlist/RecommendFeedDelegate;", "b", "Lcom/tencent/mobileqq/guild/api/FeedListDelegateSectionFactory;", "a", "Lkotlin/Lazy;", "c", "()Lcom/tencent/mobileqq/guild/api/FeedListDelegateSectionFactory;", "recommendLayoutFactory", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/l;", "RecommendFeedSectionClass", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class RecommendFeedDelegateKt {

    /* renamed from: a */
    @NotNull
    private static final Lazy f217157a;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<FeedListDelegateSectionFactory>() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.recommend.delegate.feedlist.RecommendFeedDelegateKt$recommendLayoutFactory$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FeedListDelegateSectionFactory invoke() {
                return ((IGuildFeedLayoutApi) QRoute.api(IGuildFeedLayoutApi.class)).getRecommendFeedFactory();
            }
        });
        f217157a = lazy;
    }

    public static final /* synthetic */ FeedListDelegateSectionFactory a() {
        return c();
    }

    @NotNull
    public static final List<RecommendFeedDelegate> b() {
        return c().f(new Function2<FeedListDelegateType, List<? extends Class<? extends Section<?>>>, RecommendFeedDelegate>() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.recommend.delegate.feedlist.RecommendFeedDelegateKt$generateRecommendFeedDelegates$1
            @Override // kotlin.jvm.functions.Function2
            @NotNull
            public final RecommendFeedDelegate invoke(@NotNull FeedListDelegateType type, @NotNull List<? extends Class<? extends Section<?>>> list) {
                Intrinsics.checkNotNullParameter(type, "type");
                Intrinsics.checkNotNullParameter(list, "list");
                return new RecommendFeedDelegate(type, list);
            }
        });
    }

    public static final FeedListDelegateSectionFactory c() {
        return (FeedListDelegateSectionFactory) f217157a.getValue();
    }
}
