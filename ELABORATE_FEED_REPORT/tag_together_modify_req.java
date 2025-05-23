package ELABORATE_FEED_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class tag_together_modify_req extends JceStruct {
    public Map<Integer, String> mapExt;
    public String sPgcFeedKey;
    public tag_deatail_info stTagDetailInfo;
    public long uModifyType;
    public long uPgcAppid;
    public long uPgcUin;
    static tag_deatail_info cache_stTagDetailInfo = new tag_deatail_info();
    static Map<Integer, String> cache_mapExt = new HashMap();

    static {
        cache_mapExt.put(0, "");
    }

    public tag_together_modify_req() {
        this.uPgcUin = 0L;
        this.uPgcAppid = 0L;
        this.sPgcFeedKey = "";
        this.stTagDetailInfo = null;
        this.mapExt = null;
        this.uModifyType = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uPgcUin = jceInputStream.read(this.uPgcUin, 0, false);
        this.uPgcAppid = jceInputStream.read(this.uPgcAppid, 1, false);
        this.sPgcFeedKey = jceInputStream.readString(2, false);
        this.stTagDetailInfo = (tag_deatail_info) jceInputStream.read((JceStruct) cache_stTagDetailInfo, 3, false);
        this.mapExt = (Map) jceInputStream.read((JceInputStream) cache_mapExt, 4, false);
        this.uModifyType = jceInputStream.read(this.uModifyType, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uPgcUin, 0);
        jceOutputStream.write(this.uPgcAppid, 1);
        String str = this.sPgcFeedKey;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        tag_deatail_info tag_deatail_infoVar = this.stTagDetailInfo;
        if (tag_deatail_infoVar != null) {
            jceOutputStream.write((JceStruct) tag_deatail_infoVar, 3);
        }
        Map<Integer, String> map = this.mapExt;
        if (map != null) {
            jceOutputStream.write((Map) map, 4);
        }
        jceOutputStream.write(this.uModifyType, 5);
    }

    public tag_together_modify_req(long j3, long j16, String str, tag_deatail_info tag_deatail_infoVar, Map<Integer, String> map, long j17) {
        this.uPgcUin = j3;
        this.uPgcAppid = j16;
        this.sPgcFeedKey = str;
        this.stTagDetailInfo = tag_deatail_infoVar;
        this.mapExt = map;
        this.uModifyType = j17;
    }
}
