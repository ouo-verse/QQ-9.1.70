package LBSClientInterfaceV2;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stGetLbsCombinReq extends JceStruct {
    static stGPS cache_stGps;
    public int iAccuracy;
    public int iForecastDay;
    public int iLocateCostTime;
    public int iReqNum;
    public stGPS stGps;
    public String strClientIP;

    public stGetLbsCombinReq() {
        this.stGps = null;
        this.strClientIP = "";
        this.iReqNum = 30;
        this.iAccuracy = 0;
        this.iLocateCostTime = 0;
        this.iForecastDay = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_stGps == null) {
            cache_stGps = new stGPS();
        }
        this.stGps = (stGPS) jceInputStream.read((JceStruct) cache_stGps, 0, true);
        this.strClientIP = jceInputStream.readString(1, true);
        this.iReqNum = jceInputStream.read(this.iReqNum, 2, true);
        this.iAccuracy = jceInputStream.read(this.iAccuracy, 3, false);
        this.iLocateCostTime = jceInputStream.read(this.iLocateCostTime, 4, false);
        this.iForecastDay = jceInputStream.read(this.iForecastDay, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.stGps, 0);
        jceOutputStream.write(this.strClientIP, 1);
        jceOutputStream.write(this.iReqNum, 2);
        jceOutputStream.write(this.iAccuracy, 3);
        jceOutputStream.write(this.iLocateCostTime, 4);
        jceOutputStream.write(this.iForecastDay, 5);
    }

    public stGetLbsCombinReq(stGPS stgps, String str, int i3, int i16, int i17, int i18) {
        this.stGps = stgps;
        this.strClientIP = str;
        this.iReqNum = i3;
        this.iAccuracy = i16;
        this.iLocateCostTime = i17;
        this.iForecastDay = i18;
    }
}
