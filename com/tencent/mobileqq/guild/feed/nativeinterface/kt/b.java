package com.tencent.mobileqq.guild.feed.nativeinterface.kt;

import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.guild.aio.util.h;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProClientIdentity;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMedal;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProSimpleProfile;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProChannelUserInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProCustomManageTag;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProPersonalMedal;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStIconInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStUser;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a$\u0010\b\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0005\u001a\"\u0010\f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005\u001a$\u0010\u000f\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0002\u001a\u001c\u0010\u0010\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u0005H\u0002\u001a$\u0010\u0011\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0002\u001a*\u0010\u0013\u001a\u00020\u0012*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStUser;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProSimpleProfile;", "simpleProfile", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildRoleInfo;", "roleInfo", "", PhotoCategorySummaryInfo.AVATAR_URL, "", "e", "guildId", "channelId", "id", "d", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "service", "a", "c", "f", "", "b", "qqguild_feed_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b {
    private static final void a(GProStUser gProStUser, IGPSService iGPSService, String str, String str2) {
        boolean z16;
        String str3 = "";
        gProStUser.nick = iGPSService.getGuildUserDisplayName(str, str2, iGPSService.getGuildUserNick("", str2));
        GProStIconInfo gProStIconInfo = gProStUser.icon;
        String guildUserAvatarUrl = iGPSService.getGuildUserAvatarUrl(str, str2, 0);
        if (guildUserAvatarUrl != null && guildUserAvatarUrl.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            guildUserAvatarUrl = null;
        }
        if (guildUserAvatarUrl == null) {
            String guildUserAvatarUrl2 = iGPSService.getGuildUserAvatarUrl("0", str2, 0);
            if (guildUserAvatarUrl2 != null) {
                str3 = guildUserAvatarUrl2;
            }
        } else {
            str3 = guildUserAvatarUrl;
        }
        gProStIconInfo.iconUrl = str3;
    }

    public static final boolean b(@NotNull GProStUser gProStUser, @NotNull IGPSService service, @NotNull String guildId, @NotNull String channelId, @NotNull String id5) {
        String str;
        Intrinsics.checkNotNullParameter(gProStUser, "<this>");
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(id5, "id");
        IGProGuildRoleInfo memberTopRole = service.getMemberTopRole(guildId, channelId, id5, "0", 1);
        GProCustomManageTag gProCustomManageTag = gProStUser.manageTag;
        String str2 = gProCustomManageTag.tagName;
        int i3 = gProCustomManageTag.color;
        int i16 = 0;
        if (memberTopRole != null && Intrinsics.areEqual(str2, memberTopRole.getDisplayTagName()) && i3 == memberTopRole.getColor()) {
            return false;
        }
        GProCustomManageTag gProCustomManageTag2 = gProStUser.manageTag;
        if (memberTopRole == null || (str = memberTopRole.getDisplayTagName()) == null) {
            str = "";
        }
        gProCustomManageTag2.tagName = str;
        GProCustomManageTag gProCustomManageTag3 = gProStUser.manageTag;
        if (memberTopRole != null) {
            i16 = memberTopRole.getColor();
        }
        gProCustomManageTag3.color = i16;
        return true;
    }

    private static final void c(GProStUser gProStUser, IGPSService iGPSService, String str) {
        GProPersonalMedal gProPersonalMedal = gProStUser.personalMedal;
        if (gProPersonalMedal == null) {
            gProPersonalMedal = new GProPersonalMedal();
        }
        gProStUser.personalMedal = gProPersonalMedal;
        IGProMedal guildUserMedal = iGPSService.getGuildUserMedal(str);
        if (guildUserMedal != null) {
            gProStUser.personalMedal.startTime = guildUserMedal.getStartTime();
            gProStUser.personalMedal.endTime = guildUserMedal.getEndTime();
            gProStUser.personalMedal.url = guildUserMedal.getUrl();
        }
    }

    @NotNull
    public static final GProStUser d(@NotNull GProStUser gProStUser, @NotNull String guildId, @NotNull String channelId, @NotNull String id5) {
        AppInterface appInterface;
        Intrinsics.checkNotNullParameter(gProStUser, "<this>");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(id5, "id");
        gProStUser.idd = id5;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService iRuntimeService = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null) {
            a(gProStUser, iGPSService, guildId, id5);
            c(gProStUser, iGPSService, id5);
            f(gProStUser, iGPSService, guildId, id5);
            b(gProStUser, iGPSService, guildId, channelId, id5);
        }
        return gProStUser;
    }

    public static final void e(@NotNull GProStUser gProStUser, @NotNull IGProSimpleProfile simpleProfile, @Nullable IGProGuildRoleInfo iGProGuildRoleInfo, @NotNull String avatarUrl) {
        String str;
        int i3;
        Intrinsics.checkNotNullParameter(gProStUser, "<this>");
        Intrinsics.checkNotNullParameter(simpleProfile, "simpleProfile");
        Intrinsics.checkNotNullParameter(avatarUrl, "avatarUrl");
        gProStUser.idd = String.valueOf(simpleProfile.getTinyId());
        gProStUser.nick = simpleProfile.getDisplayName();
        gProStUser.icon.iconUrl = avatarUrl;
        GProPersonalMedal gProPersonalMedal = gProStUser.personalMedal;
        gProPersonalMedal.startTime = simpleProfile.getPersonalMedal().getStartTime();
        gProPersonalMedal.endTime = simpleProfile.getPersonalMedal().getEndTime();
        gProPersonalMedal.url = simpleProfile.getPersonalMedal().getUrl();
        gProStUser.avatarPendant = simpleProfile.getAvatarPendant();
        GProChannelUserInfo gProChannelUserInfo = gProStUser.channelUserInfo;
        h hVar = h.f112401a;
        IGProClientIdentity clientIdentityBytes = simpleProfile.getClientIdentityBytes();
        Intrinsics.checkNotNullExpressionValue(clientIdentityBytes, "simpleProfile.clientIdentityBytes");
        gProChannelUserInfo.clientIdentityBytes = hVar.F(clientIdentityBytes);
        GProCustomManageTag gProCustomManageTag = gProStUser.manageTag;
        if (iGProGuildRoleInfo == null || (str = iGProGuildRoleInfo.getDisplayTagName()) == null) {
            str = "";
        }
        gProCustomManageTag.tagName = str;
        GProCustomManageTag gProCustomManageTag2 = gProStUser.manageTag;
        if (iGProGuildRoleInfo != null) {
            i3 = iGProGuildRoleInfo.getColor();
        } else {
            i3 = 0;
        }
        gProCustomManageTag2.color = i3;
    }

    private static final void f(GProStUser gProStUser, IGPSService iGPSService, String str, String str2) {
        String guildUserAvatarPendantUrl = iGPSService.getGuildUserAvatarPendantUrl(str2);
        if (guildUserAvatarPendantUrl == null) {
            guildUserAvatarPendantUrl = "";
        }
        gProStUser.avatarPendant = guildUserAvatarPendantUrl;
        IGProClientIdentity guildUserClientIdentity = iGPSService.getGuildUserClientIdentity(str, str2);
        if (guildUserClientIdentity != null) {
            gProStUser.channelUserInfo.clientIdentityBytes = h.f112401a.F(guildUserClientIdentity);
        }
    }
}
