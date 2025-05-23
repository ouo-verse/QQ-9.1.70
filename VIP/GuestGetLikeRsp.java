package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GuestGetLikeRsp extends JceStruct {
    static CommRsp cache_errInfo = new CommRsp();
    public boolean canLike;
    public CommRsp errInfo;
    public boolean hasLiked;

    public GuestGetLikeRsp() {
        this.errInfo = null;
        this.canLike = true;
        this.hasLiked = true;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.errInfo = (CommRsp) jceInputStream.read((JceStruct) cache_errInfo, 0, false);
        this.canLike = jceInputStream.read(this.canLike, 1, false);
        this.hasLiked = jceInputStream.read(this.hasLiked, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        CommRsp commRsp = this.errInfo;
        if (commRsp != null) {
            jceOutputStream.write((JceStruct) commRsp, 0);
        }
        jceOutputStream.write(this.canLike, 1);
        jceOutputStream.write(this.hasLiked, 2);
    }

    public GuestGetLikeRsp(CommRsp commRsp, boolean z16, boolean z17) {
        this.errInfo = commRsp;
        this.canLike = z16;
        this.hasLiked = z17;
    }
}
