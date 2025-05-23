package com.tencent.mobileqq.guild.feed.jsbridge.methods.detail;

import androidx.annotation.Keep;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.guild.feed.event.GuildFeedDetailClickLikeEvent;
import com.tencent.mobileqq.guild.feed.event.GuildFeedUpdateLikeEvent;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes13.dex */
public class UpdateDoLikeMethod extends b {

    /* renamed from: h, reason: collision with root package name */
    public static String f220001h = "feedId";

    /* renamed from: i, reason: collision with root package name */
    public static String f220002i = "doLikeCount";

    /* renamed from: m, reason: collision with root package name */
    public static String f220003m = "isClicked";

    /* compiled from: P */
    @Keep
    /* loaded from: classes13.dex */
    static class Result {

        @SerializedName("likeType")
        public int mLikeType;

        public Result(int i3) {
            this.mLikeType = i3;
        }

        public String toJson() {
            return new Gson().toJson(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ok1.a
    public String k() {
        return "updateDolike";
    }

    @Override // ok1.a
    protected boolean o(String str, String str2, String str3) {
        SimpleEventBus.getInstance().dispatchEvent(new GuildFeedUpdateLikeEvent(g(f220001h), d(f220002i), b(f220003m)), true);
        return true;
    }

    @Override // com.tencent.mobileqq.guild.feed.jsbridge.methods.detail.b
    protected ArrayList<Class> p() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(GuildFeedDetailClickLikeEvent.class);
        return arrayList;
    }

    @Override // com.tencent.mobileqq.guild.feed.jsbridge.methods.detail.b
    protected void q(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof GuildFeedDetailClickLikeEvent) {
            boolean isLike = ((GuildFeedDetailClickLikeEvent) simpleBaseEvent).isLike();
            hj1.b.b("Guild_Feed_UpdateDoLikeMethod", "onReceiveEventBusEvent: isLike[" + isLike + "]");
            i(new Result(isLike ? 1 : 0).toJson());
        }
    }
}
