package NS_MOBILE_QUN;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class qun_get_time_rsp extends JceStruct {
    public long server_time;

    public qun_get_time_rsp() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.server_time = jceInputStream.read(this.server_time, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.server_time, 0);
    }

    public qun_get_time_rsp(long j3) {
        this.server_time = j3;
    }
}
