package LBSClientInterfaceV2;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class stAddPoiTraceReq extends JceStruct {
    static stGPS cache_stGps;
    public stGPS stGps;
    public String strPoiId;

    public stAddPoiTraceReq() {
        this.strPoiId = "";
        this.stGps = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.strPoiId = jceInputStream.readString(0, true);
        if (cache_stGps == null) {
            cache_stGps = new stGPS();
        }
        this.stGps = (stGPS) jceInputStream.read((JceStruct) cache_stGps, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.strPoiId, 0);
        stGPS stgps = this.stGps;
        if (stgps != null) {
            jceOutputStream.write((JceStruct) stgps, 1);
        }
    }

    public stAddPoiTraceReq(String str, stGPS stgps) {
        this.strPoiId = str;
        this.stGps = stgps;
    }
}
