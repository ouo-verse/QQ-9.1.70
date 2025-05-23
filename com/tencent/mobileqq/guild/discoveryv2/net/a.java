package com.tencent.mobileqq.guild.discoveryv2.net;

import com.tencent.mobileqq.guild.discoveryv2.RecommendAdMessage;
import com.tencent.mobileqq.kandian.base.image.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProTabContentCommonRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.eu;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nR\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/net/a;", "Lcom/tencent/mobileqq/guild/discoveryv2/net/f;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/eu;", "req", "", "c", "a", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProTabContentCommonRsp;", "rsp", "b", "Lcom/tencent/mobileqq/guild/discoveryv2/RecommendAdMessage;", "message", "d", "Lrh1/a;", "Lrh1/a;", "adPageData", "", IPublicAccountHttpDownloader.BUSI_TYPE_PARAM_KEY, "<init>", "(I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a implements f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final rh1.a adPageData;

    public a(int i3) {
        this.adPageData = new rh1.a("guild", i3);
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.net.f
    public void a(@NotNull eu req) {
        Intrinsics.checkNotNullParameter(req, "req");
        req.i(rh1.a.d(this.adPageData, false, 1, null).toByteArray());
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.net.f
    public void b(@NotNull eu req, @NotNull IGProTabContentCommonRsp rsp) {
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(rsp, "rsp");
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.net.f
    public void c(@NotNull eu req) {
        Intrinsics.checkNotNullParameter(req, "req");
        req.i(this.adPageData.c(true).toByteArray());
    }

    public final void d(@NotNull RecommendAdMessage message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.adPageData.e(message);
    }
}
