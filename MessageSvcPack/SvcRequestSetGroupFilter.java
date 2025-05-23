package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SvcRequestSetGroupFilter extends JceStruct {
    public byte cOp;
    public byte cVerifyType;
    public long lGroupCode;
    public long lUin;

    public SvcRequestSetGroupFilter() {
        this.lUin = 0L;
        this.lGroupCode = 0L;
        this.cOp = (byte) 0;
        this.cVerifyType = (byte) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lUin = jceInputStream.read(this.lUin, 0, true);
        this.lGroupCode = jceInputStream.read(this.lGroupCode, 1, true);
        this.cOp = jceInputStream.read(this.cOp, 2, true);
        this.cVerifyType = jceInputStream.read(this.cVerifyType, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lUin, 0);
        jceOutputStream.write(this.lGroupCode, 1);
        jceOutputStream.write(this.cOp, 2);
        jceOutputStream.write(this.cVerifyType, 3);
    }

    public SvcRequestSetGroupFilter(long j3, long j16, byte b16, byte b17) {
        this.lUin = j3;
        this.lGroupCode = j16;
        this.cOp = b16;
        this.cVerifyType = b17;
    }
}
