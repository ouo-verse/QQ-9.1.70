package com.tencent.mobileqq.guild.robot.api.impl;

import com.google.gson.Gson;
import com.tencent.mobileqq.guild.robot.api.IGuildRobotUtilApi;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotClientInfo;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import sx1.f;
import xw1.c;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildRobotUtilApiImpl implements IGuildRobotUtilApi {
    @Override // com.tencent.mobileqq.guild.robot.api.IGuildRobotUtilApi
    public boolean canUserAddRobotInGuild(String str) {
        IGProGuildInfo guildInfo;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || (guildInfo = ((IGPSService) peekAppRuntime.getRuntimeService(IGPSService.class, "")).getGuildInfo(str)) == null || guildInfo.getUserType() == 0) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.guild.robot.api.IGuildRobotUtilApi
    public GProGuildRobotClientInfo getGuildRobotClientInfo() {
        return f.d();
    }

    @Override // com.tencent.mobileqq.guild.robot.api.IGuildRobotUtilApi
    public c getRobotConfig() {
        return f.f();
    }

    @Override // com.tencent.mobileqq.guild.robot.api.IGuildRobotUtilApi
    public boolean isNameMatched(String str, String str2) {
        return f.h(str, str2);
    }

    @Override // com.tencent.mobileqq.guild.robot.api.IGuildRobotUtilApi
    public String toJson(Object obj) {
        return new Gson().toJson(obj);
    }

    @Override // com.tencent.mobileqq.guild.robot.api.IGuildRobotUtilApi
    public <T> T toObject(String str, Class<T> cls) {
        return (T) new Gson().fromJson(str, (Class) cls);
    }
}
