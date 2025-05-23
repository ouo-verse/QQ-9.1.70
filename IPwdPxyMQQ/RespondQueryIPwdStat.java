package IPwdPxyMQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class RespondQueryIPwdStat extends JceStruct {
    public long uIsSetPwd;

    public RespondQueryIPwdStat() {
        this.uIsSetPwd = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uIsSetPwd = jceInputStream.read(this.uIsSetPwd, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uIsSetPwd, 0);
    }

    public RespondQueryIPwdStat(long j3) {
        this.uIsSetPwd = j3;
    }
}
