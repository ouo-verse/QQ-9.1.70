package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class stPhotoSepcInfo extends JceStruct {
    public long iPhotoHeight;
    public long iPhotoSize;
    public long iPhotoType;
    public long iPhotoWidth;

    public stPhotoSepcInfo() {
        this.iPhotoSize = 0L;
        this.iPhotoWidth = 0L;
        this.iPhotoHeight = 0L;
        this.iPhotoType = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iPhotoSize = jceInputStream.read(this.iPhotoSize, 0, true);
        this.iPhotoWidth = jceInputStream.read(this.iPhotoWidth, 1, true);
        this.iPhotoHeight = jceInputStream.read(this.iPhotoHeight, 2, true);
        this.iPhotoType = jceInputStream.read(this.iPhotoType, 3, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iPhotoSize, 0);
        jceOutputStream.write(this.iPhotoWidth, 1);
        jceOutputStream.write(this.iPhotoHeight, 2);
        jceOutputStream.write(this.iPhotoType, 3);
    }

    public stPhotoSepcInfo(long j3, long j16, long j17, long j18) {
        this.iPhotoSize = j3;
        this.iPhotoWidth = j16;
        this.iPhotoHeight = j17;
        this.iPhotoType = j18;
    }
}
