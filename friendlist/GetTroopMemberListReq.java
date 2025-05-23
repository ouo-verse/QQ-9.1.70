package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class GetTroopMemberListReq extends JceStruct {
    public long GetListAppointTime;
    public long GroupCode;
    public long GroupUin;
    public long NextUin;
    public long ReqType;
    public byte UidVer;
    public long Version;
    public byte cRichCardNameVer;
    public long uin;

    public GetTroopMemberListReq() {
        this.uin = 0L;
        this.GroupCode = 0L;
        this.NextUin = 0L;
        this.GroupUin = 0L;
        this.Version = 0L;
        this.ReqType = 0L;
        this.GetListAppointTime = 0L;
        this.cRichCardNameVer = (byte) 0;
        this.UidVer = (byte) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, true);
        this.GroupCode = jceInputStream.read(this.GroupCode, 1, true);
        this.NextUin = jceInputStream.read(this.NextUin, 2, true);
        this.GroupUin = jceInputStream.read(this.GroupUin, 3, true);
        this.Version = jceInputStream.read(this.Version, 4, false);
        this.ReqType = jceInputStream.read(this.ReqType, 5, false);
        this.GetListAppointTime = jceInputStream.read(this.GetListAppointTime, 6, false);
        this.cRichCardNameVer = jceInputStream.read(this.cRichCardNameVer, 7, false);
        this.UidVer = jceInputStream.read(this.UidVer, 8, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.GroupCode, 1);
        jceOutputStream.write(this.NextUin, 2);
        jceOutputStream.write(this.GroupUin, 3);
        jceOutputStream.write(this.Version, 4);
        jceOutputStream.write(this.ReqType, 5);
        jceOutputStream.write(this.GetListAppointTime, 6);
        jceOutputStream.write(this.cRichCardNameVer, 7);
        jceOutputStream.write(this.UidVer, 8);
    }

    public GetTroopMemberListReq(long j3, long j16, long j17, long j18, long j19, long j26, long j27, byte b16, byte b17) {
        this.uin = j3;
        this.GroupCode = j16;
        this.NextUin = j17;
        this.GroupUin = j18;
        this.Version = j19;
        this.ReqType = j26;
        this.GetListAppointTime = j27;
        this.cRichCardNameVer = b16;
        this.UidVer = b17;
    }
}
