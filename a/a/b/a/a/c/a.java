package a.a.b.a.a.c;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class a extends JceStruct {

    /* renamed from: e, reason: collision with root package name */
    static byte[] f25176e;

    /* renamed from: a, reason: collision with root package name */
    public long f25177a;

    /* renamed from: b, reason: collision with root package name */
    public long f25178b;

    /* renamed from: c, reason: collision with root package name */
    public short f25179c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f25180d;

    public a() {
        this.f25177a = 0L;
        this.f25178b = 0L;
        this.f25179c = (short) 0;
        this.f25180d = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f25177a = jceInputStream.read(this.f25177a, 0, true);
        this.f25178b = jceInputStream.read(this.f25178b, 1, true);
        this.f25179c = jceInputStream.read(this.f25179c, 2, true);
        if (f25176e == null) {
            f25176e = r0;
            byte[] bArr = {0};
        }
        this.f25180d = jceInputStream.read(f25176e, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f25177a, 0);
        jceOutputStream.write(this.f25178b, 1);
        jceOutputStream.write(this.f25179c, 2);
        byte[] bArr = this.f25180d;
        if (bArr != null) {
            jceOutputStream.write(bArr, 3);
        }
    }

    public a(long j3, long j16, short s16, byte[] bArr) {
        this.f25177a = j3;
        this.f25178b = j16;
        this.f25179c = s16;
        this.f25180d = bArr;
    }
}
