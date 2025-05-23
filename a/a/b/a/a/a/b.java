package a.a.b.a.a.a;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class b extends JceStruct {

    /* renamed from: a, reason: collision with root package name */
    public byte f25162a;

    /* renamed from: b, reason: collision with root package name */
    public String f25163b;

    /* renamed from: c, reason: collision with root package name */
    public long f25164c;

    /* renamed from: d, reason: collision with root package name */
    public long f25165d;

    /* renamed from: e, reason: collision with root package name */
    public long f25166e;

    public b() {
        this.f25162a = (byte) 0;
        this.f25163b = "";
        this.f25164c = 0L;
        this.f25165d = 0L;
        this.f25166e = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f25162a = jceInputStream.read(this.f25162a, 0, true);
        this.f25163b = jceInputStream.readString(1, false);
        this.f25164c = jceInputStream.read(this.f25164c, 2, false);
        this.f25165d = jceInputStream.read(this.f25165d, 3, false);
        this.f25166e = jceInputStream.read(this.f25166e, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f25162a, 0);
        String str = this.f25163b;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.f25164c, 2);
        jceOutputStream.write(this.f25165d, 3);
        jceOutputStream.write(this.f25166e, 4);
    }

    public b(byte b16, String str, long j3, long j16, long j17) {
        this.f25162a = b16;
        this.f25163b = str;
        this.f25164c = j3;
        this.f25165d = j16;
        this.f25166e = j17;
    }
}
