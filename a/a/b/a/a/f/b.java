package a.a.b.a.a.f;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class b extends JceStruct {

    /* renamed from: d, reason: collision with root package name */
    static byte[] f25236d;

    /* renamed from: a, reason: collision with root package name */
    public short f25237a;

    /* renamed from: b, reason: collision with root package name */
    public short f25238b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f25239c;

    public b() {
        this.f25237a = (short) 0;
        this.f25238b = (short) 0;
        this.f25239c = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f25237a = jceInputStream.read(this.f25237a, 0, true);
        this.f25238b = jceInputStream.read(this.f25238b, 1, true);
        if (f25236d == null) {
            f25236d = r0;
            byte[] bArr = {0};
        }
        this.f25239c = jceInputStream.read(f25236d, 2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f25237a, 0);
        jceOutputStream.write(this.f25238b, 1);
        jceOutputStream.write(this.f25239c, 2);
    }

    public b(short s16, short s17, byte[] bArr) {
        this.f25237a = s16;
        this.f25238b = s17;
        this.f25239c = bArr;
    }
}
