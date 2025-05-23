package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class AuthResultInfo extends JceStruct {
    public String authmsg;
    public int authret;
    public String authurl;

    public AuthResultInfo() {
        this.authret = 0;
        this.authmsg = "";
        this.authurl = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.authret = jceInputStream.read(this.authret, 0, false);
        this.authmsg = jceInputStream.readString(1, false);
        this.authurl = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.authret, 0);
        String str = this.authmsg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.authurl;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
    }

    public AuthResultInfo(int i3, String str, String str2) {
        this.authret = i3;
        this.authmsg = str;
        this.authurl = str2;
    }
}
