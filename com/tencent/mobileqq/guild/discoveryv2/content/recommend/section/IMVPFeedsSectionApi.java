package com.tencent.mobileqq.guild.discoveryv2.content.recommend.section;

import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendVideoMixData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 \u00062\u00020\u0001:\u0001\u0007J\u0018\u0010\u0005\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0000\u0012\u00020\u00040\u00030\u0002H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/IMVPFeedsSectionApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/RecommendVideoMixData;", "getVideoMixSectionClz", "Companion", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes13.dex */
public interface IMVPFeedsSectionApi extends QRouteApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f217166a;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0003\u001a\u00020\u0002H\u0086\u0002\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/IMVPFeedsSectionApi$a;", "", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/IMVPFeedsSectionApi;", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.IMVPFeedsSectionApi$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f217166a = new Companion();

        Companion() {
        }

        @NotNull
        public final IMVPFeedsSectionApi a() {
            QRouteApi api = QRoute.api(IMVPFeedsSectionApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IMVPFeedsSectionApi::class.java)");
            return (IMVPFeedsSectionApi) api;
        }
    }

    @NotNull
    Class<? extends Section<? super RecommendVideoMixData>> getVideoMixSectionClz();
}
