package com.tencent.mobileqq.guild.feed.jsbridge.methods.detail;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.guild.feed.event.GuildPublishReEditEvent;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedDetailInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedPublishEditPostInitBean;
import com.tencent.mobileqq.guild.feed.manager.GuildFeedDetailDataCacheManager;
import com.tencent.mobileqq.guild.feed.publish.event.GuildTriggerPublishOperationEvent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes13.dex */
public class JumpToEditorMethod extends b {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Keep
    /* loaded from: classes13.dex */
    public static class Result {

        @SerializedName("message")
        public String mMessage;

        @SerializedName("postRes")
        public boolean mPostRes;

        @SerializedName("type")
        public String mType;

        public Result(String str, boolean z16, String str2) {
            this.mType = str;
            this.mPostRes = z16;
            this.mMessage = str2;
        }

        public String toJson() {
            return "{\"data\":" + new Gson().toJson(this) + "}";
        }
    }

    private void r(GuildPublishReEditEvent guildPublishReEditEvent) {
        boolean z16;
        if (l() != null) {
            l().deleteLocalCache();
            if (guildPublishReEditEvent.getCode() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            i(new Result("result", z16, guildPublishReEditEvent.getMsg()).toJson());
        }
    }

    private void s() {
        i(new Result("exit", false, "").toJson());
    }

    private boolean t() {
        GuildFeedDetailInitBean initBean;
        lj1.a l3 = l();
        if (l3 == null || (initBean = l3.getInitBean()) == null) {
            return false;
        }
        String feedId = initBean.getFeedId();
        if (!TextUtils.equals(feedId, g("feedId"))) {
            return false;
        }
        String g16 = g("jsonFeed");
        if (TextUtils.isEmpty(g16)) {
            QLog.d("Guild_Feed_BaseGuildJsBridgeMethod", 1, "jumpNativePublish jsonFeed is empty! use cache.");
            g16 = GuildFeedDetailDataCacheManager.y().q(feedId, initBean.getLastModifiedTime());
        }
        String str = g16;
        if (TextUtils.isEmpty(str)) {
            QLog.d("Guild_Feed_BaseGuildJsBridgeMethod", 1, "jumpNativePublish jsonFeed is empty! return.");
            return false;
        }
        initBean.getFeedReportSourceInfo().addReportItem("extra_feeds_page_id", "pg_sgrp_forumshared_joined");
        l3.jumpNativePublish(g("guild_id"), g("channel_id"), str, feedId, initBean.getBusinessType(), initBean.getTroopUin(), initBean.getTroopRole(), initBean.getFeedReportSourceInfo());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ok1.a
    public String k() {
        return "jumpToEditor";
    }

    @Override // ok1.a
    protected boolean o(String str, String str2, String str3) {
        lj1.a l3 = l();
        if (l3 == null) {
            return false;
        }
        if (d("feedType") == 1 && t()) {
            return true;
        }
        GuildFeedDetailInitBean initBean = l3.getInitBean();
        if (initBean == null) {
            return false;
        }
        String g16 = g("posterTinyId");
        GuildFeedPublishEditPostInitBean guildFeedPublishEditPostInitBean = new GuildFeedPublishEditPostInitBean();
        guildFeedPublishEditPostInitBean.setGuildId(g("guild_id"));
        guildFeedPublishEditPostInitBean.setChannelId(g("channel_id"));
        guildFeedPublishEditPostInitBean.setTinyId(g16);
        guildFeedPublishEditPostInitBean.setNickName(g("nickName"));
        guildFeedPublishEditPostInitBean.setFeedId(g("feedId"));
        guildFeedPublishEditPostInitBean.setExInfo(g("extraInfo"));
        guildFeedPublishEditPostInitBean.setCreateTime(f(WadlProxyConsts.CREATE_TIME));
        guildFeedPublishEditPostInitBean.setSourceType(initBean.getSourceType());
        guildFeedPublishEditPostInitBean.setBusinessType(initBean.getBusinessType());
        guildFeedPublishEditPostInitBean.setTroopUin(initBean.getTroopUin());
        guildFeedPublishEditPostInitBean.setTroopRole(initBean.getTroopRole());
        guildFeedPublishEditPostInitBean.setPosterTinyId(g16);
        guildFeedPublishEditPostInitBean.setFeedReportSourceInfo(initBean.getFeedReportSourceInfo());
        l3.jumpPublish(guildFeedPublishEditPostInitBean);
        return true;
    }

    @Override // com.tencent.mobileqq.guild.feed.jsbridge.methods.detail.b
    public ArrayList<Class> p() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(GuildPublishReEditEvent.class);
        arrayList.add(GuildTriggerPublishOperationEvent.class);
        return arrayList;
    }

    @Override // com.tencent.mobileqq.guild.feed.jsbridge.methods.detail.b
    public void q(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof GuildPublishReEditEvent) {
            r((GuildPublishReEditEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof GuildTriggerPublishOperationEvent) {
            s();
        }
    }
}
