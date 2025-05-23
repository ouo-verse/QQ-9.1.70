package com.tencent.mobileqq.guild.share.app;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.channel.create.CreateSubChannelInfo;
import com.tencent.mobileqq.guild.channel.create.dialog.BaseDialogFragment;
import com.tencent.mobileqq.guild.share.GuildMiniAppShareData;

/* compiled from: P */
/* loaded from: classes14.dex */
public class JoinGuildFromMiniAppDialogFragment extends BaseDialogFragment {
    private String M;
    private String N;
    private IQQGuildRouterApi.MiniAppJoinGuildDialogCallback P;

    public static JoinGuildFromMiniAppDialogFragment Eh(GuildMiniAppShareData guildMiniAppShareData, IQQGuildRouterApi.MiniAppJoinGuildDialogCallback miniAppJoinGuildDialogCallback) {
        JoinGuildFromMiniAppDialogFragment joinGuildFromMiniAppDialogFragment = new JoinGuildFromMiniAppDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("extra_key_subchannel_info", null);
        bundle.putString("extra_key_guild_name", guildMiniAppShareData.guildName);
        bundle.putString("extra_key_guild_avatar_url", guildMiniAppShareData.guildAvatarUrl);
        joinGuildFromMiniAppDialogFragment.setArguments(bundle);
        joinGuildFromMiniAppDialogFragment.Fh(miniAppJoinGuildDialogCallback);
        return joinGuildFromMiniAppDialogFragment;
    }

    private void Fh(IQQGuildRouterApi.MiniAppJoinGuildDialogCallback miniAppJoinGuildDialogCallback) {
        this.P = miniAppJoinGuildDialogCallback;
    }

    @Override // com.tencent.mobileqq.guild.channel.create.dialog.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.M = arguments.getString("extra_key_guild_name");
        this.N = arguments.getString("extra_key_guild_avatar_url");
    }

    @Override // com.tencent.mobileqq.guild.channel.create.dialog.BaseDialogFragment
    protected Fragment wh(CreateSubChannelInfo createSubChannelInfo) {
        JoinGuildFromMiniAppFragment wh5 = JoinGuildFromMiniAppFragment.wh(createSubChannelInfo, this.M, this.N, this.P);
        wh5.ph(this);
        return wh5;
    }
}
