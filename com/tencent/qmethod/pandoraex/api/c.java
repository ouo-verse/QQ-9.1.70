package com.tencent.qmethod.pandoraex.api;

import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public int f343896a;

    /* renamed from: b, reason: collision with root package name */
    public int f343897b;

    /* renamed from: c, reason: collision with root package name */
    public long f343898c;

    /* renamed from: d, reason: collision with root package name */
    public long f343899d;

    public c(int i3, int i16) {
        this.f343899d = 0L;
        this.f343896a = i3;
        this.f343898c = i3 * 1000;
        this.f343897b = i16;
    }

    @NonNull
    public String toString() {
        return "ConfigHighFrequency{count[" + this.f343897b + "], durationMillSecond[" + this.f343898c + "], actualDuration[" + this.f343899d + "]}";
    }

    public c(long j3, int i3) {
        this.f343896a = 0;
        this.f343899d = 0L;
        this.f343898c = j3;
        this.f343897b = i3;
    }

    public c(long j3, int i3, long j16) {
        this.f343896a = 0;
        this.f343898c = j3;
        this.f343897b = i3;
        this.f343899d = j16;
    }
}
