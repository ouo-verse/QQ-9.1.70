package MOBILE_QZMALL_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class VideoUrl extends JceStruct {
    public String strContentUrl;
    public String strCoverUrl;

    public VideoUrl() {
        this.strContentUrl = "";
        this.strCoverUrl = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.strContentUrl = jceInputStream.readString(0, false);
        this.strCoverUrl = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.strContentUrl;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.strCoverUrl;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
    }

    public VideoUrl(String str, String str2) {
        this.strContentUrl = str;
        this.strCoverUrl = str2;
    }
}
