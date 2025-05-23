package com.tencent.mobileqq.guild.api.impl;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildInfoUtilsApi;
import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.LiveReadyPanelFragment;
import com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore;
import com.tencent.mobileqq.guild.share.FetchGuildArkInfo;
import com.tencent.mobileqq.guild.share.shorturl.ShareServiceType;
import com.tencent.mobileqq.guild.usecases.b;
import com.tencent.mobileqq.guild.util.ao;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.security.GuildChannelSwitchManager;
import com.tencent.mobileqq.guild.widget.GuildStateType;
import com.tencent.mobileqq.mini.report.MiniAppReportManager;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.type.IChannelType;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.sharepanel.api.ISharePanelApi;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GuildInfoUtilsApiImpl implements IGuildInfoUtilsApi {
    private static final String TAG = "GuildInfoUtilsApiImpl";

    private GuildStateType getGuildStateType(com.tencent.mobileqq.guild.config.r rVar) {
        switch (rVar.d()) {
            case 1:
            case 3:
                return GuildStateType.LIVE;
            case 2:
            case 6:
                return GuildStateType.VOICE;
            case 4:
            case 5:
            case 9:
            case 10:
            default:
                return GuildStateType.NONE;
            case 7:
            case 8:
                return GuildStateType.SCREEN_SHARE;
            case 11:
            case 12:
                return GuildStateType.VOICE_GAME;
            case 13:
            case 14:
                return GuildStateType.PLAY_TOGETHER;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit lambda$shareGuildToQQ$0(Activity activity, com.tencent.mobileqq.guild.share.y yVar, GuildSharePageSource guildSharePageSource, com.tencent.mobileqq.guild.share.b bVar) {
        if (bVar == null) {
            QQToast.makeText(activity, 1, "\u5206\u4eab\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5~", 0).show();
            return null;
        }
        com.tencent.mobileqq.guild.share.w wVar = new com.tencent.mobileqq.guild.share.w(activity, yVar, guildSharePageSource);
        wVar.y(bVar);
        if (!((ISharePanelApi) QRoute.api(ISharePanelApi.class)).useNewSharePanel("pindao_homepage")) {
            wVar.n();
        }
        wVar.q();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$shareGuildToQQ$1(final Activity activity, IGProGuildInfo iGProGuildInfo, final GuildSharePageSource guildSharePageSource, ri1.a aVar, b.c cVar) {
        int i3 = aVar.f431477a;
        if (i3 == -200) {
            com.tencent.mobileqq.guild.share.m.l(aVar, activity);
            return;
        }
        if (i3 == 0 && cVar != null) {
            final com.tencent.mobileqq.guild.share.y yVar = new com.tencent.mobileqq.guild.share.y(iGProGuildInfo, null, cVar);
            yVar.E(9);
            FetchGuildArkInfo fetchGuildArkInfo = new FetchGuildArkInfo(iGProGuildInfo, null, ShareServiceType.HOME);
            fetchGuildArkInfo.h(guildSharePageSource, cVar);
            fetchGuildArkInfo.g(new Function1() { // from class: com.tencent.mobileqq.guild.api.impl.p
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit lambda$shareGuildToQQ$0;
                    lambda$shareGuildToQQ$0 = GuildInfoUtilsApiImpl.lambda$shareGuildToQQ$0(activity, yVar, guildSharePageSource, (com.tencent.mobileqq.guild.share.b) obj);
                    return lambda$shareGuildToQQ$0;
                }
            });
            return;
        }
        ch.q1(activity, i3, aVar.f431478b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$shareGuildToWechatFriend$2(Activity activity, IGProGuildInfo iGProGuildInfo, GuildSharePageSource guildSharePageSource, ri1.a aVar, b.c cVar) {
        int i3 = aVar.f431477a;
        if (i3 == -200) {
            com.tencent.mobileqq.guild.share.m.l(aVar, activity);
            return;
        }
        if (i3 == 0 && cVar != null) {
            com.tencent.mobileqq.guild.share.y yVar = new com.tencent.mobileqq.guild.share.y(iGProGuildInfo, null, cVar);
            yVar.E(9);
            new com.tencent.mobileqq.guild.share.w(activity, yVar, guildSharePageSource).x();
            return;
        }
        ch.q1(activity, i3, aVar.f431478b);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildInfoUtilsApi
    public boolean canTalkinChannel(AppRuntime appRuntime, String str, String str2) {
        boolean z16;
        boolean z17;
        boolean z18;
        if (appRuntime != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            IGProGuildInfo M = ch.M(str);
            IGProChannelInfo C = ch.C(appRuntime, str, str2);
            if (C == null) {
                QLog.e(TAG, 1, "channelInfo is null, canTalkinChannel return false");
                return false;
            }
            if (ch.t0(M)) {
                return true;
            }
            QLog.d(TAG, 1, "canTalkinChannel: talkPermission[" + C.getMyTalkPermissionType() + "], channelId=" + str2);
            boolean a16 = ao.a(C);
            if (C.getBannedSpeak() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            QLog.d(TAG, 1, "canTalkinChannel: isBannedSpeak[" + z16 + "]");
            if (GLiveChannelCore.f226698a.t().D().getValue() == Boolean.TRUE) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (M != null && M.isMember() && sz1.d.k(str, str2)) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (z16) {
                if (!ch.t0(M) && !ch.h0(str2) && !z17) {
                    return false;
                }
            } else if (z18) {
                if (!ch.t0(M) && !ch.h0(str2)) {
                    return false;
                }
            } else if (!a16 && !z17) {
                return false;
            }
            return true;
        }
        QLog.e(TAG, 1, "args invalid, canTalkinChannel return false");
        return false;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildInfoUtilsApi
    public boolean checkSecurityValid(IGProSecurityResult iGProSecurityResult) {
        return ch.p(iGProSecurityResult);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildInfoUtilsApi
    public int getChannelType(AppRuntime appRuntime, String str, String str2) {
        IGPSService iGPSService;
        IGProChannelInfo channelInfo;
        if (appRuntime == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (channelInfo = (iGPSService = (IGPSService) appRuntime.getRuntimeService(IGPSService.class, "all")).getChannelInfo(str2)) == null) {
            return 0;
        }
        int type = channelInfo.getType();
        if (type == 6) {
            long applicationId = channelInfo.getApplicationId();
            if (applicationId == 0) {
                applicationId = iGPSService.getAppChannelPreInfo(str, str2).getAppid();
            }
            if (applicationId == 1000001) {
                return 1000001;
            }
            if (applicationId == 1000137) {
                return IChannelType.APP_SUB_CHANNEL_TYPE_GAMECENTER_QA;
            }
            if (applicationId != 1000000) {
                if (applicationId == 1000051) {
                    return IChannelType.APP_SUB_CHANNEL_TYPE_QQ_SPEED;
                }
                if (applicationId == 1000070) {
                    return IChannelType.APP_SUB_CHANNEL_TYPE_CODM;
                }
                if (applicationId == 1000050) {
                    return IChannelType.APP_SUB_CHANNEL_TYPE_SCHEDULE;
                }
                if (applicationId == 1000075) {
                    return IChannelType.APP_SUB_CHANNEL_TYPE_KARAOKE;
                }
                if (!com.tencent.mobileqq.guild.main.b.b(applicationId)) {
                    if (applicationId == MiniAppReportManager.MAX_TIME_VALUE) {
                        return IChannelType.APP_SUB_CHANNEL_TYPE_LINK;
                    }
                    return type;
                }
            }
            return 1000000;
        }
        return type;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildInfoUtilsApi
    public int getGenericChannelType(int i3) {
        if (i3 >= 1000001 && i3 <= 9999999) {
            return 6;
        }
        return i3;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildInfoUtilsApi
    public GuildStateType getGuildAioSubTitleIconState(String str) {
        return getGuildStateType(ds1.a.e(str));
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildInfoUtilsApi
    public int getGuildSettingDrawable() {
        return R.drawable.guild_setting_check_selector;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildInfoUtilsApi
    public String getOnlineUIDataToShow(int i3, int i16) {
        return com.tencent.mobileqq.guild.main.b.a(i3, i16);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildInfoUtilsApi
    public boolean isCreatorOrAdmin(AppRuntime appRuntime, String str) {
        if (appRuntime != null && !TextUtils.isEmpty(str)) {
            return ch.t0(((IGPSService) appRuntime.getRuntimeService(IGPSService.class, "")).getGuildInfo(str));
        }
        QLog.e(TAG, 1, "args invalid, isCreatorOrAdmin return false");
        return false;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildInfoUtilsApi
    public boolean isHomePage(AppRuntime appRuntime, String str) {
        IGProChannelInfo channelInfo;
        if (appRuntime == null || TextUtils.isEmpty(str) || (channelInfo = ((IGPSService) appRuntime.getRuntimeService(IGPSService.class, "")).getChannelInfo(str)) == null || channelInfo.getType() != 3) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildInfoUtilsApi
    public boolean isLiveReadyFragment(Object obj) {
        return obj instanceof LiveReadyPanelFragment;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildInfoUtilsApi
    public boolean isSafetySwitchOpen(String str, int i3) {
        if (str == null) {
            return true;
        }
        return GuildChannelSwitchManager.e(str, i3);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildInfoUtilsApi
    public boolean isSupportSubscriptionChannelAbility(int i3) {
        if (i3 == 1 || i3 == 5 || i3 == 7 || i3 == 2) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildInfoUtilsApi
    public boolean isSupportTextChannleAbility(int i3) {
        if (i3 == 1 || i3 == 3 || i3 == 5 || i3 == 7 || i3 == 1000001 || i3 == 1000137) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildInfoUtilsApi
    public boolean isSupportTopChannelAbility(int i3) {
        if (i3 == 1 || i3 == 5 || i3 == 7 || i3 == 2 || i3 == 8) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildInfoUtilsApi
    public void shareGuildToQQ(final Activity activity, final IGProGuildInfo iGProGuildInfo, final GuildSharePageSource guildSharePageSource) {
        com.tencent.mobileqq.guild.usecases.b.g(iGProGuildInfo, null, 9, new b.InterfaceC7909b() { // from class: com.tencent.mobileqq.guild.api.impl.o
            @Override // com.tencent.mobileqq.guild.usecases.b.InterfaceC7909b
            public final void a(ri1.a aVar, b.c cVar) {
                GuildInfoUtilsApiImpl.lambda$shareGuildToQQ$1(activity, iGProGuildInfo, guildSharePageSource, aVar, cVar);
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildInfoUtilsApi
    public void shareGuildToWechatFriend(final Activity activity, final IGProGuildInfo iGProGuildInfo, final GuildSharePageSource guildSharePageSource) {
        com.tencent.mobileqq.guild.usecases.b.g(iGProGuildInfo, null, 9, new b.InterfaceC7909b() { // from class: com.tencent.mobileqq.guild.api.impl.n
            @Override // com.tencent.mobileqq.guild.usecases.b.InterfaceC7909b
            public final void a(ri1.a aVar, b.c cVar) {
                GuildInfoUtilsApiImpl.lambda$shareGuildToWechatFriend$2(activity, iGProGuildInfo, guildSharePageSource, aVar, cVar);
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildInfoUtilsApi
    public void toastErrorAndSecurity(Context context, int i3, String str, IGProSecurityResult iGProSecurityResult) {
        ch.t1(context, i3, str, iGProSecurityResult);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildInfoUtilsApi
    public void trySetGuildAutoTop(String str, String str2) {
        com.tencent.mobileqq.guild.main.d.d(MobileQQ.sMobileQQ.peekAppRuntime(), str, str2);
    }
}
