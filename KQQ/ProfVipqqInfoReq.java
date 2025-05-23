package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class ProfVipqqInfoReq extends JceStruct {
    public int iReloadFlag;
    public int iRetIncomPlete;
    public long iUin;

    public ProfVipqqInfoReq() {
        this.iUin = 0L;
        this.iRetIncomPlete = 0;
        this.iReloadFlag = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iUin = jceInputStream.read(this.iUin, 1, true);
        this.iRetIncomPlete = jceInputStream.read(this.iRetIncomPlete, 2, false);
        this.iReloadFlag = jceInputStream.read(this.iReloadFlag, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iUin, 1);
        jceOutputStream.write(this.iRetIncomPlete, 2);
        jceOutputStream.write(this.iReloadFlag, 3);
    }

    public ProfVipqqInfoReq(long j3, int i3, int i16) {
        this.iUin = j3;
        this.iRetIncomPlete = i3;
        this.iReloadFlag = i16;
    }
}
