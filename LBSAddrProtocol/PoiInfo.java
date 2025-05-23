package LBSAddrProtocol;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class PoiInfo extends JceStruct {
    public int iDistance;
    public int iDistrictCode;
    public int iHotValue;
    public int iLat;
    public int iLon;
    public int iType;
    public long lId;
    public String strAddress;
    public String strName;
    public String strPhone;
    public String strTypeName;

    public PoiInfo() {
        this.lId = 0L;
        this.strName = "";
        this.iType = 0;
        this.strTypeName = "";
        this.strAddress = "";
        this.iDistrictCode = 0;
        this.iLat = 0;
        this.iLon = 0;
        this.iDistance = 0;
        this.iHotValue = 0;
        this.strPhone = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lId = jceInputStream.read(this.lId, 0, true);
        this.strName = jceInputStream.readString(1, true);
        this.iType = jceInputStream.read(this.iType, 2, true);
        this.strTypeName = jceInputStream.readString(3, true);
        this.strAddress = jceInputStream.readString(4, true);
        this.iDistrictCode = jceInputStream.read(this.iDistrictCode, 5, true);
        this.iLat = jceInputStream.read(this.iLat, 6, true);
        this.iLon = jceInputStream.read(this.iLon, 7, true);
        this.iDistance = jceInputStream.read(this.iDistance, 8, true);
        this.iHotValue = jceInputStream.read(this.iHotValue, 9, false);
        this.strPhone = jceInputStream.readString(10, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lId, 0);
        jceOutputStream.write(this.strName, 1);
        jceOutputStream.write(this.iType, 2);
        jceOutputStream.write(this.strTypeName, 3);
        jceOutputStream.write(this.strAddress, 4);
        jceOutputStream.write(this.iDistrictCode, 5);
        jceOutputStream.write(this.iLat, 6);
        jceOutputStream.write(this.iLon, 7);
        jceOutputStream.write(this.iDistance, 8);
        jceOutputStream.write(this.iHotValue, 9);
        String str = this.strPhone;
        if (str != null) {
            jceOutputStream.write(str, 10);
        }
    }

    public PoiInfo(long j3, String str, int i3, String str2, String str3, int i16, int i17, int i18, int i19, int i26, String str4) {
        this.lId = j3;
        this.strName = str;
        this.iType = i3;
        this.strTypeName = str2;
        this.strAddress = str3;
        this.iDistrictCode = i16;
        this.iLat = i17;
        this.iLon = i18;
        this.iDistance = i19;
        this.iHotValue = i26;
        this.strPhone = str4;
    }
}
