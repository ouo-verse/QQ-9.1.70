package com.tencent.mobileqq.guild.chatpie.pluspanel;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GuildMobaTeamAppInfo extends PlusPanelAppInfo {
    @Override // com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo
    public int defaultDrawableID() {
        return R.drawable.guild_aio_plus_mobateam;
    }

    @Override // com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo
    public int getAppID() {
        return isGuild() ? 2000000001 : 0;
    }

    @Override // com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo
    public String getTitle() {
        return BaseApplication.getContext().getString(R.string.f142450je);
    }
}
