package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetLikeListRsp extends JceStruct {
    static CommRsp cache_errInfo = new CommRsp();
    static LikeListInfo cache_stLikeList = new LikeListInfo();
    public CommRsp errInfo;
    public long iTotal;
    public boolean isEnd;
    public String sCookie;
    public LikeListInfo stLikeList;

    public GetLikeListRsp() {
        this.errInfo = null;
        this.stLikeList = null;
        this.sCookie = "";
        this.isEnd = true;
        this.iTotal = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.errInfo = (CommRsp) jceInputStream.read((JceStruct) cache_errInfo, 0, false);
        this.stLikeList = (LikeListInfo) jceInputStream.read((JceStruct) cache_stLikeList, 1, false);
        this.sCookie = jceInputStream.readString(2, false);
        this.isEnd = jceInputStream.read(this.isEnd, 3, false);
        this.iTotal = jceInputStream.read(this.iTotal, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        CommRsp commRsp = this.errInfo;
        if (commRsp != null) {
            jceOutputStream.write((JceStruct) commRsp, 0);
        }
        LikeListInfo likeListInfo = this.stLikeList;
        if (likeListInfo != null) {
            jceOutputStream.write((JceStruct) likeListInfo, 1);
        }
        String str = this.sCookie;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        jceOutputStream.write(this.isEnd, 3);
        jceOutputStream.write(this.iTotal, 4);
    }

    public GetLikeListRsp(CommRsp commRsp, LikeListInfo likeListInfo, String str, boolean z16, long j3) {
        this.errInfo = commRsp;
        this.stLikeList = likeListInfo;
        this.sCookie = str;
        this.isEnd = z16;
        this.iTotal = j3;
    }
}
