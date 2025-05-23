package com.tencent.mobileqq.guild.chatpie.pluspanel;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.qphone.base.util.BaseApplication;

/* loaded from: classes33.dex */
public class GuildPicAppInfo extends PlusPanelAppInfo {
    @Override // com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo
    public int defaultDrawableID() {
        return R.drawable.guild_pic_icon;
    }

    @Override // com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo
    public int getAppID() {
        return 2000000003;
    }

    @Override // com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo
    public String getTitle() {
        return BaseApplication.getContext().getString(R.string.i48);
    }
}
