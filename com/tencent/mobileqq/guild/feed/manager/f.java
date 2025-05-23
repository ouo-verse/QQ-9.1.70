package com.tencent.mobileqq.guild.feed.manager;

/* compiled from: P */
/* loaded from: classes13.dex */
public class f {

    /* renamed from: b, reason: collision with root package name */
    private int f220179b;

    /* renamed from: d, reason: collision with root package name */
    private jk1.a f220181d;

    /* renamed from: a, reason: collision with root package name */
    private int f220178a = 0;

    /* renamed from: c, reason: collision with root package name */
    private String f220180c = "";

    public f(int i3) {
        this.f220179b = i3;
    }

    public String a() {
        return this.f220180c;
    }

    public jk1.a b() {
        return this.f220181d;
    }

    public int c() {
        return this.f220179b;
    }

    public f d(String str) {
        this.f220180c = str;
        return this;
    }

    public void e(jk1.a aVar) {
        this.f220181d = aVar;
    }

    public String toString() {
        return "GuildFeedSelectInfo{mStatus=" + this.f220178a + ", mPosition=" + this.f220179b + '}';
    }
}
