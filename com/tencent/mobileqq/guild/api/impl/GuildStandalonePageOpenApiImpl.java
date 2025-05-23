package com.tencent.mobileqq.guild.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.api.IGuildStandalonePageOpenApi;
import com.tencent.mobileqq.guild.base.GuildTransBottomSheetDialogFragment;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.helper.jump.JoinGuildChannelFrag;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes12.dex */
public class GuildStandalonePageOpenApiImpl implements IGuildStandalonePageOpenApi {
    public static final String TAG = "Guild.jump.GuildStandalonePageOpenApiImpl";
    public boolean isGuildChatFragmentShow;

    @Override // com.tencent.mobileqq.guild.api.IGuildStandalonePageOpenApi
    public int getChannelPageSourceType() {
        return com.tencent.mobileqq.guild.jump.a.e();
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildStandalonePageOpenApi
    public boolean getGuildChatFragmentShow() {
        return this.isGuildChatFragmentShow;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildStandalonePageOpenApi
    public void openJoinInvitationDialog(Context context, JumpGuildParam jumpGuildParam) {
        QLog.d(TAG, 1, "openJoinInvitationDialog guildId=" + jumpGuildParam.guildId);
        openJoinInvitationDialog(context, jumpGuildParam, HardCodeUtil.qqStr(R.string.f147280wg));
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildStandalonePageOpenApi
    public void setChannelPageSourceType(String str, int i3) {
        com.tencent.mobileqq.guild.jump.a.f(str, i3);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildStandalonePageOpenApi
    public void setGuildChatFragmentHide() {
        this.isGuildChatFragmentShow = false;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildStandalonePageOpenApi
    public void setGuildChatFragmentShow() {
        this.isGuildChatFragmentShow = true;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildStandalonePageOpenApi
    public void unSetChannelPageSourceType(String str) {
        com.tencent.mobileqq.guild.jump.a.g(str);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildStandalonePageOpenApi
    public void openJoinInvitationDialog(Context context, JumpGuildParam jumpGuildParam, String str) {
        openJoinInvitationDialog(context, jumpGuildParam, str, false);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildStandalonePageOpenApi
    public void openJoinInvitationDialog(Context context, JumpGuildParam jumpGuildParam, String str, boolean z16) {
        openJoinInvitationDialog(context, jumpGuildParam, str, z16, false);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildStandalonePageOpenApi
    public void openJoinInvitationDialog(Context context, JumpGuildParam jumpGuildParam, String str, boolean z16, boolean z17) {
        Intent zh5 = JoinGuildChannelFrag.zh(jumpGuildParam, str, z16, z17);
        if (context instanceof Activity) {
            GuildTransBottomSheetDialogFragment.th(context, zh5, JoinGuildChannelFrag.class, "Guild.jump.JoinGuildChannelFrag");
            return;
        }
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity != null) {
            GuildTransBottomSheetDialogFragment.th(qBaseActivity, zh5, JoinGuildChannelFrag.class, "Guild.jump.JoinGuildChannelFrag");
        } else {
            GuildTransBottomSheetDialogFragment.th(context, zh5, JoinGuildChannelFrag.class, "Guild.jump.JoinGuildChannelFrag");
        }
    }
}
