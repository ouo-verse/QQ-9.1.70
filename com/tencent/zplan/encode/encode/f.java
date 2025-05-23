package com.tencent.zplan.encode.encode;

/* compiled from: P */
/* loaded from: classes38.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f385371a;

    /* renamed from: b, reason: collision with root package name */
    public int f385372b;

    /* renamed from: c, reason: collision with root package name */
    public long f385373c;

    /* renamed from: d, reason: collision with root package name */
    public int f385374d;

    public f(byte[] bArr, int i3, long j3, int i16) {
        this.f385371a = bArr;
        this.f385372b = i3;
        this.f385373c = j3;
        this.f385374d = i16;
    }

    public String toString() {
        return "OriginEncodeDataInfo{dataSize=" + this.f385372b + ", pts=" + this.f385373c + ", frameIndex=" + this.f385374d + ", data=" + this.f385371a.length + '}';
    }
}
