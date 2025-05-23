package com.tencent.mobileqq.qqguildsdk.data;

/* loaded from: classes17.dex */
public class GuildSpeakableThresholdPermission implements IGuildSpeakableThresholdPermission {
    private long directMsgLimitTime;
    private int directMsgLimitType;
    private long guildLimitTime;
    private int guildLimitType;
    private long joinTime;
    private String verifyUrl;

    /* loaded from: classes17.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private int f265644a = 0;

        /* renamed from: b, reason: collision with root package name */
        private int f265645b = 0;

        /* renamed from: c, reason: collision with root package name */
        private long f265646c = 0;

        /* renamed from: d, reason: collision with root package name */
        private long f265647d = 0;

        /* renamed from: e, reason: collision with root package name */
        private long f265648e = 0;

        /* renamed from: f, reason: collision with root package name */
        private String f265649f = "";

        public GuildSpeakableThresholdPermission g() {
            return new GuildSpeakableThresholdPermission(this);
        }

        public a h(long j3) {
            this.f265648e = j3;
            return this;
        }

        public a i(int i3) {
            this.f265645b = i3;
            return this;
        }

        public a j(int i3) {
            this.f265644a = i3;
            return this;
        }

        public a k(long j3) {
            this.f265646c = j3;
            return this;
        }

        public a l(String str) {
            this.f265649f = str;
            return this;
        }
    }

    GuildSpeakableThresholdPermission(a aVar) {
        this.guildLimitType = aVar.f265644a;
        this.directMsgLimitType = aVar.f265645b;
        this.joinTime = aVar.f265646c;
        this.guildLimitTime = aVar.f265647d;
        this.directMsgLimitTime = aVar.f265648e;
        this.verifyUrl = aVar.f265649f;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGuildSpeakableThresholdPermission
    public long getDirectMsgLimitTime() {
        return this.directMsgLimitTime;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGuildSpeakableThresholdPermission
    public int getDirectMsgLimitType() {
        return this.directMsgLimitType;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGuildSpeakableThresholdPermission
    public long getGuildLimitTime() {
        return this.guildLimitTime;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGuildSpeakableThresholdPermission
    public int getGuildLimitType() {
        return this.guildLimitType;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGuildSpeakableThresholdPermission
    public long getJoinTime() {
        return this.joinTime;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGuildSpeakableThresholdPermission
    public String getVerifyUrl() {
        return this.verifyUrl;
    }

    public String toString() {
        return "GuildSpeakableThresholdPermission{guildLimitType=" + this.guildLimitType + ", directMsgLimitType=" + this.directMsgLimitType + ", joinTime=" + this.joinTime + ", guildLimitTime=" + this.guildLimitTime + ", directMsgLimitTime=" + this.directMsgLimitTime + ", verifyUrl=" + this.verifyUrl + "'}";
    }
}
