package NS_MOBILE_USERLOGO_TIMESTAMP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_facade_info extends JceStruct {
    public String facade_id;
    public long timestamp;

    public s_facade_info() {
        this.facade_id = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.facade_id = jceInputStream.readString(0, false);
        this.timestamp = jceInputStream.read(this.timestamp, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.facade_id;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.timestamp, 1);
    }

    public s_facade_info(String str, long j3) {
        this.facade_id = str;
        this.timestamp = j3;
    }
}
