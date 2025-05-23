package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SetUserInfoResp extends JceStruct {
    public long dwToUin;
    public byte result;

    public SetUserInfoResp() {
        this.dwToUin = 0L;
        this.result = (byte) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.dwToUin = jceInputStream.read(this.dwToUin, 0, true);
        this.result = jceInputStream.read(this.result, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.dwToUin, 0);
        jceOutputStream.write(this.result, 1);
    }

    public SetUserInfoResp(long j3, byte b16) {
        this.dwToUin = j3;
        this.result = b16;
    }
}
