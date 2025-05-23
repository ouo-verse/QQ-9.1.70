package a.a.b.a.a.f;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class d extends JceStruct {

    /* renamed from: e, reason: collision with root package name */
    static byte[] f25243e;

    /* renamed from: f, reason: collision with root package name */
    static byte[] f25244f;

    /* renamed from: a, reason: collision with root package name */
    public byte f25245a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f25246b;

    /* renamed from: c, reason: collision with root package name */
    public String f25247c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f25248d;

    public d() {
        this.f25245a = (byte) 0;
        this.f25246b = null;
        this.f25247c = "";
        this.f25248d = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f25245a = jceInputStream.read(this.f25245a, 1, true);
        if (f25243e == null) {
            f25243e = r0;
            byte[] bArr = {0};
        }
        this.f25246b = jceInputStream.read(f25243e, 2, true);
        this.f25247c = jceInputStream.readString(3, true);
        if (f25244f == null) {
            f25244f = r0;
            byte[] bArr2 = {0};
        }
        this.f25248d = jceInputStream.read(f25244f, 4, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f25245a, 1);
        jceOutputStream.write(this.f25246b, 2);
        jceOutputStream.write(this.f25247c, 3);
        jceOutputStream.write(this.f25248d, 4);
    }

    public d(byte b16, byte[] bArr, String str, byte[] bArr2) {
        this.f25245a = b16;
        this.f25246b = bArr;
        this.f25247c = str;
        this.f25248d = bArr2;
    }
}
