package com.tencent.mobileqq.guild.feed.jsbridge.methods.detail;

import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.guild.feed.event.GuildFeedDeleteEvent;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedDetailInitBean;
import com.tencent.mobileqq.guild.ipc.methods.GuildDeleteFeedIPCMethod;

/* compiled from: P */
/* loaded from: classes13.dex */
public class e extends c {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ok1.a
    public String k() {
        return "finishDeleteFeed";
    }

    @Override // ok1.a
    protected boolean o(String str, String str2, String str3) {
        GuildFeedDetailInitBean initBean;
        lj1.a l3 = l();
        if (l3 == null || (initBean = l3.getInitBean()) == null) {
            return false;
        }
        SimpleEventBus.getInstance().dispatchEvent(new GuildFeedDeleteEvent(g("feedId"), initBean.getGuildId(), initBean.getChannelId()), true);
        l3.finish();
        com.tencent.mobileqq.guild.util.y.b(GuildDeleteFeedIPCMethod.class, null, g("guildId"), g("channelId"), g("posterTinyId"));
        return false;
    }
}
