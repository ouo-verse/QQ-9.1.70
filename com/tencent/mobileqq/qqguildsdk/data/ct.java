package com.tencent.mobileqq.qqguildsdk.data;

/* compiled from: P */
/* loaded from: classes17.dex */
public class ct {

    /* renamed from: a, reason: collision with root package name */
    private final GuildScheduleInfo f265943a;

    /* renamed from: b, reason: collision with root package name */
    private final int f265944b;

    /* renamed from: c, reason: collision with root package name */
    private final int f265945c;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private GuildScheduleInfo f265946a = null;

        /* renamed from: b, reason: collision with root package name */
        private int f265947b = 0;

        /* renamed from: c, reason: collision with root package name */
        private int f265948c = 0;

        public ct d() {
            return new ct(this);
        }

        public a e(GuildScheduleInfo guildScheduleInfo) {
            this.f265946a = guildScheduleInfo;
            return this;
        }

        public a f(int i3) {
            this.f265947b = i3;
            return this;
        }

        public a g(int i3) {
            this.f265948c = i3;
            return this;
        }
    }

    public ct() {
        this.f265943a = null;
        this.f265944b = 0;
        this.f265945c = 0;
    }

    public GuildScheduleInfo a() {
        return this.f265943a;
    }

    ct(a aVar) {
        this.f265943a = aVar.f265946a;
        this.f265944b = aVar.f265947b;
        this.f265945c = aVar.f265948c;
    }
}
