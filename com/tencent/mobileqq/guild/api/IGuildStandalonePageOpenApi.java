package com.tencent.mobileqq.guild.api;

import android.content.Context;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {""})
/* loaded from: classes12.dex */
public interface IGuildStandalonePageOpenApi extends QRouteApi {
    public static final int SOURCE_ADD_FRIEND = 1;
    public static final int SOURCE_DIRECT_MESSAGE = 2;
    public static final String SOURCE_KEY_AIO = "aio";
    public static final String SOURCE_KEY_BIZ = "biz";
    public static final String SOURCE_KEY_GUILDTAB = "guildtab";

    int getChannelPageSourceType();

    boolean getGuildChatFragmentShow();

    void openJoinInvitationDialog(Context context, JumpGuildParam jumpGuildParam);

    void openJoinInvitationDialog(Context context, JumpGuildParam jumpGuildParam, String str);

    void openJoinInvitationDialog(Context context, JumpGuildParam jumpGuildParam, String str, boolean z16);

    void openJoinInvitationDialog(Context context, JumpGuildParam jumpGuildParam, String str, boolean z16, boolean z17);

    void setChannelPageSourceType(String str, int i3);

    void setGuildChatFragmentHide();

    void setGuildChatFragmentShow();

    void unSetChannelPageSourceType(String str);
}
