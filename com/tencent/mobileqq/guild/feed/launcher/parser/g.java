package com.tencent.mobileqq.guild.feed.launcher.parser;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedSchemeBean;
import com.tencent.mobileqq.guild.jump.GuildJumpUtil;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;

/* compiled from: P */
/* loaded from: classes13.dex */
public class g extends a {
    @Override // com.tencent.mobileqq.guild.feed.launcher.parser.a
    public void b(Context context, GuildFeedSchemeBean guildFeedSchemeBean) {
        if (guildFeedSchemeBean != null && guildFeedSchemeBean.getAttrs() != null) {
            String a16 = a(guildFeedSchemeBean.getAttrs(), com.tencent.mobileqq.guild.feed.b.f218117c);
            String a17 = a(guildFeedSchemeBean.getAttrs(), com.tencent.mobileqq.guild.feed.b.f218119e);
            String a18 = a(guildFeedSchemeBean.getAttrs(), com.tencent.mobileqq.guild.feed.b.f218118d);
            Bundle bundle = new Bundle();
            bundle.putString("guild_id", a16);
            bundle.putString("uin", a17);
            bundle.putInt("channel_type", 7);
            bundle.putString("channel_name", a18);
            JumpGuildParam jumpGuildParam = new JumpGuildParam(a16, a17);
            jumpGuildParam.extras.putAll(bundle);
            GuildJumpUtil.n(context, jumpGuildParam);
        }
    }
}
