package NS_MOBILE_EXTRA;

import com.huawei.hms.framework.common.ContainerUtils;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_visit_record extends JceStruct {
    static Map<Integer, String> cache_busi_param;
    public int appid;
    public Map<Integer, String> busi_param;
    public long fuin;
    public long gameId;
    public String srcId;
    public int subid;
    public int visit_type;
    public long vtime;

    public s_visit_record() {
        this.srcId = "";
    }

    private String mapToString(Map<Integer, String> map) {
        if (map == null) {
            return "null";
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("{");
        boolean z16 = true;
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (!z16) {
                sb5.append(", ");
            }
            sb5.append(entry.getKey());
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb5.append(entry.getValue());
            z16 = false;
        }
        sb5.append("}");
        return sb5.toString();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.fuin = jceInputStream.read(this.fuin, 0, true);
        this.appid = jceInputStream.read(this.appid, 1, true);
        this.subid = jceInputStream.read(this.subid, 2, true);
        this.srcId = jceInputStream.readString(3, true);
        if (cache_busi_param == null) {
            cache_busi_param = new HashMap();
            cache_busi_param.put(0, "");
        }
        this.busi_param = (Map) jceInputStream.read((JceInputStream) cache_busi_param, 4, false);
        this.gameId = jceInputStream.read(this.gameId, 5, false);
        this.visit_type = jceInputStream.read(this.visit_type, 6, false);
        this.vtime = (int) jceInputStream.read(this.vtime, 7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public String toString() {
        return "s_visit_record{fuin=" + this.fuin + ", appid=" + this.appid + ", subid=" + this.subid + ", srcId='" + this.srcId + "', busi_param=" + mapToString(this.busi_param) + ", gameId=" + this.gameId + ", visit_type=" + this.visit_type + ", vtime=" + this.vtime + '}';
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.fuin, 0);
        jceOutputStream.write(this.appid, 1);
        jceOutputStream.write(this.subid, 2);
        jceOutputStream.write(this.srcId, 3);
        Map<Integer, String> map = this.busi_param;
        if (map != null) {
            jceOutputStream.write((Map) map, 4);
        }
        jceOutputStream.write(this.gameId, 5);
        jceOutputStream.write(this.visit_type, 6);
        jceOutputStream.write(this.vtime, 7);
    }

    public s_visit_record(long j3, int i3, int i16, String str, Map<Integer, String> map, long j16, int i17, long j17) {
        this.fuin = j3;
        this.appid = i3;
        this.subid = i16;
        this.srcId = str;
        this.busi_param = map;
        this.gameId = j16;
        this.visit_type = i17;
        this.vtime = j17;
    }
}
