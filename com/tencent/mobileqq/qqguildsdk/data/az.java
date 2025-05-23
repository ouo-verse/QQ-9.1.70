package com.tencent.mobileqq.qqguildsdk.data;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public class az {

    /* renamed from: a, reason: collision with root package name */
    private final String f265708a;

    /* renamed from: b, reason: collision with root package name */
    private final GuildSourceId f265709b;

    /* renamed from: c, reason: collision with root package name */
    private final String f265710c;

    /* renamed from: d, reason: collision with root package name */
    private final String f265711d;

    /* renamed from: e, reason: collision with root package name */
    private final ArrayList<ay> f265712e;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private String f265713a;

        /* renamed from: b, reason: collision with root package name */
        private GuildSourceId f265714b;

        /* renamed from: c, reason: collision with root package name */
        private String f265715c;

        /* renamed from: d, reason: collision with root package name */
        private String f265716d = "";

        /* renamed from: e, reason: collision with root package name */
        private ArrayList<ay> f265717e = new ArrayList<>();

        public a f(ArrayList<ay> arrayList) {
            this.f265717e = arrayList;
            return this;
        }

        public az g() {
            return new az(this);
        }

        public a h(String str) {
            this.f265716d = str;
            return this;
        }

        public a i(String str) {
            this.f265713a = str;
            return this;
        }

        public a j(String str) {
            this.f265715c = str;
            return this;
        }

        public a k(GuildSourceId guildSourceId) {
            this.f265714b = guildSourceId;
            return this;
        }
    }

    az(a aVar) {
        this.f265708a = aVar.f265713a;
        this.f265709b = aVar.f265714b;
        this.f265710c = aVar.f265715c;
        this.f265711d = aVar.f265716d;
        this.f265712e = aVar.f265717e;
    }

    public ArrayList<ay> a() {
        return this.f265712e;
    }

    public String b() {
        return this.f265711d;
    }

    public String c() {
        return this.f265708a;
    }

    public String d() {
        return this.f265710c;
    }

    public GuildSourceId e() {
        return this.f265709b;
    }

    public String toString() {
        return "GProJoinGuildWithOptionReqParam{guild='" + this.f265708a + "', sourceId=" + this.f265709b + ", sig='" + this.f265710c + "', comment='" + this.f265711d + "', answers=" + this.f265712e + '}';
    }
}
