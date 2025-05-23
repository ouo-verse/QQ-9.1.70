package com.tencent.gamecenter.wadl.sdk.downloader.task.i;

import android.os.SystemClock;

/* compiled from: P */
/* loaded from: classes6.dex */
public class c {

    /* renamed from: b, reason: collision with root package name */
    boolean f107568b = true;

    /* renamed from: c, reason: collision with root package name */
    boolean f107569c = false;

    /* renamed from: d, reason: collision with root package name */
    long f107570d = 0;

    /* renamed from: e, reason: collision with root package name */
    int f107571e = 0;

    /* renamed from: f, reason: collision with root package name */
    boolean f107572f = true;

    /* renamed from: g, reason: collision with root package name */
    boolean f107573g = false;

    /* renamed from: h, reason: collision with root package name */
    long f107574h = 0;

    /* renamed from: i, reason: collision with root package name */
    long f107575i = 0;

    /* renamed from: j, reason: collision with root package name */
    boolean f107576j = false;

    /* renamed from: k, reason: collision with root package name */
    boolean f107577k = false;

    /* renamed from: l, reason: collision with root package name */
    volatile boolean f107578l = false;

    /* renamed from: a, reason: collision with root package name */
    long f107567a = SystemClock.elapsedRealtime();

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
        this.f107568b = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        this.f107568b = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        if (this.f107570d == 0) {
            this.f107570d = SystemClock.elapsedRealtime();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
        if (this.f107569c && !com.tencent.gamecenter.wadl.sdk.common.b.c.k()) {
            this.f107569c = false;
        }
    }

    public String toString() {
        return "SectionRunInfo{relativeStartTime=" + this.f107567a + ",isNeedSwitchUrl=" + this.f107568b + ",isWapLimited=" + this.f107569c + ",reqFailStartTime=" + this.f107570d + ",retrySleepTime=" + this.f107571e + ",checkCostTime=" + this.f107572f + ",isSwitched=" + this.f107573g + ",isFinish=" + this.f107576j + ",readLen=" + this.f107574h + ",readLenOnce=" + this.f107575i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i3, long j3, long j16) {
        if (i3 == -59) {
            this.f107569c = true;
            this.f107568b = false;
        } else {
            this.f107568b = true;
        }
        if (j3 > j16) {
            this.f107571e = 0;
        } else {
            this.f107571e = com.tencent.gamecenter.wadl.sdk.downloader.a.c.c(i3) ? 3000 : 1000;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(long j3) {
        this.f107570d = 0L;
        this.f107571e = 0;
        this.f107572f = false;
        this.f107575i = j3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z16) {
        if (!z16 || this.f107573g) {
            return;
        }
        this.f107568b = true;
        this.f107573g = true;
    }
}
