package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class get_photo_comment_req extends JceStruct {
    static Map<String, String> cache_extent_info;
    public String albumid;
    public String attach_info;
    public int commenttype;
    public Map<String, String> extent_info;
    public int order;
    public String photoid;
    public int refresh_type;
    public String topicid;
    public long uin;

    static {
        HashMap hashMap = new HashMap();
        cache_extent_info = hashMap;
        hashMap.put("", "");
    }

    public get_photo_comment_req() {
        this.uin = 0L;
        this.albumid = "";
        this.photoid = "";
        this.attach_info = "";
        this.refresh_type = 8;
        this.order = 0;
        this.commenttype = 0;
        this.topicid = "";
        this.extent_info = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, true);
        this.albumid = jceInputStream.readString(1, true);
        this.photoid = jceInputStream.readString(2, true);
        this.attach_info = jceInputStream.readString(3, true);
        this.refresh_type = jceInputStream.read(this.refresh_type, 4, false);
        this.order = jceInputStream.read(this.order, 5, false);
        this.commenttype = jceInputStream.read(this.commenttype, 6, false);
        this.topicid = jceInputStream.readString(7, false);
        this.extent_info = (Map) jceInputStream.read((JceInputStream) cache_extent_info, 8, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.albumid, 1);
        jceOutputStream.write(this.photoid, 2);
        jceOutputStream.write(this.attach_info, 3);
        jceOutputStream.write(this.refresh_type, 4);
        jceOutputStream.write(this.order, 5);
        jceOutputStream.write(this.commenttype, 6);
        String str = this.topicid;
        if (str != null) {
            jceOutputStream.write(str, 7);
        }
        Map<String, String> map = this.extent_info;
        if (map != null) {
            jceOutputStream.write((Map) map, 8);
        }
    }

    public get_photo_comment_req(long j3, String str, String str2, int i3, String str3) {
        this.attach_info = "";
        this.refresh_type = 8;
        this.order = 0;
        this.extent_info = null;
        this.uin = j3;
        this.albumid = str;
        this.photoid = str2;
        this.commenttype = i3;
        this.topicid = str3;
    }

    public get_photo_comment_req(long j3, String str, String str2, int i3, String str3, Map<String, String> map) {
        this.attach_info = "";
        this.refresh_type = 8;
        this.order = 0;
        this.uin = j3;
        this.albumid = str;
        this.photoid = str2;
        this.commenttype = i3;
        this.topicid = str3;
        this.extent_info = map;
    }
}
