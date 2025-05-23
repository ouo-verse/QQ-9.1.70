package CommonClientInterface;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stReqComm extends JceStruct {
    public int iAppId;
    public int iAuthType;
    public int iPlat;
    public String sAppVersion;
    public String sDeviceID;
    public String sDeviceName;
    public String sOSVersion;
    public String sReserved1;
    public String sReserved2;
    public String sSessionKey;
    public String sUid;

    public stReqComm() {
        this.iAppId = 0;
        this.iPlat = 0;
        this.sAppVersion = "";
        this.sDeviceName = "";
        this.sOSVersion = "";
        this.sDeviceID = "";
        this.iAuthType = 0;
        this.sUid = "";
        this.sSessionKey = "";
        this.sReserved1 = "";
        this.sReserved2 = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iAppId = jceInputStream.read(this.iAppId, 0, true);
        this.iPlat = jceInputStream.read(this.iPlat, 1, true);
        this.sAppVersion = jceInputStream.readString(2, true);
        this.sDeviceName = jceInputStream.readString(3, true);
        this.sOSVersion = jceInputStream.readString(4, true);
        this.sDeviceID = jceInputStream.readString(5, true);
        this.iAuthType = jceInputStream.read(this.iAuthType, 6, false);
        this.sUid = jceInputStream.readString(7, false);
        this.sSessionKey = jceInputStream.readString(8, false);
        this.sReserved1 = jceInputStream.readString(9, false);
        this.sReserved2 = jceInputStream.readString(10, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iAppId, 0);
        jceOutputStream.write(this.iPlat, 1);
        jceOutputStream.write(this.sAppVersion, 2);
        jceOutputStream.write(this.sDeviceName, 3);
        jceOutputStream.write(this.sOSVersion, 4);
        jceOutputStream.write(this.sDeviceID, 5);
        jceOutputStream.write(this.iAuthType, 6);
        String str = this.sUid;
        if (str != null) {
            jceOutputStream.write(str, 7);
        }
        String str2 = this.sSessionKey;
        if (str2 != null) {
            jceOutputStream.write(str2, 8);
        }
        String str3 = this.sReserved1;
        if (str3 != null) {
            jceOutputStream.write(str3, 9);
        }
        String str4 = this.sReserved2;
        if (str4 != null) {
            jceOutputStream.write(str4, 10);
        }
    }

    public stReqComm(int i3, int i16, String str, String str2, String str3, String str4, int i17, String str5, String str6, String str7, String str8) {
        this.iAppId = i3;
        this.iPlat = i16;
        this.sAppVersion = str;
        this.sDeviceName = str2;
        this.sOSVersion = str3;
        this.sDeviceID = str4;
        this.iAuthType = i17;
        this.sUid = str5;
        this.sSessionKey = str6;
        this.sReserved1 = str7;
        this.sReserved2 = str8;
    }
}
