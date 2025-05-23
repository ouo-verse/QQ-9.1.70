package hi1;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.guild.api.ILaunchGuildChatPieApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lhi1/f;", "Lhi1/g;", "Landroid/content/Context;", "context", "Landroid/os/Bundle;", "bundle", "", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class f implements g {
    @Override // hi1.g
    public void a(@NotNull Context context, @NotNull Bundle bundle) {
        boolean z16;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        String guildId = bundle.getString("guildId", "");
        String channelId = bundle.getString("channelId", "");
        Intrinsics.checkNotNullExpressionValue(guildId, "guildId");
        boolean z17 = false;
        if (guildId.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            Intrinsics.checkNotNullExpressionValue(channelId, "channelId");
            if (channelId.length() > 0) {
                z17 = true;
            }
            if (z17) {
                IRuntimeService runtimeService = ch.m().getRuntimeService(IGPSService.class, "");
                Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime().getRuntimeS\u2026va, ProcessConstant.MAIN)");
                IGPSService iGPSService = (IGPSService) runtimeService;
                ((ILaunchGuildChatPieApi) QRoute.api(ILaunchGuildChatPieApi.class)).launchMediaChannel(context, iGPSService.getGuildInfo(guildId), iGPSService.getChannelInfo(channelId), bundle);
                return;
            }
        }
        Logger.f235387a.d().d("", 1, "handleAction params error");
    }
}
