package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_weishi extends JceStruct {
    static Map<String, String> cache_dc_report;
    public String cover_url;
    public Map<String, String> dc_report;
    public boolean need_show_related;
    public String nick_name;
    public String pull_weishi_alg_id;
    public int pull_weishi_mask;
    public String related_button_text;
    public String weishi_clipbrd;
    public String weishi_download_url;
    public String weishi_feedId;
    public String weishi_fileId;
    public String weishi_musicId;
    public String weishi_musicName;
    public String weishi_musicUrl;
    public String weishi_pull_schema;
    public String weishi_schema;
    public String weishi_topicID;
    public String weishi_topicName;
    public String weishi_topicUrl;

    static {
        HashMap hashMap = new HashMap();
        cache_dc_report = hashMap;
        hashMap.put("", "");
    }

    public s_weishi() {
        this.weishi_feedId = "";
        this.weishi_fileId = "";
        this.cover_url = "";
        this.nick_name = "";
        this.weishi_musicId = "";
        this.weishi_musicName = "";
        this.weishi_musicUrl = "";
        this.weishi_topicID = "";
        this.weishi_topicName = "";
        this.weishi_topicUrl = "";
        this.weishi_schema = "";
        this.dc_report = null;
        this.pull_weishi_mask = 0;
        this.weishi_download_url = "";
        this.weishi_pull_schema = "";
        this.weishi_clipbrd = "";
        this.pull_weishi_alg_id = "";
        this.need_show_related = false;
        this.related_button_text = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.weishi_feedId = jceInputStream.readString(0, false);
        this.weishi_fileId = jceInputStream.readString(1, false);
        this.cover_url = jceInputStream.readString(2, false);
        this.nick_name = jceInputStream.readString(3, false);
        this.weishi_musicId = jceInputStream.readString(4, false);
        this.weishi_musicName = jceInputStream.readString(5, false);
        this.weishi_musicUrl = jceInputStream.readString(6, false);
        this.weishi_topicID = jceInputStream.readString(7, false);
        this.weishi_topicName = jceInputStream.readString(8, false);
        this.weishi_topicUrl = jceInputStream.readString(9, false);
        this.weishi_schema = jceInputStream.readString(10, false);
        this.dc_report = (Map) jceInputStream.read((JceInputStream) cache_dc_report, 11, false);
        this.pull_weishi_mask = jceInputStream.read(this.pull_weishi_mask, 12, false);
        this.weishi_download_url = jceInputStream.readString(13, false);
        this.weishi_pull_schema = jceInputStream.readString(14, false);
        this.weishi_clipbrd = jceInputStream.readString(15, false);
        this.pull_weishi_alg_id = jceInputStream.readString(16, false);
        this.need_show_related = jceInputStream.read(this.need_show_related, 17, false);
        this.related_button_text = jceInputStream.readString(18, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.weishi_feedId;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.weishi_fileId;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.cover_url;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        String str4 = this.nick_name;
        if (str4 != null) {
            jceOutputStream.write(str4, 3);
        }
        String str5 = this.weishi_musicId;
        if (str5 != null) {
            jceOutputStream.write(str5, 4);
        }
        String str6 = this.weishi_musicName;
        if (str6 != null) {
            jceOutputStream.write(str6, 5);
        }
        String str7 = this.weishi_musicUrl;
        if (str7 != null) {
            jceOutputStream.write(str7, 6);
        }
        String str8 = this.weishi_topicID;
        if (str8 != null) {
            jceOutputStream.write(str8, 7);
        }
        String str9 = this.weishi_topicName;
        if (str9 != null) {
            jceOutputStream.write(str9, 8);
        }
        String str10 = this.weishi_topicUrl;
        if (str10 != null) {
            jceOutputStream.write(str10, 9);
        }
        String str11 = this.weishi_schema;
        if (str11 != null) {
            jceOutputStream.write(str11, 10);
        }
        Map<String, String> map = this.dc_report;
        if (map != null) {
            jceOutputStream.write((Map) map, 11);
        }
        jceOutputStream.write(this.pull_weishi_mask, 12);
        String str12 = this.weishi_download_url;
        if (str12 != null) {
            jceOutputStream.write(str12, 13);
        }
        String str13 = this.weishi_pull_schema;
        if (str13 != null) {
            jceOutputStream.write(str13, 14);
        }
        String str14 = this.weishi_clipbrd;
        if (str14 != null) {
            jceOutputStream.write(str14, 15);
        }
        String str15 = this.pull_weishi_alg_id;
        if (str15 != null) {
            jceOutputStream.write(str15, 16);
        }
        jceOutputStream.write(this.need_show_related, 17);
        String str16 = this.related_button_text;
        if (str16 != null) {
            jceOutputStream.write(str16, 18);
        }
    }

    public s_weishi(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Map<String, String> map, int i3, String str12, String str13, String str14, String str15, boolean z16, String str16) {
        this.weishi_feedId = str;
        this.weishi_fileId = str2;
        this.cover_url = str3;
        this.nick_name = str4;
        this.weishi_musicId = str5;
        this.weishi_musicName = str6;
        this.weishi_musicUrl = str7;
        this.weishi_topicID = str8;
        this.weishi_topicName = str9;
        this.weishi_topicUrl = str10;
        this.weishi_schema = str11;
        this.dc_report = map;
        this.pull_weishi_mask = i3;
        this.weishi_download_url = str12;
        this.weishi_pull_schema = str13;
        this.weishi_clipbrd = str14;
        this.pull_weishi_alg_id = str15;
        this.need_show_related = z16;
        this.related_button_text = str16;
    }
}
