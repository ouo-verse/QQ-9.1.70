package ELABORATE_FEED_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class tag_together_query_req extends JceStruct {
    static Map<Integer, String> cache_mapExt = new HashMap();
    public Map<Integer, String> mapExt;
    public String sPgcFeedKey;
    public long uPgcAppid;
    public long uPgcUin;

    static {
        cache_mapExt.put(0, "");
    }

    public tag_together_query_req() {
        this.uPgcUin = 0L;
        this.uPgcAppid = 0L;
        this.sPgcFeedKey = "";
        this.mapExt = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uPgcUin = jceInputStream.read(this.uPgcUin, 0, false);
        this.uPgcAppid = jceInputStream.read(this.uPgcAppid, 1, false);
        this.sPgcFeedKey = jceInputStream.readString(2, false);
        this.mapExt = (Map) jceInputStream.read((JceInputStream) cache_mapExt, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uPgcUin, 0);
        jceOutputStream.write(this.uPgcAppid, 1);
        String str = this.sPgcFeedKey;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        Map<Integer, String> map = this.mapExt;
        if (map != null) {
            jceOutputStream.write((Map) map, 3);
        }
    }

    public tag_together_query_req(long j3, long j16, String str, Map<Integer, String> map) {
        this.uPgcUin = j3;
        this.uPgcAppid = j16;
        this.sPgcFeedKey = str;
        this.mapExt = map;
    }
}
