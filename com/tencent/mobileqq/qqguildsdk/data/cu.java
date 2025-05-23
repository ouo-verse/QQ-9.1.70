package com.tencent.mobileqq.qqguildsdk.data;

/* compiled from: P */
/* loaded from: classes17.dex */
public class cu {

    /* renamed from: a, reason: collision with root package name */
    final long f265949a;

    /* renamed from: b, reason: collision with root package name */
    final long f265950b;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private long f265951a;

        /* renamed from: b, reason: collision with root package name */
        private long f265952b;

        public cu c() {
            return new cu(this);
        }

        public a d(long j3) {
            this.f265952b = j3;
            return this;
        }

        public a e(long j3) {
            this.f265951a = j3;
            return this;
        }
    }

    public cu() {
        this.f265949a = 0L;
        this.f265950b = 0L;
    }

    public long a() {
        return this.f265950b;
    }

    public long b() {
        return this.f265949a;
    }

    public String toString() {
        return "GuildScheduleSendArkGuildInfo{guildId=" + this.f265949a + ", channelId=" + this.f265950b + '}';
    }

    cu(a aVar) {
        this.f265949a = aVar.f265951a;
        this.f265950b = aVar.f265952b;
    }
}
