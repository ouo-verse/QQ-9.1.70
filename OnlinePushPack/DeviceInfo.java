package OnlinePushPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class DeviceInfo extends JceStruct {
    public byte cNetType;
    public String strDevType;
    public String strIOSIdfa;
    public String strOSVer;
    public String strVendorName;
    public String strVendorOSName;

    public DeviceInfo() {
        this.cNetType = (byte) 0;
        this.strDevType = "";
        this.strOSVer = "";
        this.strVendorName = "";
        this.strVendorOSName = "";
        this.strIOSIdfa = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.cNetType = jceInputStream.read(this.cNetType, 0, false);
        this.strDevType = jceInputStream.readString(1, false);
        this.strOSVer = jceInputStream.readString(2, false);
        this.strVendorName = jceInputStream.readString(3, false);
        this.strVendorOSName = jceInputStream.readString(4, false);
        this.strIOSIdfa = jceInputStream.readString(5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.cNetType, 0);
        String str = this.strDevType;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.strOSVer;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.strVendorName;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        String str4 = this.strVendorOSName;
        if (str4 != null) {
            jceOutputStream.write(str4, 4);
        }
        String str5 = this.strIOSIdfa;
        if (str5 != null) {
            jceOutputStream.write(str5, 5);
        }
    }

    public DeviceInfo(byte b16, String str, String str2, String str3, String str4, String str5) {
        this.cNetType = b16;
        this.strDevType = str;
        this.strOSVer = str2;
        this.strVendorName = str3;
        this.strVendorOSName = str4;
        this.strIOSIdfa = str5;
    }
}
