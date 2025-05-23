package NearbyGroup;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class Attr extends JceStruct {
    public String strImei;
    public String strImsi;
    public String strPhonenum;

    public Attr() {
        this.strImei = "";
        this.strImsi = "";
        this.strPhonenum = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.strImei = jceInputStream.readString(0, false);
        this.strImsi = jceInputStream.readString(1, false);
        this.strPhonenum = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.strImei;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.strImsi;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.strPhonenum;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
    }

    public Attr(String str, String str2, String str3) {
        this.strImei = str;
        this.strImsi = str2;
        this.strPhonenum = str3;
    }
}
