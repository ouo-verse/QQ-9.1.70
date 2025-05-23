package a.a.b.a.a.d;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class a extends JceStruct {

    /* renamed from: f, reason: collision with root package name */
    static byte[] f25185f;

    /* renamed from: g, reason: collision with root package name */
    static byte[] f25186g;

    /* renamed from: a, reason: collision with root package name */
    public byte[] f25187a;

    /* renamed from: b, reason: collision with root package name */
    public int f25188b;

    /* renamed from: c, reason: collision with root package name */
    public int f25189c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f25190d;

    /* renamed from: e, reason: collision with root package name */
    public byte f25191e;

    public a() {
        this.f25187a = null;
        this.f25188b = 0;
        this.f25189c = 0;
        this.f25190d = null;
        this.f25191e = (byte) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (f25185f == null) {
            f25185f = r0;
            byte[] bArr = {0};
        }
        this.f25187a = jceInputStream.read(f25185f, 0, true);
        this.f25188b = jceInputStream.read(this.f25188b, 1, true);
        this.f25189c = jceInputStream.read(this.f25189c, 2, true);
        if (f25186g == null) {
            f25186g = r0;
            byte[] bArr2 = {0};
        }
        this.f25190d = jceInputStream.read(f25186g, 3, true);
        this.f25191e = jceInputStream.read(this.f25191e, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f25187a, 0);
        jceOutputStream.write(this.f25188b, 1);
        jceOutputStream.write(this.f25189c, 2);
        jceOutputStream.write(this.f25190d, 3);
        jceOutputStream.write(this.f25191e, 4);
    }

    public a(byte[] bArr, int i3, int i16, byte[] bArr2, byte b16) {
        this.f25187a = bArr;
        this.f25188b = i3;
        this.f25189c = i16;
        this.f25190d = bArr2;
        this.f25191e = b16;
    }
}
