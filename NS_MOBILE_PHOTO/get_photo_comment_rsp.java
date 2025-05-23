package NS_MOBILE_PHOTO;

import NS_MOBILE_FEEDS.cell_comment;
import NS_MOBILE_FEEDS.cell_like;
import NS_MOBILE_FEEDS.cell_visitor;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class get_photo_comment_rsp extends JceStruct {
    static Map<String, String> cache_extend_info;
    public String albumid;
    public String attach_info;
    public cell_comment comment;
    public Map<String, String> extend_info;
    public boolean hasmore;
    public cell_like like;
    public String photoid;
    public String topicid;
    public long uin;
    public cell_visitor visitor;
    static cell_comment cache_comment = new cell_comment();
    static cell_like cache_like = new cell_like();
    static cell_visitor cache_visitor = new cell_visitor();

    static {
        HashMap hashMap = new HashMap();
        cache_extend_info = hashMap;
        hashMap.put("", "");
    }

    public get_photo_comment_rsp() {
        this.hasmore = true;
        this.attach_info = "";
        this.uin = 0L;
        this.albumid = "";
        this.photoid = "";
        this.topicid = "";
        this.extend_info = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.hasmore = jceInputStream.read(this.hasmore, 0, true);
        this.attach_info = jceInputStream.readString(1, true);
        this.comment = (cell_comment) jceInputStream.read((JceStruct) cache_comment, 2, true);
        this.like = (cell_like) jceInputStream.read((JceStruct) cache_like, 3, false);
        this.visitor = (cell_visitor) jceInputStream.read((JceStruct) cache_visitor, 4, false);
        this.uin = jceInputStream.read(this.uin, 5, false);
        this.albumid = jceInputStream.readString(6, false);
        this.photoid = jceInputStream.readString(7, false);
        this.topicid = jceInputStream.readString(8, false);
        this.extend_info = (Map) jceInputStream.read((JceInputStream) cache_extend_info, 9, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.hasmore, 0);
        jceOutputStream.write(this.attach_info, 1);
        jceOutputStream.write((JceStruct) this.comment, 2);
        cell_like cell_likeVar = this.like;
        if (cell_likeVar != null) {
            jceOutputStream.write((JceStruct) cell_likeVar, 3);
        }
        cell_visitor cell_visitorVar = this.visitor;
        if (cell_visitorVar != null) {
            jceOutputStream.write((JceStruct) cell_visitorVar, 4);
        }
        jceOutputStream.write(this.uin, 5);
        String str = this.albumid;
        if (str != null) {
            jceOutputStream.write(str, 6);
        }
        String str2 = this.photoid;
        if (str2 != null) {
            jceOutputStream.write(str2, 7);
        }
        String str3 = this.topicid;
        if (str3 != null) {
            jceOutputStream.write(str3, 8);
        }
        Map<String, String> map = this.extend_info;
        if (map != null) {
            jceOutputStream.write((Map) map, 9);
        }
    }

    public get_photo_comment_rsp(boolean z16, String str, cell_comment cell_commentVar, cell_like cell_likeVar, cell_visitor cell_visitorVar, long j3, String str2, String str3, String str4, Map<String, String> map) {
        this.hasmore = z16;
        this.attach_info = str;
        this.comment = cell_commentVar;
        this.like = cell_likeVar;
        this.visitor = cell_visitorVar;
        this.uin = j3;
        this.albumid = str2;
        this.photoid = str3;
        this.topicid = str4;
        this.extend_info = map;
    }
}
