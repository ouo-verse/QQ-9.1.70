package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stDevice extends JceStruct {
    public String encrypted_deviceid;
    public String idfa;
    public String imei;
    public String qimei;

    public stDevice() {
        this.encrypted_deviceid = "";
        this.imei = "";
        this.idfa = "";
        this.qimei = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.encrypted_deviceid = jceInputStream.readString(0, false);
        this.imei = jceInputStream.readString(1, false);
        this.idfa = jceInputStream.readString(2, false);
        this.qimei = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.encrypted_deviceid;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.imei;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.idfa;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        String str4 = this.qimei;
        if (str4 != null) {
            jceOutputStream.write(str4, 3);
        }
    }

    public stDevice(String str, String str2, String str3, String str4) {
        this.encrypted_deviceid = str;
        this.imei = str2;
        this.idfa = str3;
        this.qimei = str4;
    }
}
