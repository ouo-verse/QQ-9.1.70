package NS_MOBILE_CUSTOM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CustomColor extends JceStruct {

    /* renamed from: a, reason: collision with root package name */
    public byte f24973a;

    /* renamed from: b, reason: collision with root package name */
    public byte f24974b;

    /* renamed from: g, reason: collision with root package name */
    public byte f24975g;

    /* renamed from: r, reason: collision with root package name */
    public byte f24976r;

    public CustomColor() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f24973a = jceInputStream.read(this.f24973a, 0, false);
        this.f24976r = jceInputStream.read(this.f24976r, 1, false);
        this.f24975g = jceInputStream.read(this.f24975g, 2, false);
        this.f24974b = jceInputStream.read(this.f24974b, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f24973a, 0);
        jceOutputStream.write(this.f24976r, 1);
        jceOutputStream.write(this.f24975g, 2);
        jceOutputStream.write(this.f24974b, 3);
    }

    public CustomColor(byte b16, byte b17, byte b18, byte b19) {
        this.f24973a = b16;
        this.f24976r = b17;
        this.f24975g = b18;
        this.f24974b = b19;
    }
}
