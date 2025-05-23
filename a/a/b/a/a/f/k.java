package a.a.b.a.a.f;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class k extends JceStruct {

    /* renamed from: c, reason: collision with root package name */
    static byte[] f25285c;

    /* renamed from: a, reason: collision with root package name */
    public String f25286a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f25287b;

    public k() {
        this.f25286a = "";
        this.f25287b = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f25286a = jceInputStream.readString(1, true);
        if (f25285c == null) {
            f25285c = r1;
            byte[] bArr = {0};
        }
        this.f25287b = jceInputStream.read(f25285c, 2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f25286a, 1);
        jceOutputStream.write(this.f25287b, 2);
    }

    public k(String str, byte[] bArr) {
        this.f25286a = str;
        this.f25287b = bArr;
    }
}
