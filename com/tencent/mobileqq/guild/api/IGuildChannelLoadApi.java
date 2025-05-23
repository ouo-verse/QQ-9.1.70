package com.tencent.mobileqq.guild.api;

import android.content.Context;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {""})
/* loaded from: classes12.dex */
public interface IGuildChannelLoadApi extends QRouteApi {
    void destroyChannelUpdateManager();

    void initChannelUpdateManager(AppRuntime appRuntime);

    boolean loadGuildChannelFromSplash(Context context, JumpGuildParam jumpGuildParam);

    boolean loadGuildChannelWithFullGuild(Context context, JumpGuildParam jumpGuildParam);

    boolean loadGuildChannelWithMsgListTab(Context context, JumpGuildParam jumpGuildParam);

    boolean loadGuildDirectMessageAio(Context context, JumpGuildParam jumpGuildParam, int i3);

    void notifyGuildHelperDestroy();

    void onConversationTabChanged(boolean z16);
}
