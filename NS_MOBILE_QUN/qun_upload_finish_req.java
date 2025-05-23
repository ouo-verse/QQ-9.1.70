package NS_MOBILE_QUN;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class qun_upload_finish_req extends JceStruct {
    static Map<Integer, String> cache_busi_param;
    public String albumid;
    public int albumtype;
    public long batchid;
    public Map<Integer, String> busi_param;
    public String clientkey;
    public long photosucc;
    public long photototal;
    public String qunid;
    public int retry_count;

    public qun_upload_finish_req() {
        this.qunid = "";
        this.albumid = "";
        this.clientkey = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.qunid = jceInputStream.readString(0, true);
        this.albumid = jceInputStream.readString(1, true);
        this.batchid = jceInputStream.read(this.batchid, 2, false);
        this.photototal = jceInputStream.read(this.photototal, 3, false);
        this.photosucc = jceInputStream.read(this.photosucc, 4, false);
        this.clientkey = jceInputStream.readString(5, false);
        if (cache_busi_param == null) {
            cache_busi_param = new HashMap();
            cache_busi_param.put(0, "");
        }
        this.busi_param = (Map) jceInputStream.read((JceInputStream) cache_busi_param, 6, false);
        this.retry_count = jceInputStream.read(this.retry_count, 7, false);
        this.albumtype = jceInputStream.read(this.albumtype, 8, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.qunid, 0);
        jceOutputStream.write(this.albumid, 1);
        jceOutputStream.write(this.batchid, 2);
        jceOutputStream.write(this.photototal, 3);
        jceOutputStream.write(this.photosucc, 4);
        String str = this.clientkey;
        if (str != null) {
            jceOutputStream.write(str, 5);
        }
        Map<Integer, String> map = this.busi_param;
        if (map != null) {
            jceOutputStream.write((Map) map, 6);
        }
        jceOutputStream.write(this.retry_count, 7);
        jceOutputStream.write(this.albumtype, 8);
    }

    public qun_upload_finish_req(String str, String str2, long j3, long j16, long j17, String str3, Map<Integer, String> map, int i3, int i16) {
        this.qunid = str;
        this.albumid = str2;
        this.batchid = j3;
        this.photototal = j16;
        this.photosucc = j17;
        this.clientkey = str3;
        this.busi_param = map;
        this.retry_count = i3;
        this.albumtype = i16;
    }
}
