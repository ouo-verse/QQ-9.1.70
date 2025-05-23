package RegisterProxySvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class RegisterHttpShortConnectionBusiPack extends JceStruct {
    static byte[] cache_vBusi;
    public String strSvcCmd;
    public long uSeq;
    public byte[] vBusi;

    public RegisterHttpShortConnectionBusiPack() {
        this.strSvcCmd = "";
        this.uSeq = 0L;
        this.vBusi = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.strSvcCmd = jceInputStream.readString(0, true);
        this.uSeq = jceInputStream.read(this.uSeq, 1, true);
        if (cache_vBusi == null) {
            cache_vBusi = r2;
            byte[] bArr = {0};
        }
        this.vBusi = jceInputStream.read(cache_vBusi, 2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.strSvcCmd, 0);
        jceOutputStream.write(this.uSeq, 1);
        jceOutputStream.write(this.vBusi, 2);
    }

    public RegisterHttpShortConnectionBusiPack(String str, long j3, byte[] bArr) {
        this.strSvcCmd = str;
        this.uSeq = j3;
        this.vBusi = bArr;
    }
}
