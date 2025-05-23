package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SvcRequestSetRoamMsgAllUser extends JceStruct {
    public byte cValue;
    public byte cVerifyType;
    public long lUin;
    public short shType;

    public SvcRequestSetRoamMsgAllUser() {
        this.lUin = 0L;
        this.cVerifyType = (byte) 0;
        this.shType = (short) 0;
        this.cValue = (byte) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lUin = jceInputStream.read(this.lUin, 0, true);
        this.cVerifyType = jceInputStream.read(this.cVerifyType, 1, true);
        this.shType = jceInputStream.read(this.shType, 2, true);
        this.cValue = jceInputStream.read(this.cValue, 3, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lUin, 0);
        jceOutputStream.write(this.cVerifyType, 1);
        jceOutputStream.write(this.shType, 2);
        jceOutputStream.write(this.cValue, 3);
    }

    public SvcRequestSetRoamMsgAllUser(long j3, byte b16, short s16, byte b17) {
        this.lUin = j3;
        this.cVerifyType = b16;
        this.shType = s16;
        this.cValue = b17;
    }
}
