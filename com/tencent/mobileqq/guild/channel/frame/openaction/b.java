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
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.debug.GuildJumpDebugUtils;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/frame/openaction/b;", "Lcom/tencent/mobileqq/guild/channel/frame/openaction/i;", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "jumpGuildParam", "", "d", "", "b", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class b implements i {
    private final String b(JumpGuildParam jumpGuildParam) {
        int i3;
        IGuildFeatureAdapterApi iGuildFeatureAdapterApi = (IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class);
        IGProChannelInfo B = ch.B(jumpGuildParam.getChannelId());
        if (B != null) {
            i3 = (int) B.getApplicationId();
        } else {
            i3 = 0;
        }
        String transFactoryName = iGuildFeatureAdapterApi.transFactoryName(i3);
        Intrinsics.checkNotNullExpressionValue(transFactoryName, "api(IGuildFeatureAdapter\u2026licationId?.toInt() ?: 0)");
        return transFactoryName;
    }

    private final boolean d(Context context, JumpGuildParam jumpGuildParam) {
        Activity activity;
        com.tencent.mobileqq.guild.api.i a16 = new com.tencent.mobileqq.guild.api.i().f(jumpGuildParam.guildId).b(jumpGuildParam.getChannelId()).d(b(jumpGuildParam)).e(c(jumpGuildParam)).a();
        GuildJumpDebugUtils.a("GUILD_JUMP", "AppChannelTextOpenAction::launchTextChannel() launchParam = ", a16);
        if (GuildSplitViewUtils.f235370a.D(context) && jumpGuildParam.getChannelLoadFrom() != 3) {
            ((ILaunchGuildChatPieApi) QRoute.api(ILaunchGuildChatPieApi.class)).launchGuildChatFragment(context, a16);
            return true;
        }
        Intent guildChatActivityIntent = ((ILaunchGuildChatPieApi) QRoute.api(ILaunchGuildChatPieApi.class)).getGuildChatActivityIntent(context, a16);
        if (guildChatActivityIntent == null) {
            return false;
        }
        if (!(context instanceof Activity)) {
            guildChatActivityIntent.addFlags(268435456);
        }
        context.startActivity(guildChatActivityIntent);
        if (jumpGuildParam.extras.getBoolean("jumpGuildFromLoadingPage", false)) {
            if (context instanceof Activity) {
                activity = (Activity) context;
            } else {
                activity = null;
            }
            if (activity != null) {
                activity.overridePendingTransition(R.anim.l_, R.anim.l_);
                return true;
            }
            return true;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.guild.channel.frame.openaction.i
    public boolean a(@NotNull Context context, @NotNull JumpGuildParam jumpGuildParam) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(jumpGuildParam, "jumpGuildParam");
        String str = jumpGuildParam.guildId;
        String channelId = jumpGuildParam.getChannelId();
        Intrinsics.checkNotNullExpressionValue(channelId, "jumpGuildParam.channelId");
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(channelId)) {
            return d(context, jumpGuildParam);
        }
        Logger.f235387a.d().w("Guild.jump.ChannelTextOpenAction", 1, "launchTextChannel: guildId or channelId is null");
        return false;
    }

    @NotNull
    public Bundle c(@NotNull JumpGuildParam jumpGuildParam) {
        return i.a.a(this, jumpGuildParam);
    }
}
