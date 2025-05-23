package a.a.b.a.a.e;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class b extends JceStruct {

    /* renamed from: e, reason: collision with root package name */
    static int f25198e;

    /* renamed from: a, reason: collision with root package name */
    public int f25199a;

    /* renamed from: b, reason: collision with root package name */
    public int f25200b;

    /* renamed from: c, reason: collision with root package name */
    public int f25201c;

    /* renamed from: d, reason: collision with root package name */
    public int f25202d;

    public b() {
        this.f25199a = 900000000;
        this.f25200b = 900000000;
        this.f25201c = -10000000;
        this.f25202d = c.f25204e.a();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f25199a = jceInputStream.read(this.f25199a, 0, true);
        this.f25200b = jceInputStream.read(this.f25200b, 1, true);
        this.f25201c = jceInputStream.read(this.f25201c, 2, true);
        this.f25202d = jceInputStream.read(this.f25202d, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f25199a, 0);
        jceOutputStream.write(this.f25200b, 1);
        jceOutputStream.write(this.f25201c, 2);
        jceOutputStream.write(this.f25202d, 3);
    }

    public b(int i3, int i16, int i17, int i18) {
        this.f25199a = 900000000;
        this.f25200b = 900000000;
        this.f25201c = -10000000;
        c.f25204e.a();
        this.f25199a = i3;
        this.f25200b = i16;
        this.f25201c = i17;
        this.f25202d = i18;
    }
}
