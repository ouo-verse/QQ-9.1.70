package com.tencent.mobileqq.guild.safety;

import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    String f233036a;

    /* renamed from: b, reason: collision with root package name */
    boolean f233037b;

    /* renamed from: c, reason: collision with root package name */
    long f233038c;

    public a(String str, boolean z16, long j3) {
        this.f233036a = str;
        this.f233037b = z16;
        this.f233038c = j3;
    }

    public static a a(IGProGuildInfo iGProGuildInfo) {
        if (iGProGuildInfo == null) {
            return null;
        }
        return new a(iGProGuildInfo.getGuildID(), iGProGuildInfo.getIsBanned(), iGProGuildInfo.getBannedTimeLimit() * 1000);
    }

    public long b() {
        return this.f233038c;
    }

    public String toString() {
        return "BanInfo{guildId='" + this.f233036a + "', isBanned=" + this.f233037b + ", guildBannedTimeLimit=" + this.f233038c + '}';
    }
}
