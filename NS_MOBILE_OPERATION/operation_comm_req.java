package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class operation_comm_req extends JceStruct {
    static Map<String, String> cache_mapEx;
    static byte[] cache_message;
    public int appid;
    public Map<String, String> mapEx;
    public byte[] message;
    public long opuin;

    static {
        cache_message = r0;
        byte[] bArr = {0};
        HashMap hashMap = new HashMap();
        cache_mapEx = hashMap;
        hashMap.put("", "");
    }

    public operation_comm_req() {
        this.appid = 0;
        this.opuin = 0L;
        this.message = null;
        this.mapEx = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.appid = jceInputStream.read(this.appid, 0, false);
        this.opuin = jceInputStream.read(this.opuin, 1, false);
        this.message = jceInputStream.read(cache_message, 2, false);
        this.mapEx = (Map) jceInputStream.read((JceInputStream) cache_mapEx, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.appid, 0);
        jceOutputStream.write(this.opuin, 1);
        byte[] bArr = this.message;
        if (bArr != null) {
            jceOutputStream.write(bArr, 2);
        }
        Map<String, String> map = this.mapEx;
        if (map != null) {
            jceOutputStream.write((Map) map, 3);
        }
    }

    public operation_comm_req(int i3, long j3, byte[] bArr, Map<String, String> map) {
        this.appid = i3;
        this.opuin = j3;
        this.message = bArr;
        this.mapEx = map;
    }
}
