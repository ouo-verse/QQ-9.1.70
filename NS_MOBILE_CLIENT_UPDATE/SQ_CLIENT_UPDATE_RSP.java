package NS_MOBILE_CLIENT_UPDATE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class SQ_CLIENT_UPDATE_RSP extends JceStruct {
    static Map<String, String> cache_extra_info;
    static int cache_upType;
    static ArrayList<UPDATE_INFO> cache_vModule;
    static ArrayList<UPDATE_INFO> cache_vPlugin;
    public Map<String, String> extra_info;
    public String md5;
    public String upMsg;
    public int upType;
    public String upUrl;
    public ArrayList<UPDATE_INFO> vModule;
    public ArrayList<UPDATE_INFO> vPlugin;
    public String version;

    static {
        HashMap hashMap = new HashMap();
        cache_extra_info = hashMap;
        hashMap.put("", "");
        cache_vPlugin = new ArrayList<>();
        cache_vPlugin.add(new UPDATE_INFO());
        cache_vModule = new ArrayList<>();
        cache_vModule.add(new UPDATE_INFO());
    }

    public SQ_CLIENT_UPDATE_RSP() {
        this.version = "";
        this.upUrl = "";
        this.md5 = "";
        this.upMsg = "";
        this.upType = 0;
        this.extra_info = null;
        this.vPlugin = null;
        this.vModule = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.version = jceInputStream.readString(0, false);
        this.upUrl = jceInputStream.readString(1, false);
        this.md5 = jceInputStream.readString(2, false);
        this.upMsg = jceInputStream.readString(3, false);
        this.upType = jceInputStream.read(this.upType, 4, false);
        this.extra_info = (Map) jceInputStream.read((JceInputStream) cache_extra_info, 5, false);
        this.vPlugin = (ArrayList) jceInputStream.read((JceInputStream) cache_vPlugin, 6, false);
        this.vModule = (ArrayList) jceInputStream.read((JceInputStream) cache_vModule, 7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.version;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.upUrl;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.md5;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        String str4 = this.upMsg;
        if (str4 != null) {
            jceOutputStream.write(str4, 3);
        }
        jceOutputStream.write(this.upType, 4);
        Map<String, String> map = this.extra_info;
        if (map != null) {
            jceOutputStream.write((Map) map, 5);
        }
        ArrayList<UPDATE_INFO> arrayList = this.vPlugin;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 6);
        }
        ArrayList<UPDATE_INFO> arrayList2 = this.vModule;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 7);
        }
    }

    public SQ_CLIENT_UPDATE_RSP(String str, String str2, String str3, String str4, int i3, Map<String, String> map, ArrayList<UPDATE_INFO> arrayList, ArrayList<UPDATE_INFO> arrayList2) {
        this.version = str;
        this.upUrl = str2;
        this.md5 = str3;
        this.upMsg = str4;
        this.upType = i3;
        this.extra_info = map;
        this.vPlugin = arrayList;
        this.vModule = arrayList2;
    }
}
