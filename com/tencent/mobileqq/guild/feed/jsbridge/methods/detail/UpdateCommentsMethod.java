package com.tencent.mobileqq.guild.feed.jsbridge.methods.detail;

import androidx.annotation.Keep;
import com.google.gson.Gson;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.guild.feed.event.GuildFeedDetailClickCommentEvent;
import com.tencent.mobileqq.guild.feed.event.GuildFeedUpdateCommentsEvent;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes13.dex */
public class UpdateCommentsMethod extends b {

    /* compiled from: P */
    @Keep
    /* loaded from: classes13.dex */
    static class Result {
        public String toJson() {
            return new Gson().toJson(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ok1.a
    public String k() {
        return "updateComments";
    }

    @Override // ok1.a
    protected boolean o(String str, String str2, String str3) {
        if (l() == null) {
            return false;
        }
        SimpleEventBus.getInstance().dispatchEvent(new GuildFeedUpdateCommentsEvent(g("feedId"), d("commentCount")), true);
        return true;
    }

    @Override // com.tencent.mobileqq.guild.feed.jsbridge.methods.detail.b
    protected ArrayList<Class> p() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(GuildFeedDetailClickCommentEvent.class);
        return arrayList;
    }

    @Override // com.tencent.mobileqq.guild.feed.jsbridge.methods.detail.b
    protected void q(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof GuildFeedDetailClickCommentEvent) {
            hj1.b.b("Guild_Feed_BaseGuildJsBridgeMethod", "onReceiveEventBusEvent: ");
            i(new Result().toJson());
        }
    }
}
