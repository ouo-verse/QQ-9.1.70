package com.tencent.mobileqq.guild.message.api.impl;

import com.tencent.imcore.message.MsgPool;
import com.tencent.mobileqq.guild.message.api.IGuildMessageManagerApi;
import com.tencent.mobileqq.guild.message.m;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildMessageManagerApiImpl implements IGuildMessageManagerApi {
    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageManagerApi
    public com.tencent.mobileqq.guild.message.b newGuildMessageManager(AppRuntime appRuntime, MsgPool msgPool) {
        return new m(appRuntime, msgPool);
    }
}
