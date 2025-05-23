package IMMsgBodyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class PluginNum extends JceStruct {
    public byte cFlag;
    public long dwID;
    public long dwNUm;

    public PluginNum() {
        this.dwID = 0L;
        this.dwNUm = 0L;
        this.cFlag = (byte) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.dwID = jceInputStream.read(this.dwID, 0, false);
        this.dwNUm = jceInputStream.read(this.dwNUm, 1, false);
        this.cFlag = jceInputStream.read(this.cFlag, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.dwID, 0);
        jceOutputStream.write(this.dwNUm, 1);
        jceOutputStream.write(this.cFlag, 2);
    }

    public PluginNum(long j3, long j16, byte b16) {
        this.dwID = j3;
        this.dwNUm = j16;
        this.cFlag = b16;
    }
}
