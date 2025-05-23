package com.tencent.mobileqq.guild.chatpie.pluspanel;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GuildGiftAppInfo extends PlusPanelAppInfo {
    public static final String TAG = "com.tencent.mobileqq.guild.chatpie.pluspanel.GuildGiftAppInfo";

    @Override // com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo
    public int defaultDrawableID() {
        return R.drawable.guild_aio_plus_gift;
    }

    @Override // com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo
    public int getAppID() {
        return isGuild() ? 2000000002 : 0;
    }

    @Override // com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo
    public String getTitle() {
        return BaseApplication.getContext().getString(R.string.f1789137y);
    }
}
