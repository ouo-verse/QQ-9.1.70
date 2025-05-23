package com.tencent.mobileqq.guild.feed.morepanel.impl;

import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.guild.feed.bean.GuildFeedRichMediaData;
import com.tencent.mobileqq.guild.feed.morepanel.FeedMorePanelUtils;
import com.tencent.mobileqq.guild.feed.morepanel.k;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\n\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/morepanel/impl/c;", "Lcom/tencent/mobileqq/guild/feed/morepanel/k$b;", "Lcom/tencent/mobileqq/sharepanel/f;", "sharePanel", "", "e", "", "c", "Lcom/tencent/mobileqq/sharepanel/model/d;", "getReportParams", "Lcom/tencent/mobileqq/guild/feed/morepanel/k;", "a", "Lcom/tencent/mobileqq/guild/feed/morepanel/k;", ConstantsAPI.Token.WX_LAUNCH_PARAM_KEY, "<init>", "(Lcom/tencent/mobileqq/guild/feed/morepanel/k;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public class c implements k.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.feed.morepanel.k launchParam;

    public c(@NotNull com.tencent.mobileqq.guild.feed.morepanel.k launchParam) {
        Intrinsics.checkNotNullParameter(launchParam, "launchParam");
        this.launchParam = launchParam;
    }

    @Override // com.tencent.mobileqq.guild.feed.morepanel.k.b
    public void a(@NotNull com.tencent.mobileqq.sharepanel.f fVar) {
        k.b.a.c(this, fVar);
    }

    @Override // com.tencent.mobileqq.guild.feed.morepanel.k.b
    public void b(@NotNull com.tencent.mobileqq.sharepanel.f fVar) {
        k.b.a.b(this, fVar);
    }

    @Override // com.tencent.mobileqq.guild.feed.morepanel.k.b
    @NotNull
    public String c() {
        return "pindao_feedimmersion";
    }

    @Override // com.tencent.mobileqq.guild.feed.morepanel.k.b
    public void d(@NotNull com.tencent.mobileqq.sharepanel.f fVar) {
        k.b.a.a(this, fVar);
    }

    @Override // com.tencent.mobileqq.guild.feed.morepanel.k.b
    public void e(@NotNull com.tencent.mobileqq.sharepanel.f sharePanel) {
        Intrinsics.checkNotNullParameter(sharePanel, "sharePanel");
        boolean z16 = false;
        sharePanel.m0(false);
        vk1.b j3 = this.launchParam.e().j();
        FeedMorePanelUtils feedMorePanelUtils = FeedMorePanelUtils.f220193a;
        boolean i3 = feedMorePanelUtils.i(j3);
        boolean j16 = feedMorePanelUtils.j(j3);
        boolean g16 = feedMorePanelUtils.g(j3);
        feedMorePanelUtils.b(sharePanel, "save_to_phone");
        feedMorePanelUtils.b(sharePanel, "generate_share_image");
        feedMorePanelUtils.b(sharePanel, WinkDaTongReportConstant.ElementParamValue.XSJ_SHARE_COPY_LINK);
        if (j16) {
            feedMorePanelUtils.c(sharePanel, this.launchParam.e());
        }
        if (g16) {
            feedMorePanelUtils.b(sharePanel, "move_post");
        }
        if (g16 || i3) {
            feedMorePanelUtils.b(sharePanel, "delete");
        }
        if (!i3) {
            feedMorePanelUtils.b(sharePanel, "report_abuse");
        }
        Object n3 = j3.n();
        if (!(n3 instanceof GuildFeedRichMediaData)) {
            n3 = null;
        }
        GuildFeedRichMediaData guildFeedRichMediaData = (GuildFeedRichMediaData) n3;
        if (guildFeedRichMediaData != null && guildFeedRichMediaData.getType() == 1) {
            z16 = true;
        }
        if (z16) {
            feedMorePanelUtils.b(sharePanel, "floating_window");
        }
        feedMorePanelUtils.e(this.launchParam, sharePanel);
    }

    @Override // com.tencent.mobileqq.guild.feed.morepanel.k.b
    @NotNull
    public com.tencent.mobileqq.sharepanel.model.d getReportParams() {
        return com.tencent.mobileqq.guild.feed.morepanel.e.INSTANCE.a(GuildSharePageSource.GALLERY_FEED_SHARE, this.launchParam.e().j());
    }
}
