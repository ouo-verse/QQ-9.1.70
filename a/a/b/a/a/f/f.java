package a.a.b.a.a.f;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class f extends JceStruct {

    /* renamed from: e, reason: collision with root package name */
    static byte[] f25253e;

    /* renamed from: f, reason: collision with root package name */
    static byte[] f25254f;

    /* renamed from: a, reason: collision with root package name */
    public byte f25255a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f25256b;

    /* renamed from: c, reason: collision with root package name */
    public String f25257c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f25258d;

    public f() {
        this.f25255a = (byte) 0;
        this.f25256b = null;
        this.f25257c = "";
        this.f25258d = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f25255a = jceInputStream.read(this.f25255a, 1, true);
        if (f25253e == null) {
            f25253e = r0;
            byte[] bArr = {0};
        }
        this.f25256b = jceInputStream.read(f25253e, 2, true);
        this.f25257c = jceInputStream.readString(3, true);
        if (f25254f == null) {
            f25254f = r0;
            byte[] bArr2 = {0};
        }
        this.f25258d = jceInputStream.read(f25254f, 4, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f25255a, 1);
        jceOutputStream.write(this.f25256b, 2);
        jceOutputStream.write(this.f25257c, 3);
        jceOutputStream.write(this.f25258d, 4);
    }

    public f(byte b16, byte[] bArr, String str, byte[] bArr2) {
        this.f25255a = b16;
        this.f25256b = bArr;
        this.f25257c = str;
        this.f25258d = bArr2;
    }
}
