package MAAccessClient;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class AcCode extends JceStruct {
    public String appid;
    public String imei;
    public String random;
    public int versionCode;

    public AcCode() {
        this.imei = "";
        this.appid = "";
        this.random = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.imei = jceInputStream.readString(0, false);
        this.appid = jceInputStream.readString(1, false);
        this.random = jceInputStream.readString(2, false);
        this.versionCode = jceInputStream.read(this.versionCode, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.imei;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.appid;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.random;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        jceOutputStream.write(this.versionCode, 3);
    }

    public AcCode(String str, String str2, String str3, int i3) {
        this.imei = str;
        this.appid = str2;
        this.random = str3;
        this.versionCode = i3;
    }
}
