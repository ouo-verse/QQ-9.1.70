package a.a.b.a.a.f;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class h extends JceStruct {

    /* renamed from: e, reason: collision with root package name */
    static byte[] f25260e;

    /* renamed from: f, reason: collision with root package name */
    static byte[] f25261f;

    /* renamed from: a, reason: collision with root package name */
    public byte f25262a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f25263b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f25264c;

    /* renamed from: d, reason: collision with root package name */
    public String f25265d;

    public h() {
        this.f25262a = (byte) 0;
        this.f25263b = null;
        this.f25264c = null;
        this.f25265d = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f25262a = jceInputStream.read(this.f25262a, 1, true);
        if (f25260e == null) {
            f25260e = r0;
            byte[] bArr = {0};
        }
        this.f25263b = jceInputStream.read(f25260e, 2, true);
        if (f25261f == null) {
            f25261f = r0;
            byte[] bArr2 = {0};
        }
        this.f25264c = jceInputStream.read(f25261f, 3, true);
        this.f25265d = jceInputStream.readString(4, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f25262a, 1);
        jceOutputStream.write(this.f25263b, 2);
        jceOutputStream.write(this.f25264c, 3);
        jceOutputStream.write(this.f25265d, 4);
    }

    public h(byte b16, byte[] bArr, byte[] bArr2, String str) {
        this.f25262a = b16;
        this.f25263b = bArr;
        this.f25264c = bArr2;
        this.f25265d = str;
    }
}
