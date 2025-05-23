package com.tencent.mobileqq.qqguildsdk.data;

import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes17.dex */
public class bz {

    /* renamed from: a, reason: collision with root package name */
    private final String f265790a;

    /* renamed from: b, reason: collision with root package name */
    private final String f265791b;

    /* renamed from: c, reason: collision with root package name */
    private final long f265792c;

    /* renamed from: d, reason: collision with root package name */
    private final long f265793d;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private String f265794a = "0";

        /* renamed from: b, reason: collision with root package name */
        private String f265795b = "0";

        /* renamed from: c, reason: collision with root package name */
        private long f265796c = 0;

        /* renamed from: d, reason: collision with root package name */
        private long f265797d = 0;

        public bz e() {
            return new bz(this);
        }

        public a f(@NonNull String str) {
            this.f265795b = str;
            return this;
        }

        public a g(long j3) {
            this.f265797d = j3;
            return this;
        }

        public a h(@NonNull String str) {
            this.f265794a = str;
            return this;
        }

        public a i(long j3) {
            this.f265796c = j3;
            return this;
        }
    }

    bz(a aVar) {
        this.f265790a = aVar.f265794a;
        this.f265791b = aVar.f265795b;
        this.f265792c = aVar.f265796c;
        this.f265793d = aVar.f265797d;
    }

    public String a() {
        return this.f265791b;
    }

    public long b() {
        return this.f265793d;
    }

    public String c() {
        return this.f265790a;
    }

    public long d() {
        return this.f265792c;
    }

    public String toString() {
        return "GProSeqCondParams{mGuildId='" + this.f265790a + "', mChannelID='" + this.f265791b + "', mStartSeq=" + this.f265792c + ", mEndSeq=" + this.f265793d + '}';
    }
}
