package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class GetTroopInfoReq extends JceStruct {
    public long GroupCode;
    public long GroupUin;
    public byte isneedstatus;
    public long uin;

    public GetTroopInfoReq() {
        this.uin = 0L;
        this.GroupCode = 0L;
        this.GroupUin = 0L;
        this.isneedstatus = (byte) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, true);
        this.GroupCode = jceInputStream.read(this.GroupCode, 1, true);
        this.GroupUin = jceInputStream.read(this.GroupUin, 2, true);
        this.isneedstatus = jceInputStream.read(this.isneedstatus, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.GroupCode, 1);
        jceOutputStream.write(this.GroupUin, 2);
        jceOutputStream.write(this.isneedstatus, 3);
    }

    public GetTroopInfoReq(long j3, long j16, long j17, byte b16) {
        this.uin = j3;
        this.GroupCode = j16;
        this.GroupUin = j17;
        this.isneedstatus = b16;
    }
}
