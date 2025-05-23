package com.tencent.mobileqq.guild.channel.frame.openaction;

import android.content.Context;
import com.tencent.mobileqq.guild.base.extension.r;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqecommerce.biz.sdk.api.IQQECommerceSdk;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qroute.QRoute;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \r2\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/frame/openaction/a;", "Lcom/tencent/mobileqq/guild/channel/frame/openaction/i;", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "jumpGuildParam", "", "a", "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "contextRef", "<init>", "()V", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class a implements i {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private WeakReference<Context> contextRef = new WeakReference<>(null);

    @Override // com.tencent.mobileqq.guild.channel.frame.openaction.i
    public boolean a(@NotNull Context context, @NotNull JumpGuildParam jumpGuildParam) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(jumpGuildParam, "jumpGuildParam");
        r rVar = r.f214743a;
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(T::class.java, process)");
        IGProChannelInfo channelInfo = ((IGPSService) S0).getChannelInfo(jumpGuildParam.getChannelId());
        if (channelInfo == null) {
            return false;
        }
        this.contextRef = new WeakReference<>(context);
        if (channelInfo.getAppChannelJumpType() == 1) {
            if (kg1.a.f((int) channelInfo.getApplicationId())) {
                Logger.f235387a.d().i("Guild.jump.AppChannelDefaultOpenAction", 1, "AppChannelDefaultOpenAction::doOpenChannel() jump isEcommerceBusiness");
                IQQECommerceSdk iQQECommerceSdk = (IQQECommerceSdk) QRoute.api(IQQECommerceSdk.class);
                String appChannelJumpUrl = channelInfo.getAppChannelJumpUrl();
                Intrinsics.checkNotNullExpressionValue(appChannelJumpUrl, "channelInfo.appChannelJumpUrl");
                iQQECommerceSdk.handleScheme(appChannelJumpUrl, null);
                return true;
            }
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("AppChannelDefaultOpenAction::doOpenChannel() jumpType is native, not support");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.jump.AppChannelDefaultOpenAction", 1, (String) it.next(), null);
            }
            return false;
        }
        String str = jumpGuildParam.guildId;
        Intrinsics.checkNotNullExpressionValue(str, "jumpGuildParam.guildId");
        new dq1.b(str, channelInfo, jumpGuildParam.extras).jump(context);
        return true;
    }
}
