package com.tencent.mobileqq.channel.node.click;

import android.content.Context;
import android.os.Bundle;
import com.tencent.common.config.AppSetting;
import com.tencent.guild.aio.factory.a;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxRuntimeService;
import com.tencent.mobileqq.channel.node.ChannelNodeExtKt;
import com.tencent.mobileqq.guild.GuildChatUtils;
import com.tencent.mobileqq.guild.api.IGuildChannelLoadApi;
import com.tencent.mobileqq.guild.api.ILaunchGuildChatPieApi;
import com.tencent.mobileqq.guild.api.i;
import com.tencent.mobileqq.guild.e;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.guild.mainframe.GuildFeedReportSourceInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.chats.main.vm.usecase.click.b;
import com.tencent.qqnt.kernel.nativeinterface.GuildContactInfo;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.ChannelStateElement;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0011\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0096\u0002\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/channel/node/click/ChannelItemClickUseCase;", "Lcom/tencent/qqnt/chats/main/vm/usecase/click/b;", "Lcom/tencent/mobileqq/guild/mainframe/GuildAppReportSourceInfo;", "getReportInfo", "Lcom/tencent/mobileqq/guild/mainframe/GuildFeedReportSourceInfo;", "getFeedReportInfo", "Lcom/tencent/qqnt/chats/main/vm/usecase/click/b$a;", "params", "", "interestedIn", "invoke", "<init>", "()V", "Companion", "qqchat_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class ChannelItemClickUseCase implements b {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "ChannelItemClickUseCase";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/channel/node/click/ChannelItemClickUseCase$Companion;", "", "()V", "TAG", "", "qqchat_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22635);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ChannelItemClickUseCase() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final GuildFeedReportSourceInfo getFeedReportInfo() {
        GuildFeedReportSourceInfo guildFeedReportSourceInfo = new GuildFeedReportSourceInfo();
        guildFeedReportSourceInfo.addReportItem("extra_feeds_pre_page_id", IGameMsgBoxRuntimeService.DT_PAGE_ID);
        return guildFeedReportSourceInfo;
    }

    private final GuildAppReportSourceInfo getReportInfo() {
        GuildAppReportSourceInfo guildAppReportSourceInfo = new GuildAppReportSourceInfo();
        guildAppReportSourceInfo.addReportItem("sgrp_stream_pgin_source_name", "msg_tab_list");
        return guildAppReportSourceInfo;
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.click.b
    public boolean interestedIn(@NotNull b.a params) {
        g gVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) params)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(params, "params");
        com.tencent.qqnt.chats.core.adapter.itemdata.b b16 = params.b();
        if (b16 instanceof g) {
            gVar = (g) b16;
        } else {
            gVar = null;
        }
        if (gVar == null || gVar.n() != 4) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.click.b
    public boolean invoke(@NotNull b.a params) {
        g gVar;
        RecentContactInfo s16;
        GuildContactInfo guildContactInfo;
        boolean z16;
        IRuntimeService iRuntimeService;
        IGProChannelInfo iGProChannelInfo;
        g gVar2;
        AppRuntime peekAppRuntime;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) params)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(params, "params");
        com.tencent.qqnt.chats.core.adapter.itemdata.b b16 = params.b();
        ChannelStateElement channelStateElement = null;
        if (b16 instanceof g) {
            gVar = (g) b16;
        } else {
            gVar = null;
        }
        if (gVar != null && (s16 = gVar.s()) != null && (guildContactInfo = s16.guildContactInfo) != null) {
            String str = guildContactInfo.channelId;
            boolean z18 = false;
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                String str2 = guildContactInfo.guildId;
                if (str2 != null && str2.length() != 0) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                if (!z17) {
                    z18 = true;
                }
            }
            if (!z18) {
                guildContactInfo = null;
            }
            if (guildContactInfo != null) {
                Context context = params.c().getContext();
                if (context == null) {
                    QLog.i(TAG, 1, "click channelId:" + guildContactInfo.channelId + " fail, context is null");
                    return true;
                }
                GuildChatUtils guildChatUtils = GuildChatUtils.f213838a;
                MobileQQ mobileQQ = MobileQQ.sMobileQQ;
                if (mobileQQ != null && (peekAppRuntime = mobileQQ.peekAppRuntime()) != null) {
                    iRuntimeService = peekAppRuntime.getRuntimeService(IGPSService.class, "");
                } else {
                    iRuntimeService = null;
                }
                IGPSService iGPSService = (IGPSService) iRuntimeService;
                if (iGPSService != null) {
                    iGProChannelInfo = iGPSService.getChannelInfo(guildContactInfo.channelId);
                } else {
                    iGProChannelInfo = null;
                }
                if (iGProChannelInfo == null) {
                    QLog.i(TAG, 1, "click channelId:" + guildContactInfo.channelId + " fail, channelInfo is null");
                    return true;
                }
                GuildAppReportSourceInfo reportInfo = getReportInfo();
                GuildFeedReportSourceInfo feedReportInfo = getFeedReportInfo();
                int type = iGProChannelInfo.getType();
                if (type == 1) {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("GuildAppReportSourceInfo", reportInfo);
                    bundle.putParcelable("GuildFeedReportSourceInfo", feedReportInfo);
                    i a16 = new i().f(iGProChannelInfo.getGuildId()).b(iGProChannelInfo.getChannelUin()).d(a.class.getName()).e(bundle).a();
                    if (AppSetting.t(context)) {
                        ((ILaunchGuildChatPieApi) QRoute.api(ILaunchGuildChatPieApi.class)).launchSplashGuildChatFragment(context, a16);
                    } else {
                        ((ILaunchGuildChatPieApi) QRoute.api(ILaunchGuildChatPieApi.class)).launchSplashGuildChatActivity(context, a16);
                    }
                } else {
                    JumpGuildParam jumpGuildParam = new JumpGuildParam(iGProChannelInfo.getGuildId(), iGProChannelInfo.getChannelUin());
                    jumpGuildParam.setFeedReportSourceInfo(feedReportInfo);
                    ((IGuildChannelLoadApi) QRoute.api(IGuildChannelLoadApi.class)).loadGuildChannelWithMsgListTab(context, jumpGuildParam);
                }
                if (type == 2 || type == 5) {
                    com.tencent.qqnt.chats.core.adapter.itemdata.b b17 = params.b();
                    if (b17 instanceof g) {
                        gVar2 = (g) b17;
                    } else {
                        gVar2 = null;
                    }
                    if (gVar2 != null) {
                        channelStateElement = ChannelNodeExtKt.getChannelStateElement(gVar2);
                    }
                    if (channelStateElement != null) {
                        e.f217857a.d(channelStateElement.guildId, channelStateElement.channelId, channelStateElement.channelStateReq);
                    }
                }
                QLog.i(TAG, 1, "click channelId:" + guildContactInfo.channelId + " channelType:" + type);
            }
        }
        return true;
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.click.b
    public boolean needUnifiedAnim(@NotNull b.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar)).booleanValue();
        }
        return b.C9598b.a(this, aVar);
    }
}
