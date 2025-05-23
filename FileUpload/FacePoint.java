package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class FacePoint extends JceStruct {

    /* renamed from: x, reason: collision with root package name */
    public int f24897x;

    /* renamed from: y, reason: collision with root package name */
    public int f24898y;

    public FacePoint() {
        this.f24897x = 0;
        this.f24898y = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f24897x = jceInputStream.read(this.f24897x, 1, true);
        this.f24898y = jceInputStream.read(this.f24898y, 2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f24897x, 1);
        jceOutputStream.write(this.f24898y, 2);
    }

    public FacePoint(int i3, int i16) {
        this.f24897x = i3;
        this.f24898y = i16;
    }
}
