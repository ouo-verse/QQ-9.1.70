package a.a.b.a.a.f;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class l extends JceStruct {

    /* renamed from: d, reason: collision with root package name */
    static byte[] f25288d;

    /* renamed from: a, reason: collision with root package name */
    public byte f25289a;

    /* renamed from: b, reason: collision with root package name */
    public String f25290b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f25291c;

    public l() {
        this.f25289a = (byte) 0;
        this.f25290b = "";
        this.f25291c = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f25289a = jceInputStream.read(this.f25289a, 1, true);
        this.f25290b = jceInputStream.readString(2, true);
        if (f25288d == null) {
            f25288d = r0;
            byte[] bArr = {0};
        }
        this.f25291c = jceInputStream.read(f25288d, 3, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f25289a, 1);
        jceOutputStream.write(this.f25290b, 2);
        jceOutputStream.write(this.f25291c, 3);
    }

    public l(byte b16, String str, byte[] bArr) {
        this.f25289a = b16;
        this.f25290b = str;
        this.f25291c = bArr;
    }
}
