package com.tencent.mobileqq.guild.api.impl;

import com.tencent.mobileqq.guild.api.IGuildRoleGroupApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J*\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0012\u0010\u0012\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0013\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0004\u001a\u00020\u0002H\u0016R\u0014\u0010\u0014\u001a\u00020\u00078\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/api/impl/GuildRoleGroupApiImpl;", "Lcom/tencent/mobileqq/guild/api/IGuildRoleGroupApi;", "", "allSwitch", "switchType", "", "isSwitchOpen", "", "guildId", "tinyId", "levelRoleId", "Lcom/tencent/mobileqq/guild/api/IGuildRoleGroupApi$a;", "roleInfoCallback", "", "getLevelRoleInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "getIsVisitorOperate", "getVisibleForVisitor", "getIsOperate", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GuildRoleGroupApiImpl implements IGuildRoleGroupApi {

    @NotNull
    private final String TAG = "GuildRoleGroupApiImpl";

    private final boolean isSwitchOpen(int allSwitch, int switchType) {
        if (((allSwitch >> switchType) & 1) == 1) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildRoleGroupApi
    public boolean getIsOperate(@Nullable IGProGuildInfo guildInfo, int switchType) {
        if (guildInfo == null) {
            Logger logger = Logger.f235387a;
            logger.d().d(this.TAG, 1, "getIsOperate guildInfo is null");
            return false;
        }
        int visitorInteractionAllSwitch = guildInfo.getVisitorInteractionAllSwitch();
        boolean isSwitchOpen = isSwitchOpen(visitorInteractionAllSwitch, 5);
        boolean isSwitchOpen2 = isSwitchOpen(visitorInteractionAllSwitch, switchType);
        if (!isSwitchOpen || !isSwitchOpen2) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildRoleGroupApi
    public boolean getIsVisitorOperate(@Nullable IGProGuildInfo guildInfo, int switchType) {
        if (guildInfo == null || !getIsOperate(guildInfo, switchType) || guildInfo.isMember()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildRoleGroupApi
    public void getLevelRoleInfo(@NotNull String guildId, @NotNull String tinyId, @NotNull String levelRoleId, @Nullable IGuildRoleGroupApi.a roleInfoCallback) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        Intrinsics.checkNotNullParameter(levelRoleId, "levelRoleId");
        IGProGuildRoleInfo memberLevelRole = ((IGPSService) ch.R0(IGPSService.class)).getMemberLevelRole(guildId, tinyId, levelRoleId);
        if (roleInfoCallback != null) {
            roleInfoCallback.a(memberLevelRole);
        }
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildRoleGroupApi
    public boolean getVisibleForVisitor(@Nullable IGProGuildInfo guildInfo) {
        if (guildInfo == null) {
            Logger logger = Logger.f235387a;
            logger.d().d(this.TAG, 1, "getVisibleForVisitor guildInfo is null");
            return false;
        }
        return isSwitchOpen(guildInfo.getVisitorInteractionAllSwitch(), 5);
    }
}
