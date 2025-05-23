package com.tencent.av.ui.funchat.record;

/* compiled from: P */
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f75865a;

    /* renamed from: b, reason: collision with root package name */
    public long f75866b;

    /* renamed from: c, reason: collision with root package name */
    public long f75867c;

    public d(byte[] bArr, long j3) {
        this.f75865a = bArr;
        this.f75866b = j3;
    }

    public String toString() {
        int length;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("PCMFrame:");
        byte[] bArr = this.f75865a;
        if (bArr == null) {
            length = -1;
        } else {
            length = bArr.length;
        }
        sb5.append(length);
        sb5.append(", idx=");
        sb5.append(this.f75866b);
        sb5.append(", pts=");
        sb5.append(this.f75867c);
        return sb5.toString();
    }
}
