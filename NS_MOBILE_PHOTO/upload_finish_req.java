package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class upload_finish_req extends JceStruct {
    static Map<Integer, String> cache_busi_param;
    public long albumhandset;
    public String albumid;
    public long albumtype;
    public long batchid;
    public Map<Integer, String> busi_param;
    public String clientkey;
    public long photosucc;
    public long photototal;
    public int retry_count;

    public upload_finish_req() {
        this.albumid = "";
        this.clientkey = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.batchid = jceInputStream.read(this.batchid, 0, true);
        this.albumtype = jceInputStream.read(this.albumtype, 1, true);
        this.albumhandset = jceInputStream.read(this.albumhandset, 2, true);
        this.albumid = jceInputStream.readString(3, true);
        this.photototal = jceInputStream.read(this.photototal, 4, true);
        this.photosucc = jceInputStream.read(this.photosucc, 5, true);
        if (cache_busi_param == null) {
            cache_busi_param = new HashMap();
            cache_busi_param.put(0, "");
        }
        this.busi_param = (Map) jceInputStream.read((JceInputStream) cache_busi_param, 6, false);
        this.retry_count = jceInputStream.read(this.retry_count, 7, false);
        this.clientkey = jceInputStream.readString(8, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.batchid, 0);
        jceOutputStream.write(this.albumtype, 1);
        jceOutputStream.write(this.albumhandset, 2);
        jceOutputStream.write(this.albumid, 3);
        jceOutputStream.write(this.photototal, 4);
        jceOutputStream.write(this.photosucc, 5);
        Map<Integer, String> map = this.busi_param;
        if (map != null) {
            jceOutputStream.write((Map) map, 6);
        }
        jceOutputStream.write(this.retry_count, 7);
        String str = this.clientkey;
        if (str != null) {
            jceOutputStream.write(str, 8);
        }
    }

    public upload_finish_req(long j3, long j16, long j17, String str, long j18, long j19, Map<Integer, String> map, int i3, String str2) {
        this.batchid = j3;
        this.albumtype = j16;
        this.albumhandset = j17;
        this.albumid = str;
        this.photototal = j18;
        this.photosucc = j19;
        this.busi_param = map;
        this.retry_count = i3;
        this.clientkey = str2;
    }
}
