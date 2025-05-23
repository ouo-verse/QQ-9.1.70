package com.tencent.libra.util.apng.decode;

import java.io.IOException;

/* compiled from: P */
/* loaded from: classes7.dex */
public class g extends b {

    /* renamed from: h, reason: collision with root package name */
    public static final int f118835h = b.a("IHDR");

    /* renamed from: e, reason: collision with root package name */
    public int f118836e;

    /* renamed from: f, reason: collision with root package name */
    public int f118837f;

    /* renamed from: g, reason: collision with root package name */
    public byte[] f118838g = new byte[5];

    @Override // com.tencent.libra.util.apng.decode.b
    void b(h11.a aVar) throws IOException {
        this.f118836e = aVar.d();
        this.f118837f = aVar.d();
        byte[] bArr = this.f118838g;
        aVar.read(bArr, 0, bArr.length);
    }
}
