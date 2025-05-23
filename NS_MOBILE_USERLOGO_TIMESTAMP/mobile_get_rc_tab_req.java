package NS_MOBILE_USERLOGO_TIMESTAMP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_get_rc_tab_req extends JceStruct {
    public long last_timestamp;

    public mobile_get_rc_tab_req() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.last_timestamp = jceInputStream.read(this.last_timestamp, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.last_timestamp, 0);
    }

    public mobile_get_rc_tab_req(long j3) {
        this.last_timestamp = j3;
    }
}
