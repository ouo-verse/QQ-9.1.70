package NeighborSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class ReqGetPoint extends JceStruct {
    static ReqUserInfo cache_stUserInfo;
    public byte bGetCityId;
    public byte bJiejingSOSO;
    public ReqUserInfo stUserInfo;

    public ReqGetPoint() {
        this.stUserInfo = null;
        this.bJiejingSOSO = (byte) 0;
        this.bGetCityId = (byte) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_stUserInfo == null) {
            cache_stUserInfo = new ReqUserInfo();
        }
        this.stUserInfo = (ReqUserInfo) jceInputStream.read((JceStruct) cache_stUserInfo, 0, true);
        this.bJiejingSOSO = jceInputStream.read(this.bJiejingSOSO, 1, false);
        this.bGetCityId = jceInputStream.read(this.bGetCityId, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.stUserInfo, 0);
        jceOutputStream.write(this.bJiejingSOSO, 1);
        jceOutputStream.write(this.bGetCityId, 2);
    }

    public ReqGetPoint(ReqUserInfo reqUserInfo, byte b16, byte b17) {
        this.stUserInfo = reqUserInfo;
        this.bJiejingSOSO = b16;
        this.bGetCityId = b17;
    }
}
