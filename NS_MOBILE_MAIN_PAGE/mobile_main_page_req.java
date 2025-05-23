package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_main_page_req extends JceStruct {
    static Map<Integer, Long> cache_mapTimeStamp;
    public String attach_info;
    public byte force;
    public Map<Integer, Long> mapTimeStamp;
    public long uin;
    public long visituin;

    public mobile_main_page_req() {
        this.attach_info = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, false);
        this.visituin = jceInputStream.read(this.visituin, 1, false);
        this.force = jceInputStream.read(this.force, 2, false);
        this.attach_info = jceInputStream.readString(3, false);
        if (cache_mapTimeStamp == null) {
            cache_mapTimeStamp = new HashMap();
            cache_mapTimeStamp.put(0, 0L);
        }
        this.mapTimeStamp = (Map) jceInputStream.read((JceInputStream) cache_mapTimeStamp, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.visituin, 1);
        jceOutputStream.write(this.force, 2);
        String str = this.attach_info;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        Map<Integer, Long> map = this.mapTimeStamp;
        if (map != null) {
            jceOutputStream.write((Map) map, 4);
        }
    }

    public mobile_main_page_req(long j3, long j16, byte b16, String str, Map<Integer, Long> map) {
        this.uin = j3;
        this.visituin = j16;
        this.force = b16;
        this.attach_info = str;
        this.mapTimeStamp = map;
    }
}
