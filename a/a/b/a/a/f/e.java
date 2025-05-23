package a.a.b.a.a.f;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class e extends JceStruct {

    /* renamed from: d, reason: collision with root package name */
    static byte[] f25249d;

    /* renamed from: a, reason: collision with root package name */
    public String f25250a;

    /* renamed from: b, reason: collision with root package name */
    public String f25251b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f25252c;

    public e() {
        this.f25250a = "";
        this.f25251b = "";
        this.f25252c = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f25250a = jceInputStream.readString(1, true);
        this.f25251b = jceInputStream.readString(2, true);
        if (f25249d == null) {
            f25249d = r0;
            byte[] bArr = {0};
        }
        this.f25252c = jceInputStream.read(f25249d, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f25250a, 1);
        jceOutputStream.write(this.f25251b, 2);
        byte[] bArr = this.f25252c;
        if (bArr != null) {
            jceOutputStream.write(bArr, 3);
        }
    }

    public e(String str, String str2, byte[] bArr) {
        this.f25250a = str;
        this.f25251b = str2;
        this.f25252c = bArr;
    }
}
