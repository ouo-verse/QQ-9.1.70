package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class HostGetLikeRsp extends JceStruct {
    static CommRsp cache_errInfo = new CommRsp();
    public boolean canLike;
    public CommRsp errInfo;
    public boolean hasLiked;
    public long iTotal;

    public HostGetLikeRsp() {
        this.errInfo = null;
        this.iTotal = 0L;
        this.canLike = true;
        this.hasLiked = true;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.errInfo = (CommRsp) jceInputStream.read((JceStruct) cache_errInfo, 0, false);
        this.iTotal = jceInputStream.read(this.iTotal, 1, false);
        this.canLike = jceInputStream.read(this.canLike, 2, false);
        this.hasLiked = jceInputStream.read(this.hasLiked, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        CommRsp commRsp = this.errInfo;
        if (commRsp != null) {
            jceOutputStream.write((JceStruct) commRsp, 0);
        }
        jceOutputStream.write(this.iTotal, 1);
        jceOutputStream.write(this.canLike, 2);
        jceOutputStream.write(this.hasLiked, 3);
    }

    public HostGetLikeRsp(CommRsp commRsp, long j3, boolean z16, boolean z17) {
        this.errInfo = commRsp;
        this.iTotal = j3;
        this.canLike = z16;
        this.hasLiked = z17;
    }
}
