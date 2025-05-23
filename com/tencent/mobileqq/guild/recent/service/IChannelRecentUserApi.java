package com.tencent.mobileqq.guild.recent.service;

import android.content.Context;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.qqguildsdk.data.fk;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {""})
/* loaded from: classes14.dex */
public interface IChannelRecentUserApi extends QRouteApi {
    void cancelSubscribeChannel(AppRuntime appRuntime, Context context, String str, String str2);

    boolean channelIsInRecentUserCache(AppRuntime appRuntime, String str);

    int getChannelTypeIcon(int i3);

    fk getQQMsgListChannel(AppRuntime appRuntime, String str, String str2);

    RecentUserProxy getRecentUserProxy(AppRuntime appRuntime);

    String getWelcomeMsgForRecentList(AppRuntime appRuntime, String str);

    void refreshMsgListChannelForRecentList(AppRuntime appRuntime);

    boolean tryToAddAndShowChannelInRecentList(AppRuntime appRuntime, fk fkVar);

    void tryToAddChannelsInRecentList(AppRuntime appRuntime, List<fk> list);

    boolean tryToRefreshChannelInRecentList(AppRuntime appRuntime, fk fkVar);

    boolean tryToRemoveChannelInRecentUserCache(AppRuntime appRuntime, String str);

    boolean tryToSetTopChannelInRecentUserCache(AppRuntime appRuntime, String str, long j3);

    boolean tryToUnsetTopChannelInRecentUserCache(AppRuntime appRuntime, String str);
}
