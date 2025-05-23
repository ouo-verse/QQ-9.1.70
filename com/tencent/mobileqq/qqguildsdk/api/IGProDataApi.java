package com.tencent.mobileqq.qqguildsdk.api;

import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetContentRecommendRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetMyTabContentRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetRecommendTabContentRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationTab;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendContentItem;
import com.tencent.mobileqq.qqguildsdk.data.p;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProContentRecommendFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProSysPromptDigest;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH&J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\bH&J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\bH&J\u0016\u0010\u0013\u001a\u00020\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H&J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\t\u001a\u00020\bH&J\u0016\u0010\u0017\u001a\u00020\b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0010H&J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u00102\u0006\u0010\t\u001a\u00020\bH&J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\bH&J\u0010\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001bH&\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/api/IGProDataApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "itemType", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProContentRecommendFeed;", "feed", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRecommendContentItem;", "newGProRecommendContentItem", "", "byteArray", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGetContentRecommendRsp;", "fastDecodeMVPFeedsRspPb", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGetRecommendTabContentRsp;", "decodeGProGetRecommendTabContentRsp", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGetMyTabContentRsp;", "decodeGProGetMyTabContentRsp", "", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guilds", "encodeGProGuilds", "decodeGProGuilds", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProNavigationTab;", "list", "encodeGProNavigationTabs", "decodeGProNavigationTabs", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProSysPromptDigest;", "decodeGProSysPromptDigest", "Lcom/tencent/mobileqq/qqguildsdk/data/p;", "attaData", "encodeShareAttaData", "Companion", "a", "qqguild-sdk-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes17.dex */
public interface IGProDataApi extends QRouteApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f265054a;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/api/IGProDataApi$a;", "", "Lcom/tencent/mobileqq/qqguildsdk/api/IGProDataApi;", "b", "Lcom/tencent/mobileqq/qqguildsdk/api/IGProDataApi;", "a", "()Lcom/tencent/mobileqq/qqguildsdk/api/IGProDataApi;", "g", "<init>", "()V", "qqguild-sdk-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqguildsdk.api.IGProDataApi$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f265054a = new Companion();

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private static final IGProDataApi g;

        static {
            QRouteApi api = QRoute.api(IGProDataApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IGProDataApi::class.java)");
            g = (IGProDataApi) api;
        }

        Companion() {
        }

        @NotNull
        public final IGProDataApi a() {
            return g;
        }
    }

    @NotNull
    IGProGetMyTabContentRsp decodeGProGetMyTabContentRsp(@NotNull byte[] byteArray);

    @NotNull
    IGProGetRecommendTabContentRsp decodeGProGetRecommendTabContentRsp(@NotNull byte[] byteArray);

    @NotNull
    List<IGProGuildInfo> decodeGProGuilds(@NotNull byte[] byteArray);

    @NotNull
    List<IGProNavigationTab> decodeGProNavigationTabs(@NotNull byte[] byteArray);

    @NotNull
    GProSysPromptDigest decodeGProSysPromptDigest(@NotNull byte[] byteArray);

    @NotNull
    byte[] encodeGProGuilds(@NotNull List<? extends IGProGuildInfo> guilds);

    @NotNull
    byte[] encodeGProNavigationTabs(@NotNull List<? extends IGProNavigationTab> list);

    @NotNull
    byte[] encodeShareAttaData(@NotNull p attaData);

    @NotNull
    IGProGetContentRecommendRsp fastDecodeMVPFeedsRspPb(@NotNull byte[] byteArray);

    @NotNull
    IGProRecommendContentItem newGProRecommendContentItem(int itemType, @NotNull GProContentRecommendFeed feed);
}
