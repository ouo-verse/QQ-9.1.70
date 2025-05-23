package com.tencent.mobileqq.guild.api;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.guild.widget.GuildStateType;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IGuildInfoUtilsApi extends QRouteApi {
    boolean canTalkinChannel(AppRuntime appRuntime, String str, String str2);

    boolean checkSecurityValid(IGProSecurityResult iGProSecurityResult);

    int getChannelType(AppRuntime appRuntime, String str, String str2);

    int getGenericChannelType(int i3);

    GuildStateType getGuildAioSubTitleIconState(String str);

    int getGuildSettingDrawable();

    String getOnlineUIDataToShow(int i3, int i16);

    boolean isCreatorOrAdmin(AppRuntime appRuntime, String str);

    boolean isHomePage(AppRuntime appRuntime, String str);

    boolean isLiveReadyFragment(Object obj);

    boolean isSafetySwitchOpen(String str, int i3);

    boolean isSupportSubscriptionChannelAbility(int i3);

    boolean isSupportTextChannleAbility(int i3);

    boolean isSupportTopChannelAbility(int i3);

    void shareGuildToQQ(Activity activity, IGProGuildInfo iGProGuildInfo, GuildSharePageSource guildSharePageSource);

    void shareGuildToWechatFriend(Activity activity, IGProGuildInfo iGProGuildInfo, GuildSharePageSource guildSharePageSource);

    void toastErrorAndSecurity(Context context, int i3, String str, IGProSecurityResult iGProSecurityResult);

    void trySetGuildAutoTop(String str, String str2);
}
