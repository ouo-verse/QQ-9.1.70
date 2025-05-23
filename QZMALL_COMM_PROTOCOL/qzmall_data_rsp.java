package QZMALL_COMM_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class qzmall_data_rsp extends JceStruct {
    static Map<String, byte[]> cache_rspMap;
    public Map<String, byte[]> rspMap;
    public long uUin;

    static {
        HashMap hashMap = new HashMap();
        cache_rspMap = hashMap;
        hashMap.put("", new byte[]{0});
    }

    public qzmall_data_rsp() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uUin = jceInputStream.read(this.uUin, 0, false);
        this.rspMap = (Map) jceInputStream.read((JceInputStream) cache_rspMap, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uUin, 0);
        Map<String, byte[]> map = this.rspMap;
        if (map != null) {
            jceOutputStream.write((Map) map, 1);
        }
    }

    public qzmall_data_rsp(long j3, Map<String, byte[]> map) {
        this.uUin = j3;
        this.rspMap = map;
    }
}
