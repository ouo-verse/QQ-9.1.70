package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ReqGetFace extends JceStruct {
    static ReqHead cache_stHeader;
    static UserCntlData cache_stUserData;
    public int iPageSize;
    public long lUIN;
    public ReqHead stHeader;
    public UserCntlData stUserData;

    public ReqGetFace() {
        this.stHeader = null;
        this.lUIN = 0L;
        this.stUserData = null;
        this.iPageSize = -1;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_stHeader == null) {
            cache_stHeader = new ReqHead();
        }
        this.stHeader = (ReqHead) jceInputStream.read((JceStruct) cache_stHeader, 0, true);
        this.lUIN = jceInputStream.read(this.lUIN, 1, true);
        if (cache_stUserData == null) {
            cache_stUserData = new UserCntlData();
        }
        this.stUserData = (UserCntlData) jceInputStream.read((JceStruct) cache_stUserData, 2, false);
        this.iPageSize = jceInputStream.read(this.iPageSize, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.stHeader, 0);
        jceOutputStream.write(this.lUIN, 1);
        UserCntlData userCntlData = this.stUserData;
        if (userCntlData != null) {
            jceOutputStream.write((JceStruct) userCntlData, 2);
        }
        jceOutputStream.write(this.iPageSize, 3);
    }

    public ReqGetFace(ReqHead reqHead, long j3, UserCntlData userCntlData, int i3) {
        this.stHeader = reqHead;
        this.lUIN = j3;
        this.stUserData = userCntlData;
        this.iPageSize = i3;
    }
}
