package com.tencent.biz.qqcircle.immersive.feed.live.od;

import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes4.dex */
public interface a {

    /* compiled from: P */
    /* renamed from: com.tencent.biz.qqcircle.immersive.feed.live.od.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0883a {

        /* renamed from: a, reason: collision with root package name */
        public int f86332a;

        /* renamed from: b, reason: collision with root package name */
        public long f86333b;

        /* renamed from: c, reason: collision with root package name */
        public String f86334c;

        /* renamed from: d, reason: collision with root package name */
        public String f86335d;

        /* compiled from: P */
        /* renamed from: com.tencent.biz.qqcircle.immersive.feed.live.od.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static class C0884a {

            /* renamed from: a, reason: collision with root package name */
            public int f86336a;

            /* renamed from: b, reason: collision with root package name */
            private long f86337b;

            /* renamed from: c, reason: collision with root package name */
            private String f86338c;

            /* renamed from: d, reason: collision with root package name */
            private String f86339d;

            public C0883a a() {
                return new C0883a(this.f86336a, this.f86337b, this.f86338c, this.f86339d);
            }

            public C0884a b(String str) {
                this.f86338c = str;
                return this;
            }

            public C0884a c(String str) {
                this.f86339d = str;
                return this;
            }

            public C0884a d(int i3) {
                this.f86336a = i3;
                return this;
            }

            public C0884a e(long j3) {
                this.f86337b = j3;
                return this;
            }
        }

        public C0883a(int i3, long j3, String str, String str2) {
            this.f86332a = i3;
            this.f86333b = j3;
            this.f86334c = str;
            this.f86335d = str2;
        }
    }

    void L(int i3, boolean z16);

    void hide();

    boolean isRelease();

    void pause();

    void release();

    void setSeatInfo(int i3, @Nullable C0883a c0883a);

    void show();
}
