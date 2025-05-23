package com.tencent.mobileqq.qqguildsdk.data;

/* compiled from: P */
/* loaded from: classes17.dex */
public class cv implements fc {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f265953a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f265954b;

    /* renamed from: c, reason: collision with root package name */
    private final long f265955c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f265956d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f265957e;

    /* renamed from: f, reason: collision with root package name */
    private final long f265958f;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private boolean f265959a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f265960b;

        /* renamed from: c, reason: collision with root package name */
        private long f265961c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f265962d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f265963e;

        /* renamed from: f, reason: collision with root package name */
        private long f265964f;

        public cv g() {
            return new cv(this);
        }

        public a h(boolean z16) {
            this.f265963e = z16;
            return this;
        }

        public a i(long j3) {
            this.f265964f = j3;
            return this;
        }

        public a j(boolean z16) {
            this.f265962d = z16;
            return this;
        }

        public a k(boolean z16) {
            this.f265960b = z16;
            return this;
        }

        public a l(long j3) {
            this.f265961c = j3;
            return this;
        }

        public a m(boolean z16) {
            this.f265959a = z16;
            return this;
        }
    }

    cv(a aVar) {
        this.f265953a = aVar.f265959a;
        this.f265954b = aVar.f265960b;
        this.f265955c = aVar.f265961c;
        this.f265956d = aVar.f265962d;
        this.f265957e = aVar.f265963e;
        this.f265958f = aVar.f265964f;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.fc
    public boolean a() {
        return this.f265957e;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.fc
    public long b() {
        return this.f265955c;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.fc
    public boolean c() {
        return this.f265953a;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.fc
    public long d() {
        return this.f265958f;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.fc
    public boolean e() {
        return this.f265956d;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.fc
    public boolean f() {
        return this.f265954b;
    }

    public String toString() {
        return "GuildSpeakableThreshold{guildNeedRealName=" + this.f265953a + ", guildNeedJoinRole=" + this.f265954b + ", guildNeedJoinTime=" + this.f265955c + ", directMsgNeedRealName=" + this.f265956d + ", directMsgNeedJoinRole=" + this.f265957e + ", directMsgNeedJoinTime=" + this.f265958f + '}';
    }
}
