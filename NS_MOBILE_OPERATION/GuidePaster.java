package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class GuidePaster extends JceStruct {
    public String pasterId;
    public String url;

    public GuidePaster() {
        this.url = "";
        this.pasterId = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.url = jceInputStream.readString(0, false);
        this.pasterId = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.url;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.pasterId;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
    }

    public GuidePaster(String str, String str2) {
        this.url = str;
        this.pasterId = str2;
    }
}
