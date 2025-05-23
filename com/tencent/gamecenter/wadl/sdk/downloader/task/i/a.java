package com.tencent.gamecenter.wadl.sdk.downloader.task.i;

import com.tencent.gamecenter.wadl.sdk.downloader.task.e;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a {

    /* renamed from: k, reason: collision with root package name */
    private static String f107556k = ",";

    /* renamed from: a, reason: collision with root package name */
    public boolean f107557a;

    /* renamed from: b, reason: collision with root package name */
    public int f107558b;

    /* renamed from: c, reason: collision with root package name */
    public int f107559c;

    /* renamed from: d, reason: collision with root package name */
    public volatile long f107560d;

    /* renamed from: e, reason: collision with root package name */
    public volatile long f107561e;

    /* renamed from: f, reason: collision with root package name */
    public volatile long f107562f;

    /* renamed from: g, reason: collision with root package name */
    public volatile long f107563g;

    /* renamed from: h, reason: collision with root package name */
    public volatile boolean f107564h;

    /* renamed from: i, reason: collision with root package name */
    public volatile boolean f107565i;

    /* renamed from: j, reason: collision with root package name */
    public e f107566j;

    public a(e eVar, long j3, long j16, long j17, long j18) {
        this.f107557a = true;
        this.f107558b = -1;
        this.f107559c = -1;
        this.f107564h = false;
        this.f107565i = false;
        this.f107566j = eVar;
        this.f107560d = j3;
        this.f107563g = j18;
        this.f107561e = j16;
        this.f107562f = Math.max(j16, j17);
    }

    public long a(long j3) {
        if (this.f107563g != -1) {
            j3 = this.f107563g;
        }
        return j3 - this.f107562f;
    }

    public String toString() {
        return "[" + this.f107558b + f107556k + this.f107559c + f107556k + this.f107560d + f107556k + this.f107561e + f107556k + this.f107562f + f107556k + this.f107563g + "]";
    }

    public a(e eVar, String str) {
        this.f107557a = true;
        this.f107558b = -1;
        this.f107559c = -1;
        this.f107564h = false;
        this.f107565i = false;
        this.f107566j = eVar;
        String[] split = str.split(f107556k);
        if (split == null || split.length != 5) {
            com.tencent.gamecenter.wadl.sdk.common.e.b.e("Wadl-downloader-DataSection", "new DataSection pattern fail.");
            this.f107557a = false;
            return;
        }
        this.f107558b = Integer.valueOf(split[0]).intValue();
        this.f107559c = Integer.valueOf(split[1]).intValue();
        this.f107560d = Long.valueOf(split[2]).longValue();
        this.f107561e = Long.valueOf(split[3]).longValue();
        this.f107562f = this.f107561e;
        this.f107563g = Long.valueOf(split[4]).longValue();
    }

    public com.tencent.gamecenter.wadl.sdk.downloader.a.e.b a(int i3, boolean z16) {
        long j3 = this.f107563g;
        if (i3 > 0) {
            if (this.f107563g == -1) {
                j3 = this.f107562f + i3;
            } else {
                long j16 = i3;
                if (j16 < this.f107563g - this.f107562f) {
                    j3 = this.f107562f + j16;
                } else if (!z16) {
                    j3 = -1;
                }
            }
        }
        return new com.tencent.gamecenter.wadl.sdk.downloader.a.e.b(this.f107562f, j3);
    }

    public String a() {
        return this.f107558b + f107556k + this.f107559c + f107556k + this.f107560d + f107556k + this.f107561e + f107556k + this.f107563g;
    }
}
