package com.tencent.mobileqq.guild.main;

import android.text.TextUtils;
import com.tencent.mobileqq.guild.api.IDirectMessageNodeRepoApi;
import com.tencent.mobileqq.guild.config.subconfig.parser.f;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildListSortInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.eh;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\"\u0010\f\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0007J \u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0002\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/main/d;", "", "", "isFromDirectMsgAIO", "", "channelId", "", "c", "Lmqq/app/AppRuntime;", "appRuntime", "guildId", "operate", "d", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "gpsService", "b", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f227139a = new d();

    d() {
    }

    private final boolean b(IGPSService gpsService, String guildId, String operate) {
        List<String> topGuildList = gpsService.getTopGuildList();
        if (topGuildList != null && topGuildList.contains(guildId) && Intrinsics.areEqual(topGuildList.get(0), guildId)) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("Guild.MF.Top.GuildSetToTopUtils", 2, "the guild is top guild no need move! operate=" + operate + " guildId=" + guildId);
            }
            return false;
        }
        ArrayList<Long> sortedGuildIdsFromCache = gpsService.getSortedGuildIdsFromCache();
        if (sortedGuildIdsFromCache != null) {
            Iterator<Long> it = sortedGuildIdsFromCache.iterator();
            while (it.hasNext()) {
                Long next = it.next();
                if (topGuildList == null || !topGuildList.contains(String.valueOf(next))) {
                    if (Intrinsics.areEqual(guildId, String.valueOf(next))) {
                        Logger logger2 = Logger.f235387a;
                        if (!QLog.isColorLevel()) {
                            return false;
                        }
                        logger2.d().d("Guild.MF.Top.GuildSetToTopUtils", 2, "no need move! operate=" + operate + " guildId=" + guildId);
                        return false;
                    }
                    return true;
                }
            }
        }
        Logger logger3 = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger3.d().d("Guild.MF.Top.GuildSetToTopUtils", 2, "no need move 2! operate=" + operate + " guildId=" + guildId);
        }
        return false;
    }

    @JvmStatic
    public static final void c(boolean isFromDirectMsgAIO, @NotNull String channelId) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        IGPSService iGPSService = (IGPSService) ch.R0(IGPSService.class);
        boolean z16 = true;
        if (isFromDirectMsgAIO) {
            String findNodeByGuildId = ((IDirectMessageNodeRepoApi) QRoute.api(IDirectMessageNodeRepoApi.class)).findNodeByGuildId(channelId);
            if (!TextUtils.isEmpty(findNodeByGuildId)) {
                IGProGuildInfo guildInfo = iGPSService.getGuildInfo(findNodeByGuildId);
                if (guildInfo == null || !guildInfo.isMember()) {
                    z16 = false;
                }
                if (z16) {
                    d(ch.m(), findNodeByGuildId, "trySetGuildAutoTop by channelId");
                    return;
                }
                return;
            }
            return;
        }
        IGProChannelInfo channelInfo = iGPSService.getChannelInfo(channelId);
        if (channelInfo == null) {
            return;
        }
        IGProGuildInfo guildInfo2 = iGPSService.getGuildInfo(channelInfo.getGuildId());
        if (guildInfo2 == null || !guildInfo2.isMember()) {
            z16 = false;
        }
        if (!z16) {
            return;
        }
        AppRuntime m3 = ch.m();
        String guildId = channelInfo.getGuildId();
        Intrinsics.checkNotNullExpressionValue(guildId, "channelInfo.guildId");
        d(m3, guildId, "trySetGuildAutoTop by channelId");
    }

    @JvmStatic
    public static final boolean d(@Nullable AppRuntime appRuntime, @NotNull final String guildId, @NotNull final String operate) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(operate, "operate");
        if (appRuntime != null && !TextUtils.isEmpty(guildId)) {
            tg1.a a16 = ch.E().a(100);
            if ((a16 instanceof f.GuildRecentConfigBean) && !((f.GuildRecentConfigBean) a16).getUsable()) {
                Logger.f235387a.d().i("Guild.MF.Top.GuildSetToTopUtils", 1, "trySetGuildAutoTop failed. auto top disable!");
                return false;
            }
            IRuntimeService runtimeService = appRuntime.getRuntimeService(IGPSService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
            IGPSService iGPSService = (IGPSService) runtimeService;
            if (!f227139a.b(iGPSService, guildId, operate)) {
                return false;
            }
            Logger.f235387a.d().i("Guild.MF.Top.GuildSetToTopUtils", 1, "setGuildListTop start. operate=" + operate + " guildId=" + guildId);
            iGPSService.setGuildListTop(guildId, 1, 2, new eh() { // from class: com.tencent.mobileqq.guild.main.c
                @Override // wh2.eh
                public final void a(int i3, String str, IGProGuildListSortInfo iGProGuildListSortInfo) {
                    d.e(operate, guildId, i3, str, iGProGuildListSortInfo);
                }
            });
            return true;
        }
        Logger.f235387a.d().i("Guild.MF.Top.GuildSetToTopUtils", 1, "trySetGuildTop failed operate=" + operate);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(String operate, String guildId, int i3, String str, IGProGuildListSortInfo iGProGuildListSortInfo) {
        Intrinsics.checkNotNullParameter(operate, "$operate");
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        Logger.f235387a.d().i("Guild.MF.Top.GuildSetToTopUtils", 1, "setGuildListTop end. with " + operate + " guildId=" + guildId + " code=" + i3 + " errMsg=" + str);
    }
}
