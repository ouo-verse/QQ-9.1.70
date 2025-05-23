package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class MultiPicInfo extends JceStruct {
    public int iBatUploadNum;
    public int iCurUpload;
    public int iFailNum;
    public int iSuccNum;

    public MultiPicInfo() {
        this.iBatUploadNum = 0;
        this.iCurUpload = 0;
        this.iSuccNum = 0;
        this.iFailNum = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iBatUploadNum = jceInputStream.read(this.iBatUploadNum, 0, false);
        this.iCurUpload = jceInputStream.read(this.iCurUpload, 1, false);
        this.iSuccNum = jceInputStream.read(this.iSuccNum, 2, false);
        this.iFailNum = jceInputStream.read(this.iFailNum, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iBatUploadNum, 0);
        jceOutputStream.write(this.iCurUpload, 1);
        jceOutputStream.write(this.iSuccNum, 2);
        jceOutputStream.write(this.iFailNum, 3);
    }

    public MultiPicInfo(int i3, int i16, int i17, int i18) {
        this.iBatUploadNum = i3;
        this.iCurUpload = i16;
        this.iSuccNum = i17;
        this.iFailNum = i18;
    }
}
