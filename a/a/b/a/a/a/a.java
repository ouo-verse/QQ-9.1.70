package a.a.b.a.a.a;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class a extends JceStruct {

    /* renamed from: a, reason: collision with root package name */
    public boolean f25159a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f25160b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f25161c;

    public a() {
        this.f25159a = true;
        this.f25160b = true;
        this.f25161c = true;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f25159a = jceInputStream.read(this.f25159a, 0, false);
        this.f25160b = jceInputStream.read(this.f25160b, 1, false);
        this.f25161c = jceInputStream.read(this.f25161c, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f25159a, 0);
        jceOutputStream.write(this.f25160b, 1);
        jceOutputStream.write(this.f25161c, 2);
    }

    public a(boolean z16, boolean z17, boolean z18) {
        this.f25159a = z16;
        this.f25160b = z17;
        this.f25161c = z18;
    }
}
