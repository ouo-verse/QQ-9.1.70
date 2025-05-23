package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class FaceRect extends JceStruct {

    /* renamed from: h, reason: collision with root package name */
    public int f24899h;

    /* renamed from: w, reason: collision with root package name */
    public int f24900w;

    /* renamed from: x, reason: collision with root package name */
    public int f24901x;

    /* renamed from: y, reason: collision with root package name */
    public int f24902y;

    public FaceRect() {
        this.f24901x = 0;
        this.f24902y = 0;
        this.f24900w = 0;
        this.f24899h = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f24901x = jceInputStream.read(this.f24901x, 1, true);
        this.f24902y = jceInputStream.read(this.f24902y, 2, true);
        this.f24900w = jceInputStream.read(this.f24900w, 3, true);
        this.f24899h = jceInputStream.read(this.f24899h, 4, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f24901x, 1);
        jceOutputStream.write(this.f24902y, 2);
        jceOutputStream.write(this.f24900w, 3);
        jceOutputStream.write(this.f24899h, 4);
    }

    public FaceRect(int i3, int i16, int i17, int i18) {
        this.f24901x = i3;
        this.f24902y = i16;
        this.f24900w = i17;
        this.f24899h = i18;
    }
}
