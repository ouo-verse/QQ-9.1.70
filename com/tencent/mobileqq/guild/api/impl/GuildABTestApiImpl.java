package com.tencent.mobileqq.guild.api.impl;

import com.tencent.mobileqq.guild.api.IGuildABTestApi;
import com.tencent.mobileqq.guild.guildtab.GuildTabRedLogic;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GuildABTestApiImpl implements IGuildABTestApi {
    private static final String TAG = "GuildABTestApiImpl";

    @Override // com.tencent.mobileqq.guild.api.IGuildABTestApi
    public boolean isExpHit(String str, String str2) {
        return y02.a.a(str, str2);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildABTestApi
    public void reportExposure(String str) {
        y02.a.d(str);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildABTestApi
    public void setGuildTabGrayRedPointShowTime(long j3, String str) {
        GuildTabRedLogic.f224628d.i(j3, str);
    }
}
