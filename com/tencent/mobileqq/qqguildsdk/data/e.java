package com.tencent.mobileqq.qqguildsdk.data;

/* compiled from: P */
/* loaded from: classes17.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private String f266011a;

    /* renamed from: b, reason: collision with root package name */
    private String f266012b;

    /* renamed from: c, reason: collision with root package name */
    private int f266013c;

    /* renamed from: d, reason: collision with root package name */
    private int f266014d;

    /* renamed from: e, reason: collision with root package name */
    private int f266015e;

    /* renamed from: f, reason: collision with root package name */
    private String f266016f;

    /* renamed from: g, reason: collision with root package name */
    private String f266017g;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private String f266018a;

        /* renamed from: b, reason: collision with root package name */
        private String f266019b;

        /* renamed from: c, reason: collision with root package name */
        private int f266020c = -1000;

        /* renamed from: d, reason: collision with root package name */
        private int f266021d = -1000;

        /* renamed from: e, reason: collision with root package name */
        private int f266022e = -1000;

        /* renamed from: f, reason: collision with root package name */
        private String f266023f;

        /* renamed from: g, reason: collision with root package name */
        private String f266024g;

        public e h() {
            return new e(this);
        }

        public a i(int i3) {
            this.f266022e = i3;
            return this;
        }

        public a j(String str) {
            this.f266024g = str;
            return this;
        }

        public a k(String str) {
            this.f266023f = str;
            return this;
        }

        public a l(String str) {
            this.f266018a = str;
            return this;
        }

        public a m(String str) {
            this.f266019b = str;
            return this;
        }
    }

    public e(a aVar) {
        this.f266013c = -1000;
        this.f266014d = -1000;
        this.f266015e = -1000;
        this.f266011a = aVar.f266018a;
        this.f266012b = aVar.f266019b;
        this.f266013c = aVar.f266020c;
        this.f266014d = aVar.f266021d;
        this.f266015e = aVar.f266022e;
        this.f266016f = aVar.f266023f;
        this.f266017g = aVar.f266024g;
        this.f266013c = aVar.f266020c;
    }

    public String a() {
        return this.f266017g;
    }

    public String b() {
        return this.f266016f;
    }

    public String c() {
        return this.f266011a;
    }

    public int d() {
        return this.f266014d;
    }

    public String e() {
        return this.f266012b;
    }

    public int f() {
        return this.f266013c;
    }

    public String toString() {
        return "ChannelMsgNode{channelId : " + this.f266011a + ", name : " + this.f266012b + ", type : " + this.f266013c + ", msgNotifyType : " + this.f266014d + ", finalNotifyType : " + this.f266015e + ", fromTId : " + this.f266016f + ", fromNick : " + this.f266017g + "}";
    }
}
