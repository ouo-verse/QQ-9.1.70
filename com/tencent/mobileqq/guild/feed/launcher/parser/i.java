package com.tencent.mobileqq.guild.feed.launcher.parser;

import android.content.Context;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedLauncher;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedPublishInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedSchemeBean;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes13.dex */
public class i extends a {
    @Override // com.tencent.mobileqq.guild.feed.launcher.parser.a
    public void b(Context context, GuildFeedSchemeBean guildFeedSchemeBean) {
        if (guildFeedSchemeBean != null && guildFeedSchemeBean.getAttrs() != null) {
            String a16 = a(guildFeedSchemeBean.getAttrs(), com.tencent.mobileqq.guild.feed.b.f218117c);
            String a17 = a(guildFeedSchemeBean.getAttrs(), com.tencent.mobileqq.guild.feed.b.f218119e);
            String u16 = ax.u();
            String guildUserDisplayName = ((IGPSService) ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).runtimeService(IGPSService.class)).getGuildUserDisplayName(a16, u16);
            GuildFeedPublishInitBean guildFeedPublishInitBean = new GuildFeedPublishInitBean();
            guildFeedPublishInitBean.setGuildId(a16);
            guildFeedPublishInitBean.setChannelId(a17);
            guildFeedPublishInitBean.setTinyId(u16);
            guildFeedPublishInitBean.setNickName(guildUserDisplayName);
            GuildFeedBaseInitBean q16 = ax.q(context);
            if (q16 != null) {
                guildFeedPublishInitBean.setBusinessType(q16.getBusinessType());
                guildFeedPublishInitBean.setTroopUin(q16.getTroopUin());
                guildFeedPublishInitBean.setTroopRole(q16.getTroopRole());
                guildFeedPublishInitBean.setFeedReportSourceInfo(q16.getFeedReportSourceInfo());
            }
            GuildFeedLauncher.A(context, guildFeedPublishInitBean);
        }
    }
}
