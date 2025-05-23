package TianShuJce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class AdItem extends JceStruct {
    static Map<String, String> cache_argList;
    static ArrayList<String> cache_lstPic;
    public Map<String, String> argList;
    public String desc;
    public String ext_info;
    public long iAdId;
    public String iconurl;
    public String jumpurl;
    public ArrayList<String> lstPic;
    public String title;
    public String traceinfo;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        cache_lstPic = arrayList;
        arrayList.add("");
        HashMap hashMap = new HashMap();
        cache_argList = hashMap;
        hashMap.put("", "");
    }

    public AdItem() {
        this.iAdId = 0L;
        this.traceinfo = "";
        this.title = "";
        this.desc = "";
        this.jumpurl = "";
        this.iconurl = "";
        this.lstPic = null;
        this.argList = null;
        this.ext_info = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iAdId = jceInputStream.read(this.iAdId, 1, false);
        this.traceinfo = jceInputStream.readString(5, false);
        this.title = jceInputStream.readString(10, false);
        this.desc = jceInputStream.readString(11, false);
        this.jumpurl = jceInputStream.readString(12, false);
        this.iconurl = jceInputStream.readString(13, false);
        this.lstPic = (ArrayList) jceInputStream.read((JceInputStream) cache_lstPic, 14, false);
        this.argList = (Map) jceInputStream.read((JceInputStream) cache_argList, 15, false);
        this.ext_info = jceInputStream.readString(20, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iAdId, 1);
        String str = this.traceinfo;
        if (str != null) {
            jceOutputStream.write(str, 5);
        }
        String str2 = this.title;
        if (str2 != null) {
            jceOutputStream.write(str2, 10);
        }
        String str3 = this.desc;
        if (str3 != null) {
            jceOutputStream.write(str3, 11);
        }
        String str4 = this.jumpurl;
        if (str4 != null) {
            jceOutputStream.write(str4, 12);
        }
        String str5 = this.iconurl;
        if (str5 != null) {
            jceOutputStream.write(str5, 13);
        }
        ArrayList<String> arrayList = this.lstPic;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 14);
        }
        Map<String, String> map = this.argList;
        if (map != null) {
            jceOutputStream.write((Map) map, 15);
        }
        String str6 = this.ext_info;
        if (str6 != null) {
            jceOutputStream.write(str6, 20);
        }
    }

    public AdItem(long j3, String str, String str2, String str3, String str4, String str5, ArrayList<String> arrayList, Map<String, String> map, String str6) {
        this.iAdId = j3;
        this.traceinfo = str;
        this.title = str2;
        this.desc = str3;
        this.jumpurl = str4;
        this.iconurl = str5;
        this.lstPic = arrayList;
        this.argList = map;
        this.ext_info = str6;
    }
}
