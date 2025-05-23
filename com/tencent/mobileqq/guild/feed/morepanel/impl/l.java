package com.tencent.mobileqq.guild.feed.morepanel.impl;

import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.guild.feed.morepanel.FeedMorePanelUtils;
import com.tencent.mobileqq.guild.feed.morepanel.impl.FeedMorePanelBusiImpl;
import com.tencent.mobileqq.guild.feed.morepanel.k;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0011\u001a\u00020\b\u0012\u0006\u0010\u0014\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/morepanel/impl/l;", "Lcom/tencent/mobileqq/guild/feed/morepanel/k$b;", "Lcom/tencent/mobileqq/sharepanel/f;", "sharePanel", "", "d", "b", "e", "", "c", "Lcom/tencent/mobileqq/sharepanel/model/d;", "getReportParams", "Lcom/tencent/mobileqq/guild/feed/morepanel/k;", "a", "Lcom/tencent/mobileqq/guild/feed/morepanel/k;", ConstantsAPI.Token.WX_LAUNCH_PARAM_KEY, "Ljava/lang/String;", "troopUin", "", "Z", "fromImageGallery", "<init>", "(Lcom/tencent/mobileqq/guild/feed/morepanel/k;Ljava/lang/String;Z)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class l implements k.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.feed.morepanel.k launchParam;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String troopUin;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final boolean fromImageGallery;

    public l(@NotNull com.tencent.mobileqq.guild.feed.morepanel.k launchParam, @NotNull String troopUin, boolean z16) {
        Intrinsics.checkNotNullParameter(launchParam, "launchParam");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        this.launchParam = launchParam;
        this.troopUin = troopUin;
        this.fromImageGallery = z16;
    }

    @Override // com.tencent.mobileqq.guild.feed.morepanel.k.b
    public void a(@NotNull com.tencent.mobileqq.sharepanel.f fVar) {
        k.b.a.c(this, fVar);
    }

    @Override // com.tencent.mobileqq.guild.feed.morepanel.k.b
    public void b(@NotNull com.tencent.mobileqq.sharepanel.f sharePanel) {
        Intrinsics.checkNotNullParameter(sharePanel, "sharePanel");
        sharePanel.s0();
    }

    @Override // com.tencent.mobileqq.guild.feed.morepanel.k.b
    @NotNull
    public String c() {
        return "group_feedimmersion";
    }

    @Override // com.tencent.mobileqq.guild.feed.morepanel.k.b
    public void d(@NotNull com.tencent.mobileqq.sharepanel.f sharePanel) {
        Intrinsics.checkNotNullParameter(sharePanel, "sharePanel");
        String string = this.launchParam.e().h().getResources().getString(R.string.f158041oj);
        Intrinsics.checkNotNullExpressionValue(string, "launchParam.panelContext\u2026op_feed_more_panel_title)");
        sharePanel.setTitle(string);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0089  */
    @Override // com.tencent.mobileqq.guild.feed.morepanel.k.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e(@NotNull com.tencent.mobileqq.sharepanel.f sharePanel) {
        boolean z16;
        FeedMorePanelBusiImpl.OperationListProvider.e eVar;
        Boolean bool;
        Intrinsics.checkNotNullParameter(sharePanel, "sharePanel");
        boolean z17 = false;
        sharePanel.m0(false);
        vk1.b j3 = this.launchParam.e().j();
        FeedMorePanelUtils feedMorePanelUtils = FeedMorePanelUtils.f220193a;
        boolean i3 = feedMorePanelUtils.i(j3);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            TroopInfo findTroopInfo = ((ITroopInfoService) peekAppRuntime.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(this.troopUin);
            if (findTroopInfo != null) {
                bool = Boolean.valueOf(findTroopInfo.isOwnerOrAdmin(peekAppRuntime.getCurrentAccountUin()));
            } else {
                bool = null;
            }
            if (bool != null) {
                z16 = bool.booleanValue();
                eVar = (FeedMorePanelBusiImpl.OperationListProvider.e) this.launchParam.e().getApiRouter().b(FeedMorePanelBusiImpl.OperationListProvider.e.class);
                if (eVar != null && eVar.a("")) {
                    z17 = true;
                }
                if (!z16) {
                    if (z17) {
                        feedMorePanelUtils.b(sharePanel, "uppin_homepage");
                    } else {
                        feedMorePanelUtils.b(sharePanel, "pin_to_homepage");
                    }
                    feedMorePanelUtils.b(sharePanel, "delete");
                    if (i3) {
                        feedMorePanelUtils.b(sharePanel, "edit");
                    }
                } else if (i3) {
                    feedMorePanelUtils.b(sharePanel, "delete");
                    feedMorePanelUtils.b(sharePanel, "edit");
                }
                if (!i3) {
                    feedMorePanelUtils.b(sharePanel, "report_abuse");
                }
                if (this.fromImageGallery) {
                    feedMorePanelUtils.b(sharePanel, "save_to_phone");
                    feedMorePanelUtils.a(sharePanel, "edit");
                }
                feedMorePanelUtils.e(this.launchParam, sharePanel);
            }
        }
        z16 = false;
        eVar = (FeedMorePanelBusiImpl.OperationListProvider.e) this.launchParam.e().getApiRouter().b(FeedMorePanelBusiImpl.OperationListProvider.e.class);
        if (eVar != null) {
            z17 = true;
        }
        if (!z16) {
        }
        if (!i3) {
        }
        if (this.fromImageGallery) {
        }
        feedMorePanelUtils.e(this.launchParam, sharePanel);
    }

    @Override // com.tencent.mobileqq.guild.feed.morepanel.k.b
    @NotNull
    public com.tencent.mobileqq.sharepanel.model.d getReportParams() {
        return com.tencent.mobileqq.guild.feed.morepanel.e.INSTANCE.a(GuildSharePageSource.TROOP_FEED, this.launchParam.e().j());
    }
}
