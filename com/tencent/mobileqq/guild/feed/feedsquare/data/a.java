package com.tencent.mobileqq.guild.feed.feedsquare.data;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStGetChannelFeedsRsp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\u0003\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/data/a;", "", "", "a", "Z", "b", "()Z", QAdRewardDefine$VideoParams.ISCACHE, "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStGetChannelFeedsRsp;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStGetChannelFeedsRsp;", "()Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStGetChannelFeedsRsp;", "gProGetChannelFeedsRsp", "<init>", "(ZLcom/tencent/qqnt/kernelgpro/nativeinterface/GProStGetChannelFeedsRsp;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean isCache;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GProStGetChannelFeedsRsp gProGetChannelFeedsRsp;

    public a(boolean z16, @NotNull GProStGetChannelFeedsRsp gProGetChannelFeedsRsp) {
        Intrinsics.checkNotNullParameter(gProGetChannelFeedsRsp, "gProGetChannelFeedsRsp");
        this.isCache = z16;
        this.gProGetChannelFeedsRsp = gProGetChannelFeedsRsp;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final GProStGetChannelFeedsRsp getGProGetChannelFeedsRsp() {
        return this.gProGetChannelFeedsRsp;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getIsCache() {
        return this.isCache;
    }
}
