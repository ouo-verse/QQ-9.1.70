package NS_MOBILE_NEWEST_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class newest_feeds_rsp extends JceStruct {
    static Map<Long, String> cache_mapExt;
    static Map<Long, QzoneData> cache_mapVcByte;
    static ArrayList<feed_info> cache_vec_feed_info = new ArrayList<>();
    public int code;
    public long last_feed_time;
    public Map<Long, String> mapExt;
    public Map<Long, QzoneData> mapVcByte;
    public String str_attach;
    public long uNextTime;
    public ArrayList<feed_info> vec_feed_info;

    static {
        cache_vec_feed_info.add(new feed_info());
        cache_mapVcByte = new HashMap();
        cache_mapVcByte.put(0L, new QzoneData());
        cache_mapExt = new HashMap();
        cache_mapExt.put(0L, "");
    }

    public newest_feeds_rsp() {
        this.code = 0;
        this.vec_feed_info = null;
        this.last_feed_time = 0L;
        this.str_attach = "";
        this.mapVcByte = null;
        this.mapExt = null;
        this.uNextTime = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.code = jceInputStream.read(this.code, 0, false);
        this.vec_feed_info = (ArrayList) jceInputStream.read((JceInputStream) cache_vec_feed_info, 1, false);
        this.last_feed_time = jceInputStream.read(this.last_feed_time, 2, false);
        this.str_attach = jceInputStream.readString(3, false);
        this.mapVcByte = (Map) jceInputStream.read((JceInputStream) cache_mapVcByte, 4, false);
        this.mapExt = (Map) jceInputStream.read((JceInputStream) cache_mapExt, 5, false);
        this.uNextTime = jceInputStream.read(this.uNextTime, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.code, 0);
        ArrayList<feed_info> arrayList = this.vec_feed_info;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        jceOutputStream.write(this.last_feed_time, 2);
        String str = this.str_attach;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        Map<Long, QzoneData> map = this.mapVcByte;
        if (map != null) {
            jceOutputStream.write((Map) map, 4);
        }
        Map<Long, String> map2 = this.mapExt;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 5);
        }
        jceOutputStream.write(this.uNextTime, 6);
    }

    public newest_feeds_rsp(int i3, ArrayList<feed_info> arrayList, long j3, String str, Map<Long, QzoneData> map, Map<Long, String> map2, long j16) {
        this.code = i3;
        this.vec_feed_info = arrayList;
        this.last_feed_time = j3;
        this.str_attach = str;
        this.mapVcByte = map;
        this.mapExt = map2;
        this.uNextTime = j16;
    }
}
