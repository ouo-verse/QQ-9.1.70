package LBSClientInterfaceV2;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class stGetPositionRsp extends JceStruct {
    static stGeoInfo cache_stGeoInfo;
    static stGPS cache_stUsrLoc;
    public stGeoInfo stGeoInfo;
    public stGPS stUsrLoc;

    public stGetPositionRsp() {
        this.stUsrLoc = null;
        this.stGeoInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_stUsrLoc == null) {
            cache_stUsrLoc = new stGPS();
        }
        this.stUsrLoc = (stGPS) jceInputStream.read((JceStruct) cache_stUsrLoc, 0, true);
        if (cache_stGeoInfo == null) {
            cache_stGeoInfo = new stGeoInfo();
        }
        this.stGeoInfo = (stGeoInfo) jceInputStream.read((JceStruct) cache_stGeoInfo, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.stUsrLoc, 0);
        jceOutputStream.write((JceStruct) this.stGeoInfo, 1);
    }

    public stGetPositionRsp(stGPS stgps, stGeoInfo stgeoinfo) {
        this.stUsrLoc = stgps;
        this.stGeoInfo = stgeoinfo;
    }
}
