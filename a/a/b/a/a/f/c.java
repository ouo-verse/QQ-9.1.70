package a.a.b.a.a.f;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class c extends JceStruct {

    /* renamed from: c, reason: collision with root package name */
    static byte[] f25240c;

    /* renamed from: a, reason: collision with root package name */
    public String f25241a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f25242b;

    public c() {
        this.f25241a = "";
        this.f25242b = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f25241a = jceInputStream.readString(1, true);
        if (f25240c == null) {
            f25240c = r1;
            byte[] bArr = {0};
        }
        this.f25242b = jceInputStream.read(f25240c, 2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f25241a, 1);
        jceOutputStream.write(this.f25242b, 2);
    }

    public c(String str, byte[] bArr) {
        this.f25241a = str;
        this.f25242b = bArr;
    }
}
