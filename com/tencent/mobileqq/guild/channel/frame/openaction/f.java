package com.tencent.mobileqq.guild.channel.frame.openaction;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.channel.frame.openaction.i;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.live.model.GLiveChannelStartParams;
import com.tencent.mobileqq.guild.main.data.QQGuildChannelLive;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.security.GuildChannelSwitchManager;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/frame/openaction/f;", "Lcom/tencent/mobileqq/guild/channel/frame/openaction/i;", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "jumpGuildParam", "", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class f implements i {
    @Override // com.tencent.mobileqq.guild.channel.frame.openaction.i
    public boolean a(@NotNull Context context, @NotNull JumpGuildParam jumpGuildParam) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(jumpGuildParam, "jumpGuildParam");
        String guildId = jumpGuildParam.guildId;
        String channelId = jumpGuildParam.getChannelId();
        Intrinsics.checkNotNullExpressionValue(channelId, "jumpGuildParam.channelId");
        Intrinsics.checkNotNullExpressionValue(guildId, "guildId");
        if (!GuildChannelSwitchManager.d(guildId)) {
            QLog.e("Guild.jump.ChannelLiveOpenAction", 1, "launchLiveChannel, live channel is unable.");
            return false;
        }
        IGProChannelInfo C = ch.C(ch.m(), guildId, channelId);
        if (C == null) {
            com.tencent.mobileqq.guild.util.qqui.g.b(R.string.f156611ko);
            QLog.e("Guild.jump.ChannelLiveOpenAction", 1, "launchLiveChannel, channelInfo == null, return.");
            return false;
        }
        GLiveChannelStartParams e16 = GLiveChannelStartParams.INSTANCE.e(C, new QQGuildChannelLive(new com.tencent.mobileqq.guild.main.data.c(C, C.getCategoryName(), C.getCategoryId())));
        Bundle bundle = o02.a.d(new Bundle());
        bundle.putString("guild_id", guildId);
        bundle.putAll(b(jumpGuildParam));
        Intrinsics.checkNotNullExpressionValue(bundle, "bundle");
        e16.setBundle(bundle);
        boolean e17 = gq1.c.e(e16);
        if (QLog.isColorLevel()) {
            QLog.d("Guild.jump.ChannelLiveOpenAction", 2, "handleClickLiveChannelItem ChannelUin:", channelId);
        }
        return e17;
    }

    @NotNull
    public Bundle b(@NotNull JumpGuildParam jumpGuildParam) {
        return i.a.a(this, jumpGuildParam);
    }
}
