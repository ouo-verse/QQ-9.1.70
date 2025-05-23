package com.tencent.mobileqq.guild.message;

import java.util.HashSet;

/* compiled from: P */
/* loaded from: classes14.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private HashSet<String> f230569a = new HashSet<>();

    /* renamed from: b, reason: collision with root package name */
    private HashSet<String> f230570b = new HashSet<>();

    /* renamed from: c, reason: collision with root package name */
    private int f230571c = 0;

    /* renamed from: d, reason: collision with root package name */
    private int f230572d = 0;

    private HashSet<String> h(HashSet<String> hashSet) {
        if (hashSet == null) {
            return new HashSet<>();
        }
        return hashSet;
    }

    public f a(int i3) {
        this.f230572d = i3;
        return this;
    }

    public f b(HashSet<String> hashSet) {
        this.f230569a = hashSet;
        return this;
    }

    public f c(HashSet<String> hashSet) {
        this.f230570b = hashSet;
        return this;
    }

    public int d() {
        return this.f230572d;
    }

    public HashSet<String> e() {
        return this.f230569a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        if (h(this.f230569a).equals(h(fVar.f230569a)) && h(this.f230570b).equals(h(fVar.f230570b)) && this.f230571c == fVar.f230571c && this.f230572d == fVar.f230572d) {
            return true;
        }
        return false;
    }

    public HashSet<String> f() {
        return this.f230570b;
    }

    public int g() {
        return this.f230571c;
    }

    public f i(int i3) {
        this.f230571c = i3;
        return this;
    }

    public String toString() {
        return "focusChannelSet:" + this.f230569a + " focusGuildSet:" + this.f230570b + " isMsgTabFocus:" + this.f230571c + " activeStatus:" + this.f230572d;
    }
}
