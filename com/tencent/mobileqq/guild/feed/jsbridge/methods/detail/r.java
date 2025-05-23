package com.tencent.mobileqq.guild.feed.jsbridge.methods.detail;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.tencent.biz.pubaccount.weishi.WSAutoShowCommentParams;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.guild.event.GuildOpenUserProfileEvent;
import com.tencent.mobileqq.guild.feed.FeedImpeachData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes13.dex */
public class r extends b {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class a {

        @SerializedName("atType")
        public int atType;

        a(int i3) {
            this.atType = i3;
        }

        public String a() {
            return new Gson().toJson(this);
        }
    }

    private void r(Boolean bool) {
        i(new a(bool.booleanValue() ? 1 : 0).a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ok1.a
    public String k() {
        return "jumpToUserSummary";
    }

    @Override // ok1.a
    protected boolean o(String str, String str2, String str3) {
        FeedImpeachData feedImpeachData;
        lj1.a l3 = l();
        if (l3 == null) {
            return false;
        }
        int d16 = d("impeachType");
        String g16 = g("feedId");
        String g17 = g(WSAutoShowCommentParams.KEY_COMMENT_ID);
        String g18 = g(WSAutoShowCommentParams.KEY_REPLY_ID);
        QLog.i("Guild_Feed_BaseGuildJsBridgeMethod", 1, "JumpToUserSummaryMethod impeachType:" + d16 + " feedId:" + g16 + " commentId:" + g17 + " replyId:" + g18);
        if (d16 != 0) {
            if (d16 != 1) {
                if (d16 == 2 && !TextUtils.isEmpty(g16) && !TextUtils.isEmpty(g17) && !TextUtils.isEmpty(g18)) {
                    feedImpeachData = new FeedImpeachData(d16, g16, g17, g18);
                }
                feedImpeachData = null;
            } else {
                if (!TextUtils.isEmpty(g16) && !TextUtils.isEmpty(g17)) {
                    feedImpeachData = new FeedImpeachData(d16, g16, g17, "");
                }
                feedImpeachData = null;
            }
        } else {
            if (!TextUtils.isEmpty(g16)) {
                feedImpeachData = new FeedImpeachData(d16, g16, "", "");
            }
            feedImpeachData = null;
        }
        l3.jumpUserSummary(g("guild_id"), g("channel_id"), g("tinyID"), d("business"), g("uin"), g("groupCode"), feedImpeachData);
        return true;
    }

    @Override // com.tencent.mobileqq.guild.feed.jsbridge.methods.detail.b
    protected ArrayList<Class> p() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(GuildOpenUserProfileEvent.class);
        return arrayList;
    }

    @Override // com.tencent.mobileqq.guild.feed.jsbridge.methods.detail.b
    protected void q(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof GuildOpenUserProfileEvent) {
            r(((GuildOpenUserProfileEvent) simpleBaseEvent).isRobot);
        }
    }
}
