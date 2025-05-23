package NS_MOBILE_VIDEO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class Video extends JceStruct {
    static Map<Integer, String> cache_cover;
    static Map<Integer, String> cache_map_urls = new HashMap();
    public int appid;
    public Map<Integer, String> cover;
    public String desc;
    public int file_size;
    public int height;
    public String lloc;
    public Map<Integer, String> map_urls;
    public long play_time;
    public int play_type;
    public int rights;
    public long status;
    public String subid;
    public String tid;
    public long timestamp;
    public String toast;
    public String ugckey;
    public long uin;
    public String vid;
    public int visitor_num;
    public int width;

    static {
        cache_map_urls.put(0, "");
        cache_cover = new HashMap();
        cache_cover.put(0, "");
    }

    public Video() {
        this.uin = 0L;
        this.vid = "";
        this.timestamp = 0L;
        this.play_time = 0L;
        this.map_urls = null;
        this.file_size = 0;
        this.cover = null;
        this.rights = 0;
        this.status = 0L;
        this.toast = "";
        this.tid = "";
        this.desc = "";
        this.visitor_num = 0;
        this.ugckey = "";
        this.play_type = 0;
        this.width = 0;
        this.height = 0;
        this.appid = 0;
        this.subid = "";
        this.lloc = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, false);
        this.vid = jceInputStream.readString(1, false);
        this.timestamp = jceInputStream.read(this.timestamp, 2, false);
        this.play_time = jceInputStream.read(this.play_time, 3, false);
        this.map_urls = (Map) jceInputStream.read((JceInputStream) cache_map_urls, 4, false);
        this.file_size = jceInputStream.read(this.file_size, 5, false);
        this.cover = (Map) jceInputStream.read((JceInputStream) cache_cover, 6, false);
        this.rights = jceInputStream.read(this.rights, 7, false);
        this.status = jceInputStream.read(this.status, 8, false);
        this.toast = jceInputStream.readString(9, false);
        this.tid = jceInputStream.readString(10, false);
        this.desc = jceInputStream.readString(11, false);
        this.visitor_num = jceInputStream.read(this.visitor_num, 12, false);
        this.ugckey = jceInputStream.readString(13, false);
        this.play_type = jceInputStream.read(this.play_type, 14, false);
        this.width = jceInputStream.read(this.width, 15, false);
        this.height = jceInputStream.read(this.height, 16, false);
        this.appid = jceInputStream.read(this.appid, 17, false);
        this.subid = jceInputStream.readString(18, false);
        this.lloc = jceInputStream.readString(19, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        String str = this.vid;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.timestamp, 2);
        jceOutputStream.write(this.play_time, 3);
        Map<Integer, String> map = this.map_urls;
        if (map != null) {
            jceOutputStream.write((Map) map, 4);
        }
        jceOutputStream.write(this.file_size, 5);
        Map<Integer, String> map2 = this.cover;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 6);
        }
        jceOutputStream.write(this.rights, 7);
        jceOutputStream.write(this.status, 8);
        String str2 = this.toast;
        if (str2 != null) {
            jceOutputStream.write(str2, 9);
        }
        String str3 = this.tid;
        if (str3 != null) {
            jceOutputStream.write(str3, 10);
        }
        String str4 = this.desc;
        if (str4 != null) {
            jceOutputStream.write(str4, 11);
        }
        jceOutputStream.write(this.visitor_num, 12);
        String str5 = this.ugckey;
        if (str5 != null) {
            jceOutputStream.write(str5, 13);
        }
        jceOutputStream.write(this.play_type, 14);
        jceOutputStream.write(this.width, 15);
        jceOutputStream.write(this.height, 16);
        jceOutputStream.write(this.appid, 17);
        String str6 = this.subid;
        if (str6 != null) {
            jceOutputStream.write(str6, 18);
        }
        String str7 = this.lloc;
        if (str7 != null) {
            jceOutputStream.write(str7, 19);
        }
    }

    public Video(long j3, String str, long j16, long j17, Map<Integer, String> map, int i3, Map<Integer, String> map2, int i16, long j18, String str2, String str3, String str4, int i17, String str5, int i18, int i19, int i26, int i27, String str6, String str7) {
        this.uin = j3;
        this.vid = str;
        this.timestamp = j16;
        this.play_time = j17;
        this.map_urls = map;
        this.file_size = i3;
        this.cover = map2;
        this.rights = i16;
        this.status = j18;
        this.toast = str2;
        this.tid = str3;
        this.desc = str4;
        this.visitor_num = i17;
        this.ugckey = str5;
        this.play_type = i18;
        this.width = i19;
        this.height = i26;
        this.appid = i27;
        this.subid = str6;
        this.lloc = str7;
    }
}
