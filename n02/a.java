package n02;

import com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t02.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\b"}, d2 = {"Ln02/a;", "", "", "channelId", "", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f417922a = new a();

    a() {
    }

    @JvmStatic
    public static final void a(@NotNull String channelId) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.share.GuildRecentTalkChannelHelper", 2, "added recent talked channel record id:" + channelId);
        }
        IGPSService iGPSService = (IGPSService) ch.R0(IGPSService.class);
        IGProChannelInfo channelInfo = iGPSService.getChannelInfo(channelId);
        if (channelInfo == null) {
            return;
        }
        boolean z16 = true;
        if (channelInfo.getType() != 1) {
            return;
        }
        IGProGuildInfo guildInfo = iGPSService.getGuildInfo(channelInfo.getGuildId());
        if (guildInfo == null || !guildInfo.isMember()) {
            z16 = false;
        }
        if (!z16) {
            return;
        }
        c cVar = new c(((IQQGuildSPUtilsApi) QRoute.api(IQQGuildSPUtilsApi.class)).getRecentTalkedChannelsWithTime());
        cVar.a(channelId);
        ((IQQGuildSPUtilsApi) QRoute.api(IQQGuildSPUtilsApi.class)).setRecentTalkedChannelsWithTime(cVar.toString());
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.share.GuildRecentTalkChannelHelper", 2, "Recent channels after add:" + cVar);
        }
    }
}
