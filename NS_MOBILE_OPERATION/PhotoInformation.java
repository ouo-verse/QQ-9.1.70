package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class PhotoInformation extends JceStruct {
    public int iHight;
    public int iPhotoType;
    public int iWidth;
    public String sUrl;

    public PhotoInformation() {
        this.sUrl = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.sUrl = jceInputStream.readString(0, false);
        this.iWidth = jceInputStream.read(this.iWidth, 1, false);
        this.iHight = jceInputStream.read(this.iHight, 2, false);
        this.iPhotoType = jceInputStream.read(this.iPhotoType, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.sUrl;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.iWidth, 1);
        jceOutputStream.write(this.iHight, 2);
        jceOutputStream.write(this.iPhotoType, 3);
    }

    public PhotoInformation(String str, int i3, int i16, int i17) {
        this.sUrl = str;
        this.iWidth = i3;
        this.iHight = i16;
        this.iPhotoType = i17;
    }
}
