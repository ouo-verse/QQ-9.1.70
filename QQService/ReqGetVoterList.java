package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ReqGetVoterList extends JceStruct {
    static ReqHead cache_stHeader;
    static UserCntlData cache_stUserData;
    public int iPageSize;
    public ReqHead stHeader;
    public UserCntlData stUserData;

    public ReqGetVoterList() {
        this.stHeader = null;
        this.stUserData = null;
        this.iPageSize = -1;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_stHeader == null) {
            cache_stHeader = new ReqHead();
        }
        this.stHeader = (ReqHead) jceInputStream.read((JceStruct) cache_stHeader, 0, true);
        if (cache_stUserData == null) {
            cache_stUserData = new UserCntlData();
        }
        this.stUserData = (UserCntlData) jceInputStream.read((JceStruct) cache_stUserData, 1, false);
        this.iPageSize = jceInputStream.read(this.iPageSize, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.stHeader, 0);
        UserCntlData userCntlData = this.stUserData;
        if (userCntlData != null) {
            jceOutputStream.write((JceStruct) userCntlData, 1);
        }
        jceOutputStream.write(this.iPageSize, 2);
    }

    public ReqGetVoterList(ReqHead reqHead, UserCntlData userCntlData, int i3) {
        this.stHeader = reqHead;
        this.stUserData = userCntlData;
        this.iPageSize = i3;
    }
}
