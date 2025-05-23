package com.tencent.mobileqq.guild.discoveryv2.content.recommend.data;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedUtilsApi;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendGuild;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendOneToOne;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStChannelSign;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okio.internal._Utf8Kt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001e\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000\"\u001b\u0010\n\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\t\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProContentRecommendOneToOne;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/r;", "ext", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/l;", "b", "Lcom/tencent/mobileqq/guild/feed/api/IGuildFeedUtilsApi;", "a", "Lkotlin/Lazy;", "()Lcom/tencent/mobileqq/guild/feed/api/IGuildFeedUtilsApi;", "guildFeedUtils", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class RecommendDataKt {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final Lazy f217101a;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<IGuildFeedUtilsApi>() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendDataKt$guildFeedUtils$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final IGuildFeedUtilsApi invoke() {
                return (IGuildFeedUtilsApi) QRoute.api(IGuildFeedUtilsApi.class);
            }
        });
        f217101a = lazy;
    }

    private static final IGuildFeedUtilsApi a() {
        return (IGuildFeedUtilsApi) f217101a.getValue();
    }

    @Nullable
    public static final l<?> b(@NotNull IGProContentRecommendOneToOne item, @NotNull RecommendExtData ext) {
        boolean z16;
        qj1.h hVar;
        Object m476constructorimpl;
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(ext, "ext");
        GProStFeed convertToStFeedByNT = a().convertToStFeedByNT(item.getStFeed());
        String str = convertToStFeedByNT.channelInfo.sign.joinGuildSig;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            GProStChannelSign gProStChannelSign = convertToStFeedByNT.channelInfo.sign;
            try {
                Result.Companion companion = Result.INSTANCE;
                byte[] joinSig = item.getGuild().getJoinSig();
                Intrinsics.checkNotNullExpressionValue(joinSig, "item.guild.joinSig");
                m476constructorimpl = Result.m476constructorimpl(_Utf8Kt.commonToUtf8String$default(joinSig, 0, 0, 3, null));
            } catch (Throwable th5) {
                Result.Companion companion2 = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
            if (Result.m482isFailureimpl(m476constructorimpl)) {
                m476constructorimpl = "";
            }
            gProStChannelSign.joinGuildSig = (String) m476constructorimpl;
        }
        Object parseStFeedToIFeedMainDisplayable = a().parseStFeedToIFeedMainDisplayable(convertToStFeedByNT);
        if (parseStFeedToIFeedMainDisplayable instanceof qj1.h) {
            hVar = (qj1.h) parseStFeedToIFeedMainDisplayable;
        } else {
            hVar = null;
        }
        if (hVar == null) {
            return null;
        }
        IGuildFeedUtilsApi a16 = a();
        IGProContentRecommendGuild guild2 = item.getGuild();
        Intrinsics.checkNotNullExpressionValue(guild2, "item.guild");
        Object newRecommendFeedData = a16.newRecommendFeedData(hVar, ext, guild2);
        Intrinsics.checkNotNull(newRecommendFeedData, "null cannot be cast to non-null type com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.IRecommendData<*>");
        return (l) newRecommendFeedData;
    }
}
