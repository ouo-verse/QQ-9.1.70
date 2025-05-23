package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class BatchGetSimilarGroupidReq extends JceStruct {
    static Map<String, PhotoInfos> cache_infos = new HashMap();
    public Map<String, PhotoInfos> infos;
    public boolean is_need_new_groupids;
    public long uin;

    static {
        cache_infos.put("", new PhotoInfos());
    }

    public BatchGetSimilarGroupidReq() {
        this.uin = 0L;
        this.infos = null;
        this.is_need_new_groupids = false;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, false);
        this.infos = (Map) jceInputStream.read((JceInputStream) cache_infos, 1, false);
        this.is_need_new_groupids = jceInputStream.read(this.is_need_new_groupids, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        Map<String, PhotoInfos> map = this.infos;
        if (map != null) {
            jceOutputStream.write((Map) map, 1);
        }
        jceOutputStream.write(this.is_need_new_groupids, 2);
    }

    public BatchGetSimilarGroupidReq(long j3, Map<String, PhotoInfos> map, boolean z16) {
        this.uin = j3;
        this.infos = map;
        this.is_need_new_groupids = z16;
    }
}
