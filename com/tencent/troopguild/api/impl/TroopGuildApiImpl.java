package com.tencent.troopguild.api.impl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.troopbindguild.api.ITroopBindGuildApi;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GuildGroupOptType;
import com.tencent.qqnt.kernel.nativeinterface.IGetGuildBinaryDataCallback;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import com.tencent.troopguild.api.ITroopGuildApi;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 '2\u00020\u0001:\u0001(B\u0007\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\u0002H\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\r\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J&\u0010\u0017\u001a\u00020\u00162\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0018\u0010\u001a\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J,\u0010\u001f\u001a\u00020\u00162\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0002H\u0016J$\u0010 \u001a\u00020\u00162\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001e\u001a\u00020\u0002H\u0016J\u0010\u0010\"\u001a\u00020!2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0012\u0010$\u001a\u0004\u0018\u00010!2\u0006\u0010#\u001a\u00020!H\u0016\u00a8\u0006)"}, d2 = {"Lcom/tencent/troopguild/api/impl/TroopGuildApiImpl;", "Lcom/tencent/troopguild/api/ITroopGuildApi;", "", "troopUin", "", "isTroopBindGuild", "isTroopGuild", "isTroopGuildSwitchOpen", "Landroid/content/Context;", "context", "Luo4/b;", "createGuildContainer", "getTroopGuildId", "guildId", "getTroopFeedChannelId", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "getTroopFeedChannelInfo", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "troopInfo", "getTroopName", "Luo4/a;", "cb", "", "getGuildGroupTransData", "", "optType", "getHighLightStringByOptType", "getTroopGuildRole", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", WadlProxyConsts.KEY_JUMP_URL, "doBubbleOpJumpAction", "doGrayTipJumpFeedAction", "Landroid/view/View;", "getLoadingView", "view", "getLoadingAnimView", "<init>", "()V", "Companion", "a", "troop-guild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class TroopGuildApiImpl implements ITroopGuildApi {

    @NotNull
    public static final String TAG = "TroopGuildApiImpl";
    public static final int TROOP_GUILD_ROLE_ADMIN = 2;
    public static final int TROOP_GUILD_ROLE_MEMBER = 3;
    public static final int TROOP_GUILD_ROLE_NON_MEMBER = 4;
    public static final int TROOP_GUILD_ROLE_OWNER = 1;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getGuildGroupTransData$lambda$1(uo4.a aVar, int i3, String str, HashMap data) {
        if (aVar != null) {
            Intrinsics.checkNotNullExpressionValue(data, "data");
            aVar.onResult(i3, str, data);
        }
    }

    private final boolean isTroopBindGuild(String troopUin) {
        long j3;
        ITroopBindGuildApi.TroopBindGuildInfo bindGuildInfoFromExtInfo = ((ITroopBindGuildApi) QRoute.api(ITroopBindGuildApi.class)).getBindGuildInfoFromExtInfo(troopUin);
        if (bindGuildInfoFromExtInfo != null) {
            j3 = bindGuildInfoFromExtInfo.getGuildId();
        } else {
            j3 = 0;
        }
        if (j3 != 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.troopguild.api.ITroopGuildApi
    @NotNull
    public uo4.b createGuildContainer(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new vo4.a(context);
    }

    @Override // com.tencent.troopguild.api.ITroopGuildApi
    public void doBubbleOpJumpAction(@Nullable BaseQQAppInterface app, @Nullable Context context, @NotNull String troopUin, @NotNull String jumpUrl) {
        xo4.b bVar;
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        ax c16 = bi.c(app, context, jumpUrl);
        if (c16 != null) {
            c16.r("jump_fom_op_bubble", "1");
            if (c16 instanceof xo4.b) {
                bVar = (xo4.b) c16;
            } else {
                bVar = null;
            }
            if (bVar != null) {
                if (bVar.H(troopUin)) {
                    bVar.b();
                    return;
                }
                QLog.e(TAG, 1, "doBubbleOpJumpAction isParamNotLegal troopUin:" + troopUin + " jumpUrl:" + jumpUrl);
            }
        }
    }

    @Override // com.tencent.troopguild.api.ITroopGuildApi
    public void doGrayTipJumpFeedAction(@Nullable BaseQQAppInterface app, @Nullable Context context, @NotNull String jumpUrl) {
        xo4.b bVar;
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        ax c16 = bi.c(app, context, jumpUrl);
        if (c16 != null) {
            if (c16 instanceof xo4.b) {
                bVar = (xo4.b) c16;
            } else {
                bVar = null;
            }
            if (bVar != null) {
                bVar.b();
            }
        }
    }

    @Override // com.tencent.troopguild.api.ITroopGuildApi
    public void getGuildGroupTransData(@Nullable String troopUin, @Nullable String guildId, @Nullable final uo4.a cb5) {
        ((IMsgService) QRoute.api(IMsgService.class)).getGuildGroupTransData(new Contact(9, troopUin, guildId), new IGetGuildBinaryDataCallback() { // from class: com.tencent.troopguild.api.impl.a
            @Override // com.tencent.qqnt.kernel.nativeinterface.IGetGuildBinaryDataCallback
            public final void onResult(int i3, String str, HashMap hashMap) {
                TroopGuildApiImpl.getGuildGroupTransData$lambda$1(uo4.a.this, i3, str, hashMap);
            }
        });
    }

    @Override // com.tencent.troopguild.api.ITroopGuildApi
    @NotNull
    public String getHighLightStringByOptType(@NotNull Context context, int optType) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (optType == GuildGroupOptType.KNEWFEED.ordinal()) {
            String string = context.getString(R.string.f2336877x);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026uild_high_light_new_feed)");
            return string;
        }
        if (optType == GuildGroupOptType.KFEEDCOMMENT.ordinal()) {
            String string2 = context.getString(R.string.f2336677v);
            Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri\u2026guild_high_light_comment)");
            return string2;
        }
        if (optType == GuildGroupOptType.KFEEDATME.ordinal()) {
            String string3 = context.getString(R.string.f2336577u);
            Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.stri\u2026p_guild_high_light_at_me)");
            return string3;
        }
        if (optType == GuildGroupOptType.KFEEDLIKE.ordinal()) {
            String string4 = context.getString(R.string.f2336777w);
            Intrinsics.checkNotNullExpressionValue(string4, "context.getString(R.stri\u2026op_guild_high_light_link)");
            return string4;
        }
        return "";
    }

    @Override // com.tencent.troopguild.api.ITroopGuildApi
    @Nullable
    public View getLoadingAnimView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.wox);
        if (!(findViewById instanceof View)) {
            return null;
        }
        return findViewById;
    }

    @Override // com.tencent.troopguild.api.ITroopGuildApi
    @NotNull
    public View getLoadingView(@NotNull Context context) {
        int i3;
        Intrinsics.checkNotNullParameter(context, "context");
        View view = null;
        View loadingView = LayoutInflater.from(context).inflate(R.layout.epd, (ViewGroup) null);
        View findViewById = loadingView.findViewById(R.id.wox);
        if (findViewById instanceof View) {
            view = findViewById;
        }
        if (!QQTheme.isNowThemeIsNight() && !QQTheme.isNowThemeSimpleNight()) {
            i3 = R.drawable.guild_msg_list_loading_animate_view;
        } else {
            i3 = R.drawable.guild_msg_list_loading_animate_night_view;
        }
        if (view != null) {
            view.setBackgroundResource(i3);
        }
        Intrinsics.checkNotNullExpressionValue(loadingView, "loadingView");
        return loadingView;
    }

    @Override // com.tencent.troopguild.api.ITroopGuildApi
    @Nullable
    public String getTroopFeedChannelId(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        IGProChannelInfo troopFeedChannelInfo = getTroopFeedChannelInfo(guildId);
        if (troopFeedChannelInfo != null) {
            return troopFeedChannelInfo.getChannelUin();
        }
        return null;
    }

    @Override // com.tencent.troopguild.api.ITroopGuildApi
    @Nullable
    public IGProChannelInfo getTroopFeedChannelInfo(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "sMobileQQ.peekAppRuntime\u2026va, ProcessConstant.MAIN)");
        List<IGProChannelInfo> channelList = ((IGPSService) runtimeService).getChannelList(guildId);
        Intrinsics.checkNotNullExpressionValue(channelList, "gpsService.getChannelList(guildId)");
        for (IGProChannelInfo iGProChannelInfo : channelList) {
            if (iGProChannelInfo.getType() == 7) {
                return iGProChannelInfo;
            }
        }
        QLog.i(TAG, 1, "[getTroopFeedChannelInfo] fail. guildInfo:" + guildId + ", channelList is empty: " + channelList.isEmpty());
        return null;
    }

    @Override // com.tencent.troopguild.api.ITroopGuildApi
    @NotNull
    public String getTroopGuildId(@NotNull String troopUin) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return "";
        }
        return String.valueOf(((ITroopInfoService) peekAppRuntime.getRuntimeService(ITroopInfoService.class, "")).getTroopInfo(troopUin).getTroopGuildId());
    }

    @Override // com.tencent.troopguild.api.ITroopGuildApi
    public int getTroopGuildRole(@NotNull String troopUin) {
        TroopInfo findTroopInfo;
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || (findTroopInfo = ((ITroopInfoService) peekAppRuntime.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(troopUin)) == null) {
            return 4;
        }
        String currentAccountUin = peekAppRuntime.getCurrentAccountUin();
        if (findTroopInfo.isTroopOwner(currentAccountUin)) {
            return 1;
        }
        if (findTroopInfo.isTroopAdmin(currentAccountUin)) {
            return 2;
        }
        return 3;
    }

    @Override // com.tencent.troopguild.api.ITroopGuildApi
    @NotNull
    public String getTroopName(@NotNull String troopUin) {
        boolean z16;
        AppRuntime peekAppRuntime;
        TroopInfo findTroopInfo;
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        if (troopUin.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null || (findTroopInfo = ((ITroopInfoService) peekAppRuntime.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(troopUin)) == null) {
            return "";
        }
        String troopDisplayName = findTroopInfo.getTroopDisplayName();
        Intrinsics.checkNotNullExpressionValue(troopDisplayName, "troopInfo.troopDisplayName");
        return troopDisplayName;
    }

    @Override // com.tencent.troopguild.api.ITroopGuildApi
    public boolean isTroopGuild(@Nullable String troopUin) {
        AppRuntime peekAppRuntime;
        TroopInfo findTroopInfo;
        if ((troopUin == null || troopUin.length() == 0) || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null || (findTroopInfo = ((ITroopInfoService) peekAppRuntime.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(troopUin)) == null) {
            return false;
        }
        return findTroopInfo.isTroopGuild() && !isTroopBindGuild(troopUin);
    }

    @Override // com.tencent.troopguild.api.ITroopGuildApi
    public boolean isTroopGuildSwitchOpen(@Nullable String troopUin) {
        boolean z16;
        AppRuntime peekAppRuntime;
        TroopInfo findTroopInfo;
        if (troopUin != null && troopUin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16 || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null || (findTroopInfo = ((ITroopInfoService) peekAppRuntime.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(troopUin)) == null) {
            return false;
        }
        if (findTroopInfo.isTroopGuild() && findTroopInfo.isTroopGuildSwitchOpen() && !isTroopBindGuild(troopUin)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.troopguild.api.ITroopGuildApi
    public boolean isTroopGuild(@Nullable TroopInfo troopInfo) {
        if (troopInfo != null) {
            return troopInfo.isTroopGuild();
        }
        return false;
    }
}
