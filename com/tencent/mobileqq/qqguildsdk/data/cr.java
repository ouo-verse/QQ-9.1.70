package com.tencent.mobileqq.qqguildsdk.data;

/* compiled from: P */
/* loaded from: classes17.dex */
public class cr {

    /* renamed from: a, reason: collision with root package name */
    private final long f265935a;

    /* renamed from: b, reason: collision with root package name */
    private final int f265936b;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private long f265937a = 0;

        /* renamed from: b, reason: collision with root package name */
        private int f265938b = 0;

        public cr c() {
            return new cr(this);
        }

        public a d(long j3) {
            this.f265937a = j3;
            return this;
        }

        public a e(int i3) {
            this.f265938b = i3;
            return this;
        }
    }

    public cr() {
        this.f265935a = 0L;
        this.f265936b = 0;
    }

    public long a() {
        return this.f265935a;
    }

    public int b() {
        return this.f265936b;
    }

    cr(a aVar) {
        this.f265935a = aVar.f265937a;
        this.f265936b = aVar.f265938b;
    }
}
