package com.tencent.biz.qqstory.model.lbs;

import com.tencent.mobileqq.soso.location.data.SosoLocation;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final int f94078a;

    /* renamed from: b, reason: collision with root package name */
    public final int f94079b;

    /* renamed from: c, reason: collision with root package name */
    public final int f94080c;

    public a(int i3, int i16) {
        this.f94078a = i3;
        this.f94079b = i16;
        this.f94080c = 1;
    }

    public static a a(SosoLocation sosoLocation) {
        if (sosoLocation != null) {
            return new a((int) (sosoLocation.mLat02 * 1000000.0d), (int) (sosoLocation.mLon02 * 1000000.0d));
        }
        return new a(0, 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        if (this.f94078a == aVar.f94078a && this.f94079b == aVar.f94079b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.f94078a * 31) + this.f94079b;
    }

    public String toString() {
        return "GpsMsg{latitude=" + this.f94078a + ", longitude=" + this.f94079b + '}';
    }

    public a(int i3, int i16, int i17) {
        this.f94078a = i3;
        this.f94079b = i16;
        this.f94080c = i17;
    }
}
