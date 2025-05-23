package PasserbySvc;

import NeighborComm.ReqHeader;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ReqCheckIn extends JceStruct {
    static ReqHeader cache_stHeader;
    static ReqUserInfo cache_stUserInfo;
    public ReqHeader stHeader;
    public ReqUserInfo stUserInfo;

    public ReqCheckIn() {
        this.stHeader = null;
        this.stUserInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_stHeader == null) {
            cache_stHeader = new ReqHeader();
        }
        this.stHeader = (ReqHeader) jceInputStream.read((JceStruct) cache_stHeader, 0, true);
        if (cache_stUserInfo == null) {
            cache_stUserInfo = new ReqUserInfo();
        }
        this.stUserInfo = (ReqUserInfo) jceInputStream.read((JceStruct) cache_stUserInfo, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.stHeader, 0);
        jceOutputStream.write((JceStruct) this.stUserInfo, 1);
    }

    public ReqCheckIn(ReqHeader reqHeader, ReqUserInfo reqUserInfo) {
        this.stHeader = reqHeader;
        this.stUserInfo = reqUserInfo;
    }
}
