package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ReqGetDiscussInfo extends JceStruct {
    static Map<Long, Integer> cache_UinList;
    public long DiscussUin;
    public long InfoSeq;
    public long InteRemarkTimeStamp;
    public String Signature;
    public Map<Long, Integer> UinList;

    public ReqGetDiscussInfo() {
        this.DiscussUin = 0L;
        this.InteRemarkTimeStamp = -1L;
        this.UinList = null;
        this.InfoSeq = 0L;
        this.Signature = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.DiscussUin = jceInputStream.read(this.DiscussUin, 0, true);
        this.InteRemarkTimeStamp = jceInputStream.read(this.InteRemarkTimeStamp, 1, false);
        if (cache_UinList == null) {
            cache_UinList = new HashMap();
            cache_UinList.put(0L, 0);
        }
        this.UinList = (Map) jceInputStream.read((JceInputStream) cache_UinList, 2, false);
        this.InfoSeq = jceInputStream.read(this.InfoSeq, 3, false);
        this.Signature = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.DiscussUin, 0);
        jceOutputStream.write(this.InteRemarkTimeStamp, 1);
        Map<Long, Integer> map = this.UinList;
        if (map != null) {
            jceOutputStream.write((Map) map, 2);
        }
        jceOutputStream.write(this.InfoSeq, 3);
        String str = this.Signature;
        if (str != null) {
            jceOutputStream.write(str, 4);
        }
    }

    public ReqGetDiscussInfo(long j3, long j16, Map<Long, Integer> map, long j17, String str) {
        this.DiscussUin = j3;
        this.InteRemarkTimeStamp = j16;
        this.UinList = map;
        this.InfoSeq = j17;
        this.Signature = str;
    }
}
