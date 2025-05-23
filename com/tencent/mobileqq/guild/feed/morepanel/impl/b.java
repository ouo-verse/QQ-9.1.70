package com.tencent.mobileqq.guild.feed.morepanel.impl;

import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/morepanel/impl/b;", "Lcom/tencent/mobileqq/guild/feed/morepanel/impl/c;", "", "c", "Lcom/tencent/mobileqq/sharepanel/model/d;", "getReportParams", "Lcom/tencent/mobileqq/guild/feed/morepanel/k;", "b", "Lcom/tencent/mobileqq/guild/feed/morepanel/k;", ConstantsAPI.Token.WX_LAUNCH_PARAM_KEY, "<init>", "(Lcom/tencent/mobileqq/guild/feed/morepanel/k;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b extends c {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.feed.morepanel.k launchParam;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull com.tencent.mobileqq.guild.feed.morepanel.k launchParam) {
        super(launchParam);
        Intrinsics.checkNotNullParameter(launchParam, "launchParam");
        this.launchParam = launchParam;
    }

    @Override // com.tencent.mobileqq.guild.feed.morepanel.impl.c, com.tencent.mobileqq.guild.feed.morepanel.k.b
    @NotNull
    public String c() {
        return "pindao_feedpicture";
    }

    @Override // com.tencent.mobileqq.guild.feed.morepanel.impl.c, com.tencent.mobileqq.guild.feed.morepanel.k.b
    @NotNull
    public com.tencent.mobileqq.sharepanel.model.d getReportParams() {
        return com.tencent.mobileqq.guild.feed.morepanel.e.INSTANCE.a(GuildSharePageSource.FEED_MEDIA_VIEWER, this.launchParam.e().j());
    }
}
