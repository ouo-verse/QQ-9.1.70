package com.tencent.mobileqq.qqguildsdk.data;

/* compiled from: P */
/* loaded from: classes17.dex */
public class cq {

    /* renamed from: a, reason: collision with root package name */
    public int f265931a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f265932b = 0;

    /* renamed from: c, reason: collision with root package name */
    public long f265933c = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f265934d = 0;

    public boolean a() {
        if (this.f265934d == 1) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof cq)) {
            return false;
        }
        cq cqVar = (cq) obj;
        if (this.f265931a == cqVar.f265931a && this.f265932b == cqVar.f265932b && this.f265933c == cqVar.f265933c && this.f265934d == cqVar.f265934d) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3 = ((this.f265931a * 31) + this.f265932b) * 31;
        long j3 = this.f265933c;
        return ((i3 + ((int) (j3 ^ (j3 >>> 32)))) * 31) + this.f265934d;
    }

    public String toString() {
        return "GuildNoticeRedPoint{redPointType=" + this.f265931a + ", count=" + this.f265932b + ", expireTs=" + this.f265933c + ", muteSwitch=" + this.f265934d + '}';
    }
}
