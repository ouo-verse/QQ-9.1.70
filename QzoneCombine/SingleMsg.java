package QzoneCombine;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SingleMsg extends JceStruct {
    static Map<String, String> cache_data;
    static byte[] cache_extBuffer;
    public long addTime;
    public Map<String, String> data;
    public byte[] extBuffer;
    public long opUin;

    static {
        HashMap hashMap = new HashMap();
        cache_data = hashMap;
        hashMap.put("", "");
        cache_extBuffer = r0;
        byte[] bArr = {0};
    }

    public SingleMsg() {
        this.addTime = 0L;
        this.data = null;
        this.opUin = 0L;
        this.extBuffer = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.addTime = jceInputStream.read(this.addTime, 0, false);
        this.data = (Map) jceInputStream.read((JceInputStream) cache_data, 1, false);
        this.opUin = jceInputStream.read(this.opUin, 2, false);
        this.extBuffer = jceInputStream.read(cache_extBuffer, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.addTime, 0);
        Map<String, String> map = this.data;
        if (map != null) {
            jceOutputStream.write((Map) map, 1);
        }
        jceOutputStream.write(this.opUin, 2);
        byte[] bArr = this.extBuffer;
        if (bArr != null) {
            jceOutputStream.write(bArr, 3);
        }
    }

    public SingleMsg(long j3, Map<String, String> map, long j16, byte[] bArr) {
        this.addTime = j3;
        this.data = map;
        this.opUin = j16;
        this.extBuffer = bArr;
    }
}
