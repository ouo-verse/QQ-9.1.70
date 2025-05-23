package com.tencent.mobileqq.guild.api;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface ILaunchGuildChatPieApi extends QRouteApi {
    int getChannelTypeLaunchChatPie(AppRuntime appRuntime, int i3, String str, String str2);

    Intent getGuildChatActivityIntent(@NonNull Context context, @NonNull i iVar);

    Intent getGuildChatPieIntent(Context context, LaunchGuildChatPieParam launchGuildChatPieParam);

    Intent getSplashGuildChatActivityIntent(@NonNull Context context, @NonNull i iVar);

    void launchGuildChatActivity(@NonNull Context context, @NonNull i iVar);

    void launchGuildChatFragment(@NonNull Context context, @NonNull i iVar);

    void launchGuildChatPie(@NonNull Context context, @NonNull LaunchGuildChatPieParam launchGuildChatPieParam);

    void launchGuildDirectMessageAio(@NonNull Context context, @NonNull LaunchGuildChatPieParam launchGuildChatPieParam);

    boolean launchMediaChannel(Context context, IGProGuildInfo iGProGuildInfo, IGProChannelInfo iGProChannelInfo, Bundle bundle);

    void launchSplashGuildChatActivity(@NonNull Context context, @NonNull i iVar);

    void launchSplashGuildChatFragment(@NonNull Context context, @NonNull i iVar);
}
