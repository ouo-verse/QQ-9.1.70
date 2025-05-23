package friendlist;

import PasserbySvc.ReqCheckIn;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class GetSimpleOnlineFriendInfoReq extends JceStruct {
    static ReqCheckIn cache_stReqCheckIn;
    public byte cSrcType;
    public byte ifShowTermType;
    public byte ifgetFriendVideoAbi;
    public byte isReqCheckIn;
    public ReqCheckIn stReqCheckIn;
    public long uin;
    public long version;

    public GetSimpleOnlineFriendInfoReq() {
        this.uin = 0L;
        this.ifgetFriendVideoAbi = (byte) 0;
        this.isReqCheckIn = (byte) 0;
        this.stReqCheckIn = null;
        this.ifShowTermType = (byte) 0;
        this.version = 0L;
        this.cSrcType = (byte) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, true);
        this.ifgetFriendVideoAbi = jceInputStream.read(this.ifgetFriendVideoAbi, 1, false);
        this.isReqCheckIn = jceInputStream.read(this.isReqCheckIn, 2, false);
        if (cache_stReqCheckIn == null) {
            cache_stReqCheckIn = new ReqCheckIn();
        }
        this.stReqCheckIn = (ReqCheckIn) jceInputStream.read((JceStruct) cache_stReqCheckIn, 3, false);
        this.ifShowTermType = jceInputStream.read(this.ifShowTermType, 4, false);
        this.version = jceInputStream.read(this.version, 5, false);
        this.cSrcType = jceInputStream.read(this.cSrcType, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.ifgetFriendVideoAbi, 1);
        jceOutputStream.write(this.isReqCheckIn, 2);
        ReqCheckIn reqCheckIn = this.stReqCheckIn;
        if (reqCheckIn != null) {
            jceOutputStream.write((JceStruct) reqCheckIn, 3);
        }
        jceOutputStream.write(this.ifShowTermType, 4);
        jceOutputStream.write(this.version, 5);
        jceOutputStream.write(this.cSrcType, 6);
    }

    public GetSimpleOnlineFriendInfoReq(long j3, byte b16, byte b17, ReqCheckIn reqCheckIn, byte b18, long j16, byte b19) {
        this.uin = j3;
        this.ifgetFriendVideoAbi = b16;
        this.isReqCheckIn = b17;
        this.stReqCheckIn = reqCheckIn;
        this.ifShowTermType = b18;
        this.version = j16;
        this.cSrcType = b19;
    }
}
