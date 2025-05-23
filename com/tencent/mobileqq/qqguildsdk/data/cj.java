package com.tencent.mobileqq.qqguildsdk.data;

import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes17.dex */
public class cj {

    /* renamed from: a, reason: collision with root package name */
    private long f265868a;

    /* renamed from: b, reason: collision with root package name */
    private String f265869b;

    /* renamed from: c, reason: collision with root package name */
    private String f265870c;

    public cj(long j3, String str, String str2) {
        this.f265868a = j3;
        this.f265869b = str;
        this.f265870c = str2;
    }

    public long a() {
        return this.f265868a;
    }

    public String b() {
        return this.f265869b;
    }

    public String c() {
        return this.f265870c;
    }

    public boolean d() {
        if (this.f265868a != 0 && !TextUtils.isEmpty(this.f265869b)) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "GuildIdentityInfo{appid : " + this.f265868a + ", orgID : " + this.f265869b + ", worldID : " + this.f265870c + "}";
    }
}
