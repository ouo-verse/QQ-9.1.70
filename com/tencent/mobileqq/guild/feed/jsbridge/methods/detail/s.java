package com.tencent.mobileqq.guild.feed.jsbridge.methods.detail;

import android.text.TextUtils;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.guild.feed.event.GuildFeedMoveEvent;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedDetailInitBean;

/* compiled from: P */
/* loaded from: classes13.dex */
public class s extends c {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ok1.a
    public String k() {
        return "moveFeed";
    }

    @Override // ok1.a
    protected boolean o(String str, String str2, String str3) {
        GuildFeedDetailInitBean initBean;
        lj1.a l3 = l();
        if (l3 == null || TextUtils.isEmpty(g("feedId")) || (initBean = l3.getInitBean()) == null) {
            return false;
        }
        SimpleEventBus.getInstance().dispatchEvent(new GuildFeedMoveEvent(g("feedId"), initBean.getGuildId(), initBean.getChannelId()), true);
        l3.finish();
        return false;
    }
}
