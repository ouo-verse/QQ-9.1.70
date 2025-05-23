package com.tencent.mobileqq.guild.api.impl;

import com.tencent.mobileqq.guild.api.IGuildMuteApi;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GuildMuteApiImpl implements IGuildMuteApi {
    @Override // com.tencent.mobileqq.guild.api.IGuildMuteApi
    public String getMuteFormatHintTextInChannel(String str, String str2) {
        return com.tencent.mobileqq.guild.setting.mute.c.u(str, str2);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildMuteApi
    public e12.a<Long> getSelfGuildMuteLiveData(String str) {
        return com.tencent.mobileqq.guild.setting.mute.c.C(str);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildMuteApi
    public boolean hasGuildMuteManagePermission(String str) {
        return com.tencent.mobileqq.guild.setting.mute.c.M(str);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildMuteApi
    public boolean selfIsMutingInGuild(String str) {
        return com.tencent.mobileqq.guild.setting.mute.c.T(str);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildMuteApi
    public boolean selfIsQQGuildOrChannelManager(String str, String str2) {
        return com.tencent.mobileqq.guild.setting.mute.c.V(str, str2);
    }
}
