package AccostSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class PengYouInfo extends JceStruct {
    public String strDescription;
    public String strPYFaceUrl;
    public String strPYName;

    public PengYouInfo() {
        this.strPYName = "";
        this.strPYFaceUrl = "";
        this.strDescription = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.strPYName = jceInputStream.readString(0, true);
        this.strPYFaceUrl = jceInputStream.readString(1, true);
        this.strDescription = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.strPYName, 0);
        jceOutputStream.write(this.strPYFaceUrl, 1);
        String str = this.strDescription;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
    }

    public PengYouInfo(String str, String str2, String str3) {
        this.strPYName = str;
        this.strPYFaceUrl = str2;
        this.strDescription = str3;
    }
}
