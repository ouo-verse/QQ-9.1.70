package com.tencent.mobileqq.guild.util;

import com.tencent.mobileqq.guild.api.IGuildInfoUtilsApi;
import com.tencent.mobileqq.guild.rolegroup.model.data.Permissions;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.type.IPermissionType;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J \u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0007J*\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0007J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0002J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0002J\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0002J\u0018\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0002J\u0018\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0002J\u0018\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0002J\u0018\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0002J$\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\u001b\u001a\u00020\u0006H\u0002J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0018\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0002\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/util/as;", "", "", "guildId", "", "type", "", tl.h.F, "channelId", "i", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "channelInfo", "j", "channelType", "", "appId", "k", "f", "b", "a", "c", "e", "g", "d", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/c;", "permissionsModel", "isSpeak", "isNotify", "l", DomainData.DOMAIN_NAME, "o", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class as {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final as f235447a = new as();

    as() {
    }

    private final boolean a(String guildId, String channelId) {
        Permissions channelPermission = com.tencent.mobileqq.guild.rolegroup.model.repositories.s.a().getChannelPermission(guildId, channelId);
        if (!channelPermission.a(20012) && !m(this, channelPermission, true, false, 4, null)) {
            return false;
        }
        return true;
    }

    private final boolean b(String guildId, String channelId) {
        Permissions channelPermission = com.tencent.mobileqq.guild.rolegroup.model.repositories.s.a().getChannelPermission(guildId, channelId);
        if (channelPermission.a(20011) || l(channelPermission, true, true)) {
            return true;
        }
        return false;
    }

    private final boolean c(String guildId, String channelId) {
        Permissions channelPermission = com.tencent.mobileqq.guild.rolegroup.model.repositories.s.a().getChannelPermission(guildId, channelId);
        if (channelPermission.a(20013) || l(channelPermission, true, true)) {
            return true;
        }
        return false;
    }

    private final boolean d(String guildId, String channelId) {
        return l(com.tencent.mobileqq.guild.rolegroup.model.repositories.s.a().getChannelPermission(guildId, channelId), true, true);
    }

    private final boolean e(String guildId, String channelId) {
        Permissions channelPermission = com.tencent.mobileqq.guild.rolegroup.model.repositories.s.a().getChannelPermission(guildId, channelId);
        if (channelPermission.a(20014) || l(channelPermission, true, true)) {
            return true;
        }
        return false;
    }

    private final boolean f(String guildId, String channelId) {
        Permissions channelPermission = com.tencent.mobileqq.guild.rolegroup.model.repositories.s.a().getChannelPermission(guildId, channelId);
        if (channelPermission.a(20010) || l(channelPermission, true, true)) {
            return true;
        }
        return false;
    }

    private final boolean g(String guildId, String channelId) {
        Permissions channelPermission = com.tencent.mobileqq.guild.rolegroup.model.repositories.s.a().getChannelPermission(guildId, channelId);
        if (channelPermission.a(20015) || l(channelPermission, true, true)) {
            return true;
        }
        return false;
    }

    @JvmStatic
    public static final boolean h(@NotNull String guildId, int type) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        return com.tencent.mobileqq.guild.rolegroup.model.repositories.s.a().getGuildPermission(guildId).a(type);
    }

    @JvmStatic
    public static final boolean i(@NotNull String guildId, @NotNull String channelId, int type) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        return com.tencent.mobileqq.guild.rolegroup.model.repositories.s.a().getChannelPermission(guildId, channelId).a(type);
    }

    @JvmStatic
    public static final boolean j(@NotNull IGProChannelInfo channelInfo) {
        Intrinsics.checkNotNullParameter(channelInfo, "channelInfo");
        String guildId = channelInfo.getGuildId();
        Intrinsics.checkNotNullExpressionValue(guildId, "channelInfo.guildId");
        String channelUin = channelInfo.getChannelUin();
        Intrinsics.checkNotNullExpressionValue(channelUin, "channelInfo.channelUin");
        return k(guildId, channelUin, channelInfo.getType(), channelInfo.getApplicationId());
    }

    @JvmStatic
    public static final boolean k(@NotNull String guildId, @NotNull String channelId, int channelType, long appId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        if (channelType != 1) {
            if (channelType != 2) {
                if (channelType != 5) {
                    if (channelType != 6) {
                        if (channelType != 7) {
                            if (channelType != 8) {
                                return false;
                            }
                            return f235447a.a(guildId, channelId);
                        }
                        return f235447a.b(guildId, channelId);
                    }
                    if (appId == 1000050) {
                        return f235447a.e(guildId, channelId);
                    }
                    as asVar = f235447a;
                    if (asVar.o(guildId, channelId)) {
                        return asVar.g(guildId, channelId);
                    }
                    return asVar.d(guildId, channelId);
                }
                return f235447a.c(guildId, channelId);
            }
            return f235447a.a(guildId, channelId);
        }
        return f235447a.f(guildId, channelId);
    }

    private final boolean l(Permissions permissionsModel, boolean isSpeak, boolean isNotify) {
        if ((isSpeak && permissionsModel.a(IPermissionType.MODIFY_CHANNEL_SPEAK)) || ((isNotify && ch.n0(permissionsModel.getGId())) || n(permissionsModel))) {
            return true;
        }
        return false;
    }

    static /* synthetic */ boolean m(as asVar, Permissions permissions, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        if ((i3 & 4) != 0) {
            z17 = false;
        }
        return asVar.l(permissions, z16, z17);
    }

    private final boolean n(Permissions permissionsModel) {
        if (!permissionsModel.a(20003) && !permissionsModel.a(70005) && !permissionsModel.a(IPermissionType.MODIFY_CHANNEL_VIEW) && !permissionsModel.a(20002)) {
            return false;
        }
        return true;
    }

    private final boolean o(String guildId, String channelId) {
        return ((IGuildInfoUtilsApi) QRoute.api(IGuildInfoUtilsApi.class)).isSupportTextChannleAbility(((IGuildInfoUtilsApi) QRoute.api(IGuildInfoUtilsApi.class)).getChannelType(ch.l(), guildId, channelId));
    }
}
