package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class get_photo_list_bytimeline_req extends JceStruct {
    static Map<Integer, String> cache_busi_param;
    static Map<Long, Long> cache_time_range = new HashMap();
    public String albumid;
    public int albumtype;
    public String attach_info;
    public Map<Integer, String> busi_param;
    public int gettimeline;
    public int num;
    public String password;
    public int sort;
    public int start;
    public Map<Long, Long> time_range;
    public long uin;

    static {
        cache_time_range.put(0L, 0L);
        cache_busi_param = new HashMap();
        cache_busi_param.put(0, "");
    }

    public get_photo_list_bytimeline_req() {
        this.albumid = "";
        this.attach_info = "";
        this.password = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, true);
        this.albumid = jceInputStream.readString(1, true);
        this.time_range = (Map) jceInputStream.read((JceInputStream) cache_time_range, 2, true);
        this.sort = jceInputStream.read(this.sort, 3, false);
        this.attach_info = jceInputStream.readString(4, false);
        this.password = jceInputStream.readString(5, false);
        this.start = jceInputStream.read(this.start, 6, false);
        this.num = jceInputStream.read(this.num, 7, false);
        this.albumtype = jceInputStream.read(this.albumtype, 8, false);
        this.gettimeline = jceInputStream.read(this.gettimeline, 9, false);
        this.busi_param = (Map) jceInputStream.read((JceInputStream) cache_busi_param, 10, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        String str = this.albumid;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write((Map) this.time_range, 2);
        jceOutputStream.write(this.sort, 3);
        String str2 = this.attach_info;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
        String str3 = this.password;
        if (str3 != null) {
            jceOutputStream.write(str3, 5);
        }
        jceOutputStream.write(this.start, 6);
        jceOutputStream.write(this.num, 7);
        jceOutputStream.write(this.albumtype, 8);
        jceOutputStream.write(this.gettimeline, 9);
        Map<Integer, String> map = this.busi_param;
        if (map != null) {
            jceOutputStream.write((Map) map, 10);
        }
    }

    public get_photo_list_bytimeline_req(long j3, String str, Map<Long, Long> map, int i3, String str2, String str3, int i16, int i17, int i18, int i19, Map<Integer, String> map2) {
        this.uin = j3;
        this.albumid = str;
        this.time_range = map;
        this.sort = i3;
        this.attach_info = str2;
        this.password = str3;
        this.start = i16;
        this.num = i17;
        this.albumtype = i18;
        this.gettimeline = i19;
        this.busi_param = map2;
    }
}
