package com.tencent.mobileqq.qqguildsdk.state;

import com.tencent.mobileqq.qqguildsdk.data.cz;

/* compiled from: P */
/* loaded from: classes17.dex */
public abstract class a implements cz {

    /* renamed from: a, reason: collision with root package name */
    final String f268470a;

    /* renamed from: b, reason: collision with root package name */
    final String f268471b;

    /* renamed from: c, reason: collision with root package name */
    final int f268472c;

    /* renamed from: d, reason: collision with root package name */
    long f268473d;

    public a(String str, String str2, int i3) {
        this(str, str2, i3, 0L);
    }

    public long a() {
        return this.f268473d;
    }

    public void b(long j3) {
        this.f268473d = j3;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.cz
    public String getChannelId() {
        return this.f268471b;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.cz
    public int getChannelType() {
        return this.f268472c;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.cz
    public String getGuildId() {
        return this.f268470a;
    }

    public a(String str, String str2, int i3, long j3) {
        this.f268470a = str;
        this.f268471b = str2;
        this.f268472c = i3;
        this.f268473d = j3;
    }
}
