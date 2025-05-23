package RegisterProxySvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class RegisterPushNotice extends JceStruct {
    public long uEndSeq;
    public long uFlag;
    public long uInterval_forbid_pulldown;
    public long ulTimeOutFlag;

    public RegisterPushNotice() {
        this.uFlag = 0L;
        this.uEndSeq = 0L;
        this.ulTimeOutFlag = 0L;
        this.uInterval_forbid_pulldown = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uFlag = jceInputStream.read(this.uFlag, 0, false);
        this.uEndSeq = jceInputStream.read(this.uEndSeq, 1, false);
        this.ulTimeOutFlag = jceInputStream.read(this.ulTimeOutFlag, 2, false);
        this.uInterval_forbid_pulldown = jceInputStream.read(this.uInterval_forbid_pulldown, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uFlag, 0);
        jceOutputStream.write(this.uEndSeq, 1);
        jceOutputStream.write(this.ulTimeOutFlag, 2);
        jceOutputStream.write(this.uInterval_forbid_pulldown, 3);
    }

    public RegisterPushNotice(long j3, long j16, long j17, long j18) {
        this.uFlag = j3;
        this.uEndSeq = j16;
        this.ulTimeOutFlag = j17;
        this.uInterval_forbid_pulldown = j18;
    }
}
