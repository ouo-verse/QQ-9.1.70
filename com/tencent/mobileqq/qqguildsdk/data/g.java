package com.tencent.mobileqq.qqguildsdk.data;

/* compiled from: P */
/* loaded from: classes17.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private String f266067a;

    /* renamed from: b, reason: collision with root package name */
    private String f266068b;

    /* renamed from: c, reason: collision with root package name */
    private int f266069c;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private String f266070a;

        /* renamed from: b, reason: collision with root package name */
        private String f266071b;

        /* renamed from: c, reason: collision with root package name */
        private int f266072c;

        public g d() {
            return new g(this);
        }

        public a e(String str) {
            this.f266070a = str;
            return this;
        }

        public a f(int i3) {
            this.f266072c = i3;
            return this;
        }

        public a g(String str) {
            this.f266071b = str;
            return this;
        }
    }

    g() {
    }

    public static g a(IGProChannelInfo iGProChannelInfo) {
        if (iGProChannelInfo == null) {
            return new g();
        }
        a aVar = new a();
        aVar.e(iGProChannelInfo.getChannelUin());
        aVar.g(iGProChannelInfo.getGuildId());
        aVar.f(iGProChannelInfo.getType());
        return aVar.d();
    }

    public String b() {
        return this.f266067a;
    }

    public int c() {
        return this.f266069c;
    }

    public String d() {
        return this.f266068b;
    }

    public String toString() {
        return "ChannelSimpleInfo{channelId='" + this.f266067a + "', guildId='" + this.f266068b + "', channelType=" + this.f266069c + '}';
    }

    g(a aVar) {
        this.f266067a = aVar.f266070a;
        this.f266068b = aVar.f266071b;
        this.f266069c = aVar.f266072c;
    }
}
