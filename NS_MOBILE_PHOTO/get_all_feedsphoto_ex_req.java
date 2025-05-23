package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class get_all_feedsphoto_ex_req extends JceStruct {
    static Map<String, String> cache_mapEx;
    static int cache_req_type;
    public int album_show_type;
    public int appid;
    public String attach_info;
    public int count;
    public int extrance_type;
    public Map<String, String> mapEx;
    public int refresh_type;
    public int req_type;
    public boolean timeline_on;
    public long uin;

    static {
        HashMap hashMap = new HashMap();
        cache_mapEx = hashMap;
        hashMap.put("", "");
        cache_req_type = 0;
    }

    public get_all_feedsphoto_ex_req() {
        this.uin = 0L;
        this.appid = 0;
        this.count = 0;
        this.attach_info = "";
        this.album_show_type = 0;
        this.refresh_type = 0;
        this.extrance_type = 0;
        this.mapEx = null;
        this.req_type = 1;
        this.timeline_on = false;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, false);
        this.appid = jceInputStream.read(this.appid, 1, false);
        this.count = jceInputStream.read(this.count, 2, false);
        this.attach_info = jceInputStream.readString(3, false);
        this.album_show_type = jceInputStream.read(this.album_show_type, 4, false);
        this.refresh_type = jceInputStream.read(this.refresh_type, 5, false);
        this.extrance_type = jceInputStream.read(this.extrance_type, 6, false);
        this.mapEx = (Map) jceInputStream.read((JceInputStream) cache_mapEx, 7, false);
        this.req_type = jceInputStream.read(this.req_type, 8, false);
        this.timeline_on = jceInputStream.read(this.timeline_on, 9, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.appid, 1);
        jceOutputStream.write(this.count, 2);
        String str = this.attach_info;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        jceOutputStream.write(this.album_show_type, 4);
        jceOutputStream.write(this.refresh_type, 5);
        jceOutputStream.write(this.extrance_type, 6);
        Map<String, String> map = this.mapEx;
        if (map != null) {
            jceOutputStream.write((Map) map, 7);
        }
        jceOutputStream.write(this.req_type, 8);
        jceOutputStream.write(this.timeline_on, 9);
    }

    public get_all_feedsphoto_ex_req(long j3, int i3, int i16, String str, int i17, int i18, int i19, Map<String, String> map, int i26, boolean z16) {
        this.uin = j3;
        this.appid = i3;
        this.count = i16;
        this.attach_info = str;
        this.album_show_type = i17;
        this.refresh_type = i18;
        this.extrance_type = i19;
        this.mapEx = map;
        this.req_type = i26;
        this.timeline_on = z16;
    }
}
