package com.tencent.mobileqq.guild.feed.morepanel.handler;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.guild.feed.event.GuildFeedShareChannelEvent;
import com.tencent.mobileqq.guild.feed.morepanel.PanelContext;
import com.tencent.mobileqq.guild.feed.morepanel.handler.GuildFeedShareToWXInfo;
import com.tencent.mobileqq.guild.feed.usecases.GuildFeedArkShareInfo;
import com.tencent.mobileqq.guild.share.util.GuildActionSheetAttaUtil;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildListSortInfo;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import wh2.eh;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "result", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final class ShareFeedActionHandler$handleAppendActionOrShareChannel$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ boolean $appendAction;
    final /* synthetic */ String $id;
    final /* synthetic */ PanelContext<Activity, vk1.b> $panelContext;
    final /* synthetic */ GuildFeedArkShareInfo $shareArkInfo;
    final /* synthetic */ ShareFeedActionHandler this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareFeedActionHandler$handleAppendActionOrShareChannel$1(PanelContext<Activity, vk1.b> panelContext, GuildFeedArkShareInfo guildFeedArkShareInfo, boolean z16, String str, ShareFeedActionHandler shareFeedActionHandler) {
        super(1);
        this.$panelContext = panelContext;
        this.$shareArkInfo = guildFeedArkShareInfo;
        this.$appendAction = z16;
        this.$id = str;
        this.this$0 = shareFeedActionHandler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(GuildFeedArkShareInfo guildFeedArkShareInfo, int i3, String str, IGProGuildListSortInfo iGProGuildListSortInfo) {
        Logger.f235387a.d().i("guild.share.ShareFeedActionHandler", 1, "setGuildListTop end. with guildId=" + guildFeedArkShareInfo.p() + " code=" + i3 + " errMsg=" + str);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z16) {
        Unit unit;
        if (z16) {
            Logger logger = Logger.f235387a;
            String str = this.$id;
            logger.d().i("guild.share.ShareFeedActionHandler", 1, "handleAppendActionOrShareChannel item:" + str);
            com.tencent.mobileqq.guild.feed.share.r rVar = new com.tencent.mobileqq.guild.feed.share.r(this.$panelContext.h(), this.$shareArkInfo);
            Bundle extra = this.$panelContext.getExtra();
            GuildSharePageSource guildSharePageSource = GuildSharePageSource.UNKNOWN;
            rVar.a(extra.getInt(AppConstants.Key.SHARE_PANEL_PAGE_SOURCE, guildSharePageSource.ordinal()));
            if (this.$appendAction) {
                if (Intrinsics.areEqual(this.$id, WinkDaTongReportConstant.ElementParamValue.XSJ_SHARE_COPY_LINK)) {
                    rVar.c();
                }
            } else {
                String str2 = this.$id;
                switch (str2.hashCode()) {
                    case -791575966:
                        if (str2.equals("weixin")) {
                            GuildFeedShareToWXInfo.Companion companion = GuildFeedShareToWXInfo.INSTANCE;
                            PanelContext<Activity, vk1.b> panelContext = this.$panelContext;
                            String y16 = this.$shareArkInfo.y();
                            Intrinsics.checkNotNullExpressionValue(y16, "shareArkInfo.shareTitle");
                            String s16 = this.$shareArkInfo.s();
                            Intrinsics.checkNotNullExpressionValue(s16, "shareArkInfo.outShareContent");
                            GuildFeedShareToWXInfo a16 = companion.a(panelContext, y16, s16);
                            if (a16 != null) {
                                GuildFeedShareToWXHelper.f220290a.q(this.$panelContext.h(), a16);
                                unit = Unit.INSTANCE;
                            } else {
                                unit = null;
                            }
                            if (unit == null) {
                                rVar.h(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.morepanel.handler.ae
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        ShareFeedActionHandler$handleAppendActionOrShareChannel$1.e();
                                    }
                                });
                                break;
                            }
                        }
                        break;
                    case -393543490:
                        if (str2.equals("qqfriend")) {
                            rVar.d();
                            break;
                        }
                        break;
                    case -304161157:
                        if (str2.equals("qzoneshuoshuo")) {
                            rVar.f();
                            break;
                        }
                        break;
                    case 154627506:
                        if (str2.equals("weixincircle")) {
                            rVar.g(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.morepanel.handler.af
                                @Override // java.lang.Runnable
                                public final void run() {
                                    ShareFeedActionHandler$handleAppendActionOrShareChannel$1.f();
                                }
                            });
                            break;
                        }
                        break;
                    case 2024098531:
                        if (str2.equals("qqchannel")) {
                            rVar.b();
                            break;
                        }
                        break;
                }
                if (Intrinsics.areEqual(this.$id, "weixin") || Intrinsics.areEqual(this.$id, "weixincircle") || Intrinsics.areEqual(this.$id, "qzoneshuoshuo")) {
                    this.this$0.j(GuildFeedShareChannelEvent.INSTANCE.e(this.$id), this.$panelContext, "handleAppendActionOrShareChannel");
                }
            }
            this.this$0.q(this.$panelContext.h(), this.$shareArkInfo);
            String w3 = this.$shareArkInfo.w();
            Intrinsics.checkNotNullExpressionValue(w3, "shareArkInfo.shareLongUrl");
            GuildActionSheetAttaUtil.r(w3, this.$id, this.$panelContext.getExtra().getInt(AppConstants.Key.SHARE_PANEL_PAGE_SOURCE, guildSharePageSource.ordinal()), "");
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
            IGPSService iGPSService = (IGPSService) (appInterface != null ? appInterface.getRuntimeService(IGPSService.class, "") : null);
            if (iGPSService != null) {
                String p16 = this.$shareArkInfo.p();
                final GuildFeedArkShareInfo guildFeedArkShareInfo = this.$shareArkInfo;
                iGPSService.setGuildListTop(p16, 1, 2, new eh() { // from class: com.tencent.mobileqq.guild.feed.morepanel.handler.ag
                    @Override // wh2.eh
                    public final void a(int i3, String str3, IGProGuildListSortInfo iGProGuildListSortInfo) {
                        ShareFeedActionHandler$handleAppendActionOrShareChannel$1.g(GuildFeedArkShareInfo.this, i3, str3, iGProGuildListSortInfo);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f() {
    }
}
