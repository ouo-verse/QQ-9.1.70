package com.tencent.mobileqq.guild.api.impl;

import com.tencent.mobileqq.guild.api.IGuildAVPriorityManager;
import com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore;
import mqq.app.AppRuntime;

/* loaded from: classes12.dex */
public class GuildAVPriorityManagerImpl implements IGuildAVPriorityManager {
    @Override // com.tencent.mobileqq.guild.api.IGuildAVPriorityManager
    public void abandonAVFocus(String str) {
        com.tencent.mobileqq.guild.util.h.b(str);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildAVPriorityManager
    public int checkIsInAudioRoom(String str) {
        return com.tencent.mobileqq.guild.util.h.d(str);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildAVPriorityManager
    public boolean checkIsInGuildLive() {
        return com.tencent.mobileqq.guild.util.h.e();
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildAVPriorityManager
    public boolean requestAVFocus(AppRuntime appRuntime, String str) {
        return com.tencent.mobileqq.guild.util.h.m(appRuntime, str, GLiveChannelCore.f226698a.g());
    }
}
