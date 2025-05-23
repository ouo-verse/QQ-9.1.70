package dq1;

import android.os.Bundle;
import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.base.extension.r;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.s;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t\u00a8\u0006\u000f"}, d2 = {"Ldq1/k;", "", "", "guildId", "channelId", "Landroid/os/Bundle;", "extras", "Ldq1/c;", "b", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "param", "c", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final k f394610a = new k();

    k() {
    }

    @JvmStatic
    @NotNull
    public static final c b(@NotNull String guildId, @NotNull String channelId, @Nullable Bundle extras) {
        c dVar;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        r rVar = r.f214743a;
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(T::class.java, process)");
        IGProChannelInfo channelInfo = ((IGPSService) S0).getChannelInfo(channelId);
        if (channelInfo == null) {
            return new m();
        }
        int type = channelInfo.getType();
        if (type != 1 && type != 2 && type != 5) {
            if (type != 6) {
                if (type != 7) {
                    if (type != 8) {
                        return new m();
                    }
                } else {
                    dVar = new e(guildId, channelInfo, extras);
                }
            } else {
                dVar = new b(guildId, channelInfo, extras);
            }
            return dVar;
        }
        dVar = new d(guildId, channelInfo, extras);
        return dVar;
    }

    private final c c(JumpGuildParam param) {
        IRuntimeService S0 = ch.S0(IGPSService.class, "Guild.jump.JumpStrategiesFactory");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        IGPSService iGPSService = (IGPSService) S0;
        IGProGuildInfo guildInfo = iGPSService.getGuildInfo(param.guildId);
        if (guildInfo != null) {
            String guildID = guildInfo.getGuildID();
            Intrinsics.checkNotNullExpressionValue(guildID, "guildInfo.guildID");
            if (MiscKt.l(guildID) != 0) {
                if (!guildInfo.getIsValid()) {
                    Logger.f235387a.d().w("Guild.jump.JumpStrategiesFactory", 1, "handleInfoIntercept guild is dissolve. ");
                    return new j(param, 4);
                }
                if (!guildInfo.getIsBanned() && !guildInfo.getIsFrozen()) {
                    if (param.isGuest() && !param.getJoinInfoParam().isValid()) {
                        s.e("Guild.jump.JumpStrategiesFactory", "joinInfoParam is invalid", new IllegalStateException());
                    }
                    if (!guildInfo.isVisibleForVisitor() && param.isGuest()) {
                        Logger.f235387a.d().i("Guild.jump.JumpStrategiesFactory", 1, "handleInfoIntercept can't visit. guildInfo:" + guildInfo);
                        return new g(param);
                    }
                    if (GuildMainFrameUtils.q(param.getChannelId()) || iGPSService.getChannelInfo(param.getChannelId()) != null) {
                        return null;
                    }
                    Logger.f235387a.d().i("Guild.jump.JumpStrategiesFactory", 1, "handleInfoIntercept channelInfo is null " + param.guildId + "-" + param.getChannelId() + "-" + param.businessType);
                    if (param.businessType == 2) {
                        return null;
                    }
                    return new j(param, 2);
                }
                Logger.f235387a.d().w("Guild.jump.JumpStrategiesFactory", 1, "handleInfoIntercept guild is banned. ");
                return new j(param, 1);
            }
        }
        Logger.f235387a.d().w("Guild.jump.JumpStrategiesFactory", 1, "handleInfoIntercept guildInfo is null ");
        param.businessType = 9;
        return new j(param, 0);
    }

    @Nullable
    public final c a(@NotNull JumpGuildParam param) {
        Intrinsics.checkNotNullParameter(param, "param");
        c c16 = c(param);
        if (c16 != null) {
            return c16;
        }
        if (GuildMainFrameUtils.q(param.getChannelId())) {
            return new g(param);
        }
        int i3 = param.businessType;
        if (i3 == 1) {
            return new l(param);
        }
        if (i3 == 2) {
            return new f(param);
        }
        if (ch.D(param.getChannelId()) == 7) {
            return new g(param);
        }
        return null;
    }
}
