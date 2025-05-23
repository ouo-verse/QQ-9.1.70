package NS_NEW_MOBILE_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class Terminal extends JceStruct {
    public String androidId;
    public String imei;
    public String imei2;
    public String imsi;
    public String imsi2;
    public String macAddress;
    public String manufacture;
    public String mid;
    public String mode;
    public String qimei;

    public Terminal() {
        this.imei = "";
        this.macAddress = "";
        this.androidId = "";
        this.imsi = "";
        this.mid = "";
        this.imsi2 = "";
        this.imei2 = "";
        this.mode = "";
        this.manufacture = "";
        this.qimei = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.imei = jceInputStream.readString(0, false);
        this.macAddress = jceInputStream.readString(1, false);
        this.androidId = jceInputStream.readString(2, false);
        this.imsi = jceInputStream.readString(3, false);
        this.mid = jceInputStream.readString(4, false);
        this.imsi2 = jceInputStream.readString(5, false);
        this.imei2 = jceInputStream.readString(6, false);
        this.mode = jceInputStream.readString(7, false);
        this.manufacture = jceInputStream.readString(8, false);
        this.qimei = jceInputStream.readString(9, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.imei;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.macAddress;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.androidId;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        String str4 = this.imsi;
        if (str4 != null) {
            jceOutputStream.write(str4, 3);
        }
        String str5 = this.mid;
        if (str5 != null) {
            jceOutputStream.write(str5, 4);
        }
        String str6 = this.imsi2;
        if (str6 != null) {
            jceOutputStream.write(str6, 5);
        }
        String str7 = this.imei2;
        if (str7 != null) {
            jceOutputStream.write(str7, 6);
        }
        String str8 = this.mode;
        if (str8 != null) {
            jceOutputStream.write(str8, 7);
        }
        String str9 = this.manufacture;
        if (str9 != null) {
            jceOutputStream.write(str9, 8);
        }
        String str10 = this.qimei;
        if (str10 != null) {
            jceOutputStream.write(str10, 9);
        }
    }

    public Terminal(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        this.imei = str;
        this.macAddress = str2;
        this.androidId = str3;
        this.imsi = str4;
        this.mid = str5;
        this.imsi2 = str6;
        this.imei2 = str7;
        this.mode = str8;
        this.manufacture = str9;
        this.qimei = str10;
    }
}
