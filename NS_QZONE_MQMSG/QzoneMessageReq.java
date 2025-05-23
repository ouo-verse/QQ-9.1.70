package NS_QZONE_MQMSG;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class QzoneMessageReq extends JceStruct {
    static Map<String, String> cache_ext;
    public Map<String, String> ext;
    public long num;
    public int scence;
    public String trace_info;
    public long uin;

    static {
        HashMap hashMap = new HashMap();
        cache_ext = hashMap;
        hashMap.put("", "");
    }

    public QzoneMessageReq() {
        this.uin = 0L;
        this.trace_info = "";
        this.num = 0L;
        this.ext = null;
        this.scence = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, true);
        this.trace_info = jceInputStream.readString(1, true);
        this.num = jceInputStream.read(this.num, 2, true);
        this.ext = (Map) jceInputStream.read((JceInputStream) cache_ext, 3, false);
        this.scence = jceInputStream.read(this.scence, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.trace_info, 1);
        jceOutputStream.write(this.num, 2);
        Map<String, String> map = this.ext;
        if (map != null) {
            jceOutputStream.write((Map) map, 3);
        }
        jceOutputStream.write(this.scence, 4);
    }

    public QzoneMessageReq(long j3, String str, long j16, Map<String, String> map, int i3) {
        this.uin = j3;
        this.trace_info = str;
        this.num = j16;
        this.ext = map;
        this.scence = i3;
    }
}
