package a.a.b.a.a.e;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class a extends JceStruct {

    /* renamed from: a, reason: collision with root package name */
    public short f25194a;

    /* renamed from: b, reason: collision with root package name */
    public short f25195b;

    /* renamed from: c, reason: collision with root package name */
    public int f25196c;

    /* renamed from: d, reason: collision with root package name */
    public int f25197d;

    public a() {
        this.f25194a = (short) -1;
        this.f25195b = (short) -1;
        this.f25196c = -1;
        this.f25197d = -1;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f25194a = jceInputStream.read(this.f25194a, 0, true);
        this.f25195b = jceInputStream.read(this.f25195b, 1, true);
        this.f25196c = jceInputStream.read(this.f25196c, 2, true);
        this.f25197d = jceInputStream.read(this.f25197d, 3, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f25194a, 0);
        jceOutputStream.write(this.f25195b, 1);
        jceOutputStream.write(this.f25196c, 2);
        jceOutputStream.write(this.f25197d, 3);
    }

    public a(short s16, short s17, int i3, int i16) {
        this.f25194a = s16;
        this.f25195b = s17;
        this.f25196c = i3;
        this.f25197d = i16;
    }
}
