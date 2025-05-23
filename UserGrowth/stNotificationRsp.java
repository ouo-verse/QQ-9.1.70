package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stNotificationRsp extends JceStruct {
    static stGlobalConfig cache_config;
    static Map<String, String> cache_map_ext;
    static ArrayList<stSimpleMetaPerson> cache_persons = new ArrayList<>();
    static int cache_type;
    static ArrayList<String> cache_vtFeedid;
    public int cid;
    public stGlobalConfig config;
    public String h5Url;
    public String imgurl;
    public String jump_url;
    public Map<String, String> map_ext;
    public ArrayList<stSimpleMetaPerson> persons;
    public String scheme_url;
    public String text;
    public String trace_id;
    public int type;
    public ArrayList<String> vtFeedid;

    static {
        cache_persons.add(new stSimpleMetaPerson());
        ArrayList<String> arrayList = new ArrayList<>();
        cache_vtFeedid = arrayList;
        arrayList.add("");
        cache_config = new stGlobalConfig();
        HashMap hashMap = new HashMap();
        cache_map_ext = hashMap;
        hashMap.put("", "");
    }

    public stNotificationRsp() {
        this.type = 0;
        this.imgurl = "";
        this.text = "";
        this.persons = null;
        this.jump_url = "";
        this.vtFeedid = null;
        this.config = null;
        this.h5Url = "";
        this.scheme_url = "";
        this.cid = 0;
        this.trace_id = "";
        this.map_ext = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.type = jceInputStream.read(this.type, 0, false);
        this.imgurl = jceInputStream.readString(1, false);
        this.text = jceInputStream.readString(2, false);
        this.persons = (ArrayList) jceInputStream.read((JceInputStream) cache_persons, 3, false);
        this.jump_url = jceInputStream.readString(4, false);
        this.vtFeedid = (ArrayList) jceInputStream.read((JceInputStream) cache_vtFeedid, 5, false);
        this.config = (stGlobalConfig) jceInputStream.read((JceStruct) cache_config, 6, false);
        this.h5Url = jceInputStream.readString(7, false);
        this.scheme_url = jceInputStream.readString(8, false);
        this.cid = jceInputStream.read(this.cid, 9, false);
        this.trace_id = jceInputStream.readString(10, false);
        this.map_ext = (Map) jceInputStream.read((JceInputStream) cache_map_ext, 11, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.type, 0);
        String str = this.imgurl;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.text;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        ArrayList<stSimpleMetaPerson> arrayList = this.persons;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 3);
        }
        String str3 = this.jump_url;
        if (str3 != null) {
            jceOutputStream.write(str3, 4);
        }
        ArrayList<String> arrayList2 = this.vtFeedid;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 5);
        }
        stGlobalConfig stglobalconfig = this.config;
        if (stglobalconfig != null) {
            jceOutputStream.write((JceStruct) stglobalconfig, 6);
        }
        String str4 = this.h5Url;
        if (str4 != null) {
            jceOutputStream.write(str4, 7);
        }
        String str5 = this.scheme_url;
        if (str5 != null) {
            jceOutputStream.write(str5, 8);
        }
        jceOutputStream.write(this.cid, 9);
        String str6 = this.trace_id;
        if (str6 != null) {
            jceOutputStream.write(str6, 10);
        }
        Map<String, String> map = this.map_ext;
        if (map != null) {
            jceOutputStream.write((Map) map, 11);
        }
    }

    public stNotificationRsp(int i3, String str, String str2, ArrayList<stSimpleMetaPerson> arrayList, String str3, ArrayList<String> arrayList2, stGlobalConfig stglobalconfig, String str4, String str5, int i16, String str6, Map<String, String> map) {
        this.type = i3;
        this.imgurl = str;
        this.text = str2;
        this.persons = arrayList;
        this.jump_url = str3;
        this.vtFeedid = arrayList2;
        this.config = stglobalconfig;
        this.h5Url = str4;
        this.scheme_url = str5;
        this.cid = i16;
        this.trace_id = str6;
        this.map_ext = map;
    }
}
