package LBSClientInterfaceV2;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class stGetPoiInfoReq extends JceStruct {
    static stGPS cache_stGps;
    public int iAccuracy;
    public int iDistance;
    public int iLocateCostTime;
    public int iNum;
    public int iPage;
    public stGPS stGps;
    public String strClientIP;
    public String strKeyWord;

    public stGetPoiInfoReq() {
        this.stGps = null;
        this.strClientIP = "";
        this.strKeyWord = "";
        this.iDistance = 100;
        this.iPage = 1;
        this.iNum = 30;
        this.iAccuracy = 0;
        this.iLocateCostTime = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_stGps == null) {
            cache_stGps = new stGPS();
        }
        this.stGps = (stGPS) jceInputStream.read((JceStruct) cache_stGps, 0, true);
        this.strClientIP = jceInputStream.readString(1, true);
        this.strKeyWord = jceInputStream.readString(2, true);
        this.iDistance = jceInputStream.read(this.iDistance, 3, true);
        this.iPage = jceInputStream.read(this.iPage, 4, true);
        this.iNum = jceInputStream.read(this.iNum, 5, true);
        this.iAccuracy = jceInputStream.read(this.iAccuracy, 6, false);
        this.iLocateCostTime = jceInputStream.read(this.iLocateCostTime, 7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.stGps, 0);
        jceOutputStream.write(this.strClientIP, 1);
        jceOutputStream.write(this.strKeyWord, 2);
        jceOutputStream.write(this.iDistance, 3);
        jceOutputStream.write(this.iPage, 4);
        jceOutputStream.write(this.iNum, 5);
        jceOutputStream.write(this.iAccuracy, 6);
        jceOutputStream.write(this.iLocateCostTime, 7);
    }

    public stGetPoiInfoReq(stGPS stgps, String str, String str2, int i3, int i16, int i17, int i18, int i19) {
        this.stGps = stgps;
        this.strClientIP = str;
        this.strKeyWord = str2;
        this.iDistance = i3;
        this.iPage = i16;
        this.iNum = i17;
        this.iAccuracy = i18;
        this.iLocateCostTime = i19;
    }
}
