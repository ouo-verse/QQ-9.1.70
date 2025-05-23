package com.tencent.mobileqq.guild.feed.jsbridge.methods.detail;

import androidx.annotation.Keep;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.guild.feed.event.GuildFeedDetailClickPreferEvent;
import com.tencent.mobileqq.guild.feed.event.GuildFeedUpdatePreferEvent;
import java.util.ArrayList;

/* loaded from: classes13.dex */
public class UpdateDoPreferMethod extends b {

    /* renamed from: h, reason: collision with root package name */
    public static String f220004h = "feedId";

    /* renamed from: i, reason: collision with root package name */
    public static String f220005i = "preferCountWithoutLike";

    /* renamed from: m, reason: collision with root package name */
    public static String f220006m = "preferStatus";

    @Keep
    /* loaded from: classes13.dex */
    static class Result {

        @SerializedName("action")
        public int mAction;

        public Result(int i3) {
            this.mAction = i3;
        }

        public String toJson() {
            return new Gson().toJson(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ok1.a
    public String k() {
        return "updatePrefer";
    }

    @Override // ok1.a
    protected boolean o(String str, String str2, String str3) {
        SimpleEventBus.getInstance().dispatchEvent(new GuildFeedUpdatePreferEvent(g(f220004h), d(f220005i), d(f220006m)), true);
        return true;
    }

    @Override // com.tencent.mobileqq.guild.feed.jsbridge.methods.detail.b
    protected ArrayList<Class> p() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(GuildFeedDetailClickPreferEvent.class);
        return arrayList;
    }

    @Override // com.tencent.mobileqq.guild.feed.jsbridge.methods.detail.b
    protected void q(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof GuildFeedDetailClickPreferEvent) {
            int preferAction = ((GuildFeedDetailClickPreferEvent) simpleBaseEvent).getPreferAction();
            hj1.b.b("Guild_Feed_UpdateDoPreferMethod", "onReceiveEventBusEvent: PreferActtion [" + preferAction + "]");
            i(new Result(preferAction).toJson());
        }
    }
}
