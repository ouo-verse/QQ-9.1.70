package a.a.b.a.a.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class a extends JceStruct {

    /* renamed from: a, reason: collision with root package name */
    public long f25167a;

    /* renamed from: b, reason: collision with root package name */
    public int f25168b;

    public a() {
        this.f25167a = 0L;
        this.f25168b = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f25167a = jceInputStream.read(this.f25167a, 0, false);
        this.f25168b = jceInputStream.read(this.f25168b, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f25167a, 0);
        jceOutputStream.write(this.f25168b, 1);
    }

    public a(long j3, int i3) {
        this.f25167a = j3;
        this.f25168b = i3;
    }
}
