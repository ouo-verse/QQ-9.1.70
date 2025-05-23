package com.tencent.mobileqq.qqguildsdk.data;

import java.util.List;

/* compiled from: P */
/* loaded from: classes17.dex */
public class cn {

    /* renamed from: a, reason: collision with root package name */
    private String f265877a;

    /* renamed from: b, reason: collision with root package name */
    private String f265878b;

    /* renamed from: c, reason: collision with root package name */
    private String f265879c;

    /* renamed from: d, reason: collision with root package name */
    private List<e> f265880d;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private String f265881a;

        /* renamed from: b, reason: collision with root package name */
        private String f265882b;

        /* renamed from: c, reason: collision with root package name */
        private String f265883c;

        /* renamed from: d, reason: collision with root package name */
        private List<e> f265884d;

        public cn e() {
            return new cn(this);
        }

        public a f(List<e> list) {
            this.f265884d = list;
            return this;
        }

        public a g(String str) {
            this.f265881a = str;
            return this;
        }

        public a h(String str) {
            this.f265883c = str;
            return this;
        }
    }

    public cn(a aVar) {
        this.f265877a = aVar.f265881a;
        this.f265878b = aVar.f265882b;
        this.f265879c = aVar.f265883c;
        this.f265880d = aVar.f265884d;
    }

    public String a() {
        return this.f265877a;
    }

    public String b() {
        return this.f265879c;
    }

    public String c() {
        return this.f265878b;
    }

    public String toString() {
        return "GuildMsgNode{guildId : " + this.f265877a + ", showNumber : " + this.f265878b + ", name : " + this.f265879c + ", channelMsgNodeList size : " + this.f265880d.size() + "}";
    }
}
