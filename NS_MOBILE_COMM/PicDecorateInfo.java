package NS_MOBILE_COMM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class PicDecorateInfo extends JceStruct {
    public int iType;
    public String strPlayZipUrl;
    public String strReverseUrl;

    public PicDecorateInfo() {
        this.iType = -1;
        this.strReverseUrl = "";
        this.strPlayZipUrl = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iType = jceInputStream.read(this.iType, 0, false);
        this.strReverseUrl = jceInputStream.readString(1, false);
        this.strPlayZipUrl = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iType, 0);
        String str = this.strReverseUrl;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.strPlayZipUrl;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
    }

    public PicDecorateInfo(int i3, String str, String str2) {
        this.iType = i3;
        this.strReverseUrl = str;
        this.strPlayZipUrl = str2;
    }
}
