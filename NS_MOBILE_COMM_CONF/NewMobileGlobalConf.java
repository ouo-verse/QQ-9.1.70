package NS_MOBILE_COMM_CONF;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class NewMobileGlobalConf extends JceStruct {
    public long version;

    public NewMobileGlobalConf() {
        this.version = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.version = jceInputStream.read(this.version, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.version, 0);
    }

    public NewMobileGlobalConf(long j3) {
        this.version = j3;
    }
}
