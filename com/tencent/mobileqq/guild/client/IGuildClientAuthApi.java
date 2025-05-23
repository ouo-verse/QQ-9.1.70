package com.tencent.mobileqq.guild.client;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppActivity;

/* compiled from: P */
@QAPI(process = {""})
/* loaded from: classes12.dex */
public interface IGuildClientAuthApi extends QRouteApi {
    void clientAuthorizationForAIOPlus(QBaseActivity qBaseActivity, GuildClientParams guildClientParams);

    void openClientAuthorizationDialog(QBaseActivity qBaseActivity, GuildClientParams guildClientParams);

    void showClientGuideAuthDialog(AppActivity appActivity, String str, String str2);

    void tryToRequestClientAccountList(QBaseActivity qBaseActivity, GuildClientParams guildClientParams);
}
