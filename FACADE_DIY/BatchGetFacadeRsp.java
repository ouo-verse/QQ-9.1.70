package FACADE_DIY;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class BatchGetFacadeRsp extends JceStruct {
    static Map<Long, UserFacadeInfo> cache_info = new HashMap();
    public Map<Long, UserFacadeInfo> info;
    public String jumpUrl;

    static {
        cache_info.put(0L, new UserFacadeInfo());
    }

    public BatchGetFacadeRsp() {
        this.info = null;
        this.jumpUrl = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.info = (Map) jceInputStream.read((JceInputStream) cache_info, 0, false);
        this.jumpUrl = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        Map<Long, UserFacadeInfo> map = this.info;
        if (map != null) {
            jceOutputStream.write((Map) map, 0);
        }
        String str = this.jumpUrl;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public BatchGetFacadeRsp(Map<Long, UserFacadeInfo> map, String str) {
        this.info = map;
        this.jumpUrl = str;
    }
}
