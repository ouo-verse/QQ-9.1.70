package NS_MOBILE_COMM_CONF;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class NewMobileUserConf extends JceStruct {
    public long uBeginTime;
    public long uEndTime;
    public long version;

    public NewMobileUserConf() {
        this.version = 0L;
        this.uBeginTime = 0L;
        this.uEndTime = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.version = jceInputStream.read(this.version, 0, false);
        this.uBeginTime = jceInputStream.read(this.uBeginTime, 1, false);
        this.uEndTime = jceInputStream.read(this.uEndTime, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.version, 0);
        jceOutputStream.write(this.uBeginTime, 1);
        jceOutputStream.write(this.uEndTime, 2);
    }

    public NewMobileUserConf(long j3, long j16, long j17) {
        this.version = j3;
        this.uBeginTime = j16;
        this.uEndTime = j17;
    }
}
