package com.tencent.mobileqq.guild.channel.frame.openaction;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.ILaunchGuildChatPieApi;
import com.tencent.mobileqq.guild.channel.frame.openaction.i;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/frame/openaction/h;", "Lcom/tencent/mobileqq/guild/channel/frame/openaction/i;", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "jumpGuildParam", "", "b", "Landroid/content/Context;", "context", "", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class h implements i {
    private final String b(JumpGuildParam jumpGuildParam) {
        if (!jumpGuildParam.isDirectMessage()) {
            String name = com.tencent.guild.aio.factory.a.class.getName();
            Intrinsics.checkNotNullExpressionValue(name, "GuildAIODefaultFactory::class.java.name");
            return name;
        }
        String name2 = com.tencent.qqguild.directmessage.aio.a.class.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "DirectMessageAioFactory::class.java.name");
        return name2;
    }

    @Override // com.tencent.mobileqq.guild.channel.frame.openaction.i
    public boolean a(@NotNull Context context, @NotNull JumpGuildParam jumpGuildParam) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(jumpGuildParam, "jumpGuildParam");
        String str = jumpGuildParam.guildId;
        String channelId = jumpGuildParam.getChannelId();
        Intrinsics.checkNotNullExpressionValue(channelId, "jumpGuildParam.channelId");
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(channelId)) {
            com.tencent.mobileqq.guild.api.i a16 = new com.tencent.mobileqq.guild.api.i().f(str).b(channelId).d(b(jumpGuildParam)).e(c(jumpGuildParam)).a();
            if (GuildSplitViewUtils.f235370a.D(context)) {
                ((ILaunchGuildChatPieApi) QRoute.api(ILaunchGuildChatPieApi.class)).launchGuildChatFragment(context, a16);
            } else {
                Intent guildChatActivityIntent = ((ILaunchGuildChatPieApi) QRoute.api(ILaunchGuildChatPieApi.class)).getGuildChatActivityIntent(context, a16);
                if (guildChatActivityIntent == null) {
                    return false;
                }
                if (!(context instanceof Activity)) {
                    guildChatActivityIntent.addFlags(268435456);
                }
                context.startActivity(guildChatActivityIntent);
                Activity activity = null;
                if (jumpGuildParam.extras.getBoolean("jumpGuildFromLoadingPage", false)) {
                    if (context instanceof Activity) {
                        activity = (Activity) context;
                    }
                    if (activity != null) {
                        activity.overridePendingTransition(R.anim.l_, R.anim.l_);
                    }
                } else {
                    if (context instanceof Activity) {
                        activity = (Activity) context;
                    }
                    if (activity != null) {
                        activity.overridePendingTransition(R.anim.f154619or, R.anim.f154442w);
                    }
                }
            }
            return true;
        }
        QLog.w("Guild.jump.ChannelTextOpenAction", 1, "launchTextChannel: guildId or channelId is null");
        return false;
    }

    @NotNull
    public Bundle c(@NotNull JumpGuildParam jumpGuildParam) {
        return i.a.a(this, jumpGuildParam);
    }
}
