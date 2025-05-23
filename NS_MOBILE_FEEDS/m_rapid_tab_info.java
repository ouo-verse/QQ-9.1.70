package NS_MOBILE_FEEDS;

import NS_MOBILE_COMM.msgb_rapidemotion;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class m_rapid_tab_info extends JceStruct {
    static Map<String, String> cache_extend_info;
    static ArrayList<msgb_rapidemotion> cache_rapid_emotions = new ArrayList<>();
    public Map<String, String> extend_info;
    public ArrayList<msgb_rapidemotion> rapid_emotions;
    public long tab_id;
    public String zip_md5_value;
    public String zip_url;

    static {
        cache_rapid_emotions.add(new msgb_rapidemotion());
        HashMap hashMap = new HashMap();
        cache_extend_info = hashMap;
        hashMap.put("", "");
    }

    public m_rapid_tab_info() {
        this.zip_url = "";
        this.zip_md5_value = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.tab_id = jceInputStream.read(this.tab_id, 0, false);
        this.rapid_emotions = (ArrayList) jceInputStream.read((JceInputStream) cache_rapid_emotions, 1, false);
        this.zip_url = jceInputStream.readString(2, false);
        this.zip_md5_value = jceInputStream.readString(3, false);
        this.extend_info = (Map) jceInputStream.read((JceInputStream) cache_extend_info, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.tab_id, 0);
        ArrayList<msgb_rapidemotion> arrayList = this.rapid_emotions;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        String str = this.zip_url;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        String str2 = this.zip_md5_value;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        Map<String, String> map = this.extend_info;
        if (map != null) {
            jceOutputStream.write((Map) map, 4);
        }
    }

    public m_rapid_tab_info(long j3, ArrayList<msgb_rapidemotion> arrayList, String str, String str2, Map<String, String> map) {
        this.tab_id = j3;
        this.rapid_emotions = arrayList;
        this.zip_url = str;
        this.zip_md5_value = str2;
        this.extend_info = map;
    }
}
