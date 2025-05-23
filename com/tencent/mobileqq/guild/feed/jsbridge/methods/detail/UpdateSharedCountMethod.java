package com.tencent.mobileqq.guild.feed.jsbridge.methods.detail;

import androidx.annotation.Keep;
import com.google.gson.Gson;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.guild.feed.event.GuildFeedDetailClickShareEvent;
import com.tencent.mobileqq.guild.feed.event.GuildFeedUpdateSharedCountEvent;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes13.dex */
public class UpdateSharedCountMethod extends b {

    /* renamed from: h, reason: collision with root package name */
    public static String f220007h = "feedId";

    /* renamed from: i, reason: collision with root package name */
    public static String f220008i = "sharedCount";

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
        return "updateSharedCount";
    }

    @Override // ok1.a
    protected boolean o(String str, String str2, String str3) {
        SimpleEventBus.getInstance().dispatchEvent(new GuildFeedUpdateSharedCountEvent(g(f220007h), d(f220008i)), true);
        return true;
    }

    @Override // com.tencent.mobileqq.guild.feed.jsbridge.methods.detail.b
    protected ArrayList<Class> p() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(GuildFeedDetailClickShareEvent.class);
        return arrayList;
    }

    @Override // com.tencent.mobileqq.guild.feed.jsbridge.methods.detail.b
    protected void q(SimpleBaseEvent simpleBaseEvent) {
        lj1.a l3 = l();
        if ((simpleBaseEvent instanceof GuildFeedDetailClickShareEvent) && l3 != null && l3.hashCode() == simpleBaseEvent.mHashCode) {
            hj1.b.b("Guild_Feed_UpdateDoLikeMethod", "onReceiveEventBusEvent: ");
            i(new Result().toJson());
        }
    }
}
