package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cell_forward_list extends JceStruct {
    static Map<String, String> cache_extendinfo;
    static ArrayList<s_user> cache_fwdmans = new ArrayList<>();
    public String actionUrl;
    public Map<String, String> extendinfo;
    public String forwardkey;
    public ArrayList<s_user> fwdmans;
    public int isforward;
    public int num;
    public String txt;

    static {
        cache_fwdmans.add(new s_user());
        HashMap hashMap = new HashMap();
        cache_extendinfo = hashMap;
        hashMap.put("", "");
    }

    public cell_forward_list() {
        this.num = 0;
        this.isforward = 0;
        this.fwdmans = null;
        this.actionUrl = "";
        this.extendinfo = null;
        this.forwardkey = "";
        this.txt = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.num = jceInputStream.read(this.num, 0, false);
        this.isforward = jceInputStream.read(this.isforward, 1, false);
        this.fwdmans = (ArrayList) jceInputStream.read((JceInputStream) cache_fwdmans, 2, false);
        this.actionUrl = jceInputStream.readString(3, false);
        this.extendinfo = (Map) jceInputStream.read((JceInputStream) cache_extendinfo, 4, false);
        this.forwardkey = jceInputStream.readString(5, false);
        this.txt = jceInputStream.readString(6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.num, 0);
        jceOutputStream.write(this.isforward, 1);
        ArrayList<s_user> arrayList = this.fwdmans;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
        String str = this.actionUrl;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        Map<String, String> map = this.extendinfo;
        if (map != null) {
            jceOutputStream.write((Map) map, 4);
        }
        String str2 = this.forwardkey;
        if (str2 != null) {
            jceOutputStream.write(str2, 5);
        }
        String str3 = this.txt;
        if (str3 != null) {
            jceOutputStream.write(str3, 6);
        }
    }

    public cell_forward_list(int i3, int i16, ArrayList<s_user> arrayList, String str, Map<String, String> map, String str2, String str3) {
        this.num = i3;
        this.isforward = i16;
        this.fwdmans = arrayList;
        this.actionUrl = str;
        this.extendinfo = map;
        this.forwardkey = str2;
        this.txt = str3;
    }
}
