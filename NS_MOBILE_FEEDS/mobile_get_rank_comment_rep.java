package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_get_rank_comment_rep extends JceStruct {
    static Map<Integer, String> cache_busi_param = new HashMap();
    public Map<Integer, String> busi_param;
    public int icount;

    static {
        cache_busi_param.put(0, "");
    }

    public mobile_get_rank_comment_rep() {
        this.icount = 0;
        this.busi_param = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.icount = jceInputStream.read(this.icount, 0, false);
        this.busi_param = (Map) jceInputStream.read((JceInputStream) cache_busi_param, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.icount, 0);
        Map<Integer, String> map = this.busi_param;
        if (map != null) {
            jceOutputStream.write((Map) map, 1);
        }
    }

    public mobile_get_rank_comment_rep(int i3, Map<Integer, String> map) {
        this.icount = i3;
        this.busi_param = map;
    }
}
