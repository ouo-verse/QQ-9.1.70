package a.a.b.a.a.e;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class d extends JceStruct {

    /* renamed from: a, reason: collision with root package name */
    public String f25213a;

    /* renamed from: b, reason: collision with root package name */
    public long f25214b;

    /* renamed from: c, reason: collision with root package name */
    public short f25215c;

    /* renamed from: d, reason: collision with root package name */
    public short f25216d;

    /* renamed from: e, reason: collision with root package name */
    public byte f25217e;

    /* renamed from: f, reason: collision with root package name */
    public long f25218f;

    /* renamed from: g, reason: collision with root package name */
    public byte f25219g;

    /* renamed from: h, reason: collision with root package name */
    public byte f25220h;

    /* renamed from: i, reason: collision with root package name */
    public int f25221i;

    public d() {
        this.f25213a = "";
        this.f25214b = 0L;
        this.f25215c = (short) 0;
        this.f25216d = (short) 0;
        this.f25217e = (byte) 0;
        this.f25218f = 0L;
        this.f25219g = (byte) 0;
        this.f25220h = (byte) 0;
        this.f25221i = 64;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f25213a = jceInputStream.readString(1, true);
        this.f25214b = jceInputStream.read(this.f25214b, 2, true);
        this.f25215c = jceInputStream.read(this.f25215c, 3, true);
        this.f25216d = jceInputStream.read(this.f25216d, 4, true);
        this.f25217e = jceInputStream.read(this.f25217e, 5, true);
        this.f25218f = jceInputStream.read(this.f25218f, 6, false);
        this.f25219g = jceInputStream.read(this.f25219g, 7, false);
        this.f25220h = jceInputStream.read(this.f25220h, 8, false);
        this.f25221i = jceInputStream.read(this.f25221i, 9, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f25213a, 1);
        jceOutputStream.write(this.f25214b, 2);
        jceOutputStream.write(this.f25215c, 3);
        jceOutputStream.write(this.f25216d, 4);
        jceOutputStream.write(this.f25217e, 5);
        jceOutputStream.write(this.f25218f, 6);
        jceOutputStream.write(this.f25219g, 7);
        jceOutputStream.write(this.f25220h, 8);
        jceOutputStream.write(this.f25221i, 9);
    }

    public d(String str, long j3, short s16, short s17, byte b16, long j16, byte b17, byte b18, int i3) {
        this.f25213a = str;
        this.f25214b = j3;
        this.f25215c = s16;
        this.f25216d = s17;
        this.f25217e = b16;
        this.f25218f = j16;
        this.f25219g = b17;
        this.f25220h = b18;
        this.f25221i = i3;
    }
}
