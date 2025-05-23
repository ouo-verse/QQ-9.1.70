package com.tencent.mobileqq.guild.feed.morepanel.impl;

import android.app.Activity;
import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.guild.feed.morepanel.FeedMorePanelUtils;
import com.tencent.mobileqq.guild.feed.morepanel.PanelContext;
import com.tencent.mobileqq.guild.feed.morepanel.k;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nj\u0002`\r\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016R$\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nj\u0002`\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/morepanel/impl/d;", "Lcom/tencent/mobileqq/guild/feed/morepanel/k$b;", "Lcom/tencent/mobileqq/sharepanel/f;", "sharePanel", "", "e", "", "c", "Lcom/tencent/mobileqq/sharepanel/model/d;", "getReportParams", "Lcom/tencent/mobileqq/guild/feed/morepanel/PanelContext;", "Landroid/app/Activity;", "Lvk1/b;", "Lcom/tencent/mobileqq/guild/feed/morepanel/impl/MorePanelContext;", "a", "Lcom/tencent/mobileqq/guild/feed/morepanel/PanelContext;", "panelContext", "<init>", "(Lcom/tencent/mobileqq/guild/feed/morepanel/PanelContext;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class d implements k.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PanelContext<Activity, vk1.b> panelContext;

    public d(@NotNull PanelContext<Activity, vk1.b> panelContext) {
        Intrinsics.checkNotNullParameter(panelContext, "panelContext");
        this.panelContext = panelContext;
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
        return "pindao_feed";
    }

    @Override // com.tencent.mobileqq.guild.feed.morepanel.k.b
    public void d(@NotNull com.tencent.mobileqq.sharepanel.f fVar) {
        k.b.a.a(this, fVar);
    }

    @Override // com.tencent.mobileqq.guild.feed.morepanel.k.b
    public void e(@NotNull com.tencent.mobileqq.sharepanel.f sharePanel) {
        Intrinsics.checkNotNullParameter(sharePanel, "sharePanel");
        sharePanel.m0(false);
        FeedMorePanelUtils feedMorePanelUtils = FeedMorePanelUtils.f220193a;
        feedMorePanelUtils.b(sharePanel, "generate_share_image");
        feedMorePanelUtils.b(sharePanel, WinkDaTongReportConstant.ElementParamValue.XSJ_SHARE_COPY_LINK);
        vk1.b j3 = this.panelContext.j();
        boolean i3 = feedMorePanelUtils.i(j3);
        boolean j16 = feedMorePanelUtils.j(j3);
        boolean g16 = feedMorePanelUtils.g(j3);
        if (j16) {
            feedMorePanelUtils.c(sharePanel, this.panelContext);
        }
        if (g16) {
            feedMorePanelUtils.b(sharePanel, "move_post");
            feedMorePanelUtils.b(sharePanel, "batch_manage");
            feedMorePanelUtils.b(sharePanel, "delete");
            if (i3) {
                feedMorePanelUtils.b(sharePanel, "edit");
            } else {
                feedMorePanelUtils.b(sharePanel, "report_abuse");
            }
        } else if (i3) {
            feedMorePanelUtils.b(sharePanel, "edit");
            feedMorePanelUtils.b(sharePanel, "delete");
        } else {
            feedMorePanelUtils.b(sharePanel, "report_abuse");
        }
        if (this.panelContext.getExtra().getInt("src_business_type", 0) == 14) {
            feedMorePanelUtils.b(sharePanel, "not_interested");
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.morepanel.k.b
    @NotNull
    public com.tencent.mobileqq.sharepanel.model.d getReportParams() {
        return com.tencent.mobileqq.guild.feed.morepanel.e.INSTANCE.a(GuildSharePageSource.FEED_LIST, this.panelContext.j());
    }
}
