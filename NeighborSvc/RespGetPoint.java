package NeighborSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class RespGetPoint extends JceStruct {
    static GPS cache_stGps;
    static UserDetailLocalInfo cache_stUDLinfo;
    public GPS stGps;
    public UserDetailLocalInfo stUDLinfo;

    public RespGetPoint() {
        this.stGps = null;
        this.stUDLinfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_stGps == null) {
            cache_stGps = new GPS();
        }
        this.stGps = (GPS) jceInputStream.read((JceStruct) cache_stGps, 0, true);
        if (cache_stUDLinfo == null) {
            cache_stUDLinfo = new UserDetailLocalInfo();
        }
        this.stUDLinfo = (UserDetailLocalInfo) jceInputStream.read((JceStruct) cache_stUDLinfo, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.stGps, 0);
        UserDetailLocalInfo userDetailLocalInfo = this.stUDLinfo;
        if (userDetailLocalInfo != null) {
            jceOutputStream.write((JceStruct) userDetailLocalInfo, 1);
        }
    }

    public RespGetPoint(GPS gps, UserDetailLocalInfo userDetailLocalInfo) {
        this.stGps = gps;
        this.stUDLinfo = userDetailLocalInfo;
    }
}
