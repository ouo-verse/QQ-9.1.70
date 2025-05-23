package com.tencent.mobileqq.guild.api.impl;

import com.tencent.mobileqq.guild.api.IGuildArkStrokeApi;
import com.tencent.mobileqq.guild.config.GuildArkStrokeConfigParser;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GuildArkStrokeApiImpl implements IGuildArkStrokeApi {
    private com.tencent.mobileqq.guild.config.f config;

    @Override // com.tencent.mobileqq.guild.api.IGuildArkStrokeApi
    public int getRoundRadius() {
        return this.config.b();
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildArkStrokeApi
    public String getStrokeColor() {
        return this.config.a();
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildArkStrokeApi
    public int getStrokeWidth() {
        return this.config.c();
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildArkStrokeApi
    public boolean isNeedStroke(String str) {
        com.tencent.mobileqq.guild.config.f a16 = GuildArkStrokeConfigParser.INSTANCE.a();
        this.config = a16;
        if (a16 == null) {
            return false;
        }
        return a16.e(str);
    }
}
