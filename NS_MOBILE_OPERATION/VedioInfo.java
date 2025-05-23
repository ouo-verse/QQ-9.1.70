package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class VedioInfo extends JceStruct {
    static Map<String, String> cache_ext_info;
    public String detailurl;
    public Map<String, String> ext_info;
    public String img;
    public String playurl;
    public int pub_route;
    public int subtype;
    public long time;
    public String title;
    public String video_id;
    public int who;

    static {
        HashMap hashMap = new HashMap();
        cache_ext_info = hashMap;
        hashMap.put("", "");
    }

    public VedioInfo() {
        this.playurl = "";
        this.img = "";
        this.title = "";
        this.who = 0;
        this.detailurl = "";
        this.video_id = "";
        this.pub_route = 0;
        this.time = 0L;
        this.subtype = 0;
        this.ext_info = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.playurl = jceInputStream.readString(0, false);
        this.img = jceInputStream.readString(1, false);
        this.title = jceInputStream.readString(2, false);
        this.who = jceInputStream.read(this.who, 3, false);
        this.detailurl = jceInputStream.readString(4, false);
        this.video_id = jceInputStream.readString(5, false);
        this.pub_route = jceInputStream.read(this.pub_route, 6, false);
        this.time = jceInputStream.read(this.time, 7, false);
        this.subtype = jceInputStream.read(this.subtype, 8, false);
        this.ext_info = (Map) jceInputStream.read((JceInputStream) cache_ext_info, 9, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.playurl;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.img;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.title;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        jceOutputStream.write(this.who, 3);
        String str4 = this.detailurl;
        if (str4 != null) {
            jceOutputStream.write(str4, 4);
        }
        String str5 = this.video_id;
        if (str5 != null) {
            jceOutputStream.write(str5, 5);
        }
        jceOutputStream.write(this.pub_route, 6);
        jceOutputStream.write(this.time, 7);
        jceOutputStream.write(this.subtype, 8);
        Map<String, String> map = this.ext_info;
        if (map != null) {
            jceOutputStream.write((Map) map, 9);
        }
    }

    public VedioInfo(String str, String str2, String str3, int i3, String str4, String str5, int i16, long j3, int i17, Map<String, String> map) {
        this.playurl = str;
        this.img = str2;
        this.title = str3;
        this.who = i3;
        this.detailurl = str4;
        this.video_id = str5;
        this.pub_route = i16;
        this.time = j3;
        this.subtype = i17;
        this.ext_info = map;
    }
}
