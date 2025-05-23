package QMF_PROTOCAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RetryInfo extends JceStruct {
    public short Flag;
    public long PkgId;
    public int RetryCount;

    public RetryInfo() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.Flag = jceInputStream.read(this.Flag, 0, true);
        this.RetryCount = jceInputStream.read(this.RetryCount, 1, true);
        this.PkgId = jceInputStream.read(this.PkgId, 2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.Flag, 0);
        jceOutputStream.write(this.RetryCount, 1);
        jceOutputStream.write(this.PkgId, 2);
    }

    public RetryInfo(short s16, int i3, long j3) {
        this.Flag = s16;
        this.RetryCount = i3;
        this.PkgId = j3;
    }
}
