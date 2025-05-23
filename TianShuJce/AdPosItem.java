package TianShuJce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class AdPosItem extends JceStruct {
    static Map<String, String> cache_extra_info;
    public Map<String, String> extra_info;
    public long nNeedCnt;
    public long posId;

    static {
        HashMap hashMap = new HashMap();
        cache_extra_info = hashMap;
        hashMap.put("", "");
    }

    public AdPosItem() {
        this.posId = 0L;
        this.nNeedCnt = 0L;
        this.extra_info = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.posId = jceInputStream.read(this.posId, 1, false);
        this.nNeedCnt = jceInputStream.read(this.nNeedCnt, 2, false);
        this.extra_info = (Map) jceInputStream.read((JceInputStream) cache_extra_info, 14, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.posId, 1);
        jceOutputStream.write(this.nNeedCnt, 2);
        Map<String, String> map = this.extra_info;
        if (map != null) {
            jceOutputStream.write((Map) map, 14);
        }
    }

    public AdPosItem(long j3, long j16, Map<String, String> map) {
        this.posId = j3;
        this.nNeedCnt = j16;
        this.extra_info = map;
    }
}
